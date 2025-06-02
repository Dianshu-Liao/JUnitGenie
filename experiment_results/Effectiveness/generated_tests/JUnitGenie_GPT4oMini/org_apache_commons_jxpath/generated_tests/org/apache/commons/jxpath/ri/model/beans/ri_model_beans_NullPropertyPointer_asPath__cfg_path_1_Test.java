package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_model_beans_NullPropertyPointer_asPath__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAsPathWhenByNameAttributeIsFalse() {
        // Arrange
        NodePointer parentPointer = null; // Assuming a valid NodePointer instance is provided
        NullPropertyPointer pointer = new NullPropertyPointer(parentPointer);
        
        // Act
        String result = pointer.asPath();
        
        // Assert
        assertEquals("Expected path from super.asPath()", result);
    }



}
