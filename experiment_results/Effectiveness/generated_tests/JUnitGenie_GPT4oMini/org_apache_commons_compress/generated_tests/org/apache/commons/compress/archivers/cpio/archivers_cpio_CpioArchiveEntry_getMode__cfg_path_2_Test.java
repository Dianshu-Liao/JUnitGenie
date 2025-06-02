package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_cpio_CpioArchiveEntry_getMode__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetModeWhenModeIsZeroAndNameIsNotTrailer() {
        // Arrange
        CpioArchiveEntry entry = new CpioArchiveEntry((short) 0, "someFile");
        // Set the private field 'name' using reflection
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
        assertEquals(32768L, result);
    }

    @Test(timeout = 4000)
    public void testGetModeWhenModeIsNonZero() {
        // Arrange
        CpioArchiveEntry entry = new CpioArchiveEntry((short) 12345);
        // Set the private field 'name' using reflection
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
        assertEquals(12345L, result);
    }

    @Test(timeout = 4000)
    public void testGetModeWhenNameIsTrailer() {
        // Arrange
        CpioArchiveEntry entry = new CpioArchiveEntry((short) 0, "TRAILER!!!");
        // Set the private field 'name' using reflection
        try {
            java.lang.reflect.Field nameField = CpioArchiveEntry.class.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(entry, "TRAILER!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Act
        long result = entry.getMode();

        // Assert
        assertEquals(0L, result);
    }

}