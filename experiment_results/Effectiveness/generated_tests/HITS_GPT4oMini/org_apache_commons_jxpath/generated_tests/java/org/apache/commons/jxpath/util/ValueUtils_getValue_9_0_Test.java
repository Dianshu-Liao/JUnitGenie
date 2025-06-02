package org.apache.commons.jxpath.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.beans.IndexedPropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathException;

public class ValueUtils_getValue_9_0_Test {

    private TestBean testBean;

    private PropertyDescriptor propertyDescriptor;

    @BeforeEach
    public void setUp() throws Exception {
        testBean = new TestBean();
        testBean.setValue("Test Value");
        // Set up PropertyDescriptor for the 'value' property
        propertyDescriptor = new PropertyDescriptor("value", TestBean.class);
    }

    @Test
    public void testGetValue_ValidBean_ReturnsValue() {
        Object result = ValueUtils.getValue(testBean, propertyDescriptor);
        assertEquals("Test Value", result);
    }

    @Test
    public void testGetValue_NullBean_ThrowsJXPathException() {
        assertThrows(JXPathException.class, () -> {
            ValueUtils.getValue(null, propertyDescriptor);
        });
    }

    @Test
    public void testGetValue_NoReadMethod_ThrowsJXPathException() throws Exception {
        PropertyDescriptor invalidPropertyDescriptor = new PropertyDescriptor("invalidProperty", TestBean.class);
        assertThrows(JXPathException.class, () -> {
            ValueUtils.getValue(testBean, invalidPropertyDescriptor);
        });
    }

    @Test
    public void testGetValue_ReadMethodThrowsException_ThrowsJXPathException() throws Exception {
        PropertyDescriptor exceptionPropertyDescriptor = new PropertyDescriptor("exceptionProperty", TestBean.class);
        assertThrows(JXPathException.class, () -> {
            ValueUtils.getValue(testBean, exceptionPropertyDescriptor);
        });
    }

    // TestBean class for the purpose of testing
    public static class TestBean {

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        // Method to simulate an exception during property access
        public String getExceptionProperty() throws Exception {
            throw new Exception("Simulated Exception");
        }
    }
}
