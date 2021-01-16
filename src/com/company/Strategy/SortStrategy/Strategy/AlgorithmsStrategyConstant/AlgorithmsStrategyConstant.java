package com.company.Strategy.SortStrategy.Strategy.AlgorithmsStrategyConstant;

public enum AlgorithmsStrategyConstant {
    MERGER_SORT("Merge"),
    INTERCHANGE_SORT("Interchange");

    private String name;

    AlgorithmsStrategyConstant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static AlgorithmsStrategyConstant isValid(String name){
        for (AlgorithmsStrategyConstant al: values()){
            if(al.getName().equals(name))
                return al;
        }
        return null;
    }
}
