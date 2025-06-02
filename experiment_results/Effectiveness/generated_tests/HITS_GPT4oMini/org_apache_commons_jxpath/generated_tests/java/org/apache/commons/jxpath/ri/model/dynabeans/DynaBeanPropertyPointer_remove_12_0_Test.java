package org.apache.commons.jxpath.ri.model.dynabeans;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.jxpath.JXPathTypeConversionException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.ValueUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.util.TypeUtils;

public class DynaBeanPropertyPointer_remove_12_0_Test {

    private DynaBean dynaBean;

    private DynaBeanPropertyPointer propertyPointer;

    @BeforeEach
    public void setUp() {
        dynaBean = mock(DynaBean.class);
        NodePointer parent = mock(NodePointer.class);
        propertyPointer = new DynaBeanPropertyPointer(parent, dynaBean);
    }

    @Test
    public void testRemoveWholeCollection() {
        when(dynaBean.get("propertyName")).thenReturn(new ArrayList<>(Arrays.asList("value1", "value2")));
        propertyPointer.setPropertyName("propertyName");
        propertyPointer.setPropertyIndex(DynaBeanPropertyPointer.WHOLE_COLLECTION);
        propertyPointer.remove();
        verify(dynaBean).set("propertyName", null);
    }

    @Test
    public void testRemoveIndexedProperty() {
        when(dynaBean.get("propertyName")).thenReturn(new ArrayList<>(Arrays.asList("value1", "value2")));
        propertyPointer.setPropertyName("propertyName");
        propertyPointer.setPropertyIndex(1);
        propertyPointer.remove();
        verify(dynaBean).set("propertyName", 1, null);
    }

    @Test
    public void testRemoveFromCollection() {
        List<String> collection = new ArrayList<>(Arrays.asList("value1", "value2", "value3"));
        when(dynaBean.get("propertyName")).thenReturn(collection);
        propertyPointer.setPropertyName("propertyName");
        propertyPointer.setPropertyIndex(1);
        propertyPointer.remove();
        assertEquals(Arrays.asList("value1", "value3"), collection);
    }

    @Test
    public void testRemoveFirstElement() {
        List<String> collection = new ArrayList<>(Arrays.asList("value1", "value2"));
        when(dynaBean.get("propertyName")).thenReturn(collection);
        propertyPointer.setPropertyName("propertyName");
        propertyPointer.setPropertyIndex(0);
        propertyPointer.remove();
        assertEquals(Arrays.asList(null, "value2"), collection);
    }

    @Test
    public void testRemoveFromEmptyCollection() {
        List<String> collection = new ArrayList<>();
        when(dynaBean.get("propertyName")).thenReturn(collection);
        propertyPointer.setPropertyName("propertyName");
        propertyPointer.setPropertyIndex(0);
        propertyPointer.remove();
        assertTrue(collection.isEmpty());
    }

    @Test
    public void testRemoveFromNullCollection() {
        when(dynaBean.get("propertyName")).thenReturn(null);
        propertyPointer.setPropertyName("propertyName");
        propertyPointer.setPropertyIndex(0);
        propertyPointer.remove();
        verify(dynaBean).set("propertyName", null);
    }

    @Test
    public void testRemoveWithInvalidIndex() {
        List<String> collection = new ArrayList<>(Arrays.asList("value1", "value2"));
        when(dynaBean.get("propertyName")).thenReturn(collection);
        propertyPointer.setPropertyName("propertyName");
        propertyPointer.setPropertyIndex(3);
        assertThrows(JXPathTypeConversionException.class, propertyPointer::remove);
    }
}
