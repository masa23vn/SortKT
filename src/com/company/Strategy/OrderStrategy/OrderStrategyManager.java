package com.company.Strategy.OrderStrategy;

import com.company.Strategy.OrderStrategy.Constant.OrderConstant;
import com.company.Strategy.SortStrategy.Strategy.Constant.AgorithmConstant;
import com.company.Strategy.SortStrategy.Strategy.SortStrategy;

import java.util.HashMap;

public class OrderStrategyManager {
    private static HashMap<OrderConstant, OrderStrategy> orderStrategy = new HashMap<OrderConstant, OrderStrategy>();
    private static HashMap<String, OrderStrategy> customStrategy = new HashMap<String, OrderStrategy>();

    static {
        orderStrategy.put(OrderConstant.ASCENDING, new Ascending());
        orderStrategy.put(OrderConstant.DESCENDING, new Descending());
    }

    public static OrderStrategy getStrategy(String name) {
        try {
            OrderConstant orderConstant = OrderConstant.isValid(name);
            if (orderConstant != null) {
                System.out.println("strategy: " + orderConstant.getName());
                if (orderStrategy.containsKey(orderConstant)) {
                    return (OrderStrategy) orderStrategy.get(orderConstant).clone();
                }
                else {
                    return null;
                }
            }
            // check custom strategy
            else if (customStrategy.containsKey(name)) {
                return (OrderStrategy) customStrategy.get(name).clone();
            }
            else {
                return null;
            }

        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public static Boolean setCustomStrategy(String name, OrderStrategy strategy) {
        if (AgorithmConstant.isValid(name) == null) { // check if overlap with default strategy name
            customStrategy.put(name, strategy);
            return true;
        }
        return false;
    }

}
