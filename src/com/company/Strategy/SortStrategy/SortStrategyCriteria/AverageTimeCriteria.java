package com.company.Strategy.SortStrategy.SortStrategyCriteria;

import com.company.Strategy.SortStrategy.Strategy.SortStrategy;

public class AverageTimeCriteria extends SortStrategyCriteria {
    public AverageTimeCriteria(String complexity) {
        super(complexity);
    }

    protected String getInput(SortStrategy strat) {
        return strat.getAverage();
    }

}
