package com.company.Strategy.OrderStrategy;

public class Descending extends OrderStrategy {
    @Override
    public Boolean check(Object a, Object b) throws ClassCastException {
        Comparable p1 = (Comparable) a;
        Comparable p2 = (Comparable) b;
        return p1.compareTo(p2) < 0;
    }
}
