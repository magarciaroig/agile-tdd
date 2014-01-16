package com.akamon.agile.tdd.data;

import com.akamon.agile.tdd.data.exception.UnableToLoadSourceCodeFromFileException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * A source code provider from phisical files
 * @author Miguel Angel Garcia
 */
public class FileSourceCodeProvider implements ISourceCodeProvider {

    File sourceCodeFile = null;
    
    public FileSourceCodeProvider(String fileName)  {
        this(new File(fileName));
    }
    
    public FileSourceCodeProvider(File fileName)  {
        this.sourceCodeFile = fileName;
    }
    
    @Override
    public String loadSource() throws UnableToLoadSourceCodeFromFileException {        
        String source = null;
        
        try {
            source = loadFileContent(this.sourceCodeFile);
        }
        catch (Exception e){
            throw new UnableToLoadSourceCodeFromFileException(this.sourceCodeFile, e);
        }
        
        return source;
    }
    
    private String loadFileContent(File source) throws FileNotFoundException, IOException{
        String content;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {                        
            content = loadBufferedReaderContent(reader);        
        }
        
        return content;
    }
    
    private String loadBufferedReaderContent(BufferedReader reader) throws IOException{
        StringBuilder strBuilder = new StringBuilder();
        String line = reader.readLine();
                
        while (line != null) {
            strBuilder.append(line);
            strBuilder.append(System.lineSeparator());
            line = reader.readLine();
        }
        
        final String readerContent = strBuilder.toString();
        
        return readerContent;
    }
    
}
