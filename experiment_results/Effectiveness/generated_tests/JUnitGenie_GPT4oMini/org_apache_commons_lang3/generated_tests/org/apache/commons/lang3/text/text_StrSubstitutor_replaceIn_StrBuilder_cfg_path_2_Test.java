package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class text_StrSubstitutor_replaceIn_StrBuilder_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testReplaceIn_NullSource() {
        StrSubstitutor substitutor = new StrSubstitutor();
        StrBuilder source = null;

        // Testing the case where source is null
        boolean result = substitutor.replaceIn(source);
        assertFalse(result);
    }

}