package org.apache.commons.codec.cli;
import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.junit.Test;
import java.lang.reflect.Method;
import java.io.IOException;

public class cli_Digest_run__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRun_withAllAlgorithm() {
        try {
            String[] args = new String[]{"someArgument"};
            Digest digest = (Digest) Digest.class.getDeclaredConstructor(String[].class).newInstance((Object) args);
            Method method = Digest.class.getDeclaredMethod("run");
            method.setAccessible(true);

            // Set the algorithm to "ALL" to hit the relevant CFG Path
            setAlgorithmField(digest, "ALL");

            // Execute the method
            method.invoke(digest);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setAlgorithmField(Digest digest, String algorithm) throws Exception {
        // Using reflection to set the private field 'algorithm'
        java.lang.reflect.Field field = Digest.class.getDeclaredField("algorithm");
        field.setAccessible(true);
        field.set(digest, algorithm);
    }


}