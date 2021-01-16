package com.company.Strategy.SortStrategy.Strategy.Constant;

public enum AgorithmConstant {
    MERGER_SORT("Merge"),
    INTERCHANGE_SORT("Interchange");

    private String name;

    AgorithmConstant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static AgorithmConstant isValid(String name){
        for (AgorithmConstant al: values()){
            if(al.getName().equals(name))
                return al;
        }
        return null;
    }
}
