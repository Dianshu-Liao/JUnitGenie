package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.ri.QName;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_model_beans_NullPointer_hashCode__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHashCodeWithNullName() {
        // Arrange
        NullPointer nullPointer = new NullPointer(new QName("test"), null);
        // Act
        int result = nullPointer.hashCode();
        // Assert
        assertEquals(0, result);
    }

    @Test(timeout = 4000)
    public void testHashCodeWithNonNullName() {
        // Arrange
        QName qName = new QName("test");
        NullPointer nullPointer = new NullPointer(qName, null);
        // Act
        int result = nullPointer.hashCode();
        // Assert
        assertEquals(qName.hashCode(), result);
    }

}