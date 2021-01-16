package com.company.Strategy.SortStrategy.Constant;

public enum Complexity {
    N("O(N)"),
    N2("O(N^2)"),
    NLOGN("O(Nlog(N))"),
    O1("O(1)"),
    STABLE("STABLE"),
    UNSTABLE("UNSTABLE");

    private final String name;

    private Complexity(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
