package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSetUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharSetUtils_squeeze_String_String_____cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testSqueezeWithNullStringAndEmptySet() {
        String result = CharSetUtils.squeeze(null, new String[]{});
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithEmptyStringAndEmptySet() {
        String result = CharSetUtils.squeeze("", new String[]{});
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithNullStringAndNullSet() {
        String result = CharSetUtils.squeeze(null, null);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithNonEmptyStringAndNullSet() {
        String result = CharSetUtils.squeeze("test", null);
        assertEquals("test", result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithNonEmptyStringAndEmptySet() {
        String result = CharSetUtils.squeeze("test", new String[]{});
        assertEquals("test", result);
    }

}