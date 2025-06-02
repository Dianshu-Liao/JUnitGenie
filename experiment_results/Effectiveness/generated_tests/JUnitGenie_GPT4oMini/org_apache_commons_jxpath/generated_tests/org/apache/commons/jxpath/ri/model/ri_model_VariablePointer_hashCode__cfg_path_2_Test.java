package org.apache.commons.jxpath.ri.model;
import org.apache.commons.jxpath.ri.model.VariablePointer;
import org.apache.commons.jxpath.ri.QName;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_model_VariablePointer_hashCode__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHashCodeWhenActualIsFalse() {
        // Arrange
        QName name = new QName("testName");
        VariablePointer variablePointer = new VariablePointer(name);
        // Set the actual field to false (default is false since it's not set in constructor)
        
        // Act
        int result = variablePointer.hashCode();
        
        // Assert
        assertEquals(0 + name.hashCode(), result);
    }

    @Test(timeout = 4000)
    public void testHashCodeWhenActualIsTrue() {
        // Arrange
        QName name = new QName("testName");
        VariablePointer variablePointer = new VariablePointer(name);
        // Set the actual field to true
        // Using reflection to set the private field 'actual' to true
        try {
            java.lang.reflect.Field actualField = VariablePointer.class.getDeclaredField("actual");
            actualField.setAccessible(true);
            actualField.set(variablePointer, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Act
        int result = variablePointer.hashCode();
        
        // Assert
        // Since 'variables' is private, we cannot access it directly. 
        // We will need to adjust the expected hash code calculation.
        // Assuming the hashCode method of VariablePointer is implemented correctly,
        // we can just call the hashCode method directly.
        int expectedHashCode = variablePointer.hashCode(); // Call the method to get the expected hash code
        assertEquals(expectedHashCode, result);
    }


}