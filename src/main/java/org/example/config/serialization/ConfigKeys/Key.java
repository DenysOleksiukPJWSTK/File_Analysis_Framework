package org.example.config.serialization.ConfigKeys;

/**
 * Registry of property keys for state serialization and persistence configuration.
 *
 * @author Denys Oleksiuk
 * @version 1.0.0 (2026-01-10)
 */
public enum Key {
    /** Toggle for the automated state serialization service. */
    ENABLED("state.enabled"),

    /** The target file system path for persisting the binary state. */
    FILE_PATH("state.file.path"),

    /** The frequency of automated state saves (in seconds or operations). */
    AUTOSAVE_INTERVAL("state.autosave.interval"),

    /** The maximum number of historical snapshots to retain in storage. */
    MAX_SNAPSHOTS("state.max.snapshots");

    /** The literal string key used in property files. */
    final String key;

    Key(String key){
        this.key = key;
    }

}
