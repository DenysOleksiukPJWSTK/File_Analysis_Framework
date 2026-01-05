package org.example.analysis;
/**
 * Functional contract for defining file filtering logic.
 * <p>
 * This interface is marked with {@link FunctionalInterface} to support
 * Lambda expressions and Method References in the scanning pipeline.
 * </p>
 *
 * @author Denys Oleksiuk
 * @version 1.0.0 (2026-01-05)
 */
@FunctionalInterface
public interface FileFilterStrategy {
    // Current specification requires the addition of a functional method
    // e.g., boolean test(java.nio.file.Path path)
}
