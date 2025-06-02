package org.apache.commons.codec.cli;
import org.apache.commons.codec.cli.Digest;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class cli_Digest_println_String_byte_____String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPrintlnWithValidParameters() {
        try {
            // Create an instance of the Digest class using a constructor that accepts a String array
            String[] args = new String[]{"SHA-256", "testfile.txt"}; // Provide valid parameters
            // Use reflection to access the private constructor
            Constructor<Digest> constructor = Digest.class.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            Digest digest = constructor.newInstance((Object) args);

            // Prepare parameters
            String prefix = "TestPrefix: ";
            byte[] digestBytes = new byte[]{0x01, 0x02, 0x03}; // Example byte array
            String fileName = "testfile.txt";

            // Access the private method println using reflection
            Method method = Digest.class.getDeclaredMethod("println", String.class, byte[].class, String.class);
            method.setAccessible(true);

            // Invoke the method
            method.invoke(digest, prefix, digestBytes, fileName);

        } catch (Exception e) {
            // Handle exception for testing
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testPrintlnWithNullFileName() {
        try {
            // Create an instance of the Digest class using a constructor that accepts a String array
            String[] args = new String[]{"SHA-256", "testfile.txt"}; // Provide valid parameters
            // Use reflection to access the private constructor
            Constructor<Digest> constructor = Digest.class.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            Digest digest = constructor.newInstance((Object) args);

            // Prepare parameters
            String prefix = "TestPrefix: ";
            byte[] digestBytes = new byte[]{0x01, 0x02, 0x03}; // Example byte array
            String fileName = null;

            // Access the private method println using reflection
            Method method = Digest.class.getDeclaredMethod("println", String.class, byte[].class, String.class);
            method.setAccessible(true);

            // Invoke the method
            method.invoke(digest, prefix, digestBytes, fileName);

        } catch (Exception e) {
            // Handle exception for testing
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testPrintlnWithEmptyByteArray() {
        try {
            // Create an instance of the Digest class using a constructor that accepts a String array
            String[] args = new String[]{"SHA-256", "testfile.txt"}; // Provide valid parameters
            // Use reflection to access the private constructor
            Constructor<Digest> constructor = Digest.class.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            Digest digest = constructor.newInstance((Object) args);

            // Prepare parameters
            String prefix = "TestPrefix: ";
            byte[] digestBytes = new byte[0]; // Empty byte array
            String fileName = "testfile.txt";

            // Access the private method println using reflection
            Method method = Digest.class.getDeclaredMethod("println", String.class, byte[].class, String.class);
            method.setAccessible(true);

            // Invoke the method
            method.invoke(digest, prefix, digestBytes, fileName);

        } catch (Exception e) {
            // Handle exception for testing
            e.printStackTrace();
        }
    }


}