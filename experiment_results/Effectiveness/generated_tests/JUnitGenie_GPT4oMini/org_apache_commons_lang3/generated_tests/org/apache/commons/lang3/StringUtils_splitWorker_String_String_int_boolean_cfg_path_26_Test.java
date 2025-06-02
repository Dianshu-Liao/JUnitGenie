package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_26_Test {

    @Test(timeout = 4000)
    public void testSplitWorker() {
        // Given
        String str = "a,b,c";
        String separatorChars = ",";
        int max = 10;
        boolean preserveAllTokens = false;

        // When
        String[] result = StringUtils.split(str, separatorChars, max);

        // Then
        String[] expected = {"a", "b", "c"};
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSplitWorkerWithNullString() {
        // Given
        String str = null;
        String separatorChars = ",";
        int max = 10;
        boolean preserveAllTokens = false;

        // When
        String[] result = StringUtils.split(str, separatorChars, max);

        // Then
        assertArrayEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testSplitWorkerWithEmptyString() {
        // Given
        String str = "";
        String separatorChars = ",";
        int max = 10;
        boolean preserveAllTokens = false;

        // When
        String[] result = StringUtils.split(str, separatorChars, max);

        // Then
        String[] expected = ArrayUtils.EMPTY_STRING_ARRAY;
        assertArrayEquals(expected, result);
    }

}