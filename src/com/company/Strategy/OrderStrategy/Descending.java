package com.company.Strategy.OrderStrategy;

public class Descending extends OrderStrategy {
    @Override
    public Boolean check(Object a, Object b) {
        return (int) a < (int) b;
    }
}
