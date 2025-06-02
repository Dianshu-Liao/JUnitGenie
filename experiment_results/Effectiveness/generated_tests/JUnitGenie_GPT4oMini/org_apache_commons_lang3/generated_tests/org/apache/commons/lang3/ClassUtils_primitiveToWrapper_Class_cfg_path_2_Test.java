package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ClassUtils_primitiveToWrapper_Class_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPrimitiveToWrapperWithPrimitiveClass() {
        Class<?> result = ClassUtils.primitiveToWrapper(int.class);
        assertEquals(Integer.class, result);
    }

    @Test(timeout = 4000)
    public void testPrimitiveToWrapperWithNull() {
        Class<?> result = ClassUtils.primitiveToWrapper(null);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testPrimitiveToWrapperWithNonPrimitiveClass() {
        Class<?> result = ClassUtils.primitiveToWrapper(String.class);
        assertEquals(String.class, result);
    }

}