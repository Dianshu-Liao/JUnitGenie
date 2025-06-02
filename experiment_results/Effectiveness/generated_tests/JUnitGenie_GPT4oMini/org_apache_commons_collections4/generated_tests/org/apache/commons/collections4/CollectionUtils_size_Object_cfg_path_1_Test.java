package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CollectionUtils_size_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSizeWithNullObject() {
        // Given
        Object object = null;

        // When
        int result = CollectionUtils.size(object);

        // Then
        assertEquals(0, result);
    }

}