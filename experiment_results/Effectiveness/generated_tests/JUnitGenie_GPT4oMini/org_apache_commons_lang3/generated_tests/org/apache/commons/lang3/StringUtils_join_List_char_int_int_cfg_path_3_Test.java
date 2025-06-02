package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class StringUtils_join_List_char_int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testJoinWithNullList() {
        // Arrange
        List<?> list = null;
        char separator = ',';
        int startIndex = 0;
        int endIndex = 0;

        // Act
        String result = StringUtils.join(list, separator, startIndex, endIndex);

        // Assert
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testJoinWithEmptyList() {
        // Arrange
        List<?> list = new ArrayList<>();
        char separator = ',';
        int startIndex = 0;
        int endIndex = 0; // no items to join

        // Act
        String result = StringUtils.join(list, separator, startIndex, endIndex);

        // Assert
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test(timeout = 4000)
    public void testJoinWithValidRange() {
        // Arrange
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        char separator = ',';
        int startIndex = 0;
        int endIndex = 3; // full list should be joined

        // Act
        String result = StringUtils.join(list, separator, startIndex, endIndex);

        // Assert
        assertEquals("A,B,C", result);
    }

}