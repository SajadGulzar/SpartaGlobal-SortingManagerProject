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
    void checkMergeSort() {
        MergeSort mergeSort = new MergeSort();
        boolean isMergeSortWorking = SortCheck.isSorted(mergeSort.sort(randomArray));
        Assertions.assertEquals(true, isMergeSortWorking);
    }

}





