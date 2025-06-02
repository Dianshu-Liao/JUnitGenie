package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrMatcher;
import org.apache.commons.lang3.text.StrTokenizer;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class text_StrTokenizer_setTrimmerMatcher_StrMatcher_cfg_path_1_Test {

    // Concrete implementation of StrMatcher for testing
    private static class TestStrMatcher extends StrMatcher {
        @Override
        public int isMatch(char[] buffer, int start, int end, int strIndex) {
            return 0; // Implement as required for your tests
        }
    }

    @Test(timeout = 4000)
    public void testSetTrimmerMatcher() {
        StrTokenizer tokenizer = new StrTokenizer();
        StrMatcher trimmer = new TestStrMatcher(); // Create an instance of the concrete class
        
        // Invoking the method to cover the specified CFGPath
        StrTokenizer result = tokenizer.setTrimmerMatcher(trimmer);

        // Verifying the result
        assertSame(tokenizer, result); // Check that we get the same instance returned
    }

    @Test(timeout = 4000)
    public void testSetTrimmerMatcherWithNull() {
        StrTokenizer tokenizer = new StrTokenizer();
        StrMatcher trimmer = null; // Testing condition where trimmer is null

        try {
            StrTokenizer result = tokenizer.setTrimmerMatcher(trimmer);
            assertSame(tokenizer, result); // Verify it still returns the same instance
        } catch (Exception e) {
            // Handle exception if needed
        }
    }

}