package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.junit.Test;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.AnnotatedElement;
import java.util.Objects;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class reflect_TypeUtils_getImplicitBounds_TypeVariable_cfg_path_2_Test {



    @Test(timeout = 4000)
    public void testGetImplicitBoundsWithNullTypeVariable() {
        try {
            TypeUtils.getImplicitBounds(null);
        } catch (NullPointerException e) {
            assertEquals("typeVariable", e.getMessage());
        }
    }


}
