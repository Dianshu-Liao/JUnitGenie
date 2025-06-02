package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class text_StrSubstitutor_replaceIn_StringBuffer_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testReplaceIn_NullSource() {
        StrSubstitutor strSubstitutor = new StrSubstitutor();
        StringBuffer source = null;

        try {
            boolean result = strSubstitutor.replaceIn(source);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}