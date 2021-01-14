package com.company.SortFactory;

import java.util.HashMap;
import java.util.Set;

public class Attribute {

    private HashMap<String, Object> attributes = new HashMap<String, Object>();
    private Boolean autoAddNew = true;

    public Object getAttribute(String name) {
        if (attributes.containsKey(name))
            return attributes.get(name);
        return null;
    }

    public Boolean setAttribute(String name, Object newValue) {
        if (attributes.containsKey(name)) {
            attributes.put(name, newValue);
            return true;
        }
        else {
            if (autoAddNew) {
                attributes.put(name, newValue);
                return true;
            }
            return false;
        }
    }
}