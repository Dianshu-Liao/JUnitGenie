package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.util.Random;

public class ArrayUtils_shuffle_Object_____Random_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testShuffle() {
        // Prepare the test data
        Object[] array = {1, 2, 3, 4, 5};
        Random random = new Random();

        // Call the focal method
        try {
            ArrayUtils.shuffle(array, random);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        // Validate the result (the array should be shuffled)
        // Note: Since the shuffle is random, we cannot assert a specific order,
        // but we can check that the length remains the same and all original elements are present.
        assert array.length == 5;
        for (Object element : new Object[]{1, 2, 3, 4, 5}) {
            boolean found = false;
            for (Object shuffledElement : array) {
                if (element.equals(shuffledElement)) {
                    found = true;
                    break;
                }
            }
            assert found : "Element " + element + " not found in shuffled array.";
        }
    }

}