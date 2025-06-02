package org.apache.commons.jxpath.ri.model;
import org.apache.commons.jxpath.ri.model.VariablePointer;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.QName;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_model_VariablePointer_getBaseValue__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetBaseValueThrowsJXPathException() {
        // Arrange
        QName name = new QName("testVariable");
        VariablePointer variablePointer = new VariablePointer(null, name);
        // Set the actual field to false to trigger the exception
        setActualField(variablePointer, false);

        try {
            // Act
            variablePointer.getBaseValue();
            // If no exception is thrown, fail the test
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException e) {
            // Assert
            String expectedMessage = "Undefined variable: " + name.toString();
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    private void setActualField(VariablePointer variablePointer, boolean value) {
        try {
            java.lang.reflect.Field actualField = VariablePointer.class.getDeclaredField("actual");
            actualField.setAccessible(true);
            actualField.set(variablePointer, value);
        } catch (Exception e) {
            fail("Failed to set actual field: " + e.getMessage());
        }
    }

}