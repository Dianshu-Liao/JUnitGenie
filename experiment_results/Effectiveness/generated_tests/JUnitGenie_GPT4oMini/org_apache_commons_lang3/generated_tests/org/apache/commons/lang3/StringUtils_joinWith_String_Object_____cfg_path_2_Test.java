package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringUtils_joinWith_String_Object_____cfg_path_2_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testJoinWith_NullArray_ThrowsIllegalArgumentException() {
        String delimiter = ",";
        Object[] array = null;

        try {
            StringUtils.joinWith(delimiter, array);
        } catch (IllegalArgumentException e) {
            // Exception is expected, test passes
            throw e; // rethrow to satisfy the expected exception
        }
    }

}