package com.company.Strategy.OrderStrategy.OrderStrategyConstant;

public enum OrderStrategyConstant {
    ASCENDING("Ascending"),
    DESCENDING("Descending"),
    INTEGER_ASCENDING("Integer ascending"),
    INTEGER_DESCENDING("Integer descending"),
    PERSON_AGE_ASCENDING("Age ascending"),
    PERSON_AGE_DESCENDING("Age descending"),
    PERSON_ID_ASCENDING("Id ascending"),
    PERSON_ID_DESCENDING("Id desscending"),
    STRING_ASCENDING("String ascending"),
    STRING_DESCENDING("String desscending");

    private String name;

    OrderStrategyConstant(String name) {
        this.name = name;
    }

    public static OrderStrategyConstant isValid(String name){
        for (OrderStrategyConstant al: values()){
            if(al.getName().equals(name))
                return al;
        }
        return null;
    }

    public String getName() {
        return name;
    }

}
