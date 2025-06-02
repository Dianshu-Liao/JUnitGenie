package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSetUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class CharSetUtils_keep_String_String_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testKeepWithNullString() {
        String result = CharSetUtils.keep(null);
        assertNull(result);
    }

}