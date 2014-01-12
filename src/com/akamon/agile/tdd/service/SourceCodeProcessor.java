package com.akamon.agile.tdd.service;

import com.akamon.agile.tdd.data.SourceCode;

/**
 * Class with responsability of performing analysis against source code content
 * @author miguelgarcia
 */
public class SourceCodeProcessor {
 
    public static int countNonCommentedLines(SourceCode sourceCode){
        int nonCommentedlines = 0;
                
        for (int currentLineNumber = 0; currentLineNumber < sourceCode.countLines(); currentLineNumber++) {
            String line = sourceCode.lineAt(currentLineNumber).trim();
            
            if (!line.startsWith("//")) {
                nonCommentedlines++;
            }
        }
        
        return nonCommentedlines;
    }
    
}
