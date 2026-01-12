package org.example.config.analysis;

import org.example.analysis.FileFilterStrategy;
import org.example.config.report.ReportFormat;

import java.nio.charset.Charset;
/**
 * Fluent builder for creating instances of {@link AnalysisConfig}.
 * <p>
 * This class provides a mutable staging area to set configuration parameters
 * before producing a thread-safe, immutable result via the {@link #build()} method.
 * </p>
 *
 * @author Denys Oleksiuk
 * @version 1.0.0 (2026-01-10)
 */
public class AnalysisConfigBuilder {
    private boolean enableSizeAnalysis;
    private boolean enableExtensionsAnalysis;
    private AnalysisSortOrder analysisSortOrder;
    private FileFilterStrategy fileFilterStrategy;
    private ReportFormat reportFormat;
    private long bufferSize;
    private Charset charset;
    private int resultLimit;

    /** Sets whether to include file size metrics in the analysis. */
    public AnalysisConfigBuilder withEnabledSizeAnalysis(boolean enableSizeAnalysis) {
        this.enableSizeAnalysis = enableSizeAnalysis;
        return this;
    }

    /** Sets whether to include extension distribution in the analysis. */
    public AnalysisConfigBuilder withEnabledExtensionsAnalysis(boolean enableExtensionsAnalysis) {
        this.enableExtensionsAnalysis = enableExtensionsAnalysis;
        return this;
    }

    /** Sets the sorting direction for the analysis results. */
    public AnalysisConfigBuilder withAnalysisSortOrder(AnalysisSortOrder analysisSortOrder) {
        this.analysisSortOrder = analysisSortOrder;
        return  this;
    }

    /** Sets the functional strategy for filtering files. */
    public  AnalysisConfigBuilder withFileFilterStrategy(FileFilterStrategy fileFilterStrategy) {
        this.fileFilterStrategy = fileFilterStrategy;
        return this;
    }

    /** Sets the desired output format (e.g., TXT, CSV). */
    public AnalysisConfigBuilder withReportFormat(ReportFormat reportFormat) {
        this.reportFormat = reportFormat;
        return this;
    }

    /** Sets the I/O buffer size in bytes. */
    public AnalysisConfigBuilder withBufferSize(long bufferSize) {
        this.bufferSize = bufferSize;
        return this;
    }

    /** Sets the character set for processing text-based file data. */
    public AnalysisConfigBuilder withCharset(Charset charset) {
        this.charset = charset;
        return this;
    }

    /** Sets the maximum number of items to include in the final report. */
    public AnalysisConfigBuilder withResultLimit(int resultLimit) {
        this.resultLimit = resultLimit;
        return this;
    }

    /**
     * Constructs the {@link AnalysisConfig} using the current state of the builder.
     *
     * @return A new, validated, and immutable {@link AnalysisConfig} instance.
     * @throws IllegalArgumentException if the parameters fail validation in the
     *                                  AnalysisConfig constructor.
     */
    public AnalysisConfig build() throws IllegalArgumentException{
        return new AnalysisConfig(enableSizeAnalysis,enableExtensionsAnalysis,analysisSortOrder,fileFilterStrategy,reportFormat,bufferSize,charset,resultLimit);
    }

}
