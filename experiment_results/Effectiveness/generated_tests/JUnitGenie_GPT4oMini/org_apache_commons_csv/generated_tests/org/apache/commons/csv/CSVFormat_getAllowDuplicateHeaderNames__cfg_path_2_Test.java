package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.DuplicateHeaderMode;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import static org.junit.Assert.assertTrue;

public class CSVFormat_getAllowDuplicateHeaderNames__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetAllowDuplicateHeaderNames() {
        try {
            // Use reflection to access the private constructor
            Constructor<CSVFormat> constructor = CSVFormat.class.getDeclaredConstructor(DuplicateHeaderMode.class);
            constructor.setAccessible(true);
            CSVFormat csvFormat = constructor.newInstance(DuplicateHeaderMode.ALLOW_ALL);

            // Call the method and assert the expected result
            boolean result = csvFormat.getAllowDuplicateHeaderNames();
            assertTrue(result);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}