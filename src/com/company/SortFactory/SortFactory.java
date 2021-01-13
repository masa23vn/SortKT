package com.company.SortFactory;

import com.company.Strategy.OrderStrategy.OrderStrategy;
import com.company.Strategy.SortStrategy.SortStrategy;

import java.util.ArrayList;

public class SortFactory {
	private SortStrategy strategy = null;
	private OrderStrategy order = null;
	private ArrayList sortObject = null;

	public SortFactory() {
		this.strategy = SortStrategy.getStrategy("Interchange");
		this.order = OrderStrategy.getStrategy("Ascending");
	}

	public ArrayList getSortObject() {
		return sortObject;
	}

	public void sort() {
		strategy.setOrder(this.order);
		strategy.sort(sortObject);
	}


	public void setSortObject(ArrayList sortObject) {
		this.sortObject = sortObject;
	}

	public void setStrategy(String name) {
		this.strategy = SortStrategy.getStrategy(name);
	}

	public void setStrategy(SortStrategy strategy) {
		this.strategy = strategy;
	}

	public OrderStrategy getOrder() {
		return order;
	}

	public void setOrder(String name) {
		this.order = OrderStrategy.getStrategy(name);
	}

	public void setOrder(OrderStrategy order) {
		this.order = order;
	}

}

