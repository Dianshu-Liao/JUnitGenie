package org.apache.commons.jxpath.ri.model.dynabeans;
import org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.util.Locale;

public class ri_model_dynabeans_DynaBeanPointer_equals_Object_cfg_path_16_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        DynaBeanPointer pointer = new DynaBeanPointer(new QName("test"), null, Locale.getDefault());
        assertTrue(pointer.equals(pointer));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        DynaBeanPointer pointer = new DynaBeanPointer(new QName("test"), null, Locale.getDefault());
        String differentTypeObject = "Not a DynaBeanPointer";
        assertFalse(pointer.equals(differentTypeObject));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualObjects() {
        DynaBeanPointer pointer1 = new DynaBeanPointer(new QName("test"), null, Locale.getDefault());
        DynaBeanPointer pointer2 = new DynaBeanPointer(new QName("test"), null, Locale.getDefault());
        assertTrue(pointer1.equals(pointer2));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        DynaBeanPointer pointer = new DynaBeanPointer(new QName("test"), null, Locale.getDefault());
        assertFalse(pointer.equals(null));
    }

}