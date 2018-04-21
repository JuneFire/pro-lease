package com.design.lease.ws.builder;

import com.design.lease.ws.dto.WsResponseMsgVO;
import com.design.lease.ws.utils.WsResponseUtils;
import com.design.lease.utils.JacksonObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class WsConfigRequestController {

    private static final Logger logger = LoggerFactory.getLogger(WsConfigRequestController.class);

    @Autowired
    private WsBeanController wsBeanController;

    public void doFilter(HttpServletRequest request, HttpServletResponse response){
        setHttpServletRequest(request);
        String path = request.getRequestURI();
        logger.info("path = {}",path);
        WsResponseMsgVO wsResponseMsgVO = new WsResponseMsgVO().buildSuccessResponse();
        WsResponseUtils.sendMessage(response, JacksonObjectUtils.jacksonObjectToSerializable(wsResponseMsgVO));
    }

    private void setHttpServletRequest(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
