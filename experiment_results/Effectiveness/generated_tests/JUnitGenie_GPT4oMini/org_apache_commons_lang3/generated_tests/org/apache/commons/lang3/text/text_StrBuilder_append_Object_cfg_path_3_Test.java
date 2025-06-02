package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_append_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAppend_NullObject() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.setNullText(null); // Ensure nullText is set to null

        // Act
        StrBuilder result = strBuilder.append((Object) null); // Explicitly cast to Object

        // Assert
        assertEquals(strBuilder, result);
    }


}