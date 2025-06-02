package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Locale;

public class ri_model_beans_NullPropertyPointer_setValue_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSetValue_throwsJXPathInvalidAccessException_whenParentIsNull() {
        NullPropertyPointer pointer = new NullPropertyPointer(null);
        
        try {
            pointer.setValue(new Object());
            fail("Expected JXPathInvalidAccessException to be thrown");
        } catch (JXPathInvalidAccessException e) {
            assertEquals("Cannot set property " + pointer.asPath() + ", the target object is null", e.getMessage());
        }
    }



}
