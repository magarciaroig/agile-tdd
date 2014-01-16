package com.akamon.agile.tdd.service;

import com.akamon.agile.tdd.data.SourceCode;
import com.akamon.agile.tdd.data.SourceCodeLine;
import java.util.Enumeration;

/**
 * Class with responsability of performing analysis against source code content
 * @author miguelgarcia
 */
public class SourceCodeProcessor {
 
    private enum Status {INITIAL_PROCESSOR_STATUS, INSIDE_BLOCK_COMMENT_STATE};
    
    private int linesCount;    
    private Status status = Status.INITIAL_PROCESSOR_STATUS;
    
    public int countNonCommentedAndNonBlankLines(SourceCode sourceCode){        
        initLinesCounter();        
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
        final boolean incrementLinesCounter = shouldBeCountedAsNonCommentedAndNonBlank(line);
        if (incrementLinesCounter) {
            linesCount++;
        }
    }
    
    private boolean shouldBeCountedAsNonCommentedAndNonBlank(SourceCodeLine line){
        /*final boolean inCommentScenario = checkCommentOrBlankLineOrInsidePrevBlockComment(line);
        if ((inCommentScenario) || (line.isBlockCommentInit() || !line.isBlockCommentEnd())) {            
            
            updateStatusIfNeeded(line);            
        }*/
        if (status.equals(Status.INITIAL_PROCESSOR_STATUS)){
            
        }
        else if (status.equals(Status.INSIDE_BLOCK_COMMENT_STATE)){
            
        }
        
        return true;        
    } 
    
    private boolean checkCommentOrBlankLineOrInsidePrevBlockComment(SourceCodeLine line){
        /*return ( line.isSimpleComment() || 
                line.isBlankLine() || 
                line.isBlockComment() || 
                insideBlockComment() );*/
        return ((insideBlockComment()) || (!line.hasNonCommentedContent()));
    }
    
    private boolean insideBlockComment(){
        return status.equals(Status.INSIDE_BLOCK_COMMENT_STATE);
    }
    
    private void updateStatusIfNeeded(SourceCodeLine line){
        updateToBlockCommentStateIfNeeded(line);
        updateToInitialStateIfNeeded(line);
    }
    
    private void updateToBlockCommentStateIfNeeded(SourceCodeLine line){
        final boolean isBeginOfBlockComment = line.isBlockCommentInit();
        if (isBeginOfBlockComment) {
            updateStatus(Status.INSIDE_BLOCK_COMMENT_STATE);
        }
    }
    
    private void updateToInitialStateIfNeeded(SourceCodeLine line){
        final boolean isEndOfBlockComment = line.isBlockCommentEnd();
        if (isEndOfBlockComment) {
            updateStatus(Status.INITIAL_PROCESSOR_STATUS);
        }
    }
    
    private void updateStatus(Status status){
        this.status = status;
    }
}
