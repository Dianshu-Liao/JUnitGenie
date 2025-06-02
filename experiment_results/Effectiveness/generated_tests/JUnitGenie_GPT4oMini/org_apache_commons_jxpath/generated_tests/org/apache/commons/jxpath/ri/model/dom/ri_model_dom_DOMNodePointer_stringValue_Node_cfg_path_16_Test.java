package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Text;
import org.w3c.dom.Comment;
import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Entity;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Notation;
import org.w3c.dom.UserDataHandler;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_model_dom_DOMNodePointer_stringValue_Node_cfg_path_16_Test {

    @Test(timeout = 4000)
    public void testStringValueWithCommentNode() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Comment commentNode = doc.createComment("This is a comment");
            DOMNodePointer pointer = new DOMNodePointer(commentNode, null);
            String result = invokeStringValue(pointer, commentNode);
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
            Document doc = builder.newDocument();
            Text textNode = doc.createTextNode("   Hello World   ");
            DOMNodePointer pointer = new DOMNodePointer(textNode, null);
            String result = invokeStringValue(pointer, textNode);
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
            Document doc = builder.newDocument();
            ProcessingInstruction piNode = doc.createProcessingInstruction("xml", "version='1.0'");
            DOMNodePointer pointer = new DOMNodePointer(piNode, null);
            String result = invokeStringValue(pointer, piNode);
            assertEquals("version='1.0'", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithChildNodes() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element root = doc.createElement("root");
            Text textNode = doc.createTextNode("   Hello ");
            Comment commentNode = doc.createComment("This is a comment");
            root.appendChild(textNode);
            root.appendChild(commentNode);
            doc.appendChild(root);
            DOMNodePointer pointer = new DOMNodePointer(root, null);
            String result = invokeStringValue(pointer, root);
            assertEquals("   Hello ", result.trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String invokeStringValue(DOMNodePointer pointer, Node node) {
        try {
            java.lang.reflect.Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);
            return (String) method.invoke(pointer, node);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}