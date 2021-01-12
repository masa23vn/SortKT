package com.company;

import com.company.SortFactory.SortFactory;
import com.company.Strategy.OrderStrategy.Ascending;
import com.company.Strategy.OrderStrategy.Descending;
import com.company.Strategy.SortStrategy.DefaultSort;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        SortFactory factory = new SortFactory();

        ArrayList array = new ArrayList();
        array.add(5.9);
        array.add(3.5);
        array.add(7.6);
        array.add(8.8);
        array.add(0.6);
        array.add(1.4);

        factory.setSortObject(array);
        factory.setStrategy(new DefaultSort());
        factory.setOrder(new Ascending());
        factory.sort();

        for (Object i: array) {
            System.out.println(i);
        }
        System.out.println();

        factory.setOrder(new Descending());
        factory.sort();

        for (Object i: array) {
            System.out.println(i);
        }

    }
}
