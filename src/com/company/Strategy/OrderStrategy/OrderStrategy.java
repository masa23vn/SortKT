package com.company.Strategy.OrderStrategy;

import java.util.HashMap;

public class OrderStrategy implements Cloneable {
    private static HashMap<String, OrderStrategy> sortStrategy = new HashMap<String, OrderStrategy>();

    static {
        sortStrategy.put("Ascending", new Ascending());
    }

    public static OrderStrategy getStrategy(String name) {
        try {
            if (sortStrategy.containsKey(name)) {
                return (OrderStrategy) sortStrategy.get(name).clone();
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

    public <T extends Comparable<T>> Boolean check(T a, T b) {
        return true;
    }
}
