package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import java.util.List;

public class StringUtils_join_List_String_int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testJoinWithNullList() {
        // Given
        List<?> list = null;
        String separator = ",";
        int startIndex = 0;
        int endIndex = 5;

        // When
        String result = StringUtils.join(list, separator, startIndex, endIndex);

        // Then
        assertNull(result);
    }


}