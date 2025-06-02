package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;
import static org.junit.Assert.assertEquals;

public class StringUtils_join_Iterator_char_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testJoinWithEmptyIterator() {
        Iterator<?> iterator = Arrays.asList().iterator();
        char separator = ',';
        String result = StringUtils.join(iterator, separator);
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testJoinWithSingleElement() {
        Iterator<?> iterator = Arrays.asList("element").iterator();
        char separator = ',';
        String result = StringUtils.join(iterator, separator);
        assertEquals("element", result);
    }

    @Test(timeout = 4000)
    public void testJoinWithMultipleElements() {
        Iterator<?> iterator = Arrays.asList("one", "two", "three").iterator();
        char separator = ',';
        String result = StringUtils.join(iterator, separator);
        assertEquals("one,two,three", result);
    }

    @Test(timeout = 4000)
    public void testJoinWithNullIterator() {
        Iterator<?> iterator = null;
        char separator = ',';
        String result = StringUtils.join(iterator, separator);
        assertEquals(null, result);
    }

}