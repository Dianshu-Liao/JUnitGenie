package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.ri.model.beans.NullPropertyPointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.QName;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NullPropertyPointer_asPath_21_1_Test {

    private NullPropertyPointer nullPropertyPointer;

    private NodePointer parent;

    @BeforeEach
    public void setUp() {
        parent = mock(NodePointer.class);
        nullPropertyPointer = new NullPropertyPointer(parent);
    }

    @Test
    public void testAsPathWithoutNameAttribute() throws Exception {
        // Invoke the private method using reflection
        Method method = NullPropertyPointer.class.getDeclaredMethod("asPath");
        method.setAccessible(true);
        String result = (String) method.invoke(nullPropertyPointer);
        // Since byNameAttribute is false, it should call super.asPath(), which we expect to be null
        assertEquals(null, result);
    }

    @Test
    public void testAsPathWithNameAttribute() throws Exception {
        nullPropertyPointer.setNameAttributeValue("testName");
        // Mock the behavior of getImmediateParentPointer() to return a mocked NodePointer
        NodePointer mockParentPointer = mock(NodePointer.class);
        when(mockParentPointer.asPath()).thenReturn("/parentPath");
        // Mocking the getImmediateParentPointer method
        Method getImmediateParentPointerMethod = NullPropertyPointer.class.getDeclaredMethod("getImmediateParentPointer");
        getImmediateParentPointerMethod.setAccessible(true);
        when(getImmediateParentPointerMethod.invoke(nullPropertyPointer)).thenReturn(mockParentPointer);
        // Invoke the private method
        Method method = NullPropertyPointer.class.getDeclaredMethod("asPath");
        method.setAccessible(true);
        String result = (String) method.invoke(nullPropertyPointer);
        // Validate the result
        assertEquals("/parentPath[@name='testName']", result);
    }

    @Test
    public void testAsPathWithIndex() throws Exception {
        nullPropertyPointer.setNameAttributeValue("testName");
        // Mock the behavior of getImmediateParentPointer() to return a mocked NodePointer
        NodePointer mockParentPointer = mock(NodePointer.class);
        when(mockParentPointer.asPath()).thenReturn("/parentPath");
        // Use reflection to set the index to a value other than WHOLE_COLLECTION
        Method setPropertyIndexMethod = NullPropertyPointer.class.getDeclaredMethod("setPropertyIndex", int.class);
        setPropertyIndexMethod.setAccessible(true);
        // Assuming index starts from 0
        setPropertyIndexMethod.invoke(nullPropertyPointer, 0);
        // Mocking the getImmediateParentPointer method
        Method getImmediateParentPointerMethod = NullPropertyPointer.class.getDeclaredMethod("getImmediateParentPointer");
        getImmediateParentPointerMethod.setAccessible(true);
        when(getImmediateParentPointerMethod.invoke(nullPropertyPointer)).thenReturn(mockParentPointer);
        // Invoke the private method
        Method method = NullPropertyPointer.class.getDeclaredMethod("asPath");
        method.setAccessible(true);
        String result = (String) method.invoke(nullPropertyPointer);
        // Validate the result
        // Index is 0, so it should be 1 in the path
        assertEquals("/parentPath[@name='testName'][1]", result);
    }
}
