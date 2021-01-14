package com.company.Strategy.OrderStrategy.Custom;

import com.company.Class.Person;
import com.company.Strategy.OrderStrategy.OrderStrategy;

public class StringOrderAscending extends OrderStrategy {
    @Override
    public Boolean check(Object a, Object b) {
        String p1 = (String) a;
        String p2 = (String) b;
        return p1.compareTo(p2) < 0;
    }
}
