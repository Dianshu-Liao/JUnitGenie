package com.fasterxml.jackson.dataformat.xml;

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
        int int0 = javax.xml.stream.XMLStreamConstants.START_DOCUMENT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 7 + "'", int0 == 7);
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        com.fasterxml.jackson.databind.deser.DeserializerFactory deserializerFactory0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.deser.XmlDeserializationContext xmlDeserializationContext1 = new com.fasterxml.jackson.dataformat.xml.deser.XmlDeserializationContext(deserializerFactory0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Can not pass null DeserializerFactory");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        com.fasterxml.jackson.dataformat.xml.util.StaxUtil staxUtil0 = new com.fasterxml.jackson.dataformat.xml.util.StaxUtil();
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test004");
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext xmlReadContext2 = com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext.createRootContext(100, (int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchFieldError; message: _nestingDepth");
        } catch (NoSuchFieldError e) {
            // Expected exception.
        }
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test005");
        int int0 = com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream.XML_TEXT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 5 + "'", int0 == 5);
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        int int0 = javax.xml.stream.XMLStreamConstants.COMMENT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 5 + "'", int0 == 5);
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        javax.xml.stream.XMLInputFactory xMLInputFactory0 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory1 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlMapper xmlMapper2 = new XmlMapper(xMLInputFactory0, xMLOutputFactory1);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlMapper.coercionConfigDefaults()Lcom/fasterxml/jackson/databind/cfg/MutableCoercionConfig;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        javax.xml.stream.XMLInputFactory xMLInputFactory0 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlMapper xmlMapper1 = new XmlMapper(xMLInputFactory0);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlMapper.coercionConfigDefaults()Lcom/fasterxml/jackson/databind/cfg/MutableCoercionConfig;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_1 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafXsiNilElement(xMLStreamWriter2_1, "", "");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        String str0 = com.fasterxml.jackson.core.JsonFactory.FORMAT_NAME_JSON;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "JSON" + "'", str0, "JSON");
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializerBase xmlBeanSerializerBase0 = null;
        String[] strArray3 = new String[] { "JSON", "JSON" };
        java.util.LinkedHashSet<String> strSet4 = new java.util.LinkedHashSet<String>();
        boolean boolean5 = java.util.Collections.addAll((java.util.Collection<String>) strSet4, strArray3);
        String[] strArray8 = new String[] { "", "" };
        java.util.LinkedHashSet<String> strSet9 = new java.util.LinkedHashSet<String>();
        boolean boolean10 = java.util.Collections.addAll((java.util.Collection<String>) strSet9, strArray8);
        java.util.Spliterator<String> strSpliterator11 = strSet9.spliterator();
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializer xmlBeanSerializer12 = new com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializer(xmlBeanSerializerBase0, (java.util.Set<String>) strSet4, (java.util.Set<String>) strSet9);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.<init>(Lcom/fasterxml/jackson/databind/ser/std/BeanSerializerBase;Ljava/util/Set;Ljava/util/Set;)V");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray3);
        org.junit.Assert.assertArrayEquals(strArray3, new String[] { "JSON", "JSON" });
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(strArray8);
        org.junit.Assert.assertArrayEquals(strArray8, new String[] { "", "" });
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertNotNull(strSpliterator11);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        PackageVersion packageVersion0 = new PackageVersion();
        com.fasterxml.jackson.core.Version version1 = packageVersion0.version();
        org.junit.Assert.assertNotNull(version1);
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_1 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeStartElement(xMLStreamWriter2_1, "", "hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        com.fasterxml.jackson.dataformat.xml.ser.UnwrappingXmlBeanSerializer unwrappingXmlBeanSerializer0 = null;
        com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter objectIdWriter1 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.UnwrappingXmlBeanSerializer unwrappingXmlBeanSerializer2 = new com.fasterxml.jackson.dataformat.xml.ser.UnwrappingXmlBeanSerializer(unwrappingXmlBeanSerializer0, objectIdWriter1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        com.fasterxml.jackson.dataformat.xml.ser.UnwrappingXmlBeanSerializer unwrappingXmlBeanSerializer0 = null;
        com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter objectIdWriter1 = null;
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup2 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.UnwrappingXmlBeanSerializer unwrappingXmlBeanSerializer3 = new com.fasterxml.jackson.dataformat.xml.ser.UnwrappingXmlBeanSerializer(unwrappingXmlBeanSerializer0, objectIdWriter1, (Object) xmlRootNameLookup2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        com.fasterxml.jackson.databind.ser.BeanPropertyWriter beanPropertyWriter0 = null;
        com.fasterxml.jackson.databind.PropertyName propertyName1 = null;
        com.fasterxml.jackson.databind.PropertyName propertyName2 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer3 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.XmlBeanPropertyWriter xmlBeanPropertyWriter4 = new com.fasterxml.jackson.dataformat.xml.ser.XmlBeanPropertyWriter(beanPropertyWriter0, propertyName1, propertyName2, objJsonSerializer3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_1 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafNullElement(xMLStreamWriter2_1, "hi!", "");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeEndObject(jsonGenerator3, 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_3 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeEndElement(xMLStreamWriter2_3, 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeRootValueSeparator(jsonGenerator3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_1 = null;
        java.math.BigDecimal bigDecimal4 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_1, "hi!", "hi!", bigDecimal4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        String str1 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.sanitizeXmlTypeName("hi!");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "hi_" + "'", str1, "hi_");
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_1 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_1, "hi!", "", 0.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser8 = xmlFactory6.createJsonParser("hi_");
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlFactory._createContentReference(Ljava/lang/Object;)Lcom/fasterxml/jackson/core/io/ContentReference;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeRootValueSeparator(jsonGenerator3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        int int0 = javax.xml.stream.XMLStreamConstants.END_ELEMENT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2 + "'", int0 == 2);
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.beforeArrayValues(jsonGenerator1);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_3 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_3, "", "JSON", (long) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        int int0 = javax.xml.stream.XMLStreamConstants.PROCESSING_INSTRUCTION;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 3 + "'", int0 == 3);
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_3 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_3, "", "hi_", "hi_", true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        String[] strArray2 = new String[] { "", "" };
        java.util.LinkedHashSet<String> strSet3 = new java.util.LinkedHashSet<String>();
        boolean boolean4 = java.util.Collections.addAll((java.util.Collection<String>) strSet3, strArray2);
        java.util.Spliterator<String> strSpliterator5 = strSet3.spliterator();
        com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet caseInsensitiveNameSet6 = com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet.construct((java.util.Set<String>) strSet3);
        java.util.Collection<String> strCollection7 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean8 = strSet3.removeAll(strCollection7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray2);
        org.junit.Assert.assertArrayEquals(strArray2, new String[] { "", "" });
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(strSpliterator5);
        org.junit.Assert.assertNotNull(caseInsensitiveNameSet6);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_1 = null;
        java.math.BigDecimal bigDecimal4 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_1, "", "", bigDecimal4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        java.io.Reader reader9 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser10 = jsonFactory8.createJsonParser(reader9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_3 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_3, "JSON", "JSON", "hi!", false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeArrayValueSeparator(jsonGenerator1);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_3 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_3, "", "hi!", (double) 1.0f);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test035");
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider0 = null;
        com.fasterxml.jackson.databind.SerializationConfig serializationConfig1 = null;
        com.fasterxml.jackson.databind.ser.SerializerFactory serializerFactory2 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider3 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlSerializerProvider0, serializationConfig1, serializerFactory2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        int int0 = javax.xml.stream.XMLStreamConstants.ATTRIBUTE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 10 + "'", int0 == 10);
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        int int0 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.collectDefaults();
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 0 + "'", int0 == 0);
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        XmlFactory xmlFactory1 = new XmlFactory(objectCodec0);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser3 = xmlFactory1.createParser("");
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlFactory._createContentReference(Ljava/lang/Object;)Lcom/fasterxml/jackson/core/io/ContentReference;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        javax.xml.stream.XMLStreamException xMLStreamException0 = null;
        com.fasterxml.jackson.core.JsonParser jsonParser1 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.util.Instantiatable<com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter> defaultXmlPrettyPrinterInstantiatable2 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.throwAsParseException(xMLStreamException0, jsonParser1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        javax.xml.namespace.QName qName0 = com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup.ROOT_NAME_FOR_NULL;
        org.junit.Assert.assertNotNull(qName0);
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_3 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_3, "", "JSON", (long) 2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.StreamWriteFeature streamWriteFeature1 = null;
        com.fasterxml.jackson.core.StreamWriteFeature streamWriteFeature2 = null;
        com.fasterxml.jackson.core.StreamWriteFeature[] streamWriteFeatureArray3 = new com.fasterxml.jackson.core.StreamWriteFeature[] { streamWriteFeature2 };
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder4 = xmlFactoryBuilder0.enable(streamWriteFeature1, streamWriteFeatureArray3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(streamWriteFeatureArray3);
        org.junit.Assert.assertArrayEquals(streamWriteFeatureArray3, new com.fasterxml.jackson.core.StreamWriteFeature[] { null });
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser.Feature feature3 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder4 = xmlFactoryBuilder0.enable(feature3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        XmlFactory xmlFactory0 = new XmlFactory();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory2 = xmlFactory0.setOutputDecorator(outputDecorator1);
        String str3 = xmlFactory0.getXMLTextElementName();
        org.junit.Assert.assertNotNull(jsonFactory2);
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        int int0 = com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream.XML_END;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 8 + "'", int0 == 8);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        String[] strArray2 = new String[] { "", "" };
        java.util.LinkedHashSet<String> strSet3 = new java.util.LinkedHashSet<String>();
        boolean boolean4 = java.util.Collections.addAll((java.util.Collection<String>) strSet3, strArray2);
        java.util.Spliterator<String> strSpliterator5 = strSet3.spliterator();
        com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet caseInsensitiveNameSet6 = com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet.construct((java.util.Set<String>) strSet3);
        String[] strArray9 = new String[] { "", "hi!" };
        java.util.ArrayList<String> strList10 = new java.util.ArrayList<String>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<String>) strList10, strArray9);
        java.util.stream.Stream<String> strStream12 = strList10.stream();
        boolean boolean13 = strSet3.containsAll((java.util.Collection<String>) strList10);
        org.junit.Assert.assertNotNull(strArray2);
        org.junit.Assert.assertArrayEquals(strArray2, new String[] { "", "" });
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(strSpliterator5);
        org.junit.Assert.assertNotNull(caseInsensitiveNameSet6);
        org.junit.Assert.assertNotNull(strArray9);
        org.junit.Assert.assertArrayEquals(strArray9, new String[] { "", "hi!" });
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNotNull(strStream12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        int int0 = com.fasterxml.jackson.core.base.GeneratorBase.SURR2_FIRST;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 56320 + "'", int0 == 56320);
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext xmlReadContext0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext xmlReadContext5 = new com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext(xmlReadContext0, 2, 100, (int) (byte) 100, 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchFieldError; message: _nestingDepth");
        } catch (NoSuchFieldError e) {
            // Expected exception.
        }
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        XmlNameProcessor xmlNameProcessor0 = XmlNameProcessors.newAlwaysOnBase64Processor();
        org.junit.Assert.assertNotNull(xmlNameProcessor0);
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_1 = null;
        org.codehaus.stax2.typed.Base64Variant base64Variant4 = null;
        byte[] byteArray11 = new byte[] { (byte) 10, (byte) 0, (byte) 0, (byte) 1, (byte) 100, (byte) 0 };
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_1, "", "hi_", base64Variant4, byteArray11, (int) (short) 10, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray11);
        org.junit.Assert.assertArrayEquals(byteArray11, new byte[] { (byte) 10, (byte) 0, (byte) 0, (byte) 1, (byte) 100, (byte) 0 });
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_3 = null;
        java.math.BigInteger bigInteger6 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_3, "", "hi_", bigInteger6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        String str0 = XmlFactory.FORMAT_NAME_XML;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "XML" + "'", str0, "XML");
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.json.JsonWriteFeature jsonWriteFeature3 = null;
        com.fasterxml.jackson.core.json.JsonWriteFeature jsonWriteFeature4 = null;
        com.fasterxml.jackson.core.json.JsonWriteFeature[] jsonWriteFeatureArray5 = new com.fasterxml.jackson.core.json.JsonWriteFeature[] { jsonWriteFeature4 };
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder6 = xmlFactoryBuilder2.disable(jsonWriteFeature3, jsonWriteFeatureArray5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertNotNull(jsonWriteFeatureArray5);
        org.junit.Assert.assertArrayEquals(jsonWriteFeatureArray5, new com.fasterxml.jackson.core.json.JsonWriteFeature[] { null });
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        int int0 = javax.xml.stream.XMLStreamConstants.START_ELEMENT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator1 = xmlFactoryBuilder0.inputDecorator();
        com.fasterxml.jackson.core.StreamWriteFeature streamWriteFeature2 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder3 = xmlFactoryBuilder0.disable(streamWriteFeature2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNull(inputDecorator1);
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        int int0 = javax.xml.stream.XMLStreamConstants.SPACE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 6 + "'", int0 == 6);
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        XmlFactory xmlFactory0 = new XmlFactory();
        // The following exception was thrown during execution in test generation
        try {
            XmlMapper.Builder builder1 = XmlMapper.builder(xmlFactory0);
            org.junit.Assert.fail("Expected exception of type java.lang.VerifyError; message: Bad return type?Exception Details:?  Location:?    com/fasterxml/jackson/databind/cfg/MapperBuilder.streamFactory()Lcom/fasterxml/jackson/core/TokenStreamFactory; @7: areturn?  Reason:?    Type 'com/fasterxml/jackson/core/JsonFactory' (current frame, stack[0]) is not assignable to 'com/fasterxml/jackson/core/TokenStreamFactory' (from method signature)?  Current Frame:?    bci: @7?    flags: { }?    locals: { 'com/fasterxml/jackson/databind/cfg/MapperBuilder' }?    stack: { 'com/fasterxml/jackson/core/JsonFactory' }?  Bytecode:?    0x0000000: 2ab4 0002 b600 08b0                    ?");
        } catch (VerifyError e) {
            // Expected exception.
        }
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        int int0 = javax.xml.stream.XMLStreamConstants.NAMESPACE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 13 + "'", int0 == 13);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser.Feature feature11 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactory xmlFactory13 = xmlFactory10.configure(feature11, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        int int0 = javax.xml.stream.XMLStreamConstants.CHARACTERS;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 4 + "'", int0 == 4);
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializerBase xmlBeanSerializerBase0 = null;
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer1 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.UnwrappingXmlBeanSerializer unwrappingXmlBeanSerializer2 = new com.fasterxml.jackson.dataformat.xml.ser.UnwrappingXmlBeanSerializer(xmlBeanSerializerBase0, nameTransformer1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        JacksonXmlModule jacksonXmlModule0 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlMapper xmlMapper1 = new XmlMapper(jacksonXmlModule0);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlMapper.coercionConfigDefaults()Lcom/fasterxml/jackson/databind/cfg/MutableCoercionConfig;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.beforeArrayValues(jsonGenerator1);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_3 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_3, "hi!", "hi!", 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder0.nameForTextElement("hi_");
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature6 = null;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature7 = null;
        com.fasterxml.jackson.core.json.JsonReadFeature[] jsonReadFeatureArray8 = new com.fasterxml.jackson.core.json.JsonReadFeature[] { jsonReadFeature7 };
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder9 = xmlFactoryBuilder0.enable(jsonReadFeature6, jsonReadFeatureArray8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertNotNull(jsonReadFeatureArray8);
        org.junit.Assert.assertArrayEquals(jsonReadFeatureArray8, new com.fasterxml.jackson.core.json.JsonReadFeature[] { null });
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        String str0 = org.codehaus.stax2.XMLStreamReader2.FEATURE_DTD_OVERRIDE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "org.codehaus.stax2.propDtdOverride" + "'", str0, "org.codehaus.stax2.propDtdOverride");
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        XmlFactory xmlFactory0 = new XmlFactory();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory2 = xmlFactory0.setOutputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.FormatSchema formatSchema3 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean4 = jsonFactory2.canUseSchema(formatSchema3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory2);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        int int0 = com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream.XML_ATTRIBUTE_VALUE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 4 + "'", int0 == 4);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.core.ObjectCodec objectCodec9 = xmlFactory6.getCodec();
        com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser.Feature feature10 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactory xmlFactory11 = xmlFactory6.disable(feature10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertNull(objectCodec9);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        XmlNameProcessor xmlNameProcessor0 = XmlNameProcessors.newReplacementProcessor();
        org.junit.Assert.assertNotNull(xmlNameProcessor0);
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        int int0 = com.fasterxml.jackson.core.base.GeneratorBase.SURR2_LAST;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 57343 + "'", int0 == 57343);
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        XmlFactory xmlFactory1 = new XmlFactory(objectCodec0);
        com.fasterxml.jackson.core.JsonFactory.Feature feature2 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonFactory jsonFactory4 = xmlFactory1.configure(feature2, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        XmlFactory xmlFactory0 = new XmlFactory();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory2 = xmlFactory0.setOutputDecorator(outputDecorator1);
        javax.xml.stream.XMLStreamWriter xMLStreamWriter3 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator toXmlGenerator4 = xmlFactory0.createGenerator(xMLStreamWriter3);
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonGenerationException; message: N/A");
        } catch (com.fasterxml.jackson.core.JsonGenerationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory2);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
        com.fasterxml.jackson.core.io.IOContext iOContext0 = null;
        com.fasterxml.jackson.core.ObjectCodec objectCodec3 = null;
        javax.xml.stream.XMLStreamWriter xMLStreamWriter4 = null;
        XmlNameProcessor xmlNameProcessor6 = XmlNameProcessors.newReplacementProcessor("hi_");
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator toXmlGenerator7 = new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator(iOContext0, 3, (int) (byte) -1, objectCodec3, xMLStreamWriter4, xmlNameProcessor6);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.core.base.GeneratorBase.<init>(ILcom/fasterxml/jackson/core/ObjectCodec;Lcom/fasterxml/jackson/core/io/IOContext;)V");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlNameProcessor6);
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        XmlFactory xmlFactory1 = new XmlFactory(objectCodec0);
        XmlNameProcessor xmlNameProcessor2 = xmlFactory1.getXmlNameProcessor();
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        xmlFactory1.setXMLInputFactory(xMLInputFactory3);
        com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser.Feature feature5 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactory xmlFactory7 = xmlFactory1.configure(feature5, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlNameProcessor2);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.StreamWriteFeature streamWriteFeature3 = null;
        com.fasterxml.jackson.core.StreamWriteFeature[] streamWriteFeatureArray4 = new com.fasterxml.jackson.core.StreamWriteFeature[] {};
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder0.disable(streamWriteFeature3, streamWriteFeatureArray4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertNotNull(streamWriteFeatureArray4);
        org.junit.Assert.assertArrayEquals(streamWriteFeatureArray4, new com.fasterxml.jackson.core.StreamWriteFeature[] {});
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        XmlFactory xmlFactory1 = new XmlFactory(objectCodec0);
        XmlNameProcessor xmlNameProcessor2 = xmlFactory1.getXmlNameProcessor();
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        xmlFactory1.setXMLInputFactory(xMLInputFactory3);
        byte[] byteArray6 = new byte[] { (byte) 1 };
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser9 = xmlFactory1.createParser(byteArray6, 56320, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlNameProcessor2);
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] { (byte) 1 });
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser.Feature feature1 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder3 = xmlFactoryBuilder0.configure(feature1, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        com.fasterxml.jackson.databind.ser.std.BeanSerializerBase beanSerializerBase0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializer xmlBeanSerializer1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializer(beanSerializerBase0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        XmlFactory xmlFactory0 = new XmlFactory();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory2 = xmlFactory0.setOutputDecorator(outputDecorator1);
        java.io.OutputStream outputStream3 = null;
        com.fasterxml.jackson.core.JsonEncoding jsonEncoding4 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator toXmlGenerator5 = xmlFactory0.createGenerator(outputStream3, jsonEncoding4);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlFactory._createContentReference(Ljava/lang/Object;)Lcom/fasterxml/jackson/core/io/ContentReference;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory2);
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        int int0 = javax.xml.stream.XMLStreamConstants.DTD;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 11 + "'", int0 == 11);
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        defaultXmlPrettyPrinter0.writeEndArray(jsonGenerator3, (int) (byte) 0);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator6 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator6);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator8 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeStartObject(jsonGenerator8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        String str11 = xmlFactory6.getXMLTextElementName();
        byte[] byteArray16 = new byte[] { (byte) 0, (byte) -1, (byte) -1, (byte) 100 };
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser17 = xmlFactory6.createJsonParser(byteArray16);
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Invalid byte 1 of 1-byte UTF-8 sequence.");
        } catch (com.fasterxml.jackson.core.JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "" + "'", str11, "");
        org.junit.Assert.assertNotNull(byteArray16);
        org.junit.Assert.assertArrayEquals(byteArray16, new byte[] { (byte) 0, (byte) -1, (byte) -1, (byte) 100 });
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        String str11 = xmlFactory6.getXMLTextElementName();
        boolean boolean12 = xmlFactory6.canHandleBinaryNatively();
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "" + "'", str11, "");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_5 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_5, "hi_", "hi!", 3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        XmlFactory xmlFactory1 = new XmlFactory(objectCodec0);
        XmlNameProcessor xmlNameProcessor2 = xmlFactory1.getXmlNameProcessor();
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        xmlFactory1.setXMLInputFactory(xMLInputFactory3);
        com.fasterxml.jackson.core.JsonGenerator.Feature feature5 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonFactory jsonFactory6 = xmlFactory1.disable(feature5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlNameProcessor2);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.StreamWriteConstraints streamWriteConstraints3 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder4 = xmlFactoryBuilder2.streamWriteConstraints(streamWriteConstraints3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.StreamWriteFeature streamWriteFeature3 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder4 = xmlFactoryBuilder2.disable(streamWriteFeature3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        String str11 = xmlFactory6.getXMLTextElementName();
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator12 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory13 = xmlFactory6.setInputDecorator(inputDecorator12);
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "" + "'", str11, "");
        org.junit.Assert.assertNotNull(jsonFactory13);
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        javax.xml.stream.XMLStreamException xMLStreamException0 = null;
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        // The following exception was thrown during execution in test generation
        try {
            Comparable<String> strComparable2 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.throwAsGenerationException(xMLStreamException0, jsonGenerator1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
        defaultXmlPrettyPrinter0.beforeObjectEntries(jsonGenerator5);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_7 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_7, "XML", "org.codehaus.stax2.propDtdOverride", (-1.0d));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializerBase xmlBeanSerializerBase0 = null;
        com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter objectIdWriter1 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializer xmlBeanSerializer2 = new com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializer(xmlBeanSerializerBase0, objectIdWriter1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator5);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_7 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_7, "XML", "XML", "hi!", false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        XmlFactory xmlFactory1 = new XmlFactory(objectCodec0);
        String str2 = xmlFactory1.getFormatName();
        java.io.OutputStream outputStream3 = null;
        com.fasterxml.jackson.core.JsonEncoding jsonEncoding4 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator toXmlGenerator5 = xmlFactory1.createGenerator(outputStream3, jsonEncoding4);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlFactory._createContentReference(Ljava/lang/Object;)Lcom/fasterxml/jackson/core/io/ContentReference;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "XML" + "'", str2, "XML");
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        JacksonXmlModule jacksonXmlModule0 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers1 = null;
        jacksonXmlModule0.setKeySerializers(simpleSerializers1);
        com.fasterxml.jackson.databind.Module.SetupContext setupContext3 = null;
        // The following exception was thrown during execution in test generation
        try {
            jacksonXmlModule0.setupModule(setupContext3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        Object obj0 = com.fasterxml.jackson.databind.ser.BeanPropertyWriter.MARKER_FOR_EMPTY;
        org.junit.Assert.assertTrue("'" + obj0 + "' != '" + com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY + "'", obj0.equals(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY));
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        XmlFactory xmlFactory1 = new XmlFactory(objectCodec0);
        java.io.OutputStream outputStream2 = null;
        com.fasterxml.jackson.core.JsonEncoding jsonEncoding3 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator toXmlGenerator4 = xmlFactory1.createGenerator(outputStream2, jsonEncoding3);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlFactory._createContentReference(Ljava/lang/Object;)Lcom/fasterxml/jackson/core/io/ContentReference;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        int int0 = com.fasterxml.jackson.core.base.GeneratorBase.SURR1_FIRST;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 55296 + "'", int0 == 55296);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder0.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature6 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature7 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean9 = feature7.enabledIn((int) '#');
        com.fasterxml.jackson.core.ObjectCodec objectCodec10 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory13 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory14 = null;
        XmlFactory xmlFactory16 = new XmlFactory(objectCodec10, (int) 'a', 10, xMLInputFactory13, xMLOutputFactory14, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator17 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory18 = xmlFactory16.setOutputDecorator(outputDecorator17);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature19 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory20 = xmlFactory16.disable(feature19);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature21 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature22 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] featureArray23 = new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { feature7, feature19, feature21, feature22 };
        XmlFactoryBuilder xmlFactoryBuilder24 = xmlFactoryBuilder5.disable(feature6, featureArray23);
        com.fasterxml.jackson.core.StreamWriteConstraints streamWriteConstraints25 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder26 = xmlFactoryBuilder5.streamWriteConstraints(streamWriteConstraints25);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertTrue("'" + feature6 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature6.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + feature7 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature7.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(jsonFactory18);
        org.junit.Assert.assertTrue("'" + feature19 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature19.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory20);
        org.junit.Assert.assertTrue("'" + feature21 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature21.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertTrue("'" + feature22 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature22.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(featureArray23);
        org.junit.Assert.assertArrayEquals(featureArray23, new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 });
        org.junit.Assert.assertNotNull(xmlFactoryBuilder24);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        java.io.Reader reader7 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser8 = xmlFactory6.createJsonParser(reader7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        int int0 = javax.xml.stream.XMLStreamConstants.END_DOCUMENT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 8 + "'", int0 == 8);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        ClassLoader classLoader0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory1 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader0);
        javax.xml.stream.XMLOutputFactory xMLOutputFactory2 = null;
        XmlFactory xmlFactory3 = new XmlFactory(xMLInputFactory1, xMLOutputFactory2);
        com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser.Feature feature4 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactory xmlFactory6 = xmlFactory3.configure(feature4, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xMLInputFactory1);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        com.fasterxml.jackson.dataformat.xml.ser.UnwrappingXmlBeanSerializer unwrappingXmlBeanSerializer0 = null;
        com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter objectIdWriter1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator3 = null;
        XmlFactoryBuilder xmlFactoryBuilder4 = xmlFactoryBuilder2.outputDecorator(outputDecorator3);
        int int5 = xmlFactoryBuilder2.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder7 = xmlFactoryBuilder2.nameForTextElement("hi_");
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.UnwrappingXmlBeanSerializer unwrappingXmlBeanSerializer8 = new com.fasterxml.jackson.dataformat.xml.ser.UnwrappingXmlBeanSerializer(unwrappingXmlBeanSerializer0, objectIdWriter1, (Object) xmlFactoryBuilder7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 4 + "'", int5 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder7);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator3);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_5 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_5, "JSON", "", (float) 13);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        defaultXmlPrettyPrinter0.writeEndArray(jsonGenerator3, (int) (byte) 0);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_6 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafXsiNilElement(xMLStreamWriter2_6, "XML", "XML");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        javax.xml.stream.XMLStreamWriter xMLStreamWriter7 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator toXmlGenerator8 = xmlFactory6.createGenerator(xMLStreamWriter7);
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonGenerationException; message: N/A");
        } catch (com.fasterxml.jackson.core.JsonGenerationException e) {
            // Expected exception.
        }
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter.Indenter indenter5 = null;
        defaultXmlPrettyPrinter4.indentObjectsWith(indenter5);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator7 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter4.writeStartObject(jsonGenerator7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        XmlFactory xmlFactory1 = new XmlFactory(objectCodec0);
        XmlNameProcessor xmlNameProcessor2 = xmlFactory1.getXmlNameProcessor();
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        xmlFactory1.setXMLInputFactory(xMLInputFactory3);
        com.fasterxml.jackson.core.JsonFactory.Feature feature5 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonFactory jsonFactory6 = xmlFactory1.disable(feature5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlNameProcessor2);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder0.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser.Feature feature6 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder7 = xmlFactoryBuilder5.enable(feature6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.StreamReadFeature streamReadFeature1 = null;
        com.fasterxml.jackson.core.StreamReadFeature[] streamReadFeatureArray2 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder3 = xmlFactoryBuilder0.enable(streamReadFeature1, streamReadFeatureArray2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.factoryFeaturesMask();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature4 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder0.enable(jsonReadFeature4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 15 + "'", int3 == 15);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_5 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter4.writeLeafElement(xMLStreamWriter2_5, "", "", "JSON", false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_5 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter4.writeStartElement(xMLStreamWriter2_5, "JSON", "JSON");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_5 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter4.writeLeafElement(xMLStreamWriter2_5, "", "", (long) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator3 = null;
        XmlFactoryBuilder xmlFactoryBuilder4 = xmlFactoryBuilder0.inputDecorator(inputDecorator3);
        XmlFactoryBuilder xmlFactoryBuilder5 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator6 = xmlFactoryBuilder5.inputDecorator();
        ClassLoader classLoader7 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory8 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader7);
        XmlFactoryBuilder xmlFactoryBuilder9 = xmlFactoryBuilder5.inputFactory(xMLInputFactory8);
        XmlFactoryBuilder xmlFactoryBuilder10 = xmlFactoryBuilder4.inputFactory(xMLInputFactory8);
        com.fasterxml.jackson.core.StreamWriteFeature streamWriteFeature11 = null;
        com.fasterxml.jackson.core.StreamWriteFeature streamWriteFeature12 = null;
        com.fasterxml.jackson.core.StreamWriteFeature[] streamWriteFeatureArray13 = new com.fasterxml.jackson.core.StreamWriteFeature[] { streamWriteFeature12 };
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder14 = xmlFactoryBuilder10.enable(streamWriteFeature11, streamWriteFeatureArray13);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertNull(inputDecorator6);
        org.junit.Assert.assertNotNull(xMLInputFactory8);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder9);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder10);
        org.junit.Assert.assertNotNull(streamWriteFeatureArray13);
        org.junit.Assert.assertArrayEquals(streamWriteFeatureArray13, new com.fasterxml.jackson.core.StreamWriteFeature[] { null });
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeArrayValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("hi!");
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_5 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_5, "hi!", "JSON", false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        int int0 = com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream.XML_ATTRIBUTE_NAME;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 3 + "'", int0 == 3);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        XmlFactory xmlFactory0 = new XmlFactory();
        xmlFactory0.setXMLTextElementName("XML");
        xmlFactory0.setXMLTextElementName("JSON");
        com.fasterxml.jackson.core.JsonParser.Feature feature5 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonFactory jsonFactory7 = xmlFactory0.configure(feature5, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        com.fasterxml.jackson.core.io.CharacterEscapes characterEscapes11 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory12 = xmlFactory10.setCharacterEscapes(characterEscapes11);
        byte[] byteArray18 = new byte[] { (byte) 1, (byte) -1, (byte) 1, (byte) 0, (byte) -1 };
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser21 = jsonFactory12.createParser(byteArray18, (int) (short) 10, (int) (short) -1);
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: ParseError at [row,col]:[1,1]?Message: Premature end of file.");
        } catch (com.fasterxml.jackson.core.JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertNotNull(jsonFactory12);
        org.junit.Assert.assertNotNull(byteArray18);
        org.junit.Assert.assertArrayEquals(byteArray18, new byte[] { (byte) 1, (byte) -1, (byte) 1, (byte) 0, (byte) -1 });
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
        defaultXmlPrettyPrinter4.writeObjectEntrySeparator(jsonGenerator5);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_7 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter4.writePrologLinefeed(xMLStreamWriter2_7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        Class<com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature> featureClass11 = xmlFactory6.getFormatWriteFeatureType();
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser13 = xmlFactory6.createParser("JSON");
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlFactory._createContentReference(Ljava/lang/Object;)Lcom/fasterxml/jackson/core/io/ContentReference;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertNotNull(featureClass11);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext xmlReadContext0 = com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext.createRootContext();
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchFieldError; message: _nestingDepth");
        } catch (NoSuchFieldError e) {
            // Expected exception.
        }
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator3 = null;
        XmlFactoryBuilder xmlFactoryBuilder4 = xmlFactoryBuilder0.inputDecorator(inputDecorator3);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature5 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder6 = xmlFactoryBuilder4.disable(jsonReadFeature5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder4);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        byte[] byteArray11 = new byte[] { (byte) 100, (byte) -1, (byte) 0, (byte) 100 };
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser12 = xmlFactory6.createJsonParser(byteArray11);
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: Invalid byte 1 of 1-byte UTF-8 sequence.");
        } catch (com.fasterxml.jackson.core.JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray11);
        org.junit.Assert.assertArrayEquals(byteArray11, new byte[] { (byte) 100, (byte) -1, (byte) 0, (byte) 100 });
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        defaultXmlPrettyPrinter0.writeEndArray(jsonGenerator3, (int) (byte) 0);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_6 = null;
        char[] charArray11 = new char[] { ' ', ' ' };
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_6, "org.codehaus.stax2.propDtdOverride", "XML", charArray11, 8, 100, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(charArray11);
        org.junit.Assert.assertArrayEquals(charArray11, new char[] { ' ', ' ' });
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test125");
        JacksonXmlModule jacksonXmlModule0 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers1 = null;
        jacksonXmlModule0.setKeySerializers(simpleSerializers1);
        Class[] classArray4 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray5 = (Class<?>[]) classArray4;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule6 = jacksonXmlModule0.registerSubtypes((Class<?>[]) classArray4);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver7 = null;
        jacksonXmlModule0.setAbstractTypes(simpleAbstractTypeResolver7);
        jacksonXmlModule0.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.BeanSerializerModifier beanSerializerModifier11 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule12 = jacksonXmlModule0.setSerializerModifier(beanSerializerModifier11);
        com.fasterxml.jackson.databind.module.SimpleKeyDeserializers simpleKeyDeserializers13 = null;
        simpleModule12.setKeyDeserializers(simpleKeyDeserializers13);
        org.junit.Assert.assertNotNull(classArray4);
        org.junit.Assert.assertArrayEquals(classArray4, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray5);
        org.junit.Assert.assertArrayEquals(wildcardClassArray5, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule6);
        org.junit.Assert.assertNotNull(simpleModule12);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test126");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        com.fasterxml.jackson.core.ObjectCodec objectCodec11 = xmlFactory10.getCodec();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator12 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory13 = xmlFactory10.setOutputDecorator(outputDecorator12);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser15 = jsonFactory13.createJsonParser("org.codehaus.stax2.propDtdOverride");
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlFactory._createContentReference(Ljava/lang/Object;)Lcom/fasterxml/jackson/core/io/ContentReference;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertNull(objectCodec11);
        org.junit.Assert.assertNotNull(jsonFactory13);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test127");
        com.fasterxml.jackson.databind.deser.BeanDeserializerBase beanDeserializerBase0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.deser.XmlTextDeserializer xmlTextDeserializer2 = new com.fasterxml.jackson.dataformat.xml.deser.XmlTextDeserializer(beanDeserializerBase0, (int) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test128");
        String[] strArray2 = new String[] { "", "" };
        java.util.LinkedHashSet<String> strSet3 = new java.util.LinkedHashSet<String>();
        boolean boolean4 = java.util.Collections.addAll((java.util.Collection<String>) strSet3, strArray2);
        java.util.Spliterator<String> strSpliterator5 = strSet3.spliterator();
        strSet3.clear();
        org.junit.Assert.assertNotNull(strArray2);
        org.junit.Assert.assertArrayEquals(strArray2, new String[] { "", "" });
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(strSpliterator5);
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test129");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.core.ObjectCodec objectCodec2 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory5 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory6 = null;
        XmlFactory xmlFactory8 = new XmlFactory(objectCodec2, (int) 'a', 10, xMLInputFactory5, xMLOutputFactory6, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator9 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory10 = xmlFactory8.setOutputDecorator(outputDecorator9);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature11 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory12 = xmlFactory8.disable(feature11);
        Class<com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature> featureClass13 = xmlFactory8.getFormatWriteFeatureType();
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer14 = xmlSerializerProvider1.findValueSerializer(featureClass13);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory10);
        org.junit.Assert.assertTrue("'" + feature11 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature11.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory12);
        org.junit.Assert.assertNotNull(featureClass13);
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test130");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.core.io.CharacterEscapes characterEscapes9 = xmlFactory6.getCharacterEscapes();
        java.io.File file10 = null;
        com.fasterxml.jackson.core.JsonEncoding jsonEncoding11 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator toXmlGenerator12 = xmlFactory6.createGenerator(file10, jsonEncoding11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertNull(characterEscapes9);
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test131");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeArrayValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("hi!");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
        defaultXmlPrettyPrinter0.writeObjectEntrySeparator(jsonGenerator5);
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test132");
        com.fasterxml.jackson.databind.deser.BeanDeserializerBase beanDeserializerBase0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.deser.XmlTextDeserializer xmlTextDeserializer2 = new com.fasterxml.jackson.dataformat.xml.deser.XmlTextDeserializer(beanDeserializerBase0, 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test133");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        com.fasterxml.jackson.databind.JavaType javaType3 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer4 = defaultSerializerProvider2.findTypeSerializer(javaType3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test134");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator3 = null;
        XmlFactoryBuilder xmlFactoryBuilder4 = xmlFactoryBuilder0.inputDecorator(inputDecorator3);
        XmlFactoryBuilder xmlFactoryBuilder5 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator6 = xmlFactoryBuilder5.inputDecorator();
        ClassLoader classLoader7 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory8 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader7);
        XmlFactoryBuilder xmlFactoryBuilder9 = xmlFactoryBuilder5.inputFactory(xMLInputFactory8);
        XmlFactoryBuilder xmlFactoryBuilder10 = xmlFactoryBuilder4.inputFactory(xMLInputFactory8);
        com.fasterxml.jackson.core.json.JsonWriteFeature jsonWriteFeature11 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder12 = xmlFactoryBuilder10.enable(jsonWriteFeature11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertNull(inputDecorator6);
        org.junit.Assert.assertNotNull(xMLInputFactory8);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder9);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder10);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test135");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.nameForTextElement("");
        com.fasterxml.jackson.core.JsonFactory.Feature feature3 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder4 = xmlFactoryBuilder2.disable(feature3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test136");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
        // The following exception was thrown during execution in test generation
        try {
            xmlSerializerProvider1.defaultSerializeField("hi!", (Object) 100, jsonGenerator5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test137");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        java.io.Writer writer9 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonGenerator jsonGenerator10 = jsonFactory8.createJsonGenerator(writer9);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlFactory._createContentReference(Ljava/lang/Object;)Lcom/fasterxml/jackson/core/io/ContentReference;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test138");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator3 = null;
        XmlFactoryBuilder xmlFactoryBuilder4 = xmlFactoryBuilder0.inputDecorator(inputDecorator3);
        XmlFactoryBuilder xmlFactoryBuilder5 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator6 = xmlFactoryBuilder5.inputDecorator();
        ClassLoader classLoader7 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory8 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader7);
        XmlFactoryBuilder xmlFactoryBuilder9 = xmlFactoryBuilder5.inputFactory(xMLInputFactory8);
        XmlFactoryBuilder xmlFactoryBuilder10 = xmlFactoryBuilder4.inputFactory(xMLInputFactory8);
        com.fasterxml.jackson.core.StreamWriteFeature streamWriteFeature11 = null;
        com.fasterxml.jackson.core.StreamWriteFeature[] streamWriteFeatureArray12 = new com.fasterxml.jackson.core.StreamWriteFeature[] {};
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder13 = xmlFactoryBuilder10.enable(streamWriteFeature11, streamWriteFeatureArray12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertNull(inputDecorator6);
        org.junit.Assert.assertNotNull(xMLInputFactory8);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder9);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder10);
        org.junit.Assert.assertNotNull(streamWriteFeatureArray12);
        org.junit.Assert.assertArrayEquals(streamWriteFeatureArray12, new com.fasterxml.jackson.core.StreamWriteFeature[] {});
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test139");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        defaultXmlPrettyPrinter0.writeEndArray(jsonGenerator3, (int) (byte) 0);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator6 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator6);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator8 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeRootValueSeparator(jsonGenerator8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test140");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
        defaultXmlPrettyPrinter4.writeObjectEntrySeparator(jsonGenerator5);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_7 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter4.writeLeafElement(xMLStreamWriter2_7, "org.codehaus.stax2.propDtdOverride", "org.codehaus.stax2.propDtdOverride", "org.codehaus.stax2.propDtdOverride", true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test141");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator2 = null;
        XmlFactory xmlFactory3 = new XmlFactory();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator4 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory5 = xmlFactory3.setOutputDecorator(outputDecorator4);
        // The following exception was thrown during execution in test generation
        try {
            xmlSerializerProvider1.serializeValue(jsonGenerator2, (Object) xmlFactory3);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchFieldError; message: _generator");
        } catch (NoSuchFieldError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory5);
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test142");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator3 = xmlFactoryBuilder0.inputDecorator();
        com.fasterxml.jackson.core.StreamWriteFeature streamWriteFeature4 = null;
        com.fasterxml.jackson.core.StreamWriteFeature streamWriteFeature5 = null;
        com.fasterxml.jackson.core.StreamWriteFeature[] streamWriteFeatureArray6 = new com.fasterxml.jackson.core.StreamWriteFeature[] { streamWriteFeature5 };
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder7 = xmlFactoryBuilder0.enable(streamWriteFeature4, streamWriteFeatureArray6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertNull(inputDecorator3);
        org.junit.Assert.assertNotNull(streamWriteFeatureArray6);
        org.junit.Assert.assertArrayEquals(streamWriteFeatureArray6, new com.fasterxml.jackson.core.StreamWriteFeature[] { null });
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test143");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        com.fasterxml.jackson.core.ObjectCodec objectCodec3 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory6 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory7 = null;
        XmlFactory xmlFactory9 = new XmlFactory(objectCodec3, (int) 'a', 10, xMLInputFactory6, xMLOutputFactory7, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator10 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory11 = xmlFactory9.setOutputDecorator(outputDecorator10);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature12 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory13 = xmlFactory9.disable(feature12);
        Class<com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature> featureClass14 = xmlFactory9.getFormatWriteFeatureType();
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.jsonschema.JsonSchema jsonSchema15 = defaultSerializerProvider2.generateJsonSchema(featureClass14);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(jsonFactory11);
        org.junit.Assert.assertTrue("'" + feature12 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature12.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory13);
        org.junit.Assert.assertNotNull(featureClass14);
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test144");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        String str11 = xmlFactory10.getFormatName();
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "XML" + "'", str11, "XML");
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test145");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator3);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_5 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writePrologLinefeed(xMLStreamWriter2_5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test146");
        String[] strArray2 = new String[] { "", "" };
        java.util.LinkedHashSet<String> strSet3 = new java.util.LinkedHashSet<String>();
        boolean boolean4 = java.util.Collections.addAll((java.util.Collection<String>) strSet3, strArray2);
        java.util.Spliterator<String> strSpliterator5 = strSet3.spliterator();
        com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet caseInsensitiveNameSet6 = com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet.construct((java.util.Set<String>) strSet3);
        java.util.Iterator<String> strItor7 = caseInsensitiveNameSet6.iterator();
        int int8 = caseInsensitiveNameSet6.size();
        org.junit.Assert.assertNotNull(strArray2);
        org.junit.Assert.assertArrayEquals(strArray2, new String[] { "", "" });
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(strSpliterator5);
        org.junit.Assert.assertNotNull(caseInsensitiveNameSet6);
        org.junit.Assert.assertNotNull(strItor7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 1 + "'", int8 == 1);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test147");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        defaultXmlPrettyPrinter0.writeEndArray(jsonGenerator3, (int) (byte) 0);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator6 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator6);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter9 = defaultXmlPrettyPrinter0.withCustomNewLine("XML");
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_10 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter9.writeLeafNullElement(xMLStreamWriter2_10, "org.codehaus.stax2.propDtdOverride", "JSON");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter9);
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test148");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_5 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_5, "org.codehaus.stax2.propDtdOverride", "org.codehaus.stax2.propDtdOverride", (int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test149");
        com.fasterxml.jackson.dataformat.xml.util.XmlInfo xmlInfo4 = new com.fasterxml.jackson.dataformat.xml.util.XmlInfo((Boolean) false, "JSON", (Boolean) true, (Boolean) true);
        String str5 = xmlInfo4.getNamespace();
        boolean boolean6 = xmlInfo4.isAttribute();
        boolean boolean7 = xmlInfo4.isAttribute();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "JSON" + "'", str5, "JSON");
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test150");
        com.fasterxml.jackson.databind.deser.BeanDeserializerBase beanDeserializerBase0 = null;
        com.fasterxml.jackson.databind.deser.SettableBeanProperty settableBeanProperty1 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.deser.XmlTextDeserializer xmlTextDeserializer2 = new com.fasterxml.jackson.dataformat.xml.deser.XmlTextDeserializer(beanDeserializerBase0, settableBeanProperty1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test151");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator5);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_7 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_7, "JSON", "", (double) 15);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test152");
        JacksonXmlModule jacksonXmlModule0 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers1 = null;
        jacksonXmlModule0.setKeySerializers(simpleSerializers1);
        Class[] classArray4 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray5 = (Class<?>[]) classArray4;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule6 = jacksonXmlModule0.registerSubtypes((Class<?>[]) classArray4);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver7 = null;
        jacksonXmlModule0.setAbstractTypes(simpleAbstractTypeResolver7);
        jacksonXmlModule0.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.BeanSerializerModifier beanSerializerModifier11 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule12 = jacksonXmlModule0.setSerializerModifier(beanSerializerModifier11);
        com.fasterxml.jackson.databind.module.SimpleValueInstantiators simpleValueInstantiators13 = null;
        simpleModule12.setValueInstantiators(simpleValueInstantiators13);
        org.junit.Assert.assertNotNull(classArray4);
        org.junit.Assert.assertArrayEquals(classArray4, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray5);
        org.junit.Assert.assertArrayEquals(wildcardClassArray5, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule6);
        org.junit.Assert.assertNotNull(simpleModule12);
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test153");
        XmlFactory xmlFactory0 = new XmlFactory();
        java.io.OutputStream outputStream1 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator toXmlGenerator2 = xmlFactory0.createGenerator(outputStream1);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlFactory._createContentReference(Ljava/lang/Object;)Lcom/fasterxml/jackson/core/io/ContentReference;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test154");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer3 = defaultSerializerProvider2.getDefaultNullKeySerializer();
        com.fasterxml.jackson.core.ObjectCodec objectCodec4 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory7 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory8 = null;
        XmlFactory xmlFactory10 = new XmlFactory(objectCodec4, (int) 'a', 10, xMLInputFactory7, xMLOutputFactory8, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator11 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory12 = xmlFactory10.setOutputDecorator(outputDecorator11);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature13 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory14 = xmlFactory10.disable(feature13);
        Class<com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature> featureClass15 = xmlFactory10.getFormatWriteFeatureType();
        com.fasterxml.jackson.databind.BeanProperty beanProperty16 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer17 = defaultSerializerProvider2.findKeySerializer(featureClass15, beanProperty16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(objJsonSerializer3);
        org.junit.Assert.assertNotNull(jsonFactory12);
        org.junit.Assert.assertTrue("'" + feature13 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature13.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory14);
        org.junit.Assert.assertNotNull(featureClass15);
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test155");
        com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext xmlReadContext0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext xmlReadContext4 = new com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext(xmlReadContext0, (int) (short) -1, 6, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchFieldError; message: _nestingDepth");
        } catch (NoSuchFieldError e) {
            // Expected exception.
        }
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test156");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        com.fasterxml.jackson.databind.SerializationConfig serializationConfig3 = null;
        com.fasterxml.jackson.databind.ser.SerializerFactory serializerFactory4 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider5 = xmlSerializerProvider1.createInstance(serializationConfig3, serializerFactory4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test157");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.json.JsonWriteFeature jsonWriteFeature3 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder2.configure(jsonWriteFeature3, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test158");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        defaultXmlPrettyPrinter0.writeEndArray(jsonGenerator3, (int) (byte) 0);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator6 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator6);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_8 = null;
        org.codehaus.stax2.typed.Base64Variant base64Variant11 = null;
        byte[] byteArray16 = new byte[] { (byte) 1, (byte) 1, (byte) 1, (byte) 0 };
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_8, "", "org.codehaus.stax2.propDtdOverride", base64Variant11, byteArray16, (-1), 5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray16);
        org.junit.Assert.assertArrayEquals(byteArray16, new byte[] { (byte) 1, (byte) 1, (byte) 1, (byte) 0 });
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test159");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.core.ObjectCodec objectCodec2 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory5 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory6 = null;
        XmlFactory xmlFactory8 = new XmlFactory(objectCodec2, (int) 'a', 10, xMLInputFactory5, xMLOutputFactory6, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator9 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory10 = xmlFactory8.setOutputDecorator(outputDecorator9);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature11 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory12 = xmlFactory8.disable(feature11);
        Class<com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature> featureClass13 = xmlFactory8.getFormatWriteFeatureType();
        com.fasterxml.jackson.databind.BeanProperty beanProperty15 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer16 = xmlSerializerProvider1.findTypedValueSerializer(featureClass13, true, beanProperty15);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory10);
        org.junit.Assert.assertTrue("'" + feature11 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature11.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory12);
        org.junit.Assert.assertNotNull(featureClass13);
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test160");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        XmlFactory xmlFactory1 = new XmlFactory(objectCodec0);
        String str2 = xmlFactory1.getFormatName();
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder3 = xmlFactory1.rebuild();
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchFieldError; message: _streamReadConstraints");
        } catch (NoSuchFieldError e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "XML" + "'", str2, "XML");
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test161");
        ClassLoader classLoader0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory1 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader0);
        javax.xml.stream.XMLOutputFactory xMLOutputFactory2 = null;
        XmlFactory xmlFactory3 = new XmlFactory(xMLInputFactory1, xMLOutputFactory2);
        com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser.Feature feature4 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactory xmlFactory6 = xmlFactory3.configure(feature4, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xMLInputFactory1);
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test162");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator3 = xmlFactoryBuilder0.inputDecorator();
        ClassLoader classLoader4 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory5 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader4);
        XmlFactoryBuilder xmlFactoryBuilder6 = xmlFactoryBuilder0.inputFactory(xMLInputFactory5);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature7 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder8 = xmlFactoryBuilder6.disable(jsonReadFeature7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertNull(inputDecorator3);
        org.junit.Assert.assertNotNull(xMLInputFactory5);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder6);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test163");
        // The following exception was thrown during execution in test generation
        try {
            XmlMapper.Builder builder0 = XmlMapper.xmlBuilder();
            org.junit.Assert.fail("Expected exception of type java.lang.VerifyError; message: Bad return type?Exception Details:?  Location:?    com/fasterxml/jackson/databind/cfg/MapperBuilder.streamFactory()Lcom/fasterxml/jackson/core/TokenStreamFactory; @7: areturn?  Reason:?    Type 'com/fasterxml/jackson/core/JsonFactory' (current frame, stack[0]) is not assignable to 'com/fasterxml/jackson/core/TokenStreamFactory' (from method signature)?  Current Frame:?    bci: @7?    flags: { }?    locals: { 'com/fasterxml/jackson/databind/cfg/MapperBuilder' }?    stack: { 'com/fasterxml/jackson/core/JsonFactory' }?  Bytecode:?    0x0000000: 2ab4 0002 b600 08b0                    ?");
        } catch (VerifyError e) {
            // Expected exception.
        }
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test164");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator1 = xmlFactoryBuilder0.inputDecorator();
        com.fasterxml.jackson.core.json.JsonWriteFeature jsonWriteFeature2 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder3 = xmlFactoryBuilder0.disable(jsonWriteFeature2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNull(inputDecorator1);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test165");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator3 = null;
        XmlFactoryBuilder xmlFactoryBuilder4 = xmlFactoryBuilder0.inputDecorator(inputDecorator3);
        com.fasterxml.jackson.core.json.JsonWriteFeature jsonWriteFeature5 = null;
        com.fasterxml.jackson.core.json.JsonWriteFeature jsonWriteFeature6 = null;
        com.fasterxml.jackson.core.json.JsonWriteFeature[] jsonWriteFeatureArray7 = new com.fasterxml.jackson.core.json.JsonWriteFeature[] { jsonWriteFeature6 };
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder8 = xmlFactoryBuilder4.enable(jsonWriteFeature5, jsonWriteFeatureArray7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder4);
        org.junit.Assert.assertNotNull(jsonWriteFeatureArray7);
        org.junit.Assert.assertArrayEquals(jsonWriteFeatureArray7, new com.fasterxml.jackson.core.json.JsonWriteFeature[] { null });
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test166");
        javax.xml.stream.XMLStreamException xMLStreamException0 = null;
        com.fasterxml.jackson.core.JsonParser jsonParser1 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.reflect.GenericDeclaration genericDeclaration2 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.throwAsParseException(xMLStreamException0, jsonParser1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test167");
        ClassLoader classLoader0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory1 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader0);
        javax.xml.stream.XMLOutputFactory xMLOutputFactory2 = null;
        XmlFactory xmlFactory3 = new XmlFactory(xMLInputFactory1, xMLOutputFactory2);
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory5 = new XmlFactory(xMLInputFactory1, xMLOutputFactory4);
        java.io.File file6 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser7 = xmlFactory5.createParser(file6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xMLInputFactory1);
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test168");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        com.fasterxml.jackson.core.io.CharacterEscapes characterEscapes11 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory12 = xmlFactory10.setCharacterEscapes(characterEscapes11);
        com.fasterxml.jackson.core.JsonFactory.Feature feature13 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonFactory jsonFactory15 = jsonFactory12.configure(feature13, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertNotNull(jsonFactory12);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test169");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        XmlFactory xmlFactory1 = new XmlFactory(objectCodec0);
        String str2 = xmlFactory1.getFormatName();
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature3 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        XmlFactory xmlFactory4 = xmlFactory1.enable(feature3);
        com.fasterxml.jackson.core.ObjectCodec objectCodec5 = xmlFactory1.getCodec();
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "XML" + "'", str2, "XML");
        org.junit.Assert.assertTrue("'" + feature3 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature3.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(xmlFactory4);
        org.junit.Assert.assertNull(objectCodec5);
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test170");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.formatParserFeaturesMask();
        int int4 = xmlFactoryBuilder0.formatGeneratorFeaturesMask();
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature5 = null;
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature6 = null;
        com.fasterxml.jackson.core.json.JsonReadFeature[] jsonReadFeatureArray7 = new com.fasterxml.jackson.core.json.JsonReadFeature[] { jsonReadFeature6 };
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder8 = xmlFactoryBuilder0.disable(jsonReadFeature5, jsonReadFeatureArray7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(jsonReadFeatureArray7);
        org.junit.Assert.assertArrayEquals(jsonReadFeatureArray7, new com.fasterxml.jackson.core.json.JsonReadFeature[] { null });
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test171");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        String str11 = xmlFactory6.getXMLTextElementName();
        com.fasterxml.jackson.core.ObjectCodec objectCodec12 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory13 = xmlFactory6.setCodec(objectCodec12);
        java.net.URL uRL14 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser15 = xmlFactory6.createParser(uRL14);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "" + "'", str11, "");
        org.junit.Assert.assertNotNull(jsonFactory13);
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test172");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        com.fasterxml.jackson.databind.BeanProperty beanProperty3 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer4 = defaultSerializerProvider2.findNullValueSerializer(beanProperty3);
        com.fasterxml.jackson.databind.MapperFeature mapperFeature5 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean6 = defaultSerializerProvider2.isEnabled(mapperFeature5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(objJsonSerializer4);
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test173");
        JacksonXmlModule jacksonXmlModule0 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.jsontype.NamedType namedType1 = null;
        com.fasterxml.jackson.databind.jsontype.NamedType[] namedTypeArray2 = new com.fasterxml.jackson.databind.jsontype.NamedType[] { namedType1 };
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule3 = jacksonXmlModule0.registerSubtypes(namedTypeArray2);
        com.fasterxml.jackson.databind.module.SimpleDeserializers simpleDeserializers4 = null;
        simpleModule3.setDeserializers(simpleDeserializers4);
        org.junit.Assert.assertNotNull(namedTypeArray2);
        org.junit.Assert.assertArrayEquals(namedTypeArray2, new com.fasterxml.jackson.databind.jsontype.NamedType[] { null });
        org.junit.Assert.assertNotNull(simpleModule3);
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test174");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.beforeArrayValues(jsonGenerator1);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_3 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_3, "org.codehaus.stax2.propDtdOverride", "JSON", (long) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test175");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.nameForTextElement("");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature3 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean4 = feature3.enabledByDefault();
        XmlFactoryBuilder xmlFactoryBuilder5 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator6 = null;
        XmlFactoryBuilder xmlFactoryBuilder7 = xmlFactoryBuilder5.outputDecorator(outputDecorator6);
        int int8 = xmlFactoryBuilder5.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder10 = xmlFactoryBuilder5.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature11 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature12 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean14 = feature12.enabledIn((int) '#');
        com.fasterxml.jackson.core.ObjectCodec objectCodec15 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory18 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory19 = null;
        XmlFactory xmlFactory21 = new XmlFactory(objectCodec15, (int) 'a', 10, xMLInputFactory18, xMLOutputFactory19, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator22 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory23 = xmlFactory21.setOutputDecorator(outputDecorator22);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature24 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory25 = xmlFactory21.disable(feature24);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature26 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature27 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] featureArray28 = new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { feature12, feature24, feature26, feature27 };
        XmlFactoryBuilder xmlFactoryBuilder29 = xmlFactoryBuilder10.disable(feature11, featureArray28);
        XmlFactoryBuilder xmlFactoryBuilder30 = xmlFactoryBuilder2.disable(feature3, featureArray28);
        com.fasterxml.jackson.core.JsonFactory.Feature feature31 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder32 = xmlFactoryBuilder30.enable(feature31);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + feature3 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature3.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 4 + "'", int8 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder10);
        org.junit.Assert.assertTrue("'" + feature11 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature11.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + feature12 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature12.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(jsonFactory23);
        org.junit.Assert.assertTrue("'" + feature24 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature24.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory25);
        org.junit.Assert.assertTrue("'" + feature26 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature26.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertTrue("'" + feature27 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature27.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(featureArray28);
        org.junit.Assert.assertArrayEquals(featureArray28, new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 });
        org.junit.Assert.assertNotNull(xmlFactoryBuilder29);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder30);
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test176");
        XmlFactory xmlFactory0 = new XmlFactory();
        xmlFactory0.setXMLTextElementName("XML");
        xmlFactory0.setXMLTextElementName("JSON");
        // The following exception was thrown during execution in test generation
        try {
            XmlMapper.Builder builder5 = XmlMapper.builder(xmlFactory0);
            org.junit.Assert.fail("Expected exception of type java.lang.VerifyError; message: Bad return type?Exception Details:?  Location:?    com/fasterxml/jackson/databind/cfg/MapperBuilder.streamFactory()Lcom/fasterxml/jackson/core/TokenStreamFactory; @7: areturn?  Reason:?    Type 'com/fasterxml/jackson/core/JsonFactory' (current frame, stack[0]) is not assignable to 'com/fasterxml/jackson/core/TokenStreamFactory' (from method signature)?  Current Frame:?    bci: @7?    flags: { }?    locals: { 'com/fasterxml/jackson/databind/cfg/MapperBuilder' }?    stack: { 'com/fasterxml/jackson/core/JsonFactory' }?  Bytecode:?    0x0000000: 2ab4 0002 b600 08b0                    ?");
        } catch (VerifyError e) {
            // Expected exception.
        }
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test177");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        String str11 = xmlFactory6.getXMLTextElementName();
        XmlNameProcessor xmlNameProcessor13 = XmlNameProcessors.newReplacementProcessor("hi_");
        xmlFactory6.setXmlNameProcessor(xmlNameProcessor13);
        XmlNameProcessor.XmlName xmlName15 = new XmlNameProcessor.XmlName();
        // The following exception was thrown during execution in test generation
        try {
            xmlNameProcessor13.encodeName(xmlName15);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "" + "'", str11, "");
        org.junit.Assert.assertNotNull(xmlNameProcessor13);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test178");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator3 = xmlFactoryBuilder0.inputDecorator();
        ClassLoader classLoader4 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory5 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader4);
        XmlFactoryBuilder xmlFactoryBuilder6 = xmlFactoryBuilder0.inputFactory(xMLInputFactory5);
        com.fasterxml.jackson.core.StreamWriteFeature streamWriteFeature7 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder8 = xmlFactoryBuilder0.disable(streamWriteFeature7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertNull(inputDecorator3);
        org.junit.Assert.assertNotNull(xMLInputFactory5);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder6);
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test179");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        XmlNameProcessor xmlNameProcessor11 = xmlFactory6.getXmlNameProcessor();
        com.fasterxml.jackson.core.JsonFactory.Feature feature12 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonFactory jsonFactory13 = xmlFactory6.disable(feature12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertNotNull(xmlNameProcessor11);
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test180");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder0.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature6 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature7 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean9 = feature7.enabledIn((int) '#');
        com.fasterxml.jackson.core.ObjectCodec objectCodec10 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory13 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory14 = null;
        XmlFactory xmlFactory16 = new XmlFactory(objectCodec10, (int) 'a', 10, xMLInputFactory13, xMLOutputFactory14, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator17 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory18 = xmlFactory16.setOutputDecorator(outputDecorator17);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature19 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory20 = xmlFactory16.disable(feature19);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature21 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature22 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] featureArray23 = new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { feature7, feature19, feature21, feature22 };
        XmlFactoryBuilder xmlFactoryBuilder24 = xmlFactoryBuilder5.disable(feature6, featureArray23);
        com.fasterxml.jackson.core.json.JsonWriteFeature jsonWriteFeature25 = null;
        com.fasterxml.jackson.core.json.JsonWriteFeature[] jsonWriteFeatureArray26 = new com.fasterxml.jackson.core.json.JsonWriteFeature[] {};
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder27 = xmlFactoryBuilder5.disable(jsonWriteFeature25, jsonWriteFeatureArray26);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertTrue("'" + feature6 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature6.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + feature7 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature7.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(jsonFactory18);
        org.junit.Assert.assertTrue("'" + feature19 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature19.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory20);
        org.junit.Assert.assertTrue("'" + feature21 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature21.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertTrue("'" + feature22 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature22.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(featureArray23);
        org.junit.Assert.assertArrayEquals(featureArray23, new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 });
        org.junit.Assert.assertNotNull(xmlFactoryBuilder24);
        org.junit.Assert.assertNotNull(jsonWriteFeatureArray26);
        org.junit.Assert.assertArrayEquals(jsonWriteFeatureArray26, new com.fasterxml.jackson.core.json.JsonWriteFeature[] {});
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test181");
        // The following exception was thrown during execution in test generation
        try {
            XmlMapper xmlMapper0 = new XmlMapper();
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlMapper.coercionConfigDefaults()Lcom/fasterxml/jackson/databind/cfg/MutableCoercionConfig;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test182");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter.Indenter indenter5 = null;
        defaultXmlPrettyPrinter4.indentObjectsWith(indenter5);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator7 = null;
        defaultXmlPrettyPrinter4.writeStartArray(jsonGenerator7);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_9 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter4.writeStartElement(xMLStreamWriter2_9, "", "");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test183");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        defaultXmlPrettyPrinter0.writeEndArray(jsonGenerator3, (int) (byte) 0);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator6 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator6);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter9 = defaultXmlPrettyPrinter0.withCustomNewLine("XML");
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_10 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter9.writeLeafXsiNilElement(xMLStreamWriter2_10, "hi!", "JSON");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter9);
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test184");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        com.fasterxml.jackson.core.ObjectCodec objectCodec11 = xmlFactory10.getCodec();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator12 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory13 = xmlFactory10.setOutputDecorator(outputDecorator12);
        byte[] byteArray15 = new byte[] { (byte) 1 };
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser18 = jsonFactory13.createJsonParser(byteArray15, (int) (short) 100, (int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: ParseError at [row,col]:[1,1]?Message: Premature end of file.");
        } catch (com.fasterxml.jackson.core.JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertNull(objectCodec11);
        org.junit.Assert.assertNotNull(jsonFactory13);
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] { (byte) 1 });
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test185");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        XmlFactory xmlFactory1 = new XmlFactory(objectCodec0);
        String str2 = xmlFactory1.getFormatName();
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature3 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        XmlFactory xmlFactory4 = xmlFactory1.enable(feature3);
        // The following exception was thrown during execution in test generation
        try {
            XmlMapper xmlMapper5 = new XmlMapper(xmlFactory1);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlMapper.coercionConfigDefaults()Lcom/fasterxml/jackson/databind/cfg/MutableCoercionConfig;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "XML" + "'", str2, "XML");
        org.junit.Assert.assertTrue("'" + feature3 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature3.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(xmlFactory4);
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test186");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.JavaType javaType2 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer3 = xmlSerializerProvider1.findTypeSerializer(javaType2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test187");
        ClassLoader classLoader0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory1 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader0);
        javax.xml.stream.XMLOutputFactory xMLOutputFactory2 = null;
        XmlFactory xmlFactory3 = new XmlFactory(xMLInputFactory1, xMLOutputFactory2);
        byte[] byteArray10 = new byte[] { (byte) 1, (byte) 100, (byte) 100, (byte) 1, (byte) 1, (byte) 1 };
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser13 = xmlFactory3.createParser(byteArray10, 1, 57343);
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: ParseError at [row,col]:[1,1]?Message: Content is not allowed in prolog.");
        } catch (com.fasterxml.jackson.core.JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xMLInputFactory1);
        org.junit.Assert.assertNotNull(byteArray10);
        org.junit.Assert.assertArrayEquals(byteArray10, new byte[] { (byte) 1, (byte) 100, (byte) 100, (byte) 1, (byte) 1, (byte) 1 });
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test188");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        com.fasterxml.jackson.databind.JavaType javaType3 = null;
        com.fasterxml.jackson.databind.BeanProperty beanProperty4 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer5 = xmlSerializerProvider1.findValueSerializer(javaType3, beanProperty4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test189");
        JacksonXmlModule jacksonXmlModule0 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers1 = null;
        jacksonXmlModule0.setKeySerializers(simpleSerializers1);
        Class[] classArray4 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray5 = (Class<?>[]) classArray4;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule6 = jacksonXmlModule0.registerSubtypes((Class<?>[]) classArray4);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver7 = null;
        jacksonXmlModule0.setAbstractTypes(simpleAbstractTypeResolver7);
        jacksonXmlModule0.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.SerializerFactory serializerFactory11 = null;
        JacksonXmlModule jacksonXmlModule12 = jacksonXmlModule0.overrideSerializerFactory(serializerFactory11);
        com.fasterxml.jackson.databind.ser.SerializerFactory serializerFactory13 = jacksonXmlModule0.serializerFactoryOverride();
        org.junit.Assert.assertNotNull(classArray4);
        org.junit.Assert.assertArrayEquals(classArray4, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray5);
        org.junit.Assert.assertArrayEquals(wildcardClassArray5, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule6);
        org.junit.Assert.assertNotNull(jacksonXmlModule12);
        org.junit.Assert.assertNull(serializerFactory13);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test190");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.core.io.CharacterEscapes characterEscapes9 = xmlFactory6.getCharacterEscapes();
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature10 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        boolean boolean12 = feature10.enabledIn((int) (short) 0);
        boolean boolean14 = feature10.enabledIn((int) ' ');
        XmlFactory xmlFactory15 = xmlFactory6.enable(feature10);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser17 = xmlFactory15.createJsonParser("org.codehaus.stax2.propDtdOverride");
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlFactory._createContentReference(Ljava/lang/Object;)Lcom/fasterxml/jackson/core/io/ContentReference;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertNull(characterEscapes9);
        org.junit.Assert.assertTrue("'" + feature10 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature10.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertNotNull(xmlFactory15);
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test191");
        JacksonXmlModule jacksonXmlModule0 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers1 = null;
        jacksonXmlModule0.setKeySerializers(simpleSerializers1);
        Class[] classArray4 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray5 = (Class<?>[]) classArray4;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule6 = jacksonXmlModule0.registerSubtypes((Class<?>[]) classArray4);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver7 = null;
        jacksonXmlModule0.setAbstractTypes(simpleAbstractTypeResolver7);
        jacksonXmlModule0.setXMLTextElementName("JSON");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup11 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider12 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup11);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider13 = xmlSerializerProvider12.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer14 = defaultSerializerProvider13.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer15 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer16 = objJsonSerializer14.unwrappingSerializer(nameTransformer15);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.module.SimpleModule simpleModule17 = jacksonXmlModule0.addSerializer(objJsonSerializer14);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: JsonSerializer of type com.fasterxml.jackson.databind.ser.impl.FailingSerializer does not define valid handledType() -- must either register with method that takes type argument  or make serializer extend 'com.fasterxml.jackson.databind.ser.std.StdSerializer'");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(classArray4);
        org.junit.Assert.assertArrayEquals(classArray4, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray5);
        org.junit.Assert.assertArrayEquals(wildcardClassArray5, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule6);
        org.junit.Assert.assertNotNull(defaultSerializerProvider13);
        org.junit.Assert.assertNotNull(objJsonSerializer14);
        org.junit.Assert.assertNotNull(objJsonSerializer16);
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test192");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        defaultXmlPrettyPrinter0.writeEndArray(jsonGenerator3, (int) (byte) 0);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator6 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator6);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter9 = defaultXmlPrettyPrinter0.withCustomNewLine("XML");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator10 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter9.writeStartObject(jsonGenerator10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter9);
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test193");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.nameForTextElement("");
        com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser.Feature feature3 = null;
        com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser.Feature feature4 = null;
        com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser.Feature[] featureArray5 = new com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser.Feature[] { feature4 };
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder6 = xmlFactoryBuilder2.disable(feature3, featureArray5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertNotNull(featureArray5);
        org.junit.Assert.assertArrayEquals(featureArray5, new com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser.Feature[] { null });
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test194");
        String[] strArray2 = new String[] { "", "" };
        java.util.LinkedHashSet<String> strSet3 = new java.util.LinkedHashSet<String>();
        boolean boolean4 = java.util.Collections.addAll((java.util.Collection<String>) strSet3, strArray2);
        java.util.Spliterator<String> strSpliterator5 = strSet3.spliterator();
        java.util.Spliterator<String> strSpliterator6 = strSet3.spliterator();
        java.util.Spliterator<String> strSpliterator7 = strSet3.spliterator();
        org.junit.Assert.assertNotNull(strArray2);
        org.junit.Assert.assertArrayEquals(strArray2, new String[] { "", "" });
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(strSpliterator5);
        org.junit.Assert.assertNotNull(strSpliterator6);
        org.junit.Assert.assertNotNull(strSpliterator7);
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test195");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        com.fasterxml.jackson.databind.BeanProperty beanProperty3 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer4 = defaultSerializerProvider2.findNullValueSerializer(beanProperty3);
        com.fasterxml.jackson.databind.SerializationFeature serializationFeature5 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean6 = defaultSerializerProvider2.isEnabled(serializationFeature5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(objJsonSerializer4);
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test196");
        com.fasterxml.jackson.databind.deser.BeanDeserializerBase beanDeserializerBase0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.deser.WrapperHandlingDeserializer wrapperHandlingDeserializer1 = new com.fasterxml.jackson.dataformat.xml.deser.WrapperHandlingDeserializer(beanDeserializerBase0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test197");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
        defaultXmlPrettyPrinter0.beforeObjectEntries(jsonGenerator5);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator7 = null;
        defaultXmlPrettyPrinter0.writeEndArray(jsonGenerator7, 55296);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter.Indenter indenter10 = null;
        defaultXmlPrettyPrinter0.indentArraysWith(indenter10);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_12 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafNullElement(xMLStreamWriter2_12, " ", "XML");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test198");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer3 = defaultSerializerProvider2.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.introspect.Annotated annotated4 = null;
        XmlFactoryBuilder xmlFactoryBuilder5 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator6 = null;
        XmlFactoryBuilder xmlFactoryBuilder7 = xmlFactoryBuilder5.outputDecorator(outputDecorator6);
        int int8 = xmlFactoryBuilder5.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder10 = xmlFactoryBuilder5.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature11 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature12 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean14 = feature12.enabledIn((int) '#');
        com.fasterxml.jackson.core.ObjectCodec objectCodec15 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory18 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory19 = null;
        XmlFactory xmlFactory21 = new XmlFactory(objectCodec15, (int) 'a', 10, xMLInputFactory18, xMLOutputFactory19, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator22 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory23 = xmlFactory21.setOutputDecorator(outputDecorator22);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature24 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory25 = xmlFactory21.disable(feature24);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature26 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature27 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] featureArray28 = new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { feature12, feature24, feature26, feature27 };
        XmlFactoryBuilder xmlFactoryBuilder29 = xmlFactoryBuilder10.disable(feature11, featureArray28);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer30 = defaultSerializerProvider2.serializerInstance(annotated4, (Object) featureArray28);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: AnnotationIntrospector returned serializer definition of type [Lcom.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator$Feature;; expected type JsonSerializer or Class<JsonSerializer> instead");
        } catch (IllegalStateException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(objJsonSerializer3);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 4 + "'", int8 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder10);
        org.junit.Assert.assertTrue("'" + feature11 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature11.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + feature12 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature12.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(jsonFactory23);
        org.junit.Assert.assertTrue("'" + feature24 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature24.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory25);
        org.junit.Assert.assertTrue("'" + feature26 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature26.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertTrue("'" + feature27 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature27.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(featureArray28);
        org.junit.Assert.assertArrayEquals(featureArray28, new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 });
        org.junit.Assert.assertNotNull(xmlFactoryBuilder29);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test199");
        com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext xmlReadContext0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext xmlReadContext5 = new com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext(xmlReadContext0, 11, (int) '4', (int) (byte) 0, (int) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchFieldError; message: _nestingDepth");
        } catch (NoSuchFieldError e) {
            // Expected exception.
        }
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test200");
        XmlFactory xmlFactory0 = new XmlFactory();
        xmlFactory0.setXMLTextElementName("XML");
        javax.xml.stream.XMLStreamWriter xMLStreamWriter3 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator toXmlGenerator4 = xmlFactory0.createGenerator(xMLStreamWriter3);
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonGenerationException; message: N/A");
        } catch (com.fasterxml.jackson.core.JsonGenerationException e) {
            // Expected exception.
        }
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test201");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator1 = xmlFactoryBuilder0.inputDecorator();
        ClassLoader classLoader2 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader2);
        XmlFactoryBuilder xmlFactoryBuilder4 = xmlFactoryBuilder0.inputFactory(xMLInputFactory3);
        XmlFactory xmlFactory5 = new XmlFactory(xMLInputFactory3);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNull(inputDecorator1);
        org.junit.Assert.assertNotNull(xMLInputFactory3);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder4);
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test202");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator3 = null;
        XmlFactoryBuilder xmlFactoryBuilder4 = xmlFactoryBuilder0.inputDecorator(inputDecorator3);
        com.fasterxml.jackson.core.json.JsonWriteFeature jsonWriteFeature5 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder6 = xmlFactoryBuilder4.disable(jsonWriteFeature5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder4);
    }

//    @Test
//    public void test203() throws Throwable {
//        if (debug)
//            System.out.format("%n%s%n", "RegressionTest0.test203");
//        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
//        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
//        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
//        com.fasterxml.jackson.databind.BeanProperty beanProperty3 = null;
//        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer4 = defaultSerializerProvider2.findNullValueSerializer(beanProperty3);
//        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
//        com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer7 = null;
//        // The following exception was thrown during execution in test generation
//        try {
//            defaultSerializerProvider2.serializePolymorphic(jsonGenerator5, (Object) 11, typeSerializer7);
//            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
//        } catch (NullPointerException e) {
//            // Expected exception.
//        }
//        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
//        org.junit.Assert.assertNotNull(objJsonSerializer4);
//    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test204");
        String[] strArray2 = new String[] { "", "" };
        java.util.LinkedHashSet<String> strSet3 = new java.util.LinkedHashSet<String>();
        boolean boolean4 = java.util.Collections.addAll((java.util.Collection<String>) strSet3, strArray2);
        java.util.Spliterator<String> strSpliterator5 = strSet3.spliterator();
        boolean boolean7 = strSet3.add("XML");
        Object[] objArray8 = strSet3.toArray();
        org.junit.Assert.assertNotNull(strArray2);
        org.junit.Assert.assertArrayEquals(strArray2, new String[] { "", "" });
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(strSpliterator5);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNotNull(objArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray8), "[, XML]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray8), "[, XML]");
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test205");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.nameForTextElement("");
        com.fasterxml.jackson.core.json.JsonWriteFeature jsonWriteFeature3 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder4 = xmlFactoryBuilder0.enable(jsonWriteFeature3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test206");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.beforeArrayValues(jsonGenerator1);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_3 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_3, "", " ", (int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test207");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
        defaultXmlPrettyPrinter0.beforeObjectEntries(jsonGenerator5);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_7 = null;
        org.codehaus.stax2.typed.Base64Variant base64Variant10 = null;
        byte[] byteArray15 = new byte[] { (byte) 0, (byte) 0, (byte) 100, (byte) 10 };
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_7, "JSON", "JSON", base64Variant10, byteArray15, 10, 55296);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] { (byte) 0, (byte) 0, (byte) 100, (byte) 10 });
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test208");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        XmlFactory xmlFactory1 = new XmlFactory(objectCodec0);
        String str2 = xmlFactory1.getFormatName();
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature3 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        XmlFactory xmlFactory4 = xmlFactory1.enable(feature3);
        com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser.Feature feature5 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactory xmlFactory6 = xmlFactory4.disable(feature5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "XML" + "'", str2, "XML");
        org.junit.Assert.assertTrue("'" + feature3 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature3.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(xmlFactory4);
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test209");
        XmlFactory xmlFactory0 = new XmlFactory();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory2 = xmlFactory0.setOutputDecorator(outputDecorator1);
        java.io.InputStream inputStream3 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser4 = xmlFactory0.createParser(inputStream3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory2);
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test210");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder0.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature6 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactoryBuilder xmlFactoryBuilder7 = XmlFactory.builder();
        XmlFactoryBuilder xmlFactoryBuilder9 = xmlFactoryBuilder7.nameForTextElement("");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature10 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean11 = feature10.enabledByDefault();
        XmlFactoryBuilder xmlFactoryBuilder12 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator13 = null;
        XmlFactoryBuilder xmlFactoryBuilder14 = xmlFactoryBuilder12.outputDecorator(outputDecorator13);
        int int15 = xmlFactoryBuilder12.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder17 = xmlFactoryBuilder12.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature18 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature19 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean21 = feature19.enabledIn((int) '#');
        com.fasterxml.jackson.core.ObjectCodec objectCodec22 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory25 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory26 = null;
        XmlFactory xmlFactory28 = new XmlFactory(objectCodec22, (int) 'a', 10, xMLInputFactory25, xMLOutputFactory26, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator29 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory30 = xmlFactory28.setOutputDecorator(outputDecorator29);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature31 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory32 = xmlFactory28.disable(feature31);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature33 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature34 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] featureArray35 = new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { feature19, feature31, feature33, feature34 };
        XmlFactoryBuilder xmlFactoryBuilder36 = xmlFactoryBuilder17.disable(feature18, featureArray35);
        XmlFactoryBuilder xmlFactoryBuilder37 = xmlFactoryBuilder9.disable(feature10, featureArray35);
        XmlFactoryBuilder xmlFactoryBuilder38 = xmlFactoryBuilder0.disable(feature6, featureArray35);
        int int39 = xmlFactoryBuilder38.streamReadFeatures();
        com.fasterxml.jackson.core.JsonFactory.Feature feature40 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder42 = xmlFactoryBuilder38.configure(feature40, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertTrue("'" + feature6 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature6.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactoryBuilder7);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder9);
        org.junit.Assert.assertTrue("'" + feature10 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature10.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder12);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 4 + "'", int15 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder17);
        org.junit.Assert.assertTrue("'" + feature18 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature18.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + feature19 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature19.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(jsonFactory30);
        org.junit.Assert.assertTrue("'" + feature31 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature31.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory32);
        org.junit.Assert.assertTrue("'" + feature33 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature33.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertTrue("'" + feature34 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature34.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(featureArray35);
        org.junit.Assert.assertArrayEquals(featureArray35, new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 });
        org.junit.Assert.assertNotNull(xmlFactoryBuilder36);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder37);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder38);
        org.junit.Assert.assertTrue("'" + int39 + "' != '" + 1 + "'", int39 == 1);
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test211");
        XmlFactory xmlFactory0 = new XmlFactory();
        xmlFactory0.setXMLTextElementName("XML");
        Class<com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature> featureClass3 = xmlFactory0.getFormatWriteFeatureType();
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator4 = xmlFactory0.getInputDecorator();
        com.fasterxml.jackson.core.JsonGenerator.Feature feature5 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonFactory jsonFactory7 = xmlFactory0.configure(feature5, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(featureClass3);
        org.junit.Assert.assertNull(inputDecorator4);
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test212");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator5);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator7 = null;
        defaultXmlPrettyPrinter0.writeObjectEntrySeparator(jsonGenerator7);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_9 = null;
        org.codehaus.stax2.typed.Base64Variant base64Variant12 = null;
        byte[] byteArray19 = new byte[] { (byte) 10, (byte) 10, (byte) 1, (byte) -1, (byte) 0, (byte) 10 };
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_9, "hi!", "hi!", base64Variant12, byteArray19, 1, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
        org.junit.Assert.assertNotNull(byteArray19);
        org.junit.Assert.assertArrayEquals(byteArray19, new byte[] { (byte) 10, (byte) 10, (byte) 1, (byte) -1, (byte) 0, (byte) 10 });
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test213");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        XmlFactory xmlFactory1 = new XmlFactory(objectCodec0);
        String str2 = xmlFactory1.getFormatName();
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature3 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        XmlFactory xmlFactory4 = xmlFactory1.enable(feature3);
        java.io.InputStream inputStream5 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser6 = xmlFactory4.createJsonParser(inputStream5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "XML" + "'", str2, "XML");
        org.junit.Assert.assertTrue("'" + feature3 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature3.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(xmlFactory4);
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test214");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.nameForTextElement("");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature3 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean4 = feature3.enabledByDefault();
        XmlFactoryBuilder xmlFactoryBuilder5 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator6 = null;
        XmlFactoryBuilder xmlFactoryBuilder7 = xmlFactoryBuilder5.outputDecorator(outputDecorator6);
        int int8 = xmlFactoryBuilder5.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder10 = xmlFactoryBuilder5.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature11 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature12 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean14 = feature12.enabledIn((int) '#');
        com.fasterxml.jackson.core.ObjectCodec objectCodec15 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory18 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory19 = null;
        XmlFactory xmlFactory21 = new XmlFactory(objectCodec15, (int) 'a', 10, xMLInputFactory18, xMLOutputFactory19, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator22 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory23 = xmlFactory21.setOutputDecorator(outputDecorator22);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature24 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory25 = xmlFactory21.disable(feature24);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature26 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature27 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] featureArray28 = new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { feature12, feature24, feature26, feature27 };
        XmlFactoryBuilder xmlFactoryBuilder29 = xmlFactoryBuilder10.disable(feature11, featureArray28);
        XmlFactoryBuilder xmlFactoryBuilder30 = xmlFactoryBuilder2.disable(feature3, featureArray28);
        int int31 = xmlFactoryBuilder2.formatGeneratorFeaturesMask();
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + feature3 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature3.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 4 + "'", int8 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder10);
        org.junit.Assert.assertTrue("'" + feature11 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature11.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + feature12 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature12.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(jsonFactory23);
        org.junit.Assert.assertTrue("'" + feature24 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature24.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory25);
        org.junit.Assert.assertTrue("'" + feature26 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature26.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertTrue("'" + feature27 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature27.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(featureArray28);
        org.junit.Assert.assertArrayEquals(featureArray28, new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 });
        org.junit.Assert.assertNotNull(xmlFactoryBuilder29);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder30);
        org.junit.Assert.assertTrue("'" + int31 + "' != '" + 0 + "'", int31 == 0);
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test215");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        XmlFactory xmlFactory1 = new XmlFactory(objectCodec0);
        XmlNameProcessor xmlNameProcessor2 = xmlFactory1.getXmlNameProcessor();
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        xmlFactory1.setXMLInputFactory(xMLInputFactory3);
        java.net.URL uRL5 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser6 = xmlFactory1.createJsonParser(uRL5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlNameProcessor2);
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test216");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature0 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean2 = feature0.enabledIn((int) '#');
        boolean boolean3 = feature0.enabledByDefault();
        boolean boolean5 = feature0.enabledIn((int) (byte) 10);
        org.junit.Assert.assertTrue("'" + feature0 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature0.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test217");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder0.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature6 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactoryBuilder xmlFactoryBuilder7 = XmlFactory.builder();
        XmlFactoryBuilder xmlFactoryBuilder9 = xmlFactoryBuilder7.nameForTextElement("");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature10 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean11 = feature10.enabledByDefault();
        XmlFactoryBuilder xmlFactoryBuilder12 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator13 = null;
        XmlFactoryBuilder xmlFactoryBuilder14 = xmlFactoryBuilder12.outputDecorator(outputDecorator13);
        int int15 = xmlFactoryBuilder12.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder17 = xmlFactoryBuilder12.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature18 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature19 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean21 = feature19.enabledIn((int) '#');
        com.fasterxml.jackson.core.ObjectCodec objectCodec22 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory25 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory26 = null;
        XmlFactory xmlFactory28 = new XmlFactory(objectCodec22, (int) 'a', 10, xMLInputFactory25, xMLOutputFactory26, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator29 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory30 = xmlFactory28.setOutputDecorator(outputDecorator29);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature31 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory32 = xmlFactory28.disable(feature31);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature33 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature34 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] featureArray35 = new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { feature19, feature31, feature33, feature34 };
        XmlFactoryBuilder xmlFactoryBuilder36 = xmlFactoryBuilder17.disable(feature18, featureArray35);
        XmlFactoryBuilder xmlFactoryBuilder37 = xmlFactoryBuilder9.disable(feature10, featureArray35);
        XmlFactoryBuilder xmlFactoryBuilder38 = xmlFactoryBuilder0.disable(feature6, featureArray35);
        com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser.Feature feature39 = null;
        com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser.Feature[] featureArray40 = new com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser.Feature[] {};
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder41 = xmlFactoryBuilder38.enable(feature39, featureArray40);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertTrue("'" + feature6 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature6.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactoryBuilder7);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder9);
        org.junit.Assert.assertTrue("'" + feature10 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature10.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder12);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 4 + "'", int15 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder17);
        org.junit.Assert.assertTrue("'" + feature18 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature18.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + feature19 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature19.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(jsonFactory30);
        org.junit.Assert.assertTrue("'" + feature31 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature31.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory32);
        org.junit.Assert.assertTrue("'" + feature33 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature33.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertTrue("'" + feature34 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature34.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(featureArray35);
        org.junit.Assert.assertArrayEquals(featureArray35, new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 });
        org.junit.Assert.assertNotNull(xmlFactoryBuilder36);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder37);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder38);
        org.junit.Assert.assertNotNull(featureArray40);
        org.junit.Assert.assertArrayEquals(featureArray40, new com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser.Feature[] {});
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test218");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator3);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter5 = defaultXmlPrettyPrinter0.createInstance();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator6 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeStartObject(jsonGenerator6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter5);
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test219");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        ClassLoader classLoader1 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory2 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader1);
        javax.xml.stream.XMLOutputFactory xMLOutputFactory3 = null;
        XmlFactory xmlFactory4 = new XmlFactory(objectCodec0, xMLInputFactory2, xMLOutputFactory3);
        XmlFactoryBuilder xmlFactoryBuilder5 = XmlFactory.builder();
        XmlFactoryBuilder xmlFactoryBuilder7 = xmlFactoryBuilder5.nameForTextElement("");
        javax.xml.stream.XMLOutputFactory xMLOutputFactory8 = xmlFactoryBuilder7.xmlOutputFactory();
        // The following exception was thrown during execution in test generation
        try {
            XmlMapper xmlMapper9 = new XmlMapper(xMLInputFactory2, xMLOutputFactory8);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlMapper.coercionConfigDefaults()Lcom/fasterxml/jackson/databind/cfg/MutableCoercionConfig;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xMLInputFactory2);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder7);
        org.junit.Assert.assertNotNull(xMLOutputFactory8);
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test220");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        defaultSerializerProvider2.flushCachedSerializers();
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup4 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider5 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup4);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider6 = xmlSerializerProvider5.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer7 = defaultSerializerProvider6.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer8 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer9 = objJsonSerializer7.unwrappingSerializer(nameTransformer8);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean10 = defaultSerializerProvider2.isUnknownTypeSerializer(objJsonSerializer7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(defaultSerializerProvider6);
        org.junit.Assert.assertNotNull(objJsonSerializer7);
        org.junit.Assert.assertNotNull(objJsonSerializer9);
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test221");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature0 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_DECLARATION;
        org.junit.Assert.assertTrue("'" + feature0 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_DECLARATION + "'", feature0.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_DECLARATION));
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test222");
        com.fasterxml.jackson.databind.deser.BeanDeserializerBase beanDeserializerBase0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.deser.XmlTextDeserializer xmlTextDeserializer2 = new com.fasterxml.jackson.dataformat.xml.deser.XmlTextDeserializer(beanDeserializerBase0, (int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test223");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder0.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature6 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature7 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean9 = feature7.enabledIn((int) '#');
        com.fasterxml.jackson.core.ObjectCodec objectCodec10 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory13 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory14 = null;
        XmlFactory xmlFactory16 = new XmlFactory(objectCodec10, (int) 'a', 10, xMLInputFactory13, xMLOutputFactory14, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator17 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory18 = xmlFactory16.setOutputDecorator(outputDecorator17);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature19 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory20 = xmlFactory16.disable(feature19);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature21 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature22 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] featureArray23 = new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { feature7, feature19, feature21, feature22 };
        XmlFactoryBuilder xmlFactoryBuilder24 = xmlFactoryBuilder5.disable(feature6, featureArray23);
        com.fasterxml.jackson.core.json.JsonWriteFeature jsonWriteFeature25 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder27 = xmlFactoryBuilder5.configure(jsonWriteFeature25, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertTrue("'" + feature6 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature6.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + feature7 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature7.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(jsonFactory18);
        org.junit.Assert.assertTrue("'" + feature19 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature19.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory20);
        org.junit.Assert.assertTrue("'" + feature21 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature21.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertTrue("'" + feature22 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature22.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(featureArray23);
        org.junit.Assert.assertArrayEquals(featureArray23, new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 });
        org.junit.Assert.assertNotNull(xmlFactoryBuilder24);
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test224");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.SerializationConfig serializationConfig2 = null;
        com.fasterxml.jackson.databind.ser.SerializerFactory serializerFactory3 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider4 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlSerializerProvider1, serializationConfig2, serializerFactory3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test225");
        XmlFactory xmlFactory0 = new XmlFactory();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory2 = xmlFactory0.setOutputDecorator(outputDecorator1);
        java.io.OutputStream outputStream3 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonGenerator jsonGenerator4 = jsonFactory2.createJsonGenerator(outputStream3);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlFactory._createContentReference(Ljava/lang/Object;)Lcom/fasterxml/jackson/core/io/ContentReference;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory2);
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test226");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        javax.xml.stream.XMLStreamReader xMLStreamReader11 = null;
        org.codehaus.stax2.XMLStreamReader2 xMLStreamReader2_12 = com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter.wrapIfNecessary(xMLStreamReader11);
        org.codehaus.stax2.XMLStreamReader2 xMLStreamReader2_13 = com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter.wrapIfNecessary((javax.xml.stream.XMLStreamReader) xMLStreamReader2_12);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser fromXmlParser14 = xmlFactory6.createParser((javax.xml.stream.XMLStreamReader) xMLStreamReader2_12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertNotNull(xMLStreamReader2_12);
        org.junit.Assert.assertNotNull(xMLStreamReader2_13);
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test227");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        defaultSerializerProvider2.flushCachedSerializers();
        com.fasterxml.jackson.databind.JavaType javaType4 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.jsontype.TypeSerializer typeSerializer5 = defaultSerializerProvider2.findTypeSerializer(javaType4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test228");
        com.fasterxml.jackson.dataformat.xml.util.AnnotationUtil annotationUtil0 = new com.fasterxml.jackson.dataformat.xml.util.AnnotationUtil();
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test229");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter.Indenter indenter5 = null;
        defaultXmlPrettyPrinter4.indentObjectsWith(indenter5);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator7 = null;
        defaultXmlPrettyPrinter4.writeStartArray(jsonGenerator7);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_9 = null;
        org.codehaus.stax2.typed.Base64Variant base64Variant12 = null;
        byte[] byteArray18 = new byte[] { (byte) 0, (byte) 100, (byte) 1, (byte) 10, (byte) 1 };
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter4.writeLeafElement(xMLStreamWriter2_9, "org.codehaus.stax2.propDtdOverride", "XML", base64Variant12, byteArray18, 0, (int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
        org.junit.Assert.assertNotNull(byteArray18);
        org.junit.Assert.assertArrayEquals(byteArray18, new byte[] { (byte) 0, (byte) 100, (byte) 1, (byte) 10, (byte) 1 });
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test230");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeArrayValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("hi!");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
        defaultXmlPrettyPrinter4.writeEndArray(jsonGenerator5, (int) (short) -1);
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test231");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        com.fasterxml.jackson.databind.BeanProperty beanProperty3 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer4 = defaultSerializerProvider2.findNullValueSerializer(beanProperty3);
        com.fasterxml.jackson.core.ObjectCodec objectCodec5 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec5);
        String str7 = xmlFactory6.getFormatName();
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature8 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        XmlFactory xmlFactory9 = xmlFactory6.enable(feature8);
        // The following exception was thrown during execution in test generation
        try {
            Object obj10 = defaultSerializerProvider2.getAttribute((Object) xmlFactory9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(objJsonSerializer4);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "XML" + "'", str7, "XML");
        org.junit.Assert.assertTrue("'" + feature8 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature8.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(xmlFactory9);
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test232");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        com.fasterxml.jackson.core.ObjectCodec objectCodec11 = xmlFactory10.getCodec();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator12 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory13 = xmlFactory10.setOutputDecorator(outputDecorator12);
        com.fasterxml.jackson.core.JsonFactory jsonFactory15 = xmlFactory10.setRootValueSeparator("JSON");
        com.fasterxml.jackson.core.JsonFactory.Feature feature16 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonFactory jsonFactory17 = jsonFactory15.disable(feature16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertNull(objectCodec11);
        org.junit.Assert.assertNotNull(jsonFactory13);
        org.junit.Assert.assertNotNull(jsonFactory15);
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test233");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.core.JsonGenerator.Feature feature9 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonFactory jsonFactory11 = jsonFactory8.configure(feature9, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test234");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup2 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider3 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup2);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider4 = xmlSerializerProvider3.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer5 = defaultSerializerProvider4.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.BeanProperty beanProperty6 = null;
        com.fasterxml.jackson.databind.JsonSerializer<?> wildcardJsonSerializer7 = xmlSerializerProvider1.handleSecondaryContextualization(objJsonSerializer5, beanProperty6);
        com.fasterxml.jackson.databind.introspect.Annotated annotated8 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.util.Converter<Object, Object> objConverter10 = xmlSerializerProvider1.converterInstance(annotated8, (Object) 56320);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: AnnotationIntrospector returned Converter definition of type java.lang.Integer; expected type Converter or Class<Converter> instead");
        } catch (IllegalStateException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider4);
        org.junit.Assert.assertNotNull(objJsonSerializer5);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer7);
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test235");
        XmlFactory xmlFactory0 = new XmlFactory();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory2 = xmlFactory0.setOutputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.JsonParser.Feature feature3 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonFactory jsonFactory4 = jsonFactory2.disable(feature3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory2);
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test236");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter.Indenter indenter5 = null;
        defaultXmlPrettyPrinter4.indentObjectsWith(indenter5);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator7 = null;
        defaultXmlPrettyPrinter4.writeStartArray(jsonGenerator7);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_9 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter4.writeLeafElement(xMLStreamWriter2_9, "hi_", "", (long) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test237");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        XmlFactory xmlFactory1 = new XmlFactory(objectCodec0);
        com.fasterxml.jackson.core.JsonFactory.Feature feature2 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonFactory jsonFactory4 = xmlFactory1.configure(feature2, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test238");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator4 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultSerializerProvider2.defaultSerializeValue((Object) 0, jsonGenerator4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test239");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup2 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider3 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup2);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider4 = xmlSerializerProvider3.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer5 = defaultSerializerProvider4.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.BeanProperty beanProperty6 = null;
        com.fasterxml.jackson.databind.JsonSerializer<?> wildcardJsonSerializer7 = xmlSerializerProvider1.handleSecondaryContextualization(objJsonSerializer5, beanProperty6);
        com.fasterxml.jackson.databind.JavaType javaType8 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer9 = xmlSerializerProvider1.findValueSerializer(javaType8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider4);
        org.junit.Assert.assertNotNull(objJsonSerializer5);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer7);
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test240");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator3 = xmlFactoryBuilder0.inputDecorator();
        ClassLoader classLoader4 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory5 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader4);
        XmlFactoryBuilder xmlFactoryBuilder6 = xmlFactoryBuilder0.inputFactory(xMLInputFactory5);
        com.fasterxml.jackson.core.json.JsonWriteFeature jsonWriteFeature7 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder8 = xmlFactoryBuilder6.disable(jsonWriteFeature7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertNull(inputDecorator3);
        org.junit.Assert.assertNotNull(xMLInputFactory5);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder6);
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test241");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature0 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.UNWRAP_ROOT_OBJECT_NODE;
        org.junit.Assert.assertTrue("'" + feature0 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.UNWRAP_ROOT_OBJECT_NODE + "'", feature0.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.UNWRAP_ROOT_OBJECT_NODE));
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test242");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        XmlFactory xmlFactory1 = new XmlFactory(objectCodec0);
        XmlNameProcessor xmlNameProcessor2 = xmlFactory1.getXmlNameProcessor();
        XmlNameProcessor.XmlName xmlName3 = new XmlNameProcessor.XmlName();
        xmlNameProcessor2.encodeName(xmlName3);
        String str5 = xmlName3.namespace;
        xmlName3.namespace = " ";
        xmlName3.namespace = "";
        org.junit.Assert.assertNotNull(xmlNameProcessor2);
        org.junit.Assert.assertNull(str5);
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test243");
        com.fasterxml.jackson.core.io.IOContext iOContext0 = null;
        com.fasterxml.jackson.core.ObjectCodec objectCodec3 = null;
        javax.xml.stream.XMLStreamWriter xMLStreamWriter4 = null;
        com.fasterxml.jackson.core.ObjectCodec objectCodec5 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec5);
        XmlNameProcessor xmlNameProcessor7 = xmlFactory6.getXmlNameProcessor();
        XmlNameProcessor.XmlName xmlName8 = new XmlNameProcessor.XmlName();
        xmlNameProcessor7.encodeName(xmlName8);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator toXmlGenerator10 = new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator(iOContext0, 56320, 1, objectCodec3, xMLStreamWriter4, xmlNameProcessor7);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.core.base.GeneratorBase.<init>(ILcom/fasterxml/jackson/core/ObjectCodec;Lcom/fasterxml/jackson/core/io/IOContext;)V");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlNameProcessor7);
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test244");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator3 = null;
        XmlFactoryBuilder xmlFactoryBuilder4 = xmlFactoryBuilder0.inputDecorator(inputDecorator3);
        XmlFactoryBuilder xmlFactoryBuilder5 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator6 = xmlFactoryBuilder5.inputDecorator();
        ClassLoader classLoader7 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory8 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader7);
        XmlFactoryBuilder xmlFactoryBuilder9 = xmlFactoryBuilder5.inputFactory(xMLInputFactory8);
        XmlFactoryBuilder xmlFactoryBuilder10 = xmlFactoryBuilder4.inputFactory(xMLInputFactory8);
        com.fasterxml.jackson.core.json.JsonWriteFeature jsonWriteFeature11 = null;
        com.fasterxml.jackson.core.json.JsonWriteFeature jsonWriteFeature12 = null;
        com.fasterxml.jackson.core.json.JsonWriteFeature[] jsonWriteFeatureArray13 = new com.fasterxml.jackson.core.json.JsonWriteFeature[] { jsonWriteFeature12 };
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder14 = xmlFactoryBuilder4.disable(jsonWriteFeature11, jsonWriteFeatureArray13);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertNull(inputDecorator6);
        org.junit.Assert.assertNotNull(xMLInputFactory8);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder9);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder10);
        org.junit.Assert.assertNotNull(jsonWriteFeatureArray13);
        org.junit.Assert.assertArrayEquals(jsonWriteFeatureArray13, new com.fasterxml.jackson.core.json.JsonWriteFeature[] { null });
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test245");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.nameForTextElement("");
        com.fasterxml.jackson.core.json.JsonWriteFeature jsonWriteFeature3 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder0.configure(jsonWriteFeature3, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
    }

    @Test
    public void test246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test246");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.Version version7 = xmlFactory6.version();
        org.junit.Assert.assertNotNull(version7);
    }

    @Test
    public void test247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test247");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.formatParserFeaturesMask();
        int int4 = xmlFactoryBuilder0.formatGeneratorFeaturesMask();
        com.fasterxml.jackson.core.StreamReadFeature streamReadFeature5 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder7 = xmlFactoryBuilder0.configure(streamReadFeature5, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
    }

    @Test
    public void test248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test248");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder0.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature6 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactoryBuilder xmlFactoryBuilder7 = XmlFactory.builder();
        XmlFactoryBuilder xmlFactoryBuilder9 = xmlFactoryBuilder7.nameForTextElement("");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature10 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean11 = feature10.enabledByDefault();
        XmlFactoryBuilder xmlFactoryBuilder12 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator13 = null;
        XmlFactoryBuilder xmlFactoryBuilder14 = xmlFactoryBuilder12.outputDecorator(outputDecorator13);
        int int15 = xmlFactoryBuilder12.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder17 = xmlFactoryBuilder12.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature18 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature19 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean21 = feature19.enabledIn((int) '#');
        com.fasterxml.jackson.core.ObjectCodec objectCodec22 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory25 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory26 = null;
        XmlFactory xmlFactory28 = new XmlFactory(objectCodec22, (int) 'a', 10, xMLInputFactory25, xMLOutputFactory26, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator29 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory30 = xmlFactory28.setOutputDecorator(outputDecorator29);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature31 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory32 = xmlFactory28.disable(feature31);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature33 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature34 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] featureArray35 = new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { feature19, feature31, feature33, feature34 };
        XmlFactoryBuilder xmlFactoryBuilder36 = xmlFactoryBuilder17.disable(feature18, featureArray35);
        XmlFactoryBuilder xmlFactoryBuilder37 = xmlFactoryBuilder9.disable(feature10, featureArray35);
        XmlFactoryBuilder xmlFactoryBuilder38 = xmlFactoryBuilder0.disable(feature6, featureArray35);
        // The following exception was thrown during execution in test generation
        try {
            XmlFactory xmlFactory39 = xmlFactoryBuilder0.build();
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.core.JsonFactory.<init>(Lcom/fasterxml/jackson/core/TSFBuilder;Z)V");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertTrue("'" + feature6 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature6.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactoryBuilder7);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder9);
        org.junit.Assert.assertTrue("'" + feature10 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature10.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder12);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 4 + "'", int15 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder17);
        org.junit.Assert.assertTrue("'" + feature18 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature18.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + feature19 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature19.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(jsonFactory30);
        org.junit.Assert.assertTrue("'" + feature31 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature31.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory32);
        org.junit.Assert.assertTrue("'" + feature33 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature33.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertTrue("'" + feature34 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature34.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(featureArray35);
        org.junit.Assert.assertArrayEquals(featureArray35, new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 });
        org.junit.Assert.assertNotNull(xmlFactoryBuilder36);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder37);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder38);
    }

    @Test
    public void test249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test249");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.core.ObjectCodec objectCodec9 = xmlFactory6.getCodec();
        com.fasterxml.jackson.core.ObjectCodec objectCodec10 = xmlFactory6.getCodec();
        com.fasterxml.jackson.core.JsonParser.Feature feature11 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonFactory jsonFactory13 = xmlFactory6.configure(feature11, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertNull(objectCodec9);
        org.junit.Assert.assertNull(objectCodec10);
    }

    @Test
    public void test250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test250");
        com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext xmlReadContext0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext xmlReadContext5 = new com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext(xmlReadContext0, 100, 11, 55296, 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchFieldError; message: _nestingDepth");
        } catch (NoSuchFieldError e) {
            // Expected exception.
        }
    }

    @Test
    public void test251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test251");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator1 = xmlFactoryBuilder0.inputDecorator();
        ClassLoader classLoader2 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader2);
        XmlFactoryBuilder xmlFactoryBuilder4 = xmlFactoryBuilder0.inputFactory(xMLInputFactory3);
        com.fasterxml.jackson.core.json.JsonWriteFeature jsonWriteFeature5 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder6 = xmlFactoryBuilder4.disable(jsonWriteFeature5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNull(inputDecorator1);
        org.junit.Assert.assertNotNull(xMLInputFactory3);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder4);
    }

    @Test
    public void test252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test252");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator3 = null;
        XmlFactoryBuilder xmlFactoryBuilder4 = xmlFactoryBuilder0.inputDecorator(inputDecorator3);
        int int5 = xmlFactoryBuilder0.factoryFeaturesMask();
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature6 = null;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature7 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        int int8 = feature7.getMask();
        String[] strArray11 = new String[] { "", "" };
        java.util.LinkedHashSet<String> strSet12 = new java.util.LinkedHashSet<String>();
        boolean boolean13 = java.util.Collections.addAll((java.util.Collection<String>) strSet12, strArray11);
        java.util.Spliterator<String> strSpliterator14 = strSet12.spliterator();
        java.util.stream.Stream<String> strStream15 = strSet12.stream();
        com.fasterxml.jackson.core.ObjectCodec objectCodec16 = null;
        XmlFactory xmlFactory17 = new XmlFactory(objectCodec16);
        String str18 = xmlFactory17.getFormatName();
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature19 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        XmlFactory xmlFactory20 = xmlFactory17.enable(feature19);
        boolean boolean21 = strSet12.equals((Object) feature19);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature22 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        XmlFactoryBuilder xmlFactoryBuilder23 = XmlFactory.builder();
        XmlFactoryBuilder xmlFactoryBuilder25 = xmlFactoryBuilder23.nameForTextElement("");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature26 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean27 = feature26.enabledByDefault();
        XmlFactoryBuilder xmlFactoryBuilder28 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator29 = null;
        XmlFactoryBuilder xmlFactoryBuilder30 = xmlFactoryBuilder28.outputDecorator(outputDecorator29);
        int int31 = xmlFactoryBuilder28.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder33 = xmlFactoryBuilder28.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature34 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature35 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean37 = feature35.enabledIn((int) '#');
        com.fasterxml.jackson.core.ObjectCodec objectCodec38 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory41 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory42 = null;
        XmlFactory xmlFactory44 = new XmlFactory(objectCodec38, (int) 'a', 10, xMLInputFactory41, xMLOutputFactory42, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator45 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory46 = xmlFactory44.setOutputDecorator(outputDecorator45);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature47 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory48 = xmlFactory44.disable(feature47);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature49 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature50 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] featureArray51 = new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { feature35, feature47, feature49, feature50 };
        XmlFactoryBuilder xmlFactoryBuilder52 = xmlFactoryBuilder33.disable(feature34, featureArray51);
        XmlFactoryBuilder xmlFactoryBuilder53 = xmlFactoryBuilder25.disable(feature26, featureArray51);
        XmlFactoryBuilder xmlFactoryBuilder54 = XmlFactory.builder();
        XmlFactoryBuilder xmlFactoryBuilder56 = xmlFactoryBuilder54.nameForTextElement("");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature57 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean58 = feature57.enabledByDefault();
        XmlFactoryBuilder xmlFactoryBuilder59 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator60 = null;
        XmlFactoryBuilder xmlFactoryBuilder61 = xmlFactoryBuilder59.outputDecorator(outputDecorator60);
        int int62 = xmlFactoryBuilder59.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder64 = xmlFactoryBuilder59.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature65 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature66 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean68 = feature66.enabledIn((int) '#');
        com.fasterxml.jackson.core.ObjectCodec objectCodec69 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory72 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory73 = null;
        XmlFactory xmlFactory75 = new XmlFactory(objectCodec69, (int) 'a', 10, xMLInputFactory72, xMLOutputFactory73, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator76 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory77 = xmlFactory75.setOutputDecorator(outputDecorator76);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature78 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory79 = xmlFactory75.disable(feature78);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature80 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature81 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] featureArray82 = new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { feature66, feature78, feature80, feature81 };
        XmlFactoryBuilder xmlFactoryBuilder83 = xmlFactoryBuilder64.disable(feature65, featureArray82);
        XmlFactoryBuilder xmlFactoryBuilder84 = xmlFactoryBuilder56.disable(feature57, featureArray82);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] featureArray85 = new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { feature7, feature19, feature22, feature26, feature57 };
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder86 = xmlFactoryBuilder0.disable(feature6, featureArray85);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 15 + "'", int5 == 15);
        org.junit.Assert.assertTrue("'" + feature7 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature7.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 2 + "'", int8 == 2);
        org.junit.Assert.assertNotNull(strArray11);
        org.junit.Assert.assertArrayEquals(strArray11, new String[] { "", "" });
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertNotNull(strSpliterator14);
        org.junit.Assert.assertNotNull(strStream15);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "XML" + "'", str18, "XML");
        org.junit.Assert.assertTrue("'" + feature19 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature19.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(xmlFactory20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + feature22 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature22.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(xmlFactoryBuilder23);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder25);
        org.junit.Assert.assertTrue("'" + feature26 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature26.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder28);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder30);
        org.junit.Assert.assertTrue("'" + int31 + "' != '" + 4 + "'", int31 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder33);
        org.junit.Assert.assertTrue("'" + feature34 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature34.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + feature35 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature35.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertNotNull(jsonFactory46);
        org.junit.Assert.assertTrue("'" + feature47 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature47.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory48);
        org.junit.Assert.assertTrue("'" + feature49 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature49.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertTrue("'" + feature50 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature50.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(featureArray51);
        org.junit.Assert.assertArrayEquals(featureArray51, new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 });
        org.junit.Assert.assertNotNull(xmlFactoryBuilder52);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder53);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder54);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder56);
        org.junit.Assert.assertTrue("'" + feature57 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature57.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean58 + "' != '" + false + "'", boolean58 == false);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder59);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder61);
        org.junit.Assert.assertTrue("'" + int62 + "' != '" + 4 + "'", int62 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder64);
        org.junit.Assert.assertTrue("'" + feature65 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature65.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + feature66 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature66.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean68 + "' != '" + false + "'", boolean68 == false);
        org.junit.Assert.assertNotNull(jsonFactory77);
        org.junit.Assert.assertTrue("'" + feature78 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature78.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory79);
        org.junit.Assert.assertTrue("'" + feature80 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature80.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertTrue("'" + feature81 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature81.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(featureArray82);
        org.junit.Assert.assertArrayEquals(featureArray82, new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 });
        org.junit.Assert.assertNotNull(xmlFactoryBuilder83);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder84);
        org.junit.Assert.assertNotNull(featureArray85);
        org.junit.Assert.assertArrayEquals(featureArray85, new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL });
    }

    @Test
    public void test253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test253");
        com.fasterxml.jackson.annotation.JsonFormat.Value value0 = com.fasterxml.jackson.databind.BeanProperty.EMPTY_FORMAT;
        org.junit.Assert.assertNotNull(value0);
    }

    @Test
    public void test254() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test254");
        int int0 = com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream.XML_START_ELEMENT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test255() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test255");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature0 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean2 = feature0.enabledIn((int) '#');
        int int3 = feature0.getMask();
        org.junit.Assert.assertTrue("'" + feature0 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature0.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
    }

    @Test
    public void test256() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test256");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.factoryFeaturesMask();
        com.fasterxml.jackson.core.StreamReadFeature streamReadFeature4 = null;
        com.fasterxml.jackson.core.StreamReadFeature[] streamReadFeatureArray5 = new com.fasterxml.jackson.core.StreamReadFeature[] {};
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder6 = xmlFactoryBuilder0.enable(streamReadFeature4, streamReadFeatureArray5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 15 + "'", int3 == 15);
        org.junit.Assert.assertNotNull(streamReadFeatureArray5);
        org.junit.Assert.assertArrayEquals(streamReadFeatureArray5, new com.fasterxml.jackson.core.StreamReadFeature[] {});
    }

    @Test
    public void test257() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test257");
        ClassLoader classLoader0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory1 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader0);
        javax.xml.stream.XMLOutputFactory xMLOutputFactory2 = null;
        XmlFactory xmlFactory3 = new XmlFactory(xMLInputFactory1, xMLOutputFactory2);
        java.io.Writer writer4 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = xmlFactory3.createJsonGenerator(writer4);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlFactory._createContentReference(Ljava/lang/Object;)Lcom/fasterxml/jackson/core/io/ContentReference;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xMLInputFactory1);
    }

    @Test
    public void test258() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test258");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.formatParserFeaturesMask();
        XmlNameProcessor xmlNameProcessor4 = xmlFactoryBuilder0.xmlNameProcessor();
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
        org.junit.Assert.assertNotNull(xmlNameProcessor4);
    }

    @Test
    public void test259() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test259");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.core.io.CharacterEscapes characterEscapes9 = xmlFactory6.getCharacterEscapes();
        // The following exception was thrown during execution in test generation
        try {
            XmlMapper.Builder builder10 = XmlMapper.builder(xmlFactory6);
            org.junit.Assert.fail("Expected exception of type java.lang.VerifyError; message: Bad return type?Exception Details:?  Location:?    com/fasterxml/jackson/databind/cfg/MapperBuilder.streamFactory()Lcom/fasterxml/jackson/core/TokenStreamFactory; @7: areturn?  Reason:?    Type 'com/fasterxml/jackson/core/JsonFactory' (current frame, stack[0]) is not assignable to 'com/fasterxml/jackson/core/TokenStreamFactory' (from method signature)?  Current Frame:?    bci: @7?    flags: { }?    locals: { 'com/fasterxml/jackson/databind/cfg/MapperBuilder' }?    stack: { 'com/fasterxml/jackson/core/JsonFactory' }?  Bytecode:?    0x0000000: 2ab4 0002 b600 08b0                    ?");
        } catch (VerifyError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertNull(characterEscapes9);
    }

    @Test
    public void test260() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test260");
        String str0 = com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper.USE_PROPERTY_NAME;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "" + "'", str0, "");
    }

    @Test
    public void test261() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test261");
        XmlFactory xmlFactory0 = new XmlFactory();
        xmlFactory0.setXMLTextElementName("XML");
        xmlFactory0.setXMLTextElementName("JSON");
        com.fasterxml.jackson.core.JsonParser.Feature feature5 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonFactory jsonFactory6 = xmlFactory0.disable(feature5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test262() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test262");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        com.fasterxml.jackson.core.ObjectCodec objectCodec11 = xmlFactory10.getCodec();
        xmlFactory10.setXMLTextElementName("XML");
        com.fasterxml.jackson.core.JsonGenerator.Feature feature14 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonFactory jsonFactory15 = xmlFactory10.enable(feature14);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertNull(objectCodec11);
    }

    @Test
    public void test263() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test263");
        com.fasterxml.jackson.core.io.IOContext iOContext0 = null;
        com.fasterxml.jackson.core.ObjectCodec objectCodec3 = null;
        javax.xml.stream.XMLStreamWriter xMLStreamWriter4 = null;
        com.fasterxml.jackson.core.ObjectCodec objectCodec5 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory8 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory9 = null;
        XmlFactory xmlFactory11 = new XmlFactory(objectCodec5, (int) 'a', 10, xMLInputFactory8, xMLOutputFactory9, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator12 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory13 = xmlFactory11.setOutputDecorator(outputDecorator12);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature14 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory15 = xmlFactory11.disable(feature14);
        XmlNameProcessor xmlNameProcessor16 = xmlFactory11.getXmlNameProcessor();
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator toXmlGenerator17 = new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator(iOContext0, 1, (int) ' ', objectCodec3, xMLStreamWriter4, xmlNameProcessor16);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.core.base.GeneratorBase.<init>(ILcom/fasterxml/jackson/core/ObjectCodec;Lcom/fasterxml/jackson/core/io/IOContext;)V");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory13);
        org.junit.Assert.assertTrue("'" + feature14 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature14.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory15);
        org.junit.Assert.assertNotNull(xmlNameProcessor16);
    }

    @Test
    public void test264() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test264");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.core.io.CharacterEscapes characterEscapes9 = xmlFactory6.getCharacterEscapes();
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature10 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        boolean boolean12 = feature10.enabledIn((int) (short) 0);
        boolean boolean14 = feature10.enabledIn((int) ' ');
        XmlFactory xmlFactory15 = xmlFactory6.enable(feature10);
        boolean boolean16 = xmlFactory15.requiresPropertyOrdering();
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertNull(characterEscapes9);
        org.junit.Assert.assertTrue("'" + feature10 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature10.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertNotNull(xmlFactory15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test265() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test265");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder0.nameForTextElement("hi_");
        com.fasterxml.jackson.core.StreamWriteConstraints streamWriteConstraints6 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder7 = xmlFactoryBuilder5.streamWriteConstraints(streamWriteConstraints6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
    }

    @Test
    public void test266() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test266");
        // The following exception was thrown during execution in test generation
        try {
            XmlMapper.Builder builder0 = XmlMapper.builder();
            org.junit.Assert.fail("Expected exception of type java.lang.VerifyError; message: Bad return type?Exception Details:?  Location:?    com/fasterxml/jackson/databind/cfg/MapperBuilder.streamFactory()Lcom/fasterxml/jackson/core/TokenStreamFactory; @7: areturn?  Reason:?    Type 'com/fasterxml/jackson/core/JsonFactory' (current frame, stack[0]) is not assignable to 'com/fasterxml/jackson/core/TokenStreamFactory' (from method signature)?  Current Frame:?    bci: @7?    flags: { }?    locals: { 'com/fasterxml/jackson/databind/cfg/MapperBuilder' }?    stack: { 'com/fasterxml/jackson/core/JsonFactory' }?  Bytecode:?    0x0000000: 2ab4 0002 b600 08b0                    ?");
        } catch (VerifyError e) {
            // Expected exception.
        }
    }

    @Test
    public void test267() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test267");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder0.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature6 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature7 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean9 = feature7.enabledIn((int) '#');
        com.fasterxml.jackson.core.ObjectCodec objectCodec10 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory13 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory14 = null;
        XmlFactory xmlFactory16 = new XmlFactory(objectCodec10, (int) 'a', 10, xMLInputFactory13, xMLOutputFactory14, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator17 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory18 = xmlFactory16.setOutputDecorator(outputDecorator17);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature19 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory20 = xmlFactory16.disable(feature19);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature21 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature22 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] featureArray23 = new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { feature7, feature19, feature21, feature22 };
        XmlFactoryBuilder xmlFactoryBuilder24 = xmlFactoryBuilder5.disable(feature6, featureArray23);
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator25 = null;
        XmlFactoryBuilder xmlFactoryBuilder26 = xmlFactoryBuilder5.inputDecorator(inputDecorator25);
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator27 = xmlFactoryBuilder26.inputDecorator();
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertTrue("'" + feature6 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature6.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + feature7 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature7.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(jsonFactory18);
        org.junit.Assert.assertTrue("'" + feature19 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature19.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory20);
        org.junit.Assert.assertTrue("'" + feature21 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature21.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertTrue("'" + feature22 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature22.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(featureArray23);
        org.junit.Assert.assertArrayEquals(featureArray23, new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 });
        org.junit.Assert.assertNotNull(xmlFactoryBuilder24);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder26);
        org.junit.Assert.assertNull(inputDecorator27);
    }

    @Test
    public void test268() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test268");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        com.fasterxml.jackson.core.io.CharacterEscapes characterEscapes11 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory12 = xmlFactory10.setCharacterEscapes(characterEscapes11);
        com.fasterxml.jackson.core.JsonGenerator.Feature feature13 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonFactory jsonFactory14 = xmlFactory10.disable(feature13);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertNotNull(jsonFactory12);
    }

    @Test
    public void test269() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test269");
        String[] strArray2 = new String[] { "", "" };
        java.util.LinkedHashSet<String> strSet3 = new java.util.LinkedHashSet<String>();
        boolean boolean4 = java.util.Collections.addAll((java.util.Collection<String>) strSet3, strArray2);
        java.util.Spliterator<String> strSpliterator5 = strSet3.spliterator();
        boolean boolean7 = strSet3.add(" ");
        org.junit.Assert.assertNotNull(strArray2);
        org.junit.Assert.assertArrayEquals(strArray2, new String[] { "", "" });
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(strSpliterator5);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test270() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test270");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.core.io.CharacterEscapes characterEscapes9 = xmlFactory6.getCharacterEscapes();
        XmlFactoryBuilder xmlFactoryBuilder10 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator11 = null;
        XmlFactoryBuilder xmlFactoryBuilder12 = xmlFactoryBuilder10.outputDecorator(outputDecorator11);
        int int13 = xmlFactoryBuilder10.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder15 = xmlFactoryBuilder10.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature16 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactoryBuilder xmlFactoryBuilder17 = XmlFactory.builder();
        XmlFactoryBuilder xmlFactoryBuilder19 = xmlFactoryBuilder17.nameForTextElement("");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature20 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean21 = feature20.enabledByDefault();
        XmlFactoryBuilder xmlFactoryBuilder22 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator23 = null;
        XmlFactoryBuilder xmlFactoryBuilder24 = xmlFactoryBuilder22.outputDecorator(outputDecorator23);
        int int25 = xmlFactoryBuilder22.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder27 = xmlFactoryBuilder22.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature28 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature29 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean31 = feature29.enabledIn((int) '#');
        com.fasterxml.jackson.core.ObjectCodec objectCodec32 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory35 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory36 = null;
        XmlFactory xmlFactory38 = new XmlFactory(objectCodec32, (int) 'a', 10, xMLInputFactory35, xMLOutputFactory36, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator39 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory40 = xmlFactory38.setOutputDecorator(outputDecorator39);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature41 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory42 = xmlFactory38.disable(feature41);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature43 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature44 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] featureArray45 = new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { feature29, feature41, feature43, feature44 };
        XmlFactoryBuilder xmlFactoryBuilder46 = xmlFactoryBuilder27.disable(feature28, featureArray45);
        XmlFactoryBuilder xmlFactoryBuilder47 = xmlFactoryBuilder19.disable(feature20, featureArray45);
        XmlFactoryBuilder xmlFactoryBuilder48 = xmlFactoryBuilder10.disable(feature16, featureArray45);
        boolean boolean49 = xmlFactory6.isEnabled(feature16);
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertNull(characterEscapes9);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder10);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder12);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 4 + "'", int13 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder15);
        org.junit.Assert.assertTrue("'" + feature16 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature16.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactoryBuilder17);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder19);
        org.junit.Assert.assertTrue("'" + feature20 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature20.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder22);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder24);
        org.junit.Assert.assertTrue("'" + int25 + "' != '" + 4 + "'", int25 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder27);
        org.junit.Assert.assertTrue("'" + feature28 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature28.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + feature29 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature29.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNotNull(jsonFactory40);
        org.junit.Assert.assertTrue("'" + feature41 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature41.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory42);
        org.junit.Assert.assertTrue("'" + feature43 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature43.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertTrue("'" + feature44 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature44.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(featureArray45);
        org.junit.Assert.assertArrayEquals(featureArray45, new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 });
        org.junit.Assert.assertNotNull(xmlFactoryBuilder46);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder47);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder48);
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + false + "'", boolean49 == false);
    }

    @Test
    public void test271() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test271");
        ClassLoader classLoader0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory1 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader0);
        javax.xml.stream.XMLOutputFactory xMLOutputFactory2 = null;
        XmlFactory xmlFactory3 = new XmlFactory(xMLInputFactory1, xMLOutputFactory2);
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory5 = new XmlFactory(xMLInputFactory1, xMLOutputFactory4);
        ClassLoader classLoader6 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory7 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultOutputFactory(classLoader6);
        // The following exception was thrown during execution in test generation
        try {
            XmlMapper xmlMapper8 = new XmlMapper(xMLInputFactory1, xMLOutputFactory7);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlMapper.coercionConfigDefaults()Lcom/fasterxml/jackson/databind/cfg/MutableCoercionConfig;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xMLInputFactory1);
        org.junit.Assert.assertNotNull(xMLOutputFactory7);
    }

    @Test
    public void test272() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test272");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature0 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean2 = feature0.enabledIn((int) '#');
        boolean boolean3 = feature0.enabledByDefault();
        int int4 = feature0.getMask();
        org.junit.Assert.assertTrue("'" + feature0 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature0.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 4 + "'", int4 == 4);
    }

    @Test
    public void test273() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test273");
        java.util.List<com.fasterxml.jackson.databind.Module> moduleList0 = com.fasterxml.jackson.databind.ObjectMapper.findModules();
        org.junit.Assert.assertNotNull(moduleList0);
    }

    @Test
    public void test274() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test274");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        defaultSerializerProvider2.flushCachedSerializers();
        com.fasterxml.jackson.databind.SerializationFeature serializationFeature4 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean5 = defaultSerializerProvider2.isEnabled(serializationFeature4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
    }

    @Test
    public void test275() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test275");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.nameForTextElement("");
        javax.xml.stream.XMLOutputFactory xMLOutputFactory3 = xmlFactoryBuilder2.xmlOutputFactory();
        com.fasterxml.jackson.core.json.JsonWriteFeature jsonWriteFeature4 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder2.disable(jsonWriteFeature4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertNotNull(xMLOutputFactory3);
    }

    @Test
    public void test276() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test276");
        String[] strArray2 = new String[] { "", "" };
        java.util.LinkedHashSet<String> strSet3 = new java.util.LinkedHashSet<String>();
        boolean boolean4 = java.util.Collections.addAll((java.util.Collection<String>) strSet3, strArray2);
        java.util.Spliterator<String> strSpliterator5 = strSet3.spliterator();
        com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet caseInsensitiveNameSet6 = com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet.construct((java.util.Set<String>) strSet3);
        com.fasterxml.jackson.dataformat.xml.util.XmlInfo xmlInfo11 = new com.fasterxml.jackson.dataformat.xml.util.XmlInfo((Boolean) false, "org.codehaus.stax2.propDtdOverride", (Boolean) true, (Boolean) false);
        boolean boolean12 = xmlInfo11.isAttribute();
        boolean boolean13 = strSet3.remove((Object) boolean12);
        org.junit.Assert.assertNotNull(strArray2);
        org.junit.Assert.assertArrayEquals(strArray2, new String[] { "", "" });
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(strSpliterator5);
        org.junit.Assert.assertNotNull(caseInsensitiveNameSet6);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test277() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test277");
        XmlFactory xmlFactory0 = new XmlFactory();
        xmlFactory0.setXMLTextElementName("XML");
        XmlNameProcessor xmlNameProcessor3 = xmlFactory0.getXmlNameProcessor();
        XmlFactory xmlFactory4 = new XmlFactory();
        xmlFactory4.setXMLTextElementName("XML");
        XmlNameProcessor xmlNameProcessor7 = xmlFactory4.getXmlNameProcessor();
        XmlNameProcessor.XmlName xmlName8 = new XmlNameProcessor.XmlName();
        xmlNameProcessor7.decodeName(xmlName8);
        xmlNameProcessor3.encodeName(xmlName8);
        org.junit.Assert.assertNotNull(xmlNameProcessor3);
        org.junit.Assert.assertNotNull(xmlNameProcessor7);
    }

    @Test
    public void test278() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test278");
        com.fasterxml.jackson.dataformat.xml.util.XmlInfo xmlInfo4 = new com.fasterxml.jackson.dataformat.xml.util.XmlInfo((Boolean) true, "org.codehaus.stax2.propDtdOverride", (Boolean) false, (Boolean) false);
    }

    @Test
    public void test279() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test279");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        com.fasterxml.jackson.core.ObjectCodec objectCodec11 = xmlFactory10.getCodec();
        char[] charArray15 = new char[] { '#', '#', 'a' };
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser16 = xmlFactory10.createParser(charArray15);
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: ParseError at [row,col]:[1,1]?Message: Content is not allowed in prolog.");
        } catch (com.fasterxml.jackson.core.JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertNull(objectCodec11);
        org.junit.Assert.assertNotNull(charArray15);
        org.junit.Assert.assertArrayEquals(charArray15, new char[] { '#', '#', 'a' });
    }

    @Test
    public void test280() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test280");
        String[] strArray2 = new String[] { "", "" };
        java.util.LinkedHashSet<String> strSet3 = new java.util.LinkedHashSet<String>();
        boolean boolean4 = java.util.Collections.addAll((java.util.Collection<String>) strSet3, strArray2);
        java.util.Spliterator<String> strSpliterator5 = strSet3.spliterator();
        java.util.stream.Stream<String> strStream6 = strSet3.stream();
        String[] strArray9 = new String[] { "", "" };
        java.util.LinkedHashSet<String> strSet10 = new java.util.LinkedHashSet<String>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<String>) strSet10, strArray9);
        java.util.Spliterator<String> strSpliterator12 = strSet10.spliterator();
        java.util.stream.Stream<String> strStream13 = strSet10.stream();
        com.fasterxml.jackson.core.ObjectCodec objectCodec14 = null;
        XmlFactory xmlFactory15 = new XmlFactory(objectCodec14);
        String str16 = xmlFactory15.getFormatName();
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature17 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        XmlFactory xmlFactory18 = xmlFactory15.enable(feature17);
        boolean boolean19 = strSet10.equals((Object) feature17);
        boolean boolean20 = strSet3.removeAll((java.util.Collection<String>) strSet10);
        org.junit.Assert.assertNotNull(strArray2);
        org.junit.Assert.assertArrayEquals(strArray2, new String[] { "", "" });
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(strSpliterator5);
        org.junit.Assert.assertNotNull(strStream6);
        org.junit.Assert.assertNotNull(strArray9);
        org.junit.Assert.assertArrayEquals(strArray9, new String[] { "", "" });
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNotNull(strSpliterator12);
        org.junit.Assert.assertNotNull(strStream13);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "XML" + "'", str16, "XML");
        org.junit.Assert.assertTrue("'" + feature17 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature17.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(xmlFactory18);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
    }

    @Test
    public void test281() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test281");
        com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping defaultTyping0 = null;
        com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator polymorphicTypeValidator1 = null;
        // The following exception was thrown during execution in test generation
        try {
            DefaultingXmlTypeResolverBuilder defaultingXmlTypeResolverBuilder2 = new DefaultingXmlTypeResolverBuilder(defaultTyping0, polymorphicTypeValidator1);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.databind.ObjectMapper$DefaultTypeResolverBuilder.<init>(Lcom/fasterxml/jackson/databind/ObjectMapper$DefaultTyping;Lcom/fasterxml/jackson/databind/jsontype/PolymorphicTypeValidator;)V");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test282() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test282");
        XmlFactory xmlFactory0 = new XmlFactory();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory2 = xmlFactory0.setOutputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator3 = jsonFactory2.getInputDecorator();
        org.junit.Assert.assertNotNull(jsonFactory2);
        org.junit.Assert.assertNull(inputDecorator3);
    }

    @Test
    public void test283() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test283");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder0.nameForTextElement("hi_");
        int int6 = xmlFactoryBuilder0.streamReadFeatures();
        com.fasterxml.jackson.core.util.JsonGeneratorDecorator jsonGeneratorDecorator7 = null;
        XmlFactoryBuilder xmlFactoryBuilder8 = xmlFactoryBuilder0.addDecorator(jsonGeneratorDecorator7);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 1 + "'", int6 == 1);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder8);
    }

    @Test
    public void test284() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test284");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator5);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator7 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeEndObject(jsonGenerator7, (int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test285() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test285");
        int int0 = javax.xml.stream.XMLStreamConstants.ENTITY_REFERENCE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 9 + "'", int0 == 9);
    }

    @Test
    public void test286() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test286");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        defaultXmlPrettyPrinter0.writeEndArray(jsonGenerator3, (int) (byte) 0);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator6 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator6);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter9 = defaultXmlPrettyPrinter0.withCustomNewLine("XML");
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_10 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter9.writeLeafNullElement(xMLStreamWriter2_10, " ", "org.codehaus.stax2.propDtdOverride");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter9);
    }

    @Test
    public void test287() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test287");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer3 = defaultSerializerProvider2.getDefaultNullKeySerializer();
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup4 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider5 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup4);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider6 = xmlSerializerProvider5.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer7 = defaultSerializerProvider6.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer8 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer9 = objJsonSerializer7.unwrappingSerializer(nameTransformer8);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer10 = objJsonSerializer3.replaceDelegatee(objJsonSerializer7);
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: null");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(objJsonSerializer3);
        org.junit.Assert.assertNotNull(defaultSerializerProvider6);
        org.junit.Assert.assertNotNull(objJsonSerializer7);
        org.junit.Assert.assertNotNull(objJsonSerializer9);
    }

    @Test
    public void test288() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test288");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        defaultSerializerProvider2.flushCachedSerializers();
        com.fasterxml.jackson.databind.introspect.Annotated annotated4 = null;
        com.fasterxml.jackson.core.ObjectCodec objectCodec5 = null;
        ClassLoader classLoader6 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory7 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader6);
        javax.xml.stream.XMLOutputFactory xMLOutputFactory8 = null;
        XmlFactory xmlFactory9 = new XmlFactory(objectCodec5, xMLInputFactory7, xMLOutputFactory8);
        com.fasterxml.jackson.databind.util.Converter<Object, Object> objConverter10 = defaultSerializerProvider2.converterInstance(annotated4, (Object) objectCodec5);
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup11 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider12 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup11);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider13 = xmlSerializerProvider12.copy();
        com.fasterxml.jackson.databind.BeanProperty beanProperty14 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer15 = defaultSerializerProvider13.findNullValueSerializer(beanProperty14);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean16 = defaultSerializerProvider2.isUnknownTypeSerializer(objJsonSerializer15);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(xMLInputFactory7);
        org.junit.Assert.assertNull(objConverter10);
        org.junit.Assert.assertNotNull(defaultSerializerProvider13);
        org.junit.Assert.assertNotNull(objJsonSerializer15);
    }

    @Test
    public void test289() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test289");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        XmlFactoryBuilder xmlFactoryBuilder4 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator5 = null;
        XmlFactoryBuilder xmlFactoryBuilder6 = xmlFactoryBuilder4.outputDecorator(outputDecorator5);
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator7 = null;
        XmlFactoryBuilder xmlFactoryBuilder8 = xmlFactoryBuilder4.inputDecorator(inputDecorator7);
        XmlFactoryBuilder xmlFactoryBuilder9 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator10 = xmlFactoryBuilder9.inputDecorator();
        ClassLoader classLoader11 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory12 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader11);
        XmlFactoryBuilder xmlFactoryBuilder13 = xmlFactoryBuilder9.inputFactory(xMLInputFactory12);
        XmlFactoryBuilder xmlFactoryBuilder14 = xmlFactoryBuilder8.inputFactory(xMLInputFactory12);
        javax.xml.stream.XMLOutputFactory xMLOutputFactory15 = xmlFactoryBuilder14.xmlOutputFactory();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator16 = null;
        // The following exception was thrown during execution in test generation
        try {
            xmlSerializerProvider1.defaultSerializeField(" ", (Object) xMLOutputFactory15, jsonGenerator16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder6);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder8);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder9);
        org.junit.Assert.assertNull(inputDecorator10);
        org.junit.Assert.assertNotNull(xMLInputFactory12);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder13);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder14);
        org.junit.Assert.assertNotNull(xMLOutputFactory15);
    }

    @Test
    public void test290() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test290");
        XmlFactory xmlFactory0 = new XmlFactory();
        xmlFactory0.setXMLTextElementName("XML");
        XmlNameProcessor xmlNameProcessor3 = xmlFactory0.getXmlNameProcessor();
        XmlNameProcessor xmlNameProcessor4 = xmlFactory0.getXmlNameProcessor();
        java.io.Reader reader5 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser6 = xmlFactory0.createJsonParser(reader5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlNameProcessor3);
        org.junit.Assert.assertNotNull(xmlNameProcessor4);
    }

    @Test
    public void test291() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test291");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.inputDecorator(inputDecorator1);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
    }

    @Test
    public void test292() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test292");
        int int0 = javax.xml.stream.XMLStreamConstants.CDATA;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 12 + "'", int0 == 12);
    }

    @Test
    public void test293() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test293");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        defaultSerializerProvider2.flushCachedSerializers();
        com.fasterxml.jackson.databind.introspect.Annotated annotated4 = null;
        com.fasterxml.jackson.core.ObjectCodec objectCodec5 = null;
        ClassLoader classLoader6 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory7 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader6);
        javax.xml.stream.XMLOutputFactory xMLOutputFactory8 = null;
        XmlFactory xmlFactory9 = new XmlFactory(objectCodec5, xMLInputFactory7, xMLOutputFactory8);
        com.fasterxml.jackson.databind.util.Converter<Object, Object> objConverter10 = defaultSerializerProvider2.converterInstance(annotated4, (Object) objectCodec5);
        com.fasterxml.jackson.databind.SerializationFeature serializationFeature11 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean12 = defaultSerializerProvider2.isEnabled(serializationFeature11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(xMLInputFactory7);
        org.junit.Assert.assertNull(objConverter10);
    }

    @Test
    public void test294() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test294");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.core.format.InputAccessor inputAccessor9 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.format.MatchStrength matchStrength10 = xmlFactory6.hasFormat(inputAccessor9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
    }

    @Test
    public void test295() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test295");
        com.fasterxml.jackson.core.format.InputAccessor inputAccessor0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.format.MatchStrength matchStrength1 = XmlFactory.hasXMLFormat(inputAccessor0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test296() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test296");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup2 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider3 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup2);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider4 = xmlSerializerProvider3.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer5 = defaultSerializerProvider4.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.BeanProperty beanProperty6 = null;
        com.fasterxml.jackson.databind.JsonSerializer<?> wildcardJsonSerializer7 = xmlSerializerProvider1.handleSecondaryContextualization(objJsonSerializer5, beanProperty6);
        com.fasterxml.jackson.databind.cfg.CacheProvider cacheProvider8 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider9 = xmlSerializerProvider1.withCaches(cacheProvider8);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.<init>(Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;Lcom/fasterxml/jackson/databind/cfg/CacheProvider;)V");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider4);
        org.junit.Assert.assertNotNull(objJsonSerializer5);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer7);
    }

    @Test
    public void test297() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test297");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        XmlFactory xmlFactory1 = new XmlFactory(objectCodec0);
        XmlNameProcessor xmlNameProcessor2 = xmlFactory1.getXmlNameProcessor();
        String str3 = xmlFactory1.getRootValueSeparator();
        com.fasterxml.jackson.core.JsonFactory jsonFactory5 = xmlFactory1.setRootValueSeparator("hi!");
        java.io.InputStream inputStream6 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser7 = xmlFactory1.createJsonParser(inputStream6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlNameProcessor2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + " " + "'", str3, " ");
        org.junit.Assert.assertNotNull(jsonFactory5);
    }

    @Test
    public void test298() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test298");
        String[] strArray2 = new String[] { "", "hi!" };
        java.util.ArrayList<String> strList3 = new java.util.ArrayList<String>();
        boolean boolean4 = java.util.Collections.addAll((java.util.Collection<String>) strList3, strArray2);
        java.util.stream.Stream<String> strStream5 = strList3.stream();
        java.util.stream.Stream<String> strStream6 = strList3.stream();
        Object[] objArray7 = strList3.toArray();
        org.junit.Assert.assertNotNull(strArray2);
        org.junit.Assert.assertArrayEquals(strArray2, new String[] { "", "hi!" });
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(strStream5);
        org.junit.Assert.assertNotNull(strStream6);
        org.junit.Assert.assertNotNull(objArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray7), "[, hi!]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray7), "[, hi!]");
    }

    @Test
    public void test299() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test299");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        com.fasterxml.jackson.databind.BeanProperty beanProperty3 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer4 = defaultSerializerProvider2.findNullValueSerializer(beanProperty3);
        com.fasterxml.jackson.core.ObjectCodec objectCodec5 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory8 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory9 = null;
        XmlFactory xmlFactory11 = new XmlFactory(objectCodec5, (int) 'a', 10, xMLInputFactory8, xMLOutputFactory9, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator12 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory13 = xmlFactory11.setOutputDecorator(outputDecorator12);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature14 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory15 = xmlFactory11.disable(feature14);
        Class<com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature> featureClass16 = xmlFactory11.getFormatWriteFeatureType();
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.jsonschema.JsonSchema jsonSchema17 = defaultSerializerProvider2.generateJsonSchema(featureClass16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(objJsonSerializer4);
        org.junit.Assert.assertNotNull(jsonFactory13);
        org.junit.Assert.assertTrue("'" + feature14 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature14.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory15);
        org.junit.Assert.assertNotNull(featureClass16);
    }

    @Test
    public void test300() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test300");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
        defaultXmlPrettyPrinter0.beforeObjectEntries(jsonGenerator5);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator7 = null;
        defaultXmlPrettyPrinter0.writeEndArray(jsonGenerator7, 55296);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator10 = null;
        defaultXmlPrettyPrinter0.beforeArrayValues(jsonGenerator10);
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test301() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test301");
        int int0 = com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream.XML_ROOT_TEXT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 7 + "'", int0 == 7);
    }

    @Test
    public void test302() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test302");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        defaultSerializerProvider2.flushCachedSerializers();
        com.fasterxml.jackson.databind.introspect.Annotated annotated4 = null;
        com.fasterxml.jackson.core.ObjectCodec objectCodec5 = null;
        ClassLoader classLoader6 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory7 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader6);
        javax.xml.stream.XMLOutputFactory xMLOutputFactory8 = null;
        XmlFactory xmlFactory9 = new XmlFactory(objectCodec5, xMLInputFactory7, xMLOutputFactory8);
        com.fasterxml.jackson.databind.util.Converter<Object, Object> objConverter10 = defaultSerializerProvider2.converterInstance(annotated4, (Object) objectCodec5);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.AnnotationIntrospector annotationIntrospector11 = defaultSerializerProvider2.getAnnotationIntrospector();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(xMLInputFactory7);
        org.junit.Assert.assertNull(objConverter10);
    }

    @Test
    public void test303() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test303");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator5);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator7 = null;
        defaultXmlPrettyPrinter0.writeEndArray(jsonGenerator7, 15);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_10 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_10, "org.codehaus.stax2.propDtdOverride", "org.codehaus.stax2.propDtdOverride", (float) 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test304() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test304");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        com.fasterxml.jackson.core.io.CharacterEscapes characterEscapes11 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory12 = xmlFactory10.setCharacterEscapes(characterEscapes11);
        com.fasterxml.jackson.core.io.CharacterEscapes characterEscapes13 = xmlFactory10.getCharacterEscapes();
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertNotNull(jsonFactory12);
        org.junit.Assert.assertNull(characterEscapes13);
    }

    @Test
    public void test305() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test305");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup2 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider3 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup2);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider4 = xmlSerializerProvider3.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer5 = defaultSerializerProvider4.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.BeanProperty beanProperty6 = null;
        com.fasterxml.jackson.databind.JsonSerializer<?> wildcardJsonSerializer7 = xmlSerializerProvider1.handleSecondaryContextualization(objJsonSerializer5, beanProperty6);
        // The following exception was thrown during execution in test generation
        try {
            java.util.Locale locale8 = xmlSerializerProvider1.getLocale();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider4);
        org.junit.Assert.assertNotNull(objJsonSerializer5);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer7);
    }

    @Test
    public void test306() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test306");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator5);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_7 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeStartElement(xMLStreamWriter2_7, "hi!", "XML");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test307() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test307");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator3);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter5 = defaultXmlPrettyPrinter0.createInstance();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator6 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator6);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_8 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_8, "", "hi_", true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter5);
    }

    @Test
    public void test308() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test308");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        JacksonXmlModule jacksonXmlModule3 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers4 = null;
        jacksonXmlModule3.setKeySerializers(simpleSerializers4);
        Class[] classArray7 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray8 = (Class<?>[]) classArray7;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule9 = jacksonXmlModule3.registerSubtypes((Class<?>[]) classArray7);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver10 = null;
        jacksonXmlModule3.setAbstractTypes(simpleAbstractTypeResolver10);
        JacksonXmlModule jacksonXmlModule12 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers13 = null;
        jacksonXmlModule12.setKeySerializers(simpleSerializers13);
        Class[] classArray16 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray17 = (Class<?>[]) classArray16;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule18 = jacksonXmlModule12.registerSubtypes((Class<?>[]) classArray16);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver19 = null;
        jacksonXmlModule12.setAbstractTypes(simpleAbstractTypeResolver19);
        jacksonXmlModule12.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.SerializerFactory serializerFactory23 = null;
        JacksonXmlModule jacksonXmlModule24 = jacksonXmlModule12.overrideSerializerFactory(serializerFactory23);
        com.fasterxml.jackson.core.ObjectCodec objectCodec25 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory28 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory29 = null;
        XmlFactory xmlFactory31 = new XmlFactory(objectCodec25, (int) 'a', 10, xMLInputFactory28, xMLOutputFactory29, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator32 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory33 = xmlFactory31.setOutputDecorator(outputDecorator32);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature34 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory35 = xmlFactory31.disable(feature34);
        Class<com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature> featureClass36 = xmlFactory31.getFormatWriteFeatureType();
        com.fasterxml.jackson.databind.deser.ValueInstantiator valueInstantiator37 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule38 = jacksonXmlModule12.addValueInstantiator(featureClass36, valueInstantiator37);
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup39 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider40 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup39);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider41 = xmlSerializerProvider40.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer42 = defaultSerializerProvider41.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule43 = jacksonXmlModule3.addKeySerializer(featureClass36, objJsonSerializer42);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.annotation.JsonFormat.Value value44 = xmlSerializerProvider1.getDefaultPropertyFormat(featureClass36);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(classArray7);
        org.junit.Assert.assertArrayEquals(classArray7, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray8);
        org.junit.Assert.assertArrayEquals(wildcardClassArray8, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule9);
        org.junit.Assert.assertNotNull(classArray16);
        org.junit.Assert.assertArrayEquals(classArray16, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray17);
        org.junit.Assert.assertArrayEquals(wildcardClassArray17, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule18);
        org.junit.Assert.assertNotNull(jacksonXmlModule24);
        org.junit.Assert.assertNotNull(jsonFactory33);
        org.junit.Assert.assertTrue("'" + feature34 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature34.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory35);
        org.junit.Assert.assertNotNull(featureClass36);
        org.junit.Assert.assertNotNull(simpleModule38);
        org.junit.Assert.assertNotNull(defaultSerializerProvider41);
        org.junit.Assert.assertNotNull(objJsonSerializer42);
        org.junit.Assert.assertNotNull(simpleModule43);
    }

    @Test
    public void test309() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test309");
        JacksonXmlModule jacksonXmlModule0 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers1 = null;
        jacksonXmlModule0.setKeySerializers(simpleSerializers1);
        Class[] classArray4 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray5 = (Class<?>[]) classArray4;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule6 = jacksonXmlModule0.registerSubtypes((Class<?>[]) classArray4);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver7 = null;
        jacksonXmlModule0.setAbstractTypes(simpleAbstractTypeResolver7);
        jacksonXmlModule0.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.BeanSerializerModifier beanSerializerModifier11 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule12 = jacksonXmlModule0.setSerializerModifier(beanSerializerModifier11);
        JacksonXmlModule jacksonXmlModule13 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers14 = null;
        jacksonXmlModule13.setKeySerializers(simpleSerializers14);
        Class[] classArray17 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray18 = (Class<?>[]) classArray17;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule19 = jacksonXmlModule13.registerSubtypes((Class<?>[]) classArray17);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver20 = null;
        jacksonXmlModule13.setAbstractTypes(simpleAbstractTypeResolver20);
        jacksonXmlModule13.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.SerializerFactory serializerFactory24 = null;
        JacksonXmlModule jacksonXmlModule25 = jacksonXmlModule13.overrideSerializerFactory(serializerFactory24);
        com.fasterxml.jackson.core.ObjectCodec objectCodec26 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory29 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory30 = null;
        XmlFactory xmlFactory32 = new XmlFactory(objectCodec26, (int) 'a', 10, xMLInputFactory29, xMLOutputFactory30, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator33 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory34 = xmlFactory32.setOutputDecorator(outputDecorator33);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature35 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory36 = xmlFactory32.disable(feature35);
        Class<com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature> featureClass37 = xmlFactory32.getFormatWriteFeatureType();
        com.fasterxml.jackson.databind.deser.ValueInstantiator valueInstantiator38 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule39 = jacksonXmlModule13.addValueInstantiator(featureClass37, valueInstantiator38);
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup40 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider41 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup40);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider42 = xmlSerializerProvider41.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer43 = defaultSerializerProvider42.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer44 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer45 = objJsonSerializer43.unwrappingSerializer(nameTransformer44);
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule46 = simpleModule12.addKeySerializer(featureClass37, objJsonSerializer43);
        com.fasterxml.jackson.databind.ser.BeanSerializerModifier beanSerializerModifier47 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule48 = simpleModule12.setSerializerModifier(beanSerializerModifier47);
        String str49 = simpleModule48.getModuleName();
        org.junit.Assert.assertNotNull(classArray4);
        org.junit.Assert.assertArrayEquals(classArray4, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray5);
        org.junit.Assert.assertArrayEquals(wildcardClassArray5, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule6);
        org.junit.Assert.assertNotNull(simpleModule12);
        org.junit.Assert.assertNotNull(classArray17);
        org.junit.Assert.assertArrayEquals(classArray17, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray18);
        org.junit.Assert.assertArrayEquals(wildcardClassArray18, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule19);
        org.junit.Assert.assertNotNull(jacksonXmlModule25);
        org.junit.Assert.assertNotNull(jsonFactory34);
        org.junit.Assert.assertTrue("'" + feature35 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature35.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory36);
        org.junit.Assert.assertNotNull(featureClass37);
        org.junit.Assert.assertNotNull(simpleModule39);
        org.junit.Assert.assertNotNull(defaultSerializerProvider42);
        org.junit.Assert.assertNotNull(objJsonSerializer43);
        org.junit.Assert.assertNotNull(objJsonSerializer45);
        org.junit.Assert.assertNotNull(simpleModule46);
        org.junit.Assert.assertNotNull(simpleModule48);
        org.junit.Assert.assertEquals("'" + str49 + "' != '" + "JacksonXmlModule" + "'", str49, "JacksonXmlModule");
    }

    @Test
    public void test310() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test310");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup2 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider3 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup2);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider4 = xmlSerializerProvider3.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer5 = defaultSerializerProvider4.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.BeanProperty beanProperty6 = null;
        com.fasterxml.jackson.databind.JsonSerializer<?> wildcardJsonSerializer7 = xmlSerializerProvider1.handleSecondaryContextualization(objJsonSerializer5, beanProperty6);
        com.fasterxml.jackson.databind.SerializationConfig serializationConfig8 = xmlSerializerProvider1.getConfig();
        java.util.Date date9 = null;
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator10 = null;
        // The following exception was thrown during execution in test generation
        try {
            xmlSerializerProvider1.defaultSerializeDateValue(date9, jsonGenerator10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider4);
        org.junit.Assert.assertNotNull(objJsonSerializer5);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer7);
        org.junit.Assert.assertNull(serializationConfig8);
    }

    @Test
    public void test311() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test311");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup2 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider3 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup2);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider4 = xmlSerializerProvider3.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer5 = defaultSerializerProvider4.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.BeanProperty beanProperty6 = null;
        com.fasterxml.jackson.databind.JsonSerializer<?> wildcardJsonSerializer7 = xmlSerializerProvider1.handleSecondaryContextualization(objJsonSerializer5, beanProperty6);
        com.fasterxml.jackson.databind.SerializationConfig serializationConfig8 = xmlSerializerProvider1.getConfig();
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup9 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider10 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup9);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider11 = xmlSerializerProvider10.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer12 = defaultSerializerProvider11.getDefaultNullKeySerializer();
        xmlSerializerProvider1.setDefaultKeySerializer(objJsonSerializer12);
        org.junit.Assert.assertNotNull(defaultSerializerProvider4);
        org.junit.Assert.assertNotNull(objJsonSerializer5);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer7);
        org.junit.Assert.assertNull(serializationConfig8);
        org.junit.Assert.assertNotNull(defaultSerializerProvider11);
        org.junit.Assert.assertNotNull(objJsonSerializer12);
    }

    @Test
    public void test312() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test312");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.core.io.CharacterEscapes characterEscapes9 = xmlFactory6.getCharacterEscapes();
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature10 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        boolean boolean12 = feature10.enabledIn((int) (short) 0);
        boolean boolean14 = feature10.enabledIn((int) ' ');
        XmlFactory xmlFactory15 = xmlFactory6.enable(feature10);
        java.io.Writer writer16 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator toXmlGenerator17 = xmlFactory15.createGenerator(writer16);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlFactory._createContentReference(Ljava/lang/Object;)Lcom/fasterxml/jackson/core/io/ContentReference;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertNull(characterEscapes9);
        org.junit.Assert.assertTrue("'" + feature10 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature10.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertNotNull(xmlFactory15);
    }

    @Test
    public void test313() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test313");
        JacksonXmlModule jacksonXmlModule0 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers1 = null;
        jacksonXmlModule0.setKeySerializers(simpleSerializers1);
        Class[] classArray4 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray5 = (Class<?>[]) classArray4;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule6 = jacksonXmlModule0.registerSubtypes((Class<?>[]) classArray4);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver7 = null;
        jacksonXmlModule0.setAbstractTypes(simpleAbstractTypeResolver7);
        jacksonXmlModule0.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.BeanSerializerModifier beanSerializerModifier11 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule12 = jacksonXmlModule0.setSerializerModifier(beanSerializerModifier11);
        com.fasterxml.jackson.databind.ser.BeanSerializerModifier beanSerializerModifier13 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule14 = simpleModule12.setSerializerModifier(beanSerializerModifier13);
        com.fasterxml.jackson.databind.module.SimpleKeyDeserializers simpleKeyDeserializers15 = null;
        simpleModule14.setKeyDeserializers(simpleKeyDeserializers15);
        org.junit.Assert.assertNotNull(classArray4);
        org.junit.Assert.assertArrayEquals(classArray4, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray5);
        org.junit.Assert.assertArrayEquals(wildcardClassArray5, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule6);
        org.junit.Assert.assertNotNull(simpleModule12);
        org.junit.Assert.assertNotNull(simpleModule14);
    }

    @Test
    public void test314() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test314");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        XmlFactory xmlFactory1 = new XmlFactory(objectCodec0);
        String str2 = xmlFactory1.getFormatName();
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature3 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        XmlFactory xmlFactory4 = xmlFactory1.enable(feature3);
        boolean boolean5 = xmlFactory4.canHandleBinaryNatively();
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "XML" + "'", str2, "XML");
        org.junit.Assert.assertTrue("'" + feature3 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature3.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(xmlFactory4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test315() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test315");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
        defaultXmlPrettyPrinter0.beforeObjectEntries(jsonGenerator5);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_7 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writePrologLinefeed(xMLStreamWriter2_7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test316() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test316");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder0.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature6 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactoryBuilder xmlFactoryBuilder7 = XmlFactory.builder();
        XmlFactoryBuilder xmlFactoryBuilder9 = xmlFactoryBuilder7.nameForTextElement("");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature10 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean11 = feature10.enabledByDefault();
        XmlFactoryBuilder xmlFactoryBuilder12 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator13 = null;
        XmlFactoryBuilder xmlFactoryBuilder14 = xmlFactoryBuilder12.outputDecorator(outputDecorator13);
        int int15 = xmlFactoryBuilder12.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder17 = xmlFactoryBuilder12.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature18 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature19 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean21 = feature19.enabledIn((int) '#');
        com.fasterxml.jackson.core.ObjectCodec objectCodec22 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory25 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory26 = null;
        XmlFactory xmlFactory28 = new XmlFactory(objectCodec22, (int) 'a', 10, xMLInputFactory25, xMLOutputFactory26, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator29 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory30 = xmlFactory28.setOutputDecorator(outputDecorator29);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature31 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory32 = xmlFactory28.disable(feature31);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature33 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature34 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] featureArray35 = new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { feature19, feature31, feature33, feature34 };
        XmlFactoryBuilder xmlFactoryBuilder36 = xmlFactoryBuilder17.disable(feature18, featureArray35);
        XmlFactoryBuilder xmlFactoryBuilder37 = xmlFactoryBuilder9.disable(feature10, featureArray35);
        XmlFactoryBuilder xmlFactoryBuilder38 = xmlFactoryBuilder0.disable(feature6, featureArray35);
        com.fasterxml.jackson.core.ObjectCodec objectCodec39 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory42 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory43 = null;
        XmlFactory xmlFactory45 = new XmlFactory(objectCodec39, (int) 'a', 10, xMLInputFactory42, xMLOutputFactory43, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator46 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory47 = xmlFactory45.setOutputDecorator(outputDecorator46);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature48 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory49 = xmlFactory45.disable(feature48);
        XmlFactoryBuilder xmlFactoryBuilder51 = xmlFactoryBuilder38.configure(feature48, false);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertTrue("'" + feature6 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature6.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactoryBuilder7);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder9);
        org.junit.Assert.assertTrue("'" + feature10 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature10.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder12);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 4 + "'", int15 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder17);
        org.junit.Assert.assertTrue("'" + feature18 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature18.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + feature19 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature19.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(jsonFactory30);
        org.junit.Assert.assertTrue("'" + feature31 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature31.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory32);
        org.junit.Assert.assertTrue("'" + feature33 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature33.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertTrue("'" + feature34 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature34.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(featureArray35);
        org.junit.Assert.assertArrayEquals(featureArray35, new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 });
        org.junit.Assert.assertNotNull(xmlFactoryBuilder36);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder37);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder38);
        org.junit.Assert.assertNotNull(jsonFactory47);
        org.junit.Assert.assertTrue("'" + feature48 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature48.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory49);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder51);
    }

    @Test
    public void test317() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test317");
        XmlFactory xmlFactory0 = new XmlFactory();
        xmlFactory0.setXMLTextElementName("XML");
        Class<com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature> featureClass3 = xmlFactory0.getFormatWriteFeatureType();
        com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser.Feature feature4 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactory xmlFactory5 = xmlFactory0.enable(feature4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(featureClass3);
    }

    @Test
    public void test318() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test318");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder0.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature6 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature7 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean9 = feature7.enabledIn((int) '#');
        com.fasterxml.jackson.core.ObjectCodec objectCodec10 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory13 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory14 = null;
        XmlFactory xmlFactory16 = new XmlFactory(objectCodec10, (int) 'a', 10, xMLInputFactory13, xMLOutputFactory14, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator17 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory18 = xmlFactory16.setOutputDecorator(outputDecorator17);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature19 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory20 = xmlFactory16.disable(feature19);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature21 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature22 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] featureArray23 = new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { feature7, feature19, feature21, feature22 };
        XmlFactoryBuilder xmlFactoryBuilder24 = xmlFactoryBuilder5.disable(feature6, featureArray23);
        XmlNameProcessor xmlNameProcessor25 = xmlFactoryBuilder5.xmlNameProcessor();
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertTrue("'" + feature6 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature6.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + feature7 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature7.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(jsonFactory18);
        org.junit.Assert.assertTrue("'" + feature19 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature19.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory20);
        org.junit.Assert.assertTrue("'" + feature21 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature21.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertTrue("'" + feature22 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature22.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(featureArray23);
        org.junit.Assert.assertArrayEquals(featureArray23, new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 });
        org.junit.Assert.assertNotNull(xmlFactoryBuilder24);
        org.junit.Assert.assertNotNull(xmlNameProcessor25);
    }

    @Test
    public void test319() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test319");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        XmlFactory xmlFactory1 = new XmlFactory(objectCodec0);
        String str2 = xmlFactory1.getFormatName();
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature3 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        XmlFactory xmlFactory4 = xmlFactory1.enable(feature3);
        int int5 = feature3.getMask();
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "XML" + "'", str2, "XML");
        org.junit.Assert.assertTrue("'" + feature3 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature3.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(xmlFactory4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 2 + "'", int5 == 2);
    }

    @Test
    public void test320() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test320");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator3);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter5 = defaultXmlPrettyPrinter0.createInstance();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator6 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator6);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_8 = null;
        java.math.BigDecimal bigDecimal11 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_8, "JSON", "hi!", bigDecimal11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter5);
    }

    @Test
    public void test321() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test321");
        String str0 = com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializerBase.KEY_XML_INFO;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "xmlInfo" + "'", str0, "xmlInfo");
    }

    @Test
    public void test322() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test322");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.core.io.CharacterEscapes characterEscapes9 = xmlFactory6.getCharacterEscapes();
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature10 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        boolean boolean12 = feature10.enabledIn((int) (short) 0);
        boolean boolean14 = feature10.enabledIn((int) ' ');
        XmlFactory xmlFactory15 = xmlFactory6.enable(feature10);
        javax.xml.stream.XMLOutputFactory xMLOutputFactory16 = null;
        xmlFactory6.setXMLOutputFactory(xMLOutputFactory16);
        com.fasterxml.jackson.core.JsonParser.Feature feature18 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonFactory jsonFactory19 = xmlFactory6.enable(feature18);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertNull(characterEscapes9);
        org.junit.Assert.assertTrue("'" + feature10 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature10.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertNotNull(xmlFactory15);
    }

    @Test
    public void test323() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test323");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        com.fasterxml.jackson.core.ObjectCodec objectCodec11 = xmlFactory10.getCodec();
        xmlFactory10.setXMLTextElementName("XML");
        com.fasterxml.jackson.core.io.CharacterEscapes characterEscapes14 = xmlFactory10.getCharacterEscapes();
        char[] charArray19 = new char[] { '#', '#', 'a', '4' };
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser22 = xmlFactory10.createParser(charArray19, (int) (short) 0, 5);
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: ParseError at [row,col]:[1,1]?Message: Content is not allowed in prolog.");
        } catch (com.fasterxml.jackson.core.JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertNull(objectCodec11);
        org.junit.Assert.assertNull(characterEscapes14);
        org.junit.Assert.assertNotNull(charArray19);
        org.junit.Assert.assertArrayEquals(charArray19, new char[] { '#', '#', 'a', '4' });
    }

    @Test
    public void test324() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test324");
        String[] strArray2 = new String[] { "", "" };
        java.util.LinkedHashSet<String> strSet3 = new java.util.LinkedHashSet<String>();
        boolean boolean4 = java.util.Collections.addAll((java.util.Collection<String>) strSet3, strArray2);
        java.util.Spliterator<String> strSpliterator5 = strSet3.spliterator();
        com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet caseInsensitiveNameSet6 = com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet.construct((java.util.Set<String>) strSet3);
        int int7 = caseInsensitiveNameSet6.size();
        com.fasterxml.jackson.core.ObjectCodec objectCodec8 = null;
        ClassLoader classLoader9 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory10 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader9);
        javax.xml.stream.XMLOutputFactory xMLOutputFactory11 = null;
        XmlFactory xmlFactory12 = new XmlFactory(objectCodec8, xMLInputFactory10, xMLOutputFactory11);
        boolean boolean13 = caseInsensitiveNameSet6.remove((Object) xMLOutputFactory11);
        org.junit.Assert.assertNotNull(strArray2);
        org.junit.Assert.assertArrayEquals(strArray2, new String[] { "", "" });
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(strSpliterator5);
        org.junit.Assert.assertNotNull(caseInsensitiveNameSet6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 1 + "'", int7 == 1);
        org.junit.Assert.assertNotNull(xMLInputFactory10);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test325() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test325");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_3 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_3, " ", "hi!", 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test326() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test326");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        com.fasterxml.jackson.databind.BeanProperty beanProperty3 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer4 = defaultSerializerProvider2.findNullValueSerializer(beanProperty3);
        JacksonXmlModule jacksonXmlModule5 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers6 = null;
        jacksonXmlModule5.setKeySerializers(simpleSerializers6);
        Class[] classArray9 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray10 = (Class<?>[]) classArray9;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule11 = jacksonXmlModule5.registerSubtypes((Class<?>[]) classArray9);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver12 = null;
        jacksonXmlModule5.setAbstractTypes(simpleAbstractTypeResolver12);
        jacksonXmlModule5.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.BeanSerializerModifier beanSerializerModifier16 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule17 = jacksonXmlModule5.setSerializerModifier(beanSerializerModifier16);
        JacksonXmlModule jacksonXmlModule18 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers19 = null;
        jacksonXmlModule18.setKeySerializers(simpleSerializers19);
        Class[] classArray22 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray23 = (Class<?>[]) classArray22;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule24 = jacksonXmlModule18.registerSubtypes((Class<?>[]) classArray22);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver25 = null;
        jacksonXmlModule18.setAbstractTypes(simpleAbstractTypeResolver25);
        jacksonXmlModule18.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.SerializerFactory serializerFactory29 = null;
        JacksonXmlModule jacksonXmlModule30 = jacksonXmlModule18.overrideSerializerFactory(serializerFactory29);
        com.fasterxml.jackson.core.ObjectCodec objectCodec31 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory34 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory35 = null;
        XmlFactory xmlFactory37 = new XmlFactory(objectCodec31, (int) 'a', 10, xMLInputFactory34, xMLOutputFactory35, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator38 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory39 = xmlFactory37.setOutputDecorator(outputDecorator38);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature40 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory41 = xmlFactory37.disable(feature40);
        Class<com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature> featureClass42 = xmlFactory37.getFormatWriteFeatureType();
        com.fasterxml.jackson.databind.deser.ValueInstantiator valueInstantiator43 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule44 = jacksonXmlModule18.addValueInstantiator(featureClass42, valueInstantiator43);
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup45 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider46 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup45);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider47 = xmlSerializerProvider46.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer48 = defaultSerializerProvider47.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer49 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer50 = objJsonSerializer48.unwrappingSerializer(nameTransformer49);
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule51 = simpleModule17.addKeySerializer(featureClass42, objJsonSerializer48);
        com.fasterxml.jackson.databind.BeanProperty beanProperty52 = null;
        com.fasterxml.jackson.databind.JsonSerializer<?> wildcardJsonSerializer53 = defaultSerializerProvider2.handleSecondaryContextualization(objJsonSerializer48, beanProperty52);
        com.fasterxml.jackson.core.ObjectCodec objectCodec54 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory57 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory58 = null;
        XmlFactory xmlFactory60 = new XmlFactory(objectCodec54, (int) 'a', 10, xMLInputFactory57, xMLOutputFactory58, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator61 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory62 = xmlFactory60.setOutputDecorator(outputDecorator61);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature63 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory64 = xmlFactory60.disable(feature63);
        Class<com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature> featureClass65 = xmlFactory60.getFormatWriteFeatureType();
        com.fasterxml.jackson.databind.BeanProperty beanProperty66 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer67 = defaultSerializerProvider2.findKeySerializer(featureClass65, beanProperty66);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(objJsonSerializer4);
        org.junit.Assert.assertNotNull(classArray9);
        org.junit.Assert.assertArrayEquals(classArray9, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray10);
        org.junit.Assert.assertArrayEquals(wildcardClassArray10, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule11);
        org.junit.Assert.assertNotNull(simpleModule17);
        org.junit.Assert.assertNotNull(classArray22);
        org.junit.Assert.assertArrayEquals(classArray22, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray23);
        org.junit.Assert.assertArrayEquals(wildcardClassArray23, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule24);
        org.junit.Assert.assertNotNull(jacksonXmlModule30);
        org.junit.Assert.assertNotNull(jsonFactory39);
        org.junit.Assert.assertTrue("'" + feature40 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature40.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory41);
        org.junit.Assert.assertNotNull(featureClass42);
        org.junit.Assert.assertNotNull(simpleModule44);
        org.junit.Assert.assertNotNull(defaultSerializerProvider47);
        org.junit.Assert.assertNotNull(objJsonSerializer48);
        org.junit.Assert.assertNotNull(objJsonSerializer50);
        org.junit.Assert.assertNotNull(simpleModule51);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer53);
        org.junit.Assert.assertNotNull(jsonFactory62);
        org.junit.Assert.assertTrue("'" + feature63 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature63.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory64);
        org.junit.Assert.assertNotNull(featureClass65);
    }

    @Test
    public void test327() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test327");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        XmlFactory xmlFactory1 = new XmlFactory(objectCodec0);
        XmlNameProcessor xmlNameProcessor2 = xmlFactory1.getXmlNameProcessor();
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        xmlFactory1.setXMLInputFactory(xMLInputFactory3);
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder5 = new XmlFactoryBuilder(xmlFactory1);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchFieldError; message: _streamReadConstraints");
        } catch (NoSuchFieldError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlNameProcessor2);
    }

    @Test
    public void test328() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test328");
        JacksonXmlModule jacksonXmlModule0 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.jsontype.NamedType namedType1 = null;
        com.fasterxml.jackson.databind.jsontype.NamedType[] namedTypeArray2 = new com.fasterxml.jackson.databind.jsontype.NamedType[] { namedType1 };
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule3 = jacksonXmlModule0.registerSubtypes(namedTypeArray2);
        com.fasterxml.jackson.databind.module.SimpleValueInstantiators simpleValueInstantiators4 = null;
        jacksonXmlModule0.setValueInstantiators(simpleValueInstantiators4);
        com.fasterxml.jackson.databind.ser.BeanSerializerModifier beanSerializerModifier6 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule7 = jacksonXmlModule0.setSerializerModifier(beanSerializerModifier6);
        org.junit.Assert.assertNotNull(namedTypeArray2);
        org.junit.Assert.assertArrayEquals(namedTypeArray2, new com.fasterxml.jackson.databind.jsontype.NamedType[] { null });
        org.junit.Assert.assertNotNull(simpleModule3);
        org.junit.Assert.assertNotNull(simpleModule7);
    }

    @Test
    public void test329() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test329");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature0 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        int int1 = feature0.getMask();
        boolean boolean2 = feature0.enabledByDefault();
        boolean boolean4 = feature0.enabledIn((int) (byte) 100);
        org.junit.Assert.assertTrue("'" + feature0 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature0.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 2 + "'", int1 == 2);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test330() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test330");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        defaultSerializerProvider2.flushCachedSerializers();
        com.fasterxml.jackson.databind.JavaType javaType4 = null;
        JacksonXmlModule jacksonXmlModule5 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers6 = null;
        jacksonXmlModule5.setKeySerializers(simpleSerializers6);
        Class[] classArray9 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray10 = (Class<?>[]) classArray9;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule11 = jacksonXmlModule5.registerSubtypes((Class<?>[]) classArray9);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver12 = null;
        jacksonXmlModule5.setAbstractTypes(simpleAbstractTypeResolver12);
        JacksonXmlModule jacksonXmlModule14 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers15 = null;
        jacksonXmlModule14.setKeySerializers(simpleSerializers15);
        Class[] classArray18 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray19 = (Class<?>[]) classArray18;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule20 = jacksonXmlModule14.registerSubtypes((Class<?>[]) classArray18);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver21 = null;
        jacksonXmlModule14.setAbstractTypes(simpleAbstractTypeResolver21);
        jacksonXmlModule14.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.SerializerFactory serializerFactory25 = null;
        JacksonXmlModule jacksonXmlModule26 = jacksonXmlModule14.overrideSerializerFactory(serializerFactory25);
        com.fasterxml.jackson.core.ObjectCodec objectCodec27 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory30 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory31 = null;
        XmlFactory xmlFactory33 = new XmlFactory(objectCodec27, (int) 'a', 10, xMLInputFactory30, xMLOutputFactory31, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator34 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory35 = xmlFactory33.setOutputDecorator(outputDecorator34);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature36 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory37 = xmlFactory33.disable(feature36);
        Class<com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature> featureClass38 = xmlFactory33.getFormatWriteFeatureType();
        com.fasterxml.jackson.databind.deser.ValueInstantiator valueInstantiator39 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule40 = jacksonXmlModule14.addValueInstantiator(featureClass38, valueInstantiator39);
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup41 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider42 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup41);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider43 = xmlSerializerProvider42.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer44 = defaultSerializerProvider43.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule45 = jacksonXmlModule5.addKeySerializer(featureClass38, objJsonSerializer44);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.JavaType javaType46 = defaultSerializerProvider2.constructSpecializedType(javaType4, featureClass38);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(classArray9);
        org.junit.Assert.assertArrayEquals(classArray9, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray10);
        org.junit.Assert.assertArrayEquals(wildcardClassArray10, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule11);
        org.junit.Assert.assertNotNull(classArray18);
        org.junit.Assert.assertArrayEquals(classArray18, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray19);
        org.junit.Assert.assertArrayEquals(wildcardClassArray19, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule20);
        org.junit.Assert.assertNotNull(jacksonXmlModule26);
        org.junit.Assert.assertNotNull(jsonFactory35);
        org.junit.Assert.assertTrue("'" + feature36 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature36.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory37);
        org.junit.Assert.assertNotNull(featureClass38);
        org.junit.Assert.assertNotNull(simpleModule40);
        org.junit.Assert.assertNotNull(defaultSerializerProvider43);
        org.junit.Assert.assertNotNull(objJsonSerializer44);
        org.junit.Assert.assertNotNull(simpleModule45);
    }

    @Test
    public void test331() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test331");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer3 = defaultSerializerProvider2.getDefaultNullKeySerializer();
        Class<?> wildcardClass4 = defaultSerializerProvider2.getActiveView();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator6 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultSerializerProvider2.defaultSerializeDateValue((long) '4', jsonGenerator6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(objJsonSerializer3);
        org.junit.Assert.assertNull(wildcardClass4);
    }

    @Test
    public void test332() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test332");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.beforeArrayValues(jsonGenerator1);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_3 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_3, "XML", "JSON", (double) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test333() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test333");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
        defaultXmlPrettyPrinter0.beforeObjectEntries(jsonGenerator5);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator7 = null;
        defaultXmlPrettyPrinter0.writeEndArray(jsonGenerator7, (int) (short) 1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator10 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeEndObject(jsonGenerator10, 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test334() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test334");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup2 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider3 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup2);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider4 = xmlSerializerProvider3.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer5 = defaultSerializerProvider4.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.BeanProperty beanProperty6 = null;
        com.fasterxml.jackson.databind.JsonSerializer<?> wildcardJsonSerializer7 = xmlSerializerProvider1.handleSecondaryContextualization(objJsonSerializer5, beanProperty6);
        com.fasterxml.jackson.databind.SerializationConfig serializationConfig8 = xmlSerializerProvider1.getConfig();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator9 = null;
        com.fasterxml.jackson.core.ObjectCodec objectCodec10 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory13 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory14 = null;
        XmlFactory xmlFactory16 = new XmlFactory(objectCodec10, (int) 'a', 10, xMLInputFactory13, xMLOutputFactory14, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator17 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory18 = xmlFactory16.setOutputDecorator(outputDecorator17);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature19 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory20 = xmlFactory16.disable(feature19);
        com.fasterxml.jackson.databind.JavaType javaType21 = null;
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup22 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider23 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup22);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider24 = xmlSerializerProvider23.copy();
        com.fasterxml.jackson.databind.BeanProperty beanProperty25 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer26 = defaultSerializerProvider24.findNullValueSerializer(beanProperty25);
        JacksonXmlModule jacksonXmlModule27 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers28 = null;
        jacksonXmlModule27.setKeySerializers(simpleSerializers28);
        Class[] classArray31 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray32 = (Class<?>[]) classArray31;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule33 = jacksonXmlModule27.registerSubtypes((Class<?>[]) classArray31);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver34 = null;
        jacksonXmlModule27.setAbstractTypes(simpleAbstractTypeResolver34);
        jacksonXmlModule27.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.BeanSerializerModifier beanSerializerModifier38 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule39 = jacksonXmlModule27.setSerializerModifier(beanSerializerModifier38);
        JacksonXmlModule jacksonXmlModule40 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers41 = null;
        jacksonXmlModule40.setKeySerializers(simpleSerializers41);
        Class[] classArray44 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray45 = (Class<?>[]) classArray44;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule46 = jacksonXmlModule40.registerSubtypes((Class<?>[]) classArray44);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver47 = null;
        jacksonXmlModule40.setAbstractTypes(simpleAbstractTypeResolver47);
        jacksonXmlModule40.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.SerializerFactory serializerFactory51 = null;
        JacksonXmlModule jacksonXmlModule52 = jacksonXmlModule40.overrideSerializerFactory(serializerFactory51);
        com.fasterxml.jackson.core.ObjectCodec objectCodec53 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory56 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory57 = null;
        XmlFactory xmlFactory59 = new XmlFactory(objectCodec53, (int) 'a', 10, xMLInputFactory56, xMLOutputFactory57, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator60 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory61 = xmlFactory59.setOutputDecorator(outputDecorator60);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature62 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory63 = xmlFactory59.disable(feature62);
        Class<com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature> featureClass64 = xmlFactory59.getFormatWriteFeatureType();
        com.fasterxml.jackson.databind.deser.ValueInstantiator valueInstantiator65 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule66 = jacksonXmlModule40.addValueInstantiator(featureClass64, valueInstantiator65);
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup67 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider68 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup67);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider69 = xmlSerializerProvider68.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer70 = defaultSerializerProvider69.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer71 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer72 = objJsonSerializer70.unwrappingSerializer(nameTransformer71);
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule73 = simpleModule39.addKeySerializer(featureClass64, objJsonSerializer70);
        com.fasterxml.jackson.databind.BeanProperty beanProperty74 = null;
        com.fasterxml.jackson.databind.JsonSerializer<?> wildcardJsonSerializer75 = defaultSerializerProvider24.handleSecondaryContextualization(objJsonSerializer70, beanProperty74);
        // The following exception was thrown during execution in test generation
        try {
            xmlSerializerProvider1.serializeValue(jsonGenerator9, (Object) feature19, javaType21, objJsonSerializer70);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchFieldError; message: _generator");
        } catch (NoSuchFieldError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider4);
        org.junit.Assert.assertNotNull(objJsonSerializer5);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer7);
        org.junit.Assert.assertNull(serializationConfig8);
        org.junit.Assert.assertNotNull(jsonFactory18);
        org.junit.Assert.assertTrue("'" + feature19 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature19.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory20);
        org.junit.Assert.assertNotNull(defaultSerializerProvider24);
        org.junit.Assert.assertNotNull(objJsonSerializer26);
        org.junit.Assert.assertNotNull(classArray31);
        org.junit.Assert.assertArrayEquals(classArray31, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray32);
        org.junit.Assert.assertArrayEquals(wildcardClassArray32, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule33);
        org.junit.Assert.assertNotNull(simpleModule39);
        org.junit.Assert.assertNotNull(classArray44);
        org.junit.Assert.assertArrayEquals(classArray44, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray45);
        org.junit.Assert.assertArrayEquals(wildcardClassArray45, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule46);
        org.junit.Assert.assertNotNull(jacksonXmlModule52);
        org.junit.Assert.assertNotNull(jsonFactory61);
        org.junit.Assert.assertTrue("'" + feature62 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature62.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory63);
        org.junit.Assert.assertNotNull(featureClass64);
        org.junit.Assert.assertNotNull(simpleModule66);
        org.junit.Assert.assertNotNull(defaultSerializerProvider69);
        org.junit.Assert.assertNotNull(objJsonSerializer70);
        org.junit.Assert.assertNotNull(objJsonSerializer72);
        org.junit.Assert.assertNotNull(simpleModule73);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer75);
    }

    @Test
    public void test335() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test335");
        String[] strArray2 = new String[] { "", "" };
        java.util.LinkedHashSet<String> strSet3 = new java.util.LinkedHashSet<String>();
        boolean boolean4 = java.util.Collections.addAll((java.util.Collection<String>) strSet3, strArray2);
        java.util.Spliterator<String> strSpliterator5 = strSet3.spliterator();
        com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet caseInsensitiveNameSet6 = com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet.construct((java.util.Set<String>) strSet3);
        java.util.Iterator<String> strItor7 = caseInsensitiveNameSet6.iterator();
        com.fasterxml.jackson.annotation.JsonInclude.Value value8 = com.fasterxml.jackson.databind.BeanProperty.EMPTY_INCLUDE;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = caseInsensitiveNameSet6.contains((Object) value8);
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: com.fasterxml.jackson.annotation.JsonInclude$Value cannot be cast to java.lang.String");
        } catch (ClassCastException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray2);
        org.junit.Assert.assertArrayEquals(strArray2, new String[] { "", "" });
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(strSpliterator5);
        org.junit.Assert.assertNotNull(caseInsensitiveNameSet6);
        org.junit.Assert.assertNotNull(strItor7);
        org.junit.Assert.assertNotNull(value8);
    }

    @Test
    public void test336() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test336");
        com.fasterxml.jackson.databind.JavaType javaType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean1 = com.fasterxml.jackson.dataformat.xml.util.TypeUtil.isIndexedType(javaType0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test337() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test337");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup2 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider3 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup2);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider4 = xmlSerializerProvider3.copy();
        com.fasterxml.jackson.databind.BeanProperty beanProperty5 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer6 = defaultSerializerProvider4.findNullValueSerializer(beanProperty5);
        JacksonXmlModule jacksonXmlModule7 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers8 = null;
        jacksonXmlModule7.setKeySerializers(simpleSerializers8);
        Class[] classArray11 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray12 = (Class<?>[]) classArray11;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule13 = jacksonXmlModule7.registerSubtypes((Class<?>[]) classArray11);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver14 = null;
        jacksonXmlModule7.setAbstractTypes(simpleAbstractTypeResolver14);
        jacksonXmlModule7.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.BeanSerializerModifier beanSerializerModifier18 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule19 = jacksonXmlModule7.setSerializerModifier(beanSerializerModifier18);
        JacksonXmlModule jacksonXmlModule20 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers21 = null;
        jacksonXmlModule20.setKeySerializers(simpleSerializers21);
        Class[] classArray24 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray25 = (Class<?>[]) classArray24;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule26 = jacksonXmlModule20.registerSubtypes((Class<?>[]) classArray24);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver27 = null;
        jacksonXmlModule20.setAbstractTypes(simpleAbstractTypeResolver27);
        jacksonXmlModule20.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.SerializerFactory serializerFactory31 = null;
        JacksonXmlModule jacksonXmlModule32 = jacksonXmlModule20.overrideSerializerFactory(serializerFactory31);
        com.fasterxml.jackson.core.ObjectCodec objectCodec33 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory36 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory37 = null;
        XmlFactory xmlFactory39 = new XmlFactory(objectCodec33, (int) 'a', 10, xMLInputFactory36, xMLOutputFactory37, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator40 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory41 = xmlFactory39.setOutputDecorator(outputDecorator40);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature42 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory43 = xmlFactory39.disable(feature42);
        Class<com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature> featureClass44 = xmlFactory39.getFormatWriteFeatureType();
        com.fasterxml.jackson.databind.deser.ValueInstantiator valueInstantiator45 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule46 = jacksonXmlModule20.addValueInstantiator(featureClass44, valueInstantiator45);
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup47 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider48 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup47);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider49 = xmlSerializerProvider48.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer50 = defaultSerializerProvider49.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer51 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer52 = objJsonSerializer50.unwrappingSerializer(nameTransformer51);
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule53 = simpleModule19.addKeySerializer(featureClass44, objJsonSerializer50);
        com.fasterxml.jackson.databind.BeanProperty beanProperty54 = null;
        com.fasterxml.jackson.databind.JsonSerializer<?> wildcardJsonSerializer55 = defaultSerializerProvider4.handleSecondaryContextualization(objJsonSerializer50, beanProperty54);
        boolean boolean56 = objJsonSerializer50.isUnwrappingSerializer();
        xmlSerializerProvider1.setNullKeySerializer(objJsonSerializer50);
        org.junit.Assert.assertNotNull(defaultSerializerProvider4);
        org.junit.Assert.assertNotNull(objJsonSerializer6);
        org.junit.Assert.assertNotNull(classArray11);
        org.junit.Assert.assertArrayEquals(classArray11, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray12);
        org.junit.Assert.assertArrayEquals(wildcardClassArray12, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule13);
        org.junit.Assert.assertNotNull(simpleModule19);
        org.junit.Assert.assertNotNull(classArray24);
        org.junit.Assert.assertArrayEquals(classArray24, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray25);
        org.junit.Assert.assertArrayEquals(wildcardClassArray25, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule26);
        org.junit.Assert.assertNotNull(jacksonXmlModule32);
        org.junit.Assert.assertNotNull(jsonFactory41);
        org.junit.Assert.assertTrue("'" + feature42 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature42.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory43);
        org.junit.Assert.assertNotNull(featureClass44);
        org.junit.Assert.assertNotNull(simpleModule46);
        org.junit.Assert.assertNotNull(defaultSerializerProvider49);
        org.junit.Assert.assertNotNull(objJsonSerializer50);
        org.junit.Assert.assertNotNull(objJsonSerializer52);
        org.junit.Assert.assertNotNull(simpleModule53);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer55);
        org.junit.Assert.assertTrue("'" + boolean56 + "' != '" + false + "'", boolean56 == false);
    }

    @Test
    public void test338() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test338");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        defaultXmlPrettyPrinter0.writeEndArray(jsonGenerator3, (int) (byte) 0);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator6 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator6);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter9 = defaultXmlPrettyPrinter0.withCustomNewLine("XML");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator10 = null;
        defaultXmlPrettyPrinter9.writeObjectFieldValueSeparator(jsonGenerator10);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_12 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter9.writeStartElement(xMLStreamWriter2_12, "hi_", "JSON");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter9);
    }

    @Test
    public void test339() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test339");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator3 = null;
        XmlFactoryBuilder xmlFactoryBuilder4 = xmlFactoryBuilder0.inputDecorator(inputDecorator3);
        XmlFactoryBuilder xmlFactoryBuilder5 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator6 = xmlFactoryBuilder5.inputDecorator();
        ClassLoader classLoader7 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory8 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader7);
        XmlFactoryBuilder xmlFactoryBuilder9 = xmlFactoryBuilder5.inputFactory(xMLInputFactory8);
        XmlFactoryBuilder xmlFactoryBuilder10 = xmlFactoryBuilder4.inputFactory(xMLInputFactory8);
        String str11 = xmlFactoryBuilder4.nameForTextElement();
        com.fasterxml.jackson.core.StreamReadFeature streamReadFeature12 = null;
        com.fasterxml.jackson.core.StreamReadFeature[] streamReadFeatureArray13 = new com.fasterxml.jackson.core.StreamReadFeature[] {};
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder14 = xmlFactoryBuilder4.enable(streamReadFeature12, streamReadFeatureArray13);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertNull(inputDecorator6);
        org.junit.Assert.assertNotNull(xMLInputFactory8);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder9);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder10);
        org.junit.Assert.assertNull(str11);
        org.junit.Assert.assertNotNull(streamReadFeatureArray13);
        org.junit.Assert.assertArrayEquals(streamReadFeatureArray13, new com.fasterxml.jackson.core.StreamReadFeature[] {});
    }

    @Test
    public void test340() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test340");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.core.io.CharacterEscapes characterEscapes9 = xmlFactory6.getCharacterEscapes();
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature10 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        boolean boolean12 = feature10.enabledIn((int) (short) 0);
        boolean boolean14 = feature10.enabledIn((int) ' ');
        XmlFactory xmlFactory15 = xmlFactory6.enable(feature10);
        com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser.Feature feature16 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean17 = xmlFactory15.isEnabled(feature16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertNull(characterEscapes9);
        org.junit.Assert.assertTrue("'" + feature10 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature10.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertNotNull(xmlFactory15);
    }

    @Test
    public void test341() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test341");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator3);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_5 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_5, "org.codehaus.stax2.propDtdOverride", " ", (double) 56320);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test342() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test342");
        javax.xml.stream.XMLInputFactory xMLInputFactory0 = null;
        XmlFactoryBuilder xmlFactoryBuilder1 = XmlFactory.builder();
        XmlFactoryBuilder xmlFactoryBuilder3 = xmlFactoryBuilder1.nameForTextElement("");
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = xmlFactoryBuilder3.xmlOutputFactory();
        // The following exception was thrown during execution in test generation
        try {
            XmlMapper xmlMapper5 = new XmlMapper(xMLInputFactory0, xMLOutputFactory4);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlMapper.coercionConfigDefaults()Lcom/fasterxml/jackson/databind/cfg/MutableCoercionConfig;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder1);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder3);
        org.junit.Assert.assertNotNull(xMLOutputFactory4);
    }

    @Test
    public void test343() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test343");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature3 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder0.configure(jsonReadFeature3, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
    }

    @Test
    public void test344() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test344");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.formatParserFeaturesMask();
        String str4 = xmlFactoryBuilder0.nameForTextElement();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator5 = null;
        XmlFactoryBuilder xmlFactoryBuilder6 = xmlFactoryBuilder0.outputDecorator(outputDecorator5);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder6);
    }

    @Test
    public void test345() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test345");
        com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializerModifier xmlBeanSerializerModifier0 = new com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializerModifier();
        com.fasterxml.jackson.databind.SerializationConfig serializationConfig1 = null;
        com.fasterxml.jackson.databind.BeanDescription beanDescription2 = null;
        java.util.List<com.fasterxml.jackson.databind.ser.BeanPropertyWriter> beanPropertyWriterList3 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.List<com.fasterxml.jackson.databind.ser.BeanPropertyWriter> beanPropertyWriterList4 = xmlBeanSerializerModifier0.changeProperties(serializationConfig1, beanDescription2, beanPropertyWriterList3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test346() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test346");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder0.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature6 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactoryBuilder xmlFactoryBuilder7 = XmlFactory.builder();
        XmlFactoryBuilder xmlFactoryBuilder9 = xmlFactoryBuilder7.nameForTextElement("");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature10 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean11 = feature10.enabledByDefault();
        XmlFactoryBuilder xmlFactoryBuilder12 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator13 = null;
        XmlFactoryBuilder xmlFactoryBuilder14 = xmlFactoryBuilder12.outputDecorator(outputDecorator13);
        int int15 = xmlFactoryBuilder12.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder17 = xmlFactoryBuilder12.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature18 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature19 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean21 = feature19.enabledIn((int) '#');
        com.fasterxml.jackson.core.ObjectCodec objectCodec22 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory25 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory26 = null;
        XmlFactory xmlFactory28 = new XmlFactory(objectCodec22, (int) 'a', 10, xMLInputFactory25, xMLOutputFactory26, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator29 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory30 = xmlFactory28.setOutputDecorator(outputDecorator29);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature31 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory32 = xmlFactory28.disable(feature31);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature33 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature34 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] featureArray35 = new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { feature19, feature31, feature33, feature34 };
        XmlFactoryBuilder xmlFactoryBuilder36 = xmlFactoryBuilder17.disable(feature18, featureArray35);
        XmlFactoryBuilder xmlFactoryBuilder37 = xmlFactoryBuilder9.disable(feature10, featureArray35);
        XmlFactoryBuilder xmlFactoryBuilder38 = xmlFactoryBuilder0.disable(feature6, featureArray35);
        com.fasterxml.jackson.core.json.JsonWriteFeature jsonWriteFeature39 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder41 = xmlFactoryBuilder0.configure(jsonWriteFeature39, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertTrue("'" + feature6 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature6.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactoryBuilder7);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder9);
        org.junit.Assert.assertTrue("'" + feature10 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature10.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder12);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 4 + "'", int15 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder17);
        org.junit.Assert.assertTrue("'" + feature18 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature18.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + feature19 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature19.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(jsonFactory30);
        org.junit.Assert.assertTrue("'" + feature31 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature31.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory32);
        org.junit.Assert.assertTrue("'" + feature33 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature33.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertTrue("'" + feature34 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature34.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(featureArray35);
        org.junit.Assert.assertArrayEquals(featureArray35, new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 });
        org.junit.Assert.assertNotNull(xmlFactoryBuilder36);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder37);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder38);
    }

    @Test
    public void test347() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test347");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        XmlFactory xmlFactory1 = new XmlFactory(objectCodec0);
        XmlNameProcessor xmlNameProcessor2 = xmlFactory1.getXmlNameProcessor();
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        xmlFactory1.setXMLInputFactory(xMLInputFactory3);
        com.fasterxml.jackson.core.ObjectCodec objectCodec5 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory6 = xmlFactory1.setCodec(objectCodec5);
        java.io.InputStream inputStream7 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser8 = xmlFactory1.createParser(inputStream7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlNameProcessor2);
        org.junit.Assert.assertNotNull(jsonFactory6);
    }

    @Test
    public void test348() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test348");
        XmlNameProcessor xmlNameProcessor0 = XmlNameProcessors.newPassthroughProcessor();
        com.fasterxml.jackson.core.ObjectCodec objectCodec1 = null;
        XmlFactory xmlFactory2 = new XmlFactory(objectCodec1);
        XmlNameProcessor xmlNameProcessor3 = xmlFactory2.getXmlNameProcessor();
        XmlNameProcessor.XmlName xmlName4 = new XmlNameProcessor.XmlName();
        xmlNameProcessor3.encodeName(xmlName4);
        String str6 = xmlName4.namespace;
        xmlName4.namespace = " ";
        xmlNameProcessor0.encodeName(xmlName4);
        org.junit.Assert.assertNotNull(xmlNameProcessor0);
        org.junit.Assert.assertNotNull(xmlNameProcessor3);
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test349() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test349");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator3);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter5 = defaultXmlPrettyPrinter0.createInstance();
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_6 = null;
        char[] charArray14 = new char[] { '4', '#', '#', '4', '4' };
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_6, "JacksonXmlModule", "", charArray14, 11, (int) '4', true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter5);
        org.junit.Assert.assertNotNull(charArray14);
        org.junit.Assert.assertArrayEquals(charArray14, new char[] { '4', '#', '#', '4', '4' });
    }

    @Test
    public void test350() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test350");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        com.fasterxml.jackson.core.JsonFactory.Feature feature11 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonFactory jsonFactory12 = xmlFactory6.disable(feature11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
    }

    @Test
    public void test351() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test351");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        defaultSerializerProvider2.flushCachedSerializers();
        com.fasterxml.jackson.databind.introspect.Annotated annotated4 = null;
        com.fasterxml.jackson.core.ObjectCodec objectCodec5 = null;
        ClassLoader classLoader6 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory7 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader6);
        javax.xml.stream.XMLOutputFactory xMLOutputFactory8 = null;
        XmlFactory xmlFactory9 = new XmlFactory(objectCodec5, xMLInputFactory7, xMLOutputFactory8);
        com.fasterxml.jackson.databind.util.Converter<Object, Object> objConverter10 = defaultSerializerProvider2.converterInstance(annotated4, (Object) objectCodec5);
        Class<?> wildcardClass11 = defaultSerializerProvider2.getActiveView();
        JacksonXmlModule jacksonXmlModule12 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers13 = null;
        jacksonXmlModule12.setKeySerializers(simpleSerializers13);
        Class[] classArray16 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray17 = (Class<?>[]) classArray16;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule18 = jacksonXmlModule12.registerSubtypes((Class<?>[]) classArray16);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver19 = null;
        jacksonXmlModule12.setAbstractTypes(simpleAbstractTypeResolver19);
        jacksonXmlModule12.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.BeanSerializerModifier beanSerializerModifier23 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule24 = jacksonXmlModule12.setSerializerModifier(beanSerializerModifier23);
        JacksonXmlModule jacksonXmlModule25 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers26 = null;
        jacksonXmlModule25.setKeySerializers(simpleSerializers26);
        Class[] classArray29 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray30 = (Class<?>[]) classArray29;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule31 = jacksonXmlModule25.registerSubtypes((Class<?>[]) classArray29);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver32 = null;
        jacksonXmlModule25.setAbstractTypes(simpleAbstractTypeResolver32);
        jacksonXmlModule25.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.SerializerFactory serializerFactory36 = null;
        JacksonXmlModule jacksonXmlModule37 = jacksonXmlModule25.overrideSerializerFactory(serializerFactory36);
        com.fasterxml.jackson.core.ObjectCodec objectCodec38 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory41 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory42 = null;
        XmlFactory xmlFactory44 = new XmlFactory(objectCodec38, (int) 'a', 10, xMLInputFactory41, xMLOutputFactory42, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator45 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory46 = xmlFactory44.setOutputDecorator(outputDecorator45);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature47 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory48 = xmlFactory44.disable(feature47);
        Class<com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature> featureClass49 = xmlFactory44.getFormatWriteFeatureType();
        com.fasterxml.jackson.databind.deser.ValueInstantiator valueInstantiator50 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule51 = jacksonXmlModule25.addValueInstantiator(featureClass49, valueInstantiator50);
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup52 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider53 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup52);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider54 = xmlSerializerProvider53.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer55 = defaultSerializerProvider54.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer56 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer57 = objJsonSerializer55.unwrappingSerializer(nameTransformer56);
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule58 = simpleModule24.addKeySerializer(featureClass49, objJsonSerializer55);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.JavaType javaType59 = defaultSerializerProvider2.constructType((java.lang.reflect.Type) featureClass49);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(xMLInputFactory7);
        org.junit.Assert.assertNull(objConverter10);
        org.junit.Assert.assertNull(wildcardClass11);
        org.junit.Assert.assertNotNull(classArray16);
        org.junit.Assert.assertArrayEquals(classArray16, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray17);
        org.junit.Assert.assertArrayEquals(wildcardClassArray17, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule18);
        org.junit.Assert.assertNotNull(simpleModule24);
        org.junit.Assert.assertNotNull(classArray29);
        org.junit.Assert.assertArrayEquals(classArray29, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray30);
        org.junit.Assert.assertArrayEquals(wildcardClassArray30, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule31);
        org.junit.Assert.assertNotNull(jacksonXmlModule37);
        org.junit.Assert.assertNotNull(jsonFactory46);
        org.junit.Assert.assertTrue("'" + feature47 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature47.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory48);
        org.junit.Assert.assertNotNull(featureClass49);
        org.junit.Assert.assertNotNull(simpleModule51);
        org.junit.Assert.assertNotNull(defaultSerializerProvider54);
        org.junit.Assert.assertNotNull(objJsonSerializer55);
        org.junit.Assert.assertNotNull(objJsonSerializer57);
        org.junit.Assert.assertNotNull(simpleModule58);
    }

    @Test
    public void test352() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test352");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator3 = xmlFactoryBuilder0.inputDecorator();
        ClassLoader classLoader4 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory5 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader4);
        XmlFactoryBuilder xmlFactoryBuilder6 = xmlFactoryBuilder0.inputFactory(xMLInputFactory5);
        int int7 = xmlFactoryBuilder0.streamReadFeatures();
        com.fasterxml.jackson.core.json.JsonWriteFeature jsonWriteFeature8 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder9 = xmlFactoryBuilder0.enable(jsonWriteFeature8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertNull(inputDecorator3);
        org.junit.Assert.assertNotNull(xMLInputFactory5);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 1 + "'", int7 == 1);
    }

    @Test
    public void test353() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test353");
        com.fasterxml.jackson.core.Base64Variant base64Variant0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.codehaus.stax2.typed.Base64Variant base64Variant1 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.toStax2Base64Variant(base64Variant0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test354() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test354");
        JacksonXmlModule jacksonXmlModule0 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers1 = null;
        jacksonXmlModule0.setKeySerializers(simpleSerializers1);
        Class[] classArray4 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray5 = (Class<?>[]) classArray4;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule6 = jacksonXmlModule0.registerSubtypes((Class<?>[]) classArray4);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver7 = null;
        jacksonXmlModule0.setAbstractTypes(simpleAbstractTypeResolver7);
        jacksonXmlModule0.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.SerializerFactory serializerFactory11 = null;
        JacksonXmlModule jacksonXmlModule12 = jacksonXmlModule0.overrideSerializerFactory(serializerFactory11);
        com.fasterxml.jackson.core.Version version13 = jacksonXmlModule0.version();
        org.junit.Assert.assertNotNull(classArray4);
        org.junit.Assert.assertArrayEquals(classArray4, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray5);
        org.junit.Assert.assertArrayEquals(wildcardClassArray5, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule6);
        org.junit.Assert.assertNotNull(jacksonXmlModule12);
        org.junit.Assert.assertNotNull(version13);
    }

    @Test
    public void test355() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test355");
        com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext xmlReadContext0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext xmlReadContext4 = new com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext(xmlReadContext0, 10, 8, (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchFieldError; message: _nestingDepth");
        } catch (NoSuchFieldError e) {
            // Expected exception.
        }
    }

    @Test
    public void test356() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test356");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator3 = xmlFactoryBuilder0.inputDecorator();
        ClassLoader classLoader4 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory5 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader4);
        XmlFactoryBuilder xmlFactoryBuilder6 = xmlFactoryBuilder0.inputFactory(xMLInputFactory5);
        ClassLoader classLoader7 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory8 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultOutputFactory(classLoader7);
        XmlFactory xmlFactory9 = new XmlFactory(xMLInputFactory5, xMLOutputFactory8);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertNull(inputDecorator3);
        org.junit.Assert.assertNotNull(xMLInputFactory5);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder6);
        org.junit.Assert.assertNotNull(xMLOutputFactory8);
    }

    @Test
    public void test357() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test357");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup2 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider3 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup2);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider4 = xmlSerializerProvider3.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer5 = defaultSerializerProvider4.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.BeanProperty beanProperty6 = null;
        com.fasterxml.jackson.databind.JsonSerializer<?> wildcardJsonSerializer7 = xmlSerializerProvider1.handleSecondaryContextualization(objJsonSerializer5, beanProperty6);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.type.TypeFactory typeFactory8 = xmlSerializerProvider1.getTypeFactory();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider4);
        org.junit.Assert.assertNotNull(objJsonSerializer5);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer7);
    }

    @Test
    public void test358() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test358");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        defaultXmlPrettyPrinter0.writeEndArray(jsonGenerator3, (int) (byte) 0);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator6 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator6);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter9 = defaultXmlPrettyPrinter0.withCustomNewLine("XML");
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_10 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafXsiNilElement(xMLStreamWriter2_10, "hi!", "hi_");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter9);
    }

    @Test
    public void test359() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test359");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
        defaultXmlPrettyPrinter0.beforeObjectEntries(jsonGenerator5);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator7 = null;
        defaultXmlPrettyPrinter0.writeEndArray(jsonGenerator7, (int) (short) 1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator10 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator10);
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test360() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test360");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator3);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter5 = defaultXmlPrettyPrinter0.createInstance();
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter.Indenter indenter6 = null;
        defaultXmlPrettyPrinter0.indentObjectsWith(indenter6);
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter5);
    }

    @Test
    public void test361() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test361");
        XmlFactory xmlFactory0 = new XmlFactory();
        xmlFactory0.setXMLTextElementName("XML");
        XmlNameProcessor xmlNameProcessor3 = xmlFactory0.getXmlNameProcessor();
        com.fasterxml.jackson.core.ObjectCodec objectCodec4 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory5 = xmlFactory0.setCodec(objectCodec4);
        char[] charArray11 = new char[] { '#', '4', '4', 'a', '#' };
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser12 = jsonFactory5.createParser(charArray11);
            org.junit.Assert.fail("Expected exception of type com.fasterxml.jackson.core.JsonParseException; message: ParseError at [row,col]:[1,1]?Message: Content is not allowed in prolog.");
        } catch (com.fasterxml.jackson.core.JsonParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlNameProcessor3);
        org.junit.Assert.assertNotNull(jsonFactory5);
        org.junit.Assert.assertNotNull(charArray11);
        org.junit.Assert.assertArrayEquals(charArray11, new char[] { '#', '4', '4', 'a', '#' });
    }

    @Test
    public void test362() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test362");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        com.fasterxml.jackson.core.ObjectCodec objectCodec11 = xmlFactory10.getCodec();
        xmlFactory10.setXMLTextElementName("XML");
        java.io.InputStream inputStream14 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser15 = xmlFactory10.createJsonParser(inputStream14);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertNull(objectCodec11);
    }

    @Test
    public void test363() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test363");
        ClassLoader classLoader0 = null;
        java.util.List<com.fasterxml.jackson.databind.Module> moduleList1 = com.fasterxml.jackson.databind.ObjectMapper.findModules(classLoader0);
        org.junit.Assert.assertNotNull(moduleList1);
    }

    @Test
    public void test364() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test364");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        XmlFactory xmlFactory1 = new XmlFactory(objectCodec0);
        XmlNameProcessor xmlNameProcessor2 = xmlFactory1.getXmlNameProcessor();
        java.io.OutputStream outputStream3 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator toXmlGenerator4 = xmlFactory1.createGenerator(outputStream3);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlFactory._createContentReference(Ljava/lang/Object;)Lcom/fasterxml/jackson/core/io/ContentReference;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlNameProcessor2);
    }

    @Test
    public void test365() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test365");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        com.fasterxml.jackson.core.ObjectCodec objectCodec11 = xmlFactory10.getCodec();
        xmlFactory10.setXMLTextElementName("XML");
        com.fasterxml.jackson.core.ObjectCodec objectCodec14 = xmlFactory10.getCodec();
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertNull(objectCodec11);
        org.junit.Assert.assertNull(objectCodec14);
    }

    @Test
    public void test366() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test366");
        JacksonXmlModule jacksonXmlModule0 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers1 = null;
        jacksonXmlModule0.setKeySerializers(simpleSerializers1);
        Class[] classArray4 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray5 = (Class<?>[]) classArray4;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule6 = jacksonXmlModule0.registerSubtypes((Class<?>[]) classArray4);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver7 = null;
        jacksonXmlModule0.setAbstractTypes(simpleAbstractTypeResolver7);
        jacksonXmlModule0.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.SerializerFactory serializerFactory11 = null;
        JacksonXmlModule jacksonXmlModule12 = jacksonXmlModule0.overrideSerializerFactory(serializerFactory11);
        com.fasterxml.jackson.core.ObjectCodec objectCodec13 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory16 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory17 = null;
        XmlFactory xmlFactory19 = new XmlFactory(objectCodec13, (int) 'a', 10, xMLInputFactory16, xMLOutputFactory17, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator20 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory21 = xmlFactory19.setOutputDecorator(outputDecorator20);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature22 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory23 = xmlFactory19.disable(feature22);
        Class<com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature> featureClass24 = xmlFactory19.getFormatWriteFeatureType();
        com.fasterxml.jackson.databind.deser.ValueInstantiator valueInstantiator25 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule26 = jacksonXmlModule0.addValueInstantiator(featureClass24, valueInstantiator25);
        String str27 = jacksonXmlModule0.getModuleName();
        org.junit.Assert.assertNotNull(classArray4);
        org.junit.Assert.assertArrayEquals(classArray4, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray5);
        org.junit.Assert.assertArrayEquals(wildcardClassArray5, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule6);
        org.junit.Assert.assertNotNull(jacksonXmlModule12);
        org.junit.Assert.assertNotNull(jsonFactory21);
        org.junit.Assert.assertTrue("'" + feature22 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature22.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory23);
        org.junit.Assert.assertNotNull(featureClass24);
        org.junit.Assert.assertNotNull(simpleModule26);
        org.junit.Assert.assertEquals("'" + str27 + "' != '" + "JacksonXmlModule" + "'", str27, "JacksonXmlModule");
    }

    @Test
    public void test367() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test367");
        XmlFactory xmlFactory0 = new XmlFactory();
        java.io.Writer writer1 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator toXmlGenerator2 = xmlFactory0.createGenerator(writer1);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlFactory._createContentReference(Ljava/lang/Object;)Lcom/fasterxml/jackson/core/io/ContentReference;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test368() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test368");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup2 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider3 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup2);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider4 = xmlSerializerProvider3.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer5 = defaultSerializerProvider4.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.BeanProperty beanProperty6 = null;
        com.fasterxml.jackson.databind.JsonSerializer<?> wildcardJsonSerializer7 = xmlSerializerProvider1.handleSecondaryContextualization(objJsonSerializer5, beanProperty6);
        XmlFactory xmlFactory8 = new XmlFactory();
        xmlFactory8.setXMLTextElementName("XML");
        Class<com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature> featureClass11 = xmlFactory8.getFormatWriteFeatureType();
        com.fasterxml.jackson.databind.BeanProperty beanProperty12 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer13 = xmlSerializerProvider1.findValueSerializer(featureClass11, beanProperty12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider4);
        org.junit.Assert.assertNotNull(objJsonSerializer5);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer7);
        org.junit.Assert.assertNotNull(featureClass11);
    }

    @Test
    public void test369() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test369");
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext xmlReadContext2 = com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext.createRootContext(11, (int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchFieldError; message: _nestingDepth");
        } catch (NoSuchFieldError e) {
            // Expected exception.
        }
    }

    @Test
    public void test370() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test370");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        defaultSerializerProvider2.flushCachedSerializers();
        com.fasterxml.jackson.databind.introspect.Annotated annotated4 = null;
        com.fasterxml.jackson.core.ObjectCodec objectCodec5 = null;
        ClassLoader classLoader6 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory7 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader6);
        javax.xml.stream.XMLOutputFactory xMLOutputFactory8 = null;
        XmlFactory xmlFactory9 = new XmlFactory(objectCodec5, xMLInputFactory7, xMLOutputFactory8);
        com.fasterxml.jackson.databind.util.Converter<Object, Object> objConverter10 = defaultSerializerProvider2.converterInstance(annotated4, (Object) objectCodec5);
        com.fasterxml.jackson.databind.JavaType javaType11 = null;
        com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper jsonFormatVisitorWrapper12 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultSerializerProvider2.acceptJsonFormatVisitor(javaType11, jsonFormatVisitorWrapper12);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: A class must be provided");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(xMLInputFactory7);
        org.junit.Assert.assertNull(objConverter10);
    }

    @Test
    public void test371() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test371");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        com.fasterxml.jackson.core.io.CharacterEscapes characterEscapes11 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory12 = xmlFactory10.setCharacterEscapes(characterEscapes11);
        com.fasterxml.jackson.core.JsonParser.Feature feature13 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonFactory jsonFactory14 = jsonFactory12.enable(feature13);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertNotNull(jsonFactory12);
    }

    @Test
    public void test372() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test372");
        ClassLoader classLoader0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory1 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader0);
        javax.xml.stream.XMLOutputFactory xMLOutputFactory2 = null;
        XmlFactory xmlFactory3 = new XmlFactory(xMLInputFactory1, xMLOutputFactory2);
        java.io.OutputStream outputStream4 = null;
        com.fasterxml.jackson.core.JsonEncoding jsonEncoding5 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator toXmlGenerator6 = xmlFactory3.createGenerator(outputStream4, jsonEncoding5);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlFactory._createContentReference(Ljava/lang/Object;)Lcom/fasterxml/jackson/core/io/ContentReference;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xMLInputFactory1);
    }

    @Test
    public void test373() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test373");
        XmlFactory xmlFactory0 = new XmlFactory();
        xmlFactory0.setXMLTextElementName("XML");
        XmlNameProcessor xmlNameProcessor3 = xmlFactory0.getXmlNameProcessor();
        com.fasterxml.jackson.core.ObjectCodec objectCodec4 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory5 = xmlFactory0.setCodec(objectCodec4);
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder6 = new XmlFactoryBuilder(xmlFactory0);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchFieldError; message: _streamReadConstraints");
        } catch (NoSuchFieldError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlNameProcessor3);
        org.junit.Assert.assertNotNull(jsonFactory5);
    }

    @Test
    public void test374() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test374");
        int int0 = javax.xml.stream.XMLStreamConstants.ENTITY_DECLARATION;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 15 + "'", int0 == 15);
    }

    @Test
    public void test375() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test375");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
        defaultXmlPrettyPrinter0.beforeObjectEntries(jsonGenerator5);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator7 = null;
        defaultXmlPrettyPrinter0.writeEndArray(jsonGenerator7, (int) (short) 1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator10 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator10);
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test376() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test376");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer3 = defaultSerializerProvider2.getDefaultNullKeySerializer();
        Class<?> wildcardClass4 = defaultSerializerProvider2.getActiveView();
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup5 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider6 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup5);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider7 = xmlSerializerProvider6.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer8 = defaultSerializerProvider7.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer9 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer10 = objJsonSerializer8.unwrappingSerializer(nameTransformer9);
        boolean boolean11 = objJsonSerializer8.isUnwrappingSerializer();
        com.fasterxml.jackson.databind.BeanProperty beanProperty12 = null;
        com.fasterxml.jackson.databind.JsonSerializer<?> wildcardJsonSerializer13 = defaultSerializerProvider2.handleSecondaryContextualization(objJsonSerializer8, beanProperty12);
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(objJsonSerializer3);
        org.junit.Assert.assertNull(wildcardClass4);
        org.junit.Assert.assertNotNull(defaultSerializerProvider7);
        org.junit.Assert.assertNotNull(objJsonSerializer8);
        org.junit.Assert.assertNotNull(objJsonSerializer10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer13);
    }

    @Test
    public void test377() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test377");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.factoryFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder0.nameForTextElement("JSON");
        com.fasterxml.jackson.core.StreamWriteFeature streamWriteFeature6 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder7 = xmlFactoryBuilder5.enable(streamWriteFeature6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 15 + "'", int3 == 15);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
    }

    @Test
    public void test378() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test378");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        defaultSerializerProvider2.flushCachedSerializers();
        com.fasterxml.jackson.databind.introspect.Annotated annotated4 = null;
        com.fasterxml.jackson.core.ObjectCodec objectCodec5 = null;
        ClassLoader classLoader6 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory7 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader6);
        javax.xml.stream.XMLOutputFactory xMLOutputFactory8 = null;
        XmlFactory xmlFactory9 = new XmlFactory(objectCodec5, xMLInputFactory7, xMLOutputFactory8);
        com.fasterxml.jackson.databind.util.Converter<Object, Object> objConverter10 = defaultSerializerProvider2.converterInstance(annotated4, (Object) objectCodec5);
        int int11 = defaultSerializerProvider2.cachedSerializersCount();
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(xMLInputFactory7);
        org.junit.Assert.assertNull(objConverter10);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
    }

    @Test
    public void test379() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test379");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        com.fasterxml.jackson.core.ObjectCodec objectCodec11 = xmlFactory10.getCodec();
        xmlFactory10.setXMLTextElementName("XML");
        com.fasterxml.jackson.core.io.CharacterEscapes characterEscapes14 = xmlFactory10.getCharacterEscapes();
        javax.xml.stream.XMLOutputFactory xMLOutputFactory15 = xmlFactory10.getXMLOutputFactory();
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertNull(objectCodec11);
        org.junit.Assert.assertNull(characterEscapes14);
        org.junit.Assert.assertNotNull(xMLOutputFactory15);
    }

    @Test
    public void test380() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test380");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer3 = defaultSerializerProvider2.getDefaultNullKeySerializer();
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup4 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider5 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup4);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider6 = xmlSerializerProvider5.copy();
        com.fasterxml.jackson.databind.BeanProperty beanProperty7 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer8 = defaultSerializerProvider6.findNullValueSerializer(beanProperty7);
        JacksonXmlModule jacksonXmlModule9 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers10 = null;
        jacksonXmlModule9.setKeySerializers(simpleSerializers10);
        Class[] classArray13 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray14 = (Class<?>[]) classArray13;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule15 = jacksonXmlModule9.registerSubtypes((Class<?>[]) classArray13);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver16 = null;
        jacksonXmlModule9.setAbstractTypes(simpleAbstractTypeResolver16);
        jacksonXmlModule9.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.BeanSerializerModifier beanSerializerModifier20 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule21 = jacksonXmlModule9.setSerializerModifier(beanSerializerModifier20);
        JacksonXmlModule jacksonXmlModule22 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers23 = null;
        jacksonXmlModule22.setKeySerializers(simpleSerializers23);
        Class[] classArray26 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray27 = (Class<?>[]) classArray26;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule28 = jacksonXmlModule22.registerSubtypes((Class<?>[]) classArray26);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver29 = null;
        jacksonXmlModule22.setAbstractTypes(simpleAbstractTypeResolver29);
        jacksonXmlModule22.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.SerializerFactory serializerFactory33 = null;
        JacksonXmlModule jacksonXmlModule34 = jacksonXmlModule22.overrideSerializerFactory(serializerFactory33);
        com.fasterxml.jackson.core.ObjectCodec objectCodec35 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory38 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory39 = null;
        XmlFactory xmlFactory41 = new XmlFactory(objectCodec35, (int) 'a', 10, xMLInputFactory38, xMLOutputFactory39, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator42 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory43 = xmlFactory41.setOutputDecorator(outputDecorator42);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature44 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory45 = xmlFactory41.disable(feature44);
        Class<com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature> featureClass46 = xmlFactory41.getFormatWriteFeatureType();
        com.fasterxml.jackson.databind.deser.ValueInstantiator valueInstantiator47 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule48 = jacksonXmlModule22.addValueInstantiator(featureClass46, valueInstantiator47);
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup49 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider50 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup49);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider51 = xmlSerializerProvider50.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer52 = defaultSerializerProvider51.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer53 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer54 = objJsonSerializer52.unwrappingSerializer(nameTransformer53);
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule55 = simpleModule21.addKeySerializer(featureClass46, objJsonSerializer52);
        com.fasterxml.jackson.databind.BeanProperty beanProperty56 = null;
        com.fasterxml.jackson.databind.JsonSerializer<?> wildcardJsonSerializer57 = defaultSerializerProvider6.handleSecondaryContextualization(objJsonSerializer52, beanProperty56);
        defaultSerializerProvider2.setNullValueSerializer(objJsonSerializer52);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter60 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator61 = null;
        defaultXmlPrettyPrinter60.writeObjectFieldValueSeparator(jsonGenerator61);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator63 = null;
        defaultXmlPrettyPrinter60.writeStartArray(jsonGenerator63);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter65 = defaultXmlPrettyPrinter60.createInstance();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator66 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultSerializerProvider2.defaultSerializeField("xmlInfo", (Object) defaultXmlPrettyPrinter60, jsonGenerator66);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(objJsonSerializer3);
        org.junit.Assert.assertNotNull(defaultSerializerProvider6);
        org.junit.Assert.assertNotNull(objJsonSerializer8);
        org.junit.Assert.assertNotNull(classArray13);
        org.junit.Assert.assertArrayEquals(classArray13, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray14);
        org.junit.Assert.assertArrayEquals(wildcardClassArray14, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule15);
        org.junit.Assert.assertNotNull(simpleModule21);
        org.junit.Assert.assertNotNull(classArray26);
        org.junit.Assert.assertArrayEquals(classArray26, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray27);
        org.junit.Assert.assertArrayEquals(wildcardClassArray27, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule28);
        org.junit.Assert.assertNotNull(jacksonXmlModule34);
        org.junit.Assert.assertNotNull(jsonFactory43);
        org.junit.Assert.assertTrue("'" + feature44 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature44.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory45);
        org.junit.Assert.assertNotNull(featureClass46);
        org.junit.Assert.assertNotNull(simpleModule48);
        org.junit.Assert.assertNotNull(defaultSerializerProvider51);
        org.junit.Assert.assertNotNull(objJsonSerializer52);
        org.junit.Assert.assertNotNull(objJsonSerializer54);
        org.junit.Assert.assertNotNull(simpleModule55);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer57);
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter65);
    }

    @Test
    public void test381() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test381");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        com.fasterxml.jackson.core.ObjectCodec objectCodec11 = xmlFactory10.getCodec();
        xmlFactory10.setXMLTextElementName("XML");
        com.fasterxml.jackson.core.io.CharacterEscapes characterEscapes14 = xmlFactory10.getCharacterEscapes();
        javax.xml.stream.XMLStreamReader xMLStreamReader15 = null;
        org.codehaus.stax2.XMLStreamReader2 xMLStreamReader2_16 = com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter.wrapIfNecessary(xMLStreamReader15);
        org.codehaus.stax2.XMLStreamReader2 xMLStreamReader2_17 = com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter.wrapIfNecessary((javax.xml.stream.XMLStreamReader) xMLStreamReader2_16);
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser fromXmlParser18 = xmlFactory10.createParser((javax.xml.stream.XMLStreamReader) xMLStreamReader2_16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertNull(objectCodec11);
        org.junit.Assert.assertNull(characterEscapes14);
        org.junit.Assert.assertNotNull(xMLStreamReader2_16);
        org.junit.Assert.assertNotNull(xMLStreamReader2_17);
    }

    @Test
    public void test382() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test382");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_5 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_5, "hi!", "JacksonXmlModule", true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test383() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test383");
        com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializerModifier xmlBeanSerializerModifier0 = new com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializerModifier();
        com.fasterxml.jackson.databind.SerializationConfig serializationConfig1 = null;
        com.fasterxml.jackson.databind.type.MapType mapType2 = null;
        com.fasterxml.jackson.databind.BeanDescription beanDescription3 = null;
        JacksonXmlModule jacksonXmlModule4 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers5 = null;
        jacksonXmlModule4.setKeySerializers(simpleSerializers5);
        Class[] classArray8 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray9 = (Class<?>[]) classArray8;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule10 = jacksonXmlModule4.registerSubtypes((Class<?>[]) classArray8);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver11 = null;
        jacksonXmlModule4.setAbstractTypes(simpleAbstractTypeResolver11);
        jacksonXmlModule4.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.BeanSerializerModifier beanSerializerModifier15 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule16 = jacksonXmlModule4.setSerializerModifier(beanSerializerModifier15);
        JacksonXmlModule jacksonXmlModule17 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers18 = null;
        jacksonXmlModule17.setKeySerializers(simpleSerializers18);
        Class[] classArray21 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray22 = (Class<?>[]) classArray21;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule23 = jacksonXmlModule17.registerSubtypes((Class<?>[]) classArray21);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver24 = null;
        jacksonXmlModule17.setAbstractTypes(simpleAbstractTypeResolver24);
        jacksonXmlModule17.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.SerializerFactory serializerFactory28 = null;
        JacksonXmlModule jacksonXmlModule29 = jacksonXmlModule17.overrideSerializerFactory(serializerFactory28);
        com.fasterxml.jackson.core.ObjectCodec objectCodec30 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory33 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory34 = null;
        XmlFactory xmlFactory36 = new XmlFactory(objectCodec30, (int) 'a', 10, xMLInputFactory33, xMLOutputFactory34, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator37 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory38 = xmlFactory36.setOutputDecorator(outputDecorator37);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature39 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory40 = xmlFactory36.disable(feature39);
        Class<com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature> featureClass41 = xmlFactory36.getFormatWriteFeatureType();
        com.fasterxml.jackson.databind.deser.ValueInstantiator valueInstantiator42 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule43 = jacksonXmlModule17.addValueInstantiator(featureClass41, valueInstantiator42);
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup44 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider45 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup44);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider46 = xmlSerializerProvider45.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer47 = defaultSerializerProvider46.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer48 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer49 = objJsonSerializer47.unwrappingSerializer(nameTransformer48);
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule50 = simpleModule16.addKeySerializer(featureClass41, objJsonSerializer47);
        com.fasterxml.jackson.databind.JsonSerializer<?> wildcardJsonSerializer51 = xmlBeanSerializerModifier0.modifyMapSerializer(serializationConfig1, mapType2, beanDescription3, objJsonSerializer47);
        org.junit.Assert.assertNotNull(classArray8);
        org.junit.Assert.assertArrayEquals(classArray8, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray9);
        org.junit.Assert.assertArrayEquals(wildcardClassArray9, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule10);
        org.junit.Assert.assertNotNull(simpleModule16);
        org.junit.Assert.assertNotNull(classArray21);
        org.junit.Assert.assertArrayEquals(classArray21, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray22);
        org.junit.Assert.assertArrayEquals(wildcardClassArray22, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule23);
        org.junit.Assert.assertNotNull(jacksonXmlModule29);
        org.junit.Assert.assertNotNull(jsonFactory38);
        org.junit.Assert.assertTrue("'" + feature39 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature39.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory40);
        org.junit.Assert.assertNotNull(featureClass41);
        org.junit.Assert.assertNotNull(simpleModule43);
        org.junit.Assert.assertNotNull(defaultSerializerProvider46);
        org.junit.Assert.assertNotNull(objJsonSerializer47);
        org.junit.Assert.assertNotNull(objJsonSerializer49);
        org.junit.Assert.assertNotNull(simpleModule50);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer51);
    }

    @Test
    public void test384() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test384");
        XmlNameProcessor.XmlName xmlName0 = new XmlNameProcessor.XmlName();
        xmlName0.localPart = "XML";
        String str3 = xmlName0.namespace;
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test385() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test385");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.core.io.CharacterEscapes characterEscapes9 = xmlFactory6.getCharacterEscapes();
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature10 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        boolean boolean12 = feature10.enabledIn((int) (short) 0);
        boolean boolean14 = feature10.enabledIn((int) ' ');
        XmlFactory xmlFactory15 = xmlFactory6.enable(feature10);
        com.fasterxml.jackson.core.JsonParser.Feature feature16 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonFactory jsonFactory18 = xmlFactory15.configure(feature16, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertNull(characterEscapes9);
        org.junit.Assert.assertTrue("'" + feature10 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature10.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertNotNull(xmlFactory15);
    }

    @Test
    public void test386() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test386");
        XmlFactory xmlFactory0 = new XmlFactory();
        xmlFactory0.setXMLTextElementName("XML");
        XmlNameProcessor xmlNameProcessor3 = xmlFactory0.getXmlNameProcessor();
        XmlNameProcessor xmlNameProcessor4 = xmlFactory0.getXmlNameProcessor();
        com.fasterxml.jackson.core.JsonFactory.Feature feature5 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean6 = xmlFactory0.isEnabled(feature5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlNameProcessor3);
        org.junit.Assert.assertNotNull(xmlNameProcessor4);
    }

    @Test
    public void test387() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test387");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator3 = null;
        XmlFactoryBuilder xmlFactoryBuilder4 = xmlFactoryBuilder0.inputDecorator(inputDecorator3);
        XmlFactoryBuilder xmlFactoryBuilder5 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator6 = xmlFactoryBuilder5.inputDecorator();
        ClassLoader classLoader7 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory8 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader7);
        XmlFactoryBuilder xmlFactoryBuilder9 = xmlFactoryBuilder5.inputFactory(xMLInputFactory8);
        XmlFactoryBuilder xmlFactoryBuilder10 = xmlFactoryBuilder4.inputFactory(xMLInputFactory8);
        javax.xml.stream.XMLOutputFactory xMLOutputFactory11 = xmlFactoryBuilder10.xmlOutputFactory();
        javax.xml.stream.XMLOutputFactory xMLOutputFactory12 = xmlFactoryBuilder10.xmlOutputFactory();
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertNull(inputDecorator6);
        org.junit.Assert.assertNotNull(xMLInputFactory8);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder9);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder10);
        org.junit.Assert.assertNotNull(xMLOutputFactory11);
        org.junit.Assert.assertNotNull(xMLOutputFactory12);
    }

    @Test
    public void test388() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test388");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
        defaultXmlPrettyPrinter0.beforeObjectEntries(jsonGenerator5);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator7 = null;
        defaultXmlPrettyPrinter0.writeEndArray(jsonGenerator7, (int) (short) -1);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_10 = null;
        char[] charArray19 = new char[] { '4', '4', '4', 'a', '#', ' ' };
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_10, "hi_", "JSON", charArray19, 57343, 7, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
        org.junit.Assert.assertNotNull(charArray19);
        org.junit.Assert.assertArrayEquals(charArray19, new char[] { '4', '4', '4', 'a', '#', ' ' });
    }

    @Test
    public void test389() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test389");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder0.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature6 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature7 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean9 = feature7.enabledIn((int) '#');
        com.fasterxml.jackson.core.ObjectCodec objectCodec10 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory13 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory14 = null;
        XmlFactory xmlFactory16 = new XmlFactory(objectCodec10, (int) 'a', 10, xMLInputFactory13, xMLOutputFactory14, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator17 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory18 = xmlFactory16.setOutputDecorator(outputDecorator17);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature19 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory20 = xmlFactory16.disable(feature19);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature21 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature22 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] featureArray23 = new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { feature7, feature19, feature21, feature22 };
        XmlFactoryBuilder xmlFactoryBuilder24 = xmlFactoryBuilder5.disable(feature6, featureArray23);
        com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser.Feature feature25 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder27 = xmlFactoryBuilder24.configure(feature25, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertTrue("'" + feature6 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature6.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + feature7 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature7.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(jsonFactory18);
        org.junit.Assert.assertTrue("'" + feature19 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature19.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory20);
        org.junit.Assert.assertTrue("'" + feature21 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature21.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertTrue("'" + feature22 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature22.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(featureArray23);
        org.junit.Assert.assertArrayEquals(featureArray23, new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 });
        org.junit.Assert.assertNotNull(xmlFactoryBuilder24);
    }

    @Test
    public void test390() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test390");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.beforeArrayValues(jsonGenerator1);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator3 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeRootValueSeparator(jsonGenerator3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test391() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test391");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
        defaultXmlPrettyPrinter0.writeStartArray(jsonGenerator5);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator7 = null;
        defaultXmlPrettyPrinter0.writeEndArray(jsonGenerator7, 0);
        org.codehaus.stax2.XMLStreamWriter2 xMLStreamWriter2_10 = null;
        java.math.BigInteger bigInteger13 = null;
        // The following exception was thrown during execution in test generation
        try {
            defaultXmlPrettyPrinter0.writeLeafElement(xMLStreamWriter2_10, "xmlInfo", "", bigInteger13);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test392() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test392");
        com.fasterxml.jackson.core.ObjectCodec objectCodec0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory3 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory6 = new XmlFactory(objectCodec0, (int) 'a', 10, xMLInputFactory3, xMLOutputFactory4, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator7 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory8 = xmlFactory6.setOutputDecorator(outputDecorator7);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature9 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory10 = xmlFactory6.disable(feature9);
        String str11 = xmlFactory6.getXMLTextElementName();
        com.fasterxml.jackson.core.ObjectCodec objectCodec12 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory13 = xmlFactory6.setCodec(objectCodec12);
        java.io.InputStream inputStream14 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.fasterxml.jackson.core.JsonParser jsonParser15 = jsonFactory13.createJsonParser(inputStream14);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(jsonFactory8);
        org.junit.Assert.assertTrue("'" + feature9 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature9.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory10);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "" + "'", str11, "");
        org.junit.Assert.assertNotNull(jsonFactory13);
    }

    @Test
    public void test393() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test393");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        com.fasterxml.jackson.databind.BeanProperty beanProperty3 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer4 = defaultSerializerProvider2.findNullValueSerializer(beanProperty3);
        JacksonXmlModule jacksonXmlModule5 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers6 = null;
        jacksonXmlModule5.setKeySerializers(simpleSerializers6);
        Class[] classArray9 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray10 = (Class<?>[]) classArray9;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule11 = jacksonXmlModule5.registerSubtypes((Class<?>[]) classArray9);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver12 = null;
        jacksonXmlModule5.setAbstractTypes(simpleAbstractTypeResolver12);
        jacksonXmlModule5.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.BeanSerializerModifier beanSerializerModifier16 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule17 = jacksonXmlModule5.setSerializerModifier(beanSerializerModifier16);
        JacksonXmlModule jacksonXmlModule18 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers19 = null;
        jacksonXmlModule18.setKeySerializers(simpleSerializers19);
        Class[] classArray22 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray23 = (Class<?>[]) classArray22;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule24 = jacksonXmlModule18.registerSubtypes((Class<?>[]) classArray22);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver25 = null;
        jacksonXmlModule18.setAbstractTypes(simpleAbstractTypeResolver25);
        jacksonXmlModule18.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.SerializerFactory serializerFactory29 = null;
        JacksonXmlModule jacksonXmlModule30 = jacksonXmlModule18.overrideSerializerFactory(serializerFactory29);
        com.fasterxml.jackson.core.ObjectCodec objectCodec31 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory34 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory35 = null;
        XmlFactory xmlFactory37 = new XmlFactory(objectCodec31, (int) 'a', 10, xMLInputFactory34, xMLOutputFactory35, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator38 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory39 = xmlFactory37.setOutputDecorator(outputDecorator38);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature40 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory41 = xmlFactory37.disable(feature40);
        Class<com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature> featureClass42 = xmlFactory37.getFormatWriteFeatureType();
        com.fasterxml.jackson.databind.deser.ValueInstantiator valueInstantiator43 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule44 = jacksonXmlModule18.addValueInstantiator(featureClass42, valueInstantiator43);
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup45 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider46 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup45);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider47 = xmlSerializerProvider46.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer48 = defaultSerializerProvider47.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer49 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer50 = objJsonSerializer48.unwrappingSerializer(nameTransformer49);
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule51 = simpleModule17.addKeySerializer(featureClass42, objJsonSerializer48);
        com.fasterxml.jackson.databind.BeanProperty beanProperty52 = null;
        com.fasterxml.jackson.databind.JsonSerializer<?> wildcardJsonSerializer53 = defaultSerializerProvider2.handleSecondaryContextualization(objJsonSerializer48, beanProperty52);
        String[] strArray60 = new String[] { "XML", "hi!", "hi!", "org.codehaus.stax2.propDtdOverride", "hi_", "org.codehaus.stax2.propDtdOverride" };
        java.util.ArrayList<String> strList61 = new java.util.ArrayList<String>();
        boolean boolean62 = java.util.Collections.addAll((java.util.Collection<String>) strList61, strArray60);
        boolean boolean63 = strList61.isEmpty();
        boolean boolean64 = objJsonSerializer48.isEmpty((Object) boolean63);
        org.junit.Assert.assertNotNull(defaultSerializerProvider2);
        org.junit.Assert.assertNotNull(objJsonSerializer4);
        org.junit.Assert.assertNotNull(classArray9);
        org.junit.Assert.assertArrayEquals(classArray9, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray10);
        org.junit.Assert.assertArrayEquals(wildcardClassArray10, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule11);
        org.junit.Assert.assertNotNull(simpleModule17);
        org.junit.Assert.assertNotNull(classArray22);
        org.junit.Assert.assertArrayEquals(classArray22, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray23);
        org.junit.Assert.assertArrayEquals(wildcardClassArray23, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule24);
        org.junit.Assert.assertNotNull(jacksonXmlModule30);
        org.junit.Assert.assertNotNull(jsonFactory39);
        org.junit.Assert.assertTrue("'" + feature40 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature40.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory41);
        org.junit.Assert.assertNotNull(featureClass42);
        org.junit.Assert.assertNotNull(simpleModule44);
        org.junit.Assert.assertNotNull(defaultSerializerProvider47);
        org.junit.Assert.assertNotNull(objJsonSerializer48);
        org.junit.Assert.assertNotNull(objJsonSerializer50);
        org.junit.Assert.assertNotNull(simpleModule51);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer53);
        org.junit.Assert.assertNotNull(strArray60);
        org.junit.Assert.assertArrayEquals(strArray60, new String[] { "XML", "hi!", "hi!", "org.codehaus.stax2.propDtdOverride", "hi_", "org.codehaus.stax2.propDtdOverride" });
        org.junit.Assert.assertTrue("'" + boolean62 + "' != '" + true + "'", boolean62 == true);
        org.junit.Assert.assertTrue("'" + boolean63 + "' != '" + false + "'", boolean63 == false);
        org.junit.Assert.assertTrue("'" + boolean64 + "' != '" + false + "'", boolean64 == false);
    }

    @Test
    public void test394() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test394");
        ClassLoader classLoader0 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory1 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader0);
        javax.xml.stream.XMLOutputFactory xMLOutputFactory2 = null;
        XmlFactory xmlFactory3 = new XmlFactory(xMLInputFactory1, xMLOutputFactory2);
        javax.xml.stream.XMLOutputFactory xMLOutputFactory4 = null;
        XmlFactory xmlFactory5 = new XmlFactory(xMLInputFactory1, xMLOutputFactory4);
        com.fasterxml.jackson.core.ObjectCodec objectCodec6 = null;
        XmlFactoryBuilder xmlFactoryBuilder9 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.InputDecorator inputDecorator10 = xmlFactoryBuilder9.inputDecorator();
        ClassLoader classLoader11 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory12 = com.fasterxml.jackson.dataformat.xml.util.StaxUtil.defaultInputFactory(classLoader11);
        XmlFactoryBuilder xmlFactoryBuilder13 = xmlFactoryBuilder9.inputFactory(xMLInputFactory12);
        XmlFactoryBuilder xmlFactoryBuilder14 = XmlFactory.builder();
        XmlFactoryBuilder xmlFactoryBuilder16 = xmlFactoryBuilder14.nameForTextElement("");
        javax.xml.stream.XMLOutputFactory xMLOutputFactory17 = xmlFactoryBuilder16.xmlOutputFactory();
        XmlFactory xmlFactory19 = new XmlFactory(objectCodec6, 6, 55296, xMLInputFactory12, xMLOutputFactory17, "hi!");
        xmlFactory5.setXMLInputFactory(xMLInputFactory12);
        // The following exception was thrown during execution in test generation
        try {
            XmlMapper xmlMapper21 = new XmlMapper(xMLInputFactory12);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlMapper.coercionConfigDefaults()Lcom/fasterxml/jackson/databind/cfg/MutableCoercionConfig;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xMLInputFactory1);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder9);
        org.junit.Assert.assertNull(inputDecorator10);
        org.junit.Assert.assertNotNull(xMLInputFactory12);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder13);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder14);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder16);
        org.junit.Assert.assertNotNull(xMLOutputFactory17);
    }

    @Test
    public void test395() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test395");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator1 = null;
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.outputDecorator(outputDecorator1);
        int int3 = xmlFactoryBuilder0.factoryFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder5 = xmlFactoryBuilder0.nameForTextElement("JSON");
        com.fasterxml.jackson.core.json.JsonReadFeature jsonReadFeature6 = null;
        com.fasterxml.jackson.core.json.JsonReadFeature[] jsonReadFeatureArray7 = new com.fasterxml.jackson.core.json.JsonReadFeature[] {};
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder8 = xmlFactoryBuilder5.enable(jsonReadFeature6, jsonReadFeatureArray7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 15 + "'", int3 == 15);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertNotNull(jsonReadFeatureArray7);
        org.junit.Assert.assertArrayEquals(jsonReadFeatureArray7, new com.fasterxml.jackson.core.json.JsonReadFeature[] {});
    }

    @Test
    public void test396() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test396");
        com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializerModifier xmlBeanSerializerModifier0 = new com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializerModifier();
        com.fasterxml.jackson.databind.SerializationConfig serializationConfig1 = null;
        com.fasterxml.jackson.databind.BeanDescription beanDescription2 = null;
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup3 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider4 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup3);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider5 = xmlSerializerProvider4.copy();
        com.fasterxml.jackson.databind.BeanProperty beanProperty6 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer7 = defaultSerializerProvider5.findNullValueSerializer(beanProperty6);
        JacksonXmlModule jacksonXmlModule8 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers9 = null;
        jacksonXmlModule8.setKeySerializers(simpleSerializers9);
        Class[] classArray12 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray13 = (Class<?>[]) classArray12;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule14 = jacksonXmlModule8.registerSubtypes((Class<?>[]) classArray12);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver15 = null;
        jacksonXmlModule8.setAbstractTypes(simpleAbstractTypeResolver15);
        jacksonXmlModule8.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.BeanSerializerModifier beanSerializerModifier19 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule20 = jacksonXmlModule8.setSerializerModifier(beanSerializerModifier19);
        JacksonXmlModule jacksonXmlModule21 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers22 = null;
        jacksonXmlModule21.setKeySerializers(simpleSerializers22);
        Class[] classArray25 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray26 = (Class<?>[]) classArray25;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule27 = jacksonXmlModule21.registerSubtypes((Class<?>[]) classArray25);
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver28 = null;
        jacksonXmlModule21.setAbstractTypes(simpleAbstractTypeResolver28);
        jacksonXmlModule21.setXMLTextElementName("JSON");
        com.fasterxml.jackson.databind.ser.SerializerFactory serializerFactory32 = null;
        JacksonXmlModule jacksonXmlModule33 = jacksonXmlModule21.overrideSerializerFactory(serializerFactory32);
        com.fasterxml.jackson.core.ObjectCodec objectCodec34 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory37 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory38 = null;
        XmlFactory xmlFactory40 = new XmlFactory(objectCodec34, (int) 'a', 10, xMLInputFactory37, xMLOutputFactory38, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator41 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory42 = xmlFactory40.setOutputDecorator(outputDecorator41);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature43 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory44 = xmlFactory40.disable(feature43);
        Class<com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature> featureClass45 = xmlFactory40.getFormatWriteFeatureType();
        com.fasterxml.jackson.databind.deser.ValueInstantiator valueInstantiator46 = null;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule47 = jacksonXmlModule21.addValueInstantiator(featureClass45, valueInstantiator46);
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup48 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider49 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup48);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider50 = xmlSerializerProvider49.copy();
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer51 = defaultSerializerProvider50.getDefaultNullKeySerializer();
        com.fasterxml.jackson.databind.util.NameTransformer nameTransformer52 = null;
        com.fasterxml.jackson.databind.JsonSerializer<Object> objJsonSerializer53 = objJsonSerializer51.unwrappingSerializer(nameTransformer52);
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule54 = simpleModule20.addKeySerializer(featureClass45, objJsonSerializer51);
        com.fasterxml.jackson.databind.BeanProperty beanProperty55 = null;
        com.fasterxml.jackson.databind.JsonSerializer<?> wildcardJsonSerializer56 = defaultSerializerProvider5.handleSecondaryContextualization(objJsonSerializer51, beanProperty55);
        com.fasterxml.jackson.databind.JsonSerializer<?> wildcardJsonSerializer57 = xmlBeanSerializerModifier0.modifySerializer(serializationConfig1, beanDescription2, (com.fasterxml.jackson.databind.JsonSerializer<Object>) wildcardJsonSerializer56);
        org.junit.Assert.assertNotNull(defaultSerializerProvider5);
        org.junit.Assert.assertNotNull(objJsonSerializer7);
        org.junit.Assert.assertNotNull(classArray12);
        org.junit.Assert.assertArrayEquals(classArray12, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray13);
        org.junit.Assert.assertArrayEquals(wildcardClassArray13, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule14);
        org.junit.Assert.assertNotNull(simpleModule20);
        org.junit.Assert.assertNotNull(classArray25);
        org.junit.Assert.assertArrayEquals(classArray25, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray26);
        org.junit.Assert.assertArrayEquals(wildcardClassArray26, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule27);
        org.junit.Assert.assertNotNull(jacksonXmlModule33);
        org.junit.Assert.assertNotNull(jsonFactory42);
        org.junit.Assert.assertTrue("'" + feature43 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature43.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory44);
        org.junit.Assert.assertNotNull(featureClass45);
        org.junit.Assert.assertNotNull(simpleModule47);
        org.junit.Assert.assertNotNull(defaultSerializerProvider50);
        org.junit.Assert.assertNotNull(objJsonSerializer51);
        org.junit.Assert.assertNotNull(objJsonSerializer53);
        org.junit.Assert.assertNotNull(simpleModule54);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer56);
        org.junit.Assert.assertNotNull(wildcardJsonSerializer57);
    }

    @Test
    public void test397() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test397");
        XmlFactoryBuilder xmlFactoryBuilder0 = XmlFactory.builder();
        XmlFactoryBuilder xmlFactoryBuilder2 = xmlFactoryBuilder0.nameForTextElement("");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature3 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean4 = feature3.enabledByDefault();
        XmlFactoryBuilder xmlFactoryBuilder5 = XmlFactory.builder();
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator6 = null;
        XmlFactoryBuilder xmlFactoryBuilder7 = xmlFactoryBuilder5.outputDecorator(outputDecorator6);
        int int8 = xmlFactoryBuilder5.formatParserFeaturesMask();
        XmlFactoryBuilder xmlFactoryBuilder10 = xmlFactoryBuilder5.nameForTextElement("hi_");
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature11 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature12 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        boolean boolean14 = feature12.enabledIn((int) '#');
        com.fasterxml.jackson.core.ObjectCodec objectCodec15 = null;
        javax.xml.stream.XMLInputFactory xMLInputFactory18 = null;
        javax.xml.stream.XMLOutputFactory xMLOutputFactory19 = null;
        XmlFactory xmlFactory21 = new XmlFactory(objectCodec15, (int) 'a', 10, xMLInputFactory18, xMLOutputFactory19, "");
        com.fasterxml.jackson.core.io.OutputDecorator outputDecorator22 = null;
        com.fasterxml.jackson.core.JsonFactory jsonFactory23 = xmlFactory21.setOutputDecorator(outputDecorator22);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature24 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL;
        XmlFactory xmlFactory25 = xmlFactory21.disable(feature24);
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature26 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature feature27 = com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1;
        com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] featureArray28 = new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { feature12, feature24, feature26, feature27 };
        XmlFactoryBuilder xmlFactoryBuilder29 = xmlFactoryBuilder10.disable(feature11, featureArray28);
        XmlFactoryBuilder xmlFactoryBuilder30 = xmlFactoryBuilder2.disable(feature3, featureArray28);
        com.fasterxml.jackson.core.StreamWriteFeature streamWriteFeature31 = null;
        // The following exception was thrown during execution in test generation
        try {
            XmlFactoryBuilder xmlFactoryBuilder33 = xmlFactoryBuilder30.configure(streamWriteFeature31, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(xmlFactoryBuilder0);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder2);
        org.junit.Assert.assertTrue("'" + feature3 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature3.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder5);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 4 + "'", int8 == 4);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder10);
        org.junit.Assert.assertTrue("'" + feature11 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS + "'", feature11.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS));
        org.junit.Assert.assertTrue("'" + feature12 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature12.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(jsonFactory23);
        org.junit.Assert.assertTrue("'" + feature24 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL + "'", feature24.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL));
        org.junit.Assert.assertNotNull(xmlFactory25);
        org.junit.Assert.assertTrue("'" + feature26 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature26.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertTrue("'" + feature27 + "' != '" + com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 + "'", feature27.equals(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1));
        org.junit.Assert.assertNotNull(featureArray28);
        org.junit.Assert.assertArrayEquals(featureArray28, new com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature[] { com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1, com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_1_1 });
        org.junit.Assert.assertNotNull(xmlFactoryBuilder29);
        org.junit.Assert.assertNotNull(xmlFactoryBuilder30);
    }

    @Test
    public void test398() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test398");
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter0 = new com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter();
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator1 = null;
        defaultXmlPrettyPrinter0.writeObjectFieldValueSeparator(jsonGenerator1);
        com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter defaultXmlPrettyPrinter4 = defaultXmlPrettyPrinter0.withCustomNewLine("JSON");
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator5 = null;
        defaultXmlPrettyPrinter0.beforeObjectEntries(jsonGenerator5);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator7 = null;
        defaultXmlPrettyPrinter0.writeEndArray(jsonGenerator7, 55296);
        com.fasterxml.jackson.core.JsonGenerator jsonGenerator10 = null;
        defaultXmlPrettyPrinter0.writeEndArray(jsonGenerator10, 7);
        org.junit.Assert.assertNotNull(defaultXmlPrettyPrinter4);
    }

    @Test
    public void test399() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test399");
        JacksonXmlModule jacksonXmlModule0 = new JacksonXmlModule();
        com.fasterxml.jackson.databind.module.SimpleSerializers simpleSerializers1 = null;
        jacksonXmlModule0.setKeySerializers(simpleSerializers1);
        Class[] classArray4 = new Class[0];
        @SuppressWarnings("unchecked")
        Class<?>[] wildcardClassArray5 = (Class<?>[]) classArray4;
        com.fasterxml.jackson.databind.module.SimpleModule simpleModule6 = jacksonXmlModule0.registerSubtypes((Class<?>[]) classArray4);
        com.fasterxml.jackson.core.Version version7 = jacksonXmlModule0.version();
        com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver simpleAbstractTypeResolver8 = null;
        jacksonXmlModule0.setAbstractTypes(simpleAbstractTypeResolver8);
        // The following exception was thrown during execution in test generation
        try {
            XmlMapper xmlMapper10 = new XmlMapper(jacksonXmlModule0);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: com.fasterxml.jackson.dataformat.xml.XmlMapper.coercionConfigDefaults()Lcom/fasterxml/jackson/databind/cfg/MutableCoercionConfig;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(classArray4);
        org.junit.Assert.assertArrayEquals(classArray4, new Class[] {});
        org.junit.Assert.assertNotNull(wildcardClassArray5);
        org.junit.Assert.assertArrayEquals(wildcardClassArray5, new Class[] {});
        org.junit.Assert.assertNotNull(simpleModule6);
        org.junit.Assert.assertNotNull(version7);
    }
}

