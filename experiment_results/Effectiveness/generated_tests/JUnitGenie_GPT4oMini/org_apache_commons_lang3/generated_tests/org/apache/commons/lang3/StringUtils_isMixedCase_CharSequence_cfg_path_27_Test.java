package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import static org.junit.Assert.*;
import org.junit.Test;

public class StringUtils_isMixedCase_CharSequence_cfg_path_27_Test {

    @Test(timeout = 4000)
    public void testIsMixedCaseEmpty() {
        // Testing an empty CharSequence
        CharSequence cs = "";
        try {
            assertFalse(StringUtils.isMixedCase(cs));
        } catch (Exception e) {
            // Handling exception if any
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsMixedCaseSingleCharacterUppercase() {
        // Testing a single uppercase character
        CharSequence cs = "A";
        try {
            assertFalse(StringUtils.isMixedCase(cs));
        } catch (Exception e) {
            // Handling exception if any
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsMixedCaseSingleCharacterLowercase() {
        // Testing a single lowercase character
        CharSequence cs = "a";
        try {
            assertFalse(StringUtils.isMixedCase(cs));
        } catch (Exception e) {
            // Handling exception if any
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsMixedCaseAllLowercase() {
        // Testing a CharSequence with all lowercase letters
        CharSequence cs = "lowercase";
        try {
            assertFalse(StringUtils.isMixedCase(cs));
        } catch (Exception e) {
            // Handling exception if any
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsMixedCaseAllUppercase() {
        // Testing a CharSequence with all uppercase letters
        CharSequence cs = "UPPERCASE";
        try {
            assertFalse(StringUtils.isMixedCase(cs));
        } catch (Exception e) {
            // Handling exception if any
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsMixedCaseMixedCase() {
        // Testing a CharSequence with mixed case letters
        CharSequence cs = "MixedCase";
        try {
            assertTrue(StringUtils.isMixedCase(cs));
        } catch (Exception e) {
            // Handling exception if any
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsMixedCaseNull() {
        // Testing a null CharSequence
        CharSequence cs = null;
        try {
            assertFalse(StringUtils.isMixedCase(cs));
        } catch (Exception e) {
            // Handling exception if any
            e.printStackTrace();
        }
    }

}