package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.ProcessingInstructionTest;
import org.jdom.ProcessingInstruction;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.HashMap;

public class ri_model_jdom_JDOMNodePointer_testNode_NodePointer_Object_NodeTest_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNode_WithValidProcessingInstructionTest_ShouldReturnTrue() {
        NodePointer pointer = new JDOMNodePointer(new Object(), java.util.Locale.getDefault());
        ProcessingInstruction node = new ProcessingInstruction("target", new HashMap<String, String>());
        
        ProcessingInstructionTest test = new ProcessingInstructionTest("target");
        try {
            boolean result = JDOMNodePointer.testNode(pointer, node, test);
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testNode_WithInvalidProcessingInstructionTest_ShouldReturnFalse() {
        NodePointer pointer = new JDOMNodePointer(new Object(), java.util.Locale.getDefault());
        ProcessingInstruction node = new ProcessingInstruction("differentTarget", new HashMap<String, String>());
        
        ProcessingInstructionTest test = new ProcessingInstructionTest("target");
        try {
            boolean result = JDOMNodePointer.testNode(pointer, node, test);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testNode_WithNullTest_ShouldReturnTrue() {
        NodePointer pointer = new JDOMNodePointer(new Object(), java.util.Locale.getDefault());
        ProcessingInstruction node = new ProcessingInstruction("target", new HashMap<String, String>());
        
        try {
            boolean result = JDOMNodePointer.testNode(pointer, node, null);
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}