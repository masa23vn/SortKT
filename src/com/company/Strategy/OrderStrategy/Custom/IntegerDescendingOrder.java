package com.company.Strategy.OrderStrategy.Custom;

import com.company.Strategy.OrderStrategy.OrderStrategy;

public class IntegerDescendingOrder extends OrderStrategy {
    @Override
    public Boolean check(Object a, Object b) {
        int p1 = (int) a;
        int p2 = (int) b;
        return p1 > p2;
    }
}
