package com.company.Strategy.SortStrategy.SortStrategyCriteria;

import com.company.Strategy.SortStrategy.Strategy.SortStrategy;

public class BestTimeCriteria extends SortStrategyCriteria {
    public BestTimeCriteria(String complexity) {
        super(complexity);
    }

    protected String getInput(SortStrategy strat) {
        return strat.getBest();
    }

}
