package com.spartaglobal.sortManager;

import com.spartaglobal.sortManager.Controller.SortManager;
import com.spartaglobal.sortManager.Model.RandomArrayGenerator;
import com.spartaglobal.sortManager.Model.Sorter;
import com.spartaglobal.sortManager.View.Printer;
import com.spartaglobal.sortManager.View.QuestionOne;
import com.spartaglobal.sortManager.View.QuestionTwo;

public class Loader {
    public void run() {
        QuestionOne questionOne = new QuestionOne();
        int arrayNumber = questionOne.questionOneMethod();

        QuestionTwo questionTwo = new QuestionTwo();
        int sortChoice = questionTwo.questionTwoMethod();

        int[] randomArray = RandomArrayGenerator.getRandomArray(arrayNumber);
        int[] randomArrayCopy = new int [randomArray.length];
        for(int i = 0; i < randomArray.length; i++) {
            randomArrayCopy[i] = randomArray[i];
        }

        Sorter chosenSort = SortManager.getSorter(sortChoice);
        String className = chosenSort.getClass().getSimpleName();

        long startTime = System.nanoTime();
        int[] sortedArray = chosenSort.sort(randomArray);
        long endTime = System.nanoTime();
        long sortDuration = endTime - startTime;

        Printer printer = new Printer(randomArrayCopy, className, sortedArray, sortDuration);
        printer.printResult();
    }
}
