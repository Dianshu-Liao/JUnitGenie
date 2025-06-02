package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;

public class text_WordUtils_isDelimiter_char_char_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsDelimiterWithNonNullDelimiters() {
        try {
            // Access the private static method using reflection
            Method method = WordUtils.class.getDeclaredMethod("isDelimiter", char.class, char[].class);
            method.setAccessible(true);

            char ch = 'a';
            char[] delimiters = {'a', 'b', 'c'};
            boolean result = (boolean) method.invoke(null, ch, delimiters);

            // Assert that the character is found in the delimiters
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}