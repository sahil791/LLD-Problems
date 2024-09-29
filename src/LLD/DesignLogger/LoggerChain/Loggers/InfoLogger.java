package LLD.DesignLogger.LoggerChain.Loggers;

import LLD.DesignLogger.LoggerChain.LogLevel;
import LLD.DesignLogger.LoggerChain.Logger;

public class InfoLogger extends Logger {
    public InfoLogger(Logger logger) {
        super(logger);
    }

    public void log(LogLevel logLevel, String message) {
        if(logLevel.equals(LogLevel.INFO)) {
            System.out.println("INFO: " + message);
        } else {
            System.out.println("INFO : Moving on to next Level");
            super.log(logLevel, message);
        }
    }
}
