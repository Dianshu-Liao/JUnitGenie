package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.fail;

public class text_StrSubstitutor_checkCyclicSubstitution_String_List_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCheckCyclicSubstitution() {
        StrSubstitutor strSubstitutor = new StrSubstitutor();
        String varName = "var1";
        List<String> priorVariables = Arrays.asList("var1", "var2", "var3");

        try {
            // Accessing the private method using reflection
            Method method = StrSubstitutor.class.getDeclaredMethod("checkCyclicSubstitution", String.class, List.class);
            method.setAccessible(true);
            method.invoke(strSubstitutor, varName, priorVariables);
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            // Expected exception
            String expectedMessage = "Infinite loop in property interpolation of var1: var2->var3";
            assert e.getMessage().equals(expectedMessage);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

}