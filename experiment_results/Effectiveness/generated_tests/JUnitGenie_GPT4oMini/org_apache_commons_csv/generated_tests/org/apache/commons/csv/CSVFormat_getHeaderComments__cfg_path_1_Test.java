package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class CSVFormat_getHeaderComments__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetHeaderComments_Null() {
        // Create an instance of CSVFormat with reflection to bypass the private constructor
        CSVFormat csvFormat = getCSVFormatInstanceWithNullHeaderComments();

        // Call the focal method
        String[] result = csvFormat.getHeaderComments();

        // Assert that the result is null
        assertArrayEquals(null, result);
    }

    private CSVFormat getCSVFormatInstanceWithNullHeaderComments() {
        try {
            // Access the private constructor via reflection
            java.lang.reflect.Constructor<CSVFormat> constructor = CSVFormat.class.getDeclaredConstructor(org.apache.commons.csv.CSVFormat.Builder.class);
            constructor.setAccessible(true);
            // Create a new instance of CSVFormat with a null value for headerComments
            org.apache.commons.csv.CSVFormat.Builder builder = org.apache.commons.csv.CSVFormat.Builder.create();
            builder.setHeaderComments(null); // set headerComments to null
            return constructor.newInstance(builder);
        } catch (Exception e) {
            // handle any exceptions that may occur
            e.printStackTrace();
            return null;
        }
    }


}