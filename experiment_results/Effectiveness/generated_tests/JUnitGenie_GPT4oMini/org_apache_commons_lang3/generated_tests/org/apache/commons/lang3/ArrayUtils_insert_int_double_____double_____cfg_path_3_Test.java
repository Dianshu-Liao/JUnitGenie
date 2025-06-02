package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_insert_int_double_____double_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testInsertThrowsIndexOutOfBoundsException() {
        double[] array = {1.0, 2.0, 3.0};
        double[] values = {4.0, 5.0};

        try {
            // This should throw an IndexOutOfBoundsException
            ArrayUtils.insert(-1, array, values);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: -1, Length: 3", e.getMessage());
        }

        try {
            // This should also throw an IndexOutOfBoundsException
            ArrayUtils.insert(4, array, values);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index: 4, Length: 3", e.getMessage());
        }
    }

}