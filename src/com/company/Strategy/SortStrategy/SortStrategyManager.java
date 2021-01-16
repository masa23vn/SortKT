package com.company.Strategy.SortStrategy;

import com.company.Strategy.SortStrategy.SortStrategyCriteria.SortStrategyCriteria;
import com.company.Strategy.SortStrategy.Strategy.InterchangeSort;
import com.company.Strategy.SortStrategy.Strategy.MergeSort;
import com.company.Strategy.SortStrategy.Strategy.SortStrategy;

import java.util.HashMap;
import java.util.List;

public class SortStrategyManager {
    private static HashMap<String, SortStrategy> sortStrategy = new HashMap<String, SortStrategy>();

    static  {
        sortStrategy.put("Interchange", new InterchangeSort());
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
    public static SortStrategy getStrategy(List<SortStrategyCriteria> criterias) {
        try {
            int number = criterias.size();
            for (String stratName : sortStrategy.keySet()) {
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
            return null;
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
