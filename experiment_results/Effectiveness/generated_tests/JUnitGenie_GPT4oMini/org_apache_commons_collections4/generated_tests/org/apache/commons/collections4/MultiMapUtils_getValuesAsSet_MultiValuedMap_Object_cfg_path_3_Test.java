package org.apache.commons.collections4;
import org.apache.commons.collections4.MultiMapUtils;
import org.apache.commons.collections4.MultiValuedMap;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import java.util.Set;

public class MultiMapUtils_getValuesAsSet_MultiValuedMap_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetValuesAsSet_NullMap() {
        // Arrange
        MultiValuedMap<Object, Object> map = null;
        Object key = new Object();

        // Act
        Set<Object> result = null;
        try {
            result = MultiMapUtils.getValuesAsSet(map, key);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertNull(result);
    }


}