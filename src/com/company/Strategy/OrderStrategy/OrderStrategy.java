package com.company.Strategy.OrderStrategy;

import com.company.Strategy.OrderStrategy.ComparableCheck.Ascending;
import com.company.Strategy.OrderStrategy.ComparableCheck.Descending;

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

    public <T> Boolean check(T a, T b) {
        try {
            if (a instanceof java.lang.Comparable) {
                return checkComparable((Comparable) a, (Comparable) b);
            } else {
                return checkCustom((Object) a, (Object) b);
            }
        }
        catch(Exception e) {
            System.out.println("Wrong data type");
            return false;
        }
    }

    public <Object> Boolean checkCustom(Object a, Object b) {
        return false;
    }

    public <T extends Comparable<T>> Boolean checkComparable(T a, T b) {
        return true;
    }
}
