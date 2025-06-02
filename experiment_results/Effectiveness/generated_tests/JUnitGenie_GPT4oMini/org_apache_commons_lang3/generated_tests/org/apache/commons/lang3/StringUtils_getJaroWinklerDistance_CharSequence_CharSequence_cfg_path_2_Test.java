package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringUtils_getJaroWinklerDistance_CharSequence_CharSequence_cfg_path_2_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testGetJaroWinklerDistance_NullFirstParameter() {
        // Test case where the first parameter is null
        StringUtils.getJaroWinklerDistance(null, "test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetJaroWinklerDistance_NullSecondParameter() {
        // Test case where the second parameter is null
        StringUtils.getJaroWinklerDistance("test", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetJaroWinklerDistance_BothParametersNull() {
        // Test case where both parameters are null
        StringUtils.getJaroWinklerDistance(null, null);
    }

}