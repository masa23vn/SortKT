package com.company.Strategy.SortStrategy;

import com.company.Strategy.SortStrategy.SortStrategyCriteria.SortStrategyCriteria;
import com.company.Strategy.SortStrategy.Strategy.Constant.AgorithmConstant;
import com.company.Strategy.SortStrategy.Strategy.InterchangeSort;
import com.company.Strategy.SortStrategy.Strategy.MergeSort;
import com.company.Strategy.SortStrategy.Strategy.SortStrategy;

import java.util.HashMap;
import java.util.List;

public class SortStrategyManager {
    private static HashMap<AgorithmConstant, SortStrategy> sortStrategy = new HashMap<>();
    private static HashMap<String, SortStrategy> customStrategy = new HashMap<>();

    static {
        sortStrategy.put(AgorithmConstant.INTERCHANGE_SORT, new InterchangeSort());
        sortStrategy.put(AgorithmConstant.MERGER_SORT, new MergeSort());
    }

    public static SortStrategy getStrategy(String name) {
        try {
            // check default strategy
            AgorithmConstant agorithmConstant = AgorithmConstant.isValid(name);
            if (agorithmConstant != null) {
                System.out.println("strategy: " + agorithmConstant.getName());

                if (sortStrategy.containsKey(agorithmConstant)) {
                    return (SortStrategy) sortStrategy.get(agorithmConstant).clone();
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
            for (AgorithmConstant stratName : sortStrategy.keySet()) {
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
        if (AgorithmConstant.isValid(name) == null) { // check if overlap with default strategy name
            customStrategy.put(name, strategy);
            return true;
        }
        return false;
    }
}
