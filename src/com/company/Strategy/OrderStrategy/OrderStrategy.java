package com.company.Strategy.OrderStrategy;

import java.util.HashMap;

public class OrderStrategy implements Cloneable {
    private static HashMap<String, OrderStrategy> orderStrategy = new HashMap<String, OrderStrategy>();

    static {
        orderStrategy.put("Ascending", new Ascending());
        orderStrategy.put("Descending", new Descending());
    }

    public static OrderStrategy getStrategy(String name) {
        try {
            if (orderStrategy.containsKey(name)) {
                return (OrderStrategy) orderStrategy.get(name).clone();
            } else {
                return null;
            }
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Boolean check(Object a, Object b) throws ClassCastException {
        return false;
    }

}
