package com.company.Strategy.OrderStrategy;

import com.company.Strategy.OrderStrategy.Custom.*;
import com.company.Strategy.OrderStrategy.OrderStrategyConstant.OrderStrategyConstant;

import java.util.HashMap;

public class OrderStrategyManager {
    private static HashMap<OrderStrategyConstant, OrderStrategy> orderStrategy = new HashMap<OrderStrategyConstant, OrderStrategy>();

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
            OrderStrategyConstant orderConstant = OrderStrategyConstant.isValid(name);
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
