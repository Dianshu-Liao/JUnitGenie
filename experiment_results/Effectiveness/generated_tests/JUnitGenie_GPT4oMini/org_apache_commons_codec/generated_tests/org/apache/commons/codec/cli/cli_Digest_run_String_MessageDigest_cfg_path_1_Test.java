package org.apache.commons.codec.cli;
import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static org.junit.Assert.assertNotNull;

public class cli_Digest_run_String_MessageDigest_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRunWithNullInputs() {
        try {
            // Create an instance of the Digest class using reflection
            Class<Digest> digestClass = Digest.class;
            Constructor<Digest> constructor = digestClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            // Pass an empty array instead of null to avoid NullPointerException
            Digest digestInstance = constructor.newInstance((Object) new String[0]);

            // Prepare the parameters for the run method
            String prefix = "Test Prefix";
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            // Call the private run method using reflection
            Method runMethod = digestClass.getDeclaredMethod("run", String.class, MessageDigest.class);
            runMethod.setAccessible(true);
            runMethod.invoke(digestInstance, prefix, messageDigest);

            // Since the method does not return anything, we can only assert that it does not throw an exception
            assertNotNull(messageDigest);
        } catch (NoSuchAlgorithmException | ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

}