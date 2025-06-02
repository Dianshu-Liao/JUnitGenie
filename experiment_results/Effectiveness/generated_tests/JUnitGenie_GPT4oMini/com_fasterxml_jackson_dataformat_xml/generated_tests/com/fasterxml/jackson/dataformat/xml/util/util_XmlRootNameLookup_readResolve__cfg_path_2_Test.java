package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class util_XmlRootNameLookup_readResolve__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testReadResolve_whenRootNamesIsNull() {
        try {
            // Create an instance of XmlRootNameLookup
            XmlRootNameLookup lookup = new XmlRootNameLookup();
            
            // Use reflection to access the protected method readResolve
            Method method = XmlRootNameLookup.class.getDeclaredMethod("readResolve");
            method.setAccessible(true);
            
            // Set _rootNames to null to trigger the condition
            // Note: Since _rootNames is final and protected, we need to use reflection to set it
            java.lang.reflect.Field field = XmlRootNameLookup.class.getDeclaredField("_rootNames");
            field.setAccessible(true);
            field.set(lookup, null);
            
            // Invoke the readResolve method
            Object result = method.invoke(lookup);
            
            // Assert that the result is not null
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}