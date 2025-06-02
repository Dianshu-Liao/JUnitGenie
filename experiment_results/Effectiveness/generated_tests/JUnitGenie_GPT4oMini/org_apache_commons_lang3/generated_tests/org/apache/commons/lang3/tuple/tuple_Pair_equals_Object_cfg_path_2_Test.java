package org.apache.commons.lang3.tuple;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.AbstractMap;
import java.util.Map;

public class tuple_Pair_equals_Object_cfg_path_2_Test {

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
    public void testEquals_SameInstance() {
        TestPair pair = new TestPair("key", "value");
        assertTrue(pair.equals(pair));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        TestPair pair = new TestPair("key", "value");
        assertFalse(pair.equals("Not a Pair"));
    }

    @Test(timeout = 4000)
    public void testEquals_Null() {
        TestPair pair = new TestPair("key", "value");
        assertFalse(pair.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualPairs() {
        TestPair pair1 = new TestPair("key", "value");
        TestPair pair2 = new TestPair("key", "value");
        assertTrue(pair1.equals(pair2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentPairs() {
        TestPair pair1 = new TestPair("key1", "value1");
        TestPair pair2 = new TestPair("key2", "value2");
        assertFalse(pair1.equals(pair2));
    }

    @Test(timeout = 4000)
    public void testEquals_Entry() {
        TestPair pair = new TestPair("key", "value");
        Map.Entry<Object, Object> entry = new AbstractMap.SimpleEntry<>("key", "value");
        assertTrue(pair.equals(entry));
    }

    @Test(timeout = 4000)
    public void testEquals_Entry_DifferentKey() {
        TestPair pair = new TestPair("key", "value");
        Map.Entry<Object, Object> entry = new AbstractMap.SimpleEntry<>("differentKey", "value");
        assertFalse(pair.equals(entry));
    }

    @Test(timeout = 4000)
    public void testEquals_Entry_DifferentValue() {
        TestPair pair = new TestPair("key", "value");
        Map.Entry<Object, Object> entry = new AbstractMap.SimpleEntry<>("key", "differentValue");
        assertFalse(pair.equals(entry));
    }


}