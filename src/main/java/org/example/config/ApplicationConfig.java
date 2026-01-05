package org.example.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Immutable configuration holder for the primary Application settings.
 * <p>
 * This class ensures that core application metadata, such as naming conventions
 * and semantic versioning, are strictly validated before the system initializes.
 * </p>
 *
 * @author Denys Oleksiuk
 * @version 1.0.0 (2026-01-05)
 */
public final class ApplicationConfig {
    /** The official identifier of the application. */
    private final String name;

    /** The semantic version string (format: x.y.z). */
    private final String version;

    /** The operational environment mode (e.g., DEV, PROD). */
    private final ApplicationMode mode;

    /** Flag indicating if the application should accept user console input. */
    private final boolean interactive;

    /**
     * Validates the integrity of the application configuration parameters.
     *
     * @param name        The application name.
     * @param version     The version string.
     * @param mode        The execution mode.
     * @param interactive Interactive flag.
     * @throws IllegalArgumentException if any parameter violates validation rules.
     */
    private void validate(String name, String version, ApplicationMode mode, boolean interactive) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty!");
        if (version == null || version.isEmpty()) throw new IllegalArgumentException("Version cannot be null or empty!");

        // Semantic Versioning Validation (e.g., 1.0.2)
        Pattern pattern = Pattern.compile("^\\d+\\.\\d+\\.\\d+$");
        Matcher matcher = pattern.matcher(version);
        if (!matcher.matches()) throw new IllegalArgumentException("Invalid format version!");
        if (mode == null) throw new IllegalArgumentException("Mode cannot be null!");
    }

    /**
     * Constructs a new validated and immutable ApplicationConfig.
     *
     * @param name        Application name.
     * @param version     Semantic version.
     * @param mode        Application execution mode.
     * @param interactive Interactive mode status.
     */
    public ApplicationConfig(String name, String version, ApplicationMode mode, boolean interactive) {
        validate(name, version, mode, interactive);
        this.name = name;
        this.version = version;
        this.mode = mode;
        this.interactive = interactive;
    }

    /** @return The application name. */
    public String getName() {
        return name;
    }

    /** @return The semantic version string. */
    public String getVersion() {
        return version;
    }

    /** @return The current {@link ApplicationMode}. */
    public ApplicationMode getMode() {
        return mode;
    }

    /** @return true if the application is running in interactive mode. */
    public boolean isInteractive() {
        return interactive;
    }

}
