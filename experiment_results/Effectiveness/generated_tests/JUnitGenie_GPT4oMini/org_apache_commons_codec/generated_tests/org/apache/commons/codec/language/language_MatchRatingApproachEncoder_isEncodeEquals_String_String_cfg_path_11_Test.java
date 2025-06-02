package org.apache.commons.codec.language;
import org.apache.commons.codec.language.MatchRatingApproachEncoder;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class language_MatchRatingApproachEncoder_isEncodeEquals_String_String_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testIsEncodeEqualsWithNullName1() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        String name1 = null;
        String name2 = "John Doe";
        try {
            boolean result = encoder.isEncodeEquals(name1, name2);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsEncodeEqualsWithNullName2() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        String name1 = "John Doe";
        String name2 = null;
        try {
            boolean result = encoder.isEncodeEquals(name1, name2);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsEncodeEqualsWithEmptyName1() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        String name1 = "";
        String name2 = "John Doe";
        try {
            boolean result = encoder.isEncodeEquals(name1, name2);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsEncodeEqualsWithEmptyName2() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        String name1 = "John Doe";
        String name2 = "";
        try {
            boolean result = encoder.isEncodeEquals(name1, name2);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsEncodeEqualsWithSpaceName1() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        String name1 = " ";
        String name2 = "John Doe";
        try {
            boolean result = encoder.isEncodeEquals(name1, name2);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsEncodeEqualsWithSpaceName2() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        String name1 = "John Doe";
        String name2 = " ";
        try {
            boolean result = encoder.isEncodeEquals(name1, name2);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsEncodeEqualsWithSingleCharacterName1() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        String name1 = "A";
        String name2 = "John Doe";
        try {
            boolean result = encoder.isEncodeEquals(name1, name2);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsEncodeEqualsWithSingleCharacterName2() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        String name1 = "John Doe";
        String name2 = "B";
        try {
            boolean result = encoder.isEncodeEquals(name1, name2);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}