package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_zip_X5455_ExtendedTimestamp_setFlags_byte_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSetFlagsWithModifyTimePresent() {
        X5455_ExtendedTimestamp instance = new X5455_ExtendedTimestamp();
        byte flags = 1; // MODIFY_TIME_BIT is 1
        instance.setFlags(flags);
        
        // Use reflection to access private fields
        assertTrue(getBit0ModifyTimePresent(instance));
        assertFalse(getBit1AccessTimePresent(instance));
        assertFalse(getBit2CreateTimePresent(instance));
    }

    @Test(timeout = 4000)
    public void testSetFlagsWithAccessTimePresent() {
        X5455_ExtendedTimestamp instance = new X5455_ExtendedTimestamp();
        byte flags = 2; // ACCESS_TIME_BIT is 2
        instance.setFlags(flags);
        
        // Use reflection to access private fields
        assertFalse(getBit0ModifyTimePresent(instance));
        assertTrue(getBit1AccessTimePresent(instance));
        assertFalse(getBit2CreateTimePresent(instance));
    }

    @Test(timeout = 4000)
    public void testSetFlagsWithCreateTimePresent() {
        X5455_ExtendedTimestamp instance = new X5455_ExtendedTimestamp();
        byte flags = 4; // CREATE_TIME_BIT is 4
        instance.setFlags(flags);
        
        // Use reflection to access private fields
        assertFalse(getBit0ModifyTimePresent(instance));
        assertFalse(getBit1AccessTimePresent(instance));
        assertTrue(getBit2CreateTimePresent(instance));
    }

    @Test(timeout = 4000)
    public void testSetFlagsWithNoFlags() {
        X5455_ExtendedTimestamp instance = new X5455_ExtendedTimestamp();
        byte flags = 0; // No flags set
        instance.setFlags(flags);
        
        // Use reflection to access private fields
        assertFalse(getBit0ModifyTimePresent(instance));
        assertFalse(getBit1AccessTimePresent(instance));
        assertFalse(getBit2CreateTimePresent(instance));
    }

    // Reflection methods to access private fields
    private boolean getBit0ModifyTimePresent(X5455_ExtendedTimestamp instance) {
        try {
            java.lang.reflect.Field field = X5455_ExtendedTimestamp.class.getDeclaredField("bit0_modifyTimePresent");
            field.setAccessible(true);
            return field.getBoolean(instance);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean getBit1AccessTimePresent(X5455_ExtendedTimestamp instance) {
        try {
            java.lang.reflect.Field field = X5455_ExtendedTimestamp.class.getDeclaredField("bit1_accessTimePresent");
            field.setAccessible(true);
            return field.getBoolean(instance);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean getBit2CreateTimePresent(X5455_ExtendedTimestamp instance) {
        try {
            java.lang.reflect.Field field = X5455_ExtendedTimestamp.class.getDeclaredField("bit2_createTimePresent");
            field.setAccessible(true);
            return field.getBoolean(instance);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}