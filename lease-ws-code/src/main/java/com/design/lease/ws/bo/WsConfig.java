package com.design.lease.ws.bo;

import java.io.Serializable;
import java.util.Map;

public class WsConfig implements Serializable{

    private static final long serialVersionUID = -8862366943787571211L;
    private String wsNameSpace;

    private String route;

    private String method;

    private String className;

    private String path;

    private Map<String,Class<?>> params;

    private Object object;

    private String beanName;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getWsNameSpace() {
        return wsNameSpace;
    }

    public void setWsNameSpace(String wsNameSpace) {
        this.wsNameSpace = wsNameSpace;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<String, Class<?>> getParams() {
        return params;
    }

    public void setParams(Map<String, Class<?>> params) {
        this.params = params;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
