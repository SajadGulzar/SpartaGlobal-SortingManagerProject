package com.spartaglobal.sortManager.Model.BinaryTree;

import com.spartaglobal.sortManager.Model.Sorter;
import com.spartaglobal.sortManager.Model.ValueNotFoundException;

public class BinaryTreeSort implements Sorter, BinaryTreeInterface {
    private Node rootNode;
    private int[] arrayToSort;
    private int indexAsc;

    public BinaryTreeSort() {
    }

    @Override
    public int[] sort(int[] arrayToSort) {
        rootNode = new Node(arrayToSort[0]);
        this.arrayToSort = arrayToSort;
        addElements(arrayToSort);
        return getSortedTreeAsc();
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public void addElement(final int element) {
        addNodeToTree(rootNode, element);
    }

    @Override
    public void addElements(final int[] arrayToSort) {
        int index = 1;
        addNodesToTree(arrayToSort);
    }

    @Override
    public int getNumberOfElements() {
        return nodeNum(rootNode);
    }

    private int nodeNum(Node rootNode) {
        if (rootNode == null)
            return 0;
        return 1 + nodeNum(rootNode.getLeft()) + nodeNum(rootNode.getRight());
    }

    @Override
    public boolean findElement(final int value) {
        Node node = findNode(value);
        if(node != null) {
            try {
                getLeft(value);
                getRight(value);
            } catch (ValueNotFoundException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    @Override
    public int getLeft(int element) throws ValueNotFoundException {
        Node node = findNode(element);
        if(node.getLeft() == null) {
            throw new ValueNotFoundException("This Node has no value in Left");
        }
        return node.getRight().getValue();

    }

    @Override
    public int getRight(int element) throws ValueNotFoundException {
        Node node = findNode(element);
        if(node.getRight() == null) {
            throw new ValueNotFoundException("This Node has no value in Right");
        }
        return node.getRight().getValue();
    }

    private Node findNode(int element) {
        Node node = rootNode;
        while(node != null) {
            if(element == node.getValue()) {
                return node;
            }
            if(element < node.getValue()) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return null;
    }

    private void addNodeToTree(Node node, int element) {
        if(element == node.getValue()) return;

        if(element < node.getValue()) {
            if(node.isLeftEmpty()) {
                node.setLeft(new Node(element));
            } else {
                addNodeToTree(node.getLeft(), element);
            }
        } else if(element > node.getValue()) {
            if(node.isRightEmpty()) {
                node.setRight(new Node(element));
            } else {
                addNodeToTree(node.getRight(), element);
            }
        }
    }

    private void addNodesToTree(int[] arrayToAdd) {
        int index = 1;
        Node node = rootNode;
        for(int i = 1; i < arrayToAdd.length; i++) {
            NewNodeSet:
            do {
                if (arrayToAdd[i] < node.getValue()) {
                    if (node.isLeftEmpty()) {
                        node.setLeft(new Node(arrayToAdd[i]));
                        i++; index++; node = rootNode;
                    } else {
                        node = node.getLeft();
                        continue NewNodeSet;
                    }
                } else if (arrayToAdd[i] > node.getValue()) {
                    if (node.isRightEmpty()) {
                        node.setRight(new Node(arrayToAdd[i]));
                        i++; index++; node = rootNode;
                    } else {
                        node = node.getRight();
                        continue NewNodeSet;
                    }
                } else if(arrayToAdd[i] == node.getValue()) {
                    if (node.isLeftEmpty()) {
                        node.setLeft(new Node(arrayToAdd[i]));
                        i++; index++; node = rootNode;
                    } else {
                        node = node.getLeft();
                        continue NewNodeSet;
                    }
                }
            } while(index < arrayToAdd.length);
        }
    }

    @Override
    public int[] getSortedTreeAsc() {
        int[] sortedArrayToFill = new int[arrayToSort.length];
        return returnAscendingTree(sortedArrayToFill, rootNode);
    }

    @Override
    public int[] getSortedTreeDesc() {
        int[] sortedArrayToFill = new int[arrayToSort.length];
        return returnDescendingTree(sortedArrayToFill, rootNode);
    }

    public int[] returnAscendingTree(int[] sortedArray, Node node) {
        if (!node.isLeftEmpty()) {
            returnAscendingTree(sortedArray, node.getLeft());
        }
        sortedArray[indexAsc] = node.getValue();
        indexAsc += 1;
        if (!node.isRightEmpty()) {
            returnAscendingTree(sortedArray, node.getRight());
        }
        return sortedArray;
    }

    public int[] returnDescendingTree(int[] sortedArray, Node node) {
        if (!node.isRightEmpty()) {
            returnDescendingTree(sortedArray, node.getRight());
        }
        sortedArray[indexAsc] = node.getValue();
        indexAsc += 1;
        if (!node.isLeftEmpty()) {
            returnDescendingTree(sortedArray, node.getLeft());
        }
        return sortedArray;
    }

}
