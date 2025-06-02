package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.AsiExtraField;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class archivers_zip_AsiExtraField_isDirectory__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsDirectoryWhenDirFlagIsFalse() {
        AsiExtraField asiExtraField = new AsiExtraField();
        
        // Directly setting the private field dirFlag to false using reflection
        try {
            java.lang.reflect.Field field = AsiExtraField.class.getDeclaredField("dirFlag");
            field.setAccessible(true);
            field.setBoolean(asiExtraField, false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Call the method under test
        boolean result = asiExtraField.isDirectory();
        
        // Verify the result
        assertFalse(result);
    }

}