package org.apache.commons.lang3;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class RandomStringUtils_next_int_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testNextWithNullChars() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        int count = 5;
        String chars = null;

        try {
            String result = randomStringUtils.next(count, chars);
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testNextWithValidChars() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        int count = 5;
        String chars = "abcde";

        try {
            String result = randomStringUtils.next(count, chars);
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

}