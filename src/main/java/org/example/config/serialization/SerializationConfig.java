package org.example.config.serialization;

import java.nio.file.Path;
/**
 * Immutable configuration for system state serialization and snapshot management.
 * <p>
 * This class enforces strict validation for persistence intervals and file path integrity
 * to ensure reliable background data saving.
 * </p>
 *
 * @author Denys Oleksiuk
 * @version 1.0.0 (2026-01-10)
 */
public final class SerializationConfig {
    private final boolean enabled;
    private final Path filePath;
    private final int saveInterval;
    private final int maxSnapshots;

    /**
     * Internal validation logic for serialization parameters.
     *
     * @throws IllegalArgumentException if numeric constraints or path requirements are violated.
     */
    private void validate(Path filePath, int saveInterval, int maxSnapshots) {
        if (saveInterval <= 0 || maxSnapshots <= 0) throw  new IllegalArgumentException("Save interval and max snapshots must be positive");
        if (filePath == null) throw  new IllegalArgumentException("File path cannot be null");
        if (filePath.toString().isEmpty()) throw new IllegalArgumentException("File path cannot be empty");
    }

    /**
     * Constructs a validated SerializationConfig instance.
     *
     * @param enabled      Toggle for the serialization service.
     * @param filePath     Target {@link Path} for the serialized data file.
     * @param saveInterval Frequency of saves (e.g., in seconds or operations). Must be > 0.
     * @param maxSnapshots Retention limit for historical data snapshots. Must be > 0.
     */
    public SerializationConfig(final boolean enabled, final Path filePath, final int saveInterval, final int maxSnapshots) {
        validate(filePath, saveInterval, maxSnapshots);
        this.enabled = enabled;
        this.filePath = filePath;
        this.saveInterval = saveInterval;
        this.maxSnapshots = maxSnapshots;
    }

    /** @return true if the serialization service is active. */
    public  boolean isEnabled() {
        return enabled;
    }

    /** @return The designated {@link Path} for state persistence. */
    public Path getFilePath() {
        return filePath;
    }

    /** @return The interval between automated save operations. */
    public int getSaveInterval() {
        return saveInterval;
    }

    /** @return The maximum number of snapshots to retain in storage. */
    public int getMaxSnapshots() {
        return maxSnapshots;
    }
}
