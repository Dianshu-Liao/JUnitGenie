package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class StringUtils_join_List_char_int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testJoinWithValidParameters() {
        List<String> list = Arrays.asList("a", "b", "c");
        char separator = ',';
        int startIndex = 0;
        int endIndex = 3;

        String result = StringUtils.join(list, separator, startIndex, endIndex);
        assertEquals("a,b,c", result);
    }

    @Test(timeout = 4000)
    public void testJoinWithEmptyList() {
        List<String> list = Arrays.asList();
        char separator = ',';
        int startIndex = 0;
        int endIndex = 0;

        String result = StringUtils.join(list, separator, startIndex, endIndex);
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testJoinWithNullList() {
        List<String> list = null;
        char separator = ',';
        int startIndex = 0;
        int endIndex = 1;

        String result = StringUtils.join(list, separator, startIndex, endIndex);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testJoinWithNegativeNoOfItems() {
        List<String> list = Arrays.asList("a", "b", "c");
        char separator = ',';
        int startIndex = 1;
        int endIndex = 1;

        String result = StringUtils.join(list, separator, startIndex, endIndex);
        assertEquals("", result);
    }

}