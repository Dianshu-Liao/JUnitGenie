package org.apache.commons.jxpath;
import org.apache.commons.jxpath.BasicNodeSet;
import org.apache.commons.jxpath.NodeSet;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class BasicNodeSet_add_NodeSet_cfg_path_2_Test {

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
            return null; // Not needed for this test
        }

        @Override
        public List<Object> getValues() {
            return null; // Not needed for this test
        }
    }

    @Test(timeout = 4000)
    public void testAddWithValidPointers() {
        BasicNodeSet basicNodeSet = new BasicNodeSet();
        List<Object> validPointers = new ArrayList<>();
        validPointers.add(new Object()); // Adding a valid pointer
        NodeSet mockNodeSet = new MockNodeSet(validPointers);

        try {
            basicNodeSet.add(mockNodeSet);
            // If no exception is thrown, we can check if the pointers were added
            assertFalse(basicNodeSet.getPointers().isEmpty());
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAddWithEmptyPointers() {
        BasicNodeSet basicNodeSet = new BasicNodeSet();
        List<Object> emptyPointers = new ArrayList<>();
        NodeSet mockNodeSet = new MockNodeSet(emptyPointers);

        try {
            basicNodeSet.add(mockNodeSet);
            // Check that pointers remain empty since no valid pointers were added
            assertTrue(basicNodeSet.getPointers().isEmpty());
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

}