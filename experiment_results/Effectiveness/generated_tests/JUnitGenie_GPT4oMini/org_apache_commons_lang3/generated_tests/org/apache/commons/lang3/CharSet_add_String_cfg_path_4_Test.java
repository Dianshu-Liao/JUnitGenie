package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharRange;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;
import static org.junit.Assert.assertTrue;

public class CharSet_add_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testAddWithNegatedRange() {
        CharSet charSet = new CharSet(new String[]{});
        String input = "^a-c"; // This should trigger the negated range logic

        try {
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            addMethod.invoke(charSet, input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Verify that the expected CharRange is added to the set
        Set<CharRange> expectedSet = Collections.synchronizedSet(new HashSet<>());
        expectedSet.add(CharRange.isNotIn('a', 'c'));
        assertTrue(charSet.getCharRanges().equals(expectedSet)); // Changed to use the correct public getter
    }

    @Test(timeout = 4000)
    public void testAddWithRange() {
        CharSet charSet = new CharSet(new String[]{});
        String input = "a-c"; // This should trigger the range logic

        try {
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            addMethod.invoke(charSet, input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Verify that the expected CharRange is added to the set
        Set<CharRange> expectedSet = Collections.synchronizedSet(new HashSet<>());
        expectedSet.add(CharRange.isIn('a', 'c'));
        assertTrue(charSet.getCharRanges().equals(expectedSet)); // Changed to use the correct public getter
    }

    @Test(timeout = 4000)
    public void testAddWithNegatedChar() {
        CharSet charSet = new CharSet(new String[]{});
        String input = "^a"; // This should trigger the negated char logic

        try {
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            addMethod.invoke(charSet, input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Verify that the expected CharRange is added to the set
        Set<CharRange> expectedSet = Collections.synchronizedSet(new HashSet<>());
        expectedSet.add(CharRange.isNot('a'));
        assertTrue(charSet.getCharRanges().equals(expectedSet)); // Changed to use the correct public getter
    }

    @Test(timeout = 4000)
    public void testAddWithSingleChar() {
        CharSet charSet = new CharSet(new String[]{});
        String input = "a"; // This should trigger the single char logic

        try {
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            addMethod.invoke(charSet, input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Verify that the expected CharRange is added to the set
        Set<CharRange> expectedSet = Collections.synchronizedSet(new HashSet<>());
        expectedSet.add(CharRange.is('a'));
        assertTrue(charSet.getCharRanges().equals(expectedSet)); // Changed to use the correct public getter
    }

}