package LLD.DesignLogger.LoggerChain.Loggers;

import LLD.DesignLogger.LoggerChain.LogLevel;
import LLD.DesignLogger.LoggerChain.Logger;

public class NullLogger extends Logger {
    public NullLogger() {
        super(null);
    }

    public void log(LogLevel logLevel, String message) {
    }
}
