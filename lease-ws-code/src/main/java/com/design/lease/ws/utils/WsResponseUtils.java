package com.design.lease.ws.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WsResponseUtils {

    public static void sendMessage(HttpServletResponse response,String json){
        try {
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.append(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
