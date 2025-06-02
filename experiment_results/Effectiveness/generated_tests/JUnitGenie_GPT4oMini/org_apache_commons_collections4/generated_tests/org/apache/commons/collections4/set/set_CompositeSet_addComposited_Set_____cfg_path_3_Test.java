package org.apache.commons.collections4.set;
import org.apache.commons.collections4.set.CompositeSet;
import org.junit.Test;
import java.util.Set;

public class set_CompositeSet_addComposited_Set_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAddCompositedWithNull() {
        CompositeSet<Object> compositeSet = new CompositeSet<>();
        try {
            compositeSet.addComposited((Set<Object>[]) null);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}