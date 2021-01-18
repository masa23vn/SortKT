package com.company.Strategy.OrderStrategy;

import com.company.Strategy.OrderStrategy.Constant.OrderConstant;
import com.company.Strategy.SortStrategy.Strategy.Constant.AgorithmConstant;
import com.company.Strategy.SortStrategy.Strategy.SortStrategy;

import java.util.HashMap;

public class OrderStrategyManager {
    private static HashMap<OrderConstant, OrderStrategy> orderStrategy = new HashMap<OrderConstant, OrderStrategy>();
    private static HashMap<String, OrderStrategy> customStrategy = new HashMap<String, OrderStrategy>();

    static {
        orderStrategy.put(OrderStrategyConstant.ASCENDING, new Ascending());
        orderStrategy.put(OrderStrategyConstant.DESCENDING, new Descending());
        orderStrategy.put(OrderStrategyConstant.PERSON_AGE_ASCENDING, new PersonAgeAscending());
        orderStrategy.put(OrderStrategyConstant.PERSON_AGE_DESCENDING, new PersonAgeDescending());
        orderStrategy.put(OrderStrategyConstant.PERSON_ID_ASCENDING, new PersonIdAscending());
        orderStrategy.put(OrderStrategyConstant.PERSON_ID_DESCENDING, new PersonIdDescending());
        orderStrategy.put(OrderStrategyConstant.STRING_ASCENDING, new StringOrderAscending());
        orderStrategy.put(OrderStrategyConstant.STRING_DESCENDING, new StringOrderDescending());
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
