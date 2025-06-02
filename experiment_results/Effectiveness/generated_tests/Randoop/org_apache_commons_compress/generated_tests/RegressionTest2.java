import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest2 {

    public static boolean debug = false;

    @Test
    public void test1001() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1001");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean1 = org.apache.commons.compress.utils.TimeUtils.isUnixTime((long) 9);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.file.attribute.FileTimes.isUnixTime(J)Z");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test1002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1002");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        dumpArchiveEntry2.setMode((int) '4');
        long long5 = dumpArchiveEntry2.getOffset();
        int int6 = dumpArchiveEntry2.getMode();
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry9 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("", true);
        java.util.Date date10 = tarArchiveEntry9.getLastModifiedDate();
        dumpArchiveEntry2.setAccessTime(date10);
        org.junit.Assert.assertTrue("'" + long5 + "' != '" + 0L + "'", long5 == 0L);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 52 + "'", int6 == 52);
        org.junit.Assert.assertNotNull(date10);
// flaky "1) test1002(RegressionTest2)":         org.junit.Assert.assertEquals(date10.toString(), "Fri Mar 14 23:48:27 AEDT 2025");
    }

    @Test
    public void test1003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1003");
        org.apache.commons.compress.archivers.zip.X0019_EncryptionRecipientCertificateList x0019_EncryptionRecipientCertificateList0 = new org.apache.commons.compress.archivers.zip.X0019_EncryptionRecipientCertificateList();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort1 = x0019_EncryptionRecipientCertificateList0.getCentralDirectoryLength();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort2 = x0019_EncryptionRecipientCertificateList0.getCentralDirectoryLength();
        org.junit.Assert.assertNotNull(zipShort1);
        org.junit.Assert.assertNotNull(zipShort2);
    }

    @Test
    public void test1004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1004");
        org.apache.commons.compress.archivers.zip.ResourceAlignmentExtraField resourceAlignmentExtraField0 = new org.apache.commons.compress.archivers.zip.ResourceAlignmentExtraField();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort1 = resourceAlignmentExtraField0.getHeaderId();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort2 = resourceAlignmentExtraField0.getLocalFileDataLength();
        org.junit.Assert.assertNotNull(zipShort1);
        org.junit.Assert.assertNotNull(zipShort2);
    }

    @Test
    public void test1005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1005");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        java.lang.String str3 = dumpArchiveEntry2.toString();
        int int4 = dumpArchiveEntry2.getHeaderHoles();
        java.util.Date date5 = dumpArchiveEntry2.getAccessTime();
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE tYPE6 = org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.DIRECTORY;
        dumpArchiveEntry2.setType(tYPE6);
        boolean boolean8 = dumpArchiveEntry2.isChrDev();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "jar" + "'", str3, "jar");
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(date5);
        org.junit.Assert.assertEquals(date5.toString(), "Thu Jan 01 10:00:00 AEST 1970");
        org.junit.Assert.assertTrue("'" + tYPE6 + "' != '" + org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.DIRECTORY + "'", tYPE6.equals(org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.DIRECTORY));
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test1006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1006");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime1 = null;
        x5455_ExtendedTimestamp0.setAccessFileTime(fileTime1);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = x5455_ExtendedTimestamp0.getLocalFileDataLength();
        java.nio.file.attribute.FileTime fileTime4 = x5455_ExtendedTimestamp0.getCreateFileTime();
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry5 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date6 = arjArchiveEntry5.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong7 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date6);
        x5455_ExtendedTimestamp0.setModifyTime(zipLong7);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort9 = x5455_ExtendedTimestamp0.getHeaderId();
        java.lang.String str10 = x5455_ExtendedTimestamp0.toString();
        java.lang.Object obj11 = x5455_ExtendedTimestamp0.clone();
        org.junit.Assert.assertNotNull(zipShort3);
        org.junit.Assert.assertNull(fileTime4);
        org.junit.Assert.assertNotNull(date6);
        org.junit.Assert.assertEquals(date6.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong7);
        org.junit.Assert.assertNotNull(zipShort9);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "0x5455 Zip Extra Field: Flags=1  Modify:[Mon Jan 26 10:44:48 AEST 1970] " + "'", str10, "0x5455 Zip Extra Field: Flags=1  Modify:[Mon Jan 26 10:44:48 AEST 1970] ");
        org.junit.Assert.assertNotNull(obj11);
        org.junit.Assert.assertEquals(obj11.toString(), "0x5455 Zip Extra Field: Flags=1  Modify:[Mon Jan 26 10:44:48 AEST 1970] ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(obj11), "0x5455 Zip Extra Field: Flags=1  Modify:[Mon Jan 26 10:44:48 AEST 1970] ");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj11), "0x5455 Zip Extra Field: Flags=1  Modify:[Mon Jan 26 10:44:48 AEST 1970] ");
    }

    @Test
    public void test1007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1007");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream8 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 4);
        org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream deflateCompressorOutputStream9 = new org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        // The following exception was thrown during execution in test generation
        try {
            cpioArchiveOutputStream2.closeArchiveEntry();
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: Trying to close non-existent entry");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test1008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1008");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.FORMAT_OLDGNU;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2 + "'", int0 == 2);
    }

    @Test
    public void test1009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1009");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.MAGIC_OFFSET;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 257 + "'", int0 == 257);
    }

    @Test
    public void test1010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1010");
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
        org.junit.Assert.assertTrue("'" + oS1 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS1.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertNotNull(objList3);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(annotationVisitor15);
    }

    @Test
    public void test1011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1011");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        java.lang.String str1 = sevenZArchiveEntry0.getName();
        sevenZArchiveEntry0.setHasCrc(false);
        boolean boolean4 = sevenZArchiveEntry0.getHasWindowsAttributes();
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry7 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        java.lang.String str8 = dumpArchiveEntry7.toString();
        int int9 = dumpArchiveEntry7.getHeaderHoles();
        java.util.Date date10 = dumpArchiveEntry7.getAccessTime();
        sevenZArchiveEntry0.setCreationDate(date10);
        sevenZArchiveEntry0.setName("CPMember: UTF-8:splitting(UTF-8:splitting)");
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "jar" + "'", str8, "jar");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertNotNull(date10);
        org.junit.Assert.assertEquals(date10.toString(), "Thu Jan 01 10:00:00 AEST 1970");
    }

    @Test
    public void test1012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1012");
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder0 = new org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder();
        java.io.OutputStream outputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream3 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream1, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry4 = null;
        boolean boolean5 = cpioArchiveOutputStream3.canWriteEntryData(archiveEntry4);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream7 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream3, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream9 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream7, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap10 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream11 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream9, strMap10);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec12 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean13 = bHSDCodec12.isDelta();
        byte[] byteArray15 = bHSDCodec12.encode((int) '#');
        pack200CompressorOutputStream11.write(byteArray15);
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder17 = builder0.setOutputStream((java.io.OutputStream) pack200CompressorOutputStream11);
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder19 = builder0.setMaxMemoryLimitKb(148);
        java.io.OutputStream outputStream20 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream22 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream20, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry23 = null;
        boolean boolean24 = cpioArchiveOutputStream22.canWriteEntryData(archiveEntry23);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream26 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream22, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream28 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream22, 4);
        byte[] byteArray30 = zstdCompressorOutputStream28.writeUsAsciiRaw("org.apache.commons.compress.harmony.pack200.Segment$PassException");
        org.apache.commons.compress.utils.ByteUtils.OutputStreamByteConsumer outputStreamByteConsumer31 = new org.apache.commons.compress.utils.ByteUtils.OutputStreamByteConsumer((java.io.OutputStream) zstdCompressorOutputStream28);
        byte[] byteArray36 = new byte[] { (byte) 0, (byte) 12, (byte) 12, (byte) 2 };
        zstdCompressorOutputStream28.write(byteArray36, 1000, 135);
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder40 = builder0.setByteArray(byteArray36);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(bHSDCodec12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] { (byte) 35 });
        org.junit.Assert.assertNotNull(builder17);
        org.junit.Assert.assertNotNull(builder19);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
        org.junit.Assert.assertNotNull(byteArray30);
        org.junit.Assert.assertNotNull(byteArray36);
        org.junit.Assert.assertArrayEquals(byteArray36, new byte[] { (byte) 0, (byte) 12, (byte) 12, (byte) 2 });
        org.junit.Assert.assertNotNull(builder40);
    }

    @Test
    public void test1013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1013");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream8 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream6, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap9 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream10 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream8, strMap9);
        boolean boolean11 = pack200CompressorOutputStream10.isClosed();
        org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream snappyCompressorOutputStream13 = new org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream((java.io.OutputStream) pack200CompressorOutputStream10, (long) 10240);
        snappyCompressorOutputStream13.write(28771);
        byte[] byteArray17 = snappyCompressorOutputStream13.writeUsAsciiRaw("pack.progress");
        snappyCompressorOutputStream13.finish();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(byteArray17);
        org.junit.Assert.assertArrayEquals(byteArray17, new byte[] { (byte) 112, (byte) 97, (byte) 99, (byte) 107, (byte) 46, (byte) 112, (byte) 114, (byte) 111, (byte) 103, (byte) 114, (byte) 101, (byte) 115, (byte) 115 });
    }

    @Test
    public void test1014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1014");
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker0 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray1 = jarMarker0.getLocalFileDataData();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort2 = jarMarker0.getLocalFileDataLength();
        java.io.OutputStream outputStream3 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream5 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream3, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream6 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream5);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream7 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) cpioArchiveOutputStream5);
        zipArchiveOutputStream7.setUseLanguageEncodingFlag(true);
        boolean boolean10 = zipShort2.equals((java.lang.Object) zipArchiveOutputStream7);
        // The following exception was thrown during execution in test generation
        try {
            zipArchiveOutputStream7.flush();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] {});
        org.junit.Assert.assertNotNull(zipShort2);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test1015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1015");
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker0 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray1 = jarMarker0.getCentralDirectoryData();
        byte[] byteArray2 = jarMarker0.getLocalFileDataData();
        boolean boolean4 = org.apache.commons.compress.compressors.xz.XZCompressorInputStream.matches(byteArray2, 0);
        boolean boolean6 = org.apache.commons.compress.archivers.dump.DumpArchiveInputStream.matches(byteArray2, 17);
        org.apache.commons.compress.archivers.tar.TarFile tarFile7 = new org.apache.commons.compress.archivers.tar.TarFile(byteArray2);
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry10 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file11 = tarArchiveEntry10.getFile();
        int int12 = tarArchiveEntry10.getDevMinor();
        tarArchiveEntry10.setUserName("UTF-8:splitting");
        tarArchiveEntry10.setUserId(12);
        java.io.InputStream inputStream17 = tarFile7.getInputStream(tarArchiveEntry10);
        org.apache.commons.compress.compressors.deflate.DeflateParameters deflateParameters18 = new org.apache.commons.compress.compressors.deflate.DeflateParameters();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.deflate.DeflateCompressorInputStream deflateCompressorInputStream19 = new org.apache.commons.compress.compressors.deflate.DeflateCompressorInputStream(inputStream17, deflateParameters18);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] {});
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(file11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(inputStream17);
    }

    @Test
    public void test1016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1016");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec1 = org.apache.commons.compress.harmony.pack200.CodecEncoding.getCanonicalCodec(3);
        java.io.InputStream inputStream3 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream4 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream3);
        int int5 = cpioArchiveInputStream4.getCount();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream8 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream4, (long) 1, (long) 148);
        java.util.zip.Checksum checksum9 = cRC32VerifyingInputStream8.getChecksum();
        long long11 = cRC32VerifyingInputStream8.skip((long) 345);
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream14 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cRC32VerifyingInputStream8, 8589934591L, (long) '4');
        // The following exception was thrown during execution in test generation
        try {
            int[] intArray15 = bHSDCodec1.decodeInts((int) (byte) 75, (java.io.InputStream) cRC32VerifyingInputStream8);
            org.junit.Assert.fail("Expected exception of type java.io.EOFException; message: End of stream reached whilst decoding");
        } catch (java.io.EOFException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(bHSDCodec1);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertNotNull(checksum9);
        org.junit.Assert.assertTrue("'" + long11 + "' != '" + 0L + "'", long11 == 0L);
    }

    @Test
    public void test1017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1017");
        org.apache.commons.compress.compressors.gzip.ExtraField extraField0 = new org.apache.commons.compress.compressors.gzip.ExtraField();
        int int1 = extraField0.size();
        extraField0.clear();
        extraField0.clear();
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 0 + "'", int1 == 0);
    }

    @Test
    public void test1018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1018");
        org.apache.commons.compress.harmony.unpack200.CpBands cpBands0 = null;
        org.apache.commons.compress.harmony.unpack200.SegmentConstantPool segmentConstantPool1 = new org.apache.commons.compress.harmony.unpack200.SegmentConstantPool(cpBands0);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.unpack200.bytecode.ConstantPoolEntry constantPoolEntry5 = segmentConstantPool1.getInitMethodPoolEntry(33188, (long) 32768, "ustar\000.bz2");
            org.junit.Assert.fail("Expected exception of type java.lang.Error; message: Nothing but CP_METHOD can be an <init>");
        } catch (java.lang.Error e) {
            // Expected exception.
        }
    }

    @Test
    public void test1019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1019");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry6 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean7 = cpioArchiveOutputStream2.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry6);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream8 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        java.io.File file9 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.cpio.CpioArchiveEntry cpioArchiveEntry11 = cpioArchiveOutputStream2.createArchiveEntry(file9, "xz");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test1020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1020");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec2 = new org.apache.commons.compress.harmony.pack200.BHSDCodec(11, (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: 1<=b<=5");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1021");
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode6 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int7 = byteCode6.getByteCodeIndex();
        int[] intArray8 = new int[] {};
        int[] intArray9 = new int[] {};
        int[] intArray10 = new int[] {};
        int[][] intArray11 = new int[][] { intArray8, intArray9, intArray10 };
        byteCode6.setNestedPositions(intArray11);
        int[] intArray13 = byteCode6.getRewrite();
        int[] intArray24 = new int[] { ' ', (byte) -1 };
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm iMethodRefForm25 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm((int) (byte) -1, "", intArray24);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm classRefForm26 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm((int) (short) 0, "jar", intArray24);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.StringRefForm stringRefForm28 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.StringRefForm(1, "splitting", intArray24, true);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.LabelForm labelForm29 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.LabelForm((int) '#', "pass", intArray24);
        org.apache.commons.compress.harmony.unpack200.bytecode.LineNumberTableAttribute lineNumberTableAttribute30 = new org.apache.commons.compress.harmony.unpack200.bytecode.LineNumberTableAttribute(100, intArray13, intArray24);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.ShortForm shortForm31 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.ShortForm(420, "ConstantValue", intArray24);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.FieldRefForm fieldRefForm32 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.FieldRefForm(55, "class-file version", intArray24);
        org.junit.Assert.assertNotNull(byteCode6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + (-1) + "'", int7 == (-1));
        org.junit.Assert.assertNotNull(intArray8);
        org.junit.Assert.assertArrayEquals(intArray8, new int[] {});
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertArrayEquals(intArray9, new int[] {});
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] {});
        org.junit.Assert.assertNotNull(intArray11);
        org.junit.Assert.assertNotNull(intArray13);
        org.junit.Assert.assertArrayEquals(intArray13, new int[] { 255 });
        org.junit.Assert.assertNotNull(intArray24);
        org.junit.Assert.assertArrayEquals(intArray24, new int[] { 32, (-1) });
    }

    @Test
    public void test1022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1022");
        java.nio.file.Path[] pathArray0 = new java.nio.file.Path[] {};
        java.util.ArrayList<java.nio.file.Path> pathList1 = new java.util.ArrayList<java.nio.file.Path>();
        boolean boolean2 = java.util.Collections.addAll((java.util.Collection<java.nio.file.Path>) pathList1, pathArray0);
        java.nio.file.LinkOption[] linkOptionArray3 = org.apache.commons.compress.utils.IOUtils.EMPTY_LINK_OPTIONS;
        // The following exception was thrown during execution in test generation
        try {
            java.nio.channels.SeekableByteChannel seekableByteChannel4 = org.apache.commons.compress.archivers.zip.ZipSplitReadOnlySeekableByteChannel.forPaths((java.util.List<java.nio.file.Path>) pathList1, (java.nio.file.OpenOption[]) linkOptionArray3);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 0, Size: 0");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pathArray0);
        org.junit.Assert.assertArrayEquals(pathArray0, new java.nio.file.Path[] {});
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(linkOptionArray3);
        org.junit.Assert.assertArrayEquals(linkOptionArray3, new java.nio.file.LinkOption[] {});
    }

    @Test
    public void test1023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1023");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        boolean boolean1 = sevenZArchiveEntry0.getHasCrc();
        int int2 = sevenZArchiveEntry0.getWindowsAttributes();
        sevenZArchiveEntry0.setName("keep");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry7 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("", true);
        tarArchiveEntry7.setMode(16877);
        java.nio.file.attribute.FileTime fileTime10 = tarArchiveEntry7.getStatusChangeTime();
        boolean boolean11 = tarArchiveEntry7.isStreamContiguous();
        boolean boolean12 = tarArchiveEntry7.isGNULongLinkEntry();
        java.nio.file.attribute.FileTime fileTime13 = tarArchiveEntry7.getLastModifiedTime();
        sevenZArchiveEntry0.setCreationTime(fileTime13);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNull(fileTime10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(fileTime13);
    }

    @Test
    public void test1024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1024");
        java.util.concurrent.ExecutorService executorService0 = null;
        java.nio.file.Path path1 = null;
        org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier defaultBackingStoreSupplier2 = new org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier(path1);
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore3 = defaultBackingStoreSupplier2.get();
        org.apache.commons.compress.archivers.zip.ParallelScatterZipCreator parallelScatterZipCreator4 = new org.apache.commons.compress.archivers.zip.ParallelScatterZipCreator(executorService0, (org.apache.commons.compress.parallel.ScatterGatherBackingStoreSupplier) defaultBackingStoreSupplier2);
        org.junit.Assert.assertNotNull(scatterGatherBackingStore3);
    }

    @Test
    public void test1025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1025");
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker0 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray1 = jarMarker0.getCentralDirectoryData();
        byte[] byteArray2 = jarMarker0.getLocalFileDataData();
        boolean boolean4 = org.apache.commons.compress.compressors.xz.XZCompressorInputStream.matches(byteArray2, 0);
        boolean boolean6 = org.apache.commons.compress.archivers.dump.DumpArchiveInputStream.matches(byteArray2, 17);
        org.apache.commons.compress.archivers.tar.TarFile tarFile7 = new org.apache.commons.compress.archivers.tar.TarFile(byteArray2);
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry10 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file11 = tarArchiveEntry10.getFile();
        int int12 = tarArchiveEntry10.getDevMinor();
        tarArchiveEntry10.setUserName("UTF-8:splitting");
        tarArchiveEntry10.setUserId(12);
        java.io.InputStream inputStream17 = tarFile7.getInputStream(tarArchiveEntry10);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipArchiveInputStream zipArchiveInputStream19 = new org.apache.commons.compress.archivers.zip.ZipArchiveInputStream(inputStream17, "splitting");
            org.junit.Assert.fail("Expected exception of type java.nio.charset.UnsupportedCharsetException; message: splitting");
        } catch (java.nio.charset.UnsupportedCharsetException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] {});
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(file11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(inputStream17);
    }

    @Test
    public void test1026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1026");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream8 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 4);
        byte[] byteArray10 = zstdCompressorOutputStream8.writeUsAsciiRaw("org.apache.commons.compress.harmony.pack200.Segment$PassException");
        zstdCompressorOutputStream8.finish();
        java.nio.file.Path path12 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long13 = zstdCompressorOutputStream8.write(path12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(byteArray10);
    }

    @Test
    public void test1027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1027");
        org.apache.commons.compress.compressors.CompressorStreamFactory compressorStreamFactory2 = new org.apache.commons.compress.compressors.CompressorStreamFactory(false, (int) (byte) 10);
    }

    @Test
    public void test1028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1028");
        org.apache.commons.compress.harmony.pack200.BHSDCodec[] bHSDCodecArray0 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs3;
        org.junit.Assert.assertNotNull(bHSDCodecArray0);
    }

    @Test
    public void test1029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1029");
        byte[] byteArray0 = null;
        byte[] byteArray4 = org.apache.commons.compress.utils.ArchiveUtils.toAsciiBytes("cpio");
        byte[] byteArray5 = null;
        boolean boolean6 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray4, byteArray5);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = org.apache.commons.compress.utils.ArchiveUtils.isEqualWithNull(byteArray0, 17, 8, byteArray5, 0, (int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 99, (byte) 112, (byte) 105, (byte) 111 });
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test1030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1030");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.XSTAR_MAGIC_OFFSET;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 508 + "'", int0 == 508);
    }

    @Test
    public void test1031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1031");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream3 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        byte[] byteArray4 = null;
        blockLZ4CompressorOutputStream3.write(byteArray4, 4, (-1));
    }

    @Test
    public void test1032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1032");
        java.nio.file.Path path0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipFile zipFile2 = new org.apache.commons.compress.archivers.zip.ZipFile(path0, "0\000");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1033");
        short short0 = org.apache.commons.compress.archivers.cpio.CpioConstants.FORMAT_OLD_MASK;
        org.junit.Assert.assertTrue("'" + short0 + "' != '" + (short) 12 + "'", short0 == (short) 12);
    }

    @Test
    public void test1034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1034");
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.Builder builder0 = org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.builder();
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.Builder builder2 = builder0.withMaxMemoryLimitInKb(1000);
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions sevenZFileOptions3 = builder0.build();
        int int4 = sevenZFileOptions3.getMaxMemoryLimitInKb();
        boolean boolean5 = sevenZFileOptions3.getUseDefaultNameForUnnamedEntries();
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(builder2);
        org.junit.Assert.assertNotNull(sevenZFileOptions3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1000 + "'", int4 == 1000);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test1035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1035");
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel0 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel();
    }

    @Test
    public void test1036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1036");
        org.apache.commons.compress.harmony.pack200.Segment segment0 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands2 = new org.apache.commons.compress.harmony.pack200.CpBands(segment0, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.Segment segment3 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands5 = new org.apache.commons.compress.harmony.pack200.CpBands(segment3, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.BcBands bcBands7 = new org.apache.commons.compress.harmony.pack200.BcBands(cpBands2, segment3, 10240);
        java.lang.Object obj8 = null;
        // The following exception was thrown during execution in test generation
        try {
            bcBands7.visitLdcInsn(obj8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1037");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE tYPE0 = org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.UNKNOWN;
        org.junit.Assert.assertTrue("'" + tYPE0 + "' != '" + org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.UNKNOWN + "'", tYPE0.equals(org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.UNKNOWN));
    }

    @Test
    public void test1038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1038");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_2);
        java.lang.String str4 = cPUTF8_2.toString();
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_7 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_7);
        org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute newAttribute10 = new org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute(cPUTF8_7, 8);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_14 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_14);
        org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute newAttribute17 = new org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute(cPUTF8_14, 8);
        org.apache.commons.compress.harmony.unpack200.bytecode.Attribute[] attributeArray18 = new org.apache.commons.compress.harmony.unpack200.bytecode.Attribute[] { newAttribute17 };
        java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute> attributeList19 = new java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute>();
        boolean boolean20 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute>) attributeList19, attributeArray18);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPMember cPMember21 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPMember(cPUTF8_2, cPUTF8_7, (long) (byte) 0, (java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute>) attributeList19);
        cPUTF8_2.setGlobalIndex(0);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "UTF-8:splitting" + "'", str4, "UTF-8:splitting");
        org.junit.Assert.assertNotNull(attributeArray18);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
    }

    @Test
    public void test1039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1039");
        java.util.Locale locale0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.ResourceBundle resourceBundle2 = org.apache.commons.compress.harmony.archive.internal.nls.Messages.setLocale(locale0, "AnnotationDefault");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1040");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS1 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue elementValue2 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue((int) (byte) 7, (java.lang.Object) oS1);
        java.util.List<java.lang.Object> objList3 = elementValue2.getClassFileEntries();
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute annotationDefaultAttribute4 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute(elementValue2);
        java.lang.String str5 = annotationDefaultAttribute4.toString();
        org.apache.commons.compress.harmony.pack200.Segment segment6 = new org.apache.commons.compress.harmony.pack200.Segment();
        boolean boolean7 = annotationDefaultAttribute4.equals((java.lang.Object) segment6);
        org.apache.commons.compress.harmony.pack200.Segment.SegmentMethodVisitor segmentMethodVisitor8 = segment6.new SegmentMethodVisitor();
        segmentMethodVisitor8.visitAnnotableParameterCount(134630224, true);
        // The following exception was thrown during execution in test generation
        try {
            segmentMethodVisitor8.visitMethodInsn((int) (short) 100, "pack.deflate.hint.lzma.lzma", "not encodeable", "0x7875 Zip Extra Field: UID=32768 GID=1000", true);
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: INVOKESPECIAL/STATIC on interfaces requires ASM5");
        } catch (java.lang.UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + oS1 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS1.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertNotNull(objList3);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test1041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1041");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        // The following exception was thrown during execution in test generation
        try {
            cpioArchiveOutputStream2.closeArchiveEntry();
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: Trying to close non-existent entry");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test1042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1042");
        org.apache.commons.compress.archivers.zip.UnrecognizedExtraField unrecognizedExtraField0 = new org.apache.commons.compress.archivers.zip.UnrecognizedExtraField();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort1 = unrecognizedExtraField0.getCentralDirectoryLength();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort2 = unrecognizedExtraField0.getCentralDirectoryLength();
        org.junit.Assert.assertNotNull(zipShort1);
        org.junit.Assert.assertNotNull(zipShort2);
    }

    @Test
    public void test1043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1043");
        java.lang.String str0 = org.apache.commons.compress.compressors.CompressorStreamFactory.GZIP;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "gz" + "'", str0, "gz");
    }

    @Test
    public void test1044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1044");
        org.apache.commons.compress.harmony.unpack200.bytecode.ClassFile classFile0 = new org.apache.commons.compress.harmony.unpack200.bytecode.ClassFile();
        org.apache.commons.compress.harmony.unpack200.bytecode.ClassConstantPool classConstantPool1 = classFile0.pool;
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass[] cPClassArray2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPClass[] {};
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionsAttribute exceptionsAttribute3 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionsAttribute(cPClassArray2);
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionsAttribute exceptionsAttribute4 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionsAttribute(cPClassArray2);
        classFile0.fields = cPClassArray2;
        int[] intArray6 = classFile0.interfaces;
        org.junit.Assert.assertNotNull(classConstantPool1);
        org.junit.Assert.assertNotNull(cPClassArray2);
        org.junit.Assert.assertArrayEquals(cPClassArray2, new org.apache.commons.compress.harmony.unpack200.bytecode.CPClass[] {});
        org.junit.Assert.assertNull(intArray6);
    }

    @Test
    public void test1045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1045");
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel2 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        org.apache.commons.compress.archivers.tar.TarFile tarFile3 = new org.apache.commons.compress.archivers.tar.TarFile((java.nio.channels.SeekableByteChannel) seekableInMemoryByteChannel2);
        seekableInMemoryByteChannel2.close();
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel6 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        long long7 = seekableInMemoryByteChannel6.size();
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel9 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        org.apache.commons.compress.archivers.tar.TarFile tarFile10 = new org.apache.commons.compress.archivers.tar.TarFile((java.nio.channels.SeekableByteChannel) seekableInMemoryByteChannel9);
        seekableInMemoryByteChannel9.close();
        java.nio.channels.SeekableByteChannel[] seekableByteChannelArray12 = new java.nio.channels.SeekableByteChannel[] { seekableInMemoryByteChannel2, seekableInMemoryByteChannel6, seekableInMemoryByteChannel9 };
        java.nio.channels.SeekableByteChannel seekableByteChannel13 = org.apache.commons.compress.utils.MultiReadOnlySeekableByteChannel.forSeekableByteChannels(seekableByteChannelArray12);
        java.lang.String str14 = org.apache.commons.compress.harmony.archive.internal.nls.Messages.getString("TarArchiveStructSparse{offset=8589934591, numbytes=0}", (java.lang.Object[]) seekableByteChannelArray12);
        org.junit.Assert.assertTrue("'" + long7 + "' != '" + 96L + "'", long7 == 96L);
        org.junit.Assert.assertNotNull(seekableByteChannelArray12);
        org.junit.Assert.assertNotNull(seekableByteChannel13);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "TarArchiveStructSparse{offset=8589934591, numbytes=0}" + "'", str14, "TarArchiveStructSparse{offset=8589934591, numbytes=0}");
    }

    @Test
    public void test1046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1046");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime1 = null;
        x5455_ExtendedTimestamp0.setAccessFileTime(fileTime1);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = x5455_ExtendedTimestamp0.getLocalFileDataLength();
        java.lang.Object obj4 = x5455_ExtendedTimestamp0.clone();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong5 = x5455_ExtendedTimestamp0.getAccessTime();
        byte byte6 = x5455_ExtendedTimestamp0.getFlags();
        boolean boolean7 = x5455_ExtendedTimestamp0.isBit2_createTimePresent();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort8 = x5455_ExtendedTimestamp0.getLocalFileDataLength();
        java.lang.String str9 = zipShort8.toString();
        org.junit.Assert.assertNotNull(zipShort3);
        org.junit.Assert.assertNotNull(obj4);
        org.junit.Assert.assertEquals(obj4.toString(), "0x5455 Zip Extra Field: Flags=0 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(obj4), "0x5455 Zip Extra Field: Flags=0 ");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj4), "0x5455 Zip Extra Field: Flags=0 ");
        org.junit.Assert.assertNull(zipLong5);
        org.junit.Assert.assertTrue("'" + byte6 + "' != '" + (byte) 0 + "'", byte6 == (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(zipShort8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ZipShort value: 1" + "'", str9, "ZipShort value: 1");
    }

    @Test
    public void test1047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1047");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime1 = null;
        x5455_ExtendedTimestamp0.setAccessFileTime(fileTime1);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = x5455_ExtendedTimestamp0.getLocalFileDataLength();
        java.lang.Object obj4 = x5455_ExtendedTimestamp0.clone();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong5 = x5455_ExtendedTimestamp0.getAccessTime();
        byte byte6 = x5455_ExtendedTimestamp0.getFlags();
        boolean boolean7 = x5455_ExtendedTimestamp0.isBit2_createTimePresent();
        byte[] byteArray8 = x5455_ExtendedTimestamp0.getLocalFileDataData();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort9 = x5455_ExtendedTimestamp0.getLocalFileDataLength();
        org.junit.Assert.assertNotNull(zipShort3);
        org.junit.Assert.assertNotNull(obj4);
        org.junit.Assert.assertEquals(obj4.toString(), "0x5455 Zip Extra Field: Flags=0 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(obj4), "0x5455 Zip Extra Field: Flags=0 ");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj4), "0x5455 Zip Extra Field: Flags=0 ");
        org.junit.Assert.assertNull(zipLong5);
        org.junit.Assert.assertTrue("'" + byte6 + "' != '" + (byte) 0 + "'", byte6 == (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(byteArray8);
        org.junit.Assert.assertArrayEquals(byteArray8, new byte[] { (byte) 0 });
        org.junit.Assert.assertNotNull(zipShort9);
    }

    @Test
    public void test1048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1048");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        long long3 = cpioArchiveInputStream1.getBytesRead();
        org.apache.commons.compress.utils.CloseShieldFilterInputStream closeShieldFilterInputStream4 = new org.apache.commons.compress.utils.CloseShieldFilterInputStream((java.io.InputStream) cpioArchiveInputStream1);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.lzma.LZMACompressorInputStream lZMACompressorInputStream6 = new org.apache.commons.compress.compressors.lzma.LZMACompressorInputStream((java.io.InputStream) closeShieldFilterInputStream4, 8);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
    }

    @Test
    public void test1049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1049");
        org.apache.commons.compress.harmony.pack200.BHSDCodec[] bHSDCodecArray0 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs1;
        org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaSignedCodecs5 = bHSDCodecArray0;
        org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs3 = bHSDCodecArray0;
        org.junit.Assert.assertNotNull(bHSDCodecArray0);
    }

    @Test
    public void test1050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1050");
        java.util.Locale locale0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.ResourceBundle resourceBundle2 = org.apache.commons.compress.harmony.archive.internal.nls.Messages.setLocale(locale0, "impdep2");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1051");
        java.nio.file.Path path0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream2 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream(path0, 8589934591L);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Zip split segment size should between 64K and 4,294,967,295");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1052");
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.WideForm wideForm2 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.WideForm((int) (short) -1, "././@LongLink");
        int[] intArray10 = new int[] { ' ', (byte) -1 };
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm iMethodRefForm11 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm((int) (byte) -1, "", intArray10);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.LongForm longForm12 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.LongForm((int) (short) -1, "pass", intArray10);
        // The following exception was thrown during execution in test generation
        try {
            wideForm2.setRewrite4Bytes((int) (byte) 88, intArray10);
            org.junit.Assert.fail("Expected exception of type java.lang.Error; message: Trying to rewrite org.apache.commons.compress.harmony.unpack200.bytecode.forms.WideForm(././@LongLink) but there is no room for 4 bytes");
        } catch (java.lang.Error e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] { 32, (-1) });
    }

    @Test
    public void test1053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1053");
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode extraFieldParsingMode0 = org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.DRACONIC;
        org.junit.Assert.assertTrue("'" + extraFieldParsingMode0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.DRACONIC + "'", extraFieldParsingMode0.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.DRACONIC));
    }

    @Test
    public void test1054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1054");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream8 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 4);
        org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream deflateCompressorOutputStream9 = new org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray11 = deflateCompressorOutputStream9.writeUsAscii("0x7875 Zip Extra Field: UID=32768 GID=1000");
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: No current CPIO entry");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test1055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1055");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        long long3 = dumpArchiveEntry2.getSize();
        java.lang.String str4 = dumpArchiveEntry2.getName();
        dumpArchiveEntry2.setMode((int) (byte) 51);
        dumpArchiveEntry2.setDeleted(false);
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "jar" + "'", str4, "jar");
    }

    @Test
    public void test1056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1056");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime1 = null;
        x5455_ExtendedTimestamp0.setAccessFileTime(fileTime1);
        byte[] byteArray3 = x5455_ExtendedTimestamp0.getLocalFileDataData();
        org.apache.commons.compress.compressors.lz77support.LZ77Compressor.LiteralBlock literalBlock6 = new org.apache.commons.compress.compressors.lz77support.LZ77Compressor.LiteralBlock(byteArray3, 40960, 8);
        int int7 = literalBlock6.getLength();
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 0 });
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 8 + "'", int7 == 8);
    }

    @Test
    public void test1057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1057");
        java.util.ArrayList<org.apache.commons.io.function.IOIterator<org.apache.commons.compress.archivers.cpio.CpioArchiveEntry>> cpioArchiveEntryIOIteratorList0 = org.apache.commons.compress.utils.Lists.newArrayList();
        org.junit.Assert.assertNotNull(cpioArchiveEntryIOIteratorList0);
    }

    @Test
    public void test1058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1058");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_2);
        java.lang.String str4 = cPUTF8_2.toString();
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_7 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_7);
        org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute newAttribute10 = new org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute(cPUTF8_7, 8);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_14 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_14);
        org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute newAttribute17 = new org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute(cPUTF8_14, 8);
        org.apache.commons.compress.harmony.unpack200.bytecode.Attribute[] attributeArray18 = new org.apache.commons.compress.harmony.unpack200.bytecode.Attribute[] { newAttribute17 };
        java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute> attributeList19 = new java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute>();
        boolean boolean20 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute>) attributeList19, attributeArray18);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPMember cPMember21 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPMember(cPUTF8_2, cPUTF8_7, (long) (byte) 0, (java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute>) attributeList19);
        org.apache.commons.compress.harmony.unpack200.bytecode.SignatureAttribute signatureAttribute22 = new org.apache.commons.compress.harmony.unpack200.bytecode.SignatureAttribute(cPUTF8_2);
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry25 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        dumpArchiveEntry25.setMode((int) '4');
        boolean boolean28 = cPUTF8_2.equals((java.lang.Object) dumpArchiveEntry25);
        java.util.Date date29 = dumpArchiveEntry25.getLastModifiedDate();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "UTF-8:splitting" + "'", str4, "UTF-8:splitting");
        org.junit.Assert.assertNotNull(attributeArray18);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertNotNull(date29);
        org.junit.Assert.assertEquals(date29.toString(), "Thu Jan 01 10:00:00 AEST 1970");
    }

    @Test
    public void test1059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1059");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream8 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream6, 6);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream10 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream8, (int) (byte) 100);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream12 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream8, 100);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test1060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1060");
        java.util.jar.JarFile jarFile0 = null;
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader1 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        boolean boolean2 = segmentHeader1.have_method_flags_hi();
        java.io.OutputStream outputStream3 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream5 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream3, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry6 = null;
        boolean boolean7 = cpioArchiveOutputStream5.canWriteEntryData(archiveEntry6);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream9 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream5, 135);
        org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream framedLZ4CompressorOutputStream10 = new org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream9);
        segmentHeader1.pack((java.io.OutputStream) framedLZ4CompressorOutputStream10);
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions12 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        packingOptions12.setLogFile("ar");
        packingOptions12.setVerbose(true);
        java.lang.String str17 = packingOptions12.getLogFile();
        packingOptions12.setSegmentLimit((long) 11);
        packingOptions12.setGzip(true);
        org.apache.commons.compress.harmony.pack200.Archive archive22 = new org.apache.commons.compress.harmony.pack200.Archive(jarFile0, (java.io.OutputStream) framedLZ4CompressorOutputStream10, packingOptions12);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "ar" + "'", str17, "ar");
    }

    @Test
    public void test1061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1061");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("", true);
        tarArchiveEntry2.setMode(16877);
        java.nio.file.attribute.FileTime fileTime5 = tarArchiveEntry2.getStatusChangeTime();
        boolean boolean6 = tarArchiveEntry2.isStreamContiguous();
        boolean boolean7 = tarArchiveEntry2.isGNULongLinkEntry();
        tarArchiveEntry2.setGroupId(0L);
        boolean boolean10 = tarArchiveEntry2.isBlockDevice();
        org.junit.Assert.assertNull(fileTime5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test1062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1062");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        byte[] byteArray2 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream1);
        long long3 = cpioArchiveInputStream1.getBytesRead();
        int int4 = cpioArchiveInputStream1.getCount();
        boolean boolean5 = cpioArchiveInputStream1.markSupported();
        org.apache.commons.io.function.IOIterator<org.apache.commons.compress.archivers.cpio.CpioArchiveEntry> cpioArchiveEntryIOIterator6 = cpioArchiveInputStream1.iterator();
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry7 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        java.lang.String str8 = sevenZArchiveEntry7.getName();
        sevenZArchiveEntry7.setHasCrc(false);
        boolean boolean11 = cpioArchiveInputStream1.canReadEntryData((org.apache.commons.compress.archivers.ArchiveEntry) sevenZArchiveEntry7);
        org.apache.commons.compress.utils.SkipShieldingInputStream skipShieldingInputStream12 = new org.apache.commons.compress.utils.SkipShieldingInputStream((java.io.InputStream) cpioArchiveInputStream1);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(cpioArchiveEntryIOIterator6);
        org.junit.Assert.assertNull(str8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
    }

    @Test
    public void test1063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1063");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_2);
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS5 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue elementValue6 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue((int) (byte) 7, (java.lang.Object) oS5);
        java.util.List<java.lang.Object> objList7 = elementValue6.getClassFileEntries();
        boolean boolean8 = cPUTF8_2.equals((java.lang.Object) elementValue6);
        org.apache.commons.compress.harmony.unpack200.bytecode.LocalVariableTableAttribute.setAttributeName(cPUTF8_2);
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute.setAttributeName(cPUTF8_2);
        org.junit.Assert.assertTrue("'" + oS5 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS5.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertNotNull(objList7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test1064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1064");
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker0 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray1 = jarMarker0.getLocalFileDataData();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort2 = jarMarker0.getLocalFileDataLength();
        java.io.OutputStream outputStream3 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream5 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream3, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream6 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream5);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream7 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) cpioArchiveOutputStream5);
        zipArchiveOutputStream7.setUseLanguageEncodingFlag(true);
        boolean boolean10 = zipShort2.equals((java.lang.Object) zipArchiveOutputStream7);
        java.lang.Object obj11 = zipShort2.clone();
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] {});
        org.junit.Assert.assertNotNull(zipShort2);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(obj11);
        org.junit.Assert.assertEquals(obj11.toString(), "ZipShort value: 0");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(obj11), "ZipShort value: 0");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj11), "ZipShort value: 0");
    }

    @Test
    public void test1065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1065");
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData unparseableExtraFieldData2 = jarArchiveEntry1.getUnparseableExtraFieldData();
        org.apache.commons.compress.archivers.zip.GeneralPurposeBit generalPurposeBit3 = jarArchiveEntry1.getGeneralPurposeBit();
        java.lang.Object obj4 = generalPurposeBit3.clone();
        org.junit.Assert.assertNull(unparseableExtraFieldData2);
        org.junit.Assert.assertNotNull(generalPurposeBit3);
        org.junit.Assert.assertNotNull(obj4);
    }

    @Test
    public void test1066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1066");
        int[] intArray2 = new int[] {};
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.ByteForm byteForm3 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.ByteForm(1, "ACC_NATIVE", intArray2);
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode5 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int6 = byteCode5.getByteCodeIndex();
        int[] intArray7 = new int[] {};
        int[] intArray8 = new int[] {};
        int[] intArray9 = new int[] {};
        int[][] intArray10 = new int[][] { intArray7, intArray8, intArray9 };
        byteCode5.setNestedPositions(intArray10);
        int[] intArray12 = byteCode5.getRewrite();
        boolean boolean14 = byteCode5.equals((java.lang.Object) (byte) 7);
        org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager operandManager15 = null;
        // The following exception was thrown during execution in test generation
        try {
            byteForm3.setByteCodeOperands(byteCode5, operandManager15, 4096);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(intArray2);
        org.junit.Assert.assertArrayEquals(intArray2, new int[] {});
        org.junit.Assert.assertNotNull(byteCode5);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + (-1) + "'", int6 == (-1));
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertArrayEquals(intArray7, new int[] {});
        org.junit.Assert.assertNotNull(intArray8);
        org.junit.Assert.assertArrayEquals(intArray8, new int[] {});
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertArrayEquals(intArray9, new int[] {});
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertNotNull(intArray12);
        org.junit.Assert.assertArrayEquals(intArray12, new int[] { 255 });
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test1067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1067");
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions0 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        boolean boolean2 = packingOptions0.isPassFile("TRAILER!!!");
        java.lang.String str3 = packingOptions0.getModificationTime();
        packingOptions0.addMethodAttributeAction("ZipShort value: 1", "`\n");
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "keep" + "'", str3, "keep");
    }

    @Test
    public void test1068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1068");
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        java.nio.file.attribute.FileTime fileTime2 = jarArchiveEntry1.getCreationTime();
        jarArchiveEntry1.setVersionRequired(16);
        java.nio.file.attribute.FileTime fileTime5 = jarArchiveEntry1.getLastModifiedTime();
        long long6 = jarArchiveEntry1.getDataOffset();
        org.junit.Assert.assertNull(fileTime2);
        org.junit.Assert.assertNull(fileTime5);
        org.junit.Assert.assertTrue("'" + long6 + "' != '" + (-1L) + "'", long6 == (-1L));
    }

    @Test
    public void test1069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1069");
        org.apache.commons.compress.archivers.zip.ZipMethod zipMethod0 = org.apache.commons.compress.archivers.zip.ZipMethod.ZSTD_DEPRECATED;
        org.junit.Assert.assertTrue("'" + zipMethod0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipMethod.ZSTD_DEPRECATED + "'", zipMethod0.equals(org.apache.commons.compress.archivers.zip.ZipMethod.ZSTD_DEPRECATED));
    }

    @Test
    public void test1070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1070");
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode1 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int2 = byteCode1.getByteCodeIndex();
        int[] intArray3 = new int[] {};
        int[] intArray4 = new int[] {};
        int[] intArray5 = new int[] {};
        int[][] intArray6 = new int[][] { intArray3, intArray4, intArray5 };
        byteCode1.setNestedPositions(intArray6);
        int[] intArray8 = byteCode1.getRewrite();
        int[] intArray9 = byteCode1.getByteCodeTargets();
        // The following exception was thrown during execution in test generation
        try {
            byteCode1.setOperand2Bytes((int) (byte) 100, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.Error; message: Trying to rewrite impdep2 that has no rewrite");
        } catch (java.lang.Error e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteCode1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
        org.junit.Assert.assertNotNull(intArray3);
        org.junit.Assert.assertArrayEquals(intArray3, new int[] {});
        org.junit.Assert.assertNotNull(intArray4);
        org.junit.Assert.assertArrayEquals(intArray4, new int[] {});
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] {});
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertNotNull(intArray8);
        org.junit.Assert.assertArrayEquals(intArray8, new int[] { 255 });
        org.junit.Assert.assertNull(intArray9);
    }

    @Test
    public void test1071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1071");
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry0 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date1 = arjArchiveEntry0.getLastModifiedDate();
        boolean boolean2 = arjArchiveEntry0.isDirectory();
        java.lang.String str3 = arjArchiveEntry0.getName();
        org.junit.Assert.assertNotNull(date1);
        org.junit.Assert.assertEquals(date1.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test1072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1072");
        int int0 = org.apache.commons.compress.harmony.pack200.MetadataBandGroup.CONTEXT_METHOD;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2 + "'", int0 == 2);
    }

    @Test
    public void test1073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1073");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec3 = new org.apache.commons.compress.harmony.pack200.BHSDCodec(60012, (int) (short) 12, 1000);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: 1<=b<=5");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1074");
        org.apache.commons.compress.compressors.lz4.XXHash32 xXHash32_1 = new org.apache.commons.compress.compressors.lz4.XXHash32(3);
    }

    @Test
    public void test1075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1075");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime1 = null;
        x5455_ExtendedTimestamp0.setAccessFileTime(fileTime1);
        org.apache.commons.compress.archivers.zip.ZipLong zipLong3 = org.apache.commons.compress.archivers.zip.ZipLong.AED_SIG;
        boolean boolean5 = zipLong3.equals((java.lang.Object) "pass");
        x5455_ExtendedTimestamp0.setCreateTime(zipLong3);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort7 = x5455_ExtendedTimestamp0.getLocalFileDataLength();
        org.junit.Assert.assertNotNull(zipLong3);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(zipShort7);
    }

    @Test
    public void test1076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1076");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_2);
        java.lang.String str4 = cPUTF8_2.toString();
        cPUTF8_2.setGlobalIndex(33188);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "UTF-8:splitting" + "'", str4, "UTF-8:splitting");
    }

    @Test
    public void test1077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1077");
        int int0 = org.apache.commons.compress.archivers.cpio.CpioConstants.C_IWOTH;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2 + "'", int0 == 2);
    }

    @Test
    public void test1078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1078");
        java.io.File file0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.cpio.CpioArchiveEntry cpioArchiveEntry2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveEntry(file0, "pack.deflate.hint");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1079");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        long long7 = cpioArchiveOutputStream2.getBytesWritten();
        org.apache.commons.compress.archivers.cpio.CpioArchiveEntry cpioArchiveEntry8 = null;
        // The following exception was thrown during execution in test generation
        try {
            cpioArchiveOutputStream2.putArchiveEntry(cpioArchiveEntry8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + long7 + "' != '" + 0L + "'", long7 == 0L);
    }

    @Test
    public void test1080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1080");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        boolean boolean1 = sevenZArchiveEntry0.getHasCrc();
        sevenZArchiveEntry0.setAntiItem(true);
        sevenZArchiveEntry0.setDirectory(true);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test1081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1081");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream5 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream1, (long) 1, (long) 148);
        org.apache.commons.compress.utils.CloseShieldFilterInputStream closeShieldFilterInputStream6 = new org.apache.commons.compress.utils.CloseShieldFilterInputStream((java.io.InputStream) cpioArchiveInputStream1);
        org.apache.commons.compress.utils.ByteUtils.InputStreamByteSupplier inputStreamByteSupplier7 = new org.apache.commons.compress.utils.ByteUtils.InputStreamByteSupplier((java.io.InputStream) closeShieldFilterInputStream6);
        int int8 = inputStreamByteSupplier7.getAsByte();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
    }

    @Test
    public void test1082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1082");
        boolean boolean1 = org.apache.commons.compress.archivers.zip.ZipUtil.isDosTime(96L);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test1083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1083");
        org.apache.commons.compress.archivers.ArchiveStreamFactory archiveStreamFactory1 = new org.apache.commons.compress.archivers.ArchiveStreamFactory("");
        java.lang.String str2 = archiveStreamFactory1.getEntryEncoding();
        java.util.Set<java.lang.String> strSet3 = archiveStreamFactory1.getInputStreamArchiveNames();
        java.lang.String str4 = archiveStreamFactory1.getEntryEncoding();
        java.util.Set<java.lang.String> strSet5 = archiveStreamFactory1.getInputStreamArchiveNames();
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "" + "'", str2, "");
        org.junit.Assert.assertNotNull(strSet3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertNotNull(strSet5);
    }

    @Test
    public void test1084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1084");
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.Builder builder0 = org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.builder();
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.Builder builder2 = builder0.withUseDefaultNameForUnnamedEntries(true);
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(builder2);
    }

    @Test
    public void test1085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1085");
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions0 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        packingOptions0.setLogFile("ar");
        packingOptions0.setKeepFileOrder(false);
    }

    @Test
    public void test1086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1086");
        java.lang.String str0 = org.apache.commons.compress.java.util.jar.Pack200.Packer.UNKNOWN_ATTRIBUTE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "pack.unknown.attribute" + "'", str0, "pack.unknown.attribute");
    }

    @Test
    public void test1087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1087");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream3 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream4 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        zipArchiveOutputStream4.setUseLanguageEncodingFlag(false);
        zipArchiveOutputStream4.setUseLanguageEncodingFlag(false);
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream9 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) zipArchiveOutputStream4);
        java.io.OutputStream outputStream10 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream12 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream10, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream13 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream12);
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker15 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray16 = jarMarker15.getCentralDirectoryData();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField17 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger18 = zip64ExtendedInformationExtraField17.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger19 = null;
        zip64ExtendedInformationExtraField17.setSize(zipEightByteInteger19);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField21 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField22 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger23 = zip64ExtendedInformationExtraField22.getCompressedSize();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField24 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger25 = zip64ExtendedInformationExtraField24.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger26 = null;
        zip64ExtendedInformationExtraField24.setSize(zipEightByteInteger26);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField28 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger29 = zip64ExtendedInformationExtraField28.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger30 = null;
        zip64ExtendedInformationExtraField28.setSize(zipEightByteInteger30);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField32 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipExtraField[] zipExtraFieldArray33 = new org.apache.commons.compress.archivers.zip.ZipExtraField[] { zip64ExtendedInformationExtraField17, zip64ExtendedInformationExtraField21, zip64ExtendedInformationExtraField22, zip64ExtendedInformationExtraField24, zip64ExtendedInformationExtraField28, zip64ExtendedInformationExtraField32 };
        byte[] byteArray34 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.mergeLocalFileDataData(zipExtraFieldArray33);
        boolean boolean35 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray16, byteArray34);
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField38 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField("ustar\000", byteArray34, 0, 9);
        blockLZ4CompressorOutputStream13.prefill(byteArray34, 21, (int) '4');
        java.io.OutputStream outputStream42 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream44 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream42, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream45 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream44);
        byte[] byteArray46 = null;
        blockLZ4CompressorOutputStream45.write(byteArray46, 4, (-1));
        java.io.OutputStream outputStream50 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream52 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream50, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream53 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream52);
        byte[] byteArray54 = null;
        blockLZ4CompressorOutputStream53.write(byteArray54, 4, (-1));
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream[] blockLZ4CompressorOutputStreamArray58 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream[] { blockLZ4CompressorOutputStream9, blockLZ4CompressorOutputStream13, blockLZ4CompressorOutputStream45, blockLZ4CompressorOutputStream53 };
        java.util.HashSet<org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream> blockLZ4CompressorOutputStreamSet59 = org.apache.commons.compress.utils.Sets.newHashSet(blockLZ4CompressorOutputStreamArray58);
        org.junit.Assert.assertNotNull(byteArray16);
        org.junit.Assert.assertArrayEquals(byteArray16, new byte[] {});
        org.junit.Assert.assertNull(zipEightByteInteger18);
        org.junit.Assert.assertNull(zipEightByteInteger23);
        org.junit.Assert.assertNull(zipEightByteInteger25);
        org.junit.Assert.assertNull(zipEightByteInteger29);
        org.junit.Assert.assertNotNull(zipExtraFieldArray33);
        org.junit.Assert.assertNotNull(byteArray34);
        org.junit.Assert.assertArrayEquals(byteArray34, new byte[] { (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertNotNull(blockLZ4CompressorOutputStreamArray58);
        org.junit.Assert.assertNotNull(blockLZ4CompressorOutputStreamSet59);
    }

    @Test
    public void test1088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1088");
        org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm encryptionAlgorithm0 = org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm.TripleDES192;
        org.junit.Assert.assertTrue("'" + encryptionAlgorithm0 + "' != '" + org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm.TripleDES192 + "'", encryptionAlgorithm0.equals(org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm.TripleDES192));
    }

    @Test
    public void test1089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1089");
        org.apache.commons.compress.archivers.dump.InvalidFormatException invalidFormatException2 = new org.apache.commons.compress.archivers.dump.InvalidFormatException((long) 8);
        long long3 = invalidFormatException2.getOffset();
        org.apache.commons.compress.archivers.ArchiveException archiveException4 = new org.apache.commons.compress.archivers.ArchiveException("070701", (java.lang.Exception) invalidFormatException2);
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 8L + "'", long3 == 8L);
    }

    @Test
    public void test1090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1090");
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData unparseableExtraFieldData2 = jarArchiveEntry1.getUnparseableExtraFieldData();
        org.apache.commons.compress.archivers.zip.GeneralPurposeBit generalPurposeBit3 = jarArchiveEntry1.getGeneralPurposeBit();
        jarArchiveEntry1.setCrc((long) 512);
        org.junit.Assert.assertNull(unparseableExtraFieldData2);
        org.junit.Assert.assertNotNull(generalPurposeBit3);
    }

    @Test
    public void test1091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1091");
        java.nio.charset.Charset charset2 = null;
        org.apache.commons.compress.archivers.zip.ZipEncoding zipEncoding3 = org.apache.commons.compress.archivers.zip.ZipEncodingHelper.getZipEncoding(charset2);
        byte[] byteArray9 = new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 };
        byte[] byteArray16 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean18 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray16, 0);
        boolean boolean19 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray9, byteArray16);
        java.lang.String str20 = zipEncoding3.decode(byteArray9);
        org.apache.commons.compress.harmony.unpack200.Segment segment21 = new org.apache.commons.compress.harmony.unpack200.Segment();
        org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager operandManager22 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass26 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry27 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass26);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass31 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry32 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass31);
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry[] exceptionTableEntryArray33 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry[] { exceptionTableEntry27, exceptionTableEntry32 };
        java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry> exceptionTableEntryList34 = new java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>();
        boolean boolean35 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>) exceptionTableEntryList34, exceptionTableEntryArray33);
        org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute codeAttribute36 = new org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute(476, (int) (byte) 51, byteArray9, segment21, operandManager22, (java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>) exceptionTableEntryList34);
        segment21.setLogLevel((int) (short) 1);
        org.junit.Assert.assertNotNull(zipEncoding3);
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertArrayEquals(byteArray9, new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 });
        org.junit.Assert.assertNotNull(byteArray16);
        org.junit.Assert.assertArrayEquals(byteArray16, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "\002?\002\n\001" + "'", str20, "\002?\002\n\001");
        org.junit.Assert.assertNotNull(exceptionTableEntryArray33);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + true + "'", boolean35 == true);
    }

    @Test
    public void test1092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1092");
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        jarArchiveEntry1.setUnixMode(52);
        jarArchiveEntry1.setMethod(32782);
    }

    @Test
    public void test1093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1093");
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode1 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int2 = byteCode1.getByteCodeIndex();
        int[] intArray3 = new int[] {};
        int[] intArray4 = new int[] {};
        int[] intArray5 = new int[] {};
        int[][] intArray6 = new int[][] { intArray3, intArray4, intArray5 };
        byteCode1.setNestedPositions(intArray6);
        int[] intArray8 = byteCode1.getRewrite();
        int[] intArray9 = byteCode1.getByteCodeTargets();
        // The following exception was thrown during execution in test generation
        try {
            int[] intArray11 = byteCode1.getNestedPosition((int) (byte) 48);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 48");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteCode1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
        org.junit.Assert.assertNotNull(intArray3);
        org.junit.Assert.assertArrayEquals(intArray3, new int[] {});
        org.junit.Assert.assertNotNull(intArray4);
        org.junit.Assert.assertArrayEquals(intArray4, new int[] {});
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] {});
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertNotNull(intArray8);
        org.junit.Assert.assertArrayEquals(intArray8, new int[] { 255 });
        org.junit.Assert.assertNull(intArray9);
    }

    @Test
    public void test1094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1094");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream3 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream4 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        zipArchiveOutputStream4.setUseLanguageEncodingFlag(false);
        int int7 = zipArchiveOutputStream4.getCount();
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
    }

    @Test
    public void test1095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1095");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime1 = null;
        x5455_ExtendedTimestamp0.setAccessFileTime(fileTime1);
        byte[] byteArray3 = x5455_ExtendedTimestamp0.getLocalFileDataData();
        org.apache.commons.compress.compressors.lz77support.LZ77Compressor.LiteralBlock literalBlock6 = new org.apache.commons.compress.compressors.lz77support.LZ77Compressor.LiteralBlock(byteArray3, 40960, 8);
        java.lang.String str7 = literalBlock6.toString();
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 0 });
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "LiteralBlock LITERAL with offset 40960 and length 8" + "'", str7, "LiteralBlock LITERAL with offset 40960 and length 8");
    }

    @Test
    public void test1096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1096");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass[] cPClassArray0 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPClass[] {};
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionsAttribute exceptionsAttribute1 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionsAttribute(cPClassArray0);
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionsAttribute exceptionsAttribute2 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionsAttribute(cPClassArray0);
        java.lang.String str3 = exceptionsAttribute2.toString();
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp4 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime5 = null;
        x5455_ExtendedTimestamp4.setAccessFileTime(fileTime5);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort7 = x5455_ExtendedTimestamp4.getLocalFileDataLength();
        java.nio.file.attribute.FileTime fileTime8 = x5455_ExtendedTimestamp4.getCreateFileTime();
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry9 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date10 = arjArchiveEntry9.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong11 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date10);
        x5455_ExtendedTimestamp4.setModifyTime(zipLong11);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort13 = x5455_ExtendedTimestamp4.getHeaderId();
        java.lang.String str14 = x5455_ExtendedTimestamp4.toString();
        boolean boolean15 = exceptionsAttribute2.equals((java.lang.Object) x5455_ExtendedTimestamp4);
        org.junit.Assert.assertNotNull(cPClassArray0);
        org.junit.Assert.assertArrayEquals(cPClassArray0, new org.apache.commons.compress.harmony.unpack200.bytecode.CPClass[] {});
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Exceptions: " + "'", str3, "Exceptions: ");
        org.junit.Assert.assertNotNull(zipShort7);
        org.junit.Assert.assertNull(fileTime8);
        org.junit.Assert.assertNotNull(date10);
        org.junit.Assert.assertEquals(date10.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong11);
        org.junit.Assert.assertNotNull(zipShort13);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0x5455 Zip Extra Field: Flags=1  Modify:[Mon Jan 26 10:44:48 AEST 1970] " + "'", str14, "0x5455 Zip Extra Field: Flags=1  Modify:[Mon Jan 26 10:44:48 AEST 1970] ");
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test1097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1097");
        org.apache.commons.compress.archivers.ArchiveStreamFactory archiveStreamFactory1 = new org.apache.commons.compress.archivers.ArchiveStreamFactory("");
        java.lang.String str2 = archiveStreamFactory1.getEntryEncoding();
        java.util.Set<java.lang.String> strSet3 = archiveStreamFactory1.getOutputStreamArchiveNames();
        java.util.Set<java.lang.String> strSet4 = archiveStreamFactory1.getInputStreamArchiveNames();
        java.util.Set<java.lang.String> strSet5 = archiveStreamFactory1.getOutputStreamArchiveNames();
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "" + "'", str2, "");
        org.junit.Assert.assertNotNull(strSet3);
        org.junit.Assert.assertNotNull(strSet4);
        org.junit.Assert.assertNotNull(strSet5);
    }

    @Test
    public void test1098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1098");
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode2 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int3 = byteCode2.getByteCodeIndex();
        int[] intArray4 = new int[] {};
        int[] intArray5 = new int[] {};
        int[] intArray6 = new int[] {};
        int[][] intArray7 = new int[][] { intArray4, intArray5, intArray6 };
        byteCode2.setNestedPositions(intArray7);
        int[] intArray9 = byteCode2.getRewrite();
        int[] intArray20 = new int[] { ' ', (byte) -1 };
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm iMethodRefForm21 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm((int) (byte) -1, "", intArray20);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm classRefForm22 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm((int) (short) 0, "jar", intArray20);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.StringRefForm stringRefForm24 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.StringRefForm(1, "splitting", intArray20, true);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.LabelForm labelForm25 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.LabelForm((int) '#', "pass", intArray20);
        org.apache.commons.compress.harmony.unpack200.bytecode.LineNumberTableAttribute lineNumberTableAttribute26 = new org.apache.commons.compress.harmony.unpack200.bytecode.LineNumberTableAttribute(100, intArray9, intArray20);
        java.lang.String str27 = lineNumberTableAttribute26.toString();
        org.junit.Assert.assertNotNull(byteCode2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + (-1) + "'", int3 == (-1));
        org.junit.Assert.assertNotNull(intArray4);
        org.junit.Assert.assertArrayEquals(intArray4, new int[] {});
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] {});
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertArrayEquals(intArray6, new int[] {});
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertArrayEquals(intArray9, new int[] { 255 });
        org.junit.Assert.assertNotNull(intArray20);
        org.junit.Assert.assertArrayEquals(intArray20, new int[] { 32, (-1) });
        org.junit.Assert.assertEquals("'" + str27 + "' != '" + "LineNumberTable: 100 lines" + "'", str27, "LineNumberTable: 100 lines");
    }

    @Test
    public void test1099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1099");
        org.apache.commons.compress.compressors.gzip.GzipParameters gzipParameters0 = new org.apache.commons.compress.compressors.gzip.GzipParameters();
        gzipParameters0.setOperatingSystem(6);
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS3 = gzipParameters0.getOS();
        gzipParameters0.setBufferSize(16384);
        org.apache.commons.compress.compressors.gzip.ExtraField extraField6 = gzipParameters0.getExtraField();
        org.junit.Assert.assertTrue("'" + oS3 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.HPFS + "'", oS3.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.HPFS));
        org.junit.Assert.assertNull(extraField6);
    }

    @Test
    public void test1100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1100");
        org.apache.commons.compress.compressors.gzip.ExtraField extraField0 = new org.apache.commons.compress.compressors.gzip.ExtraField();
        java.util.Spliterator<org.apache.commons.compress.compressors.gzip.ExtraField.SubField> subFieldSpliterator1 = extraField0.spliterator();
        org.junit.Assert.assertNotNull(subFieldSpliterator1);
    }

    @Test
    public void test1101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1101");
        org.apache.commons.compress.archivers.zip.ZipMethod zipMethod0 = org.apache.commons.compress.archivers.zip.ZipMethod.UNKNOWN;
        org.junit.Assert.assertTrue("'" + zipMethod0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipMethod.UNKNOWN + "'", zipMethod0.equals(org.apache.commons.compress.archivers.zip.ZipMethod.UNKNOWN));
    }

    @Test
    public void test1102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1102");
        org.apache.commons.compress.harmony.pack200.BHSDCodec[] bHSDCodecArray0 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs4;
        org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaUnsignedCodecs2 = bHSDCodecArray0;
        org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaSignedCodecs3 = bHSDCodecArray0;
        org.junit.Assert.assertNotNull(bHSDCodecArray0);
    }

    @Test
    public void test1103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1103");
        byte[] byteArray1 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean2 = org.apache.commons.compress.utils.ArchiveUtils.matchAsciiBuffer("pack.keep.file.order.bz2", byteArray1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1104");
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField2 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField();
        jarArchiveEntry1.addExtraField((org.apache.commons.compress.archivers.zip.ZipExtraField) unicodeCommentExtraField2);
        boolean boolean4 = jarArchiveEntry1.isStreamContiguous();
        org.apache.commons.compress.parallel.InputStreamSupplier inputStreamSupplier5 = null;
        org.apache.commons.compress.archivers.zip.ZipArchiveEntryRequest zipArchiveEntryRequest6 = org.apache.commons.compress.archivers.zip.ZipArchiveEntryRequest.createZipArchiveEntryRequest((org.apache.commons.compress.archivers.zip.ZipArchiveEntry) jarArchiveEntry1, inputStreamSupplier5);
        int int7 = zipArchiveEntryRequest6.getMethod();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(zipArchiveEntryRequest6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + (-1) + "'", int7 == (-1));
    }

    @Test
    public void test1105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1105");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        long long3 = cpioArchiveInputStream1.skip((long) 8);
        org.apache.commons.compress.utils.CountingInputStream countingInputStream4 = new org.apache.commons.compress.utils.CountingInputStream((java.io.InputStream) cpioArchiveInputStream1);
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode extraFieldParsingMode5 = org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT;
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp6 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime7 = null;
        x5455_ExtendedTimestamp6.setAccessFileTime(fileTime7);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort9 = x5455_ExtendedTimestamp6.getHeaderId();
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField10 = extraFieldParsingMode5.createExtraField(zipShort9);
        byte[] byteArray12 = org.apache.commons.compress.archivers.zip.ZipShort.getBytes(8);
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField17 = extraFieldParsingMode5.onUnparseableExtraField(byteArray12, (int) (byte) -1, 17, true, 0);
        byte[] byteArray18 = org.apache.commons.compress.archivers.zip.ZipUtil.reverse(byteArray12);
        int int19 = countingInputStream4.read(byteArray18);
        long long20 = countingInputStream4.getBytesRead();
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + extraFieldParsingMode5 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT + "'", extraFieldParsingMode5.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT));
        org.junit.Assert.assertNotNull(zipShort9);
        org.junit.Assert.assertNotNull(zipExtraField10);
        org.junit.Assert.assertNotNull(byteArray12);
        org.junit.Assert.assertArrayEquals(byteArray12, new byte[] { (byte) 0, (byte) 8 });
        org.junit.Assert.assertNull(zipExtraField17);
        org.junit.Assert.assertNotNull(byteArray18);
        org.junit.Assert.assertArrayEquals(byteArray18, new byte[] { (byte) 0, (byte) 8 });
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + (-1) + "'", int19 == (-1));
        org.junit.Assert.assertTrue("'" + long20 + "' != '" + 0L + "'", long20 == 0L);
    }

    @Test
    public void test1106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1106");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.unpack200.SegmentOptions segmentOptions1 = new org.apache.commons.compress.harmony.unpack200.SegmentOptions(12);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.compress.harmony.pack200.Pack200Exception; message: Some unused flags are non-zero");
        } catch (org.apache.commons.compress.harmony.pack200.Pack200Exception e) {
            // Expected exception.
        }
    }

    @Test
    public void test1107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1107");
        byte byte0 = org.apache.commons.compress.archivers.tar.TarConstants.LF_BLK;
        org.junit.Assert.assertTrue("'" + byte0 + "' != '" + (byte) 52 + "'", byte0 == (byte) 52);
    }

    @Test
    public void test1108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1108");
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder0 = new org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder();
        java.io.OutputStream outputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream3 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream1, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry4 = null;
        boolean boolean5 = cpioArchiveOutputStream3.canWriteEntryData(archiveEntry4);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream7 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream3, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream9 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream7, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap10 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream11 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream9, strMap10);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec12 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean13 = bHSDCodec12.isDelta();
        byte[] byteArray15 = bHSDCodec12.encode((int) '#');
        pack200CompressorOutputStream11.write(byteArray15);
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder17 = builder0.setOutputStream((java.io.OutputStream) pack200CompressorOutputStream11);
        char[] charArray23 = new char[] { 'a', 'a', '#', '4', '4' };
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder24 = builder17.setPassword(charArray23);
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder26 = builder24.setBufferSize((java.lang.Integer) 32768);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(bHSDCodec12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] { (byte) 35 });
        org.junit.Assert.assertNotNull(builder17);
        org.junit.Assert.assertNotNull(charArray23);
        org.junit.Assert.assertArrayEquals(charArray23, new char[] { 'a', 'a', '#', '4', '4' });
        org.junit.Assert.assertNotNull(builder24);
        org.junit.Assert.assertNotNull(builder26);
    }

    @Test
    public void test1109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1109");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipFile zipFile1 = new org.apache.commons.compress.archivers.zip.ZipFile("xz");
            org.junit.Assert.fail("Expected exception of type java.nio.file.NoSuchFileException; message: xz");
        } catch (java.nio.file.NoSuchFileException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1110");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPLong cPLong2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPLong((java.lang.Long) 6L, 31);
        java.lang.String str3 = cPLong2.toString();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Long: 6" + "'", str3, "Long: 6");
    }

    @Test
    public void test1111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1111");
        java.nio.file.Path path0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarFile tarFile2 = new org.apache.commons.compress.archivers.tar.TarFile(path0, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1112");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_1 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        cPUTF8_1.setIndex(4);
        org.apache.commons.compress.harmony.pack200.Segment segment4 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands6 = new org.apache.commons.compress.harmony.pack200.CpBands(segment4, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature8 = cpBands6.getCPSignature("ustar\000");
        org.apache.commons.compress.harmony.pack200.CPNameAndType cPNameAndType9 = new org.apache.commons.compress.harmony.pack200.CPNameAndType(cPUTF8_1, cPSignature8);
        int int10 = cPNameAndType9.getNameIndex();
        int int11 = cPNameAndType9.getNameIndex();
        org.junit.Assert.assertNotNull(cPSignature8);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 4 + "'", int10 == 4);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 4 + "'", int11 == 4);
    }

    @Test
    public void test1113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1113");
        java.io.InputStream inputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream1);
        int int3 = cpioArchiveInputStream2.getCount();
        cpioArchiveInputStream2.reset();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream7 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream2, (long) 'a', 0);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec8 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean9 = bHSDCodec8.isDelta();
        long long10 = bHSDCodec8.smallest();
        org.apache.commons.compress.harmony.pack200.Codec codec11 = org.apache.commons.compress.harmony.pack200.CodecEncoding.getCodec(52, (java.io.InputStream) cRC32VerifyingInputStream7, (org.apache.commons.compress.harmony.pack200.Codec) bHSDCodec8);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(bHSDCodec8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + long10 + "' != '" + 0L + "'", long10 == 0L);
        org.junit.Assert.assertNotNull(codec11);
    }

    @Test
    public void test1114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1114");
        int int0 = org.apache.commons.compress.archivers.zip.UnixStat.LINK_FLAG;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 40960 + "'", int0 == 40960);
    }

    @Test
    public void test1115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1115");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        long long3 = dumpArchiveEntry2.getSize();
        boolean boolean4 = dumpArchiveEntry2.isBlkDev();
        dumpArchiveEntry2.setGeneration((int) (byte) 55);
        dumpArchiveEntry2.setGeneration(55);
        org.apache.commons.compress.archivers.dump.DumpArchiveConstants.SEGMENT_TYPE sEGMENT_TYPE9 = dumpArchiveEntry2.getHeaderType();
        java.lang.String str10 = dumpArchiveEntry2.getName();
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNull(sEGMENT_TYPE9);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "jar" + "'", str10, "jar");
    }

    @Test
    public void test1116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1116");
        java.lang.String str0 = org.apache.commons.compress.harmony.pack200.PackingOptions.PASS;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "pass" + "'", str0, "pass");
    }

    @Test
    public void test1117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1117");
        org.apache.commons.compress.harmony.pack200.CPInt cPInt1 = new org.apache.commons.compress.harmony.pack200.CPInt(60012);
    }

    @Test
    public void test1118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1118");
        org.apache.commons.compress.archivers.zip.AsiExtraField asiExtraField0 = new org.apache.commons.compress.archivers.zip.AsiExtraField();
        int int1 = asiExtraField0.getMode();
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker2 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray3 = jarMarker2.getCentralDirectoryData();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField4 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger5 = zip64ExtendedInformationExtraField4.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger6 = null;
        zip64ExtendedInformationExtraField4.setSize(zipEightByteInteger6);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField8 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField9 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger10 = zip64ExtendedInformationExtraField9.getCompressedSize();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField11 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger12 = zip64ExtendedInformationExtraField11.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger13 = null;
        zip64ExtendedInformationExtraField11.setSize(zipEightByteInteger13);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField15 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger16 = zip64ExtendedInformationExtraField15.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger17 = null;
        zip64ExtendedInformationExtraField15.setSize(zipEightByteInteger17);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField19 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipExtraField[] zipExtraFieldArray20 = new org.apache.commons.compress.archivers.zip.ZipExtraField[] { zip64ExtendedInformationExtraField4, zip64ExtendedInformationExtraField8, zip64ExtendedInformationExtraField9, zip64ExtendedInformationExtraField11, zip64ExtendedInformationExtraField15, zip64ExtendedInformationExtraField19 };
        byte[] byteArray21 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.mergeLocalFileDataData(zipExtraFieldArray20);
        boolean boolean22 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray3, byteArray21);
        // The following exception was thrown during execution in test generation
        try {
            asiExtraField0.parseFromCentralDirectoryData(byteArray3, 33188, 0);
            org.junit.Assert.fail("Expected exception of type java.util.zip.ZipException; message: The length is too short, only 0 bytes, expected at least 14");
        } catch (java.util.zip.ZipException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 0 + "'", int1 == 0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] {});
        org.junit.Assert.assertNull(zipEightByteInteger5);
        org.junit.Assert.assertNull(zipEightByteInteger10);
        org.junit.Assert.assertNull(zipEightByteInteger12);
        org.junit.Assert.assertNull(zipEightByteInteger16);
        org.junit.Assert.assertNotNull(zipExtraFieldArray20);
        org.junit.Assert.assertNotNull(byteArray21);
        org.junit.Assert.assertArrayEquals(byteArray21, new byte[] { (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test1119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1119");
        int int0 = org.apache.commons.compress.archivers.zip.ZipArchiveEntry.PLATFORM_FAT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 0 + "'", int0 == 0);
    }

    @Test
    public void test1120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1120");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_2);
        java.lang.String str4 = cPUTF8_2.toString();
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_7 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_7);
        org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute newAttribute10 = new org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute(cPUTF8_7, 8);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_14 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_14);
        org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute newAttribute17 = new org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute(cPUTF8_14, 8);
        org.apache.commons.compress.harmony.unpack200.bytecode.Attribute[] attributeArray18 = new org.apache.commons.compress.harmony.unpack200.bytecode.Attribute[] { newAttribute17 };
        java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute> attributeList19 = new java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute>();
        boolean boolean20 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute>) attributeList19, attributeArray18);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPMember cPMember21 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPMember(cPUTF8_2, cPUTF8_7, (long) (byte) 0, (java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute>) attributeList19);
        org.apache.commons.compress.harmony.unpack200.bytecode.SignatureAttribute signatureAttribute22 = new org.apache.commons.compress.harmony.unpack200.bytecode.SignatureAttribute(cPUTF8_2);
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.Annotation[] annotationArray23 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.Annotation[] {};
        org.apache.commons.compress.harmony.unpack200.bytecode.RuntimeVisibleorInvisibleAnnotationsAttribute runtimeVisibleorInvisibleAnnotationsAttribute24 = new org.apache.commons.compress.harmony.unpack200.bytecode.RuntimeVisibleorInvisibleAnnotationsAttribute(cPUTF8_2, annotationArray23);
        org.apache.commons.compress.harmony.unpack200.bytecode.LocalVariableTableAttribute.setAttributeName(cPUTF8_2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "UTF-8:splitting" + "'", str4, "UTF-8:splitting");
        org.junit.Assert.assertNotNull(attributeArray18);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
        org.junit.Assert.assertNotNull(annotationArray23);
        org.junit.Assert.assertArrayEquals(annotationArray23, new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.Annotation[] {});
    }

    @Test
    public void test1121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1121");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime1 = null;
        x5455_ExtendedTimestamp0.setAccessFileTime(fileTime1);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = x5455_ExtendedTimestamp0.getLocalFileDataLength();
        java.nio.file.attribute.FileTime fileTime4 = x5455_ExtendedTimestamp0.getCreateFileTime();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong5 = x5455_ExtendedTimestamp0.getCreateTime();
        org.junit.Assert.assertNotNull(zipShort3);
        org.junit.Assert.assertNull(fileTime4);
        org.junit.Assert.assertNull(zipLong5);
    }

    @Test
    public void test1122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1122");
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel1 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        byte[] byteArray3 = org.apache.commons.compress.utils.IOUtils.readRange((java.nio.channels.ReadableByteChannel) seekableInMemoryByteChannel1, (int) '#');
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipFile zipFile4 = new org.apache.commons.compress.archivers.zip.ZipFile((java.nio.channels.SeekableByteChannel) seekableInMemoryByteChannel1);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.Charsets.toCharset(Ljava/nio/charset/Charset;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray3);
    }

    @Test
    public void test1123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1123");
        org.apache.commons.compress.archivers.zip.X0016_CertificateIdForCentralDirectory x0016_CertificateIdForCentralDirectory0 = new org.apache.commons.compress.archivers.zip.X0016_CertificateIdForCentralDirectory();
    }

    @Test
    public void test1124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1124");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file3 = tarArchiveEntry2.getFile();
        int int4 = tarArchiveEntry2.getDevMinor();
        boolean boolean5 = tarArchiveEntry2.isPaxGNU1XSparse();
        // The following exception was thrown during execution in test generation
        try {
            tarArchiveEntry2.setDataOffset((long) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The offset cannot be smaller than 0");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(file3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test1125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1125");
        org.apache.commons.compress.compressors.gzip.GzipParameters gzipParameters0 = new org.apache.commons.compress.compressors.gzip.GzipParameters();
        gzipParameters0.setOperatingSystem(6);
        java.lang.String str3 = gzipParameters0.getFilename();
        gzipParameters0.setModificationTime((-2147483648L));
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test1126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1126");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_3 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_5 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition attributeDefinition6 = new org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition(4096, 493, cPUTF8_3, cPUTF8_5);
        cPUTF8_3.setIndex(8192);
    }

    @Test
    public void test1127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1127");
        java.util.jar.JarInputStream jarInputStream0 = null;
        java.util.jar.JarFile jarFile1 = null;
        java.io.OutputStream outputStream2 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream4 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream2, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry5 = null;
        boolean boolean6 = cpioArchiveOutputStream4.canWriteEntryData(archiveEntry5);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream8 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream4, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream10 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream8, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap11 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream12 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream10, strMap11);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec13 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean14 = bHSDCodec13.isDelta();
        byte[] byteArray16 = bHSDCodec13.encode((int) '#');
        pack200CompressorOutputStream12.write(byteArray16);
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions18 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        org.apache.commons.compress.harmony.pack200.Archive archive19 = new org.apache.commons.compress.harmony.pack200.Archive(jarFile1, (java.io.OutputStream) pack200CompressorOutputStream12, packingOptions18);
        java.util.jar.JarFile jarFile20 = null;
        java.io.OutputStream outputStream21 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream23 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream21, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry24 = null;
        boolean boolean25 = cpioArchiveOutputStream23.canWriteEntryData(archiveEntry24);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream27 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream23, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream29 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream27, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap30 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream31 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream29, strMap30);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec32 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean33 = bHSDCodec32.isDelta();
        byte[] byteArray35 = bHSDCodec32.encode((int) '#');
        pack200CompressorOutputStream31.write(byteArray35);
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions37 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        org.apache.commons.compress.harmony.pack200.Archive archive38 = new org.apache.commons.compress.harmony.pack200.Archive(jarFile20, (java.io.OutputStream) pack200CompressorOutputStream31, packingOptions37);
        org.apache.commons.compress.harmony.pack200.Archive archive39 = new org.apache.commons.compress.harmony.pack200.Archive(jarInputStream0, (java.io.OutputStream) pack200CompressorOutputStream12, packingOptions37);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream41 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) pack200CompressorOutputStream12, (int) (short) 4);
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker42 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray43 = jarMarker42.getLocalFileDataData();
        pack200CompressorOutputStream12.write(byteArray43);
        // The following exception was thrown during execution in test generation
        try {
            pack200CompressorOutputStream12.finish();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertNotNull(bHSDCodec13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(byteArray16);
        org.junit.Assert.assertArrayEquals(byteArray16, new byte[] { (byte) 35 });
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + true + "'", boolean25 == true);
        org.junit.Assert.assertNotNull(bHSDCodec32);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertNotNull(byteArray35);
        org.junit.Assert.assertArrayEquals(byteArray35, new byte[] { (byte) 35 });
        org.junit.Assert.assertNotNull(byteArray43);
        org.junit.Assert.assertArrayEquals(byteArray43, new byte[] {});
    }

    @Test
    public void test1128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1128");
        org.apache.commons.compress.harmony.pack200.Segment segment2 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands4 = new org.apache.commons.compress.harmony.pack200.CpBands(segment2, (int) (byte) 2);
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS5 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.pack200.CPConstant<?> wildcardCPConstant6 = cpBands4.getConstant((java.lang.Object) oS5);
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader7 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        org.apache.commons.compress.harmony.pack200.MetadataBandGroup metadataBandGroup9 = new org.apache.commons.compress.harmony.pack200.MetadataBandGroup("LocalVariableTypeTable", 16, cpBands4, segmentHeader7, 263);
        org.apache.commons.compress.harmony.pack200.Segment segment10 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.IcBands icBands11 = segment10.getIcBands();
        org.apache.commons.compress.harmony.pack200.ClassBands classBands12 = segment10.getClassBands();
        org.apache.commons.compress.harmony.pack200.BcBands bcBands14 = new org.apache.commons.compress.harmony.pack200.BcBands(cpBands4, segment10, 32782);
        org.objectweb.asm.Label label17 = null;
        org.objectweb.asm.Label label18 = null;
        org.objectweb.asm.Label[] labelArray19 = new org.objectweb.asm.Label[] { label18 };
        bcBands14.visitTableSwitchInsn(0, 96, label17, labelArray19);
        bcBands14.setCurrentClass("ISO-8859-1", "0x7875 Zip Extra Field: UID=32768 GID=1000");
        // The following exception was thrown during execution in test generation
        try {
            bcBands14.visitTypeInsn((int) (byte) 10, "UTF-16BE");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + oS5 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS5.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertNull(wildcardCPConstant6);
        org.junit.Assert.assertNull(icBands11);
        org.junit.Assert.assertNull(classBands12);
        org.junit.Assert.assertNotNull(labelArray19);
        org.junit.Assert.assertArrayEquals(labelArray19, new org.objectweb.asm.Label[] { null });
    }

    @Test
    public void test1129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1129");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.XSTAR_MULTIVOLUME_OFFSET;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 464 + "'", int0 == 464);
    }

    @Test
    public void test1130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1130");
        org.apache.commons.compress.harmony.pack200.BHSDCodec[] bHSDCodecArray0 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs5;
        org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaUnsignedCodecs2 = bHSDCodecArray0;
        org.junit.Assert.assertNotNull(bHSDCodecArray0);
    }

    @Test
    public void test1131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1131");
        java.nio.charset.Charset charset2 = null;
        org.apache.commons.compress.archivers.zip.ZipEncoding zipEncoding3 = org.apache.commons.compress.archivers.zip.ZipEncodingHelper.getZipEncoding(charset2);
        byte[] byteArray9 = new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 };
        byte[] byteArray16 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean18 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray16, 0);
        boolean boolean19 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray9, byteArray16);
        java.lang.String str20 = zipEncoding3.decode(byteArray9);
        org.apache.commons.compress.harmony.unpack200.Segment segment21 = new org.apache.commons.compress.harmony.unpack200.Segment();
        org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager operandManager22 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass26 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry27 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass26);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass31 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry32 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass31);
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry[] exceptionTableEntryArray33 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry[] { exceptionTableEntry27, exceptionTableEntry32 };
        java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry> exceptionTableEntryList34 = new java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>();
        boolean boolean35 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>) exceptionTableEntryList34, exceptionTableEntryArray33);
        org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute codeAttribute36 = new org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute(476, (int) (byte) 51, byteArray9, segment21, operandManager22, (java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>) exceptionTableEntryList34);
        java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode> byteCodeList37 = codeAttribute36.byteCodes;
        org.apache.commons.compress.harmony.unpack200.bytecode.Attribute attribute38 = null;
        codeAttribute36.addAttribute(attribute38);
        java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute> attributeList40 = codeAttribute36.attributes;
        org.junit.Assert.assertNotNull(zipEncoding3);
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertArrayEquals(byteArray9, new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 });
        org.junit.Assert.assertNotNull(byteArray16);
        org.junit.Assert.assertArrayEquals(byteArray16, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "\002?\002\n\001" + "'", str20, "\002?\002\n\001");
        org.junit.Assert.assertNotNull(exceptionTableEntryArray33);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + true + "'", boolean35 == true);
        org.junit.Assert.assertNotNull(byteCodeList37);
        org.junit.Assert.assertNotNull(attributeList40);
    }

    @Test
    public void test1132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1132");
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode1 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int2 = byteCode1.getByteCodeIndex();
        int[] intArray3 = new int[] {};
        int[] intArray4 = new int[] {};
        int[] intArray5 = new int[] {};
        int[][] intArray6 = new int[][] { intArray3, intArray4, intArray5 };
        byteCode1.setNestedPositions(intArray6);
        int[] intArray8 = byteCode1.getRewrite();
        boolean boolean10 = byteCode1.equals((java.lang.Object) (byte) 7);
        int[] intArray21 = new int[] { ' ', (byte) -1 };
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm iMethodRefForm22 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm((int) (byte) -1, "", intArray21);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm classRefForm23 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm((int) (short) 0, "jar", intArray21);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.StringRefForm stringRefForm25 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.StringRefForm(1, "splitting", intArray21, true);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.LongForm longForm26 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.LongForm(17, "ACC_STATIC", intArray21);
        byteCode1.setRewrite(intArray21);
        org.junit.Assert.assertNotNull(byteCode1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
        org.junit.Assert.assertNotNull(intArray3);
        org.junit.Assert.assertArrayEquals(intArray3, new int[] {});
        org.junit.Assert.assertNotNull(intArray4);
        org.junit.Assert.assertArrayEquals(intArray4, new int[] {});
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] {});
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertNotNull(intArray8);
        org.junit.Assert.assertArrayEquals(intArray8, new int[] { 255 });
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(intArray21);
        org.junit.Assert.assertArrayEquals(intArray21, new int[] { 32, (-1) });
    }

    @Test
    public void test1133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1133");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        java.util.Date date3 = dumpArchiveEntry2.getLastModifiedDate();
        boolean boolean5 = dumpArchiveEntry2.isSparseRecord((int) (byte) 75);
        org.junit.Assert.assertNotNull(date3);
        org.junit.Assert.assertEquals(date3.toString(), "Thu Jan 01 10:00:00 AEST 1970");
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test1134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1134");
        org.apache.commons.compress.harmony.pack200.NewAttribute.StripAttribute stripAttribute2 = new org.apache.commons.compress.harmony.pack200.NewAttribute.StripAttribute("(5,4)", 8192);
        stripAttribute2.addContext((int) (byte) 88);
    }

    @Test
    public void test1135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1135");
        org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData unparseableExtraFieldData0 = new org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort1 = unparseableExtraFieldData0.getHeaderId();
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp2 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime3 = null;
        x5455_ExtendedTimestamp2.setAccessFileTime(fileTime3);
        byte[] byteArray5 = x5455_ExtendedTimestamp2.getLocalFileDataData();
        // The following exception was thrown during execution in test generation
        try {
            unparseableExtraFieldData0.parseFromCentralDirectoryData(byteArray5, 1000, (int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: null");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(zipShort1);
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] { (byte) 0 });
    }

    @Test
    public void test1136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1136");
        int int0 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.UnparseableExtraField.READ_KEY;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2 + "'", int0 == 2);
    }

    @Test
    public void test1137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1137");
        org.apache.commons.compress.harmony.pack200.Segment segment0 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands2 = new org.apache.commons.compress.harmony.pack200.CpBands(segment0, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPMethodOrField cPMethodOrField6 = cpBands2.getCPMethod("", "zstd", "ACC_STRICT");
        org.apache.commons.compress.harmony.pack200.CPClass cPClass8 = cpBands2.getCPClass("true");
        org.apache.commons.compress.harmony.pack200.CPClass cPClass10 = cpBands2.getCPClass("ACC_TRANSIENT");
        org.junit.Assert.assertNotNull(cPMethodOrField6);
        org.junit.Assert.assertNotNull(cPClass8);
        org.junit.Assert.assertNotNull(cPClass10);
    }

    @Test
    public void test1138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1138");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream8 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 4);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream10 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 32);
        java.io.File file11 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.cpio.CpioArchiveEntry cpioArchiveEntry13 = cpioArchiveOutputStream2.createArchiveEntry(file11, "pack.deflate.hint.lzma.lzma");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test1139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1139");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass[] cPClassArray0 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPClass[] {};
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionsAttribute exceptionsAttribute1 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionsAttribute(cPClassArray0);
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger2 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger3 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger4 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry5 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date6 = arjArchiveEntry5.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong7 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date6);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField8 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField(zipEightByteInteger2, zipEightByteInteger3, zipEightByteInteger4, zipLong7);
        boolean boolean9 = exceptionsAttribute1.equals((java.lang.Object) zip64ExtendedInformationExtraField8);
        java.lang.String str10 = exceptionsAttribute1.toString();
        org.junit.Assert.assertNotNull(cPClassArray0);
        org.junit.Assert.assertArrayEquals(cPClassArray0, new org.apache.commons.compress.harmony.unpack200.bytecode.CPClass[] {});
        org.junit.Assert.assertNotNull(zipEightByteInteger2);
        org.junit.Assert.assertNotNull(zipEightByteInteger3);
        org.junit.Assert.assertNotNull(zipEightByteInteger4);
        org.junit.Assert.assertNotNull(date6);
        org.junit.Assert.assertEquals(date6.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong7);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "Exceptions: " + "'", str10, "Exceptions: ");
    }

    @Test
    public void test1140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1140");
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream.UnicodeExtraFieldPolicy unicodeExtraFieldPolicy0 = org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream.UnicodeExtraFieldPolicy.NOT_ENCODEABLE;
        java.lang.String str1 = unicodeExtraFieldPolicy0.toString();
        java.lang.String str2 = unicodeExtraFieldPolicy0.toString();
        org.junit.Assert.assertNotNull(unicodeExtraFieldPolicy0);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "not encodeable" + "'", str1, "not encodeable");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "not encodeable" + "'", str2, "not encodeable");
    }

    @Test
    public void test1141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1141");
        org.apache.commons.compress.compressors.gzip.GzipParameters gzipParameters0 = new org.apache.commons.compress.compressors.gzip.GzipParameters();
        gzipParameters0.setOperatingSystem(6);
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS3 = gzipParameters0.getOS();
        gzipParameters0.setBufferSize(16384);
        gzipParameters0.setDeflateStrategy((int) (byte) 6);
        java.util.ArrayList<java.nio.file.attribute.FileTime> fileTimeList8 = org.apache.commons.compress.utils.Lists.newArrayList();
        boolean boolean9 = gzipParameters0.equals((java.lang.Object) fileTimeList8);
        org.junit.Assert.assertTrue("'" + oS3 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.HPFS + "'", oS3.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.HPFS));
        org.junit.Assert.assertNotNull(fileTimeList8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test1142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1142");
        java.io.File file0 = null;
        java.io.File[] fileArray1 = new java.io.File[] { file0 };
        // The following exception was thrown during execution in test generation
        try {
            java.nio.channels.SeekableByteChannel seekableByteChannel2 = org.apache.commons.compress.archivers.zip.ZipSplitReadOnlySeekableByteChannel.forFiles(fileArray1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(fileArray1);
        org.junit.Assert.assertArrayEquals(fileArray1, new java.io.File[] { null });
    }

    @Test
    public void test1143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1143");
        java.nio.file.Path path0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipFile zipFile2 = new org.apache.commons.compress.archivers.zip.ZipFile(path0, "Exceptions: ");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1144");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE tYPE0 = org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.BLKDEV;
        org.junit.Assert.assertTrue("'" + tYPE0 + "' != '" + org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.BLKDEV + "'", tYPE0.equals(org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.BLKDEV));
    }

    @Test
    public void test1145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1145");
        org.apache.commons.compress.compressors.lzma.LZMAUtils.setCacheLZMAAvailablity(true);
    }

    @Test
    public void test1146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1146");
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker0 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray1 = jarMarker0.getCentralDirectoryData();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger3 = new org.apache.commons.compress.archivers.zip.ZipEightByteInteger(byteArray1, (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: null");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] {});
    }

    @Test
    public void test1147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1147");
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader0 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        boolean boolean1 = segmentHeader0.have_method_flags_hi();
        java.io.OutputStream outputStream2 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream4 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream2, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry5 = null;
        boolean boolean6 = cpioArchiveOutputStream4.canWriteEntryData(archiveEntry5);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream8 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream4, 135);
        org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream framedLZ4CompressorOutputStream9 = new org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream8);
        segmentHeader0.pack((java.io.OutputStream) framedLZ4CompressorOutputStream9);
        segmentHeader0.setCp_Imethod_count((int) (byte) 49);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test1148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1148");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_0 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute newAttribute2 = new org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute(cPUTF8_0, (int) (short) 1);
    }

    @Test
    public void test1149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1149");
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.Builder builder0 = org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.builder();
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.Builder builder2 = builder0.withTryToRecoverBrokenArchives(true);
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(builder2);
    }

    @Test
    public void test1150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1150");
        org.apache.commons.compress.archivers.zip.X0017_StrongEncryptionHeader x0017_StrongEncryptionHeader0 = new org.apache.commons.compress.archivers.zip.X0017_StrongEncryptionHeader();
    }

    @Test
    public void test1151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1151");
        org.apache.commons.compress.archivers.zip.X7875_NewUnix x7875_NewUnix0 = new org.apache.commons.compress.archivers.zip.X7875_NewUnix();
        x7875_NewUnix0.setUID((long) 32768);
        java.lang.String str3 = x7875_NewUnix0.toString();
        byte[] byteArray4 = x7875_NewUnix0.getLocalFileDataData();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "0x7875 Zip Extra Field: UID=32768 GID=1000" + "'", str3, "0x7875 Zip Extra Field: UID=32768 GID=1000");
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 1, (byte) 2, (byte) 0, (byte) -128, (byte) 2, (byte) -24, (byte) 3 });
    }

    @Test
    public void test1152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1152");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream8 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream6, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap9 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream10 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream8, strMap9);
        boolean boolean11 = pack200CompressorOutputStream10.isClosed();
        org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream snappyCompressorOutputStream13 = new org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream((java.io.OutputStream) pack200CompressorOutputStream10, (long) 10240);
        org.apache.commons.compress.archivers.jar.JarArchiveOutputStream jarArchiveOutputStream14 = new org.apache.commons.compress.archivers.jar.JarArchiveOutputStream((java.io.OutputStream) snappyCompressorOutputStream13);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test1153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1153");
        org.apache.commons.compress.archivers.ArchiveStreamFactory archiveStreamFactory0 = org.apache.commons.compress.archivers.ArchiveStreamFactory.DEFAULT;
        java.util.SortedMap<java.lang.String, org.apache.commons.compress.archivers.ArchiveStreamProvider> strMap1 = archiveStreamFactory0.getArchiveInputStreamProviders();
        org.junit.Assert.assertNotNull(archiveStreamFactory0);
        org.junit.Assert.assertNotNull(strMap1);
    }

    @Test
    public void test1154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1154");
        int int0 = org.apache.commons.compress.archivers.zip.UnixStat.FILE_TYPE_FLAG;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 61440 + "'", int0 == 61440);
    }

    @Test
    public void test1155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1155");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec1 = org.apache.commons.compress.harmony.pack200.CodecEncoding.getCanonicalCodec(3);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec2 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean3 = bHSDCodec2.isDelta();
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec4 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean5 = bHSDCodec4.isDelta();
        byte[] byteArray7 = bHSDCodec4.encode((int) '#');
        int int8 = bHSDCodec4.getS();
        org.apache.commons.compress.harmony.pack200.PopulationCodec populationCodec9 = new org.apache.commons.compress.harmony.pack200.PopulationCodec((org.apache.commons.compress.harmony.pack200.Codec) bHSDCodec1, (org.apache.commons.compress.harmony.pack200.Codec) bHSDCodec2, (org.apache.commons.compress.harmony.pack200.Codec) bHSDCodec4);
        org.apache.commons.compress.harmony.pack200.Codec codec10 = populationCodec9.getFavouredCodec();
        org.junit.Assert.assertNotNull(bHSDCodec1);
        org.junit.Assert.assertNotNull(bHSDCodec2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(bHSDCodec4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) 35 });
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(codec10);
    }

    @Test
    public void test1156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1156");
        byte[] byteArray1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField2 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField("apk.bz2", byteArray1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1157");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file3 = tarArchiveEntry2.getFile();
        int int4 = tarArchiveEntry2.getDevMinor();
        boolean boolean5 = tarArchiveEntry2.isGNULongNameEntry();
        org.junit.Assert.assertNull(file3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test1158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1158");
        byte[] byteArray0 = null;
        org.apache.commons.compress.compressors.lz77support.LZ77Compressor.LiteralBlock literalBlock3 = new org.apache.commons.compress.compressors.lz77support.LZ77Compressor.LiteralBlock(byteArray0, 0, (int) (byte) 51);
    }

    @Test
    public void test1159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1159");
        org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData unparseableExtraFieldData0 = new org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort1 = unparseableExtraFieldData0.getLocalFileDataLength();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort2 = unparseableExtraFieldData0.getHeaderId();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = unparseableExtraFieldData0.getLocalFileDataLength();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort4 = unparseableExtraFieldData0.getLocalFileDataLength();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger5 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger6 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger7 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry8 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date9 = arjArchiveEntry8.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong10 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date9);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField11 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField(zipEightByteInteger5, zipEightByteInteger6, zipEightByteInteger7, zipLong10);
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger12 = zip64ExtendedInformationExtraField11.getSize();
        byte[] byteArray13 = zip64ExtendedInformationExtraField11.getLocalFileDataData();
        // The following exception was thrown during execution in test generation
        try {
            unparseableExtraFieldData0.parseFromCentralDirectoryData(byteArray13, 131, (int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: null");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(zipShort1);
        org.junit.Assert.assertNotNull(zipShort2);
        org.junit.Assert.assertNotNull(zipShort3);
        org.junit.Assert.assertNotNull(zipShort4);
        org.junit.Assert.assertNotNull(zipEightByteInteger5);
        org.junit.Assert.assertNotNull(zipEightByteInteger6);
        org.junit.Assert.assertNotNull(zipEightByteInteger7);
        org.junit.Assert.assertNotNull(date9);
        org.junit.Assert.assertEquals(date9.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong10);
        org.junit.Assert.assertNotNull(zipEightByteInteger12);
        org.junit.Assert.assertNotNull(byteArray13);
        org.junit.Assert.assertArrayEquals(byteArray13, new byte[] { (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0 });
    }

    @Test
    public void test1160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1160");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec3 = new org.apache.commons.compress.harmony.pack200.BHSDCodec(2048, 488, (int) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: 1<=b<=5");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1161");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry6 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean7 = cpioArchiveOutputStream2.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry6);
        int int8 = cpioArchiveOutputStream2.getCount();
        // The following exception was thrown during execution in test generation
        try {
            cpioArchiveOutputStream2.closeArchiveEntry();
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: Trying to close non-existent entry");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
    }

    @Test
    public void test1162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1162");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry3 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("xz", (byte) 88, false);
    }

    @Test
    public void test1163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1163");
        org.apache.commons.compress.compressors.gzip.GzipParameters gzipParameters0 = new org.apache.commons.compress.compressors.gzip.GzipParameters();
        gzipParameters0.setOperatingSystem(6);
        boolean boolean3 = gzipParameters0.getHeaderCRC();
        long long4 = gzipParameters0.getTrailerCrc();
        java.nio.charset.Charset charset5 = org.apache.commons.compress.utils.Charsets.US_ASCII;
        // The following exception was thrown during execution in test generation
        try {
            gzipParameters0.setFileNameCharset(charset5);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.Charsets.toCharset(Ljava/nio/charset/Charset;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + long4 + "' != '" + 0L + "'", long4 == 0L);
        org.junit.Assert.assertNotNull(charset5);
    }

    @Test
    public void test1164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1164");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("", true);
        tarArchiveEntry2.setMode(16877);
        java.nio.file.attribute.FileTime fileTime5 = tarArchiveEntry2.getStatusChangeTime();
        boolean boolean6 = tarArchiveEntry2.isStreamContiguous();
        boolean boolean7 = tarArchiveEntry2.isGNULongLinkEntry();
        java.nio.file.attribute.FileTime fileTime8 = tarArchiveEntry2.getLastModifiedTime();
        boolean boolean9 = tarArchiveEntry2.isFIFO();
        org.junit.Assert.assertNull(fileTime5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(fileTime8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test1165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1165");
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.WideForm wideForm2 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.WideForm(10, "");
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode7 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int8 = byteCode7.getByteCodeIndex();
        int[] intArray9 = new int[] {};
        int[] intArray10 = new int[] {};
        int[] intArray11 = new int[] {};
        int[][] intArray12 = new int[][] { intArray9, intArray10, intArray11 };
        byteCode7.setNestedPositions(intArray12);
        int[] intArray14 = byteCode7.getRewrite();
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.ThisFieldRefForm thisFieldRefForm15 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.ThisFieldRefForm(17, "ar", intArray14);
        // The following exception was thrown during execution in test generation
        try {
            wideForm2.setRewrite4Bytes((int) (byte) 49, intArray14);
            org.junit.Assert.fail("Expected exception of type java.lang.Error; message: Trying to rewrite org.apache.commons.compress.harmony.unpack200.bytecode.forms.WideForm() but there is no room for 4 bytes");
        } catch (java.lang.Error e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteCode7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertArrayEquals(intArray9, new int[] {});
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] {});
        org.junit.Assert.assertNotNull(intArray11);
        org.junit.Assert.assertArrayEquals(intArray11, new int[] {});
        org.junit.Assert.assertNotNull(intArray12);
        org.junit.Assert.assertNotNull(intArray14);
        org.junit.Assert.assertArrayEquals(intArray14, new int[] { 255 });
    }

    @Test
    public void test1166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1166");
        java.nio.file.Path[] pathArray0 = new java.nio.file.Path[] {};
        java.util.ArrayList<java.nio.file.Path> pathList1 = new java.util.ArrayList<java.nio.file.Path>();
        boolean boolean2 = java.util.Collections.addAll((java.util.Collection<java.nio.file.Path>) pathList1, pathArray0);
        java.nio.file.OpenOption[] openOptionArray3 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.nio.channels.SeekableByteChannel seekableByteChannel4 = org.apache.commons.compress.archivers.zip.ZipSplitReadOnlySeekableByteChannel.forPaths((java.util.List<java.nio.file.Path>) pathList1, openOptionArray3);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 0, Size: 0");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pathArray0);
        org.junit.Assert.assertArrayEquals(pathArray0, new java.nio.file.Path[] {});
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test1167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1167");
        org.apache.commons.compress.archivers.zip.ResourceAlignmentExtraField resourceAlignmentExtraField0 = new org.apache.commons.compress.archivers.zip.ResourceAlignmentExtraField();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort1 = resourceAlignmentExtraField0.getHeaderId();
        boolean boolean2 = resourceAlignmentExtraField0.allowMethodChange();
        org.junit.Assert.assertNotNull(zipShort1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test1168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1168");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        cpioArchiveInputStream1.reset();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream6 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream1, (long) 'a', 0);
        int int7 = cRC32VerifyingInputStream6.available();
        int int8 = cRC32VerifyingInputStream6.read();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 1 + "'", int7 == 1);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
    }

    @Test
    public void test1169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1169");
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.LookupSwitchForm lookupSwitchForm2 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.LookupSwitchForm(8, "ISO-8859-1");
    }

    @Test
    public void test1170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1170");
        org.apache.commons.compress.archivers.ArchiveStreamFactory archiveStreamFactory0 = new org.apache.commons.compress.archivers.ArchiveStreamFactory();
    }

    @Test
    public void test1171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1171");
        org.apache.commons.compress.archivers.zip.ResourceAlignmentExtraField resourceAlignmentExtraField1 = new org.apache.commons.compress.archivers.zip.ResourceAlignmentExtraField(10240);
        org.apache.commons.compress.archivers.zip.AsiExtraField asiExtraField2 = new org.apache.commons.compress.archivers.zip.AsiExtraField();
        byte[] byteArray3 = asiExtraField2.getCentralDirectoryData();
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField7 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.fillExtraField((org.apache.commons.compress.archivers.zip.ZipExtraField) resourceAlignmentExtraField1, byteArray3, 5, 4, true);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort8 = resourceAlignmentExtraField1.getCentralDirectoryLength();
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel10 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        byte[] byteArray12 = org.apache.commons.compress.utils.IOUtils.readRange((java.nio.channels.ReadableByteChannel) seekableInMemoryByteChannel10, (int) '#');
        resourceAlignmentExtraField1.parseFromLocalFileData(byteArray12, (int) (short) 12, 10240);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 118, (byte) 104, (byte) -118, (byte) -29, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertNotNull(zipExtraField7);
        org.junit.Assert.assertNotNull(zipShort8);
        org.junit.Assert.assertNotNull(byteArray12);
    }

    @Test
    public void test1172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1172");
        org.apache.commons.compress.archivers.examples.Archiver archiver0 = new org.apache.commons.compress.archivers.examples.Archiver();
        java.io.InputStream inputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream1);
        byte[] byteArray3 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream2);
        long long4 = cpioArchiveInputStream2.getBytesRead();
        int int5 = cpioArchiveInputStream2.getCount();
        boolean boolean6 = cpioArchiveInputStream2.markSupported();
        java.io.OutputStream outputStream7 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream9 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream7, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry10 = null;
        boolean boolean11 = cpioArchiveOutputStream9.canWriteEntryData(archiveEntry10);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream13 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream9, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream15 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream13, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap16 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream17 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream15, strMap16);
        long long18 = org.apache.commons.compress.utils.IOUtils.copy((java.io.InputStream) cpioArchiveInputStream2, (java.io.OutputStream) pack200CompressorOutputStream17);
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream19 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream((java.io.OutputStream) pack200CompressorOutputStream17);
        java.io.File file20 = null;
        // The following exception was thrown during execution in test generation
        try {
            archiver0.create((org.apache.commons.compress.archivers.ArchiveOutputStream<org.apache.commons.compress.archivers.cpio.CpioArchiveEntry>) cpioArchiveOutputStream19, file20);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] {});
        org.junit.Assert.assertTrue("'" + long4 + "' != '" + 0L + "'", long4 == 0L);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertTrue("'" + long18 + "' != '" + 0L + "'", long18 == 0L);
    }

    @Test
    public void test1173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1173");
        org.apache.commons.compress.harmony.pack200.Segment segment0 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.IcBands icBands1 = segment0.getIcBands();
        org.apache.commons.compress.harmony.pack200.ClassBands classBands2 = segment0.getClassBands();
        org.apache.commons.compress.harmony.pack200.Segment.SegmentAnnotationVisitor segmentAnnotationVisitor7 = segment0.new SegmentAnnotationVisitor(8, 8, "070702", true);
        org.junit.Assert.assertNull(icBands1);
        org.junit.Assert.assertNull(classBands2);
    }

    @Test
    public void test1174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1174");
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker0 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray1 = jarMarker0.getLocalFileDataData();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort2 = jarMarker0.getLocalFileDataLength();
        byte[] byteArray3 = jarMarker0.getLocalFileDataData();
        // The following exception was thrown during execution in test generation
        try {
            long long5 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.getLongValue(byteArray3, 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: null");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] {});
        org.junit.Assert.assertNotNull(zipShort2);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] {});
    }

    @Test
    public void test1175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1175");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        boolean boolean1 = sevenZArchiveEntry0.getHasCrc();
        sevenZArchiveEntry0.setAntiItem(true);
        // The following exception was thrown during execution in test generation
        try {
            java.nio.file.attribute.FileTime fileTime4 = sevenZArchiveEntry0.getAccessTime();
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: The entry doesn't have this timestamp");
        } catch (java.lang.UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test1176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1176");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        long long4 = cpioArchiveInputStream1.skip((long) 1);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorInputStream framedLZ4CompressorInputStream5 = new org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorInputStream((java.io.InputStream) cpioArchiveInputStream1);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + long4 + "' != '" + 0L + "'", long4 == 0L);
    }

    @Test
    public void test1177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1177");
        java.nio.file.Path path0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarFile tarFile2 = new org.apache.commons.compress.archivers.tar.TarFile(path0, "apk");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1178");
        org.apache.commons.compress.harmony.pack200.BHSDCodec[] bHSDCodecArray0 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaUnsignedCodecs2;
        org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs5 = bHSDCodecArray0;
        org.junit.Assert.assertNotNull(bHSDCodecArray0);
    }

    @Test
    public void test1179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1179");
        org.apache.commons.compress.archivers.sevenz.SevenZMethod sevenZMethod0 = org.apache.commons.compress.archivers.sevenz.SevenZMethod.DEFLATE;
        org.junit.Assert.assertTrue("'" + sevenZMethod0 + "' != '" + org.apache.commons.compress.archivers.sevenz.SevenZMethod.DEFLATE + "'", sevenZMethod0.equals(org.apache.commons.compress.archivers.sevenz.SevenZMethod.DEFLATE));
    }

    @Test
    public void test1180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1180");
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField0 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger1 = zip64ExtendedInformationExtraField0.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger2 = null;
        zip64ExtendedInformationExtraField0.setRelativeHeaderOffset(zipEightByteInteger2);
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker4 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray5 = jarMarker4.getCentralDirectoryData();
        byte[] byteArray6 = jarMarker4.getLocalFileDataData();
        boolean boolean8 = org.apache.commons.compress.compressors.xz.XZCompressorInputStream.matches(byteArray6, 0);
        boolean boolean10 = org.apache.commons.compress.archivers.dump.DumpArchiveInputStream.matches(byteArray6, 17);
        // The following exception was thrown during execution in test generation
        try {
            zip64ExtendedInformationExtraField0.parseFromCentralDirectoryData(byteArray6, (int) (short) 0, (int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: null");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(zipEightByteInteger1);
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] {});
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] {});
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test1181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1181");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("error", false);
        java.util.Date date3 = tarArchiveEntry2.getModTime();
        java.nio.file.attribute.FileTime fileTime4 = org.apache.commons.compress.utils.TimeUtils.toFileTime(date3);
        org.junit.Assert.assertNotNull(date3);
// flaky "2) test1181(RegressionTest2)":         org.junit.Assert.assertEquals(date3.toString(), "Fri Mar 14 23:48:46 AEDT 2025");
        org.junit.Assert.assertNotNull(fileTime4);
    }

    @Test
    public void test1182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1182");
        org.apache.commons.compress.harmony.pack200.BHSDCodec[] bHSDCodecArray0 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaSignedCodecs3;
        org.junit.Assert.assertNotNull(bHSDCodecArray0);
    }

    @Test
    public void test1183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1183");
        org.apache.commons.compress.compressors.gzip.GzipParameters gzipParameters0 = new org.apache.commons.compress.compressors.gzip.GzipParameters();
        gzipParameters0.setOperatingSystem(6);
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS3 = gzipParameters0.getOS();
        int int4 = gzipParameters0.getOperatingSystem();
        org.apache.commons.compress.compressors.gzip.ExtraField extraField5 = new org.apache.commons.compress.compressors.gzip.ExtraField();
        int int6 = extraField5.size();
        extraField5.clear();
        gzipParameters0.setExtraField(extraField5);
        org.junit.Assert.assertTrue("'" + oS3 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.HPFS + "'", oS3.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.HPFS));
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 6 + "'", int4 == 6);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test1184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1184");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("error", 32);
        org.apache.commons.compress.harmony.unpack200.MetadataBandGroup.setRvaAttributeName(cPUTF8_2);
        org.apache.commons.compress.harmony.unpack200.bytecode.SignatureAttribute.setAttributeName(cPUTF8_2);
    }

    @Test
    public void test1185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1185");
        long long1 = org.apache.commons.compress.archivers.zip.ZipUtil.adjustToLong(1024);
        org.junit.Assert.assertTrue("'" + long1 + "' != '" + 1024L + "'", long1 == 1024L);
    }

    @Test
    public void test1186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1186");
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker0 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray1 = jarMarker0.getLocalFileDataData();
        long long2 = org.apache.commons.compress.archivers.tar.TarUtils.computeCheckSum(byteArray1);
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] {});
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
    }

    @Test
    public void test1187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1187");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec0 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean1 = bHSDCodec0.isDelta();
        byte[] byteArray3 = bHSDCodec0.encode((int) '#');
        int int4 = bHSDCodec0.getS();
        int int5 = bHSDCodec0.getL();
        int[] intArray11 = new int[] { 52, 512, 345, '4', 255 };
        byte[] byteArray12 = bHSDCodec0.encode(intArray11);
        org.junit.Assert.assertNotNull(bHSDCodec0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 35 });
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 252 + "'", int5 == 252);
        org.junit.Assert.assertNotNull(intArray11);
        org.junit.Assert.assertArrayEquals(intArray11, new int[] { 52, 512, 345, 52, 255 });
        org.junit.Assert.assertNotNull(byteArray12);
        org.junit.Assert.assertArrayEquals(byteArray12, new byte[] { (byte) 52, (byte) -4, (byte) 65, (byte) -3, (byte) 23, (byte) 52, (byte) -1, (byte) 0 });
    }

    @Test
    public void test1188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1188");
        org.apache.commons.compress.archivers.zip.X0015_CertificateIdForFile x0015_CertificateIdForFile0 = new org.apache.commons.compress.archivers.zip.X0015_CertificateIdForFile();
        org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm hashAlgorithm1 = x0015_CertificateIdForFile0.getHashAlgorithm();
        org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm hashAlgorithm2 = x0015_CertificateIdForFile0.getHashAlgorithm();
        org.junit.Assert.assertNull(hashAlgorithm1);
        org.junit.Assert.assertNull(hashAlgorithm2);
    }

    @Test
    public void test1189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1189");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file3 = tarArchiveEntry2.getFile();
        int int4 = tarArchiveEntry2.getDevMinor();
        tarArchiveEntry2.setUserName("UTF-8:splitting");
        tarArchiveEntry2.setUserId(12);
        boolean boolean9 = tarArchiveEntry2.isCheckSumOK();
        org.junit.Assert.assertNull(file3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test1190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1190");
        org.apache.commons.compress.harmony.unpack200.bytecode.ClassFile classFile0 = new org.apache.commons.compress.harmony.unpack200.bytecode.ClassFile();
        org.apache.commons.compress.harmony.unpack200.bytecode.ClassConstantPool classConstantPool1 = classFile0.pool;
        org.apache.commons.compress.harmony.unpack200.bytecode.ClassConstantPool classConstantPool2 = classFile0.pool;
        org.junit.Assert.assertNotNull(classConstantPool1);
        org.junit.Assert.assertNotNull(classConstantPool2);
    }

    @Test
    public void test1191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1191");
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions0 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        boolean boolean2 = packingOptions0.isPassFile("TRAILER!!!");
        java.lang.String str3 = packingOptions0.getModificationTime();
        packingOptions0.removePassFile("pack.modification.time");
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "keep" + "'", str3, "keep");
    }

    @Test
    public void test1192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1192");
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel1 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        long long2 = seekableInMemoryByteChannel1.size();
        java.nio.channels.SeekableByteChannel seekableByteChannel4 = seekableInMemoryByteChannel1.position((long) 33188);
        char[] charArray7 = new char[] { '4', 'a' };
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.Builder builder8 = org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.builder();
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.Builder builder10 = builder8.withMaxMemoryLimitInKb(1000);
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions sevenZFileOptions11 = builder8.build();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZFile sevenZFile12 = new org.apache.commons.compress.archivers.sevenz.SevenZFile((java.nio.channels.SeekableByteChannel) seekableInMemoryByteChannel1, charArray7, sevenZFileOptions11);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.IOUtils.read(Ljava/nio/channels/ReadableByteChannel;Ljava/nio/ByteBuffer;)I");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 96L + "'", long2 == 96L);
        org.junit.Assert.assertNotNull(seekableByteChannel4);
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '4', 'a' });
        org.junit.Assert.assertNotNull(builder8);
        org.junit.Assert.assertNotNull(builder10);
        org.junit.Assert.assertNotNull(sevenZFileOptions11);
    }

    @Test
    public void test1193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1193");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipFile zipFile2 = new org.apache.commons.compress.archivers.zip.ZipFile("Code: 41 bytes", "Integer: 8");
            org.junit.Assert.fail("Expected exception of type java.nio.file.NoSuchFileException; message: Code: 41 bytes");
        } catch (java.nio.file.NoSuchFileException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1194");
        java.nio.charset.Charset charset2 = null;
        org.apache.commons.compress.archivers.zip.ZipEncoding zipEncoding3 = org.apache.commons.compress.archivers.zip.ZipEncodingHelper.getZipEncoding(charset2);
        byte[] byteArray9 = new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 };
        byte[] byteArray16 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean18 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray16, 0);
        boolean boolean19 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray9, byteArray16);
        java.lang.String str20 = zipEncoding3.decode(byteArray9);
        org.apache.commons.compress.harmony.unpack200.Segment segment21 = new org.apache.commons.compress.harmony.unpack200.Segment();
        org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager operandManager22 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass26 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry27 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass26);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass31 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry32 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass31);
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry[] exceptionTableEntryArray33 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry[] { exceptionTableEntry27, exceptionTableEntry32 };
        java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry> exceptionTableEntryList34 = new java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>();
        boolean boolean35 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>) exceptionTableEntryList34, exceptionTableEntryArray33);
        org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute codeAttribute36 = new org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute(476, (int) (byte) 51, byteArray9, segment21, operandManager22, (java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>) exceptionTableEntryList34);
        java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode> byteCodeList37 = codeAttribute36.byteCodes;
        org.apache.commons.compress.harmony.unpack200.bytecode.Attribute attribute38 = null;
        codeAttribute36.addAttribute(attribute38);
        java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode> byteCodeList40 = codeAttribute36.byteCodes;
        org.junit.Assert.assertNotNull(zipEncoding3);
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertArrayEquals(byteArray9, new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 });
        org.junit.Assert.assertNotNull(byteArray16);
        org.junit.Assert.assertArrayEquals(byteArray16, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "\002?\002\n\001" + "'", str20, "\002?\002\n\001");
        org.junit.Assert.assertNotNull(exceptionTableEntryArray33);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + true + "'", boolean35 == true);
        org.junit.Assert.assertNotNull(byteCodeList37);
        org.junit.Assert.assertNotNull(byteCodeList40);
    }

    @Test
    public void test1195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1195");
        java.io.InputStream inputStream0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.dump.DumpArchiveInputStream dumpArchiveInputStream2 = new org.apache.commons.compress.archivers.dump.DumpArchiveInputStream(inputStream0, "hi!.lzma");
            org.junit.Assert.fail("Expected exception of type java.nio.charset.IllegalCharsetNameException; message: hi!.lzma");
        } catch (java.nio.charset.IllegalCharsetNameException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1196");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream8 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream6, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap9 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream10 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream8, strMap9);
        boolean boolean11 = pack200CompressorOutputStream10.isClosed();
        org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream snappyCompressorOutputStream13 = new org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream((java.io.OutputStream) pack200CompressorOutputStream10, (long) 10240);
        snappyCompressorOutputStream13.write(28771);
        snappyCompressorOutputStream13.write((int) (byte) 55);
        byte[] byteArray19 = org.apache.commons.compress.utils.ArchiveUtils.toAsciiBytes("cpio");
        byte[] byteArray20 = org.apache.commons.compress.archivers.zip.ZipUtil.reverse(byteArray19);
        snappyCompressorOutputStream13.write(byteArray20, 345, 0);
        byte[] byteArray25 = snappyCompressorOutputStream13.writeUsAscii("`\n");
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream26 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) snappyCompressorOutputStream13);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(byteArray19);
        org.junit.Assert.assertArrayEquals(byteArray19, new byte[] { (byte) 111, (byte) 105, (byte) 112, (byte) 99 });
        org.junit.Assert.assertNotNull(byteArray20);
        org.junit.Assert.assertArrayEquals(byteArray20, new byte[] { (byte) 111, (byte) 105, (byte) 112, (byte) 99 });
        org.junit.Assert.assertNotNull(byteArray25);
        org.junit.Assert.assertArrayEquals(byteArray25, new byte[] { (byte) 96, (byte) 10 });
    }

    @Test
    public void test1197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1197");
        byte byte0 = org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp.CREATE_TIME_BIT;
        org.junit.Assert.assertTrue("'" + byte0 + "' != '" + (byte) 4 + "'", byte0 == (byte) 4);
    }

    @Test
    public void test1198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1198");
        java.io.File file0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarFile tarFile2 = new org.apache.commons.compress.archivers.tar.TarFile(file0, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1199");
        java.lang.String str1 = org.apache.commons.compress.compressors.gzip.GzipUtils.getUncompressedFileName("pack.deflate.hint.lzma.lzma");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "pack.deflate.hint.lzma.lzma" + "'", str1, "pack.deflate.hint.lzma.lzma");
    }

    @Test
    public void test1200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1200");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        java.lang.String str1 = sevenZArchiveEntry0.getName();
        sevenZArchiveEntry0.setHasCrc(false);
        boolean boolean4 = sevenZArchiveEntry0.getHasWindowsAttributes();
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry7 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        java.lang.String str8 = dumpArchiveEntry7.toString();
        int int9 = dumpArchiveEntry7.getHeaderHoles();
        java.util.Date date10 = dumpArchiveEntry7.getAccessTime();
        sevenZArchiveEntry0.setCreationDate(date10);
        boolean boolean12 = sevenZArchiveEntry0.getHasWindowsAttributes();
        sevenZArchiveEntry0.setSize((long) 1);
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "jar" + "'", str8, "jar");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertNotNull(date10);
        org.junit.Assert.assertEquals(date10.toString(), "Thu Jan 01 10:00:00 AEST 1970");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test1201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1201");
        org.apache.commons.compress.harmony.unpack200.bytecode.ClassFile classFile0 = new org.apache.commons.compress.harmony.unpack200.bytecode.ClassFile();
        org.apache.commons.compress.harmony.unpack200.bytecode.ClassConstantPool classConstantPool1 = classFile0.pool;
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass[] cPClassArray2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPClass[] {};
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionsAttribute exceptionsAttribute3 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionsAttribute(cPClassArray2);
        classFile0.fields = cPClassArray2;
        classFile0.major = (byte) 100;
        org.junit.Assert.assertNotNull(classConstantPool1);
        org.junit.Assert.assertNotNull(cPClassArray2);
        org.junit.Assert.assertArrayEquals(cPClassArray2, new org.apache.commons.compress.harmony.unpack200.bytecode.CPClass[] {});
    }

    @Test
    public void test1202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1202");
        int int0 = org.apache.commons.compress.harmony.unpack200.AttributeLayout.CONTEXT_CLASS;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 0 + "'", int0 == 0);
    }

    @Test
    public void test1203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1203");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry6 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean7 = cpioArchiveOutputStream2.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry6);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream8 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        long long9 = cpioArchiveOutputStream2.getBytesWritten();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.lzma.LZMACompressorOutputStream lZMACompressorOutputStream10 = new org.apache.commons.compress.compressors.lzma.LZMACompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: No current CPIO entry");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + long9 + "' != '" + 0L + "'", long9 == 0L);
    }

    @Test
    public void test1204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1204");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry6 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean7 = cpioArchiveOutputStream2.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry6);
        long long8 = cpioArchiveOutputStream2.getBytesWritten();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + long8 + "' != '" + 0L + "'", long8 == 0L);
    }

    @Test
    public void test1205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1205");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        long long3 = dumpArchiveEntry2.getSize();
        boolean boolean4 = dumpArchiveEntry2.isBlkDev();
        dumpArchiveEntry2.setGeneration((int) (byte) 55);
        dumpArchiveEntry2.setGeneration(55);
        org.apache.commons.compress.archivers.dump.DumpArchiveConstants.SEGMENT_TYPE sEGMENT_TYPE9 = dumpArchiveEntry2.getHeaderType();
        dumpArchiveEntry2.setDeleted(true);
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNull(sEGMENT_TYPE9);
    }

    @Test
    public void test1206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1206");
        org.apache.commons.compress.archivers.sevenz.SevenZMethod sevenZMethod0 = org.apache.commons.compress.archivers.sevenz.SevenZMethod.BCJ_PPC_FILTER;
        org.junit.Assert.assertTrue("'" + sevenZMethod0 + "' != '" + org.apache.commons.compress.archivers.sevenz.SevenZMethod.BCJ_PPC_FILTER + "'", sevenZMethod0.equals(org.apache.commons.compress.archivers.sevenz.SevenZMethod.BCJ_PPC_FILTER));
    }

    @Test
    public void test1207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1207");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime1 = null;
        x5455_ExtendedTimestamp0.setAccessFileTime(fileTime1);
        byte[] byteArray3 = x5455_ExtendedTimestamp0.getLocalFileDataData();
        org.apache.commons.compress.compressors.lz77support.LZ77Compressor.LiteralBlock literalBlock6 = new org.apache.commons.compress.compressors.lz77support.LZ77Compressor.LiteralBlock(byteArray3, 40960, 8);
        byte[] byteArray7 = literalBlock6.getData();
        org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType blockType8 = literalBlock6.getType();
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 0 });
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) 0 });
        org.junit.Assert.assertTrue("'" + blockType8 + "' != '" + org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.LITERAL + "'", blockType8.equals(org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.LITERAL));
    }

    @Test
    public void test1208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1208");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        byte[] byteArray2 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream1);
        long long3 = cpioArchiveInputStream1.getBytesRead();
        int int4 = cpioArchiveInputStream1.getCount();
        boolean boolean5 = cpioArchiveInputStream1.markSupported();
        java.io.OutputStream outputStream6 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream8 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream6, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry9 = null;
        boolean boolean10 = cpioArchiveOutputStream8.canWriteEntryData(archiveEntry9);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream12 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream8, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream14 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream12, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap15 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream16 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream14, strMap15);
        long long17 = org.apache.commons.compress.utils.IOUtils.copy((java.io.InputStream) cpioArchiveInputStream1, (java.io.OutputStream) pack200CompressorOutputStream16);
        org.apache.commons.compress.compressors.xz.XZCompressorOutputStream xZCompressorOutputStream18 = new org.apache.commons.compress.compressors.xz.XZCompressorOutputStream((java.io.OutputStream) pack200CompressorOutputStream16);
        byte[] byteArray20 = xZCompressorOutputStream18.writeUsAscii("xz");
        org.apache.commons.compress.compressors.lz77support.Parameters parameters21 = null;
        org.apache.commons.compress.compressors.snappy.FramedSnappyCompressorOutputStream framedSnappyCompressorOutputStream22 = new org.apache.commons.compress.compressors.snappy.FramedSnappyCompressorOutputStream((java.io.OutputStream) xZCompressorOutputStream18, parameters21);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarArchiveOutputStream tarArchiveOutputStream24 = new org.apache.commons.compress.archivers.tar.TarArchiveOutputStream((java.io.OutputStream) xZCompressorOutputStream18, (int) (short) 12);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Block size must be a multiple of 512 bytes. Attempt to use set size of 12");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + long17 + "' != '" + 0L + "'", long17 == 0L);
        org.junit.Assert.assertNotNull(byteArray20);
        org.junit.Assert.assertArrayEquals(byteArray20, new byte[] { (byte) 120, (byte) 122 });
    }

    @Test
    public void test1209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1209");
        org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData unparseableExtraFieldData0 = new org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort1 = unparseableExtraFieldData0.getLocalFileDataLength();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort2 = unparseableExtraFieldData0.getHeaderId();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = unparseableExtraFieldData0.getLocalFileDataLength();
        byte[] byteArray4 = unparseableExtraFieldData0.getLocalFileDataData();
        org.junit.Assert.assertNotNull(zipShort1);
        org.junit.Assert.assertNotNull(zipShort2);
        org.junit.Assert.assertNotNull(zipShort3);
        org.junit.Assert.assertNull(byteArray4);
    }

    @Test
    public void test1210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1210");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec0 = org.apache.commons.compress.harmony.pack200.Codec.MDELTA5;
        java.io.InputStream inputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream1);
        int int3 = cpioArchiveInputStream2.read();
        // The following exception was thrown during execution in test generation
        try {
            int int4 = bHSDCodec0.decode((java.io.InputStream) cpioArchiveInputStream2);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.compress.harmony.pack200.Pack200Exception; message: Delta encoding used without passing in last value; this is a coding error");
        } catch (org.apache.commons.compress.harmony.pack200.Pack200Exception e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(bHSDCodec0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + (-1) + "'", int3 == (-1));
    }

    @Test
    public void test1211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1211");
        java.lang.String str1 = org.apache.commons.compress.compressors.lzma.LZMAUtils.getUncompressedFileName("\002?\002\n\001");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "\002?\002\n\001" + "'", str1, "\002?\002\n\001");
    }

    @Test
    public void test1212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1212");
        java.lang.String str0 = org.apache.commons.compress.archivers.tar.TarConstants.VERSION_POSIX;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "00" + "'", str0, "00");
    }

    @Test
    public void test1213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1213");
        byte[] byteArray1 = org.apache.commons.compress.utils.ArchiveUtils.toAsciiBytes("apk");
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 97, (byte) 112, (byte) 107 });
    }

    @Test
    public void test1214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1214");
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder0 = new org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder();
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder2 = builder0.setCharSequence((java.lang.CharSequence) "arj");
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder4 = builder0.setPassword("UTF-8:splitting");
        byte[] byteArray5 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder6 = builder0.setByteArray(byteArray5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder2);
        org.junit.Assert.assertNotNull(builder4);
    }

    @Test
    public void test1215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1215");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream8 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream6, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap9 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream10 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream8, strMap9);
        boolean boolean11 = pack200CompressorOutputStream10.isClosed();
        org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream snappyCompressorOutputStream13 = new org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream((java.io.OutputStream) pack200CompressorOutputStream10, (long) 10240);
        snappyCompressorOutputStream13.write(28771);
        byte[] byteArray17 = snappyCompressorOutputStream13.writeUsAsciiRaw("pack.progress");
        // The following exception was thrown during execution in test generation
        try {
            snappyCompressorOutputStream13.close();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(byteArray17);
        org.junit.Assert.assertArrayEquals(byteArray17, new byte[] { (byte) 112, (byte) 97, (byte) 99, (byte) 107, (byte) 46, (byte) 112, (byte) 114, (byte) 111, (byte) 103, (byte) 114, (byte) 101, (byte) 115, (byte) 115 });
    }

    @Test
    public void test1216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1216");
        org.apache.commons.compress.harmony.unpack200.IcTuple icTuple8 = new org.apache.commons.compress.harmony.unpack200.IcTuple("ACC_SYNTHETIC", 32771, "ACC_TRANSIENT", "ACC_PROTECTED", (int) '4', 8192, 17, 4);
        java.lang.String str9 = icTuple8.outerClassString();
        boolean boolean10 = icTuple8.isMember();
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ACC_TRANSIENT" + "'", str9, "ACC_TRANSIENT");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
    }

    @Test
    public void test1217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1217");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry5 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file6 = tarArchiveEntry5.getFile();
        boolean boolean7 = tarArchiveEntry5.isGNUSparse();
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry8 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date9 = arjArchiveEntry8.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong10 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date9);
        tarArchiveEntry5.setModTime(date9);
        java.nio.file.attribute.FileTime fileTime12 = tarArchiveEntry5.getLastModifiedTime();
        tarArchiveEntry2.setLastModifiedTime(fileTime12);
        tarArchiveEntry2.setLinkName("ustar\000");
        org.junit.Assert.assertNull(file6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(date9);
        org.junit.Assert.assertEquals(date9.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong10);
        org.junit.Assert.assertNotNull(fileTime12);
    }

    @Test
    public void test1218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1218");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file3 = tarArchiveEntry2.getFile();
        boolean boolean4 = tarArchiveEntry2.isGNUSparse();
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry5 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date6 = arjArchiveEntry5.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong7 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date6);
        tarArchiveEntry2.setModTime(date6);
        java.nio.file.attribute.FileTime fileTime9 = tarArchiveEntry2.getLastModifiedTime();
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry12 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("", true);
        tarArchiveEntry12.setMode(16877);
        java.io.File file15 = tarArchiveEntry12.getFile();
        boolean boolean16 = tarArchiveEntry12.isPaxHeader();
        boolean boolean17 = tarArchiveEntry2.isDescendent(tarArchiveEntry12);
        org.junit.Assert.assertNull(file3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(date6);
        org.junit.Assert.assertEquals(date6.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong7);
        org.junit.Assert.assertNotNull(fileTime9);
        org.junit.Assert.assertNull(file15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test1219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1219");
        org.apache.commons.compress.archivers.zip.AsiExtraField asiExtraField0 = new org.apache.commons.compress.archivers.zip.AsiExtraField();
        byte[] byteArray1 = asiExtraField0.getCentralDirectoryData();
        java.lang.Object obj2 = asiExtraField0.clone();
        asiExtraField0.setUserId(16877);
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 118, (byte) 104, (byte) -118, (byte) -29, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertNotNull(obj2);
    }

    @Test
    public void test1220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1220");
        java.lang.String str0 = org.apache.commons.compress.archivers.tar.TarConstants.VERSION_ANT;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "\000\000" + "'", str0, "\000\000");
    }

    @Test
    public void test1221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1221");
        java.io.File file0 = null;
        org.apache.commons.compress.java.util.jar.Pack200.Unpacker unpacker1 = org.apache.commons.compress.java.util.jar.Pack200.newUnpacker();
        java.beans.PropertyChangeListener propertyChangeListener2 = null;
        unpacker1.removePropertyChangeListener(propertyChangeListener2);
        java.util.SortedMap<java.lang.String, java.lang.String> strMap4 = unpacker1.properties();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.pack200.Pack200Utils.normalize(file0, (java.util.Map<java.lang.String, java.lang.String>) strMap4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(unpacker1);
        org.junit.Assert.assertNotNull(strMap4);
    }

    @Test
    public void test1222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1222");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry6 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean7 = cpioArchiveOutputStream2.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry6);
        java.nio.file.attribute.FileTime fileTime8 = jarArchiveEntry6.getLastAccessTime();
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource commentSource9 = jarArchiveEntry6.getCommentSource();
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource commentSource10 = jarArchiveEntry6.getCommentSource();
        jarArchiveEntry6.setUnixMode(345);
        long long13 = jarArchiveEntry6.getDataOffset();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNull(fileTime8);
        org.junit.Assert.assertTrue("'" + commentSource9 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.COMMENT + "'", commentSource9.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.COMMENT));
        org.junit.Assert.assertTrue("'" + commentSource10 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.COMMENT + "'", commentSource10.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.COMMENT));
        org.junit.Assert.assertTrue("'" + long13 + "' != '" + (-1L) + "'", long13 == (-1L));
    }

    @Test
    public void test1223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1223");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream3 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream4 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        long long5 = zipArchiveOutputStream4.getBytesWritten();
        java.nio.file.Path path6 = null;
        java.nio.file.LinkOption[] linkOptionArray8 = new java.nio.file.LinkOption[] {};
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipArchiveEntry zipArchiveEntry9 = zipArchiveOutputStream4.createArchiveEntry(path6, "", linkOptionArray8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + long5 + "' != '" + 0L + "'", long5 == 0L);
        org.junit.Assert.assertNotNull(linkOptionArray8);
        org.junit.Assert.assertArrayEquals(linkOptionArray8, new java.nio.file.LinkOption[] {});
    }

    @Test
    public void test1224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1224");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream5 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream1, (long) 1, (long) 148);
        java.io.OutputStream outputStream6 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream8 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream6, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry9 = null;
        boolean boolean10 = cpioArchiveOutputStream8.canWriteEntryData(archiveEntry9);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream12 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream8, 135);
        org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream framedLZ4CompressorOutputStream13 = new org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream12);
        framedLZ4CompressorOutputStream13.write(0);
        long long16 = org.apache.commons.compress.utils.IOUtils.copy((java.io.InputStream) cRC32VerifyingInputStream5, (java.io.OutputStream) framedLZ4CompressorOutputStream13);
        int int17 = cRC32VerifyingInputStream5.available();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + long16 + "' != '" + 0L + "'", long16 == 0L);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 1 + "'", int17 == 1);
    }

    @Test
    public void test1225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1225");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream3 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream4 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        zipArchiveOutputStream4.setUseLanguageEncodingFlag(false);
        zipArchiveOutputStream4.setUseLanguageEncodingFlag(false);
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream9 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) zipArchiveOutputStream4);
        byte[] byteArray11 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(0L);
        boolean boolean13 = org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.matches(byteArray11, 52);
        // The following exception was thrown during execution in test generation
        try {
            zipArchiveOutputStream4.write(byteArray11, (int) (short) 10, 55);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: No current entry");
        } catch (java.lang.IllegalStateException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray11);
        org.junit.Assert.assertArrayEquals(byteArray11, new byte[] { (byte) 0, (byte) 0, (byte) 33, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test1226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1226");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        int int3 = cpioArchiveInputStream1.available();
        int int4 = cpioArchiveInputStream1.available();
        org.apache.commons.compress.archivers.jar.JarArchiveInputStream jarArchiveInputStream5 = new org.apache.commons.compress.archivers.jar.JarArchiveInputStream((java.io.InputStream) cpioArchiveInputStream1);
        java.nio.charset.Charset charset6 = jarArchiveInputStream5.getCharset();
        long long7 = jarArchiveInputStream5.getBytesRead();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNotNull(charset6);
        org.junit.Assert.assertTrue("'" + long7 + "' != '" + 0L + "'", long7 == 0L);
    }

    @Test
    public void test1227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1227");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream8 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 4);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream10 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 32);
        byte[] byteArray12 = zstdCompressorOutputStream10.writeUsAscii("Exceptions");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarArchiveStructSparse tarArchiveStructSparse14 = org.apache.commons.compress.archivers.tar.TarUtils.parseSparse(byteArray12, (int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: -1");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(byteArray12);
        org.junit.Assert.assertArrayEquals(byteArray12, new byte[] { (byte) 69, (byte) 120, (byte) 99, (byte) 101, (byte) 112, (byte) 116, (byte) 105, (byte) 111, (byte) 110, (byte) 115 });
    }

    @Test
    public void test1228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1228");
        org.apache.commons.compress.harmony.unpack200.IcTuple icTuple8 = new org.apache.commons.compress.harmony.unpack200.IcTuple("ACC_SYNTHETIC", 32771, "ACC_TRANSIENT", "ACC_PROTECTED", (int) '4', 8192, 17, 4);
        boolean boolean11 = icTuple8.nullSafeEquals("dump.bz2.gz", "");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test1229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1229");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file3 = tarArchiveEntry2.getFile();
        boolean boolean4 = tarArchiveEntry2.isGNUSparse();
        tarArchiveEntry2.setLinkName("070702");
        org.junit.Assert.assertNull(file3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test1230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1230");
        org.apache.commons.compress.compressors.CompressorStreamFactory compressorStreamFactory2 = new org.apache.commons.compress.compressors.CompressorStreamFactory(true, 8192);
    }

    @Test
    public void test1231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1231");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream5 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream1, (long) 1, (long) 148);
        org.apache.commons.compress.utils.CloseShieldFilterInputStream closeShieldFilterInputStream6 = new org.apache.commons.compress.utils.CloseShieldFilterInputStream((java.io.InputStream) cpioArchiveInputStream1);
        org.apache.commons.compress.utils.CountingInputStream countingInputStream7 = new org.apache.commons.compress.utils.CountingInputStream((java.io.InputStream) closeShieldFilterInputStream6);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test1232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1232");
        org.apache.commons.compress.archivers.zip.X7875_NewUnix x7875_NewUnix0 = new org.apache.commons.compress.archivers.zip.X7875_NewUnix();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort1 = x7875_NewUnix0.getLocalFileDataLength();
        org.junit.Assert.assertNotNull(zipShort1);
    }

    @Test
    public void test1233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1233");
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        java.nio.file.attribute.FileTime fileTime2 = jarArchiveEntry1.getCreationTime();
        jarArchiveEntry1.setCrc((long) (byte) 51);
        boolean boolean5 = jarArchiveEntry1.isStreamContiguous();
        org.junit.Assert.assertNull(fileTime2);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test1234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1234");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_2);
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS5 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue elementValue6 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue((int) (byte) 7, (java.lang.Object) oS5);
        java.util.List<java.lang.Object> objList7 = elementValue6.getClassFileEntries();
        boolean boolean8 = cPUTF8_2.equals((java.lang.Object) elementValue6);
        org.apache.commons.compress.harmony.unpack200.bytecode.ConstantValueAttribute constantValueAttribute9 = new org.apache.commons.compress.harmony.unpack200.bytecode.ConstantValueAttribute((org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry) cPUTF8_2);
        org.junit.Assert.assertTrue("'" + oS5 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS5.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertNotNull(objList7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test1235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1235");
        java.nio.file.Path path1 = null;
        org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier defaultBackingStoreSupplier2 = new org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier(path1);
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore3 = defaultBackingStoreSupplier2.get();
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore4 = defaultBackingStoreSupplier2.get();
        org.apache.commons.compress.archivers.zip.StreamCompressor streamCompressor5 = org.apache.commons.compress.archivers.zip.StreamCompressor.create(0, scatterGatherBackingStore4);
        java.io.InputStream inputStream6 = scatterGatherBackingStore4.getInputStream();
        org.junit.Assert.assertNotNull(scatterGatherBackingStore3);
        org.junit.Assert.assertNotNull(scatterGatherBackingStore4);
        org.junit.Assert.assertNotNull(streamCompressor5);
        org.junit.Assert.assertNotNull(inputStream6);
    }

    @Test
    public void test1236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1236");
        java.lang.String str1 = org.apache.commons.compress.compressors.gzip.GzipUtils.getUncompressedFileName("not encodeable");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "not encodeable" + "'", str1, "not encodeable");
    }

    @Test
    public void test1237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1237");
        org.apache.commons.compress.archivers.zip.AsiExtraField asiExtraField0 = new org.apache.commons.compress.archivers.zip.AsiExtraField();
        asiExtraField0.setMode((int) (byte) 100);
        asiExtraField0.setDirectory(true);
        asiExtraField0.setDirectory(false);
    }

    @Test
    public void test1238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1238");
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.Annotation[] annotationArray0 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.Annotation[] {};
        org.apache.commons.compress.harmony.unpack200.bytecode.RuntimeVisibleorInvisibleParameterAnnotationsAttribute.ParameterAnnotation parameterAnnotation1 = new org.apache.commons.compress.harmony.unpack200.bytecode.RuntimeVisibleorInvisibleParameterAnnotationsAttribute.ParameterAnnotation(annotationArray0);
        java.util.List<java.lang.Object> objList2 = parameterAnnotation1.getClassFileEntries();
        org.junit.Assert.assertNotNull(annotationArray0);
        org.junit.Assert.assertArrayEquals(annotationArray0, new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.Annotation[] {});
        org.junit.Assert.assertNotNull(objList2);
    }

    @Test
    public void test1239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1239");
        org.apache.commons.compress.harmony.unpack200.AttributeLayoutMap attributeLayoutMap0 = new org.apache.commons.compress.harmony.unpack200.AttributeLayoutMap();
        org.apache.commons.compress.harmony.unpack200.AttributeLayout attributeLayout1 = null;
        org.apache.commons.compress.harmony.unpack200.NewAttributeBands newAttributeBands2 = attributeLayoutMap0.getAttributeBands(attributeLayout1);
        org.apache.commons.compress.harmony.unpack200.AttributeLayout attributeLayout3 = null;
        org.apache.commons.compress.harmony.unpack200.NewAttributeBands newAttributeBands4 = attributeLayoutMap0.getAttributeBands(attributeLayout3);
        org.apache.commons.compress.harmony.unpack200.AttributeLayout attributeLayout5 = null;
        // The following exception was thrown during execution in test generation
        try {
            attributeLayoutMap0.add(attributeLayout5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(newAttributeBands2);
        org.junit.Assert.assertNull(newAttributeBands4);
    }

    @Test
    public void test1240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1240");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream5 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream1, (long) 1, (long) 148);
        java.util.zip.Checksum checksum6 = cRC32VerifyingInputStream5.getChecksum();
        long long8 = cRC32VerifyingInputStream5.skip((long) 345);
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream11 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cRC32VerifyingInputStream5, 8589934591L, (long) '4');
        // The following exception was thrown during execution in test generation
        try {
            long long13 = org.apache.commons.compress.utils.IOUtils.skip((java.io.InputStream) cRC32VerifyingInputStream5, (long) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.BootstrapMethodError; message: java.lang.NoSuchMethodError: org.apache.commons.io.IOUtils.byteArray()[B");
        } catch (java.lang.BootstrapMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(checksum6);
        org.junit.Assert.assertTrue("'" + long8 + "' != '" + 0L + "'", long8 == 0L);
    }

    @Test
    public void test1241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1241");
        org.apache.commons.compress.compressors.lz77support.Parameters.Builder builder0 = org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream.createParameterBuilder();
        org.apache.commons.compress.compressors.lz77support.Parameters parameters1 = builder0.build();
        org.apache.commons.compress.compressors.lz77support.Parameters.Builder builder3 = builder0.withLazyMatching(false);
        org.apache.commons.compress.compressors.lz77support.Parameters.Builder builder5 = builder0.withNiceBackReferenceLength(52);
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(parameters1);
        org.junit.Assert.assertNotNull(builder3);
        org.junit.Assert.assertNotNull(builder5);
    }

    @Test
    public void test1242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1242");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        byte[] byteArray2 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream1);
        long long3 = cpioArchiveInputStream1.getBytesRead();
        int int4 = cpioArchiveInputStream1.getCount();
        org.apache.commons.compress.utils.CountingInputStream countingInputStream5 = new org.apache.commons.compress.utils.CountingInputStream((java.io.InputStream) cpioArchiveInputStream1);
        java.nio.charset.Charset charset8 = null;
        org.apache.commons.compress.archivers.zip.ZipEncoding zipEncoding9 = org.apache.commons.compress.archivers.zip.ZipEncodingHelper.getZipEncoding(charset8);
        byte[] byteArray15 = new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 };
        byte[] byteArray22 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean24 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray22, 0);
        boolean boolean25 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray15, byteArray22);
        java.lang.String str26 = zipEncoding9.decode(byteArray15);
        org.apache.commons.compress.harmony.unpack200.Segment segment27 = new org.apache.commons.compress.harmony.unpack200.Segment();
        org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager operandManager28 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass32 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry33 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass32);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass37 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry38 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass37);
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry[] exceptionTableEntryArray39 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry[] { exceptionTableEntry33, exceptionTableEntry38 };
        java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry> exceptionTableEntryList40 = new java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>();
        boolean boolean41 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>) exceptionTableEntryList40, exceptionTableEntryArray39);
        org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute codeAttribute42 = new org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute(476, (int) (byte) 51, byteArray15, segment27, operandManager28, (java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>) exceptionTableEntryList40);
        int int43 = countingInputStream5.read(byteArray15);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(zipEncoding9);
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 });
        org.junit.Assert.assertNotNull(byteArray22);
        org.junit.Assert.assertArrayEquals(byteArray22, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertEquals("'" + str26 + "' != '" + "\002?\002\n\001" + "'", str26, "\002?\002\n\001");
        org.junit.Assert.assertNotNull(exceptionTableEntryArray39);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + true + "'", boolean41 == true);
        org.junit.Assert.assertTrue("'" + int43 + "' != '" + (-1) + "'", int43 == (-1));
    }

    @Test
    public void test1243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1243");
        byte[] byteArray1 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(0L);
        boolean boolean3 = org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.matches(byteArray1, 52);
        org.apache.commons.compress.archivers.tar.TarFile tarFile4 = new org.apache.commons.compress.archivers.tar.TarFile(byteArray1);
        tarFile4.close();
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 0, (byte) 0, (byte) 33, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test1244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1244");
        int int0 = org.apache.commons.compress.archivers.cpio.CpioConstants.C_ISDIR;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 16384 + "'", int0 == 16384);
    }

    @Test
    public void test1245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1245");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.LF_OFFSET;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 156 + "'", int0 == 156);
    }

    @Test
    public void test1246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1246");
        byte byte0 = org.apache.commons.compress.harmony.unpack200.bytecode.ConstantPoolEntry.CP_Float;
        org.junit.Assert.assertTrue("'" + byte0 + "' != '" + (byte) 4 + "'", byte0 == (byte) 4);
    }

    @Test
    public void test1247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1247");
        java.util.jar.JarFile jarFile0 = null;
        java.io.OutputStream outputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream3 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream1, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry4 = null;
        boolean boolean5 = cpioArchiveOutputStream3.canWriteEntryData(archiveEntry4);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream7 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream3, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream9 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream3, 4);
        byte[] byteArray11 = zstdCompressorOutputStream9.writeUsAsciiRaw("org.apache.commons.compress.harmony.pack200.Segment$PassException");
        org.apache.commons.compress.utils.ByteUtils.OutputStreamByteConsumer outputStreamByteConsumer12 = new org.apache.commons.compress.utils.ByteUtils.OutputStreamByteConsumer((java.io.OutputStream) zstdCompressorOutputStream9);
        java.util.jar.JarFile jarFile13 = null;
        java.io.OutputStream outputStream14 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream16 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream14, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry17 = null;
        boolean boolean18 = cpioArchiveOutputStream16.canWriteEntryData(archiveEntry17);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream20 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream16, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream22 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream20, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap23 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream24 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream22, strMap23);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec25 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean26 = bHSDCodec25.isDelta();
        byte[] byteArray28 = bHSDCodec25.encode((int) '#');
        pack200CompressorOutputStream24.write(byteArray28);
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions30 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        org.apache.commons.compress.harmony.pack200.Archive archive31 = new org.apache.commons.compress.harmony.pack200.Archive(jarFile13, (java.io.OutputStream) pack200CompressorOutputStream24, packingOptions30);
        org.apache.commons.compress.harmony.pack200.Archive archive32 = new org.apache.commons.compress.harmony.pack200.Archive(jarFile0, (java.io.OutputStream) zstdCompressorOutputStream9, packingOptions30);
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker33 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray34 = jarMarker33.getCentralDirectoryData();
        byte[] byteArray35 = jarMarker33.getLocalFileDataData();
        boolean boolean37 = org.apache.commons.compress.compressors.xz.XZCompressorInputStream.matches(byteArray35, 0);
        boolean boolean39 = org.apache.commons.compress.archivers.dump.DumpArchiveInputStream.matches(byteArray35, 17);
        zstdCompressorOutputStream9.write(byteArray35);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(byteArray11);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertNotNull(bHSDCodec25);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertNotNull(byteArray28);
        org.junit.Assert.assertArrayEquals(byteArray28, new byte[] { (byte) 35 });
        org.junit.Assert.assertNotNull(byteArray34);
        org.junit.Assert.assertArrayEquals(byteArray34, new byte[] {});
        org.junit.Assert.assertNotNull(byteArray35);
        org.junit.Assert.assertArrayEquals(byteArray35, new byte[] {});
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
    }

    @Test
    public void test1248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1248");
        org.apache.commons.compress.archivers.zip.ResourceAlignmentExtraField resourceAlignmentExtraField0 = new org.apache.commons.compress.archivers.zip.ResourceAlignmentExtraField();
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec1 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean2 = bHSDCodec1.isDelta();
        byte[] byteArray4 = bHSDCodec1.encode((int) '#');
        // The following exception was thrown during execution in test generation
        try {
            resourceAlignmentExtraField0.parseFromCentralDirectoryData(byteArray4, (int) (short) -1, 0);
            org.junit.Assert.fail("Expected exception of type java.util.zip.ZipException; message: Too short content for ResourceAlignmentExtraField (0xa11e): 0");
        } catch (java.util.zip.ZipException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(bHSDCodec1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 35 });
    }

    @Test
    public void test1249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1249");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry5 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file6 = tarArchiveEntry5.getFile();
        boolean boolean7 = tarArchiveEntry5.isGNUSparse();
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry8 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date9 = arjArchiveEntry8.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong10 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date9);
        tarArchiveEntry5.setModTime(date9);
        java.nio.file.attribute.FileTime fileTime12 = tarArchiveEntry5.getLastModifiedTime();
        tarArchiveEntry2.setLastModifiedTime(fileTime12);
        java.util.List<org.apache.commons.compress.archivers.tar.TarArchiveStructSparse> tarArchiveStructSparseList14 = tarArchiveEntry2.getSparseHeaders();
        org.junit.Assert.assertNull(file6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(date9);
        org.junit.Assert.assertEquals(date9.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong10);
        org.junit.Assert.assertNotNull(fileTime12);
        org.junit.Assert.assertNull(tarArchiveStructSparseList14);
    }

    @Test
    public void test1250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1250");
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData unparseableExtraFieldData2 = jarArchiveEntry1.getUnparseableExtraFieldData();
        long long3 = jarArchiveEntry1.getLocalHeaderOffset();
        org.junit.Assert.assertNull(unparseableExtraFieldData2);
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + (-1L) + "'", long3 == (-1L));
    }

    @Test
    public void test1251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1251");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        java.util.Date date3 = dumpArchiveEntry2.getLastModifiedDate();
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE tYPE4 = dumpArchiveEntry2.getType();
        int int5 = dumpArchiveEntry2.getUserId();
        java.util.Date date6 = dumpArchiveEntry2.getCreationTime();
        org.junit.Assert.assertNotNull(date3);
        org.junit.Assert.assertEquals(date3.toString(), "Thu Jan 01 10:00:00 AEST 1970");
        org.junit.Assert.assertTrue("'" + tYPE4 + "' != '" + org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.UNKNOWN + "'", tYPE4.equals(org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.UNKNOWN));
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertNotNull(date6);
        org.junit.Assert.assertEquals(date6.toString(), "Thu Jan 01 10:00:00 AEST 1970");
    }

    @Test
    public void test1252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1252");
        org.apache.commons.compress.harmony.pack200.Segment segment0 = new org.apache.commons.compress.harmony.pack200.Segment();
        // The following exception was thrown during execution in test generation
        try {
            segment0.visitNestHost("apk");
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: NestHost requires ASM7");
        } catch (java.lang.UnsupportedOperationException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1253");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream3 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream4 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        zipArchiveOutputStream4.setLevel((int) (byte) 4);
    }

    @Test
    public void test1254() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1254");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass0 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.CPNameAndType cPNameAndType1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.unpack200.bytecode.CPMethodRef cPMethodRef3 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPMethodRef(cPClass0, cPNameAndType1, 16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: className");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1255() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1255");
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel1 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(131);
    }

    @Test
    public void test1256() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1256");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream3 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream4 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        zipArchiveOutputStream4.setUseLanguageEncodingFlag(false);
        zipArchiveOutputStream4.setUseLanguageEncodingFlag(false);
        // The following exception was thrown during execution in test generation
        try {
            zipArchiveOutputStream4.finish();
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: No current CPIO entry");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1257() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1257");
        org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE cOMPRESSION_TYPE0 = org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE.LZO;
        org.junit.Assert.assertTrue("'" + cOMPRESSION_TYPE0 + "' != '" + org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE.LZO + "'", cOMPRESSION_TYPE0.equals(org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE.LZO));
    }

    @Test
    public void test1258() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1258");
        boolean boolean1 = org.apache.commons.compress.compressors.bzip2.BZip2Utils.isCompressedFileName(" \000");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test1259() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1259");
        org.apache.commons.compress.archivers.sevenz.SevenZMethod sevenZMethod0 = org.apache.commons.compress.archivers.sevenz.SevenZMethod.BZIP2;
        org.junit.Assert.assertTrue("'" + sevenZMethod0 + "' != '" + org.apache.commons.compress.archivers.sevenz.SevenZMethod.BZIP2 + "'", sevenZMethod0.equals(org.apache.commons.compress.archivers.sevenz.SevenZMethod.BZIP2));
    }

    @Test
    public void test1260() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1260");
        org.apache.commons.compress.harmony.pack200.Segment segment2 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands4 = new org.apache.commons.compress.harmony.pack200.CpBands(segment2, (int) (byte) 2);
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS5 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.pack200.CPConstant<?> wildcardCPConstant6 = cpBands4.getConstant((java.lang.Object) oS5);
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader7 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        org.apache.commons.compress.harmony.pack200.MetadataBandGroup metadataBandGroup9 = new org.apache.commons.compress.harmony.pack200.MetadataBandGroup("LocalVariableTypeTable", 16, cpBands4, segmentHeader7, 263);
        org.apache.commons.compress.harmony.pack200.Segment segment10 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands12 = new org.apache.commons.compress.harmony.pack200.CpBands(segment10, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature14 = cpBands12.getCPSignature("ustar\000");
        int int15 = cPSignature14.getIndexInCpUtf8();
        org.apache.commons.compress.harmony.pack200.Segment segment16 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands18 = new org.apache.commons.compress.harmony.pack200.CpBands(segment16, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature20 = cpBands18.getCPSignature("ustar\000");
        int int21 = cPSignature20.getIndexInCpUtf8();
        org.apache.commons.compress.harmony.pack200.Segment segment22 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands24 = new org.apache.commons.compress.harmony.pack200.CpBands(segment22, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature26 = cpBands24.getCPSignature("ustar\000");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_31 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_33 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition attributeDefinition34 = new org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition(4096, 493, cPUTF8_31, cPUTF8_33);
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_35 = attributeDefinition34.name;
        org.apache.commons.compress.harmony.pack200.Segment segment36 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands38 = new org.apache.commons.compress.harmony.pack200.CpBands(segment36, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPMethodOrField cPMethodOrField42 = cpBands38.getCPMethod("", "zstd", "ACC_STRICT");
        org.apache.commons.compress.harmony.pack200.CPClass cPClass44 = cpBands38.getCPClass("true");
        boolean boolean45 = cPClass44.isInnerClass();
        org.apache.commons.compress.harmony.pack200.CPClass[] cPClassArray46 = new org.apache.commons.compress.harmony.pack200.CPClass[] { cPClass44 };
        java.util.ArrayList<org.apache.commons.compress.harmony.pack200.CPClass> cPClassList47 = new java.util.ArrayList<org.apache.commons.compress.harmony.pack200.CPClass>();
        boolean boolean48 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.pack200.CPClass>) cPClassList47, cPClassArray46);
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature49 = new org.apache.commons.compress.harmony.pack200.CPSignature("splitting", cPUTF8_35, (java.util.List<org.apache.commons.compress.harmony.pack200.CPClass>) cPClassList47);
        org.apache.commons.compress.harmony.pack200.Segment segment50 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands52 = new org.apache.commons.compress.harmony.pack200.CpBands(segment50, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature54 = cpBands52.getCPSignature("ustar\000");
        org.apache.commons.compress.harmony.pack200.CPSignature[] cPSignatureArray55 = new org.apache.commons.compress.harmony.pack200.CPSignature[] { cPSignature14, cPSignature20, cPSignature26, cPSignature49, cPSignature54 };
        java.util.ArrayList<org.apache.commons.compress.harmony.pack200.CPSignature> cPSignatureList56 = new java.util.ArrayList<org.apache.commons.compress.harmony.pack200.CPSignature>();
        boolean boolean57 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.pack200.CPSignature>) cPSignatureList56, cPSignatureArray55);
        metadataBandGroup9.caseet_RS = cPSignatureList56;
        org.apache.commons.compress.harmony.pack200.IntList intList59 = null;
        metadataBandGroup9.nestpair_N = intList59;
        java.io.OutputStream outputStream61 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream63 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream61, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream64 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream63);
        metadataBandGroup9.pack((java.io.OutputStream) blockLZ4CompressorOutputStream64);
        org.junit.Assert.assertTrue("'" + oS5 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS5.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertNull(wildcardCPConstant6);
        org.junit.Assert.assertNotNull(cPSignature14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + (-1) + "'", int15 == (-1));
        org.junit.Assert.assertNotNull(cPSignature20);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + (-1) + "'", int21 == (-1));
        org.junit.Assert.assertNotNull(cPSignature26);
        org.junit.Assert.assertNotNull(cPUTF8_35);
        org.junit.Assert.assertNotNull(cPMethodOrField42);
        org.junit.Assert.assertNotNull(cPClass44);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
        org.junit.Assert.assertNotNull(cPClassArray46);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + true + "'", boolean48 == true);
        org.junit.Assert.assertNotNull(cPSignature54);
        org.junit.Assert.assertNotNull(cPSignatureArray55);
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + true + "'", boolean57 == true);
    }

    @Test
    public void test1261() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1261");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream8 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream6, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap9 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream10 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream8, strMap9);
        boolean boolean11 = pack200CompressorOutputStream10.isClosed();
        org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream snappyCompressorOutputStream13 = new org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream((java.io.OutputStream) pack200CompressorOutputStream10, (long) 10240);
        snappyCompressorOutputStream13.write(1024);
        snappyCompressorOutputStream13.write(55);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test1262() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1262");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        cpioArchiveInputStream1.reset();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream6 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream1, (long) 'a', 0);
        long long8 = cRC32VerifyingInputStream6.skip((long) 17);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + long8 + "' != '" + 0L + "'", long8 == 0L);
    }

    @Test
    public void test1263() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1263");
        byte[] byteArray1 = org.apache.commons.compress.archivers.zip.ZipShort.getBytes(33188);
        // The following exception was thrown during execution in test generation
        try {
            long long4 = org.apache.commons.compress.utils.ByteUtils.fromLittleEndian(byteArray1, 2048, (int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Can't read more than eight bytes into a long value");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) -92, (byte) -127 });
    }

    @Test
    public void test1264() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1264");
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData unparseableExtraFieldData2 = jarArchiveEntry1.getUnparseableExtraFieldData();
        org.apache.commons.compress.archivers.zip.GeneralPurposeBit generalPurposeBit3 = jarArchiveEntry1.getGeneralPurposeBit();
        boolean boolean4 = generalPurposeBit3.usesStrongEncryption();
        generalPurposeBit3.useStrongEncryption(false);
        generalPurposeBit3.useEncryption(true);
        org.junit.Assert.assertNull(unparseableExtraFieldData2);
        org.junit.Assert.assertNotNull(generalPurposeBit3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test1265() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1265");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file3 = tarArchiveEntry2.getFile();
        boolean boolean4 = tarArchiveEntry2.isGNUSparse();
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry5 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date6 = arjArchiveEntry5.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong7 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date6);
        tarArchiveEntry2.setModTime(date6);
        java.nio.file.attribute.FileTime fileTime9 = tarArchiveEntry2.getLastModifiedTime();
        boolean boolean10 = tarArchiveEntry2.isStarSparse();
        java.util.Date date11 = null;
        // The following exception was thrown during execution in test generation
        try {
            tarArchiveEntry2.setModTime(date11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: time");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(file3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(date6);
        org.junit.Assert.assertEquals(date6.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong7);
        org.junit.Assert.assertNotNull(fileTime9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test1266() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1266");
        java.lang.String str0 = org.apache.commons.compress.harmony.unpack200.AttributeLayout.ACC_PUBLIC;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "ACC_PUBLIC" + "'", str0, "ACC_PUBLIC");
    }

    @Test
    public void test1267() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1267");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry6 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean7 = cpioArchiveOutputStream2.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry6);
        int int8 = cpioArchiveOutputStream2.getCount();
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray10 = cpioArchiveOutputStream2.writeUsAsciiRaw("`\n");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
    }

    @Test
    public void test1268() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1268");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream5 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream1, (long) 1, (long) 148);
        java.util.zip.Checksum checksum6 = cRC32VerifyingInputStream5.getChecksum();
        long long8 = cRC32VerifyingInputStream5.skip((long) 10240);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(checksum6);
        org.junit.Assert.assertTrue("'" + long8 + "' != '" + 0L + "'", long8 == 0L);
    }

    @Test
    public void test1269() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1269");
        org.apache.commons.compress.harmony.pack200.Segment segment0 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands2 = new org.apache.commons.compress.harmony.pack200.CpBands(segment0, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature4 = cpBands2.getCPSignature("pack.keep.file.order");
        org.junit.Assert.assertNotNull(cPSignature4);
    }

    @Test
    public void test1270() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1270");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPFloat cPFloat2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPFloat((java.lang.Float) 100.0f, 10240);
    }

    @Test
    public void test1271() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1271");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        byte[] byteArray2 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream1);
        long long3 = cpioArchiveInputStream1.getBytesRead();
        int int4 = cpioArchiveInputStream1.getCount();
        boolean boolean5 = cpioArchiveInputStream1.markSupported();
        java.io.OutputStream outputStream6 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream8 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream6, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry9 = null;
        boolean boolean10 = cpioArchiveOutputStream8.canWriteEntryData(archiveEntry9);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream12 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream8, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream14 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream12, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap15 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream16 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream14, strMap15);
        long long17 = org.apache.commons.compress.utils.IOUtils.copy((java.io.InputStream) cpioArchiveInputStream1, (java.io.OutputStream) pack200CompressorOutputStream16);
        org.apache.commons.compress.compressors.snappy.FramedSnappyCompressorOutputStream framedSnappyCompressorOutputStream18 = new org.apache.commons.compress.compressors.snappy.FramedSnappyCompressorOutputStream((java.io.OutputStream) pack200CompressorOutputStream16);
        org.apache.commons.compress.compressors.xz.XZCompressorOutputStream xZCompressorOutputStream19 = new org.apache.commons.compress.compressors.xz.XZCompressorOutputStream((java.io.OutputStream) pack200CompressorOutputStream16);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + long17 + "' != '" + 0L + "'", long17 == 0L);
    }

    @Test
    public void test1272() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1272");
        int int0 = org.apache.commons.compress.harmony.unpack200.AttributeLayout.CONTEXT_FIELD;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test1273() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1273");
        org.apache.commons.compress.archivers.zip.AsiExtraField asiExtraField0 = new org.apache.commons.compress.archivers.zip.AsiExtraField();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort1 = asiExtraField0.getCentralDirectoryLength();
        org.junit.Assert.assertNotNull(zipShort1);
    }

    @Test
    public void test1274() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1274");
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        java.nio.file.attribute.FileTime fileTime2 = jarArchiveEntry1.getCreationTime();
        org.apache.commons.compress.parallel.InputStreamSupplier inputStreamSupplier3 = null;
        org.apache.commons.compress.archivers.zip.ZipArchiveEntryRequest zipArchiveEntryRequest4 = org.apache.commons.compress.archivers.zip.ZipArchiveEntryRequest.createZipArchiveEntryRequest((org.apache.commons.compress.archivers.zip.ZipArchiveEntry) jarArchiveEntry1, inputStreamSupplier3);
        int int5 = zipArchiveEntryRequest4.getMethod();
        org.junit.Assert.assertNull(fileTime2);
        org.junit.Assert.assertNotNull(zipArchiveEntryRequest4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + (-1) + "'", int5 == (-1));
    }

    @Test
    public void test1275() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1275");
        int int0 = org.apache.commons.compress.harmony.unpack200.Segment.LOG_LEVEL_VERBOSE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2 + "'", int0 == 2);
    }

    @Test
    public void test1276() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1276");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("error", false);
        boolean boolean3 = tarArchiveEntry2.isStreamContiguous();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test1277() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1277");
        java.util.concurrent.ExecutorService executorService0 = null;
        java.nio.file.Path path1 = null;
        org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier defaultBackingStoreSupplier2 = new org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier(path1);
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore3 = defaultBackingStoreSupplier2.get();
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore4 = defaultBackingStoreSupplier2.get();
        org.apache.commons.compress.archivers.zip.ParallelScatterZipCreator parallelScatterZipCreator5 = new org.apache.commons.compress.archivers.zip.ParallelScatterZipCreator(executorService0, (org.apache.commons.compress.parallel.ScatterGatherBackingStoreSupplier) defaultBackingStoreSupplier2);
        org.apache.commons.compress.archivers.zip.ScatterStatistics scatterStatistics6 = parallelScatterZipCreator5.getStatisticsMessage();
        org.apache.commons.compress.archivers.zip.ZipArchiveEntryRequestSupplier zipArchiveEntryRequestSupplier7 = null;
        // The following exception was thrown during execution in test generation
        try {
            parallelScatterZipCreator5.addArchiveEntry(zipArchiveEntryRequestSupplier7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(scatterGatherBackingStore3);
        org.junit.Assert.assertNotNull(scatterGatherBackingStore4);
        org.junit.Assert.assertNotNull(scatterStatistics6);
    }

    @Test
    public void test1278() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1278");
        org.apache.commons.compress.harmony.pack200.Segment segment2 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands4 = new org.apache.commons.compress.harmony.pack200.CpBands(segment2, (int) (byte) 2);
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS5 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.pack200.CPConstant<?> wildcardCPConstant6 = cpBands4.getConstant((java.lang.Object) oS5);
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader7 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        org.apache.commons.compress.harmony.pack200.MetadataBandGroup metadataBandGroup9 = new org.apache.commons.compress.harmony.pack200.MetadataBandGroup("LocalVariableTypeTable", 16, cpBands4, segmentHeader7, 263);
        org.apache.commons.compress.harmony.pack200.Segment segment10 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands12 = new org.apache.commons.compress.harmony.pack200.CpBands(segment10, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature14 = cpBands12.getCPSignature("ustar\000");
        int int15 = cPSignature14.getIndexInCpUtf8();
        org.apache.commons.compress.harmony.pack200.Segment segment16 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands18 = new org.apache.commons.compress.harmony.pack200.CpBands(segment16, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature20 = cpBands18.getCPSignature("ustar\000");
        int int21 = cPSignature20.getIndexInCpUtf8();
        org.apache.commons.compress.harmony.pack200.Segment segment22 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands24 = new org.apache.commons.compress.harmony.pack200.CpBands(segment22, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature26 = cpBands24.getCPSignature("ustar\000");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_31 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_33 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition attributeDefinition34 = new org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition(4096, 493, cPUTF8_31, cPUTF8_33);
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_35 = attributeDefinition34.name;
        org.apache.commons.compress.harmony.pack200.Segment segment36 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands38 = new org.apache.commons.compress.harmony.pack200.CpBands(segment36, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPMethodOrField cPMethodOrField42 = cpBands38.getCPMethod("", "zstd", "ACC_STRICT");
        org.apache.commons.compress.harmony.pack200.CPClass cPClass44 = cpBands38.getCPClass("true");
        boolean boolean45 = cPClass44.isInnerClass();
        org.apache.commons.compress.harmony.pack200.CPClass[] cPClassArray46 = new org.apache.commons.compress.harmony.pack200.CPClass[] { cPClass44 };
        java.util.ArrayList<org.apache.commons.compress.harmony.pack200.CPClass> cPClassList47 = new java.util.ArrayList<org.apache.commons.compress.harmony.pack200.CPClass>();
        boolean boolean48 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.pack200.CPClass>) cPClassList47, cPClassArray46);
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature49 = new org.apache.commons.compress.harmony.pack200.CPSignature("splitting", cPUTF8_35, (java.util.List<org.apache.commons.compress.harmony.pack200.CPClass>) cPClassList47);
        org.apache.commons.compress.harmony.pack200.Segment segment50 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands52 = new org.apache.commons.compress.harmony.pack200.CpBands(segment50, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature54 = cpBands52.getCPSignature("ustar\000");
        org.apache.commons.compress.harmony.pack200.CPSignature[] cPSignatureArray55 = new org.apache.commons.compress.harmony.pack200.CPSignature[] { cPSignature14, cPSignature20, cPSignature26, cPSignature49, cPSignature54 };
        java.util.ArrayList<org.apache.commons.compress.harmony.pack200.CPSignature> cPSignatureList56 = new java.util.ArrayList<org.apache.commons.compress.harmony.pack200.CPSignature>();
        boolean boolean57 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.pack200.CPSignature>) cPSignatureList56, cPSignatureArray55);
        metadataBandGroup9.caseet_RS = cPSignatureList56;
        org.apache.commons.compress.harmony.pack200.IntList intList59 = null;
        metadataBandGroup9.nestpair_N = intList59;
        org.apache.commons.compress.harmony.pack200.IntList intList61 = metadataBandGroup9.pair_N;
        int[] intArray62 = intList61.toArray();
        org.junit.Assert.assertTrue("'" + oS5 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS5.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertNull(wildcardCPConstant6);
        org.junit.Assert.assertNotNull(cPSignature14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + (-1) + "'", int15 == (-1));
        org.junit.Assert.assertNotNull(cPSignature20);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + (-1) + "'", int21 == (-1));
        org.junit.Assert.assertNotNull(cPSignature26);
        org.junit.Assert.assertNotNull(cPUTF8_35);
        org.junit.Assert.assertNotNull(cPMethodOrField42);
        org.junit.Assert.assertNotNull(cPClass44);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
        org.junit.Assert.assertNotNull(cPClassArray46);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + true + "'", boolean48 == true);
        org.junit.Assert.assertNotNull(cPSignature54);
        org.junit.Assert.assertNotNull(cPSignatureArray55);
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + true + "'", boolean57 == true);
        org.junit.Assert.assertNotNull(intList61);
        org.junit.Assert.assertNotNull(intArray62);
        org.junit.Assert.assertArrayEquals(intArray62, new int[] {});
    }

    @Test
    public void test1279() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1279");
        java.nio.file.Path path1 = null;
        org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier defaultBackingStoreSupplier2 = new org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier(path1);
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore3 = defaultBackingStoreSupplier2.get();
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore4 = defaultBackingStoreSupplier2.get();
        org.apache.commons.compress.archivers.zip.StreamCompressor streamCompressor5 = org.apache.commons.compress.archivers.zip.StreamCompressor.create(0, scatterGatherBackingStore4);
        streamCompressor5.close();
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker7 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray8 = jarMarker7.getCentralDirectoryData();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField9 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger10 = zip64ExtendedInformationExtraField9.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger11 = null;
        zip64ExtendedInformationExtraField9.setSize(zipEightByteInteger11);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField13 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField14 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger15 = zip64ExtendedInformationExtraField14.getCompressedSize();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField16 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger17 = zip64ExtendedInformationExtraField16.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger18 = null;
        zip64ExtendedInformationExtraField16.setSize(zipEightByteInteger18);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField20 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger21 = zip64ExtendedInformationExtraField20.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger22 = null;
        zip64ExtendedInformationExtraField20.setSize(zipEightByteInteger22);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField24 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipExtraField[] zipExtraFieldArray25 = new org.apache.commons.compress.archivers.zip.ZipExtraField[] { zip64ExtendedInformationExtraField9, zip64ExtendedInformationExtraField13, zip64ExtendedInformationExtraField14, zip64ExtendedInformationExtraField16, zip64ExtendedInformationExtraField20, zip64ExtendedInformationExtraField24 };
        byte[] byteArray26 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.mergeLocalFileDataData(zipExtraFieldArray25);
        boolean boolean27 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray8, byteArray26);
        streamCompressor5.writeCounted(byteArray8);
        org.junit.Assert.assertNotNull(scatterGatherBackingStore3);
        org.junit.Assert.assertNotNull(scatterGatherBackingStore4);
        org.junit.Assert.assertNotNull(streamCompressor5);
        org.junit.Assert.assertNotNull(byteArray8);
        org.junit.Assert.assertArrayEquals(byteArray8, new byte[] {});
        org.junit.Assert.assertNull(zipEightByteInteger10);
        org.junit.Assert.assertNull(zipEightByteInteger15);
        org.junit.Assert.assertNull(zipEightByteInteger17);
        org.junit.Assert.assertNull(zipEightByteInteger21);
        org.junit.Assert.assertNotNull(zipExtraFieldArray25);
        org.junit.Assert.assertNotNull(byteArray26);
        org.junit.Assert.assertArrayEquals(byteArray26, new byte[] { (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
    }

    @Test
    public void test1280() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1280");
        byte[] byteArray3 = new byte[] { (byte) 10, (byte) 10, (byte) -1 };
        boolean boolean5 = org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.matches(byteArray3, (int) (short) -1);
        byte[] byteArray6 = org.apache.commons.compress.archivers.zip.ZipUtil.reverse(byteArray3);
        boolean boolean8 = org.apache.commons.compress.compressors.xz.XZUtils.matches(byteArray3, (int) (short) -1);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) -1, (byte) 10, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] { (byte) -1, (byte) 10, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test1281() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1281");
        java.lang.String str0 = org.apache.commons.compress.harmony.unpack200.AttributeLayout.ACC_ENUM;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "ACC_ENUM" + "'", str0, "ACC_ENUM");
    }

    @Test
    public void test1282() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1282");
        java.nio.charset.Charset charset2 = null;
        org.apache.commons.compress.archivers.zip.ZipEncoding zipEncoding3 = org.apache.commons.compress.archivers.zip.ZipEncodingHelper.getZipEncoding(charset2);
        byte[] byteArray9 = new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 };
        byte[] byteArray16 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean18 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray16, 0);
        boolean boolean19 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray9, byteArray16);
        java.lang.String str20 = zipEncoding3.decode(byteArray9);
        org.apache.commons.compress.harmony.unpack200.Segment segment21 = new org.apache.commons.compress.harmony.unpack200.Segment();
        org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager operandManager22 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass26 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry27 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass26);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass31 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry32 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass31);
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry[] exceptionTableEntryArray33 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry[] { exceptionTableEntry27, exceptionTableEntry32 };
        java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry> exceptionTableEntryList34 = new java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>();
        boolean boolean35 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>) exceptionTableEntryList34, exceptionTableEntryArray33);
        org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute codeAttribute36 = new org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute(476, (int) (byte) 51, byteArray9, segment21, operandManager22, (java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>) exceptionTableEntryList34);
        java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode> byteCodeList37 = codeAttribute36.byteCodes;
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS39 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue elementValue40 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue((int) (byte) 7, (java.lang.Object) oS39);
        java.util.List<java.lang.Object> objList41 = elementValue40.getClassFileEntries();
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute annotationDefaultAttribute42 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute(elementValue40);
        java.lang.String str43 = annotationDefaultAttribute42.toString();
        java.lang.String str44 = annotationDefaultAttribute42.toString();
        codeAttribute36.addAttribute((org.apache.commons.compress.harmony.unpack200.bytecode.Attribute) annotationDefaultAttribute42);
        java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode> byteCodeList46 = codeAttribute36.byteCodes;
        org.junit.Assert.assertNotNull(zipEncoding3);
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertArrayEquals(byteArray9, new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 });
        org.junit.Assert.assertNotNull(byteArray16);
        org.junit.Assert.assertArrayEquals(byteArray16, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "\002?\002\n\001" + "'", str20, "\002?\002\n\001");
        org.junit.Assert.assertNotNull(exceptionTableEntryArray33);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + true + "'", boolean35 == true);
        org.junit.Assert.assertNotNull(byteCodeList37);
        org.junit.Assert.assertTrue("'" + oS39 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS39.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertNotNull(objList41);
        org.junit.Assert.assertNotNull(byteCodeList46);
    }

    @Test
    public void test1283() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1283");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream5 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream1, (long) 1, (long) 148);
        java.util.zip.Checksum checksum6 = cRC32VerifyingInputStream5.getChecksum();
        long long8 = cRC32VerifyingInputStream5.skip((long) 345);
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream11 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cRC32VerifyingInputStream5, 8589934591L, (long) '4');
        org.apache.commons.compress.utils.BoundedInputStream boundedInputStream13 = new org.apache.commons.compress.utils.BoundedInputStream((java.io.InputStream) cRC32VerifyingInputStream5, (long) 1000);
        org.apache.commons.compress.archivers.zip.ZipArchiveInputStream zipArchiveInputStream14 = new org.apache.commons.compress.archivers.zip.ZipArchiveInputStream((java.io.InputStream) cRC32VerifyingInputStream5);
        java.util.function.Function<org.apache.commons.compress.archivers.zip.ZipShort, org.apache.commons.compress.archivers.zip.ZipExtraField> zipShortFunction15 = null;
        org.apache.commons.compress.archivers.zip.ZipArchiveInputStream zipArchiveInputStream16 = zipArchiveInputStream14.setExtraFieldSupport(zipShortFunction15);
        org.apache.commons.io.function.IOIterator<org.apache.commons.compress.archivers.zip.ZipArchiveEntry> zipArchiveEntryIOIterator17 = zipArchiveInputStream14.iterator();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(checksum6);
        org.junit.Assert.assertTrue("'" + long8 + "' != '" + 0L + "'", long8 == 0L);
        org.junit.Assert.assertNotNull(zipArchiveInputStream16);
        org.junit.Assert.assertNotNull(zipArchiveEntryIOIterator17);
    }

    @Test
    public void test1284() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1284");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry6 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean7 = cpioArchiveOutputStream2.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry6);
        java.nio.file.attribute.FileTime fileTime8 = jarArchiveEntry6.getLastAccessTime();
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource commentSource9 = jarArchiveEntry6.getCommentSource();
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource commentSource10 = jarArchiveEntry6.getCommentSource();
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker11 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray12 = jarMarker11.getCentralDirectoryData();
        byte[] byteArray13 = jarMarker11.getLocalFileDataData();
        boolean boolean15 = org.apache.commons.compress.compressors.xz.XZCompressorInputStream.matches(byteArray13, 0);
        boolean boolean17 = org.apache.commons.compress.archivers.dump.DumpArchiveInputStream.matches(byteArray13, 17);
        org.apache.commons.compress.archivers.tar.TarFile tarFile18 = new org.apache.commons.compress.archivers.tar.TarFile(byteArray13);
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry21 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file22 = tarArchiveEntry21.getFile();
        int int23 = tarArchiveEntry21.getDevMinor();
        tarArchiveEntry21.setUserName("UTF-8:splitting");
        tarArchiveEntry21.setUserId(12);
        java.io.InputStream inputStream28 = tarFile18.getInputStream(tarArchiveEntry21);
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry31 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file32 = tarArchiveEntry31.getFile();
        boolean boolean33 = tarArchiveEntry31.isGNUSparse();
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry34 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date35 = arjArchiveEntry34.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong36 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date35);
        tarArchiveEntry31.setModTime(date35);
        java.nio.file.attribute.FileTime fileTime38 = tarArchiveEntry31.getLastModifiedTime();
        tarArchiveEntry21.setLastModifiedTime(fileTime38);
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry40 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        java.lang.String str41 = sevenZArchiveEntry40.getName();
        sevenZArchiveEntry40.setHasCrc(false);
        boolean boolean44 = sevenZArchiveEntry40.getHasWindowsAttributes();
        sevenZArchiveEntry40.setHasLastModifiedDate(true);
        java.lang.String str47 = sevenZArchiveEntry40.getName();
        sevenZArchiveEntry40.setWindowsAttributes((int) '4');
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker50 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray51 = jarMarker50.getCentralDirectoryData();
        byte[] byteArray52 = jarMarker50.getLocalFileDataData();
        boolean boolean54 = org.apache.commons.compress.compressors.xz.XZCompressorInputStream.matches(byteArray52, 0);
        boolean boolean56 = org.apache.commons.compress.archivers.dump.DumpArchiveInputStream.matches(byteArray52, 17);
        org.apache.commons.compress.archivers.tar.TarFile tarFile57 = new org.apache.commons.compress.archivers.tar.TarFile(byteArray52);
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry60 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file61 = tarArchiveEntry60.getFile();
        int int62 = tarArchiveEntry60.getDevMinor();
        tarArchiveEntry60.setUserName("UTF-8:splitting");
        tarArchiveEntry60.setUserId(12);
        java.io.InputStream inputStream67 = tarFile57.getInputStream(tarArchiveEntry60);
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry70 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file71 = tarArchiveEntry70.getFile();
        boolean boolean72 = tarArchiveEntry70.isGNUSparse();
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry73 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date74 = arjArchiveEntry73.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong75 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date74);
        tarArchiveEntry70.setModTime(date74);
        java.nio.file.attribute.FileTime fileTime77 = tarArchiveEntry70.getLastModifiedTime();
        tarArchiveEntry60.setLastModifiedTime(fileTime77);
        sevenZArchiveEntry40.setLastModifiedTime(fileTime77);
        tarArchiveEntry21.setModTime(fileTime77);
        // The following exception was thrown during execution in test generation
        try {
            jarArchiveEntry6.setTime(fileTime77);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.file.attribute.FileTimes.isUnixTime(Ljava/nio/file/attribute/FileTime;)Z");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNull(fileTime8);
        org.junit.Assert.assertTrue("'" + commentSource9 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.COMMENT + "'", commentSource9.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.COMMENT));
        org.junit.Assert.assertTrue("'" + commentSource10 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.COMMENT + "'", commentSource10.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.COMMENT));
        org.junit.Assert.assertNotNull(byteArray12);
        org.junit.Assert.assertArrayEquals(byteArray12, new byte[] {});
        org.junit.Assert.assertNotNull(byteArray13);
        org.junit.Assert.assertArrayEquals(byteArray13, new byte[] {});
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNull(file22);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + 0 + "'", int23 == 0);
        org.junit.Assert.assertNotNull(inputStream28);
        org.junit.Assert.assertNull(file32);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertNotNull(date35);
        org.junit.Assert.assertEquals(date35.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong36);
        org.junit.Assert.assertNotNull(fileTime38);
        org.junit.Assert.assertNull(str41);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertNull(str47);
        org.junit.Assert.assertNotNull(byteArray51);
        org.junit.Assert.assertArrayEquals(byteArray51, new byte[] {});
        org.junit.Assert.assertNotNull(byteArray52);
        org.junit.Assert.assertArrayEquals(byteArray52, new byte[] {});
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + false + "'", boolean54 == false);
        org.junit.Assert.assertTrue("'" + boolean56 + "' != '" + false + "'", boolean56 == false);
        org.junit.Assert.assertNull(file61);
        org.junit.Assert.assertTrue("'" + int62 + "' != '" + 0 + "'", int62 == 0);
        org.junit.Assert.assertNotNull(inputStream67);
        org.junit.Assert.assertNull(file71);
        org.junit.Assert.assertTrue("'" + boolean72 + "' != '" + false + "'", boolean72 == false);
        org.junit.Assert.assertNotNull(date74);
        org.junit.Assert.assertEquals(date74.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong75);
        org.junit.Assert.assertNotNull(fileTime77);
    }

    @Test
    public void test1285() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1285");
        org.apache.commons.compress.compressors.lz77support.LZ77Compressor.EOD eOD0 = new org.apache.commons.compress.compressors.lz77support.LZ77Compressor.EOD();
    }

    @Test
    public void test1286() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1286");
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader0 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        org.apache.commons.compress.harmony.pack200.BandSet.BandAnalysisResults bandAnalysisResults1 = segmentHeader0.new BandAnalysisResults();
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode5 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int6 = byteCode5.getByteCodeIndex();
        int[] intArray7 = new int[] {};
        int[] intArray8 = new int[] {};
        int[] intArray9 = new int[] {};
        int[][] intArray10 = new int[][] { intArray7, intArray8, intArray9 };
        byteCode5.setNestedPositions(intArray10);
        int[] intArray12 = byteCode5.getRewrite();
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.ThisFieldRefForm thisFieldRefForm13 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.ThisFieldRefForm(17, "ar", intArray12);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec14 = org.apache.commons.compress.harmony.pack200.Codec.BRANCH5;
        byte[] byteArray15 = segmentHeader0.encodeScalar(intArray12, bHSDCodec14);
        org.junit.Assert.assertNotNull(byteCode5);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + (-1) + "'", int6 == (-1));
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertArrayEquals(intArray7, new int[] {});
        org.junit.Assert.assertNotNull(intArray8);
        org.junit.Assert.assertArrayEquals(intArray8, new int[] {});
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertArrayEquals(intArray9, new int[] {});
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertNotNull(intArray12);
        org.junit.Assert.assertArrayEquals(intArray12, new int[] { 255 });
        org.junit.Assert.assertNotNull(bHSDCodec14);
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] { (byte) -4, (byte) 22 });
    }

    @Test
    public void test1287() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1287");
        java.util.ArrayList<org.apache.commons.compress.archivers.tar.TarArchiveEntry[]> tarArchiveEntryArrayList0 = org.apache.commons.compress.utils.Lists.newArrayList();
        org.junit.Assert.assertNotNull(tarArchiveEntryArrayList0);
    }

    @Test
    public void test1288() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1288");
        byte[] byteArray7 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean9 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray7, 0);
        java.nio.charset.Charset charset12 = null;
        org.apache.commons.compress.archivers.zip.ZipEncoding zipEncoding13 = org.apache.commons.compress.archivers.zip.ZipEncodingHelper.getZipEncoding(charset12);
        byte[] byteArray19 = new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 };
        byte[] byteArray26 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean28 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray26, 0);
        boolean boolean29 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray19, byteArray26);
        java.lang.String str30 = zipEncoding13.decode(byteArray19);
        // The following exception was thrown during execution in test generation
        try {
            int int31 = org.apache.commons.compress.archivers.tar.TarUtils.formatNameBytes("ustar\000.bz2", byteArray7, 17, (int) (byte) 2, zipEncoding13);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: null");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(zipEncoding13);
        org.junit.Assert.assertNotNull(byteArray19);
        org.junit.Assert.assertArrayEquals(byteArray19, new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 });
        org.junit.Assert.assertNotNull(byteArray26);
        org.junit.Assert.assertArrayEquals(byteArray26, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertEquals("'" + str30 + "' != '" + "\002?\002\n\001" + "'", str30, "\002?\002\n\001");
    }

    @Test
    public void test1289() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1289");
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.WideForm wideForm2 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.WideForm(10, "");
        int[] intArray14 = new int[] { ' ', (byte) -1 };
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm iMethodRefForm15 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm((int) (byte) -1, "", intArray14);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm classRefForm16 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm((int) (short) 0, "jar", intArray14);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.StringRefForm stringRefForm18 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.StringRefForm(1, "splitting", intArray14, true);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.LabelForm labelForm19 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.LabelForm((int) '#', "pass", intArray14);
        // The following exception was thrown during execution in test generation
        try {
            wideForm2.setRewrite4Bytes(1024, intArray14);
            org.junit.Assert.fail("Expected exception of type java.lang.Error; message: Trying to rewrite org.apache.commons.compress.harmony.unpack200.bytecode.forms.WideForm() but there is no room for 4 bytes");
        } catch (java.lang.Error e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(intArray14);
        org.junit.Assert.assertArrayEquals(intArray14, new int[] { 32, (-1) });
    }

    @Test
    public void test1290() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1290");
        java.lang.Throwable throwable4 = null;
        org.apache.commons.compress.MemoryLimitException memoryLimitException5 = new org.apache.commons.compress.MemoryLimitException((long) '4', (int) (short) 0, throwable4);
        org.apache.commons.compress.archivers.dump.DumpArchiveException dumpArchiveException6 = new org.apache.commons.compress.archivers.dump.DumpArchiveException((java.lang.Throwable) memoryLimitException5);
        org.apache.commons.compress.MemoryLimitException memoryLimitException7 = new org.apache.commons.compress.MemoryLimitException((long) 32768, (int) (byte) 4, (java.lang.Exception) dumpArchiveException6);
    }

    @Test
    public void test1291() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1291");
        java.io.InputStream inputStream0 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long2 = org.apache.commons.compress.utils.ByteUtils.fromLittleEndian(inputStream0, 55);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Can't read more than eight bytes into a long value");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1292() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1292");
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder0 = new org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder();
        java.io.OutputStream outputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream3 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream1, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry4 = null;
        boolean boolean5 = cpioArchiveOutputStream3.canWriteEntryData(archiveEntry4);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream7 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream3, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream9 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream7, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap10 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream11 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream9, strMap10);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec12 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean13 = bHSDCodec12.isDelta();
        byte[] byteArray15 = bHSDCodec12.encode((int) '#');
        pack200CompressorOutputStream11.write(byteArray15);
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder17 = builder0.setOutputStream((java.io.OutputStream) pack200CompressorOutputStream11);
        char[] charArray23 = new char[] { 'a', 'a', '#', '4', '4' };
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder24 = builder17.setPassword(charArray23);
        java.nio.file.LinkOption[] linkOptionArray25 = org.apache.commons.compress.utils.IOUtils.EMPTY_LINK_OPTIONS;
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder26 = builder24.setOpenOptions((java.nio.file.OpenOption[]) linkOptionArray25);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(bHSDCodec12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] { (byte) 35 });
        org.junit.Assert.assertNotNull(builder17);
        org.junit.Assert.assertNotNull(charArray23);
        org.junit.Assert.assertArrayEquals(charArray23, new char[] { 'a', 'a', '#', '4', '4' });
        org.junit.Assert.assertNotNull(builder24);
        org.junit.Assert.assertNotNull(linkOptionArray25);
        org.junit.Assert.assertArrayEquals(linkOptionArray25, new java.nio.file.LinkOption[] {});
        org.junit.Assert.assertNotNull(builder26);
    }

    @Test
    public void test1293() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1293");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream3 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream4 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        zipArchiveOutputStream4.setUseLanguageEncodingFlag(true);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.utils.IOUtils.closeQuietly((java.io.Closeable) zipArchiveOutputStream4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1294() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1294");
        org.apache.commons.compress.archivers.ar.ArArchiveEntry arArchiveEntry6 = new org.apache.commons.compress.archivers.ar.ArArchiveEntry("", (long) 'a', 0, 10, 0, (long) (short) 1);
        long long7 = arArchiveEntry6.getSize();
        long long8 = arArchiveEntry6.getLength();
        java.lang.String str9 = arArchiveEntry6.getName();
        boolean boolean10 = arArchiveEntry6.isDirectory();
        org.junit.Assert.assertTrue("'" + long7 + "' != '" + 97L + "'", long7 == 97L);
        org.junit.Assert.assertTrue("'" + long8 + "' != '" + 97L + "'", long8 == 97L);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "" + "'", str9, "");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test1295() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1295");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime1 = null;
        x5455_ExtendedTimestamp0.setAccessFileTime(fileTime1);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = x5455_ExtendedTimestamp0.getLocalFileDataLength();
        byte[] byteArray7 = new byte[] { (byte) 10, (byte) 10, (byte) -1 };
        boolean boolean9 = org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.matches(byteArray7, (int) (short) -1);
        byte[] byteArray10 = org.apache.commons.compress.archivers.zip.ZipUtil.reverse(byteArray7);
        // The following exception was thrown during execution in test generation
        try {
            x5455_ExtendedTimestamp0.parseFromLocalFileData(byteArray10, 0, 257);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 3");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(zipShort3);
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) -1, (byte) 10, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(byteArray10);
        org.junit.Assert.assertArrayEquals(byteArray10, new byte[] { (byte) -1, (byte) 10, (byte) 10 });
    }

    @Test
    public void test1296() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1296");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        java.lang.String str1 = sevenZArchiveEntry0.getName();
        sevenZArchiveEntry0.setHasCrc(false);
        boolean boolean4 = sevenZArchiveEntry0.getHasWindowsAttributes();
        int int5 = sevenZArchiveEntry0.getWindowsAttributes();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test1297() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1297");
        org.apache.commons.compress.changes.ChangeSetResults changeSetResults0 = new org.apache.commons.compress.changes.ChangeSetResults();
        java.util.List<java.lang.String> strList1 = changeSetResults0.getAddedFromChangeSet();
        org.junit.Assert.assertNotNull(strList1);
    }

    @Test
    public void test1298() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1298");
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions0 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        packingOptions0.setLogFile("ar");
        packingOptions0.setVerbose(true);
        java.lang.String str5 = packingOptions0.getLogFile();
        boolean boolean6 = packingOptions0.isKeepFileOrder();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "ar" + "'", str5, "ar");
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test1299() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1299");
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel1 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        org.apache.commons.compress.archivers.tar.TarFile tarFile2 = new org.apache.commons.compress.archivers.tar.TarFile((java.nio.channels.SeekableByteChannel) seekableInMemoryByteChannel1);
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry5 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file6 = tarArchiveEntry5.getFile();
        int int7 = tarArchiveEntry5.getDevMinor();
        tarArchiveEntry5.setUserName("UTF-8:splitting");
        tarArchiveEntry5.setIds(493, (int) (byte) 2);
        boolean boolean13 = tarArchiveEntry5.isDirectory();
        java.lang.String str15 = tarArchiveEntry5.getExtraPaxHeader("pass");
        boolean boolean16 = tarArchiveEntry5.isCheckSumOK();
        tarArchiveEntry5.setNames("ACC_ANNOTATION", "");
        java.io.InputStream inputStream20 = tarFile2.getInputStream(tarArchiveEntry5);
        org.junit.Assert.assertNull(file6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNull(str15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(inputStream20);
    }

    @Test
    public void test1300() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1300");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream3 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker5 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray6 = jarMarker5.getCentralDirectoryData();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField7 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger8 = zip64ExtendedInformationExtraField7.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger9 = null;
        zip64ExtendedInformationExtraField7.setSize(zipEightByteInteger9);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField11 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField12 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger13 = zip64ExtendedInformationExtraField12.getCompressedSize();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField14 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger15 = zip64ExtendedInformationExtraField14.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger16 = null;
        zip64ExtendedInformationExtraField14.setSize(zipEightByteInteger16);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField18 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger19 = zip64ExtendedInformationExtraField18.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger20 = null;
        zip64ExtendedInformationExtraField18.setSize(zipEightByteInteger20);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField22 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipExtraField[] zipExtraFieldArray23 = new org.apache.commons.compress.archivers.zip.ZipExtraField[] { zip64ExtendedInformationExtraField7, zip64ExtendedInformationExtraField11, zip64ExtendedInformationExtraField12, zip64ExtendedInformationExtraField14, zip64ExtendedInformationExtraField18, zip64ExtendedInformationExtraField22 };
        byte[] byteArray24 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.mergeLocalFileDataData(zipExtraFieldArray23);
        boolean boolean25 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray6, byteArray24);
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField28 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField("ustar\000", byteArray24, 0, 9);
        blockLZ4CompressorOutputStream3.prefill(byteArray24, 21, (int) '4');
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarArchiveOutputStream tarArchiveOutputStream33 = new org.apache.commons.compress.archivers.tar.TarArchiveOutputStream((java.io.OutputStream) blockLZ4CompressorOutputStream3, 31);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Block size must be a multiple of 512 bytes. Attempt to use set size of 31");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] {});
        org.junit.Assert.assertNull(zipEightByteInteger8);
        org.junit.Assert.assertNull(zipEightByteInteger13);
        org.junit.Assert.assertNull(zipEightByteInteger15);
        org.junit.Assert.assertNull(zipEightByteInteger19);
        org.junit.Assert.assertNotNull(zipExtraFieldArray23);
        org.junit.Assert.assertNotNull(byteArray24);
        org.junit.Assert.assertArrayEquals(byteArray24, new byte[] { (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
    }

    @Test
    public void test1301() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1301");
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField2 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField();
        jarArchiveEntry1.addExtraField((org.apache.commons.compress.archivers.zip.ZipExtraField) unicodeCommentExtraField2);
        java.lang.Object obj4 = jarArchiveEntry1.clone();
        org.junit.Assert.assertNotNull(obj4);
        org.junit.Assert.assertEquals(obj4.toString(), "ACC_NATIVE.gz");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(obj4), "ACC_NATIVE.gz");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj4), "ACC_NATIVE.gz");
    }

    @Test
    public void test1302() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1302");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry6 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean7 = cpioArchiveOutputStream2.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry6);
        long long8 = jarArchiveEntry6.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipExtraField[] zipExtraFieldArray10 = jarArchiveEntry6.getExtraFields(true);
        java.nio.file.attribute.FileTime fileTime11 = jarArchiveEntry6.getLastModifiedTime();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + long8 + "' != '" + (-1L) + "'", long8 == (-1L));
        org.junit.Assert.assertNotNull(zipExtraFieldArray10);
        org.junit.Assert.assertArrayEquals(zipExtraFieldArray10, new org.apache.commons.compress.archivers.zip.ZipExtraField[] {});
        org.junit.Assert.assertNull(fileTime11);
    }

    @Test
    public void test1303() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1303");
        org.apache.commons.compress.harmony.pack200.Segment segment0 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands2 = new org.apache.commons.compress.harmony.pack200.CpBands(segment0, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPMethodOrField cPMethodOrField6 = cpBands2.getCPMethod("", "zstd", "ACC_STRICT");
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature8 = cpBands2.getCPSignature("ustar ");
        org.junit.Assert.assertNotNull(cPMethodOrField6);
        org.junit.Assert.assertNotNull(cPSignature8);
    }

    @Test
    public void test1304() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1304");
        byte[] byteArray2 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(0L);
        boolean boolean4 = org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.matches(byteArray2, 52);
        org.apache.commons.compress.archivers.tar.TarFile tarFile5 = new org.apache.commons.compress.archivers.tar.TarFile(byteArray2);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.UnicodePathExtraField unicodePathExtraField8 = new org.apache.commons.compress.archivers.zip.UnicodePathExtraField("././@LongLink", byteArray2, 55, (int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: null");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) 0, (byte) 0, (byte) 33, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test1305() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1305");
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker1 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray2 = jarMarker1.getLocalFileDataData();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = jarMarker1.getLocalFileDataLength();
        byte[] byteArray4 = jarMarker1.getLocalFileDataData();
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField5 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField("ustar\000", byteArray4);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertNotNull(zipShort3);
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] {});
    }

    @Test
    public void test1306() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1306");
        byte[] byteArray1 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(0L);
        boolean boolean3 = org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.matches(byteArray1, 52);
        org.apache.commons.compress.archivers.tar.TarFile tarFile4 = new org.apache.commons.compress.archivers.tar.TarFile(byteArray1);
        org.apache.commons.compress.archivers.zip.ZipLong zipLong6 = new org.apache.commons.compress.archivers.zip.ZipLong(byteArray1, 0);
        java.nio.charset.Charset charset7 = null;
        org.apache.commons.compress.archivers.zip.ZipEncoding zipEncoding8 = org.apache.commons.compress.archivers.zip.ZipEncodingHelper.getZipEncoding(charset7);
        byte[] byteArray14 = new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 };
        byte[] byteArray21 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean23 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray21, 0);
        boolean boolean24 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray14, byteArray21);
        java.lang.String str25 = zipEncoding8.decode(byteArray14);
        boolean boolean27 = zipEncoding8.canEncode("deflate");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry30 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry(byteArray1, zipEncoding8, false, 1L);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 100");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 0, (byte) 0, (byte) 33, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(zipEncoding8);
        org.junit.Assert.assertNotNull(byteArray14);
        org.junit.Assert.assertArrayEquals(byteArray14, new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 });
        org.junit.Assert.assertNotNull(byteArray21);
        org.junit.Assert.assertArrayEquals(byteArray21, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertEquals("'" + str25 + "' != '" + "\002?\002\n\001" + "'", str25, "\002?\002\n\001");
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + true + "'", boolean27 == true);
    }

    @Test
    public void test1307() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1307");
        org.apache.commons.compress.harmony.pack200.Segment segment0 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.objectweb.asm.TypePath typePath2 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.objectweb.asm.AnnotationVisitor annotationVisitor5 = segment0.visitTypeAnnotation(7, typePath2, "class-file version", false);
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: TypeAnnotation requires ASM5");
        } catch (java.lang.UnsupportedOperationException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1308() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1308");
        int int0 = org.apache.commons.compress.harmony.unpack200.AttributeLayout.CONTEXT_CODE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 3 + "'", int0 == 3);
    }

    @Test
    public void test1309() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1309");
        org.apache.commons.compress.archivers.zip.UnicodePathExtraField unicodePathExtraField0 = new org.apache.commons.compress.archivers.zip.UnicodePathExtraField();
    }

    @Test
    public void test1310() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1310");
        java.util.concurrent.ExecutorService executorService0 = null;
        java.nio.file.Path path1 = null;
        org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier defaultBackingStoreSupplier2 = new org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier(path1);
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore3 = defaultBackingStoreSupplier2.get();
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore4 = defaultBackingStoreSupplier2.get();
        org.apache.commons.compress.archivers.zip.ParallelScatterZipCreator parallelScatterZipCreator5 = new org.apache.commons.compress.archivers.zip.ParallelScatterZipCreator(executorService0, (org.apache.commons.compress.parallel.ScatterGatherBackingStoreSupplier) defaultBackingStoreSupplier2);
        org.apache.commons.compress.archivers.zip.ScatterStatistics scatterStatistics6 = parallelScatterZipCreator5.getStatisticsMessage();
        long long7 = scatterStatistics6.getMergingElapsed();
        long long8 = scatterStatistics6.getCompressionElapsed();
        org.junit.Assert.assertNotNull(scatterGatherBackingStore3);
        org.junit.Assert.assertNotNull(scatterGatherBackingStore4);
        org.junit.Assert.assertNotNull(scatterStatistics6);
        org.junit.Assert.assertTrue("'" + long7 + "' != '" + 0L + "'", long7 == 0L);
// flaky "3) test1310(RegressionTest2)":         org.junit.Assert.assertTrue("'" + long8 + "' != '" + (-1741956537562L) + "'", long8 == (-1741956537562L));
    }

    @Test
    public void test1311() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1311");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file3 = tarArchiveEntry2.getFile();
        boolean boolean4 = tarArchiveEntry2.isOldGNUSparse();
        org.junit.Assert.assertNull(file3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test1312() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1312");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        java.lang.String str1 = sevenZArchiveEntry0.getName();
        sevenZArchiveEntry0.setHasCrc(false);
        java.lang.Iterable<? extends org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration> wildcardIterable4 = sevenZArchiveEntry0.getContentMethods();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertNull(wildcardIterable4);
    }

    @Test
    public void test1313() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1313");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        java.lang.String str1 = sevenZArchiveEntry0.getName();
        sevenZArchiveEntry0.setHasCrc(false);
        boolean boolean4 = sevenZArchiveEntry0.getHasWindowsAttributes();
        sevenZArchiveEntry0.setWindowsAttributes(1000);
        java.lang.String str7 = sevenZArchiveEntry0.getName();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test1314() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1314");
        java.nio.file.Path path1 = null;
        org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier defaultBackingStoreSupplier2 = new org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier(path1);
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore3 = defaultBackingStoreSupplier2.get();
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore4 = defaultBackingStoreSupplier2.get();
        org.apache.commons.compress.archivers.zip.StreamCompressor streamCompressor5 = org.apache.commons.compress.archivers.zip.StreamCompressor.create(0, scatterGatherBackingStore4);
        scatterGatherBackingStore4.closeForWriting();
        org.junit.Assert.assertNotNull(scatterGatherBackingStore3);
        org.junit.Assert.assertNotNull(scatterGatherBackingStore4);
        org.junit.Assert.assertNotNull(streamCompressor5);
    }

    @Test
    public void test1315() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1315");
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry0 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        boolean boolean1 = arjArchiveEntry0.isHostOsUnix();
        long long2 = arjArchiveEntry0.getSize();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
    }

    @Test
    public void test1316() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1316");
        int int0 = org.apache.commons.compress.archivers.cpio.CpioConstants.BLOCK_SIZE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 512 + "'", int0 == 512);
    }

    @Test
    public void test1317() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1317");
        byte byte0 = org.apache.commons.compress.archivers.tar.TarConstants.LF_GNUTYPE_SPARSE;
        org.junit.Assert.assertTrue("'" + byte0 + "' != '" + (byte) 83 + "'", byte0 == (byte) 83);
    }

    @Test
    public void test1318() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1318");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream3 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker5 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray6 = jarMarker5.getCentralDirectoryData();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField7 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger8 = zip64ExtendedInformationExtraField7.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger9 = null;
        zip64ExtendedInformationExtraField7.setSize(zipEightByteInteger9);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField11 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField12 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger13 = zip64ExtendedInformationExtraField12.getCompressedSize();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField14 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger15 = zip64ExtendedInformationExtraField14.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger16 = null;
        zip64ExtendedInformationExtraField14.setSize(zipEightByteInteger16);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField18 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger19 = zip64ExtendedInformationExtraField18.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger20 = null;
        zip64ExtendedInformationExtraField18.setSize(zipEightByteInteger20);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField22 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipExtraField[] zipExtraFieldArray23 = new org.apache.commons.compress.archivers.zip.ZipExtraField[] { zip64ExtendedInformationExtraField7, zip64ExtendedInformationExtraField11, zip64ExtendedInformationExtraField12, zip64ExtendedInformationExtraField14, zip64ExtendedInformationExtraField18, zip64ExtendedInformationExtraField22 };
        byte[] byteArray24 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.mergeLocalFileDataData(zipExtraFieldArray23);
        boolean boolean25 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray6, byteArray24);
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField28 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField("ustar\000", byteArray24, 0, 9);
        blockLZ4CompressorOutputStream3.prefill(byteArray24, 21, (int) '4');
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray33 = blockLZ4CompressorOutputStream3.writeUsAsciiRaw("ZipShort value: 1");
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: No current CPIO entry");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] {});
        org.junit.Assert.assertNull(zipEightByteInteger8);
        org.junit.Assert.assertNull(zipEightByteInteger13);
        org.junit.Assert.assertNull(zipEightByteInteger15);
        org.junit.Assert.assertNull(zipEightByteInteger19);
        org.junit.Assert.assertNotNull(zipExtraFieldArray23);
        org.junit.Assert.assertNotNull(byteArray24);
        org.junit.Assert.assertArrayEquals(byteArray24, new byte[] { (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
    }

    @Test
    public void test1319() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1319");
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel1 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        org.apache.commons.compress.archivers.tar.TarFile tarFile2 = new org.apache.commons.compress.archivers.tar.TarFile((java.nio.channels.SeekableByteChannel) seekableInMemoryByteChannel1);
        tarFile2.close();
    }

    @Test
    public void test1320() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1320");
        org.apache.commons.compress.archivers.examples.Expander expander0 = new org.apache.commons.compress.archivers.examples.Expander();
        java.io.InputStream inputStream2 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream3 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream2);
        byte[] byteArray4 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream3);
        long long5 = cpioArchiveInputStream3.getBytesRead();
        int int6 = cpioArchiveInputStream3.getCount();
        boolean boolean7 = cpioArchiveInputStream3.markSupported();
        org.apache.commons.io.function.IOIterator<org.apache.commons.compress.archivers.cpio.CpioArchiveEntry> cpioArchiveEntryIOIterator8 = cpioArchiveInputStream3.iterator();
        long long10 = cpioArchiveInputStream3.skip((long) (byte) 55);
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream11 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream((java.io.InputStream) cpioArchiveInputStream3);
        org.apache.commons.compress.archivers.tar.TarArchiveInputStream tarArchiveInputStream12 = new org.apache.commons.compress.archivers.tar.TarArchiveInputStream((java.io.InputStream) cpioArchiveInputStream11);
        java.nio.file.Path path13 = null;
        org.apache.commons.compress.archivers.examples.CloseableConsumer closeableConsumer14 = org.apache.commons.compress.archivers.examples.CloseableConsumer.NULL_CONSUMER;
        // The following exception was thrown during execution in test generation
        try {
            expander0.expand("pack.keep.file.order", (java.io.InputStream) tarArchiveInputStream12, path13, closeableConsumer14);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.compress.archivers.ArchiveException; message: Archiver: pack.keep.file.order not found.");
        } catch (org.apache.commons.compress.archivers.ArchiveException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] {});
        org.junit.Assert.assertTrue("'" + long5 + "' != '" + 0L + "'", long5 == 0L);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(cpioArchiveEntryIOIterator8);
        org.junit.Assert.assertTrue("'" + long10 + "' != '" + 0L + "'", long10 == 0L);
        org.junit.Assert.assertNotNull(closeableConsumer14);
    }

    @Test
    public void test1321() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1321");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_2);
        java.lang.String str4 = cPUTF8_2.toString();
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_7 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_7);
        org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute newAttribute10 = new org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute(cPUTF8_7, 8);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_14 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_14);
        org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute newAttribute17 = new org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute(cPUTF8_14, 8);
        org.apache.commons.compress.harmony.unpack200.bytecode.Attribute[] attributeArray18 = new org.apache.commons.compress.harmony.unpack200.bytecode.Attribute[] { newAttribute17 };
        java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute> attributeList19 = new java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute>();
        boolean boolean20 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute>) attributeList19, attributeArray18);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPMember cPMember21 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPMember(cPUTF8_2, cPUTF8_7, (long) (byte) 0, (java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute>) attributeList19);
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionsAttribute.setAttributeName(cPUTF8_2);
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.Annotation annotation23 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.Annotation[] annotationArray24 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.Annotation[] { annotation23 };
        org.apache.commons.compress.harmony.unpack200.bytecode.RuntimeVisibleorInvisibleAnnotationsAttribute runtimeVisibleorInvisibleAnnotationsAttribute25 = new org.apache.commons.compress.harmony.unpack200.bytecode.RuntimeVisibleorInvisibleAnnotationsAttribute(cPUTF8_2, annotationArray24);
        java.lang.String str26 = runtimeVisibleorInvisibleAnnotationsAttribute25.toString();
        java.lang.String str27 = runtimeVisibleorInvisibleAnnotationsAttribute25.toString();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "UTF-8:splitting" + "'", str4, "UTF-8:splitting");
        org.junit.Assert.assertNotNull(attributeArray18);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
        org.junit.Assert.assertNotNull(annotationArray24);
        org.junit.Assert.assertArrayEquals(annotationArray24, new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.Annotation[] { null });
        org.junit.Assert.assertEquals("'" + str26 + "' != '" + "splitting: 1 annotations" + "'", str26, "splitting: 1 annotations");
        org.junit.Assert.assertEquals("'" + str27 + "' != '" + "splitting: 1 annotations" + "'", str27, "splitting: 1 annotations");
    }

    @Test
    public void test1322() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1322");
        org.apache.commons.compress.harmony.pack200.NewAttribute.StripAttribute stripAttribute2 = new org.apache.commons.compress.harmony.pack200.NewAttribute.StripAttribute("././@LongLink", 40960);
        boolean boolean3 = stripAttribute2.isCodeAttribute();
        boolean boolean4 = stripAttribute2.isContextClass();
        boolean boolean5 = stripAttribute2.isUnknown();
        java.lang.String str6 = stripAttribute2.type;
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "././@LongLink" + "'", str6, "././@LongLink");
    }

    @Test
    public void test1323() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1323");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream8 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 4);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream10 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 32);
        java.io.File file11 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.cpio.CpioArchiveEntry cpioArchiveEntry13 = cpioArchiveOutputStream2.createArchiveEntry(file11, "US-ASCII");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test1324() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1324");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec0 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        bHSDCodec0.lastBandLength = (-1);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec3 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean4 = bHSDCodec3.isDelta();
        byte[] byteArray6 = bHSDCodec3.encode((int) '#');
        int int7 = bHSDCodec3.getS();
        int int8 = bHSDCodec3.getH();
        long long9 = bHSDCodec3.smallest();
        int[] intArray10 = org.apache.commons.compress.harmony.pack200.CodecEncoding.getSpecifier((org.apache.commons.compress.harmony.pack200.Codec) bHSDCodec0, (org.apache.commons.compress.harmony.pack200.Codec) bHSDCodec3);
        int int11 = bHSDCodec3.lastBandLength;
        org.junit.Assert.assertNotNull(bHSDCodec0);
        org.junit.Assert.assertNotNull(bHSDCodec3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] { (byte) 35 });
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 4 + "'", int8 == 4);
        org.junit.Assert.assertTrue("'" + long9 + "' != '" + 0L + "'", long9 == 0L);
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] { 17 });
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + (-1) + "'", int11 == (-1));
    }

    @Test
    public void test1325() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1325");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        fixedLengthBlockOutputStream6.write(1024);
        org.apache.commons.compress.compressors.lzma.LZMACompressorOutputStream lZMACompressorOutputStream9 = new org.apache.commons.compress.compressors.lzma.LZMACompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream6);
        lZMACompressorOutputStream9.flush();
        byte[] byteArray12 = lZMACompressorOutputStream9.writeUtf8("TRAILER!!!");
        lZMACompressorOutputStream9.finish();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(byteArray12);
        org.junit.Assert.assertArrayEquals(byteArray12, new byte[] { (byte) 84, (byte) 82, (byte) 65, (byte) 73, (byte) 76, (byte) 69, (byte) 82, (byte) 33, (byte) 33, (byte) 33 });
    }

    @Test
    public void test1326() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1326");
        org.apache.commons.compress.archivers.zip.X0015_CertificateIdForFile x0015_CertificateIdForFile0 = new org.apache.commons.compress.archivers.zip.X0015_CertificateIdForFile();
        org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm hashAlgorithm1 = x0015_CertificateIdForFile0.getHashAlgorithm();
        java.util.jar.JarInputStream jarInputStream2 = null;
        java.util.jar.JarFile jarFile3 = null;
        java.io.OutputStream outputStream4 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream6 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream4, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry7 = null;
        boolean boolean8 = cpioArchiveOutputStream6.canWriteEntryData(archiveEntry7);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream10 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream6, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream12 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream10, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap13 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream14 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream12, strMap13);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec15 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean16 = bHSDCodec15.isDelta();
        byte[] byteArray18 = bHSDCodec15.encode((int) '#');
        pack200CompressorOutputStream14.write(byteArray18);
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions20 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        org.apache.commons.compress.harmony.pack200.Archive archive21 = new org.apache.commons.compress.harmony.pack200.Archive(jarFile3, (java.io.OutputStream) pack200CompressorOutputStream14, packingOptions20);
        java.util.jar.JarFile jarFile22 = null;
        java.io.OutputStream outputStream23 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream25 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream23, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry26 = null;
        boolean boolean27 = cpioArchiveOutputStream25.canWriteEntryData(archiveEntry26);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream29 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream25, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream31 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream29, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap32 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream33 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream31, strMap32);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec34 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean35 = bHSDCodec34.isDelta();
        byte[] byteArray37 = bHSDCodec34.encode((int) '#');
        pack200CompressorOutputStream33.write(byteArray37);
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions39 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        org.apache.commons.compress.harmony.pack200.Archive archive40 = new org.apache.commons.compress.harmony.pack200.Archive(jarFile22, (java.io.OutputStream) pack200CompressorOutputStream33, packingOptions39);
        org.apache.commons.compress.harmony.pack200.Archive archive41 = new org.apache.commons.compress.harmony.pack200.Archive(jarInputStream2, (java.io.OutputStream) pack200CompressorOutputStream14, packingOptions39);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream43 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) pack200CompressorOutputStream14, (int) (short) 4);
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker44 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray45 = jarMarker44.getLocalFileDataData();
        pack200CompressorOutputStream14.write(byteArray45);
        // The following exception was thrown during execution in test generation
        try {
            x0015_CertificateIdForFile0.parseFromCentralDirectoryData(byteArray45, 28771, (int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: null");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(hashAlgorithm1);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(bHSDCodec15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(byteArray18);
        org.junit.Assert.assertArrayEquals(byteArray18, new byte[] { (byte) 35 });
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + true + "'", boolean27 == true);
        org.junit.Assert.assertNotNull(bHSDCodec34);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertNotNull(byteArray37);
        org.junit.Assert.assertArrayEquals(byteArray37, new byte[] { (byte) 35 });
        org.junit.Assert.assertNotNull(byteArray45);
        org.junit.Assert.assertArrayEquals(byteArray45, new byte[] {});
    }

    @Test
    public void test1327() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1327");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        byte[] byteArray2 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream1);
        long long3 = cpioArchiveInputStream1.getBytesRead();
        int int4 = cpioArchiveInputStream1.getCount();
        boolean boolean5 = cpioArchiveInputStream1.markSupported();
        java.io.OutputStream outputStream6 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream8 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream6, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry9 = null;
        boolean boolean10 = cpioArchiveOutputStream8.canWriteEntryData(archiveEntry9);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream12 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream8, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream14 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream12, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap15 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream16 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream14, strMap15);
        long long17 = org.apache.commons.compress.utils.IOUtils.copy((java.io.InputStream) cpioArchiveInputStream1, (java.io.OutputStream) pack200CompressorOutputStream16);
        org.apache.commons.compress.compressors.xz.XZCompressorOutputStream xZCompressorOutputStream18 = new org.apache.commons.compress.compressors.xz.XZCompressorOutputStream((java.io.OutputStream) pack200CompressorOutputStream16);
        org.apache.commons.compress.archivers.tar.TarArchiveOutputStream tarArchiveOutputStream20 = new org.apache.commons.compress.archivers.tar.TarArchiveOutputStream((java.io.OutputStream) xZCompressorOutputStream18, "UTF-16");
        tarArchiveOutputStream20.setBigNumberMode(134630224);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + long17 + "' != '" + 0L + "'", long17 == 0L);
    }

    @Test
    public void test1328() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1328");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.ATIMELEN_XSTAR;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 12 + "'", int0 == 12);
    }

    @Test
    public void test1329() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1329");
        org.apache.commons.compress.archivers.ArchiveStreamFactory archiveStreamFactory1 = new org.apache.commons.compress.archivers.ArchiveStreamFactory("");
        java.lang.String str2 = archiveStreamFactory1.getEntryEncoding();
        java.util.Set<java.lang.String> strSet3 = archiveStreamFactory1.getInputStreamArchiveNames();
        java.lang.String str4 = archiveStreamFactory1.getEntryEncoding();
        java.io.InputStream inputStream6 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream7 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream6);
        int int8 = cpioArchiveInputStream7.getCount();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream11 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream7, (long) 1, (long) 148);
        java.io.OutputStream outputStream12 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream14 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream12, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry15 = null;
        boolean boolean16 = cpioArchiveOutputStream14.canWriteEntryData(archiveEntry15);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream18 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream14, 135);
        org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream framedLZ4CompressorOutputStream19 = new org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream18);
        framedLZ4CompressorOutputStream19.write(0);
        long long22 = org.apache.commons.compress.utils.IOUtils.copy((java.io.InputStream) cRC32VerifyingInputStream11, (java.io.OutputStream) framedLZ4CompressorOutputStream19);
        int int23 = cRC32VerifyingInputStream11.read();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarArchiveInputStream tarArchiveInputStream25 = archiveStreamFactory1.createArchiveInputStream("pack.unknown.attribute", (java.io.InputStream) cRC32VerifyingInputStream11, "deflate64");
            org.junit.Assert.fail("Expected exception of type org.apache.commons.compress.archivers.ArchiveException; message: Archiver: pack.unknown.attribute not found.");
        } catch (org.apache.commons.compress.archivers.ArchiveException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "" + "'", str2, "");
        org.junit.Assert.assertNotNull(strSet3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertTrue("'" + long22 + "' != '" + 0L + "'", long22 == 0L);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
    }

    @Test
    public void test1330() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1330");
        java.lang.String str0 = org.apache.commons.compress.harmony.unpack200.AttributeLayout.ACC_SYNCHRONIZED;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "ACC_SYNCHRONIZED" + "'", str0, "ACC_SYNCHRONIZED");
    }

    @Test
    public void test1331() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1331");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        java.lang.String str1 = sevenZArchiveEntry0.getName();
        sevenZArchiveEntry0.setHasCrc(false);
        sevenZArchiveEntry0.setAntiItem(false);
        boolean boolean6 = sevenZArchiveEntry0.getHasLastModifiedDate();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test1332() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1332");
        // The following exception was thrown during execution in test generation
        try {
            int int1 = org.apache.commons.compress.utils.ParsingUtils.parseIntValue("CPMember: UTF-8:splitting(UTF-8:splitting)");
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: Unable to parse int from string value: CPMember: UTF-8:splitting(UTF-8:splitting)");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1333() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1333");
        org.apache.commons.compress.harmony.unpack200.AttributeLayoutMap attributeLayoutMap0 = new org.apache.commons.compress.harmony.unpack200.AttributeLayoutMap();
        attributeLayoutMap0.checkMap();
        org.apache.commons.compress.harmony.unpack200.AttributeLayout attributeLayout2 = null;
        org.apache.commons.compress.harmony.unpack200.NewAttributeBands newAttributeBands3 = attributeLayoutMap0.getAttributeBands(attributeLayout2);
        org.apache.commons.compress.harmony.unpack200.AttributeLayout attributeLayout4 = null;
        org.apache.commons.compress.harmony.unpack200.NewAttributeBands newAttributeBands5 = attributeLayoutMap0.getAttributeBands(attributeLayout4);
        org.junit.Assert.assertNull(newAttributeBands3);
        org.junit.Assert.assertNull(newAttributeBands5);
    }

    @Test
    public void test1334() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1334");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        long long3 = cpioArchiveInputStream1.getBytesRead();
        cpioArchiveInputStream1.mark(21);
        org.apache.commons.io.function.IOIterator<org.apache.commons.compress.archivers.cpio.CpioArchiveEntry> cpioArchiveEntryIOIterator6 = cpioArchiveInputStream1.iterator();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream9 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream1, (long) 155, (int) (byte) -1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertNotNull(cpioArchiveEntryIOIterator6);
    }

    @Test
    public void test1335() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1335");
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode1 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int2 = byteCode1.getByteCodeIndex();
        int[] intArray3 = new int[] {};
        int[] intArray4 = new int[] {};
        int[] intArray5 = new int[] {};
        int[][] intArray6 = new int[][] { intArray3, intArray4, intArray5 };
        byteCode1.setNestedPositions(intArray6);
        int[] intArray8 = byteCode1.getRewrite();
        java.lang.String str9 = byteCode1.toString();
        java.lang.String str10 = byteCode1.toString();
        java.lang.String str11 = byteCode1.getName();
        org.junit.Assert.assertNotNull(byteCode1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
        org.junit.Assert.assertNotNull(intArray3);
        org.junit.Assert.assertArrayEquals(intArray3, new int[] {});
        org.junit.Assert.assertNotNull(intArray4);
        org.junit.Assert.assertArrayEquals(intArray4, new int[] {});
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] {});
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertNotNull(intArray8);
        org.junit.Assert.assertArrayEquals(intArray8, new int[] { 255 });
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "impdep2" + "'", str9, "impdep2");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "impdep2" + "'", str10, "impdep2");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "impdep2" + "'", str11, "impdep2");
    }

    @Test
    public void test1336() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1336");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        long long3 = dumpArchiveEntry2.getSize();
        boolean boolean4 = dumpArchiveEntry2.isBlkDev();
        dumpArchiveEntry2.setGeneration((int) (byte) 55);
        dumpArchiveEntry2.setGeneration(55);
        org.apache.commons.compress.archivers.dump.DumpArchiveConstants.SEGMENT_TYPE sEGMENT_TYPE9 = dumpArchiveEntry2.getHeaderType();
        java.util.Set<org.apache.commons.compress.archivers.dump.DumpArchiveEntry.PERMISSION> pERMISSIONSet10 = dumpArchiveEntry2.getPermissions();
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNull(sEGMENT_TYPE9);
        org.junit.Assert.assertNotNull(pERMISSIONSet10);
    }

    @Test
    public void test1337() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1337");
        org.apache.commons.compress.harmony.pack200.BHSDCodec[] bHSDCodecArray1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs1;
        org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaSignedCodecs5 = bHSDCodecArray1;
        java.lang.String str3 = org.apache.commons.compress.harmony.archive.internal.nls.Messages.getString("keep", (java.lang.Object[]) bHSDCodecArray1);
        org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs2 = bHSDCodecArray1;
        org.junit.Assert.assertNotNull(bHSDCodecArray1);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "keep" + "'", str3, "keep");
    }

    @Test
    public void test1338() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1338");
        java.util.jar.JarEntry jarEntry0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry(jarEntry0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: entry");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1339() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1339");
        org.apache.commons.compress.archivers.zip.Zip64Mode zip64Mode0 = org.apache.commons.compress.archivers.zip.Zip64Mode.Always;
        org.junit.Assert.assertTrue("'" + zip64Mode0 + "' != '" + org.apache.commons.compress.archivers.zip.Zip64Mode.Always + "'", zip64Mode0.equals(org.apache.commons.compress.archivers.zip.Zip64Mode.Always));
    }

    @Test
    public void test1340() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1340");
        int[] intArray8 = new int[] { ' ', (byte) -1 };
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm iMethodRefForm9 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm((int) (byte) -1, "", intArray8);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.LabelForm labelForm11 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.LabelForm(5, "class-file version", intArray8, true);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm iMethodRefForm12 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm(345, "apk", intArray8);
        org.junit.Assert.assertNotNull(intArray8);
        org.junit.Assert.assertArrayEquals(intArray8, new int[] { 32, (-1) });
    }

    @Test
    public void test1341() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1341");
        java.nio.charset.Charset charset2 = null;
        org.apache.commons.compress.archivers.zip.ZipEncoding zipEncoding3 = org.apache.commons.compress.archivers.zip.ZipEncodingHelper.getZipEncoding(charset2);
        byte[] byteArray9 = new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 };
        byte[] byteArray16 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean18 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray16, 0);
        boolean boolean19 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray9, byteArray16);
        java.lang.String str20 = zipEncoding3.decode(byteArray9);
        org.apache.commons.compress.harmony.unpack200.Segment segment21 = new org.apache.commons.compress.harmony.unpack200.Segment();
        org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager operandManager22 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass26 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry27 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass26);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass31 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry32 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass31);
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry[] exceptionTableEntryArray33 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry[] { exceptionTableEntry27, exceptionTableEntry32 };
        java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry> exceptionTableEntryList34 = new java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>();
        boolean boolean35 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>) exceptionTableEntryList34, exceptionTableEntryArray33);
        org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute codeAttribute36 = new org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute(476, (int) (byte) 51, byteArray9, segment21, operandManager22, (java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>) exceptionTableEntryList34);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_39 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_39);
        java.lang.String str41 = cPUTF8_39.toString();
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_44 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_44);
        org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute newAttribute47 = new org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute(cPUTF8_44, 8);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_51 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_51);
        org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute newAttribute54 = new org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute(cPUTF8_51, 8);
        org.apache.commons.compress.harmony.unpack200.bytecode.Attribute[] attributeArray55 = new org.apache.commons.compress.harmony.unpack200.bytecode.Attribute[] { newAttribute54 };
        java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute> attributeList56 = new java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute>();
        boolean boolean57 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute>) attributeList56, attributeArray55);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPMember cPMember58 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPMember(cPUTF8_39, cPUTF8_44, (long) (byte) 0, (java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute>) attributeList56);
        org.apache.commons.compress.harmony.unpack200.bytecode.SignatureAttribute signatureAttribute59 = new org.apache.commons.compress.harmony.unpack200.bytecode.SignatureAttribute(cPUTF8_39);
        codeAttribute36.addAttribute((org.apache.commons.compress.harmony.unpack200.bytecode.Attribute) signatureAttribute59);
        java.lang.String str61 = codeAttribute36.toString();
        int int62 = codeAttribute36.maxStack;
        codeAttribute36.maxStack = (byte) 48;
        codeAttribute36.maxStack = 135;
        org.junit.Assert.assertNotNull(zipEncoding3);
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertArrayEquals(byteArray9, new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 });
        org.junit.Assert.assertNotNull(byteArray16);
        org.junit.Assert.assertArrayEquals(byteArray16, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "\002?\002\n\001" + "'", str20, "\002?\002\n\001");
        org.junit.Assert.assertNotNull(exceptionTableEntryArray33);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + true + "'", boolean35 == true);
        org.junit.Assert.assertEquals("'" + str41 + "' != '" + "UTF-8:splitting" + "'", str41, "UTF-8:splitting");
        org.junit.Assert.assertNotNull(attributeArray55);
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + true + "'", boolean57 == true);
        org.junit.Assert.assertEquals("'" + str61 + "' != '" + "Code: 41 bytes" + "'", str61, "Code: 41 bytes");
        org.junit.Assert.assertTrue("'" + int62 + "' != '" + 476 + "'", int62 == 476);
    }

    @Test
    public void test1342() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1342");
        org.apache.commons.compress.archivers.ArchiveException archiveException1 = new org.apache.commons.compress.archivers.ArchiveException("pack.modification.time");
    }

    @Test
    public void test1343() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1343");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry6 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean7 = cpioArchiveOutputStream2.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry6);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipArchiveEntry zipArchiveEntry8 = new org.apache.commons.compress.archivers.zip.ZipArchiveEntry((org.apache.commons.compress.archivers.zip.ZipArchiveEntry) jarArchiveEntry6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: ZIP compression method cannot be negative: -1");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test1344() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1344");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream framedLZ4CompressorOutputStream7 = new org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream6);
        framedLZ4CompressorOutputStream7.write(0);
        byte[] byteArray11 = framedLZ4CompressorOutputStream7.writeUtf8("pass");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(byteArray11);
        org.junit.Assert.assertArrayEquals(byteArray11, new byte[] { (byte) 112, (byte) 97, (byte) 115, (byte) 115 });
    }

    @Test
    public void test1345() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1345");
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker0 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray1 = jarMarker0.getCentralDirectoryData();
        byte[] byteArray2 = jarMarker0.getLocalFileDataData();
        boolean boolean4 = org.apache.commons.compress.compressors.xz.XZCompressorInputStream.matches(byteArray2, 0);
        boolean boolean6 = org.apache.commons.compress.archivers.dump.DumpArchiveInputStream.matches(byteArray2, 17);
        org.apache.commons.compress.archivers.tar.TarFile tarFile7 = new org.apache.commons.compress.archivers.tar.TarFile(byteArray2);
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry10 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file11 = tarArchiveEntry10.getFile();
        int int12 = tarArchiveEntry10.getDevMinor();
        tarArchiveEntry10.setUserName("UTF-8:splitting");
        tarArchiveEntry10.setUserId(12);
        java.io.InputStream inputStream17 = tarFile7.getInputStream(tarArchiveEntry10);
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry20 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file21 = tarArchiveEntry20.getFile();
        boolean boolean22 = tarArchiveEntry20.isGNUSparse();
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry23 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date24 = arjArchiveEntry23.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong25 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date24);
        tarArchiveEntry20.setModTime(date24);
        java.nio.file.attribute.FileTime fileTime27 = tarArchiveEntry20.getLastModifiedTime();
        tarArchiveEntry10.setLastModifiedTime(fileTime27);
        boolean boolean29 = tarArchiveEntry10.isStarSparse();
        org.apache.commons.compress.archivers.tar.TarArchiveEntry[] tarArchiveEntryArray30 = tarArchiveEntry10.getDirectoryEntries();
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] {});
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(file11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(inputStream17);
        org.junit.Assert.assertNull(file21);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(date24);
        org.junit.Assert.assertEquals(date24.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong25);
        org.junit.Assert.assertNotNull(fileTime27);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNotNull(tarArchiveEntryArray30);
        org.junit.Assert.assertArrayEquals(tarArchiveEntryArray30, new org.apache.commons.compress.archivers.tar.TarArchiveEntry[] {});
    }

    @Test
    public void test1346() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1346");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec0 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean1 = bHSDCodec0.isDelta();
        byte[] byteArray3 = bHSDCodec0.encode((int) '#');
        int int4 = bHSDCodec0.getS();
        int int5 = bHSDCodec0.getH();
        long long6 = bHSDCodec0.smallest();
        int int7 = org.apache.commons.compress.harmony.pack200.CodecEncoding.getSpecifierForDefaultCodec(bHSDCodec0);
        org.junit.Assert.assertNotNull(bHSDCodec0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 35 });
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 4 + "'", int5 == 4);
        org.junit.Assert.assertTrue("'" + long6 + "' != '" + 0L + "'", long6 == 0L);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 17 + "'", int7 == 17);
    }

    @Test
    public void test1347() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1347");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_2);
        org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute newAttribute5 = new org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute(cPUTF8_2, 8);
        int int6 = newAttribute5.getLayoutIndex();
        int int7 = newAttribute5.getLayoutIndex();
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 8 + "'", int6 == 8);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 8 + "'", int7 == 8);
    }

    @Test
    public void test1348() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1348");
        org.apache.commons.compress.harmony.pack200.Segment segment0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.pack200.ClassBands classBands4 = new org.apache.commons.compress.harmony.pack200.ClassBands(segment0, (int) (byte) 54, (int) (byte) 7, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1349() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1349");
        java.nio.file.Path path1 = null;
        org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier defaultBackingStoreSupplier2 = new org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier(path1);
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore3 = defaultBackingStoreSupplier2.get();
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore4 = defaultBackingStoreSupplier2.get();
        org.apache.commons.compress.archivers.zip.StreamCompressor streamCompressor5 = org.apache.commons.compress.archivers.zip.StreamCompressor.create(0, scatterGatherBackingStore4);
        org.apache.commons.compress.archivers.zip.StreamCompressor streamCompressor6 = org.apache.commons.compress.archivers.zip.StreamCompressor.create(scatterGatherBackingStore4);
        java.io.InputStream inputStream7 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream8 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream7);
        int int9 = cpioArchiveInputStream8.getCount();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream12 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream8, (long) 1, (long) 148);
        java.util.zip.Checksum checksum13 = cRC32VerifyingInputStream12.getChecksum();
        streamCompressor6.deflate((java.io.InputStream) cRC32VerifyingInputStream12, 256);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.brotli.BrotliCompressorInputStream brotliCompressorInputStream16 = new org.apache.commons.compress.compressors.brotli.BrotliCompressorInputStream((java.io.InputStream) cRC32VerifyingInputStream12);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(scatterGatherBackingStore3);
        org.junit.Assert.assertNotNull(scatterGatherBackingStore4);
        org.junit.Assert.assertNotNull(streamCompressor5);
        org.junit.Assert.assertNotNull(streamCompressor6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertNotNull(checksum13);
    }

    @Test
    public void test1350() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1350");
        org.apache.commons.compress.compressors.lz77support.Parameters.Builder builder0 = org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream.createParameterBuilder();
        org.apache.commons.compress.compressors.lz77support.Parameters parameters1 = builder0.build();
        boolean boolean2 = parameters1.getLazyMatching();
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(parameters1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test1351() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1351");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream3 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        byte[] byteArray5 = blockLZ4CompressorOutputStream3.writeUtf8("LiteralBlock LITERAL with offset 40960 and length 8");
        org.junit.Assert.assertNotNull(byteArray5);
    }

    @Test
    public void test1352() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1352");
        org.apache.commons.compress.compressors.xz.XZUtils.setCacheXZAvailablity(false);
    }

    @Test
    public void test1353() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1353");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream5 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream1, (long) 1, (long) 148);
        java.util.zip.Checksum checksum6 = cRC32VerifyingInputStream5.getChecksum();
        long long8 = cRC32VerifyingInputStream5.skip((long) 345);
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream11 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cRC32VerifyingInputStream5, 8589934591L, (long) '4');
        org.apache.commons.compress.utils.BoundedInputStream boundedInputStream13 = new org.apache.commons.compress.utils.BoundedInputStream((java.io.InputStream) cRC32VerifyingInputStream5, (long) 1000);
        org.apache.commons.compress.archivers.zip.ZipArchiveInputStream zipArchiveInputStream14 = new org.apache.commons.compress.archivers.zip.ZipArchiveInputStream((java.io.InputStream) cRC32VerifyingInputStream5);
        java.util.function.Function<org.apache.commons.compress.archivers.zip.ZipShort, org.apache.commons.compress.archivers.zip.ZipExtraField> zipShortFunction15 = null;
        org.apache.commons.compress.archivers.zip.ZipArchiveInputStream zipArchiveInputStream16 = zipArchiveInputStream14.setExtraFieldSupport(zipShortFunction15);
        zipArchiveInputStream16.mark(488);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(checksum6);
        org.junit.Assert.assertTrue("'" + long8 + "' != '" + 0L + "'", long8 == 0L);
        org.junit.Assert.assertNotNull(zipArchiveInputStream16);
    }

    @Test
    public void test1354() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1354");
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode1 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int2 = byteCode1.getLength();
        org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry[] classFileEntryArray3 = byteCode1.getNestedClassFileEntries();
        org.apache.commons.compress.harmony.unpack200.bytecode.ClassFile classFile4 = new org.apache.commons.compress.harmony.unpack200.bytecode.ClassFile();
        org.apache.commons.compress.harmony.unpack200.bytecode.ClassConstantPool classConstantPool5 = classFile4.pool;
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass[] cPClassArray6 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPClass[] {};
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionsAttribute exceptionsAttribute7 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionsAttribute(cPClassArray6);
        classFile4.fields = cPClassArray6;
        org.apache.commons.compress.harmony.unpack200.bytecode.Attribute[] attributeArray9 = classFile4.attributes;
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode11 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int12 = byteCode11.getLength();
        org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry[] classFileEntryArray13 = byteCode11.getNestedClassFileEntries();
        classFile4.methods = classFileEntryArray13;
        byteCode1.setNested(classFileEntryArray13);
        org.junit.Assert.assertNotNull(byteCode1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 1 + "'", int2 == 1);
        org.junit.Assert.assertNotNull(classFileEntryArray3);
        org.junit.Assert.assertArrayEquals(classFileEntryArray3, new org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry[] {});
        org.junit.Assert.assertNotNull(classConstantPool5);
        org.junit.Assert.assertNotNull(cPClassArray6);
        org.junit.Assert.assertArrayEquals(cPClassArray6, new org.apache.commons.compress.harmony.unpack200.bytecode.CPClass[] {});
        org.junit.Assert.assertNull(attributeArray9);
        org.junit.Assert.assertNotNull(byteCode11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 1 + "'", int12 == 1);
        org.junit.Assert.assertNotNull(classFileEntryArray13);
        org.junit.Assert.assertArrayEquals(classFileEntryArray13, new org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry[] {});
    }

    @Test
    public void test1355() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1355");
        org.apache.commons.compress.archivers.ArchiveStreamFactory archiveStreamFactory1 = new org.apache.commons.compress.archivers.ArchiveStreamFactory("lz4-block");
    }

    @Test
    public void test1356() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1356");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime1 = null;
        x5455_ExtendedTimestamp0.setAccessFileTime(fileTime1);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = x5455_ExtendedTimestamp0.getLocalFileDataLength();
        java.nio.file.attribute.FileTime fileTime4 = x5455_ExtendedTimestamp0.getCreateFileTime();
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp5 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime6 = null;
        x5455_ExtendedTimestamp5.setAccessFileTime(fileTime6);
        org.apache.commons.compress.archivers.zip.ZipLong zipLong8 = org.apache.commons.compress.archivers.zip.ZipLong.AED_SIG;
        boolean boolean10 = zipLong8.equals((java.lang.Object) "pass");
        x5455_ExtendedTimestamp5.setCreateTime(zipLong8);
        x5455_ExtendedTimestamp0.setAccessTime(zipLong8);
        java.lang.Object obj13 = x5455_ExtendedTimestamp0.clone();
        org.junit.Assert.assertNotNull(zipShort3);
        org.junit.Assert.assertNull(fileTime4);
        org.junit.Assert.assertNotNull(zipLong8);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(obj13);
        org.junit.Assert.assertEquals(obj13.toString(), "0x5455 Zip Extra Field: Flags=10  Access:[Mon Apr 08 15:17:04 AEST 1974] ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(obj13), "0x5455 Zip Extra Field: Flags=10  Access:[Mon Apr 08 15:17:04 AEST 1974] ");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj13), "0x5455 Zip Extra Field: Flags=10  Access:[Mon Apr 08 15:17:04 AEST 1974] ");
    }

    @Test
    public void test1357() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1357");
        int int0 = org.apache.commons.compress.harmony.unpack200.SegmentConstantPool.CP_FLOAT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 3 + "'", int0 == 3);
    }

    @Test
    public void test1358() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1358");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file3 = tarArchiveEntry2.getFile();
        int int4 = tarArchiveEntry2.getDevMinor();
        tarArchiveEntry2.setUserName("UTF-8:splitting");
        long long7 = tarArchiveEntry2.getDataOffset();
        java.nio.file.attribute.FileTime fileTime8 = tarArchiveEntry2.getLastModifiedTime();
        org.junit.Assert.assertNull(file3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + long7 + "' != '" + (-1L) + "'", long7 == (-1L));
        org.junit.Assert.assertNotNull(fileTime8);
    }

    @Test
    public void test1359() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1359");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream8 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 4);
        byte[] byteArray10 = zstdCompressorOutputStream8.writeUsAsciiRaw("org.apache.commons.compress.harmony.pack200.Segment$PassException");
        org.apache.commons.compress.utils.ByteUtils.OutputStreamByteConsumer outputStreamByteConsumer11 = new org.apache.commons.compress.utils.ByteUtils.OutputStreamByteConsumer((java.io.OutputStream) zstdCompressorOutputStream8);
        zstdCompressorOutputStream8.finish();
        // The following exception was thrown during execution in test generation
        try {
            zstdCompressorOutputStream8.close();
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: No current CPIO entry");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(byteArray10);
    }

    @Test
    public void test1360() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1360");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry1 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("ustar\000");
    }

    @Test
    public void test1361() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1361");
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader0 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        segmentHeader0.setCp_Int_count(96);
        boolean boolean3 = segmentHeader0.have_class_flags_hi();
        segmentHeader0.setHave_class_flags_hi(true);
        java.io.OutputStream outputStream6 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream8 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream6, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry9 = null;
        boolean boolean10 = cpioArchiveOutputStream8.canWriteEntryData(archiveEntry9);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream12 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream8, 135);
        fixedLengthBlockOutputStream12.write(1024);
        org.apache.commons.compress.compressors.xz.XZCompressorOutputStream xZCompressorOutputStream16 = new org.apache.commons.compress.compressors.xz.XZCompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream12, (int) (short) 1);
        segmentHeader0.pack((java.io.OutputStream) xZCompressorOutputStream16);
        byte[] byteArray19 = xZCompressorOutputStream16.writeUtf8("pass");
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertNotNull(byteArray19);
        org.junit.Assert.assertArrayEquals(byteArray19, new byte[] { (byte) 112, (byte) 97, (byte) 115, (byte) 115 });
    }

    @Test
    public void test1362() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1362");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec1 = org.apache.commons.compress.harmony.pack200.CodecEncoding.getCanonicalCodec(3);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec2 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean3 = bHSDCodec2.isDelta();
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec4 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean5 = bHSDCodec4.isDelta();
        byte[] byteArray7 = bHSDCodec4.encode((int) '#');
        int int8 = bHSDCodec4.getS();
        org.apache.commons.compress.harmony.pack200.PopulationCodec populationCodec9 = new org.apache.commons.compress.harmony.pack200.PopulationCodec((org.apache.commons.compress.harmony.pack200.Codec) bHSDCodec1, (org.apache.commons.compress.harmony.pack200.Codec) bHSDCodec2, (org.apache.commons.compress.harmony.pack200.Codec) bHSDCodec4);
        boolean boolean10 = bHSDCodec4.isDelta();
        bHSDCodec4.lastBandLength = 263;
        org.junit.Assert.assertNotNull(bHSDCodec1);
        org.junit.Assert.assertNotNull(bHSDCodec2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(bHSDCodec4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) 35 });
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test1363() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1363");
        java.util.jar.JarFile jarFile0 = null;
        java.io.OutputStream outputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream3 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream1, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry4 = null;
        boolean boolean5 = cpioArchiveOutputStream3.canWriteEntryData(archiveEntry4);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream7 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream3, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream9 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream7, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap10 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream11 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream9, strMap10);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec12 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean13 = bHSDCodec12.isDelta();
        byte[] byteArray15 = bHSDCodec12.encode((int) '#');
        pack200CompressorOutputStream11.write(byteArray15);
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions17 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        org.apache.commons.compress.harmony.pack200.Archive archive18 = new org.apache.commons.compress.harmony.pack200.Archive(jarFile0, (java.io.OutputStream) pack200CompressorOutputStream11, packingOptions17);
        boolean boolean19 = packingOptions17.isKeepFileOrder();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(bHSDCodec12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] { (byte) 35 });
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
    }

    @Test
    public void test1364() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1364");
        org.apache.commons.compress.harmony.pack200.Segment segment2 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands4 = new org.apache.commons.compress.harmony.pack200.CpBands(segment2, (int) (byte) 2);
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS5 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.pack200.CPConstant<?> wildcardCPConstant6 = cpBands4.getConstant((java.lang.Object) oS5);
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader7 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        org.apache.commons.compress.harmony.pack200.MetadataBandGroup metadataBandGroup9 = new org.apache.commons.compress.harmony.pack200.MetadataBandGroup("LocalVariableTypeTable", 16, cpBands4, segmentHeader7, 263);
        segmentHeader7.setCp_Double_count((int) (byte) 0);
        segmentHeader7.setFile_count(10);
        int[] intArray25 = new int[] { ' ', (byte) -1 };
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm iMethodRefForm26 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm((int) (byte) -1, "", intArray25);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm classRefForm27 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm((int) (short) 0, "jar", intArray25);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.StringRefForm stringRefForm29 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.StringRefForm(1, "splitting", intArray25, true);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.LongForm longForm30 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.LongForm(17, "ACC_STATIC", intArray25);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec31 = null;
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray32 = segmentHeader7.encodeBandInt("\002?\002\n\001", intArray25, bHSDCodec31);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + oS5 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS5.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertNull(wildcardCPConstant6);
        org.junit.Assert.assertNotNull(intArray25);
        org.junit.Assert.assertArrayEquals(intArray25, new int[] { 32, (-1) });
    }

    @Test
    public void test1365() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1365");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_4 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_6 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition attributeDefinition7 = new org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition(4096, 493, cPUTF8_4, cPUTF8_6);
        org.apache.commons.compress.harmony.pack200.Segment segment8 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands10 = new org.apache.commons.compress.harmony.pack200.CpBands(segment8, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPMethodOrField cPMethodOrField14 = cpBands10.getCPMethod("", "zstd", "ACC_STRICT");
        org.apache.commons.compress.harmony.pack200.CPClass cPClass16 = cpBands10.getCPClass("true");
        boolean boolean17 = cPClass16.isInnerClass();
        org.apache.commons.compress.harmony.pack200.CPClass[] cPClassArray18 = new org.apache.commons.compress.harmony.pack200.CPClass[] { cPClass16 };
        java.util.ArrayList<org.apache.commons.compress.harmony.pack200.CPClass> cPClassList19 = new java.util.ArrayList<org.apache.commons.compress.harmony.pack200.CPClass>();
        boolean boolean20 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.pack200.CPClass>) cPClassList19, cPClassArray18);
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature21 = new org.apache.commons.compress.harmony.pack200.CPSignature("pack.deflate.hint.lzma.lzma", cPUTF8_4, (java.util.List<org.apache.commons.compress.harmony.pack200.CPClass>) cPClassList19);
        int int22 = cPSignature21.getIndexInCpUtf8();
        org.junit.Assert.assertNotNull(cPMethodOrField14);
        org.junit.Assert.assertNotNull(cPClass16);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNotNull(cPClassArray18);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + (-1) + "'", int22 == (-1));
    }

    @Test
    public void test1366() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1366");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_4 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_6 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition attributeDefinition7 = new org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition(4096, 493, cPUTF8_4, cPUTF8_6);
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_8 = attributeDefinition7.name;
        org.apache.commons.compress.harmony.pack200.Segment segment9 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands11 = new org.apache.commons.compress.harmony.pack200.CpBands(segment9, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPMethodOrField cPMethodOrField15 = cpBands11.getCPMethod("", "zstd", "ACC_STRICT");
        org.apache.commons.compress.harmony.pack200.CPClass cPClass17 = cpBands11.getCPClass("true");
        boolean boolean18 = cPClass17.isInnerClass();
        org.apache.commons.compress.harmony.pack200.CPClass[] cPClassArray19 = new org.apache.commons.compress.harmony.pack200.CPClass[] { cPClass17 };
        java.util.ArrayList<org.apache.commons.compress.harmony.pack200.CPClass> cPClassList20 = new java.util.ArrayList<org.apache.commons.compress.harmony.pack200.CPClass>();
        boolean boolean21 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.pack200.CPClass>) cPClassList20, cPClassArray19);
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature22 = new org.apache.commons.compress.harmony.pack200.CPSignature("splitting", cPUTF8_8, (java.util.List<org.apache.commons.compress.harmony.pack200.CPClass>) cPClassList20);
        int int23 = cPUTF8_8.getIndex();
        org.junit.Assert.assertNotNull(cPUTF8_8);
        org.junit.Assert.assertNotNull(cPMethodOrField15);
        org.junit.Assert.assertNotNull(cPClass17);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNotNull(cPClassArray19);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + true + "'", boolean21 == true);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
    }

    @Test
    public void test1367() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1367");
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions0 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        packingOptions0.setLogFile("ar");
        packingOptions0.setVerbose(true);
        java.lang.String str5 = packingOptions0.getLogFile();
        packingOptions0.setSegmentLimit((long) 11);
        boolean boolean8 = packingOptions0.isStripDebug();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "ar" + "'", str5, "ar");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test1368() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1368");
        org.apache.commons.compress.harmony.unpack200.IcTuple icTuple8 = new org.apache.commons.compress.harmony.unpack200.IcTuple("ACC_SYNTHETIC", 32771, "ACC_TRANSIENT", "ACC_PROTECTED", (int) '4', 8192, 17, 4);
        java.lang.String str9 = icTuple8.outerClassString();
        java.lang.String str10 = icTuple8.getC();
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ACC_TRANSIENT" + "'", str9, "ACC_TRANSIENT");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "ACC_SYNTHETIC" + "'", str10, "ACC_SYNTHETIC");
    }

    @Test
    public void test1369() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1369");
        java.lang.String str0 = org.apache.commons.compress.java.util.jar.Pack200.Packer.STRIP;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "strip" + "'", str0, "strip");
    }

    @Test
    public void test1370() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1370");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        boolean boolean1 = sevenZArchiveEntry0.getHasCrc();
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry2 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        java.lang.String str3 = sevenZArchiveEntry2.getName();
        sevenZArchiveEntry2.setHasCrc(false);
        boolean boolean6 = sevenZArchiveEntry2.getHasWindowsAttributes();
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry9 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        java.lang.String str10 = dumpArchiveEntry9.toString();
        int int11 = dumpArchiveEntry9.getHeaderHoles();
        java.util.Date date12 = dumpArchiveEntry9.getAccessTime();
        sevenZArchiveEntry2.setCreationDate(date12);
        sevenZArchiveEntry0.setAccessDate(date12);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNull(str3);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "jar" + "'", str10, "jar");
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertNotNull(date12);
        org.junit.Assert.assertEquals(date12.toString(), "Thu Jan 01 10:00:00 AEST 1970");
    }

    @Test
    public void test1371() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1371");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        cpioArchiveInputStream1.reset();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream6 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream1, (long) 'a', 0);
        int int7 = cRC32VerifyingInputStream6.available();
        long long8 = cRC32VerifyingInputStream6.getBytesRemaining();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipArchiveInputStream zipArchiveInputStream10 = new org.apache.commons.compress.archivers.zip.ZipArchiveInputStream((java.io.InputStream) cRC32VerifyingInputStream6, "Exceptions: ");
            org.junit.Assert.fail("Expected exception of type java.nio.charset.IllegalCharsetNameException; message: Exceptions: ");
        } catch (java.nio.charset.IllegalCharsetNameException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 1 + "'", int7 == 1);
        org.junit.Assert.assertTrue("'" + long8 + "' != '" + 97L + "'", long8 == 97L);
    }

    @Test
    public void test1372() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1372");
        org.apache.commons.compress.harmony.pack200.BHSDCodec[] bHSDCodecArray0 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaUnsignedCodecs4;
        org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaUnsignedCodecs2 = bHSDCodecArray0;
        org.junit.Assert.assertNotNull(bHSDCodecArray0);
    }

    @Test
    public void test1373() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1373");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream8 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 4);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream10 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 32);
        // The following exception was thrown during execution in test generation
        try {
            cpioArchiveOutputStream2.closeArchiveEntry();
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: Trying to close non-existent entry");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test1374() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1374");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_2);
        java.lang.String str4 = cPUTF8_2.toString();
        org.apache.commons.compress.java.util.jar.Pack200.Unpacker unpacker5 = org.apache.commons.compress.java.util.jar.Pack200.newUnpacker();
        boolean boolean6 = cPUTF8_2.equals((java.lang.Object) unpacker5);
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp7 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime8 = null;
        x5455_ExtendedTimestamp7.setAccessFileTime(fileTime8);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort10 = x5455_ExtendedTimestamp7.getLocalFileDataLength();
        boolean boolean11 = cPUTF8_2.equals((java.lang.Object) zipShort10);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "UTF-8:splitting" + "'", str4, "UTF-8:splitting");
        org.junit.Assert.assertNotNull(unpacker5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(zipShort10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test1375() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1375");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_2);
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS5 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue elementValue6 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue((int) (byte) 7, (java.lang.Object) oS5);
        java.util.List<java.lang.Object> objList7 = elementValue6.getClassFileEntries();
        boolean boolean8 = cPUTF8_2.equals((java.lang.Object) elementValue6);
        java.io.DataOutputStream dataOutputStream9 = null;
        // The following exception was thrown during execution in test generation
        try {
            elementValue6.writeBody(dataOutputStream9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + oS5 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS5.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertNotNull(objList7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test1376() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1376");
        java.util.jar.JarInputStream jarInputStream0 = null;
        java.util.jar.JarFile jarFile1 = null;
        java.io.OutputStream outputStream2 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream4 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream2, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry5 = null;
        boolean boolean6 = cpioArchiveOutputStream4.canWriteEntryData(archiveEntry5);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream8 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream4, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream10 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream8, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap11 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream12 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream10, strMap11);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec13 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean14 = bHSDCodec13.isDelta();
        byte[] byteArray16 = bHSDCodec13.encode((int) '#');
        pack200CompressorOutputStream12.write(byteArray16);
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions18 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        org.apache.commons.compress.harmony.pack200.Archive archive19 = new org.apache.commons.compress.harmony.pack200.Archive(jarFile1, (java.io.OutputStream) pack200CompressorOutputStream12, packingOptions18);
        java.util.jar.JarFile jarFile20 = null;
        java.io.OutputStream outputStream21 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream23 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream21, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry24 = null;
        boolean boolean25 = cpioArchiveOutputStream23.canWriteEntryData(archiveEntry24);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream27 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream23, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream29 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream27, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap30 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream31 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream29, strMap30);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec32 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean33 = bHSDCodec32.isDelta();
        byte[] byteArray35 = bHSDCodec32.encode((int) '#');
        pack200CompressorOutputStream31.write(byteArray35);
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions37 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        org.apache.commons.compress.harmony.pack200.Archive archive38 = new org.apache.commons.compress.harmony.pack200.Archive(jarFile20, (java.io.OutputStream) pack200CompressorOutputStream31, packingOptions37);
        org.apache.commons.compress.harmony.pack200.Archive archive39 = new org.apache.commons.compress.harmony.pack200.Archive(jarInputStream0, (java.io.OutputStream) pack200CompressorOutputStream12, packingOptions37);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream41 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) pack200CompressorOutputStream12, (int) (short) 4);
        org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream framedLZ4CompressorOutputStream42 = new org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream((java.io.OutputStream) pack200CompressorOutputStream12);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertNotNull(bHSDCodec13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(byteArray16);
        org.junit.Assert.assertArrayEquals(byteArray16, new byte[] { (byte) 35 });
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + true + "'", boolean25 == true);
        org.junit.Assert.assertNotNull(bHSDCodec32);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertNotNull(byteArray35);
        org.junit.Assert.assertArrayEquals(byteArray35, new byte[] { (byte) 35 });
    }

    @Test
    public void test1377() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1377");
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader0 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        boolean boolean1 = segmentHeader0.have_method_flags_hi();
        java.io.OutputStream outputStream2 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream4 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream2, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry5 = null;
        boolean boolean6 = cpioArchiveOutputStream4.canWriteEntryData(archiveEntry5);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream8 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream4, 135);
        org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream framedLZ4CompressorOutputStream9 = new org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream8);
        segmentHeader0.pack((java.io.OutputStream) framedLZ4CompressorOutputStream9);
        segmentHeader0.setCp_Utf8_count(32768);
        segmentHeader0.setHave_code_flags_hi(true);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test1378() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1378");
        int[] intArray6 = new int[] { ' ', (byte) -1 };
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm iMethodRefForm7 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm((int) (byte) -1, "", intArray6);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm classRefForm8 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm((int) (short) 0, "jar", intArray6);
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode10 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int11 = byteCode10.getByteCodeIndex();
        int[] intArray12 = new int[] {};
        int[] intArray13 = new int[] {};
        int[] intArray14 = new int[] {};
        int[][] intArray15 = new int[][] { intArray12, intArray13, intArray14 };
        byteCode10.setNestedPositions(intArray15);
        int[] intArray17 = byteCode10.getRewrite();
        int[][] intArray18 = byteCode10.getNestedPositions();
        org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager operandManager19 = null;
        // The following exception was thrown during execution in test generation
        try {
            classRefForm8.setByteCodeOperands(byteCode10, operandManager19, (int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertArrayEquals(intArray6, new int[] { 32, (-1) });
        org.junit.Assert.assertNotNull(byteCode10);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + (-1) + "'", int11 == (-1));
        org.junit.Assert.assertNotNull(intArray12);
        org.junit.Assert.assertArrayEquals(intArray12, new int[] {});
        org.junit.Assert.assertNotNull(intArray13);
        org.junit.Assert.assertArrayEquals(intArray13, new int[] {});
        org.junit.Assert.assertNotNull(intArray14);
        org.junit.Assert.assertArrayEquals(intArray14, new int[] {});
        org.junit.Assert.assertNotNull(intArray15);
        org.junit.Assert.assertNotNull(intArray17);
        org.junit.Assert.assertArrayEquals(intArray17, new int[] { 255 });
        org.junit.Assert.assertNotNull(intArray18);
    }

    @Test
    public void test1379() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1379");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        int int5 = cpioArchiveOutputStream2.getCount();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test1380() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1380");
        java.util.jar.JarFile jarFile0 = null;
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader1 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        segmentHeader1.setCp_Int_count(96);
        boolean boolean4 = segmentHeader1.have_class_flags_hi();
        segmentHeader1.setHave_class_flags_hi(true);
        java.io.OutputStream outputStream7 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream9 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream7, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry10 = null;
        boolean boolean11 = cpioArchiveOutputStream9.canWriteEntryData(archiveEntry10);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream13 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream9, 135);
        fixedLengthBlockOutputStream13.write(1024);
        org.apache.commons.compress.compressors.xz.XZCompressorOutputStream xZCompressorOutputStream17 = new org.apache.commons.compress.compressors.xz.XZCompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream13, (int) (short) 1);
        segmentHeader1.pack((java.io.OutputStream) xZCompressorOutputStream17);
        java.util.jar.JarFile jarFile19 = null;
        java.io.OutputStream outputStream20 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream22 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream20, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry23 = null;
        boolean boolean24 = cpioArchiveOutputStream22.canWriteEntryData(archiveEntry23);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream26 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream22, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream28 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream26, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap29 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream30 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream28, strMap29);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec31 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean32 = bHSDCodec31.isDelta();
        byte[] byteArray34 = bHSDCodec31.encode((int) '#');
        pack200CompressorOutputStream30.write(byteArray34);
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions36 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        org.apache.commons.compress.harmony.pack200.Archive archive37 = new org.apache.commons.compress.harmony.pack200.Archive(jarFile19, (java.io.OutputStream) pack200CompressorOutputStream30, packingOptions36);
        boolean boolean39 = packingOptions36.isPassFile("LZ4 Parameters with BlockSize null, withContentChecksum true, withBlockChecksum false, withBlockDependency false");
        org.apache.commons.compress.harmony.pack200.Archive archive40 = new org.apache.commons.compress.harmony.pack200.Archive(jarFile0, (java.io.OutputStream) xZCompressorOutputStream17, packingOptions36);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
        org.junit.Assert.assertNotNull(bHSDCodec31);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNotNull(byteArray34);
        org.junit.Assert.assertArrayEquals(byteArray34, new byte[] { (byte) 35 });
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
    }

    @Test
    public void test1381() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1381");
        java.nio.file.Path path0 = null;
        org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier defaultBackingStoreSupplier1 = new org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier(path0);
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore2 = defaultBackingStoreSupplier1.get();
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore3 = defaultBackingStoreSupplier1.get();
        org.junit.Assert.assertNotNull(scatterGatherBackingStore2);
        org.junit.Assert.assertNotNull(scatterGatherBackingStore3);
    }

    @Test
    public void test1382() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1382");
        org.apache.commons.compress.archivers.zip.ZipLong zipLong0 = org.apache.commons.compress.archivers.zip.ZipLong.SINGLE_SEGMENT_SPLIT_MARKER;
        java.lang.String str1 = zipLong0.toString();
        org.junit.Assert.assertNotNull(zipLong0);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "ZipLong value: 808471376" + "'", str1, "ZipLong value: 808471376");
    }

    @Test
    public void test1383() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1383");
        java.lang.String str0 = org.apache.commons.compress.harmony.unpack200.AttributeLayout.ACC_ABSTRACT;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "ACC_ABSTRACT" + "'", str0, "ACC_ABSTRACT");
    }

    @Test
    public void test1384() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1384");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec0 = org.apache.commons.compress.harmony.pack200.Codec.SIGNED5;
        int int1 = org.apache.commons.compress.harmony.pack200.CodecEncoding.getSpecifierForDefaultCodec(bHSDCodec0);
        org.junit.Assert.assertNotNull(bHSDCodec0);
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 27 + "'", int1 == 27);
    }

    @Test
    public void test1385() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1385");
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder0 = new org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder();
        java.io.OutputStream outputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream3 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream1, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry4 = null;
        boolean boolean5 = cpioArchiveOutputStream3.canWriteEntryData(archiveEntry4);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream7 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream3, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream9 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream7, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap10 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream11 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream9, strMap10);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec12 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean13 = bHSDCodec12.isDelta();
        byte[] byteArray15 = bHSDCodec12.encode((int) '#');
        pack200CompressorOutputStream11.write(byteArray15);
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder17 = builder0.setOutputStream((java.io.OutputStream) pack200CompressorOutputStream11);
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder19 = builder0.setUseDefaultNameForUnnamedEntries(false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(bHSDCodec12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] { (byte) 35 });
        org.junit.Assert.assertNotNull(builder17);
        org.junit.Assert.assertNotNull(builder19);
    }

    @Test
    public void test1386() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1386");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec1 = org.apache.commons.compress.harmony.pack200.CodecEncoding.getCanonicalCodec(3);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec2 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean3 = bHSDCodec2.isDelta();
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec4 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean5 = bHSDCodec4.isDelta();
        byte[] byteArray7 = bHSDCodec4.encode((int) '#');
        int int8 = bHSDCodec4.getS();
        org.apache.commons.compress.harmony.pack200.PopulationCodec populationCodec9 = new org.apache.commons.compress.harmony.pack200.PopulationCodec((org.apache.commons.compress.harmony.pack200.Codec) bHSDCodec1, (org.apache.commons.compress.harmony.pack200.Codec) bHSDCodec2, (org.apache.commons.compress.harmony.pack200.Codec) bHSDCodec4);
        org.apache.commons.compress.harmony.pack200.Codec codec10 = populationCodec9.getTokenCodec();
        org.junit.Assert.assertNotNull(bHSDCodec1);
        org.junit.Assert.assertNotNull(bHSDCodec2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(bHSDCodec4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) 35 });
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(codec10);
    }

    @Test
    public void test1387() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1387");
        java.io.InputStream inputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream1);
        byte[] byteArray3 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream2);
        org.apache.commons.compress.archivers.tar.TarFile tarFile4 = new org.apache.commons.compress.archivers.tar.TarFile(byteArray3);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean7 = org.apache.commons.compress.utils.ArchiveUtils.matchAsciiBuffer("hi!.lzma", byteArray3, 1024, (int) (byte) 75);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 1024");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] {});
    }

    @Test
    public void test1388() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1388");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream8 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 4);
        java.io.OutputStream outputStream9 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream11 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream9, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream12 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream11);
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker14 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray15 = jarMarker14.getCentralDirectoryData();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField16 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger17 = zip64ExtendedInformationExtraField16.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger18 = null;
        zip64ExtendedInformationExtraField16.setSize(zipEightByteInteger18);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField20 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField21 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger22 = zip64ExtendedInformationExtraField21.getCompressedSize();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField23 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger24 = zip64ExtendedInformationExtraField23.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger25 = null;
        zip64ExtendedInformationExtraField23.setSize(zipEightByteInteger25);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField27 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger28 = zip64ExtendedInformationExtraField27.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger29 = null;
        zip64ExtendedInformationExtraField27.setSize(zipEightByteInteger29);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField31 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipExtraField[] zipExtraFieldArray32 = new org.apache.commons.compress.archivers.zip.ZipExtraField[] { zip64ExtendedInformationExtraField16, zip64ExtendedInformationExtraField20, zip64ExtendedInformationExtraField21, zip64ExtendedInformationExtraField23, zip64ExtendedInformationExtraField27, zip64ExtendedInformationExtraField31 };
        byte[] byteArray33 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.mergeLocalFileDataData(zipExtraFieldArray32);
        boolean boolean34 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray15, byteArray33);
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField37 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField("ustar\000", byteArray33, 0, 9);
        blockLZ4CompressorOutputStream12.prefill(byteArray33, 21, (int) '4');
        int int41 = org.apache.commons.compress.archivers.zip.ZipShort.getValue(byteArray33);
        // The following exception was thrown during execution in test generation
        try {
            cpioArchiveOutputStream2.write(byteArray33, 0, (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: null");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] {});
        org.junit.Assert.assertNull(zipEightByteInteger17);
        org.junit.Assert.assertNull(zipEightByteInteger22);
        org.junit.Assert.assertNull(zipEightByteInteger24);
        org.junit.Assert.assertNull(zipEightByteInteger28);
        org.junit.Assert.assertNotNull(zipExtraFieldArray32);
        org.junit.Assert.assertNotNull(byteArray33);
        org.junit.Assert.assertArrayEquals(byteArray33, new byte[] { (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertTrue("'" + int41 + "' != '" + 1 + "'", int41 == 1);
    }

    @Test
    public void test1389() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1389");
        int int0 = org.apache.commons.compress.harmony.unpack200.SegmentConstantPool.SIGNATURE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 8 + "'", int0 == 8);
    }

    @Test
    public void test1390() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1390");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        java.lang.String str1 = sevenZArchiveEntry0.getName();
        sevenZArchiveEntry0.setHasCrc(false);
        boolean boolean4 = sevenZArchiveEntry0.getHasWindowsAttributes();
        sevenZArchiveEntry0.setWindowsAttributes(1000);
        sevenZArchiveEntry0.setDirectory(true);
        sevenZArchiveEntry0.setWindowsAttributes((int) (byte) 88);
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test1391() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1391");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file3 = tarArchiveEntry2.getFile();
        int int4 = tarArchiveEntry2.getDevMinor();
        tarArchiveEntry2.setUserName("UTF-8:splitting");
        tarArchiveEntry2.setIds(493, (int) (byte) 2);
        boolean boolean10 = tarArchiveEntry2.isDirectory();
        java.lang.String str12 = tarArchiveEntry2.getExtraPaxHeader("pass");
        boolean boolean13 = tarArchiveEntry2.isCheckSumOK();
        tarArchiveEntry2.setNames("ACC_ANNOTATION", "");
        boolean boolean17 = tarArchiveEntry2.isGlobalPaxHeader();
        org.junit.Assert.assertNull(file3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNull(str12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test1392() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1392");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("", true);
        tarArchiveEntry2.setMode(16877);
        java.nio.file.attribute.FileTime fileTime5 = tarArchiveEntry2.getStatusChangeTime();
        byte[] byteArray7 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(0L);
        boolean boolean9 = org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.matches(byteArray7, 52);
        org.apache.commons.compress.archivers.tar.TarFile tarFile10 = new org.apache.commons.compress.archivers.tar.TarFile(byteArray7);
        // The following exception was thrown during execution in test generation
        try {
            tarArchiveEntry2.parseTarHeader(byteArray7);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 100");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(fileTime5);
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) 0, (byte) 0, (byte) 33, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test1393() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1393");
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker0 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray1 = jarMarker0.getCentralDirectoryData();
        byte[] byteArray2 = jarMarker0.getLocalFileDataData();
        boolean boolean4 = org.apache.commons.compress.compressors.xz.XZCompressorInputStream.matches(byteArray2, 0);
        boolean boolean6 = org.apache.commons.compress.archivers.dump.DumpArchiveInputStream.matches(byteArray2, 17);
        org.apache.commons.compress.archivers.tar.TarFile tarFile7 = new org.apache.commons.compress.archivers.tar.TarFile(byteArray2);
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry10 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file11 = tarArchiveEntry10.getFile();
        int int12 = tarArchiveEntry10.getDevMinor();
        tarArchiveEntry10.setUserName("UTF-8:splitting");
        tarArchiveEntry10.setUserId(12);
        java.io.InputStream inputStream17 = tarFile7.getInputStream(tarArchiveEntry10);
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry20 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file21 = tarArchiveEntry20.getFile();
        boolean boolean22 = tarArchiveEntry20.isGNUSparse();
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry23 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date24 = arjArchiveEntry23.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong25 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date24);
        tarArchiveEntry20.setModTime(date24);
        java.nio.file.attribute.FileTime fileTime27 = tarArchiveEntry20.getLastModifiedTime();
        tarArchiveEntry10.setLastModifiedTime(fileTime27);
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry29 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        java.lang.String str30 = sevenZArchiveEntry29.getName();
        sevenZArchiveEntry29.setHasCrc(false);
        boolean boolean33 = sevenZArchiveEntry29.getHasWindowsAttributes();
        sevenZArchiveEntry29.setHasLastModifiedDate(true);
        java.lang.String str36 = sevenZArchiveEntry29.getName();
        sevenZArchiveEntry29.setWindowsAttributes((int) '4');
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker39 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray40 = jarMarker39.getCentralDirectoryData();
        byte[] byteArray41 = jarMarker39.getLocalFileDataData();
        boolean boolean43 = org.apache.commons.compress.compressors.xz.XZCompressorInputStream.matches(byteArray41, 0);
        boolean boolean45 = org.apache.commons.compress.archivers.dump.DumpArchiveInputStream.matches(byteArray41, 17);
        org.apache.commons.compress.archivers.tar.TarFile tarFile46 = new org.apache.commons.compress.archivers.tar.TarFile(byteArray41);
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry49 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file50 = tarArchiveEntry49.getFile();
        int int51 = tarArchiveEntry49.getDevMinor();
        tarArchiveEntry49.setUserName("UTF-8:splitting");
        tarArchiveEntry49.setUserId(12);
        java.io.InputStream inputStream56 = tarFile46.getInputStream(tarArchiveEntry49);
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry59 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file60 = tarArchiveEntry59.getFile();
        boolean boolean61 = tarArchiveEntry59.isGNUSparse();
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry62 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date63 = arjArchiveEntry62.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong64 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date63);
        tarArchiveEntry59.setModTime(date63);
        java.nio.file.attribute.FileTime fileTime66 = tarArchiveEntry59.getLastModifiedTime();
        tarArchiveEntry49.setLastModifiedTime(fileTime66);
        sevenZArchiveEntry29.setLastModifiedTime(fileTime66);
        tarArchiveEntry10.setModTime(fileTime66);
        tarArchiveEntry10.setName("arj");
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] {});
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNull(file11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(inputStream17);
        org.junit.Assert.assertNull(file21);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(date24);
        org.junit.Assert.assertEquals(date24.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong25);
        org.junit.Assert.assertNotNull(fileTime27);
        org.junit.Assert.assertNull(str30);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertNull(str36);
        org.junit.Assert.assertNotNull(byteArray40);
        org.junit.Assert.assertArrayEquals(byteArray40, new byte[] {});
        org.junit.Assert.assertNotNull(byteArray41);
        org.junit.Assert.assertArrayEquals(byteArray41, new byte[] {});
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
        org.junit.Assert.assertNull(file50);
        org.junit.Assert.assertTrue("'" + int51 + "' != '" + 0 + "'", int51 == 0);
        org.junit.Assert.assertNotNull(inputStream56);
        org.junit.Assert.assertNull(file60);
        org.junit.Assert.assertTrue("'" + boolean61 + "' != '" + false + "'", boolean61 == false);
        org.junit.Assert.assertNotNull(date63);
        org.junit.Assert.assertEquals(date63.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong64);
        org.junit.Assert.assertNotNull(fileTime66);
    }

    @Test
    public void test1394() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1394");
        org.apache.commons.compress.compressors.gzip.GzipParameters gzipParameters0 = new org.apache.commons.compress.compressors.gzip.GzipParameters();
        gzipParameters0.setOperatingSystem(6);
        java.lang.String str3 = gzipParameters0.getFilename();
        gzipParameters0.setFilename("ACC_ANNOTATION");
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test1395() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1395");
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader0 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        java.io.OutputStream outputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream3 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream1, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry4 = null;
        boolean boolean5 = cpioArchiveOutputStream3.canWriteEntryData(archiveEntry4);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream7 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream3, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream9 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream7, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap10 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream11 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream9, strMap10);
        segmentHeader0.pack((java.io.OutputStream) fixedLengthBlockOutputStream9);
        segmentHeader0.setCp_Double_count(135);
        segmentHeader0.setFile_count(476);
        segmentHeader0.addMajorVersion((int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test1396() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1396");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime1 = null;
        x5455_ExtendedTimestamp0.setAccessFileTime(fileTime1);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = x5455_ExtendedTimestamp0.getLocalFileDataLength();
        java.lang.Object obj4 = x5455_ExtendedTimestamp0.clone();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong5 = x5455_ExtendedTimestamp0.getAccessTime();
        byte byte6 = x5455_ExtendedTimestamp0.getFlags();
        boolean boolean7 = x5455_ExtendedTimestamp0.isBit2_createTimePresent();
        byte[] byteArray8 = x5455_ExtendedTimestamp0.getLocalFileDataData();
        java.nio.file.attribute.FileTime fileTime9 = x5455_ExtendedTimestamp0.getAccessFileTime();
        org.junit.Assert.assertNotNull(zipShort3);
        org.junit.Assert.assertNotNull(obj4);
        org.junit.Assert.assertEquals(obj4.toString(), "0x5455 Zip Extra Field: Flags=0 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(obj4), "0x5455 Zip Extra Field: Flags=0 ");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj4), "0x5455 Zip Extra Field: Flags=0 ");
        org.junit.Assert.assertNull(zipLong5);
        org.junit.Assert.assertTrue("'" + byte6 + "' != '" + (byte) 0 + "'", byte6 == (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(byteArray8);
        org.junit.Assert.assertArrayEquals(byteArray8, new byte[] { (byte) 0 });
        org.junit.Assert.assertNull(fileTime9);
    }

    @Test
    public void test1397() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1397");
        org.apache.commons.compress.archivers.zip.ZipEncoding zipEncoding1 = org.apache.commons.compress.archivers.zip.ZipEncodingHelper.getZipEncoding("unpack.progress");
        org.junit.Assert.assertNotNull(zipEncoding1);
    }

    @Test
    public void test1398() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1398");
        byte[] byteArray2 = org.apache.commons.compress.utils.ArchiveUtils.toAsciiBytes("cpio");
        byte[] byteArray3 = org.apache.commons.compress.archivers.zip.ZipUtil.reverse(byteArray2);
        // The following exception was thrown during execution in test generation
        try {
            int int6 = org.apache.commons.compress.archivers.tar.TarUtils.formatOctalBytes((long) 32, byteArray3, 29127, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: 32=40 will not fit in octal number buffer of length -2");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) 111, (byte) 105, (byte) 112, (byte) 99 });
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 111, (byte) 105, (byte) 112, (byte) 99 });
    }

    @Test
    public void test1399() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1399");
        org.apache.commons.compress.harmony.pack200.Segment segment2 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands4 = new org.apache.commons.compress.harmony.pack200.CpBands(segment2, (int) (byte) 2);
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS5 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.pack200.CPConstant<?> wildcardCPConstant6 = cpBands4.getConstant((java.lang.Object) oS5);
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader7 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        org.apache.commons.compress.harmony.pack200.MetadataBandGroup metadataBandGroup9 = new org.apache.commons.compress.harmony.pack200.MetadataBandGroup("LocalVariableTypeTable", 16, cpBands4, segmentHeader7, 263);
        org.apache.commons.compress.harmony.pack200.Segment segment10 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.IcBands icBands11 = segment10.getIcBands();
        org.apache.commons.compress.harmony.pack200.ClassBands classBands12 = segment10.getClassBands();
        org.apache.commons.compress.harmony.pack200.BcBands bcBands14 = new org.apache.commons.compress.harmony.pack200.BcBands(cpBands4, segment10, 32782);
        org.objectweb.asm.Label label17 = null;
        org.objectweb.asm.Label label18 = null;
        org.objectweb.asm.Label[] labelArray19 = new org.objectweb.asm.Label[] { label18 };
        bcBands14.visitTableSwitchInsn(0, 96, label17, labelArray19);
        bcBands14.visitInsn((int) (byte) 55);
        org.junit.Assert.assertTrue("'" + oS5 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS5.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertNull(wildcardCPConstant6);
        org.junit.Assert.assertNull(icBands11);
        org.junit.Assert.assertNull(classBands12);
        org.junit.Assert.assertNotNull(labelArray19);
        org.junit.Assert.assertArrayEquals(labelArray19, new org.objectweb.asm.Label[] { null });
    }

    @Test
    public void test1400() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1400");
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader0 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        segmentHeader0.setCp_Int_count(96);
        boolean boolean3 = segmentHeader0.have_class_flags_hi();
        segmentHeader0.setHave_class_flags_hi(true);
        java.io.OutputStream outputStream6 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream8 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream6, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry9 = null;
        boolean boolean10 = cpioArchiveOutputStream8.canWriteEntryData(archiveEntry9);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream12 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream8, 135);
        fixedLengthBlockOutputStream12.write(1024);
        org.apache.commons.compress.compressors.xz.XZCompressorOutputStream xZCompressorOutputStream16 = new org.apache.commons.compress.compressors.xz.XZCompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream12, (int) (short) 1);
        segmentHeader0.pack((java.io.OutputStream) xZCompressorOutputStream16);
        int int18 = segmentHeader0.getArchive_modtime();
        segmentHeader0.setIc_count((int) (byte) 83);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 0 + "'", int18 == 0);
    }

    @Test
    public void test1401() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1401");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry6 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean7 = cpioArchiveOutputStream2.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry6);
        java.nio.file.attribute.FileTime fileTime8 = jarArchiveEntry6.getLastAccessTime();
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource commentSource9 = jarArchiveEntry6.getCommentSource();
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource commentSource10 = jarArchiveEntry6.getCommentSource();
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode extraFieldParsingMode11 = org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT;
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp12 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime13 = null;
        x5455_ExtendedTimestamp12.setAccessFileTime(fileTime13);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort15 = x5455_ExtendedTimestamp12.getHeaderId();
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField16 = extraFieldParsingMode11.createExtraField(zipShort15);
        jarArchiveEntry6.addAsFirstExtraField(zipExtraField16);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNull(fileTime8);
        org.junit.Assert.assertTrue("'" + commentSource9 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.COMMENT + "'", commentSource9.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.COMMENT));
        org.junit.Assert.assertTrue("'" + commentSource10 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.COMMENT + "'", commentSource10.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.COMMENT));
        org.junit.Assert.assertTrue("'" + extraFieldParsingMode11 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT + "'", extraFieldParsingMode11.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT));
        org.junit.Assert.assertNotNull(zipShort15);
        org.junit.Assert.assertNotNull(zipExtraField16);
    }

    @Test
    public void test1402() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1402");
        org.apache.commons.compress.harmony.unpack200.SegmentUtils segmentUtils0 = new org.apache.commons.compress.harmony.unpack200.SegmentUtils();
    }

    @Test
    public void test1403() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1403");
        org.apache.commons.compress.harmony.pack200.Segment.ASM_API = 28771;
    }

    @Test
    public void test1404() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1404");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS1 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue elementValue2 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue((int) (byte) 7, (java.lang.Object) oS1);
        java.util.List<java.lang.Object> objList3 = elementValue2.getClassFileEntries();
        java.util.List<java.lang.Object> objList4 = elementValue2.getClassFileEntries();
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute annotationDefaultAttribute5 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute(elementValue2);
        org.junit.Assert.assertTrue("'" + oS1 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS1.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertNotNull(objList3);
        org.junit.Assert.assertNotNull(objList4);
    }

    @Test
    public void test1405() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1405");
        // The following exception was thrown during execution in test generation
        try {
            java.nio.charset.Charset charset1 = org.apache.commons.compress.utils.Charsets.toCharset("\000\000");
            org.junit.Assert.fail("Expected exception of type java.nio.charset.IllegalCharsetNameException; message: ??");
        } catch (java.nio.charset.IllegalCharsetNameException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1406() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1406");
        java.lang.String str0 = org.apache.commons.compress.harmony.unpack200.AttributeLayout.ATTRIBUTE_LOCAL_VARIABLE_TABLE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "LocalVariableTable" + "'", str0, "LocalVariableTable");
    }

    @Test
    public void test1407() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1407");
        java.io.File file0 = null;
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.Builder builder1 = org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.builder();
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.Builder builder3 = builder1.withMaxMemoryLimitInKb(1000);
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions sevenZFileOptions4 = builder1.build();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZFile sevenZFile5 = new org.apache.commons.compress.archivers.sevenz.SevenZFile(file0, sevenZFileOptions4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder1);
        org.junit.Assert.assertNotNull(builder3);
        org.junit.Assert.assertNotNull(sevenZFileOptions4);
    }

    @Test
    public void test1408() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1408");
        org.apache.commons.compress.archivers.dump.DumpArchiveException dumpArchiveException1 = new org.apache.commons.compress.archivers.dump.DumpArchiveException();
        org.apache.commons.compress.archivers.ArchiveException archiveException2 = new org.apache.commons.compress.archivers.ArchiveException(" \000", (java.lang.Exception) dumpArchiveException1);
    }

    @Test
    public void test1409() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1409");
        boolean boolean1 = org.apache.commons.compress.archivers.zip.ZipUtil.isDosTime((long) (short) 10);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test1410() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1410");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        java.lang.String str3 = dumpArchiveEntry2.toString();
        java.util.Date date4 = dumpArchiveEntry2.getAccessTime();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "jar" + "'", str3, "jar");
        org.junit.Assert.assertNotNull(date4);
        org.junit.Assert.assertEquals(date4.toString(), "Thu Jan 01 10:00:00 AEST 1970");
    }

    @Test
    public void test1411() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1411");
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField0 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort1 = zip64ExtendedInformationExtraField0.getLocalFileDataLength();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger2 = zip64ExtendedInformationExtraField0.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger3 = null;
        zip64ExtendedInformationExtraField0.setCompressedSize(zipEightByteInteger3);
        org.apache.commons.compress.archivers.zip.ZipLong zipLong5 = zip64ExtendedInformationExtraField0.getDiskStartNumber();
        org.junit.Assert.assertNotNull(zipShort1);
        org.junit.Assert.assertNull(zipEightByteInteger2);
        org.junit.Assert.assertNull(zipLong5);
    }

    @Test
    public void test1412() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1412");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec0 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean1 = bHSDCodec0.isDelta();
        byte[] byteArray3 = bHSDCodec0.encode((int) '#');
        int int4 = bHSDCodec0.getS();
        int int5 = bHSDCodec0.getH();
        long long6 = bHSDCodec0.smallest();
        byte[] byteArray9 = bHSDCodec0.encode(420, 40960);
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel10 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(byteArray9);
        org.junit.Assert.assertNotNull(bHSDCodec0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 35 });
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 4 + "'", int5 == 4);
        org.junit.Assert.assertTrue("'" + long6 + "' != '" + 0L + "'", long6 == 0L);
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertArrayEquals(byteArray9, new byte[] { (byte) -4, (byte) 42 });
    }

    @Test
    public void test1413() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1413");
        java.util.jar.JarFile jarFile0 = null;
        java.io.OutputStream outputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream3 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream1, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry4 = null;
        boolean boolean5 = cpioArchiveOutputStream3.canWriteEntryData(archiveEntry4);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream7 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream3, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream9 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream3, 4);
        byte[] byteArray11 = zstdCompressorOutputStream9.writeUsAsciiRaw("org.apache.commons.compress.harmony.pack200.Segment$PassException");
        org.apache.commons.compress.utils.ByteUtils.OutputStreamByteConsumer outputStreamByteConsumer12 = new org.apache.commons.compress.utils.ByteUtils.OutputStreamByteConsumer((java.io.OutputStream) zstdCompressorOutputStream9);
        java.util.jar.JarFile jarFile13 = null;
        java.io.OutputStream outputStream14 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream16 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream14, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry17 = null;
        boolean boolean18 = cpioArchiveOutputStream16.canWriteEntryData(archiveEntry17);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream20 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream16, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream22 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream20, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap23 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream24 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream22, strMap23);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec25 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean26 = bHSDCodec25.isDelta();
        byte[] byteArray28 = bHSDCodec25.encode((int) '#');
        pack200CompressorOutputStream24.write(byteArray28);
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions30 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        org.apache.commons.compress.harmony.pack200.Archive archive31 = new org.apache.commons.compress.harmony.pack200.Archive(jarFile13, (java.io.OutputStream) pack200CompressorOutputStream24, packingOptions30);
        org.apache.commons.compress.harmony.pack200.Archive archive32 = new org.apache.commons.compress.harmony.pack200.Archive(jarFile0, (java.io.OutputStream) zstdCompressorOutputStream9, packingOptions30);
        boolean boolean33 = packingOptions30.isKeepDeflateHint();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(byteArray11);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertNotNull(bHSDCodec25);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertNotNull(byteArray28);
        org.junit.Assert.assertArrayEquals(byteArray28, new byte[] { (byte) 35 });
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + true + "'", boolean33 == true);
    }

    @Test
    public void test1414() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1414");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream5 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream1, (long) 1, (long) 148);
        java.io.OutputStream outputStream6 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream8 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream6, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry9 = null;
        boolean boolean10 = cpioArchiveOutputStream8.canWriteEntryData(archiveEntry9);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream12 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream8, 135);
        org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream framedLZ4CompressorOutputStream13 = new org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream12);
        framedLZ4CompressorOutputStream13.write(0);
        long long16 = org.apache.commons.compress.utils.IOUtils.copy((java.io.InputStream) cRC32VerifyingInputStream5, (java.io.OutputStream) framedLZ4CompressorOutputStream13);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarArchiveOutputStream tarArchiveOutputStream19 = new org.apache.commons.compress.archivers.tar.TarArchiveOutputStream((java.io.OutputStream) framedLZ4CompressorOutputStream13, 16, "ustar\000");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Block size must be a multiple of 512 bytes. Attempt to use set size of 16");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + long16 + "' != '" + 0L + "'", long16 == 0L);
    }

    @Test
    public void test1415() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1415");
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder0 = new org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder();
        java.io.OutputStream outputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream3 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream1, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry4 = null;
        boolean boolean5 = cpioArchiveOutputStream3.canWriteEntryData(archiveEntry4);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream7 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream3, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream9 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream7, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap10 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream11 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream9, strMap10);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec12 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean13 = bHSDCodec12.isDelta();
        byte[] byteArray15 = bHSDCodec12.encode((int) '#');
        pack200CompressorOutputStream11.write(byteArray15);
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder17 = builder0.setOutputStream((java.io.OutputStream) pack200CompressorOutputStream11);
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder19 = builder0.setMaxMemoryLimitKb(148);
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder21 = builder0.setPath("class-file version");
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker23 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray24 = jarMarker23.getCentralDirectoryData();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField25 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger26 = zip64ExtendedInformationExtraField25.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger27 = null;
        zip64ExtendedInformationExtraField25.setSize(zipEightByteInteger27);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField29 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField30 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger31 = zip64ExtendedInformationExtraField30.getCompressedSize();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField32 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger33 = zip64ExtendedInformationExtraField32.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger34 = null;
        zip64ExtendedInformationExtraField32.setSize(zipEightByteInteger34);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField36 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger37 = zip64ExtendedInformationExtraField36.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger38 = null;
        zip64ExtendedInformationExtraField36.setSize(zipEightByteInteger38);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField40 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipExtraField[] zipExtraFieldArray41 = new org.apache.commons.compress.archivers.zip.ZipExtraField[] { zip64ExtendedInformationExtraField25, zip64ExtendedInformationExtraField29, zip64ExtendedInformationExtraField30, zip64ExtendedInformationExtraField32, zip64ExtendedInformationExtraField36, zip64ExtendedInformationExtraField40 };
        byte[] byteArray42 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.mergeLocalFileDataData(zipExtraFieldArray41);
        boolean boolean43 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray24, byteArray42);
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField46 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField("ustar\000", byteArray42, 0, 9);
        byte[] byteArray47 = unicodeCommentExtraField46.getCentralDirectoryData();
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder48 = builder0.setPassword(byteArray47);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(bHSDCodec12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] { (byte) 35 });
        org.junit.Assert.assertNotNull(builder17);
        org.junit.Assert.assertNotNull(builder19);
        org.junit.Assert.assertNotNull(builder21);
        org.junit.Assert.assertNotNull(byteArray24);
        org.junit.Assert.assertArrayEquals(byteArray24, new byte[] {});
        org.junit.Assert.assertNull(zipEightByteInteger26);
        org.junit.Assert.assertNull(zipEightByteInteger31);
        org.junit.Assert.assertNull(zipEightByteInteger33);
        org.junit.Assert.assertNull(zipEightByteInteger37);
        org.junit.Assert.assertNotNull(zipExtraFieldArray41);
        org.junit.Assert.assertNotNull(byteArray42);
        org.junit.Assert.assertArrayEquals(byteArray42, new byte[] { (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
        org.junit.Assert.assertNotNull(byteArray47);
        org.junit.Assert.assertArrayEquals(byteArray47, new byte[] { (byte) 1, (byte) -53, (byte) 25, (byte) 21, (byte) -69, (byte) 117, (byte) 115, (byte) 116, (byte) 97, (byte) 114, (byte) 0 });
        org.junit.Assert.assertNotNull(builder48);
    }

    @Test
    public void test1416() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1416");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_2);
        java.lang.String str4 = cPUTF8_2.toString();
        org.apache.commons.compress.harmony.unpack200.MetadataBandGroup.setRiaAttributeName(cPUTF8_2);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_2);
        org.apache.commons.compress.harmony.unpack200.MetadataBandGroup.setRipaAttributeName(cPUTF8_2);
        org.apache.commons.compress.harmony.unpack200.bytecode.LineNumberTableAttribute.setAttributeName(cPUTF8_2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "UTF-8:splitting" + "'", str4, "UTF-8:splitting");
    }

    @Test
    public void test1417() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1417");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        fixedLengthBlockOutputStream6.write(1024);
        org.apache.commons.compress.compressors.lzma.LZMACompressorOutputStream lZMACompressorOutputStream9 = new org.apache.commons.compress.compressors.lzma.LZMACompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream6);
        lZMACompressorOutputStream9.flush();
        java.nio.file.Path path11 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long12 = lZMACompressorOutputStream9.write(path11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test1418() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1418");
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode extraFieldParsingMode0 = org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT;
        byte[] byteArray4 = new byte[] { (byte) 10, (byte) 10, (byte) -1 };
        boolean boolean6 = org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.matches(byteArray4, (int) (short) -1);
        byte[] byteArray7 = org.apache.commons.compress.archivers.zip.ZipUtil.reverse(byteArray4);
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField12 = extraFieldParsingMode0.onUnparseableExtraField(byteArray7, 100, 1024, false, 263);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField13 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort14 = zip64ExtendedInformationExtraField13.getLocalFileDataLength();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger15 = zip64ExtendedInformationExtraField13.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort16 = zip64ExtendedInformationExtraField13.getCentralDirectoryLength();
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField17 = extraFieldParsingMode0.createExtraField(zipShort16);
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField18 = null;
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker20 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray21 = jarMarker20.getCentralDirectoryData();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField22 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger23 = zip64ExtendedInformationExtraField22.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger24 = null;
        zip64ExtendedInformationExtraField22.setSize(zipEightByteInteger24);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField26 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField27 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger28 = zip64ExtendedInformationExtraField27.getCompressedSize();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField29 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger30 = zip64ExtendedInformationExtraField29.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger31 = null;
        zip64ExtendedInformationExtraField29.setSize(zipEightByteInteger31);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField33 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger34 = zip64ExtendedInformationExtraField33.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger35 = null;
        zip64ExtendedInformationExtraField33.setSize(zipEightByteInteger35);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField37 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipExtraField[] zipExtraFieldArray38 = new org.apache.commons.compress.archivers.zip.ZipExtraField[] { zip64ExtendedInformationExtraField22, zip64ExtendedInformationExtraField26, zip64ExtendedInformationExtraField27, zip64ExtendedInformationExtraField29, zip64ExtendedInformationExtraField33, zip64ExtendedInformationExtraField37 };
        byte[] byteArray39 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.mergeLocalFileDataData(zipExtraFieldArray38);
        boolean boolean40 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray21, byteArray39);
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField43 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField("ustar\000", byteArray39, 0, 9);
        byte[] byteArray44 = unicodeCommentExtraField43.getLocalFileDataData();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField48 = extraFieldParsingMode0.fill(zipExtraField18, byteArray44, 420, (int) (byte) 83, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + extraFieldParsingMode0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT + "'", extraFieldParsingMode0.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT));
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) -1, (byte) 10, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) -1, (byte) 10, (byte) 10 });
        org.junit.Assert.assertNull(zipExtraField12);
        org.junit.Assert.assertNotNull(zipShort14);
        org.junit.Assert.assertNull(zipEightByteInteger15);
        org.junit.Assert.assertNotNull(zipShort16);
        org.junit.Assert.assertNotNull(zipExtraField17);
        org.junit.Assert.assertNotNull(byteArray21);
        org.junit.Assert.assertArrayEquals(byteArray21, new byte[] {});
        org.junit.Assert.assertNull(zipEightByteInteger23);
        org.junit.Assert.assertNull(zipEightByteInteger28);
        org.junit.Assert.assertNull(zipEightByteInteger30);
        org.junit.Assert.assertNull(zipEightByteInteger34);
        org.junit.Assert.assertNotNull(zipExtraFieldArray38);
        org.junit.Assert.assertNotNull(byteArray39);
        org.junit.Assert.assertArrayEquals(byteArray39, new byte[] { (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertNotNull(byteArray44);
        org.junit.Assert.assertArrayEquals(byteArray44, new byte[] { (byte) 1, (byte) -53, (byte) 25, (byte) 21, (byte) -69, (byte) 117, (byte) 115, (byte) 116, (byte) 97, (byte) 114, (byte) 0 });
    }

    @Test
    public void test1419() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1419");
        java.io.File file0 = null;
        byte[] byteArray2 = org.apache.commons.compress.utils.ArchiveUtils.toAsciiBytes("ISO-8859-1");
        // The following exception was thrown during execution in test generation
        try {
            int int3 = org.apache.commons.compress.utils.IOUtils.read(file0, byteArray2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) 73, (byte) 83, (byte) 79, (byte) 45, (byte) 56, (byte) 56, (byte) 53, (byte) 57, (byte) 45, (byte) 49 });
    }

    @Test
    public void test1420() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1420");
        org.apache.commons.compress.archivers.zip.X0015_CertificateIdForFile x0015_CertificateIdForFile0 = new org.apache.commons.compress.archivers.zip.X0015_CertificateIdForFile();
        org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm hashAlgorithm1 = x0015_CertificateIdForFile0.getHashAlgorithm();
        byte[] byteArray2 = x0015_CertificateIdForFile0.getLocalFileDataData();
        int int3 = x0015_CertificateIdForFile0.getRecordCount();
        org.junit.Assert.assertNull(hashAlgorithm1);
        org.junit.Assert.assertNull(byteArray2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
    }

    @Test
    public void test1421() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1421");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream3 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream4 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        zipArchiveOutputStream4.setUseLanguageEncodingFlag(false);
        zipArchiveOutputStream4.setUseLanguageEncodingFlag(false);
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream9 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) zipArchiveOutputStream4);
        zipArchiveOutputStream4.setMethod(155);
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp12 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime13 = null;
        x5455_ExtendedTimestamp12.setAccessFileTime(fileTime13);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort15 = x5455_ExtendedTimestamp12.getLocalFileDataLength();
        java.nio.file.attribute.FileTime fileTime16 = x5455_ExtendedTimestamp12.getCreateFileTime();
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry17 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date18 = arjArchiveEntry17.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong19 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date18);
        x5455_ExtendedTimestamp12.setModifyTime(zipLong19);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort21 = x5455_ExtendedTimestamp12.getHeaderId();
        java.lang.String str22 = x5455_ExtendedTimestamp12.toString();
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp23 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime24 = null;
        x5455_ExtendedTimestamp23.setAccessFileTime(fileTime24);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort26 = x5455_ExtendedTimestamp23.getLocalFileDataLength();
        java.nio.file.attribute.FileTime fileTime27 = x5455_ExtendedTimestamp23.getCreateFileTime();
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry28 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date29 = arjArchiveEntry28.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong30 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date29);
        x5455_ExtendedTimestamp23.setModifyTime(zipLong30);
        x5455_ExtendedTimestamp12.setModifyTime(zipLong30);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort33 = x5455_ExtendedTimestamp12.getLocalFileDataLength();
        byte[] byteArray34 = x5455_ExtendedTimestamp12.getCentralDirectoryData();
        // The following exception was thrown during execution in test generation
        try {
            zipArchiveOutputStream4.write(byteArray34, (int) (short) 4, (int) (byte) 75);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: No current entry");
        } catch (java.lang.IllegalStateException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(zipShort15);
        org.junit.Assert.assertNull(fileTime16);
        org.junit.Assert.assertNotNull(date18);
        org.junit.Assert.assertEquals(date18.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong19);
        org.junit.Assert.assertNotNull(zipShort21);
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "0x5455 Zip Extra Field: Flags=1  Modify:[Mon Jan 26 10:44:48 AEST 1970] " + "'", str22, "0x5455 Zip Extra Field: Flags=1  Modify:[Mon Jan 26 10:44:48 AEST 1970] ");
        org.junit.Assert.assertNotNull(zipShort26);
        org.junit.Assert.assertNull(fileTime27);
        org.junit.Assert.assertNotNull(date29);
        org.junit.Assert.assertEquals(date29.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong30);
        org.junit.Assert.assertNotNull(zipShort33);
        org.junit.Assert.assertNotNull(byteArray34);
        org.junit.Assert.assertArrayEquals(byteArray34, new byte[] { (byte) 1, (byte) 0, (byte) 0, (byte) 33, (byte) 0 });
    }

    @Test
    public void test1422() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1422");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream5 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream1, (long) 1, (long) 148);
        java.util.zip.Checksum checksum6 = cRC32VerifyingInputStream5.getChecksum();
        long long8 = cRC32VerifyingInputStream5.skip((long) 345);
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream11 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cRC32VerifyingInputStream5, 8589934591L, (long) '4');
        int int12 = cRC32VerifyingInputStream5.read();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream15 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cRC32VerifyingInputStream5, (long) 52, (long) (short) -1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(checksum6);
        org.junit.Assert.assertTrue("'" + long8 + "' != '" + 0L + "'", long8 == 0L);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + (-1) + "'", int12 == (-1));
    }

    @Test
    public void test1423() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1423");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        org.apache.commons.compress.archivers.tar.TarArchiveInputStream tarArchiveInputStream4 = new org.apache.commons.compress.archivers.tar.TarArchiveInputStream((java.io.InputStream) cpioArchiveInputStream1, 0);
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry5 = tarArchiveInputStream4.getCurrentEntry();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.arj.ArjArchiveInputStream arjArchiveInputStream6 = new org.apache.commons.compress.archivers.arj.ArjArchiveInputStream((java.io.InputStream) tarArchiveInputStream4);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: No current tar entry");
        } catch (java.lang.IllegalStateException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNull(tarArchiveEntry5);
    }

    @Test
    public void test1424() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1424");
        java.nio.charset.Charset charset2 = null;
        org.apache.commons.compress.archivers.zip.ZipEncoding zipEncoding3 = org.apache.commons.compress.archivers.zip.ZipEncodingHelper.getZipEncoding(charset2);
        byte[] byteArray9 = new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 };
        byte[] byteArray16 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean18 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray16, 0);
        boolean boolean19 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray9, byteArray16);
        java.lang.String str20 = zipEncoding3.decode(byteArray9);
        org.apache.commons.compress.harmony.unpack200.Segment segment21 = new org.apache.commons.compress.harmony.unpack200.Segment();
        org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager operandManager22 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass26 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry27 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass26);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass31 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry32 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass31);
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry[] exceptionTableEntryArray33 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry[] { exceptionTableEntry27, exceptionTableEntry32 };
        java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry> exceptionTableEntryList34 = new java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>();
        boolean boolean35 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>) exceptionTableEntryList34, exceptionTableEntryArray33);
        org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute codeAttribute36 = new org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute(476, (int) (byte) 51, byteArray9, segment21, operandManager22, (java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>) exceptionTableEntryList34);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_39 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_39);
        java.lang.String str41 = cPUTF8_39.toString();
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_44 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_44);
        org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute newAttribute47 = new org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute(cPUTF8_44, 8);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_51 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_51);
        org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute newAttribute54 = new org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute(cPUTF8_51, 8);
        org.apache.commons.compress.harmony.unpack200.bytecode.Attribute[] attributeArray55 = new org.apache.commons.compress.harmony.unpack200.bytecode.Attribute[] { newAttribute54 };
        java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute> attributeList56 = new java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute>();
        boolean boolean57 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute>) attributeList56, attributeArray55);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPMember cPMember58 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPMember(cPUTF8_39, cPUTF8_44, (long) (byte) 0, (java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute>) attributeList56);
        org.apache.commons.compress.harmony.unpack200.bytecode.SignatureAttribute signatureAttribute59 = new org.apache.commons.compress.harmony.unpack200.bytecode.SignatureAttribute(cPUTF8_39);
        codeAttribute36.addAttribute((org.apache.commons.compress.harmony.unpack200.bytecode.Attribute) signatureAttribute59);
        java.lang.String str61 = codeAttribute36.toString();
        int int62 = codeAttribute36.maxStack;
        codeAttribute36.maxStack = (byte) 48;
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass68 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry69 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass68);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass73 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry74 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass73);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass75 = exceptionTableEntry74.getCatchType();
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry[] exceptionTableEntryArray76 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry[] { exceptionTableEntry69, exceptionTableEntry74 };
        java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry> exceptionTableEntryList77 = new java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>();
        boolean boolean78 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>) exceptionTableEntryList77, exceptionTableEntryArray76);
        codeAttribute36.exceptionTable = exceptionTableEntryList77;
        org.junit.Assert.assertNotNull(zipEncoding3);
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertArrayEquals(byteArray9, new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 });
        org.junit.Assert.assertNotNull(byteArray16);
        org.junit.Assert.assertArrayEquals(byteArray16, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "\002?\002\n\001" + "'", str20, "\002?\002\n\001");
        org.junit.Assert.assertNotNull(exceptionTableEntryArray33);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + true + "'", boolean35 == true);
        org.junit.Assert.assertEquals("'" + str41 + "' != '" + "UTF-8:splitting" + "'", str41, "UTF-8:splitting");
        org.junit.Assert.assertNotNull(attributeArray55);
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + true + "'", boolean57 == true);
        org.junit.Assert.assertEquals("'" + str61 + "' != '" + "Code: 41 bytes" + "'", str61, "Code: 41 bytes");
        org.junit.Assert.assertTrue("'" + int62 + "' != '" + 476 + "'", int62 == 476);
        org.junit.Assert.assertNull(cPClass75);
        org.junit.Assert.assertNotNull(exceptionTableEntryArray76);
        org.junit.Assert.assertTrue("'" + boolean78 + "' != '" + true + "'", boolean78 == true);
    }

    @Test
    public void test1425() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1425");
        java.util.jar.JarFile jarFile0 = null;
        java.io.OutputStream outputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream3 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream1, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry4 = null;
        boolean boolean5 = cpioArchiveOutputStream3.canWriteEntryData(archiveEntry4);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream7 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream3, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream9 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream7, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap10 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream11 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream9, strMap10);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec12 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean13 = bHSDCodec12.isDelta();
        byte[] byteArray15 = bHSDCodec12.encode((int) '#');
        pack200CompressorOutputStream11.write(byteArray15);
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions17 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        org.apache.commons.compress.harmony.pack200.Archive archive18 = new org.apache.commons.compress.harmony.pack200.Archive(jarFile0, (java.io.OutputStream) pack200CompressorOutputStream11, packingOptions17);
        java.lang.String str19 = packingOptions17.getDeflateHint();
        java.lang.String str21 = packingOptions17.getUnknownCodeAttributeAction("ACC_PROTECTED");
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(bHSDCodec12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] { (byte) 35 });
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "keep" + "'", str19, "keep");
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "pass" + "'", str21, "pass");
    }

    @Test
    public void test1426() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1426");
        java.io.InputStream inputStream0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.xz.XZCompressorInputStream xZCompressorInputStream2 = new org.apache.commons.compress.compressors.xz.XZCompressorInputStream(inputStream0, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test1427() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1427");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream8 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 4);
        byte[] byteArray10 = zstdCompressorOutputStream8.writeUsAsciiRaw("org.apache.commons.compress.harmony.pack200.Segment$PassException");
        org.apache.commons.compress.archivers.jar.JarArchiveOutputStream jarArchiveOutputStream11 = new org.apache.commons.compress.archivers.jar.JarArchiveOutputStream((java.io.OutputStream) zstdCompressorOutputStream8);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(byteArray10);
    }

    @Test
    public void test1428() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1428");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("error", 32);
        org.apache.commons.compress.harmony.unpack200.MetadataBandGroup.setRvaAttributeName(cPUTF8_2);
        org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute.setAttributeName(cPUTF8_2);
    }

    @Test
    public void test1429() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1429");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream3 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream4 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        long long5 = cpioArchiveOutputStream2.getBytesWritten();
        org.junit.Assert.assertTrue("'" + long5 + "' != '" + 0L + "'", long5 == 0L);
    }

    @Test
    public void test1430() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1430");
        java.nio.charset.Charset charset2 = null;
        org.apache.commons.compress.archivers.zip.ZipEncoding zipEncoding3 = org.apache.commons.compress.archivers.zip.ZipEncodingHelper.getZipEncoding(charset2);
        byte[] byteArray9 = new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 };
        byte[] byteArray16 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean18 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray16, 0);
        boolean boolean19 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray9, byteArray16);
        java.lang.String str20 = zipEncoding3.decode(byteArray9);
        org.apache.commons.compress.harmony.unpack200.Segment segment21 = new org.apache.commons.compress.harmony.unpack200.Segment();
        org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager operandManager22 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass26 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry27 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass26);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass31 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry32 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass31);
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry[] exceptionTableEntryArray33 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry[] { exceptionTableEntry27, exceptionTableEntry32 };
        java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry> exceptionTableEntryList34 = new java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>();
        boolean boolean35 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>) exceptionTableEntryList34, exceptionTableEntryArray33);
        org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute codeAttribute36 = new org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute(476, (int) (byte) 51, byteArray9, segment21, operandManager22, (java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>) exceptionTableEntryList34);
        java.lang.String str37 = codeAttribute36.toString();
        org.junit.Assert.assertNotNull(zipEncoding3);
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertArrayEquals(byteArray9, new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 });
        org.junit.Assert.assertNotNull(byteArray16);
        org.junit.Assert.assertArrayEquals(byteArray16, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "\002?\002\n\001" + "'", str20, "\002?\002\n\001");
        org.junit.Assert.assertNotNull(exceptionTableEntryArray33);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + true + "'", boolean35 == true);
        org.junit.Assert.assertEquals("'" + str37 + "' != '" + "Code: 33 bytes" + "'", str37, "Code: 33 bytes");
    }

    @Test
    public void test1431() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1431");
        java.nio.charset.Charset charset2 = null;
        org.apache.commons.compress.archivers.zip.ZipEncoding zipEncoding3 = org.apache.commons.compress.archivers.zip.ZipEncodingHelper.getZipEncoding(charset2);
        byte[] byteArray9 = new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 };
        byte[] byteArray16 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean18 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray16, 0);
        boolean boolean19 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray9, byteArray16);
        java.lang.String str20 = zipEncoding3.decode(byteArray9);
        org.apache.commons.compress.harmony.unpack200.Segment segment21 = new org.apache.commons.compress.harmony.unpack200.Segment();
        org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager operandManager22 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass26 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry27 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass26);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass31 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry32 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass31);
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry[] exceptionTableEntryArray33 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry[] { exceptionTableEntry27, exceptionTableEntry32 };
        java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry> exceptionTableEntryList34 = new java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>();
        boolean boolean35 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>) exceptionTableEntryList34, exceptionTableEntryArray33);
        org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute codeAttribute36 = new org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute(476, (int) (byte) 51, byteArray9, segment21, operandManager22, (java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry>) exceptionTableEntryList34);
        java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode> byteCodeList37 = codeAttribute36.byteCodes;
        org.apache.commons.compress.harmony.unpack200.bytecode.Attribute attribute38 = null;
        codeAttribute36.addAttribute(attribute38);
        int int40 = codeAttribute36.maxStack;
        org.junit.Assert.assertNotNull(zipEncoding3);
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertArrayEquals(byteArray9, new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 });
        org.junit.Assert.assertNotNull(byteArray16);
        org.junit.Assert.assertArrayEquals(byteArray16, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "\002?\002\n\001" + "'", str20, "\002?\002\n\001");
        org.junit.Assert.assertNotNull(exceptionTableEntryArray33);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + true + "'", boolean35 == true);
        org.junit.Assert.assertNotNull(byteCodeList37);
        org.junit.Assert.assertTrue("'" + int40 + "' != '" + 476 + "'", int40 == 476);
    }

    @Test
    public void test1432() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1432");
        int int2 = org.apache.commons.compress.utils.ExactMath.add(131, 96L);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 227 + "'", int2 == 227);
    }

    @Test
    public void test1433() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1433");
        org.apache.commons.compress.archivers.dump.InvalidFormatException invalidFormatException1 = new org.apache.commons.compress.archivers.dump.InvalidFormatException((long) 8);
        long long2 = invalidFormatException1.getOffset();
        long long3 = invalidFormatException1.getOffset();
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 8L + "'", long2 == 8L);
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 8L + "'", long3 == 8L);
    }

    @Test
    public void test1434() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1434");
        java.lang.String str0 = org.apache.commons.compress.compressors.CompressorStreamFactory.LZMA;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "lzma" + "'", str0, "lzma");
    }

    @Test
    public void test1435() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1435");
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode4 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int5 = byteCode4.getByteCodeIndex();
        int[] intArray6 = new int[] {};
        int[] intArray7 = new int[] {};
        int[] intArray8 = new int[] {};
        int[][] intArray9 = new int[][] { intArray6, intArray7, intArray8 };
        byteCode4.setNestedPositions(intArray9);
        int[] intArray11 = byteCode4.getRewrite();
        int[] intArray22 = new int[] { ' ', (byte) -1 };
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm iMethodRefForm23 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm((int) (byte) -1, "", intArray22);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm classRefForm24 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm((int) (short) 0, "jar", intArray22);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.StringRefForm stringRefForm26 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.StringRefForm(1, "splitting", intArray22, true);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.LabelForm labelForm27 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.LabelForm((int) '#', "pass", intArray22);
        org.apache.commons.compress.harmony.unpack200.bytecode.LineNumberTableAttribute lineNumberTableAttribute28 = new org.apache.commons.compress.harmony.unpack200.bytecode.LineNumberTableAttribute(100, intArray11, intArray22);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm iMethodRefForm29 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm(3, "RuntimeInvisibleParameterAnnotations", intArray22);
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode31 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int32 = byteCode31.getByteCodeIndex();
        int[] intArray33 = new int[] {};
        int[] intArray34 = new int[] {};
        int[] intArray35 = new int[] {};
        int[][] intArray36 = new int[][] { intArray33, intArray34, intArray35 };
        byteCode31.setNestedPositions(intArray36);
        org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry[] classFileEntryArray38 = byteCode31.getNestedClassFileEntries();
        org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager operandManager39 = null;
        // The following exception was thrown during execution in test generation
        try {
            iMethodRefForm29.setByteCodeOperands(byteCode31, operandManager39, (int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteCode4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + (-1) + "'", int5 == (-1));
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertArrayEquals(intArray6, new int[] {});
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertArrayEquals(intArray7, new int[] {});
        org.junit.Assert.assertNotNull(intArray8);
        org.junit.Assert.assertArrayEquals(intArray8, new int[] {});
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertNotNull(intArray11);
        org.junit.Assert.assertArrayEquals(intArray11, new int[] { 255 });
        org.junit.Assert.assertNotNull(intArray22);
        org.junit.Assert.assertArrayEquals(intArray22, new int[] { 32, (-1) });
        org.junit.Assert.assertNotNull(byteCode31);
        org.junit.Assert.assertTrue("'" + int32 + "' != '" + (-1) + "'", int32 == (-1));
        org.junit.Assert.assertNotNull(intArray33);
        org.junit.Assert.assertArrayEquals(intArray33, new int[] {});
        org.junit.Assert.assertNotNull(intArray34);
        org.junit.Assert.assertArrayEquals(intArray34, new int[] {});
        org.junit.Assert.assertNotNull(intArray35);
        org.junit.Assert.assertArrayEquals(intArray35, new int[] {});
        org.junit.Assert.assertNotNull(intArray36);
        org.junit.Assert.assertNotNull(classFileEntryArray38);
        org.junit.Assert.assertArrayEquals(classFileEntryArray38, new org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry[] {});
    }

    @Test
    public void test1436() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1436");
        org.apache.commons.compress.compressors.gzip.GzipParameters gzipParameters0 = new org.apache.commons.compress.compressors.gzip.GzipParameters();
        gzipParameters0.setOperatingSystem(6);
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS3 = gzipParameters0.getOS();
        gzipParameters0.setOperatingSystem(7);
        org.junit.Assert.assertTrue("'" + oS3 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.HPFS + "'", oS3.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.HPFS));
    }

    @Test
    public void test1437() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1437");
        org.apache.commons.compress.harmony.unpack200.CpBands cpBands0 = null;
        org.apache.commons.compress.harmony.unpack200.SegmentConstantPool segmentConstantPool1 = new org.apache.commons.compress.harmony.unpack200.SegmentConstantPool(cpBands0);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry classFileEntry4 = segmentConstantPool1.getValue(1024, (long) 40960);
            org.junit.Assert.fail("Expected exception of type java.lang.Error; message: Tried to get a value I don't know about: 1024");
        } catch (java.lang.Error e) {
            // Expected exception.
        }
    }

    @Test
    public void test1438() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1438");
        int int0 = org.apache.commons.compress.harmony.pack200.Segment.ASM_API;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 28771 + "'", int0 == 28771);
    }

    @Test
    public void test1439() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1439");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS1 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue elementValue2 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue((int) (byte) 7, (java.lang.Object) oS1);
        java.io.DataOutputStream dataOutputStream3 = null;
        // The following exception was thrown during execution in test generation
        try {
            elementValue2.writeBody(dataOutputStream3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + oS1 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS1.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
    }

    @Test
    public void test1440() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1440");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        byte[] byteArray2 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream1);
        long long3 = cpioArchiveInputStream1.getBytesRead();
        int int4 = cpioArchiveInputStream1.getCount();
        boolean boolean5 = cpioArchiveInputStream1.markSupported();
        org.apache.commons.io.function.IOIterator<org.apache.commons.compress.archivers.cpio.CpioArchiveEntry> cpioArchiveEntryIOIterator6 = cpioArchiveInputStream1.iterator();
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry7 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        java.lang.String str8 = sevenZArchiveEntry7.getName();
        sevenZArchiveEntry7.setHasCrc(false);
        boolean boolean11 = cpioArchiveInputStream1.canReadEntryData((org.apache.commons.compress.archivers.ArchiveEntry) sevenZArchiveEntry7);
        cpioArchiveInputStream1.reset();
        org.apache.commons.compress.archivers.tar.TarArchiveInputStream tarArchiveInputStream14 = new org.apache.commons.compress.archivers.tar.TarArchiveInputStream((java.io.InputStream) cpioArchiveInputStream1, (int) (byte) 54);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream bZip2CompressorInputStream16 = new org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream((java.io.InputStream) cpioArchiveInputStream1, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(cpioArchiveEntryIOIterator6);
        org.junit.Assert.assertNull(str8);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
    }

    @Test
    public void test1441() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1441");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPDouble cPDouble2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPDouble((java.lang.Double) (-1.0d), (int) (short) 100);
        java.lang.String str3 = cPDouble2.toString();
        java.lang.String str4 = cPDouble2.toString();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Double: -1.0" + "'", str3, "Double: -1.0");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Double: -1.0" + "'", str4, "Double: -1.0");
    }

    @Test
    public void test1442() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1442");
        java.util.jar.JarFile jarFile0 = null;
        java.io.OutputStream outputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream3 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream1, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry4 = null;
        boolean boolean5 = cpioArchiveOutputStream3.canWriteEntryData(archiveEntry4);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream7 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream3, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream9 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream7, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap10 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream11 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream9, strMap10);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec12 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean13 = bHSDCodec12.isDelta();
        byte[] byteArray15 = bHSDCodec12.encode((int) '#');
        pack200CompressorOutputStream11.write(byteArray15);
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions17 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        org.apache.commons.compress.harmony.pack200.Archive archive18 = new org.apache.commons.compress.harmony.pack200.Archive(jarFile0, (java.io.OutputStream) pack200CompressorOutputStream11, packingOptions17);
        java.lang.String str19 = packingOptions17.getDeflateHint();
        boolean boolean20 = packingOptions17.isStripDebug();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(bHSDCodec12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] { (byte) 35 });
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "keep" + "'", str19, "keep");
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test1443() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1443");
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader0 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        org.apache.commons.compress.harmony.pack200.BandSet.BandAnalysisResults bandAnalysisResults1 = segmentHeader0.new BandAnalysisResults();
        boolean boolean2 = segmentHeader0.have_all_code_flags();
        java.io.OutputStream outputStream3 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream5 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream3, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry6 = null;
        boolean boolean7 = cpioArchiveOutputStream5.canWriteEntryData(archiveEntry6);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream9 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream5, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream11 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream9, 6);
        segmentHeader0.pack((java.io.OutputStream) fixedLengthBlockOutputStream11);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test1444() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1444");
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger0 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger1 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger2 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry3 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date4 = arjArchiveEntry3.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong5 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date4);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField6 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField(zipEightByteInteger0, zipEightByteInteger1, zipEightByteInteger2, zipLong5);
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger7 = zip64ExtendedInformationExtraField6.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger8 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger9 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger10 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry11 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date12 = arjArchiveEntry11.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong13 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date12);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField14 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField(zipEightByteInteger8, zipEightByteInteger9, zipEightByteInteger10, zipLong13);
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger15 = zip64ExtendedInformationExtraField14.getSize();
        zip64ExtendedInformationExtraField6.setSize(zipEightByteInteger15);
        java.math.BigInteger bigInteger17 = zipEightByteInteger15.getValue();
        org.junit.Assert.assertNotNull(zipEightByteInteger0);
        org.junit.Assert.assertNotNull(zipEightByteInteger1);
        org.junit.Assert.assertNotNull(zipEightByteInteger2);
        org.junit.Assert.assertNotNull(date4);
        org.junit.Assert.assertEquals(date4.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong5);
        org.junit.Assert.assertNotNull(zipEightByteInteger7);
        org.junit.Assert.assertNotNull(zipEightByteInteger8);
        org.junit.Assert.assertNotNull(zipEightByteInteger9);
        org.junit.Assert.assertNotNull(zipEightByteInteger10);
        org.junit.Assert.assertNotNull(date12);
        org.junit.Assert.assertEquals(date12.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong13);
        org.junit.Assert.assertNotNull(zipEightByteInteger15);
        org.junit.Assert.assertNotNull(bigInteger17);
    }

    @Test
    public void test1445() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1445");
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode3 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int4 = byteCode3.getByteCodeIndex();
        int[] intArray5 = new int[] {};
        int[] intArray6 = new int[] {};
        int[] intArray7 = new int[] {};
        int[][] intArray8 = new int[][] { intArray5, intArray6, intArray7 };
        byteCode3.setNestedPositions(intArray8);
        int[] intArray10 = byteCode3.getRewrite();
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IincForm iincForm11 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IincForm(6, "cpio", intArray10);
        org.junit.Assert.assertNotNull(byteCode3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + (-1) + "'", int4 == (-1));
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] {});
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertArrayEquals(intArray6, new int[] {});
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertArrayEquals(intArray7, new int[] {});
        org.junit.Assert.assertNotNull(intArray8);
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] { 255 });
    }

    @Test
    public void test1446() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1446");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        java.lang.String str1 = sevenZArchiveEntry0.getName();
        sevenZArchiveEntry0.setHasCrc(false);
        boolean boolean4 = sevenZArchiveEntry0.getHasWindowsAttributes();
        sevenZArchiveEntry0.setHasLastModifiedDate(true);
        java.lang.String str7 = sevenZArchiveEntry0.getName();
        sevenZArchiveEntry0.setHasCrc(true);
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test1447() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1447");
        java.nio.file.Path path0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.nio.channels.SeekableByteChannel seekableByteChannel1 = org.apache.commons.compress.archivers.zip.ZipSplitReadOnlySeekableByteChannel.buildFromLastSplitSegment(path0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1448() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1448");
        int int0 = org.apache.commons.compress.archivers.cpio.CpioConstants.C_ISNWK;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 36864 + "'", int0 == 36864);
    }

    @Test
    public void test1449() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1449");
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader0 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        int int1 = segmentHeader0.getDefaultMajorVersion();
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 0 + "'", int1 == 0);
    }

    @Test
    public void test1450() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1450");
        java.nio.file.Path path0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipFile zipFile1 = new org.apache.commons.compress.archivers.zip.ZipFile(path0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1451() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1451");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS1 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.from(345);
        org.junit.Assert.assertTrue("'" + oS1 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.UNKNOWN + "'", oS1.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.UNKNOWN));
    }

    @Test
    public void test1452() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1452");
        java.lang.String str1 = org.apache.commons.compress.compressors.gzip.GzipUtils.getCompressedFileName("pass");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "pass.gz" + "'", str1, "pass.gz");
    }

    @Test
    public void test1453() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1453");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.lz77support.Parameters.Builder builder1 = org.apache.commons.compress.compressors.lz77support.Parameters.builder(10240);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: windowSize must be a power of two");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1454() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1454");
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel1 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        long long2 = seekableInMemoryByteChannel1.size();
        char[] charArray7 = new char[] { '4', '#', '#', ' ' };
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZFile sevenZFile8 = new org.apache.commons.compress.archivers.sevenz.SevenZFile((java.nio.channels.SeekableByteChannel) seekableInMemoryByteChannel1, charArray7);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.IOUtils.read(Ljava/nio/channels/ReadableByteChannel;Ljava/nio/ByteBuffer;)I");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 96L + "'", long2 == 96L);
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '4', '#', '#', ' ' });
    }

    @Test
    public void test1455() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1455");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("error", false);
        java.util.Date date3 = tarArchiveEntry2.getModTime();
        boolean boolean4 = tarArchiveEntry2.isExtended();
        org.junit.Assert.assertNotNull(date3);
// flaky "4) test1455(RegressionTest2)":         org.junit.Assert.assertEquals(date3.toString(), "Fri Mar 14 23:49:07 AEDT 2025");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test1456() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1456");
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        jarArchiveEntry1.setUnixMode(16877);
        java.lang.String str4 = org.apache.commons.compress.utils.ArchiveUtils.toString((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry1);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "-      -1 ACC_NATIVE.gz" + "'", str4, "-      -1 ACC_NATIVE.gz");
    }

    @Test
    public void test1457() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1457");
        org.apache.commons.compress.harmony.unpack200.IcTuple icTuple8 = new org.apache.commons.compress.harmony.unpack200.IcTuple("ACC_SYNTHETIC", 32771, "ACC_TRANSIENT", "ACC_PROTECTED", (int) '4', 8192, 17, 4);
        java.lang.String str9 = icTuple8.outerClassString();
        boolean boolean10 = icTuple8.outerIsAnonymous();
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "ACC_TRANSIENT" + "'", str9, "ACC_TRANSIENT");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test1458() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1458");
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader0 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        org.apache.commons.compress.harmony.pack200.BandSet.BandAnalysisResults bandAnalysisResults1 = segmentHeader0.new BandAnalysisResults();
        org.apache.commons.compress.harmony.pack200.BandSet.BandAnalysisResults bandAnalysisResults2 = segmentHeader0.new BandAnalysisResults();
        segmentHeader0.setCp_Imethod_count((int) '#');
        segmentHeader0.setCp_Double_count(60012);
    }

    @Test
    public void test1459() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1459");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        java.lang.String str3 = dumpArchiveEntry2.toString();
        int int4 = dumpArchiveEntry2.getHeaderHoles();
        java.lang.String str5 = dumpArchiveEntry2.getName();
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry6 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date7 = arjArchiveEntry6.getLastModifiedDate();
        long long8 = org.apache.commons.compress.utils.TimeUtils.toNtfsTime(date7);
        dumpArchiveEntry2.setAccessTime(date7);
        org.apache.commons.compress.archivers.zip.ZipLong zipLong10 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date7);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "jar" + "'", str3, "jar");
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "jar" + "'", str5, "jar");
        org.junit.Assert.assertNotNull(date7);
        org.junit.Assert.assertEquals(date7.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertTrue("'" + long8 + "' != '" + 119572020000000000L + "'", long8 == 119572020000000000L);
        org.junit.Assert.assertNotNull(zipLong10);
    }

    @Test
    public void test1460() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1460");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        long long3 = cpioArchiveInputStream1.skip((long) '4');
        org.apache.commons.compress.archivers.jar.JarArchiveInputStream jarArchiveInputStream4 = new org.apache.commons.compress.archivers.jar.JarArchiveInputStream((java.io.InputStream) cpioArchiveInputStream1);
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
    }

    @Test
    public void test1461() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1461");
        byte[] byteArray1 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.getBytes((long) ' ');
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 32, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0 });
    }

    @Test
    public void test1462() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1462");
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode1 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int2 = byteCode1.getLength();
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode6 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int7 = byteCode6.getByteCodeIndex();
        int[] intArray8 = new int[] {};
        int[] intArray9 = new int[] {};
        int[] intArray10 = new int[] {};
        int[][] intArray11 = new int[][] { intArray8, intArray9, intArray10 };
        byteCode6.setNestedPositions(intArray11);
        int[] intArray13 = byteCode6.getRewrite();
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm iMethodRefForm14 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm(96, "UTF-16BE", intArray13);
        int[] intArray15 = iMethodRefForm14.getRewrite();
        // The following exception was thrown during execution in test generation
        try {
            byteCode1.setOperandBytes(intArray15);
            org.junit.Assert.fail("Expected exception of type java.lang.Error; message: Trying to rewrite impdep2 that has no rewrite");
        } catch (java.lang.Error e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteCode1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 1 + "'", int2 == 1);
        org.junit.Assert.assertNotNull(byteCode6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + (-1) + "'", int7 == (-1));
        org.junit.Assert.assertNotNull(intArray8);
        org.junit.Assert.assertArrayEquals(intArray8, new int[] {});
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertArrayEquals(intArray9, new int[] {});
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] {});
        org.junit.Assert.assertNotNull(intArray11);
        org.junit.Assert.assertNotNull(intArray13);
        org.junit.Assert.assertArrayEquals(intArray13, new int[] { 255 });
        org.junit.Assert.assertNotNull(intArray15);
        org.junit.Assert.assertArrayEquals(intArray15, new int[] { 255 });
    }

    @Test
    public void test1463() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1463");
        org.apache.commons.compress.archivers.dump.DumpArchiveException dumpArchiveException2 = new org.apache.commons.compress.archivers.dump.DumpArchiveException();
        org.apache.commons.compress.MemoryLimitException memoryLimitException3 = new org.apache.commons.compress.MemoryLimitException((long) 252, 32, (java.lang.Throwable) dumpArchiveException2);
    }

    @Test
    public void test1464() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1464");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file3 = tarArchiveEntry2.getFile();
        int int4 = tarArchiveEntry2.getDevMinor();
        tarArchiveEntry2.setUserName("UTF-8:splitting");
        tarArchiveEntry2.setIds(493, (int) (byte) 2);
        boolean boolean10 = tarArchiveEntry2.isDirectory();
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry13 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        java.util.Date date14 = dumpArchiveEntry13.getLastModifiedDate();
        tarArchiveEntry2.setModTime(date14);
        tarArchiveEntry2.setDevMinor(488);
        java.nio.file.attribute.FileTime fileTime18 = tarArchiveEntry2.getLastModifiedTime();
        org.junit.Assert.assertNull(file3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(date14);
        org.junit.Assert.assertEquals(date14.toString(), "Thu Jan 01 10:00:00 AEST 1970");
        org.junit.Assert.assertNotNull(fileTime18);
    }

    @Test
    public void test1465() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1465");
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger0 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger1 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger2 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry3 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date4 = arjArchiveEntry3.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong5 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date4);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField6 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField(zipEightByteInteger0, zipEightByteInteger1, zipEightByteInteger2, zipLong5);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField7 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger8 = zip64ExtendedInformationExtraField7.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort9 = zip64ExtendedInformationExtraField7.getLocalFileDataLength();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger10 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger11 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger12 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry13 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date14 = arjArchiveEntry13.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong15 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date14);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField16 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField(zipEightByteInteger10, zipEightByteInteger11, zipEightByteInteger12, zipLong15);
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger17 = zip64ExtendedInformationExtraField16.getCompressedSize();
        zip64ExtendedInformationExtraField7.setSize(zipEightByteInteger17);
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger19 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger20 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger21 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry22 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date23 = arjArchiveEntry22.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong24 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date23);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField25 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField(zipEightByteInteger19, zipEightByteInteger20, zipEightByteInteger21, zipLong24);
        java.math.BigInteger bigInteger26 = zipEightByteInteger19.getValue();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger27 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger28 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger29 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry30 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date31 = arjArchiveEntry30.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong32 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date31);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField33 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField(zipEightByteInteger27, zipEightByteInteger28, zipEightByteInteger29, zipLong32);
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger34 = zip64ExtendedInformationExtraField33.getSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger35 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger36 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger37 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry38 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date39 = arjArchiveEntry38.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong40 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date39);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField41 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField(zipEightByteInteger35, zipEightByteInteger36, zipEightByteInteger37, zipLong40);
        java.math.BigInteger bigInteger42 = zipEightByteInteger35.getValue();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger43 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField44 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField(zipEightByteInteger35, zipEightByteInteger43);
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger45 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger46 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger47 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry48 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date49 = arjArchiveEntry48.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong50 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date49);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField51 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField(zipEightByteInteger45, zipEightByteInteger46, zipEightByteInteger47, zipLong50);
        org.apache.commons.compress.archivers.zip.ZipLong zipLong52 = org.apache.commons.compress.archivers.zip.ZipLong.LFH_SIG;
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField53 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField(zipEightByteInteger34, zipEightByteInteger35, zipEightByteInteger45, zipLong52);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField54 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField(zipEightByteInteger0, zipEightByteInteger17, zipEightByteInteger19, zipLong52);
        org.junit.Assert.assertNotNull(zipEightByteInteger0);
        org.junit.Assert.assertNotNull(zipEightByteInteger1);
        org.junit.Assert.assertNotNull(zipEightByteInteger2);
        org.junit.Assert.assertNotNull(date4);
        org.junit.Assert.assertEquals(date4.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong5);
        org.junit.Assert.assertNull(zipEightByteInteger8);
        org.junit.Assert.assertNotNull(zipShort9);
        org.junit.Assert.assertNotNull(zipEightByteInteger10);
        org.junit.Assert.assertNotNull(zipEightByteInteger11);
        org.junit.Assert.assertNotNull(zipEightByteInteger12);
        org.junit.Assert.assertNotNull(date14);
        org.junit.Assert.assertEquals(date14.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong15);
        org.junit.Assert.assertNotNull(zipEightByteInteger17);
        org.junit.Assert.assertNotNull(zipEightByteInteger19);
        org.junit.Assert.assertNotNull(zipEightByteInteger20);
        org.junit.Assert.assertNotNull(zipEightByteInteger21);
        org.junit.Assert.assertNotNull(date23);
        org.junit.Assert.assertEquals(date23.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong24);
        org.junit.Assert.assertNotNull(bigInteger26);
        org.junit.Assert.assertNotNull(zipEightByteInteger27);
        org.junit.Assert.assertNotNull(zipEightByteInteger28);
        org.junit.Assert.assertNotNull(zipEightByteInteger29);
        org.junit.Assert.assertNotNull(date31);
        org.junit.Assert.assertEquals(date31.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong32);
        org.junit.Assert.assertNotNull(zipEightByteInteger34);
        org.junit.Assert.assertNotNull(zipEightByteInteger35);
        org.junit.Assert.assertNotNull(zipEightByteInteger36);
        org.junit.Assert.assertNotNull(zipEightByteInteger37);
        org.junit.Assert.assertNotNull(date39);
        org.junit.Assert.assertEquals(date39.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong40);
        org.junit.Assert.assertNotNull(bigInteger42);
        org.junit.Assert.assertNotNull(zipEightByteInteger43);
        org.junit.Assert.assertNotNull(zipEightByteInteger45);
        org.junit.Assert.assertNotNull(zipEightByteInteger46);
        org.junit.Assert.assertNotNull(zipEightByteInteger47);
        org.junit.Assert.assertNotNull(date49);
        org.junit.Assert.assertEquals(date49.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong50);
        org.junit.Assert.assertNotNull(zipLong52);
    }

    @Test
    public void test1466() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1466");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec0 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean1 = bHSDCodec0.isDelta();
        int int2 = org.apache.commons.compress.harmony.pack200.CodecEncoding.getSpecifierForDefaultCodec(bHSDCodec0);
        boolean boolean3 = bHSDCodec0.isDelta();
        org.junit.Assert.assertNotNull(bHSDCodec0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 17 + "'", int2 == 17);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test1467() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1467");
        org.apache.commons.compress.compressors.gzip.GzipParameters gzipParameters0 = new org.apache.commons.compress.compressors.gzip.GzipParameters();
        gzipParameters0.setOperatingSystem(6);
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS3 = gzipParameters0.getOS();
        gzipParameters0.setBufferSize(16384);
        gzipParameters0.setDeflateStrategy((int) (byte) 6);
        java.time.Instant instant8 = null;
        gzipParameters0.setModificationInstant(instant8);
        java.lang.String str10 = gzipParameters0.getFilename();
        gzipParameters0.setFilename("././@LongLink");
        org.junit.Assert.assertTrue("'" + oS3 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.HPFS + "'", oS3.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.HPFS));
        org.junit.Assert.assertNull(str10);
    }

    @Test
    public void test1468() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1468");
        org.apache.commons.compress.archivers.zip.UnrecognizedExtraField unrecognizedExtraField0 = new org.apache.commons.compress.archivers.zip.UnrecognizedExtraField();
        org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData unparseableExtraFieldData1 = new org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort2 = unparseableExtraFieldData1.getHeaderId();
        unrecognizedExtraField0.setHeaderId(zipShort2);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort4 = unrecognizedExtraField0.getHeaderId();
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker5 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray6 = jarMarker5.getCentralDirectoryData();
        byte[] byteArray7 = jarMarker5.getLocalFileDataData();
        boolean boolean9 = org.apache.commons.compress.compressors.xz.XZCompressorInputStream.matches(byteArray7, 0);
        boolean boolean11 = org.apache.commons.compress.archivers.dump.DumpArchiveInputStream.matches(byteArray7, 17);
        unrecognizedExtraField0.setLocalFileDataData(byteArray7);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean14 = org.apache.commons.compress.compressors.zstandard.ZstdUtils.matches(byteArray7, 32771);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 0");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(zipShort2);
        org.junit.Assert.assertNotNull(zipShort4);
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] {});
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] {});
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test1469() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1469");
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder0 = new org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder();
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder2 = builder0.setCharSequence((java.lang.CharSequence) "arj");
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder4 = builder2.setUseDefaultNameForUnnamedEntries(true);
        java.io.OutputStream outputStream5 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream7 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream5, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry8 = null;
        boolean boolean9 = cpioArchiveOutputStream7.canWriteEntryData(archiveEntry8);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry11 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean12 = cpioArchiveOutputStream7.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry11);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream13 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) cpioArchiveOutputStream7);
        long long14 = cpioArchiveOutputStream7.getBytesWritten();
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder15 = builder2.setOutputStream((java.io.OutputStream) cpioArchiveOutputStream7);
        org.junit.Assert.assertNotNull(builder2);
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + long14 + "' != '" + 0L + "'", long14 == 0L);
        org.junit.Assert.assertNotNull(builder15);
    }

    @Test
    public void test1470() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1470");
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode1 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int2 = byteCode1.getByteCodeIndex();
        int[] intArray3 = new int[] {};
        int[] intArray4 = new int[] {};
        int[] intArray5 = new int[] {};
        int[][] intArray6 = new int[][] { intArray3, intArray4, intArray5 };
        byteCode1.setNestedPositions(intArray6);
        int[] intArray8 = byteCode1.getRewrite();
        java.lang.String str9 = byteCode1.toString();
        org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute codeAttribute10 = null;
        byteCode1.applyByteCodeTargetFixup(codeAttribute10);
        org.junit.Assert.assertNotNull(byteCode1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
        org.junit.Assert.assertNotNull(intArray3);
        org.junit.Assert.assertArrayEquals(intArray3, new int[] {});
        org.junit.Assert.assertNotNull(intArray4);
        org.junit.Assert.assertArrayEquals(intArray4, new int[] {});
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] {});
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertNotNull(intArray8);
        org.junit.Assert.assertArrayEquals(intArray8, new int[] { 255 });
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "impdep2" + "'", str9, "impdep2");
    }

    @Test
    public void test1471() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1471");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.lz77support.Parameters.Builder builder1 = org.apache.commons.compress.compressors.lz77support.Parameters.builder((int) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: windowSize must be a power of two");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1472() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1472");
        org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData unparseableExtraFieldData0 = new org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort1 = unparseableExtraFieldData0.getLocalFileDataLength();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort2 = unparseableExtraFieldData0.getHeaderId();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = unparseableExtraFieldData0.getLocalFileDataLength();
        java.io.InputStream inputStream4 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream5 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream4);
        long long7 = cpioArchiveInputStream5.skip((long) 8);
        org.apache.commons.compress.utils.CountingInputStream countingInputStream8 = new org.apache.commons.compress.utils.CountingInputStream((java.io.InputStream) cpioArchiveInputStream5);
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode extraFieldParsingMode9 = org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT;
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp10 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime11 = null;
        x5455_ExtendedTimestamp10.setAccessFileTime(fileTime11);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort13 = x5455_ExtendedTimestamp10.getHeaderId();
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField14 = extraFieldParsingMode9.createExtraField(zipShort13);
        byte[] byteArray16 = org.apache.commons.compress.archivers.zip.ZipShort.getBytes(8);
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField21 = extraFieldParsingMode9.onUnparseableExtraField(byteArray16, (int) (byte) -1, 17, true, 0);
        byte[] byteArray22 = org.apache.commons.compress.archivers.zip.ZipUtil.reverse(byteArray16);
        int int23 = countingInputStream8.read(byteArray22);
        // The following exception was thrown during execution in test generation
        try {
            unparseableExtraFieldData0.parseFromCentralDirectoryData(byteArray22, 4096, 61440);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: null");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(zipShort1);
        org.junit.Assert.assertNotNull(zipShort2);
        org.junit.Assert.assertNotNull(zipShort3);
        org.junit.Assert.assertTrue("'" + long7 + "' != '" + 0L + "'", long7 == 0L);
        org.junit.Assert.assertTrue("'" + extraFieldParsingMode9 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT + "'", extraFieldParsingMode9.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT));
        org.junit.Assert.assertNotNull(zipShort13);
        org.junit.Assert.assertNotNull(zipExtraField14);
        org.junit.Assert.assertNotNull(byteArray16);
        org.junit.Assert.assertArrayEquals(byteArray16, new byte[] { (byte) 0, (byte) 8 });
        org.junit.Assert.assertNull(zipExtraField21);
        org.junit.Assert.assertNotNull(byteArray22);
        org.junit.Assert.assertArrayEquals(byteArray22, new byte[] { (byte) 0, (byte) 8 });
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
    }

    @Test
    public void test1473() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1473");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec3 = new org.apache.commons.compress.harmony.pack200.BHSDCodec((int) (byte) 48, (int) (byte) 88, 2048);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: 1<=b<=5");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1474() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1474");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream3 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        blockLZ4CompressorOutputStream3.write(512);
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger6 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger7 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger8 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry9 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date10 = arjArchiveEntry9.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong11 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date10);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField12 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField(zipEightByteInteger6, zipEightByteInteger7, zipEightByteInteger8, zipLong11);
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger13 = zip64ExtendedInformationExtraField12.getSize();
        byte[] byteArray14 = zip64ExtendedInformationExtraField12.getLocalFileDataData();
        // The following exception was thrown during execution in test generation
        try {
            blockLZ4CompressorOutputStream3.write(byteArray14, 17, (int) (byte) 48);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: null");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(zipEightByteInteger6);
        org.junit.Assert.assertNotNull(zipEightByteInteger7);
        org.junit.Assert.assertNotNull(zipEightByteInteger8);
        org.junit.Assert.assertNotNull(date10);
        org.junit.Assert.assertEquals(date10.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong11);
        org.junit.Assert.assertNotNull(zipEightByteInteger13);
        org.junit.Assert.assertNotNull(byteArray14);
        org.junit.Assert.assertArrayEquals(byteArray14, new byte[] { (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0 });
    }

    @Test
    public void test1475() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1475");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        fixedLengthBlockOutputStream6.write(1024);
        org.apache.commons.compress.compressors.lzma.LZMACompressorOutputStream lZMACompressorOutputStream9 = new org.apache.commons.compress.compressors.lzma.LZMACompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream6);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream10 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream6);
        java.io.OutputStream outputStream11 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream13 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream11, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry14 = null;
        boolean boolean15 = cpioArchiveOutputStream13.canWriteEntryData(archiveEntry14);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry17 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean18 = cpioArchiveOutputStream13.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry17);
        long long19 = jarArchiveEntry17.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource commentSource20 = jarArchiveEntry17.getCommentSource();
        java.nio.file.attribute.FileTime fileTime21 = jarArchiveEntry17.getLastModifiedTime();
        long long22 = jarArchiveEntry17.getTime();
        zipArchiveOutputStream10.putArchiveEntry((org.apache.commons.compress.archivers.zip.ZipArchiveEntry) jarArchiveEntry17);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertTrue("'" + long19 + "' != '" + (-1L) + "'", long19 == (-1L));
        org.junit.Assert.assertTrue("'" + commentSource20 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.COMMENT + "'", commentSource20.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.COMMENT));
        org.junit.Assert.assertNull(fileTime21);
        org.junit.Assert.assertTrue("'" + long22 + "' != '" + (-1L) + "'", long22 == (-1L));
    }

    @Test
    public void test1476() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1476");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        boolean boolean3 = dumpArchiveEntry2.isDirectory();
        boolean boolean5 = dumpArchiveEntry2.isSparseRecord(0);
        org.apache.commons.compress.archivers.dump.DumpArchiveConstants.SEGMENT_TYPE sEGMENT_TYPE6 = dumpArchiveEntry2.getHeaderType();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNull(sEGMENT_TYPE6);
    }

    @Test
    public void test1477() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1477");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0);
    }

    @Test
    public void test1478() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1478");
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode extraFieldParsingMode0 = org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT;
        java.util.jar.JarInputStream jarInputStream1 = null;
        java.util.jar.JarFile jarFile2 = null;
        java.io.OutputStream outputStream3 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream5 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream3, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry6 = null;
        boolean boolean7 = cpioArchiveOutputStream5.canWriteEntryData(archiveEntry6);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream9 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream5, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream11 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream9, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap12 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream13 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream11, strMap12);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec14 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean15 = bHSDCodec14.isDelta();
        byte[] byteArray17 = bHSDCodec14.encode((int) '#');
        pack200CompressorOutputStream13.write(byteArray17);
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions19 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        org.apache.commons.compress.harmony.pack200.Archive archive20 = new org.apache.commons.compress.harmony.pack200.Archive(jarFile2, (java.io.OutputStream) pack200CompressorOutputStream13, packingOptions19);
        java.util.jar.JarFile jarFile21 = null;
        java.io.OutputStream outputStream22 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream24 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream22, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry25 = null;
        boolean boolean26 = cpioArchiveOutputStream24.canWriteEntryData(archiveEntry25);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream28 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream24, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream30 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream28, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap31 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream32 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream30, strMap31);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec33 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean34 = bHSDCodec33.isDelta();
        byte[] byteArray36 = bHSDCodec33.encode((int) '#');
        pack200CompressorOutputStream32.write(byteArray36);
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions38 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        org.apache.commons.compress.harmony.pack200.Archive archive39 = new org.apache.commons.compress.harmony.pack200.Archive(jarFile21, (java.io.OutputStream) pack200CompressorOutputStream32, packingOptions38);
        org.apache.commons.compress.harmony.pack200.Archive archive40 = new org.apache.commons.compress.harmony.pack200.Archive(jarInputStream1, (java.io.OutputStream) pack200CompressorOutputStream13, packingOptions38);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream42 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) pack200CompressorOutputStream13, (int) (short) 4);
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker43 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray44 = jarMarker43.getLocalFileDataData();
        pack200CompressorOutputStream13.write(byteArray44);
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField50 = extraFieldParsingMode0.onUnparseableExtraField(byteArray44, (int) (short) 1, (int) (byte) 12, false, 28771);
        org.junit.Assert.assertTrue("'" + extraFieldParsingMode0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT + "'", extraFieldParsingMode0.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT));
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNotNull(bHSDCodec14);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(byteArray17);
        org.junit.Assert.assertArrayEquals(byteArray17, new byte[] { (byte) 35 });
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + true + "'", boolean26 == true);
        org.junit.Assert.assertNotNull(bHSDCodec33);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertNotNull(byteArray36);
        org.junit.Assert.assertArrayEquals(byteArray36, new byte[] { (byte) 35 });
        org.junit.Assert.assertNotNull(byteArray44);
        org.junit.Assert.assertArrayEquals(byteArray44, new byte[] {});
        org.junit.Assert.assertNull(zipExtraField50);
    }

    @Test
    public void test1479() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1479");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry6 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean7 = cpioArchiveOutputStream2.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry6);
        jarArchiveEntry6.setVersionMadeBy(52);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test1480() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1480");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        int int3 = cpioArchiveInputStream1.available();
        int int4 = cpioArchiveInputStream1.available();
        boolean boolean5 = cpioArchiveInputStream1.markSupported();
        long long6 = cpioArchiveInputStream1.getBytesRead();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + long6 + "' != '" + 0L + "'", long6 == 0L);
    }

    @Test
    public void test1481() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1481");
        org.apache.commons.compress.archivers.zip.AsiExtraField asiExtraField0 = new org.apache.commons.compress.archivers.zip.AsiExtraField();
        byte[] byteArray1 = asiExtraField0.getCentralDirectoryData();
        int int2 = asiExtraField0.getGroupId();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = asiExtraField0.getLocalFileDataLength();
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 118, (byte) 104, (byte) -118, (byte) -29, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(zipShort3);
    }

    @Test
    public void test1482() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1482");
        org.apache.commons.compress.compressors.CompressorStreamFactory compressorStreamFactory0 = new org.apache.commons.compress.compressors.CompressorStreamFactory();
        java.util.SortedMap<java.lang.String, org.apache.commons.compress.compressors.CompressorStreamProvider> strMap1 = compressorStreamFactory0.getCompressorOutputStreamProviders();
        java.util.Set<java.lang.String> strSet2 = compressorStreamFactory0.getOutputStreamCompressorNames();
        java.util.SortedMap<java.lang.String, org.apache.commons.compress.compressors.CompressorStreamProvider> strMap3 = compressorStreamFactory0.getCompressorInputStreamProviders();
        org.junit.Assert.assertNotNull(strMap1);
        org.junit.Assert.assertNotNull(strSet2);
        org.junit.Assert.assertNotNull(strMap3);
    }
}
