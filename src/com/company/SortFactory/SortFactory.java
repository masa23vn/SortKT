package com.company.SortFactory;

import com.company.Strategy.OrderStrategy.OrderStrategyConstant.OrderStrategyConstant;
import com.company.Strategy.OrderStrategy.OrderStrategy;
import com.company.Strategy.OrderStrategy.OrderStrategyManager;
import com.company.Strategy.SortStrategy.SortStrategyCriteria.SortStrategyCriteria;
import com.company.Strategy.SortStrategy.Strategy.SortStrategyConstant.SortStrategyConstant;
import com.company.Strategy.SortStrategy.Strategy.SortStrategy;
import com.company.Strategy.SortStrategy.SortStrategyManager;

import java.util.ArrayList;
import java.util.List;

public class SortFactory {
	private static volatile SortFactory instance;

	private Attribute attribute = new Attribute();

	private SortFactory() {
		attribute.setAttribute("Strategy",  SortStrategyManager.getStrategy(SortStrategyConstant.INTERCHANGE_SORT.getName()));
		attribute.setAttribute("Order",  OrderStrategyManager.getStrategy(OrderStrategyConstant.ASCENDING.getName()));
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
		attribute.setAttribute("Strategy", SortStrategyManager.getStrategy(name));
	}

	public void setStrategy(SortStrategy strategy) {
		attribute.setAttribute("Strategy", strategy);
	}

	public void setStrategy(List<SortStrategyCriteria> criteria) {
		attribute.setAttribute("Strategy", SortStrategyManager.getStrategy(criteria));
	}

	public void addCustomSortStrategy(String name, SortStrategy strategy) {
		SortStrategyManager.setCustomStrategy(name, strategy);
	}

	public OrderStrategy getOrder() {
		return (OrderStrategy) attribute.getAttribute("Order");
	}

	public void setOrder(String name) {
		attribute.setAttribute("Order", OrderStrategyManager.getStrategy(name));
	}

	public void setOrder(OrderStrategy order) {
		attribute.setAttribute("Order", order);
	}

	public void addCustomOrderStrategy(String name, OrderStrategy strategy) {
		OrderStrategyManager.setCustomStrategy(name, strategy);
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
				try {
					strategy.sort(object);
					return true;
				}
				catch (ClassCastException e) {
					System.out.println("ERROR: Need custom order method for class\n       " + e.getMessage());
				}
			}
		}
		return false;
	}
}

