package org.app.exception;

/*
    author: Timor
    date: 2020/1/16 0016
*/
public class FrequentlyUseException extends Exception{
    public FrequentlyUseException() {
        super("调用频率过高...");
    }

    public FrequentlyUseException(String message) {
        super(message);
    }
}
