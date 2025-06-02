package org.joda.time.format;
import org.joda.time.format.DateTimeParserBucket;
import org.joda.time.format.DateTimeParserBucket.SavedField;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class format_DateTimeParserBucket_obtainSaveField__cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testObtainSaveField() {
        try {
            // Create an instance of DateTimeParserBucket
            DateTimeParserBucket bucket = new DateTimeParserBucket(0L, null, null);

            // Access the private method obtainSaveField using reflection
            Method method = DateTimeParserBucket.class.getDeclaredMethod("obtainSaveField");
            method.setAccessible(true);

            // Invoke the method
            SavedField result = (SavedField) method.invoke(bucket);

            // Assert that the result is not null
            assertNotNull(result);
        } catch (NoSuchMethodException e) {
            System.err.println("Method not found: " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.err.println("Access denied: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}