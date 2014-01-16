package com.akamon.agile.tdd.data;

/**
 *
 * @author Miguel Angel Garcia
 */
public class MemorySourceCodeProvider implements ISourceCodeProvider {

    private String source;
    
    public MemorySourceCodeProvider(String source){
        this.source = source;
    }
    
    @Override
    public String loadSource() {
        return this.source;
    }        
}
