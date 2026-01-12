package org.example.config.analysis.ConfigKeys;

/**
 * Registry of property keys for analysis-specific external configuration.
 * Used by ConfigLoaders to retrieve and validate environment settings.
 *
 * @author Denys Oleksiuk
 * @version 1.0.0 (2026-01-10)
 */
public enum Key {
    /** Toggle for enabling file size distribution analysis. */
    SIZE_ANALYSIS("analysis.enable.size.analysis"),

    /** Toggle for enabling file extension analysis. */
    EXTENSION_ANALYSIS("analysis.enable.extensions.analysis"),

    /** The preferred sorting order for results (e.g., ASC/DESC). */
    SORT_ORDER("analysis.sort.order"),

    /** The identifier for the file filtering strategy. */
    STRATEGY("analysis.strategy"),

    /** The targeted output format for reports (e.g., TXT/CSV). */
    REPORT_FORMAT("analysis.report.format"),

    /** I/O buffer size in bytes for reading operations. */
    BUFFER_SIZE("analysis.buffer.size"),

    /** Character encoding for file processing. */
    CHARSET("analysis.charset"),

    /** Maximum number of records to include in the output. */
    RESULT_LIMIT("analysis.result.limit");

    /** The literal string key used in .properties or .yaml files. */
    final String key;

    Key(String key){
        this.key = key;
    }

}
