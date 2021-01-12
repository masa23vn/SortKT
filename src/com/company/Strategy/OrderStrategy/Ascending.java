package com.company.Strategy.OrderStrategy;

public class Ascending extends OrderStrategy {
    @Override
    public Boolean check(Object a, Object b) {
        return (int) a > (int) b;
    }
}
