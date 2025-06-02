package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.NamespaceResolver;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_NamespaceResolver_seal__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSeal_NullParent() {
        NamespaceResolver resolver = new NamespaceResolver();
        resolver.seal();
        // Check that the sealed state is true after calling seal
        assertTrue(resolver.isSealed());
    }

    @Test(timeout = 4000)
    public void testSeal_WithParent() {
        NamespaceResolver parentResolver = new NamespaceResolver();
        NamespaceResolver childResolver = new NamespaceResolver(parentResolver);
        
        childResolver.seal();
        // Check that the sealed state is true for both child and parent
        assertTrue(childResolver.isSealed());
        assertTrue(parentResolver.isSealed());
    }


}