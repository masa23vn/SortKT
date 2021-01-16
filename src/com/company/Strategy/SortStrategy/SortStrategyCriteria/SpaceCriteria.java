package com.company.Strategy.SortStrategy.SortStrategyCriteria;

import com.company.Strategy.SortStrategy.Strategy.SortStrategy;

public class SpaceCriteria extends SortStrategyCriteria {
    public SpaceCriteria(String complexity) {
        super(complexity);
    }

    protected String getInput(SortStrategy strat) {
        return strat.getSpace();
    }

}
