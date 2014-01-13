package com.akamon.agile.tdd.data;

/**
 * Class responsible to modelate a line content of a source code
 * @author miguelgarcia
 */
public class SourceCodeLine {

    private String cleanedContent;
    private String rawContent;
    private int number;
    private SourceCode sourceCodeOwner;
    
    
    SourceCodeLine(String lineContent, int lineNumber, SourceCode sourceCodeOwner) {
        this.rawContent = lineContent;
        this.cleanedContent =  this.rawContent.trim();
        this.sourceCodeOwner = sourceCodeOwner;
        this.number = lineNumber;
    }
    
    public String getContent(){
        return rawContent;
    }
    
    /**
     * @return the lineNumber
     */
    public int getNumber() {
        return number;
    }
            
    /**
     * @return the sourceCode
     */
    public SourceCode getSourceCodeOwner() {
        return sourceCodeOwner;
    }
    
    public boolean isSimpleComment() {
        return cleanedContent.startsWith("//");
    }    
    
    public boolean isBlankLine() {
        return cleanedContent.equals("");
    }
    
    public boolean isBlockCommentInit() {
        return cleanedContent.startsWith("/*");
    }
    
    public boolean isBlockCommentEnd() {
        return cleanedContent.endsWith("*/");
    } 
    
    public boolean isBlockComment(){
        return isBlockCommentInit() || isBlockCommentEnd();
    }
}
