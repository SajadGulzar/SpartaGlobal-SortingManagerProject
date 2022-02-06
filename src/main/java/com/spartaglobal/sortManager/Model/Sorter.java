package com.spartaglobal.sortManager.Model;

import com.spartaglobal.sortManager.View.ValueNotFoundException;

public interface Sorter {
    int[] sort(int[] arrayToSort);

    int getLeft(int element) throws ValueNotFoundException;

}
