package org.example.config.report;

import java.nio.charset.Charset;
import java.nio.file.Path;
/**
 * Fluent builder for creating immutable {@link ReportConfig} instances.
 * <p>
 * Provides a mutable interface to configure report parameters before producing
 * a thread-safe result via the {@link #build()} method.
 * </p>
 *
 * @author Denys Oleksiuk
 * @version 1.0.0 (2026-01-10)
 */
public class ReportConfigBuilder {
    private Path outputPath;
    private boolean appendMode;
    private ReportFormat reportFormat;
    private long bufferSize;
    private Charset charset;
    private boolean includeHeaders;
    private int flushInterval;
    private int maxRows;

    /** Sets the target file system path for the report. */
    public ReportConfigBuilder withOutputPath(Path outputPath){
        this.outputPath = outputPath;
        return this;
    }

    /** Sets whether to append to an existing file or overwrite it. */
    public ReportConfigBuilder withAppendMode(boolean appendMode){
        this.appendMode = appendMode;
        return this;
    }

    /** Sets the serialization format (e.g., TXT, CSV). */
    public ReportConfigBuilder withReportFormat(ReportFormat reportFormat){
        this.reportFormat = reportFormat;
        return this;
    }

    /** Sets the I/O buffer size in bytes. */
    public ReportConfigBuilder withBufferSize(long bufferSize){
        this.bufferSize = bufferSize;
        return this;
    }

    /** Sets the character encoding for the output file. */
    public ReportConfigBuilder withCharset(Charset charset){
        this.charset = charset;
        return this;
    }

    /** Sets whether to include descriptive headers at the top of the report. */
    public ReportConfigBuilder withIncludeHeaders(boolean includeHeaders){
        this.includeHeaders = includeHeaders;
        return this;
    }

    /** Sets the frequency of automatic flushes to disk (in rows or operations). */
    public ReportConfigBuilder withFlushInterval(int flushInterval){
        this.flushInterval = flushInterval;
        return this;
    }

    /** Sets the maximum number of rows allowed in a single report file. */
    public ReportConfigBuilder withMaxRows(int maxRows){
        this.maxRows = maxRows;
        return this;
    }

    /**
     * Constructs the final {@link ReportConfig} object.
     *
     * @return A new, validated, and immutable configuration.
     * @throws IllegalArgumentException if the gathered parameters fail the
     *                                  validation rules of the target constructor.
     */
    public ReportConfig build() throws IllegalArgumentException{
        return new ReportConfig(outputPath, appendMode, reportFormat, bufferSize, charset, includeHeaders, flushInterval, maxRows);
    }
}
