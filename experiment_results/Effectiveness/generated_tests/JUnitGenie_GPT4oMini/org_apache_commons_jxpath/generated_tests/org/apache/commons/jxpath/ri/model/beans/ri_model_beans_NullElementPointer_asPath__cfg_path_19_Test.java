package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.ri.model.beans.NullElementPointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_model_beans_NullElementPointer_asPath__cfg_path_19_Test {

    @Test(timeout = 4000)
    public void testAsPathWithNullParent() {
        // Arrange
        NullElementPointer pointer = new NullElementPointer(null, -2147483648); // index set to WHOLE_COLLECTION

        // Act
        String result = pointer.asPath();

        // Assert
        assertEquals("", result); // Expecting an empty string since parent is null
    }

}