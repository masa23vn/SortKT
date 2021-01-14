package com.company.SortFactory;

import com.company.Strategy.OrderStrategy.OrderStrategy;
import com.company.Strategy.SortStrategy.SortStrategy;

import java.util.ArrayList;

public class SortFactory {
	private static volatile SortFactory instance;

	private Attribute attribute = new Attribute();

	private SortFactory() {
		attribute.setAttribute("Strategy",  SortStrategy.getStrategy("Interchange"));
		attribute.setAttribute("Order",  SortStrategy.getStrategy("Interchange"));
	}

	public static SortFactory getInstance() {
		SortFactory result = instance;
		if (result != null) {
			return result;
		}
		synchronized(SortFactory.class) {
			if (instance == null) {
				instance = new SortFactory();
			}
			return instance;
		}
	}

	public ArrayList getSortObject() {
		return (ArrayList) attribute.getAttribute("Object");
	}

	public void setSortObject(ArrayList sortObject) {
		attribute.setAttribute("Object",  sortObject);
	}

	public SortStrategy getStrategy() {
		return (SortStrategy) attribute.getAttribute("Strategy");
	}

	public void setStrategy(String name) {
		attribute.setAttribute("Strategy", SortStrategy.getStrategy(name));
	}

	public void setStrategy(SortStrategy strategy) {
		attribute.setAttribute("Strategy", strategy);
	}

	public OrderStrategy getOrder() {
		return (OrderStrategy) attribute.getAttribute("Order");
	}

	public void setOrder(String name) {
		attribute.setAttribute("Order", OrderStrategy.getStrategy(name));
	}

	public void setOrder(OrderStrategy order) {
		attribute.setAttribute("Order", order);
	}

	public Boolean sort() {
		SortStrategy strategy = getStrategy();
		OrderStrategy order = getOrder();
		ArrayList object = getSortObject();

		if (strategy != null) {
			if (order != null) {
				strategy.setOrder(order);
			}
			if (object != null) {
				strategy.sort(object);
				return true;
			}
		}
		return false;
	}
}

