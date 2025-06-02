package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.dataformat.xml.deser.ElementWrapper;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class deser_ElementWrapper_toString__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToStringWithParentNullAndWrapperNameNotNull() {
        // Arrange
        ElementWrapper elementWrapper = instantiateElementWrapper(null, "TestWrapper");

        // Act
        String result = elementWrapper.toString();

        // Assert
        assertEquals("Wrapper: ROOT, matching: TestWrapper", result);
    }

    @Test(timeout = 4000)
    public void testToStringWithParentNotNullAndWrapperNameNull() {
        // Arrange
        ElementWrapper parentWrapper = instantiateElementWrapper(null, null);
        ElementWrapper elementWrapper = instantiateElementWrapper(parentWrapper, null);

        // Act
        String result = elementWrapper.toString();

        // Assert
        assertEquals("Wrapper: empty", result);
    }

    @Test(timeout = 4000)
    public void testToStringWithParentNotNullAndWrapperNameNotNull() {
        // Arrange
        ElementWrapper parentWrapper = instantiateElementWrapper(null, null);
        ElementWrapper elementWrapper = instantiateElementWrapper(parentWrapper, "TestWrapper");

        // Act
        String result = elementWrapper.toString();

        // Assert
        assertEquals("Wrapper: branch, matching: TestWrapper", result);
    }

    private ElementWrapper instantiateElementWrapper(ElementWrapper parent, String wrapperName) {
        try {
            // Use reflection to access the private constructor
            java.lang.reflect.Constructor<ElementWrapper> constructor = ElementWrapper.class.getDeclaredConstructor(ElementWrapper.class, String.class, String.class);
            constructor.setAccessible(true);
            return constructor.newInstance(parent, wrapperName, null); // Assuming the third param is not needed, passing null
        } catch (Exception e) {
            throw new RuntimeException("Failed to instantiate ElementWrapper", e);
        }
    }

}