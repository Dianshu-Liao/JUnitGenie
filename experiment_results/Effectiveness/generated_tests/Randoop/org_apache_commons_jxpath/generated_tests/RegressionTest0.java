package org.apache.commons.jxpath;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    @Test
    public void test001() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test001");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.OR;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 27 + "'", int0 == 27);
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        int int0 = org.apache.commons.jxpath.ri.Compiler.FUNCTION_KEY;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 29 + "'", int0 == 29);
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        org.apache.commons.jxpath.ri.model.NodePointerFactory[] nodePointerFactoryArray0 = org.apache.commons.jxpath.ri.JXPathContextReferenceImpl.getNodePointerFactories();
        org.junit.Assert.assertNotNull(nodePointerFactoryArray0);
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test004");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        JXPathContext jXPathContext3 = null;
        org.apache.commons.jxpath.ri.QName qName4 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.model.NodePointer nodePointer6 = jDOMNamespacePointer2.createChild(jXPathContext3, qName4, (int) (short) -1);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.jxpath.JXPathException; message: Cannot create an object for path namespace::/null[0], operation is not allowed for this type of node");
        } catch (JXPathException e) {
            // Expected exception.
        }
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test005");
        String str0 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.XML_NAMESPACE_URI;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "http://www.w3.org/XML/1998/namespace" + "'", str0, "http://www.w3.org/XML/1998/namespace");
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        org.apache.commons.jxpath.ri.axes.SimplePathInterpreter simplePathInterpreter0 = new org.apache.commons.jxpath.ri.axes.SimplePathInterpreter();
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.LTE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 14 + "'", int0 == 14);
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.AXIS_CHILD;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 36 + "'", int0 == 36);
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        int int0 = org.apache.commons.jxpath.ri.Compiler.FUNCTION_SUBSTRING_AFTER;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 13 + "'", int0 == 13);
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        String str0 = JXPathContextFactory.FACTORY_NAME_PROPERTY;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "org.apache.commons.jxpath.JXPathContextFactory" + "'", str0, "org.apache.commons.jxpath.JXPathContextFactory");
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        org.apache.commons.jxpath.ri.compiler.Expression expression0 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression1 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual2 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression0, expression1);
        org.apache.commons.jxpath.ri.compiler.Expression expression3 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression4 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual5 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression3, expression4);
        org.apache.commons.jxpath.ri.compiler.CoreOperationEqual coreOperationEqual6 = new org.apache.commons.jxpath.ri.compiler.CoreOperationEqual(expression0, expression4);
        // The following exception was thrown during execution in test generation
        try {
            String str7 = coreOperationEqual6.toString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.AXIS_NAMESPACE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 40 + "'", int0 == 40);
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer propertyOwnerPointer0 = null;
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer3 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer5 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer3, "");
        jDOMNamespacePointer5.setIndex((int) (byte) 10);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.model.dynamic.DynamicPropertyIterator dynamicPropertyIterator8 = new org.apache.commons.jxpath.ri.model.dynamic.DynamicPropertyIterator(propertyOwnerPointer0, "http://www.w3.org/XML/1998/namespace", false, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        org.apache.commons.jxpath.ri.model.NodePointerFactory nodePointerFactory0 = null;
        boolean boolean1 = org.apache.commons.jxpath.ri.JXPathContextReferenceImpl.removeNodePointerFactory(nodePointerFactory0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        org.apache.commons.jxpath.ri.compiler.Expression expression0 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression1 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual2 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression0, expression1);
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray3 = coreOperationGreaterThanOrEqual2.getArguments();
        // The following exception was thrown during execution in test generation
        try {
            String str4 = coreOperationGreaterThanOrEqual2.toString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(expressionArray3);
        org.junit.Assert.assertArrayEquals(expressionArray3, new org.apache.commons.jxpath.ri.compiler.Expression[] { null, null });
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        org.apache.commons.jxpath.ri.model.NodePointerFactory nodePointerFactory0 = null;
        org.apache.commons.jxpath.ri.JXPathContextReferenceImpl.addNodePointerFactory(nodePointerFactory0);
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        int int0 = org.apache.commons.jxpath.ri.Compiler.AXIS_CHILD;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2 + "'", int0 == 2);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        JXPathContext jXPathContext0 = null;
        // The following exception was thrown during execution in test generation
        try {
            JXPathContext jXPathContext2 = JXPathContext.newContext(jXPathContext0, (Object) 2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.FUNCTION_LANG;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 72 + "'", int0 == 72);
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.FUNCTION_SUM;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 74 + "'", int0 == 74);
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray1 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction2 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray1);
        boolean boolean3 = coreFunction2.computeContextDependent();
        org.junit.Assert.assertNotNull(expressionArray1);
        org.junit.Assert.assertArrayEquals(expressionArray1, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        JXPathInvalidSyntaxException jXPathInvalidSyntaxException1 = new JXPathInvalidSyntaxException("org.apache.commons.jxpath.JXPathContextFactory");
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        JXPathException jXPathException1 = new JXPathException();
        JXPathException jXPathException2 = new JXPathException("", (Throwable) jXPathException1);
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        int int0 = org.apache.commons.jxpath.ri.model.VariablePointerFactory.VARIABLE_POINTER_FACTORY_ORDER;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 890 + "'", int0 == 890);
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        org.apache.commons.jxpath.xml.XMLParser xMLParser1 = null;
        org.apache.commons.jxpath.xml.DocumentContainer.registerXMLParser("/", xMLParser1);
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        // The following exception was thrown during execution in test generation
        try {
            Object obj7 = jDOMAttributePointer6.getValue();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.FUNCTION_SUBSTRING;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 63 + "'", int0 == 63);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        org.apache.commons.beanutils.DynaBean dynaBean7 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer8 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer6, dynaBean7);
        JXPathContext jXPathContext9 = null;
        org.apache.commons.jxpath.ri.QName qName10 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.model.NodePointer nodePointer12 = dynaBeanPropertyPointer8.createChild(jXPathContext9, qName10, 63);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        JXPathFunctionNotFoundException jXPathFunctionNotFoundException1 = new JXPathFunctionNotFoundException("namespace::");
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.FUNCTION_FALSE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 70 + "'", int0 == 70);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.FUNCTION_NOT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 68 + "'", int0 == 68);
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        boolean boolean1 = org.apache.commons.jxpath.util.ValueUtils.isCollection((Object) 1);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        org.apache.commons.beanutils.DynaBean dynaBean7 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer8 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer6, dynaBean7);
        boolean boolean10 = dynaBeanPropertyPointer8.equals((Object) true);
        // The following exception was thrown during execution in test generation
        try {
            int int11 = dynaBeanPropertyPointer8.getPropertyCount();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        org.w3c.dom.Node node0 = null;
        // The following exception was thrown during execution in test generation
        try {
            String str1 = org.apache.commons.jxpath.ri.model.dom.DOMNodePointer.getPrefix(node0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test035");
        java.beans.PropertyDescriptor propertyDescriptor1 = null;
        // The following exception was thrown during execution in test generation
        try {
            Object obj3 = org.apache.commons.jxpath.util.ValueUtils.getValue((Object) 74, propertyDescriptor1, (int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        org.apache.commons.jxpath.util.KeyManagerUtils keyManagerUtils0 = new org.apache.commons.jxpath.util.KeyManagerUtils();
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.AXIS_DESCENDANT_OR_SELF;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 47 + "'", int0 == 47);
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        org.apache.commons.beanutils.DynaBean dynaBean7 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer8 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer6, dynaBean7);
        // The following exception was thrown during execution in test generation
        try {
            int int9 = dynaBeanPropertyPointer8.getPropertyCount();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        JXPathContext jXPathContext0 = null;
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer2 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer4 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer2, "");
        jDOMNamespacePointer4.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute7 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer8 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer4, attribute7);
        org.apache.commons.beanutils.DynaBean dynaBean9 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer10 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer8, dynaBean9);
        boolean boolean12 = dynaBeanPropertyPointer10.equals((Object) true);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.JXPathContextReferenceImpl jXPathContextReferenceImpl13 = new org.apache.commons.jxpath.ri.JXPathContextReferenceImpl(jXPathContext0, (Object) (byte) 1, (Pointer) dynaBeanPropertyPointer10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.AXIS_FOLLOWING;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 42 + "'", int0 == 42);
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        int int5 = jDOMNamespacePointer2.getLength();
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.AXIS_PRECEDING_SIBLING;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 46 + "'", int0 == 46);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        org.apache.commons.beanutils.DynaBean dynaBean7 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer8 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer6, dynaBean7);
        // The following exception was thrown during execution in test generation
        try {
            jDOMAttributePointer6.remove();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.FUNCTION_STARTS_WITH;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 58 + "'", int0 == 58);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        JXPathException jXPathException0 = new JXPathException();
        JXPathContextFactoryConfigurationError jXPathContextFactoryConfigurationError1 = new JXPathContextFactoryConfigurationError((Exception) jXPathException0);
        Exception exception2 = jXPathContextFactoryConfigurationError1.getException();
        org.junit.Assert.assertNotNull(exception2);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        int int0 = org.apache.commons.jxpath.ri.Compiler.FUNCTION_FORMAT_NUMBER;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 30 + "'", int0 == 30);
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        PackageFunctions packageFunctions2 = new PackageFunctions("http://www.w3.org/XML/1998/namespace", "hi!");
        java.util.Set set3 = packageFunctions2.getUsedNamespaces();
        org.apache.commons.jxpath.util.ValueUtils.setValue((Object) packageFunctions2, 74, (Object) 100.0d);
        org.junit.Assert.assertNotNull(set3);
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        int int0 = org.apache.commons.jxpath.ri.Compiler.FUNCTION_NAMESPACE_URI;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 6 + "'", int0 == 6);
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray1 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction2 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray1);
        boolean boolean3 = coreFunction2.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.Expression expression4 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression5 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual6 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression4, expression5);
        org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan coreOperationLessThan7 = new org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction2, expression5);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.compiler.Expression expression8 = coreFunction2.getArg1();
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 0");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(expressionArray1);
        org.junit.Assert.assertArrayEquals(expressionArray1, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        int int3 = unionContext2.getCurrentPosition();
        int int4 = unionContext2.getDocumentOrder();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer5 = unionContext2.getCurrentNodePointer();
        unionContext2.reset();
        Pointer pointer7 = unionContext2.getSingleNodePointer();
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNull(nodePointer5);
        org.junit.Assert.assertNull(pointer7);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        org.apache.commons.jxpath.servlet.Constants constants0 = new org.apache.commons.jxpath.servlet.Constants();
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        String str1 = org.apache.commons.jxpath.ri.compiler.NodeTypeTest.nodeTypeToString(72);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "UNKNOWN" + "'", str1, "UNKNOWN");
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        org.apache.commons.beanutils.DynaBean dynaBean7 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer8 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer6, dynaBean7);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = dynaBeanPropertyPointer8.isActual();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        org.apache.commons.jxpath.ri.parser.Token token1 = org.apache.commons.jxpath.ri.parser.Token.newToken((-1));
        int int2 = token1.endLine;
        org.junit.Assert.assertNotNull(token1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray1 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction2 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray1);
        boolean boolean3 = coreFunction2.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.Expression expression4 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression5 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual6 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression4, expression5);
        org.apache.commons.jxpath.ri.compiler.NameAttributeTest nameAttributeTest7 = new org.apache.commons.jxpath.ri.compiler.NameAttributeTest((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction2, (org.apache.commons.jxpath.ri.compiler.Expression) coreOperationGreaterThanOrEqual6);
        org.apache.commons.jxpath.ri.compiler.Expression expression8 = nameAttributeTest7.getNameTestExpression();
        org.apache.commons.jxpath.ri.EvalContext evalContext9 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray10 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext11 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext9, evalContextArray10);
        // The following exception was thrown during execution in test generation
        try {
            java.util.Iterator iterator12 = nameAttributeTest7.iterate((org.apache.commons.jxpath.ri.EvalContext) unionContext11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(expressionArray1);
        org.junit.Assert.assertArrayEquals(expressionArray1, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(expression8);
        org.junit.Assert.assertNotNull(evalContextArray10);
        org.junit.Assert.assertArrayEquals(evalContextArray10, new org.apache.commons.jxpath.ri.EvalContext[] {});
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        org.apache.commons.jxpath.servlet.HttpSessionHandler httpSessionHandler0 = new org.apache.commons.jxpath.servlet.HttpSessionHandler();
        // The following exception was thrown during execution in test generation
        try {
            String[] strArray2 = httpSessionHandler0.getPropertyNames((Object) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: java.lang.Short cannot be cast to org.apache.commons.jxpath.servlet.HttpSessionAndServletContext");
        } catch (ClassCastException e) {
            // Expected exception.
        }
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        String str0 = org.apache.commons.jxpath.ri.model.dom.DOMNodePointer.XML_NAMESPACE_URI;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "http://www.w3.org/XML/1998/namespace" + "'", str0, "http://www.w3.org/XML/1998/namespace");
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        java.util.Locale locale3 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer4 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext0, locale3);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean6 = collectionPointer4.isLanguage("/");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        org.apache.commons.beanutils.DynaBean dynaBean7 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer8 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer6, dynaBean7);
        boolean boolean10 = dynaBeanPropertyPointer8.equals((Object) true);
        // The following exception was thrown during execution in test generation
        try {
            dynaBeanPropertyPointer8.setValue((Object) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest4 = null;
        boolean boolean5 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, (Object) true, nodeTest4);
        JXPathException jXPathException6 = new JXPathException();
        JXPathContextFactoryConfigurationError jXPathContextFactoryConfigurationError7 = new JXPathContextFactoryConfigurationError((Exception) jXPathException6);
        JXPathException jXPathException8 = new JXPathException((Throwable) jXPathException6);
        jDOMNamespacePointer2.handle((Throwable) jXPathException8);
        int int10 = jDOMNamespacePointer2.getIndex();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + (-2147483648) + "'", int10 == (-2147483648));
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        org.apache.commons.jxpath.ri.parser.TokenMgrError tokenMgrError7 = new org.apache.commons.jxpath.ri.parser.TokenMgrError(true, (int) (byte) 1, 27, (int) (short) 0, "hi!", 'a', (int) (short) -1);
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        org.apache.commons.beanutils.DynaBean dynaBean7 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer8 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer6, dynaBean7);
        org.apache.commons.jxpath.ri.QName qName9 = null;
        org.apache.commons.jxpath.ri.model.NodeIterator nodeIterator10 = jDOMAttributePointer6.attributeIterator(qName9);
        org.junit.Assert.assertNull(nodeIterator10);
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        int int0 = org.apache.commons.jxpath.ri.model.jdom.JDOMPointerFactory.JDOM_POINTER_FACTORY_ORDER;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 110 + "'", int0 == 110);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        int int0 = org.apache.commons.jxpath.ri.Compiler.FUNCTION_NULL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 28 + "'", int0 == 28);
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        int int3 = unionContext2.getCurrentPosition();
        int int4 = unionContext2.getDocumentOrder();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer5 = unionContext2.getCurrentNodePointer();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer6 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer8 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer6, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest10 = null;
        boolean boolean11 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer8, (Object) true, nodeTest10);
        Object obj12 = jDOMNamespacePointer8.clone();
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray14 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction15 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray14);
        org.apache.commons.jxpath.ri.compiler.Step step16 = null;
        org.apache.commons.jxpath.ri.compiler.Step[] stepArray17 = new org.apache.commons.jxpath.ri.compiler.Step[] { step16 };
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.model.NodePointer nodePointer18 = org.apache.commons.jxpath.ri.axes.SimplePathInterpreter.interpretSimpleExpressionPath((org.apache.commons.jxpath.ri.EvalContext) unionContext2, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer8, expressionArray14, stepArray17);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNull(nodePointer5);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNotNull(obj12);
        org.junit.Assert.assertEquals(obj12.toString(), "namespace::");
        org.junit.Assert.assertEquals(String.valueOf(obj12), "namespace::");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj12), "namespace::");
        org.junit.Assert.assertNotNull(expressionArray14);
        org.junit.Assert.assertArrayEquals(expressionArray14, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertNotNull(stepArray17);
        org.junit.Assert.assertArrayEquals(stepArray17, new org.apache.commons.jxpath.ri.compiler.Step[] { null });
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.FUNCTION_COUNT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 50 + "'", int0 == 50);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        String str1 = org.apache.commons.jxpath.ri.parser.TokenMgrError.addEscapes("/");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "/" + "'", str1, "/");
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        org.apache.commons.jxpath.servlet.HttpSessionHandler httpSessionHandler0 = new org.apache.commons.jxpath.servlet.HttpSessionHandler();
        JXPathException jXPathException3 = new JXPathException();
        JXPathContextFactoryConfigurationError jXPathContextFactoryConfigurationError4 = new JXPathContextFactoryConfigurationError((Exception) jXPathException3);
        // The following exception was thrown during execution in test generation
        try {
            httpSessionHandler0.setProperty((Object) 68, "org.apache.commons.jxpath.JXPathContextFactory", (Object) jXPathException3);
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: java.lang.Integer cannot be cast to org.apache.commons.jxpath.servlet.HttpSessionAndServletContext");
        } catch (ClassCastException e) {
            // Expected exception.
        }
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        int int0 = org.apache.commons.jxpath.ri.Compiler.FUNCTION_NAME;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 7 + "'", int0 == 7);
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.EQ;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 11 + "'", int0 == 11);
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        int int0 = org.apache.commons.jxpath.ri.Compiler.FUNCTION_FALSE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 21 + "'", int0 == 21);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        int int0 = org.apache.commons.jxpath.ri.Compiler.AXIS_FOLLOWING;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 8 + "'", int0 == 8);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
        String str0 = org.apache.commons.jxpath.xml.DocumentContainer.MODEL_DOM;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "DOM" + "'", str0, "DOM");
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        java.util.Locale locale3 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer4 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext0, locale3);
        int int5 = collectionPointer4.getLength();
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.PLUS;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 9 + "'", int0 == 9);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        org.apache.commons.jxpath.ri.parser.TokenMgrError tokenMgrError2 = new org.apache.commons.jxpath.ri.parser.TokenMgrError("namespace::", 27);
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        java.io.Reader reader0 = null;
        org.apache.commons.jxpath.ri.parser.SimpleCharStream simpleCharStream1 = new org.apache.commons.jxpath.ri.parser.SimpleCharStream(reader0);
        // The following exception was thrown during execution in test generation
        try {
            int int2 = simpleCharStream1.getEndLine();
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: -1");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        int int0 = org.apache.commons.jxpath.ri.Compiler.FUNCTION_NUMBER;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 23 + "'", int0 == 23);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        JXPathContext jXPathContext7 = null;
        // The following exception was thrown during execution in test generation
        try {
            Pointer pointer9 = jDOMAttributePointer6.getPointerByID(jXPathContext7, "DOM");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        javax.xml.transform.Source source0 = null;
        // The following exception was thrown during execution in test generation
        try {
            XMLDocumentContainer xMLDocumentContainer1 = new XMLDocumentContainer(source0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.Extender;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 26 + "'", int0 == 26);
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        org.apache.commons.beanutils.DynaBean dynaBean7 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer8 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer6, dynaBean7);
        boolean boolean10 = dynaBeanPropertyPointer8.equals((Object) true);
        // The following exception was thrown during execution in test generation
        try {
            int int11 = dynaBeanPropertyPointer8.getPropertyIndex();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        String str6 = jDOMNamespacePointer2.getNamespaceURI("");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest7 = null;
        org.apache.commons.jxpath.ri.NamespaceResolver namespaceResolver9 = new org.apache.commons.jxpath.ri.NamespaceResolver();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer10 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer12 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer10, "");
        jDOMNamespacePointer12.setIndex((int) (byte) 10);
        namespaceResolver9.setNamespaceContextPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer12);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.model.dom.DOMNodeIterator dOMNodeIterator16 = new org.apache.commons.jxpath.ri.model.dom.DOMNodeIterator((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, nodeTest7, false, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        org.apache.commons.beanutils.DynaBean dynaBean7 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer8 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer6, dynaBean7);
        boolean boolean10 = dynaBeanPropertyPointer8.equals((Object) true);
        // The following exception was thrown during execution in test generation
        try {
            String str11 = dynaBeanPropertyPointer8.asPath();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        java.util.Locale locale3 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer4 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext0, locale3);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer7 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer5, "");
        jDOMNamespacePointer7.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute10 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer11 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer7, attribute10);
        boolean boolean12 = jDOMAttributePointer11.isLeaf();
        boolean boolean13 = collectionPointer4.equals((Object) jDOMAttributePointer11);
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray15 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction16 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray15);
        boolean boolean17 = coreFunction16.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.Expression expression18 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression19 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual20 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression18, expression19);
        org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan coreOperationLessThan21 = new org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction16, expression19);
        // The following exception was thrown during execution in test generation
        try {
            int int22 = jDOMAttributePointer11.compareTo((Object) coreOperationLessThan21);
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan cannot be cast to org.apache.commons.jxpath.ri.model.NodePointer");
        } catch (ClassCastException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(expressionArray15);
        org.junit.Assert.assertArrayEquals(expressionArray15, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        int int0 = org.apache.commons.jxpath.ri.Compiler.FUNCTION_ID;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 4 + "'", int0 == 4);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        java.io.Reader reader0 = null;
        org.apache.commons.jxpath.ri.parser.SimpleCharStream simpleCharStream1 = new org.apache.commons.jxpath.ri.parser.SimpleCharStream(reader0);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.parser.XPathParserTokenManager xPathParserTokenManager3 = new org.apache.commons.jxpath.ri.parser.XPathParserTokenManager(simpleCharStream1, (int) (byte) 1);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.jxpath.ri.parser.TokenMgrError; message: Error: Ignoring invalid lexical state : 1. State unchanged.");
        } catch (org.apache.commons.jxpath.ri.parser.TokenMgrError e) {
            // Expected exception.
        }
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        org.apache.commons.jxpath.servlet.HttpSessionHandler httpSessionHandler0 = new org.apache.commons.jxpath.servlet.HttpSessionHandler();
        JXPathException jXPathException1 = new JXPathException();
        JXPathContextFactoryConfigurationError jXPathContextFactoryConfigurationError2 = new JXPathContextFactoryConfigurationError((Exception) jXPathException1);
        JXPathException jXPathException3 = new JXPathException((Throwable) jXPathException1);
        org.apache.commons.jxpath.ri.parser.TokenMgrError tokenMgrError4 = new org.apache.commons.jxpath.ri.parser.TokenMgrError();
        jXPathException1.addSuppressed((Throwable) tokenMgrError4);
        // The following exception was thrown during execution in test generation
        try {
            Object obj7 = httpSessionHandler0.getProperty((Object) tokenMgrError4, "namespace::");
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: org.apache.commons.jxpath.ri.parser.TokenMgrError cannot be cast to org.apache.commons.jxpath.servlet.HttpSessionAndServletContext");
        } catch (ClassCastException e) {
            // Expected exception.
        }
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.LT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 13 + "'", int0 == 13);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        org.apache.commons.beanutils.DynaBean dynaBean7 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer8 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer6, dynaBean7);
        org.apache.commons.jxpath.ri.EvalContext evalContext9 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray10 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext11 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext9, evalContextArray10);
        java.util.Locale locale12 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer13 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext9, locale12);
        org.apache.commons.jxpath.ri.QName qName14 = null;
        org.apache.commons.jxpath.ri.model.beans.NullPointer nullPointer15 = new org.apache.commons.jxpath.ri.model.beans.NullPointer((org.apache.commons.jxpath.ri.model.NodePointer) collectionPointer13, qName14);
        Object obj16 = collectionPointer13.getNodeValue();
        org.apache.commons.jxpath.ri.NamespaceResolver namespaceResolver17 = new org.apache.commons.jxpath.ri.NamespaceResolver();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer18 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer20 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer18, "");
        jDOMNamespacePointer20.setIndex((int) (byte) 10);
        namespaceResolver17.setNamespaceContextPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer20);
        // The following exception was thrown during execution in test generation
        try {
            int int24 = dynaBeanPropertyPointer8.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) collectionPointer13, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer20);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(evalContextArray10);
        org.junit.Assert.assertArrayEquals(evalContextArray10, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertNull(obj16);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        java.net.URL uRL0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.xml.DocumentContainer documentContainer1 = new org.apache.commons.jxpath.xml.DocumentContainer(uRL0);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.jxpath.JXPathException; message: XML URL is null");
        } catch (JXPathException e) {
            // Expected exception.
        }
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        java.lang.reflect.Constructor constructor0 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction1 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor0);
        Class<?> wildcardClass2 = constructorFunction1.getClass();
        org.apache.commons.jxpath.ri.EvalContext evalContext4 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray5 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext6 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext4, evalContextArray5);
        java.lang.reflect.Method method7 = org.apache.commons.jxpath.util.MethodLookupUtils.lookupMethod((Class) wildcardClass2, "namespace::", (Object[]) evalContextArray5);
        org.junit.Assert.assertNotNull(wildcardClass2);
        org.junit.Assert.assertNotNull(evalContextArray5);
        org.junit.Assert.assertArrayEquals(evalContextArray5, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertNull(method7);
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest4 = null;
        boolean boolean5 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, (Object) true, nodeTest4);
        Object obj6 = jDOMNamespacePointer2.clone();
        JXPathContext jXPathContext7 = null;
        JXPathContextFactoryConfigurationError jXPathContextFactoryConfigurationError10 = new JXPathContextFactoryConfigurationError("UNKNOWN");
        // The following exception was thrown during execution in test generation
        try {
            NodeSet nodeSet11 = jDOMNamespacePointer2.getNodeSetByKey(jXPathContext7, "namespace::/null", (Object) "UNKNOWN");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(obj6);
        org.junit.Assert.assertEquals(obj6.toString(), "namespace::");
        org.junit.Assert.assertEquals(String.valueOf(obj6), "namespace::");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj6), "namespace::");
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        boolean boolean7 = jDOMAttributePointer6.isLeaf();
        Object obj8 = jDOMAttributePointer6.getImmediateNode();
        java.lang.reflect.Constructor constructor9 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction10 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor9);
        Class<?> wildcardClass11 = constructorFunction10.getClass();
        JXPathBasicBeanInfo jXPathBasicBeanInfo13 = new JXPathBasicBeanInfo((Class) wildcardClass11, false);
        // The following exception was thrown during execution in test generation
        try {
            jDOMAttributePointer6.setValue((Object) wildcardClass11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNull(obj8);
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        JXPathFunctionNotFoundException jXPathFunctionNotFoundException1 = new JXPathFunctionNotFoundException("");
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        org.apache.commons.jxpath.ri.QName qName0 = null;
        org.apache.commons.beanutils.DynaBean dynaBean1 = null;
        java.util.Locale locale2 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer dynaBeanPointer3 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer(qName0, dynaBean1, locale2);
        org.apache.commons.jxpath.ri.QName qName6 = null;
        org.apache.commons.beanutils.DynaBean dynaBean7 = null;
        java.util.Locale locale8 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer dynaBeanPointer9 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer(qName6, dynaBean7, locale8);
        boolean boolean10 = dynaBeanPointer9.isLeaf();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.model.NodeIterator nodeIterator11 = dynaBeanPointer3.createNodeIterator("BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]", true, (org.apache.commons.jxpath.ri.model.NodePointer) dynaBeanPointer9);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.jxpath.JXPathException; message: PropertyIerator startWith parameter is not a child of the supplied parent");
        } catch (JXPathException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        JXPathContext jXPathContext0 = null;
        org.apache.commons.jxpath.ri.model.VariablePointerFactory.VariableContextWrapper variableContextWrapper1 = org.apache.commons.jxpath.ri.model.VariablePointerFactory.contextWrapper(jXPathContext0);
        JXPathContext jXPathContext2 = variableContextWrapper1.getContext();
        org.junit.Assert.assertNotNull(variableContextWrapper1);
        org.junit.Assert.assertNull(jXPathContext2);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        String str0 = org.apache.commons.jxpath.xml.DocumentContainer.MODEL_JDOM;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "JDOM" + "'", str0, "JDOM");
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        org.apache.commons.jxpath.ri.compiler.Constant constant1 = new org.apache.commons.jxpath.ri.compiler.Constant((Number) 26);
        boolean boolean2 = constant1.computeContextDependent();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        int int0 = org.apache.commons.jxpath.ri.Compiler.FUNCTION_CONCAT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 9 + "'", int0 == 9);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        int int3 = unionContext2.getCurrentPosition();
        int int4 = unionContext2.getDocumentOrder();
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest5 = null;
        org.apache.commons.jxpath.ri.axes.AttributeContext attributeContext6 = new org.apache.commons.jxpath.ri.axes.AttributeContext((org.apache.commons.jxpath.ri.EvalContext) unionContext2, nodeTest5);
        Pointer pointer7 = unionContext2.getContextNodePointer();
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNull(pointer7);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.VARIABLE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 17 + "'", int0 == 17);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        boolean boolean7 = jDOMAttributePointer6.isLeaf();
        // The following exception was thrown during execution in test generation
        try {
            jDOMAttributePointer6.setValue((Object) (-1.0f));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        org.apache.commons.jxpath.ri.model.container.ContainerPointerFactory containerPointerFactory0 = new org.apache.commons.jxpath.ri.model.container.ContainerPointerFactory();
        boolean boolean1 = org.apache.commons.jxpath.ri.JXPathContextReferenceImpl.removeNodePointerFactory((org.apache.commons.jxpath.ri.model.NodePointerFactory) containerPointerFactory0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.FUNCTION_ID;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 51 + "'", int0 == 51);
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.FUNCTION_BOOLEAN;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 67 + "'", int0 == 67);
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.AXIS_ANCESTOR;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 38 + "'", int0 == 38);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.NODE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 31 + "'", int0 == 31);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        org.apache.commons.beanutils.DynaBean dynaBean7 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer8 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer6, dynaBean7);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = dynaBeanPropertyPointer8.isCollection();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        org.apache.commons.jxpath.ri.NamespaceResolver namespaceResolver0 = new org.apache.commons.jxpath.ri.NamespaceResolver();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer1 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer3 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer1, "");
        jDOMNamespacePointer3.setIndex((int) (byte) 10);
        namespaceResolver0.setNamespaceContextPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer3);
        org.apache.commons.jxpath.ri.EvalContext evalContext7 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray8 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext9 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext7, evalContextArray8);
        java.util.Locale locale10 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer11 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext7, locale10);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer12 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer14 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer12, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest16 = null;
        boolean boolean17 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer14, (Object) true, nodeTest16);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer18 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer20 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer18, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest22 = null;
        boolean boolean23 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer20, (Object) true, nodeTest22);
        int int24 = collectionPointer11.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer14, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer20);
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest25 = null;
        boolean boolean26 = collectionPointer11.testNode(nodeTest25);
        namespaceResolver0.setNamespaceContextPointer((org.apache.commons.jxpath.ri.model.NodePointer) collectionPointer11);
        org.junit.Assert.assertNotNull(evalContextArray8);
        org.junit.Assert.assertArrayEquals(evalContextArray8, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertTrue("'" + int24 + "' != '" + 0 + "'", int24 == 0);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + true + "'", boolean26 == true);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest4 = null;
        boolean boolean5 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, (Object) true, nodeTest4);
        org.apache.commons.jxpath.ri.QName qName6 = null;
        org.apache.commons.jxpath.ri.model.beans.NullPointer nullPointer7 = new org.apache.commons.jxpath.ri.model.beans.NullPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, qName6);
        String str8 = nullPointer7.asPath();
        org.apache.commons.jxpath.ri.QName qName9 = nullPointer7.getName();
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest10 = null;
        org.apache.commons.jxpath.ri.EvalContext evalContext12 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray13 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext14 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext12, evalContextArray13);
        java.util.Locale locale15 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer16 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext12, locale15);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.model.NodeIterator nodeIterator17 = nullPointer7.childIterator(nodeTest10, false, (org.apache.commons.jxpath.ri.model.NodePointer) collectionPointer16);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.jxpath.JXPathException; message: PropertyIerator startWith parameter is not a child of the supplied parent");
        } catch (JXPathException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "namespace::/null" + "'", str8, "namespace::/null");
        org.junit.Assert.assertNull(qName9);
        org.junit.Assert.assertNotNull(evalContextArray13);
        org.junit.Assert.assertArrayEquals(evalContextArray13, new org.apache.commons.jxpath.ri.EvalContext[] {});
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        int int3 = unionContext2.getCurrentPosition();
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest4 = null;
        org.apache.commons.jxpath.ri.axes.ParentContext parentContext5 = new org.apache.commons.jxpath.ri.axes.ParentContext((org.apache.commons.jxpath.ri.EvalContext) unionContext2, nodeTest4);
        boolean boolean6 = unionContext2.nextSet();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer7 = unionContext2.getCurrentNodePointer();
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertNull(nodePointer7);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        // The following exception was thrown during execution in test generation
        try {
            Object obj3 = jDOMNamespacePointer2.getRootNode();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        Object obj5 = jDOMNamespacePointer2.getBaseValue();
        int int6 = jDOMNamespacePointer2.getIndex();
        org.junit.Assert.assertNull(obj5);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.Number;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 20 + "'", int0 == 20);
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        java.util.Locale locale3 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer4 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext0, locale3);
        org.apache.commons.jxpath.ri.QName qName5 = null;
        org.apache.commons.jxpath.ri.model.beans.NullPointer nullPointer6 = new org.apache.commons.jxpath.ri.model.beans.NullPointer((org.apache.commons.jxpath.ri.model.NodePointer) collectionPointer4, qName5);
        org.apache.commons.jxpath.ri.QName qName9 = null;
        org.apache.commons.jxpath.ri.EvalContext evalContext10 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray11 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext12 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext10, evalContextArray11);
        java.util.Locale locale13 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer14 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext10, locale13);
        Object obj15 = collectionPointer14.getImmediateNode();
        org.apache.commons.jxpath.servlet.ServletContextHandler servletContextHandler16 = new org.apache.commons.jxpath.servlet.ServletContextHandler();
        java.util.Locale locale17 = null;
        org.apache.commons.jxpath.ri.model.dynamic.DynamicPointer dynamicPointer18 = new org.apache.commons.jxpath.ri.model.dynamic.DynamicPointer(qName9, (Object) collectionPointer14, (DynamicPropertyHandler) servletContextHandler16, locale17);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.model.NodeIterator nodeIterator19 = nullPointer6.createNodeIterator("/", false, (org.apache.commons.jxpath.ri.model.NodePointer) collectionPointer14);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.jxpath.JXPathException; message: PropertyIerator startWith parameter is not a child of the supplied parent");
        } catch (JXPathException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertNotNull(evalContextArray11);
        org.junit.Assert.assertArrayEquals(evalContextArray11, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertNull(obj15);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        int int0 = org.apache.commons.jxpath.ri.Compiler.FUNCTION_SUBSTRING;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 14 + "'", int0 == 14);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        java.lang.reflect.Constructor constructor0 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction1 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor0);
        Class<?> wildcardClass2 = constructorFunction1.getClass();
        JXPathBasicBeanInfo jXPathBasicBeanInfo4 = new JXPathBasicBeanInfo((Class) wildcardClass2, false);
        boolean boolean5 = jXPathBasicBeanInfo4.isAtomic();
        Class class6 = jXPathBasicBeanInfo4.getDynamicPropertyHandlerClass();
        org.junit.Assert.assertNotNull(wildcardClass2);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNull(class6);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        boolean boolean7 = jDOMAttributePointer6.isLeaf();
        Object obj8 = jDOMAttributePointer6.getImmediateNode();
        java.lang.reflect.Constructor constructor9 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction10 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor9);
        Class<?> wildcardClass11 = constructorFunction10.getClass();
        JXPathBasicBeanInfo jXPathBasicBeanInfo13 = new JXPathBasicBeanInfo((Class) wildcardClass11, false);
        String str14 = jXPathBasicBeanInfo13.toString();
        org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer beanPropertyPointer15 = new org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer6, (JXPathBeanInfo) jXPathBasicBeanInfo13);
        // The following exception was thrown during execution in test generation
        try {
            jDOMAttributePointer6.setValue((Object) 17);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNull(obj8);
        org.junit.Assert.assertNotNull(wildcardClass11);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]" + "'", str14, "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]");
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        int int3 = unionContext2.getDocumentOrder();
        java.util.List list4 = unionContext2.getContextNodeList();
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(list4);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        org.apache.commons.jxpath.ri.JXPathContextReferenceImpl jXPathContextReferenceImpl0 = null;
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer1 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer3 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer1, "");
        jDOMNamespacePointer3.setIndex((int) (byte) 10);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.axes.RootContext rootContext6 = new org.apache.commons.jxpath.ri.axes.RootContext(jXPathContextReferenceImpl0, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        String str7 = jDOMAttributePointer6.asPath();
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "namespace::/@null" + "'", str7, "namespace::/@null");
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        org.apache.commons.jxpath.servlet.HttpSessionHandler httpSessionHandler0 = new org.apache.commons.jxpath.servlet.HttpSessionHandler();
        org.apache.commons.jxpath.ri.NamespaceResolver namespaceResolver1 = new org.apache.commons.jxpath.ri.NamespaceResolver();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer2 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer4 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer2, "");
        jDOMNamespacePointer4.setIndex((int) (byte) 10);
        namespaceResolver1.setNamespaceContextPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer4);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer9 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer11 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer9, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest13 = null;
        boolean boolean14 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer11, (Object) true, nodeTest13);
        org.apache.commons.jxpath.ri.QName qName15 = null;
        org.apache.commons.jxpath.ri.model.beans.NullPointer nullPointer16 = new org.apache.commons.jxpath.ri.model.beans.NullPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer11, qName15);
        String str17 = nullPointer16.asPath();
        // The following exception was thrown during execution in test generation
        try {
            httpSessionHandler0.setProperty((Object) namespaceResolver1, "http://www.w3.org/XML/1998/namespace", (Object) nullPointer16);
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: org.apache.commons.jxpath.ri.NamespaceResolver cannot be cast to org.apache.commons.jxpath.servlet.HttpSessionAndServletContext");
        } catch (ClassCastException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "namespace::/null" + "'", str17, "namespace::/null");
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray1 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction2 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray1);
        int int3 = coreFunction2.getArgumentCount();
        org.apache.commons.jxpath.ri.compiler.CoreOperationNegate coreOperationNegate4 = new org.apache.commons.jxpath.ri.compiler.CoreOperationNegate((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction2);
        String str5 = coreOperationNegate4.getSymbol();
        org.junit.Assert.assertNotNull(expressionArray1);
        org.junit.Assert.assertArrayEquals(expressionArray1, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "-" + "'", str5, "-");
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test125");
        Object obj2 = org.apache.commons.jxpath.util.ValueUtils.getValue((Object) 72, 27);
        org.junit.Assert.assertEquals("'" + obj2 + "' != '" + 72 + "'", obj2, 72);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test126");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        int int3 = unionContext2.getCurrentPosition();
        int int4 = unionContext2.getDocumentOrder();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer5 = unionContext2.getCurrentNodePointer();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.axes.InitialContext initialContext6 = new org.apache.commons.jxpath.ri.axes.InitialContext((org.apache.commons.jxpath.ri.EvalContext) unionContext2);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 0, Size: 0");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNull(nodePointer5);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test127");
        org.apache.commons.jxpath.ri.QName qName0 = null;
        org.apache.commons.jxpath.ri.compiler.VariableReference variableReference1 = new org.apache.commons.jxpath.ri.compiler.VariableReference(qName0);
        org.apache.commons.jxpath.ri.EvalContext evalContext2 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray3 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext4 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext2, evalContextArray3);
        int int5 = unionContext4.getCurrentPosition();
        int int6 = unionContext4.getDocumentOrder();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer7 = unionContext4.getCurrentNodePointer();
        unionContext4.reset();
        // The following exception was thrown during execution in test generation
        try {
            Object obj9 = variableReference1.compute((org.apache.commons.jxpath.ri.EvalContext) unionContext4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(evalContextArray3);
        org.junit.Assert.assertArrayEquals(evalContextArray3, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertNull(nodePointer7);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test128");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest4 = null;
        boolean boolean5 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, (Object) true, nodeTest4);
        org.apache.commons.jxpath.ri.QName qName6 = null;
        org.apache.commons.jxpath.ri.model.beans.NullPointer nullPointer7 = new org.apache.commons.jxpath.ri.model.beans.NullPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, qName6);
        int int8 = nullPointer7.getLength();
        org.apache.commons.jxpath.ri.QName qName10 = new org.apache.commons.jxpath.ri.QName("JDOM");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.model.NodePointer nodePointer12 = org.apache.commons.jxpath.ri.model.NodePointer.newChildNodePointer((org.apache.commons.jxpath.ri.model.NodePointer) nullPointer7, qName10, (Object) 6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test129");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.FUNCTION_FLOOR;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 75 + "'", int0 == 75);
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test130");
        String str1 = org.apache.commons.jxpath.ri.compiler.NodeTypeTest.nodeTypeToString(21);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "UNKNOWN" + "'", str1, "UNKNOWN");
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test131");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.EOF;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 0 + "'", int0 == 0);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test132");
        Container container0 = null;
        java.util.Locale locale1 = null;
        org.apache.commons.jxpath.ri.model.container.ContainerPointer containerPointer2 = new org.apache.commons.jxpath.ri.model.container.ContainerPointer(container0, locale1);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test133");
        java.io.Reader reader0 = null;
        org.apache.commons.jxpath.ri.parser.SimpleCharStream simpleCharStream1 = new org.apache.commons.jxpath.ri.parser.SimpleCharStream(reader0);
        // The following exception was thrown during execution in test generation
        try {
            int int2 = simpleCharStream1.getColumn();
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: -1");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test134");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer1 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer3 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer1, "");
        jDOMNamespacePointer3.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute6 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer7 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer3, attribute6);
        org.apache.commons.beanutils.DynaBean dynaBean8 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer9 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer7, dynaBean8);
        org.apache.commons.jxpath.servlet.KeywordVariables keywordVariables10 = new org.apache.commons.jxpath.servlet.KeywordVariables("hi!", (Object) dynaBean8);
        org.apache.commons.jxpath.ri.EvalContext evalContext12 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray13 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext14 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext12, evalContextArray13);
        // The following exception was thrown during execution in test generation
        try {
            keywordVariables10.declareVariable("DOM", (Object) unionContext14);
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: Cannot declare new keyword variables.");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(evalContextArray13);
        org.junit.Assert.assertArrayEquals(evalContextArray13, new org.apache.commons.jxpath.ri.EvalContext[] {});
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test135");
        java.lang.reflect.Method method0 = null;
        java.lang.reflect.Method method1 = org.apache.commons.jxpath.util.ValueUtils.getAccessibleMethod(method0);
        org.junit.Assert.assertNull(method1);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test136");
        org.apache.commons.jxpath.servlet.JXPathServletContexts jXPathServletContexts0 = new org.apache.commons.jxpath.servlet.JXPathServletContexts();
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test137");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        java.util.Locale locale3 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer4 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext0, locale3);
        org.apache.commons.jxpath.ri.QName qName5 = null;
        org.apache.commons.jxpath.ri.model.beans.NullPointer nullPointer6 = new org.apache.commons.jxpath.ri.model.beans.NullPointer((org.apache.commons.jxpath.ri.model.NodePointer) collectionPointer4, qName5);
        Object obj7 = collectionPointer4.getNodeValue();
        JXPathContext jXPathContext8 = null;
        org.apache.commons.jxpath.ri.QName qName10 = new org.apache.commons.jxpath.ri.QName("JDOM");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.model.NodePointer nodePointer12 = collectionPointer4.createChild(jXPathContext8, qName10, 8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertNull(obj7);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test138");
        int int0 = org.apache.commons.jxpath.ri.Compiler.FUNCTION_CEILING;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 26 + "'", int0 == 26);
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test139");
        org.apache.commons.jxpath.ri.QName qName1 = new org.apache.commons.jxpath.ri.QName("JDOM");
        java.util.Locale locale3 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.model.NodePointer nodePointer4 = org.apache.commons.jxpath.ri.model.NodePointer.newNodePointer(qName1, (Object) "", locale3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test140");
        org.apache.commons.jxpath.xml.JDOMParser jDOMParser0 = new org.apache.commons.jxpath.xml.JDOMParser();
        jDOMParser0.setIgnoringElementContentWhitespace(true);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test141");
        org.apache.commons.jxpath.ri.NamespaceResolver namespaceResolver0 = new org.apache.commons.jxpath.ri.NamespaceResolver();
        String str2 = namespaceResolver0.getPrefix("DOM");
        org.junit.Assert.assertNull(str2);
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test142");
        int int0 = org.apache.commons.jxpath.ri.Compiler.NODE_TYPE_COMMENT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 3 + "'", int0 == 3);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test143");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        int int3 = unionContext2.getCurrentPosition();
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest4 = null;
        org.apache.commons.jxpath.ri.axes.NamespaceContext namespaceContext5 = new org.apache.commons.jxpath.ri.axes.NamespaceContext((org.apache.commons.jxpath.ri.EvalContext) unionContext2, nodeTest4);
        boolean boolean6 = namespaceContext5.nextNode();
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test144");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest4 = null;
        boolean boolean5 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, (Object) true, nodeTest4);
        String str6 = jDOMNamespacePointer2.asPath();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer7 = jDOMNamespacePointer2.getImmediateParentPointer();
        String str8 = jDOMNamespacePointer2.asPath();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "namespace::" + "'", str6, "namespace::");
        org.junit.Assert.assertNull(nodePointer7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "namespace::" + "'", str8, "namespace::");
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test145");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.Ideographic;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 23 + "'", int0 == 23);
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test146");
        org.apache.commons.jxpath.ri.QName qName0 = null;
        org.apache.commons.beanutils.DynaBean dynaBean1 = null;
        java.util.Locale locale2 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer dynaBeanPointer3 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer(qName0, dynaBean1, locale2);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer4 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer4, "");
        jDOMNamespacePointer6.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute9 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer10 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer6, attribute9);
        boolean boolean11 = jDOMAttributePointer10.isLeaf();
        Object obj12 = jDOMAttributePointer10.getImmediateNode();
        java.lang.reflect.Constructor constructor13 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction14 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor13);
        Class<?> wildcardClass15 = constructorFunction14.getClass();
        JXPathBasicBeanInfo jXPathBasicBeanInfo17 = new JXPathBasicBeanInfo((Class) wildcardClass15, false);
        String str18 = jXPathBasicBeanInfo17.toString();
        org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer beanPropertyPointer19 = new org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer10, (JXPathBeanInfo) jXPathBasicBeanInfo17);
        int int20 = dynaBeanPointer3.compareTo((Object) beanPropertyPointer19);
        boolean boolean21 = dynaBeanPointer3.isDynamicPropertyDeclarationSupported();
        ExceptionHandler exceptionHandler22 = null;
        dynaBeanPointer3.setExceptionHandler(exceptionHandler22);
        int int24 = dynaBeanPointer3.getLength();
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNull(obj12);
        org.junit.Assert.assertNotNull(wildcardClass15);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]" + "'", str18, "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]");
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + int24 + "' != '" + 1 + "'", int24 == 1);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test147");
        JXPathException jXPathException0 = new JXPathException();
        JXPathContextFactoryConfigurationError jXPathContextFactoryConfigurationError1 = new JXPathContextFactoryConfigurationError((Exception) jXPathException0);
        JXPathException jXPathException2 = new JXPathException((Throwable) jXPathException0);
        org.apache.commons.jxpath.ri.parser.TokenMgrError tokenMgrError3 = new org.apache.commons.jxpath.ri.parser.TokenMgrError();
        jXPathException0.addSuppressed((Throwable) tokenMgrError3);
        char char5 = tokenMgrError3.getCharacter();
        org.junit.Assert.assertTrue("'" + char5 + "' != '" + '\000' + "'", char5 == '\000');
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test148");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        int int3 = unionContext2.getCurrentPosition();
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest4 = null;
        org.apache.commons.jxpath.ri.axes.ParentContext parentContext5 = new org.apache.commons.jxpath.ri.axes.ParentContext((org.apache.commons.jxpath.ri.EvalContext) unionContext2, nodeTest4);
        // The following exception was thrown during execution in test generation
        try {
            Object obj6 = parentContext5.next();
            org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException; message: null");
        } catch (java.util.NoSuchElementException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test149");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.FUNCTION_STRING_LENGTH;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 64 + "'", int0 == 64);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test150");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        java.util.Locale locale3 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer4 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext0, locale3);
        org.apache.commons.jxpath.ri.QName qName5 = null;
        org.apache.commons.jxpath.ri.model.beans.NullPointer nullPointer6 = new org.apache.commons.jxpath.ri.model.beans.NullPointer((org.apache.commons.jxpath.ri.model.NodePointer) collectionPointer4, qName5);
        Object obj7 = collectionPointer4.getNodeValue();
        java.util.Iterator iterator8 = org.apache.commons.jxpath.util.ValueUtils.iterate(obj7);
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertNull(obj7);
        org.junit.Assert.assertNotNull(iterator8);
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test151");
        org.apache.commons.jxpath.ri.QName qName0 = null;
        org.apache.commons.beanutils.DynaBean dynaBean1 = null;
        java.util.Locale locale2 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer dynaBeanPointer3 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer(qName0, dynaBean1, locale2);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer4 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer4, "");
        jDOMNamespacePointer6.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute9 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer10 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer6, attribute9);
        boolean boolean11 = jDOMAttributePointer10.isLeaf();
        Object obj12 = jDOMAttributePointer10.getImmediateNode();
        java.lang.reflect.Constructor constructor13 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction14 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor13);
        Class<?> wildcardClass15 = constructorFunction14.getClass();
        JXPathBasicBeanInfo jXPathBasicBeanInfo17 = new JXPathBasicBeanInfo((Class) wildcardClass15, false);
        String str18 = jXPathBasicBeanInfo17.toString();
        org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer beanPropertyPointer19 = new org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer10, (JXPathBeanInfo) jXPathBasicBeanInfo17);
        int int20 = dynaBeanPointer3.compareTo((Object) beanPropertyPointer19);
        boolean boolean21 = dynaBeanPointer3.isDynamicPropertyDeclarationSupported();
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray23 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction24 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray23);
        boolean boolean25 = coreFunction24.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.Expression expression26 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression27 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual28 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression26, expression27);
        org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan coreOperationLessThan29 = new org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction24, expression27);
        // The following exception was thrown during execution in test generation
        try {
            dynaBeanPointer3.setValue((Object) coreFunction24);
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: Cannot replace the root object");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNull(obj12);
        org.junit.Assert.assertNotNull(wildcardClass15);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]" + "'", str18, "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]");
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(expressionArray23);
        org.junit.Assert.assertArrayEquals(expressionArray23, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test152");
        JXPathContext jXPathContext0 = null;
        // The following exception was thrown during execution in test generation
        try {
            JXPathContext jXPathContext2 = JXPathContext.newContext(jXPathContext0, (Object) 26);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test153");
        org.apache.commons.jxpath.ri.QName qName0 = null;
        org.apache.commons.beanutils.DynaBean dynaBean1 = null;
        java.util.Locale locale2 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer dynaBeanPointer3 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer(qName0, dynaBean1, locale2);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer4 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer4, "");
        jDOMNamespacePointer6.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute9 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer10 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer6, attribute9);
        boolean boolean11 = jDOMAttributePointer10.isLeaf();
        Object obj12 = jDOMAttributePointer10.getImmediateNode();
        java.lang.reflect.Constructor constructor13 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction14 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor13);
        Class<?> wildcardClass15 = constructorFunction14.getClass();
        JXPathBasicBeanInfo jXPathBasicBeanInfo17 = new JXPathBasicBeanInfo((Class) wildcardClass15, false);
        String str18 = jXPathBasicBeanInfo17.toString();
        org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer beanPropertyPointer19 = new org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer10, (JXPathBeanInfo) jXPathBasicBeanInfo17);
        int int20 = dynaBeanPointer3.compareTo((Object) beanPropertyPointer19);
        Object obj21 = beanPropertyPointer19.getBaseValue();
        JXPathException jXPathException22 = new JXPathException();
        JXPathContextFactoryConfigurationError jXPathContextFactoryConfigurationError23 = new JXPathContextFactoryConfigurationError((Exception) jXPathException22);
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest24 = null;
        boolean boolean25 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) beanPropertyPointer19, (Object) jXPathException22, nodeTest24);
        JXPathContext jXPathContext26 = null;
        // The following exception was thrown during execution in test generation
        try {
            Pointer pointer28 = beanPropertyPointer19.getPointerByID(jXPathContext26, "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNull(obj12);
        org.junit.Assert.assertNotNull(wildcardClass15);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]" + "'", str18, "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]");
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertNull(obj21);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + true + "'", boolean25 == true);
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test154");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        int int3 = unionContext2.getCurrentPosition();
        int int4 = unionContext2.getDocumentOrder();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer5 = unionContext2.getCurrentNodePointer();
        unionContext2.reset();
        // The following exception was thrown during execution in test generation
        try {
            JXPathContext jXPathContext7 = unionContext2.getJXPathContext();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNull(nodePointer5);
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test155");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.FUNCTION_STRING;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 56 + "'", int0 == 56);
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test156");
        int int0 = org.apache.commons.jxpath.ri.model.dynamic.DynamicPointerFactory.DYNAMIC_POINTER_FACTORY_ORDER;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 800 + "'", int0 == 800);
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test157");
        int int0 = org.apache.commons.jxpath.ri.Compiler.AXIS_NAMESPACE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 6 + "'", int0 == 6);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test158");
        int int0 = org.apache.commons.jxpath.ri.Compiler.AXIS_ANCESTOR;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 4 + "'", int0 == 4);
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test159");
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray1 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction2 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray1);
        boolean boolean3 = coreFunction2.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.Expression expression4 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression5 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual6 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression4, expression5);
        org.apache.commons.jxpath.ri.compiler.NameAttributeTest nameAttributeTest7 = new org.apache.commons.jxpath.ri.compiler.NameAttributeTest((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction2, (org.apache.commons.jxpath.ri.compiler.Expression) coreOperationGreaterThanOrEqual6);
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray9 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction10 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray9);
        boolean boolean11 = coreFunction10.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.Expression expression12 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression13 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual14 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression12, expression13);
        org.apache.commons.jxpath.ri.compiler.NameAttributeTest nameAttributeTest15 = new org.apache.commons.jxpath.ri.compiler.NameAttributeTest((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction10, (org.apache.commons.jxpath.ri.compiler.Expression) coreOperationGreaterThanOrEqual14);
        org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan coreOperationLessThan16 = new org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan((org.apache.commons.jxpath.ri.compiler.Expression) nameAttributeTest7, (org.apache.commons.jxpath.ri.compiler.Expression) nameAttributeTest15);
        org.apache.commons.jxpath.ri.EvalContext evalContext17 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray18 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext19 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext17, evalContextArray18);
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest20 = null;
        org.apache.commons.jxpath.ri.axes.SelfContext selfContext21 = new org.apache.commons.jxpath.ri.axes.SelfContext((org.apache.commons.jxpath.ri.EvalContext) unionContext19, nodeTest20);
        // The following exception was thrown during execution in test generation
        try {
            Object obj22 = nameAttributeTest7.computeValue((org.apache.commons.jxpath.ri.EvalContext) unionContext19);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(expressionArray1);
        org.junit.Assert.assertArrayEquals(expressionArray1, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(expressionArray9);
        org.junit.Assert.assertArrayEquals(expressionArray9, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(evalContextArray18);
        org.junit.Assert.assertArrayEquals(evalContextArray18, new org.apache.commons.jxpath.ri.EvalContext[] {});
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test160");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        String str6 = jDOMNamespacePointer2.getNamespaceURI("");
        // The following exception was thrown during execution in test generation
        try {
            Object obj7 = jDOMNamespacePointer2.getImmediateNode();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test161");
        org.apache.commons.jxpath.ri.QName qName0 = null;
        org.apache.commons.beanutils.DynaBean dynaBean1 = null;
        java.util.Locale locale2 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer dynaBeanPointer3 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer(qName0, dynaBean1, locale2);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer4 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer4, "");
        jDOMNamespacePointer6.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute9 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer10 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer6, attribute9);
        boolean boolean11 = jDOMAttributePointer10.isLeaf();
        Object obj12 = jDOMAttributePointer10.getImmediateNode();
        java.lang.reflect.Constructor constructor13 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction14 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor13);
        Class<?> wildcardClass15 = constructorFunction14.getClass();
        JXPathBasicBeanInfo jXPathBasicBeanInfo17 = new JXPathBasicBeanInfo((Class) wildcardClass15, false);
        String str18 = jXPathBasicBeanInfo17.toString();
        org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer beanPropertyPointer19 = new org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer10, (JXPathBeanInfo) jXPathBasicBeanInfo17);
        int int20 = dynaBeanPointer3.compareTo((Object) beanPropertyPointer19);
        boolean boolean21 = dynaBeanPointer3.isDynamicPropertyDeclarationSupported();
        Object obj22 = dynaBeanPointer3.getBaseValue();
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNull(obj12);
        org.junit.Assert.assertNotNull(wildcardClass15);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]" + "'", str18, "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]");
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNull(obj22);
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test162");
        int int0 = org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointerFactory.DYNA_BEAN_POINTER_FACTORY_ORDER;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 700 + "'", int0 == 700);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test163");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        org.apache.commons.beanutils.DynaBean dynaBean7 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer8 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer6, dynaBean7);
        boolean boolean9 = dynaBeanPropertyPointer8.isRoot();
        // The following exception was thrown during execution in test generation
        try {
            String[] strArray10 = dynaBeanPropertyPointer8.getPropertyNames();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test164");
        Object obj2 = org.apache.commons.jxpath.ri.JXPathContextReferenceImpl.allocateConditionally("namespace::", "/");
        org.junit.Assert.assertNull(obj2);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test165");
        org.apache.commons.jxpath.ri.parser.Token token0 = new org.apache.commons.jxpath.ri.parser.Token();
        String str1 = token0.toString();
        token0.beginLine = 26;
        org.junit.Assert.assertNull(str1);
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test166");
        JXPathContext jXPathContext0 = null;
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer2 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer4 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer2, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest6 = null;
        boolean boolean7 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer4, (Object) true, nodeTest6);
        org.apache.commons.jxpath.ri.QName qName8 = null;
        org.apache.commons.jxpath.ri.model.beans.NullPointer nullPointer9 = new org.apache.commons.jxpath.ri.model.beans.NullPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer4, qName8);
        org.apache.commons.jxpath.ri.model.beans.PropertyPointer propertyPointer10 = nullPointer9.getPropertyPointer();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer11 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer13 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer11, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest15 = null;
        boolean boolean16 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer13, (Object) true, nodeTest15);
        String str17 = jDOMNamespacePointer13.asPath();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer18 = jDOMNamespacePointer13.getImmediateParentPointer();
        boolean boolean19 = propertyPointer10.equals((Object) jDOMNamespacePointer13);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.JXPathContextReferenceImpl jXPathContextReferenceImpl20 = new org.apache.commons.jxpath.ri.JXPathContextReferenceImpl(jXPathContext0, (Object) 10.0f, (Pointer) propertyPointer10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNotNull(propertyPointer10);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "namespace::" + "'", str17, "namespace::");
        org.junit.Assert.assertNull(nodePointer18);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test167");
        String str0 = org.apache.commons.jxpath.ri.model.NodePointer.UNKNOWN_NAMESPACE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "<<unknown namespace>>" + "'", str0, "<<unknown namespace>>");
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test168");
        JXPathContextFactoryConfigurationError jXPathContextFactoryConfigurationError1 = new JXPathContextFactoryConfigurationError("/");
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test169");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.UNION;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 8 + "'", int0 == 8);
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test170");
        boolean boolean0 = org.apache.commons.jxpath.ri.parser.SimpleCharStream.staticFlag;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test171");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        java.util.Locale locale3 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer4 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext0, locale3);
        String str5 = collectionPointer4.asPath();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer7 = collectionPointer4.namespacePointer("BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]");
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "/" + "'", str5, "/");
        org.junit.Assert.assertNull(nodePointer7);
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test172");
        int int0 = org.apache.commons.jxpath.ri.Compiler.NODE_TYPE_PI;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 4 + "'", int0 == 4);
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test173");
        org.apache.commons.jxpath.ri.InfoSetUtil infoSetUtil0 = new org.apache.commons.jxpath.ri.InfoSetUtil();
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test174");
        org.apache.commons.jxpath.servlet.ServletContextHandler servletContextHandler0 = new org.apache.commons.jxpath.servlet.ServletContextHandler();
        org.apache.commons.jxpath.util.TypeConverter typeConverter1 = org.apache.commons.jxpath.util.TypeUtils.getTypeConverter();
        org.apache.commons.jxpath.ri.NamespaceResolver namespaceResolver2 = new org.apache.commons.jxpath.ri.NamespaceResolver();
        java.lang.reflect.Constructor constructor3 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction4 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor3);
        Class<?> wildcardClass5 = constructorFunction4.getClass();
        JXPathBeanInfo jXPathBeanInfo6 = JXPathIntrospector.getBeanInfo((Class) wildcardClass5);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer8 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer10 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer8, "");
        org.apache.commons.jxpath.ri.model.dom.NamespacePointer namespacePointer12 = new org.apache.commons.jxpath.ri.model.dom.NamespacePointer(nodePointer8, "");
        String str13 = namespacePointer12.asPath();
        org.apache.commons.jxpath.ri.EvalContext evalContext14 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray15 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext16 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext14, evalContextArray15);
        java.util.Locale locale17 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer18 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext14, locale17);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer19 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer21 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer19, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest23 = null;
        boolean boolean24 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer21, (Object) true, nodeTest23);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer25 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer27 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer25, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest29 = null;
        boolean boolean30 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer27, (Object) true, nodeTest29);
        int int31 = collectionPointer18.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer21, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer27);
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest32 = null;
        boolean boolean33 = collectionPointer18.testNode(nodeTest32);
        JXPathFunctionNotFoundException jXPathFunctionNotFoundException35 = new JXPathFunctionNotFoundException("namespace::");
        Object[] objArray36 = new Object[] { namespacePointer12, nodeTest32, "namespace::" };
        java.lang.reflect.Method method37 = org.apache.commons.jxpath.util.MethodLookupUtils.lookupStaticMethod((Class) wildcardClass5, "/", objArray36);
        boolean boolean38 = typeConverter1.canConvert((Object) namespaceResolver2, (Class) wildcardClass5);
        org.apache.commons.jxpath.ri.parser.Token token40 = new org.apache.commons.jxpath.ri.parser.Token();
        String str41 = token40.toString();
        // The following exception was thrown during execution in test generation
        try {
            servletContextHandler0.setProperty((Object) namespaceResolver2, "JDOM", (Object) token40);
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: org.apache.commons.jxpath.ri.NamespaceResolver cannot be cast to javax.servlet.ServletContext");
        } catch (ClassCastException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(typeConverter1);
        org.junit.Assert.assertNotNull(wildcardClass5);
        org.junit.Assert.assertNotNull(jXPathBeanInfo6);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "namespace::" + "'", str13, "namespace::");
        org.junit.Assert.assertNotNull(evalContextArray15);
        org.junit.Assert.assertArrayEquals(evalContextArray15, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + true + "'", boolean30 == true);
        org.junit.Assert.assertTrue("'" + int31 + "' != '" + 0 + "'", int31 == 0);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + true + "'", boolean33 == true);
        org.junit.Assert.assertNotNull(objArray36);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray36), "[namespace::, null, namespace::]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray36), "[namespace::, null, namespace::]");
        org.junit.Assert.assertNull(method37);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertNull(str41);
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test175");
        int int0 = org.apache.commons.jxpath.ri.Compiler.FUNCTION_TRUE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 20 + "'", int0 == 20);
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test176");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.SLASH;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 6 + "'", int0 == 6);
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test177");
        JXPathException jXPathException1 = new JXPathException();
        JXPathContextFactoryConfigurationError jXPathContextFactoryConfigurationError2 = new JXPathContextFactoryConfigurationError((Exception) jXPathException1);
        JXPathException jXPathException3 = new JXPathException((Throwable) jXPathException1);
        org.apache.commons.jxpath.ri.parser.TokenMgrError tokenMgrError4 = new org.apache.commons.jxpath.ri.parser.TokenMgrError();
        jXPathException1.addSuppressed((Throwable) tokenMgrError4);
        JXPathException jXPathException6 = new JXPathException("/", (Throwable) tokenMgrError4);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test178");
        org.apache.commons.jxpath.util.ClassLoaderUtil classLoaderUtil0 = new org.apache.commons.jxpath.util.ClassLoaderUtil();
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test179");
        java.io.Reader reader0 = null;
        org.apache.commons.jxpath.ri.parser.SimpleCharStream simpleCharStream1 = new org.apache.commons.jxpath.ri.parser.SimpleCharStream(reader0);
        simpleCharStream1.backup((int) (byte) 10);
        char char4 = simpleCharStream1.BeginToken();
        org.junit.Assert.assertTrue("'" + char4 + "' != '" + '\000' + "'", char4 == '\000');
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test180");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer1 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer3 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer1, "");
        jDOMNamespacePointer3.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute6 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer7 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer3, attribute6);
        org.apache.commons.beanutils.DynaBean dynaBean8 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer9 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer7, dynaBean8);
        org.apache.commons.jxpath.servlet.KeywordVariables keywordVariables10 = new org.apache.commons.jxpath.servlet.KeywordVariables("hi!", (Object) dynaBean8);
        Object obj12 = keywordVariables10.getVariable("namespace::/@null");
        // The following exception was thrown during execution in test generation
        try {
            keywordVariables10.undeclareVariable("UNKNOWN");
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: Cannot undeclare keyword variables.");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(obj12);
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test181");
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray1 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction2 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray1);
        org.apache.commons.jxpath.ri.compiler.CoreOperationAdd coreOperationAdd3 = new org.apache.commons.jxpath.ri.compiler.CoreOperationAdd(expressionArray1);
        org.apache.commons.jxpath.ri.compiler.CoreOperationOr coreOperationOr4 = new org.apache.commons.jxpath.ri.compiler.CoreOperationOr(expressionArray1);
        org.apache.commons.jxpath.ri.EvalContext evalContext5 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray6 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext7 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext5, evalContextArray6);
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest8 = null;
        org.apache.commons.jxpath.ri.axes.SelfContext selfContext9 = new org.apache.commons.jxpath.ri.axes.SelfContext((org.apache.commons.jxpath.ri.EvalContext) unionContext7, nodeTest8);
        selfContext9.reset();
        Object obj11 = coreOperationOr4.computeValue((org.apache.commons.jxpath.ri.EvalContext) selfContext9);
        org.junit.Assert.assertNotNull(expressionArray1);
        org.junit.Assert.assertArrayEquals(expressionArray1, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertNotNull(evalContextArray6);
        org.junit.Assert.assertArrayEquals(evalContextArray6, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertEquals("'" + obj11 + "' != '" + false + "'", obj11, false);
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test182");
        JXPathInvalidAccessException jXPathInvalidAccessException1 = new JXPathInvalidAccessException("UNKNOWN");
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test183");
        org.apache.commons.jxpath.xml.DOMParser dOMParser0 = new org.apache.commons.jxpath.xml.DOMParser();
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test184");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        org.apache.commons.beanutils.DynaBean dynaBean7 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer8 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer6, dynaBean7);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer9 = jDOMAttributePointer6.getParent();
        nodePointer9.setIndex(14);
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest12 = null;
        boolean boolean13 = nodePointer9.testNode(nodeTest12);
        org.junit.Assert.assertNotNull(nodePointer9);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test185");
        java.io.Reader reader0 = null;
        org.apache.commons.jxpath.ri.parser.SimpleCharStream simpleCharStream1 = new org.apache.commons.jxpath.ri.parser.SimpleCharStream(reader0);
        java.io.InputStream inputStream2 = null;
        // The following exception was thrown during execution in test generation
        try {
            simpleCharStream1.ReInit(inputStream2, (int) (byte) 1, 4, (int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test186");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        org.apache.commons.beanutils.DynaBean dynaBean7 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer8 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer6, dynaBean7);
        boolean boolean9 = dynaBeanPropertyPointer8.isRoot();
        // The following exception was thrown during execution in test generation
        try {
            int int10 = dynaBeanPropertyPointer8.getPropertyIndex();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test187");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        org.apache.commons.beanutils.DynaBean dynaBean7 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer8 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer6, dynaBean7);
        boolean boolean9 = dynaBeanPropertyPointer8.isRoot();
        org.apache.commons.jxpath.ri.QName qName10 = null;
        org.apache.commons.beanutils.DynaBean dynaBean11 = null;
        java.util.Locale locale12 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer dynaBeanPointer13 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer(qName10, dynaBean11, locale12);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer14 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer16 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer14, "");
        jDOMNamespacePointer16.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute19 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer20 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer16, attribute19);
        boolean boolean21 = jDOMAttributePointer20.isLeaf();
        Object obj22 = jDOMAttributePointer20.getImmediateNode();
        java.lang.reflect.Constructor constructor23 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction24 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor23);
        Class<?> wildcardClass25 = constructorFunction24.getClass();
        JXPathBasicBeanInfo jXPathBasicBeanInfo27 = new JXPathBasicBeanInfo((Class) wildcardClass25, false);
        String str28 = jXPathBasicBeanInfo27.toString();
        org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer beanPropertyPointer29 = new org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer20, (JXPathBeanInfo) jXPathBasicBeanInfo27);
        int int30 = dynaBeanPointer13.compareTo((Object) beanPropertyPointer29);
        Object obj31 = beanPropertyPointer29.getBaseValue();
        org.apache.commons.jxpath.ri.QName qName32 = beanPropertyPointer29.getName();
        java.util.Locale locale33 = null;
        org.apache.commons.jxpath.ri.model.beans.NullPointer nullPointer34 = new org.apache.commons.jxpath.ri.model.beans.NullPointer(qName32, locale33);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.model.NodeIterator nodeIterator35 = dynaBeanPropertyPointer8.attributeIterator(qName32);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + true + "'", boolean21 == true);
        org.junit.Assert.assertNull(obj22);
        org.junit.Assert.assertNotNull(wildcardClass25);
        org.junit.Assert.assertEquals("'" + str28 + "' != '" + "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]" + "'", str28, "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]");
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 0 + "'", int30 == 0);
        org.junit.Assert.assertNull(obj31);
        org.junit.Assert.assertNotNull(qName32);
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test188");
        java.io.Reader reader0 = null;
        org.apache.commons.jxpath.ri.parser.SimpleCharStream simpleCharStream1 = new org.apache.commons.jxpath.ri.parser.SimpleCharStream(reader0);
        int int2 = simpleCharStream1.getBeginLine();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test189");
        String str0 = org.apache.commons.jxpath.servlet.Constants.SESSION_SCOPE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "session" + "'", str0, "session");
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test190");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        java.util.Locale locale3 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer4 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext0, locale3);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer7 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer5, "");
        jDOMNamespacePointer7.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute10 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer11 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer7, attribute10);
        boolean boolean12 = jDOMAttributePointer11.isLeaf();
        boolean boolean13 = collectionPointer4.equals((Object) jDOMAttributePointer11);
        org.apache.commons.jxpath.ri.EvalContext evalContext14 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray15 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext16 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext14, evalContextArray15);
        java.util.Locale locale17 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer18 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext14, locale17);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer19 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer21 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer19, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest23 = null;
        boolean boolean24 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer21, (Object) true, nodeTest23);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer25 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer27 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer25, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest29 = null;
        boolean boolean30 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer27, (Object) true, nodeTest29);
        int int31 = collectionPointer18.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer21, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer27);
        org.apache.commons.jxpath.ri.EvalContext evalContext32 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray33 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext34 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext32, evalContextArray33);
        java.util.Locale locale35 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer36 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext32, locale35);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer37 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer39 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer37, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest41 = null;
        boolean boolean42 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer39, (Object) true, nodeTest41);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer43 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer45 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer43, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest47 = null;
        boolean boolean48 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer45, (Object) true, nodeTest47);
        int int49 = collectionPointer36.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer39, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer45);
        int int50 = jDOMAttributePointer11.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer27, (org.apache.commons.jxpath.ri.model.NodePointer) collectionPointer36);
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest51 = null;
        boolean boolean52 = collectionPointer36.testNode(nodeTest51);
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(evalContextArray15);
        org.junit.Assert.assertArrayEquals(evalContextArray15, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + true + "'", boolean30 == true);
        org.junit.Assert.assertTrue("'" + int31 + "' != '" + 0 + "'", int31 == 0);
        org.junit.Assert.assertNotNull(evalContextArray33);
        org.junit.Assert.assertArrayEquals(evalContextArray33, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + true + "'", boolean42 == true);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + true + "'", boolean48 == true);
        org.junit.Assert.assertTrue("'" + int49 + "' != '" + 0 + "'", int49 == 0);
        org.junit.Assert.assertTrue("'" + int50 + "' != '" + 0 + "'", int50 == 0);
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + true + "'", boolean52 == true);
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test191");
        org.apache.commons.jxpath.ri.QName qName0 = null;
        org.apache.commons.beanutils.DynaBean dynaBean1 = null;
        java.util.Locale locale2 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer dynaBeanPointer3 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer(qName0, dynaBean1, locale2);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer4 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer4, "");
        jDOMNamespacePointer6.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute9 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer10 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer6, attribute9);
        boolean boolean11 = jDOMAttributePointer10.isLeaf();
        Object obj12 = jDOMAttributePointer10.getImmediateNode();
        java.lang.reflect.Constructor constructor13 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction14 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor13);
        Class<?> wildcardClass15 = constructorFunction14.getClass();
        JXPathBasicBeanInfo jXPathBasicBeanInfo17 = new JXPathBasicBeanInfo((Class) wildcardClass15, false);
        String str18 = jXPathBasicBeanInfo17.toString();
        org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer beanPropertyPointer19 = new org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer10, (JXPathBeanInfo) jXPathBasicBeanInfo17);
        int int20 = dynaBeanPointer3.compareTo((Object) beanPropertyPointer19);
        Object obj21 = beanPropertyPointer19.getBaseValue();
        org.apache.commons.jxpath.ri.compiler.Expression expression22 = null;
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray24 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction25 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray24);
        org.apache.commons.jxpath.ri.compiler.CoreOperationLessThanOrEqual coreOperationLessThanOrEqual26 = new org.apache.commons.jxpath.ri.compiler.CoreOperationLessThanOrEqual(expression22, (org.apache.commons.jxpath.ri.compiler.Expression) coreFunction25);
        // The following exception was thrown during execution in test generation
        try {
            int int27 = beanPropertyPointer19.compareTo((Object) expression22);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNull(obj12);
        org.junit.Assert.assertNotNull(wildcardClass15);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]" + "'", str18, "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]");
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertNull(obj21);
        org.junit.Assert.assertNotNull(expressionArray24);
        org.junit.Assert.assertArrayEquals(expressionArray24, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test192");
        int int0 = org.apache.commons.jxpath.ri.model.dom.DOMPointerFactory.DOM_POINTER_FACTORY_ORDER;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 100 + "'", int0 == 100);
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test193");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        int int3 = unionContext2.getCurrentPosition();
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest4 = null;
        org.apache.commons.jxpath.ri.axes.ParentContext parentContext5 = new org.apache.commons.jxpath.ri.axes.ParentContext((org.apache.commons.jxpath.ri.EvalContext) unionContext2, nodeTest4);
        parentContext5.reset();
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest8 = null;
        org.apache.commons.jxpath.ri.axes.DescendantContext descendantContext9 = new org.apache.commons.jxpath.ri.axes.DescendantContext((org.apache.commons.jxpath.ri.EvalContext) parentContext5, true, nodeTest8);
        descendantContext9.reset();
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test194");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest3 = null;
        org.apache.commons.jxpath.ri.axes.SelfContext selfContext4 = new org.apache.commons.jxpath.ri.axes.SelfContext((org.apache.commons.jxpath.ri.EvalContext) unionContext2, nodeTest3);
        selfContext4.reset();
        boolean boolean6 = selfContext4.nextNode();
        boolean boolean8 = selfContext4.setPosition(11);
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test195");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        Object obj5 = jDOMNamespacePointer2.getBaseValue();
        org.junit.Assert.assertNull(obj5);
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test196");
        org.apache.commons.jxpath.ri.NamespaceResolver namespaceResolver0 = new org.apache.commons.jxpath.ri.NamespaceResolver();
        namespaceResolver0.registerNamespace("UNKNOWN", "");
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test197");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        int int3 = unionContext2.getCurrentPosition();
        int int4 = unionContext2.getDocumentOrder();
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest5 = null;
        org.apache.commons.jxpath.ri.axes.AttributeContext attributeContext6 = new org.apache.commons.jxpath.ri.axes.AttributeContext((org.apache.commons.jxpath.ri.EvalContext) unionContext2, nodeTest5);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer7 = attributeContext6.getCurrentNodePointer();
        boolean boolean9 = attributeContext6.setPosition(72);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer10 = attributeContext6.getCurrentNodePointer();
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNull(nodePointer7);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNull(nodePointer10);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test198");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        org.apache.commons.jxpath.ri.model.dom.NamespacePointer namespacePointer4 = new org.apache.commons.jxpath.ri.model.dom.NamespacePointer(nodePointer0, "");
        boolean boolean5 = namespacePointer4.isCollection();
        int int6 = namespacePointer4.getLength();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 1 + "'", int6 == 1);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test199");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        int int3 = unionContext2.getCurrentPosition();
        int int4 = unionContext2.getDocumentOrder();
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest5 = null;
        org.apache.commons.jxpath.ri.axes.AttributeContext attributeContext6 = new org.apache.commons.jxpath.ri.axes.AttributeContext((org.apache.commons.jxpath.ri.EvalContext) unionContext2, nodeTest5);
        attributeContext6.reset();
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test200");
        int int0 = org.apache.commons.jxpath.ri.Compiler.FUNCTION_TRANSLATE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 17 + "'", int0 == 17);
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test201");
        org.apache.commons.jxpath.ri.parser.Token token0 = new org.apache.commons.jxpath.ri.parser.Token();
        token0.image = "UNKNOWN";
        org.apache.commons.jxpath.ri.parser.Token token3 = token0.next;
        org.junit.Assert.assertNull(token3);
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test202");
        JXPathInvalidSyntaxException jXPathInvalidSyntaxException1 = new JXPathInvalidSyntaxException("/");
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test203");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.QName qName2 = new org.apache.commons.jxpath.ri.QName("JDOM");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer4 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer4, "");
        jDOMNamespacePointer6.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute9 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer10 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer6, attribute9);
        org.apache.commons.beanutils.DynaBean dynaBean11 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer12 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer10, dynaBean11);
        org.apache.commons.jxpath.servlet.KeywordVariables keywordVariables13 = new org.apache.commons.jxpath.servlet.KeywordVariables("hi!", (Object) dynaBean11);
        java.lang.reflect.Constructor constructor14 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction15 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor14);
        Class<?> wildcardClass16 = constructorFunction15.getClass();
        JXPathBeanInfo jXPathBeanInfo17 = JXPathIntrospector.getBeanInfo((Class) wildcardClass16);
        org.apache.commons.jxpath.ri.model.beans.BeanPointer beanPointer18 = new org.apache.commons.jxpath.ri.model.beans.BeanPointer(nodePointer0, qName2, (Object) keywordVariables13, jXPathBeanInfo17);
        java.beans.PropertyDescriptor[] propertyDescriptorArray19 = jXPathBeanInfo17.getPropertyDescriptors();
        org.junit.Assert.assertNotNull(wildcardClass16);
        org.junit.Assert.assertNotNull(jXPathBeanInfo17);
        org.junit.Assert.assertNotNull(propertyDescriptorArray19);
        org.junit.Assert.assertArrayEquals(propertyDescriptorArray19, new java.beans.PropertyDescriptor[] {});
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test204");
        java.io.Reader reader0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.parser.XPathParser xPathParser1 = new org.apache.commons.jxpath.ri.parser.XPathParser(reader0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test205");
        JXPathException jXPathException0 = new JXPathException();
        JXPathContextFactoryConfigurationError jXPathContextFactoryConfigurationError1 = new JXPathContextFactoryConfigurationError((Exception) jXPathException0);
        JXPathException jXPathException2 = new JXPathException((Throwable) jXPathException0);
        String str3 = jXPathException0.toString();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "org.apache.commons.jxpath.JXPathException" + "'", str3, "org.apache.commons.jxpath.JXPathException");
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test206");
        org.apache.commons.jxpath.ri.QName qName0 = null;
        org.apache.commons.beanutils.DynaBean dynaBean1 = null;
        java.util.Locale locale2 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer dynaBeanPointer3 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer(qName0, dynaBean1, locale2);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer4 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer4, "");
        jDOMNamespacePointer6.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute9 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer10 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer6, attribute9);
        boolean boolean11 = jDOMAttributePointer10.isLeaf();
        Object obj12 = jDOMAttributePointer10.getImmediateNode();
        java.lang.reflect.Constructor constructor13 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction14 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor13);
        Class<?> wildcardClass15 = constructorFunction14.getClass();
        JXPathBasicBeanInfo jXPathBasicBeanInfo17 = new JXPathBasicBeanInfo((Class) wildcardClass15, false);
        String str18 = jXPathBasicBeanInfo17.toString();
        org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer beanPropertyPointer19 = new org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer10, (JXPathBeanInfo) jXPathBasicBeanInfo17);
        int int20 = dynaBeanPointer3.compareTo((Object) beanPropertyPointer19);
        int int21 = dynaBeanPointer3.getLength();
        boolean boolean23 = dynaBeanPointer3.equals((Object) (short) -1);
        Object obj24 = dynaBeanPointer3.getBaseValue();
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNull(obj12);
        org.junit.Assert.assertNotNull(wildcardClass15);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]" + "'", str18, "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]");
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 1 + "'", int21 == 1);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNull(obj24);
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test207");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        boolean boolean7 = jDOMAttributePointer6.isLeaf();
        Object obj8 = jDOMAttributePointer6.getImmediateNode();
        java.lang.reflect.Constructor constructor9 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction10 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor9);
        Class<?> wildcardClass11 = constructorFunction10.getClass();
        JXPathBasicBeanInfo jXPathBasicBeanInfo13 = new JXPathBasicBeanInfo((Class) wildcardClass11, false);
        String str14 = jXPathBasicBeanInfo13.toString();
        org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer beanPropertyPointer15 = new org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer6, (JXPathBeanInfo) jXPathBasicBeanInfo13);
        // The following exception was thrown during execution in test generation
        try {
            String str16 = jDOMAttributePointer6.getNamespaceURI();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNull(obj8);
        org.junit.Assert.assertNotNull(wildcardClass11);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]" + "'", str14, "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]");
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test208");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest4 = null;
        boolean boolean5 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, (Object) true, nodeTest4);
        JXPathException jXPathException6 = new JXPathException();
        JXPathContextFactoryConfigurationError jXPathContextFactoryConfigurationError7 = new JXPathContextFactoryConfigurationError((Exception) jXPathException6);
        JXPathException jXPathException8 = new JXPathException((Throwable) jXPathException6);
        jDOMNamespacePointer2.handle((Throwable) jXPathException8);
        org.apache.commons.jxpath.ri.QName qName10 = jDOMNamespacePointer2.getName();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(qName10);
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test209");
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray1 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction2 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray1);
        boolean boolean3 = coreFunction2.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.Expression expression4 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression5 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual6 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression4, expression5);
        org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan coreOperationLessThan7 = new org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction2, expression5);
        org.apache.commons.jxpath.ri.compiler.Expression expression8 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression9 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual10 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression8, expression9);
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray11 = coreOperationGreaterThanOrEqual10.getArguments();
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray13 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction14 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray13);
        boolean boolean15 = coreFunction14.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.Expression expression16 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression17 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual18 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression16, expression17);
        org.apache.commons.jxpath.ri.compiler.NameAttributeTest nameAttributeTest19 = new org.apache.commons.jxpath.ri.compiler.NameAttributeTest((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction14, (org.apache.commons.jxpath.ri.compiler.Expression) coreOperationGreaterThanOrEqual18);
        org.apache.commons.jxpath.ri.compiler.Expression expression20 = nameAttributeTest19.getNameTestExpression();
        org.apache.commons.jxpath.ri.compiler.CoreOperationLessThanOrEqual coreOperationLessThanOrEqual21 = new org.apache.commons.jxpath.ri.compiler.CoreOperationLessThanOrEqual((org.apache.commons.jxpath.ri.compiler.Expression) coreOperationGreaterThanOrEqual10, expression20);
        org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan coreOperationLessThan22 = new org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan(expression5, expression20);
        org.junit.Assert.assertNotNull(expressionArray1);
        org.junit.Assert.assertArrayEquals(expressionArray1, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(expressionArray11);
        org.junit.Assert.assertArrayEquals(expressionArray11, new org.apache.commons.jxpath.ri.compiler.Expression[] { null, null });
        org.junit.Assert.assertNotNull(expressionArray13);
        org.junit.Assert.assertArrayEquals(expressionArray13, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(expression20);
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test210");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        java.util.Locale locale3 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer4 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext0, locale3);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer7 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer5, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest9 = null;
        boolean boolean10 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer7, (Object) true, nodeTest9);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer11 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer13 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer11, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest15 = null;
        boolean boolean16 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer13, (Object) true, nodeTest15);
        int int17 = collectionPointer4.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer7, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer13);
        org.apache.commons.jxpath.ri.EvalContext evalContext18 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray19 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext20 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext18, evalContextArray19);
        java.util.Locale locale21 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer22 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext18, locale21);
        org.apache.commons.jxpath.ri.QName qName23 = null;
        org.apache.commons.jxpath.ri.model.beans.NullPointer nullPointer24 = new org.apache.commons.jxpath.ri.model.beans.NullPointer((org.apache.commons.jxpath.ri.model.NodePointer) collectionPointer22, qName23);
        Object obj25 = collectionPointer22.getNodeValue();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer26 = collectionPointer22.getValuePointer();
        org.apache.commons.jxpath.ri.EvalContext evalContext27 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray28 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext29 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext27, evalContextArray28);
        java.util.Locale locale30 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer31 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext27, locale30);
        org.apache.commons.jxpath.ri.QName qName32 = null;
        org.apache.commons.jxpath.ri.model.beans.NullPointer nullPointer33 = new org.apache.commons.jxpath.ri.model.beans.NullPointer((org.apache.commons.jxpath.ri.model.NodePointer) collectionPointer31, qName32);
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespaceIterator jDOMNamespaceIterator34 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespaceIterator((org.apache.commons.jxpath.ri.model.NodePointer) nullPointer33);
        int int35 = jDOMNamespacePointer13.compareChildNodePointers(nodePointer26, (org.apache.commons.jxpath.ri.model.NodePointer) nullPointer33);
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
        org.junit.Assert.assertNotNull(evalContextArray19);
        org.junit.Assert.assertArrayEquals(evalContextArray19, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertNull(obj25);
        org.junit.Assert.assertNotNull(nodePointer26);
        org.junit.Assert.assertNotNull(evalContextArray28);
        org.junit.Assert.assertArrayEquals(evalContextArray28, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + int35 + "' != '" + 0 + "'", int35 == 0);
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test211");
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray1 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction2 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray1);
        boolean boolean3 = coreFunction2.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.Expression expression4 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression5 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual6 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression4, expression5);
        org.apache.commons.jxpath.ri.compiler.NameAttributeTest nameAttributeTest7 = new org.apache.commons.jxpath.ri.compiler.NameAttributeTest((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction2, (org.apache.commons.jxpath.ri.compiler.Expression) coreOperationGreaterThanOrEqual6);
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray9 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction10 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray9);
        boolean boolean11 = coreFunction10.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.Expression expression12 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression13 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual14 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression12, expression13);
        org.apache.commons.jxpath.ri.compiler.NameAttributeTest nameAttributeTest15 = new org.apache.commons.jxpath.ri.compiler.NameAttributeTest((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction10, (org.apache.commons.jxpath.ri.compiler.Expression) coreOperationGreaterThanOrEqual14);
        org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan coreOperationLessThan16 = new org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan((org.apache.commons.jxpath.ri.compiler.Expression) nameAttributeTest7, (org.apache.commons.jxpath.ri.compiler.Expression) nameAttributeTest15);
        String str17 = coreOperationLessThan16.getSymbol();
        org.junit.Assert.assertNotNull(expressionArray1);
        org.junit.Assert.assertArrayEquals(expressionArray1, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(expressionArray9);
        org.junit.Assert.assertArrayEquals(expressionArray9, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "<" + "'", str17, "<");
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test212");
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray1 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction2 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray1);
        boolean boolean3 = coreFunction2.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.Expression expression4 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression5 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual6 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression4, expression5);
        org.apache.commons.jxpath.ri.compiler.NameAttributeTest nameAttributeTest7 = new org.apache.commons.jxpath.ri.compiler.NameAttributeTest((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction2, (org.apache.commons.jxpath.ri.compiler.Expression) coreOperationGreaterThanOrEqual6);
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray9 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction10 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray9);
        boolean boolean11 = coreFunction10.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.Expression expression12 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression13 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual14 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression12, expression13);
        org.apache.commons.jxpath.ri.compiler.NameAttributeTest nameAttributeTest15 = new org.apache.commons.jxpath.ri.compiler.NameAttributeTest((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction10, (org.apache.commons.jxpath.ri.compiler.Expression) coreOperationGreaterThanOrEqual14);
        org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan coreOperationLessThan16 = new org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan((org.apache.commons.jxpath.ri.compiler.Expression) nameAttributeTest7, (org.apache.commons.jxpath.ri.compiler.Expression) nameAttributeTest15);
        org.apache.commons.jxpath.ri.compiler.Constant constant18 = new org.apache.commons.jxpath.ri.compiler.Constant((Number) 26);
        org.apache.commons.jxpath.ri.compiler.CoreOperationLessThanOrEqual coreOperationLessThanOrEqual19 = new org.apache.commons.jxpath.ri.compiler.CoreOperationLessThanOrEqual((org.apache.commons.jxpath.ri.compiler.Expression) nameAttributeTest7, (org.apache.commons.jxpath.ri.compiler.Expression) constant18);
        String str20 = coreOperationLessThanOrEqual19.getSymbol();
        org.junit.Assert.assertNotNull(expressionArray1);
        org.junit.Assert.assertArrayEquals(expressionArray1, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(expressionArray9);
        org.junit.Assert.assertArrayEquals(expressionArray9, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "<=" + "'", str20, "<=");
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test213");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        java.util.Locale locale3 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer4 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext0, locale3);
        org.apache.commons.jxpath.ri.QName qName5 = null;
        org.apache.commons.jxpath.ri.EvalContext evalContext6 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray7 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext8 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext6, evalContextArray7);
        java.util.Locale locale9 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer10 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext6, locale9);
        Object obj11 = collectionPointer10.getImmediateNode();
        org.apache.commons.jxpath.servlet.ServletContextHandler servletContextHandler12 = new org.apache.commons.jxpath.servlet.ServletContextHandler();
        java.util.Locale locale13 = null;
        org.apache.commons.jxpath.ri.model.dynamic.DynamicPointer dynamicPointer14 = new org.apache.commons.jxpath.ri.model.dynamic.DynamicPointer(qName5, (Object) collectionPointer10, (DynamicPropertyHandler) servletContextHandler12, locale13);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer15 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer17 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer15, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest19 = null;
        boolean boolean20 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer17, (Object) true, nodeTest19);
        String str21 = jDOMNamespacePointer17.asPath();
        int int22 = collectionPointer4.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) collectionPointer10, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer17);
        ExceptionHandler exceptionHandler23 = null;
        jDOMNamespacePointer17.setExceptionHandler(exceptionHandler23);
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertNotNull(evalContextArray7);
        org.junit.Assert.assertArrayEquals(evalContextArray7, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertNull(obj11);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "namespace::" + "'", str21, "namespace::");
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 0 + "'", int22 == 0);
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test214");
        org.apache.commons.jxpath.ri.QName qName0 = null;
        org.apache.commons.jxpath.ri.EvalContext evalContext1 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray2 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext3 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext1, evalContextArray2);
        java.util.Locale locale4 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer5 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext1, locale4);
        Object obj6 = collectionPointer5.getImmediateNode();
        org.apache.commons.jxpath.servlet.ServletContextHandler servletContextHandler7 = new org.apache.commons.jxpath.servlet.ServletContextHandler();
        java.util.Locale locale8 = null;
        org.apache.commons.jxpath.ri.model.dynamic.DynamicPointer dynamicPointer9 = new org.apache.commons.jxpath.ri.model.dynamic.DynamicPointer(qName0, (Object) collectionPointer5, (DynamicPropertyHandler) servletContextHandler7, locale8);
        boolean boolean10 = dynamicPointer9.isDynamicPropertyDeclarationSupported();
        org.apache.commons.jxpath.ri.model.beans.PropertyPointer propertyPointer11 = dynamicPointer9.getPropertyPointer();
        JXPathContext jXPathContext12 = null;
        // The following exception was thrown during execution in test generation
        try {
            Pointer pointer15 = propertyPointer11.getPointerByKey(jXPathContext12, "", "DOM");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(evalContextArray2);
        org.junit.Assert.assertArrayEquals(evalContextArray2, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertNull(obj6);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertNotNull(propertyPointer11);
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test215");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        boolean boolean7 = jDOMAttributePointer6.isLeaf();
        boolean boolean8 = jDOMAttributePointer6.isLeaf();
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test216");
        org.apache.commons.jxpath.ri.QName qName0 = null;
        org.apache.commons.beanutils.DynaBean dynaBean1 = null;
        java.util.Locale locale2 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer dynaBeanPointer3 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer(qName0, dynaBean1, locale2);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer4 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer4, "");
        jDOMNamespacePointer6.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute9 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer10 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer6, attribute9);
        boolean boolean11 = jDOMAttributePointer10.isLeaf();
        Object obj12 = jDOMAttributePointer10.getImmediateNode();
        java.lang.reflect.Constructor constructor13 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction14 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor13);
        Class<?> wildcardClass15 = constructorFunction14.getClass();
        JXPathBasicBeanInfo jXPathBasicBeanInfo17 = new JXPathBasicBeanInfo((Class) wildcardClass15, false);
        String str18 = jXPathBasicBeanInfo17.toString();
        org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer beanPropertyPointer19 = new org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer10, (JXPathBeanInfo) jXPathBasicBeanInfo17);
        int int20 = dynaBeanPointer3.compareTo((Object) beanPropertyPointer19);
        boolean boolean21 = dynaBeanPointer3.isDynamicPropertyDeclarationSupported();
        org.apache.commons.jxpath.ri.model.beans.PropertyPointer propertyPointer22 = dynaBeanPointer3.getPropertyPointer();
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNull(obj12);
        org.junit.Assert.assertNotNull(wildcardClass15);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]" + "'", str18, "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]");
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(propertyPointer22);
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test217");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        java.util.Locale locale3 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer4 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext0, locale3);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer7 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer5, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest9 = null;
        boolean boolean10 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer7, (Object) true, nodeTest9);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer11 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer13 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer11, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest15 = null;
        boolean boolean16 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer13, (Object) true, nodeTest15);
        int int17 = collectionPointer4.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer7, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer13);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer18 = collectionPointer4.getValuePointer();
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
        org.junit.Assert.assertNotNull(nodePointer18);
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test218");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        java.util.Locale locale3 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer4 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext0, locale3);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer7 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer5, "");
        jDOMNamespacePointer7.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute10 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer11 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer7, attribute10);
        boolean boolean12 = jDOMAttributePointer11.isLeaf();
        boolean boolean13 = collectionPointer4.equals((Object) jDOMAttributePointer11);
        org.apache.commons.jxpath.ri.EvalContext evalContext14 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray15 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext16 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext14, evalContextArray15);
        java.util.Locale locale17 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer18 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext14, locale17);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer19 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer21 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer19, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest23 = null;
        boolean boolean24 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer21, (Object) true, nodeTest23);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer25 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer27 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer25, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest29 = null;
        boolean boolean30 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer27, (Object) true, nodeTest29);
        int int31 = collectionPointer18.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer21, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer27);
        org.apache.commons.jxpath.ri.EvalContext evalContext32 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray33 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext34 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext32, evalContextArray33);
        java.util.Locale locale35 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer36 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext32, locale35);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer37 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer39 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer37, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest41 = null;
        boolean boolean42 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer39, (Object) true, nodeTest41);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer43 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer45 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer43, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest47 = null;
        boolean boolean48 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer45, (Object) true, nodeTest47);
        int int49 = collectionPointer36.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer39, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer45);
        int int50 = jDOMAttributePointer11.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer27, (org.apache.commons.jxpath.ri.model.NodePointer) collectionPointer36);
        JXPathContext jXPathContext51 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMPointerFactory jDOMPointerFactory52 = new org.apache.commons.jxpath.ri.model.jdom.JDOMPointerFactory();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer53 = null;
        org.apache.commons.jxpath.ri.QName qName55 = new org.apache.commons.jxpath.ri.QName("JDOM");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer57 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer59 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer57, "");
        jDOMNamespacePointer59.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute62 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer63 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer59, attribute62);
        org.apache.commons.beanutils.DynaBean dynaBean64 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer65 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer63, dynaBean64);
        org.apache.commons.jxpath.servlet.KeywordVariables keywordVariables66 = new org.apache.commons.jxpath.servlet.KeywordVariables("hi!", (Object) dynaBean64);
        java.lang.reflect.Constructor constructor67 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction68 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor67);
        Class<?> wildcardClass69 = constructorFunction68.getClass();
        JXPathBeanInfo jXPathBeanInfo70 = JXPathIntrospector.getBeanInfo((Class) wildcardClass69);
        org.apache.commons.jxpath.ri.model.beans.BeanPointer beanPointer71 = new org.apache.commons.jxpath.ri.model.beans.BeanPointer(nodePointer53, qName55, (Object) keywordVariables66, jXPathBeanInfo70);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer72 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer74 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer72, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest76 = null;
        boolean boolean77 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer74, (Object) true, nodeTest76);
        java.util.Locale locale78 = null;
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer79 = jDOMPointerFactory52.createNodePointer(qName55, (Object) nodeTest76, locale78);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer81 = collectionPointer36.createChild(jXPathContext51, qName55, 67);
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(evalContextArray15);
        org.junit.Assert.assertArrayEquals(evalContextArray15, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + true + "'", boolean30 == true);
        org.junit.Assert.assertTrue("'" + int31 + "' != '" + 0 + "'", int31 == 0);
        org.junit.Assert.assertNotNull(evalContextArray33);
        org.junit.Assert.assertArrayEquals(evalContextArray33, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + true + "'", boolean42 == true);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + true + "'", boolean48 == true);
        org.junit.Assert.assertTrue("'" + int49 + "' != '" + 0 + "'", int49 == 0);
        org.junit.Assert.assertTrue("'" + int50 + "' != '" + 0 + "'", int50 == 0);
        org.junit.Assert.assertNotNull(wildcardClass69);
        org.junit.Assert.assertNotNull(jXPathBeanInfo70);
        org.junit.Assert.assertTrue("'" + boolean77 + "' != '" + true + "'", boolean77 == true);
        org.junit.Assert.assertNull(nodePointer79);
        org.junit.Assert.assertNotNull(nodePointer81);
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test219");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        org.apache.commons.beanutils.DynaBean dynaBean7 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer8 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer6, dynaBean7);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer9 = jDOMAttributePointer6.getParent();
        org.jdom.Attribute attribute10 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer11 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer(nodePointer9, attribute10);
        String str12 = jDOMAttributePointer11.asPath();
        org.junit.Assert.assertNotNull(nodePointer9);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "namespace::/@null" + "'", str12, "namespace::/@null");
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test220");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        java.util.Locale locale3 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer4 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext0, locale3);
        org.apache.commons.jxpath.ri.QName qName5 = null;
        org.apache.commons.jxpath.ri.model.beans.NullPointer nullPointer6 = new org.apache.commons.jxpath.ri.model.beans.NullPointer((org.apache.commons.jxpath.ri.model.NodePointer) collectionPointer4, qName5);
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespaceIterator jDOMNamespaceIterator7 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespaceIterator((org.apache.commons.jxpath.ri.model.NodePointer) nullPointer6);
        int int8 = jDOMNamespaceIterator7.getPosition();
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test221");
        org.w3c.dom.Node node0 = null;
        // The following exception was thrown during execution in test generation
        try {
            String str1 = org.apache.commons.jxpath.ri.model.dom.DOMNodePointer.getLocalName(node0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test222");
        org.apache.commons.jxpath.ri.parser.Token token0 = new org.apache.commons.jxpath.ri.parser.Token();
        org.apache.commons.jxpath.ri.parser.Token token1 = new org.apache.commons.jxpath.ri.parser.Token();
        int int2 = token1.endLine;
        token0.next = token1;
        String str4 = token0.image;
        org.apache.commons.jxpath.ri.parser.Token token5 = token0.specialToken;
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(token5);
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test223");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.FUNCTION_LAST;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 48 + "'", int0 == 48);
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test224");
        java.util.Locale locale0 = null;
        org.apache.commons.jxpath.ri.model.beans.NullPointer nullPointer2 = new org.apache.commons.jxpath.ri.model.beans.NullPointer(locale0, "");
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test225");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        java.util.Locale locale3 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer4 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext0, locale3);
        org.apache.commons.jxpath.ri.QName qName5 = null;
        org.apache.commons.jxpath.ri.EvalContext evalContext6 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray7 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext8 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext6, evalContextArray7);
        java.util.Locale locale9 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer10 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext6, locale9);
        Object obj11 = collectionPointer10.getImmediateNode();
        org.apache.commons.jxpath.servlet.ServletContextHandler servletContextHandler12 = new org.apache.commons.jxpath.servlet.ServletContextHandler();
        java.util.Locale locale13 = null;
        org.apache.commons.jxpath.ri.model.dynamic.DynamicPointer dynamicPointer14 = new org.apache.commons.jxpath.ri.model.dynamic.DynamicPointer(qName5, (Object) collectionPointer10, (DynamicPropertyHandler) servletContextHandler12, locale13);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer15 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer17 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer15, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest19 = null;
        boolean boolean20 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer17, (Object) true, nodeTest19);
        String str21 = jDOMNamespacePointer17.asPath();
        int int22 = collectionPointer4.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) collectionPointer10, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer17);
        org.apache.commons.jxpath.ri.QName qName23 = null;
        org.apache.commons.beanutils.DynaBean dynaBean24 = null;
        java.util.Locale locale25 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer dynaBeanPointer26 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer(qName23, dynaBean24, locale25);
        // The following exception was thrown during execution in test generation
        try {
            jDOMNamespacePointer17.setValue((Object) dynaBeanPointer26);
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: Cannot modify a namespace");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertNotNull(evalContextArray7);
        org.junit.Assert.assertArrayEquals(evalContextArray7, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertNull(obj11);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "namespace::" + "'", str21, "namespace::");
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 0 + "'", int22 == 0);
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test226");
        org.apache.commons.jxpath.servlet.ServletContextHandler servletContextHandler0 = new org.apache.commons.jxpath.servlet.ServletContextHandler();
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray2 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction3 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray2);
        boolean boolean4 = coreFunction3.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.Expression expression5 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression6 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual7 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression5, expression6);
        org.apache.commons.jxpath.ri.compiler.NameAttributeTest nameAttributeTest8 = new org.apache.commons.jxpath.ri.compiler.NameAttributeTest((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction3, (org.apache.commons.jxpath.ri.compiler.Expression) coreOperationGreaterThanOrEqual7);
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray10 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction11 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray10);
        boolean boolean12 = coreFunction11.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.Expression expression13 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression14 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual15 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression13, expression14);
        org.apache.commons.jxpath.ri.compiler.NameAttributeTest nameAttributeTest16 = new org.apache.commons.jxpath.ri.compiler.NameAttributeTest((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction11, (org.apache.commons.jxpath.ri.compiler.Expression) coreOperationGreaterThanOrEqual15);
        org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan coreOperationLessThan17 = new org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan((org.apache.commons.jxpath.ri.compiler.Expression) nameAttributeTest8, (org.apache.commons.jxpath.ri.compiler.Expression) nameAttributeTest16);
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray18 = nameAttributeTest8.getArguments();
        org.apache.commons.jxpath.ri.compiler.CoreOperationAnd coreOperationAnd19 = new org.apache.commons.jxpath.ri.compiler.CoreOperationAnd(expressionArray18);
        // The following exception was thrown during execution in test generation
        try {
            String[] strArray20 = servletContextHandler0.getPropertyNames((Object) expressionArray18);
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: [Lorg.apache.commons.jxpath.ri.compiler.Expression; cannot be cast to javax.servlet.ServletContext");
        } catch (ClassCastException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(expressionArray2);
        org.junit.Assert.assertArrayEquals(expressionArray2, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(expressionArray10);
        org.junit.Assert.assertArrayEquals(expressionArray10, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(expressionArray18);
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test227");
        org.apache.commons.jxpath.ri.NamespaceResolver namespaceResolver0 = new org.apache.commons.jxpath.ri.NamespaceResolver();
        String str2 = namespaceResolver0.getPrefix("UNKNOWN");
        org.junit.Assert.assertNull(str2);
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test228");
        JXPathNotFoundException jXPathNotFoundException1 = new JXPathNotFoundException("DOM");
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test229");
        org.apache.commons.jxpath.ri.QName qName0 = null;
        org.apache.commons.jxpath.ri.compiler.VariableReference variableReference1 = new org.apache.commons.jxpath.ri.compiler.VariableReference(qName0);
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray3 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction4 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray3);
        boolean boolean5 = coreFunction4.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.Expression expression6 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression7 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual8 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression6, expression7);
        org.apache.commons.jxpath.ri.compiler.NameAttributeTest nameAttributeTest9 = new org.apache.commons.jxpath.ri.compiler.NameAttributeTest((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction4, (org.apache.commons.jxpath.ri.compiler.Expression) coreOperationGreaterThanOrEqual8);
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray11 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction12 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray11);
        boolean boolean13 = coreFunction12.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.Expression expression14 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression15 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual16 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression14, expression15);
        org.apache.commons.jxpath.ri.compiler.NameAttributeTest nameAttributeTest17 = new org.apache.commons.jxpath.ri.compiler.NameAttributeTest((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction12, (org.apache.commons.jxpath.ri.compiler.Expression) coreOperationGreaterThanOrEqual16);
        org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan coreOperationLessThan18 = new org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan((org.apache.commons.jxpath.ri.compiler.Expression) nameAttributeTest9, (org.apache.commons.jxpath.ri.compiler.Expression) nameAttributeTest17);
        org.apache.commons.jxpath.ri.compiler.Constant constant20 = new org.apache.commons.jxpath.ri.compiler.Constant((Number) 26);
        org.apache.commons.jxpath.ri.compiler.CoreOperationLessThanOrEqual coreOperationLessThanOrEqual21 = new org.apache.commons.jxpath.ri.compiler.CoreOperationLessThanOrEqual((org.apache.commons.jxpath.ri.compiler.Expression) nameAttributeTest9, (org.apache.commons.jxpath.ri.compiler.Expression) constant20);
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray22 = new org.apache.commons.jxpath.ri.compiler.Expression[] { variableReference1, coreOperationLessThanOrEqual21 };
        org.apache.commons.jxpath.ri.compiler.CoreOperationUnion coreOperationUnion23 = new org.apache.commons.jxpath.ri.compiler.CoreOperationUnion(expressionArray22);
        org.junit.Assert.assertNotNull(expressionArray3);
        org.junit.Assert.assertArrayEquals(expressionArray3, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(expressionArray11);
        org.junit.Assert.assertArrayEquals(expressionArray11, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(expressionArray22);
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test230");
        java.io.Reader reader0 = null;
        org.apache.commons.jxpath.ri.parser.SimpleCharStream simpleCharStream1 = new org.apache.commons.jxpath.ri.parser.SimpleCharStream(reader0);
        simpleCharStream1.backup((int) (byte) 10);
        simpleCharStream1.Done();
        // The following exception was thrown during execution in test generation
        try {
            char[] charArray6 = simpleCharStream1.GetSuffix((int) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test231");
        java.io.Reader reader0 = null;
        org.apache.commons.jxpath.ri.parser.SimpleCharStream simpleCharStream1 = new org.apache.commons.jxpath.ri.parser.SimpleCharStream(reader0);
        simpleCharStream1.backup((int) (byte) 10);
        simpleCharStream1.Done();
        // The following exception was thrown during execution in test generation
        try {
            char char5 = simpleCharStream1.readChar();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test232");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        int int3 = unionContext2.getCurrentPosition();
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest4 = null;
        org.apache.commons.jxpath.ri.axes.NamespaceContext namespaceContext5 = new org.apache.commons.jxpath.ri.axes.NamespaceContext((org.apache.commons.jxpath.ri.EvalContext) unionContext2, nodeTest4);
        boolean boolean6 = unionContext2.hasNext();
        boolean boolean8 = unionContext2.setPosition(75);
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test233");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest4 = null;
        boolean boolean5 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, (Object) true, nodeTest4);
        org.apache.commons.jxpath.ri.QName qName6 = null;
        org.apache.commons.jxpath.ri.model.beans.NullPointer nullPointer7 = new org.apache.commons.jxpath.ri.model.beans.NullPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, qName6);
        // The following exception was thrown during execution in test generation
        try {
            Object obj8 = jDOMNamespacePointer2.getRootNode();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test234");
        ClassLoader classLoader0 = null;
        // The following exception was thrown during execution in test generation
        try {
            Class class3 = org.apache.commons.jxpath.util.ClassLoaderUtil.getClass(classLoader0, "/", false);
            org.junit.Assert.fail("Expected exception of type java.lang.ClassNotFoundException; message: /");
        } catch (ClassNotFoundException e) {
            // Expected exception.
        }
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test235");
        org.apache.commons.jxpath.ri.QName qName0 = null;
        org.apache.commons.beanutils.DynaBean dynaBean1 = null;
        java.util.Locale locale2 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer dynaBeanPointer3 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer(qName0, dynaBean1, locale2);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer4 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer4, "");
        jDOMNamespacePointer6.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute9 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer10 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer6, attribute9);
        boolean boolean11 = jDOMAttributePointer10.isLeaf();
        Object obj12 = jDOMAttributePointer10.getImmediateNode();
        java.lang.reflect.Constructor constructor13 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction14 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor13);
        Class<?> wildcardClass15 = constructorFunction14.getClass();
        JXPathBasicBeanInfo jXPathBasicBeanInfo17 = new JXPathBasicBeanInfo((Class) wildcardClass15, false);
        String str18 = jXPathBasicBeanInfo17.toString();
        org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer beanPropertyPointer19 = new org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer10, (JXPathBeanInfo) jXPathBasicBeanInfo17);
        int int20 = dynaBeanPointer3.compareTo((Object) beanPropertyPointer19);
        int int21 = dynaBeanPointer3.getLength();
        JXPathContext jXPathContext22 = null;
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer23 = null;
        org.apache.commons.jxpath.ri.QName qName25 = new org.apache.commons.jxpath.ri.QName("JDOM");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer27 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer29 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer27, "");
        jDOMNamespacePointer29.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute32 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer33 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer29, attribute32);
        org.apache.commons.beanutils.DynaBean dynaBean34 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer35 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer33, dynaBean34);
        org.apache.commons.jxpath.servlet.KeywordVariables keywordVariables36 = new org.apache.commons.jxpath.servlet.KeywordVariables("hi!", (Object) dynaBean34);
        java.lang.reflect.Constructor constructor37 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction38 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor37);
        Class<?> wildcardClass39 = constructorFunction38.getClass();
        JXPathBeanInfo jXPathBeanInfo40 = JXPathIntrospector.getBeanInfo((Class) wildcardClass39);
        org.apache.commons.jxpath.ri.model.beans.BeanPointer beanPointer41 = new org.apache.commons.jxpath.ri.model.beans.BeanPointer(nodePointer23, qName25, (Object) keywordVariables36, jXPathBeanInfo40);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.model.NodePointer nodePointer44 = dynaBeanPointer3.createChild(jXPathContext22, qName25, (-2147483648), (Object) 27);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.jxpath.JXPathException; message: Cannot create an object for path //JDOM[-2147483647], operation is not allowed for this type of node");
        } catch (JXPathException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNull(obj12);
        org.junit.Assert.assertNotNull(wildcardClass15);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]" + "'", str18, "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]");
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 1 + "'", int21 == 1);
        org.junit.Assert.assertNotNull(wildcardClass39);
        org.junit.Assert.assertNotNull(jXPathBeanInfo40);
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test236");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.FUNCTION_KEY;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 52 + "'", int0 == 52);
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test237");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        org.apache.commons.beanutils.DynaBean dynaBean7 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer8 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer6, dynaBean7);
        boolean boolean9 = dynaBeanPropertyPointer8.isRoot();
        // The following exception was thrown during execution in test generation
        try {
            int int10 = dynaBeanPropertyPointer8.getPropertyCount();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test238");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        jDOMNamespacePointer2.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, attribute5);
        org.apache.commons.beanutils.DynaBean dynaBean7 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer8 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer6, dynaBean7);
        JXPathContext jXPathContext9 = null;
        org.apache.commons.jxpath.ri.EvalContext evalContext11 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray12 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext13 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext11, evalContextArray12);
        java.util.Locale locale14 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer15 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext11, locale14);
        // The following exception was thrown during execution in test generation
        try {
            NodeSet nodeSet16 = dynaBeanPropertyPointer8.getNodeSetByKey(jXPathContext9, "", (Object) locale14);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(evalContextArray12);
        org.junit.Assert.assertArrayEquals(evalContextArray12, new org.apache.commons.jxpath.ri.EvalContext[] {});
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test239");
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray1 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction2 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray1);
        org.apache.commons.jxpath.ri.compiler.CoreOperationAdd coreOperationAdd3 = new org.apache.commons.jxpath.ri.compiler.CoreOperationAdd(expressionArray1);
        org.apache.commons.jxpath.ri.compiler.CoreOperationOr coreOperationOr4 = new org.apache.commons.jxpath.ri.compiler.CoreOperationOr(expressionArray1);
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray6 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction7 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray6);
        boolean boolean8 = coreFunction7.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.Expression expression9 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression10 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual11 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression9, expression10);
        org.apache.commons.jxpath.ri.compiler.NameAttributeTest nameAttributeTest12 = new org.apache.commons.jxpath.ri.compiler.NameAttributeTest((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction7, (org.apache.commons.jxpath.ri.compiler.Expression) coreOperationGreaterThanOrEqual11);
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThan coreOperationGreaterThan13 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThan((org.apache.commons.jxpath.ri.compiler.Expression) coreOperationOr4, (org.apache.commons.jxpath.ri.compiler.Expression) nameAttributeTest12);
        org.apache.commons.jxpath.ri.compiler.Expression expression14 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression15 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual16 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression14, expression15);
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual17 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual((org.apache.commons.jxpath.ri.compiler.Expression) nameAttributeTest12, expression15);
        org.junit.Assert.assertNotNull(expressionArray1);
        org.junit.Assert.assertArrayEquals(expressionArray1, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertNotNull(expressionArray6);
        org.junit.Assert.assertArrayEquals(expressionArray6, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test240");
        org.apache.commons.jxpath.ri.model.jdom.JDOMPointerFactory jDOMPointerFactory0 = new org.apache.commons.jxpath.ri.model.jdom.JDOMPointerFactory();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer1 = null;
        org.apache.commons.jxpath.ri.QName qName3 = new org.apache.commons.jxpath.ri.QName("JDOM");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer7 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer5, "");
        jDOMNamespacePointer7.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute10 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer11 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer7, attribute10);
        org.apache.commons.beanutils.DynaBean dynaBean12 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer13 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer11, dynaBean12);
        org.apache.commons.jxpath.servlet.KeywordVariables keywordVariables14 = new org.apache.commons.jxpath.servlet.KeywordVariables("hi!", (Object) dynaBean12);
        java.lang.reflect.Constructor constructor15 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction16 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor15);
        Class<?> wildcardClass17 = constructorFunction16.getClass();
        JXPathBeanInfo jXPathBeanInfo18 = JXPathIntrospector.getBeanInfo((Class) wildcardClass17);
        org.apache.commons.jxpath.ri.model.beans.BeanPointer beanPointer19 = new org.apache.commons.jxpath.ri.model.beans.BeanPointer(nodePointer1, qName3, (Object) keywordVariables14, jXPathBeanInfo18);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer20 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer22 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer20, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest24 = null;
        boolean boolean25 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer22, (Object) true, nodeTest24);
        java.util.Locale locale26 = null;
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer27 = jDOMPointerFactory0.createNodePointer(qName3, (Object) nodeTest24, locale26);
        int int28 = jDOMPointerFactory0.getOrder();
        org.junit.Assert.assertNotNull(wildcardClass17);
        org.junit.Assert.assertNotNull(jXPathBeanInfo18);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + true + "'", boolean25 == true);
        org.junit.Assert.assertNull(nodePointer27);
        org.junit.Assert.assertTrue("'" + int28 + "' != '" + 110 + "'", int28 == 110);
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test241");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        int int3 = unionContext2.getCurrentPosition();
        int int4 = unionContext2.getDocumentOrder();
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest5 = null;
        org.apache.commons.jxpath.ri.axes.AttributeContext attributeContext6 = new org.apache.commons.jxpath.ri.axes.AttributeContext((org.apache.commons.jxpath.ri.EvalContext) unionContext2, nodeTest5);
        boolean boolean8 = attributeContext6.setPosition(29);
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test242");
        org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer propertyOwnerPointer0 = null;
        org.apache.commons.jxpath.ri.EvalContext evalContext3 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray4 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext5 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext3, evalContextArray4);
        java.util.Locale locale6 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer7 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext3, locale6);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer8 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer10 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer8, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest12 = null;
        boolean boolean13 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer10, (Object) true, nodeTest12);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer14 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer16 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer14, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest18 = null;
        boolean boolean19 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer16, (Object) true, nodeTest18);
        int int20 = collectionPointer7.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer10, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer16);
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest21 = null;
        boolean boolean22 = collectionPointer7.testNode(nodeTest21);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.model.beans.PropertyIterator propertyIterator23 = new org.apache.commons.jxpath.ri.model.beans.PropertyIterator(propertyOwnerPointer0, "http://www.w3.org/XML/1998/namespace", false, (org.apache.commons.jxpath.ri.model.NodePointer) collectionPointer7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(evalContextArray4);
        org.junit.Assert.assertArrayEquals(evalContextArray4, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test243");
        org.apache.commons.jxpath.ri.compiler.TreeCompiler treeCompiler0 = new org.apache.commons.jxpath.ri.compiler.TreeCompiler();
        java.lang.reflect.Constructor constructor1 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction2 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor1);
        Class<?> wildcardClass3 = constructorFunction2.getClass();
        JXPathBeanInfo jXPathBeanInfo4 = JXPathIntrospector.getBeanInfo((Class) wildcardClass3);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer6 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer8 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer6, "");
        org.apache.commons.jxpath.ri.model.dom.NamespacePointer namespacePointer10 = new org.apache.commons.jxpath.ri.model.dom.NamespacePointer(nodePointer6, "");
        String str11 = namespacePointer10.asPath();
        org.apache.commons.jxpath.ri.EvalContext evalContext12 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray13 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext14 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext12, evalContextArray13);
        java.util.Locale locale15 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer16 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext12, locale15);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer17 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer19 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer17, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest21 = null;
        boolean boolean22 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer19, (Object) true, nodeTest21);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer23 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer25 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer23, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest27 = null;
        boolean boolean28 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer25, (Object) true, nodeTest27);
        int int29 = collectionPointer16.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer19, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer25);
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest30 = null;
        boolean boolean31 = collectionPointer16.testNode(nodeTest30);
        JXPathFunctionNotFoundException jXPathFunctionNotFoundException33 = new JXPathFunctionNotFoundException("namespace::");
        Object[] objArray34 = new Object[] { namespacePointer10, nodeTest30, "namespace::" };
        java.lang.reflect.Method method35 = org.apache.commons.jxpath.util.MethodLookupUtils.lookupStaticMethod((Class) wildcardClass3, "/", objArray34);
        Object[] objArray36 = new Object[] { objArray34 };
        // The following exception was thrown during execution in test generation
        try {
            Object obj37 = treeCompiler0.or(objArray34);
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: org.apache.commons.jxpath.ri.model.dom.NamespacePointer cannot be cast to org.apache.commons.jxpath.ri.compiler.Expression");
        } catch (ClassCastException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardClass3);
        org.junit.Assert.assertNotNull(jXPathBeanInfo4);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "namespace::" + "'", str11, "namespace::");
        org.junit.Assert.assertNotNull(evalContextArray13);
        org.junit.Assert.assertArrayEquals(evalContextArray13, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + true + "'", boolean28 == true);
        org.junit.Assert.assertTrue("'" + int29 + "' != '" + 0 + "'", int29 == 0);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + true + "'", boolean31 == true);
        org.junit.Assert.assertNotNull(objArray34);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray34), "[namespace::, null, namespace::]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray34), "[namespace::, null, namespace::]");
        org.junit.Assert.assertNull(method35);
        org.junit.Assert.assertNotNull(objArray36);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray36), "[[namespace::, null, namespace::]]");
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test244");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        java.util.Locale locale3 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer4 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext0, locale3);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer7 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer5, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest9 = null;
        boolean boolean10 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer7, (Object) true, nodeTest9);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer11 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer13 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer11, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest15 = null;
        boolean boolean16 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer13, (Object) true, nodeTest15);
        int int17 = collectionPointer4.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer7, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer13);
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest18 = null;
        boolean boolean19 = collectionPointer4.testNode(nodeTest18);
        java.util.Locale locale20 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer jDOMNodePointer21 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer((Object) collectionPointer4, locale20);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean23 = jDOMNodePointer21.isLanguage("<<unknown namespace>>");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test245");
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray0 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreOperationAdd coreOperationAdd1 = new org.apache.commons.jxpath.ri.compiler.CoreOperationAdd(expressionArray0);
        org.junit.Assert.assertNotNull(expressionArray0);
        org.junit.Assert.assertArrayEquals(expressionArray0, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
    }

    @Test
    public void test246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test246");
        org.apache.commons.jxpath.ri.QName qName0 = null;
        org.apache.commons.beanutils.DynaBean dynaBean1 = null;
        java.util.Locale locale2 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer dynaBeanPointer3 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer(qName0, dynaBean1, locale2);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer4 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer6 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer4, "");
        jDOMNamespacePointer6.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute9 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer10 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer6, attribute9);
        boolean boolean11 = jDOMAttributePointer10.isLeaf();
        Object obj12 = jDOMAttributePointer10.getImmediateNode();
        java.lang.reflect.Constructor constructor13 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction14 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor13);
        Class<?> wildcardClass15 = constructorFunction14.getClass();
        JXPathBasicBeanInfo jXPathBasicBeanInfo17 = new JXPathBasicBeanInfo((Class) wildcardClass15, false);
        String str18 = jXPathBasicBeanInfo17.toString();
        org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer beanPropertyPointer19 = new org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer10, (JXPathBeanInfo) jXPathBasicBeanInfo17);
        int int20 = dynaBeanPointer3.compareTo((Object) beanPropertyPointer19);
        Object obj21 = beanPropertyPointer19.getBaseValue();
        org.apache.commons.jxpath.ri.QName qName22 = beanPropertyPointer19.getName();
        String[] strArray23 = beanPropertyPointer19.getPropertyNames();
        int int24 = beanPropertyPointer19.getPropertyCount();
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNull(obj12);
        org.junit.Assert.assertNotNull(wildcardClass15);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]" + "'", str18, "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]");
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertNull(obj21);
        org.junit.Assert.assertNotNull(qName22);
        org.junit.Assert.assertNotNull(strArray23);
        org.junit.Assert.assertArrayEquals(strArray23, new String[] {});
        org.junit.Assert.assertTrue("'" + int24 + "' != '" + 0 + "'", int24 == 0);
    }

    @Test
    public void test247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test247");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        java.util.Locale locale3 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer4 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext0, locale3);
        org.apache.commons.jxpath.ri.QName qName5 = null;
        org.apache.commons.jxpath.ri.model.beans.NullPointer nullPointer6 = new org.apache.commons.jxpath.ri.model.beans.NullPointer((org.apache.commons.jxpath.ri.model.NodePointer) collectionPointer4, qName5);
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespaceIterator jDOMNamespaceIterator7 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespaceIterator((org.apache.commons.jxpath.ri.model.NodePointer) nullPointer6);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer8 = jDOMNamespaceIterator7.getNodePointer();
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertNull(nodePointer8);
    }

    @Test
    public void test248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test248");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest4 = null;
        boolean boolean5 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, (Object) true, nodeTest4);
        org.apache.commons.jxpath.ri.QName qName6 = null;
        org.apache.commons.jxpath.ri.model.beans.NullPointer nullPointer7 = new org.apache.commons.jxpath.ri.model.beans.NullPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, qName6);
        String str8 = nullPointer7.asPath();
        org.apache.commons.jxpath.ri.QName qName9 = nullPointer7.getName();
        org.apache.commons.jxpath.ri.EvalContext evalContext10 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray11 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext12 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext10, evalContextArray11);
        boolean boolean14 = unionContext12.setPosition(29);
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer15 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((org.apache.commons.jxpath.ri.model.NodePointer) nullPointer7, (Object) boolean14);
        Object obj16 = nullPointer7.getNodeValue();
        Object obj17 = nullPointer7.getValue();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "namespace::/null" + "'", str8, "namespace::/null");
        org.junit.Assert.assertNull(qName9);
        org.junit.Assert.assertNotNull(evalContextArray11);
        org.junit.Assert.assertArrayEquals(evalContextArray11, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNull(obj16);
        org.junit.Assert.assertNull(obj17);
    }

    @Test
    public void test249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test249");
        org.apache.commons.jxpath.ri.QName qName0 = null;
        org.apache.commons.jxpath.ri.EvalContext evalContext1 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray2 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext3 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext1, evalContextArray2);
        java.util.Locale locale4 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer5 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext1, locale4);
        Object obj6 = collectionPointer5.getImmediateNode();
        org.apache.commons.jxpath.servlet.ServletContextHandler servletContextHandler7 = new org.apache.commons.jxpath.servlet.ServletContextHandler();
        java.util.Locale locale8 = null;
        org.apache.commons.jxpath.ri.model.dynamic.DynamicPointer dynamicPointer9 = new org.apache.commons.jxpath.ri.model.dynamic.DynamicPointer(qName0, (Object) collectionPointer5, (DynamicPropertyHandler) servletContextHandler7, locale8);
        boolean boolean10 = dynamicPointer9.isDynamicPropertyDeclarationSupported();
        org.apache.commons.jxpath.ri.model.beans.PropertyPointer propertyPointer11 = dynamicPointer9.getPropertyPointer();
        org.apache.commons.jxpath.ri.QName qName13 = new org.apache.commons.jxpath.ri.QName("JDOM");
        org.apache.commons.jxpath.ri.model.beans.BeanAttributeIterator beanAttributeIterator14 = new org.apache.commons.jxpath.ri.model.beans.BeanAttributeIterator((org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer) dynamicPointer9, qName13);
        org.junit.Assert.assertNotNull(evalContextArray2);
        org.junit.Assert.assertArrayEquals(evalContextArray2, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertNull(obj6);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertNotNull(propertyPointer11);
    }

    @Test
    public void test250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test250");
        BasicVariables basicVariables0 = new BasicVariables();
    }

    @Test
    public void test251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test251");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest4 = null;
        boolean boolean5 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, (Object) true, nodeTest4);
        org.apache.commons.jxpath.ri.QName qName6 = null;
        org.apache.commons.jxpath.ri.model.beans.NullPointer nullPointer7 = new org.apache.commons.jxpath.ri.model.beans.NullPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, qName6);
        org.apache.commons.jxpath.ri.QName qName8 = nullPointer7.getName();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNull(qName8);
    }

    @Test
    public void test252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test252");
        org.apache.commons.jxpath.ri.parser.Token token0 = new org.apache.commons.jxpath.ri.parser.Token();
        org.apache.commons.jxpath.ri.parser.Token token1 = new org.apache.commons.jxpath.ri.parser.Token();
        int int2 = token1.endLine;
        token0.next = token1;
        token0.beginColumn = (short) 100;
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test253");
        org.apache.commons.jxpath.ri.parser.ParseException parseException1 = new org.apache.commons.jxpath.ri.parser.ParseException("hi!");
        int[] intArray8 = new int[] { (byte) 0, 110, 74, 36, 100, (short) 0 };
        int[] intArray15 = new int[] { (byte) 0, 110, 74, 36, 100, (short) 0 };
        int[] intArray22 = new int[] { (byte) 0, 110, 74, 36, 100, (short) 0 };
        int[] intArray29 = new int[] { (byte) 0, 110, 74, 36, 100, (short) 0 };
        int[] intArray36 = new int[] { (byte) 0, 110, 74, 36, 100, (short) 0 };
        int[][] intArray37 = new int[][] { intArray8, intArray15, intArray22, intArray29, intArray36 };
        parseException1.expectedTokenSequences = intArray37;
        org.junit.Assert.assertNotNull(intArray8);
        org.junit.Assert.assertArrayEquals(intArray8, new int[] { 0, 110, 74, 36, 100, 0 });
        org.junit.Assert.assertNotNull(intArray15);
        org.junit.Assert.assertArrayEquals(intArray15, new int[] { 0, 110, 74, 36, 100, 0 });
        org.junit.Assert.assertNotNull(intArray22);
        org.junit.Assert.assertArrayEquals(intArray22, new int[] { 0, 110, 74, 36, 100, 0 });
        org.junit.Assert.assertNotNull(intArray29);
        org.junit.Assert.assertArrayEquals(intArray29, new int[] { 0, 110, 74, 36, 100, 0 });
        org.junit.Assert.assertNotNull(intArray36);
        org.junit.Assert.assertArrayEquals(intArray36, new int[] { 0, 110, 74, 36, 100, 0 });
        org.junit.Assert.assertNotNull(intArray37);
    }

    @Test
    public void test254() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test254");
        org.apache.commons.jxpath.ri.compiler.Step step1 = null;
        org.apache.commons.jxpath.ri.compiler.Step[] stepArray2 = new org.apache.commons.jxpath.ri.compiler.Step[] { step1 };
        org.apache.commons.jxpath.ri.compiler.LocationPath locationPath3 = new org.apache.commons.jxpath.ri.compiler.LocationPath(true, stepArray2);
        org.apache.commons.jxpath.ri.EvalContext evalContext4 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray5 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext6 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext4, evalContextArray5);
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest7 = null;
        org.apache.commons.jxpath.ri.axes.SelfContext selfContext8 = new org.apache.commons.jxpath.ri.axes.SelfContext((org.apache.commons.jxpath.ri.EvalContext) unionContext6, nodeTest7);
        selfContext8.reset();
        boolean boolean10 = selfContext8.nextNode();
        // The following exception was thrown during execution in test generation
        try {
            Object obj11 = locationPath3.compute((org.apache.commons.jxpath.ri.EvalContext) selfContext8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(stepArray2);
        org.junit.Assert.assertArrayEquals(stepArray2, new org.apache.commons.jxpath.ri.compiler.Step[] { null });
        org.junit.Assert.assertNotNull(evalContextArray5);
        org.junit.Assert.assertArrayEquals(evalContextArray5, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test255() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test255");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        java.util.Locale locale3 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer4 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext0, locale3);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer7 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer5, "");
        jDOMNamespacePointer7.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute10 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer11 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer7, attribute10);
        org.apache.commons.beanutils.DynaBean dynaBean12 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer13 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer11, dynaBean12);
        boolean boolean15 = dynaBeanPropertyPointer13.equals((Object) true);
        boolean boolean16 = collectionPointer4.equals((Object) dynaBeanPropertyPointer13);
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test256() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test256");
        org.apache.commons.jxpath.ri.compiler.TreeCompiler treeCompiler0 = new org.apache.commons.jxpath.ri.compiler.TreeCompiler();
        Object obj3 = treeCompiler0.qname("org.apache.commons.jxpath.JXPathException", "org.apache.commons.jxpath.JXPathContextFactory");
        org.junit.Assert.assertNotNull(obj3);
        org.junit.Assert.assertEquals(obj3.toString(), "org.apache.commons.jxpath.JXPathException:org.apache.commons.jxpath.JXPathContextFactory");
        org.junit.Assert.assertEquals(String.valueOf(obj3), "org.apache.commons.jxpath.JXPathException:org.apache.commons.jxpath.JXPathContextFactory");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj3), "org.apache.commons.jxpath.JXPathException:org.apache.commons.jxpath.JXPathContextFactory");
    }

    @Test
    public void test257() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test257");
        java.util.Comparator comparator0 = org.apache.commons.jxpath.util.ReverseComparator.INSTANCE;
        org.junit.Assert.assertNotNull(comparator0);
    }

    @Test
    public void test258() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test258");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.AXIS_ANCESTOR_OR_SELF;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 44 + "'", int0 == 44);
    }

    @Test
    public void test259() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test259");
        org.apache.commons.jxpath.servlet.HttpSessionHandler httpSessionHandler0 = new org.apache.commons.jxpath.servlet.HttpSessionHandler();
        org.apache.commons.jxpath.ri.compiler.Expression expression1 = null;
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray3 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction4 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray3);
        org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan coreOperationLessThan5 = new org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan(expression1, (org.apache.commons.jxpath.ri.compiler.Expression) coreFunction4);
        // The following exception was thrown during execution in test generation
        try {
            Object obj7 = httpSessionHandler0.getProperty((Object) coreOperationLessThan5, "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan cannot be cast to org.apache.commons.jxpath.servlet.HttpSessionAndServletContext");
        } catch (ClassCastException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(expressionArray3);
        org.junit.Assert.assertArrayEquals(expressionArray3, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
    }

    @Test
    public void test260() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test260");
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray1 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction2 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray1);
        boolean boolean3 = coreFunction2.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.Expression expression4 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression5 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual6 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression4, expression5);
        org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan coreOperationLessThan7 = new org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction2, expression5);
        org.apache.commons.jxpath.ri.EvalContext evalContext8 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray9 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext10 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext8, evalContextArray9);
        Pointer pointer11 = unionContext10.getSingleNodePointer();
        // The following exception was thrown during execution in test generation
        try {
            Object obj12 = coreOperationLessThan7.computeValue((org.apache.commons.jxpath.ri.EvalContext) unionContext10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(expressionArray1);
        org.junit.Assert.assertArrayEquals(expressionArray1, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(evalContextArray9);
        org.junit.Assert.assertArrayEquals(evalContextArray9, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertNull(pointer11);
    }

    @Test
    public void test261() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test261");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        java.util.Locale locale3 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer4 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext0, locale3);
        org.apache.commons.jxpath.ri.QName qName5 = collectionPointer4.getName();
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertNull(qName5);
    }

    @Test
    public void test262() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test262");
        javax.servlet.ServletContext servletContext0 = null;
        // The following exception was thrown during execution in test generation
        try {
            JXPathContext jXPathContext1 = org.apache.commons.jxpath.servlet.JXPathServletContexts.getApplicationContext(servletContext0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test263() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test263");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest4 = null;
        boolean boolean5 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, (Object) true, nodeTest4);
        org.apache.commons.jxpath.ri.QName qName6 = null;
        org.apache.commons.jxpath.ri.model.beans.NullPointer nullPointer7 = new org.apache.commons.jxpath.ri.model.beans.NullPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, qName6);
        org.apache.commons.jxpath.ri.model.beans.PropertyPointer propertyPointer8 = nullPointer7.getPropertyPointer();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer9 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer11 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer9, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest13 = null;
        boolean boolean14 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer11, (Object) true, nodeTest13);
        String str15 = jDOMNamespacePointer11.asPath();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer16 = jDOMNamespacePointer11.getImmediateParentPointer();
        boolean boolean17 = propertyPointer8.equals((Object) jDOMNamespacePointer11);
        JXPathContext jXPathContext18 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.model.NodePointer nodePointer19 = propertyPointer8.createPath(jXPathContext18);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.jxpath.JXPathException; message: Cannot create an object for path namespace::/*[-2147483647], operation is not allowed for this type of node");
        } catch (JXPathException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(propertyPointer8);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "namespace::" + "'", str15, "namespace::");
        org.junit.Assert.assertNull(nodePointer16);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test264() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test264");
        org.apache.commons.jxpath.ri.QName qName2 = new org.apache.commons.jxpath.ri.QName("DOM", "namespace::");
        org.apache.commons.jxpath.xml.JDOMParser jDOMParser3 = new org.apache.commons.jxpath.xml.JDOMParser();
        jDOMParser3.setExpandEntityReferences(false);
        java.util.Locale locale6 = null;
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer7 = org.apache.commons.jxpath.ri.model.NodePointer.newNodePointer(qName2, (Object) false, locale6);
        org.junit.Assert.assertNotNull(nodePointer7);
    }

    @Test
    public void test265() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test265");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        org.apache.commons.jxpath.ri.model.dom.NamespacePointer namespacePointer4 = new org.apache.commons.jxpath.ri.model.dom.NamespacePointer(nodePointer0, "");
        String str5 = namespacePointer4.asPath();
        // The following exception was thrown during execution in test generation
        try {
            String str6 = namespacePointer4.getNamespaceURI();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "namespace::" + "'", str5, "namespace::");
    }

    @Test
    public void test266() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test266");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        java.util.Locale locale3 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer4 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext0, locale3);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer7 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer5, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest9 = null;
        boolean boolean10 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer7, (Object) true, nodeTest9);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer11 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer13 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer11, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest15 = null;
        boolean boolean16 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer13, (Object) true, nodeTest15);
        int int17 = collectionPointer4.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer7, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer13);
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest18 = null;
        boolean boolean19 = collectionPointer4.testNode(nodeTest18);
        java.util.Locale locale20 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer jDOMNodePointer21 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer((Object) collectionPointer4, locale20);
        int int22 = jDOMNodePointer21.getLength();
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray24 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction25 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray24);
        int int26 = coreFunction25.getArgumentCount();
        org.apache.commons.jxpath.ri.compiler.CoreOperationNegate coreOperationNegate27 = new org.apache.commons.jxpath.ri.compiler.CoreOperationNegate((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction25);
        // The following exception was thrown during execution in test generation
        try {
            jDOMNodePointer21.setValue((Object) coreFunction25);
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: org.apache.commons.jxpath.ri.model.beans.CollectionPointer cannot be cast to org.jdom.Element");
        } catch (ClassCastException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 1 + "'", int22 == 1);
        org.junit.Assert.assertNotNull(expressionArray24);
        org.junit.Assert.assertArrayEquals(expressionArray24, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 0 + "'", int26 == 0);
    }

    @Test
    public void test267() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test267");
        org.apache.commons.jxpath.ri.parser.Token token0 = new org.apache.commons.jxpath.ri.parser.Token();
        java.util.Locale locale1 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer2 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) token0, locale1);
    }

    @Test
    public void test268() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test268");
        org.apache.commons.jxpath.ri.NamespaceResolver namespaceResolver0 = new org.apache.commons.jxpath.ri.NamespaceResolver();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer1 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer3 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer1, "");
        jDOMNamespacePointer3.setIndex((int) (byte) 10);
        namespaceResolver0.setNamespaceContextPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer3);
        namespaceResolver0.seal();
    }

    @Test
    public void test269() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test269");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        java.util.Locale locale3 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer4 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext0, locale3);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer7 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer5, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest9 = null;
        boolean boolean10 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer7, (Object) true, nodeTest9);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer11 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer13 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer11, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest15 = null;
        boolean boolean16 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer13, (Object) true, nodeTest15);
        int int17 = collectionPointer4.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer7, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer13);
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest18 = null;
        boolean boolean19 = collectionPointer4.testNode(nodeTest18);
        org.jdom.Attribute attribute20 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer21 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) collectionPointer4, attribute20);
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
    }

    @Test
    public void test270() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test270");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest4 = null;
        boolean boolean5 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, (Object) true, nodeTest4);
        org.apache.commons.jxpath.ri.QName qName6 = null;
        org.apache.commons.jxpath.ri.model.beans.NullPointer nullPointer7 = new org.apache.commons.jxpath.ri.model.beans.NullPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, qName6);
        int int8 = nullPointer7.getLength();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer9 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer11 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer9, "");
        org.apache.commons.jxpath.ri.model.dom.NamespacePointer namespacePointer13 = new org.apache.commons.jxpath.ri.model.dom.NamespacePointer(nodePointer9, "");
        boolean boolean14 = namespacePointer13.isCollection();
        Object obj15 = namespacePointer13.getBaseValue();
        org.apache.commons.jxpath.ri.QName qName16 = namespacePointer13.getName();
        org.apache.commons.jxpath.ri.model.NodeIterator nodeIterator17 = nullPointer7.attributeIterator(qName16);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNull(obj15);
        org.junit.Assert.assertNotNull(qName16);
        org.junit.Assert.assertNotNull(nodeIterator17);
    }

    @Test
    public void test271() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test271");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        java.util.Locale locale3 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer4 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext0, locale3);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer7 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer5, "");
        jDOMNamespacePointer7.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute10 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer11 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer7, attribute10);
        boolean boolean12 = jDOMAttributePointer11.isLeaf();
        boolean boolean13 = collectionPointer4.equals((Object) jDOMAttributePointer11);
        org.apache.commons.jxpath.ri.EvalContext evalContext14 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray15 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext16 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext14, evalContextArray15);
        java.util.Locale locale17 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer18 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext14, locale17);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer19 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer21 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer19, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest23 = null;
        boolean boolean24 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer21, (Object) true, nodeTest23);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer25 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer27 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer25, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest29 = null;
        boolean boolean30 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer27, (Object) true, nodeTest29);
        int int31 = collectionPointer18.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer21, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer27);
        org.apache.commons.jxpath.ri.EvalContext evalContext32 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray33 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext34 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext32, evalContextArray33);
        java.util.Locale locale35 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer36 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext32, locale35);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer37 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer39 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer37, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest41 = null;
        boolean boolean42 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer39, (Object) true, nodeTest41);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer43 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer45 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer43, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest47 = null;
        boolean boolean48 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer45, (Object) true, nodeTest47);
        int int49 = collectionPointer36.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer39, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer45);
        int int50 = jDOMAttributePointer11.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer27, (org.apache.commons.jxpath.ri.model.NodePointer) collectionPointer36);
        boolean boolean51 = jDOMNamespacePointer27.isCollection();
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(evalContextArray15);
        org.junit.Assert.assertArrayEquals(evalContextArray15, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + true + "'", boolean30 == true);
        org.junit.Assert.assertTrue("'" + int31 + "' != '" + 0 + "'", int31 == 0);
        org.junit.Assert.assertNotNull(evalContextArray33);
        org.junit.Assert.assertArrayEquals(evalContextArray33, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + true + "'", boolean42 == true);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + true + "'", boolean48 == true);
        org.junit.Assert.assertTrue("'" + int49 + "' != '" + 0 + "'", int49 == 0);
        org.junit.Assert.assertTrue("'" + int50 + "' != '" + 0 + "'", int50 == 0);
        org.junit.Assert.assertTrue("'" + boolean51 + "' != '" + false + "'", boolean51 == false);
    }

    @Test
    public void test272() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test272");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        org.apache.commons.jxpath.ri.model.dom.NamespacePointer namespacePointer4 = new org.apache.commons.jxpath.ri.model.dom.NamespacePointer(nodePointer0, "");
        boolean boolean5 = namespacePointer4.isCollection();
        Object obj6 = namespacePointer4.getBaseValue();
        org.apache.commons.jxpath.ri.QName qName7 = namespacePointer4.getName();
        boolean boolean8 = namespacePointer4.isCollection();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNull(obj6);
        org.junit.Assert.assertNotNull(qName7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test273() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test273");
        org.apache.commons.jxpath.ri.QName qName0 = null;
        org.apache.commons.jxpath.ri.EvalContext evalContext1 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray2 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext3 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext1, evalContextArray2);
        java.util.Locale locale4 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer5 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext1, locale4);
        Object obj6 = collectionPointer5.getImmediateNode();
        org.apache.commons.jxpath.servlet.ServletContextHandler servletContextHandler7 = new org.apache.commons.jxpath.servlet.ServletContextHandler();
        java.util.Locale locale8 = null;
        org.apache.commons.jxpath.ri.model.dynamic.DynamicPointer dynamicPointer9 = new org.apache.commons.jxpath.ri.model.dynamic.DynamicPointer(qName0, (Object) collectionPointer5, (DynamicPropertyHandler) servletContextHandler7, locale8);
        org.apache.commons.jxpath.ri.model.jdom.JDOMPointerFactory jDOMPointerFactory10 = new org.apache.commons.jxpath.ri.model.jdom.JDOMPointerFactory();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer11 = null;
        org.apache.commons.jxpath.ri.QName qName13 = new org.apache.commons.jxpath.ri.QName("JDOM");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer15 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer17 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer15, "");
        jDOMNamespacePointer17.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute20 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer21 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer17, attribute20);
        org.apache.commons.beanutils.DynaBean dynaBean22 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer23 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer21, dynaBean22);
        org.apache.commons.jxpath.servlet.KeywordVariables keywordVariables24 = new org.apache.commons.jxpath.servlet.KeywordVariables("hi!", (Object) dynaBean22);
        java.lang.reflect.Constructor constructor25 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction26 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor25);
        Class<?> wildcardClass27 = constructorFunction26.getClass();
        JXPathBeanInfo jXPathBeanInfo28 = JXPathIntrospector.getBeanInfo((Class) wildcardClass27);
        org.apache.commons.jxpath.ri.model.beans.BeanPointer beanPointer29 = new org.apache.commons.jxpath.ri.model.beans.BeanPointer(nodePointer11, qName13, (Object) keywordVariables24, jXPathBeanInfo28);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer30 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer32 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer30, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest34 = null;
        boolean boolean35 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer32, (Object) true, nodeTest34);
        java.util.Locale locale36 = null;
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer37 = jDOMPointerFactory10.createNodePointer(qName13, (Object) nodeTest34, locale36);
        boolean boolean38 = dynamicPointer9.isValidProperty(qName13);
        org.junit.Assert.assertNotNull(evalContextArray2);
        org.junit.Assert.assertArrayEquals(evalContextArray2, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertNull(obj6);
        org.junit.Assert.assertNotNull(wildcardClass27);
        org.junit.Assert.assertNotNull(jXPathBeanInfo28);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + true + "'", boolean35 == true);
        org.junit.Assert.assertNull(nodePointer37);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + true + "'", boolean38 == true);
    }

    @Test
    public void test274() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test274");
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray1 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction2 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray1);
        org.apache.commons.jxpath.ri.compiler.CoreOperationAdd coreOperationAdd3 = new org.apache.commons.jxpath.ri.compiler.CoreOperationAdd(expressionArray1);
        org.apache.commons.jxpath.ri.compiler.CoreOperationOr coreOperationOr4 = new org.apache.commons.jxpath.ri.compiler.CoreOperationOr(expressionArray1);
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray6 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction7 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray6);
        boolean boolean8 = coreFunction7.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.Expression expression9 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression10 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual11 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression9, expression10);
        org.apache.commons.jxpath.ri.compiler.NameAttributeTest nameAttributeTest12 = new org.apache.commons.jxpath.ri.compiler.NameAttributeTest((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction7, (org.apache.commons.jxpath.ri.compiler.Expression) coreOperationGreaterThanOrEqual11);
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThan coreOperationGreaterThan13 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThan((org.apache.commons.jxpath.ri.compiler.Expression) coreOperationOr4, (org.apache.commons.jxpath.ri.compiler.Expression) nameAttributeTest12);
        String str14 = coreOperationGreaterThan13.getSymbol();
        org.junit.Assert.assertNotNull(expressionArray1);
        org.junit.Assert.assertArrayEquals(expressionArray1, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertNotNull(expressionArray6);
        org.junit.Assert.assertArrayEquals(expressionArray6, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + ">" + "'", str14, ">");
    }

    @Test
    public void test275() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test275");
        org.apache.commons.jxpath.ri.NamespaceResolver namespaceResolver0 = new org.apache.commons.jxpath.ri.NamespaceResolver();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer1 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer3 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer1, "");
        jDOMNamespacePointer3.setIndex((int) (byte) 10);
        namespaceResolver0.setNamespaceContextPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer3);
        org.apache.commons.jxpath.ri.parser.ParseException parseException8 = new org.apache.commons.jxpath.ri.parser.ParseException("hi!");
        int[][] intArray9 = parseException8.expectedTokenSequences;
        jDOMNamespacePointer3.handle((Throwable) parseException8);
        org.junit.Assert.assertNull(intArray9);
    }

    @Test
    public void test276() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test276");
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray1 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction2 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray1);
        org.apache.commons.jxpath.ri.compiler.CoreOperationAdd coreOperationAdd3 = new org.apache.commons.jxpath.ri.compiler.CoreOperationAdd(expressionArray1);
        org.apache.commons.jxpath.ri.compiler.CoreOperationOr coreOperationOr4 = new org.apache.commons.jxpath.ri.compiler.CoreOperationOr(expressionArray1);
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray6 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction7 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray6);
        boolean boolean8 = coreFunction7.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.Expression expression9 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression10 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual11 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression9, expression10);
        org.apache.commons.jxpath.ri.compiler.NameAttributeTest nameAttributeTest12 = new org.apache.commons.jxpath.ri.compiler.NameAttributeTest((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction7, (org.apache.commons.jxpath.ri.compiler.Expression) coreOperationGreaterThanOrEqual11);
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThan coreOperationGreaterThan13 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThan((org.apache.commons.jxpath.ri.compiler.Expression) coreOperationOr4, (org.apache.commons.jxpath.ri.compiler.Expression) nameAttributeTest12);
        org.apache.commons.jxpath.ri.QName qName14 = null;
        org.apache.commons.jxpath.ri.compiler.VariableReference variableReference15 = new org.apache.commons.jxpath.ri.compiler.VariableReference(qName14);
        boolean boolean16 = variableReference15.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.CoreOperationMod coreOperationMod17 = new org.apache.commons.jxpath.ri.compiler.CoreOperationMod((org.apache.commons.jxpath.ri.compiler.Expression) coreOperationOr4, (org.apache.commons.jxpath.ri.compiler.Expression) variableReference15);
        org.junit.Assert.assertNotNull(expressionArray1);
        org.junit.Assert.assertArrayEquals(expressionArray1, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertNotNull(expressionArray6);
        org.junit.Assert.assertArrayEquals(expressionArray6, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test277() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test277");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        org.apache.commons.jxpath.ri.model.dom.NamespacePointer namespacePointer4 = new org.apache.commons.jxpath.ri.model.dom.NamespacePointer(nodePointer0, "");
        int int5 = namespacePointer4.getLength();
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
    }

    @Test
    public void test278() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test278");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        int int3 = unionContext2.getCurrentPosition();
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest4 = null;
        org.apache.commons.jxpath.ri.axes.ParentContext parentContext5 = new org.apache.commons.jxpath.ri.axes.ParentContext((org.apache.commons.jxpath.ri.EvalContext) unionContext2, nodeTest4);
        parentContext5.reset();
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest8 = null;
        org.apache.commons.jxpath.ri.axes.DescendantContext descendantContext9 = new org.apache.commons.jxpath.ri.axes.DescendantContext((org.apache.commons.jxpath.ri.EvalContext) parentContext5, true, nodeTest8);
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest10 = null;
        org.apache.commons.jxpath.ri.axes.ParentContext parentContext11 = new org.apache.commons.jxpath.ri.axes.ParentContext((org.apache.commons.jxpath.ri.EvalContext) descendantContext9, nodeTest10);
        org.apache.commons.jxpath.ri.model.dynamic.DynamicPointerFactory dynamicPointerFactory12 = new org.apache.commons.jxpath.ri.model.dynamic.DynamicPointerFactory();
        org.apache.commons.jxpath.ri.QName qName13 = null;
        java.util.Locale locale15 = null;
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer16 = dynamicPointerFactory12.createNodePointer(qName13, (Object) 110, locale15);
        org.apache.commons.jxpath.ri.model.jdom.JDOMPointerFactory jDOMPointerFactory17 = new org.apache.commons.jxpath.ri.model.jdom.JDOMPointerFactory();
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer18 = null;
        org.apache.commons.jxpath.ri.QName qName20 = new org.apache.commons.jxpath.ri.QName("JDOM");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer22 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer24 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer22, "");
        jDOMNamespacePointer24.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute27 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer28 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer24, attribute27);
        org.apache.commons.beanutils.DynaBean dynaBean29 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer dynaBeanPropertyPointer30 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer28, dynaBean29);
        org.apache.commons.jxpath.servlet.KeywordVariables keywordVariables31 = new org.apache.commons.jxpath.servlet.KeywordVariables("hi!", (Object) dynaBean29);
        java.lang.reflect.Constructor constructor32 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction33 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor32);
        Class<?> wildcardClass34 = constructorFunction33.getClass();
        JXPathBeanInfo jXPathBeanInfo35 = JXPathIntrospector.getBeanInfo((Class) wildcardClass34);
        org.apache.commons.jxpath.ri.model.beans.BeanPointer beanPointer36 = new org.apache.commons.jxpath.ri.model.beans.BeanPointer(nodePointer18, qName20, (Object) keywordVariables31, jXPathBeanInfo35);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer37 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer39 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer37, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest41 = null;
        boolean boolean42 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer39, (Object) true, nodeTest41);
        java.util.Locale locale43 = null;
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer44 = jDOMPointerFactory17.createNodePointer(qName20, (Object) nodeTest41, locale43);
        org.apache.commons.jxpath.ri.compiler.Expression expression45 = null;
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray47 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction48 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray47);
        org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan coreOperationLessThan49 = new org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan(expression45, (org.apache.commons.jxpath.ri.compiler.Expression) coreFunction48);
        java.util.Locale locale50 = null;
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer51 = dynamicPointerFactory12.createNodePointer(qName20, (Object) coreFunction48, locale50);
        java.util.Locale locale52 = null;
        org.apache.commons.jxpath.ri.compiler.Expression.PointerIterator pointerIterator53 = new org.apache.commons.jxpath.ri.compiler.Expression.PointerIterator((java.util.Iterator) descendantContext9, qName20, locale52);
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNull(nodePointer16);
        org.junit.Assert.assertNotNull(wildcardClass34);
        org.junit.Assert.assertNotNull(jXPathBeanInfo35);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + true + "'", boolean42 == true);
        org.junit.Assert.assertNull(nodePointer44);
        org.junit.Assert.assertNotNull(expressionArray47);
        org.junit.Assert.assertArrayEquals(expressionArray47, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertNull(nodePointer51);
    }

    @Test
    public void test279() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test279");
        org.w3c.dom.Node node0 = null;
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest1 = null;
        boolean boolean2 = org.apache.commons.jxpath.ri.model.dom.DOMNodePointer.testNode(node0, nodeTest1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test280() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test280");
        int int0 = org.apache.commons.jxpath.ri.Compiler.AXIS_DESCENDANT_OR_SELF;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 13 + "'", int0 == 13);
    }

    @Test
    public void test281() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test281");
        int int0 = org.apache.commons.jxpath.ri.parser.XPathParserConstants.FUNCTION_ROUND;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 77 + "'", int0 == 77);
    }

    @Test
    public void test282() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test282");
        org.apache.commons.jxpath.ri.compiler.Step step1 = null;
        org.apache.commons.jxpath.ri.compiler.Step[] stepArray2 = new org.apache.commons.jxpath.ri.compiler.Step[] { step1 };
        org.apache.commons.jxpath.ri.compiler.LocationPath locationPath3 = new org.apache.commons.jxpath.ri.compiler.LocationPath(true, stepArray2);
        org.apache.commons.jxpath.ri.EvalContext evalContext4 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray5 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext6 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext4, evalContextArray5);
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest7 = null;
        org.apache.commons.jxpath.ri.axes.SelfContext selfContext8 = new org.apache.commons.jxpath.ri.axes.SelfContext((org.apache.commons.jxpath.ri.EvalContext) unionContext6, nodeTest7);
        // The following exception was thrown during execution in test generation
        try {
            Object obj9 = locationPath3.compute((org.apache.commons.jxpath.ri.EvalContext) unionContext6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(stepArray2);
        org.junit.Assert.assertArrayEquals(stepArray2, new org.apache.commons.jxpath.ri.compiler.Step[] { null });
        org.junit.Assert.assertNotNull(evalContextArray5);
        org.junit.Assert.assertArrayEquals(evalContextArray5, new org.apache.commons.jxpath.ri.EvalContext[] {});
    }

    @Test
    public void test283() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test283");
        org.apache.commons.jxpath.ri.compiler.TreeCompiler treeCompiler0 = new org.apache.commons.jxpath.ri.compiler.TreeCompiler();
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray2 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction3 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray2);
        boolean boolean4 = coreFunction3.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.Expression expression5 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression6 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual7 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression5, expression6);
        org.apache.commons.jxpath.ri.compiler.NameAttributeTest nameAttributeTest8 = new org.apache.commons.jxpath.ri.compiler.NameAttributeTest((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction3, (org.apache.commons.jxpath.ri.compiler.Expression) coreOperationGreaterThanOrEqual7);
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray10 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction11 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray10);
        boolean boolean12 = coreFunction11.computeContextDependent();
        org.apache.commons.jxpath.ri.compiler.Expression expression13 = null;
        org.apache.commons.jxpath.ri.compiler.Expression expression14 = null;
        org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual coreOperationGreaterThanOrEqual15 = new org.apache.commons.jxpath.ri.compiler.CoreOperationGreaterThanOrEqual(expression13, expression14);
        org.apache.commons.jxpath.ri.compiler.NameAttributeTest nameAttributeTest16 = new org.apache.commons.jxpath.ri.compiler.NameAttributeTest((org.apache.commons.jxpath.ri.compiler.Expression) coreFunction11, (org.apache.commons.jxpath.ri.compiler.Expression) coreOperationGreaterThanOrEqual15);
        org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan coreOperationLessThan17 = new org.apache.commons.jxpath.ri.compiler.CoreOperationLessThan((org.apache.commons.jxpath.ri.compiler.Expression) nameAttributeTest8, (org.apache.commons.jxpath.ri.compiler.Expression) nameAttributeTest16);
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray18 = nameAttributeTest8.getArguments();
        org.apache.commons.jxpath.ri.compiler.CoreOperationAnd coreOperationAnd19 = new org.apache.commons.jxpath.ri.compiler.CoreOperationAnd(expressionArray18);
        org.apache.commons.jxpath.ri.EvalContext evalContext20 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray21 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext22 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext20, evalContextArray21);
        java.util.Locale locale23 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer24 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext20, locale23);
        Object obj25 = collectionPointer24.getImmediateNode();
        Object obj26 = treeCompiler0.lessThanOrEqual((Object) coreOperationAnd19, obj25);
        org.junit.Assert.assertNotNull(expressionArray2);
        org.junit.Assert.assertArrayEquals(expressionArray2, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(expressionArray10);
        org.junit.Assert.assertArrayEquals(expressionArray10, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(expressionArray18);
        org.junit.Assert.assertNotNull(evalContextArray21);
        org.junit.Assert.assertArrayEquals(evalContextArray21, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertNull(obj25);
        org.junit.Assert.assertNotNull(obj26);
    }

    @Test
    public void test284() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test284");
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer0 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer2 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer0, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest4 = null;
        boolean boolean5 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, (Object) true, nodeTest4);
        org.apache.commons.jxpath.ri.QName qName6 = null;
        org.apache.commons.jxpath.ri.model.beans.NullPointer nullPointer7 = new org.apache.commons.jxpath.ri.model.beans.NullPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer2, qName6);
        int int8 = nullPointer7.getLength();
        Object obj9 = nullPointer7.getValue();
        org.apache.commons.jxpath.ri.QName qName12 = null;
        org.apache.commons.beanutils.DynaBean dynaBean13 = null;
        java.util.Locale locale14 = null;
        org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer dynaBeanPointer15 = new org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer(qName12, dynaBean13, locale14);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer16 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer18 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer16, "");
        jDOMNamespacePointer18.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute21 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer22 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer18, attribute21);
        boolean boolean23 = jDOMAttributePointer22.isLeaf();
        Object obj24 = jDOMAttributePointer22.getImmediateNode();
        java.lang.reflect.Constructor constructor25 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction26 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor25);
        Class<?> wildcardClass27 = constructorFunction26.getClass();
        JXPathBasicBeanInfo jXPathBasicBeanInfo29 = new JXPathBasicBeanInfo((Class) wildcardClass27, false);
        String str30 = jXPathBasicBeanInfo29.toString();
        org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer beanPropertyPointer31 = new org.apache.commons.jxpath.ri.model.beans.BeanPropertyPointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMAttributePointer22, (JXPathBeanInfo) jXPathBasicBeanInfo29);
        int int32 = dynaBeanPointer15.compareTo((Object) beanPropertyPointer31);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.model.NodeIterator nodeIterator33 = nullPointer7.createNodeIterator("<=", false, (org.apache.commons.jxpath.ri.model.NodePointer) dynaBeanPointer15);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.jxpath.JXPathException; message: PropertyIerator startWith parameter is not a child of the supplied parent");
        } catch (JXPathException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNull(obj9);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertNull(obj24);
        org.junit.Assert.assertNotNull(wildcardClass27);
        org.junit.Assert.assertEquals("'" + str30 + "' != '" + "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]" + "'", str30, "BeanInfo [class = org.apache.commons.jxpath.functions.ConstructorFunction, properties = ]");
        org.junit.Assert.assertTrue("'" + int32 + "' != '" + 0 + "'", int32 == 0);
    }

    @Test
    public void test285() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test285");
        org.apache.commons.jxpath.util.TypeConverter typeConverter0 = org.apache.commons.jxpath.util.TypeUtils.getTypeConverter();
        org.apache.commons.jxpath.ri.EvalContext evalContext1 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray2 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext3 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext1, evalContextArray2);
        java.util.Locale locale4 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer5 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext1, locale4);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer6 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer8 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer6, "");
        jDOMNamespacePointer8.setIndex((int) (byte) 10);
        org.jdom.Attribute attribute11 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer jDOMAttributePointer12 = new org.apache.commons.jxpath.ri.model.jdom.JDOMAttributePointer((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer8, attribute11);
        boolean boolean13 = jDOMAttributePointer12.isLeaf();
        boolean boolean14 = collectionPointer5.equals((Object) jDOMAttributePointer12);
        org.apache.commons.jxpath.ri.EvalContext evalContext15 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray16 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext17 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext15, evalContextArray16);
        java.util.Locale locale18 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer19 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext15, locale18);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer20 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer22 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer20, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest24 = null;
        boolean boolean25 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer22, (Object) true, nodeTest24);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer26 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer28 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer26, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest30 = null;
        boolean boolean31 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer28, (Object) true, nodeTest30);
        int int32 = collectionPointer19.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer22, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer28);
        org.apache.commons.jxpath.ri.EvalContext evalContext33 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray34 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext35 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext33, evalContextArray34);
        java.util.Locale locale36 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer37 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext33, locale36);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer38 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer40 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer38, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest42 = null;
        boolean boolean43 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer40, (Object) true, nodeTest42);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer44 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer46 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer44, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest48 = null;
        boolean boolean49 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer46, (Object) true, nodeTest48);
        int int50 = collectionPointer37.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer40, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer46);
        int int51 = jDOMAttributePointer12.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer28, (org.apache.commons.jxpath.ri.model.NodePointer) collectionPointer37);
        java.lang.reflect.Constructor constructor52 = null;
        org.apache.commons.jxpath.functions.ConstructorFunction constructorFunction53 = new org.apache.commons.jxpath.functions.ConstructorFunction(constructor52);
        Class<?> wildcardClass54 = constructorFunction53.getClass();
        JXPathBeanInfo jXPathBeanInfo55 = JXPathIntrospector.getBeanInfo((Class) wildcardClass54);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer57 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer59 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer57, "");
        org.apache.commons.jxpath.ri.model.dom.NamespacePointer namespacePointer61 = new org.apache.commons.jxpath.ri.model.dom.NamespacePointer(nodePointer57, "");
        String str62 = namespacePointer61.asPath();
        org.apache.commons.jxpath.ri.EvalContext evalContext63 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray64 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext65 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext63, evalContextArray64);
        java.util.Locale locale66 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer67 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext63, locale66);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer68 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer70 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer68, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest72 = null;
        boolean boolean73 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer70, (Object) true, nodeTest72);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer74 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer76 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer74, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest78 = null;
        boolean boolean79 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer76, (Object) true, nodeTest78);
        int int80 = collectionPointer67.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer70, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer76);
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest81 = null;
        boolean boolean82 = collectionPointer67.testNode(nodeTest81);
        JXPathFunctionNotFoundException jXPathFunctionNotFoundException84 = new JXPathFunctionNotFoundException("namespace::");
        Object[] objArray85 = new Object[] { namespacePointer61, nodeTest81, "namespace::" };
        java.lang.reflect.Method method86 = org.apache.commons.jxpath.util.MethodLookupUtils.lookupStaticMethod((Class) wildcardClass54, "/", objArray85);
        // The following exception was thrown during execution in test generation
        try {
            Object obj87 = typeConverter0.convert((Object) jDOMNamespacePointer28, (Class) wildcardClass54);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(typeConverter0);
        org.junit.Assert.assertNotNull(evalContextArray2);
        org.junit.Assert.assertArrayEquals(evalContextArray2, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(evalContextArray16);
        org.junit.Assert.assertArrayEquals(evalContextArray16, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + true + "'", boolean25 == true);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + true + "'", boolean31 == true);
        org.junit.Assert.assertTrue("'" + int32 + "' != '" + 0 + "'", int32 == 0);
        org.junit.Assert.assertNotNull(evalContextArray34);
        org.junit.Assert.assertArrayEquals(evalContextArray34, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + true + "'", boolean43 == true);
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + true + "'", boolean49 == true);
        org.junit.Assert.assertTrue("'" + int50 + "' != '" + 0 + "'", int50 == 0);
        org.junit.Assert.assertTrue("'" + int51 + "' != '" + 0 + "'", int51 == 0);
        org.junit.Assert.assertNotNull(wildcardClass54);
        org.junit.Assert.assertNotNull(jXPathBeanInfo55);
        org.junit.Assert.assertEquals("'" + str62 + "' != '" + "namespace::" + "'", str62, "namespace::");
        org.junit.Assert.assertNotNull(evalContextArray64);
        org.junit.Assert.assertArrayEquals(evalContextArray64, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean73 + "' != '" + true + "'", boolean73 == true);
        org.junit.Assert.assertTrue("'" + boolean79 + "' != '" + true + "'", boolean79 == true);
        org.junit.Assert.assertTrue("'" + int80 + "' != '" + 0 + "'", int80 == 0);
        org.junit.Assert.assertTrue("'" + boolean82 + "' != '" + true + "'", boolean82 == true);
        org.junit.Assert.assertNotNull(objArray85);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray85), "[namespace::, null, namespace::]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray85), "[namespace::, null, namespace::]");
        org.junit.Assert.assertNull(method86);
    }

    @Test
    public void test286() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test286");
        org.apache.commons.jxpath.ri.compiler.TreeCompiler treeCompiler0 = new org.apache.commons.jxpath.ri.compiler.TreeCompiler();
        org.apache.commons.jxpath.ri.compiler.Expression[] expressionArray3 = new org.apache.commons.jxpath.ri.compiler.Expression[] {};
        org.apache.commons.jxpath.ri.compiler.CoreFunction coreFunction4 = new org.apache.commons.jxpath.ri.compiler.CoreFunction((int) (byte) -1, expressionArray3);
        Object obj5 = treeCompiler0.function(51, (Object[]) expressionArray3);
        org.apache.commons.jxpath.ri.EvalContext evalContext6 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray7 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext8 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext6, evalContextArray7);
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest9 = null;
        org.apache.commons.jxpath.ri.axes.SelfContext selfContext10 = new org.apache.commons.jxpath.ri.axes.SelfContext((org.apache.commons.jxpath.ri.EvalContext) unionContext8, nodeTest9);
        org.apache.commons.jxpath.ri.EvalContext evalContext11 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray12 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext13 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext11, evalContextArray12);
        java.util.Locale locale14 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer15 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext11, locale14);
        org.apache.commons.jxpath.ri.QName qName16 = null;
        org.apache.commons.jxpath.ri.model.beans.NullPointer nullPointer17 = new org.apache.commons.jxpath.ri.model.beans.NullPointer((org.apache.commons.jxpath.ri.model.NodePointer) collectionPointer15, qName16);
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespaceIterator jDOMNamespaceIterator18 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespaceIterator((org.apache.commons.jxpath.ri.model.NodePointer) nullPointer17);
        // The following exception was thrown during execution in test generation
        try {
            Object obj19 = treeCompiler0.greaterThanOrEqual((Object) selfContext10, (Object) jDOMNamespaceIterator18);
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: org.apache.commons.jxpath.ri.axes.SelfContext cannot be cast to org.apache.commons.jxpath.ri.compiler.Expression");
        } catch (ClassCastException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(expressionArray3);
        org.junit.Assert.assertArrayEquals(expressionArray3, new org.apache.commons.jxpath.ri.compiler.Expression[] {});
        org.junit.Assert.assertNotNull(obj5);
        org.junit.Assert.assertEquals(obj5.toString(), "unknownFunction51()()");
        org.junit.Assert.assertEquals(String.valueOf(obj5), "unknownFunction51()()");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj5), "unknownFunction51()()");
        org.junit.Assert.assertNotNull(evalContextArray7);
        org.junit.Assert.assertArrayEquals(evalContextArray7, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertNotNull(evalContextArray12);
        org.junit.Assert.assertArrayEquals(evalContextArray12, new org.apache.commons.jxpath.ri.EvalContext[] {});
    }

    @Test
    public void test287() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test287");
        org.apache.commons.jxpath.ri.EvalContext evalContext0 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray1 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext2 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext0, evalContextArray1);
        java.util.Locale locale3 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer4 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext0, locale3);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer5 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer7 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer5, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest9 = null;
        boolean boolean10 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer7, (Object) true, nodeTest9);
        org.apache.commons.jxpath.ri.model.NodePointer nodePointer11 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer jDOMNamespacePointer13 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNamespacePointer(nodePointer11, "");
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest15 = null;
        boolean boolean16 = org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer.testNode((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer13, (Object) true, nodeTest15);
        int int17 = collectionPointer4.compareChildNodePointers((org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer7, (org.apache.commons.jxpath.ri.model.NodePointer) jDOMNamespacePointer13);
        org.apache.commons.jxpath.ri.compiler.NodeTest nodeTest18 = null;
        boolean boolean19 = collectionPointer4.testNode(nodeTest18);
        java.util.Locale locale20 = null;
        org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer jDOMNodePointer21 = new org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer((Object) collectionPointer4, locale20);
        String str22 = jDOMNodePointer21.asPath();
        org.junit.Assert.assertNotNull(evalContextArray1);
        org.junit.Assert.assertArrayEquals(evalContextArray1, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "" + "'", str22, "");
    }

    @Test
    public void test288() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test288");
        java.io.InputStream inputStream0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.jxpath.ri.parser.SimpleCharStream simpleCharStream3 = new org.apache.commons.jxpath.ri.parser.SimpleCharStream(inputStream0, 0, 6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test289() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test289");
        org.apache.commons.jxpath.ri.QName qName0 = null;
        org.apache.commons.jxpath.ri.EvalContext evalContext1 = null;
        org.apache.commons.jxpath.ri.EvalContext[] evalContextArray2 = new org.apache.commons.jxpath.ri.EvalContext[] {};
        org.apache.commons.jxpath.ri.axes.UnionContext unionContext3 = new org.apache.commons.jxpath.ri.axes.UnionContext(evalContext1, evalContextArray2);
        java.util.Locale locale4 = null;
        org.apache.commons.jxpath.ri.model.beans.CollectionPointer collectionPointer5 = new org.apache.commons.jxpath.ri.model.beans.CollectionPointer((Object) evalContext1, locale4);
        Object obj6 = collectionPointer5.getImmediateNode();
        org.apache.commons.jxpath.servlet.ServletContextHandler servletContextHandler7 = new org.apache.commons.jxpath.servlet.ServletContextHandler();
        java.util.Locale locale8 = null;
        org.apache.commons.jxpath.ri.model.dynamic.DynamicPointer dynamicPointer9 = new org.apache.commons.jxpath.ri.model.dynamic.DynamicPointer(qName0, (Object) collectionPointer5, (DynamicPropertyHandler) servletContextHandler7, locale8);
        boolean boolean10 = dynamicPointer9.isDynamicPropertyDeclarationSupported();
        org.apache.commons.jxpath.ri.QName qName11 = dynamicPointer9.getName();
        Object obj12 = null;
        boolean boolean13 = dynamicPointer9.equals(obj12);
        String str14 = dynamicPointer9.asPath();
        org.junit.Assert.assertNotNull(evalContextArray2);
        org.junit.Assert.assertArrayEquals(evalContextArray2, new org.apache.commons.jxpath.ri.EvalContext[] {});
        org.junit.Assert.assertNull(obj6);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertNull(qName11);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "/" + "'", str14, "/");
    }
}

