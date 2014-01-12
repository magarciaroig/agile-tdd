package com.akamon.agile.tdd.service;

import com.akamon.agile.tdd.data.SourceCode;
import com.akamon.agile.tdd.data.SourceCodeLine;
import java.util.Enumeration;

/**
 * Class with responsability of performing analysis against source code content
 * @author miguelgarcia
 */
public class SourceCodeProcessor {
 
    public static int countNonCommentedLines(SourceCode sourceCode){
        int nonCommentedlines = 0;
        
        Enumeration<SourceCodeLine> linesEnumeration = sourceCode.getLineEnumeration();                        
        
        while (linesEnumeration.hasMoreElements()) {            
            SourceCodeLine line = linesEnumeration.nextElement();            
            nonCommentedlines+= (line.isDoubleBarComment() || line.isBlankLine()) ? 0 : 1;                       
        }
                        
        return nonCommentedlines;
    }               
}
