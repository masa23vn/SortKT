package com.company.Strategy.SortStrategy.Strategy.Custom;

import com.company.Strategy.SortStrategy.Constant.Complexity;
import com.company.Strategy.SortStrategy.Strategy.SortStrategy;

import java.util.ArrayList;

public class customInterchange extends SortStrategy {
    public customInterchange() {
        this.infos.put("best", Complexity.O1);
        this.infos.put("average", Complexity.O1);
        this.infos.put("worst", Complexity.O1);
        this.infos.put("space", Complexity.O1);
        this.infos.put("stability", Complexity.STABLE);
    }

    @Override
    public void sort(ArrayList<Object> array) throws ClassCastException {
        for (int i = 0; i < array.size(); i++) {
            for (int j = i + 1; j < array.size(); j++) {
                if (this.order.check(array.get(i), array.get(j))) {
                    Object temp = array.get(i);
                    array.set(i, array.get(j));
                    array.set(j, temp);
                }
            }
        }
    }
}
