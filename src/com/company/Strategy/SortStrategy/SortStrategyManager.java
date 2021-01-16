package com.company.Strategy.SortStrategy;

import com.company.Strategy.SortStrategy.SortStrategyCriteria.SortStrategyCriteria;
import com.company.Strategy.SortStrategy.Strategy.AlgorithmsStrategyConstant.AlgorithmsStrategyConstant;
import com.company.Strategy.SortStrategy.Strategy.InterchangeSort;
import com.company.Strategy.SortStrategy.Strategy.MergeSort;
import com.company.Strategy.SortStrategy.Strategy.SortStrategy;

import java.util.HashMap;
import java.util.List;

public class SortStrategyManager {
    private static HashMap<AlgorithmsStrategyConstant, SortStrategy> sortStrategy = new HashMap<>();

    static  {
        sortStrategy.put(AlgorithmsStrategyConstant.INTERCHANGE_SORT, new InterchangeSort());
        sortStrategy.put(AlgorithmsStrategyConstant.MERGER_SORT, new MergeSort());
    }

    public static SortStrategy getStrategy(String name) {
        try {
            AlgorithmsStrategyConstant agorithmConstant = AlgorithmsStrategyConstant.isValid(name);
            System.out.println("strategy: " + agorithmConstant.getName());

            if (sortStrategy.containsKey(agorithmConstant)) {
                return (SortStrategy) sortStrategy.get(agorithmConstant).clone();
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
            for (AlgorithmsStrategyConstant stratName : sortStrategy.keySet()) {
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
