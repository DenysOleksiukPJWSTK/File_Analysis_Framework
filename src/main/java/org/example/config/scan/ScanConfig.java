package org.example.config.scan;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Immutable configuration for file scanning operations.
 * Enforces strict validation for directory access, depth limits, and file constraints.
 *
 * @author Denys Oleksiuk
 * @version 1.1.0 (2026-01-05)
 */
public final class ScanConfig {
    private final Path rootDirectory;
    private final boolean followSymlinks;
    private final int maxDepth;
    private final Set<String> allowedExtensions;
    private final long maxFileSizeBytes;

    /**
     * Constructs a validated ScanConfig instance.
     *
     * @param rootDirectory     The starting point for the scan (must exist and be readable).
     * @param followSymlinks    Flag to enable/disable symbolic link traversal.
     * @param maxDepth          Traversal depth (-1 for unlimited, >= 0 for specific levels).
     * @param allowedExtensions Set of file extensions without the leading dot.
     * @param maxFileSizeBytes  Maximum size of files allowed for processing (0 to 10GB).
     * @throws IllegalArgumentException if any parameter violates validation rules.
     */
    public ScanConfig(Path rootDirectory, boolean followSymlinks, int maxDepth, Set<String> allowedExtensions, long maxFileSizeBytes) {
        validate(rootDirectory,maxDepth,maxFileSizeBytes);
        allowedExtensions = validateAllowedExtensions(allowedExtensions);
        this.rootDirectory = rootDirectory;
        this.followSymlinks = followSymlinks;
        this.maxDepth = maxDepth;
        this.maxFileSizeBytes = maxFileSizeBytes;
        this.allowedExtensions = allowedExtensions;
    }

    /**
     * Validates directory integrity and numerical constraints.
     */
    private void validate(Path rootDirectory,int maxDepth,long maxFileSizeBytes) {
        if (rootDirectory == null) throw new IllegalArgumentException("Root directory is null!");

        if (Files.notExists(rootDirectory)) throw new IllegalArgumentException("Root directory doesn't exists! --> "
                + rootDirectory.toAbsolutePath().toString());

        if (!Files.isDirectory(rootDirectory)) throw new IllegalArgumentException("Root directory is not a directory! --> "
                + rootDirectory.toAbsolutePath().toString());

        if (!Files.isReadable(rootDirectory)) throw new IllegalArgumentException("Root directory is not readable! --> "
                + rootDirectory.toAbsolutePath().toString());

        if (maxDepth < -1) throw new IllegalArgumentException("Max depth must be >= 0 or equal to -1 (no depth limit)");
        if (maxFileSizeBytes < 0) throw new IllegalArgumentException("Max file size cannot be lower than 0!");
        if (maxFileSizeBytes > 10737418240L) throw new IllegalArgumentException("Max file size cannot be greater than 10GB!");

    }
    /**
     * Normalizes extensions to lowercase and ensures they do not start with a dot.
     * @return An unmodifiable set of normalized extensions.
     */
    private Set<String> validateAllowedExtensions(Set<String> allowedExtensions) {
        if (allowedExtensions == null) {throw new IllegalArgumentException("Allowed extensions must not be null");}
        if (allowedExtensions.isEmpty()) {throw new IllegalArgumentException("Allowed extensions must not be empty");}

        Set<String> normalized = new HashSet<>();
        for (String ext : allowedExtensions) {

            if (ext == null) {throw new IllegalArgumentException("Extension must not be null");}

            if (ext.isBlank()) {throw new IllegalArgumentException("Extension must not be blank");}
            if (ext.startsWith(".")) {
                throw new IllegalArgumentException("Extension must not start with '.': " + ext);}
            normalized.add(ext.toLowerCase());
        }
        return Collections.unmodifiableSet(normalized);
    }

    public Path getRootDirectory() {
        return rootDirectory;
    }

    public boolean isFollowSymlinks() {
        return followSymlinks;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public Set<String> getAllowedExtensions() {
        return Collections.unmodifiableSet(allowedExtensions);
    }

    public long getMaxFileSizeBytes() {
        return maxFileSizeBytes;
    }
}
