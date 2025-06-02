package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class text_StrBuilder_toCharArray_int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToCharArray_EmptyArray() {
        StrBuilder strBuilder = new StrBuilder();
        char[] result = strBuilder.toCharArray(0, 0);
        assertArrayEquals(ArrayUtils.EMPTY_CHAR_ARRAY, result);
    }

    @Test(timeout = 4000)
    public void testToCharArray_ValidRange() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        char[] result = strBuilder.toCharArray(0, 5);
        assertArrayEquals(new char[] {'H', 'e', 'l', 'l', 'o'}, result);
    }

    @Test(timeout = 4000)
    public void testToCharArray_NegativeStartIndex() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        try {
            strBuilder.toCharArray(-1, 5);
        } catch (Exception e) {
            // Handle exception as necessary
        }
    }

    @Test(timeout = 4000)
    public void testToCharArray_EndIndexLessThanStartIndex() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        try {
            strBuilder.toCharArray(3, 2);
        } catch (Exception e) {
            // Handle exception as necessary
        }
    }

}