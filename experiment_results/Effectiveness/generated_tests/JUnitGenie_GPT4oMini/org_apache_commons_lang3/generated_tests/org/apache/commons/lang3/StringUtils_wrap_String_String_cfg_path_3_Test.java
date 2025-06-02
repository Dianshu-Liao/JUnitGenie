package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrap_String_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testWrapWithNullStr() {
        String str = null;
        String wrapWith = "[]";
        try {
            String result = StringUtils.wrap(str, wrapWith);
            assertEquals(null, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testWrapWithNullWrapWith() {
        String str = "test";
        String wrapWith = null;
        try {
            String result = StringUtils.wrap(str, wrapWith);
            assertEquals("test", result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}