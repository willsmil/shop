package com.shop.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingUtil {
    static private Logger logger ;
    static public void log(Object info ){
        if (info != null) {
            logger = LoggerFactory.getLogger(LoggingUtil.class);
            logger.info(info.toString());
        }
        else {
            logger = LoggerFactory.getLogger(LoggingUtil.class);
            logger.info("null");
        }
    }
}
