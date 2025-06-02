package org.apache.commons.compress.harmony.unpack200.bytecode;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPClass;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_unpack200_bytecode_CPClass_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        // Arrange
        CPUTF8 utf8Instance = new CPUTF8("test"); // Providing a String argument for the constructor
        CPClass cpClassInstance = new CPClass(utf8Instance, 0); // Assuming a constructor with CPUTF8 and int parameters

        // Act
        boolean result = cpClassInstance.equals(null);

        // Assert
        assertFalse(result);
    }


}