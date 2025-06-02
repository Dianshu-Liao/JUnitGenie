package org.apache.commons.jxpath;
import org.apache.commons.jxpath.BasicVariables;
import org.junit.Test;
import static org.junit.Assert.*;

public class BasicVariables_getVariable_String_cfg_path_1_Test {


    @Test(timeout = 4000)
    public void testGetVariable_NonExistingVariable() {
        BasicVariables basicVariables = new BasicVariables();
        try {
            basicVariables.getVariable("nonExistentVar");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("No such variable: 'nonExistentVar'", e.getMessage());
        }
    }


}
