import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest1 {

    public static boolean debug = false;

    @Test
    public void test0501() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0501");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.XSTAR_ATIME_OFFSET;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 476 + "'", int0 == 476);
    }

    @Test
    public void test0502() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0502");
        java.lang.String str0 = org.apache.commons.compress.java.util.jar.Pack200.Packer.MODIFICATION_TIME;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "pack.modification.time" + "'", str0, "pack.modification.time");
    }

    @Test
    public void test0503() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0503");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipFile zipFile1 = new org.apache.commons.compress.archivers.zip.ZipFile("ACC_STATIC");
            org.junit.Assert.fail("Expected exception of type java.nio.file.NoSuchFileException; message: ACC_STATIC");
        } catch (java.nio.file.NoSuchFileException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0504() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0504");
        org.apache.commons.compress.compressors.zstandard.ZstdUtils.setCacheZstdAvailablity(false);
    }

    @Test
    public void test0505() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0505");
        org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm encryptionAlgorithm0 = org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm.RC2;
        org.junit.Assert.assertTrue("'" + encryptionAlgorithm0 + "' != '" + org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm.RC2 + "'", encryptionAlgorithm0.equals(org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm.RC2));
    }

    @Test
    public void test0506() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0506");
        java.util.ArrayList<java.lang.Comparable<java.lang.String>> strComparableList0 = org.apache.commons.compress.utils.Lists.newArrayList();
        org.junit.Assert.assertNotNull(strComparableList0);
    }

    @Test
    public void test0507() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0507");
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData unparseableExtraFieldData2 = jarArchiveEntry1.getUnparseableExtraFieldData();
        long long3 = jarArchiveEntry1.getCompressedSize();
        java.security.cert.Certificate[] certificateArray4 = jarArchiveEntry1.getCertificates();
        org.junit.Assert.assertNull(unparseableExtraFieldData2);
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + (-1L) + "'", long3 == (-1L));
        org.junit.Assert.assertNull(certificateArray4);
    }

    @Test
    public void test0508() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0508");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.xz.XZCompressorOutputStream xZCompressorOutputStream4 = new org.apache.commons.compress.compressors.xz.XZCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 252);
            org.junit.Assert.fail("Expected exception of type org.tukaani.xz.UnsupportedOptionsException; message: Unsupported preset: 252");
        } catch (org.tukaani.xz.UnsupportedOptionsException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0509() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0509");
        java.io.File file0 = null;
        org.apache.commons.compress.compressors.pack200.Pack200Strategy pack200Strategy1 = org.apache.commons.compress.compressors.pack200.Pack200Strategy.IN_MEMORY;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream pack200CompressorInputStream2 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream(file0, pack200Strategy1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Must specify input stream.");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(pack200Strategy1);
    }

    @Test
    public void test0510() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0510");
        org.apache.commons.compress.harmony.pack200.Segment.PassException passException2 = new org.apache.commons.compress.harmony.pack200.Segment.PassException();
        org.apache.commons.compress.archivers.dump.DumpArchiveException dumpArchiveException3 = new org.apache.commons.compress.archivers.dump.DumpArchiveException("arj", (java.lang.Throwable) passException2);
        org.apache.commons.compress.archivers.ArchiveException archiveException4 = new org.apache.commons.compress.archivers.ArchiveException("ACC_TRANSIENT", (java.lang.Exception) passException2);
    }

    @Test
    public void test0511() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0511");
        java.lang.String str1 = org.apache.commons.compress.compressors.gzip.GzipUtils.getCompressedFileName("ustar ");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "ustar .gz" + "'", str1, "ustar .gz");
    }

    @Test
    public void test0512() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0512");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_0 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_3 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_3);
        java.lang.String str5 = cPUTF8_3.toString();
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_8 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_8);
        org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute newAttribute11 = new org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute(cPUTF8_8, 8);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_15 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_15);
        org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute newAttribute18 = new org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute(cPUTF8_15, 8);
        org.apache.commons.compress.harmony.unpack200.bytecode.Attribute[] attributeArray19 = new org.apache.commons.compress.harmony.unpack200.bytecode.Attribute[] { newAttribute18 };
        java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute> attributeList20 = new java.util.ArrayList<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute>();
        boolean boolean21 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute>) attributeList20, attributeArray19);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPMember cPMember22 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPMember(cPUTF8_3, cPUTF8_8, (long) (byte) 0, (java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute>) attributeList20);
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionsAttribute.setAttributeName(cPUTF8_3);
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.Annotation annotation24 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.Annotation[] annotationArray25 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.Annotation[] { annotation24 };
        org.apache.commons.compress.harmony.unpack200.bytecode.RuntimeVisibleorInvisibleAnnotationsAttribute runtimeVisibleorInvisibleAnnotationsAttribute26 = new org.apache.commons.compress.harmony.unpack200.bytecode.RuntimeVisibleorInvisibleAnnotationsAttribute(cPUTF8_3, annotationArray25);
        org.apache.commons.compress.harmony.unpack200.bytecode.RuntimeVisibleorInvisibleAnnotationsAttribute runtimeVisibleorInvisibleAnnotationsAttribute27 = new org.apache.commons.compress.harmony.unpack200.bytecode.RuntimeVisibleorInvisibleAnnotationsAttribute(cPUTF8_0, annotationArray25);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "UTF-8:splitting" + "'", str5, "UTF-8:splitting");
        org.junit.Assert.assertNotNull(attributeArray19);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + true + "'", boolean21 == true);
        org.junit.Assert.assertNotNull(annotationArray25);
        org.junit.Assert.assertArrayEquals(annotationArray25, new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.Annotation[] { null });
    }

    @Test
    public void test0513() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0513");
        int int0 = org.apache.commons.compress.archivers.tar.TarArchiveOutputStream.LONGFILE_ERROR;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 0 + "'", int0 == 0);
    }

    @Test
    public void test0514() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0514");
        java.lang.String str0 = org.apache.commons.compress.utils.CharsetNames.ISO_8859_1;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "ISO-8859-1" + "'", str0, "ISO-8859-1");
    }

    @Test
    public void test0515() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0515");
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel1 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        long long2 = seekableInMemoryByteChannel1.size();
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel4 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        long long5 = seekableInMemoryByteChannel4.size();
        long long6 = seekableInMemoryByteChannel4.position();
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel8 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        long long9 = seekableInMemoryByteChannel8.size();
        long long10 = seekableInMemoryByteChannel8.position();
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel12 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        org.apache.commons.compress.archivers.tar.TarFile tarFile13 = new org.apache.commons.compress.archivers.tar.TarFile((java.nio.channels.SeekableByteChannel) seekableInMemoryByteChannel12);
        java.nio.channels.SeekableByteChannel[] seekableByteChannelArray14 = new java.nio.channels.SeekableByteChannel[] { seekableInMemoryByteChannel1, seekableInMemoryByteChannel4, seekableInMemoryByteChannel8, seekableInMemoryByteChannel12 };
        // The following exception was thrown during execution in test generation
        try {
            java.nio.channels.SeekableByteChannel seekableByteChannel15 = org.apache.commons.compress.archivers.zip.ZipSplitReadOnlySeekableByteChannel.forOrderedSeekableByteChannels(seekableByteChannelArray14);
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: The first ZIP split segment does not begin with split ZIP file signature");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 96L + "'", long2 == 96L);
        org.junit.Assert.assertTrue("'" + long5 + "' != '" + 96L + "'", long5 == 96L);
        org.junit.Assert.assertTrue("'" + long6 + "' != '" + 0L + "'", long6 == 0L);
        org.junit.Assert.assertTrue("'" + long9 + "' != '" + 96L + "'", long9 == 96L);
        org.junit.Assert.assertTrue("'" + long10 + "' != '" + 0L + "'", long10 == 0L);
        org.junit.Assert.assertNotNull(seekableByteChannelArray14);
    }

    @Test
    public void test0516() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0516");
        java.lang.String str0 = org.apache.commons.compress.utils.CharsetNames.US_ASCII;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "US-ASCII" + "'", str0, "US-ASCII");
    }

    @Test
    public void test0517() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0517");
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger0 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger1 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger2 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry3 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date4 = arjArchiveEntry3.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong5 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date4);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField6 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField(zipEightByteInteger0, zipEightByteInteger1, zipEightByteInteger2, zipLong5);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort7 = zip64ExtendedInformationExtraField6.getCentralDirectoryLength();
        org.junit.Assert.assertNotNull(zipEightByteInteger0);
        org.junit.Assert.assertNotNull(zipEightByteInteger1);
        org.junit.Assert.assertNotNull(zipEightByteInteger2);
        org.junit.Assert.assertNotNull(date4);
        org.junit.Assert.assertEquals(date4.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong5);
        org.junit.Assert.assertNotNull(zipShort7);
    }

    @Test
    public void test0518() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0518");
        java.lang.String str0 = org.apache.commons.compress.harmony.unpack200.AttributeLayout.ATTRIBUTE_DEPRECATED;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "Deprecated" + "'", str0, "Deprecated");
    }

    @Test
    public void test0519() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0519");
        org.apache.commons.compress.archivers.zip.ZipMethod zipMethod0 = org.apache.commons.compress.archivers.zip.ZipMethod.XZ;
        org.junit.Assert.assertTrue("'" + zipMethod0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipMethod.XZ + "'", zipMethod0.equals(org.apache.commons.compress.archivers.zip.ZipMethod.XZ));
    }

    @Test
    public void test0520() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0520");
        org.apache.commons.compress.archivers.zip.X0019_EncryptionRecipientCertificateList x0019_EncryptionRecipientCertificateList0 = new org.apache.commons.compress.archivers.zip.X0019_EncryptionRecipientCertificateList();
        byte[] byteArray1 = x0019_EncryptionRecipientCertificateList0.getLocalFileDataData();
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec2 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean3 = bHSDCodec2.isDelta();
        byte[] byteArray5 = bHSDCodec2.encode((int) '#');
        boolean boolean7 = org.apache.commons.compress.compressors.z.ZCompressorInputStream.matches(byteArray5, 9);
        // The following exception was thrown during execution in test generation
        try {
            x0019_EncryptionRecipientCertificateList0.parseFromLocalFileData(byteArray5, 32, (int) (byte) 55);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: null");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(byteArray1);
        org.junit.Assert.assertNotNull(bHSDCodec2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] { (byte) 35 });
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test0521() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0521");
        org.apache.commons.compress.archivers.zip.UnrecognizedExtraField unrecognizedExtraField0 = new org.apache.commons.compress.archivers.zip.UnrecognizedExtraField();
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode extraFieldParsingMode1 = org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT;
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp2 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime3 = null;
        x5455_ExtendedTimestamp2.setAccessFileTime(fileTime3);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort5 = x5455_ExtendedTimestamp2.getHeaderId();
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField6 = extraFieldParsingMode1.createExtraField(zipShort5);
        byte[] byteArray8 = org.apache.commons.compress.archivers.zip.ZipShort.getBytes(8);
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField13 = extraFieldParsingMode1.onUnparseableExtraField(byteArray8, (int) (byte) -1, 17, true, 0);
        byte[] byteArray14 = org.apache.commons.compress.archivers.zip.ZipUtil.reverse(byteArray8);
        // The following exception was thrown during execution in test generation
        try {
            unrecognizedExtraField0.parseFromLocalFileData(byteArray14, (int) '4', (int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: 52 > 51");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + extraFieldParsingMode1 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT + "'", extraFieldParsingMode1.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT));
        org.junit.Assert.assertNotNull(zipShort5);
        org.junit.Assert.assertNotNull(zipExtraField6);
        org.junit.Assert.assertNotNull(byteArray8);
        org.junit.Assert.assertArrayEquals(byteArray8, new byte[] { (byte) 0, (byte) 8 });
        org.junit.Assert.assertNull(zipExtraField13);
        org.junit.Assert.assertNotNull(byteArray14);
        org.junit.Assert.assertArrayEquals(byteArray14, new byte[] { (byte) 0, (byte) 8 });
    }

    @Test
    public void test0522() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0522");
        java.nio.file.Path path0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipFile zipFile2 = new org.apache.commons.compress.archivers.zip.ZipFile(path0, "keep");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0523() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0523");
        int int1 = org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream.chooseBlockSize((long) (short) -1);
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 9 + "'", int1 == 9);
    }

    @Test
    public void test0524() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0524");
        org.apache.commons.compress.archivers.dump.ShortFileException shortFileException0 = new org.apache.commons.compress.archivers.dump.ShortFileException();
    }

    @Test
    public void test0525() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0525");
        org.apache.commons.compress.harmony.pack200.BHSDCodec[] bHSDCodecArray0 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaDoubleSignedCodecs1;
        org.junit.Assert.assertNotNull(bHSDCodecArray0);
    }

    @Test
    public void test0526() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0526");
        org.apache.commons.compress.archivers.zip.ZipMethod zipMethod1 = org.apache.commons.compress.archivers.zip.ZipMethod.getMethodByCode(8192);
        org.junit.Assert.assertNull(zipMethod1);
    }

    @Test
    public void test0527() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0527");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("error", false);
        java.util.Date date3 = tarArchiveEntry2.getModTime();
        byte[] byteArray10 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean12 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray10, 0);
        java.nio.charset.Charset charset13 = null;
        org.apache.commons.compress.archivers.zip.ZipEncoding zipEncoding14 = org.apache.commons.compress.archivers.zip.ZipEncodingHelper.getZipEncoding(charset13);
        byte[] byteArray20 = new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 };
        byte[] byteArray27 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean29 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray27, 0);
        boolean boolean30 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray20, byteArray27);
        java.lang.String str31 = zipEncoding14.decode(byteArray20);
        // The following exception was thrown during execution in test generation
        try {
            tarArchiveEntry2.writeEntryHeader(byteArray10, zipEncoding14, true);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 6");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(date3);
// flaky "1) test0527(RegressionTest1)":         org.junit.Assert.assertEquals(date3.toString(), "Fri Mar 14 23:47:19 AEDT 2025");
        org.junit.Assert.assertNotNull(byteArray10);
        org.junit.Assert.assertArrayEquals(byteArray10, new byte[] { (byte) 101, (byte) 114, (byte) 114, (byte) 111, (byte) 114, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(zipEncoding14);
        org.junit.Assert.assertNotNull(byteArray20);
        org.junit.Assert.assertArrayEquals(byteArray20, new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 });
        org.junit.Assert.assertNotNull(byteArray27);
        org.junit.Assert.assertArrayEquals(byteArray27, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertEquals("'" + str31 + "' != '" + "\002?\002\n\001" + "'", str31, "\002?\002\n\001");
    }

    @Test
    public void test0528() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0528");
        java.lang.String str0 = org.apache.commons.compress.compressors.CompressorStreamFactory.BROTLI;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "br" + "'", str0, "br");
    }

    @Test
    public void test0529() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0529");
        org.apache.commons.compress.harmony.unpack200.bytecode.ClassConstantPool classConstantPool0 = new org.apache.commons.compress.harmony.unpack200.bytecode.ClassConstantPool();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry classFileEntry2 = classConstantPool0.get(1000);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: Constant pool is not yet resolved; this does not make any sense");
        } catch (java.lang.IllegalStateException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0530() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0530");
        org.apache.commons.compress.archivers.ArchiveStreamFactory archiveStreamFactory1 = new org.apache.commons.compress.archivers.ArchiveStreamFactory(" \000");
        java.io.InputStream inputStream3 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream4 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream3);
        int int5 = cpioArchiveInputStream4.getCount();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream8 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream4, (long) 1, (long) 148);
        org.apache.commons.compress.utils.CloseShieldFilterInputStream closeShieldFilterInputStream9 = new org.apache.commons.compress.utils.CloseShieldFilterInputStream((java.io.InputStream) cpioArchiveInputStream4);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.ArchiveInputStream<org.apache.commons.compress.archivers.cpio.CpioArchiveEntry> cpioArchiveEntryArchiveInputStream11 = archiveStreamFactory1.createArchiveInputStream("impdep2", (java.io.InputStream) cpioArchiveInputStream4, "ACC_STATIC");
            org.junit.Assert.fail("Expected exception of type org.apache.commons.compress.archivers.ArchiveException; message: Archiver: impdep2 not found.");
        } catch (org.apache.commons.compress.archivers.ArchiveException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test0531() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0531");
        org.apache.commons.compress.archivers.examples.Archiver archiver0 = new org.apache.commons.compress.archivers.examples.Archiver();
        org.apache.commons.compress.archivers.sevenz.SevenZOutputFile sevenZOutputFile1 = null;
        java.nio.file.Path path2 = null;
        // The following exception was thrown during execution in test generation
        try {
            archiver0.create(sevenZOutputFile1, path2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0532() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0532");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime1 = null;
        x5455_ExtendedTimestamp0.setAccessFileTime(fileTime1);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = x5455_ExtendedTimestamp0.getLocalFileDataLength();
        java.nio.file.attribute.FileTime fileTime4 = x5455_ExtendedTimestamp0.getCreateFileTime();
        java.nio.file.attribute.FileTime fileTime5 = x5455_ExtendedTimestamp0.getAccessFileTime();
        org.junit.Assert.assertNotNull(zipShort3);
        org.junit.Assert.assertNull(fileTime4);
        org.junit.Assert.assertNull(fileTime5);
    }

    @Test
    public void test0533() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0533");
        java.nio.file.Path path1 = null;
        org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier defaultBackingStoreSupplier2 = new org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier(path1);
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore3 = defaultBackingStoreSupplier2.get();
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore4 = defaultBackingStoreSupplier2.get();
        org.apache.commons.compress.archivers.zip.StreamCompressor streamCompressor5 = org.apache.commons.compress.archivers.zip.StreamCompressor.create(0, scatterGatherBackingStore4);
        byte[] byteArray9 = new byte[] { (byte) 10, (byte) 10, (byte) -1 };
        boolean boolean11 = org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.matches(byteArray9, (int) (short) -1);
        byte[] byteArray12 = org.apache.commons.compress.archivers.zip.ZipUtil.reverse(byteArray9);
        // The following exception was thrown during execution in test generation
        try {
            scatterGatherBackingStore4.writeOut(byteArray9, (int) (short) 1, 256);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: null");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(scatterGatherBackingStore3);
        org.junit.Assert.assertNotNull(scatterGatherBackingStore4);
        org.junit.Assert.assertNotNull(streamCompressor5);
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertArrayEquals(byteArray9, new byte[] { (byte) -1, (byte) 10, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(byteArray12);
        org.junit.Assert.assertArrayEquals(byteArray12, new byte[] { (byte) -1, (byte) 10, (byte) 10 });
    }

    @Test
    public void test0534() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0534");
        org.apache.commons.compress.archivers.zip.ZipLong zipLong0 = org.apache.commons.compress.archivers.zip.ZipLong.AED_SIG;
        boolean boolean2 = zipLong0.equals((java.lang.Object) "pass");
        java.lang.Object obj3 = null;
        boolean boolean4 = zipLong0.equals(obj3);
        org.junit.Assert.assertNotNull(zipLong0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test0535() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0535");
        java.nio.file.Path path0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipFile zipFile4 = new org.apache.commons.compress.archivers.zip.ZipFile(path0, "ACC_PROTECTED", false, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0536() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0536");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime1 = null;
        x5455_ExtendedTimestamp0.setAccessFileTime(fileTime1);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = x5455_ExtendedTimestamp0.getLocalFileDataLength();
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry6 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        java.lang.String str7 = dumpArchiveEntry6.toString();
        int int8 = dumpArchiveEntry6.getHeaderHoles();
        java.util.Date date9 = dumpArchiveEntry6.getAccessTime();
        // The following exception was thrown during execution in test generation
        try {
            x5455_ExtendedTimestamp0.setModifyJavaTime(date9);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.file.attribute.FileTimes.isUnixTime(J)Z");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(zipShort3);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "jar" + "'", str7, "jar");
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(date9);
        org.junit.Assert.assertEquals(date9.toString(), "Thu Jan 01 10:00:00 AEST 1970");
    }

    @Test
    public void test0537() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0537");
        byte[] byteArray1 = org.apache.commons.compress.utils.ArchiveUtils.toAsciiBytes("cpio");
        int int2 = org.apache.commons.compress.archivers.zip.ZipShort.getValue(byteArray1);
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 99, (byte) 112, (byte) 105, (byte) 111 });
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 28771 + "'", int2 == 28771);
    }

    @Test
    public void test0538() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0538");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("LocalVariableTypeTable", 6);
    }

    @Test
    public void test0539() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0539");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        java.lang.String str3 = dumpArchiveEntry2.toString();
        boolean boolean4 = dumpArchiveEntry2.isBlkDev();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "jar" + "'", str3, "jar");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test0540() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0540");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec3 = new org.apache.commons.compress.harmony.pack200.BHSDCodec(493, 2, 476);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: 1<=b<=5");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0541() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0541");
        org.apache.commons.compress.archivers.examples.Archiver archiver0 = new org.apache.commons.compress.archivers.examples.Archiver();
        java.io.OutputStream outputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream3 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream1, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry4 = null;
        boolean boolean5 = cpioArchiveOutputStream3.canWriteEntryData(archiveEntry4);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream7 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream3, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream9 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream3, 4);
        org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream deflateCompressorOutputStream10 = new org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream3);
        java.io.File file11 = null;
        // The following exception was thrown during execution in test generation
        try {
            archiver0.create((org.apache.commons.compress.archivers.ArchiveOutputStream<org.apache.commons.compress.archivers.cpio.CpioArchiveEntry>) cpioArchiveOutputStream3, file11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test0542() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0542");
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
        // The following exception was thrown during execution in test generation
        try {
            snappyCompressorOutputStream13.close();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test0543() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0543");
        org.apache.commons.compress.compressors.deflate.DeflateParameters deflateParameters0 = new org.apache.commons.compress.compressors.deflate.DeflateParameters();
        deflateParameters0.setCompressionLevel(4);
        boolean boolean3 = deflateParameters0.withZlibHeader();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test0544() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0544");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        java.lang.String str1 = sevenZArchiveEntry0.getName();
        sevenZArchiveEntry0.setHasCrc(false);
        boolean boolean4 = sevenZArchiveEntry0.getHasWindowsAttributes();
        sevenZArchiveEntry0.setLastModifiedDate((long) ' ');
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test0545() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0545");
        java.io.File file0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream2 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream(file0, 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0546() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0546");
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode extraFieldParsingMode0 = org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT;
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp1 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime2 = null;
        x5455_ExtendedTimestamp1.setAccessFileTime(fileTime2);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort4 = x5455_ExtendedTimestamp1.getHeaderId();
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField5 = extraFieldParsingMode0.createExtraField(zipShort4);
        byte[] byteArray7 = org.apache.commons.compress.archivers.zip.ZipShort.getBytes(8);
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField12 = extraFieldParsingMode0.onUnparseableExtraField(byteArray7, (int) (byte) -1, 17, true, 0);
        byte[] byteArray13 = org.apache.commons.compress.archivers.zip.ZipUtil.reverse(byteArray7);
        // The following exception was thrown during execution in test generation
        try {
            long long14 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.getLongValue(byteArray13);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: null");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + extraFieldParsingMode0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT + "'", extraFieldParsingMode0.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT));
        org.junit.Assert.assertNotNull(zipShort4);
        org.junit.Assert.assertNotNull(zipExtraField5);
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) 0, (byte) 8 });
        org.junit.Assert.assertNull(zipExtraField12);
        org.junit.Assert.assertNotNull(byteArray13);
        org.junit.Assert.assertArrayEquals(byteArray13, new byte[] { (byte) 0, (byte) 8 });
    }

    @Test
    public void test0547() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0547");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream8 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 4);
        org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream deflateCompressorOutputStream9 = new org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        byte[] byteArray11 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(0L);
        boolean boolean13 = org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.matches(byteArray11, 52);
        org.apache.commons.compress.archivers.tar.TarFile tarFile14 = new org.apache.commons.compress.archivers.tar.TarFile(byteArray11);
        // The following exception was thrown during execution in test generation
        try {
            deflateCompressorOutputStream9.write(byteArray11);
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: No current CPIO entry");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(byteArray11);
        org.junit.Assert.assertArrayEquals(byteArray11, new byte[] { (byte) 0, (byte) 0, (byte) 33, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test0548() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0548");
        org.apache.commons.compress.archivers.dump.UnrecognizedFormatException unrecognizedFormatException1 = new org.apache.commons.compress.archivers.dump.UnrecognizedFormatException();
        org.apache.commons.compress.archivers.ArchiveException archiveException2 = new org.apache.commons.compress.archivers.ArchiveException("xz", (java.lang.Exception) unrecognizedFormatException1);
    }

    @Test
    public void test0549() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0549");
        int int0 = org.apache.commons.compress.archivers.dump.DumpArchiveConstants.NFS_MAGIC;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 60012 + "'", int0 == 60012);
    }

    @Test
    public void test0550() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0550");
        java.lang.String str1 = org.apache.commons.compress.compressors.lzma.LZMAUtils.getCompressedFileName("pack.deflate.hint");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "pack.deflate.hint.lzma" + "'", str1, "pack.deflate.hint.lzma");
    }

    @Test
    public void test0551() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0551");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        long long3 = cpioArchiveInputStream1.skip((long) 8);
        org.apache.commons.compress.utils.CountingInputStream countingInputStream4 = new org.apache.commons.compress.utils.CountingInputStream((java.io.InputStream) cpioArchiveInputStream1);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray6 = org.apache.commons.compress.utils.IOUtils.readRange((java.io.InputStream) cpioArchiveInputStream1, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.IOUtils.copyLarge(Ljava/io/InputStream;Ljava/io/OutputStream;JJ)J");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
    }

    @Test
    public void test0552() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0552");
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField2 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField();
        jarArchiveEntry1.addExtraField((org.apache.commons.compress.archivers.zip.ZipExtraField) unicodeCommentExtraField2);
        boolean boolean4 = jarArchiveEntry1.isStreamContiguous();
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp5 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime6 = null;
        x5455_ExtendedTimestamp5.setAccessFileTime(fileTime6);
        org.apache.commons.compress.archivers.zip.ZipLong zipLong8 = org.apache.commons.compress.archivers.zip.ZipLong.AED_SIG;
        boolean boolean10 = zipLong8.equals((java.lang.Object) "pass");
        x5455_ExtendedTimestamp5.setCreateTime(zipLong8);
        // The following exception was thrown during execution in test generation
        try {
            jarArchiveEntry1.addAsFirstExtraField((org.apache.commons.compress.archivers.zip.ZipExtraField) x5455_ExtendedTimestamp5);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.file.attribute.FileTimes.fromUnixTime(J)Ljava/nio/file/attribute/FileTime;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(zipLong8);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test0553() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0553");
        byte byte0 = org.apache.commons.compress.archivers.tar.TarConstants.LF_GNUTYPE_LONGLINK;
        org.junit.Assert.assertTrue("'" + byte0 + "' != '" + (byte) 75 + "'", byte0 == (byte) 75);
    }

    @Test
    public void test0554() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0554");
        int[] intArray6 = new int[] { ' ', (byte) -1 };
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm iMethodRefForm7 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm((int) (byte) -1, "", intArray6);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.FieldRefForm fieldRefForm8 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.FieldRefForm(10, "070701", intArray6);
        int int9 = fieldRefForm8.getOpcode();
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode11 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int12 = byteCode11.getByteCodeIndex();
        int[] intArray13 = new int[] {};
        int[] intArray14 = new int[] {};
        int[] intArray15 = new int[] {};
        int[][] intArray16 = new int[][] { intArray13, intArray14, intArray15 };
        byteCode11.setNestedPositions(intArray16);
        int[] intArray18 = byteCode11.getRewrite();
        boolean boolean20 = byteCode11.equals((java.lang.Object) (byte) 7);
        org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager operandManager21 = null;
        // The following exception was thrown during execution in test generation
        try {
            fieldRefForm8.setByteCodeOperands(byteCode11, operandManager21, 17);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertArrayEquals(intArray6, new int[] { 32, (-1) });
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 10 + "'", int9 == 10);
        org.junit.Assert.assertNotNull(byteCode11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + (-1) + "'", int12 == (-1));
        org.junit.Assert.assertNotNull(intArray13);
        org.junit.Assert.assertArrayEquals(intArray13, new int[] {});
        org.junit.Assert.assertNotNull(intArray14);
        org.junit.Assert.assertArrayEquals(intArray14, new int[] {});
        org.junit.Assert.assertNotNull(intArray15);
        org.junit.Assert.assertArrayEquals(intArray15, new int[] {});
        org.junit.Assert.assertNotNull(intArray16);
        org.junit.Assert.assertNotNull(intArray18);
        org.junit.Assert.assertArrayEquals(intArray18, new int[] { 255 });
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test0555() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0555");
        byte byte0 = org.apache.commons.compress.archivers.tar.TarConstants.LF_MULTIVOLUME;
        org.junit.Assert.assertTrue("'" + byte0 + "' != '" + (byte) 77 + "'", byte0 == (byte) 77);
    }

    @Test
    public void test0556() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0556");
        org.apache.commons.compress.harmony.pack200.Segment segment0 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands2 = new org.apache.commons.compress.harmony.pack200.CpBands(segment0, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature4 = cpBands2.getCPSignature("ustar\000");
        int int5 = cPSignature4.getIndexInCpUtf8();
        org.junit.Assert.assertNotNull(cPSignature4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + (-1) + "'", int5 == (-1));
    }

    @Test
    public void test0557() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0557");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        boolean boolean3 = dumpArchiveEntry2.isDirectory();
        dumpArchiveEntry2.setName("FieldRef: null#null");
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test0558() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0558");
        long long0 = org.apache.commons.compress.harmony.pack200.PackingOptions.SEGMENT_LIMIT;
        org.junit.Assert.assertTrue("'" + long0 + "' != '" + 1000000L + "'", long0 == 1000000L);
    }

    @Test
    public void test0559() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0559");
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField0 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort1 = zip64ExtendedInformationExtraField0.getLocalFileDataLength();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort2 = zip64ExtendedInformationExtraField0.getLocalFileDataLength();
        org.junit.Assert.assertNotNull(zipShort1);
        org.junit.Assert.assertNotNull(zipShort2);
    }

    @Test
    public void test0560() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0560");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream3 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream4 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        java.nio.file.Path path5 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long6 = cpioArchiveOutputStream2.write(path5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0561() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0561");
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField2 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField();
        jarArchiveEntry1.addExtraField((org.apache.commons.compress.archivers.zip.ZipExtraField) unicodeCommentExtraField2);
        long long4 = jarArchiveEntry1.getSize();
        org.apache.commons.compress.archivers.zip.GeneralPurposeBit generalPurposeBit5 = null;
        jarArchiveEntry1.setGeneralPurposeBit(generalPurposeBit5);
        org.junit.Assert.assertTrue("'" + long4 + "' != '" + (-1L) + "'", long4 == (-1L));
    }

    @Test
    public void test0562() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0562");
        byte[] byteArray6 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean8 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray6, 0);
        boolean boolean10 = org.apache.commons.compress.archivers.ar.ArArchiveInputStream.matches(byteArray6, 1000);
        boolean boolean12 = org.apache.commons.compress.compressors.xz.XZCompressorInputStream.matches(byteArray6, (int) 'a');
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test0563() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0563");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream4 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream((java.io.InputStream) cpioArchiveInputStream1, "lz4-block");
            org.junit.Assert.fail("Expected exception of type java.nio.charset.UnsupportedCharsetException; message: lz4-block");
        } catch (java.nio.charset.UnsupportedCharsetException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test0564() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0564");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream8 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream6, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap9 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream10 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream8, strMap9);
        java.io.File file11 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long12 = pack200CompressorOutputStream10.write(file11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test0565() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0565");
        org.apache.commons.compress.archivers.examples.Expander expander0 = new org.apache.commons.compress.archivers.examples.Expander();
        org.apache.commons.compress.archivers.sevenz.SevenZFile sevenZFile1 = null;
        java.nio.file.Path path2 = null;
        // The following exception was thrown during execution in test generation
        try {
            expander0.expand(sevenZFile1, path2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0566() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0566");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.cpio.CpioArchiveEntry cpioArchiveEntry2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveEntry((short) (byte) 0, "pack.progress");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Unknown header type 0");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0567() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0567");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        byte[] byteArray2 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream1);
        long long3 = cpioArchiveInputStream1.getBytesRead();
        java.io.OutputStream outputStream5 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream7 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream5, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry8 = null;
        boolean boolean9 = cpioArchiveOutputStream7.canWriteEntryData(archiveEntry8);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream11 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream7, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream13 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream11, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap14 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream15 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream13, strMap14);
        boolean boolean16 = pack200CompressorOutputStream15.isClosed();
        // The following exception was thrown during execution in test generation
        try {
            long long18 = org.apache.commons.compress.utils.IOUtils.copyRange((java.io.InputStream) cpioArchiveInputStream1, (long) (byte) 55, (java.io.OutputStream) pack200CompressorOutputStream15, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: bufferSize must be bigger than 0");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test0568() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0568");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        long long3 = cpioArchiveInputStream1.getBytesRead();
        org.apache.commons.compress.utils.CloseShieldFilterInputStream closeShieldFilterInputStream4 = new org.apache.commons.compress.utils.CloseShieldFilterInputStream((java.io.InputStream) cpioArchiveInputStream1);
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode extraFieldParsingMode5 = org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_LENIENT;
        byte[] byteArray11 = new byte[] { (byte) 2, (byte) 7, (byte) 100, (byte) 7, (byte) 1 };
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField16 = extraFieldParsingMode5.onUnparseableExtraField(byteArray11, 17, 0, true, 0);
        // The following exception was thrown during execution in test generation
        try {
            int int19 = cpioArchiveInputStream1.read(byteArray11, (int) (byte) 75, 9);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: null");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertNotNull(extraFieldParsingMode5);
        org.junit.Assert.assertNotNull(byteArray11);
        org.junit.Assert.assertArrayEquals(byteArray11, new byte[] { (byte) 2, (byte) 7, (byte) 100, (byte) 7, (byte) 1 });
        org.junit.Assert.assertNull(zipExtraField16);
    }

    @Test
    public void test0569() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0569");
        boolean boolean1 = org.apache.commons.compress.compressors.xz.XZUtils.isCompressedFileName("pack.keep.file.order");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0570() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0570");
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader0 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        segmentHeader0.setCp_Int_count(96);
        int int3 = segmentHeader0.getDefaultMajorVersion();
        boolean boolean4 = segmentHeader0.have_file_modtime();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test0571() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0571");
        org.apache.commons.compress.harmony.unpack200.AttributeLayoutMap attributeLayoutMap0 = new org.apache.commons.compress.harmony.unpack200.AttributeLayoutMap();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.unpack200.AttributeLayout attributeLayout3 = attributeLayoutMap0.getAttributeLayout("error", 96);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 96");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0572() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0572");
        org.apache.commons.compress.compressors.CompressorStreamFactory compressorStreamFactory0 = new org.apache.commons.compress.compressors.CompressorStreamFactory();
        java.io.InputStream inputStream2 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream3 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream2);
        int int4 = cpioArchiveInputStream3.getCount();
        int int5 = cpioArchiveInputStream3.available();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.CompressorInputStream compressorInputStream6 = compressorStreamFactory0.createCompressorInputStream("", (java.io.InputStream) cpioArchiveInputStream3);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.compress.compressors.CompressorException; message: Compressor:  not found.");
        } catch (org.apache.commons.compress.compressors.CompressorException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
    }

    @Test
    public void test0573() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0573");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        int int3 = cpioArchiveInputStream1.available();
        int int4 = cpioArchiveInputStream1.available();
        boolean boolean5 = cpioArchiveInputStream1.markSupported();
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode extraFieldParsingMode6 = org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT;
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp7 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime8 = null;
        x5455_ExtendedTimestamp7.setAccessFileTime(fileTime8);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort10 = x5455_ExtendedTimestamp7.getHeaderId();
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField11 = extraFieldParsingMode6.createExtraField(zipShort10);
        byte[] byteArray13 = org.apache.commons.compress.archivers.zip.ZipShort.getBytes(8);
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField18 = extraFieldParsingMode6.onUnparseableExtraField(byteArray13, (int) (byte) -1, 17, true, 0);
        // The following exception was thrown during execution in test generation
        try {
            int int21 = cpioArchiveInputStream1.read(byteArray13, 60012, (int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: null");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + extraFieldParsingMode6 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT + "'", extraFieldParsingMode6.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT));
        org.junit.Assert.assertNotNull(zipShort10);
        org.junit.Assert.assertNotNull(zipExtraField11);
        org.junit.Assert.assertNotNull(byteArray13);
        org.junit.Assert.assertArrayEquals(byteArray13, new byte[] { (byte) 8, (byte) 0 });
        org.junit.Assert.assertNull(zipExtraField18);
    }

    @Test
    public void test0574() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0574");
        org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream.BlockSize blockSize0 = null;
        org.apache.commons.compress.compressors.lz77support.Parameters parameters1 = null;
        org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream.Parameters parameters2 = new org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream.Parameters(blockSize0, parameters1);
        java.lang.String str3 = parameters2.toString();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "LZ4 Parameters with BlockSize null, withContentChecksum true, withBlockChecksum false, withBlockDependency false" + "'", str3, "LZ4 Parameters with BlockSize null, withContentChecksum true, withBlockChecksum false, withBlockDependency false");
    }

    @Test
    public void test0575() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0575");
        org.apache.commons.compress.archivers.sevenz.SevenZMethod sevenZMethod0 = org.apache.commons.compress.archivers.sevenz.SevenZMethod.BCJ_ARM_THUMB_FILTER;
        org.junit.Assert.assertTrue("'" + sevenZMethod0 + "' != '" + org.apache.commons.compress.archivers.sevenz.SevenZMethod.BCJ_ARM_THUMB_FILTER + "'", sevenZMethod0.equals(org.apache.commons.compress.archivers.sevenz.SevenZMethod.BCJ_ARM_THUMB_FILTER));
    }

    @Test
    public void test0576() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0576");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        int int3 = cpioArchiveInputStream1.available();
        int int4 = cpioArchiveInputStream1.available();
        boolean boolean5 = cpioArchiveInputStream1.markSupported();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.z.ZCompressorInputStream zCompressorInputStream7 = new org.apache.commons.compress.compressors.z.ZCompressorInputStream((java.io.InputStream) cpioArchiveInputStream1, 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test0577() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0577");
        org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm hashAlgorithm0 = org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm.RIPEND160;
        org.junit.Assert.assertTrue("'" + hashAlgorithm0 + "' != '" + org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm.RIPEND160 + "'", hashAlgorithm0.equals(org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm.RIPEND160));
    }

    @Test
    public void test0578() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0578");
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode1 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int2 = byteCode1.getByteCodeIndex();
        int[] intArray3 = new int[] {};
        int[] intArray4 = new int[] {};
        int[] intArray5 = new int[] {};
        int[][] intArray6 = new int[][] { intArray3, intArray4, intArray5 };
        byteCode1.setNestedPositions(intArray6);
        // The following exception was thrown during execution in test generation
        try {
            byteCode1.setOperandSigned2Bytes(2, (int) (byte) 2);
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
    }

    @Test
    public void test0579() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0579");
        byte[] byteArray6 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean8 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray6, 0);
        boolean boolean10 = org.apache.commons.compress.archivers.ar.ArArchiveInputStream.matches(byteArray6, 1000);
        boolean boolean12 = org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorInputStream.matches(byteArray6, 21);
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test0580() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0580");
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel1 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        org.apache.commons.compress.archivers.tar.TarFile tarFile2 = new org.apache.commons.compress.archivers.tar.TarFile((java.nio.channels.SeekableByteChannel) seekableInMemoryByteChannel1);
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.Builder builder3 = org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.builder();
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.Builder builder5 = builder3.withMaxMemoryLimitInKb(1000);
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions sevenZFileOptions6 = builder3.build();
        int int7 = sevenZFileOptions6.getMaxMemoryLimitInKb();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZFile sevenZFile8 = new org.apache.commons.compress.archivers.sevenz.SevenZFile((java.nio.channels.SeekableByteChannel) seekableInMemoryByteChannel1, sevenZFileOptions6);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.IOUtils.read(Ljava/nio/channels/ReadableByteChannel;Ljava/nio/ByteBuffer;)I");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder3);
        org.junit.Assert.assertNotNull(builder5);
        org.junit.Assert.assertNotNull(sevenZFileOptions6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 1000 + "'", int7 == 1000);
    }

    @Test
    public void test0581() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0581");
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions0 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        packingOptions0.setLogFile("ar");
        packingOptions0.setVerbose(true);
        java.lang.String str5 = packingOptions0.getLogFile();
        boolean boolean6 = packingOptions0.isVerbose();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "ar" + "'", str5, "ar");
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test0582() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0582");
        int int0 = org.apache.commons.compress.archivers.cpio.CpioConstants.S_IFMT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 61440 + "'", int0 == 61440);
    }

    @Test
    public void test0583() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0583");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime1 = null;
        x5455_ExtendedTimestamp0.setAccessFileTime(fileTime1);
        byte[] byteArray3 = x5455_ExtendedTimestamp0.getLocalFileDataData();
        java.nio.charset.Charset charset6 = null;
        org.apache.commons.compress.archivers.zip.ZipEncoding zipEncoding7 = org.apache.commons.compress.archivers.zip.ZipEncodingHelper.getZipEncoding(charset6);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str8 = org.apache.commons.compress.archivers.tar.TarUtils.parseName(byteArray3, 21, 493, zipEncoding7);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 21");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 0 });
        org.junit.Assert.assertNotNull(zipEncoding7);
    }

    @Test
    public void test0584() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0584");
        java.nio.file.Path path2 = null;
        org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier defaultBackingStoreSupplier3 = new org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier(path2);
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore4 = defaultBackingStoreSupplier3.get();
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore5 = defaultBackingStoreSupplier3.get();
        org.apache.commons.compress.archivers.zip.StreamCompressor streamCompressor6 = org.apache.commons.compress.archivers.zip.StreamCompressor.create(0, scatterGatherBackingStore5);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.StreamCompressor streamCompressor7 = org.apache.commons.compress.archivers.zip.StreamCompressor.create((int) (short) 100, scatterGatherBackingStore5);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(scatterGatherBackingStore4);
        org.junit.Assert.assertNotNull(scatterGatherBackingStore5);
        org.junit.Assert.assertNotNull(streamCompressor6);
    }

    @Test
    public void test0585() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0585");
        org.apache.commons.compress.archivers.zip.UnrecognizedExtraField unrecognizedExtraField0 = new org.apache.commons.compress.archivers.zip.UnrecognizedExtraField();
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp1 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime2 = null;
        x5455_ExtendedTimestamp1.setAccessFileTime(fileTime2);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort4 = x5455_ExtendedTimestamp1.getHeaderId();
        unrecognizedExtraField0.setHeaderId(zipShort4);
        byte[] byteArray6 = unrecognizedExtraField0.getLocalFileDataData();
        org.junit.Assert.assertNotNull(zipShort4);
        org.junit.Assert.assertNull(byteArray6);
    }

    @Test
    public void test0586() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0586");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream8 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 4);
        org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream deflateCompressorOutputStream9 = new org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        // The following exception was thrown during execution in test generation
        try {
            deflateCompressorOutputStream9.flush();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test0587() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0587");
        org.apache.commons.compress.utils.FileNameUtils fileNameUtils0 = new org.apache.commons.compress.utils.FileNameUtils();
    }

    @Test
    public void test0588() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0588");
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker0 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray1 = jarMarker0.getCentralDirectoryData();
        byte[] byteArray2 = jarMarker0.getLocalFileDataData();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = new org.apache.commons.compress.archivers.zip.ZipShort(byteArray2);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 0");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] {});
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
    }

    @Test
    public void test0589() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0589");
        java.io.File file0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ScatterZipOutputStream scatterZipOutputStream2 = org.apache.commons.compress.archivers.zip.ScatterZipOutputStream.fileBased(file0, 488);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0590() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0590");
        org.apache.commons.compress.archivers.examples.Expander expander0 = new org.apache.commons.compress.archivers.examples.Expander();
        java.io.InputStream inputStream2 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream3 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream2);
        byte[] byteArray4 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream3);
        long long5 = cpioArchiveInputStream3.getBytesRead();
        int int6 = cpioArchiveInputStream3.getCount();
        boolean boolean7 = cpioArchiveInputStream3.markSupported();
        java.io.OutputStream outputStream8 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream10 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream8, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry11 = null;
        boolean boolean12 = cpioArchiveOutputStream10.canWriteEntryData(archiveEntry11);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream14 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream10, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream16 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream14, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap17 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream18 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream16, strMap17);
        long long19 = org.apache.commons.compress.utils.IOUtils.copy((java.io.InputStream) cpioArchiveInputStream3, (java.io.OutputStream) pack200CompressorOutputStream18);
        java.io.File file20 = null;
        org.apache.commons.compress.archivers.examples.CloseableConsumer closeableConsumer21 = org.apache.commons.compress.archivers.examples.CloseableConsumer.NULL_CONSUMER;
        // The following exception was thrown during execution in test generation
        try {
            expander0.expand("\001", (java.io.InputStream) cpioArchiveInputStream3, file20, closeableConsumer21);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.compress.archivers.ArchiveException; message: Archiver: ? not found.");
        } catch (org.apache.commons.compress.archivers.ArchiveException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] {});
        org.junit.Assert.assertTrue("'" + long5 + "' != '" + 0L + "'", long5 == 0L);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + long19 + "' != '" + 0L + "'", long19 == 0L);
        org.junit.Assert.assertNotNull(closeableConsumer21);
    }

    @Test
    public void test0591() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0591");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.VERSION_OFFSET;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 263 + "'", int0 == 263);
    }

    @Test
    public void test0592() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0592");
        org.apache.commons.compress.archivers.zip.ZipMethod zipMethod0 = org.apache.commons.compress.archivers.zip.ZipMethod.LZMA;
        org.junit.Assert.assertTrue("'" + zipMethod0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipMethod.LZMA + "'", zipMethod0.equals(org.apache.commons.compress.archivers.zip.ZipMethod.LZMA));
    }

    @Test
    public void test0593() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0593");
        boolean boolean1 = org.apache.commons.compress.compressors.bzip2.BZip2Utils.isCompressedFilename("ACC_STRICT");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0594() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0594");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS0 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.AMIGA;
        org.junit.Assert.assertTrue("'" + oS0 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.AMIGA + "'", oS0.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.AMIGA));
    }

    @Test
    public void test0595() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0595");
        boolean boolean1 = org.apache.commons.compress.compressors.lzma.LZMAUtils.isCompressedFilename("impdep2");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0596() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0596");
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode1 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int2 = byteCode1.getByteCodeIndex();
        int[] intArray3 = new int[] {};
        int[] intArray4 = new int[] {};
        int[] intArray5 = new int[] {};
        int[][] intArray6 = new int[][] { intArray3, intArray4, intArray5 };
        byteCode1.setNestedPositions(intArray6);
        int[] intArray8 = byteCode1.getRewrite();
        int[] intArray9 = byteCode1.getByteCodeTargets();
        int int10 = byteCode1.getOpcode();
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
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 255 + "'", int10 == 255);
    }

    @Test
    public void test0597() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0597");
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker1 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray2 = jarMarker1.getCentralDirectoryData();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField3 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger4 = zip64ExtendedInformationExtraField3.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger5 = null;
        zip64ExtendedInformationExtraField3.setSize(zipEightByteInteger5);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField7 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField8 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger9 = zip64ExtendedInformationExtraField8.getCompressedSize();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField10 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger11 = zip64ExtendedInformationExtraField10.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger12 = null;
        zip64ExtendedInformationExtraField10.setSize(zipEightByteInteger12);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField14 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger15 = zip64ExtendedInformationExtraField14.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger16 = null;
        zip64ExtendedInformationExtraField14.setSize(zipEightByteInteger16);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField18 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipExtraField[] zipExtraFieldArray19 = new org.apache.commons.compress.archivers.zip.ZipExtraField[] { zip64ExtendedInformationExtraField3, zip64ExtendedInformationExtraField7, zip64ExtendedInformationExtraField8, zip64ExtendedInformationExtraField10, zip64ExtendedInformationExtraField14, zip64ExtendedInformationExtraField18 };
        byte[] byteArray20 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.mergeLocalFileDataData(zipExtraFieldArray19);
        boolean boolean21 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray2, byteArray20);
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField24 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField("ustar\000", byteArray20, 0, 9);
        byte[] byteArray25 = unicodeCommentExtraField24.getCentralDirectoryData();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.utils.ByteUtils.toLittleEndian(byteArray25, (long) 1024, 3, (int) (byte) 77);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 11");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertNull(zipEightByteInteger4);
        org.junit.Assert.assertNull(zipEightByteInteger9);
        org.junit.Assert.assertNull(zipEightByteInteger11);
        org.junit.Assert.assertNull(zipEightByteInteger15);
        org.junit.Assert.assertNotNull(zipExtraFieldArray19);
        org.junit.Assert.assertNotNull(byteArray20);
        org.junit.Assert.assertArrayEquals(byteArray20, new byte[] { (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(byteArray25);
        org.junit.Assert.assertArrayEquals(byteArray25, new byte[] { (byte) 1, (byte) -53, (byte) 25, (byte) 0, (byte) 4, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0 });
    }

    @Test
    public void test0598() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0598");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS1 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.from(21);
        org.junit.Assert.assertTrue("'" + oS1 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.UNKNOWN + "'", oS1.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.UNKNOWN));
    }

    @Test
    public void test0599() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0599");
        boolean boolean1 = org.apache.commons.compress.compressors.gzip.GzipUtils.isCompressedFilename("ISO-8859-1");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0600() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0600");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.UNAMELEN;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 32 + "'", int0 == 32);
    }

    @Test
    public void test0601() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0601");
        org.apache.commons.compress.archivers.ar.ArArchiveEntry arArchiveEntry6 = new org.apache.commons.compress.archivers.ar.ArArchiveEntry("", (long) 'a', 0, 10, 0, (long) (short) 1);
        long long7 = arArchiveEntry6.getSize();
        long long8 = arArchiveEntry6.getLength();
        java.lang.String str9 = arArchiveEntry6.getName();
        long long10 = arArchiveEntry6.getLastModified();
        org.junit.Assert.assertTrue("'" + long7 + "' != '" + 97L + "'", long7 == 97L);
        org.junit.Assert.assertTrue("'" + long8 + "' != '" + 97L + "'", long8 == 97L);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "" + "'", str9, "");
        org.junit.Assert.assertTrue("'" + long10 + "' != '" + 1L + "'", long10 == 1L);
    }

    @Test
    public void test0602() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0602");
        java.lang.String str1 = org.apache.commons.compress.utils.FileNameUtils.getBaseName("hi!");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "hi!" + "'", str1, "hi!");
    }

    @Test
    public void test0603() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0603");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry6 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean7 = cpioArchiveOutputStream2.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry6);
        // The following exception was thrown during execution in test generation
        try {
            cpioArchiveOutputStream2.close();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test0604() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0604");
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.Builder builder0 = org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.builder();
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.Builder builder2 = builder0.withMaxMemoryLimitInKb(1000);
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions sevenZFileOptions3 = builder0.build();
        int int4 = sevenZFileOptions3.getMaxMemoryLimitInKb();
        int int5 = sevenZFileOptions3.getMaxMemoryLimitInKb();
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(builder2);
        org.junit.Assert.assertNotNull(sevenZFileOptions3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1000 + "'", int4 == 1000);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1000 + "'", int5 == 1000);
    }

    @Test
    public void test0605() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0605");
        byte byte0 = org.apache.commons.compress.archivers.tar.TarConstants.LF_LINK;
        org.junit.Assert.assertTrue("'" + byte0 + "' != '" + (byte) 49 + "'", byte0 == (byte) 49);
    }

    @Test
    public void test0606() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0606");
        org.apache.commons.compress.harmony.pack200.NewAttribute.StripAttribute stripAttribute2 = new org.apache.commons.compress.harmony.pack200.NewAttribute.StripAttribute("././@LongLink", 40960);
        stripAttribute2.addContext(32);
    }

    @Test
    public void test0607() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0607");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        byte[] byteArray2 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream1);
        long long3 = cpioArchiveInputStream1.getBytesRead();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.dump.DumpArchiveInputStream dumpArchiveInputStream5 = new org.apache.commons.compress.archivers.dump.DumpArchiveInputStream((java.io.InputStream) cpioArchiveInputStream1, "\001");
            org.junit.Assert.fail("Expected exception of type java.nio.charset.IllegalCharsetNameException; message: ?");
        } catch (java.nio.charset.IllegalCharsetNameException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
    }

    @Test
    public void test0608() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0608");
        java.io.File file0 = null;
        org.apache.commons.compress.archivers.zip.ZipLong zipLong1 = org.apache.commons.compress.archivers.zip.ZipLong.SINGLE_SEGMENT_SPLIT_MARKER;
        byte[] byteArray2 = zipLong1.getBytes();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZFile sevenZFile3 = new org.apache.commons.compress.archivers.sevenz.SevenZFile(file0, byteArray2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(zipLong1);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) 80, (byte) 75, (byte) 48, (byte) 48 });
    }

    @Test
    public void test0609() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0609");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry6 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean7 = cpioArchiveOutputStream2.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry6);
        jarArchiveEntry6.setVersionMadeBy(55);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test0610() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0610");
        int int0 = org.apache.commons.compress.harmony.unpack200.SegmentConstantPool.CP_DOUBLE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 5 + "'", int0 == 5);
    }

    @Test
    public void test0611() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0611");
        java.lang.String str1 = org.apache.commons.compress.compressors.xz.XZUtils.getUncompressedFileName("");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "" + "'", str1, "");
    }

    @Test
    public void test0612() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0612");
        org.apache.commons.compress.harmony.pack200.Segment segment0 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands2 = new org.apache.commons.compress.harmony.pack200.CpBands(segment0, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPMethodOrField cPMethodOrField6 = cpBands2.getCPMethod("", "zstd", "ACC_STRICT");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry9 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file10 = tarArchiveEntry9.getFile();
        int int11 = tarArchiveEntry9.getDevMinor();
        int int12 = cPMethodOrField6.compareTo((java.lang.Object) int11);
        int int14 = cPMethodOrField6.compareTo((java.lang.Object) "pack.keep.file.order");
        org.junit.Assert.assertNotNull(cPMethodOrField6);
        org.junit.Assert.assertNull(file10);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
    }

    @Test
    public void test0613() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0613");
        org.apache.commons.compress.archivers.zip.ZipMethod zipMethod0 = org.apache.commons.compress.archivers.zip.ZipMethod.WAVPACK;
        org.junit.Assert.assertTrue("'" + zipMethod0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipMethod.WAVPACK + "'", zipMethod0.equals(org.apache.commons.compress.archivers.zip.ZipMethod.WAVPACK));
    }

    @Test
    public void test0614() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0614");
        boolean boolean0 = org.apache.commons.compress.compressors.brotli.BrotliUtils.isBrotliCompressionAvailable();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test0615() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0615");
        java.lang.String str1 = org.apache.commons.compress.compressors.lzma.LZMAUtils.getCompressedFilename("pack.deflate.hint.lzma");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "pack.deflate.hint.lzma.lzma" + "'", str1, "pack.deflate.hint.lzma.lzma");
    }

    @Test
    public void test0616() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0616");
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker0 = new org.apache.commons.compress.archivers.zip.JarMarker();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort1 = jarMarker0.getLocalFileDataLength();
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField2 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.createExtraField(zipShort1);
        org.junit.Assert.assertNotNull(zipShort1);
        org.junit.Assert.assertNotNull(zipExtraField2);
    }

    @Test
    public void test0617() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0617");
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
        int int12 = cPUTF8_2.getGlobalIndex();
        org.apache.commons.compress.harmony.unpack200.bytecode.InnerClassesAttribute.setAttributeName(cPUTF8_2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "UTF-8:splitting" + "'", str4, "UTF-8:splitting");
        org.junit.Assert.assertNotNull(unpacker5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(zipShort10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 4 + "'", int12 == 4);
    }

    @Test
    public void test0618() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0618");
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
        org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream framedLZ4CompressorOutputStream18 = new org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream((java.io.OutputStream) pack200CompressorOutputStream16);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + long17 + "' != '" + 0L + "'", long17 == 0L);
    }

    @Test
    public void test0619() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0619");
        java.lang.String str0 = org.apache.commons.compress.archivers.ar.ArArchiveEntry.TRAILER;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "`\n" + "'", str0, "`\n");
    }

    @Test
    public void test0620() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0620");
        org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType blockType0 = org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.LITERAL;
        org.junit.Assert.assertTrue("'" + blockType0 + "' != '" + org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.LITERAL + "'", blockType0.equals(org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.LITERAL));
    }

    @Test
    public void test0621() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0621");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry6 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean7 = cpioArchiveOutputStream2.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry6);
        java.nio.file.attribute.FileTime fileTime8 = jarArchiveEntry6.getLastAccessTime();
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry11 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file12 = tarArchiveEntry11.getFile();
        boolean boolean13 = tarArchiveEntry11.isGNUSparse();
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry14 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date15 = arjArchiveEntry14.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong16 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date15);
        tarArchiveEntry11.setModTime(date15);
        java.nio.file.attribute.FileTime fileTime18 = tarArchiveEntry11.getLastModifiedTime();
        // The following exception was thrown during execution in test generation
        try {
            jarArchiveEntry6.setTime(fileTime18);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.file.attribute.FileTimes.isUnixTime(Ljava/nio/file/attribute/FileTime;)Z");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNull(fileTime8);
        org.junit.Assert.assertNull(file12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(date15);
        org.junit.Assert.assertEquals(date15.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong16);
        org.junit.Assert.assertNotNull(fileTime18);
    }

    @Test
    public void test0622() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0622");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass0 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.CPNameAndType cPNameAndType1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.unpack200.bytecode.CPInterfaceMethodRef cPInterfaceMethodRef3 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPInterfaceMethodRef(cPClass0, cPNameAndType1, (int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: className");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0623() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0623");
        java.io.File file0 = null;
        java.io.File file1 = null;
        java.util.Map<java.lang.String, java.lang.String> strMap2 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.pack200.Pack200Utils.normalize(file0, file1, strMap2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0624() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0624");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime1 = null;
        x5455_ExtendedTimestamp0.setAccessFileTime(fileTime1);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = x5455_ExtendedTimestamp0.getLocalFileDataLength();
        java.lang.Object obj4 = x5455_ExtendedTimestamp0.clone();
        boolean boolean5 = x5455_ExtendedTimestamp0.isBit2_createTimePresent();
        org.junit.Assert.assertNotNull(zipShort3);
        org.junit.Assert.assertNotNull(obj4);
        org.junit.Assert.assertEquals(obj4.toString(), "0x5455 Zip Extra Field: Flags=0 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(obj4), "0x5455 Zip Extra Field: Flags=0 ");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj4), "0x5455 Zip Extra Field: Flags=0 ");
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test0625() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0625");
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder0 = org.apache.commons.compress.archivers.sevenz.SevenZFile.builder();
        org.junit.Assert.assertNotNull(builder0);
    }

    @Test
    public void test0626() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0626");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file3 = tarArchiveEntry2.getFile();
        int int4 = tarArchiveEntry2.getDevMinor();
        tarArchiveEntry2.setUserName("UTF-8:splitting");
        tarArchiveEntry2.setIds(493, (int) (byte) 2);
        boolean boolean10 = tarArchiveEntry2.isDirectory();
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry13 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        java.util.Date date14 = dumpArchiveEntry13.getLastModifiedDate();
        tarArchiveEntry2.setModTime(date14);
        tarArchiveEntry2.setDevMajor(493);
        java.io.InputStream inputStream18 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream19 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream18);
        byte[] byteArray20 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream19);
        // The following exception was thrown during execution in test generation
        try {
            tarArchiveEntry2.writeEntryHeader(byteArray20);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: null");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(file3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(date14);
        org.junit.Assert.assertEquals(date14.toString(), "Thu Jan 01 10:00:00 AEST 1970");
        org.junit.Assert.assertNotNull(byteArray20);
        org.junit.Assert.assertArrayEquals(byteArray20, new byte[] {});
    }

    @Test
    public void test0627() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0627");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        java.lang.String str1 = sevenZArchiveEntry0.getName();
        boolean boolean2 = sevenZArchiveEntry0.isDirectory();
        boolean boolean3 = sevenZArchiveEntry0.getHasLastModifiedDate();
        sevenZArchiveEntry0.setHasAccessDate(false);
        java.lang.String str6 = sevenZArchiveEntry0.getName();
        // The following exception was thrown during execution in test generation
        try {
            java.nio.file.attribute.FileTime fileTime7 = sevenZArchiveEntry0.getCreationTime();
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: The entry doesn't have this timestamp");
        } catch (java.lang.UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test0628() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0628");
        org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm hashAlgorithm0 = org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm.NONE;
        org.junit.Assert.assertTrue("'" + hashAlgorithm0 + "' != '" + org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm.NONE + "'", hashAlgorithm0.equals(org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm.NONE));
    }

    @Test
    public void test0629() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0629");
        org.apache.commons.compress.archivers.dump.DumpArchiveConstants.SEGMENT_TYPE sEGMENT_TYPE1 = org.apache.commons.compress.archivers.dump.DumpArchiveConstants.SEGMENT_TYPE.find(2);
        org.junit.Assert.assertTrue("'" + sEGMENT_TYPE1 + "' != '" + org.apache.commons.compress.archivers.dump.DumpArchiveConstants.SEGMENT_TYPE.INODE + "'", sEGMENT_TYPE1.equals(org.apache.commons.compress.archivers.dump.DumpArchiveConstants.SEGMENT_TYPE.INODE));
    }

    @Test
    public void test0630() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0630");
        java.lang.String str1 = org.apache.commons.compress.utils.FileNameUtils.getBaseName("RuntimeInvisibleParameterAnnotations");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "RuntimeInvisibleParameterAnnotations" + "'", str1, "RuntimeInvisibleParameterAnnotations");
    }

    @Test
    public void test0631() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0631");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        cpioArchiveInputStream1.reset();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.cpio.CpioArchiveEntry cpioArchiveEntry4 = cpioArchiveInputStream1.getNextCPIOEntry();
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.IOUtils.read(Ljava/io/InputStream;[BII)I");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test0632() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0632");
        java.util.EnumSet<java.nio.file.FileVisitOption> fileVisitOptionSet0 = org.apache.commons.compress.archivers.examples.Archiver.EMPTY_FileVisitOption;
        org.junit.Assert.assertNotNull(fileVisitOptionSet0);
    }

    @Test
    public void test0633() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0633");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        byte[] byteArray2 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream1);
        long long3 = cpioArchiveInputStream1.getBytesRead();
        int int4 = cpioArchiveInputStream1.getCount();
        boolean boolean5 = cpioArchiveInputStream1.markSupported();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorInputStream blockLZ4CompressorInputStream6 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorInputStream((java.io.InputStream) cpioArchiveInputStream1);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test0634() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0634");
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry0 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        boolean boolean1 = arjArchiveEntry0.isHostOsUnix();
        int int2 = arjArchiveEntry0.getUnixMode();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test0635() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0635");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass3 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry4 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass3);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass5 = exceptionTableEntry4.getCatchType();
        java.io.DataOutputStream dataOutputStream6 = null;
        // The following exception was thrown during execution in test generation
        try {
            exceptionTableEntry4.write(dataOutputStream6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(cPClass5);
    }

    @Test
    public void test0636() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0636");
        java.lang.String str0 = org.apache.commons.compress.utils.CharsetNames.UTF_16;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "UTF-16" + "'", str0, "UTF-16");
    }

    @Test
    public void test0637() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0637");
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
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.SuperInitMethodRefForm superInitMethodRefForm31 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.SuperInitMethodRefForm((int) (byte) 0, "RuntimeInvisibleParameterAnnotations", intArray24);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.DoubleForm doubleForm32 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.DoubleForm((int) (byte) 49, "CPMember: UTF-8:splitting(UTF-8:splitting)", intArray24);
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
    public void test0638() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0638");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        int int3 = cpioArchiveInputStream1.available();
        cpioArchiveInputStream1.mark(32768);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
    }

    @Test
    public void test0639() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0639");
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel1 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        long long2 = seekableInMemoryByteChannel1.size();
        long long3 = seekableInMemoryByteChannel1.position();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipFile zipFile5 = new org.apache.commons.compress.archivers.zip.ZipFile((java.nio.channels.SeekableByteChannel) seekableInMemoryByteChannel1, "");
            org.junit.Assert.fail("Expected exception of type java.nio.charset.IllegalCharsetNameException; message: ");
        } catch (java.nio.charset.IllegalCharsetNameException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 96L + "'", long2 == 96L);
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
    }

    @Test
    public void test0640() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0640");
        int[] intArray8 = new int[] { ' ', (byte) -1 };
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm iMethodRefForm9 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm((int) (byte) -1, "", intArray8);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.FieldRefForm fieldRefForm10 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.FieldRefForm(10, "070701", intArray8);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.LongForm longForm11 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.LongForm(4, "jar", intArray8);
        java.lang.String str12 = longForm11.getName();
        org.junit.Assert.assertNotNull(intArray8);
        org.junit.Assert.assertArrayEquals(intArray8, new int[] { 32, (-1) });
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "jar" + "'", str12, "jar");
    }

    @Test
    public void test0641() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0641");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        boolean boolean3 = dumpArchiveEntry2.isDirectory();
        boolean boolean5 = dumpArchiveEntry2.isSparseRecord(0);
        java.util.Date date6 = dumpArchiveEntry2.getAccessTime();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(date6);
        org.junit.Assert.assertEquals(date6.toString(), "Thu Jan 01 10:00:00 AEST 1970");
    }

    @Test
    public void test0642() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0642");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream framedLZ4CompressorOutputStream7 = new org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream6);
        fixedLengthBlockOutputStream6.flush();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test0643() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0643");
        org.apache.commons.compress.archivers.zip.UnrecognizedExtraField unrecognizedExtraField0 = new org.apache.commons.compress.archivers.zip.UnrecognizedExtraField();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort1 = unrecognizedExtraField0.getCentralDirectoryLength();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort2 = unrecognizedExtraField0.getHeaderId();
        org.junit.Assert.assertNotNull(zipShort1);
        org.junit.Assert.assertNull(zipShort2);
    }

    @Test
    public void test0644() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0644");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_3 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_5 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition attributeDefinition6 = new org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition(4096, 493, cPUTF8_3, cPUTF8_5);
        org.apache.commons.compress.harmony.pack200.CPString cPString7 = new org.apache.commons.compress.harmony.pack200.CPString(cPUTF8_3);
    }

    @Test
    public void test0645() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0645");
        byte byte0 = org.apache.commons.compress.harmony.unpack200.bytecode.ConstantPoolEntry.CP_Double;
        org.junit.Assert.assertTrue("'" + byte0 + "' != '" + (byte) 6 + "'", byte0 == (byte) 6);
    }

    @Test
    public void test0646() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0646");
        java.util.concurrent.ExecutorService executorService0 = null;
        java.nio.file.Path path1 = null;
        org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier defaultBackingStoreSupplier2 = new org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier(path1);
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore3 = defaultBackingStoreSupplier2.get();
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore4 = defaultBackingStoreSupplier2.get();
        org.apache.commons.compress.archivers.zip.ParallelScatterZipCreator parallelScatterZipCreator5 = new org.apache.commons.compress.archivers.zip.ParallelScatterZipCreator(executorService0, (org.apache.commons.compress.parallel.ScatterGatherBackingStoreSupplier) defaultBackingStoreSupplier2);
        java.io.OutputStream outputStream6 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream8 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream6, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry9 = null;
        boolean boolean10 = cpioArchiveOutputStream8.canWriteEntryData(archiveEntry9);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry12 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean13 = cpioArchiveOutputStream8.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry12);
        java.nio.file.attribute.FileTime fileTime14 = jarArchiveEntry12.getLastAccessTime();
        byte[] byteArray15 = jarArchiveEntry12.getExtra();
        org.apache.commons.compress.parallel.InputStreamSupplier inputStreamSupplier16 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.concurrent.Callable<org.apache.commons.compress.archivers.zip.ScatterZipOutputStream> scatterZipOutputStreamCallable17 = parallelScatterZipCreator5.createCallable((org.apache.commons.compress.archivers.zip.ZipArchiveEntry) jarArchiveEntry12, inputStreamSupplier16);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Method must be set on zipArchiveEntry: ACC_NATIVE.gz");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(scatterGatherBackingStore3);
        org.junit.Assert.assertNotNull(scatterGatherBackingStore4);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertNull(fileTime14);
        org.junit.Assert.assertNull(byteArray15);
    }

    @Test
    public void test0647() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0647");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec3 = new org.apache.commons.compress.harmony.pack200.BHSDCodec(3, 60012, (int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: 1<=h<=256");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0648() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0648");
        org.apache.commons.compress.harmony.pack200.Segment segment0 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands2 = new org.apache.commons.compress.harmony.pack200.CpBands(segment0, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPMethodOrField cPMethodOrField6 = cpBands2.getCPMethod("", "zstd", "ACC_STRICT");
        int int7 = cPMethodOrField6.getDescIndex();
        org.junit.Assert.assertNotNull(cPMethodOrField6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + (-1) + "'", int7 == (-1));
    }

    @Test
    public void test0649() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0649");
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
        // The following exception was thrown during execution in test generation
        try {
            cpioArchiveOutputStream2.write(byteArray33, 16877, (int) (byte) 75);
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
    }

    @Test
    public void test0650() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0650");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry3 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("UTF-16LE", (byte) 51, true);
    }

    @Test
    public void test0651() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0651");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        java.util.Date date3 = dumpArchiveEntry2.getLastModifiedDate();
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE tYPE4 = dumpArchiveEntry2.getType();
        int int5 = dumpArchiveEntry2.getUserId();
        int int6 = dumpArchiveEntry2.getGroupId();
        org.junit.Assert.assertNotNull(date3);
        org.junit.Assert.assertEquals(date3.toString(), "Thu Jan 01 10:00:00 AEST 1970");
        org.junit.Assert.assertTrue("'" + tYPE4 + "' != '" + org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.UNKNOWN + "'", tYPE4.equals(org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.UNKNOWN));
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test0652() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0652");
        int int0 = org.apache.commons.compress.archivers.cpio.CpioConstants.C_ISSOCK;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 49152 + "'", int0 == 49152);
    }

    @Test
    public void test0653() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0653");
        org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData unparseableExtraFieldData0 = new org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort1 = unparseableExtraFieldData0.getHeaderId();
        byte[] byteArray2 = unparseableExtraFieldData0.getCentralDirectoryData();
        org.junit.Assert.assertNotNull(zipShort1);
        org.junit.Assert.assertNull(byteArray2);
    }

    @Test
    public void test0654() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0654");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime1 = null;
        x5455_ExtendedTimestamp0.setAccessFileTime(fileTime1);
        byte[] byteArray3 = x5455_ExtendedTimestamp0.getLocalFileDataData();
        boolean boolean4 = x5455_ExtendedTimestamp0.isBit2_createTimePresent();
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test0655() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0655");
        java.io.File file0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.cpio.CpioArchiveEntry cpioArchiveEntry2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveEntry(file0, "false");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0656() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0656");
        org.apache.commons.compress.harmony.pack200.Segment segment0 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands2 = new org.apache.commons.compress.harmony.pack200.CpBands(segment0, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPMethodOrField cPMethodOrField6 = cpBands2.getCPMethod("", "zstd", "ACC_STRICT");
        java.io.OutputStream outputStream7 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream9 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream7, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry10 = null;
        boolean boolean11 = cpioArchiveOutputStream9.canWriteEntryData(archiveEntry10);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream13 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream9, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream15 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream9, 4);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream17 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream9, 32);
        // The following exception was thrown during execution in test generation
        try {
            cpBands2.pack((java.io.OutputStream) cpioArchiveOutputStream9);
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: No current CPIO entry");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cPMethodOrField6);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
    }

    @Test
    public void test0657() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0657");
        java.lang.String str0 = org.apache.commons.compress.java.util.jar.Pack200.Unpacker.DEFLATE_HINT;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "unpack.deflate.hint" + "'", str0, "unpack.deflate.hint");
    }

    @Test
    public void test0658() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0658");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        byte[] byteArray2 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream1);
        long long3 = cpioArchiveInputStream1.getBytesRead();
        int int4 = cpioArchiveInputStream1.getCount();
        boolean boolean5 = cpioArchiveInputStream1.markSupported();
        org.apache.commons.io.function.IOIterator<org.apache.commons.compress.archivers.cpio.CpioArchiveEntry> cpioArchiveEntryIOIterator6 = cpioArchiveInputStream1.iterator();
        long long8 = cpioArchiveInputStream1.skip((long) (byte) 55);
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream9 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream((java.io.InputStream) cpioArchiveInputStream1);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream deflate64CompressorInputStream10 = new org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream((java.io.InputStream) cpioArchiveInputStream9);
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
        org.junit.Assert.assertTrue("'" + long8 + "' != '" + 0L + "'", long8 == 0L);
    }

    @Test
    public void test0659() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0659");
        int int0 = org.apache.commons.compress.archivers.cpio.CpioConstants.C_ISREG;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 32768 + "'", int0 == 32768);
    }

    @Test
    public void test0660() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0660");
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker0 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray1 = jarMarker0.getCentralDirectoryData();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField2 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger3 = zip64ExtendedInformationExtraField2.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger4 = null;
        zip64ExtendedInformationExtraField2.setSize(zipEightByteInteger4);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField6 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField7 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger8 = zip64ExtendedInformationExtraField7.getCompressedSize();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField9 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger10 = zip64ExtendedInformationExtraField9.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger11 = null;
        zip64ExtendedInformationExtraField9.setSize(zipEightByteInteger11);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField13 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger14 = zip64ExtendedInformationExtraField13.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger15 = null;
        zip64ExtendedInformationExtraField13.setSize(zipEightByteInteger15);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField17 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipExtraField[] zipExtraFieldArray18 = new org.apache.commons.compress.archivers.zip.ZipExtraField[] { zip64ExtendedInformationExtraField2, zip64ExtendedInformationExtraField6, zip64ExtendedInformationExtraField7, zip64ExtendedInformationExtraField9, zip64ExtendedInformationExtraField13, zip64ExtendedInformationExtraField17 };
        byte[] byteArray19 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.mergeLocalFileDataData(zipExtraFieldArray18);
        boolean boolean20 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray1, byteArray19);
        // The following exception was thrown during execution in test generation
        try {
            int int22 = org.apache.commons.compress.archivers.zip.ZipShort.getValue(byteArray1, (int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 0");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] {});
        org.junit.Assert.assertNull(zipEightByteInteger3);
        org.junit.Assert.assertNull(zipEightByteInteger8);
        org.junit.Assert.assertNull(zipEightByteInteger10);
        org.junit.Assert.assertNull(zipEightByteInteger14);
        org.junit.Assert.assertNotNull(zipExtraFieldArray18);
        org.junit.Assert.assertNotNull(byteArray19);
        org.junit.Assert.assertArrayEquals(byteArray19, new byte[] { (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test0661() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0661");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        long long3 = cpioArchiveInputStream1.skip((long) 8);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.dump.DumpArchiveInputStream dumpArchiveInputStream5 = new org.apache.commons.compress.archivers.dump.DumpArchiveInputStream((java.io.InputStream) cpioArchiveInputStream1, "LZ4 Parameters with BlockSize null, withContentChecksum true, withBlockChecksum false, withBlockDependency false");
            org.junit.Assert.fail("Expected exception of type java.nio.charset.IllegalCharsetNameException; message: LZ4 Parameters with BlockSize null, withContentChecksum true, withBlockChecksum false, withBlockDependency false");
        } catch (java.nio.charset.IllegalCharsetNameException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
    }

    @Test
    public void test0662() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0662");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.FORMAT_POSIX;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 3 + "'", int0 == 3);
    }

    @Test
    public void test0663() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0663");
        int int0 = org.apache.commons.compress.harmony.unpack200.SegmentConstantPool.CP_CLASS;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 7 + "'", int0 == 7);
    }

    @Test
    public void test0664() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0664");
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.NameSource nameSource0 = org.apache.commons.compress.archivers.zip.ZipArchiveEntry.NameSource.NAME_WITH_EFS_FLAG;
        org.junit.Assert.assertTrue("'" + nameSource0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.NameSource.NAME_WITH_EFS_FLAG + "'", nameSource0.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.NameSource.NAME_WITH_EFS_FLAG));
    }

    @Test
    public void test0665() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0665");
        int int0 = org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream.STORED;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 0 + "'", int0 == 0);
    }

    @Test
    public void test0666() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0666");
        org.apache.commons.compress.compressors.lz4.XXHash32 xXHash32_0 = new org.apache.commons.compress.compressors.lz4.XXHash32();
        xXHash32_0.update(155);
    }

    @Test
    public void test0667() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0667");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS1 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.from((int) (byte) 7);
        org.junit.Assert.assertTrue("'" + oS1 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.MACINTOSH + "'", oS1.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.MACINTOSH));
    }

    @Test
    public void test0668() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0668");
        org.apache.commons.compress.archivers.zip.ExtraFieldUtils.UnparseableExtraField unparseableExtraField0 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.UnparseableExtraField.THROW;
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
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField21 = unparseableExtraField0.onUnparseableExtraField(byteArray15, 2, 493, false, 31);
            org.junit.Assert.fail("Expected exception of type java.util.zip.ZipException; message: Bad extra field starting at 2.  Block length of 31 bytes exceeds remaining data of 489 bytes.");
        } catch (java.util.zip.ZipException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(unparseableExtraField0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(bHSDCodec12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] { (byte) 35 });
    }

    @Test
    public void test0669() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0669");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.util.Date date1 = x5455_ExtendedTimestamp0.getCreateJavaTime();
        org.junit.Assert.assertNull(date1);
    }

    @Test
    public void test0670() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0670");
        // The following exception was thrown during execution in test generation
        try {
            int int1 = org.apache.commons.compress.harmony.unpack200.SegmentUtils.countArgs("pack.code.attribute.");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: No arguments");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0671() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0671");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        java.lang.String str3 = dumpArchiveEntry2.toString();
        int int4 = dumpArchiveEntry2.getHeaderHoles();
        java.lang.String str5 = dumpArchiveEntry2.getName();
        int int6 = dumpArchiveEntry2.getIno();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "jar" + "'", str3, "jar");
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "jar" + "'", str5, "jar");
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test0672() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0672");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec3 = new org.apache.commons.compress.harmony.pack200.BHSDCodec((int) (byte) 10, 9, 32782);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: 1<=b<=5");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0673() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0673");
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions0 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        packingOptions0.setLogFile("ar");
        long long3 = packingOptions0.getSegmentLimit();
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 1000000L + "'", long3 == 1000000L);
    }

    @Test
    public void test0674() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0674");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        byte[] byteArray2 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream1);
        long long3 = cpioArchiveInputStream1.getBytesRead();
        int int4 = cpioArchiveInputStream1.getCount();
        boolean boolean5 = cpioArchiveInputStream1.markSupported();
        org.apache.commons.io.function.IOIterator<org.apache.commons.compress.archivers.cpio.CpioArchiveEntry> cpioArchiveEntryIOIterator6 = cpioArchiveInputStream1.iterator();
        org.apache.commons.io.function.IOIterator<org.apache.commons.compress.archivers.cpio.CpioArchiveEntry> cpioArchiveEntryIOIterator7 = cpioArchiveInputStream1.iterator();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipArchiveInputStream zipArchiveInputStream11 = new org.apache.commons.compress.archivers.zip.ZipArchiveInputStream((java.io.InputStream) cpioArchiveInputStream1, "z", false, false);
            org.junit.Assert.fail("Expected exception of type java.nio.charset.UnsupportedCharsetException; message: z");
        } catch (java.nio.charset.UnsupportedCharsetException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(cpioArchiveEntryIOIterator6);
        org.junit.Assert.assertNotNull(cpioArchiveEntryIOIterator7);
    }

    @Test
    public void test0675() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0675");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        int int3 = cpioArchiveInputStream1.available();
        int int4 = cpioArchiveInputStream1.available();
        boolean boolean5 = cpioArchiveInputStream1.markSupported();
        int int6 = cpioArchiveInputStream1.available();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream pack200CompressorInputStream7 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream((java.io.InputStream) cpioArchiveInputStream1);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 1 + "'", int6 == 1);
    }

    @Test
    public void test0676() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0676");
        org.apache.commons.compress.archivers.examples.Archiver archiver0 = new org.apache.commons.compress.archivers.examples.Archiver();
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
        java.io.File file42 = null;
        // The following exception was thrown during execution in test generation
        try {
            archiver0.create("ar", (java.io.OutputStream) pack200CompressorOutputStream14, file42);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
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
    }

    @Test
    public void test0677() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0677");
        org.apache.commons.compress.archivers.zip.ZipMethod zipMethod0 = org.apache.commons.compress.archivers.zip.ZipMethod.IMPLODING;
        org.junit.Assert.assertTrue("'" + zipMethod0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipMethod.IMPLODING + "'", zipMethod0.equals(org.apache.commons.compress.archivers.zip.ZipMethod.IMPLODING));
    }

    @Test
    public void test0678() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0678");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry6 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean7 = cpioArchiveOutputStream2.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry6);
        long long8 = jarArchiveEntry6.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource commentSource9 = jarArchiveEntry6.getCommentSource();
        // The following exception was thrown during execution in test generation
        try {
            jarArchiveEntry6.setAlignment(5);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid value for alignment, must be power of two and no bigger than 65535 but is 5");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + long8 + "' != '" + (-1L) + "'", long8 == (-1L));
        org.junit.Assert.assertTrue("'" + commentSource9 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.COMMENT + "'", commentSource9.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.COMMENT));
    }

    @Test
    public void test0679() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0679");
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
        java.lang.String str22 = cPMember21.toString();
        java.lang.String str23 = cPMember21.toString();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "UTF-8:splitting" + "'", str4, "UTF-8:splitting");
        org.junit.Assert.assertNotNull(attributeArray18);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "CPMember: UTF-8:splitting(UTF-8:splitting)" + "'", str22, "CPMember: UTF-8:splitting(UTF-8:splitting)");
        org.junit.Assert.assertEquals("'" + str23 + "' != '" + "CPMember: UTF-8:splitting(UTF-8:splitting)" + "'", str23, "CPMember: UTF-8:splitting(UTF-8:splitting)");
    }

    @Test
    public void test0680() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0680");
        org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData unparseableExtraFieldData0 = new org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort1 = unparseableExtraFieldData0.getLocalFileDataLength();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort2 = unparseableExtraFieldData0.getHeaderId();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = unparseableExtraFieldData0.getLocalFileDataLength();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort4 = unparseableExtraFieldData0.getLocalFileDataLength();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort5 = unparseableExtraFieldData0.getCentralDirectoryLength();
        org.junit.Assert.assertNotNull(zipShort1);
        org.junit.Assert.assertNotNull(zipShort2);
        org.junit.Assert.assertNotNull(zipShort3);
        org.junit.Assert.assertNotNull(zipShort4);
        org.junit.Assert.assertNotNull(zipShort5);
    }

    @Test
    public void test0681() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0681");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        long long3 = cpioArchiveInputStream1.skip((long) '4');
        java.io.OutputStream outputStream4 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream6 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream4, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry7 = null;
        boolean boolean8 = cpioArchiveOutputStream6.canWriteEntryData(archiveEntry7);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream10 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream6, 135);
        org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream framedLZ4CompressorOutputStream11 = new org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream10);
        // The following exception was thrown during execution in test generation
        try {
            long long13 = org.apache.commons.compress.utils.IOUtils.copy((java.io.InputStream) cpioArchiveInputStream1, (java.io.OutputStream) framedLZ4CompressorOutputStream11, 31);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.IOUtils.copy(Ljava/io/InputStream;Ljava/io/OutputStream;I)J");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test0682() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0682");
        org.apache.commons.compress.archivers.zip.ZipMethod zipMethod0 = org.apache.commons.compress.archivers.zip.ZipMethod.UNSHRINKING;
        org.junit.Assert.assertTrue("'" + zipMethod0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipMethod.UNSHRINKING + "'", zipMethod0.equals(org.apache.commons.compress.archivers.zip.ZipMethod.UNSHRINKING));
    }

    @Test
    public void test0683() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0683");
        java.io.File file0 = null;
        java.io.OutputStream outputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream3 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream1, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream4 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream3);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream5 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) cpioArchiveOutputStream3);
        zipArchiveOutputStream5.setUseLanguageEncodingFlag(false);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.utils.IOUtils.copy(file0, (java.io.OutputStream) zipArchiveOutputStream5);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.FileUtils.copyFile(Ljava/io/File;Ljava/io/OutputStream;)J");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test0684() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0684");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream8 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 4);
        org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream deflateCompressorOutputStream9 = new org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray11 = deflateCompressorOutputStream9.writeUtf8("ustar\000");
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: No current CPIO entry");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test0685() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0685");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream8 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream6, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap9 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream10 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream8, strMap9);
        boolean boolean11 = pack200CompressorOutputStream10.isClosed();
        pack200CompressorOutputStream10.write(3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test0686() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0686");
        org.apache.commons.compress.archivers.zip.ZipMethod zipMethod1 = org.apache.commons.compress.archivers.zip.ZipMethod.getMethodByCode(148);
        org.junit.Assert.assertNull(zipMethod1);
    }

    @Test
    public void test0687() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0687");
        org.apache.commons.compress.compressors.snappy.FramedSnappyDialect framedSnappyDialect0 = org.apache.commons.compress.compressors.snappy.FramedSnappyDialect.STANDARD;
        org.junit.Assert.assertTrue("'" + framedSnappyDialect0 + "' != '" + org.apache.commons.compress.compressors.snappy.FramedSnappyDialect.STANDARD + "'", framedSnappyDialect0.equals(org.apache.commons.compress.compressors.snappy.FramedSnappyDialect.STANDARD));
    }

    @Test
    public void test0688() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0688");
        org.apache.commons.compress.harmony.pack200.CPInt cPInt1 = new org.apache.commons.compress.harmony.pack200.CPInt(16384);
    }

    @Test
    public void test0689() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0689");
        java.lang.String str0 = org.apache.commons.compress.compressors.CompressorStreamFactory.LZ4_BLOCK;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "lz4-block" + "'", str0, "lz4-block");
    }

    @Test
    public void test0690() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0690");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pass", false);
    }

    @Test
    public void test0691() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0691");
        java.nio.charset.Charset charset0 = org.apache.commons.compress.utils.Charsets.UTF_16LE;
        org.apache.commons.compress.archivers.zip.ZipEncoding zipEncoding1 = org.apache.commons.compress.archivers.zip.ZipEncodingHelper.getZipEncoding(charset0);
        org.junit.Assert.assertNotNull(charset0);
        org.junit.Assert.assertNotNull(zipEncoding1);
    }

    @Test
    public void test0692() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0692");
        java.nio.file.Path path0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ScatterZipOutputStream scatterZipOutputStream1 = org.apache.commons.compress.archivers.zip.ScatterZipOutputStream.pathBased(path0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0693() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0693");
        org.apache.commons.compress.archivers.ArchiveException archiveException1 = new org.apache.commons.compress.archivers.ArchiveException("ACC_NATIVE");
    }

    @Test
    public void test0694() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0694");
        org.apache.commons.compress.archivers.sevenz.SevenZMethod sevenZMethod0 = org.apache.commons.compress.archivers.sevenz.SevenZMethod.COPY;
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry3 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file4 = tarArchiveEntry3.getFile();
        boolean boolean5 = tarArchiveEntry3.isGNUSparse();
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry6 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date7 = arjArchiveEntry6.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong8 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date7);
        tarArchiveEntry3.setModTime(date7);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration sevenZMethodConfiguration10 = new org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration(sevenZMethod0, (java.lang.Object) date7);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The COPY method doesn't support options of type class java.util.Date");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + sevenZMethod0 + "' != '" + org.apache.commons.compress.archivers.sevenz.SevenZMethod.COPY + "'", sevenZMethod0.equals(org.apache.commons.compress.archivers.sevenz.SevenZMethod.COPY));
        org.junit.Assert.assertNull(file4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(date7);
        org.junit.Assert.assertEquals(date7.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong8);
    }

    @Test
    public void test0695() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0695");
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField0 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger1 = zip64ExtendedInformationExtraField0.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger2 = null;
        zip64ExtendedInformationExtraField0.setSize(zipEightByteInteger2);
        zip64ExtendedInformationExtraField0.reparseCentralDirectoryData(true, false, false, false);
        zip64ExtendedInformationExtraField0.reparseCentralDirectoryData(false, false, true, false);
        org.junit.Assert.assertNull(zipEightByteInteger1);
    }

    @Test
    public void test0696() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0696");
        byte byte0 = org.apache.commons.compress.harmony.unpack200.bytecode.ConstantPoolEntry.CP_NameAndType;
        org.junit.Assert.assertTrue("'" + byte0 + "' != '" + (byte) 12 + "'", byte0 == (byte) 12);
    }

    @Test
    public void test0697() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0697");
        int int0 = java.util.zip.ZipEntry.DEFLATED;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 8 + "'", int0 == 8);
    }

    @Test
    public void test0698() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0698");
        java.lang.String str0 = org.apache.commons.compress.harmony.unpack200.AttributeLayout.ACC_FINAL;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "ACC_FINAL" + "'", str0, "ACC_FINAL");
    }

    @Test
    public void test0699() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0699");
        java.lang.String str0 = org.apache.commons.compress.harmony.unpack200.AttributeLayout.ATTRIBUTE_RUNTIME_VISIBLE_ANNOTATIONS;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "RuntimeVisibleAnnotations" + "'", str0, "RuntimeVisibleAnnotations");
    }

    @Test
    public void test0700() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0700");
        java.lang.String str0 = org.apache.commons.compress.harmony.unpack200.AttributeLayout.ATTRIBUTE_RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "RuntimeVisibleParameterAnnotations" + "'", str0, "RuntimeVisibleParameterAnnotations");
    }

    @Test
    public void test0701() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0701");
        byte[] byteArray1 = org.apache.commons.compress.utils.ArchiveUtils.toAsciiBytes("snappy-framed");
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 115, (byte) 110, (byte) 97, (byte) 112, (byte) 112, (byte) 121, (byte) 45, (byte) 102, (byte) 114, (byte) 97, (byte) 109, (byte) 101, (byte) 100 });
    }

    @Test
    public void test0702() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0702");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream8 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 4);
        org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream deflateCompressorOutputStream9 = new org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray11 = deflateCompressorOutputStream9.writeUsAsciiRaw("ustar .gz");
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: No current CPIO entry");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test0703() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0703");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        long long4 = cpioArchiveInputStream1.skip((long) 1);
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker5 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray6 = jarMarker5.getLocalFileDataData();
        int int7 = cpioArchiveInputStream1.read(byteArray6);
        java.io.InputStream inputStream8 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream9 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream8);
        int int10 = cpioArchiveInputStream9.getCount();
        long long12 = cpioArchiveInputStream9.skip((long) 1);
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker13 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray14 = jarMarker13.getLocalFileDataData();
        int int15 = cpioArchiveInputStream9.read(byteArray14);
        // The following exception was thrown during execution in test generation
        try {
            int int18 = cpioArchiveInputStream1.read(byteArray14, 32782, 6);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: null");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + long4 + "' != '" + 0L + "'", long4 == 0L);
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] {});
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + long12 + "' != '" + 0L + "'", long12 == 0L);
        org.junit.Assert.assertNotNull(byteArray14);
        org.junit.Assert.assertArrayEquals(byteArray14, new byte[] {});
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
    }

    @Test
    public void test0704() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0704");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        boolean boolean3 = dumpArchiveEntry2.isDirectory();
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE tYPE4 = dumpArchiveEntry2.getType();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + tYPE4 + "' != '" + org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.UNKNOWN + "'", tYPE4.equals(org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.UNKNOWN));
    }

    @Test
    public void test0705() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0705");
        byte[] byteArray2 = org.apache.commons.compress.utils.ArchiveUtils.toAsciiBytes("cpio");
        boolean boolean4 = org.apache.commons.compress.archivers.ar.ArArchiveInputStream.matches(byteArray2, 55);
        // The following exception was thrown during execution in test generation
        try {
            int int7 = org.apache.commons.compress.archivers.tar.TarUtils.formatCheckSumOctalBytes((long) 493, byteArray2, 476, 33188);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 33661");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) 99, (byte) 112, (byte) 105, (byte) 111 });
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test0706() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0706");
        java.io.File file0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.cpio.CpioArchiveEntry cpioArchiveEntry2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveEntry(file0, "\002?\002\n\001");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0707() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0707");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_2);
        org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute newAttribute5 = new org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute(cPUTF8_2, 8);
        java.lang.String str6 = newAttribute5.toString();
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "splitting" + "'", str6, "splitting");
    }

    @Test
    public void test0708() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0708");
        long[][] longArray0 = new long[][] {};
        int int1 = org.apache.commons.compress.harmony.unpack200.SegmentUtils.countBit16(longArray0);
        org.junit.Assert.assertNotNull(longArray0);
        org.junit.Assert.assertArrayEquals(longArray0, new long[][] {});
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 0 + "'", int1 == 0);
    }

    @Test
    public void test0709() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0709");
        org.apache.commons.compress.archivers.zip.UnrecognizedExtraField unrecognizedExtraField0 = new org.apache.commons.compress.archivers.zip.UnrecognizedExtraField();
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp1 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime2 = null;
        x5455_ExtendedTimestamp1.setAccessFileTime(fileTime2);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort4 = x5455_ExtendedTimestamp1.getHeaderId();
        unrecognizedExtraField0.setHeaderId(zipShort4);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort6 = unrecognizedExtraField0.getCentralDirectoryLength();
        org.junit.Assert.assertNotNull(zipShort4);
        org.junit.Assert.assertNotNull(zipShort6);
    }

    @Test
    public void test0710() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0710");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file3 = tarArchiveEntry2.getFile();
        int int4 = tarArchiveEntry2.getDevMinor();
        boolean boolean5 = tarArchiveEntry2.isExtended();
        org.junit.Assert.assertNull(file3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test0711() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0711");
        java.lang.String str0 = org.apache.commons.compress.harmony.unpack200.AttributeLayout.ACC_ANNOTATION;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "ACC_ANNOTATION" + "'", str0, "ACC_ANNOTATION");
    }

    @Test
    public void test0712() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0712");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream5 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream1, (long) 1, (long) 148);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.snappy.FramedSnappyCompressorInputStream framedSnappyCompressorInputStream6 = new org.apache.commons.compress.compressors.snappy.FramedSnappyCompressorInputStream((java.io.InputStream) cRC32VerifyingInputStream5);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test0713() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0713");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        byte[] byteArray2 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream1);
        long long3 = cpioArchiveInputStream1.getBytesRead();
        int int4 = cpioArchiveInputStream1.getCount();
        boolean boolean5 = cpioArchiveInputStream1.markSupported();
        org.apache.commons.io.function.IOIterator<org.apache.commons.compress.archivers.cpio.CpioArchiveEntry> cpioArchiveEntryIOIterator6 = cpioArchiveInputStream1.iterator();
        long long8 = cpioArchiveInputStream1.skip((long) (byte) 55);
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream9 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream((java.io.InputStream) cpioArchiveInputStream1);
        org.apache.commons.io.function.IOIterator<org.apache.commons.compress.archivers.cpio.CpioArchiveEntry> cpioArchiveEntryIOIterator10 = cpioArchiveInputStream1.iterator();
        int int11 = cpioArchiveInputStream1.read();
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(cpioArchiveEntryIOIterator6);
        org.junit.Assert.assertTrue("'" + long8 + "' != '" + 0L + "'", long8 == 0L);
        org.junit.Assert.assertNotNull(cpioArchiveEntryIOIterator10);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + (-1) + "'", int11 == (-1));
    }

    @Test
    public void test0714() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0714");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.SPARSE_HEADERS_IN_OLDGNU_HEADER;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 4 + "'", int0 == 4);
    }

    @Test
    public void test0715() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0715");
        org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream.BlockSize blockSize0 = org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream.BlockSize.K256;
        org.junit.Assert.assertTrue("'" + blockSize0 + "' != '" + org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream.BlockSize.K256 + "'", blockSize0.equals(org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream.BlockSize.K256));
    }

    @Test
    public void test0716() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0716");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE tYPE0 = org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.FILE;
        org.junit.Assert.assertTrue("'" + tYPE0 + "' != '" + org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.FILE + "'", tYPE0.equals(org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.FILE));
    }

    @Test
    public void test0717() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0717");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime1 = null;
        x5455_ExtendedTimestamp0.setAccessFileTime(fileTime1);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = x5455_ExtendedTimestamp0.getLocalFileDataLength();
        java.lang.Object obj4 = zipShort3.clone();
        java.io.InputStream inputStream5 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream6 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream5);
        byte[] byteArray7 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream6);
        long long8 = cpioArchiveInputStream6.getBytesRead();
        int int9 = cpioArchiveInputStream6.getCount();
        boolean boolean10 = cpioArchiveInputStream6.markSupported();
        java.io.OutputStream outputStream11 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream13 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream11, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry14 = null;
        boolean boolean15 = cpioArchiveOutputStream13.canWriteEntryData(archiveEntry14);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream17 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream13, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream19 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream17, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap20 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream21 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream19, strMap20);
        long long22 = org.apache.commons.compress.utils.IOUtils.copy((java.io.InputStream) cpioArchiveInputStream6, (java.io.OutputStream) pack200CompressorOutputStream21);
        org.apache.commons.compress.compressors.xz.XZCompressorOutputStream xZCompressorOutputStream23 = new org.apache.commons.compress.compressors.xz.XZCompressorOutputStream((java.io.OutputStream) pack200CompressorOutputStream21);
        boolean boolean24 = zipShort3.equals((java.lang.Object) xZCompressorOutputStream23);
        org.junit.Assert.assertNotNull(zipShort3);
        org.junit.Assert.assertNotNull(obj4);
        org.junit.Assert.assertEquals(obj4.toString(), "ZipShort value: 1");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(obj4), "ZipShort value: 1");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj4), "ZipShort value: 1");
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] {});
        org.junit.Assert.assertTrue("'" + long8 + "' != '" + 0L + "'", long8 == 0L);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + long22 + "' != '" + 0L + "'", long22 == 0L);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
    }

    @Test
    public void test0718() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0718");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream8 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 4);
        byte[] byteArray10 = zstdCompressorOutputStream8.writeUsAsciiRaw("org.apache.commons.compress.harmony.pack200.Segment$PassException");
        zstdCompressorOutputStream8.finish();
        byte[] byteArray13 = zstdCompressorOutputStream8.writeUsAsciiRaw("ACC_PROTECTED");
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger15 = new org.apache.commons.compress.archivers.zip.ZipEightByteInteger(byteArray13, 0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(byteArray10);
        org.junit.Assert.assertNotNull(byteArray13);
        org.junit.Assert.assertArrayEquals(byteArray13, new byte[] { (byte) 65, (byte) 67, (byte) 67, (byte) 95, (byte) 80, (byte) 82, (byte) 79, (byte) 84, (byte) 69, (byte) 67, (byte) 84, (byte) 69, (byte) 68 });
    }

    @Test
    public void test0719() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0719");
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions0 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        packingOptions0.setLogFile("ar");
        packingOptions0.setVerbose(true);
        packingOptions0.setVerbose(true);
    }

    @Test
    public void test0720() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0720");
        org.apache.commons.compress.archivers.sevenz.SevenZMethod sevenZMethod0 = org.apache.commons.compress.archivers.sevenz.SevenZMethod.DELTA_FILTER;
        org.junit.Assert.assertTrue("'" + sevenZMethod0 + "' != '" + org.apache.commons.compress.archivers.sevenz.SevenZMethod.DELTA_FILTER + "'", sevenZMethod0.equals(org.apache.commons.compress.archivers.sevenz.SevenZMethod.DELTA_FILTER));
    }

    @Test
    public void test0721() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0721");
        int int0 = org.apache.commons.compress.archivers.arj.ArjArchiveEntry.HostOs.OS_2;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 5 + "'", int0 == 5);
    }

    @Test
    public void test0722() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0722");
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
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarArchiveOutputStream tarArchiveOutputStream15 = new org.apache.commons.compress.archivers.tar.TarArchiveOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream9, 31, "ar");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Block size must be a multiple of 512 bytes. Attempt to use set size of 31");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test0723() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0723");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream framedLZ4CompressorOutputStream7 = new org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream6);
        java.util.Map<java.lang.String, java.lang.String> strMap8 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream9 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) framedLZ4CompressorOutputStream7, strMap8);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test0724() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0724");
        org.apache.commons.compress.archivers.dump.DumpArchiveConstants.SEGMENT_TYPE sEGMENT_TYPE1 = org.apache.commons.compress.archivers.dump.DumpArchiveConstants.SEGMENT_TYPE.find((int) (byte) 12);
        org.junit.Assert.assertNull(sEGMENT_TYPE1);
    }

    @Test
    public void test0725() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0725");
        java.lang.String str0 = org.apache.commons.compress.harmony.unpack200.AttributeLayout.ATTRIBUTE_CONSTANT_VALUE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "ConstantValue" + "'", str0, "ConstantValue");
    }

    @Test
    public void test0726() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0726");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec0 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean1 = bHSDCodec0.isDelta();
        byte[] byteArray3 = bHSDCodec0.encode((int) '#');
        boolean boolean5 = org.apache.commons.compress.compressors.z.ZCompressorInputStream.matches(byteArray3, 9);
        // The following exception was thrown during execution in test generation
        try {
            int int6 = org.apache.commons.compress.archivers.zip.ZipShort.getValue(byteArray3);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 1");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(bHSDCodec0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 35 });
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test0727() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0727");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        java.lang.String str1 = sevenZArchiveEntry0.getName();
        boolean boolean2 = sevenZArchiveEntry0.isDirectory();
        boolean boolean3 = sevenZArchiveEntry0.getHasLastModifiedDate();
        sevenZArchiveEntry0.setHasAccessDate(false);
        java.lang.String str6 = sevenZArchiveEntry0.getName();
        java.lang.String str7 = sevenZArchiveEntry0.getName();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNull(str6);
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test0728() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0728");
        org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE cOMPRESSION_TYPE0 = org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE.ZLIB;
        org.junit.Assert.assertTrue("'" + cOMPRESSION_TYPE0 + "' != '" + org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE.ZLIB + "'", cOMPRESSION_TYPE0.equals(org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE.ZLIB));
    }

    @Test
    public void test0729() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0729");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        int int3 = cpioArchiveInputStream1.available();
        int int4 = cpioArchiveInputStream1.available();
        boolean boolean5 = cpioArchiveInputStream1.markSupported();
        int int6 = cpioArchiveInputStream1.available();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.utils.IOUtils.closeQuietly((java.io.Closeable) cpioArchiveInputStream1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 1 + "'", int6 == 1);
    }

    @Test
    public void test0730() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0730");
        java.nio.file.Path path0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.parallel.FileBasedScatterGatherBackingStore fileBasedScatterGatherBackingStore1 = new org.apache.commons.compress.parallel.FileBasedScatterGatherBackingStore(path0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0731() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0731");
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
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder26 = builder24.setMaxMemoryLimitKb(255);
        java.nio.charset.Charset charset27 = org.apache.commons.compress.utils.Charsets.US_ASCII;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder28 = builder26.setCharset(charset27);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.Charsets.toCharset(Ljava/nio/charset/Charset;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
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
        org.junit.Assert.assertNotNull(charset27);
    }

    @Test
    public void test0732() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0732");
        org.apache.commons.compress.archivers.examples.Archiver archiver0 = new org.apache.commons.compress.archivers.examples.Archiver();
        org.apache.commons.compress.archivers.sevenz.SevenZOutputFile sevenZOutputFile1 = null;
        java.io.File file2 = null;
        // The following exception was thrown during execution in test generation
        try {
            archiver0.create(sevenZOutputFile1, file2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0733() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0733");
        org.apache.commons.compress.compressors.deflate.DeflateParameters deflateParameters0 = new org.apache.commons.compress.compressors.deflate.DeflateParameters();
        deflateParameters0.setWithZlibHeader(true);
    }

    @Test
    public void test0734() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0734");
        org.apache.commons.compress.archivers.examples.Expander expander0 = new org.apache.commons.compress.archivers.examples.Expander();
        java.io.InputStream inputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream1);
        int int3 = cpioArchiveInputStream2.getCount();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream6 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream2, (long) 1, (long) 148);
        java.nio.file.Path path7 = null;
        // The following exception was thrown during execution in test generation
        try {
            expander0.expand((org.apache.commons.compress.archivers.ArchiveInputStream<org.apache.commons.compress.archivers.cpio.CpioArchiveEntry>) cpioArchiveInputStream2, path7);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.IOUtils.read(Ljava/io/InputStream;[BII)I");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
    }

    @Test
    public void test0735() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0735");
        java.lang.String str1 = org.apache.commons.compress.harmony.archive.internal.nls.Messages.getString("pack.progress");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "pack.progress" + "'", str1, "pack.progress");
    }

    @Test
    public void test0736() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0736");
        org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData unparseableExtraFieldData0 = new org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort1 = unparseableExtraFieldData0.getLocalFileDataLength();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort2 = unparseableExtraFieldData0.getHeaderId();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = unparseableExtraFieldData0.getHeaderId();
        org.junit.Assert.assertNotNull(zipShort1);
        org.junit.Assert.assertNotNull(zipShort2);
        org.junit.Assert.assertNotNull(zipShort3);
    }

    @Test
    public void test0737() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0737");
        org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm encryptionAlgorithm0 = org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm.AES128;
        org.junit.Assert.assertTrue("'" + encryptionAlgorithm0 + "' != '" + org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm.AES128 + "'", encryptionAlgorithm0.equals(org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm.AES128));
    }

    @Test
    public void test0738() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0738");
        // The following exception was thrown during execution in test generation
        try {
            long long1 = org.apache.commons.compress.utils.ParsingUtils.parseLongValue("ISO-8859-1");
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: Unable to parse long from string value: ISO-8859-1");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0739() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0739");
        java.lang.String str1 = org.apache.commons.compress.compressors.lzma.LZMAUtils.getCompressedFilename("hi!");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "hi!.lzma" + "'", str1, "hi!.lzma");
    }

    @Test
    public void test0740() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0740");
        org.apache.commons.compress.archivers.sevenz.SevenZMethod sevenZMethod0 = org.apache.commons.compress.archivers.sevenz.SevenZMethod.BCJ_SPARC_FILTER;
        org.junit.Assert.assertTrue("'" + sevenZMethod0 + "' != '" + org.apache.commons.compress.archivers.sevenz.SevenZMethod.BCJ_SPARC_FILTER + "'", sevenZMethod0.equals(org.apache.commons.compress.archivers.sevenz.SevenZMethod.BCJ_SPARC_FILTER));
    }

    @Test
    public void test0741() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0741");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry6 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean7 = cpioArchiveOutputStream2.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry6);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream8 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry10 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField11 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField();
        jarArchiveEntry10.addExtraField((org.apache.commons.compress.archivers.zip.ZipExtraField) unicodeCommentExtraField11);
        java.io.InputStream inputStream13 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream14 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream13);
        byte[] byteArray15 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream14);
        long long16 = cpioArchiveInputStream14.getBytesRead();
        int int17 = cpioArchiveInputStream14.getCount();
        boolean boolean18 = cpioArchiveInputStream14.markSupported();
        org.apache.commons.io.function.IOIterator<org.apache.commons.compress.archivers.cpio.CpioArchiveEntry> cpioArchiveEntryIOIterator19 = cpioArchiveInputStream14.iterator();
        long long21 = cpioArchiveInputStream14.skip((long) (byte) 55);
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream22 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream((java.io.InputStream) cpioArchiveInputStream14);
        // The following exception was thrown during execution in test generation
        try {
            zipArchiveOutputStream8.addRawArchiveEntry((org.apache.commons.compress.archivers.zip.ZipArchiveEntry) jarArchiveEntry10, (java.io.InputStream) cpioArchiveInputStream22);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: ZIP compression method cannot be negative: -1");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] {});
        org.junit.Assert.assertTrue("'" + long16 + "' != '" + 0L + "'", long16 == 0L);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNotNull(cpioArchiveEntryIOIterator19);
        org.junit.Assert.assertTrue("'" + long21 + "' != '" + 0L + "'", long21 == 0L);
    }

    @Test
    public void test0742() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0742");
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData unparseableExtraFieldData2 = jarArchiveEntry1.getUnparseableExtraFieldData();
        long long3 = jarArchiveEntry1.getCompressedSize();
        jarArchiveEntry1.setExternalAttributes((long) '4');
        org.junit.Assert.assertNull(unparseableExtraFieldData2);
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + (-1L) + "'", long3 == (-1L));
    }

    @Test
    public void test0743() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0743");
        java.io.File file0 = null;
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.Builder builder1 = org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.builder();
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.Builder builder3 = builder1.withMaxMemoryLimitInKb(1000);
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions sevenZFileOptions4 = builder1.build();
        int int5 = sevenZFileOptions4.getMaxMemoryLimitInKb();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZFile sevenZFile6 = new org.apache.commons.compress.archivers.sevenz.SevenZFile(file0, sevenZFileOptions4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder1);
        org.junit.Assert.assertNotNull(builder3);
        org.junit.Assert.assertNotNull(sevenZFileOptions4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1000 + "'", int5 == 1000);
    }

    @Test
    public void test0744() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0744");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime1 = null;
        x5455_ExtendedTimestamp0.setAccessFileTime(fileTime1);
        org.apache.commons.compress.archivers.zip.ZipLong zipLong3 = org.apache.commons.compress.archivers.zip.ZipLong.AED_SIG;
        boolean boolean5 = zipLong3.equals((java.lang.Object) "pass");
        x5455_ExtendedTimestamp0.setCreateTime(zipLong3);
        // The following exception was thrown during execution in test generation
        try {
            java.nio.file.attribute.FileTime fileTime7 = x5455_ExtendedTimestamp0.getCreateFileTime();
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.file.attribute.FileTimes.fromUnixTime(J)Ljava/nio/file/attribute/FileTime;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(zipLong3);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test0745() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0745");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("", true);
        tarArchiveEntry2.setMode(16877);
        java.nio.file.attribute.FileTime fileTime5 = tarArchiveEntry2.getStatusChangeTime();
        boolean boolean6 = tarArchiveEntry2.isStreamContiguous();
        long long7 = tarArchiveEntry2.getLongUserId();
        org.junit.Assert.assertNull(fileTime5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertTrue("'" + long7 + "' != '" + 0L + "'", long7 == 0L);
    }

    @Test
    public void test0746() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0746");
        org.apache.commons.compress.archivers.zip.ZipLong zipLong0 = org.apache.commons.compress.archivers.zip.ZipLong.AED_SIG;
        boolean boolean2 = zipLong0.equals((java.lang.Object) "pass");
        int int3 = zipLong0.getIntValue();
        org.junit.Assert.assertNotNull(zipLong0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 134630224 + "'", int3 == 134630224);
    }

    @Test
    public void test0747() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0747");
        byte byte0 = org.apache.commons.compress.archivers.tar.TarConstants.LF_OLDNORM;
        org.junit.Assert.assertTrue("'" + byte0 + "' != '" + (byte) 0 + "'", byte0 == (byte) 0);
    }

    @Test
    public void test0748() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0748");
        org.apache.commons.compress.harmony.pack200.BHSDCodec[] bHSDCodecArray0 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaDoubleSignedCodecs1;
        org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaDoubleSignedCodecs1 = bHSDCodecArray0;
        org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs1 = bHSDCodecArray0;
        org.junit.Assert.assertNotNull(bHSDCodecArray0);
    }

    @Test
    public void test0749() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0749");
        org.apache.commons.compress.archivers.zip.UnrecognizedExtraField unrecognizedExtraField0 = new org.apache.commons.compress.archivers.zip.UnrecognizedExtraField();
        org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData unparseableExtraFieldData1 = new org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort2 = unparseableExtraFieldData1.getHeaderId();
        unrecognizedExtraField0.setHeaderId(zipShort2);
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode extraFieldParsingMode4 = org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT;
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp5 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime6 = null;
        x5455_ExtendedTimestamp5.setAccessFileTime(fileTime6);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort8 = x5455_ExtendedTimestamp5.getHeaderId();
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField9 = extraFieldParsingMode4.createExtraField(zipShort8);
        unrecognizedExtraField0.setHeaderId(zipShort8);
        org.junit.Assert.assertNotNull(zipShort2);
        org.junit.Assert.assertTrue("'" + extraFieldParsingMode4 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT + "'", extraFieldParsingMode4.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT));
        org.junit.Assert.assertNotNull(zipShort8);
        org.junit.Assert.assertNotNull(zipExtraField9);
    }

    @Test
    public void test0750() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0750");
        org.apache.commons.compress.archivers.sevenz.SevenZMethod sevenZMethod0 = org.apache.commons.compress.archivers.sevenz.SevenZMethod.LZMA2;
        org.junit.Assert.assertTrue("'" + sevenZMethod0 + "' != '" + org.apache.commons.compress.archivers.sevenz.SevenZMethod.LZMA2 + "'", sevenZMethod0.equals(org.apache.commons.compress.archivers.sevenz.SevenZMethod.LZMA2));
    }

    @Test
    public void test0751() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0751");
        java.lang.String str0 = org.apache.commons.compress.harmony.unpack200.AttributeLayout.ATTRIBUTE_ANNOTATION_DEFAULT;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "AnnotationDefault" + "'", str0, "AnnotationDefault");
    }

    @Test
    public void test0752() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0752");
        byte byte0 = org.apache.commons.compress.archivers.tar.TarConstants.LF_PAX_EXTENDED_HEADER_UC;
        org.junit.Assert.assertTrue("'" + byte0 + "' != '" + (byte) 88 + "'", byte0 == (byte) 88);
    }

    @Test
    public void test0753() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0753");
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
        org.apache.commons.compress.harmony.unpack200.bytecode.Attribute attribute37 = null;
        codeAttribute36.addAttribute(attribute37);
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
    public void test0754() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0754");
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel1 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        org.apache.commons.compress.archivers.tar.TarFile tarFile2 = new org.apache.commons.compress.archivers.tar.TarFile((java.nio.channels.SeekableByteChannel) seekableInMemoryByteChannel1);
        seekableInMemoryByteChannel1.close();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipFile zipFile5 = new org.apache.commons.compress.archivers.zip.ZipFile((java.nio.channels.SeekableByteChannel) seekableInMemoryByteChannel1, "splitting");
            org.junit.Assert.fail("Expected exception of type java.nio.charset.UnsupportedCharsetException; message: splitting");
        } catch (java.nio.charset.UnsupportedCharsetException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0755() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0755");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS0 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.FAT;
        org.junit.Assert.assertTrue("'" + oS0 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.FAT + "'", oS0.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.FAT));
    }

    @Test
    public void test0756() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0756");
        org.apache.commons.compress.archivers.zip.ZipLong zipLong0 = org.apache.commons.compress.archivers.zip.ZipLong.AED_SIG;
        boolean boolean2 = zipLong0.equals((java.lang.Object) "pass");
        java.util.Date date3 = org.apache.commons.compress.archivers.zip.ZipUtil.fromDosTime(zipLong0);
        org.junit.Assert.assertNotNull(zipLong0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(date3);
        org.junit.Assert.assertEquals(date3.toString(), "Tue Dec 06 09:26:32 AEDT 1983");
    }

    @Test
    public void test0757() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0757");
        org.apache.commons.compress.archivers.zip.UnrecognizedExtraField unrecognizedExtraField0 = new org.apache.commons.compress.archivers.zip.UnrecognizedExtraField();
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp1 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime2 = null;
        x5455_ExtendedTimestamp1.setAccessFileTime(fileTime2);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort4 = x5455_ExtendedTimestamp1.getHeaderId();
        unrecognizedExtraField0.setHeaderId(zipShort4);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort6 = unrecognizedExtraField0.getCentralDirectoryLength();
        org.junit.Assert.assertNotNull(zipShort4);
        org.junit.Assert.assertNotNull(zipShort6);
    }

    @Test
    public void test0758() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0758");
        org.apache.commons.compress.archivers.zip.ZipLong zipLong0 = org.apache.commons.compress.archivers.zip.ZipLong.CFH_SIG;
        org.junit.Assert.assertNotNull(zipLong0);
    }

    @Test
    public void test0759() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0759");
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.ByteCodeForm byteCodeForm1 = org.apache.commons.compress.harmony.unpack200.bytecode.forms.ByteCodeForm.get(8);
        org.junit.Assert.assertNotNull(byteCodeForm1);
    }

    @Test
    public void test0760() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0760");
        org.apache.commons.compress.compressors.gzip.ExtraField extraField0 = new org.apache.commons.compress.compressors.gzip.ExtraField();
        int int1 = extraField0.size();
        int int2 = extraField0.size();
        int int3 = extraField0.size();
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 0 + "'", int1 == 0);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
    }

    @Test
    public void test0761() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0761");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file3 = tarArchiveEntry2.getFile();
        boolean boolean4 = tarArchiveEntry2.isGNUSparse();
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry5 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date6 = arjArchiveEntry5.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong7 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date6);
        tarArchiveEntry2.setModTime(date6);
        java.nio.file.attribute.FileTime fileTime9 = tarArchiveEntry2.getLastModifiedTime();
        boolean boolean10 = tarArchiveEntry2.isStarSparse();
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry13 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file14 = tarArchiveEntry13.getFile();
        int int15 = tarArchiveEntry13.getDevMinor();
        tarArchiveEntry13.setUserName("UTF-8:splitting");
        tarArchiveEntry13.setIds(493, (int) (byte) 2);
        boolean boolean21 = tarArchiveEntry13.isDirectory();
        java.io.File file22 = tarArchiveEntry13.getFile();
        java.util.List<org.apache.commons.compress.archivers.tar.TarArchiveStructSparse> tarArchiveStructSparseList23 = tarArchiveEntry13.getOrderedSparseHeaders();
        tarArchiveEntry2.setSparseHeaders(tarArchiveStructSparseList23);
        org.junit.Assert.assertNull(file3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(date6);
        org.junit.Assert.assertEquals(date6.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong7);
        org.junit.Assert.assertNotNull(fileTime9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNull(file14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNull(file22);
        org.junit.Assert.assertNotNull(tarArchiveStructSparseList23);
    }

    @Test
    public void test0762() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0762");
        java.io.File file0 = null;
        char[] charArray4 = new char[] { '#', 'a', '4' };
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZOutputFile sevenZOutputFile5 = new org.apache.commons.compress.archivers.sevenz.SevenZOutputFile(file0, charArray4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(charArray4);
        org.junit.Assert.assertArrayEquals(charArray4, new char[] { '#', 'a', '4' });
    }

    @Test
    public void test0763() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0763");
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
        packingOptions37.setSegmentLimit(0L);
        // The following exception was thrown during execution in test generation
        try {
            packingOptions37.setDeflateHint("class-file version");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Bad argument: -H class-file version ? deflate hint should be either true, false or keep (default)");
        } catch (java.lang.IllegalArgumentException e) {
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
    }

    @Test
    public void test0764() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0764");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream framedLZ4CompressorOutputStream7 = new org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream6);
        java.io.InputStream inputStream8 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream9 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream8);
        byte[] byteArray10 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream9);
        long long11 = org.apache.commons.compress.archivers.tar.TarUtils.computeCheckSum(byteArray10);
        // The following exception was thrown during execution in test generation
        try {
            fixedLengthBlockOutputStream6.write(byteArray10, (int) (byte) 1, 16384);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: null");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(byteArray10);
        org.junit.Assert.assertArrayEquals(byteArray10, new byte[] {});
        org.junit.Assert.assertTrue("'" + long11 + "' != '" + 0L + "'", long11 == 0L);
    }

    @Test
    public void test0765() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0765");
        byte[] byteArray4 = new byte[] { (byte) 10, (byte) 10, (byte) -1 };
        boolean boolean6 = org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.matches(byteArray4, (int) (short) -1);
        // The following exception was thrown during execution in test generation
        try {
            int int9 = org.apache.commons.compress.archivers.tar.TarUtils.formatLongOctalBytes((long) 256, byteArray4, 9, 4);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 11");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 10, (byte) 10, (byte) -1 });
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test0766() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0766");
        org.apache.commons.compress.harmony.pack200.Segment segment0 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands2 = new org.apache.commons.compress.harmony.pack200.CpBands(segment0, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPMethodOrField cPMethodOrField6 = cpBands2.getCPMethod("", "zstd", "ACC_STRICT");
        org.apache.commons.compress.harmony.pack200.CPClass cPClass8 = cpBands2.getCPClass("true");
        boolean boolean9 = cPClass8.isInnerClass();
        org.junit.Assert.assertNotNull(cPMethodOrField6);
        org.junit.Assert.assertNotNull(cPClass8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test0767() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0767");
        java.io.File file0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarFile tarFile2 = new org.apache.commons.compress.archivers.tar.TarFile(file0, "ACC_SYNTHETIC");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0768() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0768");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS1 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue elementValue2 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue((int) (byte) 7, (java.lang.Object) oS1);
        int int3 = elementValue2.getLength();
        org.junit.Assert.assertTrue("'" + oS1 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS1.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
    }

    @Test
    public void test0769() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0769");
        org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType blockType0 = org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.BACK_REFERENCE;
        org.junit.Assert.assertTrue("'" + blockType0 + "' != '" + org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.BACK_REFERENCE + "'", blockType0.equals(org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.BACK_REFERENCE));
    }

    @Test
    public void test0770() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0770");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("", true);
        tarArchiveEntry2.setSize((long) 40960);
        boolean boolean5 = tarArchiveEntry2.isFile();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test0771() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0771");
        java.lang.String str1 = org.apache.commons.compress.compressors.bzip2.BZip2Utils.getUncompressedFilename("pack.deflate.hint.lzma");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "pack.deflate.hint.lzma" + "'", str1, "pack.deflate.hint.lzma");
    }

    @Test
    public void test0772() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0772");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        fixedLengthBlockOutputStream6.write(1024);
        org.apache.commons.compress.compressors.lzma.LZMACompressorOutputStream lZMACompressorOutputStream9 = new org.apache.commons.compress.compressors.lzma.LZMACompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream6);
        // The following exception was thrown during execution in test generation
        try {
            fixedLengthBlockOutputStream6.flushBlock();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test0773() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0773");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry.PERMISSION pERMISSION0 = org.apache.commons.compress.archivers.dump.DumpArchiveEntry.PERMISSION.GROUP_READ;
        org.junit.Assert.assertTrue("'" + pERMISSION0 + "' != '" + org.apache.commons.compress.archivers.dump.DumpArchiveEntry.PERMISSION.GROUP_READ + "'", pERMISSION0.equals(org.apache.commons.compress.archivers.dump.DumpArchiveEntry.PERMISSION.GROUP_READ));
    }

    @Test
    public void test0774() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0774");
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
        java.nio.file.attribute.FileTime fileTime13 = x5455_ExtendedTimestamp0.getModifyFileTime();
        org.junit.Assert.assertNotNull(zipShort3);
        org.junit.Assert.assertNull(fileTime4);
        org.junit.Assert.assertNotNull(zipLong8);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNull(fileTime13);
    }

    @Test
    public void test0775() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0775");
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions0 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        packingOptions0.setLogFile("ar");
        java.lang.String str4 = packingOptions0.getUnknownClassAttributeAction("pack.modification.time");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "pass" + "'", str4, "pass");
    }

    @Test
    public void test0776() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0776");
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
        pack200CompressorOutputStream16.flush();
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + long17 + "' != '" + 0L + "'", long17 == 0L);
    }

    @Test
    public void test0777() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0777");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        java.lang.String str1 = sevenZArchiveEntry0.getName();
        sevenZArchiveEntry0.setHasCrc(false);
        sevenZArchiveEntry0.setHasAccessDate(false);
        org.junit.Assert.assertNull(str1);
    }

    @Test
    public void test0778() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0778");
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
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker32 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray33 = jarMarker32.getCentralDirectoryData();
        byte[] byteArray34 = jarMarker32.getLocalFileDataData();
        java.lang.String str35 = org.apache.commons.compress.utils.ArchiveUtils.toAsciiString(byteArray34);
        // The following exception was thrown during execution in test generation
        try {
            blockLZ4CompressorOutputStream3.prefill(byteArray34, 476, 32768);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: null");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
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
        org.junit.Assert.assertNotNull(byteArray33);
        org.junit.Assert.assertArrayEquals(byteArray33, new byte[] {});
        org.junit.Assert.assertNotNull(byteArray34);
        org.junit.Assert.assertArrayEquals(byteArray34, new byte[] {});
        org.junit.Assert.assertEquals("'" + str35 + "' != '" + "" + "'", str35, "");
    }

    @Test
    public void test0779() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0779");
        int[] intArray6 = new int[] { ' ', (byte) -1 };
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm iMethodRefForm7 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm((int) (byte) -1, "", intArray6);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm classRefForm8 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm((int) (short) 0, "jar", intArray6);
        int int9 = classRefForm8.firstOperandIndex();
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertArrayEquals(intArray6, new int[] { 32, (-1) });
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 1 + "'", int9 == 1);
    }

    @Test
    public void test0780() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0780");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("!<arch>\n", (int) (byte) 51);
        org.apache.commons.compress.harmony.unpack200.bytecode.DeprecatedAttribute.setAttributeName(cPUTF8_2);
    }

    @Test
    public void test0781() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0781");
        java.lang.String str2 = org.apache.commons.compress.harmony.archive.internal.nls.Messages.getString("RuntimeInvisibleParameterAnnotations", 10240);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "RuntimeInvisibleParameterAnnotations" + "'", str2, "RuntimeInvisibleParameterAnnotations");
    }

    @Test
    public void test0782() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0782");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        fixedLengthBlockOutputStream6.write(1024);
        org.apache.commons.compress.compressors.lzma.LZMACompressorOutputStream lZMACompressorOutputStream9 = new org.apache.commons.compress.compressors.lzma.LZMACompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream6);
        // The following exception was thrown during execution in test generation
        try {
            lZMACompressorOutputStream9.close();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test0783() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0783");
        java.lang.String str0 = org.apache.commons.compress.archivers.tar.TarConstants.VERSION_GNU_ZERO;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "0\000" + "'", str0, "0\000");
    }

    @Test
    public void test0784() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0784");
        org.apache.commons.compress.java.util.jar.Pack200.Unpacker unpacker0 = org.apache.commons.compress.java.util.jar.Pack200.newUnpacker();
        java.beans.PropertyChangeListener propertyChangeListener1 = null;
        unpacker0.removePropertyChangeListener(propertyChangeListener1);
        java.io.InputStream inputStream3 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream4 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream3);
        byte[] byteArray5 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream4);
        long long6 = cpioArchiveInputStream4.getBytesRead();
        int int7 = cpioArchiveInputStream4.getCount();
        boolean boolean8 = cpioArchiveInputStream4.markSupported();
        java.io.OutputStream outputStream9 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream11 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream9, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry12 = null;
        boolean boolean13 = cpioArchiveOutputStream11.canWriteEntryData(archiveEntry12);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream15 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream11, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream17 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream15, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap18 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream19 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream17, strMap18);
        long long20 = org.apache.commons.compress.utils.IOUtils.copy((java.io.InputStream) cpioArchiveInputStream4, (java.io.OutputStream) pack200CompressorOutputStream19);
        java.util.jar.JarOutputStream jarOutputStream21 = null;
        // The following exception was thrown during execution in test generation
        try {
            unpacker0.unpack((java.io.InputStream) cpioArchiveInputStream4, jarOutputStream21);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Must specify output stream.");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(unpacker0);
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] {});
        org.junit.Assert.assertTrue("'" + long6 + "' != '" + 0L + "'", long6 == 0L);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertTrue("'" + long20 + "' != '" + 0L + "'", long20 == 0L);
    }

    @Test
    public void test0785() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0785");
        byte[] byteArray5 = new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 };
        byte[] byteArray12 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean14 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray12, 0);
        boolean boolean15 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray5, byteArray12);
        long long16 = org.apache.commons.compress.archivers.zip.ZipLong.getValue(byteArray5);
        java.io.OutputStream outputStream19 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream21 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream19, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry22 = null;
        boolean boolean23 = cpioArchiveOutputStream21.canWriteEntryData(archiveEntry22);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream25 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream21, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream27 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream21, 4);
        byte[] byteArray29 = zstdCompressorOutputStream27.writeUsAsciiRaw("org.apache.commons.compress.harmony.pack200.Segment$PassException");
        org.apache.commons.compress.utils.ByteUtils.OutputStreamByteConsumer outputStreamByteConsumer30 = new org.apache.commons.compress.utils.ByteUtils.OutputStreamByteConsumer((java.io.OutputStream) zstdCompressorOutputStream27);
        byte[] byteArray35 = new byte[] { (byte) 0, (byte) 12, (byte) 12, (byte) 2 };
        zstdCompressorOutputStream27.write(byteArray35, 1000, 135);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean41 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray5, 55, 476, byteArray35, 100, 488);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 55");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 });
        org.junit.Assert.assertNotNull(byteArray12);
        org.junit.Assert.assertArrayEquals(byteArray12, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + long16 + "' != '" + 167968514L + "'", long16 == 167968514L);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertNotNull(byteArray29);
        org.junit.Assert.assertNotNull(byteArray35);
        org.junit.Assert.assertArrayEquals(byteArray35, new byte[] { (byte) 0, (byte) 12, (byte) 12, (byte) 2 });
    }

    @Test
    public void test0786() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0786");
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader0 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        boolean boolean1 = segmentHeader0.have_method_flags_hi();
        segmentHeader0.setIc_count((int) '4');
        segmentHeader0.setCp_Method_count(4096);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0787() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0787");
        java.lang.String str0 = org.apache.commons.compress.harmony.unpack200.AttributeLayout.ATTRIBUTE_EXCEPTIONS;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "Exceptions" + "'", str0, "Exceptions");
    }

    @Test
    public void test0788() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0788");
        org.apache.commons.compress.archivers.examples.Expander expander0 = new org.apache.commons.compress.archivers.examples.Expander();
        java.nio.file.Path path1 = null;
        java.nio.file.Path path2 = null;
        // The following exception was thrown during execution in test generation
        try {
            expander0.expand(path1, path2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0789() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0789");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        java.lang.String str1 = sevenZArchiveEntry0.getName();
        sevenZArchiveEntry0.setHasCrc(false);
        sevenZArchiveEntry0.setAntiItem(false);
        sevenZArchiveEntry0.setAntiItem(false);
        // The following exception was thrown during execution in test generation
        try {
            java.nio.file.attribute.FileTime fileTime8 = sevenZArchiveEntry0.getCreationTime();
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: The entry doesn't have this timestamp");
        } catch (java.lang.UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(str1);
    }

    @Test
    public void test0790() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0790");
        java.nio.file.Path path0 = null;
        java.nio.file.LinkOption linkOption2 = null;
        java.nio.file.LinkOption[] linkOptionArray3 = new java.nio.file.LinkOption[] { linkOption2 };
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.ar.ArArchiveEntry arArchiveEntry4 = new org.apache.commons.compress.archivers.ar.ArArchiveEntry(path0, "deflate64", linkOptionArray3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(linkOptionArray3);
        org.junit.Assert.assertArrayEquals(linkOptionArray3, new java.nio.file.LinkOption[] { null });
    }

    @Test
    public void test0791() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0791");
        org.apache.commons.compress.archivers.examples.Expander expander0 = new org.apache.commons.compress.archivers.examples.Expander();
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel3 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        org.apache.commons.compress.archivers.tar.TarFile tarFile4 = new org.apache.commons.compress.archivers.tar.TarFile((java.nio.channels.SeekableByteChannel) seekableInMemoryByteChannel3);
        seekableInMemoryByteChannel3.close();
        java.nio.file.Path path6 = null;
        org.apache.commons.compress.archivers.examples.CloseableConsumer closeableConsumer7 = org.apache.commons.compress.archivers.examples.CloseableConsumer.NULL_CONSUMER;
        // The following exception was thrown during execution in test generation
        try {
            expander0.expand("FieldRef: null#null", (java.nio.channels.SeekableByteChannel) seekableInMemoryByteChannel3, path6, closeableConsumer7);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.compress.archivers.ArchiveException; message: Archiver: FieldRef: null#null not found.");
        } catch (org.apache.commons.compress.archivers.ArchiveException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(closeableConsumer7);
    }

    @Test
    public void test0792() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0792");
        java.lang.String str0 = org.apache.commons.compress.archivers.cpio.CpioConstants.MAGIC_NEW_CRC;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "070702" + "'", str0, "070702");
    }

    @Test
    public void test0793() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0793");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream8 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 4);
        byte[] byteArray10 = zstdCompressorOutputStream8.writeUsAsciiRaw("org.apache.commons.compress.harmony.pack200.Segment$PassException");
        org.apache.commons.compress.utils.ByteUtils.OutputStreamByteConsumer outputStreamByteConsumer11 = new org.apache.commons.compress.utils.ByteUtils.OutputStreamByteConsumer((java.io.OutputStream) zstdCompressorOutputStream8);
        outputStreamByteConsumer11.accept(100);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(byteArray10);
    }

    @Test
    public void test0794() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0794");
        org.apache.commons.compress.compressors.CompressorStreamFactory compressorStreamFactory0 = new org.apache.commons.compress.compressors.CompressorStreamFactory();
        java.util.SortedMap<java.lang.String, org.apache.commons.compress.compressors.CompressorStreamProvider> strMap1 = compressorStreamFactory0.getCompressorOutputStreamProviders();
        java.util.Set<java.lang.String> strSet2 = compressorStreamFactory0.getOutputStreamCompressorNames();
        java.io.InputStream inputStream3 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream4 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream3);
        byte[] byteArray5 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream4);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.CompressorInputStream compressorInputStream6 = compressorStreamFactory0.createCompressorInputStream((java.io.InputStream) cpioArchiveInputStream4);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Mark is not supported.");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strMap1);
        org.junit.Assert.assertNotNull(strSet2);
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] {});
    }

    @Test
    public void test0795() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0795");
        int int0 = org.objectweb.asm.ClassReader.SKIP_FRAMES;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 4 + "'", int0 == 4);
    }

    @Test
    public void test0796() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0796");
        org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData unparseableExtraFieldData0 = new org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort1 = unparseableExtraFieldData0.getHeaderId();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort2 = unparseableExtraFieldData0.getCentralDirectoryLength();
        int int3 = zipShort2.getValue();
        org.junit.Assert.assertNotNull(zipShort1);
        org.junit.Assert.assertNotNull(zipShort2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
    }

    @Test
    public void test0797() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0797");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        java.lang.String str1 = sevenZArchiveEntry0.getName();
        boolean boolean2 = sevenZArchiveEntry0.isDirectory();
        sevenZArchiveEntry0.setCrc(0);
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test0798() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0798");
        java.io.File file0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipFile zipFile2 = new org.apache.commons.compress.archivers.zip.ZipFile(file0, "unpack.deflate.hint");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0799() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0799");
        org.apache.commons.compress.archivers.zip.UnsupportedZipFeatureException.Feature feature0 = null;
        org.apache.commons.compress.archivers.zip.UnsupportedZipFeatureException unsupportedZipFeatureException1 = new org.apache.commons.compress.archivers.zip.UnsupportedZipFeatureException(feature0);
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry zipArchiveEntry2 = unsupportedZipFeatureException1.getEntry();
        org.junit.Assert.assertNull(zipArchiveEntry2);
    }

    @Test
    public void test0800() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0800");
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader0 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        org.apache.commons.compress.harmony.pack200.BandSet.BandAnalysisResults bandAnalysisResults1 = segmentHeader0.new BandAnalysisResults();
        org.apache.commons.compress.harmony.pack200.BandSet.BandAnalysisResults bandAnalysisResults2 = segmentHeader0.new BandAnalysisResults();
        segmentHeader0.setCp_Imethod_count((int) '#');
        int int5 = segmentHeader0.getArchive_modtime();
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test0801() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0801");
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder0 = new org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder();
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder2 = builder0.setCharSequence((java.lang.CharSequence) "arj");
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder4 = builder0.setPassword("UTF-8:splitting");
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder6 = builder4.setCharSequence((java.lang.CharSequence) "z");
        java.io.File file7 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder8 = builder4.setFile(file7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder2);
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(builder6);
    }

    @Test
    public void test0802() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0802");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_1 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("ACC_PROTECTED");
    }

    @Test
    public void test0803() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0803");
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
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder21 = builder19.setCharSequence((java.lang.CharSequence) "dump.bz2.gz");
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder23 = builder19.setPath("pack.code.attribute.");
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(bHSDCodec12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] { (byte) 35 });
        org.junit.Assert.assertNotNull(builder17);
        org.junit.Assert.assertNotNull(builder19);
        org.junit.Assert.assertNotNull(builder21);
        org.junit.Assert.assertNotNull(builder23);
    }

    @Test
    public void test0804() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0804");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("", true);
        tarArchiveEntry2.setSize((long) 40960);
        org.apache.commons.compress.archivers.tar.TarArchiveEntry[] tarArchiveEntryArray5 = tarArchiveEntry2.getDirectoryEntries();
        boolean boolean6 = tarArchiveEntry2.isFIFO();
        org.junit.Assert.assertNotNull(tarArchiveEntryArray5);
        org.junit.Assert.assertArrayEquals(tarArchiveEntryArray5, new org.apache.commons.compress.archivers.tar.TarArchiveEntry[] {});
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test0805() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0805");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file3 = tarArchiveEntry2.getFile();
        tarArchiveEntry2.setSize((long) '#');
        byte[] byteArray7 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(0L);
        boolean boolean9 = org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.matches(byteArray7, 52);
        // The following exception was thrown during execution in test generation
        try {
            tarArchiveEntry2.writeEntryHeader(byteArray7);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: null");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(file3);
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) 0, (byte) 0, (byte) 33, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test0806() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0806");
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel1 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        long long2 = seekableInMemoryByteChannel1.size();
        long long3 = seekableInMemoryByteChannel1.position();
        char[] charArray9 = new char[] { '4', ' ', '#', '4', 'a' };
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZFile sevenZFile10 = new org.apache.commons.compress.archivers.sevenz.SevenZFile((java.nio.channels.SeekableByteChannel) seekableInMemoryByteChannel1, charArray9);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.IOUtils.read(Ljava/nio/channels/ReadableByteChannel;Ljava/nio/ByteBuffer;)I");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 96L + "'", long2 == 96L);
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertNotNull(charArray9);
        org.junit.Assert.assertArrayEquals(charArray9, new char[] { '4', ' ', '#', '4', 'a' });
    }

    @Test
    public void test0807() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0807");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime1 = null;
        x5455_ExtendedTimestamp0.setAccessFileTime(fileTime1);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = x5455_ExtendedTimestamp0.getLocalFileDataLength();
        java.lang.Object obj4 = x5455_ExtendedTimestamp0.clone();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong5 = x5455_ExtendedTimestamp0.getAccessTime();
        byte byte6 = x5455_ExtendedTimestamp0.getFlags();
        java.nio.file.attribute.FileTime fileTime7 = x5455_ExtendedTimestamp0.getModifyFileTime();
        org.junit.Assert.assertNotNull(zipShort3);
        org.junit.Assert.assertNotNull(obj4);
        org.junit.Assert.assertEquals(obj4.toString(), "0x5455 Zip Extra Field: Flags=0 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(obj4), "0x5455 Zip Extra Field: Flags=0 ");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj4), "0x5455 Zip Extra Field: Flags=0 ");
        org.junit.Assert.assertNull(zipLong5);
        org.junit.Assert.assertTrue("'" + byte6 + "' != '" + (byte) 0 + "'", byte6 == (byte) 0);
        org.junit.Assert.assertNull(fileTime7);
    }

    @Test
    public void test0808() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0808");
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel1 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        org.apache.commons.compress.archivers.tar.TarFile tarFile2 = new org.apache.commons.compress.archivers.tar.TarFile((java.nio.channels.SeekableByteChannel) seekableInMemoryByteChannel1);
        seekableInMemoryByteChannel1.close();
        boolean boolean4 = seekableInMemoryByteChannel1.isOpen();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test0809() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0809");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream8 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 4);
        // The following exception was thrown during execution in test generation
        try {
            zstdCompressorOutputStream8.close();
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: No current CPIO entry");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test0810() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0810");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.read();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
    }

    @Test
    public void test0811() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0811");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime1 = null;
        x5455_ExtendedTimestamp0.setAccessFileTime(fileTime1);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = x5455_ExtendedTimestamp0.getLocalFileDataLength();
        java.lang.Object obj4 = x5455_ExtendedTimestamp0.clone();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong5 = x5455_ExtendedTimestamp0.getAccessTime();
        byte byte6 = x5455_ExtendedTimestamp0.getFlags();
        boolean boolean7 = x5455_ExtendedTimestamp0.isBit2_createTimePresent();
        byte[] byteArray8 = x5455_ExtendedTimestamp0.getLocalFileDataData();
        long long9 = org.apache.commons.compress.archivers.tar.TarUtils.computeCheckSum(byteArray8);
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
        org.junit.Assert.assertTrue("'" + long9 + "' != '" + 0L + "'", long9 == 0L);
    }

    @Test
    public void test0812() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0812");
        java.nio.file.Path[] pathArray0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.nio.channels.SeekableByteChannel seekableByteChannel1 = org.apache.commons.compress.utils.MultiReadOnlySeekableByteChannel.forPaths(pathArray0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: paths");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0813() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0813");
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
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.deflate.DeflateCompressorInputStream deflateCompressorInputStream20 = new org.apache.commons.compress.compressors.deflate.DeflateCompressorInputStream((java.io.InputStream) countingInputStream4);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
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
    }

    @Test
    public void test0814() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0814");
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel1 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.Builder builder2 = org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.builder();
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.Builder builder4 = builder2.withMaxMemoryLimitInKb(1000);
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions sevenZFileOptions5 = builder2.build();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZFile sevenZFile6 = new org.apache.commons.compress.archivers.sevenz.SevenZFile((java.nio.channels.SeekableByteChannel) seekableInMemoryByteChannel1, sevenZFileOptions5);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.IOUtils.read(Ljava/nio/channels/ReadableByteChannel;Ljava/nio/ByteBuffer;)I");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder2);
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(sevenZFileOptions5);
    }

    @Test
    public void test0815() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0815");
        org.apache.commons.compress.harmony.pack200.Segment segment2 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands4 = new org.apache.commons.compress.harmony.pack200.CpBands(segment2, (int) (byte) 2);
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS5 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.pack200.CPConstant<?> wildcardCPConstant6 = cpBands4.getConstant((java.lang.Object) oS5);
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader7 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        org.apache.commons.compress.harmony.pack200.MetadataBandGroup metadataBandGroup9 = new org.apache.commons.compress.harmony.pack200.MetadataBandGroup("LocalVariableTypeTable", 16, cpBands4, segmentHeader7, 263);
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_11 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        cPUTF8_11.setIndex(4);
        org.apache.commons.compress.harmony.pack200.Segment segment14 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands16 = new org.apache.commons.compress.harmony.pack200.CpBands(segment14, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature18 = cpBands16.getCPSignature("ustar\000");
        org.apache.commons.compress.harmony.pack200.CPNameAndType cPNameAndType19 = new org.apache.commons.compress.harmony.pack200.CPNameAndType(cPUTF8_11, cPSignature18);
        org.apache.commons.compress.harmony.pack200.Segment segment20 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands22 = new org.apache.commons.compress.harmony.pack200.CpBands(segment20, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature24 = cpBands22.getCPSignature("ustar\000");
        int int25 = cPSignature24.getIndexInCpUtf8();
        org.apache.commons.compress.harmony.pack200.Segment segment26 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands28 = new org.apache.commons.compress.harmony.pack200.CpBands(segment26, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature30 = cpBands28.getCPSignature("ustar\000");
        org.apache.commons.compress.harmony.pack200.CPSignature[] cPSignatureArray31 = new org.apache.commons.compress.harmony.pack200.CPSignature[] { cPSignature18, cPSignature24, cPSignature30 };
        java.util.ArrayList<org.apache.commons.compress.harmony.pack200.CPSignature> cPSignatureList32 = new java.util.ArrayList<org.apache.commons.compress.harmony.pack200.CPSignature>();
        boolean boolean33 = java.util.Collections.addAll((java.util.Collection<org.apache.commons.compress.harmony.pack200.CPSignature>) cPSignatureList32, cPSignatureArray31);
        metadataBandGroup9.caseet_RS = cPSignatureList32;
        org.junit.Assert.assertTrue("'" + oS5 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS5.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertNull(wildcardCPConstant6);
        org.junit.Assert.assertNotNull(cPSignature18);
        org.junit.Assert.assertNotNull(cPSignature24);
        org.junit.Assert.assertTrue("'" + int25 + "' != '" + (-1) + "'", int25 == (-1));
        org.junit.Assert.assertNotNull(cPSignature30);
        org.junit.Assert.assertNotNull(cPSignatureArray31);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + true + "'", boolean33 == true);
    }

    @Test
    public void test0816() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0816");
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.ByteCodeForm byteCodeForm1 = org.apache.commons.compress.harmony.unpack200.bytecode.forms.ByteCodeForm.get((int) (byte) 55);
        org.junit.Assert.assertNotNull(byteCodeForm1);
    }

    @Test
    public void test0817() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0817");
        short short0 = org.apache.commons.compress.archivers.cpio.CpioConstants.FORMAT_OLD_ASCII;
        org.junit.Assert.assertTrue("'" + short0 + "' != '" + (short) 4 + "'", short0 == (short) 4);
    }

    @Test
    public void test0818() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0818");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        boolean boolean3 = dumpArchiveEntry2.isDirectory();
        int int4 = dumpArchiveEntry2.getNlink();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
    }

    @Test
    public void test0819() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0819");
        org.apache.commons.compress.archivers.zip.ZipLong zipLong0 = org.apache.commons.compress.archivers.zip.ZipLong.SINGLE_SEGMENT_SPLIT_MARKER;
        java.lang.Object obj1 = zipLong0.clone();
        org.junit.Assert.assertNotNull(zipLong0);
        org.junit.Assert.assertNotNull(obj1);
        org.junit.Assert.assertEquals(obj1.toString(), "ZipLong value: 808471376");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(obj1), "ZipLong value: 808471376");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj1), "ZipLong value: 808471376");
    }

    @Test
    public void test0820() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0820");
        org.apache.commons.compress.archivers.sevenz.SevenZMethod sevenZMethod0 = org.apache.commons.compress.archivers.sevenz.SevenZMethod.BCJ_ARM_FILTER;
        org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration sevenZMethodConfiguration1 = new org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration(sevenZMethod0);
        org.apache.commons.compress.archivers.sevenz.SevenZMethod sevenZMethod2 = sevenZMethodConfiguration1.getMethod();
        org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration sevenZMethodConfiguration3 = new org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration(sevenZMethod2);
        org.junit.Assert.assertTrue("'" + sevenZMethod0 + "' != '" + org.apache.commons.compress.archivers.sevenz.SevenZMethod.BCJ_ARM_FILTER + "'", sevenZMethod0.equals(org.apache.commons.compress.archivers.sevenz.SevenZMethod.BCJ_ARM_FILTER));
        org.junit.Assert.assertTrue("'" + sevenZMethod2 + "' != '" + org.apache.commons.compress.archivers.sevenz.SevenZMethod.BCJ_ARM_FILTER + "'", sevenZMethod2.equals(org.apache.commons.compress.archivers.sevenz.SevenZMethod.BCJ_ARM_FILTER));
    }

    @Test
    public void test0821() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0821");
        org.apache.commons.compress.archivers.zip.ZipLong zipLong0 = org.apache.commons.compress.archivers.zip.ZipLong.AED_SIG;
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
        // The following exception was thrown during execution in test generation
        try {
            zipLong0.putLong(byteArray15, (int) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 1");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(zipLong0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(bHSDCodec12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] { (byte) 35 });
    }

    @Test
    public void test0822() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0822");
        java.io.File file0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.nio.channels.SeekableByteChannel seekableByteChannel1 = org.apache.commons.compress.archivers.zip.ZipSplitReadOnlySeekableByteChannel.buildFromLastSplitSegment(file0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0823() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0823");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS1 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.from(476);
        org.junit.Assert.assertTrue("'" + oS1 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.UNKNOWN + "'", oS1.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.UNKNOWN));
    }

    @Test
    public void test0824() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0824");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        long long3 = cpioArchiveInputStream1.skip((long) 8);
        org.apache.commons.compress.utils.CountingInputStream countingInputStream4 = new org.apache.commons.compress.utils.CountingInputStream((java.io.InputStream) cpioArchiveInputStream1);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.arj.ArjArchiveInputStream arjArchiveInputStream6 = new org.apache.commons.compress.archivers.arj.ArjArchiveInputStream((java.io.InputStream) countingInputStream4, "`\n");
            org.junit.Assert.fail("Expected exception of type java.nio.charset.IllegalCharsetNameException; message: `?");
        } catch (java.nio.charset.IllegalCharsetNameException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
    }

    @Test
    public void test0825() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0825");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file3 = tarArchiveEntry2.getFile();
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry6 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        int int7 = tarArchiveEntry6.getDevMinor();
        boolean boolean8 = tarArchiveEntry2.isDescendent(tarArchiveEntry6);
        org.junit.Assert.assertNull(file3);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test0826() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0826");
        org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream.Parameters parameters0 = org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream.Parameters.DEFAULT;
        org.junit.Assert.assertNotNull(parameters0);
    }

    @Test
    public void test0827() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0827");
        byte byte0 = org.apache.commons.compress.archivers.tar.TarConstants.LF_NORMAL;
        org.junit.Assert.assertTrue("'" + byte0 + "' != '" + (byte) 48 + "'", byte0 == (byte) 48);
    }

    @Test
    public void test0828() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0828");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass3 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry4 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass3);
        java.io.DataOutputStream dataOutputStream5 = null;
        // The following exception was thrown during execution in test generation
        try {
            exceptionTableEntry4.write(dataOutputStream5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0829() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0829");
        org.apache.commons.compress.harmony.pack200.Segment segment0 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands2 = new org.apache.commons.compress.harmony.pack200.CpBands(segment0, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPMethodOrField cPMethodOrField6 = cpBands2.getCPMethod("", "zstd", "ACC_STRICT");
        org.apache.commons.compress.harmony.pack200.CPClass cPClass8 = cpBands2.getCPClass("true");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_10 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        cPUTF8_10.setIndex(4);
        org.apache.commons.compress.harmony.pack200.Segment segment13 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands15 = new org.apache.commons.compress.harmony.pack200.CpBands(segment13, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature17 = cpBands15.getCPSignature("ustar\000");
        org.apache.commons.compress.harmony.pack200.CPNameAndType cPNameAndType18 = new org.apache.commons.compress.harmony.pack200.CPNameAndType(cPUTF8_10, cPSignature17);
        org.apache.commons.compress.harmony.pack200.CPMethodOrField cPMethodOrField19 = new org.apache.commons.compress.harmony.pack200.CPMethodOrField(cPClass8, cPNameAndType18);
        org.junit.Assert.assertNotNull(cPMethodOrField6);
        org.junit.Assert.assertNotNull(cPClass8);
        org.junit.Assert.assertNotNull(cPSignature17);
    }

    @Test
    public void test0830() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0830");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass3 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry4 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass3);
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass5 = exceptionTableEntry4.getCatchType();
        java.lang.Integer[] intArray38 = new java.lang.Integer[] { 16877, 10240, 6, 476, 135, 263, 16877, 2, 488, 1000, 252, 7, 9, 255, 2, 493, 255, 1000, 0, 263, 256, 33188, 134630224, 4096, 488, 32, 252, 32768, 33188, 5, 255, 32782 };
        java.util.ArrayList<java.lang.Integer> intList39 = new java.util.ArrayList<java.lang.Integer>();
        boolean boolean40 = java.util.Collections.addAll((java.util.Collection<java.lang.Integer>) intList39, intArray38);
        // The following exception was thrown during execution in test generation
        try {
            exceptionTableEntry4.renumber((java.util.List<java.lang.Integer>) intList39);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 34, Size: 32");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(cPClass5);
        org.junit.Assert.assertNotNull(intArray38);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + true + "'", boolean40 == true);
    }

    @Test
    public void test0831() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0831");
        org.apache.commons.compress.harmony.pack200.Segment segment2 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands4 = new org.apache.commons.compress.harmony.pack200.CpBands(segment2, (int) (byte) 2);
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS5 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.pack200.CPConstant<?> wildcardCPConstant6 = cpBands4.getConstant((java.lang.Object) oS5);
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader7 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        org.apache.commons.compress.harmony.pack200.MetadataBandGroup metadataBandGroup9 = new org.apache.commons.compress.harmony.pack200.MetadataBandGroup("LocalVariableTypeTable", 16, cpBands4, segmentHeader7, 263);
        java.lang.String[] strArray94 = new java.lang.String[] { "RuntimeVisibleParameterAnnotations", "pack.deflate.hint.lzma.lzma", "pack.deflate.hint.lzma", "0x5455 Zip Extra Field: Flags=0 ", "org.apache.commons.compress.harmony.pack200.Segment$PassException", "RuntimeInvisibleParameterAnnotations", "(5,4)", "deflate", "deflate64", "true", "pack.progress", "RuntimeVisibleParameterAnnotations", "CPMember: UTF-8:splitting(UTF-8:splitting)", "ar", "ACC_STATIC", "deflate64", "ACC_FINAL", "jar", "hi!.lzma", "zstd", "class-file version", "UTF-16BE", "Integer: 8", "lz4-framed", "class-file version", "US-ASCII", "arj", "deflate64", "US-ASCII", "pack.keep.file.order.bz2", "ACC_ANNOTATION", "ISO-8859-1", "unpack.deflate.hint", "ACC_PROTECTED", "org.apache.commons.compress.harmony.pack200.Segment$PassException", "splitting", "TRAILER!!!", "AnnotationDefault", "UTF-8:splitting", "pass", "ACC_STATIC", "snappy-framed", "dump.bz2", "lz4-framed", "cpio", "zstd", "ACC_NATIVE", "ACC_PROTECTED", "ar", "deflate64", "xz", "arj", "Code", "pack.modification.time", "error", "070701", "pack.deflate.hint", "ACC_STATIC", "TRAILER!!!", "ISO-8859-1", "pass", "splitting: 1 annotations", "dump", "deflate", "snappy-framed", "LZ4 Parameters with BlockSize null, withContentChecksum true, withBlockChecksum false, withBlockDependency false", "unpack.deflate.hint", "", "false", "jar", "splitting: 1 annotations", "hi!", "pack.keep.file.order.bz2", "UTF-8:splitting", "\002?\002\n\001", "0x5455 Zip Extra Field: Flags=1  Modify:[Mon Jan 26 10:44:48 AEST 1970] ", "US-ASCII", "z", "pack.keep.file.order", "pack.progress", "pass", "snappy-framed", "impdep2", "ustar\000" };
        java.util.ArrayList<java.lang.String> strList95 = new java.util.ArrayList<java.lang.String>();
        boolean boolean96 = java.util.Collections.addAll((java.util.Collection<java.lang.String>) strList95, strArray94);
        metadataBandGroup9.T = strList95;
        org.apache.commons.compress.harmony.pack200.IntList intList98 = null;
        metadataBandGroup9.casearray_N = intList98;
        org.junit.Assert.assertTrue("'" + oS5 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS5.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertNull(wildcardCPConstant6);
        org.junit.Assert.assertNotNull(strArray94);
        org.junit.Assert.assertTrue("'" + boolean96 + "' != '" + true + "'", boolean96 == true);
    }

    @Test
    public void test0832() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0832");
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker1 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray2 = jarMarker1.getCentralDirectoryData();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField3 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger4 = zip64ExtendedInformationExtraField3.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger5 = null;
        zip64ExtendedInformationExtraField3.setSize(zipEightByteInteger5);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField7 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField8 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger9 = zip64ExtendedInformationExtraField8.getCompressedSize();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField10 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger11 = zip64ExtendedInformationExtraField10.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger12 = null;
        zip64ExtendedInformationExtraField10.setSize(zipEightByteInteger12);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField14 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger15 = zip64ExtendedInformationExtraField14.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger16 = null;
        zip64ExtendedInformationExtraField14.setSize(zipEightByteInteger16);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField18 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipExtraField[] zipExtraFieldArray19 = new org.apache.commons.compress.archivers.zip.ZipExtraField[] { zip64ExtendedInformationExtraField3, zip64ExtendedInformationExtraField7, zip64ExtendedInformationExtraField8, zip64ExtendedInformationExtraField10, zip64ExtendedInformationExtraField14, zip64ExtendedInformationExtraField18 };
        byte[] byteArray20 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.mergeLocalFileDataData(zipExtraFieldArray19);
        boolean boolean21 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray2, byteArray20);
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField24 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField("ustar\000", byteArray20, 0, 9);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.pack200.Pack200ClassReader pack200ClassReader25 = new org.apache.commons.compress.harmony.pack200.Pack200ClassReader(byteArray20);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertNull(zipEightByteInteger4);
        org.junit.Assert.assertNull(zipEightByteInteger9);
        org.junit.Assert.assertNull(zipEightByteInteger11);
        org.junit.Assert.assertNull(zipEightByteInteger15);
        org.junit.Assert.assertNotNull(zipExtraFieldArray19);
        org.junit.Assert.assertNotNull(byteArray20);
        org.junit.Assert.assertArrayEquals(byteArray20, new byte[] { (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
    }

    @Test
    public void test0833() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0833");
        byte[] byteArray3 = new byte[] { (byte) 10, (byte) 10, (byte) -1 };
        boolean boolean5 = org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.matches(byteArray3, (int) (short) -1);
        byte[] byteArray6 = org.apache.commons.compress.archivers.zip.ZipUtil.reverse(byteArray3);
        boolean boolean8 = org.apache.commons.compress.compressors.xz.XZCompressorInputStream.matches(byteArray6, 252);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) -1, (byte) 10, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] { (byte) -1, (byte) 10, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test0834() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0834");
        org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm hashAlgorithm0 = org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm.MD5;
        int int1 = hashAlgorithm0.getCode();
        org.junit.Assert.assertTrue("'" + hashAlgorithm0 + "' != '" + org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm.MD5 + "'", hashAlgorithm0.equals(org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm.MD5));
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 32771 + "'", int1 == 32771);
    }

    @Test
    public void test0835() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0835");
        org.apache.commons.compress.archivers.zip.AsiExtraField asiExtraField0 = new org.apache.commons.compress.archivers.zip.AsiExtraField();
        byte[] byteArray1 = asiExtraField0.getCentralDirectoryData();
        java.io.OutputStream outputStream2 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream4 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream2, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry5 = null;
        boolean boolean6 = cpioArchiveOutputStream4.canWriteEntryData(archiveEntry5);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream8 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream4, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream10 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream8, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap11 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream12 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream10, strMap11);
        boolean boolean13 = pack200CompressorOutputStream12.isClosed();
        org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream snappyCompressorOutputStream15 = new org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream((java.io.OutputStream) pack200CompressorOutputStream12, (long) 10240);
        snappyCompressorOutputStream15.write(28771);
        byte[] byteArray19 = snappyCompressorOutputStream15.writeUsAsciiRaw("pack.progress");
        // The following exception was thrown during execution in test generation
        try {
            asiExtraField0.parseFromCentralDirectoryData(byteArray19, (int) (byte) 75, 256);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 75");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 118, (byte) 104, (byte) -118, (byte) -29, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(byteArray19);
        org.junit.Assert.assertArrayEquals(byteArray19, new byte[] { (byte) 112, (byte) 97, (byte) 99, (byte) 107, (byte) 46, (byte) 112, (byte) 114, (byte) 111, (byte) 103, (byte) 114, (byte) 101, (byte) 115, (byte) 115 });
    }

    @Test
    public void test0836() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0836");
        org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm encryptionAlgorithm0 = org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm.AES256;
        org.junit.Assert.assertTrue("'" + encryptionAlgorithm0 + "' != '" + org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm.AES256 + "'", encryptionAlgorithm0.equals(org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm.AES256));
    }

    @Test
    public void test0837() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0837");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        fixedLengthBlockOutputStream6.write(1024);
        org.apache.commons.compress.compressors.lzma.LZMACompressorOutputStream lZMACompressorOutputStream9 = new org.apache.commons.compress.compressors.lzma.LZMACompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream6);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream10 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream6);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream bZip2CompressorOutputStream11 = new org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream((java.io.OutputStream) zipArchiveOutputStream10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: No current entry");
        } catch (java.lang.IllegalStateException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test0838() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0838");
        byte[] byteArray0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipShort zipShort1 = new org.apache.commons.compress.archivers.zip.ZipShort(byteArray0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0839() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0839");
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField2 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField();
        jarArchiveEntry1.addExtraField((org.apache.commons.compress.archivers.zip.ZipExtraField) unicodeCommentExtraField2);
        boolean boolean4 = jarArchiveEntry1.isStreamContiguous();
        org.apache.commons.compress.parallel.InputStreamSupplier inputStreamSupplier5 = null;
        org.apache.commons.compress.archivers.zip.ZipArchiveEntryRequest zipArchiveEntryRequest6 = org.apache.commons.compress.archivers.zip.ZipArchiveEntryRequest.createZipArchiveEntryRequest((org.apache.commons.compress.archivers.zip.ZipArchiveEntry) jarArchiveEntry1, inputStreamSupplier5);
        jarArchiveEntry1.setInternalAttributes(493);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(zipArchiveEntryRequest6);
    }

    @Test
    public void test0840() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0840");
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
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder21 = builder19.setCharSequence((java.lang.CharSequence) "dump.bz2.gz");
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder23 = builder21.setTryToRecoverBrokenArchives(false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(bHSDCodec12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] { (byte) 35 });
        org.junit.Assert.assertNotNull(builder17);
        org.junit.Assert.assertNotNull(builder19);
        org.junit.Assert.assertNotNull(builder21);
        org.junit.Assert.assertNotNull(builder23);
    }

    @Test
    public void test0841() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0841");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        boolean boolean1 = sevenZArchiveEntry0.getHasCrc();
        sevenZArchiveEntry0.setAntiItem(true);
        sevenZArchiveEntry0.setCreationDate((long) '4');
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0842() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0842");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file3 = tarArchiveEntry2.getFile();
        boolean boolean4 = tarArchiveEntry2.isGNUSparse();
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry5 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date6 = arjArchiveEntry5.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong7 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date6);
        tarArchiveEntry2.setModTime(date6);
        java.nio.file.attribute.FileTime fileTime9 = tarArchiveEntry2.getLastModifiedTime();
        long long10 = org.apache.commons.compress.utils.TimeUtils.toNtfsTime(fileTime9);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean11 = org.apache.commons.compress.utils.TimeUtils.isUnixTime(fileTime9);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.file.attribute.FileTimes.isUnixTime(Ljava/nio/file/attribute/FileTime;)Z");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(file3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(date6);
        org.junit.Assert.assertEquals(date6.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong7);
        org.junit.Assert.assertNotNull(fileTime9);
        org.junit.Assert.assertTrue("'" + long10 + "' != '" + 119572020000000000L + "'", long10 == 119572020000000000L);
    }

    @Test
    public void test0843() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0843");
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode1 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int2 = byteCode1.getByteCodeIndex();
        int[] intArray3 = new int[] {};
        int[] intArray4 = new int[] {};
        int[] intArray5 = new int[] {};
        int[][] intArray6 = new int[][] { intArray3, intArray4, intArray5 };
        byteCode1.setNestedPositions(intArray6);
        int[] intArray8 = byteCode1.getRewrite();
        // The following exception was thrown during execution in test generation
        try {
            byteCode1.setOperandSigned2Bytes(32771, (int) '#');
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
    }

    @Test
    public void test0844() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0844");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_2);
        org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute newAttribute5 = new org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute(cPUTF8_2, 8);
        byte byte6 = cPUTF8_2.getTag();
        java.io.DataOutputStream dataOutputStream7 = null;
        // The following exception was thrown during execution in test generation
        try {
            cPUTF8_2.doWrite(dataOutputStream7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + byte6 + "' != '" + (byte) 1 + "'", byte6 == (byte) 1);
    }

    @Test
    public void test0845() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0845");
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData unparseableExtraFieldData2 = jarArchiveEntry1.getUnparseableExtraFieldData();
        org.apache.commons.compress.archivers.zip.GeneralPurposeBit generalPurposeBit3 = jarArchiveEntry1.getGeneralPurposeBit();
        boolean boolean4 = generalPurposeBit3.usesStrongEncryption();
        boolean boolean5 = generalPurposeBit3.usesUTF8ForNames();
        org.junit.Assert.assertNull(unparseableExtraFieldData2);
        org.junit.Assert.assertNotNull(generalPurposeBit3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test0846() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0846");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        boolean boolean1 = sevenZArchiveEntry0.getHasCrc();
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry4 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file5 = tarArchiveEntry4.getFile();
        boolean boolean6 = tarArchiveEntry4.isGNUSparse();
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry7 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date8 = arjArchiveEntry7.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong9 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date8);
        tarArchiveEntry4.setModTime(date8);
        java.nio.file.attribute.FileTime fileTime11 = tarArchiveEntry4.getLastModifiedTime();
        long long12 = org.apache.commons.compress.utils.TimeUtils.toNtfsTime(fileTime11);
        sevenZArchiveEntry0.setLastModifiedTime(fileTime11);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNull(file5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(date8);
        org.junit.Assert.assertEquals(date8.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong9);
        org.junit.Assert.assertNotNull(fileTime11);
        org.junit.Assert.assertTrue("'" + long12 + "' != '" + 119572020000000000L + "'", long12 == 119572020000000000L);
    }

    @Test
    public void test0847() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0847");
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder0 = new org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder();
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder2 = builder0.setCharSequence((java.lang.CharSequence) "arj");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder4 = builder2.setCharset("ar");
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.Charsets.toCharset(Ljava/lang/String;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder2);
    }

    @Test
    public void test0848() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0848");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream8 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 4);
        org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream deflateCompressorOutputStream9 = new org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        // The following exception was thrown during execution in test generation
        try {
            cpioArchiveOutputStream2.finish();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test0849() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0849");
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader0 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        boolean boolean1 = segmentHeader0.have_method_flags_hi();
        java.io.OutputStream outputStream2 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream4 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream2, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry5 = null;
        boolean boolean6 = cpioArchiveOutputStream4.canWriteEntryData(archiveEntry5);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream8 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream4, 135);
        org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream framedLZ4CompressorOutputStream9 = new org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream8);
        segmentHeader0.pack((java.io.OutputStream) framedLZ4CompressorOutputStream9);
        segmentHeader0.setDeflate_hint(true);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test0850() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0850");
        boolean boolean0 = org.apache.commons.compress.utils.OsgiUtils.isRunningInOsgiEnvironment();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0851() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0851");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry6 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean7 = cpioArchiveOutputStream2.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry6);
        java.io.File file8 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long9 = cpioArchiveOutputStream2.write(file8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test0852() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0852");
        org.apache.commons.compress.harmony.pack200.Segment segment0 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands2 = new org.apache.commons.compress.harmony.pack200.CpBands(segment0, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPMethodOrField cPMethodOrField6 = cpBands2.getCPMethod("", "zstd", "ACC_STRICT");
        org.apache.commons.compress.harmony.pack200.CPClass cPClass8 = cpBands2.getCPClass("true");
        java.io.OutputStream outputStream9 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream11 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream9, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry12 = null;
        boolean boolean13 = cpioArchiveOutputStream11.canWriteEntryData(archiveEntry12);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream15 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream11, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream17 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream11, 4);
        byte[] byteArray19 = zstdCompressorOutputStream17.writeUsAsciiRaw("org.apache.commons.compress.harmony.pack200.Segment$PassException");
        cpBands2.pack((java.io.OutputStream) zstdCompressorOutputStream17);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec21 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean22 = bHSDCodec21.isDelta();
        byte[] byteArray24 = bHSDCodec21.encode((int) '#');
        org.apache.commons.compress.harmony.pack200.CPConstant<?> wildcardCPConstant25 = cpBands2.getConstant((java.lang.Object) '#');
        org.junit.Assert.assertNotNull(cPMethodOrField6);
        org.junit.Assert.assertNotNull(cPClass8);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertNotNull(byteArray19);
        org.junit.Assert.assertNotNull(bHSDCodec21);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(byteArray24);
        org.junit.Assert.assertArrayEquals(byteArray24, new byte[] { (byte) 35 });
        org.junit.Assert.assertNull(wildcardCPConstant25);
    }

    @Test
    public void test0853() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0853");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream3 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream4 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry6 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        jarArchiveEntry6.setUnixMode(16877);
        // The following exception was thrown during execution in test generation
        try {
            zipArchiveOutputStream4.putArchiveEntry((org.apache.commons.compress.archivers.zip.ZipArchiveEntry) jarArchiveEntry6);
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: No current CPIO entry");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0854() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0854");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        java.lang.String str1 = sevenZArchiveEntry0.getName();
        sevenZArchiveEntry0.setHasCrc(false);
        sevenZArchiveEntry0.setSize((long) 'a');
        // The following exception was thrown during execution in test generation
        try {
            java.nio.file.attribute.FileTime fileTime6 = sevenZArchiveEntry0.getLastModifiedTime();
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: The entry doesn't have this timestamp");
        } catch (java.lang.UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(str1);
    }

    @Test
    public void test0855() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0855");
        org.apache.commons.compress.archivers.zip.UnrecognizedExtraField unrecognizedExtraField0 = new org.apache.commons.compress.archivers.zip.UnrecognizedExtraField();
        org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData unparseableExtraFieldData1 = new org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort2 = unparseableExtraFieldData1.getHeaderId();
        unrecognizedExtraField0.setHeaderId(zipShort2);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort4 = unrecognizedExtraField0.getHeaderId();
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp5 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime6 = null;
        x5455_ExtendedTimestamp5.setAccessFileTime(fileTime6);
        byte[] byteArray8 = x5455_ExtendedTimestamp5.getLocalFileDataData();
        org.apache.commons.compress.compressors.lz77support.LZ77Compressor.LiteralBlock literalBlock11 = new org.apache.commons.compress.compressors.lz77support.LZ77Compressor.LiteralBlock(byteArray8, 40960, 8);
        byte[] byteArray12 = literalBlock11.getData();
        unrecognizedExtraField0.setLocalFileDataData(byteArray12);
        java.io.OutputStream outputStream14 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream16 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream14, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry17 = null;
        boolean boolean18 = cpioArchiveOutputStream16.canWriteEntryData(archiveEntry17);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream20 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream16, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream22 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream16, 4);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream24 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream16, 32);
        byte[] byteArray26 = zstdCompressorOutputStream24.writeUsAsciiRaw("(5,4)");
        // The following exception was thrown during execution in test generation
        try {
            unrecognizedExtraField0.parseFromLocalFileData(byteArray26, 512, (int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: null");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(zipShort2);
        org.junit.Assert.assertNotNull(zipShort4);
        org.junit.Assert.assertNotNull(byteArray8);
        org.junit.Assert.assertArrayEquals(byteArray8, new byte[] { (byte) 0 });
        org.junit.Assert.assertNotNull(byteArray12);
        org.junit.Assert.assertArrayEquals(byteArray12, new byte[] { (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertNotNull(byteArray26);
        org.junit.Assert.assertArrayEquals(byteArray26, new byte[] { (byte) 40, (byte) 53, (byte) 44, (byte) 52, (byte) 41 });
    }

    @Test
    public void test0856() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0856");
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader0 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        boolean boolean1 = segmentHeader0.have_method_flags_hi();
        segmentHeader0.setIc_count((int) '4');
        boolean boolean4 = segmentHeader0.have_all_code_flags();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test0857() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0857");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_3 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_5 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition attributeDefinition6 = new org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition(4096, 493, cPUTF8_3, cPUTF8_5);
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_10 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_12 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition attributeDefinition13 = new org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition(4096, 493, cPUTF8_10, cPUTF8_12);
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_14 = attributeDefinition13.name;
        attributeDefinition6.layout = cPUTF8_14;
        int int16 = attributeDefinition6.contextType;
        int int17 = attributeDefinition6.index;
        org.junit.Assert.assertNotNull(cPUTF8_14);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 493 + "'", int16 == 493);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 4096 + "'", int17 == 4096);
    }

    @Test
    public void test0858() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0858");
        int int0 = org.apache.commons.compress.archivers.zip.UnixStat.DEFAULT_FILE_PERM;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 420 + "'", int0 == 420);
    }

    @Test
    public void test0859() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0859");
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
        boolean boolean21 = xZCompressorOutputStream18.isClosed();
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + long17 + "' != '" + 0L + "'", long17 == 0L);
        org.junit.Assert.assertNotNull(byteArray20);
        org.junit.Assert.assertArrayEquals(byteArray20, new byte[] { (byte) 120, (byte) 122 });
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
    }

    @Test
    public void test0860() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0860");
        org.apache.commons.compress.compressors.CompressorStreamFactory compressorStreamFactory0 = new org.apache.commons.compress.compressors.CompressorStreamFactory();
        java.util.SortedMap<java.lang.String, org.apache.commons.compress.compressors.CompressorStreamProvider> strMap1 = compressorStreamFactory0.getCompressorOutputStreamProviders();
        compressorStreamFactory0.setDecompressConcatenated(true);
        org.junit.Assert.assertNotNull(strMap1);
    }

    @Test
    public void test0861() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0861");
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
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarArchiveOutputStream tarArchiveOutputStream45 = new org.apache.commons.compress.archivers.tar.TarArchiveOutputStream((java.io.OutputStream) pack200CompressorOutputStream12, (int) ' ', (int) '4', "ACC_ANNOTATION");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Block size must be a multiple of 512 bytes. Attempt to use set size of 32");
        } catch (java.lang.IllegalArgumentException e) {
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
    }

    @Test
    public void test0862() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0862");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.jar.JarArchiveOutputStream jarArchiveOutputStream6 = new org.apache.commons.compress.archivers.jar.JarArchiveOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, "RuntimeVisibleParameterAnnotations");
            org.junit.Assert.fail("Expected exception of type java.nio.charset.UnsupportedCharsetException; message: RuntimeVisibleParameterAnnotations");
        } catch (java.nio.charset.UnsupportedCharsetException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test0863() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0863");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        dumpArchiveEntry2.setMode((int) '4');
        dumpArchiveEntry2.setOffset((long) (byte) -1);
        java.util.Date date7 = dumpArchiveEntry2.getAccessTime();
        org.junit.Assert.assertNotNull(date7);
        org.junit.Assert.assertEquals(date7.toString(), "Thu Jan 01 10:00:00 AEST 1970");
    }

    @Test
    public void test0864() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0864");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipFile zipFile1 = new org.apache.commons.compress.archivers.zip.ZipFile("ACC_NATIVE");
            org.junit.Assert.fail("Expected exception of type java.nio.file.NoSuchFileException; message: ACC_NATIVE");
        } catch (java.nio.file.NoSuchFileException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0865() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0865");
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker1 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray2 = jarMarker1.getCentralDirectoryData();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField3 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger4 = zip64ExtendedInformationExtraField3.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger5 = null;
        zip64ExtendedInformationExtraField3.setSize(zipEightByteInteger5);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField7 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField8 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger9 = zip64ExtendedInformationExtraField8.getCompressedSize();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField10 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger11 = zip64ExtendedInformationExtraField10.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger12 = null;
        zip64ExtendedInformationExtraField10.setSize(zipEightByteInteger12);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField14 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger15 = zip64ExtendedInformationExtraField14.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger16 = null;
        zip64ExtendedInformationExtraField14.setSize(zipEightByteInteger16);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField18 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipExtraField[] zipExtraFieldArray19 = new org.apache.commons.compress.archivers.zip.ZipExtraField[] { zip64ExtendedInformationExtraField3, zip64ExtendedInformationExtraField7, zip64ExtendedInformationExtraField8, zip64ExtendedInformationExtraField10, zip64ExtendedInformationExtraField14, zip64ExtendedInformationExtraField18 };
        byte[] byteArray20 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.mergeLocalFileDataData(zipExtraFieldArray19);
        boolean boolean21 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray2, byteArray20);
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField24 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField("ustar\000", byteArray20, 0, 9);
        org.apache.commons.compress.archivers.zip.ZipLong zipLong25 = org.apache.commons.compress.archivers.zip.ZipLong.SINGLE_SEGMENT_SPLIT_MARKER;
        byte[] byteArray26 = zipLong25.getBytes();
        unicodeCommentExtraField24.setUnicodeName(byteArray26);
        // The following exception was thrown during execution in test generation
        try {
            long long29 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.getLongValue(byteArray26, 9);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: null");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertNull(zipEightByteInteger4);
        org.junit.Assert.assertNull(zipEightByteInteger9);
        org.junit.Assert.assertNull(zipEightByteInteger11);
        org.junit.Assert.assertNull(zipEightByteInteger15);
        org.junit.Assert.assertNotNull(zipExtraFieldArray19);
        org.junit.Assert.assertNotNull(byteArray20);
        org.junit.Assert.assertArrayEquals(byteArray20, new byte[] { (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(zipLong25);
        org.junit.Assert.assertNotNull(byteArray26);
        org.junit.Assert.assertArrayEquals(byteArray26, new byte[] { (byte) 80, (byte) 75, (byte) 48, (byte) 48 });
    }

    @Test
    public void test0866() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0866");
        java.lang.String str0 = org.apache.commons.compress.harmony.unpack200.AttributeLayout.ACC_VOLATILE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "ACC_VOLATILE" + "'", str0, "ACC_VOLATILE");
    }

    @Test
    public void test0867() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0867");
        org.apache.commons.compress.compressors.lz77support.LZ77Compressor.BackReference backReference2 = new org.apache.commons.compress.compressors.lz77support.LZ77Compressor.BackReference((int) (byte) 55, (int) (byte) 48);
    }

    @Test
    public void test0868() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0868");
        byte[] byteArray1 = org.apache.commons.compress.utils.ByteUtils.EMPTY_BYTE_ARRAY;
        // The following exception was thrown during execution in test generation
        try {
            int int4 = org.apache.commons.compress.archivers.tar.TarUtils.formatLongOctalBytes((long) 134630224, byteArray1, 512, 28771);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 29281");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] {});
    }

    @Test
    public void test0869() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0869");
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel1 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        long long2 = seekableInMemoryByteChannel1.size();
        long long3 = seekableInMemoryByteChannel1.position();
        java.nio.charset.Charset charset4 = null;
        org.apache.commons.compress.archivers.zip.ZipEncoding zipEncoding5 = org.apache.commons.compress.archivers.zip.ZipEncodingHelper.getZipEncoding(charset4);
        byte[] byteArray11 = new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 };
        byte[] byteArray18 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean20 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray18, 0);
        boolean boolean21 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray11, byteArray18);
        java.lang.String str22 = zipEncoding5.decode(byteArray11);
        java.nio.ByteBuffer byteBuffer24 = zipEncoding5.encode("SourceFile");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.utils.IOUtils.readFully((java.nio.channels.ReadableByteChannel) seekableInMemoryByteChannel1, byteBuffer24);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.IOUtils.read(Ljava/nio/channels/ReadableByteChannel;Ljava/nio/ByteBuffer;)I");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 96L + "'", long2 == 96L);
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertNotNull(zipEncoding5);
        org.junit.Assert.assertNotNull(byteArray11);
        org.junit.Assert.assertArrayEquals(byteArray11, new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 });
        org.junit.Assert.assertNotNull(byteArray18);
        org.junit.Assert.assertArrayEquals(byteArray18, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "\002?\002\n\001" + "'", str22, "\002?\002\n\001");
        org.junit.Assert.assertNotNull(byteBuffer24);
    }

    @Test
    public void test0870() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0870");
        org.apache.commons.compress.archivers.ar.ArArchiveEntry arArchiveEntry6 = new org.apache.commons.compress.archivers.ar.ArArchiveEntry("", (long) 'a', 0, 10, 0, (long) (short) 1);
        long long7 = arArchiveEntry6.getSize();
        java.util.Date date8 = arArchiveEntry6.getLastModifiedDate();
        org.junit.Assert.assertTrue("'" + long7 + "' != '" + 97L + "'", long7 == 97L);
        org.junit.Assert.assertNotNull(date8);
        org.junit.Assert.assertEquals(date8.toString(), "Thu Jan 01 10:00:01 AEST 1970");
    }

    @Test
    public void test0871() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0871");
        org.apache.commons.compress.compressors.CompressorStreamFactory compressorStreamFactory1 = new org.apache.commons.compress.compressors.CompressorStreamFactory(true);
        java.util.Set<java.lang.String> strSet2 = compressorStreamFactory1.getInputStreamCompressorNames();
        org.junit.Assert.assertNotNull(strSet2);
    }

    @Test
    public void test0872() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0872");
        java.nio.charset.Charset charset0 = org.apache.commons.compress.utils.Charsets.UTF_16;
        org.junit.Assert.assertNotNull(charset0);
    }

    @Test
    public void test0873() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0873");
        org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE cOMPRESSION_TYPE1 = org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE.find(5);
        org.junit.Assert.assertTrue("'" + cOMPRESSION_TYPE1 + "' != '" + org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE.UNKNOWN + "'", cOMPRESSION_TYPE1.equals(org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE.UNKNOWN));
    }

    @Test
    public void test0874() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0874");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry6 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean7 = cpioArchiveOutputStream2.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry6);
        jarArchiveEntry6.setInternalAttributes((int) (short) 1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test0875() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0875");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        fixedLengthBlockOutputStream6.write(1024);
        org.apache.commons.compress.compressors.xz.XZCompressorOutputStream xZCompressorOutputStream10 = new org.apache.commons.compress.compressors.xz.XZCompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream6, (int) (short) 1);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarArchiveOutputStream tarArchiveOutputStream12 = new org.apache.commons.compress.archivers.tar.TarArchiveOutputStream((java.io.OutputStream) xZCompressorOutputStream10, 33188);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Block size must be a multiple of 512 bytes. Attempt to use set size of 33188");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test0876() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0876");
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder0 = new org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder();
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder2 = builder0.setCharSequence((java.lang.CharSequence) "arj");
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder4 = builder2.setPassword("0x7875 Zip Extra Field: UID=32768 GID=1000");
        org.junit.Assert.assertNotNull(builder2);
        org.junit.Assert.assertNotNull(builder4);
    }

    @Test
    public void test0877() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0877");
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
        java.io.DataOutputStream dataOutputStream22 = null;
        // The following exception was thrown during execution in test generation
        try {
            cPUTF8_2.doWrite(dataOutputStream22);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "UTF-8:splitting" + "'", str4, "UTF-8:splitting");
        org.junit.Assert.assertNotNull(attributeArray18);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
    }

    @Test
    public void test0878() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0878");
        int int0 = org.apache.commons.compress.archivers.arj.ArjArchiveEntry.HostOs.ATARI_ST;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 7 + "'", int0 == 7);
    }

    @Test
    public void test0879() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0879");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream5 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream1, (long) 1, (long) 148);
        java.util.zip.Checksum checksum6 = cRC32VerifyingInputStream5.getChecksum();
        long long8 = cRC32VerifyingInputStream5.skip((long) 345);
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream11 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cRC32VerifyingInputStream5, 8589934591L, (long) '4');
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.zstandard.ZstdCompressorInputStream zstdCompressorInputStream12 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorInputStream((java.io.InputStream) cRC32VerifyingInputStream11);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(checksum6);
        org.junit.Assert.assertTrue("'" + long8 + "' != '" + 0L + "'", long8 == 0L);
    }

    @Test
    public void test0880() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0880");
        org.apache.commons.compress.archivers.zip.ExtraFieldUtils.UnparseableExtraField unparseableExtraField0 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.UnparseableExtraField.READ;
        java.io.OutputStream outputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream3 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream1, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream4 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream3);
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker6 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray7 = jarMarker6.getCentralDirectoryData();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField8 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger9 = zip64ExtendedInformationExtraField8.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger10 = null;
        zip64ExtendedInformationExtraField8.setSize(zipEightByteInteger10);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField12 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField13 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger14 = zip64ExtendedInformationExtraField13.getCompressedSize();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField15 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger16 = zip64ExtendedInformationExtraField15.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger17 = null;
        zip64ExtendedInformationExtraField15.setSize(zipEightByteInteger17);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField19 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger20 = zip64ExtendedInformationExtraField19.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger21 = null;
        zip64ExtendedInformationExtraField19.setSize(zipEightByteInteger21);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField23 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipExtraField[] zipExtraFieldArray24 = new org.apache.commons.compress.archivers.zip.ZipExtraField[] { zip64ExtendedInformationExtraField8, zip64ExtendedInformationExtraField12, zip64ExtendedInformationExtraField13, zip64ExtendedInformationExtraField15, zip64ExtendedInformationExtraField19, zip64ExtendedInformationExtraField23 };
        byte[] byteArray25 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.mergeLocalFileDataData(zipExtraFieldArray24);
        boolean boolean26 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray7, byteArray25);
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField29 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField("ustar\000", byteArray25, 0, 9);
        blockLZ4CompressorOutputStream4.prefill(byteArray25, 21, (int) '4');
        int int33 = org.apache.commons.compress.archivers.zip.ZipShort.getValue(byteArray25);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField38 = unparseableExtraField0.onUnparseableExtraField(byteArray25, 16877, (int) (byte) -1, false, 16384);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: 16877 > 16876");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(unparseableExtraField0);
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] {});
        org.junit.Assert.assertNull(zipEightByteInteger9);
        org.junit.Assert.assertNull(zipEightByteInteger14);
        org.junit.Assert.assertNull(zipEightByteInteger16);
        org.junit.Assert.assertNull(zipEightByteInteger20);
        org.junit.Assert.assertNotNull(zipExtraFieldArray24);
        org.junit.Assert.assertNotNull(byteArray25);
        org.junit.Assert.assertArrayEquals(byteArray25, new byte[] { (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + int33 + "' != '" + 1 + "'", int33 == 1);
    }

    @Test
    public void test0881() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0881");
        int int0 = org.apache.commons.compress.archivers.tar.TarArchiveOutputStream.BIGNUMBER_ERROR;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 0 + "'", int0 == 0);
    }

    @Test
    public void test0882() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0882");
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel1 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder3 = new org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder();
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
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder20 = builder3.setOutputStream((java.io.OutputStream) pack200CompressorOutputStream14);
        char[] charArray26 = new char[] { 'a', 'a', '#', '4', '4' };
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder27 = builder20.setPassword(charArray26);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZFile sevenZFile28 = new org.apache.commons.compress.archivers.sevenz.SevenZFile((java.nio.channels.SeekableByteChannel) seekableInMemoryByteChannel1, "hi!.lzma", charArray26);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.IOUtils.read(Ljava/nio/channels/ReadableByteChannel;Ljava/nio/ByteBuffer;)I");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(bHSDCodec15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(byteArray18);
        org.junit.Assert.assertArrayEquals(byteArray18, new byte[] { (byte) 35 });
        org.junit.Assert.assertNotNull(builder20);
        org.junit.Assert.assertNotNull(charArray26);
        org.junit.Assert.assertArrayEquals(charArray26, new char[] { 'a', 'a', '#', '4', '4' });
        org.junit.Assert.assertNotNull(builder27);
    }

    @Test
    public void test0883() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0883");
        org.apache.commons.compress.archivers.zip.AsiExtraField asiExtraField0 = new org.apache.commons.compress.archivers.zip.AsiExtraField();
        byte[] byteArray1 = asiExtraField0.getCentralDirectoryData();
        java.lang.String str2 = asiExtraField0.getLinkedFile();
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 118, (byte) 104, (byte) -118, (byte) -29, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "" + "'", str2, "");
    }

    @Test
    public void test0884() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0884");
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader0 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        boolean boolean1 = segmentHeader0.have_method_flags_hi();
        int int2 = segmentHeader0.getDefaultMajorVersion();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test0885() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0885");
        java.util.concurrent.ExecutorService executorService0 = null;
        java.nio.file.Path path1 = null;
        org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier defaultBackingStoreSupplier2 = new org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier(path1);
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore3 = defaultBackingStoreSupplier2.get();
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore4 = defaultBackingStoreSupplier2.get();
        org.apache.commons.compress.archivers.zip.ParallelScatterZipCreator parallelScatterZipCreator5 = new org.apache.commons.compress.archivers.zip.ParallelScatterZipCreator(executorService0, (org.apache.commons.compress.parallel.ScatterGatherBackingStoreSupplier) defaultBackingStoreSupplier2);
        java.io.OutputStream outputStream6 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream8 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream6, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry9 = null;
        boolean boolean10 = cpioArchiveOutputStream8.canWriteEntryData(archiveEntry9);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry12 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean13 = cpioArchiveOutputStream8.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry12);
        java.nio.file.attribute.FileTime fileTime14 = jarArchiveEntry12.getLastAccessTime();
        jarArchiveEntry12.setDiskNumberStart(96L);
        org.apache.commons.compress.parallel.InputStreamSupplier inputStreamSupplier17 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.concurrent.Callable<org.apache.commons.compress.archivers.zip.ScatterZipOutputStream> scatterZipOutputStreamCallable18 = parallelScatterZipCreator5.createCallable((org.apache.commons.compress.archivers.zip.ZipArchiveEntry) jarArchiveEntry12, inputStreamSupplier17);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Method must be set on zipArchiveEntry: ACC_NATIVE.gz");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(scatterGatherBackingStore3);
        org.junit.Assert.assertNotNull(scatterGatherBackingStore4);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertNull(fileTime14);
    }

    @Test
    public void test0886() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0886");
        java.lang.String str1 = org.apache.commons.compress.compressors.bzip2.BZip2Utils.getCompressedFilename("apk");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "apk.bz2" + "'", str1, "apk.bz2");
    }

    @Test
    public void test0887() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0887");
        org.apache.commons.compress.archivers.dump.UnsupportedCompressionAlgorithmException unsupportedCompressionAlgorithmException2 = new org.apache.commons.compress.archivers.dump.UnsupportedCompressionAlgorithmException("LocalVariableTypeTable");
        org.apache.commons.compress.compressors.CompressorException compressorException3 = new org.apache.commons.compress.compressors.CompressorException("splitting: 1 annotations", (java.lang.Throwable) unsupportedCompressionAlgorithmException2);
    }

    @Test
    public void test0888() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0888");
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
        java.util.List<org.apache.commons.compress.harmony.unpack200.bytecode.Attribute> attributeList37 = codeAttribute36.attributes;
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
        org.junit.Assert.assertNotNull(attributeList37);
    }

    @Test
    public void test0889() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0889");
        org.apache.commons.compress.archivers.ArchiveStreamFactory archiveStreamFactory1 = new org.apache.commons.compress.archivers.ArchiveStreamFactory("");
        java.lang.String str2 = archiveStreamFactory1.getEntryEncoding();
        java.util.Set<java.lang.String> strSet3 = archiveStreamFactory1.getOutputStreamArchiveNames();
        java.util.Set<java.lang.String> strSet4 = archiveStreamFactory1.getInputStreamArchiveNames();
        java.io.InputStream inputStream6 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream7 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream6);
        int int8 = cpioArchiveInputStream7.getCount();
        long long10 = cpioArchiveInputStream7.skip((long) 1);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream12 = archiveStreamFactory1.createArchiveInputStream("arj", (java.io.InputStream) cpioArchiveInputStream7, "ACC_SYNTHETIC");
            org.junit.Assert.fail("Expected exception of type java.nio.charset.UnsupportedCharsetException; message: ACC_SYNTHETIC");
        } catch (java.nio.charset.UnsupportedCharsetException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "" + "'", str2, "");
        org.junit.Assert.assertNotNull(strSet3);
        org.junit.Assert.assertNotNull(strSet4);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertTrue("'" + long10 + "' != '" + 0L + "'", long10 == 0L);
    }

    @Test
    public void test0890() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0890");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("", true);
        tarArchiveEntry2.setSize((long) 40960);
        org.apache.commons.compress.archivers.tar.TarArchiveEntry[] tarArchiveEntryArray5 = tarArchiveEntry2.getDirectoryEntries();
        tarArchiveEntry2.setDataOffset(100L);
        org.junit.Assert.assertNotNull(tarArchiveEntryArray5);
        org.junit.Assert.assertArrayEquals(tarArchiveEntryArray5, new org.apache.commons.compress.archivers.tar.TarArchiveEntry[] {});
    }

    @Test
    public void test0891() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0891");
        java.lang.String str1 = org.apache.commons.compress.compressors.bzip2.BZip2Utils.getCompressedFileName("0x7875 Zip Extra Field: UID=32768 GID=1000");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "0x7875 Zip Extra Field: UID=32768 GID=1000.bz2" + "'", str1, "0x7875 Zip Extra Field: UID=32768 GID=1000.bz2");
    }

    @Test
    public void test0892() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0892");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec0 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        bHSDCodec0.lastBandLength = (-1);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec3 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean4 = bHSDCodec3.isDelta();
        byte[] byteArray6 = bHSDCodec3.encode((int) '#');
        int int7 = bHSDCodec3.getS();
        int int8 = bHSDCodec3.getH();
        long long9 = bHSDCodec3.smallest();
        int[] intArray10 = org.apache.commons.compress.harmony.pack200.CodecEncoding.getSpecifier((org.apache.commons.compress.harmony.pack200.Codec) bHSDCodec0, (org.apache.commons.compress.harmony.pack200.Codec) bHSDCodec3);
        java.io.InputStream inputStream11 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream12 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream11);
        int int13 = cpioArchiveInputStream12.getCount();
        // The following exception was thrown during execution in test generation
        try {
            int int14 = bHSDCodec3.decode((java.io.InputStream) cpioArchiveInputStream12);
            org.junit.Assert.fail("Expected exception of type java.io.EOFException; message: End of stream reached whilst decoding");
        } catch (java.io.EOFException e) {
            // Expected exception.
        }
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
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
    }

    @Test
    public void test0893() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0893");
        org.apache.commons.compress.archivers.ar.ArArchiveEntry arArchiveEntry6 = new org.apache.commons.compress.archivers.ar.ArArchiveEntry("", (long) 'a', 0, 10, 0, (long) (short) 1);
        long long7 = arArchiveEntry6.getSize();
        long long8 = arArchiveEntry6.getLength();
        boolean boolean9 = arArchiveEntry6.isDirectory();
        int int10 = arArchiveEntry6.getMode();
        java.util.Date date11 = arArchiveEntry6.getLastModifiedDate();
        org.junit.Assert.assertTrue("'" + long7 + "' != '" + 97L + "'", long7 == 97L);
        org.junit.Assert.assertTrue("'" + long8 + "' != '" + 97L + "'", long8 == 97L);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertNotNull(date11);
        org.junit.Assert.assertEquals(date11.toString(), "Thu Jan 01 10:00:01 AEST 1970");
    }

    @Test
    public void test0894() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0894");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("LocalVariableTypeTable", (byte) 51);
        tarArchiveEntry2.setGroupId(493);
    }

    @Test
    public void test0895() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0895");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream8 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 4);
        byte[] byteArray10 = zstdCompressorOutputStream8.writeUsAsciiRaw("org.apache.commons.compress.harmony.pack200.Segment$PassException");
        org.apache.commons.compress.utils.ByteUtils.OutputStreamByteConsumer outputStreamByteConsumer11 = new org.apache.commons.compress.utils.ByteUtils.OutputStreamByteConsumer((java.io.OutputStream) zstdCompressorOutputStream8);
        org.apache.commons.compress.utils.ByteUtils.toLittleEndian((org.apache.commons.compress.utils.ByteUtils.ByteConsumer) outputStreamByteConsumer11, (long) 7, 476);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(byteArray10);
    }

    @Test
    public void test0896() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0896");
        org.apache.commons.compress.harmony.pack200.BHSDCodec[] bHSDCodecArray0 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaSignedCodecs1;
        org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs1 = bHSDCodecArray0;
        org.junit.Assert.assertNotNull(bHSDCodecArray0);
    }

    @Test
    public void test0897() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0897");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry6 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean7 = cpioArchiveOutputStream2.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry6);
        java.nio.file.attribute.FileTime fileTime8 = jarArchiveEntry6.getLastAccessTime();
        byte[] byteArray9 = jarArchiveEntry6.getExtra();
        int int10 = jarArchiveEntry6.getRawFlag();
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource commentSource11 = org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.UNICODE_EXTRA_FIELD;
        jarArchiveEntry6.setCommentSource(commentSource11);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNull(fileTime8);
        org.junit.Assert.assertNull(byteArray9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + commentSource11 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.UNICODE_EXTRA_FIELD + "'", commentSource11.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.UNICODE_EXTRA_FIELD));
    }

    @Test
    public void test0898() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0898");
        int int0 = org.apache.commons.compress.archivers.cpio.CpioConstants.C_IWGRP;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 16 + "'", int0 == 16);
    }

    @Test
    public void test0899() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0899");
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry0 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date1 = arjArchiveEntry0.getLastModifiedDate();
        boolean boolean3 = arjArchiveEntry0.equals((java.lang.Object) "org.apache.commons.compress.harmony.pack200.Segment$PassException");
        org.junit.Assert.assertNotNull(date1);
        org.junit.Assert.assertEquals(date1.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test0900() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0900");
        int int0 = org.apache.commons.compress.archivers.tar.TarArchiveOutputStream.BIGNUMBER_STAR;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test0901() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0901");
        org.apache.commons.compress.archivers.zip.UnsupportedZipFeatureException.Feature feature0 = org.apache.commons.compress.archivers.zip.UnsupportedZipFeatureException.Feature.ENCRYPTION;
        org.junit.Assert.assertNotNull(feature0);
    }

    @Test
    public void test0902() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0902");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.unpack200.AttributeLayout attributeLayout5 = new org.apache.commons.compress.harmony.unpack200.AttributeLayout("ustar\000", 255, "", (int) '4', false);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.compress.harmony.pack200.Pack200Exception; message: Attribute context out of range: 255");
        } catch (org.apache.commons.compress.harmony.pack200.Pack200Exception e) {
            // Expected exception.
        }
    }

    @Test
    public void test0903() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0903");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS1 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue elementValue2 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue((int) (byte) 7, (java.lang.Object) oS1);
        java.util.List<java.lang.Object> objList3 = elementValue2.getClassFileEntries();
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute annotationDefaultAttribute4 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute(elementValue2);
        org.apache.commons.compress.utils.CharsetNames charsetNames5 = new org.apache.commons.compress.utils.CharsetNames();
        boolean boolean6 = annotationDefaultAttribute4.equals((java.lang.Object) charsetNames5);
        org.junit.Assert.assertTrue("'" + oS1 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS1.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertNotNull(objList3);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test0904() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0904");
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel1 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        seekableInMemoryByteChannel1.close();
    }

    @Test
    public void test0905() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0905");
        org.apache.commons.compress.harmony.pack200.BHSDCodec[] bHSDCodecArray0 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs5;
        org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaSignedCodecs1 = bHSDCodecArray0;
        org.junit.Assert.assertNotNull(bHSDCodecArray0);
    }

    @Test
    public void test0906() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0906");
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions0 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        packingOptions0.setLogFile("ar");
        java.lang.String str3 = packingOptions0.getDeflateHint();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "keep" + "'", str3, "keep");
    }

    @Test
    public void test0907() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0907");
        int int0 = org.apache.commons.compress.archivers.cpio.CpioConstants.MAGIC_OLD_BINARY;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 29127 + "'", int0 == 29127);
    }

    @Test
    public void test0908() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0908");
        org.apache.commons.compress.archivers.zip.X7875_NewUnix x7875_NewUnix0 = new org.apache.commons.compress.archivers.zip.X7875_NewUnix();
        x7875_NewUnix0.setUID((long) 32768);
        java.lang.String str3 = x7875_NewUnix0.toString();
        byte[] byteArray9 = new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 };
        byte[] byteArray16 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean18 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray16, 0);
        boolean boolean19 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray9, byteArray16);
        java.lang.String str22 = org.apache.commons.compress.archivers.tar.TarUtils.parseName(byteArray16, 0, 1);
        // The following exception was thrown during execution in test generation
        try {
            x7875_NewUnix0.parseFromLocalFileData(byteArray16, 0, (int) (byte) 12);
            org.junit.Assert.fail("Expected exception of type java.util.zip.ZipException; message: X7875_NewUnix invalid: uidSize 10 doesn't fit into 12 bytes");
        } catch (java.util.zip.ZipException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "0x7875 Zip Extra Field: UID=32768 GID=1000" + "'", str3, "0x7875 Zip Extra Field: UID=32768 GID=1000");
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertArrayEquals(byteArray9, new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 });
        org.junit.Assert.assertNotNull(byteArray16);
        org.junit.Assert.assertArrayEquals(byteArray16, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "\001" + "'", str22, "\001");
    }

    @Test
    public void test0909() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0909");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS1 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue elementValue2 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue((int) (byte) 7, (java.lang.Object) oS1);
        java.util.List<java.lang.Object> objList3 = elementValue2.getClassFileEntries();
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute annotationDefaultAttribute4 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute(elementValue2);
        java.lang.String str5 = annotationDefaultAttribute4.toString();
        org.apache.commons.compress.harmony.pack200.Segment segment6 = new org.apache.commons.compress.harmony.pack200.Segment();
        boolean boolean7 = annotationDefaultAttribute4.equals((java.lang.Object) segment6);
        org.apache.commons.compress.harmony.pack200.Segment.SegmentMethodVisitor segmentMethodVisitor8 = segment6.new SegmentMethodVisitor();
        org.objectweb.asm.Label label11 = null;
        org.objectweb.asm.Label[] labelArray12 = null;
        // The following exception was thrown during execution in test generation
        try {
            segmentMethodVisitor8.visitTableSwitchInsn(0, 16384, label11, labelArray12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + oS1 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS1.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertNotNull(objList3);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test0910() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0910");
        byte[] byteArray1 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(0L);
        boolean boolean3 = org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.matches(byteArray1, 52);
        java.nio.charset.Charset charset4 = org.apache.commons.compress.utils.Charsets.UTF_16BE;
        org.apache.commons.compress.archivers.zip.ZipEncoding zipEncoding5 = org.apache.commons.compress.archivers.zip.ZipEncodingHelper.getZipEncoding(charset4);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry8 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry(byteArray1, zipEncoding5, true, (long) 2);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 100");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 0, (byte) 0, (byte) 33, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(charset4);
        org.junit.Assert.assertNotNull(zipEncoding5);
    }

    @Test
    public void test0911() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0911");
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField2 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField();
        jarArchiveEntry1.addExtraField((org.apache.commons.compress.archivers.zip.ZipExtraField) unicodeCommentExtraField2);
        long long4 = jarArchiveEntry1.getSize();
        boolean boolean5 = jarArchiveEntry1.isDirectory();
        org.junit.Assert.assertTrue("'" + long4 + "' != '" + (-1L) + "'", long4 == (-1L));
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test0912() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0912");
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
        java.io.File file33 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long34 = zstdCompressorOutputStream9.write(file33);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(byteArray11);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertNotNull(bHSDCodec25);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertNotNull(byteArray28);
        org.junit.Assert.assertArrayEquals(byteArray28, new byte[] { (byte) 35 });
    }

    @Test
    public void test0913() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0913");
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
        bcBands14.setCurrentClass("TRAILER!!!", "splitting: 1 annotations");
        org.junit.Assert.assertTrue("'" + oS5 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS5.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertNull(wildcardCPConstant6);
        org.junit.Assert.assertNull(icBands11);
        org.junit.Assert.assertNull(classBands12);
    }

    @Test
    public void test0914() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0914");
        java.nio.channels.SeekableByteChannel seekableByteChannel0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarFile tarFile1 = new org.apache.commons.compress.archivers.tar.TarFile(seekableByteChannel0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0915() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0915");
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField0 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger1 = zip64ExtendedInformationExtraField0.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger2 = null;
        zip64ExtendedInformationExtraField0.setSize(zipEightByteInteger2);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField4 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField5 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger6 = zip64ExtendedInformationExtraField5.getCompressedSize();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField7 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger8 = zip64ExtendedInformationExtraField7.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger9 = null;
        zip64ExtendedInformationExtraField7.setSize(zipEightByteInteger9);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField11 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger12 = zip64ExtendedInformationExtraField11.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger13 = null;
        zip64ExtendedInformationExtraField11.setSize(zipEightByteInteger13);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField15 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipExtraField[] zipExtraFieldArray16 = new org.apache.commons.compress.archivers.zip.ZipExtraField[] { zip64ExtendedInformationExtraField0, zip64ExtendedInformationExtraField4, zip64ExtendedInformationExtraField5, zip64ExtendedInformationExtraField7, zip64ExtendedInformationExtraField11, zip64ExtendedInformationExtraField15 };
        byte[] byteArray17 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.mergeLocalFileDataData(zipExtraFieldArray16);
        boolean boolean19 = org.apache.commons.compress.archivers.dump.DumpArchiveInputStream.matches(byteArray17, (int) (short) 0);
        boolean boolean21 = org.apache.commons.compress.compressors.deflate.DeflateCompressorInputStream.matches(byteArray17, 52);
        org.junit.Assert.assertNull(zipEightByteInteger1);
        org.junit.Assert.assertNull(zipEightByteInteger6);
        org.junit.Assert.assertNull(zipEightByteInteger8);
        org.junit.Assert.assertNull(zipEightByteInteger12);
        org.junit.Assert.assertNotNull(zipExtraFieldArray16);
        org.junit.Assert.assertNotNull(byteArray17);
        org.junit.Assert.assertArrayEquals(byteArray17, new byte[] { (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
    }

    @Test
    public void test0916() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0916");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.PAD2LEN_GNU;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test0917() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0917");
        org.apache.commons.compress.compressors.CompressorStreamFactory compressorStreamFactory0 = new org.apache.commons.compress.compressors.CompressorStreamFactory();
        java.lang.Boolean boolean1 = compressorStreamFactory0.getDecompressUntilEOF();
        java.util.SortedMap<java.lang.String, org.apache.commons.compress.compressors.CompressorStreamProvider> strMap2 = compressorStreamFactory0.getCompressorInputStreamProviders();
        org.junit.Assert.assertNull(boolean1);
        org.junit.Assert.assertNotNull(strMap2);
    }

    @Test
    public void test0918() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0918");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("RuntimeVisibleAnnotations", "ACC_VOLATILE");
    }

    @Test
    public void test0919() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0919");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        byte[] byteArray2 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream1);
        java.nio.charset.Charset charset3 = cpioArchiveInputStream1.getCharset();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.xz.XZCompressorInputStream xZCompressorInputStream4 = new org.apache.commons.compress.compressors.xz.XZCompressorInputStream((java.io.InputStream) cpioArchiveInputStream1);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertNotNull(charset3);
    }

    @Test
    public void test0920() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0920");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file3 = tarArchiveEntry2.getFile();
        int int4 = tarArchiveEntry2.getDevMinor();
        boolean boolean5 = tarArchiveEntry2.isPaxGNU1XSparse();
        int int6 = tarArchiveEntry2.getUserId();
        org.junit.Assert.assertNull(file3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test0921() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0921");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        org.apache.commons.compress.archivers.tar.TarArchiveInputStream tarArchiveInputStream4 = new org.apache.commons.compress.archivers.tar.TarArchiveInputStream((java.io.InputStream) cpioArchiveInputStream1, 0);
        org.apache.commons.io.function.IOIterator<org.apache.commons.compress.archivers.tar.TarArchiveEntry> tarArchiveEntryIOIterator5 = tarArchiveInputStream4.iterator();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(tarArchiveEntryIOIterator5);
    }

    @Test
    public void test0922() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0922");
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry.HostOs hostOs0 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry.HostOs();
    }

    @Test
    public void test0923() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0923");
        org.apache.commons.compress.archivers.examples.Expander expander0 = new org.apache.commons.compress.archivers.examples.Expander();
        org.apache.commons.compress.archivers.zip.ZipFile zipFile1 = null;
        java.io.File file2 = null;
        // The following exception was thrown during execution in test generation
        try {
            expander0.expand(zipFile1, file2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0924() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0924");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream5 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream1, (long) 1, (long) 148);
        java.util.zip.Checksum checksum6 = cRC32VerifyingInputStream5.getChecksum();
        long long8 = cRC32VerifyingInputStream5.skip((long) 345);
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream11 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cRC32VerifyingInputStream5, 8589934591L, (long) '4');
        org.apache.commons.compress.compressors.pack200.Pack200Strategy pack200Strategy12 = org.apache.commons.compress.compressors.pack200.Pack200Strategy.IN_MEMORY;
        java.util.Map<java.lang.String, java.lang.String> strMap13 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream pack200CompressorInputStream14 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream((java.io.InputStream) cRC32VerifyingInputStream5, pack200Strategy12, strMap13);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(checksum6);
        org.junit.Assert.assertTrue("'" + long8 + "' != '" + 0L + "'", long8 == 0L);
        org.junit.Assert.assertNotNull(pack200Strategy12);
    }

    @Test
    public void test0925() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0925");
        byte[] byteArray1 = org.apache.commons.compress.utils.ArchiveUtils.toAsciiBytes("cpio");
        boolean boolean3 = org.apache.commons.compress.utils.ArchiveUtils.isArrayZero(byteArray1, 9);
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 99, (byte) 112, (byte) 105, (byte) 111 });
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test0926() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0926");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        long long3 = cpioArchiveInputStream1.skip((long) 8);
        org.apache.commons.compress.utils.CountingInputStream countingInputStream4 = new org.apache.commons.compress.utils.CountingInputStream((java.io.InputStream) cpioArchiveInputStream1);
        boolean boolean5 = cpioArchiveInputStream1.markSupported();
        java.util.jar.JarFile jarFile7 = null;
        java.io.OutputStream outputStream8 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream10 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream8, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry11 = null;
        boolean boolean12 = cpioArchiveOutputStream10.canWriteEntryData(archiveEntry11);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream14 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream10, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream16 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream10, 4);
        byte[] byteArray18 = zstdCompressorOutputStream16.writeUsAsciiRaw("org.apache.commons.compress.harmony.pack200.Segment$PassException");
        org.apache.commons.compress.utils.ByteUtils.OutputStreamByteConsumer outputStreamByteConsumer19 = new org.apache.commons.compress.utils.ByteUtils.OutputStreamByteConsumer((java.io.OutputStream) zstdCompressorOutputStream16);
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
        org.apache.commons.compress.harmony.pack200.Archive archive39 = new org.apache.commons.compress.harmony.pack200.Archive(jarFile7, (java.io.OutputStream) zstdCompressorOutputStream16, packingOptions37);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream40 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) zstdCompressorOutputStream16);
        // The following exception was thrown during execution in test generation
        try {
            long long42 = org.apache.commons.compress.utils.IOUtils.copyRange((java.io.InputStream) cpioArchiveInputStream1, 100L, (java.io.OutputStream) zstdCompressorOutputStream16, (int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.IOUtils.copyLarge(Ljava/io/InputStream;Ljava/io/OutputStream;JJ[B)J");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertNotNull(byteArray18);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + true + "'", boolean25 == true);
        org.junit.Assert.assertNotNull(bHSDCodec32);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertNotNull(byteArray35);
        org.junit.Assert.assertArrayEquals(byteArray35, new byte[] { (byte) 35 });
    }

    @Test
    public void test0927() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0927");
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode1 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int2 = byteCode1.getByteCodeIndex();
        int[] intArray3 = new int[] {};
        int[] intArray4 = new int[] {};
        int[] intArray5 = new int[] {};
        int[][] intArray6 = new int[][] { intArray3, intArray4, intArray5 };
        byteCode1.setNestedPositions(intArray6);
        int[] intArray8 = byteCode1.getRewrite();
        java.lang.String str9 = byteCode1.toString();
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode14 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int15 = byteCode14.getByteCodeIndex();
        int[] intArray16 = new int[] {};
        int[] intArray17 = new int[] {};
        int[] intArray18 = new int[] {};
        int[][] intArray19 = new int[][] { intArray16, intArray17, intArray18 };
        byteCode14.setNestedPositions(intArray19);
        int[] intArray21 = byteCode14.getRewrite();
        int[] intArray32 = new int[] { ' ', (byte) -1 };
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm iMethodRefForm33 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm((int) (byte) -1, "", intArray32);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm classRefForm34 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm((int) (short) 0, "jar", intArray32);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.StringRefForm stringRefForm36 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.StringRefForm(1, "splitting", intArray32, true);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.LabelForm labelForm37 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.LabelForm((int) '#', "pass", intArray32);
        org.apache.commons.compress.harmony.unpack200.bytecode.LineNumberTableAttribute lineNumberTableAttribute38 = new org.apache.commons.compress.harmony.unpack200.bytecode.LineNumberTableAttribute(100, intArray21, intArray32);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.SuperInitMethodRefForm superInitMethodRefForm39 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.SuperInitMethodRefForm((int) (byte) 0, "RuntimeInvisibleParameterAnnotations", intArray32);
        byteCode1.setRewrite(intArray32);
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
        org.junit.Assert.assertNotNull(byteCode14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + (-1) + "'", int15 == (-1));
        org.junit.Assert.assertNotNull(intArray16);
        org.junit.Assert.assertArrayEquals(intArray16, new int[] {});
        org.junit.Assert.assertNotNull(intArray17);
        org.junit.Assert.assertArrayEquals(intArray17, new int[] {});
        org.junit.Assert.assertNotNull(intArray18);
        org.junit.Assert.assertArrayEquals(intArray18, new int[] {});
        org.junit.Assert.assertNotNull(intArray19);
        org.junit.Assert.assertNotNull(intArray21);
        org.junit.Assert.assertArrayEquals(intArray21, new int[] { 255 });
        org.junit.Assert.assertNotNull(intArray32);
        org.junit.Assert.assertArrayEquals(intArray32, new int[] { 32, (-1) });
    }

    @Test
    public void test0928() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0928");
        org.apache.commons.compress.changes.ChangeSetResults changeSetResults0 = new org.apache.commons.compress.changes.ChangeSetResults();
        java.util.List<java.lang.String> strList1 = changeSetResults0.getAddedFromStream();
        org.junit.Assert.assertNotNull(strList1);
    }

    @Test
    public void test0929() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0929");
        org.apache.commons.compress.harmony.pack200.Segment segment0 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands2 = new org.apache.commons.compress.harmony.pack200.CpBands(segment0, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader3 = segment0.getSegmentHeader();
        org.apache.commons.compress.harmony.pack200.IcBands icBands4 = segment0.getIcBands();
        org.junit.Assert.assertNull(segmentHeader3);
        org.junit.Assert.assertNull(icBands4);
    }

    @Test
    public void test0930() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0930");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec0 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        byte[] byteArray3 = bHSDCodec0.encode((int) ' ', (int) (short) 1);
        org.junit.Assert.assertNotNull(bHSDCodec0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 32 });
    }

    @Test
    public void test0931() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0931");
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
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream33 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) zstdCompressorOutputStream9);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray35 = zipArchiveOutputStream33.writeUsAscii("RuntimeVisibleParameterAnnotations");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: No current entry");
        } catch (java.lang.IllegalStateException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(byteArray11);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertNotNull(bHSDCodec25);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertNotNull(byteArray28);
        org.junit.Assert.assertArrayEquals(byteArray28, new byte[] { (byte) 35 });
    }

    @Test
    public void test0932() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0932");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.PREFIXLEN_XSTAR;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 131 + "'", int0 == 131);
    }

    @Test
    public void test0933() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0933");
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField2 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField();
        jarArchiveEntry1.addExtraField((org.apache.commons.compress.archivers.zip.ZipExtraField) unicodeCommentExtraField2);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort4 = unicodeCommentExtraField2.getLocalFileDataLength();
        org.junit.Assert.assertNotNull(zipShort4);
    }

    @Test
    public void test0934() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0934");
        boolean boolean1 = org.apache.commons.compress.compressors.gzip.GzipUtils.isCompressedFileName("dump.bz2.gz");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test0935() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0935");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec0 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean1 = bHSDCodec0.isDelta();
        int int2 = org.apache.commons.compress.harmony.pack200.CodecEncoding.getSpecifierForDefaultCodec(bHSDCodec0);
        int int3 = bHSDCodec0.getH();
        org.junit.Assert.assertNotNull(bHSDCodec0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 17 + "'", int2 == 17);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
    }

    @Test
    public void test0936() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0936");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        cpioArchiveInputStream1.reset();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream6 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream1, (long) 'a', 0);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.xz.XZCompressorInputStream xZCompressorInputStream7 = new org.apache.commons.compress.compressors.xz.XZCompressorInputStream((java.io.InputStream) cRC32VerifyingInputStream6);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test0937() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0937");
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel1 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZFile sevenZFile3 = new org.apache.commons.compress.archivers.sevenz.SevenZFile((java.nio.channels.SeekableByteChannel) seekableInMemoryByteChannel1, "ConstantValue");
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.IOUtils.read(Ljava/nio/channels/ReadableByteChannel;Ljava/nio/ByteBuffer;)I");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test0938() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0938");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        java.lang.String str3 = dumpArchiveEntry2.toString();
        dumpArchiveEntry2.setGroupId((int) (byte) 51);
        org.apache.commons.compress.archivers.dump.DumpArchiveConstants.SEGMENT_TYPE sEGMENT_TYPE6 = dumpArchiveEntry2.getHeaderType();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "jar" + "'", str3, "jar");
        org.junit.Assert.assertNull(sEGMENT_TYPE6);
    }

    @Test
    public void test0939() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0939");
        org.apache.commons.compress.archivers.zip.GeneralPurposeBit generalPurposeBit0 = new org.apache.commons.compress.archivers.zip.GeneralPurposeBit();
    }

    @Test
    public void test0940() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0940");
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
        java.nio.charset.Charset charset20 = builder0.getCharset();
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(bHSDCodec12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] { (byte) 35 });
        org.junit.Assert.assertNotNull(builder17);
        org.junit.Assert.assertNotNull(builder19);
        org.junit.Assert.assertNotNull(charset20);
    }

    @Test
    public void test0941() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0941");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        int int3 = dumpArchiveEntry2.getUserId();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
    }

    @Test
    public void test0942() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0942");
        // The following exception was thrown during execution in test generation
        try {
            int int1 = org.apache.commons.compress.harmony.unpack200.SegmentUtils.countArgs("0x7875 Zip Extra Field: UID=32768 GID=1000");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: No arguments");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0943() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0943");
        int[] intArray8 = new int[] { ' ', (byte) -1 };
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm iMethodRefForm9 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm((int) (byte) -1, "", intArray8);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.LabelForm labelForm11 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.LabelForm(5, "class-file version", intArray8, true);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.FloatRefForm floatRefForm12 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.FloatRefForm(512, "ustar ", intArray8);
        int int13 = floatRefForm12.firstOperandIndex();
        org.junit.Assert.assertNotNull(intArray8);
        org.junit.Assert.assertArrayEquals(intArray8, new int[] { 32, (-1) });
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 1 + "'", int13 == 1);
    }

    @Test
    public void test0944() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0944");
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.Builder builder0 = org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.builder();
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions.Builder builder2 = builder0.withMaxMemoryLimitInKb(1000);
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions sevenZFileOptions3 = builder0.build();
        boolean boolean4 = sevenZFileOptions3.getUseDefaultNameForUnnamedEntries();
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(builder2);
        org.junit.Assert.assertNotNull(sevenZFileOptions3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test0945() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0945");
        java.nio.file.Path path0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarFile tarFile2 = new org.apache.commons.compress.archivers.tar.TarFile(path0, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0946() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0946");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        java.util.Date date3 = dumpArchiveEntry2.getLastModifiedDate();
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE tYPE4 = dumpArchiveEntry2.getType();
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE tYPE5 = org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.LINK;
        dumpArchiveEntry2.setType(tYPE5);
        int int7 = dumpArchiveEntry2.getNlink();
        org.junit.Assert.assertNotNull(date3);
        org.junit.Assert.assertEquals(date3.toString(), "Thu Jan 01 10:00:00 AEST 1970");
        org.junit.Assert.assertTrue("'" + tYPE4 + "' != '" + org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.UNKNOWN + "'", tYPE4.equals(org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.UNKNOWN));
        org.junit.Assert.assertTrue("'" + tYPE5 + "' != '" + org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.LINK + "'", tYPE5.equals(org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.LINK));
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
    }

    @Test
    public void test0947() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0947");
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions0 = new org.apache.commons.compress.harmony.pack200.PackingOptions();
        packingOptions0.setLogFile("ar");
        packingOptions0.setVerbose(true);
        java.lang.String str5 = packingOptions0.getUnknownAttributeAction();
        packingOptions0.removePassFile("ACC_SYNTHETIC");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "pass" + "'", str5, "pass");
    }

    @Test
    public void test0948() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0948");
        org.apache.commons.compress.archivers.ar.ArArchiveEntry arArchiveEntry6 = new org.apache.commons.compress.archivers.ar.ArArchiveEntry("", (long) 'a', 0, 10, 0, (long) (short) 1);
        int int7 = arArchiveEntry6.getMode();
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
    }

    @Test
    public void test0949() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0949");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.cpio.CpioArchiveEntry cpioArchiveEntry3 = new org.apache.commons.compress.archivers.cpio.CpioArchiveEntry((short) (byte) 6, "`\n", (long) 1024);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Unknown header type 6");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0950() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0950");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec1 = org.apache.commons.compress.harmony.pack200.CodecEncoding.getCanonicalCodec(3);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec2 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean3 = bHSDCodec2.isDelta();
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec4 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean5 = bHSDCodec4.isDelta();
        byte[] byteArray7 = bHSDCodec4.encode((int) '#');
        int int8 = bHSDCodec4.getS();
        org.apache.commons.compress.harmony.pack200.PopulationCodec populationCodec9 = new org.apache.commons.compress.harmony.pack200.PopulationCodec((org.apache.commons.compress.harmony.pack200.Codec) bHSDCodec1, (org.apache.commons.compress.harmony.pack200.Codec) bHSDCodec2, (org.apache.commons.compress.harmony.pack200.Codec) bHSDCodec4);
        java.io.InputStream inputStream11 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream12 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream11);
        int int13 = cpioArchiveInputStream12.getCount();
        int int14 = cpioArchiveInputStream12.available();
        int int15 = cpioArchiveInputStream12.available();
        // The following exception was thrown during execution in test generation
        try {
            int[] intArray16 = bHSDCodec2.decodeInts(3, (java.io.InputStream) cpioArchiveInputStream12);
            org.junit.Assert.fail("Expected exception of type java.io.EOFException; message: End of stream reached whilst decoding");
        } catch (java.io.EOFException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(bHSDCodec1);
        org.junit.Assert.assertNotNull(bHSDCodec2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(bHSDCodec4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) 35 });
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 1 + "'", int14 == 1);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 1 + "'", int15 == 1);
    }

    @Test
    public void test0951() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0951");
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode extraFieldParsingMode0 = org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_LENIENT;
        byte[] byteArray6 = new byte[] { (byte) 2, (byte) 7, (byte) 100, (byte) 7, (byte) 1 };
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField11 = extraFieldParsingMode0.onUnparseableExtraField(byteArray6, 17, 0, true, 0);
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField12 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField();
        byte[] byteArray13 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField17 = extraFieldParsingMode0.fill((org.apache.commons.compress.archivers.zip.ZipExtraField) unicodeCommentExtraField12, byteArray13, 16384, (int) ' ', false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(extraFieldParsingMode0);
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] { (byte) 2, (byte) 7, (byte) 100, (byte) 7, (byte) 1 });
        org.junit.Assert.assertNull(zipExtraField11);
    }

    @Test
    public void test0952() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0952");
        org.apache.commons.compress.compressors.deflate.DeflateParameters deflateParameters0 = new org.apache.commons.compress.compressors.deflate.DeflateParameters();
        deflateParameters0.setCompressionLevel(4);
        int int3 = deflateParameters0.getCompressionLevel();
        // The following exception was thrown during execution in test generation
        try {
            deflateParameters0.setCompressionLevel(12);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid Deflate compression level: 12");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
    }

    @Test
    public void test0953() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0953");
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
        org.apache.commons.compress.harmony.unpack200.MetadataBandGroup.setRvpaAttributeName(cPUTF8_7);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "UTF-8:splitting" + "'", str4, "UTF-8:splitting");
        org.junit.Assert.assertNotNull(attributeArray18);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
    }

    @Test
    public void test0954() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0954");
        org.apache.commons.compress.harmony.pack200.BHSDCodec[] bHSDCodecArray0 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaSignedCodecs4;
        org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaUnsignedCodecs3 = bHSDCodecArray0;
        org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaUnsignedCodecs4 = bHSDCodecArray0;
        org.junit.Assert.assertNotNull(bHSDCodecArray0);
    }

    @Test
    public void test0955() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0955");
        org.apache.commons.compress.archivers.zip.ZipMethod zipMethod0 = org.apache.commons.compress.archivers.zip.ZipMethod.EXPANDING_LEVEL_4;
        org.junit.Assert.assertTrue("'" + zipMethod0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipMethod.EXPANDING_LEVEL_4 + "'", zipMethod0.equals(org.apache.commons.compress.archivers.zip.ZipMethod.EXPANDING_LEVEL_4));
    }

    @Test
    public void test0956() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0956");
        org.apache.commons.compress.archivers.dump.DumpArchiveConstants.SEGMENT_TYPE sEGMENT_TYPE0 = org.apache.commons.compress.archivers.dump.DumpArchiveConstants.SEGMENT_TYPE.TAPE;
        org.junit.Assert.assertTrue("'" + sEGMENT_TYPE0 + "' != '" + org.apache.commons.compress.archivers.dump.DumpArchiveConstants.SEGMENT_TYPE.TAPE + "'", sEGMENT_TYPE0.equals(org.apache.commons.compress.archivers.dump.DumpArchiveConstants.SEGMENT_TYPE.TAPE));
    }

    @Test
    public void test0957() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0957");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_2);
        java.lang.String str4 = cPUTF8_2.toString();
        org.apache.commons.compress.java.util.jar.Pack200.Unpacker unpacker5 = org.apache.commons.compress.java.util.jar.Pack200.newUnpacker();
        boolean boolean6 = cPUTF8_2.equals((java.lang.Object) unpacker5);
        java.io.InputStream inputStream7 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream8 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream7);
        int int9 = cpioArchiveInputStream8.getCount();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream12 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream8, (long) 1, (long) 148);
        java.util.jar.JarOutputStream jarOutputStream13 = null;
        // The following exception was thrown during execution in test generation
        try {
            unpacker5.unpack((java.io.InputStream) cRC32VerifyingInputStream12, jarOutputStream13);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Must specify output stream.");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "UTF-8:splitting" + "'", str4, "UTF-8:splitting");
        org.junit.Assert.assertNotNull(unpacker5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
    }

    @Test
    public void test0958() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0958");
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker1 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray2 = jarMarker1.getCentralDirectoryData();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField3 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger4 = zip64ExtendedInformationExtraField3.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger5 = null;
        zip64ExtendedInformationExtraField3.setSize(zipEightByteInteger5);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField7 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField8 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger9 = zip64ExtendedInformationExtraField8.getCompressedSize();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField10 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger11 = zip64ExtendedInformationExtraField10.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger12 = null;
        zip64ExtendedInformationExtraField10.setSize(zipEightByteInteger12);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField14 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger15 = zip64ExtendedInformationExtraField14.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger16 = null;
        zip64ExtendedInformationExtraField14.setSize(zipEightByteInteger16);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField18 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipExtraField[] zipExtraFieldArray19 = new org.apache.commons.compress.archivers.zip.ZipExtraField[] { zip64ExtendedInformationExtraField3, zip64ExtendedInformationExtraField7, zip64ExtendedInformationExtraField8, zip64ExtendedInformationExtraField10, zip64ExtendedInformationExtraField14, zip64ExtendedInformationExtraField18 };
        byte[] byteArray20 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.mergeLocalFileDataData(zipExtraFieldArray19);
        boolean boolean21 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray2, byteArray20);
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField24 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField("ustar\000", byteArray20, 0, 9);
        long long25 = unicodeCommentExtraField24.getNameCRC32();
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertNull(zipEightByteInteger4);
        org.junit.Assert.assertNull(zipEightByteInteger9);
        org.junit.Assert.assertNull(zipEightByteInteger11);
        org.junit.Assert.assertNull(zipEightByteInteger15);
        org.junit.Assert.assertNotNull(zipExtraFieldArray19);
        org.junit.Assert.assertNotNull(byteArray20);
        org.junit.Assert.assertArrayEquals(byteArray20, new byte[] { (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + long25 + "' != '" + 3138722251L + "'", long25 == 3138722251L);
    }

    @Test
    public void test0959() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0959");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_3 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_5 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition attributeDefinition6 = new org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition(4096, 493, cPUTF8_3, cPUTF8_5);
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_10 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_12 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition attributeDefinition13 = new org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition(4096, 493, cPUTF8_10, cPUTF8_12);
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_14 = attributeDefinition13.name;
        attributeDefinition6.layout = cPUTF8_14;
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_17 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        cPUTF8_17.setIndex(4);
        org.apache.commons.compress.harmony.pack200.Segment segment20 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands22 = new org.apache.commons.compress.harmony.pack200.CpBands(segment20, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPSignature cPSignature24 = cpBands22.getCPSignature("ustar\000");
        org.apache.commons.compress.harmony.pack200.CPNameAndType cPNameAndType25 = new org.apache.commons.compress.harmony.pack200.CPNameAndType(cPUTF8_17, cPSignature24);
        attributeDefinition6.name = cPUTF8_17;
        org.junit.Assert.assertNotNull(cPUTF8_14);
        org.junit.Assert.assertNotNull(cPSignature24);
    }

    @Test
    public void test0960() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0960");
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode1 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int2 = byteCode1.getByteCodeIndex();
        int[] intArray3 = new int[] {};
        int[] intArray4 = new int[] {};
        int[] intArray5 = new int[] {};
        int[][] intArray6 = new int[][] { intArray3, intArray4, intArray5 };
        byteCode1.setNestedPositions(intArray6);
        int[] intArray8 = byteCode1.getRewrite();
        java.lang.String str9 = byteCode1.toString();
        // The following exception was thrown during execution in test generation
        try {
            byteCode1.setOperandByte(0, (int) (byte) 6);
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
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "impdep2" + "'", str9, "impdep2");
    }

    @Test
    public void test0961() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0961");
        java.util.jar.JarFile jarFile0 = null;
        java.io.OutputStream outputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream3 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream1, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry4 = null;
        boolean boolean5 = cpioArchiveOutputStream3.canWriteEntryData(archiveEntry4);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.pack200.PackingUtils.copyThroughJar(jarFile0, (java.io.OutputStream) cpioArchiveOutputStream3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test0962() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0962");
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger0 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger1 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger2 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry3 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date4 = arjArchiveEntry3.getLastModifiedDate();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong5 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(date4);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField6 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField(zipEightByteInteger0, zipEightByteInteger1, zipEightByteInteger2, zipLong5);
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger7 = zip64ExtendedInformationExtraField6.getSize();
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker8 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray9 = jarMarker8.getCentralDirectoryData();
        byte[] byteArray10 = jarMarker8.getLocalFileDataData();
        boolean boolean12 = org.apache.commons.compress.compressors.xz.XZCompressorInputStream.matches(byteArray10, 0);
        boolean boolean14 = org.apache.commons.compress.archivers.dump.DumpArchiveInputStream.matches(byteArray10, 17);
        org.apache.commons.compress.archivers.tar.TarFile tarFile15 = new org.apache.commons.compress.archivers.tar.TarFile(byteArray10);
        // The following exception was thrown during execution in test generation
        try {
            zip64ExtendedInformationExtraField6.parseFromCentralDirectoryData(byteArray10, 49152, 33188);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: null");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(zipEightByteInteger0);
        org.junit.Assert.assertNotNull(zipEightByteInteger1);
        org.junit.Assert.assertNotNull(zipEightByteInteger2);
        org.junit.Assert.assertNotNull(date4);
        org.junit.Assert.assertEquals(date4.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
        org.junit.Assert.assertNotNull(zipLong5);
        org.junit.Assert.assertNotNull(zipEightByteInteger7);
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertArrayEquals(byteArray9, new byte[] {});
        org.junit.Assert.assertNotNull(byteArray10);
        org.junit.Assert.assertArrayEquals(byteArray10, new byte[] {});
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test0963() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0963");
        int int0 = org.apache.commons.compress.harmony.unpack200.SegmentConstantPool.CP_LONG;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 4 + "'", int0 == 4);
    }

    @Test
    public void test0964() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0964");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream3 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream4 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        zipArchiveOutputStream4.setUseLanguageEncodingFlag(false);
        java.io.OutputStream outputStream7 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream9 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream7, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry10 = null;
        boolean boolean11 = cpioArchiveOutputStream9.canWriteEntryData(archiveEntry10);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream13 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream9, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream15 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream9, 4);
        byte[] byteArray17 = zstdCompressorOutputStream15.writeUsAsciiRaw("org.apache.commons.compress.harmony.pack200.Segment$PassException");
        boolean boolean19 = org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorInputStream.matches(byteArray17, (int) (byte) 51);
        // The following exception was thrown during execution in test generation
        try {
            zipArchiveOutputStream4.writePreamble(byteArray17, (int) (byte) 55, 476);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: null");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNotNull(byteArray17);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test0965() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0965");
        org.apache.commons.compress.archivers.examples.Expander expander0 = new org.apache.commons.compress.archivers.examples.Expander();
        java.io.InputStream inputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream1);
        long long4 = cpioArchiveInputStream2.skip((long) 8);
        org.apache.commons.compress.utils.CountingInputStream countingInputStream5 = new org.apache.commons.compress.utils.CountingInputStream((java.io.InputStream) cpioArchiveInputStream2);
        boolean boolean6 = cpioArchiveInputStream2.markSupported();
        java.nio.file.Path path7 = null;
        // The following exception was thrown during execution in test generation
        try {
            expander0.expand((org.apache.commons.compress.archivers.ArchiveInputStream<org.apache.commons.compress.archivers.cpio.CpioArchiveEntry>) cpioArchiveInputStream2, path7);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.IOUtils.read(Ljava/io/InputStream;[BII)I");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + long4 + "' != '" + 0L + "'", long4 == 0L);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test0966() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0966");
        byte byte0 = org.apache.commons.compress.archivers.tar.TarConstants.LF_FIFO;
        org.junit.Assert.assertTrue("'" + byte0 + "' != '" + (byte) 54 + "'", byte0 == (byte) 54);
    }

    @Test
    public void test0967() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0967");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream zstdCompressorOutputStream8 = new org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 4);
        org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream deflateCompressorOutputStream9 = new org.apache.commons.compress.compressors.deflate.DeflateCompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        java.io.OutputStream outputStream10 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream12 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream10, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry13 = null;
        boolean boolean14 = cpioArchiveOutputStream12.canWriteEntryData(archiveEntry13);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream16 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream12, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream18 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream16, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap19 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream20 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream18, strMap19);
        boolean boolean21 = pack200CompressorOutputStream20.isClosed();
        org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream snappyCompressorOutputStream23 = new org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream((java.io.OutputStream) pack200CompressorOutputStream20, (long) 10240);
        snappyCompressorOutputStream23.write(28771);
        byte[] byteArray27 = snappyCompressorOutputStream23.writeUsAsciiRaw("pack.progress");
        // The following exception was thrown during execution in test generation
        try {
            deflateCompressorOutputStream9.write(byteArray27, 52, 21);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: null");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(byteArray27);
        org.junit.Assert.assertArrayEquals(byteArray27, new byte[] { (byte) 112, (byte) 97, (byte) 99, (byte) 107, (byte) 46, (byte) 112, (byte) 114, (byte) 111, (byte) 103, (byte) 114, (byte) 101, (byte) 115, (byte) 115 });
    }

    @Test
    public void test0968() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0968");
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader0 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        org.apache.commons.compress.harmony.pack200.BandSet.BandAnalysisResults bandAnalysisResults1 = segmentHeader0.new BandAnalysisResults();
        segmentHeader0.setDeflate_hint(true);
    }

    @Test
    public void test0969() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0969");
        org.apache.commons.compress.harmony.unpack200.bytecode.ClassFile classFile0 = new org.apache.commons.compress.harmony.unpack200.bytecode.ClassFile();
        int int1 = classFile0.accessFlags;
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 0 + "'", int1 == 0);
    }

    @Test
    public void test0970() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0970");
        java.io.File file0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream2 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream(file0, (long) 2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0971() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0971");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.unpack200.AttributeLayout attributeLayout4 = new org.apache.commons.compress.harmony.unpack200.AttributeLayout("pass", 5, "0x5455 Zip Extra Field: Flags=0 ", (int) (byte) 77);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.compress.harmony.pack200.Pack200Exception; message: Attribute context out of range: 5");
        } catch (org.apache.commons.compress.harmony.pack200.Pack200Exception e) {
            // Expected exception.
        }
    }

    @Test
    public void test0972() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0972");
        int int0 = org.apache.commons.compress.archivers.zip.UnixStat.FILE_FLAG;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 32768 + "'", int0 == 32768);
    }

    @Test
    public void test0973() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0973");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        org.apache.commons.compress.archivers.tar.TarArchiveInputStream tarArchiveInputStream4 = new org.apache.commons.compress.archivers.tar.TarArchiveInputStream((java.io.InputStream) cpioArchiveInputStream1, 0);
        boolean boolean5 = tarArchiveInputStream4.markSupported();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test0974() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0974");
        int int0 = org.apache.commons.compress.archivers.arj.ArjArchiveEntry.HostOs.DOS;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 0 + "'", int0 == 0);
    }

    @Test
    public void test0975() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0975");
        org.apache.commons.compress.archivers.tar.TarArchiveStructSparse tarArchiveStructSparse2 = new org.apache.commons.compress.archivers.tar.TarArchiveStructSparse(8589934591L, 0L);
        long long3 = tarArchiveStructSparse2.getOffset();
        long long4 = tarArchiveStructSparse2.getOffset();
        java.lang.String str5 = tarArchiveStructSparse2.toString();
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 8589934591L + "'", long3 == 8589934591L);
        org.junit.Assert.assertTrue("'" + long4 + "' != '" + 8589934591L + "'", long4 == 8589934591L);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "TarArchiveStructSparse{offset=8589934591, numbytes=0}" + "'", str5, "TarArchiveStructSparse{offset=8589934591, numbytes=0}");
    }

    @Test
    public void test0976() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0976");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream framedLZ4CompressorOutputStream7 = new org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream6);
        // The following exception was thrown during execution in test generation
        try {
            framedLZ4CompressorOutputStream7.close();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test0977() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0977");
        java.lang.String str0 = org.apache.commons.compress.java.util.jar.Pack200.Packer.SEGMENT_LIMIT;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "pack.segment.limit" + "'", str0, "pack.segment.limit");
    }

    @Test
    public void test0978() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0978");
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData unparseableExtraFieldData2 = jarArchiveEntry1.getUnparseableExtraFieldData();
        int int3 = jarArchiveEntry1.getVersionMadeBy();
        org.junit.Assert.assertNull(unparseableExtraFieldData2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
    }

    @Test
    public void test0979() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0979");
        java.nio.file.Path path0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipFile zipFile2 = new org.apache.commons.compress.archivers.zip.ZipFile(path0, "070701");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0980() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0980");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        cpioArchiveInputStream1.reset();
        org.apache.commons.compress.utils.CRC32VerifyingInputStream cRC32VerifyingInputStream6 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream((java.io.InputStream) cpioArchiveInputStream1, (long) 'a', 0);
        java.util.zip.Checksum checksum7 = cRC32VerifyingInputStream6.getChecksum();
        int int8 = cRC32VerifyingInputStream6.read();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(checksum7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
    }

    @Test
    public void test0981() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0981");
        java.nio.file.Path path0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream2 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream(path0, (-2147483648L));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Zip split segment size should between 64K and 4,294,967,295");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0982() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0982");
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
        packingOptions37.setSegmentLimit(0L);
        boolean boolean43 = packingOptions37.isPassFile("ACC_VOLATILE");
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
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
    }

    @Test
    public void test0983() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0983");
        java.lang.String str1 = org.apache.commons.compress.compressors.gzip.GzipUtils.getUncompressedFileName("ACC_TRANSIENT");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "ACC_TRANSIENT" + "'", str1, "ACC_TRANSIENT");
    }

    @Test
    public void test0984() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0984");
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
        segmentHeader0.setCp_Descr_count(256);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test0985() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0985");
        org.apache.commons.compress.harmony.pack200.Segment segment0 = new org.apache.commons.compress.harmony.pack200.Segment();
        org.apache.commons.compress.harmony.pack200.CpBands cpBands2 = new org.apache.commons.compress.harmony.pack200.CpBands(segment0, (int) (byte) 2);
        org.apache.commons.compress.harmony.pack200.CPMethodOrField cPMethodOrField6 = cpBands2.getCPMethod("", "zstd", "ACC_STRICT");
        org.apache.commons.compress.harmony.pack200.CPClass cPClass8 = cpBands2.getCPClass("true");
        org.apache.commons.compress.harmony.pack200.Segment segment9 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.pack200.BcBands bcBands11 = new org.apache.commons.compress.harmony.pack200.BcBands(cpBands2, segment9, 9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cPMethodOrField6);
        org.junit.Assert.assertNotNull(cPClass8);
    }

    @Test
    public void test0986() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0986");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS1 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue elementValue2 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue((int) (byte) 7, (java.lang.Object) oS1);
        java.util.List<java.lang.Object> objList3 = elementValue2.getClassFileEntries();
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute annotationDefaultAttribute4 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute(elementValue2);
        java.lang.String str5 = annotationDefaultAttribute4.toString();
        org.apache.commons.compress.harmony.pack200.Segment segment6 = new org.apache.commons.compress.harmony.pack200.Segment();
        boolean boolean7 = annotationDefaultAttribute4.equals((java.lang.Object) segment6);
        org.apache.commons.compress.harmony.pack200.Segment.SegmentMethodVisitor segmentMethodVisitor8 = segment6.new SegmentMethodVisitor();
        org.objectweb.asm.Handle handle11 = null;
        org.apache.commons.compress.harmony.pack200.BHSDCodec[] bHSDCodecArray12 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaSignedCodecs2;
        org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs3 = bHSDCodecArray12;
        // The following exception was thrown during execution in test generation
        try {
            segmentMethodVisitor8.visitInvokeDynamicInsn("ConstantValue", "Exceptions", handle11, (java.lang.Object[]) bHSDCodecArray12);
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: This feature requires ASM5");
        } catch (java.lang.UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + oS1 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS1.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertNotNull(objList3);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(bHSDCodecArray12);
    }

    @Test
    public void test0987() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0987");
        org.apache.commons.compress.compressors.CompressorStreamFactory compressorStreamFactory1 = new org.apache.commons.compress.compressors.CompressorStreamFactory(true);
        // The following exception was thrown during execution in test generation
        try {
            compressorStreamFactory1.setDecompressConcatenated(true);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: Cannot override the setting defined by the constructor");
        } catch (java.lang.IllegalStateException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0988() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0988");
        java.lang.String str0 = org.apache.commons.compress.compressors.CompressorStreamFactory.getBzip2();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "bzip2" + "'", str0, "bzip2");
    }

    @Test
    public void test0989() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0989");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec0 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean1 = bHSDCodec0.isDelta();
        byte[] byteArray3 = bHSDCodec0.encode((int) '#');
        long long4 = bHSDCodec0.largest();
        org.junit.Assert.assertNotNull(bHSDCodec0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 35 });
        org.junit.Assert.assertTrue("'" + long4 + "' != '" + 86955L + "'", long4 == 86955L);
    }

    @Test
    public void test0990() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0990");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream3 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream4 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        zipArchiveOutputStream4.setMethod((int) 'a');
        zipArchiveOutputStream4.setMethod(96);
    }

    @Test
    public void test0991() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0991");
        java.util.concurrent.ExecutorService executorService0 = null;
        java.nio.file.Path path1 = null;
        org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier defaultBackingStoreSupplier2 = new org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier(path1);
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore3 = defaultBackingStoreSupplier2.get();
        org.apache.commons.compress.parallel.ScatterGatherBackingStore scatterGatherBackingStore4 = defaultBackingStoreSupplier2.get();
        org.apache.commons.compress.archivers.zip.ParallelScatterZipCreator parallelScatterZipCreator5 = new org.apache.commons.compress.archivers.zip.ParallelScatterZipCreator(executorService0, (org.apache.commons.compress.parallel.ScatterGatherBackingStoreSupplier) defaultBackingStoreSupplier2);
        org.apache.commons.compress.archivers.zip.ScatterStatistics scatterStatistics6 = parallelScatterZipCreator5.getStatisticsMessage();
        java.io.OutputStream outputStream7 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream9 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream7, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry10 = null;
        boolean boolean11 = cpioArchiveOutputStream9.canWriteEntryData(archiveEntry10);
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry13 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean14 = cpioArchiveOutputStream9.canWriteEntryData((org.apache.commons.compress.archivers.ArchiveEntry) jarArchiveEntry13);
        long long15 = jarArchiveEntry13.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource commentSource16 = jarArchiveEntry13.getCommentSource();
        org.apache.commons.compress.parallel.InputStreamSupplier inputStreamSupplier17 = null;
        // The following exception was thrown during execution in test generation
        try {
            parallelScatterZipCreator5.addArchiveEntry((org.apache.commons.compress.archivers.zip.ZipArchiveEntry) jarArchiveEntry13, inputStreamSupplier17);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Method must be set on zipArchiveEntry: ACC_NATIVE.gz");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(scatterGatherBackingStore3);
        org.junit.Assert.assertNotNull(scatterGatherBackingStore4);
        org.junit.Assert.assertNotNull(scatterStatistics6);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertTrue("'" + long15 + "' != '" + (-1L) + "'", long15 == (-1L));
        org.junit.Assert.assertTrue("'" + commentSource16 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.COMMENT + "'", commentSource16.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.COMMENT));
    }

    @Test
    public void test0992() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0992");
        int int0 = org.apache.commons.compress.harmony.unpack200.Segment.LOG_LEVEL_QUIET;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 0 + "'", int0 == 0);
    }

    @Test
    public void test0993() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0993");
        java.nio.file.Path path0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry1 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry(path0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0994() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0994");
        org.apache.commons.compress.compressors.pack200.Pack200Strategy pack200Strategy0 = org.apache.commons.compress.compressors.pack200.Pack200Strategy.TEMP_FILE;
        org.junit.Assert.assertNotNull(pack200Strategy0);
    }

    @Test
    public void test0995() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0995");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS1 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue elementValue2 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue((int) (byte) 7, (java.lang.Object) oS1);
        java.util.List<java.lang.Object> objList3 = elementValue2.getClassFileEntries();
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute annotationDefaultAttribute4 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute(elementValue2);
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute annotationDefaultAttribute5 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute(elementValue2);
        org.junit.Assert.assertTrue("'" + oS1 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS1.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertNotNull(objList3);
    }

    @Test
    public void test0996() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0996");
        int int0 = org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream.EFS_FLAG;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2048 + "'", int0 == 2048);
    }

    @Test
    public void test0997() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0997");
        int int0 = org.apache.commons.compress.archivers.arj.ArjArchiveEntry.HostOs.UNIX;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2 + "'", int0 == 2);
    }

    @Test
    public void test0998() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0998");
        org.apache.commons.compress.harmony.unpack200.IcTuple icTuple8 = new org.apache.commons.compress.harmony.unpack200.IcTuple("ACC_SYNTHETIC", 32771, "ACC_TRANSIENT", "ACC_PROTECTED", (int) '4', 8192, 17, 4);
        boolean boolean9 = icTuple8.isMember();
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test0999() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0999");
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel1 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        seekableInMemoryByteChannel1.close();
        org.apache.commons.compress.utils.SeekableInMemoryByteChannel seekableInMemoryByteChannel4 = new org.apache.commons.compress.utils.SeekableInMemoryByteChannel(96);
        long long5 = seekableInMemoryByteChannel4.size();
        java.nio.channels.SeekableByteChannel seekableByteChannel7 = seekableInMemoryByteChannel4.position((long) 33188);
        java.nio.channels.SeekableByteChannel[] seekableByteChannelArray8 = new java.nio.channels.SeekableByteChannel[] { seekableInMemoryByteChannel1, seekableByteChannel7 };
        java.nio.channels.SeekableByteChannel seekableByteChannel9 = org.apache.commons.compress.utils.MultiReadOnlySeekableByteChannel.forSeekableByteChannels(seekableByteChannelArray8);
        org.junit.Assert.assertTrue("'" + long5 + "' != '" + 96L + "'", long5 == 96L);
        org.junit.Assert.assertNotNull(seekableByteChannel7);
        org.junit.Assert.assertNotNull(seekableByteChannelArray8);
        org.junit.Assert.assertNotNull(seekableByteChannel9);
    }

    @Test
    public void test1000() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test1000");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS1 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue elementValue2 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue((int) (byte) 7, (java.lang.Object) oS1);
        java.util.List<java.lang.Object> objList3 = elementValue2.getClassFileEntries();
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute annotationDefaultAttribute4 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute(elementValue2);
        java.lang.String str5 = annotationDefaultAttribute4.toString();
        org.apache.commons.compress.harmony.pack200.Segment segment6 = new org.apache.commons.compress.harmony.pack200.Segment();
        boolean boolean7 = annotationDefaultAttribute4.equals((java.lang.Object) segment6);
        org.apache.commons.compress.harmony.pack200.Segment.SegmentMethodVisitor segmentMethodVisitor8 = segment6.new SegmentMethodVisitor();
        org.objectweb.asm.TypePath typePath10 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.objectweb.asm.AnnotationVisitor annotationVisitor13 = segmentMethodVisitor8.visitTypeAnnotation(96, typePath10, "ACC_PROTECTED", true);
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: This feature requires ASM5");
        } catch (java.lang.UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + oS1 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS1.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertNotNull(objList3);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }
}
