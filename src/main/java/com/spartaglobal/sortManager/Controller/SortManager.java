package com.spartaglobal.sortManager.Controller;

import com.spartaglobal.sortManager.Model.BubbleSort;
import com.spartaglobal.sortManager.Model.MergeSort;
import com.spartaglobal.sortManager.Model.Sorter;

public class SortManager {
    public static Sorter getSorter(int sorterNumber) {

        return switch (sorterNumber) {
            case 1 -> new BubbleSort();
            case 2 -> new MergeSort();
            default -> null;
        };
    }

}
