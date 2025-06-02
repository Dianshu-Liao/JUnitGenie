package org.apache.commons.lang3.mutable;
import org.apache.commons.lang3.mutable.MutableObject;
import org.junit.Test;
import static org.junit.Assert.*;

public class mutable_MutableObject_equals_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEqualsWithNullObject() {
        MutableObject<String> obj1 = new MutableObject<>("Test");
        Object obj2 = null;

        try {
            // This should return false when comparing with null
            assertFalse(obj1.equals(obj2));
        } catch (Exception e) {
            // handle exception if thrown
            e.printStackTrace(); 
        }
    }

}