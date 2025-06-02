package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_normalizeSpace_String_cfg_path_16_Test {

    @Test(timeout = 4000)
    public void testNormalizeSpace_SingleWhitespace() {
        String result = StringUtils.normalizeSpace(" a ");
        assertEquals("a", result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpace_MultipleWhitespaces() {
        String result = StringUtils.normalizeSpace("a     b");
        assertEquals("a b", result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpace_LeadingTrailingWhitespaces() {
        String result = StringUtils.normalizeSpace("   Hello World!   ");
        assertEquals("Hello World!", result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpace_EmptyString() {
        String result = StringUtils.normalizeSpace("");
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpace_NullString() {
        String result;
        try {
            result = StringUtils.normalizeSpace(null);
            assertEquals(null, result);  // Expected behavior for null input
        } catch (Exception e) {
            // Handle potential Exception if behavior changes in future implementations
            e.printStackTrace();
        }
    }

}