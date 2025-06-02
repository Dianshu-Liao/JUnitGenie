package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.junit.Test;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.Map;
import static org.junit.Assert.assertNotNull;

public class CSVParser_createEmptyHeaderMap__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCreateEmptyHeaderMap() {
        try {
            // Create an instance of CSVFormat with ignoreHeaderCase set to true
            CSVFormat format = CSVFormat.DEFAULT.withIgnoreHeaderCase(true);
            // Create an instance of CSVParser
            CSVParser csvParser = new CSVParser(new StringReader(""), format);

            // Access the private method createEmptyHeaderMap using reflection
            Method method = CSVParser.class.getDeclaredMethod("createEmptyHeaderMap");
            method.setAccessible(true);

            // Invoke the method
            Map<String, Integer> result = (Map<String, Integer>) method.invoke(csvParser);

            // Assert that the result is not null
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}