package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.lang.reflect.Method;

public class CSVFormat_trim_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testTrimWithTrimEnabled() {
        try {
            // Create an instance of CSVFormat using reflection
            Class<?> csvFormatClass = CSVFormat.class;
            Method builderMethod = csvFormatClass.getDeclaredMethod("builder");
            builderMethod.setAccessible(true);
            Object builder = builderMethod.invoke(null);
            Method setTrimMethod = builder.getClass().getMethod("setTrim", boolean.class);
            setTrimMethod.invoke(builder, true);
            Method buildMethod = builder.getClass().getMethod("build");
            CSVFormat csvFormat = (CSVFormat) buildMethod.invoke(builder);

            // Test the trim method
            String input = "   test   ";
            String expected = "test";
            String actual = csvFormat.trim(input);
            assertEquals(expected, actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testTrimWithTrimDisabled() {
        try {
            // Create an instance of CSVFormat using reflection
            Class<?> csvFormatClass = CSVFormat.class;
            Method builderMethod = csvFormatClass.getDeclaredMethod("builder");
            builderMethod.setAccessible(true);
            Object builder = builderMethod.invoke(null);
            Method setTrimMethod = builder.getClass().getMethod("setTrim", boolean.class);
            setTrimMethod.invoke(builder, false);
            Method buildMethod = builder.getClass().getMethod("build");
            CSVFormat csvFormat = (CSVFormat) buildMethod.invoke(builder);

            // Test the trim method
            String input = "   test   ";
            String expected = "   test   ";
            String actual = csvFormat.trim(input);
            assertEquals(expected, actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}