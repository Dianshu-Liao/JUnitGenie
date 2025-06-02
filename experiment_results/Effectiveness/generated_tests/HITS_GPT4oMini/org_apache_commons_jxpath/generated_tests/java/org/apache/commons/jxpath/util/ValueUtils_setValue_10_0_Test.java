package org.apache.commons.jxpath.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.apache.commons.jxpath.JXPathException;
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

class ValueUtils_setValue_10_0_Test {

    private PropertyDescriptor propertyDescriptor;

    private Method writeMethod;

    @BeforeEach
    void setUp() throws Exception {
        writeMethod = MockBean.class.getMethod("setName", String.class);
        propertyDescriptor = new PropertyDescriptor("name", MockBean.class, writeMethod.getName(), null);
    }

    @Test
    void testSetValue_Success() throws Exception {
        MockBean bean = new MockBean();
        String value = "Test Name";
        ValueUtils.setValue(bean, propertyDescriptor, value);
        assertEquals("Test Name", bean.getName());
    }

    @Test
    void testSetValue_NoWriteMethod() throws Exception {
        PropertyDescriptor pd = new PropertyDescriptor("name", MockBean.class, null, null);
        MockBean bean = new MockBean();
        assertThrows(JXPathException.class, () -> {
            ValueUtils.setValue(bean, pd, "Test Name");
        });
    }

    @Test
    void testSetValue_ConversionError() throws Exception {
        MockBean bean = new MockBean();
        assertThrows(JXPathException.class, () -> {
            ValueUtils.setValue(bean, propertyDescriptor, new Object());
        });
    }

    static class MockBean {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
