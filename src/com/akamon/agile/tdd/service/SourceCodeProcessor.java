package com.akamon.agile.tdd.service;

import java.util.regex.Pattern;

/**
 * Class with responsability of performing analysis against source code content
 * @author miguelgarcia
 */
public class SourceCodeProcessor {
 
    private enum Status {INITIAL_PROCESSOR_STATUS, INSIDE_BLOCK_COMMENT_STATE};
    
    private int linesCount;    
    private Status status = Status.INITIAL_PROCESSOR_STATUS;
    
    public int countNonCommentedAndNonBlankLines(String sourceCode){                                
        final String blockCommentsRegexp = "/\\*(?:.|[\\n\\r])*?\\*/";
        final String simpleCommentsRegExp = "\\s*//.*$";
        final String blankLineRegexp = "^\\s*$\\n";
        
        Pattern blockCommentsRegexpPattern = Pattern.compile(blockCommentsRegexp, Pattern.MULTILINE);
        Pattern simpleCommentsRegExpPattern = Pattern.compile(simpleCommentsRegExp, Pattern.MULTILINE);
        Pattern blankLineRegexpPattern = Pattern.compile(blankLineRegexp, Pattern.MULTILINE);
        
        String sourceNoBlockComments = blockCommentsRegexpPattern.matcher(sourceCode).replaceAll("");
        String sourceNoComments = simpleCommentsRegExpPattern.matcher(sourceNoBlockComments).replaceAll("");
        String sourceNoCommentsAndNoBlankLines = blankLineRegexpPattern.matcher(sourceNoComments).replaceAll("");
                                                              
        String[] lines = sourceNoCommentsAndNoBlankLines.split("\n");
        
        return lines.length;
    }               
}
