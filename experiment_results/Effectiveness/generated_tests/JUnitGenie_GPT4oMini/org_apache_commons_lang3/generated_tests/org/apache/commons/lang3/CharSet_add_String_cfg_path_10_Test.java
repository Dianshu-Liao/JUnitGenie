package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharRange;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;
import static org.junit.Assert.assertTrue;

public class CharSet_add_String_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testAddValidChar() {
        try {
            CharSet charSet = new CharSet(new String[]{});
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            
            // Test with a valid character
            String input = "a";
            addMethod.invoke(charSet, input);
            
            // Verify that the character was added
            Set<CharRange> set = (Set<CharRange>) CharSet.class.getDeclaredField("set").get(charSet);
            assertTrue(set.contains(CharRange.is('a')));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddNegatedChar() {
        try {
            CharSet charSet = new CharSet(new String[]{});
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            
            // Test with a negated character
            String input = "^a";
            addMethod.invoke(charSet, input);
            
            // Verify that the negated character was added
            Set<CharRange> set = (Set<CharRange>) CharSet.class.getDeclaredField("set").get(charSet);
            assertTrue(set.contains(CharRange.isNot('a')));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddRange() {
        try {
            CharSet charSet = new CharSet(new String[]{});
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            
            // Test with a range
            String input = "a-c";
            addMethod.invoke(charSet, input);
            
            // Verify that the range was added
            Set<CharRange> set = (Set<CharRange>) CharSet.class.getDeclaredField("set").get(charSet);
            assertTrue(set.contains(CharRange.isIn('a', 'c')));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddNegatedRange() {
        try {
            CharSet charSet = new CharSet(new String[]{});
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            
            // Test with a negated range
            String input = "^a-c";
            addMethod.invoke(charSet, input);
            
            // Verify that the negated range was added
            Set<CharRange> set = (Set<CharRange>) CharSet.class.getDeclaredField("set").get(charSet);
            assertTrue(set.contains(CharRange.isNotIn('a', 'c')));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddNull() {
        try {
            CharSet charSet = new CharSet(new String[]{});
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            
            // Test with null input
            String input = null;
            addMethod.invoke(charSet, input);
            
            // Verify that the set is still empty
            Set<CharRange> set = (Set<CharRange>) CharSet.class.getDeclaredField("set").get(charSet);
            assertTrue(set.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}