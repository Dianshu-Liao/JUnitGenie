package org.apache.commons.codec.cli;
import org.apache.commons.codec.cli.Digest;
import org.junit.Test;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.lang.reflect.Method;

public class cli_Digest_run_String_MessageDigest_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testRunWithValidInputs() {
        try {
            // Create an instance of the Digest class using reflection
            Digest digestInstance = Digest.class.getDeclaredConstructor().newInstance();

            // Prepare the parameters for the run method
            String prefix = "Test Prefix";
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            // Access the private run method using reflection
            Method runMethod = Digest.class.getDeclaredMethod("run", String.class, MessageDigest.class);
            runMethod.setAccessible(true);

            // Call the run method
            runMethod.invoke(digestInstance, prefix, messageDigest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}