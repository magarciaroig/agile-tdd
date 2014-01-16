package com.akamon.agile.tdd.data.exception;

import java.io.File;

/**
 *
 * @author Miguel Angel Garcia
 */
public class UnableToLoadSourceCodeFromFileException extends UnableToLoadSourceCodeException {
    
    private String fileName = "";
    
    public UnableToLoadSourceCodeFromFileException(String fileName){
        this(fileName, null);
    }
    
    public UnableToLoadSourceCodeFromFileException(File file){
        this(file, null);
    }
    
    public UnableToLoadSourceCodeFromFileException(File file, Throwable previous){
        this(file.getName(), previous);
    }
    
    public UnableToLoadSourceCodeFromFileException(String fileName, Throwable previous){
        super("Unable to load source code from file " + fileName, previous);
        
        this.fileName = fileName;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }       
}
