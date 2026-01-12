package org.example.config.application.ConfigKeys;

/**
 * Registry of property keys for core application metadata.
 *
 * @author Denys Oleksiuk
 * @version 1.0.0 (2026-01-10)
 */
public enum Key {

    /** The official name of the application. */
    NAME("app.name"),

    /** The semantic version of the application. */
    VERSION("app.version"),

    /** The operational mode (e.g., DEV, PROD). */
    MODE("app.mode"),

    /** Flag determining if the UI is interactive. */
    INTERACTIVE("app.interactive");

    /** The literal key string used in property files. */
    final String key;

    Key(String key){
        this.key = key;
    }

}
