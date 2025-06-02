package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharRange;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;
import static org.junit.Assert.assertTrue;

public class CharSet_add_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAddValidCharacter() {
        try {
            // Create an instance of CharSet
            CharSet charSet = new CharSet(new String[]{});

            // Access the protected method 'add' using reflection
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test input that should add a valid character
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
    public void testAddNegatedCharacter() {
        try {
            // Create an instance of CharSet
            CharSet charSet = new CharSet(new String[]{});

            // Access the protected method 'add' using reflection
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test input that should add a negated character
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
            // Create an instance of CharSet
            CharSet charSet = new CharSet(new String[]{});

            // Access the protected method 'add' using reflection
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test input that should add a range
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
            // Create an instance of CharSet
            CharSet charSet = new CharSet(new String[]{});

            // Access the protected method 'add' using reflection
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test input that should add a negated range
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
            // Create an instance of CharSet
            CharSet charSet = new CharSet(new String[]{});

            // Access the protected method 'add' using reflection
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);

            // Test input that is null
            String input = null;
            addMethod.invoke(charSet, input);

            // Verify that the set remains empty
            Set<CharRange> set = (Set<CharRange>) CharSet.class.getDeclaredField("set").get(charSet);
            assertTrue(set.isEmpty());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}