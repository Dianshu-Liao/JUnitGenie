package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_setNullText_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSetNullTextWithEmptyString() {
        StrBuilder strBuilder = new StrBuilder();
        String nullText = ""; // This will trigger the condition to set nullText to null

        try {
            strBuilder.setNullText(nullText);
            // Use a method to retrieve the nullText instead of accessing it directly
            assertEquals(nullText, strBuilder.getNullText()); // Verify that nullText is set to the empty string
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}