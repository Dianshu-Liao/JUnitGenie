package org.apache.commons.collections4.set;
import org.apache.commons.collections4.set.CompositeSet;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;

public class set_CompositeSet_addComposited_Set_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAddCompositedWithNull() {
        CompositeSet<Object> compositeSet = new CompositeSet<>();
        compositeSet.addComposited((Set<Object>[]) null); // Testing with null input
    }

    @Test(timeout = 4000)
    public void testAddCompositedWithEmptyArray() {
        CompositeSet<Object> compositeSet = new CompositeSet<>();
        compositeSet.addComposited(new Set[0]); // Testing with an empty array
    }

    @Test(timeout = 4000)
    public void testAddCompositedWithNonEmptyArray() {
        CompositeSet<Object> compositeSet = new CompositeSet<>();
        Set<Object> set1 = new HashSet<>();
        Set<Object> set2 = new HashSet<>();
        set1.add("Element1");
        set2.add("Element2");
        compositeSet.addComposited(new Set[]{set1, set2}); // Testing with a non-empty array
    }

}