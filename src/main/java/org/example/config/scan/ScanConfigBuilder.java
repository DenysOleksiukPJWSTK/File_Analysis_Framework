package org.example.config.scan;

import java.nio.file.Path;
import java.util.Set;

/**
 * Fluent builder for creating immutable {@link ScanConfig} instances.
 * <p>
 * This class provides a mutable staging area to set scanning parameters
 * before producing a thread-safe, validated result via the {@link #build()} method.
 * </p>
 *
 * @author Denys Oleksiuk
 * @version 1.1.0 (2026-01-10)
 */
public class ScanConfigBuilder {
    private Path rootDirectory;
    private boolean followSymlinks;
    private int maxDepth;
    private Set<String> allowedExtensions;
    private long maxFileSizeBytes;

    /**
     * Sets the entry point for the file system scan.
     * @param rootDirectory The starting directory {@link Path}.
     * @return Current builder instance for method chaining.
     */
    public ScanConfigBuilder withRootDir(Path rootDirectory) {
        this.rootDirectory = rootDirectory;
        return this;
    }

    /**
     * Sets whether the scanner should follow symbolic links.
     * @param followSymlinks boolean flag.
     * @return Current builder instance for method chaining.
     */
    public ScanConfigBuilder withFollowSymlinks(boolean followSymlinks) {
        this.followSymlinks = followSymlinks;
        return this;
    }

    /**
     * Sets the maximum traversal depth for the scan.
     * @param maxDepth Integer depth (-1 for unlimited, >= 0 for specific depth).
     * @return Current builder instance for method chaining.
     */
    public ScanConfigBuilder withMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
        return this;
    }

    /**
     * Sets the set of file extensions to include in the scan.
     * @param allowedExtensions A set of strings (e.g., "txt", "java").
     * @return Current builder instance for method chaining.
     */
    public ScanConfigBuilder withAllowedExtensions(Set<String> allowedExtensions) {
        this.allowedExtensions = allowedExtensions;
        return this;
    }

    /**
     * Sets the upper limit for individual file sizes.
     * @param maxFileSizeBytes Size limit in bytes.
     * @return Current builder instance for method chaining.
     */
    public ScanConfigBuilder withMaxFileSizeBytes(long maxFileSizeBytes) {
        this.maxFileSizeBytes = maxFileSizeBytes;
        return this;
    }

    /**
     * Constructs a final, immutable ScanConfig.
     *
     * @return A validated {@link ScanConfig} object.
     * @throws IllegalArgumentException if parameters fail validation in the ScanConfig constructor.
     */
    public ScanConfig build() throws IllegalArgumentException {
        return new ScanConfig(rootDirectory, followSymlinks, maxDepth, allowedExtensions, maxFileSizeBytes);
    }



}
