package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrSubstitutor_replace_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testReplaceWithNonNullSource() {
        StrSubstitutor substitutor = new StrSubstitutor();
        Object source = "Test String";
        StrBuilder expectedBuf = new StrBuilder().append(source);
        
        String result = substitutor.replace(source);
        
        // Verify that the result matches the expected output
        assertEquals(expectedBuf.toString(), result);
    }

    @Test(timeout = 4000)
    public void testReplaceWithNullSource() {
        StrSubstitutor substitutor = new StrSubstitutor();
        Object source = null;

        String result = substitutor.replace(source);
        
        // Verify that the result is null when source is null
        assertEquals(null, result);
    }

}