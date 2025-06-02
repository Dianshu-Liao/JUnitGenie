package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_firstNonEmpty_CharSequence_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testFirstNonEmpty_withNonEmptyValues() {
        CharSequence[] values = {"", "Hello", "World"};
        CharSequence result = StringUtils.firstNonEmpty(values);
        assertEquals("Hello", result);
    }

    @Test(timeout = 4000)
    public void testFirstNonEmpty_withAllEmptyValues() {
        CharSequence[] values = {"", "", ""};
        CharSequence result = StringUtils.firstNonEmpty(values);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testFirstNonEmpty_withNullArray() {
        CharSequence[] values = null;
        CharSequence result = StringUtils.firstNonEmpty(values);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testFirstNonEmpty_withMixedValues() {
        CharSequence[] values = {null, "", "Non-empty"};
        CharSequence result = StringUtils.firstNonEmpty(values);
        assertEquals("Non-empty", result);
    }

}