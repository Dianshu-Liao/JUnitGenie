package org.apache.commons.jxpath;
import org.apache.commons.jxpath.BasicNodeSet;
import org.apache.commons.jxpath.NodeSet;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class BasicNodeSet_add_NodeSet_cfg_path_1_Test {

    private class MockNodeSet implements NodeSet {
        private List<Object> pointers;

        public MockNodeSet(List<Object> pointers) {
            this.pointers = pointers;
        }

        @Override
        public List<Object> getPointers() {
            return pointers;
        }

        @Override
        public List<Object> getNodes() {
            return null; // Not used in this test
        }

        @Override
        public List<Object> getValues() {
            return null; // Not used in this test
        }
    }

    @Test(timeout = 4000)
    public void testAddWithNonEmptyNodeSet() {
        BasicNodeSet basicNodeSet = new BasicNodeSet();
        List<Object> pointersToAdd = new ArrayList<>();
        pointersToAdd.add(new Object()); // Adding a sample object
        NodeSet nodeSet = new MockNodeSet(pointersToAdd);

        // Execute the focal method
        try {
            basicNodeSet.add(nodeSet);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Verify that the pointers list is updated
        assertTrue(basicNodeSet.getPointers().size() > 0);
    }

    @Test(timeout = 4000)
    public void testAddWithEmptyNodeSet() {
        BasicNodeSet basicNodeSet = new BasicNodeSet();
        NodeSet nodeSet = new MockNodeSet(new ArrayList<>()); // Empty NodeSet

        // Execute the focal method
        try {
            basicNodeSet.add(nodeSet);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Verify that the pointers list remains empty
        assertTrue(basicNodeSet.getPointers().isEmpty());
    }


}