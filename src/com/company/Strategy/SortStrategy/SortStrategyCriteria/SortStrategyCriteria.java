package com.company.Strategy.SortStrategy.SortStrategyCriteria;

import com.company.Strategy.SortStrategy.Strategy.SortStrategy;

public class SortStrategyCriteria {
    protected String complexity;
    public SortStrategyCriteria(String complexity) {
        this.complexity = complexity;
    }


    public Boolean Check(SortStrategy strat) {
        String input = getInput(strat).toLowerCase();
        String value = this.complexity.toLowerCase();

        if (input.equals(value)) {
            return true;
        }
        return false;
    }

    protected String getInput(SortStrategy strat) {
        return "";
    }
}
