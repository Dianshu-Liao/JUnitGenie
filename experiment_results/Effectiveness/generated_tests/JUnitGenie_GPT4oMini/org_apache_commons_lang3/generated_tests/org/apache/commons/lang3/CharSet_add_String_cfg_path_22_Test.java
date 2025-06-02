package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharRange;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;
import static org.junit.Assert.assertTrue;

public class CharSet_add_String_cfg_path_22_Test {

    @Test(timeout = 4000)
    public void testAddValidChar() {
        try {
            CharSet charSet = new CharSet(new String[]{});
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            
            // Test input where str contains a single valid character
            String validInput = "a";
            addMethod.invoke(charSet, validInput);
            
            // Check that the character has been added
            Set<CharRange> setField = (Set<CharRange>) charSet.getClass().getDeclaredField("set").get(charSet);
            assertTrue(setField.contains(CharRange.is('a')));
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
            
            // Test input where str specifies a negated character
            String negatedInput = "^b";
            addMethod.invoke(charSet, negatedInput);
            
            // Check that the negated character has been added
            Set<CharRange> setField = (Set<CharRange>) charSet.getClass().getDeclaredField("set").get(charSet);
            assertTrue(setField.contains(CharRange.isNot('b')));
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
            
            // Test input where str specifies a range
            String rangeInput = "a-c";
            addMethod.invoke(charSet, rangeInput);
            
            // Check that the range has been added
            Set<CharRange> setField = (Set<CharRange>) charSet.getClass().getDeclaredField("set").get(charSet);
            assertTrue(setField.contains(CharRange.isIn('a', 'c')));
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
            
            // Test input where str specifies a negated range
            String negatedRangeInput = "^b-d";
            addMethod.invoke(charSet, negatedRangeInput);
            
            // Check that the negated range has been added
            Set<CharRange> setField = (Set<CharRange>) charSet.getClass().getDeclaredField("set").get(charSet);
            assertTrue(setField.contains(CharRange.isNotIn('b', 'd')));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddNullInput() {
        try {
            CharSet charSet = new CharSet(new String[]{});
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            
            // Test input as null
            String nullInput = null;
            addMethod.invoke(charSet, nullInput);
            
            // Ensure no items are added
            Set<CharRange> setField = (Set<CharRange>) charSet.getClass().getDeclaredField("set").get(charSet);
            assertTrue(setField.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}