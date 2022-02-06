import com.spartaglobal.sortManager.Model.BinaryTree.BinaryTreeSort;
import com.spartaglobal.sortManager.Model.BubbleSort;
import com.spartaglobal.sortManager.Model.MergeSort;
import com.spartaglobal.sortManager.Model.RandomArrayGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSortManager {
    RandomArrayGenerator randomArrayGenerator = new RandomArrayGenerator();
    private final int[] randomArray = randomArrayGenerator.getRandomArray(50);

    @Test
    void checkBubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        boolean isBubbleSortWorking = SortCheck.isSorted(bubbleSort.sort(randomArray));
        Assertions.assertEquals(true, isBubbleSortWorking);
    }

    @Test
    void checkBinaryTreeSort() {
        BinaryTreeSort binaryTreeSort = new BinaryTreeSort();
        boolean isBinaryTreeSortWorking = SortCheck.isSorted(binaryTreeSort.sort(randomArray));
        Assertions.assertEquals(true, isBinaryTreeSortWorking);
    }

    @Test
    void checkMergeSort() {
        MergeSort mergeSort = new MergeSort();
        boolean isMergeSortWorking = SortCheck.isSorted(mergeSort.sort(randomArray));
        Assertions.assertEquals(true, isMergeSortWorking);
    }

    @Test
    void checkGetNumberOfElements() {
        BinaryTreeSort binaryTreeSort = new BinaryTreeSort();
        binaryTreeSort.sort(randomArray);
        int arrayLength = randomArray.length;
        int nodeNumber = binaryTreeSort.getNumberOfElements();
        Assertions.assertEquals(arrayLength, nodeNumber);
    }

    @Test
    void checkGetRootElement() {
        BinaryTreeSort binaryTreeSort = new BinaryTreeSort();
        binaryTreeSort.sort(randomArray);
        int firstValue = randomArray[0];
        int rootNodeValue = binaryTreeSort.getRootElement();
        Assertions.assertEquals(rootNodeValue, firstValue);
    }


}





