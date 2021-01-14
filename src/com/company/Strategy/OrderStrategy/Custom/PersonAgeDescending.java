package com.company.Strategy.OrderStrategy.Custom;

import com.company.Class.Person;
import com.company.Strategy.OrderStrategy.OrderStrategy;

public class PersonAgeDescending extends OrderStrategy {
    @Override
    public Boolean check(Object a, Object b) {
        Person p1 = (Person) a;
        Person p2 = (Person) b;
        return p1.getAge() < p2.getAge();
    }
}
