package com.company.Strategy.SortStrategy.SortStrategyCriteria;

import com.company.Strategy.SortStrategy.Strategy.SortStrategy;

public class StabilityCriteria extends SortStrategyCriteria {
    public StabilityCriteria(String complexity) {
        super(complexity);
    }

    protected String getInput(SortStrategy strat) {
        return strat.getStability();
    }

}
