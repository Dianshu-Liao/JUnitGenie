package org.apache.commons.codec;

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
        java.security.MessageDigest messageDigest0 = null;
        java.io.InputStream inputStream1 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.security.MessageDigest messageDigest2 = org.apache.commons.codec.digest.DigestUtils.updateDigest(messageDigest0, inputStream1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        String str0 = org.apache.commons.codec.language.bm.Rule.ALL;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "ALL" + "'", str0, "ALL");
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        java.io.InputStream inputStream0 = null;
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.sha(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test004");
        org.apache.commons.codec.language.bm.NameType nameType0 = null;
        org.apache.commons.codec.language.bm.RuleType ruleType1 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Map<String, java.util.List<org.apache.commons.codec.language.bm.Rule>> strMap3 = org.apache.commons.codec.language.bm.Rule.getInstanceMap(nameType0, ruleType1, "ALL");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test005");
        java.io.InputStream inputStream0 = null;
        // The following exception was thrown during execution in test generation
        try {
            String str1 = org.apache.commons.codec.digest.DigestUtils.sha512_224Hex(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA-512/224 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        byte[] byteArray0 = null;
        // The following exception was thrown during execution in test generation
        try {
            javax.crypto.Mac mac1 = org.apache.commons.codec.digest.HmacUtils.getHmacSha256(byteArray0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Null key");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        java.io.InputStream inputStream0 = null;
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.sha3_512(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA3-512 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.codec.binary.Base32 base32_2 = new org.apache.commons.codec.binary.Base32(false, (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: pad must not be in alphabet or whitespace");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        String str0 = org.apache.commons.codec.language.bm.Languages.ANY;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "any" + "'", str0, "any");
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        byte[] byteArray1 = new byte[] { (byte) 1 };
        String str2 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray1);
        String str3 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray1);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray4 = org.apache.commons.codec.digest.DigestUtils.sha512_224(byteArray1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA-512/224 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "AQ==" + "'", str2, "AQ==");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str3, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        // The following exception was thrown during execution in test generation
        try {
            java.security.MessageDigest messageDigest0 = org.apache.commons.codec.digest.DigestUtils.getSha3_224Digest();
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA3-224 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        java.io.InputStream inputStream0 = null;
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.md2(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        StringEncoderComparator stringEncoderComparator0 = new StringEncoderComparator();
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        String str0 = org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA_224;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "SHA-224" + "'", str0, "SHA-224");
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        byte[] byteArray1 = new byte[] { (byte) -1 };
        java.io.InputStream inputStream2 = null;
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray3 = org.apache.commons.codec.digest.HmacUtils.hmacSha256(byteArray1, inputStream2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) -1 });
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        String str0 = org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA_512_256;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "SHA-512/256" + "'", str0, "SHA-512/256");
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        int int0 = org.apache.commons.codec.digest.MurmurHash3.DEFAULT_SEED;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 104729 + "'", int0 == 104729);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.codec.binary.Base16OutputStream base16OutputStream1 = new org.apache.commons.codec.binary.Base16OutputStream(outputStream0);
        byte[] byteArray3 = new byte[] { (byte) 1 };
        String str4 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray3);
        // The following exception was thrown during execution in test generation
        try {
            base16OutputStream1.write(byteArray3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "AQ==" + "'", str4, "AQ==");
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        java.io.InputStream inputStream0 = null;
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.sha1(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        int int1 = org.apache.commons.codec.digest.MurmurHash3.hash32("hi!");
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + (-1688936363) + "'", int1 == (-1688936363));
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        DecoderException decoderException2 = new DecoderException("ALL");
        DecoderException decoderException3 = new DecoderException("SHA-224", (Throwable) decoderException2);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        int int1 = org.apache.commons.codec.digest.MurmurHash3.hash32("any");
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 2131247126 + "'", int1 == 2131247126);
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        boolean boolean1 = org.apache.commons.codec.binary.Base64.isBase64((byte) -1);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        byte[] byteArray3 = new byte[] { (byte) 10, (byte) 0, (byte) 1 };
        // The following exception was thrown during execution in test generation
        try {
            String str6 = org.apache.commons.codec.digest.Md5Crypt.md5Crypt(byteArray3, "SHA-224", "SHA-224");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid prefix value: SHA-224");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 10, (byte) 0, (byte) 1 });
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        java.io.InputStream inputStream0 = null;
        // The following exception was thrown during execution in test generation
        try {
            String str1 = org.apache.commons.codec.digest.DigestUtils.sha3_224Hex(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA3-224 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.sha512_224("\001dd\001\000\000");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA-512/224 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        String str0 = org.apache.commons.codec.binary.Hex.DEFAULT_CHARSET_NAME;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "UTF-8" + "'", str0, "UTF-8");
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        byte[] byteArray3 = new byte[] { (byte) -1, (byte) -1, (byte) 0 };
        java.io.InputStream inputStream4 = null;
        // The following exception was thrown during execution in test generation
        try {
            String str5 = org.apache.commons.codec.digest.HmacUtils.hmacSha1Hex(byteArray3, inputStream4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) -1, (byte) -1, (byte) 0 });
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        java.io.InputStream inputStream0 = null;
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.sha512_256(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA-512/256 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.sha1("ALL");
        // The following exception was thrown during execution in test generation
        try {
            String str3 = org.apache.commons.codec.binary.StringUtils.newString(byteArray1, "ALL");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: ALL: java.io.UnsupportedEncodingException: ALL");
        } catch (IllegalStateException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 107, (byte) 66, (byte) -121, (byte) 78, (byte) 60, (byte) -46, (byte) 7, (byte) 113, (byte) -39, (byte) 48, (byte) -106, (byte) -20, (byte) 92, (byte) -29, (byte) 99, (byte) 7, (byte) -95, (byte) -14, (byte) -70, (byte) 20 });
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        byte[] byteArray2 = new byte[] { (byte) 1 };
        String str3 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray2);
        String str4 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray2);
        // The following exception was thrown during execution in test generation
        try {
            javax.crypto.Mac mac5 = org.apache.commons.codec.digest.HmacUtils.getInitializedMac("SHA-224", byteArray2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: Algorithm SHA-224 not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "AQ==" + "'", str3, "AQ==");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str4, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        DecoderException decoderException1 = new DecoderException("ALL");
        Throwable[] throwableArray2 = decoderException1.getSuppressed();
        org.junit.Assert.assertNotNull(throwableArray2);
        org.junit.Assert.assertArrayEquals(throwableArray2, new Throwable[] {});
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        int int3 = org.apache.commons.codec.digest.MurmurHash3.hash32(0L, (long) 10, (-1));
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + (-1318110126) + "'", int3 == (-1318110126));
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        org.apache.commons.codec.binary.Hex hex0 = new org.apache.commons.codec.binary.Hex();
        java.nio.ByteBuffer byteBuffer2 = org.apache.commons.codec.binary.StringUtils.getByteBufferUtf8("SHA-224");
        byte[] byteArray3 = hex0.encode(byteBuffer2);
        java.io.InputStream inputStream4 = null;
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray5 = org.apache.commons.codec.digest.HmacUtils.hmacSha1(byteArray3, inputStream4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteBuffer2);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 53, (byte) 51, (byte) 52, (byte) 56, (byte) 52, (byte) 49, (byte) 50, (byte) 100, (byte) 51, (byte) 50, (byte) 51, (byte) 50, (byte) 51, (byte) 52 });
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test035");
        org.apache.commons.codec.language.DoubleMetaphone doubleMetaphone0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult2 = doubleMetaphone0.new DoubleMetaphoneResult((int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: reflection call to org.apache.commons.codec.language.DoubleMetaphone$DoubleMetaphoneResult with null for superclass argument");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        byte[] byteArray1 = new byte[] { (byte) 1 };
        String str2 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray1);
        String str3 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray1);
        // The following exception was thrown during execution in test generation
        try {
            String str5 = org.apache.commons.codec.digest.Sha2Crypt.sha512Crypt(byteArray1, "SHA-224");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid salt value: SHA-224");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "AQ==" + "'", str2, "AQ==");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str3, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        byte[] byteArray0 = new byte[] {};
        int int1 = org.apache.commons.codec.digest.MurmurHash3.hash32x86(byteArray0);
        // The following exception was thrown during execution in test generation
        try {
            int int4 = org.apache.commons.codec.digest.MurmurHash3.hash32(byteArray0, (-1688936363), (-1688936363));
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: -1688936364");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray0);
        org.junit.Assert.assertArrayEquals(byteArray0, new byte[] {});
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 0 + "'", int1 == 0);
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray2 = org.apache.commons.codec.digest.HmacUtils.hmacMd5("", "6156665843a7281afec331f09b0ef309");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Empty key");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        String str1 = org.apache.commons.codec.digest.UnixCrypt.crypt("any");
// flaky "1) test039(RegressionTest0)":         org.junit.Assert.assertEquals("'" + str1 + "' != '" + "oHwmB0lRg.H3A" + "'", str1, "oHwmB0lRg.H3A");
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        String str2 = org.apache.commons.codec.digest.UnixCrypt.crypt("7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339", "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "7bT7wvCF8Dme." + "'", str2, "7bT7wvCF8Dme.");
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        int int0 = org.apache.commons.codec.binary.BaseNCodec.MIME_CHUNK_SIZE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 76 + "'", int0 == 76);
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        org.apache.commons.codec.binary.StringUtils stringUtils0 = new org.apache.commons.codec.binary.StringUtils();
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        byte[] byteArray1 = new byte[] { (byte) 1 };
        String str2 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray1);
        org.apache.commons.codec.digest.Blake3 blake3_3 = org.apache.commons.codec.digest.Blake3.initKeyDerivationFunction(byteArray1);
        java.io.InputStream inputStream4 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream6 = new org.apache.commons.codec.binary.Base16InputStream(inputStream4, false);
        // The following exception was thrown during execution in test generation
        try {
            String str7 = org.apache.commons.codec.digest.HmacUtils.hmacSha1Hex(byteArray1, (java.io.InputStream) base16InputStream6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "AQ==" + "'", str2, "AQ==");
        org.junit.Assert.assertNotNull(blake3_3);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        org.apache.commons.codec.language.DaitchMokotoffSoundex daitchMokotoffSoundex1 = new org.apache.commons.codec.language.DaitchMokotoffSoundex(false);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.sha3_384("ALL");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA3-384 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        String str1 = org.apache.commons.codec.digest.Crypt.crypt("");
// flaky "2) test046(RegressionTest0)":         org.junit.Assert.assertEquals("'" + str1 + "' != '" + "$6$hZjG3.XY$6czWvHLhH1l4z3ifyJ31VUlgelUNxpr0dUCBoOq5HGp.GOmJjM2bG/0H0UM/NCwi0uenRBwcDKK3D4E.Dpg5U1" + "'", str1, "$6$hZjG3.XY$6czWvHLhH1l4z3ifyJ31VUlgelUNxpr0dUCBoOq5HGp.GOmJjM2bG/0H0UM/NCwi0uenRBwcDKK3D4E.Dpg5U1");
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        String str1 = org.apache.commons.codec.digest.DigestUtils.md5Hex("any");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "100b8cad7cf2a56f6df78f171f97a1ec" + "'", str1, "100b8cad7cf2a56f6df78f171f97a1ec");
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        // The following exception was thrown during execution in test generation
        try {
            int int3 = org.apache.commons.codec.digest.MurmurHash2.hash32("ALL", 0, 2131247126);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: String index out of range: 2131247126");
        } catch (StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream2 = new org.apache.commons.codec.binary.Base16InputStream(inputStream0, false);
        // The following exception was thrown during execution in test generation
        try {
            String str3 = org.apache.commons.codec.digest.DigestUtils.sha512_224Hex(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA-512/224 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        byte[] byteArray1 = new byte[] { (byte) 1 };
        String str2 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray1);
        String str3 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray1);
        byte[] byteArray4 = org.apache.commons.codec.digest.DigestUtils.md5(byteArray1);
        byte[] byteArray7 = org.apache.commons.codec.binary.Base64.encodeBase64(byteArray4, false, true);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray8 = org.apache.commons.codec.digest.DigestUtils.sha512_256(byteArray7);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA-512/256 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "AQ==" + "'", str2, "AQ==");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str3, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 85, (byte) -91, (byte) 64, (byte) 8, (byte) -83, (byte) 27, (byte) -91, (byte) -119, (byte) -86, (byte) 33, (byte) 13, (byte) 38, (byte) 41, (byte) -63, (byte) -33, (byte) 65 });
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) 86, (byte) 97, (byte) 86, (byte) 65, (byte) 67, (byte) 75, (byte) 48, (byte) 98, (byte) 112, (byte) 89, (byte) 109, (byte) 113, (byte) 73, (byte) 81, (byte) 48, (byte) 109, (byte) 75, (byte) 99, (byte) 72, (byte) 102, (byte) 81, (byte) 81 });
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        String str1 = org.apache.commons.codec.digest.Md5Crypt.apr1Crypt("any");
// flaky "3) test051(RegressionTest0)":         org.junit.Assert.assertEquals("'" + str1 + "' != '" + "$apr1$W2y312Ks$UWEKZ0eX274guRugqidAE0" + "'", str1, "$apr1$W2y312Ks$UWEKZ0eX274guRugqidAE0");
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet1 = null;
        org.apache.commons.codec.language.bm.Rule.Phoneme phoneme2 = new org.apache.commons.codec.language.bm.Rule.Phoneme((CharSequence) "AQ==", languageSet1);
        org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet4 = null;
        org.apache.commons.codec.language.bm.Rule.Phoneme phoneme5 = new org.apache.commons.codec.language.bm.Rule.Phoneme((CharSequence) "AQ==", languageSet4);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.codec.language.bm.Rule.Phoneme phoneme6 = phoneme2.join(phoneme5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream2 = new org.apache.commons.codec.binary.Base16InputStream(inputStream0, false);
        // The following exception was thrown during execution in test generation
        try {
            String str3 = org.apache.commons.codec.digest.DigestUtils.sha3_512Hex((java.io.InputStream) base16InputStream2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA3-512 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        EncoderException encoderException1 = new EncoderException("4568c66f3c2713cef9ee8e6e332561124bbf42cb57c8b9ad08482d36db7d30a3");
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        byte[] byteArray6 = new byte[] { (byte) 1, (byte) 100, (byte) 100, (byte) 1, (byte) 0, (byte) 0 };
        String str7 = org.apache.commons.codec.binary.StringUtils.newStringIso8859_1(byteArray6);
        String str8 = org.apache.commons.codec.digest.DigestUtils.sha256Hex(byteArray6);
        byte[] byteArray9 = org.apache.commons.codec.binary.Base64.decodeBase64(byteArray6);
        // The following exception was thrown during execution in test generation
        try {
            int int11 = org.apache.commons.codec.digest.MurmurHash2.hash32(byteArray6, (int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 6");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] { (byte) 1, (byte) 100, (byte) 100, (byte) 1, (byte) 0, (byte) 0 });
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "\001dd\001\000\000" + "'", str7, "\001dd\001\000\000");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "4568c66f3c2713cef9ee8e6e332561124bbf42cb57c8b9ad08482d36db7d30a3" + "'", str8, "4568c66f3c2713cef9ee8e6e332561124bbf42cb57c8b9ad08482d36db7d30a3");
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertArrayEquals(byteArray9, new byte[] { (byte) 117 });
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        // The following exception was thrown during execution in test generation
        try {
            String str1 = org.apache.commons.codec.digest.DigestUtils.sha3_256Hex("oHwmB0lRg.H3A");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA3-256 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream2 = new org.apache.commons.codec.binary.Base16InputStream(inputStream0, false);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray3 = org.apache.commons.codec.digest.DigestUtils.sha3_384((java.io.InputStream) base16InputStream2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA3-384 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        org.apache.commons.codec.net.PercentCodec percentCodec0 = new org.apache.commons.codec.net.PercentCodec();
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        java.nio.charset.Charset charset0 = Charsets.US_ASCII;
        org.junit.Assert.assertNotNull(charset0);
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        java.math.BigInteger bigInteger0 = null;
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray1 = org.apache.commons.codec.binary.Base64.encodeInteger(bigInteger0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: bigInteger");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        org.apache.commons.codec.language.Caverphone1 caverphone1_0 = new org.apache.commons.codec.language.Caverphone1();
        String str2 = caverphone1_0.encode("UTF-8");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "ATF111" + "'", str2, "ATF111");
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        java.security.MessageDigest messageDigest0 = org.apache.commons.codec.digest.DigestUtils.getShaDigest();
        org.junit.Assert.assertNotNull(messageDigest0);
        org.junit.Assert.assertEquals(messageDigest0.toString(), "SHA-1 Message Digest from SUN, <initialized>\n");
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        // The following exception was thrown during execution in test generation
        try {
            java.security.MessageDigest messageDigest1 = org.apache.commons.codec.digest.DigestUtils.getDigest("7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: 7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        String str0 = org.apache.commons.codec.digest.MessageDigestAlgorithms.MD5;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "MD5" + "'", str0, "MD5");
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        byte[] byteArray2 = new byte[] { (byte) 1 };
        String str3 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray2);
        String str4 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray2);
        boolean boolean5 = org.apache.commons.codec.binary.Base64.isArrayByteBase64(byteArray2);
        org.apache.commons.codec.binary.Base64 base64_7 = new org.apache.commons.codec.binary.Base64(1, byteArray2, true);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "AQ==" + "'", str3, "AQ==");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str4, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        org.apache.commons.codec.digest.Blake3 blake3_0 = org.apache.commons.codec.digest.Blake3.initHash();
        org.junit.Assert.assertNotNull(blake3_0);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream2 = new org.apache.commons.codec.binary.Base16InputStream(inputStream0, false);
        org.apache.commons.codec.binary.Base32InputStream base32InputStream3 = new org.apache.commons.codec.binary.Base32InputStream(inputStream0);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray4 = org.apache.commons.codec.digest.DigestUtils.sha(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        byte[] byteArray1 = new byte[] { (byte) 1 };
        String str2 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray1);
        String str3 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray1);
        byte[] byteArray4 = org.apache.commons.codec.digest.DigestUtils.md5(byteArray1);
        byte[] byteArray7 = org.apache.commons.codec.binary.Base64.encodeBase64(byteArray4, false, true);
        java.util.Random random8 = null;
        // The following exception was thrown during execution in test generation
        try {
            String str9 = org.apache.commons.codec.digest.Md5Crypt.apr1Crypt(byteArray7, random8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "AQ==" + "'", str2, "AQ==");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str3, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 85, (byte) -91, (byte) 64, (byte) 8, (byte) -83, (byte) 27, (byte) -91, (byte) -119, (byte) -86, (byte) 33, (byte) 13, (byte) 38, (byte) 41, (byte) -63, (byte) -33, (byte) 65 });
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) 86, (byte) 97, (byte) 86, (byte) 65, (byte) 67, (byte) 75, (byte) 48, (byte) 98, (byte) 112, (byte) 89, (byte) 109, (byte) 113, (byte) 73, (byte) 81, (byte) 48, (byte) 109, (byte) 75, (byte) 99, (byte) 72, (byte) 102, (byte) 81, (byte) 81 });
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        byte[] byteArray1 = new byte[] { (byte) 1 };
        String str2 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray1);
        // The following exception was thrown during execution in test generation
        try {
            String str4 = org.apache.commons.codec.digest.UnixCrypt.crypt(byteArray1, "SHA-512/256");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid salt value: SHA-512/256");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "AQ==" + "'", str2, "AQ==");
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        // The following exception was thrown during execution in test generation
        try {
            java.io.InputStream inputStream1 = Resources.getInputStream("6704602e4ce5d0029093eef113910bc4c3f653e00e98689ee2d8ee1ed75372d6122faa47319cb8c8b75c80bea32b8c8c5b435d6eaa2c9f1ecd7833b7ae0cb6d4");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Unable to resolve required resource: 6704602e4ce5d0029093eef113910bc4c3f653e00e98689ee2d8ee1ed75372d6122faa47319cb8c8b75c80bea32b8c8c5b435d6eaa2c9f1ecd7833b7ae0cb6d4");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.codec.binary.Base16OutputStream base16OutputStream1 = new org.apache.commons.codec.binary.Base16OutputStream(outputStream0);
        // The following exception was thrown during execution in test generation
        try {
            base16OutputStream1.flush();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        org.apache.commons.codec.binary.Hex hex0 = new org.apache.commons.codec.binary.Hex();
        java.nio.ByteBuffer byteBuffer2 = org.apache.commons.codec.binary.StringUtils.getByteBufferUtf8("SHA-224");
        byte[] byteArray3 = hex0.encode(byteBuffer2);
        char[] charArray4 = org.apache.commons.codec.binary.Hex.encodeHex(byteBuffer2);
        byte[] byteArray5 = org.apache.commons.codec.binary.Hex.decodeHex(charArray4);
        org.junit.Assert.assertNotNull(byteBuffer2);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 53, (byte) 51, (byte) 52, (byte) 56, (byte) 52, (byte) 49, (byte) 50, (byte) 100, (byte) 51, (byte) 50, (byte) 51, (byte) 50, (byte) 51, (byte) 52 });
        org.junit.Assert.assertNotNull(charArray4);
        org.junit.Assert.assertArrayEquals(charArray4, new char[] {});
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] {});
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
        // The following exception was thrown during execution in test generation
        try {
            int int3 = org.apache.commons.codec.digest.MurmurHash2.hash32("", (-1318110126), 100);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: String index out of range: -1318110126");
        } catch (StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream2 = new org.apache.commons.codec.binary.Base16InputStream(inputStream0, false);
        org.apache.commons.codec.binary.Base32InputStream base32InputStream3 = new org.apache.commons.codec.binary.Base32InputStream(inputStream0);
        java.security.MessageDigest messageDigest4 = org.apache.commons.codec.digest.DigestUtils.getSha512Digest();
        org.apache.commons.codec.digest.DigestUtils digestUtils5 = new org.apache.commons.codec.digest.DigestUtils(messageDigest4);
        byte[] byteArray7 = new byte[] { (byte) 1 };
        String str8 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray7);
        String str9 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray7);
        byte[] byteArray10 = org.apache.commons.codec.digest.DigestUtils.md5(byteArray7);
        byte[] byteArray13 = org.apache.commons.codec.binary.Base64.encodeBase64(byteArray10, false, true);
        String str14 = digestUtils5.digestAsHex(byteArray13);
        // The following exception was thrown during execution in test generation
        try {
            int int15 = base32InputStream3.read(byteArray13);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(messageDigest4);
        org.junit.Assert.assertEquals(messageDigest4.toString(), "SHA-512 Message Digest from SUN, <initialized>\n");
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "AQ==" + "'", str8, "AQ==");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str9, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertNotNull(byteArray10);
        org.junit.Assert.assertArrayEquals(byteArray10, new byte[] { (byte) 85, (byte) -91, (byte) 64, (byte) 8, (byte) -83, (byte) 27, (byte) -91, (byte) -119, (byte) -86, (byte) 33, (byte) 13, (byte) 38, (byte) 41, (byte) -63, (byte) -33, (byte) 65 });
        org.junit.Assert.assertNotNull(byteArray13);
        org.junit.Assert.assertArrayEquals(byteArray13, new byte[] { (byte) 86, (byte) 97, (byte) 86, (byte) 65, (byte) 67, (byte) 75, (byte) 48, (byte) 98, (byte) 112, (byte) 89, (byte) 109, (byte) 113, (byte) 73, (byte) 81, (byte) 48, (byte) 109, (byte) 75, (byte) 99, (byte) 72, (byte) 102, (byte) 81, (byte) 81 });
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "6704602e4ce5d0029093eef113910bc4c3f653e00e98689ee2d8ee1ed75372d6122faa47319cb8c8b75c80bea32b8c8c5b435d6eaa2c9f1ecd7833b7ae0cb6d4" + "'", str14, "6704602e4ce5d0029093eef113910bc4c3f653e00e98689ee2d8ee1ed75372d6122faa47319cb8c8b75c80bea32b8c8c5b435d6eaa2c9f1ecd7833b7ae0cb6d4");
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        org.apache.commons.codec.binary.Base64 base64_1 = new org.apache.commons.codec.binary.Base64((int) '#');
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream2 = new org.apache.commons.codec.binary.Base16InputStream(inputStream0, false);
        org.apache.commons.codec.binary.Base32InputStream base32InputStream3 = new org.apache.commons.codec.binary.Base32InputStream(inputStream0);
        // The following exception was thrown during execution in test generation
        try {
            String str4 = org.apache.commons.codec.digest.DigestUtils.sha1Hex((java.io.InputStream) base32InputStream3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        org.apache.commons.codec.binary.Hex hex0 = new org.apache.commons.codec.binary.Hex();
        java.nio.ByteBuffer byteBuffer2 = org.apache.commons.codec.binary.StringUtils.getByteBufferUtf8("SHA-224");
        byte[] byteArray3 = hex0.encode(byteBuffer2);
        Object obj4 = null;
        // The following exception was thrown during execution in test generation
        try {
            Object obj5 = hex0.decode(obj4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteBuffer2);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 53, (byte) 51, (byte) 52, (byte) 56, (byte) 52, (byte) 49, (byte) 50, (byte) 100, (byte) 51, (byte) 50, (byte) 51, (byte) 50, (byte) 51, (byte) 52 });
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        org.apache.commons.codec.binary.Base64 base64_1 = new org.apache.commons.codec.binary.Base64(true);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        java.security.MessageDigest messageDigest0 = org.apache.commons.codec.digest.DigestUtils.getSha256Digest();
        java.io.RandomAccessFile randomAccessFile1 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.security.MessageDigest messageDigest2 = org.apache.commons.codec.digest.DigestUtils.updateDigest(messageDigest0, randomAccessFile1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(messageDigest0);
        org.junit.Assert.assertEquals(messageDigest0.toString(), "SHA-256 Message Digest from SUN, <initialized>\n");
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        byte[] byteArray1 = new byte[] { (byte) 1 };
        String str2 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray1);
        String str3 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray1);
        String str4 = org.apache.commons.codec.digest.DigestUtils.md2Hex(byteArray1);
        String str6 = org.apache.commons.codec.digest.Crypt.crypt(byteArray1, "100b8cad7cf2a56f6df78f171f97a1ec");
        char[] charArray8 = org.apache.commons.codec.binary.Hex.encodeHex(byteArray1, true);
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "AQ==" + "'", str2, "AQ==");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str3, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "6156665843a7281afec331f09b0ef309" + "'", str4, "6156665843a7281afec331f09b0ef309");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "10uoEQ/ivapr6" + "'", str6, "10uoEQ/ivapr6");
        org.junit.Assert.assertNotNull(charArray8);
        org.junit.Assert.assertArrayEquals(charArray8, new char[] { '0', '1' });
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.md2("hi!");
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) -55, (byte) 124, (byte) 78, (byte) 76, (byte) 114, (byte) -94, (byte) -58, (byte) -69, (byte) -2, (byte) -91, (byte) 79, (byte) -30, (byte) -79, (byte) -79, (byte) -18, (byte) 7 });
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        org.apache.commons.codec.language.bm.NameType nameType0 = null;
        org.apache.commons.codec.language.bm.RuleType ruleType1 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.List<org.apache.commons.codec.language.bm.Rule> ruleList3 = org.apache.commons.codec.language.bm.Rule.getInstance(nameType0, ruleType1, "100b8cad7cf2a56f6df78f171f97a1ec");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        java.security.MessageDigest messageDigest0 = org.apache.commons.codec.digest.DigestUtils.getSha1Digest();
        org.junit.Assert.assertNotNull(messageDigest0);
        org.junit.Assert.assertEquals(messageDigest0.toString(), "SHA-1 Message Digest from SUN, <initialized>\n");
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.md2("7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) -58, (byte) -11, (byte) -28, (byte) 103, (byte) -47, (byte) 21, (byte) 125, (byte) -26, (byte) 113, (byte) 72, (byte) -104, (byte) -104, (byte) 123, (byte) 68, (byte) 30, (byte) 59 });
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream2 = new org.apache.commons.codec.binary.Base16InputStream(inputStream0, false);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray3 = org.apache.commons.codec.digest.DigestUtils.sha384((java.io.InputStream) base16InputStream2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        java.nio.ByteBuffer byteBuffer1 = org.apache.commons.codec.binary.StringUtils.getByteBufferUtf8("SHA-224");
        String str3 = org.apache.commons.codec.binary.Hex.encodeHexString(byteBuffer1, true);
        org.junit.Assert.assertNotNull(byteBuffer1);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "5348412d323234" + "'", str3, "5348412d323234");
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        org.apache.commons.codec.net.QuotedPrintableCodec quotedPrintableCodec0 = new org.apache.commons.codec.net.QuotedPrintableCodec();
        String str2 = quotedPrintableCodec0.encode("10uoEQ/ivapr6");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "10uoEQ/ivapr6" + "'", str2, "10uoEQ/ivapr6");
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        // The following exception was thrown during execution in test generation
        try {
            java.security.MessageDigest messageDigest0 = org.apache.commons.codec.digest.DigestUtils.getSha3_512Digest();
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA3-512 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        String str1 = org.apache.commons.codec.digest.UnixCrypt.crypt("");
// flaky "4) test089(RegressionTest0)":         org.junit.Assert.assertEquals("'" + str1 + "' != '" + "2oBllIQFOdgyw" + "'", str1, "2oBllIQFOdgyw");
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        String str0 = org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA_512_224;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "SHA-512/224" + "'", str0, "SHA-512/224");
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        org.apache.commons.codec.binary.Hex hex0 = new org.apache.commons.codec.binary.Hex();
        java.nio.ByteBuffer byteBuffer2 = org.apache.commons.codec.binary.StringUtils.getByteBufferUtf8("SHA-224");
        byte[] byteArray3 = hex0.encode(byteBuffer2);
        char[] charArray4 = org.apache.commons.codec.binary.Hex.encodeHex(byteBuffer2);
        char[] charArray5 = org.apache.commons.codec.binary.Hex.encodeHex(byteBuffer2);
        org.junit.Assert.assertNotNull(byteBuffer2);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 53, (byte) 51, (byte) 52, (byte) 56, (byte) 52, (byte) 49, (byte) 50, (byte) 100, (byte) 51, (byte) 50, (byte) 51, (byte) 50, (byte) 51, (byte) 52 });
        org.junit.Assert.assertNotNull(charArray4);
        org.junit.Assert.assertArrayEquals(charArray4, new char[] {});
        org.junit.Assert.assertNotNull(charArray5);
        org.junit.Assert.assertArrayEquals(charArray5, new char[] {});
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        String str2 = org.apache.commons.codec.digest.HmacUtils.hmacSha256Hex("$apr1$W2y312Ks$UWEKZ0eX274guRugqidAE0", "hi!");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "7bf2840e9911920c6c17b7c7ac057ddcbf629b69f2fad16b16a4269e5f5c1298" + "'", str2, "7bf2840e9911920c6c17b7c7ac057ddcbf629b69f2fad16b16a4269e5f5c1298");
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        byte[] byteArray0 = org.apache.commons.codec.binary.BaseNCodec.getChunkSeparator();
        byte[] byteArray1 = org.apache.commons.codec.binary.Base64.encodeBase64(byteArray0);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.codec.digest.Blake3 blake3_2 = org.apache.commons.codec.digest.Blake3.initKeyedHash(byteArray0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Blake3 keys must be 32 bytes");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray0);
        org.junit.Assert.assertArrayEquals(byteArray0, new byte[] { (byte) 13, (byte) 10 });
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 68, (byte) 81, (byte) 111, (byte) 61 });
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        byte[] byteArray0 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long2 = org.apache.commons.codec.digest.MurmurHash2.hash64(byteArray0, (int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream2 = new org.apache.commons.codec.binary.Base16InputStream(inputStream0, false);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray3 = org.apache.commons.codec.digest.DigestUtils.sha512_256((java.io.InputStream) base16InputStream2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA-512/256 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        byte[] byteArray1 = new byte[] { (byte) 1 };
        String str2 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray1);
        String str3 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray1);
        byte[] byteArray4 = org.apache.commons.codec.digest.DigestUtils.md5(byteArray1);
        // The following exception was thrown during execution in test generation
        try {
            int int8 = org.apache.commons.codec.digest.MurmurHash3.hash32(byteArray1, (int) (short) 10, (int) (short) 100, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 10");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "AQ==" + "'", str2, "AQ==");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str3, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 85, (byte) -91, (byte) 64, (byte) 8, (byte) -83, (byte) 27, (byte) -91, (byte) -119, (byte) -86, (byte) 33, (byte) 13, (byte) 38, (byte) 41, (byte) -63, (byte) -33, (byte) 65 });
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        javax.crypto.Mac mac0 = null;
        java.io.InputStream inputStream1 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream3 = new org.apache.commons.codec.binary.Base16InputStream(inputStream1, false);
        // The following exception was thrown during execution in test generation
        try {
            javax.crypto.Mac mac4 = org.apache.commons.codec.digest.HmacUtils.updateHmac(mac0, (java.io.InputStream) base16InputStream3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        String str0 = org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA3_384;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "SHA3-384" + "'", str0, "SHA3-384");
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        java.security.MessageDigest messageDigest1 = org.apache.commons.codec.digest.DigestUtils.getSha512Digest();
        org.apache.commons.codec.digest.DigestUtils digestUtils2 = new org.apache.commons.codec.digest.DigestUtils(messageDigest1);
        java.security.MessageDigest messageDigest3 = digestUtils2.getMessageDigest();
        java.security.MessageDigest messageDigest4 = org.apache.commons.codec.digest.DigestUtils.getDigest("6156665843a7281afec331f09b0ef309", messageDigest3);
        byte[] byteArray7 = org.apache.commons.codec.digest.HmacUtils.hmacSha1("UTF-8", "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        java.security.MessageDigest messageDigest8 = org.apache.commons.codec.digest.DigestUtils.updateDigest(messageDigest3, byteArray7);
        java.io.InputStream inputStream9 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream11 = new org.apache.commons.codec.binary.Base16InputStream(inputStream9, false);
        // The following exception was thrown during execution in test generation
        try {
            java.security.MessageDigest messageDigest12 = org.apache.commons.codec.digest.DigestUtils.updateDigest(messageDigest3, (java.io.InputStream) base16InputStream11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(messageDigest1);
        org.junit.Assert.assertEquals(messageDigest1.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
        org.junit.Assert.assertNotNull(messageDigest3);
        org.junit.Assert.assertEquals(messageDigest3.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
        org.junit.Assert.assertNotNull(messageDigest4);
        org.junit.Assert.assertEquals(messageDigest4.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) -35, (byte) 1, (byte) -117, (byte) -21, (byte) -107, (byte) 125, (byte) 12, (byte) 116, (byte) 37, (byte) -85, (byte) -59, (byte) 12, (byte) 73, (byte) -86, (byte) -37, (byte) -59, (byte) 14, (byte) 0, (byte) -88, (byte) -41 });
        org.junit.Assert.assertNotNull(messageDigest8);
        org.junit.Assert.assertEquals(messageDigest8.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        byte[] byteArray2 = new byte[] { (byte) 100, (byte) 1 };
        // The following exception was thrown during execution in test generation
        try {
            String str3 = org.apache.commons.codec.digest.DigestUtils.sha3_224Hex(byteArray2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA3-224 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) 100, (byte) 1 });
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        org.apache.commons.codec.language.Metaphone metaphone0 = new org.apache.commons.codec.language.Metaphone();
        // The following exception was thrown during execution in test generation
        try {
            Object obj2 = metaphone0.encode((Object) 0.0d);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.codec.EncoderException; message: Parameter supplied to Metaphone encode is not of type java.lang.String");
        } catch (EncoderException e) {
            // Expected exception.
        }
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream2 = new org.apache.commons.codec.binary.Base16InputStream(inputStream0, false);
        org.apache.commons.codec.binary.Base32InputStream base32InputStream3 = new org.apache.commons.codec.binary.Base32InputStream(inputStream0);
        // The following exception was thrown during execution in test generation
        try {
            String str4 = org.apache.commons.codec.digest.DigestUtils.sha256Hex((java.io.InputStream) base32InputStream3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet1 = null;
        org.apache.commons.codec.language.bm.Rule.Phoneme phoneme2 = new org.apache.commons.codec.language.bm.Rule.Phoneme((CharSequence) "AQ==", languageSet1);
        org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet4 = null;
        org.apache.commons.codec.language.bm.Rule.Phoneme phoneme5 = new org.apache.commons.codec.language.bm.Rule.Phoneme((CharSequence) "AQ==", languageSet4);
        org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet6 = phoneme5.getLanguages();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.codec.language.bm.Rule.Phoneme phoneme7 = phoneme2.join(phoneme5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(languageSet6);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        java.security.MessageDigest messageDigest0 = org.apache.commons.codec.digest.DigestUtils.getSha512Digest();
        java.io.RandomAccessFile randomAccessFile1 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.security.MessageDigest messageDigest2 = org.apache.commons.codec.digest.DigestUtils.updateDigest(messageDigest0, randomAccessFile1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(messageDigest0);
        org.junit.Assert.assertEquals(messageDigest0.toString(), "SHA-512 Message Digest from SUN, <initialized>\n");
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        byte[] byteArray1 = new byte[] { (byte) 1 };
        String str2 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray1);
        String str3 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray1);
        java.math.BigInteger bigInteger4 = org.apache.commons.codec.binary.Base64.decodeInteger(byteArray1);
        byte[] byteArray5 = org.apache.commons.codec.binary.Base64.encodeInteger(bigInteger4);
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "AQ==" + "'", str2, "AQ==");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str3, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertNotNull(bigInteger4);
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] {});
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream2 = new org.apache.commons.codec.binary.Base16InputStream(inputStream0, false);
        // The following exception was thrown during execution in test generation
        try {
            String str3 = org.apache.commons.codec.digest.DigestUtils.md5Hex(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.sha512("$6$hZjG3.XY$6czWvHLhH1l4z3ifyJ31VUlgelUNxpr0dUCBoOq5HGp.GOmJjM2bG/0H0UM/NCwi0uenRBwcDKK3D4E.Dpg5U1");
        byte[] byteArray8 = new byte[] { (byte) 1, (byte) 100, (byte) 100, (byte) 1, (byte) 0, (byte) 0 };
        String str9 = org.apache.commons.codec.binary.StringUtils.newStringIso8859_1(byteArray8);
        String str10 = org.apache.commons.codec.digest.DigestUtils.sha256Hex(byteArray8);
        byte[] byteArray11 = org.apache.commons.codec.digest.HmacUtils.hmacSha1(byteArray1, byteArray8);
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertNotNull(byteArray8);
        org.junit.Assert.assertArrayEquals(byteArray8, new byte[] { (byte) 1, (byte) 100, (byte) 100, (byte) 1, (byte) 0, (byte) 0 });
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "\001dd\001\000\000" + "'", str9, "\001dd\001\000\000");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "4568c66f3c2713cef9ee8e6e332561124bbf42cb57c8b9ad08482d36db7d30a3" + "'", str10, "4568c66f3c2713cef9ee8e6e332561124bbf42cb57c8b9ad08482d36db7d30a3");
        org.junit.Assert.assertNotNull(byteArray11);
        org.junit.Assert.assertArrayEquals(byteArray11, new byte[] { (byte) 55, (byte) 93, (byte) -100, (byte) 109, (byte) 8, (byte) 115, (byte) -27, (byte) -113, (byte) 115, (byte) -128, (byte) 120, (byte) -79, (byte) -113, (byte) -119, (byte) 38, (byte) 54, (byte) -103, (byte) -20, (byte) -83, (byte) 55 });
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream2 = new org.apache.commons.codec.binary.Base16InputStream(inputStream0, false);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray3 = org.apache.commons.codec.digest.DigestUtils.sha384(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        org.apache.commons.codec.binary.Base16 base16_0 = new org.apache.commons.codec.binary.Base16();
        boolean boolean2 = base16_0.isInAlphabet((byte) 0);
        byte[] byteArray4 = new byte[] { (byte) 1 };
        String str5 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray4);
        String str6 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray4);
        byte[] byteArray7 = org.apache.commons.codec.digest.DigestUtils.md5(byteArray4);
        byte[] byteArray10 = org.apache.commons.codec.binary.Base64.encodeBase64(byteArray7, false, true);
        long long11 = base16_0.getEncodedLength(byteArray10);
        boolean boolean13 = base16_0.isInAlphabet((byte) 10);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "AQ==" + "'", str5, "AQ==");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str6, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) 85, (byte) -91, (byte) 64, (byte) 8, (byte) -83, (byte) 27, (byte) -91, (byte) -119, (byte) -86, (byte) 33, (byte) 13, (byte) 38, (byte) 41, (byte) -63, (byte) -33, (byte) 65 });
        org.junit.Assert.assertNotNull(byteArray10);
        org.junit.Assert.assertArrayEquals(byteArray10, new byte[] { (byte) 86, (byte) 97, (byte) 86, (byte) 65, (byte) 67, (byte) 75, (byte) 48, (byte) 98, (byte) 112, (byte) 89, (byte) 109, (byte) 113, (byte) 73, (byte) 81, (byte) 48, (byte) 109, (byte) 75, (byte) 99, (byte) 72, (byte) 102, (byte) 81, (byte) 81 });
        org.junit.Assert.assertTrue("'" + long11 + "' != '" + 44L + "'", long11 == 44L);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        byte[] byteArray0 = org.apache.commons.codec.binary.BaseNCodec.getChunkSeparator();
        byte[] byteArray1 = org.apache.commons.codec.binary.Base64.encodeBase64(byteArray0);
        // The following exception was thrown during execution in test generation
        try {
            char[] charArray5 = org.apache.commons.codec.binary.Hex.encodeHex(byteArray0, (int) (byte) -1, (int) (byte) 100, false);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: -1");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray0);
        org.junit.Assert.assertArrayEquals(byteArray0, new byte[] { (byte) 13, (byte) 10 });
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 68, (byte) 81, (byte) 111, (byte) 61 });
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        Resources resources0 = new Resources();
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.sha512("$6$hZjG3.XY$6czWvHLhH1l4z3ifyJ31VUlgelUNxpr0dUCBoOq5HGp.GOmJjM2bG/0H0UM/NCwi0uenRBwcDKK3D4E.Dpg5U1");
        boolean boolean2 = org.apache.commons.codec.binary.Base64.isArrayByteBase64(byteArray1);
        long[] longArray3 = org.apache.commons.codec.digest.MurmurHash3.hash128x64(byteArray1);
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(longArray3);
        org.junit.Assert.assertArrayEquals(longArray3, new long[] { (-4389317567006233171L), 7740449849287561391L });
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream2 = new org.apache.commons.codec.binary.Base16InputStream(inputStream0, false);
        org.apache.commons.codec.binary.Base32InputStream base32InputStream3 = new org.apache.commons.codec.binary.Base32InputStream(inputStream0);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray4 = org.apache.commons.codec.digest.DigestUtils.sha512_256(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA-512/256 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream2 = new org.apache.commons.codec.binary.Base16InputStream(inputStream0, false);
        org.apache.commons.codec.binary.Base32InputStream base32InputStream3 = new org.apache.commons.codec.binary.Base32InputStream(inputStream0);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray4 = org.apache.commons.codec.digest.DigestUtils.sha3_224(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA3-224 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        org.apache.commons.codec.language.bm.NameType nameType0 = null;
        org.apache.commons.codec.language.bm.RuleType ruleType1 = org.apache.commons.codec.language.bm.RuleType.RULES;
        org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet2 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.List<org.apache.commons.codec.language.bm.Rule> ruleList3 = org.apache.commons.codec.language.bm.Rule.getInstance(nameType0, ruleType1, languageSet2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + ruleType1 + "' != '" + org.apache.commons.codec.language.bm.RuleType.RULES + "'", ruleType1.equals(org.apache.commons.codec.language.bm.RuleType.RULES));
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        org.apache.commons.codec.language.Nysiis nysiis0 = new org.apache.commons.codec.language.Nysiis();
        String str2 = nysiis0.nysiis("hi!");
        boolean boolean3 = nysiis0.isStrict();
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "H" + "'", str2, "H");
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        org.apache.commons.codec.language.Nysiis nysiis0 = new org.apache.commons.codec.language.Nysiis();
        byte[] byteArray1 = new byte[] {};
        int int2 = org.apache.commons.codec.digest.MurmurHash3.hash32x86(byteArray1);
        String str3 = org.apache.commons.codec.binary.StringUtils.newStringUtf16Le(byteArray1);
        Object obj4 = nysiis0.encode((Object) str3);
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] {});
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
        org.junit.Assert.assertEquals("'" + obj4 + "' != '" + "" + "'", obj4, "");
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.codec.binary.Base16OutputStream base16OutputStream1 = new org.apache.commons.codec.binary.Base16OutputStream(outputStream0);
        org.apache.commons.codec.binary.Base16OutputStream base16OutputStream4 = new org.apache.commons.codec.binary.Base16OutputStream((java.io.OutputStream) base16OutputStream1, true, false);
        org.apache.commons.codec.binary.Base32OutputStream base32OutputStream6 = new org.apache.commons.codec.binary.Base32OutputStream((java.io.OutputStream) base16OutputStream1, false);
        org.apache.commons.codec.binary.Base32 base32_8 = new org.apache.commons.codec.binary.Base32(true);
        org.apache.commons.codec.binary.BaseNCodecOutputStream baseNCodecOutputStream10 = new org.apache.commons.codec.binary.BaseNCodecOutputStream((java.io.OutputStream) base32OutputStream6, (org.apache.commons.codec.binary.BaseNCodec) base32_8, true);
        org.apache.commons.codec.binary.Base64 base64_11 = new org.apache.commons.codec.binary.Base64();
        org.apache.commons.codec.binary.Base64 base64_13 = new org.apache.commons.codec.binary.Base64(0);
        byte[] byteArray15 = new byte[] { (byte) 1 };
        String str16 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray15);
        boolean boolean18 = base64_13.isInAlphabet(byteArray15, false);
        byte[] byteArray19 = base64_11.decode(byteArray15);
        org.apache.commons.codec.binary.BaseNCodecOutputStream baseNCodecOutputStream21 = new org.apache.commons.codec.binary.BaseNCodecOutputStream((java.io.OutputStream) baseNCodecOutputStream10, (org.apache.commons.codec.binary.BaseNCodec) base64_11, true);
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "AQ==" + "'", str16, "AQ==");
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNotNull(byteArray19);
        org.junit.Assert.assertArrayEquals(byteArray19, new byte[] {});
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        String str2 = org.apache.commons.codec.digest.HmacUtils.hmacSha384Hex("6704602e4ce5d0029093eef113910bc4c3f653e00e98689ee2d8ee1ed75372d6122faa47319cb8c8b75c80bea32b8c8c5b435d6eaa2c9f1ecd7833b7ae0cb6d4", "oHwmB0lRg.H3A");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "b67f94ef55d01fac7818d0819bbd94726b5ad4030715b469f2fb7cf3730c9c0194bd296ec32e37da5d3e36e736f2505d" + "'", str2, "b67f94ef55d01fac7818d0819bbd94726b5ad4030715b469f2fb7cf3730c9c0194bd296ec32e37da5d3e36e736f2505d");
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        byte[] byteArray1 = new byte[] { (byte) 1 };
        String str2 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray1);
        String str3 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray1);
        String str4 = org.apache.commons.codec.digest.DigestUtils.sha384Hex(byteArray1);
        java.util.Random random6 = null;
        // The following exception was thrown during execution in test generation
        try {
            String str7 = org.apache.commons.codec.digest.Sha2Crypt.sha256Crypt(byteArray1, "MD5", random6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid salt value: MD5");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "AQ==" + "'", str2, "AQ==");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str3, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "8d2ce87d86f55fcfab770a047b090da23270fa206832dfea7e0c946fff451f819add242374be551b0d6318ed6c7d41d8" + "'", str4, "8d2ce87d86f55fcfab770a047b090da23270fa206832dfea7e0c946fff451f819add242374be551b0d6318ed6c7d41d8");
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        // The following exception was thrown during execution in test generation
        try {
            String str1 = org.apache.commons.codec.digest.DigestUtils.sha3_512Hex("");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA3-512 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        byte[] byteArray1 = new byte[] { (byte) 1 };
        String str2 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray1);
        String str3 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray1);
        String str4 = org.apache.commons.codec.digest.DigestUtils.sha384Hex(byteArray1);
        java.util.Random random5 = null;
        // The following exception was thrown during execution in test generation
        try {
            String str6 = org.apache.commons.codec.digest.Md5Crypt.md5Crypt(byteArray1, random5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "AQ==" + "'", str2, "AQ==");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str3, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "8d2ce87d86f55fcfab770a047b090da23270fa206832dfea7e0c946fff451f819add242374be551b0d6318ed6c7d41d8" + "'", str4, "8d2ce87d86f55fcfab770a047b090da23270fa206832dfea7e0c946fff451f819add242374be551b0d6318ed6c7d41d8");
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.codec.binary.Base16OutputStream base16OutputStream1 = new org.apache.commons.codec.binary.Base16OutputStream(outputStream0);
        org.apache.commons.codec.binary.Base16OutputStream base16OutputStream4 = new org.apache.commons.codec.binary.Base16OutputStream((java.io.OutputStream) base16OutputStream1, true, false);
        org.apache.commons.codec.binary.Base32OutputStream base32OutputStream6 = new org.apache.commons.codec.binary.Base32OutputStream((java.io.OutputStream) base16OutputStream1, false);
        org.apache.commons.codec.binary.Base32 base32_8 = new org.apache.commons.codec.binary.Base32(true);
        org.apache.commons.codec.binary.BaseNCodecOutputStream baseNCodecOutputStream10 = new org.apache.commons.codec.binary.BaseNCodecOutputStream((java.io.OutputStream) base32OutputStream6, (org.apache.commons.codec.binary.BaseNCodec) base32_8, true);
        CodecPolicy codecPolicy13 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.codec.binary.Base16OutputStream base16OutputStream14 = new org.apache.commons.codec.binary.Base16OutputStream((java.io.OutputStream) baseNCodecOutputStream10, true, false, codecPolicy13);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: codecPolicy");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        byte[] byteArray1 = org.apache.commons.codec.binary.BaseNCodec.getChunkSeparator();
        byte[] byteArray2 = org.apache.commons.codec.binary.Base64.encodeBase64(byteArray1);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.codec.binary.Base32 base32_5 = new org.apache.commons.codec.binary.Base32((int) '4', byteArray2, true, (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: lineSeparator must not contain Base32 characters: [DQo=]");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 13, (byte) 10 });
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) 68, (byte) 81, (byte) 111, (byte) 61 });
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test125");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream2 = new org.apache.commons.codec.binary.Base16InputStream(inputStream0, false);
        // The following exception was thrown during execution in test generation
        try {
            String str3 = org.apache.commons.codec.digest.DigestUtils.sha512Hex((java.io.InputStream) base16InputStream2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test126");
        // The following exception was thrown during execution in test generation
        try {
            String str2 = org.apache.commons.codec.digest.Crypt.crypt("SHA3-384", "SHA-512/256");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid salt value: SHA-512/256");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test127");
        java.security.MessageDigest messageDigest1 = org.apache.commons.codec.digest.DigestUtils.getSha512Digest();
        org.apache.commons.codec.digest.DigestUtils digestUtils2 = new org.apache.commons.codec.digest.DigestUtils(messageDigest1);
        java.security.MessageDigest messageDigest3 = digestUtils2.getMessageDigest();
        java.security.MessageDigest messageDigest4 = org.apache.commons.codec.digest.DigestUtils.getDigest("6156665843a7281afec331f09b0ef309", messageDigest3);
        byte[] byteArray7 = org.apache.commons.codec.digest.HmacUtils.hmacSha1("UTF-8", "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        java.security.MessageDigest messageDigest8 = org.apache.commons.codec.digest.DigestUtils.updateDigest(messageDigest3, byteArray7);
        java.io.File file9 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.security.MessageDigest messageDigest10 = org.apache.commons.codec.digest.DigestUtils.updateDigest(messageDigest3, file9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(messageDigest1);
        org.junit.Assert.assertEquals(messageDigest1.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
        org.junit.Assert.assertNotNull(messageDigest3);
        org.junit.Assert.assertEquals(messageDigest3.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
        org.junit.Assert.assertNotNull(messageDigest4);
        org.junit.Assert.assertEquals(messageDigest4.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) -35, (byte) 1, (byte) -117, (byte) -21, (byte) -107, (byte) 125, (byte) 12, (byte) 116, (byte) 37, (byte) -85, (byte) -59, (byte) 12, (byte) 73, (byte) -86, (byte) -37, (byte) -59, (byte) 14, (byte) 0, (byte) -88, (byte) -41 });
        org.junit.Assert.assertNotNull(messageDigest8);
        org.junit.Assert.assertEquals(messageDigest8.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test128");
        CodecPolicy codecPolicy1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.codec.binary.Base16 base16_2 = new org.apache.commons.codec.binary.Base16(false, codecPolicy1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: codecPolicy");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test129");
        org.apache.commons.codec.digest.PureJavaCrc32C pureJavaCrc32C0 = new org.apache.commons.codec.digest.PureJavaCrc32C();
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test130");
        String str0 = org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA3_256;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "SHA3-256" + "'", str0, "SHA3-256");
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test131");
        java.util.BitSet bitSet1 = null;
        byte[] byteArray3 = org.apache.commons.codec.digest.DigestUtils.sha512("$6$hZjG3.XY$6czWvHLhH1l4z3ifyJ31VUlgelUNxpr0dUCBoOq5HGp.GOmJjM2bG/0H0UM/NCwi0uenRBwcDKK3D4E.Dpg5U1");
        boolean boolean4 = org.apache.commons.codec.binary.Base64.isArrayByteBase64(byteArray3);
        byte[] byteArray5 = org.apache.commons.codec.digest.Blake3.hash(byteArray3);
        byte[] byteArray6 = org.apache.commons.codec.net.URLCodec.encodeUrl(bitSet1, byteArray3);
        // The following exception was thrown during execution in test generation
        try {
            javax.crypto.Mac mac7 = org.apache.commons.codec.digest.HmacUtils.getInitializedMac("4568c66f3c2713cef9ee8e6e332561124bbf42cb57c8b9ad08482d36db7d30a3", byteArray3);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: Algorithm 4568c66f3c2713cef9ee8e6e332561124bbf42cb57c8b9ad08482d36db7d30a3 not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertNotNull(byteArray6);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test132");
        byte[] byteArray2 = org.apache.commons.codec.digest.HmacUtils.hmacSha512("ALL", "6704602e4ce5d0029093eef113910bc4c3f653e00e98689ee2d8ee1ed75372d6122faa47319cb8c8b75c80bea32b8c8c5b435d6eaa2c9f1ecd7833b7ae0cb6d4");
        org.junit.Assert.assertNotNull(byteArray2);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test133");
        String str0 = CharEncoding.UTF_16BE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "UTF-16BE" + "'", str0, "UTF-16BE");
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test134");
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.sha512_256("8d2ce87d86f55fcfab770a047b090da23270fa206832dfea7e0c946fff451f819add242374be551b0d6318ed6c7d41d8");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA-512/256 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test135");
        String str2 = org.apache.commons.codec.digest.HmacUtils.hmacSha1Hex("7bT7wvCF8Dme.", "ATF111");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "e5cf9e878a005b35606deb8316c0a11a9ac7b137" + "'", str2, "e5cf9e878a005b35606deb8316c0a11a9ac7b137");
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test136");
        // The following exception was thrown during execution in test generation
        try {
            String str1 = org.apache.commons.codec.digest.DigestUtils.sha3_384Hex("ALL");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA3-384 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test137");
        java.security.MessageDigest messageDigest0 = org.apache.commons.codec.digest.DigestUtils.getSha512Digest();
        org.apache.commons.codec.digest.DigestUtils digestUtils1 = new org.apache.commons.codec.digest.DigestUtils(messageDigest0);
        byte[] byteArray3 = new byte[] { (byte) 1 };
        String str4 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray3);
        String str5 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray3);
        byte[] byteArray6 = org.apache.commons.codec.digest.DigestUtils.md5(byteArray3);
        byte[] byteArray9 = org.apache.commons.codec.binary.Base64.encodeBase64(byteArray6, false, true);
        String str10 = digestUtils1.digestAsHex(byteArray9);
        java.nio.file.Path path11 = null;
        java.nio.file.OpenOption[] openOptionArray12 = new java.nio.file.OpenOption[] {};
        // The following exception was thrown during execution in test generation
        try {
            String str13 = digestUtils1.digestAsHex(path11, openOptionArray12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(messageDigest0);
        org.junit.Assert.assertEquals(messageDigest0.toString(), "SHA-512 Message Digest from SUN, <initialized>\n");
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "AQ==" + "'", str4, "AQ==");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str5, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] { (byte) 85, (byte) -91, (byte) 64, (byte) 8, (byte) -83, (byte) 27, (byte) -91, (byte) -119, (byte) -86, (byte) 33, (byte) 13, (byte) 38, (byte) 41, (byte) -63, (byte) -33, (byte) 65 });
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertArrayEquals(byteArray9, new byte[] { (byte) 86, (byte) 97, (byte) 86, (byte) 65, (byte) 67, (byte) 75, (byte) 48, (byte) 98, (byte) 112, (byte) 89, (byte) 109, (byte) 113, (byte) 73, (byte) 81, (byte) 48, (byte) 109, (byte) 75, (byte) 99, (byte) 72, (byte) 102, (byte) 81, (byte) 81 });
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "6704602e4ce5d0029093eef113910bc4c3f653e00e98689ee2d8ee1ed75372d6122faa47319cb8c8b75c80bea32b8c8c5b435d6eaa2c9f1ecd7833b7ae0cb6d4" + "'", str10, "6704602e4ce5d0029093eef113910bc4c3f653e00e98689ee2d8ee1ed75372d6122faa47319cb8c8b75c80bea32b8c8c5b435d6eaa2c9f1ecd7833b7ae0cb6d4");
        org.junit.Assert.assertNotNull(openOptionArray12);
        org.junit.Assert.assertArrayEquals(openOptionArray12, new java.nio.file.OpenOption[] {});
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test138");
        byte[] byteArray2 = new byte[] { (byte) 1 };
        String str3 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray2);
        String str4 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray2);
        byte[] byteArray5 = org.apache.commons.codec.digest.DigestUtils.md5(byteArray2);
        byte[] byteArray6 = org.apache.commons.codec.digest.DigestUtils.sha(byteArray2);
        // The following exception was thrown during execution in test generation
        try {
            javax.crypto.Mac mac7 = org.apache.commons.codec.digest.HmacUtils.getInitializedMac("UTF-16BE", byteArray6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: Algorithm UTF-16BE not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "AQ==" + "'", str3, "AQ==");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str4, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] { (byte) 85, (byte) -91, (byte) 64, (byte) 8, (byte) -83, (byte) 27, (byte) -91, (byte) -119, (byte) -86, (byte) 33, (byte) 13, (byte) 38, (byte) 41, (byte) -63, (byte) -33, (byte) 65 });
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] { (byte) -65, (byte) -117, (byte) 69, (byte) 48, (byte) -40, (byte) -46, (byte) 70, (byte) -35, (byte) 116, (byte) -84, (byte) 83, (byte) -95, (byte) 52, (byte) 113, (byte) -69, (byte) -95, (byte) 121, (byte) 65, (byte) -33, (byte) -9 });
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test139");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.codec.net.QuotedPrintableCodec quotedPrintableCodec1 = new org.apache.commons.codec.net.QuotedPrintableCodec("b67f94ef55d01fac7818d0819bbd94726b5ad4030715b469f2fb7cf3730c9c0194bd296ec32e37da5d3e36e736f2505d");
            org.junit.Assert.fail("Expected exception of type java.nio.charset.UnsupportedCharsetException; message: b67f94ef55d01fac7818d0819bbd94726b5ad4030715b469f2fb7cf3730c9c0194bd296ec32e37da5d3e36e736f2505d");
        } catch (java.nio.charset.UnsupportedCharsetException e) {
            // Expected exception.
        }
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test140");
        DecoderException decoderException1 = new DecoderException("UTF-8");
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test141");
        java.nio.charset.Charset charset0 = org.apache.commons.codec.binary.Hex.DEFAULT_CHARSET;
        org.junit.Assert.assertNotNull(charset0);
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test142");
        byte[] byteArray6 = new byte[] { (byte) 1, (byte) 100, (byte) 100, (byte) 1, (byte) 0, (byte) 0 };
        String str7 = org.apache.commons.codec.binary.StringUtils.newStringIso8859_1(byteArray6);
        String str8 = org.apache.commons.codec.digest.DigestUtils.sha256Hex(byteArray6);
        byte[] byteArray9 = org.apache.commons.codec.binary.Base64.decodeBase64(byteArray6);
        byte[] byteArray12 = org.apache.commons.codec.digest.HmacUtils.hmacSha1("UTF-8", "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        byte[] byteArray13 = org.apache.commons.codec.digest.HmacUtils.hmacMd5(byteArray6, byteArray12);
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] { (byte) 1, (byte) 100, (byte) 100, (byte) 1, (byte) 0, (byte) 0 });
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "\001dd\001\000\000" + "'", str7, "\001dd\001\000\000");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "4568c66f3c2713cef9ee8e6e332561124bbf42cb57c8b9ad08482d36db7d30a3" + "'", str8, "4568c66f3c2713cef9ee8e6e332561124bbf42cb57c8b9ad08482d36db7d30a3");
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertArrayEquals(byteArray9, new byte[] { (byte) 117 });
        org.junit.Assert.assertNotNull(byteArray12);
        org.junit.Assert.assertArrayEquals(byteArray12, new byte[] { (byte) -35, (byte) 1, (byte) -117, (byte) -21, (byte) -107, (byte) 125, (byte) 12, (byte) 116, (byte) 37, (byte) -85, (byte) -59, (byte) 12, (byte) 73, (byte) -86, (byte) -37, (byte) -59, (byte) 14, (byte) 0, (byte) -88, (byte) -41 });
        org.junit.Assert.assertNotNull(byteArray13);
        org.junit.Assert.assertArrayEquals(byteArray13, new byte[] { (byte) -95, (byte) 18, (byte) -89, (byte) 104, (byte) -6, (byte) -110, (byte) -15, (byte) 10, (byte) -110, (byte) -65, (byte) -124, (byte) 95, (byte) -20, (byte) 47, (byte) 45, (byte) -38 });
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test143");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.codec.net.QCodec qCodec1 = new org.apache.commons.codec.net.QCodec("6156665843a7281afec331f09b0ef309");
            org.junit.Assert.fail("Expected exception of type java.nio.charset.UnsupportedCharsetException; message: 6156665843a7281afec331f09b0ef309");
        } catch (java.nio.charset.UnsupportedCharsetException e) {
            // Expected exception.
        }
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test144");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.codec.digest.DigestUtils digestUtils1 = new org.apache.commons.codec.digest.DigestUtils("any");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: any MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test145");
        java.security.MessageDigest messageDigest1 = org.apache.commons.codec.digest.DigestUtils.getSha512Digest();
        java.security.MessageDigest messageDigest2 = org.apache.commons.codec.digest.DigestUtils.getDigest("ATF111", messageDigest1);
        java.nio.file.Path path3 = null;
        java.nio.file.OpenOption[] openOptionArray4 = new java.nio.file.OpenOption[] {};
        // The following exception was thrown during execution in test generation
        try {
            java.security.MessageDigest messageDigest5 = org.apache.commons.codec.digest.DigestUtils.updateDigest(messageDigest2, path3, openOptionArray4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(messageDigest1);
        org.junit.Assert.assertEquals(messageDigest1.toString(), "SHA-512 Message Digest from SUN, <initialized>\n");
        org.junit.Assert.assertNotNull(messageDigest2);
        org.junit.Assert.assertEquals(messageDigest2.toString(), "SHA-512 Message Digest from SUN, <initialized>\n");
        org.junit.Assert.assertNotNull(openOptionArray4);
        org.junit.Assert.assertArrayEquals(openOptionArray4, new java.nio.file.OpenOption[] {});
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test146");
        DecoderException decoderException2 = new DecoderException("AQ==");
        EncoderException encoderException3 = new EncoderException("4568c66f3c2713cef9ee8e6e332561124bbf42cb57c8b9ad08482d36db7d30a3", (Throwable) decoderException2);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test147");
        byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.sha("b67f94ef55d01fac7818d0819bbd94726b5ad4030715b469f2fb7cf3730c9c0194bd296ec32e37da5d3e36e736f2505d");
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) -7, (byte) -49, (byte) 122, (byte) 120, (byte) 84, (byte) -57, (byte) -7, (byte) -34, (byte) -2, (byte) 80, (byte) -26, (byte) -13, (byte) -101, (byte) 59, (byte) -14, (byte) 75, (byte) -123, (byte) 51, (byte) 58, (byte) 52 });
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test148");
        java.io.InputStream inputStream0 = null;
        // The following exception was thrown during execution in test generation
        try {
            String str1 = org.apache.commons.codec.digest.DigestUtils.shaHex(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test149");
        java.security.MessageDigest messageDigest0 = org.apache.commons.codec.digest.DigestUtils.getSha512Digest();
        org.apache.commons.codec.digest.DigestUtils digestUtils1 = new org.apache.commons.codec.digest.DigestUtils(messageDigest0);
        java.security.MessageDigest messageDigest2 = digestUtils1.getMessageDigest();
        java.io.File file3 = null;
        // The following exception was thrown during execution in test generation
        try {
            String str4 = digestUtils1.digestAsHex(file3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(messageDigest0);
        org.junit.Assert.assertEquals(messageDigest0.toString(), "SHA-512 Message Digest from SUN, <initialized>\n");
        org.junit.Assert.assertNotNull(messageDigest2);
        org.junit.Assert.assertEquals(messageDigest2.toString(), "SHA-512 Message Digest from SUN, <initialized>\n");
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test150");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream2 = new org.apache.commons.codec.binary.Base16InputStream(inputStream0, false);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray3 = org.apache.commons.codec.digest.DigestUtils.sha512_256(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA-512/256 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test151");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.codec.binary.Base16OutputStream base16OutputStream1 = new org.apache.commons.codec.binary.Base16OutputStream(outputStream0);
        org.apache.commons.codec.binary.Base16OutputStream base16OutputStream4 = new org.apache.commons.codec.binary.Base16OutputStream((java.io.OutputStream) base16OutputStream1, true, false);
        org.apache.commons.codec.binary.Base16OutputStream base16OutputStream7 = new org.apache.commons.codec.binary.Base16OutputStream((java.io.OutputStream) base16OutputStream4, true, true);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test152");
        org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet1 = null;
        org.apache.commons.codec.language.bm.Rule.Phoneme phoneme2 = new org.apache.commons.codec.language.bm.Rule.Phoneme((CharSequence) "AQ==", languageSet1);
        org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet3 = phoneme2.getLanguages();
        CharSequence charSequence4 = phoneme2.getPhonemeText();
        org.junit.Assert.assertNull(languageSet3);
        org.junit.Assert.assertNotNull(charSequence4);
        org.junit.Assert.assertEquals(charSequence4.toString(), "AQ==");
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test153");
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray2 = org.apache.commons.codec.digest.HmacUtils.hmacSha256("", "5d6b9f2777904dd857816b4c8ac77926");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Empty key");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test154");
        org.apache.commons.codec.language.Nysiis nysiis0 = new org.apache.commons.codec.language.Nysiis();
        String str2 = nysiis0.encode("2oBllIQFOdgyw");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "OBLAGF" + "'", str2, "OBLAGF");
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test155");
        byte[] byteArray0 = null;
        java.io.InputStream inputStream1 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream3 = new org.apache.commons.codec.binary.Base16InputStream(inputStream1, false);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray4 = org.apache.commons.codec.digest.HmacUtils.hmacMd5(byteArray0, inputStream1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Null key");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test156");
        String str0 = CharEncoding.UTF_8;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "UTF-8" + "'", str0, "UTF-8");
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test157");
        byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.sha512("$6$hZjG3.XY$6czWvHLhH1l4z3ifyJ31VUlgelUNxpr0dUCBoOq5HGp.GOmJjM2bG/0H0UM/NCwi0uenRBwcDKK3D4E.Dpg5U1");
        boolean boolean2 = org.apache.commons.codec.binary.Base64.isArrayByteBase64(byteArray1);
        byte[] byteArray3 = org.apache.commons.codec.digest.Blake3.hash(byteArray1);
        java.io.InputStream inputStream4 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream6 = new org.apache.commons.codec.binary.Base16InputStream(inputStream4, false);
        org.apache.commons.codec.binary.Base32InputStream base32InputStream7 = new org.apache.commons.codec.binary.Base32InputStream(inputStream4);
        // The following exception was thrown during execution in test generation
        try {
            String str8 = org.apache.commons.codec.digest.HmacUtils.hmacSha256Hex(byteArray1, (java.io.InputStream) base32InputStream7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(byteArray3);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test158");
        org.apache.commons.codec.net.QuotedPrintableCodec quotedPrintableCodec0 = new org.apache.commons.codec.net.QuotedPrintableCodec();
        org.apache.commons.codec.binary.Hex hex1 = new org.apache.commons.codec.binary.Hex();
        java.nio.ByteBuffer byteBuffer3 = org.apache.commons.codec.binary.StringUtils.getByteBufferUtf8("SHA-224");
        byte[] byteArray4 = hex1.encode(byteBuffer3);
        byte[] byteArray5 = quotedPrintableCodec0.encode(byteArray4);
        java.nio.charset.Charset charset7 = Charsets.UTF_8;
        String str8 = quotedPrintableCodec0.encode("UTF-8", charset7);
        org.apache.commons.codec.binary.Base16 base16_9 = new org.apache.commons.codec.binary.Base16();
        boolean boolean11 = base16_9.isInAlphabet((byte) 0);
        byte[] byteArray13 = new byte[] { (byte) 1 };
        String str14 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray13);
        String str15 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray13);
        byte[] byteArray16 = org.apache.commons.codec.digest.DigestUtils.md5(byteArray13);
        byte[] byteArray19 = org.apache.commons.codec.binary.Base64.encodeBase64(byteArray16, false, true);
        long long20 = base16_9.getEncodedLength(byteArray19);
        byte[] byteArray21 = quotedPrintableCodec0.encode(byteArray19);
        org.junit.Assert.assertNotNull(byteBuffer3);
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 53, (byte) 51, (byte) 52, (byte) 56, (byte) 52, (byte) 49, (byte) 50, (byte) 100, (byte) 51, (byte) 50, (byte) 51, (byte) 50, (byte) 51, (byte) 52 });
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] { (byte) 53, (byte) 51, (byte) 52, (byte) 56, (byte) 52, (byte) 49, (byte) 50, (byte) 100, (byte) 51, (byte) 50, (byte) 51, (byte) 50, (byte) 51, (byte) 52 });
        org.junit.Assert.assertNotNull(charset7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "UTF-8" + "'", str8, "UTF-8");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(byteArray13);
        org.junit.Assert.assertArrayEquals(byteArray13, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "AQ==" + "'", str14, "AQ==");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str15, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertNotNull(byteArray16);
        org.junit.Assert.assertArrayEquals(byteArray16, new byte[] { (byte) 85, (byte) -91, (byte) 64, (byte) 8, (byte) -83, (byte) 27, (byte) -91, (byte) -119, (byte) -86, (byte) 33, (byte) 13, (byte) 38, (byte) 41, (byte) -63, (byte) -33, (byte) 65 });
        org.junit.Assert.assertNotNull(byteArray19);
        org.junit.Assert.assertArrayEquals(byteArray19, new byte[] { (byte) 86, (byte) 97, (byte) 86, (byte) 65, (byte) 67, (byte) 75, (byte) 48, (byte) 98, (byte) 112, (byte) 89, (byte) 109, (byte) 113, (byte) 73, (byte) 81, (byte) 48, (byte) 109, (byte) 75, (byte) 99, (byte) 72, (byte) 102, (byte) 81, (byte) 81 });
        org.junit.Assert.assertTrue("'" + long20 + "' != '" + 44L + "'", long20 == 44L);
        org.junit.Assert.assertNotNull(byteArray21);
        org.junit.Assert.assertArrayEquals(byteArray21, new byte[] { (byte) 86, (byte) 97, (byte) 86, (byte) 65, (byte) 67, (byte) 75, (byte) 48, (byte) 98, (byte) 112, (byte) 89, (byte) 109, (byte) 113, (byte) 73, (byte) 81, (byte) 48, (byte) 109, (byte) 75, (byte) 99, (byte) 72, (byte) 102, (byte) 81, (byte) 81 });
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test159");
        java.security.MessageDigest messageDigest1 = org.apache.commons.codec.digest.DigestUtils.getSha512Digest();
        java.security.MessageDigest messageDigest2 = org.apache.commons.codec.digest.DigestUtils.getDigest("ATF111", messageDigest1);
        java.nio.file.Path path3 = null;
        java.nio.file.OpenOption openOption4 = null;
        java.nio.file.OpenOption[] openOptionArray5 = new java.nio.file.OpenOption[] { openOption4 };
        // The following exception was thrown during execution in test generation
        try {
            java.security.MessageDigest messageDigest6 = org.apache.commons.codec.digest.DigestUtils.updateDigest(messageDigest2, path3, openOptionArray5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(messageDigest1);
        org.junit.Assert.assertEquals(messageDigest1.toString(), "SHA-512 Message Digest from SUN, <initialized>\n");
        org.junit.Assert.assertNotNull(messageDigest2);
        org.junit.Assert.assertEquals(messageDigest2.toString(), "SHA-512 Message Digest from SUN, <initialized>\n");
        org.junit.Assert.assertNotNull(openOptionArray5);
        org.junit.Assert.assertArrayEquals(openOptionArray5, new java.nio.file.OpenOption[] { null });
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test160");
        byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.sha384("b67f94ef55d01fac7818d0819bbd94726b5ad4030715b469f2fb7cf3730c9c0194bd296ec32e37da5d3e36e736f2505d");
        char[] charArray2 = org.apache.commons.codec.binary.Hex.encodeHex(byteArray1);
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertNotNull(charArray2);
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test161");
        org.apache.commons.codec.language.RefinedSoundex refinedSoundex0 = new org.apache.commons.codec.language.RefinedSoundex();
        String str2 = refinedSoundex0.encode("6156665843a7281afec331f09b0ef309");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "A02032102" + "'", str2, "A02032102");
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test162");
        org.apache.commons.codec.binary.Base32 base32_1 = new org.apache.commons.codec.binary.Base32((byte) 1);
        boolean boolean3 = base32_1.isInAlphabet((byte) 1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test163");
        org.apache.commons.codec.binary.Base16 base16_1 = new org.apache.commons.codec.binary.Base16(true);
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test164");
        byte[] byteArray1 = new byte[] { (byte) 1 };
        String str2 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray1);
        String str3 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray1);
        byte[] byteArray4 = org.apache.commons.codec.digest.DigestUtils.md5(byteArray1);
        byte[] byteArray7 = org.apache.commons.codec.binary.Base64.encodeBase64(byteArray4, false, true);
        byte[] byteArray9 = new byte[] { (byte) 10 };
        byte[] byteArray10 = org.apache.commons.codec.digest.HmacUtils.hmacSha512(byteArray4, byteArray9);
        // The following exception was thrown during execution in test generation
        try {
            String str11 = org.apache.commons.codec.digest.DigestUtils.sha3_224Hex(byteArray4);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA3-224 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "AQ==" + "'", str2, "AQ==");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str3, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 85, (byte) -91, (byte) 64, (byte) 8, (byte) -83, (byte) 27, (byte) -91, (byte) -119, (byte) -86, (byte) 33, (byte) 13, (byte) 38, (byte) 41, (byte) -63, (byte) -33, (byte) 65 });
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) 86, (byte) 97, (byte) 86, (byte) 65, (byte) 67, (byte) 75, (byte) 48, (byte) 98, (byte) 112, (byte) 89, (byte) 109, (byte) 113, (byte) 73, (byte) 81, (byte) 48, (byte) 109, (byte) 75, (byte) 99, (byte) 72, (byte) 102, (byte) 81, (byte) 81 });
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertArrayEquals(byteArray9, new byte[] { (byte) 10 });
        org.junit.Assert.assertNotNull(byteArray10);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test165");
        String str1 = org.apache.commons.codec.digest.DigestUtils.md2Hex("UTF-16BE");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "70c71b39441c754af801c76be7cce8a2" + "'", str1, "70c71b39441c754af801c76be7cce8a2");
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test166");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.codec.binary.Base16OutputStream base16OutputStream1 = new org.apache.commons.codec.binary.Base16OutputStream(outputStream0);
        boolean boolean2 = base16OutputStream1.isStrictDecoding();
        org.apache.commons.codec.binary.Base32OutputStream base32OutputStream3 = new org.apache.commons.codec.binary.Base32OutputStream((java.io.OutputStream) base16OutputStream1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test167");
        org.apache.commons.codec.net.QuotedPrintableCodec quotedPrintableCodec0 = new org.apache.commons.codec.net.QuotedPrintableCodec();
        org.apache.commons.codec.binary.Hex hex1 = new org.apache.commons.codec.binary.Hex();
        java.nio.ByteBuffer byteBuffer3 = org.apache.commons.codec.binary.StringUtils.getByteBufferUtf8("SHA-224");
        byte[] byteArray4 = hex1.encode(byteBuffer3);
        byte[] byteArray5 = quotedPrintableCodec0.encode(byteArray4);
        java.nio.charset.Charset charset7 = Charsets.UTF_8;
        String str8 = quotedPrintableCodec0.encode("UTF-8", charset7);
        org.apache.commons.codec.net.QuotedPrintableCodec quotedPrintableCodec9 = new org.apache.commons.codec.net.QuotedPrintableCodec(charset7);
        org.apache.commons.codec.binary.Hex hex10 = new org.apache.commons.codec.binary.Hex(charset7);
        byte[] byteArray17 = new byte[] { (byte) 1, (byte) 100, (byte) 100, (byte) 1, (byte) 0, (byte) 0 };
        String str18 = org.apache.commons.codec.binary.StringUtils.newStringIso8859_1(byteArray17);
        String str19 = org.apache.commons.codec.digest.DigestUtils.sha256Hex(byteArray17);
        byte[] byteArray20 = hex10.encode(byteArray17);
        org.junit.Assert.assertNotNull(byteBuffer3);
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 53, (byte) 51, (byte) 52, (byte) 56, (byte) 52, (byte) 49, (byte) 50, (byte) 100, (byte) 51, (byte) 50, (byte) 51, (byte) 50, (byte) 51, (byte) 52 });
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] { (byte) 53, (byte) 51, (byte) 52, (byte) 56, (byte) 52, (byte) 49, (byte) 50, (byte) 100, (byte) 51, (byte) 50, (byte) 51, (byte) 50, (byte) 51, (byte) 52 });
        org.junit.Assert.assertNotNull(charset7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "UTF-8" + "'", str8, "UTF-8");
        org.junit.Assert.assertNotNull(byteArray17);
        org.junit.Assert.assertArrayEquals(byteArray17, new byte[] { (byte) 1, (byte) 100, (byte) 100, (byte) 1, (byte) 0, (byte) 0 });
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "\001dd\001\000\000" + "'", str18, "\001dd\001\000\000");
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "4568c66f3c2713cef9ee8e6e332561124bbf42cb57c8b9ad08482d36db7d30a3" + "'", str19, "4568c66f3c2713cef9ee8e6e332561124bbf42cb57c8b9ad08482d36db7d30a3");
        org.junit.Assert.assertNotNull(byteArray20);
        org.junit.Assert.assertArrayEquals(byteArray20, new byte[] { (byte) 48, (byte) 49, (byte) 54, (byte) 52, (byte) 54, (byte) 52, (byte) 48, (byte) 49, (byte) 48, (byte) 48, (byte) 48, (byte) 48 });
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test168");
        byte[] byteArray2 = new byte[] { (byte) 1 };
        String str3 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray2);
        String str4 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray2);
        byte[] byteArray5 = org.apache.commons.codec.digest.DigestUtils.md5(byteArray2);
        byte[] byteArray6 = org.apache.commons.codec.digest.DigestUtils.sha(byteArray2);
        org.apache.commons.codec.binary.Base64 base64_8 = new org.apache.commons.codec.binary.Base64(2131247126, byteArray2, true);
        byte[] byteArray11 = org.apache.commons.codec.binary.Base64.encodeBase64(byteArray2, false, true);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "AQ==" + "'", str3, "AQ==");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str4, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] { (byte) 85, (byte) -91, (byte) 64, (byte) 8, (byte) -83, (byte) 27, (byte) -91, (byte) -119, (byte) -86, (byte) 33, (byte) 13, (byte) 38, (byte) 41, (byte) -63, (byte) -33, (byte) 65 });
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] { (byte) -65, (byte) -117, (byte) 69, (byte) 48, (byte) -40, (byte) -46, (byte) 70, (byte) -35, (byte) 116, (byte) -84, (byte) 83, (byte) -95, (byte) 52, (byte) 113, (byte) -69, (byte) -95, (byte) 121, (byte) 65, (byte) -33, (byte) -9 });
        org.junit.Assert.assertNotNull(byteArray11);
        org.junit.Assert.assertArrayEquals(byteArray11, new byte[] { (byte) 65, (byte) 81 });
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test169");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.codec.binary.Base16OutputStream base16OutputStream1 = new org.apache.commons.codec.binary.Base16OutputStream(outputStream0);
        boolean boolean2 = base16OutputStream1.isStrictDecoding();
        org.apache.commons.codec.binary.Base64OutputStream base64OutputStream3 = new org.apache.commons.codec.binary.Base64OutputStream((java.io.OutputStream) base16OutputStream1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test170");
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray2 = org.apache.commons.codec.binary.StringUtils.getBytesUnchecked("", "\001dd\001\000\000");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: ?dd???: java.io.UnsupportedEncodingException: ?dd???");
        } catch (IllegalStateException e) {
            // Expected exception.
        }
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test171");
        // The following exception was thrown during execution in test generation
        try {
            java.security.MessageDigest messageDigest0 = org.apache.commons.codec.digest.DigestUtils.getSha512_256Digest();
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA-512/256 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test172");
        String str0 = org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA_384;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "SHA-384" + "'", str0, "SHA-384");
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test173");
        byte[] byteArray0 = null;
        // The following exception was thrown during execution in test generation
        try {
            String str3 = org.apache.commons.codec.digest.Md5Crypt.md5Crypt(byteArray0, "10uoEQ/ivapr6", "UTF-16BE");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test174");
        byte[] byteArray2 = new byte[] { (byte) 1 };
        String str3 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray2);
        String str4 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray2);
        byte[] byteArray5 = org.apache.commons.codec.digest.DigestUtils.md5(byteArray2);
        byte[] byteArray6 = org.apache.commons.codec.digest.DigestUtils.sha(byteArray2);
        org.apache.commons.codec.binary.Base64 base64_8 = new org.apache.commons.codec.binary.Base64(2131247126, byteArray2, true);
        byte[] byteArray10 = org.apache.commons.codec.digest.DigestUtils.sha512("$6$hZjG3.XY$6czWvHLhH1l4z3ifyJ31VUlgelUNxpr0dUCBoOq5HGp.GOmJjM2bG/0H0UM/NCwi0uenRBwcDKK3D4E.Dpg5U1");
        boolean boolean11 = org.apache.commons.codec.binary.Base64.isArrayByteBase64(byteArray10);
        byte[] byteArray12 = org.apache.commons.codec.digest.Blake3.hash(byteArray10);
        String str13 = base64_8.encodeAsString(byteArray12);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "AQ==" + "'", str3, "AQ==");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str4, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] { (byte) 85, (byte) -91, (byte) 64, (byte) 8, (byte) -83, (byte) 27, (byte) -91, (byte) -119, (byte) -86, (byte) 33, (byte) 13, (byte) 38, (byte) 41, (byte) -63, (byte) -33, (byte) 65 });
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] { (byte) -65, (byte) -117, (byte) 69, (byte) 48, (byte) -40, (byte) -46, (byte) 70, (byte) -35, (byte) 116, (byte) -84, (byte) 83, (byte) -95, (byte) 52, (byte) 113, (byte) -69, (byte) -95, (byte) 121, (byte) 65, (byte) -33, (byte) -9 });
        org.junit.Assert.assertNotNull(byteArray10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(byteArray12);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "m5tAaqa5gqTgVMgS9gYO5lTM-nn87eIpYff1BTawjno\001" + "'", str13, "m5tAaqa5gqTgVMgS9gYO5lTM-nn87eIpYff1BTawjno\001");
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test175");
        java.security.MessageDigest messageDigest0 = org.apache.commons.codec.digest.DigestUtils.getSha512Digest();
        org.apache.commons.codec.digest.DigestUtils digestUtils1 = new org.apache.commons.codec.digest.DigestUtils(messageDigest0);
        java.nio.file.Path path2 = null;
        java.nio.file.OpenOption openOption3 = null;
        java.nio.file.OpenOption[] openOptionArray4 = new java.nio.file.OpenOption[] { openOption3 };
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray5 = digestUtils1.digest(path2, openOptionArray4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(messageDigest0);
        org.junit.Assert.assertEquals(messageDigest0.toString(), "SHA-512 Message Digest from SUN, <initialized>\n");
        org.junit.Assert.assertNotNull(openOptionArray4);
        org.junit.Assert.assertArrayEquals(openOptionArray4, new java.nio.file.OpenOption[] { null });
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test176");
        org.apache.commons.codec.binary.Base32.Builder builder0 = new org.apache.commons.codec.binary.Base32.Builder();
        byte[] byteArray2 = org.apache.commons.codec.digest.DigestUtils.sha512("$6$hZjG3.XY$6czWvHLhH1l4z3ifyJ31VUlgelUNxpr0dUCBoOq5HGp.GOmJjM2bG/0H0UM/NCwi0uenRBwcDKK3D4E.Dpg5U1");
        boolean boolean3 = org.apache.commons.codec.binary.Base64.isArrayByteBase64(byteArray2);
        byte[] byteArray4 = org.apache.commons.codec.digest.Blake3.hash(byteArray2);
        org.apache.commons.codec.binary.Base32.Builder builder5 = builder0.setEncodeTable(byteArray4);
        org.apache.commons.codec.binary.Base32.Builder builder7 = builder0.setLineLength((int) (byte) 0);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertNotNull(builder5);
        org.junit.Assert.assertNotNull(builder7);
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test177");
        byte[] byteArray1 = new byte[] { (byte) 1 };
        String str2 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray1);
        String str3 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray1);
        byte[] byteArray4 = org.apache.commons.codec.digest.DigestUtils.md5(byteArray1);
        byte[] byteArray5 = org.apache.commons.codec.binary.Base64.encodeBase64URLSafe(byteArray4);
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "AQ==" + "'", str2, "AQ==");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str3, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 85, (byte) -91, (byte) 64, (byte) 8, (byte) -83, (byte) 27, (byte) -91, (byte) -119, (byte) -86, (byte) 33, (byte) 13, (byte) 38, (byte) 41, (byte) -63, (byte) -33, (byte) 65 });
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] { (byte) 86, (byte) 97, (byte) 86, (byte) 65, (byte) 67, (byte) 75, (byte) 48, (byte) 98, (byte) 112, (byte) 89, (byte) 109, (byte) 113, (byte) 73, (byte) 81, (byte) 48, (byte) 109, (byte) 75, (byte) 99, (byte) 72, (byte) 102, (byte) 81, (byte) 81 });
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test178");
        String str1 = org.apache.commons.codec.digest.DigestUtils.sha256Hex("AQ==");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "5d4dc0ce1ab5d104c7c4955c96c58ec59e96b53fba686c1f4a45a008022366cf" + "'", str1, "5d4dc0ce1ab5d104c7c4955c96c58ec59e96b53fba686c1f4a45a008022366cf");
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test179");
        byte[] byteArray0 = null;
        String str1 = org.apache.commons.codec.binary.Base64.encodeBase64URLSafeString(byteArray0);
        org.junit.Assert.assertNull(str1);
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test180");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.codec.digest.DigestUtils digestUtils1 = new org.apache.commons.codec.digest.DigestUtils("b67f94ef55d01fac7818d0819bbd94726b5ad4030715b469f2fb7cf3730c9c0194bd296ec32e37da5d3e36e736f2505d");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: b67f94ef55d01fac7818d0819bbd94726b5ad4030715b469f2fb7cf3730c9c0194bd296ec32e37da5d3e36e736f2505d MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test181");
        byte[] byteArray0 = null;
        byte[] byteArray7 = new byte[] { (byte) -1, (byte) 100, (byte) 10, (byte) 10, (byte) -1, (byte) 100 };
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray8 = org.apache.commons.codec.digest.Blake3.keyedHash(byteArray0, byteArray7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) -1, (byte) 100, (byte) 10, (byte) 10, (byte) -1, (byte) 100 });
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test182");
        org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet0 = org.apache.commons.codec.language.bm.Languages.ANY_LANGUAGE;
        boolean boolean2 = languageSet0.contains("7bT7wvCF8Dme.");
        org.junit.Assert.assertNotNull(languageSet0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test183");
        org.apache.commons.codec.net.QuotedPrintableCodec quotedPrintableCodec0 = new org.apache.commons.codec.net.QuotedPrintableCodec();
        java.nio.charset.Charset charset1 = quotedPrintableCodec0.getCharset();
        java.nio.charset.Charset charset2 = quotedPrintableCodec0.getCharset();
        // The following exception was thrown during execution in test generation
        try {
            String str5 = quotedPrintableCodec0.decode("\001dd\001\000\000", "m5tAaqa5gqTgVMgS9gYO5lTM-nn87eIpYff1BTawjno\001");
            org.junit.Assert.fail("Expected exception of type java.io.UnsupportedEncodingException; message: m5tAaqa5gqTgVMgS9gYO5lTM-nn87eIpYff1BTawjno?");
        } catch (java.io.UnsupportedEncodingException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(charset1);
        org.junit.Assert.assertNotNull(charset2);
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test184");
        int int1 = org.apache.commons.codec.digest.MurmurHash3.hash32("UTF-16BE");
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + (-1490547516) + "'", int1 == (-1490547516));
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test185");
        java.security.MessageDigest messageDigest1 = org.apache.commons.codec.digest.DigestUtils.getSha512Digest();
        org.apache.commons.codec.digest.DigestUtils digestUtils2 = new org.apache.commons.codec.digest.DigestUtils(messageDigest1);
        java.security.MessageDigest messageDigest3 = digestUtils2.getMessageDigest();
        java.security.MessageDigest messageDigest4 = org.apache.commons.codec.digest.DigestUtils.getDigest("6156665843a7281afec331f09b0ef309", messageDigest3);
        java.io.InputStream inputStream5 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream7 = new org.apache.commons.codec.binary.Base16InputStream(inputStream5, false);
        org.apache.commons.codec.binary.Base32InputStream base32InputStream8 = new org.apache.commons.codec.binary.Base32InputStream(inputStream5);
        boolean boolean9 = base32InputStream8.markSupported();
        // The following exception was thrown during execution in test generation
        try {
            java.security.MessageDigest messageDigest10 = org.apache.commons.codec.digest.DigestUtils.updateDigest(messageDigest3, (java.io.InputStream) base32InputStream8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(messageDigest1);
        org.junit.Assert.assertEquals(messageDigest1.toString(), "SHA-512 Message Digest from SUN, <initialized>\n");
        org.junit.Assert.assertNotNull(messageDigest3);
        org.junit.Assert.assertEquals(messageDigest3.toString(), "SHA-512 Message Digest from SUN, <initialized>\n");
        org.junit.Assert.assertNotNull(messageDigest4);
        org.junit.Assert.assertEquals(messageDigest4.toString(), "SHA-512 Message Digest from SUN, <initialized>\n");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test186");
        int int2 = org.apache.commons.codec.digest.MurmurHash3.hash32(100L, (long) 0);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 629192958 + "'", int2 == 629192958);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test187");
        org.apache.commons.codec.language.bm.Rule.PhonemeExpr phonemeExpr3 = null;
        org.apache.commons.codec.language.bm.Rule rule4 = new org.apache.commons.codec.language.bm.Rule("e5cf9e878a005b35606deb8316c0a11a9ac7b137", "", "OBLAGF", phonemeExpr3);
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test188");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream2 = new org.apache.commons.codec.binary.Base16InputStream(inputStream0, false);
        byte[] byteArray11 = new byte[] { (byte) 1, (byte) 100, (byte) 100, (byte) 1, (byte) 0, (byte) 0 };
        String str12 = org.apache.commons.codec.binary.StringUtils.newStringIso8859_1(byteArray11);
        String str13 = org.apache.commons.codec.digest.DigestUtils.sha256Hex(byteArray11);
        byte[] byteArray14 = org.apache.commons.codec.binary.Base64.decodeBase64(byteArray11);
        CodecPolicy codecPolicy15 = CodecPolicy.LENIENT;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.codec.binary.Base64InputStream base64InputStream16 = new org.apache.commons.codec.binary.Base64InputStream(inputStream0, false, 104729, byteArray11, codecPolicy15);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: lineSeparator must not contain base64 characters: [?dd???]");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray11);
        org.junit.Assert.assertArrayEquals(byteArray11, new byte[] { (byte) 1, (byte) 100, (byte) 100, (byte) 1, (byte) 0, (byte) 0 });
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "\001dd\001\000\000" + "'", str12, "\001dd\001\000\000");
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "4568c66f3c2713cef9ee8e6e332561124bbf42cb57c8b9ad08482d36db7d30a3" + "'", str13, "4568c66f3c2713cef9ee8e6e332561124bbf42cb57c8b9ad08482d36db7d30a3");
        org.junit.Assert.assertNotNull(byteArray14);
        org.junit.Assert.assertArrayEquals(byteArray14, new byte[] { (byte) 117 });
        org.junit.Assert.assertTrue("'" + codecPolicy15 + "' != '" + CodecPolicy.LENIENT + "'", codecPolicy15.equals(CodecPolicy.LENIENT));
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test189");
        org.apache.commons.codec.digest.XXHash32 xXHash32_1 = new org.apache.commons.codec.digest.XXHash32(100);
        long long2 = xXHash32_1.getValue();
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 1272799861L + "'", long2 == 1272799861L);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test190");
        byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.sha512("$6$hZjG3.XY$6czWvHLhH1l4z3ifyJ31VUlgelUNxpr0dUCBoOq5HGp.GOmJjM2bG/0H0UM/NCwi0uenRBwcDKK3D4E.Dpg5U1");
        boolean boolean2 = org.apache.commons.codec.binary.Base64.isArrayByteBase64(byteArray1);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray3 = org.apache.commons.codec.digest.DigestUtils.sha3_224(byteArray1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA3-224 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test191");
        org.apache.commons.codec.binary.Base64 base64_1 = new org.apache.commons.codec.binary.Base64(0);
        byte[] byteArray3 = new byte[] { (byte) 1 };
        String str4 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray3);
        boolean boolean6 = base64_1.isInAlphabet(byteArray3, false);
        byte[] byteArray8 = new byte[] { (byte) 1 };
        String str9 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray8);
        String str10 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray8);
        String str11 = org.apache.commons.codec.digest.DigestUtils.sha384Hex(byteArray8);
        byte[] byteArray12 = base64_1.encode(byteArray8);
        boolean boolean13 = base64_1.isUrlSafe();
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "AQ==" + "'", str4, "AQ==");
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(byteArray8);
        org.junit.Assert.assertArrayEquals(byteArray8, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "AQ==" + "'", str9, "AQ==");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str10, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "8d2ce87d86f55fcfab770a047b090da23270fa206832dfea7e0c946fff451f819add242374be551b0d6318ed6c7d41d8" + "'", str11, "8d2ce87d86f55fcfab770a047b090da23270fa206832dfea7e0c946fff451f819add242374be551b0d6318ed6c7d41d8");
        org.junit.Assert.assertNotNull(byteArray12);
        org.junit.Assert.assertArrayEquals(byteArray12, new byte[] { (byte) 65, (byte) 81, (byte) 61, (byte) 61 });
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test192");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.codec.net.BCodec bCodec1 = new org.apache.commons.codec.net.BCodec("SHA-512/256");
            org.junit.Assert.fail("Expected exception of type java.nio.charset.IllegalCharsetNameException; message: SHA-512/256");
        } catch (java.nio.charset.IllegalCharsetNameException e) {
            // Expected exception.
        }
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test193");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream2 = new org.apache.commons.codec.binary.Base16InputStream(inputStream0, false);
        java.security.MessageDigest messageDigest6 = org.apache.commons.codec.digest.DigestUtils.getSha512Digest();
        org.apache.commons.codec.digest.DigestUtils digestUtils7 = new org.apache.commons.codec.digest.DigestUtils(messageDigest6);
        java.security.MessageDigest messageDigest8 = digestUtils7.getMessageDigest();
        java.security.MessageDigest messageDigest9 = org.apache.commons.codec.digest.DigestUtils.getDigest("6156665843a7281afec331f09b0ef309", messageDigest8);
        byte[] byteArray12 = org.apache.commons.codec.digest.HmacUtils.hmacSha1("UTF-8", "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        java.security.MessageDigest messageDigest13 = org.apache.commons.codec.digest.DigestUtils.updateDigest(messageDigest8, byteArray12);
        CodecPolicy codecPolicy14 = CodecPolicy.LENIENT;
        org.apache.commons.codec.binary.Base32InputStream base32InputStream15 = new org.apache.commons.codec.binary.Base32InputStream(inputStream0, false, 0, byteArray12, codecPolicy14);
        // The following exception was thrown during execution in test generation
        try {
            String str16 = org.apache.commons.codec.digest.DigestUtils.sha3_512Hex((java.io.InputStream) base32InputStream15);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA3-512 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(messageDigest6);
        org.junit.Assert.assertEquals(messageDigest6.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
        org.junit.Assert.assertNotNull(messageDigest8);
        org.junit.Assert.assertEquals(messageDigest8.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
        org.junit.Assert.assertNotNull(messageDigest9);
        org.junit.Assert.assertEquals(messageDigest9.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
        org.junit.Assert.assertNotNull(byteArray12);
        org.junit.Assert.assertArrayEquals(byteArray12, new byte[] { (byte) -35, (byte) 1, (byte) -117, (byte) -21, (byte) -107, (byte) 125, (byte) 12, (byte) 116, (byte) 37, (byte) -85, (byte) -59, (byte) 12, (byte) 73, (byte) -86, (byte) -37, (byte) -59, (byte) 14, (byte) 0, (byte) -88, (byte) -41 });
        org.junit.Assert.assertNotNull(messageDigest13);
        org.junit.Assert.assertEquals(messageDigest13.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
        org.junit.Assert.assertTrue("'" + codecPolicy14 + "' != '" + CodecPolicy.LENIENT + "'", codecPolicy14.equals(CodecPolicy.LENIENT));
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test194");
        DecoderException decoderException1 = new DecoderException("SHA-512/256");
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test195");
        org.apache.commons.codec.language.Nysiis nysiis0 = new org.apache.commons.codec.language.Nysiis();
        String str2 = nysiis0.nysiis("hi!");
        String str4 = nysiis0.encode("ALL");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "H" + "'", str2, "H");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "AL" + "'", str4, "AL");
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test196");
        org.apache.commons.codec.binary.Base64 base64_1 = new org.apache.commons.codec.binary.Base64((int) (short) -1);
        org.apache.commons.codec.net.QuotedPrintableCodec quotedPrintableCodec2 = new org.apache.commons.codec.net.QuotedPrintableCodec();
        org.apache.commons.codec.binary.Hex hex3 = new org.apache.commons.codec.binary.Hex();
        java.nio.ByteBuffer byteBuffer5 = org.apache.commons.codec.binary.StringUtils.getByteBufferUtf8("SHA-224");
        byte[] byteArray6 = hex3.encode(byteBuffer5);
        byte[] byteArray7 = quotedPrintableCodec2.encode(byteArray6);
        String str8 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray7);
        byte[] byteArray9 = base64_1.decode(byteArray7);
        org.junit.Assert.assertNotNull(byteBuffer5);
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] { (byte) 53, (byte) 51, (byte) 52, (byte) 56, (byte) 52, (byte) 49, (byte) 50, (byte) 100, (byte) 51, (byte) 50, (byte) 51, (byte) 50, (byte) 51, (byte) 52 });
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) 53, (byte) 51, (byte) 52, (byte) 56, (byte) 52, (byte) 49, (byte) 50, (byte) 100, (byte) 51, (byte) 50, (byte) 51, (byte) 50, (byte) 51, (byte) 52 });
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "NTM0ODQxMmQzMjMyMzQ=" + "'", str8, "NTM0ODQxMmQzMjMyMzQ=");
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertArrayEquals(byteArray9, new byte[] { (byte) -25, (byte) 126, (byte) 60, (byte) -29, (byte) 93, (byte) -99, (byte) -33, (byte) 109, (byte) -10, (byte) -33 });
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test197");
        byte[] byteArray2 = org.apache.commons.codec.digest.HmacUtils.hmacSha1("MD5", "any");
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) -80, (byte) 82, (byte) 24, (byte) 5, (byte) 40, (byte) 18, (byte) -65, (byte) 126, (byte) -56, (byte) 41, (byte) -8, (byte) -108, (byte) 123, (byte) -112, (byte) -41, (byte) -70, (byte) -23, (byte) 113, (byte) 37, (byte) -98 });
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test198");
        java.nio.charset.Charset charset0 = Charsets.UTF_16LE;
        org.junit.Assert.assertNotNull(charset0);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test199");
        org.apache.commons.codec.language.Soundex soundex0 = org.apache.commons.codec.language.Soundex.US_ENGLISH_GENEALOGY;
        soundex0.setMaxLength(100);
        org.junit.Assert.assertNotNull(soundex0);
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test200");
        org.apache.commons.codec.binary.Base32 base32_1 = new org.apache.commons.codec.binary.Base32(false);
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test201");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream2 = new org.apache.commons.codec.binary.Base16InputStream(inputStream0, false);
        java.security.MessageDigest messageDigest6 = org.apache.commons.codec.digest.DigestUtils.getSha512Digest();
        org.apache.commons.codec.digest.DigestUtils digestUtils7 = new org.apache.commons.codec.digest.DigestUtils(messageDigest6);
        java.security.MessageDigest messageDigest8 = digestUtils7.getMessageDigest();
        java.security.MessageDigest messageDigest9 = org.apache.commons.codec.digest.DigestUtils.getDigest("6156665843a7281afec331f09b0ef309", messageDigest8);
        byte[] byteArray12 = org.apache.commons.codec.digest.HmacUtils.hmacSha1("UTF-8", "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        java.security.MessageDigest messageDigest13 = org.apache.commons.codec.digest.DigestUtils.updateDigest(messageDigest8, byteArray12);
        CodecPolicy codecPolicy14 = CodecPolicy.LENIENT;
        org.apache.commons.codec.binary.Base32InputStream base32InputStream15 = new org.apache.commons.codec.binary.Base32InputStream(inputStream0, false, 0, byteArray12, codecPolicy14);
        // The following exception was thrown during execution in test generation
        try {
            long long17 = base32InputStream15.skip((long) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(messageDigest6);
        org.junit.Assert.assertEquals(messageDigest6.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
        org.junit.Assert.assertNotNull(messageDigest8);
        org.junit.Assert.assertEquals(messageDigest8.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
        org.junit.Assert.assertNotNull(messageDigest9);
        org.junit.Assert.assertEquals(messageDigest9.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
        org.junit.Assert.assertNotNull(byteArray12);
        org.junit.Assert.assertArrayEquals(byteArray12, new byte[] { (byte) -35, (byte) 1, (byte) -117, (byte) -21, (byte) -107, (byte) 125, (byte) 12, (byte) 116, (byte) 37, (byte) -85, (byte) -59, (byte) 12, (byte) 73, (byte) -86, (byte) -37, (byte) -59, (byte) 14, (byte) 0, (byte) -88, (byte) -41 });
        org.junit.Assert.assertNotNull(messageDigest13);
        org.junit.Assert.assertEquals(messageDigest13.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
        org.junit.Assert.assertTrue("'" + codecPolicy14 + "' != '" + CodecPolicy.LENIENT + "'", codecPolicy14.equals(CodecPolicy.LENIENT));
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test202");
        org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet4 = null;
        org.apache.commons.codec.language.bm.Rule.Phoneme phoneme5 = new org.apache.commons.codec.language.bm.Rule.Phoneme((CharSequence) "AQ==", languageSet4);
        org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet6 = phoneme5.getLanguages();
        org.apache.commons.codec.language.bm.Rule rule7 = new org.apache.commons.codec.language.bm.Rule("5d6b9f2777904dd857816b4c8ac77926", "", "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339", (org.apache.commons.codec.language.bm.Rule.PhonemeExpr) phoneme5);
        org.apache.commons.codec.language.bm.Rule.RPattern rPattern8 = rule7.getRContext();
        String str9 = rule7.getPattern();
        org.apache.commons.codec.language.bm.Rule.PhonemeExpr phonemeExpr10 = rule7.getPhoneme();
        org.junit.Assert.assertNull(languageSet6);
        org.junit.Assert.assertNotNull(rPattern8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "5d6b9f2777904dd857816b4c8ac77926" + "'", str9, "5d6b9f2777904dd857816b4c8ac77926");
        org.junit.Assert.assertNotNull(phonemeExpr10);
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test203");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream2 = new org.apache.commons.codec.binary.Base16InputStream(inputStream0, false);
        // The following exception was thrown during execution in test generation
        try {
            String str3 = org.apache.commons.codec.digest.DigestUtils.md2Hex(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test204");
        java.security.MessageDigest messageDigest0 = org.apache.commons.codec.digest.DigestUtils.getSha512Digest();
        org.apache.commons.codec.digest.DigestUtils digestUtils1 = new org.apache.commons.codec.digest.DigestUtils(messageDigest0);
        java.security.MessageDigest messageDigest2 = digestUtils1.getMessageDigest();
        byte[] byteArray4 = org.apache.commons.codec.binary.StringUtils.getBytesUtf16Le("8d2ce87d86f55fcfab770a047b090da23270fa206832dfea7e0c946fff451f819add242374be551b0d6318ed6c7d41d8");
        byte[] byteArray5 = digestUtils1.digest(byteArray4);
        org.junit.Assert.assertNotNull(messageDigest0);
        org.junit.Assert.assertEquals(messageDigest0.toString(), "SHA-512 Message Digest from SUN, <initialized>\n");
        org.junit.Assert.assertNotNull(messageDigest2);
        org.junit.Assert.assertEquals(messageDigest2.toString(), "SHA-512 Message Digest from SUN, <initialized>\n");
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertNotNull(byteArray5);
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test205");
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.sha512_224("UTF-8");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA-512/224 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test206");
        byte[] byteArray2 = org.apache.commons.codec.digest.HmacUtils.hmacSha384("5348412d323234", "$apr1$W2y312Ks$UWEKZ0eX274guRugqidAE0");
        byte[] byteArray4 = org.apache.commons.codec.digest.DigestUtils.sha1("ALL");
        byte[] byteArray5 = org.apache.commons.codec.digest.HmacUtils.hmacMd5(byteArray2, byteArray4);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 107, (byte) 66, (byte) -121, (byte) 78, (byte) 60, (byte) -46, (byte) 7, (byte) 113, (byte) -39, (byte) 48, (byte) -106, (byte) -20, (byte) 92, (byte) -29, (byte) 99, (byte) 7, (byte) -95, (byte) -14, (byte) -70, (byte) 20 });
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] { (byte) 72, (byte) 11, (byte) 106, (byte) -95, (byte) 68, (byte) -37, (byte) -39, (byte) -21, (byte) 53, (byte) -94, (byte) -108, (byte) 23, (byte) 15, (byte) -84, (byte) 127, (byte) 51 });
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test207");
        org.apache.commons.codec.language.Caverphone2 caverphone2_0 = new org.apache.commons.codec.language.Caverphone2();
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test208");
        byte[] byteArray2 = new byte[] { (byte) 1 };
        String str3 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray2);
        String str4 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray2);
        byte[] byteArray5 = org.apache.commons.codec.digest.DigestUtils.md5(byteArray2);
        byte[] byteArray6 = org.apache.commons.codec.digest.DigestUtils.sha(byteArray2);
        org.apache.commons.codec.binary.Base64 base64_8 = new org.apache.commons.codec.binary.Base64(2131247126, byteArray2, true);
        byte[] byteArray10 = base64_8.decode("");
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "AQ==" + "'", str3, "AQ==");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str4, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] { (byte) 85, (byte) -91, (byte) 64, (byte) 8, (byte) -83, (byte) 27, (byte) -91, (byte) -119, (byte) -86, (byte) 33, (byte) 13, (byte) 38, (byte) 41, (byte) -63, (byte) -33, (byte) 65 });
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] { (byte) -65, (byte) -117, (byte) 69, (byte) 48, (byte) -40, (byte) -46, (byte) 70, (byte) -35, (byte) 116, (byte) -84, (byte) 83, (byte) -95, (byte) 52, (byte) 113, (byte) -69, (byte) -95, (byte) 121, (byte) 65, (byte) -33, (byte) -9 });
        org.junit.Assert.assertNotNull(byteArray10);
        org.junit.Assert.assertArrayEquals(byteArray10, new byte[] {});
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test209");
        // The following exception was thrown during execution in test generation
        try {
            String str1 = org.apache.commons.codec.digest.DigestUtils.sha3_384Hex("");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA3-384 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test210");
        org.apache.commons.codec.digest.HmacAlgorithms hmacAlgorithms0 = org.apache.commons.codec.digest.HmacAlgorithms.HMAC_SHA_224;
        org.junit.Assert.assertTrue("'" + hmacAlgorithms0 + "' != '" + org.apache.commons.codec.digest.HmacAlgorithms.HMAC_SHA_224 + "'", hmacAlgorithms0.equals(org.apache.commons.codec.digest.HmacAlgorithms.HMAC_SHA_224));
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test211");
        java.security.MessageDigest messageDigest1 = org.apache.commons.codec.digest.DigestUtils.getSha512Digest();
        org.apache.commons.codec.digest.DigestUtils digestUtils2 = new org.apache.commons.codec.digest.DigestUtils(messageDigest1);
        java.security.MessageDigest messageDigest3 = digestUtils2.getMessageDigest();
        java.security.MessageDigest messageDigest4 = org.apache.commons.codec.digest.DigestUtils.getDigest("6156665843a7281afec331f09b0ef309", messageDigest3);
        byte[] byteArray7 = org.apache.commons.codec.digest.HmacUtils.hmacSha1("UTF-8", "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        java.security.MessageDigest messageDigest8 = org.apache.commons.codec.digest.DigestUtils.updateDigest(messageDigest3, byteArray7);
        java.nio.file.Path path9 = null;
        java.nio.file.OpenOption[] openOptionArray10 = new java.nio.file.OpenOption[] {};
        // The following exception was thrown during execution in test generation
        try {
            java.security.MessageDigest messageDigest11 = org.apache.commons.codec.digest.DigestUtils.updateDigest(messageDigest8, path9, openOptionArray10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(messageDigest1);
        org.junit.Assert.assertEquals(messageDigest1.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
        org.junit.Assert.assertNotNull(messageDigest3);
        org.junit.Assert.assertEquals(messageDigest3.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
        org.junit.Assert.assertNotNull(messageDigest4);
        org.junit.Assert.assertEquals(messageDigest4.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) -35, (byte) 1, (byte) -117, (byte) -21, (byte) -107, (byte) 125, (byte) 12, (byte) 116, (byte) 37, (byte) -85, (byte) -59, (byte) 12, (byte) 73, (byte) -86, (byte) -37, (byte) -59, (byte) 14, (byte) 0, (byte) -88, (byte) -41 });
        org.junit.Assert.assertNotNull(messageDigest8);
        org.junit.Assert.assertEquals(messageDigest8.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
        org.junit.Assert.assertNotNull(openOptionArray10);
        org.junit.Assert.assertArrayEquals(openOptionArray10, new java.nio.file.OpenOption[] {});
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test212");
        byte[] byteArray2 = org.apache.commons.codec.digest.HmacUtils.hmacSha1("UTF-8", "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        char[] charArray3 = org.apache.commons.codec.binary.BinaryCodec.toAsciiChars(byteArray2);
        String str4 = org.apache.commons.codec.binary.StringUtils.newStringIso8859_1(byteArray2);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) -35, (byte) 1, (byte) -117, (byte) -21, (byte) -107, (byte) 125, (byte) 12, (byte) 116, (byte) 37, (byte) -85, (byte) -59, (byte) 12, (byte) 73, (byte) -86, (byte) -37, (byte) -59, (byte) 14, (byte) 0, (byte) -88, (byte) -41 });
        org.junit.Assert.assertNotNull(charArray3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "\335\001\213\353\225}\ft%\253\305\fI\252\333\305\016\000\250\327" + "'", str4, "\335\001\213\353\225}\ft%\253\305\fI\252\333\305\016\000\250\327");
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test213");
        byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.sha("hi!");
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 58, (byte) -104, (byte) 122, (byte) -49, (byte) -116, (byte) -68, (byte) 16, (byte) 40, (byte) -73, (byte) -37, (byte) -56, (byte) 107, (byte) -48, (byte) -122, (byte) -125, (byte) 17, (byte) 81, (byte) -119, (byte) -102, (byte) 43 });
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test214");
        byte[] byteArray2 = new byte[] { (byte) 1, (byte) 100 };
        char[] charArray4 = org.apache.commons.codec.binary.Hex.encodeHex(byteArray2, false);
        String str5 = org.apache.commons.codec.binary.StringUtils.newStringUtf16Be(byteArray2);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) 1, (byte) 100 });
        org.junit.Assert.assertNotNull(charArray4);
        org.junit.Assert.assertArrayEquals(charArray4, new char[] { '0', '1', '6', '4' });
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "\u0164" + "'", str5, "\u0164");
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test215");
        DecoderException decoderException2 = new DecoderException("ALL");
        EncoderException encoderException3 = new EncoderException("5348412d323234", (Throwable) decoderException2);
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test216");
        org.apache.commons.codec.binary.Hex hex0 = new org.apache.commons.codec.binary.Hex();
        String str1 = hex0.toString();
        org.apache.commons.codec.binary.Base64 base64_3 = new org.apache.commons.codec.binary.Base64(0);
        byte[] byteArray5 = new byte[] { (byte) 1 };
        String str6 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray5);
        String str7 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray5);
        byte[] byteArray8 = org.apache.commons.codec.digest.DigestUtils.md5(byteArray5);
        byte[] byteArray9 = org.apache.commons.codec.digest.DigestUtils.sha(byteArray5);
        byte[] byteArray11 = org.apache.commons.codec.binary.StringUtils.getBytesUsAscii("hi!");
        String str12 = org.apache.commons.codec.digest.HmacUtils.hmacMd5Hex(byteArray5, byteArray11);
        byte[] byteArray13 = base64_3.encode(byteArray11);
        byte[] byteArray14 = hex0.encode(byteArray13);
        String str15 = org.apache.commons.codec.binary.Base64.encodeBase64URLSafeString(byteArray14);
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "AQ==" + "'", str6, "AQ==");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str7, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertNotNull(byteArray8);
        org.junit.Assert.assertArrayEquals(byteArray8, new byte[] { (byte) 85, (byte) -91, (byte) 64, (byte) 8, (byte) -83, (byte) 27, (byte) -91, (byte) -119, (byte) -86, (byte) 33, (byte) 13, (byte) 38, (byte) 41, (byte) -63, (byte) -33, (byte) 65 });
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertArrayEquals(byteArray9, new byte[] { (byte) -65, (byte) -117, (byte) 69, (byte) 48, (byte) -40, (byte) -46, (byte) 70, (byte) -35, (byte) 116, (byte) -84, (byte) 83, (byte) -95, (byte) 52, (byte) 113, (byte) -69, (byte) -95, (byte) 121, (byte) 65, (byte) -33, (byte) -9 });
        org.junit.Assert.assertNotNull(byteArray11);
        org.junit.Assert.assertArrayEquals(byteArray11, new byte[] { (byte) 104, (byte) 105, (byte) 33 });
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "5d6b9f2777904dd857816b4c8ac77926" + "'", str12, "5d6b9f2777904dd857816b4c8ac77926");
        org.junit.Assert.assertNotNull(byteArray13);
        org.junit.Assert.assertArrayEquals(byteArray13, new byte[] { (byte) 97, (byte) 71, (byte) 107, (byte) 104 });
        org.junit.Assert.assertNotNull(byteArray14);
        org.junit.Assert.assertArrayEquals(byteArray14, new byte[] { (byte) 54, (byte) 49, (byte) 52, (byte) 55, (byte) 54, (byte) 98, (byte) 54, (byte) 56 });
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "NjE0NzZiNjg" + "'", str15, "NjE0NzZiNjg");
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test217");
        java.nio.charset.Charset charset0 = Charsets.ISO_8859_1;
        org.junit.Assert.assertNotNull(charset0);
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test218");
        String str0 = CharEncoding.UTF_16;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "UTF-16" + "'", str0, "UTF-16");
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test219");
        byte[] byteArray1 = new byte[] { (byte) 1 };
        String str2 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray1);
        org.apache.commons.codec.digest.Blake3 blake3_3 = org.apache.commons.codec.digest.Blake3.initKeyDerivationFunction(byteArray1);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray4 = org.apache.commons.codec.digest.DigestUtils.sha3_384(byteArray1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.security.NoSuchAlgorithmException: SHA3-384 MessageDigest not available");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "AQ==" + "'", str2, "AQ==");
        org.junit.Assert.assertNotNull(blake3_3);
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test220");
        byte[] byteArray2 = org.apache.commons.codec.digest.HmacUtils.hmacMd5("SHA3-384", "ALL");
        byte[] byteArray8 = org.apache.commons.codec.digest.HmacUtils.hmacSha1("UTF-8", "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        char[] charArray9 = org.apache.commons.codec.binary.BinaryCodec.toAsciiChars(byteArray8);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.codec.binary.Hex.encodeHex(byteArray2, 104729, (int) (short) 1, true, charArray9, (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 104729");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) 2, (byte) -92, (byte) 75, (byte) 112, (byte) 112, (byte) -47, (byte) -95, (byte) -84, (byte) -30, (byte) 39, (byte) 116, (byte) 62, (byte) -32, (byte) 90, (byte) -54, (byte) 79 });
        org.junit.Assert.assertNotNull(byteArray8);
        org.junit.Assert.assertArrayEquals(byteArray8, new byte[] { (byte) -35, (byte) 1, (byte) -117, (byte) -21, (byte) -107, (byte) 125, (byte) 12, (byte) 116, (byte) 37, (byte) -85, (byte) -59, (byte) 12, (byte) 73, (byte) -86, (byte) -37, (byte) -59, (byte) 14, (byte) 0, (byte) -88, (byte) -41 });
        org.junit.Assert.assertNotNull(charArray9);
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test221");
        java.io.OutputStream outputStream0 = null;
        org.apache.commons.codec.binary.Base16OutputStream base16OutputStream1 = new org.apache.commons.codec.binary.Base16OutputStream(outputStream0);
        org.apache.commons.codec.binary.Base16OutputStream base16OutputStream4 = new org.apache.commons.codec.binary.Base16OutputStream((java.io.OutputStream) base16OutputStream1, true, false);
        org.apache.commons.codec.binary.Base32OutputStream base32OutputStream6 = new org.apache.commons.codec.binary.Base32OutputStream((java.io.OutputStream) base16OutputStream1, false);
        org.apache.commons.codec.binary.Base32OutputStream base32OutputStream7 = new org.apache.commons.codec.binary.Base32OutputStream((java.io.OutputStream) base16OutputStream1);
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test222");
        byte[] byteArray2 = org.apache.commons.codec.digest.HmacUtils.hmacSha1("UTF-8", "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        java.util.Random random5 = null;
        // The following exception was thrown during execution in test generation
        try {
            String str6 = org.apache.commons.codec.digest.Md5Crypt.md5Crypt(byteArray2, "NTM0ODQxMmQzMjMyMzQ=", "AL", random5);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid prefix value: AL");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) -35, (byte) 1, (byte) -117, (byte) -21, (byte) -107, (byte) 125, (byte) 12, (byte) 116, (byte) 37, (byte) -85, (byte) -59, (byte) 12, (byte) 73, (byte) -86, (byte) -37, (byte) -59, (byte) 14, (byte) 0, (byte) -88, (byte) -41 });
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test223");
        int int0 = org.apache.commons.codec.binary.BaseNCodec.PEM_CHUNK_SIZE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 64 + "'", int0 == 64);
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test224");
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray2 = org.apache.commons.codec.binary.StringUtils.getBytesUnchecked("A02032102", "b67f94ef55d01fac7818d0819bbd94726b5ad4030715b469f2fb7cf3730c9c0194bd296ec32e37da5d3e36e736f2505d");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: b67f94ef55d01fac7818d0819bbd94726b5ad4030715b469f2fb7cf3730c9c0194bd296ec32e37da5d3e36e736f2505d: java.io.UnsupportedEncodingException: b67f94ef55d01fac7818d0819bbd94726b5ad4030715b469f2fb7cf3730c9c0194bd296ec32e37da5d3e36e736f2505d");
        } catch (IllegalStateException e) {
            // Expected exception.
        }
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test225");
        org.apache.commons.codec.binary.Hex hex0 = new org.apache.commons.codec.binary.Hex();
        // The following exception was thrown during execution in test generation
        try {
            Object obj2 = hex0.decode((Object) 100.0f);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.codec.DecoderException; message: java.lang.Float cannot be cast to [C");
        } catch (DecoderException e) {
            // Expected exception.
        }
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test226");
        org.apache.commons.codec.binary.Base32.Builder builder0 = new org.apache.commons.codec.binary.Base32.Builder();
        org.apache.commons.codec.binary.Base32.Builder builder2 = builder0.setPadding((byte) 100);
        org.junit.Assert.assertNotNull(builder2);
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test227");
        byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.sha256("UTF-16BE");
        org.junit.Assert.assertNotNull(byteArray1);
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test228");
        org.apache.commons.codec.language.bm.NameType nameType0 = null;
        org.apache.commons.codec.language.bm.RuleType ruleType1 = org.apache.commons.codec.language.bm.RuleType.EXACT;
        org.apache.commons.codec.language.bm.PhoneticEngine phoneticEngine4 = new org.apache.commons.codec.language.bm.PhoneticEngine(nameType0, ruleType1, false, (-1318110126));
        int int5 = phoneticEngine4.getMaxPhonemes();
        org.apache.commons.codec.language.bm.NameType nameType6 = phoneticEngine4.getNameType();
        boolean boolean7 = phoneticEngine4.isConcat();
        org.junit.Assert.assertTrue("'" + ruleType1 + "' != '" + org.apache.commons.codec.language.bm.RuleType.EXACT + "'", ruleType1.equals(org.apache.commons.codec.language.bm.RuleType.EXACT));
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + (-1318110126) + "'", int5 == (-1318110126));
        org.junit.Assert.assertNull(nameType6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test229");
        org.apache.commons.codec.language.Metaphone metaphone0 = new org.apache.commons.codec.language.Metaphone();
        boolean boolean3 = metaphone0.isMetaphoneEqual("", "8d2ce87d86f55fcfab770a047b090da23270fa206832dfea7e0c946fff451f819add242374be551b0d6318ed6c7d41d8");
        String str5 = metaphone0.metaphone("b67f94ef55d01fac7818d0819bbd94726b5ad4030715b469f2fb7cf3730c9c0194bd296ec32e37da5d3e36e736f2505d");
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "BFFT" + "'", str5, "BFFT");
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test230");
        javax.crypto.Mac mac0 = null;
        // The following exception was thrown during execution in test generation
        try {
            javax.crypto.Mac mac2 = org.apache.commons.codec.digest.HmacUtils.updateHmac(mac0, "A02032102");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test231");
        byte[] byteArray1 = new byte[] { (byte) 1 };
        String str2 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray1);
        String str3 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray1);
        byte[] byteArray4 = org.apache.commons.codec.digest.DigestUtils.md5(byteArray1);
        byte[] byteArray5 = org.apache.commons.codec.digest.DigestUtils.sha(byteArray1);
        byte[] byteArray7 = org.apache.commons.codec.binary.StringUtils.getBytesUsAscii("hi!");
        String str8 = org.apache.commons.codec.digest.HmacUtils.hmacMd5Hex(byteArray1, byteArray7);
        javax.crypto.Mac mac9 = org.apache.commons.codec.digest.HmacUtils.getHmacSha1(byteArray7);
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "AQ==" + "'", str2, "AQ==");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str3, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 85, (byte) -91, (byte) 64, (byte) 8, (byte) -83, (byte) 27, (byte) -91, (byte) -119, (byte) -86, (byte) 33, (byte) 13, (byte) 38, (byte) 41, (byte) -63, (byte) -33, (byte) 65 });
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] { (byte) -65, (byte) -117, (byte) 69, (byte) 48, (byte) -40, (byte) -46, (byte) 70, (byte) -35, (byte) 116, (byte) -84, (byte) 83, (byte) -95, (byte) 52, (byte) 113, (byte) -69, (byte) -95, (byte) 121, (byte) 65, (byte) -33, (byte) -9 });
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertArrayEquals(byteArray7, new byte[] { (byte) 104, (byte) 105, (byte) 33 });
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "5d6b9f2777904dd857816b4c8ac77926" + "'", str8, "5d6b9f2777904dd857816b4c8ac77926");
        org.junit.Assert.assertNotNull(mac9);
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test232");
        org.apache.commons.codec.language.bm.BeiderMorseEncoder beiderMorseEncoder0 = new org.apache.commons.codec.language.bm.BeiderMorseEncoder();
        Object obj1 = null;
        // The following exception was thrown during execution in test generation
        try {
            Object obj2 = beiderMorseEncoder0.encode(obj1);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.codec.EncoderException; message: BeiderMorseEncoder encode parameter is not of type String");
        } catch (EncoderException e) {
            // Expected exception.
        }
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test233");
        byte[] byteArray0 = null;
        String str1 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray0);
        org.junit.Assert.assertNull(str1);
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test234");
        long long0 = org.apache.commons.codec.digest.MurmurHash3.NULL_HASHCODE;
        org.junit.Assert.assertTrue("'" + long0 + "' != '" + 2862933555777941757L + "'", long0 == 2862933555777941757L);
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test235");
        java.io.InputStream inputStream0 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream2 = new org.apache.commons.codec.binary.Base16InputStream(inputStream0, false);
        java.security.MessageDigest messageDigest6 = org.apache.commons.codec.digest.DigestUtils.getSha512Digest();
        org.apache.commons.codec.digest.DigestUtils digestUtils7 = new org.apache.commons.codec.digest.DigestUtils(messageDigest6);
        java.security.MessageDigest messageDigest8 = digestUtils7.getMessageDigest();
        java.security.MessageDigest messageDigest9 = org.apache.commons.codec.digest.DigestUtils.getDigest("6156665843a7281afec331f09b0ef309", messageDigest8);
        byte[] byteArray12 = org.apache.commons.codec.digest.HmacUtils.hmacSha1("UTF-8", "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        java.security.MessageDigest messageDigest13 = org.apache.commons.codec.digest.DigestUtils.updateDigest(messageDigest8, byteArray12);
        CodecPolicy codecPolicy14 = CodecPolicy.LENIENT;
        org.apache.commons.codec.binary.Base32InputStream base32InputStream15 = new org.apache.commons.codec.binary.Base32InputStream(inputStream0, false, 0, byteArray12, codecPolicy14);
        byte[] byteArray17 = new byte[] { (byte) 1 };
        String str18 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray17);
        String str19 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray17);
        byte[] byteArray20 = org.apache.commons.codec.digest.DigestUtils.md5(byteArray17);
        String str21 = org.apache.commons.codec.digest.HmacUtils.hmacSha1Hex(byteArray12, byteArray17);
        byte[] byteArray23 = org.apache.commons.codec.digest.DigestUtils.sha384("7bT7wvCF8Dme.");
        byte[] byteArray24 = org.apache.commons.codec.digest.HmacUtils.hmacSha512(byteArray12, byteArray23);
        org.junit.Assert.assertNotNull(messageDigest6);
        org.junit.Assert.assertEquals(messageDigest6.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
        org.junit.Assert.assertNotNull(messageDigest8);
        org.junit.Assert.assertEquals(messageDigest8.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
        org.junit.Assert.assertNotNull(messageDigest9);
        org.junit.Assert.assertEquals(messageDigest9.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
        org.junit.Assert.assertNotNull(byteArray12);
        org.junit.Assert.assertArrayEquals(byteArray12, new byte[] { (byte) -35, (byte) 1, (byte) -117, (byte) -21, (byte) -107, (byte) 125, (byte) 12, (byte) 116, (byte) 37, (byte) -85, (byte) -59, (byte) 12, (byte) 73, (byte) -86, (byte) -37, (byte) -59, (byte) 14, (byte) 0, (byte) -88, (byte) -41 });
        org.junit.Assert.assertNotNull(messageDigest13);
        org.junit.Assert.assertEquals(messageDigest13.toString(), "SHA-512 Message Digest from SUN, <in progress>\n");
        org.junit.Assert.assertTrue("'" + codecPolicy14 + "' != '" + CodecPolicy.LENIENT + "'", codecPolicy14.equals(CodecPolicy.LENIENT));
        org.junit.Assert.assertNotNull(byteArray17);
        org.junit.Assert.assertArrayEquals(byteArray17, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "AQ==" + "'", str18, "AQ==");
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str19, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertNotNull(byteArray20);
        org.junit.Assert.assertArrayEquals(byteArray20, new byte[] { (byte) 85, (byte) -91, (byte) 64, (byte) 8, (byte) -83, (byte) 27, (byte) -91, (byte) -119, (byte) -86, (byte) 33, (byte) 13, (byte) 38, (byte) 41, (byte) -63, (byte) -33, (byte) 65 });
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "99e98c9b4c0ecfb8a88ecdd1551b3e08723b3114" + "'", str21, "99e98c9b4c0ecfb8a88ecdd1551b3e08723b3114");
        org.junit.Assert.assertNotNull(byteArray23);
        org.junit.Assert.assertNotNull(byteArray24);
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test236");
        org.apache.commons.codec.language.Nysiis nysiis0 = new org.apache.commons.codec.language.Nysiis();
        boolean boolean1 = nysiis0.isStrict();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test237");
        byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.sha256("AQ==");
        org.junit.Assert.assertNotNull(byteArray1);
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test238");
        java.security.MessageDigest messageDigest0 = org.apache.commons.codec.digest.DigestUtils.getSha512Digest();
        org.apache.commons.codec.digest.DigestUtils digestUtils1 = new org.apache.commons.codec.digest.DigestUtils(messageDigest0);
        byte[] byteArray3 = new byte[] { (byte) 1 };
        String str4 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray3);
        String str5 = org.apache.commons.codec.digest.DigestUtils.sha512Hex(byteArray3);
        byte[] byteArray6 = org.apache.commons.codec.digest.DigestUtils.md5(byteArray3);
        byte[] byteArray9 = org.apache.commons.codec.binary.Base64.encodeBase64(byteArray6, false, true);
        String str10 = digestUtils1.digestAsHex(byteArray9);
        java.io.InputStream inputStream11 = null;
        org.apache.commons.codec.binary.Base16InputStream base16InputStream13 = new org.apache.commons.codec.binary.Base16InputStream(inputStream11, false);
        org.apache.commons.codec.binary.Base32InputStream base32InputStream14 = new org.apache.commons.codec.binary.Base32InputStream(inputStream11);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray15 = digestUtils1.digest((java.io.InputStream) base32InputStream14);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(messageDigest0);
        org.junit.Assert.assertEquals(messageDigest0.toString(), "SHA-512 Message Digest from SUN, <initialized>\n");
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "AQ==" + "'", str4, "AQ==");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", str5, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] { (byte) 85, (byte) -91, (byte) 64, (byte) 8, (byte) -83, (byte) 27, (byte) -91, (byte) -119, (byte) -86, (byte) 33, (byte) 13, (byte) 38, (byte) 41, (byte) -63, (byte) -33, (byte) 65 });
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertArrayEquals(byteArray9, new byte[] { (byte) 86, (byte) 97, (byte) 86, (byte) 65, (byte) 67, (byte) 75, (byte) 48, (byte) 98, (byte) 112, (byte) 89, (byte) 109, (byte) 113, (byte) 73, (byte) 81, (byte) 48, (byte) 109, (byte) 75, (byte) 99, (byte) 72, (byte) 102, (byte) 81, (byte) 81 });
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "6704602e4ce5d0029093eef113910bc4c3f653e00e98689ee2d8ee1ed75372d6122faa47319cb8c8b75c80bea32b8c8c5b435d6eaa2c9f1ecd7833b7ae0cb6d4" + "'", str10, "6704602e4ce5d0029093eef113910bc4c3f653e00e98689ee2d8ee1ed75372d6122faa47319cb8c8b75c80bea32b8c8c5b435d6eaa2c9f1ecd7833b7ae0cb6d4");
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test239");
        byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.sha384("");
        org.junit.Assert.assertNotNull(byteArray1);
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test240");
        byte[] byteArray1 = org.apache.commons.codec.digest.DigestUtils.sha512("7bT7wvCF8Dme.");
        java.util.Random random2 = null;
        // The following exception was thrown during execution in test generation
        try {
            String str3 = org.apache.commons.codec.digest.Md5Crypt.apr1Crypt(byteArray1, random2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test241");
        byte[] byteArray1 = new byte[] { (byte) 1 };
        String str2 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray1);
        org.apache.commons.codec.digest.Blake3 blake3_3 = org.apache.commons.codec.digest.Blake3.initKeyDerivationFunction(byteArray1);
        byte[] byteArray6 = new byte[] { (byte) 1 };
        String str7 = org.apache.commons.codec.binary.Base64.encodeBase64String(byteArray6);
        org.apache.commons.codec.binary.Base64 base64_9 = new org.apache.commons.codec.binary.Base64((int) (byte) -1, byteArray6, true);
        org.apache.commons.codec.digest.Blake3 blake3_10 = blake3_3.doFinalize(byteArray6);
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) 1 });
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "AQ==" + "'", str2, "AQ==");
        org.junit.Assert.assertNotNull(blake3_3);
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] { (byte) -66 });
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "AQ==" + "'", str7, "AQ==");
        org.junit.Assert.assertNotNull(blake3_10);
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test242");
        org.apache.commons.codec.language.bm.NameType nameType0 = org.apache.commons.codec.language.bm.NameType.GENERIC;
        org.apache.commons.codec.language.bm.NameType nameType1 = null;
        org.apache.commons.codec.language.bm.RuleType ruleType2 = org.apache.commons.codec.language.bm.RuleType.EXACT;
        org.apache.commons.codec.language.bm.PhoneticEngine phoneticEngine5 = new org.apache.commons.codec.language.bm.PhoneticEngine(nameType1, ruleType2, false, (-1318110126));
        int int6 = phoneticEngine5.getMaxPhonemes();
        org.apache.commons.codec.language.bm.RuleType ruleType7 = phoneticEngine5.getRuleType();
        org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet8 = org.apache.commons.codec.language.bm.Languages.ANY_LANGUAGE;
        java.util.Map<String, java.util.List<org.apache.commons.codec.language.bm.Rule>> strMap9 = org.apache.commons.codec.language.bm.Rule.getInstanceMap(nameType0, ruleType7, languageSet8);
        org.apache.commons.codec.language.bm.Languages languages10 = org.apache.commons.codec.language.bm.Languages.getInstance(nameType0);
        org.apache.commons.codec.language.bm.NameType nameType11 = org.apache.commons.codec.language.bm.NameType.GENERIC;
        org.apache.commons.codec.language.bm.NameType nameType12 = null;
        org.apache.commons.codec.language.bm.RuleType ruleType13 = org.apache.commons.codec.language.bm.RuleType.EXACT;
        org.apache.commons.codec.language.bm.PhoneticEngine phoneticEngine16 = new org.apache.commons.codec.language.bm.PhoneticEngine(nameType12, ruleType13, false, (-1318110126));
        int int17 = phoneticEngine16.getMaxPhonemes();
        org.apache.commons.codec.language.bm.RuleType ruleType18 = phoneticEngine16.getRuleType();
        org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet19 = org.apache.commons.codec.language.bm.Languages.ANY_LANGUAGE;
        java.util.Map<String, java.util.List<org.apache.commons.codec.language.bm.Rule>> strMap20 = org.apache.commons.codec.language.bm.Rule.getInstanceMap(nameType11, ruleType18, languageSet19);
        org.apache.commons.codec.language.bm.NameType nameType21 = org.apache.commons.codec.language.bm.NameType.GENERIC;
        org.apache.commons.codec.language.bm.NameType nameType22 = null;
        org.apache.commons.codec.language.bm.RuleType ruleType23 = org.apache.commons.codec.language.bm.RuleType.EXACT;
        org.apache.commons.codec.language.bm.PhoneticEngine phoneticEngine26 = new org.apache.commons.codec.language.bm.PhoneticEngine(nameType22, ruleType23, false, (-1318110126));
        int int27 = phoneticEngine26.getMaxPhonemes();
        org.apache.commons.codec.language.bm.RuleType ruleType28 = phoneticEngine26.getRuleType();
        org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet29 = org.apache.commons.codec.language.bm.Languages.ANY_LANGUAGE;
        java.util.Map<String, java.util.List<org.apache.commons.codec.language.bm.Rule>> strMap30 = org.apache.commons.codec.language.bm.Rule.getInstanceMap(nameType21, ruleType28, languageSet29);
        org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet31 = org.apache.commons.codec.language.bm.Languages.ANY_LANGUAGE;
        boolean boolean33 = languageSet31.contains("7bf2840e9911920c6c17b7c7ac057ddcbf629b69f2fad16b16a4269e5f5c1298");
        org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet34 = languageSet29.restrictTo(languageSet31);
        java.util.Map<String, java.util.List<org.apache.commons.codec.language.bm.Rule>> strMap35 = org.apache.commons.codec.language.bm.Rule.getInstanceMap(nameType0, ruleType18, languageSet29);
        org.junit.Assert.assertTrue("'" + nameType0 + "' != '" + org.apache.commons.codec.language.bm.NameType.GENERIC + "'", nameType0.equals(org.apache.commons.codec.language.bm.NameType.GENERIC));
        org.junit.Assert.assertTrue("'" + ruleType2 + "' != '" + org.apache.commons.codec.language.bm.RuleType.EXACT + "'", ruleType2.equals(org.apache.commons.codec.language.bm.RuleType.EXACT));
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + (-1318110126) + "'", int6 == (-1318110126));
        org.junit.Assert.assertTrue("'" + ruleType7 + "' != '" + org.apache.commons.codec.language.bm.RuleType.EXACT + "'", ruleType7.equals(org.apache.commons.codec.language.bm.RuleType.EXACT));
        org.junit.Assert.assertNotNull(languageSet8);
        org.junit.Assert.assertNotNull(strMap9);
        org.junit.Assert.assertNotNull(languages10);
        org.junit.Assert.assertTrue("'" + nameType11 + "' != '" + org.apache.commons.codec.language.bm.NameType.GENERIC + "'", nameType11.equals(org.apache.commons.codec.language.bm.NameType.GENERIC));
        org.junit.Assert.assertTrue("'" + ruleType13 + "' != '" + org.apache.commons.codec.language.bm.RuleType.EXACT + "'", ruleType13.equals(org.apache.commons.codec.language.bm.RuleType.EXACT));
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + (-1318110126) + "'", int17 == (-1318110126));
        org.junit.Assert.assertTrue("'" + ruleType18 + "' != '" + org.apache.commons.codec.language.bm.RuleType.EXACT + "'", ruleType18.equals(org.apache.commons.codec.language.bm.RuleType.EXACT));
        org.junit.Assert.assertNotNull(languageSet19);
        org.junit.Assert.assertNotNull(strMap20);
        org.junit.Assert.assertTrue("'" + nameType21 + "' != '" + org.apache.commons.codec.language.bm.NameType.GENERIC + "'", nameType21.equals(org.apache.commons.codec.language.bm.NameType.GENERIC));
        org.junit.Assert.assertTrue("'" + ruleType23 + "' != '" + org.apache.commons.codec.language.bm.RuleType.EXACT + "'", ruleType23.equals(org.apache.commons.codec.language.bm.RuleType.EXACT));
        org.junit.Assert.assertTrue("'" + int27 + "' != '" + (-1318110126) + "'", int27 == (-1318110126));
        org.junit.Assert.assertTrue("'" + ruleType28 + "' != '" + org.apache.commons.codec.language.bm.RuleType.EXACT + "'", ruleType28.equals(org.apache.commons.codec.language.bm.RuleType.EXACT));
        org.junit.Assert.assertNotNull(languageSet29);
        org.junit.Assert.assertNotNull(strMap30);
        org.junit.Assert.assertNotNull(languageSet31);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + true + "'", boolean33 == true);
        org.junit.Assert.assertNotNull(languageSet34);
        org.junit.Assert.assertNotNull(strMap35);
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test243");
        org.apache.commons.codec.net.QuotedPrintableCodec quotedPrintableCodec0 = new org.apache.commons.codec.net.QuotedPrintableCodec();
        org.apache.commons.codec.binary.Hex hex1 = new org.apache.commons.codec.binary.Hex();
        java.nio.ByteBuffer byteBuffer3 = org.apache.commons.codec.binary.StringUtils.getByteBufferUtf8("SHA-224");
        byte[] byteArray4 = hex1.encode(byteBuffer3);
        byte[] byteArray5 = quotedPrintableCodec0.encode(byteArray4);
        java.nio.charset.Charset charset7 = Charsets.UTF_8;
        String str8 = quotedPrintableCodec0.encode("UTF-8", charset7);
        org.apache.commons.codec.net.QuotedPrintableCodec quotedPrintableCodec9 = new org.apache.commons.codec.net.QuotedPrintableCodec(charset7);
        byte[] byteArray12 = org.apache.commons.codec.digest.HmacUtils.hmacSha1("UTF-8", "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        Object obj13 = quotedPrintableCodec9.decode((Object) "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        byte[] byteArray15 = org.apache.commons.codec.binary.StringUtils.getBytesUtf16Be("UTF-8");
        byte[] byteArray17 = org.apache.commons.codec.binary.StringUtils.getBytesUtf8("6156665843a7281afec331f09b0ef309");
        byte[] byteArray18 = org.apache.commons.codec.digest.HmacUtils.hmacSha256(byteArray15, byteArray17);
        Object obj19 = quotedPrintableCodec9.decode((Object) byteArray17);
        org.junit.Assert.assertNotNull(byteBuffer3);
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 53, (byte) 51, (byte) 52, (byte) 56, (byte) 52, (byte) 49, (byte) 50, (byte) 100, (byte) 51, (byte) 50, (byte) 51, (byte) 50, (byte) 51, (byte) 52 });
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertArrayEquals(byteArray5, new byte[] { (byte) 53, (byte) 51, (byte) 52, (byte) 56, (byte) 52, (byte) 49, (byte) 50, (byte) 100, (byte) 51, (byte) 50, (byte) 51, (byte) 50, (byte) 51, (byte) 52 });
        org.junit.Assert.assertNotNull(charset7);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "UTF-8" + "'", str8, "UTF-8");
        org.junit.Assert.assertNotNull(byteArray12);
        org.junit.Assert.assertArrayEquals(byteArray12, new byte[] { (byte) -35, (byte) 1, (byte) -117, (byte) -21, (byte) -107, (byte) 125, (byte) 12, (byte) 116, (byte) 37, (byte) -85, (byte) -59, (byte) 12, (byte) 73, (byte) -86, (byte) -37, (byte) -59, (byte) 14, (byte) 0, (byte) -88, (byte) -41 });
        org.junit.Assert.assertEquals("'" + obj13 + "' != '" + "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339" + "'", obj13, "7b54b66836c1fbdd13d2441d9e1434dc62ca677fb68f5fe66a464baadecdbd00576f8d6b5ac3bcc80844b7d50b1cc6603444bbe7cfcf8fc0aa1ee3c636d9e339");
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] { (byte) 0, (byte) 85, (byte) 0, (byte) 84, (byte) 0, (byte) 70, (byte) 0, (byte) 45, (byte) 0, (byte) 56 });
        org.junit.Assert.assertNotNull(byteArray17);
        org.junit.Assert.assertNotNull(byteArray18);
        org.junit.Assert.assertNotNull(obj19);
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test244");
        int int2 = org.apache.commons.codec.digest.MurmurHash3.hash32((long) 104729, (long) (byte) 0);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 83611437 + "'", int2 == 83611437);
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test245");
        org.apache.commons.codec.binary.Base32.Builder builder0 = new org.apache.commons.codec.binary.Base32.Builder();
        byte[] byteArray2 = org.apache.commons.codec.digest.DigestUtils.sha512("$6$hZjG3.XY$6czWvHLhH1l4z3ifyJ31VUlgelUNxpr0dUCBoOq5HGp.GOmJjM2bG/0H0UM/NCwi0uenRBwcDKK3D4E.Dpg5U1");
        boolean boolean3 = org.apache.commons.codec.binary.Base64.isArrayByteBase64(byteArray2);
        byte[] byteArray4 = org.apache.commons.codec.digest.Blake3.hash(byteArray2);
        org.apache.commons.codec.binary.Base32.Builder builder5 = builder0.setEncodeTable(byteArray4);
        org.apache.commons.codec.binary.Base32.Builder builder7 = builder5.setPadding((byte) 0);
        org.apache.commons.codec.binary.Base32.Builder builder9 = builder5.setHexDecodeTable(false);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertNotNull(builder5);
        org.junit.Assert.assertNotNull(builder7);
        org.junit.Assert.assertNotNull(builder9);
    }
}
