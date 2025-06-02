package org.apache.commons.codec.cli;
import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class cli_Digest_run__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testRunWithAllAlgorithm() {
        try {
            // Create an instance of Digest using reflection
            Class<Digest> digestClass = Digest.class;
            Constructor<Digest> constructor = digestClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            Digest digestInstance = constructor.newInstance((Object) new String[]{"ALL", "dummyFile.txt"});

            // Access the private run method using reflection
            Method runMethod = digestClass.getDeclaredMethod("run");
            runMethod.setAccessible(true);

            // Invoke the run method
            runMethod.invoke(digestInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testRunWithWildcardAlgorithm() {
        try {
            // Create an instance of Digest using reflection
            Class<Digest> digestClass = Digest.class;
            Constructor<Digest> constructor = digestClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            Digest digestInstance = constructor.newInstance((Object) new String[]{"*", "dummyFile.txt"});

            // Access the private run method using reflection
            Method runMethod = digestClass.getDeclaredMethod("run");
            runMethod.setAccessible(true);

            // Invoke the run method
            runMethod.invoke(digestInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}