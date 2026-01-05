package org.example.config;

import java.nio.charset.Charset;
import java.nio.file.Path;

public final class ReportConfig {
    private final Path outputPath;
    private final boolean appendMode;
    private final ReportFormat reportFormat;
    private final long bufferSize;
    private final Charset charset;
    private final boolean includeHeaders;
    private final int flushInterval;
    private final int maxRows;


}
