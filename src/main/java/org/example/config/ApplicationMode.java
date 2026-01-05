package org.example.config;
/**
 * Defines the operational environment of the application.
 *
 * @author Denys Oleksiuk
 * @version 1.0.0 (2026-01-05)
 */
public enum ApplicationMode {
    /**
     * Development mode.
     * Enables detailed logging, debugging tools, and relaxed security constraints.
     */
    DEV,

    /**
     * Production mode.
     * Optimized for performance, strict security, and minimal diagnostic output.
     */
    PROD,
}
