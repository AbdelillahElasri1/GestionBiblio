package utils;

import java.io.PrintStream;

public class OutputWriter {
    private final java.io.PrintStream out;


    public OutputWriter(PrintStream out) {
        this.out = out;
    }
    public void print(String message){
        out.print(message);
    }
    public void println(String message){
        out.println(message);
    }
}
