package org.apache.commons.codec.language.bm;
import org.apache.commons.codec.language.bm.BeiderMorseEncoder;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class language_bm_BeiderMorseEncoder_encode_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEncode_NullSource() {
        BeiderMorseEncoder encoder = new BeiderMorseEncoder();
        try {
            String result = encoder.encode(null);
            assertNull(result);
        } catch (EncoderException e) {
            // Handle the exception according to rule 4
        }
    }

}