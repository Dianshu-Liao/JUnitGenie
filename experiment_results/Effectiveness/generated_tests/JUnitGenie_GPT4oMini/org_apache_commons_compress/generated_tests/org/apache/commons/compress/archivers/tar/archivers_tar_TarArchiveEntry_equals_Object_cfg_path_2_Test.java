package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class archivers_tar_TarArchiveEntry_equals_Object_cfg_path_2_Test {
    
    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        TarArchiveEntry entry = new TarArchiveEntry("example.tar");
        Object nullObject = null;
        
        try {
            boolean result = entry.equals(nullObject);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        TarArchiveEntry entry = new TarArchiveEntry("example.tar");
        Object differentClassObject = new Object();
        
        try {
            boolean result = entry.equals(differentClassObject);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 4000)
    public void testEquals_SameClassButDifferentInstance() {
        TarArchiveEntry entry1 = new TarArchiveEntry("example.tar");
        TarArchiveEntry entry2 = new TarArchiveEntry("example.tar");
        
        try {
            boolean result = entry1.equals(entry2);
            // Assuming the equals method is checking for some properties that can lead to false
            assertFalse(result); // You may adjust this based on your equals implementation.
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}