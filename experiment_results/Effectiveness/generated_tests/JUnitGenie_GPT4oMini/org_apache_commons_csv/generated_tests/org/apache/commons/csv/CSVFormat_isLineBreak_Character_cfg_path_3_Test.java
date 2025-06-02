package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class CSVFormat_isLineBreak_Character_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsLineBreakWithNull() {
        try {
            Method method = CSVFormat.class.getDeclaredMethod("isLineBreak", Character.class);
            method.setAccessible(true);
            boolean result = (Boolean) method.invoke(null, (Character) null);
            assertEquals(false, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}