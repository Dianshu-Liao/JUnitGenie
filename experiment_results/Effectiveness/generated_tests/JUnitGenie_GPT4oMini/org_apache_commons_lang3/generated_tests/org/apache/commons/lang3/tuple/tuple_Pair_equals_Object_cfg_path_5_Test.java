package org.apache.commons.lang3.tuple;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class tuple_Pair_equals_Object_cfg_path_5_Test {

    private static class ConcretePair extends Pair<Object, Object> {
        private final Object left;
        private final Object right;

        public ConcretePair(Object left, Object right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public Object getLeft() {
            return left;
        }

        @Override
        public Object getRight() {
            return right;
        }

        @Override
        public Object setValue(Object value) {
            throw new UnsupportedOperationException("setValue is not supported for ConcretePair");
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof ConcretePair)) return false;
            ConcretePair other = (ConcretePair) obj;
            return (left.equals(other.left) && right.equals(other.right));
        }

        @Override
        public int hashCode() {
            return left.hashCode() ^ right.hashCode();
        }
    }

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        ConcretePair pair = new ConcretePair("key", "value");
        assertTrue(pair.equals(pair)); // Testing the case where obj is this
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentObjectType() {
        ConcretePair pair = new ConcretePair("key", "value");
        Object notAPair = new Object();
        assertTrue(!pair.equals(notAPair)); // Testing the case where obj is not an instance of Map.Entry
    }

    @Test(timeout = 4000)
    public void testEquals_EqualPairs() {
        ConcretePair pair1 = new ConcretePair("key", "value");
        ConcretePair pair2 = new ConcretePair("key", "value");
        assertTrue(pair1.equals(pair2)); // Testing the case where keys and values are equal
    }

    @Test(timeout = 4000)
    public void testEquals_Null() {
        ConcretePair pair = new ConcretePair("key", "value");
        assertTrue(!pair.equals(null)); // Testing the case where obj is null
    }


}