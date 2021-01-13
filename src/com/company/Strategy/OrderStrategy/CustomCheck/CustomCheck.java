package com.company.Strategy.OrderStrategy.CustomCheck;

import com.company.Strategy.OrderStrategy.OrderStrategy;

public class CustomCheck extends OrderStrategy {
    @Override
    public <Object> Boolean checkCustom(Object a, Object b) {
        return true;
    }
}
