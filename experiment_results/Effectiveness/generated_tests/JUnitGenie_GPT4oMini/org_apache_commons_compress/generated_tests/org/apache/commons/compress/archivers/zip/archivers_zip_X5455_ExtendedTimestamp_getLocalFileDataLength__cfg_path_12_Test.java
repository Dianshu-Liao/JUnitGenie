package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_zip_X5455_ExtendedTimestamp_getLocalFileDataLength__cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testGetLocalFileDataLength_withAllTimesPresent() {
        X5455_ExtendedTimestamp timestamp = new X5455_ExtendedTimestamp();
        // Set the fields to simulate the conditions
        setPrivateField(timestamp, "bit0_modifyTimePresent", true);
        setPrivateField(timestamp, "bit1_accessTimePresent", true);
        setPrivateField(timestamp, "accessTime", new ZipLong(123456789)); // Simulating a non-null accessTime
        setPrivateField(timestamp, "bit2_createTimePresent", true);
        setPrivateField(timestamp, "createTime", new ZipLong(987654321)); // Simulating a non-null createTime

        ZipShort result = timestamp.getLocalFileDataLength();
        assertEquals(new ZipShort(12), result); // 1 + 4 + 4 + 4 = 12
    }

    @Test(timeout = 4000)
    public void testGetLocalFileDataLength_withOnlyModifyTimePresent() {
        X5455_ExtendedTimestamp timestamp = new X5455_ExtendedTimestamp();
        // Set the fields to simulate the conditions
        setPrivateField(timestamp, "bit0_modifyTimePresent", true);
        setPrivateField(timestamp, "bit1_accessTimePresent", false);
        setPrivateField(timestamp, "bit2_createTimePresent", false);

        ZipShort result = timestamp.getLocalFileDataLength();
        assertEquals(new ZipShort(5), result); // 1 + 4 = 5
    }

    @Test(timeout = 4000)
    public void testGetLocalFileDataLength_withNoTimesPresent() {
        X5455_ExtendedTimestamp timestamp = new X5455_ExtendedTimestamp();
        // Set the fields to simulate the conditions
        setPrivateField(timestamp, "bit0_modifyTimePresent", false);
        setPrivateField(timestamp, "bit1_accessTimePresent", false);
        setPrivateField(timestamp, "bit2_createTimePresent", false);

        ZipShort result = timestamp.getLocalFileDataLength();
        assertEquals(new ZipShort(1), result); // Only 1
    }

    // Helper method to set private fields using reflection
    private void setPrivateField(X5455_ExtendedTimestamp obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = X5455_ExtendedTimestamp.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}