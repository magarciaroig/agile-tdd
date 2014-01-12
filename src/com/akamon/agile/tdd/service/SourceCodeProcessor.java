package com.akamon.agile.tdd.service;

import com.akamon.agile.tdd.data.SourceCode;

/**
 * Class with responsability of performing analysis against source code content
 * @author miguelgarcia
 */
public class SourceCodeProcessor {
 
    public static int countNonCommentedLines(SourceCode sourceCode){
        return sourceCode.countLines();
    }
    
}
