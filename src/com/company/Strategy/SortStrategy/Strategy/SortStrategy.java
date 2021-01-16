package com.company.Strategy.SortStrategy.Strategy;

import com.company.Strategy.OrderStrategy.OrderStrategyConstant.OrderStrategyConstant;
import com.company.Strategy.OrderStrategy.OrderStrategy;
import com.company.Strategy.OrderStrategy.OrderStrategyManager;
import com.company.Strategy.SortStrategy.Constant.Complexity;

import java.util.ArrayList;
import java.util.HashMap;

public class SortStrategy implements Cloneable {
    protected OrderStrategy order = OrderStrategyManager.getStrategy(OrderStrategyConstant.ASCENDING.getName());
    protected HashMap<String, Complexity> infos = new HashMap<String, Complexity>();

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

    public String getBest() {
        Complexity complexity = infos.get("best");
        if (complexity != null) {
            return complexity.getName();
        }
        return null;
    }
    public String getAverage() {
        Complexity complexity = infos.get("average");
        if (complexity != null) {
            return complexity.getName();
        }
        return null;
    }
    public String getWorst() {
        Complexity complexity = infos.get("worst");
        if (complexity != null) {
            return complexity.getName();
        }
        return null;
    }
    public String getSpace() {
        Complexity complexity = infos.get("space");
        if (complexity != null) {
            return complexity.getName();
        }
        return null;
    }
    public String getStability() {
        Complexity complexity = infos.get("stability");
        if (complexity != null) {
            return complexity.getName();
        }
        return null;
    }

}
