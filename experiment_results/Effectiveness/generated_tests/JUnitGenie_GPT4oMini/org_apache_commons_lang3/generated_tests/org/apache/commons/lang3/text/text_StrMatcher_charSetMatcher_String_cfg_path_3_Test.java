package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrMatcher;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class text_StrMatcher_charSetMatcher_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCharSetMatcherWithEmptyString() {
        StrMatcher result = StrMatcher.charSetMatcher("");
        assertNotNull(result); // Check that the result is not null
        // You may need to check if the result behaves as expected for an empty string
    }

    @Test(timeout = 4000)
    public void testCharSetMatcherWithNull() {
        StrMatcher result = StrMatcher.charSetMatcher((String) null); // Explicitly cast to String
        assertNotNull(result); // Check that the result is not null
        // You may need to check if the result behaves as expected for a null input
    }


}