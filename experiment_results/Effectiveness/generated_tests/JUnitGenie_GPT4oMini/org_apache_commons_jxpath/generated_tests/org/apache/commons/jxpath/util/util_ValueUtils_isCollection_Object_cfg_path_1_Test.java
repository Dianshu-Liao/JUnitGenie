package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.apache.commons.jxpath.Container;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class util_ValueUtils_isCollection_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsCollectionWithContainer() {
        // Arrange
        Container container = new Container() {
            @Override
            public void setValue(Object value) {
                // Implement the method as needed for the test
            }

            @Override
            public Object getValue() {
                return null; // Implement as needed for the test
            }
        };

        // Act
        boolean result = ValueUtils.isCollection(container);

        // Assert
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsCollectionWithArray() {
        // Arrange
        Object array = new int[]{1, 2, 3};

        // Act
        boolean result = ValueUtils.isCollection(array);

        // Assert
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsCollectionWithNull() {
        // Arrange
        Object nullValue = null;

        // Act
        boolean result = ValueUtils.isCollection(nullValue);

        // Assert
        assertTrue(!result);
    }

    @Test(timeout = 4000)
    public void testIsCollectionWithNonCollection() {
        // Arrange
        Object nonCollection = "Not a collection";

        // Act
        boolean result = ValueUtils.isCollection(nonCollection);

        // Assert
        assertTrue(!result);
    }


}