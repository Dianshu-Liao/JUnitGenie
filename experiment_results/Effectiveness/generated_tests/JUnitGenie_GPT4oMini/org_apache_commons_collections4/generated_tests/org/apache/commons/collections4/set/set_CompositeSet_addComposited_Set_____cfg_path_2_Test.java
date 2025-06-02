package org.apache.commons.collections4.set;
import org.apache.commons.collections4.set.CompositeSet;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;

public class set_CompositeSet_addComposited_Set_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAddCompositedWithNonEmptySets() {
        CompositeSet<String> compositeSet = new CompositeSet<>();
        Set<String> set1 = new HashSet<>();
        set1.add("element1");
        Set<String> set2 = new HashSet<>();
        set2.add("element2");

        Set<String>[] sets = new Set[]{set1, set2};

        try {
            compositeSet.addComposited(sets);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddCompositedWithNullSets() {
        CompositeSet<String> compositeSet = new CompositeSet<>();

        try {
            // Explicitly call the varargs method to avoid ambiguity
            compositeSet.addComposited((Set<String>[]) null);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAddCompositedWithEmptySet() {
        CompositeSet<String> compositeSet = new CompositeSet<>();
        Set<String> emptySet = new HashSet<>();

        Set<String>[] sets = new Set[]{emptySet};

        try {
            compositeSet.addComposited(sets);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }


}