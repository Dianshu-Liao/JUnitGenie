package org.apache.commons.codec.language;
import org.apache.commons.codec.language.Soundex;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_Soundex__init__char_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSoundexConstructorWithHyphen() {
        char[] mapping = {'-', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        
        try {
            Soundex soundex = new Soundex(mapping);
            assertNotNull(soundex);
        } catch (Exception e) {
            fail("Constructor threw an exception: " + e.getMessage());
        }
    }

}