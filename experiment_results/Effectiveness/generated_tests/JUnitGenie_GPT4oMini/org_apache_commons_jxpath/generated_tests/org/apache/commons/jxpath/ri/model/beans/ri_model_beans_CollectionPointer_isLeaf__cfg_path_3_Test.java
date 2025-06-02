package org.apache.commons.jxpath.ri.model.beans;
import org.apache.commons.jxpath.ri.model.beans.CollectionPointer;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.util.Locale;

public class ri_model_beans_CollectionPointer_isLeaf__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsLeafWhenValueIsNull() {
        // Specify the type of the first argument to avoid ambiguity
        CollectionPointer collectionPointer = new CollectionPointer((Object) null, Locale.getDefault());
        boolean result = collectionPointer.isLeaf();
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsLeafWhenValueIsAtomic() {
        // Assuming we have a way to create an atomic value
        Object atomicValue = "Atomic String"; // Example of an atomic value
        CollectionPointer collectionPointer = new CollectionPointer(atomicValue, Locale.getDefault());
        boolean result = collectionPointer.isLeaf();
        assertTrue(result);
    }

}