package org.apache.commons.jxpath;
import org.apache.commons.jxpath.BasicVariables;
import org.junit.Test;
import static org.junit.Assert.*;

public class BasicVariables_getVariable_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetVariableThrowsException() {
        BasicVariables basicVariables = new BasicVariables();
        String varName = "undefinedVariable"; // This variable is not defined in vars

        try {
            basicVariables.getVariable(varName);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("No such variable: 'undefinedVariable'", e.getMessage());
        }
    }

}