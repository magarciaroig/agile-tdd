package com.akamon.agile.tdd.data.exception;

/**
 *
 * @author Miguel Angel Garcia
 */
public class UnableToLoadSourceCodeException extends Exception {
    public UnableToLoadSourceCodeException() {
       super("Unable to load source code");
    }

    public UnableToLoadSourceCodeException(String string) {
        super(string);
    }

    public UnableToLoadSourceCodeException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
}
