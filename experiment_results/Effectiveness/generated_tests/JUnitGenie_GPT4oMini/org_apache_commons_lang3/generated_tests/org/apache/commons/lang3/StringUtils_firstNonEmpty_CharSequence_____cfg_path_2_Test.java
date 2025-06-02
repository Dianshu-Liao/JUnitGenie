package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class StringUtils_firstNonEmpty_CharSequence_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testFirstNonEmptyWithNullArray() {
        // Given
        CharSequence[] values = null;

        // When
        CharSequence result = StringUtils.firstNonEmpty(values);

        // Then
        assertNull(result);
    }

}