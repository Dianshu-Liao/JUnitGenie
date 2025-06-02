package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_containsAny_CharSequence_CharSequence_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testContainsAnyWithNullSearchChars() {
        CharSequence cs = "example";
        CharSequence searchChars = null;

        try {
            boolean result = StringUtils.containsAny(cs, searchChars);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}