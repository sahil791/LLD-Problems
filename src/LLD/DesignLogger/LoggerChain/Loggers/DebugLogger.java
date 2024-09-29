package LLD.DesignLogger.LoggerChain.Loggers;

import LLD.DesignLogger.LoggerChain.LogLevel;
import LLD.DesignLogger.LoggerChain.Logger;

public class DebugLogger extends Logger {
    public DebugLogger(Logger logger) {
        super(logger);
    }

    public void log(LogLevel logLevel, String message) {
        if(logLevel.equals(LogLevel.DEBUG)) {
            System.out.println("DEBUG: " + message);
        } else {
            System.out.println("DEBUG : Moving on to next Level");
            super.log(logLevel, message);
        }
    }
}
