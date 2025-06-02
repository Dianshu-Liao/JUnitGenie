package org.apache.commons.codec.cli;
import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class cli_Digest_run_String_MessageDigest_File_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRun() {
        try {
            // Prepare the parameters for the run method
            String prefix = "Test Prefix";
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            File[] files = new File[] { new File("testFile.txt") };

            // Create an instance of the Digest class using reflection
            Class<Digest> digestClass = Digest.class;
            Method runMethod = digestClass.getDeclaredMethod("run", String.class, MessageDigest.class, File[].class);
            runMethod.setAccessible(true); // Make the private method accessible

            // Create a constructor for Digest that is accessible
            Constructor<Digest> constructor = digestClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            // Pass a valid argument to the constructor
            Digest digestInstance = constructor.newInstance((Object) new String[] { "SHA-256", "testFile.txt" });

            // Invoke the run method
            runMethod.invoke(digestInstance, prefix, messageDigest, files);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}