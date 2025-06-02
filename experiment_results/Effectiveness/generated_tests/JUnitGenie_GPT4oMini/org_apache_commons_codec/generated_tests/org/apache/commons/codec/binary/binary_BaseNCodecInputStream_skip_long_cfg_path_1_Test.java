package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.BaseNCodecInputStream;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.fail;

public class binary_BaseNCodecInputStream_skip_long_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSkipNegativeValue() {
        BaseNCodecInputStream inputStream = new BaseNCodecInputStream(System.in, null, false);
        try {
            inputStream.skip(-1);
            fail("Expected IllegalArgumentException for negative skip length");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (IOException e) {
            fail("Unexpected IOException: " + e.getMessage());
        }
    }

}