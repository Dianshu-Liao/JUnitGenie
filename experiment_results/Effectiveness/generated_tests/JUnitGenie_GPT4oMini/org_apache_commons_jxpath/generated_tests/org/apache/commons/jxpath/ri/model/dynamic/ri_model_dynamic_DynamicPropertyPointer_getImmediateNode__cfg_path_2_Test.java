package org.apache.commons.jxpath.ri.model.dynamic;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_model_dynamic_DynamicPropertyPointer_getImmediateNode__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetImmediateNodeWhenIndexIsWholeCollection() {
        // Arrange
        DynamicPropertyHandler mockHandler = new DynamicPropertyHandler() {
            @Override
            public Object getProperty(Object bean, String propertyName) {
                // Mock implementation
                return new Object(); // Return a valid object
            }

            @Override
            public void setProperty(Object bean, String propertyName, Object value) {
                // Mock implementation
            }

            @Override
            public String[] getPropertyNames(Object bean) {
                return new String[0]; // Return an empty array for mock
            }
        };
        
        DynamicPropertyPointer pointer = new DynamicPropertyPointer(null, mockHandler);
        // Use reflection to set the protected index field
        setPointerIndex(pointer, Integer.MIN_VALUE); // Simulate WHOLE_COLLECTION

        // Act
        Object result = pointer.getImmediateNode();

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testGetImmediateNodeWhenIndexIsNotWholeCollection() {
        // Arrange
        DynamicPropertyHandler mockHandler = new DynamicPropertyHandler() {
            @Override
            public Object getProperty(Object bean, String propertyName) {
                // Mock implementation
                return new Object(); // Return a valid object
            }

            @Override
            public void setProperty(Object bean, String propertyName, Object value) {
                // Mock implementation
            }

            @Override
            public String[] getPropertyNames(Object bean) {
                return new String[0]; // Return an empty array for mock
            }
        };
        
        DynamicPropertyPointer pointer = new DynamicPropertyPointer(null, mockHandler);
        // Use reflection to set the protected index field
        setPointerIndex(pointer, 0); // Simulate a valid index

        // Act
        Object result = pointer.getImmediateNode();

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testGetImmediateNodeThrowsException() {
        // Arrange
        DynamicPropertyHandler mockHandler = new DynamicPropertyHandler() {
            @Override
            public Object getProperty(Object bean, String propertyName) {
                throw new RuntimeException("Mock exception");
            }

            @Override
            public void setProperty(Object bean, String propertyName, Object value) {
                // Mock implementation
            }

            @Override
            public String[] getPropertyNames(Object bean) {
                return new String[0]; // Return an empty array for mock
            }
        };
        
        DynamicPropertyPointer pointer = new DynamicPropertyPointer(null, mockHandler);
        // Use reflection to set the protected index field
        setPointerIndex(pointer, 0); // Simulate a valid index

        // Act
        try {
            pointer.getImmediateNode();
            fail("Expected an exception to be thrown");
        } catch (RuntimeException e) {
            // Assert
            assertEquals("Mock exception", e.getMessage());
        }
    }

    private void setPointerIndex(DynamicPropertyPointer pointer, int index) {
        try {
            java.lang.reflect.Field field = DynamicPropertyPointer.class.getDeclaredField("index");
            field.setAccessible(true);
            field.setInt(pointer, index);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Field 'index' does not exist in DynamicPropertyPointer", e);
        } catch (Exception e) {
            throw new RuntimeException("Failed to set index", e);
        }
    }

}