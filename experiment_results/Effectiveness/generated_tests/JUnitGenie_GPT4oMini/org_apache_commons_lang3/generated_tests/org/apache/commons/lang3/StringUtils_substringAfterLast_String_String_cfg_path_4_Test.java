package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_substringAfterLast_String_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSubstringAfterLastWithNullString() {
        String result = StringUtils.substringAfterLast(null, "separator");
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testSubstringAfterLastWithNullSeparator() {
        String result = StringUtils.substringAfterLast("testString", null);
        assertEquals("", result);
    }

}