package com.akamon.agile.tdd.service;

/**
 *
 * @author Miguel Angel Garcia
 */
public class SourceCodeStats {
    private int nonCommentedAndNonBlankLines = 0;

    /**
     * @return the nonCommentedAndNonBlankLines
     */
    public int getNonCommentedAndNonBlankLines() {
        return nonCommentedAndNonBlankLines;
    }

    /**
     * @param nonCommentedAndNonBlankLines the nonCommentedAndNonBlankLines to set
     */
    void setNonCommentedAndNonBlankLines(int nonCommentedAndNonBlankLines) {
        this.nonCommentedAndNonBlankLines = nonCommentedAndNonBlankLines;
    }    
    
}
