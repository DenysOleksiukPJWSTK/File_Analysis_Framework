package org.example.config.scan.ConfigKeys;
/**
 * Registry of property keys for external scan configuration.
 * Maps application logic constants to external configuration file keys.
 *
 * @author Denys Oleksiuk
 * @version 1.0.0 (2026-01-10)
 */
public enum Key {
    /** The starting directory path for the file system scan. */
    ROOT_DIR("scan.root.dir"),

    /** Flag to determine if symbolic links should be traversed. */
    FOLLOW_SYMLINKS("scan.follow.symlinks"),

    /** The maximum depth of the directory tree to traverse. */
    MAX_DEPTH("scan.max.depth"),

    /** Comma-separated list of permitted file extensions. */
    ALLOWED_EXTENSIONS("scan.allowed.extensions"),

    /** Maximum individual file size permitted for scanning (in bytes). */
    MAX_FILE_SIZE_BYTES("scan.max.file.size.bytes");

    /** The literal string key used in property files. */
    final String key;

    Key(String key){
        this.key = key;
    }

}
