package com.company;

import com.company.Class.Person;
import com.company.SortFactory.SortFactory;
import com.company.Strategy.OrderStrategy.OrderStrategyConstant.OrderStrategyConstant;
import com.company.Strategy.OrderStrategy.Custom.*;
import com.company.Strategy.SortStrategy.Constant.Complexity;
import com.company.Strategy.SortStrategy.SortStrategyCriteria.*;
import com.company.Strategy.SortStrategy.Strategy.SortStrategyConstant.SortStrategyConstant;
import com.company.Strategy.SortStrategy.Strategy.Custom.*;

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
        factory.setStrategy(SortStrategyConstant.MERGER_SORT.getName());
        factory.setOrder(OrderStrategyConstant.DESCENDING.getName());
        factory.sort();

        for (Object i: array) {
            System.out.println(i);
        }
        System.out.println();

        ArrayList<Person> array2 = new ArrayList();
        array2.add(new Person(1,50, "John1"));
        array2.add(new Person(2,23, "John2"));
        array2.add(new Person(3,41, "John3"));
        array2.add(new Person(4,20, "John4"));
        array2.add(new Person(5,11, "John5"));
        array2.add(new Person(6,68, "John6"));

        System.out.println("Custom object");
        System.out.println("set custom function to sortFactory");
        factory.setSortObject(array2);
        factory.setOrder(OrderStrategyConstant.PERSON_AGE_ASCENDING.getName());

        ArrayList<SortStrategyCriteria> check = new ArrayList<>();
        check.add(new BestTimeCriteria(Complexity.NLOGN.getName()));
        factory.setStrategy(check);
        System.out.println("Using " + factory.getStrategy());
        System.out.println("Using " + factory.getOrder());

        factory.sort();
        for (Person i: array2) {
            System.out.println(i);
        }
        System.out.println();


        System.out.println("add custom function to various manager class");
        factory.addCustomSortStrategy("customInterchange",new customInterchange());
        ArrayList<SortStrategyCriteria> check2 = new ArrayList<>();
        check2.add(new BestTimeCriteria("o(1)"));
        check2.add(new WorstTimeCriteria("o(1)"));
        factory.setStrategy(check2);

        factory.addCustomOrderStrategy("idDescending", new PersonIdDescending());
        factory.setOrder("idDescending");

        System.out.println("Using " + factory.getStrategy());
        System.out.println("Using " + factory.getOrder());

        factory.sort();
        for (Person i: array2) {
            System.out.println(i);
        }
    }
}
