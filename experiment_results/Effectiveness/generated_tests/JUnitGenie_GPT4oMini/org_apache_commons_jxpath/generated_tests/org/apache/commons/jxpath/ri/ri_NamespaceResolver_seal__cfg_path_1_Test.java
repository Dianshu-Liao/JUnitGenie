package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.NamespaceResolver;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ri_NamespaceResolver_seal__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSealWithNonNullParent() {
        // Arrange
        NamespaceResolver parentResolver = new NamespaceResolver();
        NamespaceResolver childResolver = new NamespaceResolver(parentResolver);
        
        // Act
        childResolver.seal();
        
        // Assert
        assertTrue("The child resolver should be sealed.", isSealed(childResolver));
        assertTrue("The parent resolver should also be sealed.", isSealed(parentResolver));
    }

    private boolean isSealed(NamespaceResolver resolver) {
        // Assuming there is a method to check if the resolver is sealed
        // This method should be implemented in the NamespaceResolver class
        return resolver.isSealed(); // Replace with the actual method to check sealed status
    }

}