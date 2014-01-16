package com.akamon.agile.tdd.service;

import java.util.regex.Pattern;

/**
 * Class with responsability of performing analysis against source code content
 * @author miguelgarcia
 */
public class SourceCodeProcessor {
    
    private final static String blockCommentsRegexp = "/\\*(?:.|[\\n\\r])*?\\*/";
    private final static String simpleCommentsRegExp = "\\s*//.*$";
    private final static String blankLineRegexp = "^\\s*$\\n";
    
    private final static  Pattern blockCommentsRegexpPattern = Pattern.compile(blockCommentsRegexp, Pattern.MULTILINE);
    private final static  Pattern simpleCommentsRegExpPattern = Pattern.compile(simpleCommentsRegExp, Pattern.MULTILINE);
    private final static  Pattern blankLineRegexpPattern = Pattern.compile(blankLineRegexp, Pattern.MULTILINE);
    
    private static Pattern[] nonCommentedAndNonBlankLinePatterns = {
        blockCommentsRegexpPattern,
        simpleCommentsRegExpPattern,
        blankLineRegexpPattern        
    };
        
    public static int countNonCommentedAndNonBlankLines(String sourceCode){                                
       
        String cleanSourceCode = removeMatchedContentFromPatterns (sourceCode, nonCommentedAndNonBlankLinePatterns);       
        String cleanCodeLines[] = parseLinesFromText (cleanSourceCode);
        final int cleanCodeLinesCount = countLines (cleanCodeLines);
        
        return cleanCodeLinesCount;
    }      
    
    private static int countLines (String[] lines){
        return lines.length;
    }
    
    private static String[] parseLinesFromText (String text){
        final String newLineCharacterRegexp = "\\n";        
        final String[] lines = text.split(newLineCharacterRegexp);
        
        return lines;
    }
    
    private static String removeMatchedContentFromPatterns (String originalText, Pattern[] patternsToAply){
        final String textToSubstitute = "";
        
        return applyMultipleRegexpPatternsToText (originalText, textToSubstitute, patternsToAply);
    }
    
    private static String applyMultipleRegexpPatternsToText (String originalText, String textToSubstitute, Pattern[] patternsToAply){
        for (Pattern currentPattern : patternsToAply){
            originalText = applySingleRegexpPatternToText (originalText, textToSubstitute, currentPattern);
        }
        
        return originalText;
    }
    
    private static String applySingleRegexpPatternToText (String originalText, String textToSubstitute, Pattern patternToAply){
         return patternToAply.matcher(originalText).replaceAll(textToSubstitute);
    }
}
