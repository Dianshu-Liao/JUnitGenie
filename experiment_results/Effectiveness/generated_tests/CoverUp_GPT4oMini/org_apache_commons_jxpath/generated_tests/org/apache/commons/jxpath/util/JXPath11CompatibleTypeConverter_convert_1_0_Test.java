package org.apache.commons.jxpath.util;

import org.apache.commons.jxpath.NodeSet;
import java.lang.reflect.Method;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class JXPath11CompatibleTypeConverter_convert_1_0_Test {

    private final JXPath11CompatibleTypeConverter converter = new JXPath11CompatibleTypeConverter();

    @Test
    public void testConvert_WithNodeSetAndMatchingType() throws Exception {
        NodeSet nodeSet = Mockito.mock(NodeSet.class);
        Object result = invokeConvert(nodeSet, NodeSet.class);
        assertEquals(nodeSet, result);
    }

    @Test
    public void testConvert_WithNodeSetAndNonMatchingType() throws Exception {
        NodeSet nodeSet = Mockito.mock(NodeSet.class);
        Object result = invokeConvert(nodeSet, String.class);
        assertThrows(ClassCastException.class, () -> {
            String strResult = (String) result;
        });
    }

    @Test
    public void testConvert_WithNonNodeSet() throws Exception {
        String input = "test";
        Object result = invokeConvert(input, String.class);
        assertEquals(input, result);
    }

    @Test
    public void testConvert_WithNullInput() throws Exception {
        Object result = invokeConvert(null, String.class);
        assertEquals(null, result);
    }

    private Object invokeConvert(Object object, Class<?> toType) throws Exception {
        Method method = JXPath11CompatibleTypeConverter.class.getDeclaredMethod("convert", Object.class, Class.class);
        method.setAccessible(true);
        return method.invoke(converter, object, toType);
    }
}
