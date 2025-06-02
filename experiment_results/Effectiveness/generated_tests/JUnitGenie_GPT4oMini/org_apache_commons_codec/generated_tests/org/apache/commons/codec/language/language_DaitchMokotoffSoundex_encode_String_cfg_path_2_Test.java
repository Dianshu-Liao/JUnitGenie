package org.apache.commons.codec.language;
import org.apache.commons.codec.language.DaitchMokotoffSoundex;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class language_DaitchMokotoffSoundex_encode_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEncodeWithNullSource() {
        DaitchMokotoffSoundex soundex = new DaitchMokotoffSoundex();
        String result = soundex.encode(null);
        assertNull(result);
    }

}