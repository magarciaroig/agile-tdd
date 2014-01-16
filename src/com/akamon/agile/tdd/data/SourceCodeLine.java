package com.akamon.agile.tdd.data;

import org.apache.commons.lang3.StringUtils;

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
        boolean blockCommentStarted = cleanedContent.matches("^.*/\\*^(?!.*?/\\*)[^/\\*]$");
                
        
        if (blockCommentStarted){
            
            System.out.println(cleanedContent);
        }
        
        return blockCommentStarted;
    }        
    
    public boolean isBlockCommentEnd() {
        return cleanedContent.contains("*/");                
    }              
    
    public boolean isBlockComment(){        
        return isBlockCommentInit() || isBlockCommentEnd();
    }
    
    public boolean hasNonCommentedContent(){        
        boolean hasSignificativeContent = false;
        
        if (!isBlankLine()){
            if ((!isBlockComment()) && (!isSimpleComment())) {
                hasSignificativeContent = true;
            }
            else if (!isSimpleComment()) {
                if (cleanedContent.matches("^.+/\\*.*$")){
                    hasSignificativeContent = true;
                }
                else if (cleanedContent.matches("^.*\\*/.+$")){
                    hasSignificativeContent = true;
                }
            }
        }
        
        return hasSignificativeContent;
        
    } 
    
    @Override
    public String toString(){
        return this.number + " : " + this.rawContent;
    }
    
    public String getSignificativeContent(){                        
        if (isBlankLine()) return "";
        
        String significativeContent = "";                
        
        String[] sigContentParts = cleanedContent.split("/\\*.*\\*/");
        
        if ( (sigContentParts.length > 1) || (sigContentParts.length == 1 && sigContentParts[0].length() == 0) ){
            // Valid pattern
            significativeContent = StringUtils.join(sigContentParts, "");
        }
        else {
            sigContentParts = cleanedContent.split(".*\\*/");
            if ( (sigContentParts.length > 1) || (sigContentParts.length == 1 && sigContentParts[0].length() == 0) ){
                // Valid pattern
                significativeContent = StringUtils.join(sigContentParts, "");
            }
        }                                                
        
        return significativeContent;
    }
    
    public static void main(String args[]){
       SourceCodeLine l1 = new SourceCodeLine("hola/* comentario */la", 1, null);
       SourceCodeLine l2 = new SourceCodeLine("hola", 1, null);
       SourceCodeLine l3 = new SourceCodeLine("/* comentario */ ", 1, null);
       SourceCodeLine l4 = new SourceCodeLine("tario */ la", 1, null);
       
       
        //System.out.println(l1.getSignificativeContent());
        //System.out.println(l2.getSignificativeContent());
        //System.out.println(l3.getSignificativeContent());
        //System.out.println(l4.getSignificativeContent());
        
       l1.isBlockCommentInit();
       l2.isBlockCommentInit();
       l3.isBlockCommentInit();
       l4.isBlockCommentInit();
    }
    
//    public static void main(String args[]){
//        String[] cadenas = {"",
//        "pepe",
//        "hola/*",
//        "*/hola",        
//        "antes/* comment */despues", 
//        "/*comment*/"};
//                       
//        for (String str : cadenas){
//            SourceCodeLine line = new SourceCodeLine(str, 0, null);
//            System.out.println(str + " " + line.hasNonCommentedContent());
//        }                                
//    }
}
