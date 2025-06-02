package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class text_StrSubstitutor_replaceIn_StrBuilder_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testReplaceIn_NonNullSource() {
        StrSubstitutor substitutor = new StrSubstitutor();
        StrBuilder validStrBuilder = new StrBuilder("Sample text");
        boolean result = false;
        try {
            result = substitutor.replaceIn(validStrBuilder); // Pass StrBuilder directly
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testReplaceIn_NullSource() {
        StrSubstitutor substitutor = new StrSubstitutor();
        boolean result = false;
        try {
            result = substitutor.replaceIn((StrBuilder) null); // Pass null as StrBuilder
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(result);
    }

}