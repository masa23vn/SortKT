package com.company.Strategy.OrderStrategy.CustomCheck;

import com.company.Class.Person;

public class PersonAgeDescending extends CustomCheck {
    @Override
    public <Object> Boolean checkCustom(Object a, Object b) {
        Person p1 = (Person) a;
        Person p2 = (Person) b;
        return p1.getAge() < p2.getAge();
    }
}
