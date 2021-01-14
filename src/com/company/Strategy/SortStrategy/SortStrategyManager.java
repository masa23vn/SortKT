package com.company.Strategy.SortStrategy;

import java.util.HashMap;

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
}
