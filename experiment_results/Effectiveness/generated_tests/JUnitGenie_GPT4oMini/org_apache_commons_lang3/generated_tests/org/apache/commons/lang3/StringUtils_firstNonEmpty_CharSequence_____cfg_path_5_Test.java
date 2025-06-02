package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class StringUtils_firstNonEmpty_CharSequence_____cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testFirstNonEmptyWithNullArray() {
        try {
            CharSequence result = StringUtils.firstNonEmpty(null);
            assertNull(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}