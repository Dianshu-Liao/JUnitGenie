package org.apache.commons.jxpath.util;

import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathException;

public class ValueUtils_setValue_13_0_Test {

    private TestBean testBean;

    private PropertyDescriptor propertyDescriptor;

    private IndexedPropertyDescriptor indexedPropertyDescriptor;

    @BeforeEach
    void setUp() throws Exception {
        testBean = new TestBean();
        propertyDescriptor = new PropertyDescriptor("value", TestBean.class);
        indexedPropertyDescriptor = new IndexedPropertyDescriptor("list", TestBean.class);
    }

    @Test
    void testSetValueWithIndexedPropertyDescriptor() throws Exception {
        Method method = indexedPropertyDescriptor.getIndexedWriteMethod();
        Assertions.assertNotNull(method);
        ValueUtils.setValue(testBean, indexedPropertyDescriptor, 0, "First Element");
        Assertions.assertEquals("First Element", testBean.getList().get(0));
    }

    @Test
    void testSetValueWithCollection() throws Exception {
        testBean.setList(new ArrayList<>());
        ValueUtils.setValue(testBean, propertyDescriptor, 0, "Single Value");
        Assertions.assertEquals("Single Value", testBean.getValue());
    }

    @Test
    void testSetValueThrowsExceptionForInvalidIndex() {
        testBean.setList(new ArrayList<>());
        Assertions.assertThrows(IllegalArgumentException.class, () -> ValueUtils.setValue(testBean, indexedPropertyDescriptor, 1, "Invalid Index"));
    }

    @Test
    void testSetValueThrowsExceptionForNonCollection() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ValueUtils.setValue(testBean, propertyDescriptor, 1, "Not a Collection"));
    }

    @Test
    void testSetValueWithIndexedPropertyDescriptorAndValidIndex() throws Exception {
        testBean.setList(new ArrayList<>());
        ValueUtils.setValue(testBean, indexedPropertyDescriptor, 0, "Element 0");
        Assertions.assertEquals("Element 0", testBean.getList().get(0));
    }

    @Test
    void testSetValueWithIndexedPropertyDescriptorAndNullValue() throws Exception {
        testBean.setList(new ArrayList<>());
        ValueUtils.setValue(testBean, indexedPropertyDescriptor, 0, null);
        Assertions.assertNull(testBean.getList().get(0));
    }

    // TestBean class for testing purposes
    public static class TestBean {

        private String value;

        private List<String> list = new ArrayList<>();

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }
    }
}
