package org.apache.commons.jxpath.ri.model.dynabeans;
import org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.util.Locale;

public class ri_model_dynabeans_DynaBeanPointer_equals_Object_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        DynaBeanPointer pointer = new DynaBeanPointer(new QName("dummy"), null, Locale.getDefault());
        assertTrue(pointer.equals(pointer));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        DynaBeanPointer pointer = new DynaBeanPointer(new QName("dummy"), null, Locale.getDefault());
        String differentTypeObject = "Not a DynaBeanPointer";
        assertFalse(pointer.equals(differentTypeObject));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentDynaBeanPointer() {
        DynaBeanPointer pointer1 = new DynaBeanPointer(new QName("dummy"), null, Locale.getDefault());
        DynaBeanPointer pointer2 = new DynaBeanPointer(new QName("dummy"), null, Locale.getDefault());
        assertTrue(pointer1.equals(pointer2));
    }

}