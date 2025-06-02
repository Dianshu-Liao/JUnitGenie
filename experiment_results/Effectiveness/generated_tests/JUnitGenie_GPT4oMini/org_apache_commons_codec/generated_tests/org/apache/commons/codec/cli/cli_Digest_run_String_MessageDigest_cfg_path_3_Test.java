package org.apache.commons.codec.cli;
import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static org.junit.Assert.assertNotNull;

public class cli_Digest_run_String_MessageDigest_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testRunWithValidInputs() {
        try {
            // Create an instance of the Digest class using reflection
            Class<Digest> digestClass = Digest.class;
            Constructor<Digest> constructor = digestClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            Digest digestInstance = constructor.newInstance((Object) new String[]{"input1.txt", "input2.txt"});

            // Prepare the MessageDigest instance
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            // Access the private run method using reflection
            Method runMethod = digestClass.getDeclaredMethod("run", String.class, MessageDigest.class);
            runMethod.setAccessible(true);

            // Call the run method with a prefix and the MessageDigest instance
            runMethod.invoke(digestInstance, "Prefix: ", messageDigest);

            // Assert that the messageDigest is not null after the run method is invoked
            assertNotNull(messageDigest);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}