package com.company.Strategy.SortStrategy.Strategy.SortStrategyConstant;

public enum SortStrategyConstant {
    MERGER_SORT("Merge"),
    INTERCHANGE_SORT("Interchange");

    private String name;

    SortStrategyConstant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static SortStrategyConstant isValid(String name){
        for (SortStrategyConstant al: values()){
            if(al.getName().equals(name))
                return al;
        }
        return null;
    }
}
