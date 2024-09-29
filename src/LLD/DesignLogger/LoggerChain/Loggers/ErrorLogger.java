package LLD.DesignLogger.LoggerChain.Loggers;

import LLD.DesignLogger.LoggerChain.LogLevel;
import LLD.DesignLogger.LoggerChain.Logger;

public class ErrorLogger extends Logger {
    public ErrorLogger(Logger logger) {
        super(logger);
    }

    public void log(LogLevel logLevel, String message) {
        if(logLevel.equals(LogLevel.ERROR)) {
            System.out.println("ERROR: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
