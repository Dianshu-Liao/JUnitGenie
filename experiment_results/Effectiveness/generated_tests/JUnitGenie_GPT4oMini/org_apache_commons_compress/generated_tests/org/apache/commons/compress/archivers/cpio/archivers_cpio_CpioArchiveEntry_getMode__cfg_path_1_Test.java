package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_cpio_CpioArchiveEntry_getMode__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetModeWhenModeIsZeroAndNameIsNotCpioTrailer() {
        // Arrange
        CpioArchiveEntry entry = new CpioArchiveEntry("testEntry");
        // Set the private field 'mode' to 0 using reflection
        try {
            java.lang.reflect.Field modeField = CpioArchiveEntry.class.getDeclaredField("mode");
            modeField.setAccessible(true);
            modeField.setLong(entry, 0);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        
        // Act
        long result = entry.getMode();

        // Assert
        assertEquals(CpioArchiveEntry.C_ISREG, result);
    }

    @Test(timeout = 4000)
    public void testGetModeWhenModeIsNonZero() {
        // Arrange
        CpioArchiveEntry entry = new CpioArchiveEntry("testEntry");
        // Set the private field 'mode' to a non-zero value using reflection
        try {
            java.lang.reflect.Field modeField = CpioArchiveEntry.class.getDeclaredField("mode");
            modeField.setAccessible(true);
            modeField.setLong(entry, 1);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Act
        long result = entry.getMode();

        // Assert
        assertEquals(1, result);
    }

    @Test(timeout = 4000)
    public void testGetModeWhenNameIsCpioTrailer() {
        // Arrange
        CpioArchiveEntry entry = new CpioArchiveEntry("CPIO_TRAILER");
        // Set the private field 'mode' to 0 using reflection
        try {
            java.lang.reflect.Field modeField = CpioArchiveEntry.class.getDeclaredField("mode");
            modeField.setAccessible(true);
            modeField.setLong(entry, 0);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Act
        long result = entry.getMode();

        // Assert
        assertEquals(0, result); // Assuming mode remains 0 when name is CPIO_TRAILER
    }

}