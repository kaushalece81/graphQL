
package com.example.pst.dc.admin.gateway.util;

import org.slf4j.Logger;
import org.slf4j.MDC;

public class LogUtil {

    private static final String CORRELATION_ID_MDC = "CORRELATION_ID";

    private LogUtil() {

    }

    public static void info(Logger logger, String correlationId, String log, Object... args) {
        if (!logger.isInfoEnabled()) {
            return;
        }
        try (MDC.MDCCloseable mdc = MDC.putCloseable(CORRELATION_ID_MDC, correlationId)) {
            logger.info(log, args);
        }
    }

    public static void warn(Logger logger, String correlationId, String log, Object... args) {
        if (!logger.isWarnEnabled()) {
            return;
        }
        try (MDC.MDCCloseable mdc = MDC.putCloseable(CORRELATION_ID_MDC, correlationId)) {
            logger.warn(log, args);
        }
    }

    public static void error(Logger logger, String correlationId, String log, Throwable ex) {
        if (!logger.isErrorEnabled()) {
            return;
        }
        try (MDC.MDCCloseable mdc = MDC.putCloseable(CORRELATION_ID_MDC, correlationId)) {
            logger.error(log + ", ERROR_MESSAGE=" + ((ex.getMessage() != null) ? ex.getMessage() : ex.getClass().getName()), ex);
        }
    }
}
