package LLD.DesignLogger.LoggerChain;

public abstract class Logger {
    Logger nextLogger;
    public Logger(Logger logger) {
        this.nextLogger = logger;
    }

    public void log(LogLevel logLevel, String message) {
        //if(nextLogger != null) {
        nextLogger.log(logLevel, message);
        //}
    }
}
