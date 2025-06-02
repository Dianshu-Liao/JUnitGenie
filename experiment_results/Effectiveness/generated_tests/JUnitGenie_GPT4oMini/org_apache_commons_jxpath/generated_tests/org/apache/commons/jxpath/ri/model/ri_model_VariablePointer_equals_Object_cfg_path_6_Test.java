package org.apache.commons.jxpath.ri.model;
import org.apache.commons.jxpath.ri.model.VariablePointer;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.Variables;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ri_model_VariablePointer_equals_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        VariablePointer variablePointer = new VariablePointer(new QName("test"));
        assertTrue(variablePointer.equals(variablePointer));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        VariablePointer variablePointer = new VariablePointer(new QName("test"));
        String differentTypeObject = "Not a VariablePointer";
        assertFalse(variablePointer.equals(differentTypeObject));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualObjects() {
        VariablePointer variablePointer1 = new VariablePointer(new QName("test"));
        VariablePointer variablePointer2 = new VariablePointer(new QName("test"));
        assertTrue(variablePointer1.equals(variablePointer2));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        VariablePointer variablePointer = new VariablePointer(new QName("test"));
        assertFalse(variablePointer.equals(null));
    }

}