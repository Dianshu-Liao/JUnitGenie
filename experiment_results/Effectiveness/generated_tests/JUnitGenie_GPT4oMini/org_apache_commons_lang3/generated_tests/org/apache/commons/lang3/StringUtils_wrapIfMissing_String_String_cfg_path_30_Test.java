package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_30_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissing_WithNullStr_ShouldReturnNull() {
        String str = null; // setting str to null to meet External_Method_Parameters_Constraints
        String wrapWith = "test";

        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals(null, result);
        } catch (Exception e) {
            // handle exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_WithNullWrapWith_ShouldReturnNull() {
        String str = "example"; 
        String wrapWith = null; // wrapWith is null

        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals("example", result); // It should return the original str
        } catch (Exception e) {
            // handle exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_WithMissingWrapping_ShouldWrap() {
        String str = "example"; 
        String wrapWith = "test";

        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals("testexampletest", result); // It should wrap str with wrapWith
        } catch (Exception e) {
            // handle exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_WithAlreadyWrappedString_ShouldReturnOriginal() {
        String str = "testexampletest"; 
        String wrapWith = "test";

        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals("testexampletest", result); // It should return original str since it is already wrapped
        } catch (Exception e) {
            // handle exception
            e.printStackTrace();
        }
    }

}