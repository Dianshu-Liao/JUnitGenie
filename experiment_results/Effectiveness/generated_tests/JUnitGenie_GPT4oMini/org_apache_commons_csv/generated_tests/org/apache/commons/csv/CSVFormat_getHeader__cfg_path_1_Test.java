package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class CSVFormat_getHeader__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetHeaderWhenHeadersIsNull() {
        // Create an instance of CSVFormat using reflection to access the private constructor
        CSVFormat csvFormat = null;
        try {
            java.lang.reflect.Constructor<CSVFormat> constructor = CSVFormat.class.getDeclaredConstructor(org.apache.commons.csv.CSVFormat.Builder.class);
            constructor.setAccessible(true);
            csvFormat = constructor.newInstance((org.apache.commons.csv.CSVFormat.Builder) null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Call the method under test
        String[] result = csvFormat.getHeader();

        // Verify the result
        assertArrayEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testGetHeaderWhenHeadersIsNotNull() {
        // Create an instance of CSVFormat using reflection to access the private constructor
        CSVFormat csvFormat = null;
        try {
            java.lang.reflect.Constructor<CSVFormat> constructor = CSVFormat.class.getDeclaredConstructor(org.apache.commons.csv.CSVFormat.Builder.class);
            constructor.setAccessible(true);
            csvFormat = constructor.newInstance((org.apache.commons.csv.CSVFormat.Builder) null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set the headers field using reflection
        try {
            java.lang.reflect.Field headersField = CSVFormat.class.getDeclaredField("headers");
            headersField.setAccessible(true);
            headersField.set(csvFormat, new String[]{"Header1", "Header2"});
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Call the method under test
        String[] result = csvFormat.getHeader();

        // Verify the result
        assertArrayEquals(new String[]{"Header1", "Header2"}, result);
    }

}