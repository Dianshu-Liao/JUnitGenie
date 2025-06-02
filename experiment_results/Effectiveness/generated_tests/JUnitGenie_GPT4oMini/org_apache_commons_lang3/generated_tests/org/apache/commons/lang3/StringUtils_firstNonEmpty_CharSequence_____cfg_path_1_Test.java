package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class StringUtils_firstNonEmpty_CharSequence_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testFirstNonEmptyWithNullArray() {
        // Test case for the scenario where the input array is null
        CharSequence result = StringUtils.firstNonEmpty(null);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testFirstNonEmptyWithEmptyArray() {
        // Test case for the scenario where the input array is empty
        CharSequence result = StringUtils.firstNonEmpty(new CharSequence[]{});
        assertNull(result);
    }

}