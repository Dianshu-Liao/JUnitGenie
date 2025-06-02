package org.joda.time.format;
import org.joda.time.format.PeriodFormatterBuilder;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Field;
import java.util.List;

public class format_PeriodFormatterBuilder_clear__cfg_path_1_Test {
    
    @Test(timeout = 4000)
    public void testClear() {
        // Arrange
        PeriodFormatterBuilder builder = new PeriodFormatterBuilder();
        
        // Act
        builder.clear();
        
        // Assert
        assertEquals(1, getPrivateField(builder, "iMinPrintedDigits"));
        assertEquals(2, getPrivateField(builder, "iPrintZeroSetting"));
        assertEquals(10, getPrivateField(builder, "iMaxParsedDigits"));
        assertFalse((Boolean) getPrivateField(builder, "iRejectSignedValues")); // Cast to Boolean
        assertNull(getPrivateField(builder, "iPrefix"));
        assertNotNull(getPrivateField(builder, "iElementPairs"));
        assertTrue(((List<Object>) getPrivateField(builder, "iElementPairs")).isEmpty());
        assertFalse((Boolean) getPrivateField(builder, "iNotPrinter")); // Cast to Boolean
        assertFalse((Boolean) getPrivateField(builder, "iNotParser")); // Cast to Boolean
        assertNotNull(getPrivateField(builder, "iFieldFormatters"));
        assertEquals(10, ((Object[]) getPrivateField(builder, "iFieldFormatters")).length); // Changed FieldFormatter[] to Object[]
    }
    
    private Object getPrivateField(PeriodFormatterBuilder builder, String fieldName) {
        try {
            Field field = PeriodFormatterBuilder.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(builder);
        } catch (Exception e) {
            fail("Failed to access private field: " + fieldName);
            return null;
        }
    }

}