package com.spartaglobal.sortManager.Controller;

import com.spartaglobal.sortManager.Model.BinaryTree.BinaryTreeSort;
import com.spartaglobal.sortManager.Model.BubbleSort;
import com.spartaglobal.sortManager.Model.MergeSort;
import com.spartaglobal.sortManager.Model.Sorter;
import org.apache.log4j.Logger;


public class SortManager {
    public static Logger logger = Logger.getLogger("Sort Manager Logger");
    public static Sorter getSorter(int sorterNumber) {

        return switch (sorterNumber) {
            case 1 -> new BubbleSort();
            case 2 -> new BinaryTreeSort();
            case 3 -> new MergeSort();
            default -> null;
        };
    }

    public static void logExecutionTime(long startTime) {
        long endTime = System.nanoTime();
        long executionNanoTime = endTime - startTime;
        StringBuilder stringBuilder = new StringBuilder("Execution time: ");
        stringBuilder.append(executionNanoTime);
        stringBuilder.append("ns | ");
        stringBuilder.append(executionNanoTime * 0.000000001);
        stringBuilder.append("s");
        logger.info(stringBuilder.toString());
    }

}
