package org.apache.commons.jxpath.ri.model.dynabeans;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.beanutils.DynaBean;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_model_dynabeans_DynaBeanPropertyPointer_getPropertyName__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetPropertyNameWhenNameIsNullAndPropertyIndexIsValid() {
        // Arrange
        NodePointer nodePointer = null; // Assuming a valid NodePointer is created here
        DynaBean dynaBean = null; // Assuming a valid DynaBean is created here
        DynaBeanPropertyPointer pointer = new DynaBeanPropertyPointer(nodePointer, dynaBean) {
            @Override
            public String[] getPropertyNames() {
                return new String[]{"property1", "property2", "property3"};
            }
        };
        
        // Set propertyIndex using a method
        pointer.setPropertyIndex(1); // Assuming setPropertyIndex is a method in the class

        // Act
        String result = pointer.getPropertyName();

        // Assert
        assertEquals("property2", result);
    }

    @Test(timeout = 4000)
    public void testGetPropertyNameWhenNameIsNullAndPropertyIndexIsInvalid() {
        // Arrange
        NodePointer nodePointer = null; // Assuming a valid NodePointer is created here
        DynaBean dynaBean = null; // Assuming a valid DynaBean is created here
        DynaBeanPropertyPointer pointer = new DynaBeanPropertyPointer(nodePointer, dynaBean) {
            @Override
            public String[] getPropertyNames() {
                return new String[]{"property1", "property2", "property3"};
            }
        };
        
        // Set propertyIndex using a method
        pointer.setPropertyIndex(5); // Out of bounds

        // Act
        String result = pointer.getPropertyName();

        // Assert
        assertEquals("*", result);
    }

    @Test(timeout = 4000)
    public void testGetPropertyNameWhenNameIsAlreadySet() {
        // Arrange
        NodePointer nodePointer = null; // Assuming a valid NodePointer is created here
        DynaBean dynaBean = null; // Assuming a valid DynaBean is created here
        DynaBeanPropertyPointer pointer = new DynaBeanPropertyPointer(nodePointer, dynaBean) {
            @Override
            public String[] getPropertyNames() {
                return new String[]{"property1", "property2", "property3"};
            }
        };
        
        // Set name directly in the DynaBeanPropertyPointer
        pointer.setPropertyName("existingProperty"); // Assuming setPropertyName is a method in the class

        // Act
        String result = pointer.getPropertyName();

        // Assert
        assertEquals("existingProperty", result);
    }

}