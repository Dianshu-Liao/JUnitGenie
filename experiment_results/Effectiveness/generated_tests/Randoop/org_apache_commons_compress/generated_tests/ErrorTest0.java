import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ErrorTest0 {

    public static boolean debug = false;

    @Test
    public void test01() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test01");
        org.apache.commons.compress.harmony.unpack200.Segment segment0 = new org.apache.commons.compress.harmony.unpack200.Segment();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        org.apache.commons.compress.harmony.unpack200.ClassBands classBands1 = new org.apache.commons.compress.harmony.unpack200.ClassBands(segment0);
    }

    @Test
    public void test02() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test02");
        org.apache.commons.compress.harmony.pack200.Segment segment0 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands2 = new org.apache.commons.compress.harmony.pack200.CpBands(segment0, (int) (byte) 2);
        java.lang.String[] strArray9 = new java.lang.String[] { "UTF-16LE", "CPMember: UTF-8:splitting(UTF-8:splitting)" };
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        org.objectweb.asm.MethodVisitor methodVisitor10 = segment0.visitMethod(512, "", "zstd", "ustar\000.bz2", strArray9);
    }

    @Test
    public void test03() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test03");
        org.apache.commons.compress.harmony.pack200.Segment segment0 = new org.apache.commons.compress.harmony.pack200.Segment();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        boolean boolean1 = segment0.lastConstantHadWideIndex();
    }

    @Test
    public void test04() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test04");
        org.apache.commons.compress.harmony.unpack200.Segment segment0 = new org.apache.commons.compress.harmony.unpack200.Segment();
        org.apache.commons.compress.harmony.unpack200.SegmentHeader segmentHeader1 = segment0.getSegmentHeader();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        org.apache.commons.compress.harmony.unpack200.AttrDefinitionBands attrDefinitionBands2 = new org.apache.commons.compress.harmony.unpack200.AttrDefinitionBands(segment0);
    }

    @Test
    public void test05() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test05");
        org.apache.commons.compress.harmony.pack200.CPDouble cPDouble1 = new org.apache.commons.compress.harmony.pack200.CPDouble((double) (byte) 55);
        double double2 = cPDouble1.getDouble();
        org.apache.commons.compress.harmony.pack200.CPDouble cPDouble4 = new org.apache.commons.compress.harmony.pack200.CPDouble((double) (byte) 55);
        double double5 = cPDouble4.getDouble();
        int int6 = cPDouble1.compareTo(cPDouble4);
        org.junit.Assert.assertTrue("Contract failed: compareTo-equals on cPDouble1 and cPDouble4", (cPDouble1.compareTo(cPDouble4) == 0) == cPDouble1.equals(cPDouble4));
    }

    @Test
    public void test06() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test06");
        org.apache.commons.compress.harmony.pack200.NewAttribute.StripAttribute stripAttribute2 = new org.apache.commons.compress.harmony.pack200.NewAttribute.StripAttribute("././@LongLink", 40960);
        boolean boolean3 = stripAttribute2.isCodeAttribute();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        java.lang.Object obj5 = stripAttribute2.readConst(33188);
    }

    @Test
    public void test07() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test07");
        org.apache.commons.compress.harmony.pack200.Segment segment0 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands2 = new org.apache.commons.compress.harmony.pack200.CpBands(segment0, (int) (byte) 2);
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        segment0.visitInnerClass("", "ACC_ANNOTATION", "ConstantValue", 16877);
    }

    @Test
    public void test08() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test08");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS1 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue elementValue2 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue((int) (byte) 7, (java.lang.Object) oS1);
        java.util.List<java.lang.Object> objList3 = elementValue2.getClassFileEntries();
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute annotationDefaultAttribute4 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute(elementValue2);
        java.lang.String str5 = annotationDefaultAttribute4.toString();
        org.apache.commons.compress.harmony.pack200.Segment segment6 = new org.apache.commons.compress.harmony.pack200.Segment();
        boolean boolean7 = annotationDefaultAttribute4.equals((java.lang.Object) segment6);
        org.apache.commons.compress.harmony.pack200.Segment.SegmentMethodVisitor segmentMethodVisitor8 = segment6.new SegmentMethodVisitor();
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry11 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        segmentMethodVisitor8.visitLdcInsn((java.lang.Object) "splitting");
    }

    @Test
    public void test09() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test09");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_4 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_6 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition attributeDefinition7 = new org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition(4096, 493, cPUTF8_4, cPUTF8_6);
        org.apache.commons.compress.harmony.pack200.Segment segment8 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands10 = new org.apache.commons.compress.harmony.pack200.CpBands(segment8, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPMethodOrField cPMethodOrField14 = cpBands10.getCPMethod("", "zstd", "ACC_STRICT");
        org.apache.commons.compress.harmony.pack200.CPClass cPClass16 = cpBands10.getCPClass("true");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_18 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        cPUTF8_18.setIndex(4);
        org.apache.commons.compress.harmony.pack200.Segment segment21 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands23 = new org.apache.commons.compress.harmony.pack200.CpBands(segment21, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature25 = cpBands23.getCPSignature("ustar\000");
        org.apache.commons.compress.harmony.pack200.CPNameAndType cPNameAndType26 = new org.apache.commons.compress.harmony.pack200.CPNameAndType(cPUTF8_18, cPSignature25);
        org.apache.commons.compress.harmony.pack200.CPMethodOrField cPMethodOrField27 = new org.apache.commons.compress.harmony.pack200.CPMethodOrField(cPClass16, cPNameAndType26);
        org.apache.commons.compress.harmony.pack200.Segment segment28 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands30 = new org.apache.commons.compress.harmony.pack200.CpBands(segment28, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPMethodOrField cPMethodOrField34 = cpBands30.getCPMethod("", "zstd", "ACC_STRICT");
        org.apache.commons.compress.harmony.pack200.CPClass cPClass36 = cpBands30.getCPClass("true");
        boolean boolean37 = cPClass36.isInnerClass();
        org.apache.commons.compress.harmony.pack200.Segment segment38 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands40 = new org.apache.commons.compress.harmony.pack200.CpBands(segment38, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPMethodOrField cPMethodOrField44 = cpBands40.getCPMethod("", "zstd", "ACC_STRICT");
        org.apache.commons.compress.harmony.pack200.CPClass cPClass46 = cpBands40.getCPClass("true");
        boolean boolean47 = cPClass46.isInnerClass();
        org.apache.commons.compress.harmony.pack200.Segment segment48 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands50 = new org.apache.commons.compress.harmony.pack200.CpBands(segment48, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPMethodOrField cPMethodOrField54 = cpBands50.getCPMethod("", "zstd", "ACC_STRICT");
        org.apache.commons.compress.harmony.pack200.CPClass cPClass56 = cpBands50.getCPClass("true");
        boolean boolean57 = cPClass56.isInnerClass();
        org.apache.commons.compress.harmony.pack200.CPClass[] cPClassArray58 = new org.apache.commons.compress.harmony.pack200.CPClass[] { cPClass16, cPClass36, cPClass46, cPClass56 };
        java.util.ArrayList<org.apache.commons.compress.harmony.pack200.CPClass> cPClassList59 = new java.util.ArrayList<org.apache.commons.compress.harmony.pack200.CPClass>();
        boolean boolean60 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.pack200.CPClass>) cPClassList59, cPClassArray58);
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature61 = new org.apache.commons.compress.harmony.pack200.CPSignature("dump.bz2.gz", cPUTF8_4, (java.util.List<org.apache.commons.compress.harmony.pack200.CPClass>) cPClassList59);
        org.junit.Assert.assertTrue("Contract failed: compareTo-equals on cPClass16 and cPClass36", (cPClass16.compareTo(cPClass36) == 0) == cPClass16.equals(cPClass36));
    }

    @Test
    public void test10() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test10");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS1 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue elementValue2 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue((int) (byte) 7, (java.lang.Object) oS1);
        java.util.List<java.lang.Object> objList3 = elementValue2.getClassFileEntries();
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute annotationDefaultAttribute4 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute(elementValue2);
        java.lang.String str5 = annotationDefaultAttribute4.toString();
        org.apache.commons.compress.harmony.pack200.Segment segment6 = new org.apache.commons.compress.harmony.pack200.Segment();
        boolean boolean7 = annotationDefaultAttribute4.equals((java.lang.Object) segment6);
        org.apache.commons.compress.harmony.pack200.Segment.SegmentMethodVisitor segmentMethodVisitor8 = segment6.new SegmentMethodVisitor();
        segmentMethodVisitor8.visitAnnotableParameterCount(134630224, true);
        org.objectweb.asm.AnnotationVisitor annotationVisitor15 = segmentMethodVisitor8.visitParameterAnnotation((int) (byte) 6, "ustar ", false);
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        segmentMethodVisitor8.visitMethodInsn((int) (byte) 52, "dump.bz2", "0x5455 Zip Extra Field: Flags=0 ", "AnnotationDefault", false);
    }

    @Test
    public void test11() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test11");
        org.apache.commons.compress.harmony.pack200.Segment segment0 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands2 = new org.apache.commons.compress.harmony.pack200.CpBands(segment0, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPMethodOrField cPMethodOrField6 = cpBands2.getCPMethod("", "zstd", "ACC_STRICT");
        org.apache.commons.compress.harmony.pack200.CPClass cPClass8 = cpBands2.getCPClass("true");
        org.apache.commons.compress.harmony.pack200.CPClass cPClass10 = cpBands2.getCPClass("ACC_TRANSIENT");
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        org.apache.commons.compress.harmony.pack200.CPMethodOrField cPMethodOrField14 = cpBands2.getCPIMethod("hi!", "UTF-16LE", "dump.bz2");
    }

    @Test
    public void test12() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test12");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS1 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue elementValue2 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue((int) (byte) 7, (java.lang.Object) oS1);
        java.util.List<java.lang.Object> objList3 = elementValue2.getClassFileEntries();
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute annotationDefaultAttribute4 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute(elementValue2);
        java.lang.String str5 = annotationDefaultAttribute4.toString();
        org.apache.commons.compress.harmony.pack200.Segment segment6 = new org.apache.commons.compress.harmony.pack200.Segment();
        boolean boolean7 = annotationDefaultAttribute4.equals((java.lang.Object) segment6);
        org.apache.commons.compress.harmony.pack200.Segment.SegmentMethodVisitor segmentMethodVisitor8 = segment6.new SegmentMethodVisitor();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        segmentMethodVisitor8.visitVarInsn((int) (byte) 100, (int) (byte) 88);
    }

    @Test
    public void test13() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test13");
        org.apache.commons.compress.harmony.pack200.NewAttribute.StripAttribute stripAttribute2 = new org.apache.commons.compress.harmony.pack200.NewAttribute.StripAttribute("././@LongLink", 40960);
        boolean boolean3 = stripAttribute2.isCodeAttribute();
        boolean boolean4 = stripAttribute2.isContextClass();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        java.lang.Object obj6 = stripAttribute2.readConst((-1));
    }

    @Test
    public void test14() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test14");
        org.apache.commons.compress.harmony.pack200.NewAttribute.StripAttribute stripAttribute2 = new org.apache.commons.compress.harmony.pack200.NewAttribute.StripAttribute("././@LongLink", 40960);
        boolean boolean3 = stripAttribute2.isCodeAttribute();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        java.lang.String str5 = stripAttribute2.readClass(488);
    }
}

