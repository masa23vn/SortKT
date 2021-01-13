package com.company.Strategy.SortStrategy;

import com.company.Strategy.OrderStrategy.OrderStrategy;

import java.util.ArrayList;
import java.util.HashMap;

public class SortStrategy implements Cloneable {
    private static HashMap<String, SortStrategy> sortStrategy = new HashMap<String, SortStrategy>();
    protected OrderStrategy order = OrderStrategy.getStrategy("Ascending");


    static  {
        sortStrategy.put("Interchange", new IntechangeSort());
        sortStrategy.put("Merge", new MergeSort());
    }

    public static SortStrategy getStrategy(String name) {
        try {
            if (sortStrategy.containsKey(name)) {
                return (SortStrategy) sortStrategy.get(name).clone();
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

    public <T> void sort(ArrayList<T> array) {
    }

    public OrderStrategy getOrder() {
        return order;
    }

    public void setOrder(OrderStrategy order) {
        this.order = order;
    }
}
