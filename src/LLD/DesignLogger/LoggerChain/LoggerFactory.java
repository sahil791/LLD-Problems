package LLD.DesignLogger.LoggerChain;

import LLD.DesignLogger.LoggerChain.Loggers.DebugLogger;
import LLD.DesignLogger.LoggerChain.Loggers.ErrorLogger;
import LLD.DesignLogger.LoggerChain.Loggers.InfoLogger;
import LLD.DesignLogger.LoggerChain.Loggers.NullLogger;

public class LoggerFactory {
    public static Logger logger() {
        return new DebugLogger(new InfoLogger(new ErrorLogger(new NullLogger())));
    }
}
