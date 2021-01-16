package com.company;

import com.company.Class.Person;
import com.company.SortFactory.SortFactory;
import com.company.Strategy.OrderStrategy.OrderStrategyConstant.OrderStrategyConstant;
import com.company.Strategy.OrderStrategy.Custom.PersonAgeAscending;
import com.company.Strategy.SortStrategy.Constant.Complexity;
import com.company.Strategy.SortStrategy.SortStrategyCriteria.BestTimeCriteria;
import com.company.Strategy.SortStrategy.SortStrategyCriteria.SortStrategyCriteria;
import com.company.Strategy.SortStrategy.Strategy.AlgorithmsStrategyConstant.AlgorithmsStrategyConstant;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        SortFactory factory = SortFactory.getInstance();

        ArrayList array = new ArrayList();
        array.add(5.9);
        array.add(3.5);
        array.add(7.6);
        array.add(8.8);
        array.add(0.6);
        array.add(1.4);

        System.out.println(OrderStrategyConstant.DESCENDING);
        factory.setSortObject(array);
        factory.setStrategy(AlgorithmsStrategyConstant.MERGER_SORT.getName());
        factory.setOrder(OrderStrategyConstant.DESCENDING.getName());
        factory.sort();

        for (Object i: array) {
            System.out.println(i);
        }
        System.out.println();

        ArrayList<Person> array2 = new ArrayList();
        array2.add(new Person(1,50, "John"));
        array2.add(new Person(1,23, "John"));
        array2.add(new Person(1,41, "John"));
        array2.add(new Person(1,20, "John"));
        array2.add(new Person(1,11, "John"));
        array2.add(new Person(1,68, "John"));

        System.out.println("Custom object");
        factory.setSortObject(array2);
        factory.setOrder(OrderStrategyConstant.PERSON_AGE_ASCENDING.getName());

        ArrayList<SortStrategyCriteria> check = new ArrayList<>();
        check.add(new BestTimeCriteria(Complexity.NLOGN.getName()));
        factory.setStrategy(check);
        System.out.println(factory.getStrategy());

        factory.sort();
        for (Person i: array2) {
            System.out.println(i);
        }
    }
}
