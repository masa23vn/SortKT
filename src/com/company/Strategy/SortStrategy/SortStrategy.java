package com.company.Strategy.SortStrategy;

import com.company.Strategy.OrderStrategy.OrderStrategy;
import com.company.Strategy.OrderStrategy.OrderStrategyManager;

import java.util.ArrayList;

public class SortStrategy implements Cloneable {
    protected OrderStrategy order = OrderStrategyManager.getStrategy("Ascending");


    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void sort(ArrayList<Object> array) throws ClassCastException {
    }

    public OrderStrategy getOrder() {
        return order;
    }

    public void setOrder(OrderStrategy order) {
        this.order = order;
    }

}
