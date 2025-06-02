package org.apache.commons.lang3;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.util.Optional;

public class ObjectUtils_isEmpty_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testIsEmptyWithOptional() {
        try {
            // Test with an empty Optional
            Optional<Object> emptyOptional = Optional.empty();
            boolean result = ObjectUtils.isEmpty(emptyOptional);
            assertTrue(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }


}