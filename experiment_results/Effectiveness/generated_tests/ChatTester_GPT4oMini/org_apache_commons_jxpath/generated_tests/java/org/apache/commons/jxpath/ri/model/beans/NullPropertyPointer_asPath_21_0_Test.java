package org.apache.commons.jxpath.ri.model.beans;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NullPropertyPointer_asPath_21_0_Test {

    private NullPropertyPointer nullPropertyPointer;

    private NodePointer mockParentPointer;

    // Assuming WHOLE_COLLECTION is represented by -1
    private static final int WHOLE_COLLECTION = -1;

    @BeforeEach
    public void setUp() {
        mockParentPointer = mock(NodePointer.class);
        nullPropertyPointer = new NullPropertyPointer(mockParentPointer);
    }

    @Test
    public void testAsPathWhenByNameAttributeIsFalse() {
        // Set up the condition
        setPrivateField(nullPropertyPointer, "byNameAttribute", false);
        // Mock the super class method call
        String expectedPath = "superPath";
        when(mockParentPointer.asPath()).thenReturn(expectedPath);
        // Execute the method
        String result = nullPropertyPointer.asPath();
        // Verify the result
        assertEquals(expectedPath, result);
    }

    @Test
    public void testAsPathWhenByNameAttributeIsTrueAndIndexIsWholeCollection() {
        // Set up the condition
        setPrivateField(nullPropertyPointer, "byNameAttribute", true);
        setPrivateField(nullPropertyPointer, "propertyName", "testProperty");
        // Fixed the buggy line
        setPrivateField(nullPropertyPointer, "index", WHOLE_COLLECTION);
        // Mock the parent pointer asPath return
        when(mockParentPointer.asPath()).thenReturn("parentPath");
        // Execute the method
        String result = nullPropertyPointer.asPath();
        // Verify the result
        assertEquals("parentPath[@name='testProperty']", result);
    }

    @Test
    public void testAsPathWhenByNameAttributeIsTrueAndIndexIsNotWholeCollection() {
        // Set up the condition
        setPrivateField(nullPropertyPointer, "byNameAttribute", true);
        setPrivateField(nullPropertyPointer, "propertyName", "testProperty");
        // Assuming index is not WHOLE_COLLECTION
        setPrivateField(nullPropertyPointer, "index", 0);
        // Mock the parent pointer asPath return
        when(mockParentPointer.asPath()).thenReturn("parentPath");
        // Execute the method
        String result = nullPropertyPointer.asPath();
        // Verify the result
        assertEquals("parentPath[@name='testProperty'][1]", result);
    }

    private void setPrivateField(Object target, String fieldName, Object value) {
        try {
            // Fixed the buggy line by replacing 'var' with 'Field'
            java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
