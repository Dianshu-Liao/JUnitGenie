package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_indexOfAny_CharSequence_String_cfg_path_1_Test {

    private static final int INDEX_NOT_FOUND = -1; // Assuming this is the constant used in the method

    @Test(timeout = 4000)
    public void testIndexOfAnyWithNullCharSequence() {
        CharSequence cs = null; // This meets the constraint for parameter0
        String searchChars = "abc";
        
        try {
            int result = StringUtils.indexOfAny(cs, searchChars);
            assertEquals(INDEX_NOT_FOUND, result); // Expecting INDEX_NOT_FOUND since cs is null
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}