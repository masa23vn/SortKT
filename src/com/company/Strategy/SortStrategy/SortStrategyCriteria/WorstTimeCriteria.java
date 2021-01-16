package com.company.Strategy.SortStrategy.SortStrategyCriteria;

import com.company.Strategy.SortStrategy.Strategy.SortStrategy;

public class WorstTimeCriteria extends SortStrategyCriteria {
    public WorstTimeCriteria(String complexity) {
        super(complexity);
    }

    protected String getInput(SortStrategy strat) {
        return strat.getWorst();
    }
}
