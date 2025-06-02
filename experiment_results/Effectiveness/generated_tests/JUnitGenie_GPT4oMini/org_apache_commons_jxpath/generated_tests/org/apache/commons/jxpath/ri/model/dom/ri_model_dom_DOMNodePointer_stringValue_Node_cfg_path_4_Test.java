package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Text;
import org.w3c.dom.Comment;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.lang.reflect.Method;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ri_model_dom_DOMNodePointer_stringValue_Node_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testStringValueWithCommentNode() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Comment commentNode = document.createComment("This is a comment");
            DOMNodePointer pointer = new DOMNodePointer(commentNode, Locale.getDefault());

            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);
            String result = (String) method.invoke(pointer, commentNode);
            assertEquals("", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithTextNode() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Text textNode = document.createTextNode("   Hello World   ");
            DOMNodePointer pointer = new DOMNodePointer(textNode, Locale.getDefault());

            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);
            String result = (String) method.invoke(pointer, textNode);
            assertEquals("Hello World", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithProcessingInstructionNode() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            ProcessingInstruction piNode = document.createProcessingInstruction("target", "data");
            DOMNodePointer pointer = new DOMNodePointer(piNode, Locale.getDefault());

            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);
            String result = (String) method.invoke(pointer, piNode);
            assertEquals("data", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithChildNodes() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element parentNode = document.createElement("parent");
            Text childNode1 = document.createTextNode("Child 1");
            Text childNode2 = document.createTextNode("Child 2");
            parentNode.appendChild(childNode1);
            parentNode.appendChild(childNode2);
            DOMNodePointer pointer = new DOMNodePointer(parentNode, Locale.getDefault());

            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);
            String result = (String) method.invoke(pointer, parentNode);
            assertEquals("Child 1Child 2", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}