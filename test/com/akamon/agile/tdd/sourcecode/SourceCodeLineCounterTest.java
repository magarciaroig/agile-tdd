package com.akamon.agile.tdd.sourcecode;


import com.akamon.agile.tdd.data.SourceCode;
import com.akamon.agile.tdd.service.SourceCodeProcessor;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miguelgarcia
 */
public class SourceCodeLineCounterTest {
            
//    @Test
//    public void countAllLines() {
//       final String[] sourceCodeContent = {"int c;"};
//       SourceCode sourceCode = new SourceCode(sourceCodeContent);
//       SourceCodeProcessor processor = new SourceCodeProcessor();
//       final int expected = 1;       
//       
//       assertEquals("There was one line of code", expected, processor.countNonCommentedAndNonBlankLines(sourceCode));
//    }
//    
//    @Test
//    public void notCountBlankLines() {
//        final String[] sourceCodeContent = {"int c;", ""};
//        SourceCode sourceCode = new SourceCode(sourceCodeContent);
//        SourceCodeProcessor processor = new SourceCodeProcessor();
//        final int expected = 1; 
//        
//        assertEquals("Blank lines MUSN'T be counted", expected, processor.countNonCommentedAndNonBlankLines(sourceCode));
//    }
//    
//    @Test
//    public void notCountSimpleCommentedLines() {
//        final String[] sourceCodeContent = {"// Var definition", "int c;"};
//        SourceCode sourceCode = new SourceCode(sourceCodeContent);
//        SourceCodeProcessor processor = new SourceCodeProcessor();
//        final int expected = 1; 
//        
//        assertEquals("Simple commented lines MUSN'T be counted", expected, processor.countNonCommentedAndNonBlankLines(sourceCode));
//    }
//        
//    @Test
//    public void notCountBlockCommentedLines() {
//        
//        final String[] sourceCodeContentMultiLineBlockComment = {            
//            "/** Var definition", 
//            "* Please place the variables in this section", 
//            "**/",
//            "int c;"};
//        
//        final String[] sourceCodeContentOneLineBlockComment = {           
//            "/** Var definition */",             
//            "int c;"};
//        
//        final String multiLineBlockCommentTestWarning = "Block commented lines MUSN'T be counted";
//        final String oneLineBlockCommentTestWarning = "One line Block commented lines MUSN'T be counted";
//                
//        final int lineCountExpected = 1; 
//        
//        checkSourceCodeBlockComentCount(sourceCodeContentMultiLineBlockComment, 
//                lineCountExpected, 
//                multiLineBlockCommentTestWarning);
//        
//        checkSourceCodeBlockComentCount(sourceCodeContentOneLineBlockComment, 
//                lineCountExpected, 
//                oneLineBlockCommentTestWarning);                
//    }
    
    @Test
    public void countLinesWithCodeBeforeOfAfterComments(){
        final String[] sourceCodeWithCodeBeforeOfAfterComments = {            
            "begin /** Var definition", 
            "* Please place the variables in this section", 
            "**/ int c;",
            "int z; /* control var */ int y;",
            "/* process section */",
            "init();"};
        final int lineCountExpected = 4; 
        final String codeWithCodeBeforeOfAfterCommentsWarning = 
                "Lines with code before of after comments MUST be counted";
        
        checkSourceCodeBlockComentCount(sourceCodeWithCodeBeforeOfAfterComments, 
                lineCountExpected, 
                codeWithCodeBeforeOfAfterCommentsWarning);     
    }
    
    private void checkSourceCodeBlockComentCount(String[] sourceCodeContent, int expectedCount, String warningMsg) {
        SourceCode sourceCode = new SourceCode(sourceCodeContent);
        SourceCodeProcessor processor = new SourceCodeProcessor();
        
        assertEquals(warningMsg, expectedCount, processor.countNonCommentedAndNonBlankLines(sourceCode));
    }
    
}
