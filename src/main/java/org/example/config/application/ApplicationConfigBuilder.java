package org.example.config.application;

/**
 * Fluent builder for creating immutable {@link ApplicationConfig} instances.
 * <p>
 * This class decouples the construction logic from the final representation,
 * ensuring that complex validation rules defined in the target class are
 * enforced at the moment of the {@link #build()} call.
 * </p>
 *
 * @author Denys Oleksiuk
 * @version 1.0.0 (2026-01-10)
 */
public class ApplicationConfigBuilder {
    private String name;
    private String version;
    private ApplicationMode mode;
    private boolean interactive;

    /**
     * Sets the official name of the application.
     * @param name Application identifier.
     * @return Current builder instance.
     */
    public ApplicationConfigBuilder withName(String name){
        this.name = name;
        return this;
    }

    /**
     * Sets the semantic version of the application.
     * @param version String in x.y.z format.
     * @return Current builder instance.
     */
    public ApplicationConfigBuilder withVersion(String version){
        this.version = version;
        return this;
    }

    /**
     * Sets the operational environment (DEV, PROD).
     * @param mode The {@link ApplicationMode} constant.
     * @return Current builder instance.
     */
    public ApplicationConfigBuilder withMode(ApplicationMode mode){
        this.mode = mode;
        return this;
    }

    /**
     * Sets whether the application should support console interactivity.
     * @param interactive boolean flag.
     * @return Current builder instance.
     */
    public ApplicationConfigBuilder withInteractive(boolean interactive){
        this.interactive = interactive;
        return this;
    }

    /**
     * Constructs a final, immutable ApplicationConfig.
     *
     * @return A validated {@link ApplicationConfig} object.
     * @throws IllegalArgumentException if the provided name, version, or mode
     *                                  fail the validation rules.
     */
    public ApplicationConfig build() throws IllegalArgumentException{
        return new ApplicationConfig(name,version,mode,interactive);
    }
}
