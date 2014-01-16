package com.akamon.agile.tdd.data;

import com.akamon.agile.tdd.data.exception.UnableToLoadSourceCodeException;

/**
 *
 * @author Miguel Angel Garcia
 */
public interface ISourceCodeProvider {
    
    public String loadSource() throws UnableToLoadSourceCodeException;
}
