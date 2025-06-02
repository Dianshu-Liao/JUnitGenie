package org.apache.commons.lang3.tuple;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Map;
import java.util.AbstractMap;

public class tuple_Pair_equals_Object_cfg_path_4_Test {

    private static class TestPair extends Pair<Object, Object> {
        private final Object left;
        private final Object right;

        public TestPair(Object left, Object right) {
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
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Pair)) return false;
            Pair<?, ?> other = (Pair<?, ?>) obj;
            return (left == null ? other.getLeft() == null : left.equals(other.getLeft())) &&
                   (right == null ? other.getRight() == null : right.equals(other.getRight()));
        }

        @Override
        public int hashCode() {
            return (left == null ? 0 : left.hashCode()) ^ (right == null ? 0 : right.hashCode());
        }

        @Override
        public Object setValue(Object value) {
            throw new UnsupportedOperationException("setValue is not supported");
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameInstance() {
        TestPair pair = new TestPair("key", "value");
        assertTrue(pair.equals(pair));
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentType() {
        TestPair pair = new TestPair("key", "value");
        assertFalse(pair.equals("not a pair"));
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentPair() {
        TestPair pair1 = new TestPair("key", "value");
        TestPair pair2 = new TestPair("key", "differentValue");
        assertFalse(pair1.equals(pair2));
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameKeyAndValue() {
        TestPair pair1 = new TestPair("key", "value");
        TestPair pair2 = new TestPair("key", "value");
        assertTrue(pair1.equals(pair2));
    }

    @Test(timeout = 4000)
    public void testEqualsWithMapEntry() {
        TestPair pair = new TestPair("key", "value");
        Map.Entry<Object, Object> entry = new AbstractMap.SimpleEntry<>("key", "value");
        assertTrue(pair.equals(entry));
    }


}