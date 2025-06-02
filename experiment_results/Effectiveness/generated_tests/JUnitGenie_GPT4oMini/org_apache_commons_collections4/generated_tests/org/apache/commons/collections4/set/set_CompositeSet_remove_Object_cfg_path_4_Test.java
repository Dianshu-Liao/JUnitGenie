package org.apache.commons.collections4.set;
import org.apache.commons.collections4.set.CompositeSet;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class set_CompositeSet_remove_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testRemoveWithEmptySets() {
        // Arrange
        CompositeSet<Object> compositeSet = new CompositeSet<>();
        
        // Act
        boolean result = compositeSet.remove(new Object());
        
        // Assert
        assertFalse(result);
    }

}