package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Locale;
import javax.xml.namespace.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;

public class ri_model_beans_NullPropertyPointer_setValue_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSetValue_ThrowsJXPathInvalidAccessException_WhenParentIsNull() {
        NullPropertyPointer nullPropertyPointer = new NullPropertyPointer(null);
        try {
            nullPropertyPointer.setValue(new Object());
            fail("Expected JXPathInvalidAccessException to be thrown");
        } catch (JXPathInvalidAccessException e) {
            assertEquals("Cannot set property " + nullPropertyPointer.asPath() + ", the target object is null", e.getMessage());
        }
    }




}
