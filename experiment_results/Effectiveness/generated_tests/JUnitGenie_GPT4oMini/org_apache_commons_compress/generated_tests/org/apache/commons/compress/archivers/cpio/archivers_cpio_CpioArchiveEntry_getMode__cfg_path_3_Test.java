package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_cpio_CpioArchiveEntry_getMode__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetModeWhenModeIsZeroAndNameIsNotTrailer() {
        // Arrange
        CpioArchiveEntry entry = new CpioArchiveEntry("someFile");
        // Set the private field 'mode' to 0 using reflection
        try {
            java.lang.reflect.Field modeField = CpioArchiveEntry.class.getDeclaredField("mode");
            modeField.setAccessible(true);
            modeField.setLong(entry, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Set the private field 'name' to a value that is not "TRAILER!!!"
        try {
            java.lang.reflect.Field nameField = CpioArchiveEntry.class.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(entry, "someFile");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Act
        long result = entry.getMode();

        // Assert
        assertEquals(CpioArchiveEntry.C_ISREG, result);
    }

    @Test(timeout = 4000)
    public void testGetModeWhenModeIsNotZero() {
        // Arrange
        CpioArchiveEntry entry = new CpioArchiveEntry("someFile");
        // Set the private field 'mode' to a non-zero value
        try {
            java.lang.reflect.Field modeField = CpioArchiveEntry.class.getDeclaredField("mode");
            modeField.setAccessible(true);
            modeField.setLong(entry, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Act
        long result = entry.getMode();

        // Assert
        assertEquals(1, result);
    }

    @Test(timeout = 4000)
    public void testGetModeWhenNameIsTrailer() {
        // Arrange
        CpioArchiveEntry entry = new CpioArchiveEntry("TRAILER!!!");
        // Set the private field 'mode' to 0
        try {
            java.lang.reflect.Field modeField = CpioArchiveEntry.class.getDeclaredField("mode");
            modeField.setAccessible(true);
            modeField.setLong(entry, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Act
        long result = entry.getMode();

        // Assert
        assertEquals(0, result);
    }

}