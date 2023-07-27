package com.goIt.Core5.timeleaf;

import org.thymeleaf.web.IWebApplication;

import java.io.InputStream;
import java.util.Map;
import java.util.Set;

public class Aplicatoin implements IWebApplication {
    @Override
    public boolean containsAttribute(String name) {
        return false;
    }

    @Override
    public int getAttributeCount() {
        return 0;
    }

    @Override
    public Set<String> getAllAttributeNames() {
        return null;
    }

    @Override
    public Map<String, Object> getAttributeMap() {
        return null;
    }

    @Override
    public Object getAttributeValue(String name) {
        return null;
    }

    @Override
    public void setAttributeValue(String name, Object value) {

    }

    @Override
    public void removeAttribute(String name) {

    }

    @Override
    public boolean resourceExists(String path) {
        return false;
    }

    @Override
    public InputStream getResourceAsStream(String path) {
        return null;
    }
}
