package org.example.config.report.ConfigKeys;
/**
 * Registry of property keys for report-specific external configuration.
 * Used to define output paths, formatting, and I/O optimization settings.
 *
 * @author Denys Oleksiuk
 * @version 1.0.0 (2026-01-10)
 */
public enum Key {

    /** Target file system path for the generated report. */
    OUTPUT_PATH("report.output.path"),

    /** Toggle between appending to an existing file or overwriting. */
    APPEND_MODE("report.append.mode"),

    /** The serialization format (e.g., TXT, CSV). */
    FORMAT("report.format"),

    /** Memory buffer size in bytes for write operations. */
    BUFFER_SIZE("report.buffer.size"),

    /** Character encoding for the report content. */
    CHARSET("report.charset"),

    /** Flag to include column headers or metadata at the start of the file. */
    INCLUDE_HEADERS("report.include.headers"),

    /** Frequency of automatic flushes to disk. */
    FLUSH_INTERVALS("report.flush.interval"),

    /** Maximum number of records permitted per report file. */
    MAX_ROWS("report.max.rows");

    /** The literal string key used in property files. */
    final String key;

    Key(String key){
        this.key = key;
    }

}
