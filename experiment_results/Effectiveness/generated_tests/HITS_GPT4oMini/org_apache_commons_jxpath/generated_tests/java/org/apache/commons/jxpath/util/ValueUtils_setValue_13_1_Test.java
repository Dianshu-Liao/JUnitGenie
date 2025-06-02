package org.apache.commons.jxpath.util;

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
import java.beans.IndexedPropertyDescriptor;
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

class ValueUtils_setValue_13_1_Test {

    public static class TestBean {

        private List<String> items = new ArrayList<>();

        public List<String> getItems() {
            return items;
        }

        public void setItems(List<String> items) {
            this.items = items;
        }
    }

    @Test
    void testSetValueIndexedProperty() throws Exception {
        TestBean bean = new TestBean();
        bean.setItems(new ArrayList<>());
        Method indexedWriteMethod = TestBean.class.getMethod("setItems", List.class);
        Method indexedReadMethod = TestBean.class.getMethod("getItems");
        PropertyDescriptor pd = new PropertyDescriptor("items", TestBean.class, "getItems", "setItems");
        // Simulate adding an item
        bean.getItems().add("item1");
        // Now we can set it using the method under test
        ValueUtils.setValue(bean, pd, 0, "item2");
        assertEquals("item2", bean.getItems().get(0));
    }

    @Test
    void testSetValueNonIndexedProperty() throws Exception {
        TestBean bean = new TestBean();
        Method writeMethod = TestBean.class.getMethod("setItems", List.class);
        PropertyDescriptor pd = new PropertyDescriptor("items", TestBean.class, "getItems", "setItems");
        // Set the items to a new list
        List<String> newList = new ArrayList<>();
        newList.add("item1");
        ValueUtils.setValue(bean, pd, 0, newList);
        assertNotNull(bean.getItems());
        assertEquals("item1", bean.getItems().get(0));
    }
}
