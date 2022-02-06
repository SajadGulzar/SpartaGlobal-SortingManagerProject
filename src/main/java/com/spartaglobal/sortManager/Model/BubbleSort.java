package com.spartaglobal.sortManager.Model;

public class BubbleSort implements Sorter {

    @Override
        public int[] sort(int[] arrayToSort) {
            return sortArray(arrayToSort);
        }

        @Override
        public int getLeft(int element) throws ValueNotFoundException {
        return 0;
        }

        public int[] sortArray(int[] randomArray) {
            int arrLength = randomArray.length;
            for(int i=0; i < arrLength; i++) {
                for (int j=0; j < arrLength - i - 1; j++) { // j = i
                    if(randomArray[j] > (randomArray[j+1])) {
                        int holdNum = randomArray[j];
                        randomArray[j] = randomArray[j+1];
                        randomArray[j+1] = holdNum;
                    }
                }
            }
            return randomArray;
        }
    }



