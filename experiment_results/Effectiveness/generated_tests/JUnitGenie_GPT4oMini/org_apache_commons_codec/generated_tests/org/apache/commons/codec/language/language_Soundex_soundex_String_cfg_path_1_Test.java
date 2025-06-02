package org.apache.commons.codec.language;
import org.apache.commons.codec.language.Soundex;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class language_Soundex_soundex_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSoundexWithNullInput() {
        Soundex soundex = new Soundex();
        try {
            String result = soundex.soundex(null);
            assertNull(result);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

}