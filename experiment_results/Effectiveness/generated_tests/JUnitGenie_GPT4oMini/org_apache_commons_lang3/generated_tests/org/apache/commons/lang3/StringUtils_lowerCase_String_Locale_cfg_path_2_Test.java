package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import java.util.Locale;

public class StringUtils_lowerCase_String_Locale_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testLowerCaseWithNullString() {
        // Given
        String str = null;
        Locale locale = Locale.ENGLISH;

        // When
        String result = StringUtils.lowerCase(str, locale);

        // Then
        assertNull(result);
    }


}