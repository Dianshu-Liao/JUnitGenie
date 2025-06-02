package org.apache.commons.jxpath.ri.model.dom;
import org.apache.commons.jxpath.ri.model.dom.DOMNodePointer;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.CDATASection;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.NodeList;
import org.w3c.dom.Comment;
import org.w3c.dom.Text;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.lang.reflect.Method;
import java.util.Locale;

public class ri_model_dom_DOMNodePointer_stringValue_Node_cfg_path_19_Test {

    @Test(timeout = 4000)
    public void testStringValueWithTextNode() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("root");
            Text textNode = document.createTextNode("  Hello World  ");
            root.appendChild(textNode);
            document.appendChild(root);

            DOMNodePointer pointer = new DOMNodePointer(root, Locale.getDefault());
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);
            String result = (String) method.invoke(pointer, textNode);
            assertEquals("Hello World", result.trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithCommentNode() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Comment commentNode = document.createComment("This is a comment");
            document.appendChild(commentNode);

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
    public void testStringValueWithCDATASection() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("root"); // Create a root element
            document.appendChild(root); // Append root to the document
            CDATASection cdataSection = document.createCDATASection("Some CDATA content");
            root.appendChild(cdataSection); // Append CDATA section to the root

            DOMNodePointer pointer = new DOMNodePointer(root, Locale.getDefault());
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);
            String result = (String) method.invoke(pointer, cdataSection);
            assertEquals("Some CDATA content", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithProcessingInstruction() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("root"); // Create a root element
            document.appendChild(root); // Append root to the document
            ProcessingInstruction pi = document.createProcessingInstruction("xml-stylesheet", "type='text/xsl' href='style.xsl'");
            root.appendChild(pi); // Append processing instruction to the root

            DOMNodePointer pointer = new DOMNodePointer(root, Locale.getDefault());
            Method method = DOMNodePointer.class.getDeclaredMethod("stringValue", Node.class);
            method.setAccessible(true);
            String result = (String) method.invoke(pointer, pi);
            assertEquals("type='text/xsl' href='style.xsl'", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}