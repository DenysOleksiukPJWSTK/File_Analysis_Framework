package org.example.config.serialization;

import java.nio.file.Path;

/**
 * Fluent builder for creating immutable {@link SerializationConfig} instances.
 * <p>
 * This class decoupling the data gathering phase from the strict validation
 * phase performed during the {@link #build()} call.
 * </p>
 *
 * @author Denys Oleksiuk
 * @version 1.0.0 (2026-01-10)
 */
public class SerializationConfigBuilder {
    private boolean enabled;
    private Path filePath;
    private int saveInterval;
    private int maxSnapshots;

    /**
     * Enables or disables the serialization service.
     * @param enabled boolean flag.
     * @return Current builder instance.
     */
    public SerializationConfigBuilder withEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Sets the destination path for serialized data.
     * @param filePath Target {@link Path}.
     * @return Current builder instance.
     */
    public SerializationConfigBuilder withFilePath(Path filePath) {
        this.filePath = filePath;
        return this;
    }

    /**
     * Sets the frequency of automated save operations.
     * @param saveInterval Numerical interval (e.g., in seconds).
     * @return Current builder instance.
     */
    public SerializationConfigBuilder withSaveInterval(int saveInterval) {
        this.saveInterval = saveInterval;
        return this;
    }

    /**
     * Sets the maximum number of historical snapshots to retain.
     * @param maxSnapshots Retention limit.
     * @return Current builder instance.
     */
    public SerializationConfigBuilder withMaxSnapshots(int maxSnapshots) {
        this.maxSnapshots = maxSnapshots;
        return this;
    }

    /**
     * Constructs a final, immutable SerializationConfig.
     *
     * @return A validated {@link SerializationConfig} object.
     * @throws IllegalArgumentException if the parameters fail validation
     *                                  (e.g., negative intervals or null paths).
     */
    public SerializationConfig build() throws IllegalStateException {
        return new SerializationConfig(enabled, filePath, maxSnapshots, saveInterval);
    }

}
