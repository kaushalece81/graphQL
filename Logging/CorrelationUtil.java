package com.example.pst.dc.admin.gateway.util;


import static com.example.pst.dc.admin.gateway.constant.AdminGatewayConstant.CORRELATION_ID;
import static com.example.pst.dc.admin.gateway.constant.AdminGatewayConstant.DC_CORRELATION_ID_HEADER_KEY;

import java.util.List;
import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.web.reactive.function.server.ServerRequest;

/**
 * This is a CorrelationUtil class to generate unique correlationId, if its not available in header
 * otherwise it returns correlationId available in the header
 *
 */
public class CorrelationUtil {

    private CorrelationUtil() {
    }

    public static String getDcCorrelationId(ServerHttpRequest request) {

        List<String> header = request.getHeaders().get(DC_CORRELATION_ID_HEADER_KEY);
        if (CollectionUtils.isEmpty(header)) {
            return UUID.randomUUID().toString();
        }
        return header.get(0);
    }

    public static String getCorrelationIdFromMDC(){
        return MDC.get(CORRELATION_ID);
    }

    public static String getDcCorrelationId(ServerRequest request) {

        List<String> header = request.headers().header(DC_CORRELATION_ID_HEADER_KEY);
        if (CollectionUtils.isEmpty(header)) {
            return UUID.randomUUID().toString();
        }
        return header.get(0);
    }

}
