package org.apache.commons.collections4.trie;
import org.apache.commons.collections4.trie.AbstractPatriciaTrie;
import org.apache.commons.collections4.trie.AbstractPatriciaTrie.TrieEntry;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import static org.junit.Assert.fail;

public class trie_AbstractPatriciaTrie_removeExternalEntry_TrieEntry_cfg_path_5_Test {

    private class ConcreteTrie extends AbstractPatriciaTrie<String, String> {
        protected ConcreteTrie() {
            super(null, null); // Provide required arguments for the constructor
        }

        @Override
        public void putAll(Map<? extends String, ? extends String> m) {
            // Implementation not needed for this test
        }

        @Override
        public boolean containsValue(Object value) {
            return false; // Implementation not needed for this test
        }

        @Override
        public boolean isEmpty() {
            return true; // Implementation not needed for this test
        }

    }

    @Test(timeout = 4000)
    public void testRemoveExternalEntry() {
        try {
            // Create an instance of the concrete Trie
            ConcreteTrie trie = new ConcreteTrie();

            // Create a protected TrieEntry instance using reflection
            Constructor<TrieEntry> constructor = TrieEntry.class.getDeclaredConstructor(Object.class, Object.class, int.class);
            constructor.setAccessible(true);
            TrieEntry entry = constructor.newInstance(null, null, 0); // Provide required arguments

            // Set up the entry to be an external node
            entry.left = (TrieEntry) constructor.newInstance(null, null, 0); // Create a different TrieEntry for left
            entry.right = (TrieEntry) constructor.newInstance(null, null, 0); // Create a different TrieEntry for right
            entry.bitIndex = 1; // Set bitIndex
            entry.parent = (TrieEntry) constructor.newInstance(null, null, 0); // Set parent

            // Ensure the entry is external
            entry.parent.left = entry; // Set the entry as the left child of its parent
            entry.parent.right = (TrieEntry) constructor.newInstance(null, null, 0); // Create a right child for the parent

            // Call the private method using reflection
            Method method = AbstractPatriciaTrie.class.getDeclaredMethod("removeExternalEntry", TrieEntry.class);
            method.setAccessible(true);
            method.invoke(trie, entry);

        } catch (IllegalArgumentException e) {
            // Handle the expected exception for the root entry case
            if (!e.getMessage().equals("Cannot delete root Entry!")) {
                fail("Unexpected exception message: " + e.getMessage());
            }
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

}
