package LLD.DesignLogger;

import LLD.DesignLogger.LoggerChain.*;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.logger();
//        logger.log(LogLevel.DEBUG, "Heyyy How are you");
//        logger.log(LogLevel.INFO, "Heyyy How are you");
        logger.log(LogLevel.ERROR, "Heyyy How are you");
    }
}
