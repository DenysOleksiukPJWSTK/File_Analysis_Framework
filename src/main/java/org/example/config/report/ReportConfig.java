package org.example.config.report;

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

    public ReportConfig(
        Path outputPath,
        boolean appendMode,
        ReportFormat reportFormat,
        long bufferSize,
        Charset charset,
        boolean includeHeaders,
        int flushInterval,
        int maxRows
    ){
        validate(outputPath,reportFormat,bufferSize,charset,flushInterval,maxRows);
        this.outputPath = outputPath;
        this.appendMode = appendMode;
        this.reportFormat = reportFormat;
        this.bufferSize = bufferSize;
        this.charset = charset;
        this.includeHeaders = includeHeaders;
        this.flushInterval = flushInterval;
        this.maxRows = maxRows;
    }

    private void validate(Path outputPath, ReportFormat reportFormat, long bufferSize, Charset charset, int flushInterval, int maxRows) {
        if (outputPath == null) throw new IllegalArgumentException("Output path cannot be null!");
        if (reportFormat == null) throw new IllegalArgumentException("Report format cannot be null!");
        if (outputPath.toString().isEmpty()) throw new IllegalArgumentException("Output path cannot be empty!");
        if (bufferSize <= 0) throw new IllegalArgumentException("Buffer size must be positive!");
        if (charset == null) throw new IllegalArgumentException("Charset cannot be null!");
        if (flushInterval <= 0) throw new IllegalArgumentException("Flush interval must be positive!");
        if (maxRows <= 0) throw new IllegalArgumentException("Max rows must be positive!");
    }

    public Path getOutputPath() {
        return outputPath;
    }
    public boolean isAppendMode() {
        return appendMode;
    }
    public ReportFormat getReportFormat() {
        return reportFormat;
    }
    public long getBufferSize() {
        return bufferSize;
    }
    public Charset getCharset() {
        return charset;
    }
    public boolean isIncludeHeaders() {
        return includeHeaders;
    }
    public int getFlushInterval() {
        return flushInterval;
    }
    public int getMaxRows() {
        return maxRows;
    }
}
