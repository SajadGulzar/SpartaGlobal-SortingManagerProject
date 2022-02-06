package com.spartaglobal.sortManager.Model.BinaryTree;

import com.spartaglobal.sortManager.Model.ValueNotFoundException;

public interface BinaryTreeInterface {
    int getRootElement();

    int getNumberOfElements();

    void addElement(int element);

    void addElements(int[] elements);

    boolean findElement(int value) throws ValueNotFoundException;

    int getLeft(int element) throws ValueNotFoundException;

    int getRight(int element) throws ValueNotFoundException;

    int[] getSortedTreeAsc();

    int[] getSortedTreeDesc();
}
