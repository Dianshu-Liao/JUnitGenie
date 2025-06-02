package org.apache.commons.lang3;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class RandomStringUtils_next_int_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNextWithValidParameters() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        int count = 10; // Valid integer
        String chars = "abcde"; // Valid character string

        try {
            String result = randomStringUtils.next(count, chars);
            assertNotNull(result);
            // Additional assertions can be added to verify the result further
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testNextWithNullChars() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        int count = 5; // Valid integer
        String chars = null; // Null character string

        try {
            String result = randomStringUtils.next(count, chars);
            assertNotNull(result);
            // Additional assertions can be added to verify the result further
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}