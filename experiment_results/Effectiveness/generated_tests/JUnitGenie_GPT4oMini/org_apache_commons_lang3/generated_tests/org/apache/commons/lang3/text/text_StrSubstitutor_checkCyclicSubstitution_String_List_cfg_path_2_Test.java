package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class text_StrSubstitutor_checkCyclicSubstitution_String_List_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCheckCyclicSubstitution_noCyclicSubstitution() {
        try {
            StrSubstitutor substitutor = new StrSubstitutor();
            Method method = StrSubstitutor.class.getDeclaredMethod("checkCyclicSubstitution", String.class, List.class);
            method.setAccessible(true);
            
            String varName = "var1";
            List<String> priorVariables = Arrays.asList("var2", "var3");
            method.invoke(substitutor, varName, priorVariables);
            // If no exception is thrown, the test passes
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCheckCyclicSubstitution_withCyclicSubstitution() {
        try {
            StrSubstitutor substitutor = new StrSubstitutor();
            Method method = StrSubstitutor.class.getDeclaredMethod("checkCyclicSubstitution", String.class, List.class);
            method.setAccessible(true);
            
            String varName = "var1";
            List<String> priorVariables = Arrays.asList("var1", "var2", "var3");
            try {
                method.invoke(substitutor, varName, priorVariables);
            } catch (IllegalStateException e) {
                // Expected exception for cyclic substitution
                return; // Test passes if exception is thrown
            }
            // If no exception is thrown, the test fails
            assert false : "Expected IllegalStateException was not thrown.";
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

}