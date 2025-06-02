package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.ri.model.beans.NullPointer;
import org.apache.commons.jxpath.ri.QName;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_model_beans_NullPointer_hashCode__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHashCode_NameNotNull() {
        // arrange
        QName qName = new QName("example");
        NullPointer nullPointer = new NullPointer(qName, null); // Using a constructor to instantiate the class

        // act
        int result = nullPointer.hashCode();

        // assert
        assertEquals("Expected hashCode when name is not null", qName.hashCode(), result);
    }

    @Test(timeout = 4000)
    public void testHashCode_NameIsNull() {
        // arrange
        // Use a valid constructor that matches the expected parameters
        // Specify the Locale parameter explicitly to avoid ambiguity
        NullPointer nullPointer = new NullPointer(java.util.Locale.getDefault(), null); // Assuming the constructor can accept Locale and String

        // act
        int result = nullPointer.hashCode();

        // assert
        assertEquals("Expected hashCode when name is null", 0, result);
    }


}