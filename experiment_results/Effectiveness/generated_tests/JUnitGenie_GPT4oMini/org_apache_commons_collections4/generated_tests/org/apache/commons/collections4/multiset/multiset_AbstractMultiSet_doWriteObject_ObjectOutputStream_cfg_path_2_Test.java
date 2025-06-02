package org.apache.commons.collections4.multiset;
import org.apache.commons.collections4.multiset.AbstractMultiSet;
import org.apache.commons.collections4.multiset.HashMultiSet;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import static org.junit.Assert.assertEquals;

public class multiset_AbstractMultiSet_doWriteObject_ObjectOutputStream_cfg_path_2_Test {

    private class ConcreteMultiSet<E> extends HashMultiSet<E> {
        @Override
        public boolean containsAll(java.util.Collection<?> collection) {
            return super.containsAll(collection);
        }

        @Override
        public int uniqueElements() {
            return super.uniqueElements();
        }

        @Override
        public Iterator createEntrySetIterator() {
            return super.createEntrySetIterator();
        }

        @Override
        public boolean retainAll(java.util.Collection<?> collection) {
            return super.retainAll(collection);
        }
    }

    @Test(timeout = 4000)
    public void testDoWriteObject() {
        ConcreteMultiSet<String> multiSet = new ConcreteMultiSet<>();
        multiSet.add("element1");
        multiSet.add("element2");
        
        // Ensure the entrySet is not null and has entries
        Set<AbstractMultiSet.Entry<String>> entrySet = multiSet.entrySet();
        assertEquals(2, entrySet.size());

        try {
            // Use reflection to access the protected method
            Method method = AbstractMultiSet.class.getDeclaredMethod("doWriteObject", ObjectOutputStream.class);
            method.setAccessible(true);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

            // Invoke the protected method
            method.invoke(multiSet, objectOutputStream);

            // Verify the output
            objectOutputStream.flush();
            byte[] data = byteArrayOutputStream.toByteArray();
            assertEquals(2, data[0]); // Check the size written to the stream
        } catch (IOException | ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

}