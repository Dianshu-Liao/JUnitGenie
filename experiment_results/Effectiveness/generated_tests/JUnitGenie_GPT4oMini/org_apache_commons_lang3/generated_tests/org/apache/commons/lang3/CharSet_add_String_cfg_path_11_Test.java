package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharRange;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Set;
import static org.junit.Assert.assertTrue;

public class CharSet_add_String_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testAddWithNegatedChar() {
        try {
            CharSet charSet = new CharSet();
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            
            // Test input that should trigger the negated char case
            String input = "^a";
            addMethod.invoke(charSet, input);
            
            // Verify that the set contains the expected CharRange
            Set<CharRange> set = (Set<CharRange>) CharSet.class.getDeclaredField("set").get(charSet);
            assertTrue(set.contains(CharRange.isNot('a')));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddWithRange() {
        try {
            CharSet charSet = new CharSet();
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            
            // Test input that should trigger the range case
            String input = "a-c";
            addMethod.invoke(charSet, input);
            
            // Verify that the set contains the expected CharRange
            Set<CharRange> set = (Set<CharRange>) CharSet.class.getDeclaredField("set").get(charSet);
            assertTrue(set.contains(CharRange.isIn('a', 'c')));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddWithNegatedRange() {
        try {
            CharSet charSet = new CharSet();
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            
            // Test input that should trigger the negated range case
            String input = "^a-c";
            addMethod.invoke(charSet, input);
            
            // Verify that the set contains the expected CharRange
            Set<CharRange> set = (Set<CharRange>) CharSet.class.getDeclaredField("set").get(charSet);
            assertTrue(set.contains(CharRange.isNotIn('a', 'c')));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}