package org.example.config;

/**
 * Specifies the output file formats available for generated reports.
 *
 * @author Denys Oleksiuk
 * @version 1.0.0 (2026-01-05)
 */
public enum ReportFormat {
    /**
     * Plain Text format.
     * Optimized for human readability and simple console output.
     */
    TXT,

    /**
     * Comma-Separated Values format.
     * Optimized for data portability and import into spreadsheet software.
     */
    CSV
}
