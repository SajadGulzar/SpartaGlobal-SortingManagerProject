package com.spartaglobal.sortManager;

public class SortManager {
    public static Sorter getSorter(int sorterNumber) {

        return switch (sorterNumber) {
            case 1 -> new BubbleSort();
            case 2 -> new MergeSort();
            default -> null;
        };
    }

}
