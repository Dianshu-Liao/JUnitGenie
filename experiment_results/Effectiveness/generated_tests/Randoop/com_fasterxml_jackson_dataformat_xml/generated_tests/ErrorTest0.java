package com.fasterxml.jackson.dataformat.xml;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ErrorTest0 {

    public static boolean debug = false;

    @Test
    public void test1() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test1");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        com.fasterxml.jackson.databind.ser.FilterProvider filterProvider3 = xmlSerializerProvider1.getFilterProvider();
    }

    @Test
    public void test2() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test2");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        boolean boolean3 = xmlSerializerProvider1.hasSerializationFeatures((int) ' ');
    }

    @Test
    public void test3() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test3");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        java.util.Locale locale2 = xmlSerializerProvider1.getLocale();
    }

    @Test
    public void test4() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test4");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.databind.ser.DefaultSerializerProvider defaultSerializerProvider2 = xmlSerializerProvider1.copy();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        com.fasterxml.jackson.databind.type.TypeFactory typeFactory3 = defaultSerializerProvider2.getTypeFactory();
    }

    @Test
    public void test5() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test5");
        com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup xmlRootNameLookup0 = new com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup();
        com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider xmlSerializerProvider1 = new com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider(xmlRootNameLookup0);
        com.fasterxml.jackson.dataformat.xml.util.StaxUtil staxUtil2 = new com.fasterxml.jackson.dataformat.xml.util.StaxUtil();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        Object obj3 = xmlSerializerProvider1.getAttribute((Object) staxUtil2);
    }
}

