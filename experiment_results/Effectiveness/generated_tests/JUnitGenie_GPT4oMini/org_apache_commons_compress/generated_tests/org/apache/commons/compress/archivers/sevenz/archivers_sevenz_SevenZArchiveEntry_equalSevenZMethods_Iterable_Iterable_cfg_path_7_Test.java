package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZMethod;
import org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class archivers_sevenz_SevenZArchiveEntry_equalSevenZMethods_Iterable_Iterable_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testEqualSevenZMethods() {
        try {
            // Create instances of SevenZMethodConfiguration
            SevenZMethod method1 = SevenZMethod.LZMA; // Use the enum value directly
            SevenZMethod method2 = SevenZMethod.LZMA; // Use the enum value directly

            // Create valid configuration options for LZMA
            SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(method1, new Object[]{}); // Pass an empty array instead of new Object()
            SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(method2, new Object[]{}); // Pass an empty array instead of new Object()

            // Prepare parameter lists
            List<SevenZMethodConfiguration> c1 = new ArrayList<>();
            List<SevenZMethodConfiguration> c2 = new ArrayList<>();
            c1.add(config1);
            c2.add(config2);

            // Access the private method using reflection
            Method method = SevenZArchiveEntry.class.getDeclaredMethod("equalSevenZMethods", Iterable.class, Iterable.class);
            method.setAccessible(true);

            // Call the method
            boolean result = (Boolean) method.invoke(new SevenZArchiveEntry(), c1, c2);
            assertTrue(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}