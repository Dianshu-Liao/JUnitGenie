package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_35_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNullStr() {
        String str = null;
        String wrapWith = "wrap";
        String expected = null;

        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}