package org.joda.time.format;
import org.joda.time.format.DateTimeParserBucket;
import org.joda.time.format.DateTimeParserBucket.SavedField;
import org.junit.Test;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import static org.junit.Assert.assertNotNull;

public class format_DateTimeParserBucket_obtainSaveField__cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testObtainSaveField() {
        // Create an instance of DateTimeParserBucket
        DateTimeParserBucket bucket = new DateTimeParserBucket(0L, null, null);

        // Access the private method obtainSaveField using reflection
        try {
            Method method = DateTimeParserBucket.class.getDeclaredMethod("obtainSaveField");
            method.setAccessible(true); // Make the private method accessible

            // Call the method and get the result
            SavedField result = (SavedField) method.invoke(bucket);

            // Assert that the result is not null
            assertNotNull("The obtained SavedField should not be null", result);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.err.println("Access to the method was denied. Ensure that the security manager allows reflection.");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}