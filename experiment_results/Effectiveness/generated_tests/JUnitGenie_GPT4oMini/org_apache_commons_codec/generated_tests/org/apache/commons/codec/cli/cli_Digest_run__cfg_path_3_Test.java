package org.apache.commons.codec.cli;
import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import static org.junit.Assert.fail;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class cli_Digest_run__cfg_path_3_Test {

    @Test(timeout = 10000) // Increased timeout to allow for longer processing
    public void testRunWithValidAlgorithm() {
        try {
            // Create an instance of Digest using reflection
            Class<?> digestClass = Digest.class;
            Constructor<?> constructor = digestClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            Digest digestInstance = (Digest) constructor.newInstance((Object) new String[]{"SHA-256"});

            // Access the private run method using reflection
            Method runMethod = digestClass.getDeclaredMethod("run");
            runMethod.setAccessible(true);
            runMethod.invoke(digestInstance);
        } catch (Exception e) {
            fail("An exception was thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 10000) // Increased timeout to allow for longer processing
    public void testRunWithAllAlgorithm() {
        try {
            // Create an instance of Digest using reflection
            Class<?> digestClass = Digest.class;
            Constructor<?> constructor = digestClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            Digest digestInstance = (Digest) constructor.newInstance((Object) new String[]{"ALL"});

            // Access the private run method using reflection
            Method runMethod = digestClass.getDeclaredMethod("run");
            runMethod.setAccessible(true);
            runMethod.invoke(digestInstance);
        } catch (Exception e) {
            fail("An exception was thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 10000) // Increased timeout to allow for longer processing
    public void testRunWithWildcardAlgorithm() {
        try {
            // Create an instance of Digest using reflection
            Class<?> digestClass = Digest.class;
            Constructor<?> constructor = digestClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            Digest digestInstance = (Digest) constructor.newInstance((Object) new String[]{"*"});

            // Access the private run method using reflection
            Method runMethod = digestClass.getDeclaredMethod("run");
            runMethod.setAccessible(true);
            runMethod.invoke(digestInstance);
        } catch (Exception e) {
            fail("An exception was thrown: " + e.getMessage());
        }
    }


}