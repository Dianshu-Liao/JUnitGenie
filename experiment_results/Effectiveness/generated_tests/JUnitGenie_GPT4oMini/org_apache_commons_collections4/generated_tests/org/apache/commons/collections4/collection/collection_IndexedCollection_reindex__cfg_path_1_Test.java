package org.apache.commons.collections4.collection;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.collection.IndexedCollection;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collection;

public class collection_IndexedCollection_reindex__cfg_path_1_Test {


    // A simple test object that implements hashCode and equals
    private static class TestObject {
        private String name;

        public TestObject(String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            TestObject that = (TestObject) obj;
            return name.equals(that.name);
        }
    }


}
