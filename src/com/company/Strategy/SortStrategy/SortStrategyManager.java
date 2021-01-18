package com.company.Strategy.SortStrategy;

import com.company.Strategy.SortStrategy.SortStrategyCriteria.SortStrategyCriteria;
import com.company.Strategy.SortStrategy.Strategy.SortStrategyConstant.SortStrategyConstant;
import com.company.Strategy.SortStrategy.Strategy.InterchangeSort;
import com.company.Strategy.SortStrategy.Strategy.MergeSort;
import com.company.Strategy.SortStrategy.Strategy.SortStrategy;

import java.util.HashMap;
import java.util.List;

public class SortStrategyManager {
    private static HashMap<SortStrategyConstant, SortStrategy> sortStrategy = new HashMap<>();
    private static HashMap<String, SortStrategy> customStrategy = new HashMap<>();

    static {
        sortStrategy.put(SortStrategyConstant.INTERCHANGE_SORT, new InterchangeSort());
        sortStrategy.put(SortStrategyConstant.MERGER_SORT, new MergeSort());
    }

    public static SortStrategy getStrategy(String name) {
        try {
            // check default strategy
            SortStrategyConstant sortStrategyConstant = SortStrategyConstant.isValid(name);
            if (sortStrategyConstant != null) {
                System.out.println("strategy: " + sortStrategyConstant.getName());

                if (sortStrategy.containsKey(sortStrategyConstant)) {
                    return (SortStrategy) sortStrategy.get(sortStrategyConstant).clone();
                } else {
                    return null;
                }
            }
            // check custom strategy
            else if (customStrategy.containsKey(name)) {
                return (SortStrategy) customStrategy.get(name).clone();
            } else {
                return null;
            }
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public static SortStrategy getStrategy(List<SortStrategyCriteria> criterias) {
        try {
            int number = criterias.size();
            // check default strategy
            for (SortStrategyConstant stratName : sortStrategy.keySet()) {
                int tempNum = 0;
                for (SortStrategyCriteria criteria : criterias) {
                    if (criteria.Check(sortStrategy.get(stratName))) {
                        tempNum++;
                    }
                }
                if (tempNum == number) {
                    return (SortStrategy) sortStrategy.get(stratName).clone();
                }
            }
            // check custom strategy
            for (String stratName : customStrategy.keySet()) {
                int tempNum = 0;
                for (SortStrategyCriteria criteria : criterias) {
                    if (criteria.Check(customStrategy.get(stratName))) {
                        tempNum++;
                    }
                }
                if (tempNum == number) {
                    return (SortStrategy) customStrategy.get(stratName).clone();
                }
            }
            return null;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public static Boolean setCustomStrategy(String name, SortStrategy strategy) {
        if (SortStrategyConstant.isValid(name) == null) { // check if overlap with default strategy name
            customStrategy.put(name, strategy);
            return true;
        }
        return false;
    }
}
