package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_38_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNullStr() {
        String str = null; // This satisfies the condition for isEmpty
        String wrapWith = "[]";
        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals(null, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNullWrapWith() {
        String str = "test"; // This satisfies the condition for isEmpty
        String wrapWith = null; // This satisfies the condition for isEmpty
        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals("test", result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}