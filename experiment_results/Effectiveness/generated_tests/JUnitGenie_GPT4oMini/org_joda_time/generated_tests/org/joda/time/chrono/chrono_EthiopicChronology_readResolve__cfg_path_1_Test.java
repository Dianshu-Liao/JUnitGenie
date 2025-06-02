package org.joda.time.chrono;
import org.joda.time.chrono.EthiopicChronology;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class chrono_EthiopicChronology_readResolve__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testReadResolve() {
        try {
            // Create an instance of EthiopicChronology with valid parameters
            EthiopicChronology chronology = EthiopicChronology.getInstance(DateTimeZone.UTC);

            // Access the private method readResolve using reflection
            Method method = EthiopicChronology.class.getDeclaredMethod("readResolve");
            method.setAccessible(true);

            // Invoke the method
            Object result = method.invoke(chronology);

            // Validate the result
            assertNotNull("The result of readResolve should not be null", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}