package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_StrBuilder_insert_int_char_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testInsertWithNullChars() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");
        try {
            // Explicitly using an empty string to avoid ambiguity
            StrBuilder result = strBuilder.insert(5, "");
            assertEquals("Hello", result.toString());
        } catch (Exception e) {
            fail("Exception should not be thrown for null chars");
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithValidIndexAndChars() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");
        char[] chars = {' ', 'W', 'o', 'r', 'l', 'd'};
        try {
            StrBuilder result = strBuilder.insert(5, chars);
            assertEquals("Hello World", result.toString());
        } catch (Exception e) {
            fail("Exception should not be thrown for valid index and chars");
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithInvalidIndex() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");
        char[] chars = {' ', 'W', 'o', 'r', 'l', 'd'};
        try {
            strBuilder.insert(-1, chars);
            fail("Exception should be thrown for invalid index");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception type thrown");
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithIndexGreaterThanSize() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");
        char[] chars = {' ', 'W', 'o', 'r', 'l', 'd'};
        try {
            strBuilder.insert(6, chars);
            fail("Exception should be thrown for index greater than size");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception type thrown");
        }
    }


}