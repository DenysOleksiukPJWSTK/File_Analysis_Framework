package org.example.config;

import org.example.analysis.FileFilterStrategy;

import java.nio.charset.Charset;
/**
 * Immutable configuration for the analysis engine.
 * Enforces strict validation of performance and structural parameters.
 *
 * @author Denys Oleksiuk
 * @version 1.0.0 (2026-01-05)
 */
public final class AnalysisConfig {
    private final boolean enableSizeAnalysis;
    private final boolean enableExtensionsAnalysis;
    private final AnalysisSortOrder analysisSortOrder;
    private final FileFilterStrategy fileFilterStrategy;
    private final ReportFormat reportFormat;
    private final long bufferSize;
    private final Charset charset;
    private final int resultLimit;
    /**
     * Constructs a validated AnalysisConfig instance.
     *
     * @param enableSizeAnalysis       Toggle for file size metrics.
     * @param enableExtensionsAnalysis Toggle for extension distribution metrics.
     * @param analysisSortOrder        Direction of result sorting (ASC/DESC).
     * @param fileFilterStrategy       Functional strategy for file inclusion.
     * @param reportFormat             Output format (TXT/CSV).
     * @param bufferSize               I/O buffer size in bytes (must be > 0).
     * @param charset                  Character encoding for text processing.
     * @param resultLimit              Maximum number of entries in the final report.
     * @throws IllegalArgumentException if mandatory fields are null or numeric values are invalid.
     */
    public AnalysisConfig
            (
                    boolean enableSizeAnalysis,
                    boolean enableExtensionsAnalysis,
                    AnalysisSortOrder analysisSortOrder,
                    FileFilterStrategy fileFilterStrategy,
                    ReportFormat reportFormat,
                    long bufferSize,
                    Charset charset,
                    int resultLimit
                    ){
        validate(analysisSortOrder,fileFilterStrategy,reportFormat,resultLimit,bufferSize,charset);
        this.enableSizeAnalysis = enableSizeAnalysis;
        this.enableExtensionsAnalysis = enableExtensionsAnalysis;
        this.analysisSortOrder = analysisSortOrder;
        this.fileFilterStrategy = fileFilterStrategy;
        this.reportFormat = reportFormat;
        this.bufferSize = bufferSize;
        this.charset = charset;
        this.resultLimit = resultLimit;
    }

    /**
     * Validates configuration parameters to ensure system stability.
     */
    private void validate
            (
                    AnalysisSortOrder analysisSortOrder,
                    FileFilterStrategy fileFilterStrategy,
                    ReportFormat reportFormat,
                    int resultLimit,
                    long bufferSize,
                    Charset charset
            ) {
        if (analysisSortOrder == null) throw  new IllegalArgumentException("Analysis sort order cannot be null");
        if (fileFilterStrategy == null) throw  new IllegalArgumentException("File filter strategy cannot be null");
        if (reportFormat == null) throw  new IllegalArgumentException("Report format cannot be null");
        if (resultLimit < 0) throw  new IllegalArgumentException("Result limit must be positive");
        if (bufferSize <= 0) throw  new IllegalArgumentException("Buffer size must be positive");
        if (charset == null) throw  new IllegalArgumentException("Charset cannot be null");
    }

    // --- Accessors ---
    public boolean isEnableSizeAnalysis() {
        return enableSizeAnalysis;
    }

    public boolean isEnableExtensionsAnalysis() {
        return enableExtensionsAnalysis;
    }

    public AnalysisSortOrder getAnalysisSortOrder() {
        return analysisSortOrder;
    }

    public FileFilterStrategy getFileFilterStrategy() {
        return fileFilterStrategy;
    }

    public ReportFormat getReportFormat() {
        return reportFormat;
    }

    public int getResultLimit() {
        return resultLimit;
    }

    public Charset getCharset() {
        return charset;
    }

    public long getBufferSize() {
        return bufferSize;
    }

}
