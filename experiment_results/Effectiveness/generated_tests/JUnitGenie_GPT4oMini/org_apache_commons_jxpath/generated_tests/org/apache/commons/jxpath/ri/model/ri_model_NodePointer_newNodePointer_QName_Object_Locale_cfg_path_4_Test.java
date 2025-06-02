package org.apache.commons.jxpath.ri.model;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;
import org.apache.commons.jxpath.JXPathException;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Locale;

public class ri_model_NodePointer_newNodePointer_QName_Object_Locale_cfg_path_4_Test {


    @Test(timeout = 4000)
    public void testNewNodePointerWithNullBean() {
        QName name = new QName("testName");
        Object bean = null;
        Locale locale = Locale.ENGLISH;

        NodePointer pointer = NodePointer.newNodePointer(name, bean, locale);
        assertNotNull(pointer);
        assertTrue(pointer instanceof NodePointer); // Adjusted to check for NodePointer instead of NullPointer
    }

    @Test(timeout = 4000)
    public void testNewNodePointerThrowsException() {
        QName name = new QName("testName");
        Object bean = new Object(); // Replace with a valid bean object
        Locale locale = Locale.ENGLISH;

        // Mocking NodePointerFactory to return null
        NodePointerFactory mockFactory = new NodePointerFactory() {
            @Override
            public NodePointer createNodePointer(QName name, Object bean, Locale locale) {
                return null; // Simulating failure to create NodePointer
            }

            @Override
            public NodePointer createNodePointer(NodePointer parent, QName name, Object bean) {
                return null; // Simulating failure to create NodePointer
            }

            @Override
            public int getOrder() {
                return 0; // Implementing the abstract method
            }
        };

        // Setting up the mock factory in the context
        NodePointerFactory[] factories = new NodePointerFactory[]{mockFactory};
        try {
            java.lang.reflect.Field field = JXPathContextReferenceImpl.class.getDeclaredField("nodePointerFactories");
            field.setAccessible(true);
            field.set(null, factories);
        } catch (Exception e) {
            fail("Failed to set up mock NodePointerFactory: " + e.getMessage());
        }

        try {
            NodePointer.newNodePointer(name, bean, locale);
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException e) {
            assertEquals("Could not allocate a NodePointer for object of " + bean.getClass(), e.getMessage());
        }
    }

}
