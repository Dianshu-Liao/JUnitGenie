package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringUtils_getJaroWinklerDistance_CharSequence_CharSequence_cfg_path_1_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testGetJaroWinklerDistance_NullFirstParameter() {
        // Test case for first parameter being null
        StringUtils.getJaroWinklerDistance(null, "test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetJaroWinklerDistance_NullSecondParameter() {
        // Test case for second parameter being null
        StringUtils.getJaroWinklerDistance("test", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetJaroWinklerDistance_BothParametersNull() {
        // Test case for both parameters being null
        StringUtils.getJaroWinklerDistance(null, null);
    }

}