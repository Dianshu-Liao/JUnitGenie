package org.apache.commons.lang3;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.function.Suppliers;
import org.junit.Test;
import java.util.function.Supplier;
import static org.junit.Assert.assertEquals;

public class ObjectUtils_toString_Object_Supplier_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToStringWithNonNullObject() {
        Object obj = new Object() {
            @Override
            public String toString() {
                return "Non-null Object";
            }
        };
        Supplier<String> supplier = () -> "Default String";
        
        String result = ObjectUtils.toString(obj, supplier);
        assertEquals("Non-null Object", result);
    }

    @Test(timeout = 4000)
    public void testToStringWithNullObject() {
        Object obj = null;
        Supplier<String> supplier = () -> "Default String";
        
        String result = ObjectUtils.toString(obj, supplier);
        assertEquals("Default String", result);
    }

    @Test(timeout = 4000)
    public void testToStringWithNullObjectAndSupplierReturningNull() {
        Object obj = null;
        Supplier<String> supplier = () -> null;
        
        String result = ObjectUtils.toString(obj, supplier);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testToStringWithSupplierReturningString() {
        Object obj = null;
        Supplier<String> supplier = () -> "Supplier String";
        
        String result = ObjectUtils.toString(obj, supplier);
        assertEquals("Supplier String", result);
    }

}