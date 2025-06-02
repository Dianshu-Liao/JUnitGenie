package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.NamespacePointer;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ri_model_dom_NamespacePointer_testNode_NodeTest_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNode_NullNodeTest() {
        NamespacePointer namespacePointer = new NamespacePointer(null, "namespace");
        boolean result = namespacePointer.testNode(null);
        assertTrue(result);
    }




}
