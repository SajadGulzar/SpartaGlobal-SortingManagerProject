package com.spartaglobal.sortManager.Controller;

import com.spartaglobal.sortManager.Model.BubbleSort;
import com.spartaglobal.sortManager.Model.MergeSort;
import com.spartaglobal.sortManager.Model.Sorter;

import java.util.logging.Logger;

public class SortManager {
    public static Logger logger = Logger.getLogger("Sort Manager Logger");
    public static Sorter getSorter(int sorterNumber) {

        return switch (sorterNumber) {
            case 1 -> new BubbleSort();
            case 2 -> new MergeSort();
            default -> null;
        };
    }

}
