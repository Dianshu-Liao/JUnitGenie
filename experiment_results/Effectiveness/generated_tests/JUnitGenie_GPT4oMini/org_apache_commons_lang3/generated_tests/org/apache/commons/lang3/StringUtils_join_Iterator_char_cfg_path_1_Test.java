package org.apache.commons.lang3;
import static org.junit.Assert.assertEquals;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;

public class StringUtils_join_Iterator_char_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testJoin_withValidIterator() {
        Iterator<String> iterator = Arrays.asList("Hello", "World").iterator();
        char separator = ',';
        String expected = "Hello,World";
        String result = StringUtils.join(iterator, separator);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testJoin_withEmptyIterator() {
        // Corrected the type of the list to be of type String
        Iterator<String> iterator = Arrays.<String>asList().iterator();
        char separator = ',';
        String expected = "";
        String result = StringUtils.join(iterator, separator);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testJoin_withNullIterator() {
        Iterator<String> iterator = null;
        char separator = ',';
        String result = StringUtils.join(iterator, separator);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testJoin_withOneElementIterator() {
        Iterator<String> iterator = Arrays.asList("Single").iterator();
        char separator = ',';
        String expected = "Single";
        String result = StringUtils.join(iterator, separator);
        assertEquals(expected, result);
    }


}