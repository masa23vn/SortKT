package com.company;

import com.company.SortFactory.SortFactory;
import com.company.Strategy.OrderStrategy.Ascending;
import com.company.Strategy.OrderStrategy.Descending;
import com.company.Strategy.SortStrategy.DefaultSort;
import com.company.Strategy.SortStrategy.MergeSort;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        SortFactory factory = new SortFactory();

        ArrayList array = new ArrayList();
        array.add(5);
        array.add(3);
        array.add(7);
        array.add(8);
        array.add(0);
        array.add(1);

        System.out.println("Accending");
        factory.setSortObject(array);
        factory.setStrategy(new MergeSort());
        factory.setOrder(new Ascending());
        factory.sort();

        for (Object i: array) {
            System.out.println((int) i);
        }
        System.out.println();

        System.out.println("Decending");
        factory.setOrder(new Descending());
        factory.sort();

        for (Object i: array) {
            System.out.println((int) i);
        }

    }
}
