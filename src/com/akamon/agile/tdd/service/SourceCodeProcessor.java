package com.akamon.agile.tdd.service;

import com.akamon.agile.tdd.data.SourceCode;
import com.akamon.agile.tdd.data.SourceCodeLine;
import java.util.Enumeration;

/**
 * Class with responsability of performing analysis against source code content
 * @author miguelgarcia
 */
public class SourceCodeProcessor {
 
    private int linesCount;
    private boolean inBlockComment;
    
    public int countNonCommentedAndNonBlankLines(SourceCode sourceCode){        
        initLinesCounter();
        inBlockComment = false;
        recordNonCommentedAndNonBlankLines(sourceCode);
                        
        return linesCount;
    } 
    
    private void initLinesCounter(){
        linesCount = 0;        
    }
    
    private void recordNonCommentedAndNonBlankLines(SourceCode sourceCode){
        Enumeration<SourceCodeLine> linesEnumeration = sourceCode.getLineEnumeration();                        
        
        while (linesEnumeration.hasMoreElements()) {            
            SourceCodeLine line = linesEnumeration.nextElement();            
            recordNonCommentedAndNonBlankLine(line);
        }
    }
    
    private void recordNonCommentedAndNonBlankLine(SourceCodeLine line){
        if ( !shouldBeCountedAsNonCommentedAndNonBlank(line) ) {
            linesCount++;
        }
    }
    
    private boolean shouldBeCountedAsNonCommentedAndNonBlank(SourceCodeLine line){
        boolean isCommented = false;
        
        if (line.isSimpleComment() || line.isBlankLine() || line.isBlockCommentInit() || line.isBlockCommentEnd() || inBlockComment) {            
            isCommented = true;
            
            if (line.isBlockCommentInit()) {
                inBlockComment = true;
            }
            
            if (line.isBlockCommentEnd()) {
                inBlockComment = false;
            }
            
        }
        
        return isCommented;
    }
}
