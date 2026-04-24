package org.howard.edu.lsp.finalexam.question2;

/**
 * Defines the template method workflow for generating reports.
 */
public abstract class Report {

    /**
     * Loads the data needed for the report.
     */
    protected abstract void loadData();

    /**
     * Formats the report header.
     *
     * @return the report-specific header
     */
    protected abstract String formatHeader();

    /**
     * Formats the report body.
     *
     * @return the report-specific body
     */
    protected abstract String formatBody();

    /**
     * Formats the report footer.
     *
     * @return the report-specific footer
     */
    protected abstract String formatFooter();

    /**
     * Generates the report using a fixed workflow.
     */
    public final void generateReport() {
        loadData();

        System.out.println("=== HEADER ===");
        System.out.println(formatHeader());
        System.out.println();

        System.out.println("=== BODY ===");
        System.out.println(formatBody());
        System.out.println();

        System.out.println("=== FOOTER ===");
        System.out.println(formatFooter());
        System.out.println();
    }
}