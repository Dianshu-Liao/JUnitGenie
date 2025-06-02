package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import java.util.Iterator;

public class StringUtils_join_Iterator_char_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testJoinWithNullIterator() {
        // Arrange
        Iterator<?> iterator = null;
        char separator = ',';

        // Act
        String result = StringUtils.join(iterator, separator);

        // Assert
        assertNull(result);
    }


}