package org.apache.commons.codec.cli;
import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class cli_Digest_run__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRunWithAllAlgorithms() {
        try {
            // Create an instance of Digest using reflection
            Class<Digest> digestClass = Digest.class;
            Constructor<Digest> constructor = digestClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            Digest digestInstance = constructor.newInstance((Object) new String[]{});

            // Set the private final field 'algorithm' using reflection
            java.lang.reflect.Field algorithmField = digestClass.getDeclaredField("algorithm");
            algorithmField.setAccessible(true);
            algorithmField.set(digestInstance, "ALL");

            // Invoke the private method 'run' using reflection
            Method runMethod = digestClass.getDeclaredMethod("run");
            runMethod.setAccessible(true);
            runMethod.invoke(digestInstance);
        } catch (Exception e) {
            fail("An exception was thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRunWithWildcardAlgorithm() {
        try {
            // Create an instance of Digest using reflection
            Class<Digest> digestClass = Digest.class;
            Constructor<Digest> constructor = digestClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            Digest digestInstance = constructor.newInstance((Object) new String[]{});

            // Set the private final field 'algorithm' using reflection
            java.lang.reflect.Field algorithmField = digestClass.getDeclaredField("algorithm");
            algorithmField.setAccessible(true);
            algorithmField.set(digestInstance, "*");

            // Invoke the private method 'run' using reflection
            Method runMethod = digestClass.getDeclaredMethod("run");
            runMethod.setAccessible(true);
            runMethod.invoke(digestInstance);
        } catch (Exception e) {
            fail("An exception was thrown: " + e.getMessage());
        }
    }

}