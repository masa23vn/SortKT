package com.company.Strategy.OrderStrategy.Constant;

import com.company.Strategy.OrderStrategy.OrderStrategy;
import com.company.Strategy.SortStrategy.Strategy.Constant.AgorithmConstant;

public enum OrderConstant {
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

    OrderConstant(String name) {
        this.name = name;
    }

    public static OrderConstant isValid(String name){
        for (OrderConstant al: values()){
            if(al.getName().equals(name))
                return al;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
