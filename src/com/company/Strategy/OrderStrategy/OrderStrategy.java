package com.company.Strategy.OrderStrategy;

import java.util.HashMap;

public class OrderStrategy implements Cloneable {
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Boolean check(Object a, Object b) throws ClassCastException {
        return false;
    }

}
