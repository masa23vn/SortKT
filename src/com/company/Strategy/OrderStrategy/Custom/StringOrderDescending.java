package com.company.Strategy.OrderStrategy.Custom;

import com.company.Strategy.OrderStrategy.OrderStrategy;

public class StringOrderDescending extends OrderStrategy {
    @Override
    public Boolean check(Object a, Object b) {
        String p1 = (String) a;
        String p2 = (String) b;
        return p1.compareTo(p2) > 0;
    }
}
