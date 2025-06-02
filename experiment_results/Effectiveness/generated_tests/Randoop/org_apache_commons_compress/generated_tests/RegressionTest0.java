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
        java.io.InputStream inputStream0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str1 = org.apache.commons.compress.archivers.ArchiveStreamFactory.detect(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Stream must not be null.");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS0 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.NTFS;
        org.junit.Assert.assertTrue("'" + oS0 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.NTFS + "'", oS0.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.NTFS));
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        java.lang.String str0 = org.apache.commons.compress.java.util.jar.Pack200.Packer.DEFLATE_HINT;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "pack.deflate.hint" + "'", str0, "pack.deflate.hint");
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test004");
        org.apache.commons.compress.archivers.zip.ZipLong zipLong0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date1 = org.apache.commons.compress.archivers.zip.ZipUtil.fromDosTime(zipLong0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test005");
        byte[] byteArray2 = new byte[] { (byte) -1, (byte) 100 };
        org.apache.commons.compress.archivers.zip.ZipEncoding zipEncoding3 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry5 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry(byteArray2, zipEncoding3, true);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 2");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) -1, (byte) 100 });
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        java.lang.String str0 = org.apache.commons.compress.archivers.ArchiveStreamFactory.JAR;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "jar" + "'", str0, "jar");
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        // The following exception was thrown during execution in test generation
        try {
            long long1 = org.apache.commons.compress.utils.TimeUtils.toNtfsTime((long) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.file.attribute.FileTimes.toNtfsTime(J)J");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        int int1 = org.apache.commons.compress.archivers.zip.ZipUtil.signedByteToUnsignedInt((byte) 10);
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 10 + "'", int1 == 10);
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.compressors.pack200.Pack200Strategy pack200Strategy1 = null;
        java.util.Map<java.lang.String, java.lang.String> strMap2 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream pack200CompressorInputStream3 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream(inputStream0, pack200Strategy1, strMap2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE tYPE0 = org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.LINK;
        org.junit.Assert.assertTrue("'" + tYPE0 + "' != '" + org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.LINK + "'", tYPE0.equals(org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.LINK));
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField0 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger1 = zip64ExtendedInformationExtraField0.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger2 = null;
        zip64ExtendedInformationExtraField0.setSize(zipEightByteInteger2);
        org.junit.Assert.assertNull(zipEightByteInteger1);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry.PERMISSION pERMISSION0 = org.apache.commons.compress.archivers.dump.DumpArchiveEntry.PERMISSION.USER_READ;
        org.junit.Assert.assertTrue("'" + pERMISSION0 + "' != '" + org.apache.commons.compress.archivers.dump.DumpArchiveEntry.PERMISSION.USER_READ + "'", pERMISSION0.equals(org.apache.commons.compress.archivers.dump.DumpArchiveEntry.PERMISSION.USER_READ));
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        byte[] byteArray0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger1 = new org.apache.commons.compress.archivers.zip.ZipEightByteInteger(byteArray0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.ByteCodeForm byteCodeForm1 = org.apache.commons.compress.harmony.unpack200.bytecode.forms.ByteCodeForm.get((int) (byte) 0);
        org.junit.Assert.assertNotNull(byteCodeForm1);
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        java.io.File file0 = null;
        char[] charArray7 = new char[] { '4', 'a', '4', ' ', ' ', '#' };
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZOutputFile sevenZOutputFile8 = new org.apache.commons.compress.archivers.sevenz.SevenZOutputFile(file0, charArray7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertArrayEquals(charArray7, new char[] { '4', 'a', '4', ' ', ' ', '#' });
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.ISEXTENDEDLEN_GNU_SPARSE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean1 = org.apache.commons.compress.utils.TimeUtils.isUnixTime((long) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.file.attribute.FileTimes.isUnixTime(J)Z");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        org.apache.commons.compress.harmony.pack200.BHSDCodec[] bHSDCodecArray0 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaDoubleSignedCodecs1;
        org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaDoubleSignedCodecs1 = bHSDCodecArray0;
        org.junit.Assert.assertNotNull(bHSDCodecArray0);
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorInputStream framedLZ4CompressorInputStream3 = new org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorInputStream((java.io.InputStream) cpioArchiveInputStream1, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField0 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger1 = zip64ExtendedInformationExtraField0.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger2 = null;
        zip64ExtendedInformationExtraField0.setRelativeHeaderOffset(zipEightByteInteger2);
        org.junit.Assert.assertNull(zipEightByteInteger1);
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        org.apache.commons.compress.harmony.pack200.BHSDCodec[] bHSDCodecArray0 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaDoubleSignedCodecs1;
        org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs2 = bHSDCodecArray0;
        org.junit.Assert.assertNotNull(bHSDCodecArray0);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        java.lang.String str0 = org.apache.commons.compress.compressors.CompressorStreamFactory.getDeflate();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "deflate" + "'", str0, "deflate");
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        java.nio.file.Path path0 = null;
        org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier defaultBackingStoreSupplier1 = new org.apache.commons.compress.archivers.zip.DefaultBackingStoreSupplier(path0);
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry classFileEntry0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.unpack200.bytecode.ConstantValueAttribute constantValueAttribute1 = new org.apache.commons.compress.harmony.unpack200.bytecode.ConstantValueAttribute(classFileEntry0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: entry");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        org.apache.commons.compress.harmony.unpack200.SegmentConstantPoolArrayCache segmentConstantPoolArrayCache0 = new org.apache.commons.compress.harmony.unpack200.SegmentConstantPoolArrayCache();
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarArchiveInputStream tarArchiveInputStream4 = new org.apache.commons.compress.archivers.tar.TarArchiveInputStream(inputStream0, 0, (int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NegativeArraySizeException; message: null");
        } catch (java.lang.NegativeArraySizeException e) {
            // Expected exception.
        }
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        long long0 = org.apache.commons.compress.archivers.tar.TarConstants.MAXSIZE;
        org.junit.Assert.assertTrue("'" + long0 + "' != '" + 8589934591L + "'", long0 == 8589934591L);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        int int0 = org.apache.commons.compress.harmony.unpack200.SegmentConstantPool.UTF_8;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        java.lang.String str0 = org.apache.commons.compress.archivers.tar.TarConstants.VERSION_GNU_SPACE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + " \000" + "'", str0, " \000");
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.UIDLEN;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 8 + "'", int0 == 8);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        org.apache.commons.compress.compressors.zstandard.ZstdUtils.setCacheZstdAvailablity(true);
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        java.nio.file.Path path0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ScatterZipOutputStream scatterZipOutputStream2 = org.apache.commons.compress.archivers.zip.ScatterZipOutputStream.pathBased(path0, (int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField1 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger2 = zip64ExtendedInformationExtraField1.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger3 = null;
        zip64ExtendedInformationExtraField1.setSize(zipEightByteInteger3);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField5 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField6 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger7 = zip64ExtendedInformationExtraField6.getCompressedSize();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField8 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger9 = zip64ExtendedInformationExtraField8.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger10 = null;
        zip64ExtendedInformationExtraField8.setSize(zipEightByteInteger10);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField12 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger13 = zip64ExtendedInformationExtraField12.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger14 = null;
        zip64ExtendedInformationExtraField12.setSize(zipEightByteInteger14);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField16 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipExtraField[] zipExtraFieldArray17 = new org.apache.commons.compress.archivers.zip.ZipExtraField[] { zip64ExtendedInformationExtraField1, zip64ExtendedInformationExtraField5, zip64ExtendedInformationExtraField6, zip64ExtendedInformationExtraField8, zip64ExtendedInformationExtraField12, zip64ExtendedInformationExtraField16 };
        byte[] byteArray18 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.mergeLocalFileDataData(zipExtraFieldArray17);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipShort.putShort((int) (byte) 1, byteArray18, (int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 52");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(zipEightByteInteger2);
        org.junit.Assert.assertNull(zipEightByteInteger7);
        org.junit.Assert.assertNull(zipEightByteInteger9);
        org.junit.Assert.assertNull(zipEightByteInteger13);
        org.junit.Assert.assertNotNull(zipExtraFieldArray17);
        org.junit.Assert.assertNotNull(byteArray18);
        org.junit.Assert.assertArrayEquals(byteArray18, new byte[] { (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0 });
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream snappyCompressorInputStream3 = new org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream((java.io.InputStream) cpioArchiveInputStream1);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test035");
        org.apache.commons.compress.archivers.zip.ZipMethod zipMethod0 = org.apache.commons.compress.archivers.zip.ZipMethod.EXPANDING_LEVEL_3;
        int int1 = zipMethod0.getCode();
        org.junit.Assert.assertTrue("'" + zipMethod0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipMethod.EXPANDING_LEVEL_3 + "'", zipMethod0.equals(org.apache.commons.compress.archivers.zip.ZipMethod.EXPANDING_LEVEL_3));
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 4 + "'", int1 == 4);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        java.util.SortedMap<java.lang.String, org.apache.commons.compress.archivers.ArchiveStreamProvider> strMap0 = org.apache.commons.compress.archivers.ArchiveStreamFactory.findAvailableArchiveInputStreamProviders();
        org.junit.Assert.assertNotNull(strMap0);
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger0 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.ZERO;
        org.junit.Assert.assertNotNull(zipEightByteInteger0);
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        java.io.OutputStream outputStream0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarArchiveOutputStream tarArchiveOutputStream4 = new org.apache.commons.compress.archivers.tar.TarArchiveOutputStream(outputStream0, (int) '#', (int) ' ', "deflate");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Block size must be a multiple of 512 bytes. Attempt to use set size of 35");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        int[] intArray6 = new int[] { ' ', (byte) -1 };
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm iMethodRefForm7 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm((int) (byte) -1, "", intArray6);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm classRefForm8 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm((int) (short) 0, "jar", intArray6);
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode9 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.CodeAttribute codeAttribute10 = null;
        classRefForm8.fixUpByteCodeTargets(byteCode9, codeAttribute10);
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertArrayEquals(intArray6, new int[] { 32, (-1) });
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        int int0 = org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream.DEFAULT_COMPRESSION;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + (-1) + "'", int0 == (-1));
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        org.apache.commons.compress.archivers.zip.UnsupportedZipFeatureException.Feature feature0 = org.apache.commons.compress.archivers.zip.UnsupportedZipFeatureException.Feature.SPLITTING;
        java.lang.String str1 = feature0.toString();
        org.junit.Assert.assertNotNull(feature0);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "splitting" + "'", str1, "splitting");
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        byte byte0 = org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp.ACCESS_TIME_BIT;
        org.junit.Assert.assertTrue("'" + byte0 + "' != '" + (byte) 2 + "'", byte0 == (byte) 2);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        java.lang.String str0 = org.apache.commons.compress.archivers.ArchiveStreamFactory.ARJ;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "arj" + "'", str0, "arj");
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        byte byte0 = org.apache.commons.compress.harmony.unpack200.bytecode.ConstantPoolEntry.CP_Class;
        org.junit.Assert.assertTrue("'" + byte0 + "' != '" + (byte) 7 + "'", byte0 == (byte) 7);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.unpack200.Archive archive2 = new org.apache.commons.compress.harmony.unpack200.Archive("splitting", " \000");
            org.junit.Assert.fail("Expected exception of type java.nio.file.NoSuchFileException; message: splitting");
        } catch (java.nio.file.NoSuchFileException e) {
            // Expected exception.
        }
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipFile zipFile2 = new org.apache.commons.compress.archivers.zip.ZipFile("hi!", "arj");
            org.junit.Assert.fail("Expected exception of type java.nio.file.NoSuchFileException; message: hi!");
        } catch (java.nio.file.NoSuchFileException e) {
            // Expected exception.
        }
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        int[] intArray4 = new int[] { ' ', (byte) -1 };
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm iMethodRefForm5 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm((int) (byte) -1, "", intArray4);
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode6 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.OperandManager operandManager7 = null;
        // The following exception was thrown during execution in test generation
        try {
            iMethodRefForm5.setByteCodeOperands(byteCode6, operandManager7, (int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(intArray4);
        org.junit.Assert.assertArrayEquals(intArray4, new int[] { 32, (-1) });
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        java.lang.String str1 = org.apache.commons.compress.compressors.bzip2.BZip2Utils.getUncompressedFilename("jar");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "jar" + "'", str1, "jar");
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        int int0 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.UnparseableExtraField.THROW_KEY;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 0 + "'", int0 == 0);
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_0 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.SignatureAttribute.setAttributeName(cPUTF8_0);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource commentSource0 = org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.UNICODE_EXTRA_FIELD;
        org.junit.Assert.assertTrue("'" + commentSource0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.UNICODE_EXTRA_FIELD + "'", commentSource0.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.UNICODE_EXTRA_FIELD));
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        org.apache.commons.compress.archivers.ar.ArArchiveEntry arArchiveEntry6 = new org.apache.commons.compress.archivers.ar.ArArchiveEntry("", (long) 'a', 0, 10, 0, (long) (short) 1);
        long long7 = arArchiveEntry6.getSize();
        org.junit.Assert.assertTrue("'" + long7 + "' != '" + 97L + "'", long7 == 97L);
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        org.apache.commons.compress.archivers.dump.InvalidFormatException invalidFormatException1 = new org.apache.commons.compress.archivers.dump.InvalidFormatException((long) 8);
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPDouble cPDouble2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPDouble((java.lang.Double) (-1.0d), (int) (short) 100);
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.SPARSE_HEADERS_IN_EXTENSION_HEADER;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 21 + "'", int0 == 21);
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        java.io.InputStream inputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream1);
        byte[] byteArray3 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream2);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean6 = org.apache.commons.compress.utils.ArchiveUtils.matchAsciiBuffer("hi!", byteArray3, (int) (byte) 100, (int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 100");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] {});
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        java.lang.String str0 = org.apache.commons.compress.java.util.jar.Pack200.Unpacker.TRUE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "true" + "'", str0, "true");
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        byte byte0 = org.apache.commons.compress.archivers.tar.TarConstants.LF_CONTIG;
        org.junit.Assert.assertTrue("'" + byte0 + "' != '" + (byte) 55 + "'", byte0 == (byte) 55);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        java.lang.String str0 = org.apache.commons.compress.java.util.jar.Pack200.Packer.PASS;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "pass" + "'", str0, "pass");
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        org.apache.commons.compress.archivers.zip.ZipMethod zipMethod0 = org.apache.commons.compress.archivers.zip.ZipMethod.PKWARE_IMPLODING;
        org.junit.Assert.assertTrue("'" + zipMethod0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipMethod.PKWARE_IMPLODING + "'", zipMethod0.equals(org.apache.commons.compress.archivers.zip.ZipMethod.PKWARE_IMPLODING));
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        java.lang.String str0 = org.apache.commons.compress.archivers.cpio.CpioConstants.MAGIC_NEW;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "070701" + "'", str0, "070701");
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        java.nio.file.Path path0 = null;
        java.nio.file.LinkOption[] linkOptionArray2 = new java.nio.file.LinkOption[] {};
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipArchiveEntry zipArchiveEntry3 = new org.apache.commons.compress.archivers.zip.ZipArchiveEntry(path0, "deflate", linkOptionArray2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(linkOptionArray2);
        org.junit.Assert.assertArrayEquals(linkOptionArray2, new java.nio.file.LinkOption[] {});
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        int int0 = org.apache.commons.compress.archivers.tar.TarArchiveOutputStream.LONGFILE_GNU;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2 + "'", int0 == 2);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm encryptionAlgorithm0 = org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm.TripleDES168;
        org.junit.Assert.assertTrue("'" + encryptionAlgorithm0 + "' != '" + org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm.TripleDES168 + "'", encryptionAlgorithm0.equals(org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm.TripleDES168));
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream bZip2CompressorInputStream2 = new org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec0 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        bHSDCodec0.lastBandLength = (-1);
        org.junit.Assert.assertNotNull(bHSDCodec0);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        org.apache.commons.compress.archivers.zip.ZipMethod zipMethod0 = org.apache.commons.compress.archivers.zip.ZipMethod.BZIP2;
        org.junit.Assert.assertTrue("'" + zipMethod0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipMethod.BZIP2 + "'", zipMethod0.equals(org.apache.commons.compress.archivers.zip.ZipMethod.BZIP2));
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.MAGICLEN;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 6 + "'", int0 == 6);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        org.apache.commons.compress.archivers.zip.ZipMethod zipMethod0 = org.apache.commons.compress.archivers.zip.ZipMethod.EXPANDING_LEVEL_1;
        org.junit.Assert.assertTrue("'" + zipMethod0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipMethod.EXPANDING_LEVEL_1 + "'", zipMethod0.equals(org.apache.commons.compress.archivers.zip.ZipMethod.EXPANDING_LEVEL_1));
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        java.util.Date date0 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long1 = org.apache.commons.compress.utils.TimeUtils.toNtfsTime(date0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.xz.XZCompressorInputStream xZCompressorInputStream3 = new org.apache.commons.compress.compressors.xz.XZCompressorInputStream(inputStream0, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.compressors.gzip.GzipParameters gzipParameters1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream gzipCompressorOutputStream2 = new org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream(outputStream0, gzipParameters1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
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
        org.junit.Assert.assertNull(zipEightByteInteger1);
        org.junit.Assert.assertNull(zipEightByteInteger6);
        org.junit.Assert.assertNull(zipEightByteInteger8);
        org.junit.Assert.assertNull(zipEightByteInteger12);
        org.junit.Assert.assertNotNull(zipExtraFieldArray16);
        org.junit.Assert.assertNotNull(byteArray17);
        org.junit.Assert.assertArrayEquals(byteArray17, new byte[] { (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray4 = org.apache.commons.compress.utils.IOUtils.readRange((java.io.InputStream) cpioArchiveInputStream1, 2);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.IOUtils.copyLarge(Ljava/io/InputStream;Ljava/io/OutputStream;JJ)J");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        org.apache.commons.compress.harmony.pack200.PackingOptions packingOptions0 = null;
        org.apache.commons.compress.harmony.pack200.PackingUtils.config(packingOptions0);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm hashAlgorithm0 = org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm.SHA512;
        org.junit.Assert.assertTrue("'" + hashAlgorithm0 + "' != '" + org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm.SHA512 + "'", hashAlgorithm0.equals(org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm.SHA512));
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.unpack200.SegmentOptions segmentOptions1 = new org.apache.commons.compress.harmony.unpack200.SegmentOptions((int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.compress.harmony.pack200.Pack200Exception; message: Some unused flags are non-zero");
        } catch (org.apache.commons.compress.harmony.pack200.Pack200Exception e) {
            // Expected exception.
        }
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        java.lang.String str0 = org.apache.commons.compress.java.util.jar.Pack200.Packer.KEEP_FILE_ORDER;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "pack.keep.file.order" + "'", str0, "pack.keep.file.order");
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        java.nio.channels.SeekableByteChannel seekableByteChannel0 = null;
        char[] charArray6 = new char[] { 'a', 'a', '#', '4', 'a' };
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions sevenZFileOptions7 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZFile sevenZFile8 = new org.apache.commons.compress.archivers.sevenz.SevenZFile(seekableByteChannel0, charArray6, sevenZFileOptions7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { 'a', 'a', '#', '4', 'a' });
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarArchiveInputStream tarArchiveInputStream5 = new org.apache.commons.compress.archivers.tar.TarArchiveInputStream((java.io.InputStream) cpioArchiveInputStream1, (int) (byte) 100, "splitting");
            org.junit.Assert.fail("Expected exception of type java.nio.charset.UnsupportedCharsetException; message: splitting");
        } catch (java.nio.charset.UnsupportedCharsetException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        int int0 = org.apache.commons.compress.archivers.arj.ArjArchiveEntry.HostOs.MAC_OS;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 4 + "'", int0 == 4);
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        byte[] byteArray4 = new byte[] { (byte) 10, (byte) 10, (byte) -1 };
        boolean boolean6 = org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.matches(byteArray4, (int) (short) -1);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipLong.putLong((long) '#', byteArray4, (int) (byte) 7);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 7");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 10, (byte) 10, (byte) -1 });
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        byte byte0 = org.apache.commons.compress.harmony.unpack200.bytecode.ConstantPoolEntry.CP_UTF8;
        org.junit.Assert.assertTrue("'" + byte0 + "' != '" + (byte) 1 + "'", byte0 == (byte) 1);
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        org.apache.commons.compress.compressors.lz77support.Parameters parameters0 = null;
        org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Callback callback1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.lz77support.LZ77Compressor lZ77Compressor2 = new org.apache.commons.compress.compressors.lz77support.LZ77Compressor(parameters0, callback1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: params");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        java.util.SortedMap<java.lang.String, org.apache.commons.compress.compressors.CompressorStreamProvider> strMap0 = org.apache.commons.compress.compressors.CompressorStreamFactory.findAvailableCompressorOutputStreamProviders();
        org.junit.Assert.assertNotNull(strMap0);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        java.lang.String str0 = org.apache.commons.compress.java.util.jar.Pack200.Packer.CODE_ATTRIBUTE_PFX;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "pack.code.attribute." + "'", str0, "pack.code.attribute.");
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        java.io.OutputStream outputStream0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarArchiveOutputStream tarArchiveOutputStream2 = new org.apache.commons.compress.archivers.tar.TarArchiveOutputStream(outputStream0, (int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Block size must be a multiple of 512 bytes. Attempt to use set size of 100");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        java.nio.channels.SeekableByteChannel seekableByteChannel0 = null;
        org.apache.commons.compress.archivers.sevenz.SevenZFileOptions sevenZFileOptions1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZFile sevenZFile2 = new org.apache.commons.compress.archivers.sevenz.SevenZFile(seekableByteChannel0, sevenZFileOptions1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        int[] intArray8 = new int[] { ' ', (byte) -1 };
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm iMethodRefForm9 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm((int) (byte) -1, "", intArray8);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm classRefForm10 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm((int) (short) 0, "jar", intArray8);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.StringRefForm stringRefForm12 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.StringRefForm(1, "splitting", intArray8, true);
        org.junit.Assert.assertNotNull(intArray8);
        org.junit.Assert.assertArrayEquals(intArray8, new int[] { 32, (-1) });
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        int int0 = org.apache.commons.compress.archivers.zip.ResourceAlignmentExtraField.BASE_SIZE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2 + "'", int0 == 2);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        java.nio.file.Path path0 = null;
        java.nio.file.LinkOption[] linkOptionArray2 = new java.nio.file.LinkOption[] {};
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.cpio.CpioArchiveEntry cpioArchiveEntry3 = new org.apache.commons.compress.archivers.cpio.CpioArchiveEntry(path0, "hi!", linkOptionArray2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(linkOptionArray2);
        org.junit.Assert.assertArrayEquals(linkOptionArray2, new java.nio.file.LinkOption[] {});
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        java.util.jar.JarFile jarFile0 = null;
        java.io.OutputStream outputStream1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.pack200.PackingUtils.copyThroughJar(jarFile0, outputStream1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField0 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger1 = zip64ExtendedInformationExtraField0.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort2 = zip64ExtendedInformationExtraField0.getLocalFileDataLength();
        byte[] byteArray4 = org.apache.commons.compress.archivers.zip.ZipUtil.toDosTime(0L);
        // The following exception was thrown during execution in test generation
        try {
            zip64ExtendedInformationExtraField0.parseFromCentralDirectoryData(byteArray4, (int) (byte) 55, (int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: null");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(zipEightByteInteger1);
        org.junit.Assert.assertNotNull(zipShort2);
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 0, (byte) 0, (byte) 33, (byte) 0 });
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        org.apache.commons.compress.harmony.pack200.BHSDCodec[] bHSDCodecArray0 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaSignedCodecs1;
        org.junit.Assert.assertNotNull(bHSDCodecArray0);
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        boolean boolean3 = dumpArchiveEntry2.isDirectory();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        java.nio.channels.SeekableByteChannel seekableByteChannel0 = null;
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker2 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray3 = jarMarker2.getCentralDirectoryData();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZFile sevenZFile4 = new org.apache.commons.compress.archivers.sevenz.SevenZFile(seekableByteChannel0, "jar", byteArray3);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.IOUtils.read(Ljava/nio/channels/ReadableByteChannel;Ljava/nio/ByteBuffer;)I");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] {});
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        int int0 = org.apache.commons.compress.harmony.unpack200.SegmentConstantPool.CP_METHOD;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 11 + "'", int0 == 11);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream snappyCompressorOutputStream4 = new org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream(outputStream0, 97L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        org.apache.commons.compress.harmony.unpack200.Segment segment0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.unpack200.AttrDefinitionBands attrDefinitionBands1 = new org.apache.commons.compress.harmony.unpack200.AttrDefinitionBands(segment0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        // The following exception was thrown during execution in test generation
        try {
            long long1 = org.apache.commons.compress.utils.TimeUtils.toNtfsTime((long) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.file.attribute.FileTimes.toNtfsTime(J)J");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        // The following exception was thrown during execution in test generation
        try {
            cpioArchiveOutputStream2.closeArchiveEntry();
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: Trying to close non-existent entry");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        org.apache.commons.compress.compressors.pack200.Pack200Strategy pack200Strategy3 = org.apache.commons.compress.compressors.pack200.Pack200Strategy.IN_MEMORY;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream pack200CompressorInputStream4 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream((java.io.InputStream) cpioArchiveInputStream1, pack200Strategy3);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(pack200Strategy3);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        java.util.jar.JarFile jarFile0 = null;
        java.io.OutputStream outputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream3 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream1, "pack.keep.file.order");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.pack200.PackingUtils.copyThroughJar(jarFile0, (java.io.OutputStream) cpioArchiveOutputStream3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode1 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        java.io.DataOutputStream dataOutputStream2 = null;
        // The following exception was thrown during execution in test generation
        try {
            byteCode1.write(dataOutputStream2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: Entry has not been resolved");
        } catch (java.lang.IllegalStateException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteCode1);
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        java.lang.Throwable throwable2 = null;
        org.apache.commons.compress.MemoryLimitException memoryLimitException3 = new org.apache.commons.compress.MemoryLimitException((long) '4', (int) (short) 0, throwable2);
        java.lang.Throwable[] throwableArray4 = memoryLimitException3.getSuppressed();
        org.junit.Assert.assertNotNull(throwableArray4);
        org.junit.Assert.assertArrayEquals(throwableArray4, new java.lang.Throwable[] {});
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        java.io.File file0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZOutputFile sevenZOutputFile1 = new org.apache.commons.compress.archivers.sevenz.SevenZOutputFile(file0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        java.io.File file0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream pack200CompressorInputStream1 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream(file0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Must specify input stream.");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        org.apache.commons.compress.archivers.zip.ScatterZipOutputStream scatterZipOutputStream0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ScatterZipOutputStream.ZipEntryWriter zipEntryWriter1 = new org.apache.commons.compress.archivers.zip.ScatterZipOutputStream.ZipEntryWriter(scatterZipOutputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        java.lang.String str0 = org.apache.commons.compress.compressors.CompressorStreamFactory.getZstandard();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "zstd" + "'", str0, "zstd");
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        int int0 = org.apache.commons.compress.harmony.unpack200.SegmentConstantPool.CP_DESCR;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 9 + "'", int0 == 9);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder0 = new org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder();
        java.net.URI uRI1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder2 = builder0.setURI(uRI1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        byte byte0 = org.apache.commons.compress.harmony.unpack200.bytecode.ConstantPoolEntry.CP_Methodref;
        org.junit.Assert.assertTrue("'" + byte0 + "' != '" + (byte) 10 + "'", byte0 == (byte) 10);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        java.nio.file.attribute.FileTime fileTime0 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean1 = org.apache.commons.compress.utils.TimeUtils.isUnixTime(fileTime0);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.file.attribute.FileTimes.isUnixTime(Ljava/nio/file/attribute/FileTime;)Z");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        java.nio.file.Path path0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarFile tarFile2 = new org.apache.commons.compress.archivers.tar.TarFile(path0, "arj");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        java.lang.String str0 = org.apache.commons.compress.harmony.unpack200.AttributeLayout.ACC_NATIVE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "ACC_NATIVE" + "'", str0, "ACC_NATIVE");
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        int int0 = org.apache.commons.compress.archivers.tar.TarArchiveEntry.DEFAULT_DIR_MODE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 16877 + "'", int0 == 16877);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        int int2 = org.apache.commons.compress.utils.ExactMath.add((int) '#', (long) (byte) 100);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 135 + "'", int2 == 135);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.SPARSELEN_GNU;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 96 + "'", int0 == 96);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        org.apache.commons.compress.harmony.pack200.CPDouble cPDouble1 = new org.apache.commons.compress.harmony.pack200.CPDouble((double) (byte) 55);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        java.lang.String str0 = org.apache.commons.compress.archivers.ar.ArArchiveEntry.HEADER;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "!<arch>\n" + "'", str0, "!<arch>\n");
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        org.apache.commons.compress.utils.Charsets charsets0 = new org.apache.commons.compress.utils.Charsets();
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        java.io.File file0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipFile zipFile1 = new org.apache.commons.compress.archivers.zip.ZipFile(file0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS0 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.TOPS_20;
        org.junit.Assert.assertTrue("'" + oS0 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.TOPS_20 + "'", oS0.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.TOPS_20));
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        java.nio.charset.Charset charset0 = org.apache.commons.compress.utils.Charsets.UTF_8;
        org.junit.Assert.assertNotNull(charset0);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test125");
        boolean boolean0 = org.apache.commons.compress.compressors.xz.XZUtils.isXZCompressionAvailable();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test126");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        // The following exception was thrown during execution in test generation
        try {
            long long3 = org.apache.commons.compress.utils.ByteUtils.fromLittleEndian((java.io.InputStream) cpioArchiveInputStream1, 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Can't read more than eight bytes into a long value");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test127");
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.TableSwitchForm tableSwitchForm2 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.TableSwitchForm((int) (byte) 0, "hi!");
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test128");
        java.nio.file.Path path0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ScatterZipOutputStream scatterZipOutputStream2 = org.apache.commons.compress.archivers.zip.ScatterZipOutputStream.pathBased(path0, 6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test129");
        org.apache.commons.compress.archivers.sevenz.SevenZMethod sevenZMethod0 = org.apache.commons.compress.archivers.sevenz.SevenZMethod.BCJ_ARM_FILTER;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration sevenZMethodConfiguration2 = new org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration(sevenZMethod0, (java.lang.Object) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The BCJ_ARM_FILTER method doesn't support options of type class java.lang.Short");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + sevenZMethod0 + "' != '" + org.apache.commons.compress.archivers.sevenz.SevenZMethod.BCJ_ARM_FILTER + "'", sevenZMethod0.equals(org.apache.commons.compress.archivers.sevenz.SevenZMethod.BCJ_ARM_FILTER));
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test130");
        org.apache.commons.compress.archivers.examples.CloseableConsumer closeableConsumer0 = org.apache.commons.compress.archivers.examples.CloseableConsumer.NULL_CONSUMER;
        org.junit.Assert.assertNotNull(closeableConsumer0);
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test131");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.xz.XZCompressorInputStream xZCompressorInputStream3 = new org.apache.commons.compress.compressors.xz.XZCompressorInputStream((java.io.InputStream) cpioArchiveInputStream1);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test132");
        java.io.OutputStream outputStream0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream bZip2CompressorOutputStream2 = new org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream(outputStream0, 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test133");
        int int0 = org.apache.commons.compress.archivers.dump.DumpArchiveConstants.TP_SIZE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1024 + "'", int0 == 1024);
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test134");
        org.apache.commons.compress.harmony.unpack200.Segment segment0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.unpack200.ClassBands classBands1 = new org.apache.commons.compress.harmony.unpack200.ClassBands(segment0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test135");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.LONGNAMESLEN_GNU;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 4 + "'", int0 == 4);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test136");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarArchiveOutputStream tarArchiveOutputStream7 = new org.apache.commons.compress.archivers.tar.TarArchiveOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, (int) 'a', 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Block size must be a multiple of 512 bytes. Attempt to use set size of 97");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test137");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec0 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean1 = bHSDCodec0.isDelta();
        int int2 = org.apache.commons.compress.harmony.pack200.CodecEncoding.getSpecifierForDefaultCodec(bHSDCodec0);
        org.junit.Assert.assertNotNull(bHSDCodec0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 17 + "'", int2 == 17);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test138");
        org.apache.commons.compress.harmony.pack200.BHSDCodec[] bHSDCodecArray0 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs4;
        org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaUnsignedCodecs2 = bHSDCodecArray0;
        org.junit.Assert.assertNotNull(bHSDCodecArray0);
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test139");
        org.apache.commons.compress.archivers.sevenz.SevenZMethod sevenZMethod0 = org.apache.commons.compress.archivers.sevenz.SevenZMethod.COPY;
        org.junit.Assert.assertTrue("'" + sevenZMethod0 + "' != '" + org.apache.commons.compress.archivers.sevenz.SevenZMethod.COPY + "'", sevenZMethod0.equals(org.apache.commons.compress.archivers.sevenz.SevenZMethod.COPY));
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test140");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        // The following exception was thrown during execution in test generation
        try {
            cpioArchiveOutputStream2.close();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test141");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        // The following exception was thrown during execution in test generation
        try {
            cpioArchiveOutputStream2.flush();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test142");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream bZip2CompressorOutputStream5 = new org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: No current CPIO entry");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test143");
        org.apache.commons.compress.archivers.zip.ZipMethod zipMethod0 = org.apache.commons.compress.archivers.zip.ZipMethod.TOKENIZATION;
        org.junit.Assert.assertTrue("'" + zipMethod0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipMethod.TOKENIZATION + "'", zipMethod0.equals(org.apache.commons.compress.archivers.zip.ZipMethod.TOKENIZATION));
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test144");
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode extraFieldParsingMode0 = org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT;
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp1 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime2 = null;
        x5455_ExtendedTimestamp1.setAccessFileTime(fileTime2);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort4 = x5455_ExtendedTimestamp1.getHeaderId();
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField5 = extraFieldParsingMode0.createExtraField(zipShort4);
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField6 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.createExtraFieldNoDefault(zipShort4);
        org.junit.Assert.assertTrue("'" + extraFieldParsingMode0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT + "'", extraFieldParsingMode0.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT));
        org.junit.Assert.assertNotNull(zipShort4);
        org.junit.Assert.assertNotNull(zipExtraField5);
        org.junit.Assert.assertNotNull(zipExtraField6);
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test145");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        // The following exception was thrown during execution in test generation
        try {
            cpioArchiveOutputStream2.close();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test146");
        org.apache.commons.compress.archivers.zip.ZipFile zipFile0 = null;
        org.apache.commons.compress.archivers.zip.ZipFile.closeQuietly(zipFile0);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test147");
        java.util.Set<org.apache.commons.compress.archivers.dump.DumpArchiveEntry.PERMISSION> pERMISSIONSet1 = org.apache.commons.compress.archivers.dump.DumpArchiveEntry.PERMISSION.find(135);
        org.junit.Assert.assertNotNull(pERMISSIONSet1);
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test148");
        byte[] byteArray5 = new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 };
        byte[] byteArray12 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean14 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray12, 0);
        boolean boolean15 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray5, byteArray12);
        java.nio.charset.Charset charset16 = null;
        org.apache.commons.compress.archivers.zip.ZipEncoding zipEncoding17 = org.apache.commons.compress.archivers.zip.ZipEncodingHelper.getZipEncoding(charset16);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry19 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry(byteArray5, zipEncoding17, false);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 5");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 });
        org.junit.Assert.assertNotNull(byteArray12);
        org.junit.Assert.assertArrayEquals(byteArray12, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(zipEncoding17);
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test149");
        org.apache.commons.compress.archivers.zip.ZipMethod zipMethod0 = org.apache.commons.compress.archivers.zip.ZipMethod.ZSTD;
        org.junit.Assert.assertTrue("'" + zipMethod0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipMethod.ZSTD + "'", zipMethod0.equals(org.apache.commons.compress.archivers.zip.ZipMethod.ZSTD));
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test150");
        java.nio.channels.SeekableByteChannel seekableByteChannel0 = null;
        char[] charArray2 = new char[] { '4' };
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZOutputFile sevenZOutputFile3 = new org.apache.commons.compress.archivers.sevenz.SevenZOutputFile(seekableByteChannel0, charArray2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(charArray2);
        org.junit.Assert.assertArrayEquals(charArray2, new char[] { '4' });
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test151");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS0 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.QDOS;
        org.junit.Assert.assertTrue("'" + oS0 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.QDOS + "'", oS0.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.QDOS));
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test152");
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField0 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger1 = zip64ExtendedInformationExtraField0.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong2 = zip64ExtendedInformationExtraField0.getDiskStartNumber();
        org.junit.Assert.assertNull(zipEightByteInteger1);
        org.junit.Assert.assertNull(zipLong2);
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test153");
        int int0 = org.apache.commons.compress.compressors.lz77support.Parameters.TRUE_MIN_BACK_REFERENCE_LENGTH;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 3 + "'", int0 == 3);
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test154");
        java.lang.String str0 = org.apache.commons.compress.harmony.unpack200.AttributeLayout.ATTRIBUTE_CODE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "Code" + "'", str0, "Code");
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test155");
        java.lang.String str1 = org.apache.commons.compress.compressors.gzip.GzipUtils.getUncompressedFileName("!<arch>\n");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "!<arch>\n" + "'", str1, "!<arch>\n");
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test156");
        java.lang.String str1 = org.apache.commons.compress.compressors.xz.XZUtils.getUncompressedFilename("Code");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "Code" + "'", str1, "Code");
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test157");
        byte[] byteArray3 = new byte[] { (byte) 10, (byte) 10, (byte) -1 };
        boolean boolean5 = org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.matches(byteArray3, (int) (short) -1);
        byte[] byteArray6 = org.apache.commons.compress.archivers.zip.ZipUtil.reverse(byteArray3);
        // The following exception was thrown during execution in test generation
        try {
            java.math.BigInteger bigInteger8 = org.apache.commons.compress.archivers.zip.ZipEightByteInteger.getValue(byteArray3, (int) (byte) 7);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: null");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) -1, (byte) 10, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] { (byte) -1, (byte) 10, (byte) 10 });
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test158");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        java.util.Date date3 = dumpArchiveEntry2.getLastModifiedDate();
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE tYPE4 = dumpArchiveEntry2.getType();
        org.junit.Assert.assertNotNull(date3);
        org.junit.Assert.assertEquals(date3.toString(), "Thu Jan 01 10:00:00 AEST 1970");
        org.junit.Assert.assertTrue("'" + tYPE4 + "' != '" + org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.UNKNOWN + "'", tYPE4.equals(org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.UNKNOWN));
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test159");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipFile.Builder builder0 = org.apache.commons.compress.archivers.zip.ZipFile.builder();
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.Charsets.toCharset(Ljava/nio/charset/Charset;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test160");
        byte[] byteArray4 = new byte[] { (byte) 10, (byte) 10, (byte) -1 };
        boolean boolean6 = org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.matches(byteArray4, (int) (short) -1);
        byte[] byteArray7 = org.apache.commons.compress.archivers.zip.ZipUtil.reverse(byteArray4);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarUtils.formatUnsignedOctalString((long) 3, byteArray7, (int) (short) 0, 1024);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 1023");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) -1, (byte) 10, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) -1, (byte) 10, (byte) 10 });
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test161");
        java.lang.String str1 = org.apache.commons.compress.compressors.gzip.GzipUtils.getCompressedFilename("ACC_NATIVE");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "ACC_NATIVE.gz" + "'", str1, "ACC_NATIVE.gz");
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test162");
        org.apache.commons.compress.harmony.unpack200.CpBands cpBands0 = null;
        org.apache.commons.compress.harmony.unpack200.SegmentConstantPool segmentConstantPool1 = new org.apache.commons.compress.harmony.unpack200.SegmentConstantPool(cpBands0);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test163");
        int int0 = org.apache.commons.compress.archivers.tar.TarArchiveEntry.MILLIS_PER_SECOND;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1000 + "'", int0 == 1000);
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test164");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream framedLZ4CompressorOutputStream7 = new org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream6);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test165");
        org.apache.commons.compress.archivers.zip.ZipEncoding zipEncoding1 = org.apache.commons.compress.archivers.zip.ZipEncodingHelper.getZipEncoding("true");
        org.junit.Assert.assertNotNull(zipEncoding1);
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test166");
        java.lang.String str0 = org.apache.commons.compress.archivers.tar.TarConstants.MAGIC_POSIX;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "ustar\000" + "'", str0, "ustar\000");
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test167");
        org.apache.commons.compress.compressors.deflate.DeflateParameters deflateParameters0 = new org.apache.commons.compress.compressors.deflate.DeflateParameters();
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test168");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream4 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0, 8, "");
            org.junit.Assert.fail("Expected exception of type java.nio.charset.IllegalCharsetNameException; message: ");
        } catch (java.nio.charset.IllegalCharsetNameException e) {
            // Expected exception.
        }
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test169");
        org.apache.commons.compress.compressors.CompressorStreamFactory compressorStreamFactory2 = new org.apache.commons.compress.compressors.CompressorStreamFactory(false, (int) (short) 10);
        // The following exception was thrown during execution in test generation
        try {
            compressorStreamFactory2.setDecompressConcatenated(false);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: Cannot override the setting defined by the constructor");
        } catch (java.lang.IllegalStateException e) {
            // Expected exception.
        }
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test170");
        java.lang.String str0 = org.apache.commons.compress.java.util.jar.Pack200.Unpacker.KEEP;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "keep" + "'", str0, "keep");
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test171");
        int[] intArray8 = new int[] { ' ', (byte) -1 };
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm iMethodRefForm9 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm((int) (byte) -1, "", intArray8);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.FieldRefForm fieldRefForm10 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.FieldRefForm(10, "070701", intArray8);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.LongForm longForm11 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.LongForm(4, "jar", intArray8);
        int int12 = longForm11.firstOperandIndex();
        org.junit.Assert.assertNotNull(intArray8);
        org.junit.Assert.assertArrayEquals(intArray8, new int[] { 32, (-1) });
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 1 + "'", int12 == 1);
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test172");
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
            long long23 = org.apache.commons.compress.archivers.tar.TarUtils.parseOctalOrBinary(byteArray1, (int) '4', 0);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 52");
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
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test173");
        long long1 = org.apache.commons.compress.archivers.zip.ZipUtil.adjustToLong(6);
        org.junit.Assert.assertTrue("'" + long1 + "' != '" + 6L + "'", long1 == 6L);
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test174");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream8 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream6, 6);
        org.apache.commons.compress.compressors.gzip.GzipParameters gzipParameters9 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream gzipCompressorOutputStream10 = new org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream8, gzipParameters9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test175");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarArchiveInputStream tarArchiveInputStream3 = new org.apache.commons.compress.archivers.tar.TarArchiveInputStream((java.io.InputStream) cpioArchiveInputStream1, "pack.deflate.hint");
            org.junit.Assert.fail("Expected exception of type java.nio.charset.UnsupportedCharsetException; message: pack.deflate.hint");
        } catch (java.nio.charset.UnsupportedCharsetException e) {
            // Expected exception.
        }
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test176");
        org.apache.commons.compress.archivers.zip.X0014_X509Certificates x0014_X509Certificates0 = new org.apache.commons.compress.archivers.zip.X0014_X509Certificates();
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test177");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        boolean boolean1 = sevenZArchiveEntry0.getHasCrc();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test178");
        org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm encryptionAlgorithm0 = org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm.UNKNOWN;
        org.junit.Assert.assertTrue("'" + encryptionAlgorithm0 + "' != '" + org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm.UNKNOWN + "'", encryptionAlgorithm0.equals(org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm.UNKNOWN));
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test179");
        org.apache.commons.compress.archivers.examples.Archiver archiver0 = new org.apache.commons.compress.archivers.examples.Archiver();
        java.io.OutputStream outputStream1 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream3 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream1, "pack.keep.file.order");
        java.io.File file4 = null;
        // The following exception was thrown during execution in test generation
        try {
            archiver0.create((org.apache.commons.compress.archivers.ArchiveOutputStream<org.apache.commons.compress.archivers.cpio.CpioArchiveEntry>) cpioArchiveOutputStream3, file4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test180");
        org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream.BlockSize blockSize0 = null;
        org.apache.commons.compress.compressors.lz77support.Parameters parameters1 = null;
        org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream.Parameters parameters2 = new org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream.Parameters(blockSize0, parameters1);
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test181");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass3 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry exceptionTableEntry4 = new org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionTableEntry(17, (int) (short) 10, (int) (byte) 7, cPClass3);
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test182");
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        boolean boolean2 = jarArchiveEntry1.isDirectory();
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test183");
        java.lang.String str1 = org.apache.commons.compress.compressors.bzip2.BZip2Utils.getCompressedFileName("pack.keep.file.order");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "pack.keep.file.order.bz2" + "'", str1, "pack.keep.file.order.bz2");
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test184");
        org.apache.commons.compress.compressors.CompressorStreamFactory compressorStreamFactory2 = new org.apache.commons.compress.compressors.CompressorStreamFactory(false, (int) (short) 10);
        java.io.InputStream inputStream3 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream4 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream3);
        byte[] byteArray5 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream4);
        java.lang.String[] strArray23 = new java.lang.String[] { "arj", " \000", "keep", "keep", "pack.code.attribute.", "", "deflate", "ACC_NATIVE", "pack.keep.file.order", "keep", "070701", "", "hi!", "hi!", "pack.keep.file.order", "pack.keep.file.order.bz2", "deflate" };
        java.util.LinkedHashSet<java.lang.String> strSet24 = new java.util.LinkedHashSet<java.lang.String>();
        boolean boolean25 = java.util.Collections.addAll((java.util.Collection<java.lang.String>) strSet24, strArray23);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.CompressorInputStream compressorInputStream26 = compressorStreamFactory2.createCompressorInputStream((java.io.InputStream) cpioArchiveInputStream4, (java.util.Set<java.lang.String>) strSet24);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Mark is not supported.");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] {});
        org.junit.Assert.assertNotNull(strArray23);
        org.junit.Assert.assertArrayEquals(strArray23, new java.lang.String[] { "arj", " \000", "keep", "keep", "pack.code.attribute.", "", "deflate", "ACC_NATIVE", "pack.keep.file.order", "keep", "070701", "", "hi!", "hi!", "pack.keep.file.order", "pack.keep.file.order.bz2", "deflate" });
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + true + "'", boolean25 == true);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test185");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray6 = cpioArchiveOutputStream2.writeUsAscii("!<arch>\n");
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: No current CPIO entry");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test186");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS0 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.MACINTOSH;
        org.junit.Assert.assertTrue("'" + oS0 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.MACINTOSH + "'", oS0.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.MACINTOSH));
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test187");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec1 = org.apache.commons.compress.harmony.pack200.CodecEncoding.getCanonicalCodec((int) (short) 0);
        org.junit.Assert.assertNull(bHSDCodec1);
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test188");
        org.apache.commons.compress.harmony.pack200.BHSDCodec[] bHSDCodecArray0 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs1;
        org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaSignedCodecs5 = bHSDCodecArray0;
        org.junit.Assert.assertNotNull(bHSDCodecArray0);
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test189");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec0 = org.apache.commons.compress.harmony.pack200.Codec.MDELTA5;
        org.junit.Assert.assertNotNull(bHSDCodec0);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test190");
        org.apache.commons.compress.archivers.ArchiveStreamFactory archiveStreamFactory1 = new org.apache.commons.compress.archivers.ArchiveStreamFactory("");
        java.lang.String str2 = archiveStreamFactory1.getEntryEncoding();
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "" + "'", str2, "");
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test191");
        int int0 = org.apache.commons.compress.archivers.zip.UnixStat.DIR_FLAG;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 16384 + "'", int0 == 16384);
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test192");
        java.lang.String str1 = org.apache.commons.compress.compressors.lzma.LZMAUtils.getUncompressedFileName("ustar\000");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "ustar\000" + "'", str1, "ustar\000");
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test193");
        java.util.SortedMap<java.lang.String, org.apache.commons.compress.archivers.ArchiveStreamProvider> strMap0 = org.apache.commons.compress.archivers.ArchiveStreamFactory.findAvailableArchiveOutputStreamProviders();
        org.junit.Assert.assertNotNull(strMap0);
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test194");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        java.lang.String str1 = sevenZArchiveEntry0.getName();
        boolean boolean2 = sevenZArchiveEntry0.isDirectory();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test195");
        int int0 = org.apache.commons.compress.archivers.cpio.CpioConstants.C_ISLNK;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 40960 + "'", int0 == 40960);
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test196");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE tYPE0 = org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.DIRECTORY;
        org.junit.Assert.assertTrue("'" + tYPE0 + "' != '" + org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.DIRECTORY + "'", tYPE0.equals(org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE.DIRECTORY));
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test197");
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder0 = new org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder();
        org.apache.commons.compress.archivers.sevenz.SevenZFile.Builder builder2 = builder0.setCharSequence((java.lang.CharSequence) "arj");
        org.junit.Assert.assertNotNull(builder2);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test198");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.xz.XZCompressorOutputStream xZCompressorOutputStream4 = new org.apache.commons.compress.compressors.xz.XZCompressorOutputStream(outputStream0, (int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test199");
        java.nio.file.attribute.FileTime fileTime0 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long1 = org.apache.commons.compress.utils.TimeUtils.toUnixTime(fileTime0);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.file.attribute.FileTimes.toUnixTime(Ljava/nio/file/attribute/FileTime;)J");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test200");
        java.io.File file0 = null;
        byte[] byteArray1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZFile sevenZFile2 = new org.apache.commons.compress.archivers.sevenz.SevenZFile(file0, byteArray1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test201");
        java.io.File file0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream zipArchiveOutputStream1 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream(file0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test202");
        java.io.File file0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarFile tarFile1 = new org.apache.commons.compress.archivers.tar.TarFile(file0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test203");
        // The following exception was thrown during execution in test generation
        try {
            long long2 = org.apache.commons.compress.utils.ParsingUtils.parseLongValue("keep", 0);
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: Unable to parse long from string value: keep");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test204");
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker0 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray1 = jarMarker0.getLocalFileDataData();
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] {});
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test205");
        // The following exception was thrown during execution in test generation
        try {
            java.nio.file.attribute.FileTime fileTime1 = org.apache.commons.compress.utils.TimeUtils.unixTimeToFileTime((long) 16384);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.file.attribute.FileTimes.fromUnixTime(J)Ljava/nio/file/attribute/FileTime;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test206");
        java.util.Map<java.lang.String, java.lang.String> strMap0 = null;
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField1 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger2 = zip64ExtendedInformationExtraField1.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger3 = null;
        zip64ExtendedInformationExtraField1.setSize(zipEightByteInteger3);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField5 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField6 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger7 = zip64ExtendedInformationExtraField6.getCompressedSize();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField8 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger9 = zip64ExtendedInformationExtraField8.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger10 = null;
        zip64ExtendedInformationExtraField8.setSize(zipEightByteInteger10);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField12 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger13 = zip64ExtendedInformationExtraField12.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger14 = null;
        zip64ExtendedInformationExtraField12.setSize(zipEightByteInteger14);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField16 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipExtraField[] zipExtraFieldArray17 = new org.apache.commons.compress.archivers.zip.ZipExtraField[] { zip64ExtendedInformationExtraField1, zip64ExtendedInformationExtraField5, zip64ExtendedInformationExtraField6, zip64ExtendedInformationExtraField8, zip64ExtendedInformationExtraField12, zip64ExtendedInformationExtraField16 };
        byte[] byteArray18 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.mergeLocalFileDataData(zipExtraFieldArray17);
        java.nio.charset.Charset charset19 = null;
        org.apache.commons.compress.archivers.zip.ZipEncoding zipEncoding20 = org.apache.commons.compress.archivers.zip.ZipEncodingHelper.getZipEncoding(charset19);
        byte[] byteArray26 = new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 };
        byte[] byteArray33 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean35 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray33, 0);
        boolean boolean36 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray26, byteArray33);
        java.lang.String str37 = zipEncoding20.decode(byteArray26);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry39 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry(strMap0, byteArray18, zipEncoding20, true);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 100");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(zipEightByteInteger2);
        org.junit.Assert.assertNull(zipEightByteInteger7);
        org.junit.Assert.assertNull(zipEightByteInteger9);
        org.junit.Assert.assertNull(zipEightByteInteger13);
        org.junit.Assert.assertNotNull(zipExtraFieldArray17);
        org.junit.Assert.assertNotNull(byteArray18);
        org.junit.Assert.assertArrayEquals(byteArray18, new byte[] { (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertNotNull(zipEncoding20);
        org.junit.Assert.assertNotNull(byteArray26);
        org.junit.Assert.assertArrayEquals(byteArray26, new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 });
        org.junit.Assert.assertNotNull(byteArray33);
        org.junit.Assert.assertArrayEquals(byteArray33, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertEquals("'" + str37 + "' != '" + "\002?\002\n\001" + "'", str37, "\002?\002\n\001");
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test207");
        byte[] byteArray3 = new byte[] { (byte) 10, (byte) 10, (byte) -1 };
        boolean boolean5 = org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.matches(byteArray3, (int) (short) -1);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger7 = new org.apache.commons.compress.archivers.zip.ZipEightByteInteger(byteArray3, 1024);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: null");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 10, (byte) 10, (byte) -1 });
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test208");
        org.apache.commons.compress.compressors.CompressorStreamFactory compressorStreamFactory2 = new org.apache.commons.compress.compressors.CompressorStreamFactory(false, (int) (short) 10);
        java.io.InputStream inputStream4 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream5 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream4);
        byte[] byteArray6 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream5);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.CompressorInputStream compressorInputStream7 = compressorStreamFactory2.createCompressorInputStream("", (java.io.InputStream) cpioArchiveInputStream5);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.compress.compressors.CompressorException; message: Compressor:  not found.");
        } catch (org.apache.commons.compress.compressors.CompressorException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] {});
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test209");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec0 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean1 = bHSDCodec0.isDelta();
        long long2 = bHSDCodec0.smallest();
        org.junit.Assert.assertNotNull(bHSDCodec0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test210");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream3 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream((java.io.OutputStream) cpioArchiveOutputStream2);
        // The following exception was thrown during execution in test generation
        try {
            blockLZ4CompressorOutputStream3.finish();
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 0, Size: 0");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test211");
        // The following exception was thrown during execution in test generation
        try {
            int int1 = org.apache.commons.compress.harmony.unpack200.SegmentUtils.countInvokeInterfaceArgs("pack.keep.file.order");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: No arguments");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test212");
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField0 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger1 = zip64ExtendedInformationExtraField0.getCompressedSize();
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker2 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray3 = jarMarker2.getCentralDirectoryData();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField7 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.fillExtraField((org.apache.commons.compress.archivers.zip.ZipExtraField) zip64ExtendedInformationExtraField0, byteArray3, 16877, (int) (byte) 55, true);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: null");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(zipEightByteInteger1);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] {});
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test213");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry.PERMISSION pERMISSION0 = org.apache.commons.compress.archivers.dump.DumpArchiveEntry.PERMISSION.WORLD_READ;
        org.junit.Assert.assertTrue("'" + pERMISSION0 + "' != '" + org.apache.commons.compress.archivers.dump.DumpArchiveEntry.PERMISSION.WORLD_READ + "'", pERMISSION0.equals(org.apache.commons.compress.archivers.dump.DumpArchiveEntry.PERMISSION.WORLD_READ));
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test214");
        java.lang.String str0 = org.apache.commons.compress.archivers.ArchiveStreamFactory.AR;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "ar" + "'", str0, "ar");
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test215");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        byte[] byteArray2 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream1);
        long long3 = cpioArchiveInputStream1.getBytesRead();
        int int4 = cpioArchiveInputStream1.getCount();
        java.nio.charset.Charset charset5 = null;
        org.apache.commons.compress.archivers.zip.ZipEncoding zipEncoding6 = org.apache.commons.compress.archivers.zip.ZipEncodingHelper.getZipEncoding(charset5);
        byte[] byteArray12 = new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 };
        byte[] byteArray19 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean21 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray19, 0);
        boolean boolean22 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray12, byteArray19);
        java.lang.String str23 = zipEncoding6.decode(byteArray12);
        // The following exception was thrown during execution in test generation
        try {
            int int26 = org.apache.commons.compress.utils.IOUtils.readFully((java.io.InputStream) cpioArchiveInputStream1, byteArray12, (int) (short) 1, (int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: null");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(zipEncoding6);
        org.junit.Assert.assertNotNull(byteArray12);
        org.junit.Assert.assertArrayEquals(byteArray12, new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 });
        org.junit.Assert.assertNotNull(byteArray19);
        org.junit.Assert.assertArrayEquals(byteArray19, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertEquals("'" + str23 + "' != '" + "\002?\002\n\001" + "'", str23, "\002?\002\n\001");
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test216");
        org.apache.commons.compress.harmony.unpack200.Segment segment0 = new org.apache.commons.compress.harmony.unpack200.Segment();
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test217");
        org.apache.commons.compress.harmony.pack200.BHSDCodec[] bHSDCodecArray0 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaSignedCodecs4;
        org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaDoubleSignedCodecs1 = bHSDCodecArray0;
        org.junit.Assert.assertNotNull(bHSDCodecArray0);
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test218");
        int[] intArray6 = new int[] { ' ', (byte) -1 };
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm iMethodRefForm7 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm((int) (byte) -1, "", intArray6);
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm classRefForm8 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.ClassRefForm((int) (short) 0, "jar", intArray6);
        int int9 = classRefForm8.operandLength();
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertArrayEquals(intArray6, new int[] { 32, (-1) });
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 1 + "'", int9 == 1);
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test219");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        int int2 = cpioArchiveInputStream1.getCount();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.ZipArchiveInputStream zipArchiveInputStream4 = new org.apache.commons.compress.archivers.zip.ZipArchiveInputStream((java.io.InputStream) cpioArchiveInputStream1, "pack.code.attribute.");
            org.junit.Assert.fail("Expected exception of type java.nio.charset.UnsupportedCharsetException; message: pack.code.attribute.");
        } catch (java.nio.charset.UnsupportedCharsetException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test220");
        java.nio.file.Path path0 = null;
        java.lang.String str1 = org.apache.commons.compress.utils.FileNameUtils.getBaseName(path0);
        org.junit.Assert.assertNull(str1);
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test221");
        int[] intArray2 = new int[] {};
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.ByteForm byteForm3 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.ByteForm(1, "ACC_NATIVE", intArray2);
        org.junit.Assert.assertNotNull(intArray2);
        org.junit.Assert.assertArrayEquals(intArray2, new int[] {});
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test222");
        int int0 = org.apache.commons.compress.archivers.ar.ArArchiveOutputStream.LONGFILE_BSD;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test223");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        fixedLengthBlockOutputStream6.write(1024);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test224");
        byte[] byteArray5 = new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 };
        byte[] byteArray12 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean14 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray12, 0);
        boolean boolean15 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray5, byteArray12);
        byte[] byteArray24 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean26 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray24, 0);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean30 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray12, (int) (byte) 1, (int) (short) 0, byteArray24, (int) (byte) 7, 8, true);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 7");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 });
        org.junit.Assert.assertNotNull(byteArray12);
        org.junit.Assert.assertArrayEquals(byteArray12, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(byteArray24);
        org.junit.Assert.assertArrayEquals(byteArray24, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test225");
        org.apache.commons.compress.archivers.zip.ZipShort zipShort0 = org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp.HEADER_ID;
        java.lang.Object obj1 = zipShort0.clone();
        org.junit.Assert.assertNotNull(zipShort0);
        org.junit.Assert.assertNotNull(obj1);
        org.junit.Assert.assertEquals(obj1.toString(), "ZipShort value: 21589");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(obj1), "ZipShort value: 21589");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj1), "ZipShort value: 21589");
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test226");
        int int0 = org.apache.commons.compress.archivers.tar.TarArchiveEntry.DEFAULT_FILE_MODE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 33188 + "'", int0 == 33188);
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test227");
        org.apache.commons.compress.archivers.zip.ZipMethod zipMethod0 = org.apache.commons.compress.archivers.zip.ZipMethod.ENHANCED_DEFLATED;
        org.junit.Assert.assertTrue("'" + zipMethod0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipMethod.ENHANCED_DEFLATED + "'", zipMethod0.equals(org.apache.commons.compress.archivers.zip.ZipMethod.ENHANCED_DEFLATED));
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test228");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPFloat cPFloat2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPFloat((java.lang.Float) 0.0f, (int) (byte) -1);
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test229");
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
        // The following exception was thrown during execution in test generation
        try {
            long long18 = org.apache.commons.compress.utils.IOUtils.copy((java.io.InputStream) cpioArchiveInputStream1, (java.io.OutputStream) pack200CompressorOutputStream16, (int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.IOUtils.copy(Ljava/io/InputStream;Ljava/io/OutputStream;I)J");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test230");
        org.apache.commons.compress.archivers.zip.ExtraFieldUtils extraFieldUtils0 = new org.apache.commons.compress.archivers.zip.ExtraFieldUtils();
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test231");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        long long3 = dumpArchiveEntry2.getSize();
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test232");
        java.nio.channels.SeekableByteChannel seekableByteChannel0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.tar.TarFile tarFile5 = new org.apache.commons.compress.archivers.tar.TarFile(seekableByteChannel0, 4, 100, "deflate", true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test233");
        int int0 = org.apache.commons.compress.archivers.cpio.CpioConstants.C_ISCHR;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 8192 + "'", int0 == 8192);
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test234");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        int int3 = dumpArchiveEntry2.getGeneration();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test235");
        byte[] byteArray6 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean8 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray6, 0);
        boolean boolean10 = org.apache.commons.compress.archivers.ar.ArArchiveInputStream.matches(byteArray6, 1000);
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test236");
        java.nio.channels.SeekableByteChannel seekableByteChannel0 = null;
        char[] charArray3 = new char[] { 'a', 'a' };
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZFile sevenZFile4 = new org.apache.commons.compress.archivers.sevenz.SevenZFile(seekableByteChannel0, charArray3);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.IOUtils.read(Ljava/nio/channels/ReadableByteChannel;Ljava/nio/ByteBuffer;)I");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(charArray3);
        org.junit.Assert.assertArrayEquals(charArray3, new char[] { 'a', 'a' });
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test237");
        org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType blockType0 = org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.EOD;
        org.junit.Assert.assertTrue("'" + blockType0 + "' != '" + org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.EOD + "'", blockType0.equals(org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.EOD));
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test238");
        org.apache.commons.compress.archivers.zip.X0015_CertificateIdForFile x0015_CertificateIdForFile0 = new org.apache.commons.compress.archivers.zip.X0015_CertificateIdForFile();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField1 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger2 = zip64ExtendedInformationExtraField1.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger3 = null;
        zip64ExtendedInformationExtraField1.setSize(zipEightByteInteger3);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField5 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField6 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger7 = zip64ExtendedInformationExtraField6.getCompressedSize();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField8 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger9 = zip64ExtendedInformationExtraField8.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger10 = null;
        zip64ExtendedInformationExtraField8.setSize(zipEightByteInteger10);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField12 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger13 = zip64ExtendedInformationExtraField12.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger14 = null;
        zip64ExtendedInformationExtraField12.setSize(zipEightByteInteger14);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField16 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipExtraField[] zipExtraFieldArray17 = new org.apache.commons.compress.archivers.zip.ZipExtraField[] { zip64ExtendedInformationExtraField1, zip64ExtendedInformationExtraField5, zip64ExtendedInformationExtraField6, zip64ExtendedInformationExtraField8, zip64ExtendedInformationExtraField12, zip64ExtendedInformationExtraField16 };
        byte[] byteArray18 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.mergeLocalFileDataData(zipExtraFieldArray17);
        // The following exception was thrown during execution in test generation
        try {
            x0015_CertificateIdForFile0.parseFromLocalFileData(byteArray18, (int) (byte) 55, 40960);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: null");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(zipEightByteInteger2);
        org.junit.Assert.assertNull(zipEightByteInteger7);
        org.junit.Assert.assertNull(zipEightByteInteger9);
        org.junit.Assert.assertNull(zipEightByteInteger13);
        org.junit.Assert.assertNotNull(zipExtraFieldArray17);
        org.junit.Assert.assertNotNull(byteArray18);
        org.junit.Assert.assertArrayEquals(byteArray18, new byte[] { (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0 });
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test239");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        byte[] byteArray2 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream1);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.jar.JarArchiveInputStream jarArchiveInputStream4 = new org.apache.commons.compress.archivers.jar.JarArchiveInputStream((java.io.InputStream) cpioArchiveInputStream1, "keep");
            org.junit.Assert.fail("Expected exception of type java.nio.charset.UnsupportedCharsetException; message: keep");
        } catch (java.nio.charset.UnsupportedCharsetException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test240");
        org.apache.commons.compress.archivers.zip.X0019_EncryptionRecipientCertificateList x0019_EncryptionRecipientCertificateList0 = new org.apache.commons.compress.archivers.zip.X0019_EncryptionRecipientCertificateList();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort1 = x0019_EncryptionRecipientCertificateList0.getCentralDirectoryLength();
        org.junit.Assert.assertNotNull(zipShort1);
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test241");
        int int0 = org.apache.commons.compress.harmony.unpack200.SegmentConstantPool.CP_INT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2 + "'", int0 == 2);
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test242");
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
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "UTF-8:splitting" + "'", str4, "UTF-8:splitting");
        org.junit.Assert.assertNotNull(attributeArray18);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test243");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_2);
        org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute newAttribute5 = new org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute(cPUTF8_2, 8);
        int int6 = newAttribute5.getLayoutIndex();
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 8 + "'", int6 == 8);
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test244");
        byte[] byteArray5 = new byte[] { (byte) 1, (byte) 0, (byte) -1, (byte) -1 };
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean8 = org.apache.commons.compress.utils.ArchiveUtils.matchAsciiBuffer("pack.deflate.hint", byteArray5, (int) (short) -1, 8192);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: -1");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] { (byte) 1, (byte) 0, (byte) -1, (byte) -1 });
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test245");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        byte[] byteArray2 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream1);
        long long3 = cpioArchiveInputStream1.getBytesRead();
        int int4 = cpioArchiveInputStream1.getCount();
        boolean boolean5 = cpioArchiveInputStream1.markSupported();
        org.apache.commons.io.function.IOIterator<org.apache.commons.compress.archivers.cpio.CpioArchiveEntry> cpioArchiveEntryIOIterator6 = cpioArchiveInputStream1.iterator();
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(cpioArchiveEntryIOIterator6);
    }

    @Test
    public void test246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test246");
        org.apache.commons.compress.archivers.zip.ZipMethod zipMethod0 = org.apache.commons.compress.archivers.zip.ZipMethod.JPEG;
        org.junit.Assert.assertTrue("'" + zipMethod0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipMethod.JPEG + "'", zipMethod0.equals(org.apache.commons.compress.archivers.zip.ZipMethod.JPEG));
    }

    @Test
    public void test247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test247");
        org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm encryptionAlgorithm0 = org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm.RC2pre52;
        org.junit.Assert.assertTrue("'" + encryptionAlgorithm0 + "' != '" + org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm.RC2pre52 + "'", encryptionAlgorithm0.equals(org.apache.commons.compress.archivers.zip.PKWareExtraHeader.EncryptionAlgorithm.RC2pre52));
    }

    @Test
    public void test248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test248");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime1 = null;
        x5455_ExtendedTimestamp0.setAccessFileTime(fileTime1);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = x5455_ExtendedTimestamp0.getLocalFileDataLength();
        java.lang.Object obj4 = x5455_ExtendedTimestamp0.clone();
        org.apache.commons.compress.archivers.zip.ZipLong zipLong5 = x5455_ExtendedTimestamp0.getAccessTime();
        org.junit.Assert.assertNotNull(zipShort3);
        org.junit.Assert.assertNotNull(obj4);
        org.junit.Assert.assertEquals(obj4.toString(), "0x5455 Zip Extra Field: Flags=0 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(obj4), "0x5455 Zip Extra Field: Flags=0 ");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj4), "0x5455 Zip Extra Field: Flags=0 ");
        org.junit.Assert.assertNull(zipLong5);
    }

    @Test
    public void test249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test249");
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
        // The following exception was thrown during execution in test generation
        try {
            int int24 = org.apache.commons.compress.archivers.tar.TarUtils.formatCheckSumOctalBytes((long) 16384, byteArray20, (int) (short) 1, (int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 95");
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
    }

    @Test
    public void test250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test250");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.CTIMELEN_XSTAR;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 12 + "'", int0 == 12);
    }

    @Test
    public void test251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test251");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        java.lang.String str3 = dumpArchiveEntry2.toString();
        int int4 = dumpArchiveEntry2.getHeaderHoles();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "jar" + "'", str3, "jar");
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
    }

    @Test
    public void test252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test252");
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader0 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        segmentHeader0.setCp_Int_count(96);
        boolean boolean3 = segmentHeader0.have_class_flags_hi();
        segmentHeader0.setHave_class_flags_hi(true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test253");
        org.apache.commons.compress.harmony.pack200.BHSDCodec[] bHSDCodecArray0 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaSignedCodecs2;
        org.junit.Assert.assertNotNull(bHSDCodecArray0);
    }

    @Test
    public void test254() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test254");
        java.lang.String str0 = org.apache.commons.compress.utils.CharsetNames.UTF_16BE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "UTF-16BE" + "'", str0, "UTF-16BE");
    }

    @Test
    public void test255() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test255");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.XSTAR_PREFIX_OFFSET;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 345 + "'", int0 == 345);
    }

    @Test
    public void test256() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test256");
        java.lang.String str1 = org.apache.commons.compress.compressors.gzip.GzipUtils.getUncompressedFilename("UTF-8:splitting");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "UTF-8:splitting" + "'", str1, "UTF-8:splitting");
    }

    @Test
    public void test257() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test257");
        org.apache.commons.compress.compressors.gzip.ExtraField extraField0 = new org.apache.commons.compress.compressors.gzip.ExtraField();
        int int1 = extraField0.size();
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 0 + "'", int1 == 0);
    }

    @Test
    public void test258() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test258");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.CHKSUM_OFFSET;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 148 + "'", int0 == 148);
    }

    @Test
    public void test259() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test259");
        org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry sevenZArchiveEntry0 = new org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry();
        java.lang.String str1 = sevenZArchiveEntry0.getName();
        sevenZArchiveEntry0.setHasCrc(false);
        boolean boolean4 = sevenZArchiveEntry0.getHasWindowsAttributes();
        org.junit.Assert.assertNull(str1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test260() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test260");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        java.nio.file.Path path3 = null;
        java.nio.file.LinkOption linkOption5 = null;
        java.nio.file.LinkOption[] linkOptionArray6 = new java.nio.file.LinkOption[] { linkOption5 };
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.cpio.CpioArchiveEntry cpioArchiveEntry7 = cpioArchiveOutputStream2.createArchiveEntry(path3, "070701", linkOptionArray6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(linkOptionArray6);
        org.junit.Assert.assertArrayEquals(linkOptionArray6, new java.nio.file.LinkOption[] { null });
    }

    @Test
    public void test261() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test261");
        org.apache.commons.compress.archivers.zip.Zip64Mode zip64Mode0 = org.apache.commons.compress.archivers.zip.Zip64Mode.AlwaysWithCompatibility;
        org.junit.Assert.assertTrue("'" + zip64Mode0 + "' != '" + org.apache.commons.compress.archivers.zip.Zip64Mode.AlwaysWithCompatibility + "'", zip64Mode0.equals(org.apache.commons.compress.archivers.zip.Zip64Mode.AlwaysWithCompatibility));
    }

    @Test
    public void test262() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test262");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_2);
        java.lang.String str4 = cPUTF8_2.toString();
        org.apache.commons.compress.java.util.jar.Pack200.Unpacker unpacker5 = org.apache.commons.compress.java.util.jar.Pack200.newUnpacker();
        boolean boolean6 = cPUTF8_2.equals((java.lang.Object) unpacker5);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "UTF-8:splitting" + "'", str4, "UTF-8:splitting");
        org.junit.Assert.assertNotNull(unpacker5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test263() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test263");
        org.apache.commons.compress.harmony.pack200.SegmentHeader segmentHeader0 = new org.apache.commons.compress.harmony.pack200.SegmentHeader();
        org.apache.commons.compress.harmony.pack200.BandSet.BandAnalysisResults bandAnalysisResults1 = segmentHeader0.new BandAnalysisResults();
    }

    @Test
    public void test264() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test264");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS0 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.ATARI_TOS;
        org.junit.Assert.assertTrue("'" + oS0 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.ATARI_TOS + "'", oS0.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.ATARI_TOS));
    }

    @Test
    public void test265() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test265");
        org.apache.commons.compress.archivers.dump.DumpArchiveConstants.SEGMENT_TYPE sEGMENT_TYPE0 = org.apache.commons.compress.archivers.dump.DumpArchiveConstants.SEGMENT_TYPE.CLRI;
        org.junit.Assert.assertTrue("'" + sEGMENT_TYPE0 + "' != '" + org.apache.commons.compress.archivers.dump.DumpArchiveConstants.SEGMENT_TYPE.CLRI + "'", sEGMENT_TYPE0.equals(org.apache.commons.compress.archivers.dump.DumpArchiveConstants.SEGMENT_TYPE.CLRI));
    }

    @Test
    public void test266() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test266");
        java.lang.String str1 = org.apache.commons.compress.compressors.xz.XZUtils.getUncompressedFileName("Code");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "Code" + "'", str1, "Code");
    }

    @Test
    public void test267() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test267");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPInteger cPInteger2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPInteger((java.lang.Integer) 8, (int) (short) 0);
        java.lang.String str3 = cPInteger2.toString();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Integer: 8" + "'", str3, "Integer: 8");
    }

    @Test
    public void test268() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test268");
        int[] intArray3 = new int[] { 1 };
        org.apache.commons.compress.harmony.unpack200.bytecode.forms.SuperInitMethodRefForm superInitMethodRefForm4 = new org.apache.commons.compress.harmony.unpack200.bytecode.forms.SuperInitMethodRefForm(1, "UTF-8:splitting", intArray3);
        org.junit.Assert.assertNotNull(intArray3);
        org.junit.Assert.assertArrayEquals(intArray3, new int[] { 1 });
    }

    @Test
    public void test269() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test269");
        org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode byteCode1 = org.apache.commons.compress.harmony.unpack200.bytecode.ByteCode.getByteCode((-1));
        int int2 = byteCode1.getByteCodeIndex();
        int[] intArray3 = new int[] {};
        int[] intArray4 = new int[] {};
        int[] intArray5 = new int[] {};
        int[][] intArray6 = new int[][] { intArray3, intArray4, intArray5 };
        byteCode1.setNestedPositions(intArray6);
        int[] intArray8 = byteCode1.getRewrite();
        java.lang.String str9 = byteCode1.toString();
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
    public void test270() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test270");
        org.apache.commons.compress.archivers.ar.ArArchiveEntry arArchiveEntry6 = new org.apache.commons.compress.archivers.ar.ArArchiveEntry("", (long) 'a', 0, 10, 0, (long) (short) 1);
        int int7 = arArchiveEntry6.getUserId();
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
    }

    @Test
    public void test271() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test271");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        byte[] byteArray2 = org.apache.commons.compress.utils.IOUtils.toByteArray((java.io.InputStream) cpioArchiveInputStream1);
        long long3 = cpioArchiveInputStream1.getBytesRead();
        int int4 = cpioArchiveInputStream1.getCount();
        boolean boolean5 = cpioArchiveInputStream1.markSupported();
        org.apache.commons.compress.compressors.pack200.Pack200Strategy pack200Strategy6 = org.apache.commons.compress.compressors.pack200.Pack200Strategy.IN_MEMORY;
        java.util.Map<java.lang.String, java.lang.String> strMap7 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream pack200CompressorInputStream8 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream((java.io.InputStream) cpioArchiveInputStream1, pack200Strategy6, strMap7);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] {});
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(pack200Strategy6);
    }

    @Test
    public void test272() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test272");
        java.nio.channels.SeekableByteChannel seekableByteChannel0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.sevenz.SevenZOutputFile sevenZOutputFile1 = new org.apache.commons.compress.archivers.sevenz.SevenZOutputFile(seekableByteChannel0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test273() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test273");
        int int0 = org.apache.commons.compress.archivers.zip.UnixStat.DEFAULT_DIR_PERM;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 493 + "'", int0 == 493);
    }

    @Test
    public void test274() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test274");
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS1 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue elementValue2 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue((int) (byte) 7, (java.lang.Object) oS1);
        java.util.List<java.lang.Object> objList3 = elementValue2.getClassFileEntries();
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute annotationDefaultAttribute4 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationDefaultAttribute(elementValue2);
        org.junit.Assert.assertTrue("'" + oS1 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS1.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertNotNull(objList3);
    }

    @Test
    public void test275() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test275");
        org.apache.commons.compress.harmony.pack200.CPUTF8 cPUTF8_1 = new org.apache.commons.compress.harmony.pack200.CPUTF8("");
        cPUTF8_1.setIndex(4);
    }

    @Test
    public void test276() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test276");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream cpioArchiveInputStream1 = new org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream(inputStream0);
        long long3 = cpioArchiveInputStream1.skip((long) '4');
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.compressors.xz.XZCompressorInputStream xZCompressorInputStream4 = new org.apache.commons.compress.compressors.xz.XZCompressorInputStream((java.io.InputStream) cpioArchiveInputStream1);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.input.BoundedInputStream.builder()Lorg/apache/commons/io/input/BoundedInputStream$Builder;");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
    }

    @Test
    public void test277() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test277");
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp0 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime1 = null;
        x5455_ExtendedTimestamp0.setAccessFileTime(fileTime1);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort3 = x5455_ExtendedTimestamp0.getLocalFileDataLength();
        org.apache.commons.compress.archivers.arj.ArjArchiveEntry arjArchiveEntry4 = new org.apache.commons.compress.archivers.arj.ArjArchiveEntry();
        java.util.Date date5 = arjArchiveEntry4.getLastModifiedDate();
        // The following exception was thrown during execution in test generation
        try {
            x5455_ExtendedTimestamp0.setAccessJavaTime(date5);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.file.attribute.FileTimes.isUnixTime(J)Z");
        } catch (java.lang.NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(zipShort3);
        org.junit.Assert.assertNotNull(date5);
        org.junit.Assert.assertEquals(date5.toString(), "Fri Nov 30 00:00:00 AEDT 1979");
    }

    @Test
    public void test278() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test278");
        int int0 = org.apache.commons.compress.archivers.tar.TarArchiveOutputStream.BIGNUMBER_POSIX;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2 + "'", int0 == 2);
    }

    @Test
    public void test279() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test279");
        byte[] byteArray5 = new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 };
        byte[] byteArray12 = new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 };
        boolean boolean14 = org.apache.commons.compress.archivers.tar.TarArchiveInputStream.matches(byteArray12, 0);
        boolean boolean15 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray5, byteArray12);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean16 = org.apache.commons.compress.archivers.tar.TarUtils.verifyCheckSum(byteArray5);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 148");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] { (byte) 2, (byte) -1, (byte) 2, (byte) 10, (byte) 1 });
        org.junit.Assert.assertNotNull(byteArray12);
        org.junit.Assert.assertArrayEquals(byteArray12, new byte[] { (byte) 1, (byte) 10, (byte) 10, (byte) -1, (byte) -1, (byte) 10 });
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test280() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test280");
        org.apache.commons.compress.archivers.jar.JarArchiveEntry jarArchiveEntry1 = new org.apache.commons.compress.archivers.jar.JarArchiveEntry("ACC_NATIVE.gz");
        org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData unparseableExtraFieldData2 = jarArchiveEntry1.getUnparseableExtraFieldData();
        org.junit.Assert.assertNull(unparseableExtraFieldData2);
    }

    @Test
    public void test281() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test281");
        org.apache.commons.compress.archivers.zip.ZipLong zipLong0 = org.apache.commons.compress.archivers.zip.ZipLong.AED_SIG;
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
        // The following exception was thrown during execution in test generation
        try {
            zipLong0.putLong(byteArray2, 1000);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 1000");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(zipLong0);
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
    public void test282() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test282");
        org.apache.commons.compress.archivers.ArchiveStreamFactory archiveStreamFactory1 = new org.apache.commons.compress.archivers.ArchiveStreamFactory(" \000");
        java.io.OutputStream outputStream3 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream5 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream3, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry6 = null;
        boolean boolean7 = cpioArchiveOutputStream5.canWriteEntryData(archiveEntry6);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream9 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream5, 135);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.ArchiveOutputStream<org.apache.commons.compress.archivers.cpio.CpioArchiveEntry> cpioArchiveEntryArchiveOutputStream11 = archiveStreamFactory1.createArchiveOutputStream("pack.keep.file.order", (java.io.OutputStream) fixedLengthBlockOutputStream9, "splitting");
            org.junit.Assert.fail("Expected exception of type org.apache.commons.compress.archivers.ArchiveException; message: Archiver: pack.keep.file.order not found.");
        } catch (org.apache.commons.compress.archivers.ArchiveException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test283() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test283");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.NAMELEN;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 100 + "'", int0 == 100);
    }

    @Test
    public void test284() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test284");
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
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test285() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test285");
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec0 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean1 = bHSDCodec0.isDelta();
        byte[] byteArray3 = bHSDCodec0.encode((int) '#');
        int int4 = bHSDCodec0.getS();
        int int5 = bHSDCodec0.getH();
        org.junit.Assert.assertNotNull(bHSDCodec0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 35 });
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 4 + "'", int5 == 4);
    }

    @Test
    public void test286() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test286");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        tarArchiveEntry2.setDevMajor(0);
    }

    @Test
    public void test287() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test287");
        org.apache.commons.compress.java.util.jar.Pack200.Unpacker unpacker0 = org.apache.commons.compress.java.util.jar.Pack200.newUnpacker();
        java.beans.PropertyChangeListener propertyChangeListener1 = null;
        unpacker0.removePropertyChangeListener(propertyChangeListener1);
        org.junit.Assert.assertNotNull(unpacker0);
    }

    @Test
    public void test288() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test288");
        java.lang.String str0 = org.apache.commons.compress.archivers.tar.TarConstants.GNU_LONGLINK;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "././@LongLink" + "'", str0, "././@LongLink");
    }

    @Test
    public void test289() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test289");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream8 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream6, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap9 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream10 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream8, strMap9);
        org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec11 = org.apache.commons.compress.harmony.pack200.Codec.BCI5;
        boolean boolean12 = bHSDCodec11.isDelta();
        byte[] byteArray14 = bHSDCodec11.encode((int) '#');
        pack200CompressorOutputStream10.write(byteArray14);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(bHSDCodec11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(byteArray14);
        org.junit.Assert.assertArrayEquals(byteArray14, new byte[] { (byte) 35 });
    }

    @Test
    public void test290() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test290");
        org.apache.commons.compress.archivers.zip.ResourceAlignmentExtraField resourceAlignmentExtraField0 = new org.apache.commons.compress.archivers.zip.ResourceAlignmentExtraField();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort1 = resourceAlignmentExtraField0.getHeaderId();
        org.junit.Assert.assertNotNull(zipShort1);
    }

    @Test
    public void test291() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test291");
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField1 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger2 = zip64ExtendedInformationExtraField1.getCompressedSize();
        byte[] byteArray3 = zip64ExtendedInformationExtraField1.getCentralDirectoryData();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField6 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField("jar", byteArray3, (int) '#', 135);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: null");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(zipEightByteInteger2);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] {});
    }

    @Test
    public void test292() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test292");
        org.apache.commons.compress.harmony.pack200.BHSDCodec[] bHSDCodecArray0 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaUnsignedCodecs4;
        org.junit.Assert.assertNotNull(bHSDCodecArray0);
    }

    @Test
    public void test293() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test293");
        org.apache.commons.compress.archivers.zip.ZipMethod zipMethod0 = org.apache.commons.compress.archivers.zip.ZipMethod.DEFLATED;
        org.junit.Assert.assertTrue("'" + zipMethod0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipMethod.DEFLATED + "'", zipMethod0.equals(org.apache.commons.compress.archivers.zip.ZipMethod.DEFLATED));
    }

    @Test
    public void test294() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test294");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.unpack200.AttributeLayout attributeLayout4 = new org.apache.commons.compress.harmony.unpack200.AttributeLayout("splitting", 148, "zstd", 1000);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.compress.harmony.pack200.Pack200Exception; message: Attribute context out of range: 148");
        } catch (org.apache.commons.compress.harmony.pack200.Pack200Exception e) {
            // Expected exception.
        }
    }

    @Test
    public void test295() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test295");
        org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode extraFieldParsingMode0 = org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT;
        org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp x5455_ExtendedTimestamp1 = new org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp();
        java.nio.file.attribute.FileTime fileTime2 = null;
        x5455_ExtendedTimestamp1.setAccessFileTime(fileTime2);
        org.apache.commons.compress.archivers.zip.ZipShort zipShort4 = x5455_ExtendedTimestamp1.getHeaderId();
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField5 = extraFieldParsingMode0.createExtraField(zipShort4);
        byte[] byteArray7 = org.apache.commons.compress.archivers.zip.ZipShort.getBytes(8);
        org.apache.commons.compress.archivers.zip.ZipExtraField zipExtraField12 = extraFieldParsingMode0.onUnparseableExtraField(byteArray7, (int) (byte) -1, 17, true, 0);
        org.junit.Assert.assertTrue("'" + extraFieldParsingMode0 + "' != '" + org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT + "'", extraFieldParsingMode0.equals(org.apache.commons.compress.archivers.zip.ZipArchiveEntry.ExtraFieldParsingMode.ONLY_PARSEABLE_STRICT));
        org.junit.Assert.assertNotNull(zipShort4);
        org.junit.Assert.assertNotNull(zipExtraField5);
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) 8, (byte) 0 });
        org.junit.Assert.assertNull(zipExtraField12);
    }

    @Test
    public void test296() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test296");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPClass cPClass0 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.CPNameAndType cPNameAndType1 = null;
        org.apache.commons.compress.harmony.unpack200.bytecode.CPFieldRef cPFieldRef3 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPFieldRef(cPClass0, cPNameAndType1, 2);
        java.lang.String str4 = cPFieldRef3.toString();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "FieldRef: null#null" + "'", str4, "FieldRef: null#null");
    }

    @Test
    public void test297() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test297");
        int int0 = org.apache.commons.compress.archivers.tar.TarConstants.ISEXTENDEDLEN_GNU;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test298() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test298");
        org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData unparseableExtraFieldData0 = new org.apache.commons.compress.archivers.zip.UnparseableExtraFieldData();
        org.apache.commons.compress.archivers.zip.ZipShort zipShort1 = unparseableExtraFieldData0.getLocalFileDataLength();
        org.junit.Assert.assertNotNull(zipShort1);
    }

    @Test
    public void test299() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test299");
        org.apache.commons.compress.harmony.pack200.Segment.PassException passException0 = new org.apache.commons.compress.harmony.pack200.Segment.PassException();
        java.lang.String str1 = passException0.toString();
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "org.apache.commons.compress.harmony.pack200.Segment$PassException" + "'", str1, "org.apache.commons.compress.harmony.pack200.Segment$PassException");
    }

    @Test
    public void test300() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test300");
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8 cPUTF8_2 = new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("splitting", 4);
        org.apache.commons.compress.harmony.unpack200.bytecode.EnclosingMethodAttribute.setAttributeName(cPUTF8_2);
        org.apache.commons.compress.compressors.gzip.GzipParameters.OS oS5 = org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM;
        org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue elementValue6 = new org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.ElementValue((int) (byte) 7, (java.lang.Object) oS5);
        java.util.List<java.lang.Object> objList7 = elementValue6.getClassFileEntries();
        boolean boolean8 = cPUTF8_2.equals((java.lang.Object) elementValue6);
        org.junit.Assert.assertTrue("'" + oS5 + "' != '" + org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM + "'", oS5.equals(org.apache.commons.compress.compressors.gzip.GzipParameters.OS.CPM));
        org.junit.Assert.assertNotNull(objList7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test301() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test301");
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField0 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField();
    }

    @Test
    public void test302() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test302");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.ArchiveEntry archiveEntry3 = null;
        boolean boolean4 = cpioArchiveOutputStream2.canWriteEntryData(archiveEntry3);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream6 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.io.OutputStream) cpioArchiveOutputStream2, 135);
        org.apache.commons.compress.utils.FixedLengthBlockOutputStream fixedLengthBlockOutputStream8 = new org.apache.commons.compress.utils.FixedLengthBlockOutputStream((java.nio.channels.WritableByteChannel) fixedLengthBlockOutputStream6, 6);
        java.util.Map<java.lang.String, java.lang.String> strMap9 = null;
        org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream pack200CompressorOutputStream10 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream((java.io.OutputStream) fixedLengthBlockOutputStream8, strMap9);
        java.nio.file.Path path11 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long12 = pack200CompressorOutputStream10.write(path11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test303() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test303");
        org.apache.commons.compress.archivers.dump.DumpArchiveEntry dumpArchiveEntry2 = new org.apache.commons.compress.archivers.dump.DumpArchiveEntry("jar", "splitting");
        dumpArchiveEntry2.setMode((int) '4');
        long long5 = dumpArchiveEntry2.getOffset();
        org.junit.Assert.assertTrue("'" + long5 + "' != '" + 0L + "'", long5 == 0L);
    }

    @Test
    public void test304() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test304");
        org.apache.commons.compress.harmony.pack200.Segment.PassException passException1 = new org.apache.commons.compress.harmony.pack200.Segment.PassException();
        org.apache.commons.compress.archivers.dump.DumpArchiveException dumpArchiveException2 = new org.apache.commons.compress.archivers.dump.DumpArchiveException("arj", (java.lang.Throwable) passException1);
    }

    @Test
    public void test305() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test305");
        org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm hashAlgorithm0 = org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm.MD5;
        org.junit.Assert.assertTrue("'" + hashAlgorithm0 + "' != '" + org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm.MD5 + "'", hashAlgorithm0.equals(org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm.MD5));
    }

    @Test
    public void test306() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test306");
        org.apache.commons.compress.archivers.tar.TarArchiveEntry tarArchiveEntry2 = new org.apache.commons.compress.archivers.tar.TarArchiveEntry("pack.code.attribute.", (byte) 0);
        java.io.File file3 = tarArchiveEntry2.getFile();
        int int4 = tarArchiveEntry2.getDevMinor();
        org.junit.Assert.assertNull(file3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
    }

    @Test
    public void test307() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test307");
        java.lang.String str0 = org.apache.commons.compress.archivers.ArchiveStreamFactory.DUMP;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "dump" + "'", str0, "dump");
    }

    @Test
    public void test308() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test308");
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
    public void test309() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test309");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.compress.harmony.pack200.BHSDCodec bHSDCodec4 = new org.apache.commons.compress.harmony.pack200.BHSDCodec(10, 10, 3, (int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: 1<=b<=5");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test310() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test310");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream cpioArchiveOutputStream2 = new org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream(outputStream0, "pack.keep.file.order");
        org.apache.commons.compress.archivers.zip.JarMarker jarMarker4 = new org.apache.commons.compress.archivers.zip.JarMarker();
        byte[] byteArray5 = jarMarker4.getCentralDirectoryData();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField6 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger7 = zip64ExtendedInformationExtraField6.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger8 = null;
        zip64ExtendedInformationExtraField6.setSize(zipEightByteInteger8);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField10 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField11 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger12 = zip64ExtendedInformationExtraField11.getCompressedSize();
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField13 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger14 = zip64ExtendedInformationExtraField13.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger15 = null;
        zip64ExtendedInformationExtraField13.setSize(zipEightByteInteger15);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField17 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger18 = zip64ExtendedInformationExtraField17.getCompressedSize();
        org.apache.commons.compress.archivers.zip.ZipEightByteInteger zipEightByteInteger19 = null;
        zip64ExtendedInformationExtraField17.setSize(zipEightByteInteger19);
        org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField21 = new org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField();
        org.apache.commons.compress.archivers.zip.ZipExtraField[] zipExtraFieldArray22 = new org.apache.commons.compress.archivers.zip.ZipExtraField[] { zip64ExtendedInformationExtraField6, zip64ExtendedInformationExtraField10, zip64ExtendedInformationExtraField11, zip64ExtendedInformationExtraField13, zip64ExtendedInformationExtraField17, zip64ExtendedInformationExtraField21 };
        byte[] byteArray23 = org.apache.commons.compress.archivers.zip.ExtraFieldUtils.mergeLocalFileDataData(zipExtraFieldArray22);
        boolean boolean24 = org.apache.commons.compress.utils.ArchiveUtils.isEqual(byteArray5, byteArray23);
        org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField unicodeCommentExtraField27 = new org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField("ustar\000", byteArray23, 0, 9);
        // The following exception was thrown during execution in test generation
        try {
            cpioArchiveOutputStream2.write(byteArray23);
            org.junit.Assert.fail("Expected exception of type java.io.IOException; message: No current CPIO entry");
        } catch (java.io.IOException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] {});
        org.junit.Assert.assertNull(zipEightByteInteger7);
        org.junit.Assert.assertNull(zipEightByteInteger12);
        org.junit.Assert.assertNull(zipEightByteInteger14);
        org.junit.Assert.assertNull(zipEightByteInteger18);
        org.junit.Assert.assertNotNull(zipExtraFieldArray22);
        org.junit.Assert.assertNotNull(byteArray23);
        org.junit.Assert.assertArrayEquals(byteArray23, new byte[] { (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0 });
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
    }
}

