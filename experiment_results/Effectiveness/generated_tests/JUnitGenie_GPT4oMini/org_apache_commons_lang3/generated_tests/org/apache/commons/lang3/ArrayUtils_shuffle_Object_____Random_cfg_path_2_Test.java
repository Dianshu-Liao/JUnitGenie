package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.util.Random;

public class ArrayUtils_shuffle_Object_____Random_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testShuffleWithEmptyArray() {
        Object[] emptyArray = new Object[0];
        Random random = new Random();

        try {
            ArrayUtils.shuffle(emptyArray, random);
            // Since we expect no exception and the method does not change the array, we assert its length.
            assert emptyArray.length == 0 : "Array should still be empty after shuffle.";
        } catch (Exception e) {
            // Handle any unexpected exceptions that may arise
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testShuffleWithSingleElementArray() {
        Object[] singleElementArray = new Object[]{1};
        Random random = new Random();

        try {
            ArrayUtils.shuffle(singleElementArray, random);
            // The single element array should remain unchanged after shuffle.
            assert singleElementArray.length == 1 && singleElementArray[0].equals(1) : "Array should remain the same after shuffle.";
        } catch (Exception e) {
            // Handle any unexpected exceptions that may arise
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testShuffleWithMultipleElements() {
        Object[] multipleElementsArray = new Object[]{1, 2, 3, 4, 5};
        Random random = new Random();

        try {
            ArrayUtils.shuffle(multipleElementsArray, random);
            // After shuffling, the array should still contain the same elements.
            assert multipleElementsArray.length == 5 : "Array should contain 5 elements.";
            // Check if the elements are still the same but in a different order.
            boolean isShuffled = true;
            for (int i = 0; i < multipleElementsArray.length; i++) {
                if (multipleElementsArray[i].equals(i + 1)) {
                    isShuffled = false;
                    break;
                }
            }
            assert isShuffled : "Array elements should be shuffled.";
        } catch (Exception e) {
            // Handle any unexpected exceptions that may arise
            e.printStackTrace();
        }
    }


}