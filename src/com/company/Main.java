package com.company;

import com.company.Class.Person;
import com.company.SortFactory.SortFactory;
import com.company.Strategy.OrderStrategy.Custom.PersonAgeAscending;
import com.company.Strategy.OrderStrategy.Custom.PersonAgeDescending;
import com.company.Strategy.SortStrategy.InterchangeSort;
import com.company.Strategy.SortStrategy.MergeSort;

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

        System.out.println("Ascending");
        factory.setSortObject(array);
        factory.setStrategy("Merge");
        factory.setOrder("Ascending");
        factory.sort();

        for (Object i: array) {
            System.out.println(i);
        }
        System.out.println();

        ArrayList<Person> array2 = new ArrayList();
        array2.add(new Person(1,50));
        array2.add(new Person(1,23));
        array2.add(new Person(1,41));
        array2.add(new Person(1,20));
        array2.add(new Person(1,11));
        array2.add(new Person(1,68));

        System.out.println("Custom object");
        factory.setSortObject(array2);
        factory.setStrategy(new MergeSort());
        factory.setOrder(new PersonAgeAscending());
        factory.sort();

        for (Person i: array2) {
            System.out.println(i);
        }

    }
}
