package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNullStr() {
        String str = null; // @parameter0 must be null
        String wrapWith = ""; // wrapWith is empty to meet the conditions

        String result = StringUtils.wrapIfMissing(str, wrapWith);
        
        // Since str is null, the result should also be null
        assertEquals(null, result);
    }

}