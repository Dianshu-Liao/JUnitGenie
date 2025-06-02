package org.apache.commons.compress.harmony.unpack200.bytecode;
import org.apache.commons.compress.harmony.unpack200.bytecode.LocalVariableTypeTableAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class harmony_unpack200_bytecode_LocalVariableTypeTableAttribute_getNestedClassFileEntries__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetNestedClassFileEntries() {
        // Arrange
        CPUTF8[] names = new CPUTF8[] { new CPUTF8("name1"), new CPUTF8("name2") };
        CPUTF8[] signatures = new CPUTF8[] { new CPUTF8("signature1"), new CPUTF8("signature2") };
        int localVariableTypeTableLength = 2;

        LocalVariableTypeTableAttribute attribute = new LocalVariableTypeTableAttribute(0, new int[0], new int[0], names, signatures, new int[0]);

        // Act
        ClassFileEntry[] result = null;
        try {
            Method method = LocalVariableTypeTableAttribute.class.getDeclaredMethod("getNestedClassFileEntries");
            method.setAccessible(true);
            result = (ClassFileEntry[]) method.invoke(attribute);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert
        assertNotNull(result);
    }

}