package com.company.Strategy.OrderStrategy;

import com.company.Strategy.OrderStrategy.Constant.OrderConstant;

import java.util.HashMap;

public class OrderStrategyManager {
    private static HashMap<OrderConstant, OrderStrategy> orderStrategy = new HashMap<OrderConstant, OrderStrategy>();

    static {
        orderStrategy.put(OrderConstant.ASCENDING, new Ascending());
        orderStrategy.put(OrderConstant.DESCENDING, new Descending());
    }

    public static OrderStrategy getStrategy(String name) {
        try {
            OrderConstant orderConstant = OrderConstant.isValid(name);
            System.out.println("Order: " + orderConstant);
            if (orderStrategy.containsKey(orderConstant)) {
                return (OrderStrategy) orderStrategy.get(orderConstant).clone();
            } else {
                return null;
            }
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
