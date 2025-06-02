package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharRange;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Set;
import static org.junit.Assert.assertTrue;

public class CharSet_add_String_cfg_path_18_Test {

    @Test(timeout = 4000)
    public void testAddWithNegatedChar() {
        try {
            CharSet charSet = new CharSet(new String[]{});
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            
            // Test input: negated character
            String input = "^a";
            addMethod.invoke(charSet, input);
            
            // Verify that the negated character is added
            Set<CharRange> set = (Set<CharRange>) getFieldValue(charSet, "set");
            assertTrue(set.contains(CharRange.isNot('a')));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddWithRange() {
        try {
            CharSet charSet = new CharSet(new String[]{});
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            
            // Test input: range
            String input = "a-c";
            addMethod.invoke(charSet, input);
            
            // Verify that the range is added
            Set<CharRange> set = (Set<CharRange>) getFieldValue(charSet, "set");
            assertTrue(set.contains(CharRange.isIn('a', 'c')));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddWithNull() {
        try {
            CharSet charSet = new CharSet(new String[]{});
            Method addMethod = CharSet.class.getDeclaredMethod("add", String.class);
            addMethod.setAccessible(true);
            
            // Test input: null
            String input = null;
            addMethod.invoke(charSet, input);
            
            // Verify that no elements are added
            Set<CharRange> set = (Set<CharRange>) getFieldValue(charSet, "set");
            assertTrue(set.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object getFieldValue(Object obj, String fieldName) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }

}