package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.lang3.text.StrMatcher;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_replaceFirst_String_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testReplaceFirstWithNullSearchStr() {
        StrBuilder strBuilder = new StrBuilder("Hello World");
        StrBuilder result = strBuilder.replaceFirst(StrMatcher.stringMatcher(null), "New"); // Use StrMatcher to avoid ambiguity
        
        // Since searchStr is null, the method should return the original StrBuilder
        assertEquals("Hello World", result.toString());
    }


}