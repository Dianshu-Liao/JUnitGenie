package org.apache.commons.lang3;

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
        String str1 = org.apache.commons.lang3.text.WordUtils.capitalizeFully("hi!");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "Hi!" + "'", str1, "Hi!");
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        String str0 = SystemProperties.JAVAX_RMI_SSL_CLIENT_ENABLED_PROTOCOLS;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "javax.rmi.ssl.client.enabledProtocols" + "'", str0, "javax.rmi.ssl.client.enabledProtocols");
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator0 = StringEscapeUtils.UNESCAPE_JSON;
        org.junit.Assert.assertNotNull(charSequenceTranslator0);
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test004");
        JavaVersion javaVersion0 = JavaVersion.JAVA_20;
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + JavaVersion.JAVA_20 + "'", javaVersion0.equals(JavaVersion.JAVA_20));
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test005");
        String[] strArray4 = new String[] { "javax.rmi.ssl.client.enabledProtocols", "Hi!", "javax.rmi.ssl.client.enabledProtocols" };
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date5 = org.apache.commons.lang3.time.DateUtils.parseDateStrictly("hi!", strArray4);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Format 'j' not supported");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray4);
        org.junit.Assert.assertArrayEquals(strArray4, new String[] { "javax.rmi.ssl.client.enabledProtocols", "Hi!", "javax.rmi.ssl.client.enabledProtocols" });
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        String str1 = ClassUtils.getShortCanonicalName("");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "" + "'", str1, "");
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        String str1 = StringUtils.toRootUpperCase("javax.rmi.ssl.client.enabledProtocols");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "JAVAX.RMI.SSL.CLIENT.ENABLEDPROTOCOLS" + "'", str1, "JAVAX.RMI.SSL.CLIENT.ENABLEDPROTOCOLS");
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        String str0 = SystemProperties.JAVA_LOCALE_PROVIDERS;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.locale.providers" + "'", str0, "java.locale.providers");
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator0 = StringEscapeUtils.UNESCAPE_JSON;
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator1 = StringEscapeUtils.UNESCAPE_JSON;
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator2 = StringEscapeUtils.UNESCAPE_JSON;
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator3 = StringEscapeUtils.UNESCAPE_JSON;
        org.apache.commons.lang3.text.translate.CharSequenceTranslator[] charSequenceTranslatorArray4 = new org.apache.commons.lang3.text.translate.CharSequenceTranslator[] { charSequenceTranslator0, charSequenceTranslator1, charSequenceTranslator2, charSequenceTranslator3 };
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator6 = null;
        org.apache.commons.lang3.text.translate.CharSequenceTranslator[] charSequenceTranslatorArray7 = ArrayUtils.add(charSequenceTranslatorArray4, (int) (byte) 0, charSequenceTranslator6);
        org.junit.Assert.assertNotNull(charSequenceTranslator0);
        org.junit.Assert.assertNotNull(charSequenceTranslator1);
        org.junit.Assert.assertNotNull(charSequenceTranslator2);
        org.junit.Assert.assertNotNull(charSequenceTranslator3);
        org.junit.Assert.assertNotNull(charSequenceTranslatorArray4);
        org.junit.Assert.assertNotNull(charSequenceTranslatorArray7);
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        String str2 = ObjectUtils.toString((Object) 1L, "");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "1" + "'", str2, "1");
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        Throwable throwable1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.concurrent.ConcurrentRuntimeException concurrentRuntimeException2 = new org.apache.commons.lang3.concurrent.ConcurrentRuntimeException("Hi!", throwable1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Not a checked exception: null");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        String str0 = SystemProperties.JAVAX_NET_SSL_SESSION_CACHE_SIZE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "javax.net.ssl.sessionCacheSize" + "'", str0, "javax.net.ssl.sessionCacheSize");
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        Character char1 = CharUtils.toCharacterObject("");
        org.junit.Assert.assertNull(char1);
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        JavaVersion javaVersion0 = JavaVersion.JAVA_17;
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + JavaVersion.JAVA_17 + "'", javaVersion0.equals(JavaVersion.JAVA_17));
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        String str1 = StringUtils.deleteWhitespace("Hi!");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "Hi!" + "'", str1, "Hi!");
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        String str0 = org.apache.commons.lang3.time.TimeZones.GMT_ID;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "GMT" + "'", str0, "GMT");
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        String str0 = SystemProperties.getJdkHttpClientConnectionWindowSize();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        int int0 = org.apache.commons.lang3.time.FastDateFormat.LONG;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        String str3 = RegExUtils.replaceAll("1", "Hi!", "javax.rmi.ssl.client.enabledProtocols");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "1" + "'", str3, "1");
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        String str1 = StringUtils.trimToNull("java.locale.providers");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "java.locale.providers" + "'", str1, "java.locale.providers");
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        String str0 = SystemProperties.ORG_OPENJDK_JAVA_UTIL_STREAM_TRIPWIRE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "org.openjdk.java.util.stream.tripwire" + "'", str0, "org.openjdk.java.util.stream.tripwire");
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        String str1 = StringUtils.defaultString("javax.rmi.ssl.client.enabledProtocols");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "javax.rmi.ssl.client.enabledProtocols" + "'", str1, "javax.rmi.ssl.client.enabledProtocols");
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        // The following exception was thrown during execution in test generation
        try {
            Boolean boolean4 = BooleanUtils.toBooleanObject(100, 10, (int) 'a', (int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The Integer did not match any specified value");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        String str0 = SystemProperties.SUN_NET_HTTP_SERVER_NO_DELAY;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "sun.net.httpserver.nodelay" + "'", str0, "sun.net.httpserver.nodelay");
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        JavaVersion javaVersion0 = JavaVersion.JAVA_1_6;
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + JavaVersion.JAVA_1_6 + "'", javaVersion0.equals(JavaVersion.JAVA_1_6));
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        String str0 = SystemProperties.JDK_HTTP_CLIENT_CONNECTION_POOL_SIZE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "jdk.httpclient.connectionPoolSize" + "'", str0, "jdk.httpclient.connectionPoolSize");
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        org.apache.commons.lang3.math.IEEE754rUtils iEEE754rUtils0 = new org.apache.commons.lang3.math.IEEE754rUtils();
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        ClassPathUtils classPathUtils0 = new ClassPathUtils();
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        java.lang.reflect.Method method0 = null;
        ClassUtils.Interfaces interfaces1 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Set<java.lang.reflect.Method> methodSet2 = org.apache.commons.lang3.reflect.MethodUtils.getOverrideHierarchy(method0, interfaces1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: method");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        org.apache.commons.lang3.function.FailablePredicate failablePredicate0 = org.apache.commons.lang3.function.FailablePredicate.FALSE;
        org.junit.Assert.assertNotNull(failablePredicate0);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        java.util.Formattable formattable0 = null;
        String str1 = org.apache.commons.lang3.text.FormattableUtils.toString(formattable0);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "null" + "'", str1, "null");
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        char char2 = CharUtils.toChar("javax.rmi.ssl.client.enabledProtocols", ' ');
        org.junit.Assert.assertTrue("'" + char2 + "' != '" + 'j' + "'", char2 == 'j');
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        String str4 = StringUtils.overlay("jdk.httpclient.connectionPoolSize", "1", (-1), 100);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "1" + "'", str4, "1");
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        boolean boolean0 = SystemUtils.IS_OS_WINDOWS;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test035");
        String str0 = SystemProperties.getJavaRmiServerRmiClassLoaderSpi();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        int int1 = BooleanUtils.toInteger(false);
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 0 + "'", int1 == 0);
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        byte[] byteArray2 = new byte[] { (byte) -1, (byte) 0 };
        java.util.Random random3 = null;
        // The following exception was thrown during execution in test generation
        try {
            ArrayUtils.shuffle(byteArray2, random3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertArrayEquals(byteArray2, new byte[] { (byte) -1, (byte) 0 });
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        org.apache.commons.lang3.tuple.Pair<?, ?>[] wildcardPairArray1 = org.apache.commons.lang3.tuple.Pair.EMPTY_ARRAY;
        String str2 = StringUtils.joinWith("sun.net.httpserver.nodelay", (Object[]) wildcardPairArray1);
        org.junit.Assert.assertNotNull(wildcardPairArray1);
        org.junit.Assert.assertArrayEquals(wildcardPairArray1, new org.apache.commons.lang3.tuple.Pair[] {});
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "" + "'", str2, "");
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        boolean boolean0 = SystemUtils.IS_OS_400;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        org.apache.commons.lang3.function.FailableIntToDoubleFunction failableIntToDoubleFunction0 = org.apache.commons.lang3.function.FailableIntToDoubleFunction.NOP;
        org.junit.Assert.assertNotNull(failableIntToDoubleFunction0);
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        String str0 = SystemProperties.getJdkJndiRmiObjectFactoriesFilter();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        org.apache.commons.lang3.text.StrMatcher strMatcher1 = null;
        org.apache.commons.lang3.text.StrMatcher strMatcher2 = null;
        org.apache.commons.lang3.text.StrTokenizer strTokenizer3 = new org.apache.commons.lang3.text.StrTokenizer("", strMatcher1, strMatcher2);
        String str5 = StringUtils.join((java.util.Iterator<String>) strTokenizer3, "java.locale.providers");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        String str3 = StringUtils.rightPad("jdk.httpclient.connectionPoolSize", (int) '4', "Hi!");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "jdk.httpclient.connectionPoolSizeHi!Hi!Hi!Hi!Hi!Hi!H" + "'", str3, "jdk.httpclient.connectionPoolSizeHi!Hi!Hi!Hi!Hi!Hi!H");
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        String str1 = RandomStringUtils.randomPrint((int) (short) 1);
// flaky "1) test044(RegressionTest0)":         org.junit.Assert.assertEquals("'" + str1 + "' != '" + "[" + "'", str1, "[");
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        boolean boolean1 = BooleanUtils.toBoolean((int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        String str0 = SystemUtils.LINE_SEPARATOR;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "\n" + "'", str0, "\n");
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        String str0 = SystemProperties.JDK_HTTPS_NEGOTIATE_CBT;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "jdk.https.negotiate.cbt" + "'", str0, "jdk.https.negotiate.cbt");
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        String str0 = SystemProperties.USER_LANGUAGE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "user.language" + "'", str0, "user.language");
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        String str0 = SystemProperties.SUN_NET_HTTP_SERVER_MAX_IDLE_CONNECTIONS;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "sun.net.httpserver.maxIdleConnections" + "'", str0, "sun.net.httpserver.maxIdleConnections");
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        String str2 = StringUtils.repeat(' ', (int) (byte) 0);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "" + "'", str2, "");
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        java.util.Calendar calendar0 = null;
        java.util.Calendar calendar1 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean2 = org.apache.commons.lang3.time.DateUtils.isSameInstant(calendar0, calendar1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: cal1");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        boolean[] booleanArray0 = new boolean[] {};
        boolean[] booleanArray1 = new boolean[] {};
        boolean[][] booleanArray2 = new boolean[][] { booleanArray0, booleanArray1 };
        boolean[][] booleanArray3 = Validate.notEmpty(booleanArray2);
        org.junit.Assert.assertNotNull(booleanArray0);
        org.junit.Assert.assertArrayEquals(booleanArray0, new boolean[] {});
        org.junit.Assert.assertNotNull(booleanArray1);
        org.junit.Assert.assertArrayEquals(booleanArray1, new boolean[] {});
        org.junit.Assert.assertNotNull(booleanArray2);
        org.junit.Assert.assertNotNull(booleanArray3);
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        org.apache.commons.lang3.mutable.MutableBoolean mutableBoolean0 = new org.apache.commons.lang3.mutable.MutableBoolean();
        mutableBoolean0.setValue((Boolean) true);
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        org.apache.commons.lang3.mutable.MutableBoolean mutableBoolean1 = new org.apache.commons.lang3.mutable.MutableBoolean(true);
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        byte[] byteArray0 = null;
        boolean boolean1 = ArrayUtils.isSorted(byteArray0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        String str0 = SystemProperties.getJavaxAccessibilityAssistiveTechnologies();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        boolean boolean0 = SystemUtils.IS_OS_MAC_OSX;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        int[] intArray3 = new int[] { 1, 1, (short) 1 };
        int[] intArray6 = ArrayUtils.subarray(intArray3, 0, 0);
        int int7 = org.apache.commons.lang3.math.NumberUtils.min(intArray3);
        org.junit.Assert.assertNotNull(intArray3);
        org.junit.Assert.assertArrayEquals(intArray3, new int[] { 1, 1, 1 });
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertArrayEquals(intArray6, new int[] {});
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 1 + "'", int7 == 1);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        String str0 = SystemProperties.JDK_HTTP_CLIENT_SEND_BUFFER_SIZE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "jdk.httpclient.sendBufferSize" + "'", str0, "jdk.httpclient.sendBufferSize");
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        long long0 = RandomUtils.nextLong();
// flaky "2) test060(RegressionTest0)":         org.junit.Assert.assertTrue("'" + long0 + "' != '" + 3776573491206566018L + "'", long0 == 3776573491206566018L);
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        JavaVersion javaVersion0 = JavaVersion.JAVA_1_3;
        JavaVersion javaVersion1 = JavaVersion.JAVA_1_3;
        int int3 = ObjectUtils.compare(javaVersion0, javaVersion1, false);
        String str5 = ClassUtils.getSimpleName((Object) int3, "jdk.https.negotiate.cbt");
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + JavaVersion.JAVA_1_3 + "'", javaVersion0.equals(JavaVersion.JAVA_1_3));
        org.junit.Assert.assertTrue("'" + javaVersion1 + "' != '" + JavaVersion.JAVA_1_3 + "'", javaVersion1.equals(JavaVersion.JAVA_1_3));
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "Integer" + "'", str5, "Integer");
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        String str0 = SystemProperties.getUserRegion();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        String str0 = SystemProperties.JDK_HTTP_CLIENT_HTTP_CLIENT_LOG;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "jdk.httpclient.HttpClient.log" + "'", str0, "jdk.httpclient.HttpClient.log");
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        String str0 = SystemProperties.COM_SUN_NET_HTTP_SERVER_HTTP_SERVER_PROVIDER;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "com.sun.net.httpserver.HttpServerProvider" + "'", str0, "com.sun.net.httpserver.HttpServerProvider");
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        String str2 = StringUtils.substringBetween("null", "jdk.https.negotiate.cbt");
        org.junit.Assert.assertNull(str2);
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        String str2 = StringUtils.removePattern("java.locale.providers", "\n");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "java.locale.providers" + "'", str2, "java.locale.providers");
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        org.apache.commons.lang3.text.translate.UnicodeEscaper unicodeEscaper1 = org.apache.commons.lang3.text.translate.UnicodeEscaper.below((int) (byte) 0);
        org.junit.Assert.assertNotNull(unicodeEscaper1);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer1 = org.apache.commons.lang3.text.StrTokenizer.getCSVInstance("jdk.httpclient.connectionPoolSizeHi!Hi!Hi!Hi!Hi!Hi!H");
        // The following exception was thrown during execution in test generation
        try {
            strTokenizer1.add("[");
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: add() is unsupported");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strTokenizer1);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        int[] intArray3 = new int[] { 1, 1, (short) 1 };
        int[] intArray6 = ArrayUtils.subarray(intArray3, 0, 0);
        ArrayUtils.shuffle(intArray6);
        org.junit.Assert.assertNotNull(intArray3);
        org.junit.Assert.assertArrayEquals(intArray3, new int[] { 1, 1, 1 });
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertArrayEquals(intArray6, new int[] {});
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        java.util.regex.Pattern pattern1 = null;
        String str2 = RegExUtils.removeFirst((CharSequence) "javax.net.ssl.sessionCacheSize", pattern1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "javax.net.ssl.sessionCacheSize" + "'", str2, "javax.net.ssl.sessionCacheSize");
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        char[] charArray3 = new char[] { ' ', '4' };
        String str4 = org.apache.commons.lang3.text.WordUtils.capitalizeFully("", charArray3);
        ArrayUtils.swap(charArray3, (int) (short) 1, (int) '#');
        char[] charArray8 = ArrayUtils.nullToEmpty(charArray3);
        org.junit.Assert.assertNotNull(charArray3);
        org.junit.Assert.assertArrayEquals(charArray3, new char[] { ' ', '4' });
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertNotNull(charArray8);
        org.junit.Assert.assertArrayEquals(charArray8, new char[] { ' ', '4' });
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        long[] longArray0 = new long[] {};
        java.util.BitSet bitSet2 = ArrayUtils.indexesOf(longArray0, (long) 1);
        String str4 = StringUtils.join(longArray0, ' ');
        org.junit.Assert.assertNotNull(longArray0);
        org.junit.Assert.assertArrayEquals(longArray0, new long[] {});
        org.junit.Assert.assertNotNull(bitSet2);
        org.junit.Assert.assertEquals(bitSet2.toString(), "{}");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
        String[] strArray6 = new String[] { "Hi!", "Hi!", "Hi!" };
        String str7 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((Object) 0.0f, strArray6);
        String[] strArray12 = new String[] { "Hi!", "Hi!", "Hi!" };
        String str13 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((Object) 0.0f, strArray12);
        String str14 = StringUtils.replaceEach("sun.net.httpserver.nodelay", strArray6, strArray12);
        boolean boolean15 = StringUtils.equalsAny((CharSequence) "sun.net.httpserver.maxIdleConnections", (CharSequence[]) strArray6);
        org.junit.Assert.assertNotNull(strArray6);
        org.junit.Assert.assertArrayEquals(strArray6, new String[] { "Hi!", "Hi!", "Hi!" });
        org.junit.Assert.assertNotNull(strArray12);
        org.junit.Assert.assertArrayEquals(strArray12, new String[] { "Hi!", "Hi!", "Hi!" });
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "sun.net.httpserver.nodelay" + "'", str14, "sun.net.httpserver.nodelay");
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        String str0 = SystemProperties.JDK_HTTP_AUTH_PROXYING_DISABLED_SCHEMES;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "jdk.http.auth.proxying.disabledSchemes" + "'", str0, "jdk.http.auth.proxying.disabledSchemes");
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        org.apache.commons.lang3.function.FailableToLongFunction<Class<?>[], Throwable> wildcardClassArrayFailableToLongFunction0 = org.apache.commons.lang3.function.FailableToLongFunction.nop();
        org.junit.Assert.assertNotNull(wildcardClassArrayFailableToLongFunction0);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        ClassLoader classLoader0 = null;
        // The following exception was thrown during execution in test generation
        try {
            Class<?> wildcardClass3 = ClassUtils.getClass(classLoader0, "1", false);
            org.junit.Assert.fail("Expected exception of type java.lang.ClassNotFoundException; message: 1");
        } catch (ClassNotFoundException e) {
            // Expected exception.
        }
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        boolean boolean1 = StringUtils.isNotBlank((CharSequence) "sun.net.httpserver.maxIdleConnections");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        String str0 = SystemProperties.getJavaTimeZoneDefaultZoneRulesProvider();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        java.lang.reflect.Field[] fieldArray0 = ArrayUtils.EMPTY_FIELD_ARRAY;
        org.junit.Assert.assertNotNull(fieldArray0);
        org.junit.Assert.assertArrayEquals(fieldArray0, new java.lang.reflect.Field[] {});
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        String str1 = org.apache.commons.lang3.text.WordUtils.uncapitalize("[");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "[" + "'", str1, "[");
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        String str0 = SystemProperties.getComSunJndiLdapObjectTrustSerialData();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        char[] charArray4 = new char[] { ' ', '4' };
        String str5 = org.apache.commons.lang3.text.WordUtils.capitalizeFully("", charArray4);
        int int6 = StringUtils.indexOfAnyBut((CharSequence) "JAVAX.RMI.SSL.CLIENT.ENABLEDPROTOCOLS", charArray4);
        ArrayUtils.shuffle(charArray4);
        org.junit.Assert.assertNotNull(charArray4);
        org.junit.Assert.assertArrayEquals(charArray4, new char[] { '4', ' ' });
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        org.apache.commons.lang3.text.WordUtils wordUtils0 = new org.apache.commons.lang3.text.WordUtils();
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        java.util.concurrent.ExecutionException executionException0 = null;
        org.apache.commons.lang3.concurrent.ConcurrentUtils.handleCauseUnchecked(executionException0);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        String str2 = StringUtils.substringBetween("hi!", "sun.net.httpserver.nodelay");
        org.junit.Assert.assertNull(str2);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        java.lang.annotation.Annotation annotation0 = null;
        java.lang.annotation.Annotation annotation1 = null;
        boolean boolean2 = AnnotationUtils.equals(annotation0, annotation1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        boolean boolean0 = SystemUtils.IS_OS_MAC_OSX_CHEETAH;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        int int2 = BooleanUtils.compare(false, false);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        String str0 = SystemProperties.HTTP_NON_PROXY_HOSTS;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "http.nonProxyHosts" + "'", str0, "http.nonProxyHosts");
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        int int3 = org.apache.commons.lang3.math.NumberUtils.max((int) (short) 100, 1, (int) (short) 1);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        Integer[] intArray0 = ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY;
        org.junit.Assert.assertNotNull(intArray0);
        org.junit.Assert.assertArrayEquals(intArray0, new Integer[] {});
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        String str0 = SystemProperties.JDK_TLS_SERVER_SIGNATURE_SCHEMES;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "jdk.tls.server.SignatureSchemes" + "'", str0, "jdk.tls.server.SignatureSchemes");
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        org.apache.commons.lang3.mutable.MutableByte mutableByte1 = new org.apache.commons.lang3.mutable.MutableByte((byte) 1);
        String str2 = mutableByte1.toString();
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "1" + "'", str2, "1");
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        String str0 = SystemProperties.HTTP_MAX_REDIRECTS;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "http.maxRedirects" + "'", str0, "http.maxRedirects");
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        org.apache.commons.lang3.mutable.MutableByte mutableByte1 = new org.apache.commons.lang3.mutable.MutableByte((byte) 1);
        byte byte3 = mutableByte1.addAndGet((Number) (-1L));
        org.junit.Assert.assertTrue("'" + byte3 + "' != '" + (byte) 0 + "'", byte3 == (byte) 0);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        String str0 = SystemProperties.JAVA_VM_VERSION;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.vm.version" + "'", str0, "java.vm.version");
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        char char1 = Conversion.intToHexDigitMsb0((int) (byte) 1);
        org.junit.Assert.assertTrue("'" + char1 + "' != '" + '8' + "'", char1 == '8');
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        String str1 = StringUtils.strip("java.vm.version");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "java.vm.version" + "'", str1, "java.vm.version");
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        org.apache.commons.lang3.concurrent.AtomicInitializer<org.apache.commons.lang3.exception.ContextedException> contextedExceptionAtomicInitializer0 = new org.apache.commons.lang3.concurrent.AtomicInitializer<org.apache.commons.lang3.exception.ContextedException>();
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        org.apache.commons.lang3.text.translate.NumericEntityEscaper numericEntityEscaper1 = org.apache.commons.lang3.text.translate.NumericEntityEscaper.below((int) (byte) 1);
        org.junit.Assert.assertNotNull(numericEntityEscaper1);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        org.apache.commons.lang3.function.FailableObjDoubleConsumer<Class<?>[], Exception> wildcardClassArrayFailableObjDoubleConsumer0 = org.apache.commons.lang3.function.FailableObjDoubleConsumer.nop();
        org.junit.Assert.assertNotNull(wildcardClassArrayFailableObjDoubleConsumer0);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        // The following exception was thrown during execution in test generation
        try {
            Integer int1 = org.apache.commons.lang3.math.NumberUtils.createInteger("jdk.https.negotiate.cbt");
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: For input string: \"jdk.https.negotiate.cbt\"");
        } catch (NumberFormatException e) {
            // Expected exception.
        }
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        String str0 = SystemUtils.USER_DIR_KEY;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "user.dir" + "'", str0, "user.dir");
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        boolean[] booleanArray2 = new boolean[] { false, true };
        boolean boolean3 = ArrayUtils.isEmpty(booleanArray2);
        java.util.Random random4 = null;
        // The following exception was thrown during execution in test generation
        try {
            ArrayUtils.shuffle(booleanArray2, random4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanArray2);
        org.junit.Assert.assertArrayEquals(booleanArray2, new boolean[] { false, true });
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.mutable.MutableByte mutableByte1 = new org.apache.commons.lang3.mutable.MutableByte("");
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: For input string: \"\"");
        } catch (NumberFormatException e) {
            // Expected exception.
        }
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        java.util.Calendar calendar0 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long2 = org.apache.commons.lang3.time.DateUtils.getFragmentInSeconds(calendar0, (int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: calendar");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        java.util.concurrent.TimeUnit timeUnit2 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.concurrent.EventCountCircuitBreaker eventCountCircuitBreaker3 = new org.apache.commons.lang3.concurrent.EventCountCircuitBreaker(10, (long) (-1), timeUnit2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        org.apache.commons.lang3.concurrent.BasicThreadFactory.Builder builder0 = org.apache.commons.lang3.concurrent.BasicThreadFactory.builder();
        org.junit.Assert.assertNotNull(builder0);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        String str0 = SystemProperties.getJdkHttpClientRedirectsRetryLimit();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        CharSequence[] charSequenceArray2 = new CharSequence[] {};
        String str3 = StringUtils.prependIfMissingIgnoreCase("org.openjdk.java.util.stream.tripwire", (CharSequence) "\n", charSequenceArray2);
        org.junit.Assert.assertNotNull(charSequenceArray2);
        org.junit.Assert.assertArrayEquals(charSequenceArray2, new CharSequence[] {});
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "\norg.openjdk.java.util.stream.tripwire" + "'", str3, "\norg.openjdk.java.util.stream.tripwire");
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        Integer[] intArray3 = new Integer[] { 1, 1, 10 };
        Integer[] intArray4 = ArrayUtils.nullToEmpty(intArray3);
        String[] strArray10 = new String[] { "Hi!", "Hi!", "Hi!" };
        String str11 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((Object) 0.0f, strArray10);
        String[] strArray16 = new String[] { "Hi!", "Hi!", "Hi!" };
        String str17 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((Object) 0.0f, strArray16);
        String str18 = StringUtils.replaceEach("sun.net.httpserver.nodelay", strArray10, strArray16);
        org.apache.commons.lang3.compare.ObjectToStringComparator objectToStringComparator19 = new org.apache.commons.lang3.compare.ObjectToStringComparator();
        Range<Object> objRange20 = Range.of((Object) intArray4, (Object) "sun.net.httpserver.nodelay", (java.util.Comparator<Object>) objectToStringComparator19);
        org.junit.Assert.assertNotNull(intArray3);
        org.junit.Assert.assertArrayEquals(intArray3, new Integer[] { 1, 1, 10 });
        org.junit.Assert.assertNotNull(intArray4);
        org.junit.Assert.assertArrayEquals(intArray4, new Integer[] { 1, 1, 10 });
        org.junit.Assert.assertNotNull(strArray10);
        org.junit.Assert.assertArrayEquals(strArray10, new String[] { "Hi!", "Hi!", "Hi!" });
        org.junit.Assert.assertNotNull(strArray16);
        org.junit.Assert.assertArrayEquals(strArray16, new String[] { "Hi!", "Hi!", "Hi!" });
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "sun.net.httpserver.nodelay" + "'", str18, "sun.net.httpserver.nodelay");
        org.junit.Assert.assertNotNull(objRange20);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        // The following exception was thrown during execution in test generation
        try {
            Validate.isTrue(false, "javax.rmi.ssl.client.enabledProtocols", (double) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: javax.rmi.ssl.client.enabledProtocols");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        org.apache.commons.lang3.text.translate.NumericEntityEscaper numericEntityEscaper2 = org.apache.commons.lang3.text.translate.NumericEntityEscaper.outsideOf(100, (int) (byte) 10);
        org.junit.Assert.assertNotNull(numericEntityEscaper2);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        java.util.Date date0 = null;
        java.util.TimeZone timeZone2 = null;
        java.util.Locale locale3 = null;
        // The following exception was thrown during execution in test generation
        try {
            String str4 = org.apache.commons.lang3.time.DateFormatUtils.format(date0, "javax.rmi.ssl.client.enabledProtocols", timeZone2, locale3);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal pattern component: j");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        // The following exception was thrown during execution in test generation
        try {
            String str2 = StringUtils.abbreviate("jdk.http.auth.proxying.disabledSchemes", (int) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Minimum abbreviation width is 4");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        String str0 = SystemProperties.JAVAX_ACCESSIBILITY_ASSISTIVE_TECHNOLOGIES;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "javax.accessibility.assistive_technologies" + "'", str0, "javax.accessibility.assistive_technologies");
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        String str0 = SystemProperties.getJavaUtilLoggingConfigClass();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        boolean boolean0 = SystemUtils.IS_OS_MAC_OSX_YOSEMITE;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        java.util.Date date0 = null;
        java.util.Locale locale2 = null;
        // The following exception was thrown during execution in test generation
        try {
            String str3 = org.apache.commons.lang3.time.DateFormatUtils.format(date0, "java.locale.providers", locale2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal pattern component: j");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        java.util.concurrent.TimeUnit timeUnit1 = null;
        org.apache.commons.lang3.concurrent.TimedSemaphore timedSemaphore3 = new org.apache.commons.lang3.concurrent.TimedSemaphore((long) 'j', timeUnit1, (int) (short) 10);
        // The following exception was thrown during execution in test generation
        try {
            timedSemaphore3.acquire();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        java.util.List<java.util.Locale> localeList0 = LocaleUtils.availableLocaleList();
        org.junit.Assert.assertNotNull(localeList0);
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        String str0 = StringUtils.EMPTY;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "" + "'", str0, "");
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        String str0 = SystemProperties.getJavaxRmiSslClientEnabledCipherSuites();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        String str0 = SystemProperties.JDK_HTTP_CLIENT_KEEP_ALIVE_TIMEOUT_H2;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "jdk.httpclient.keepalive.timeout.h2" + "'", str0, "jdk.httpclient.keepalive.timeout.h2");
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test125");
        java.util.Date date0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date2 = org.apache.commons.lang3.time.DateUtils.setMonths(date0, (int) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test126");
        long[] longArray0 = new long[] {};
        java.util.BitSet bitSet2 = ArrayUtils.indexesOf(longArray0, (long) 1);
        Long[] longArray3 = ArrayUtils.toObject(longArray0);
        long[] longArray5 = ArrayUtils.removeElement(longArray0, (long) '4');
        ArrayUtils.swap(longArray0, 1, (int) 'a');
        org.junit.Assert.assertNotNull(longArray0);
        org.junit.Assert.assertArrayEquals(longArray0, new long[] {});
        org.junit.Assert.assertNotNull(bitSet2);
        org.junit.Assert.assertEquals(bitSet2.toString(), "{}");
        org.junit.Assert.assertNotNull(longArray3);
        org.junit.Assert.assertArrayEquals(longArray3, new Long[] {});
        org.junit.Assert.assertNotNull(longArray5);
        org.junit.Assert.assertArrayEquals(longArray5, new long[] {});
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test127");
        byte[] byteArray1 = new byte[] { (byte) -1 };
        boolean boolean2 = ArrayUtils.isSorted(byteArray1);
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertArrayEquals(byteArray1, new byte[] { (byte) -1 });
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test128");
        org.apache.commons.lang3.builder.ReflectionDiffBuilder.Builder<org.apache.commons.lang3.tuple.Pair<?, ?>[]> wildcardPairArrayBuilder0 = new org.apache.commons.lang3.builder.ReflectionDiffBuilder.Builder<org.apache.commons.lang3.tuple.Pair<?, ?>[]>();
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test129");
        String str0 = org.apache.commons.lang3.time.DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'" + "'", str0, "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'");
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test130");
        java.lang.reflect.Type[] typeArray0 = ArrayUtils.EMPTY_TYPE_ARRAY;
        org.junit.Assert.assertNotNull(typeArray0);
        org.junit.Assert.assertArrayEquals(typeArray0, new java.lang.reflect.Type[] {});
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test131");
        SerializationUtils serializationUtils0 = new SerializationUtils();
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test132");
        java.io.File file0 = SystemUtils.getUserHome();
        org.junit.Assert.assertNotNull(file0);
        org.junit.Assert.assertEquals(file0.getParent(), "/Users");
        org.junit.Assert.assertEquals(file0.toString(), "/Users/dianshuliao");
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test133");
        java.io.File[] fileArray0 = new java.io.File[] {};
        // The following exception was thrown during execution in test generation
        try {
            java.io.File file1 = ObjectUtils.median(fileArray0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The validated array is empty");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(fileArray0);
        org.junit.Assert.assertArrayEquals(fileArray0, new java.io.File[] {});
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test134");
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat0 = org.apache.commons.lang3.time.DateFormatUtils.ISO_TIME_NO_T_FORMAT;
        // The following exception was thrown during execution in test generation
        try {
            Object obj3 = org.apache.commons.lang3.reflect.FieldUtils.readDeclaredField((Object) fastDateFormat0, "jdk.httpclient.HttpClient.log", false);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot locate declared field class org.apache.commons.lang3.time.FastDateFormat.jdk.httpclient.HttpClient.log");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(fastDateFormat0);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test135");
        String str0 = SystemProperties.JAVA_PROPERTIES_DATE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.properties.date" + "'", str0, "java.properties.date");
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test136");
        java.util.stream.Collector<Object, ?, String> objCollector1 = org.apache.commons.lang3.stream.LangCollectors.joining((CharSequence) "jdk.httpclient.connectionPoolSizeHi!Hi!Hi!Hi!Hi!Hi!H");
        org.junit.Assert.assertNotNull(objCollector1);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test137");
        int int0 = org.apache.commons.lang3.time.DateUtils.RANGE_WEEK_MONDAY;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2 + "'", int0 == 2);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test138");
        String str0 = SystemProperties.JAVA_UTIL_LOGGING_CONFIG_CLASS;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.util.logging.config.class" + "'", str0, "java.util.logging.config.class");
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test139");
        org.apache.commons.lang3.builder.ReflectionToStringBuilder reflectionToStringBuilder1 = new org.apache.commons.lang3.builder.ReflectionToStringBuilder((Object) 10);
        long[] longArray3 = new long[] {};
        java.util.BitSet bitSet5 = ArrayUtils.indexesOf(longArray3, (long) 1);
        org.apache.commons.lang3.builder.ToStringBuilder toStringBuilder7 = reflectionToStringBuilder1.append("Integer", longArray3, true);
        org.junit.Assert.assertNotNull(longArray3);
        org.junit.Assert.assertArrayEquals(longArray3, new long[] {});
        org.junit.Assert.assertNotNull(bitSet5);
        org.junit.Assert.assertEquals(bitSet5.toString(), "{}");
        org.junit.Assert.assertNotNull(toStringBuilder7);
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test140");
        short[] shortArray0 = new short[] {};
        ArrayUtils.shuffle(shortArray0);
        short[] shortArray4 = ArrayUtils.subarray(shortArray0, (int) '#', (int) '4');
        short[] shortArray6 = ArrayUtils.addFirst(shortArray4, (short) 100);
        int int11 = Conversion.shortArrayToInt(shortArray4, (int) '8', (int) ' ', 0, (int) (byte) 0);
        org.junit.Assert.assertNotNull(shortArray0);
        org.junit.Assert.assertArrayEquals(shortArray0, new short[] {});
        org.junit.Assert.assertNotNull(shortArray4);
        org.junit.Assert.assertArrayEquals(shortArray4, new short[] {});
        org.junit.Assert.assertNotNull(shortArray6);
        org.junit.Assert.assertArrayEquals(shortArray6, new short[] { (short) 100 });
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 32 + "'", int11 == 32);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test141");
        Validate.notNaN((double) (-1L));
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test142");
        String str0 = SystemProperties.getJavaVmSpecificationName();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "Java Virtual Machine Specification" + "'", str0, "Java Virtual Machine Specification");
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test143");
        char[] charArray3 = new char[] { ' ', '4' };
        String str4 = org.apache.commons.lang3.text.WordUtils.capitalizeFully("", charArray3);
        char[] charArray6 = ArrayFill.fill(charArray3, 'a');
        ArrayUtils.swap(charArray6, (int) 'j', (int) '#');
        ArrayUtils.reverse(charArray6);
        org.junit.Assert.assertNotNull(charArray3);
        org.junit.Assert.assertArrayEquals(charArray3, new char[] { 'a', 'a' });
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { 'a', 'a' });
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test144");
        String str0 = SystemProperties.HTTP_AUTH_DIGEST_VALIDATE_PROXY;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "http.auth.digest.validateProxy" + "'", str0, "http.auth.digest.validateProxy");
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test145");
        ThreadUtils.ThreadIdPredicate threadIdPredicate1 = new ThreadUtils.ThreadIdPredicate((long) 100);
        org.apache.commons.lang3.builder.ReflectionToStringBuilder reflectionToStringBuilder3 = new org.apache.commons.lang3.builder.ReflectionToStringBuilder((Object) 10);
        org.apache.commons.lang3.tuple.MutablePair<ThreadUtils.ThreadPredicate, org.apache.commons.lang3.builder.ToStringBuilder> threadPredicateMutablePair4 = org.apache.commons.lang3.tuple.MutablePair.ofNonNull((ThreadUtils.ThreadPredicate) threadIdPredicate1, (org.apache.commons.lang3.builder.ToStringBuilder) reflectionToStringBuilder3);
        char[] charArray9 = new char[] { ' ', '4' };
        String str10 = org.apache.commons.lang3.text.WordUtils.capitalizeFully("", charArray9);
        char[] charArray12 = ArrayFill.fill(charArray9, 'a');
        org.apache.commons.lang3.builder.ToStringBuilder toStringBuilder14 = reflectionToStringBuilder3.append("", charArray12, true);
        org.junit.Assert.assertNotNull(threadPredicateMutablePair4);
        org.junit.Assert.assertNotNull(charArray9);
        org.junit.Assert.assertArrayEquals(charArray9, new char[] { 'a', 'a' });
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "" + "'", str10, "");
        org.junit.Assert.assertNotNull(charArray12);
        org.junit.Assert.assertArrayEquals(charArray12, new char[] { 'a', 'a' });
        org.junit.Assert.assertNotNull(toStringBuilder14);
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test146");
        double[] doubleArray1 = new double[] { 0L };
        double[] doubleArray4 = new double[] { 10, (byte) 100 };
        ArrayUtils.reverse(doubleArray4);
        boolean boolean6 = ArrayUtils.isSameLength(doubleArray1, doubleArray4);
        org.apache.commons.lang3.exception.ContextedException contextedException7 = new org.apache.commons.lang3.exception.ContextedException();
        Throwable[] throwableArray8 = org.apache.commons.lang3.exception.ExceptionUtils.getThrowables((Throwable) contextedException7);
        java.util.Set<String> strSet9 = contextedException7.getContextLabels();
        String str10 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringInclude((Object) doubleArray1, (java.util.Collection<String>) strSet9);
        org.junit.Assert.assertNotNull(doubleArray1);
        org.junit.Assert.assertArrayEquals(doubleArray1, new double[] { 0.0d }, 1.0E-15);
        org.junit.Assert.assertNotNull(doubleArray4);
        org.junit.Assert.assertArrayEquals(doubleArray4, new double[] { 100.0d, 10.0d }, 1.0E-15);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(throwableArray8);
        org.junit.Assert.assertNotNull(strSet9);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test147");
        org.apache.commons.lang3.text.StrMatcher strMatcher1 = null;
        org.apache.commons.lang3.text.StrMatcher strMatcher2 = null;
        org.apache.commons.lang3.text.StrTokenizer strTokenizer3 = new org.apache.commons.lang3.text.StrTokenizer("", strMatcher1, strMatcher2);
        org.apache.commons.lang3.text.StrMatcher strMatcher4 = strTokenizer3.getQuoteMatcher();
        int int5 = strTokenizer3.size();
        org.junit.Assert.assertNotNull(strMatcher4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test148");
        String str0 = SystemProperties.getHttpNonProxyHosts();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "local|*.local|169.254/16|*.169.254/16" + "'", str0, "local|*.local|169.254/16|*.169.254/16");
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test149");
        org.apache.commons.lang3.function.FailableDoubleFunction failableDoubleFunction0 = org.apache.commons.lang3.function.FailableDoubleFunction.NOP;
        org.junit.Assert.assertNotNull(failableDoubleFunction0);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test150");
        java.math.BigDecimal bigDecimal1 = org.apache.commons.lang3.math.NumberUtils.toScaledBigDecimal("1");
        java.math.BigDecimal bigDecimal2 = org.apache.commons.lang3.math.NumberUtils.toScaledBigDecimal(bigDecimal1);
        org.junit.Assert.assertNotNull(bigDecimal1);
        org.junit.Assert.assertNotNull(bigDecimal2);
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test151");
        // The following exception was thrown during execution in test generation
        try {
            Validate.exclusiveBetween((double) 10.0f, 1.0d, (double) (byte) -1, "sun.net.httpserver.maxIdleConnections");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: sun.net.httpserver.maxIdleConnections");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test152");
        ThreadGroup threadGroup1 = null;
        // The following exception was thrown during execution in test generation
        try {
            Thread thread2 = ThreadUtils.findThreadById((long) (-1), threadGroup1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: threadGroup");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test153");
        String str3 = StringUtils.replace("com.sun.net.httpserver.HttpServerProvider", "Integer", "jdk.httpclient.keepalive.timeout.h2");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "com.sun.net.httpserver.HttpServerProvider" + "'", str3, "com.sun.net.httpserver.HttpServerProvider");
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test154");
        java.util.TimeZone timeZone2 = null;
        // The following exception was thrown during execution in test generation
        try {
            String str3 = org.apache.commons.lang3.time.DateFormatUtils.format(0L, "jdk.http.auth.proxying.disabledSchemes", timeZone2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal pattern component: j");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test155");
        Long[] longArray3 = new Long[] { (-1L), 10L, 1L };
        long[] longArray5 = ArrayUtils.toPrimitive(longArray3, (long) (byte) 0);
        Long[] longArray6 = ArrayUtils.toObject(longArray5);
        org.junit.Assert.assertNotNull(longArray3);
        org.junit.Assert.assertArrayEquals(longArray3, new Long[] { (-1L), 10L, 1L });
        org.junit.Assert.assertNotNull(longArray5);
        org.junit.Assert.assertArrayEquals(longArray5, new long[] { (-1L), 10L, 1L });
        org.junit.Assert.assertNotNull(longArray6);
        org.junit.Assert.assertArrayEquals(longArray6, new Long[] { (-1L), 10L, 1L });
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test156");
        String str0 = SystemProperties.NETWORK_ADDRESS_CACHE_TTL;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "networkaddress.cache.ttl" + "'", str0, "networkaddress.cache.ttl");
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test157");
        ThreadUtils.ThreadIdPredicate threadIdPredicate1 = new ThreadUtils.ThreadIdPredicate((long) 100);
        org.apache.commons.lang3.builder.ReflectionToStringBuilder reflectionToStringBuilder3 = new org.apache.commons.lang3.builder.ReflectionToStringBuilder((Object) 10);
        org.apache.commons.lang3.tuple.MutablePair<ThreadUtils.ThreadPredicate, org.apache.commons.lang3.builder.ToStringBuilder> threadPredicateMutablePair4 = org.apache.commons.lang3.tuple.MutablePair.ofNonNull((ThreadUtils.ThreadPredicate) threadIdPredicate1, (org.apache.commons.lang3.builder.ToStringBuilder) reflectionToStringBuilder3);
        org.apache.commons.lang3.builder.ReflectionToStringBuilder reflectionToStringBuilder6 = new org.apache.commons.lang3.builder.ReflectionToStringBuilder((Object) 10);
        org.apache.commons.lang3.builder.ToStringBuilder toStringBuilder7 = reflectionToStringBuilder3.appendAsObjectToString((Object) reflectionToStringBuilder6);
        short[] shortArray9 = new short[] {};
        ArrayUtils.shuffle(shortArray9);
        org.apache.commons.lang3.builder.ToStringBuilder toStringBuilder12 = reflectionToStringBuilder6.append("org.openjdk.java.util.stream.tripwire", shortArray9, true);
        Class<?> wildcardClass13 = reflectionToStringBuilder6.getUpToClass();
        org.junit.Assert.assertNotNull(threadPredicateMutablePair4);
        org.junit.Assert.assertNotNull(toStringBuilder7);
        org.junit.Assert.assertNotNull(shortArray9);
        org.junit.Assert.assertArrayEquals(shortArray9, new short[] {});
        org.junit.Assert.assertNotNull(toStringBuilder12);
        org.junit.Assert.assertNull(wildcardClass13);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test158");
        String[] strArray3 = StringUtils.splitByWholeSeparator("null", "hi!", 1);
        org.junit.Assert.assertNotNull(strArray3);
        org.junit.Assert.assertArrayEquals(strArray3, new String[] { "null" });
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test159");
        String str0 = SystemProperties.getJavaSpecificationMaintenanceVersion();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test160");
        ThreadUtils.ThreadIdPredicate threadIdPredicate1 = new ThreadUtils.ThreadIdPredicate((long) 100);
        org.apache.commons.lang3.builder.ReflectionToStringBuilder reflectionToStringBuilder3 = new org.apache.commons.lang3.builder.ReflectionToStringBuilder((Object) 10);
        org.apache.commons.lang3.tuple.MutablePair<ThreadUtils.ThreadPredicate, org.apache.commons.lang3.builder.ToStringBuilder> threadPredicateMutablePair4 = org.apache.commons.lang3.tuple.MutablePair.ofNonNull((ThreadUtils.ThreadPredicate) threadIdPredicate1, (org.apache.commons.lang3.builder.ToStringBuilder) reflectionToStringBuilder3);
        org.apache.commons.lang3.builder.ReflectionToStringBuilder reflectionToStringBuilder6 = new org.apache.commons.lang3.builder.ReflectionToStringBuilder((Object) 10);
        org.apache.commons.lang3.builder.ToStringBuilder toStringBuilder7 = reflectionToStringBuilder3.appendAsObjectToString((Object) reflectionToStringBuilder6);
        byte[] byteArray15 = new byte[] { (byte) 1, (byte) 100, (byte) 10, (byte) 1, (byte) 0, (byte) 0 };
        org.apache.commons.lang3.builder.ToStringBuilder toStringBuilder17 = reflectionToStringBuilder3.append("org.openjdk.java.util.stream.tripwire", byteArray15, false);
        float[] floatArray19 = null;
        org.apache.commons.lang3.builder.ToStringBuilder toStringBuilder20 = reflectionToStringBuilder3.append("http.maxRedirects", floatArray19);
        org.junit.Assert.assertNotNull(threadPredicateMutablePair4);
        org.junit.Assert.assertNotNull(toStringBuilder7);
        org.junit.Assert.assertNotNull(byteArray15);
        org.junit.Assert.assertArrayEquals(byteArray15, new byte[] { (byte) 1, (byte) 100, (byte) 10, (byte) 1, (byte) 0, (byte) 0 });
        org.junit.Assert.assertNotNull(toStringBuilder17);
        org.junit.Assert.assertNotNull(toStringBuilder20);
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test161");
        java.util.Locale locale1 = null;
        String str2 = StringUtils.upperCase("http.auth.digest.validateProxy", locale1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "HTTP.AUTH.DIGEST.VALIDATEPROXY" + "'", str2, "HTTP.AUTH.DIGEST.VALIDATEPROXY");
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test162");
        JavaVersion javaVersion0 = JavaVersion.JAVA_16;
        boolean boolean1 = SystemUtils.isJavaVersionAtMost(javaVersion0);
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + JavaVersion.JAVA_16 + "'", javaVersion0.equals(JavaVersion.JAVA_16));
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test163");
        String str0 = SystemProperties.getJavaClassVersion();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "52.0" + "'", str0, "52.0");
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test164");
        java.lang.reflect.Method[] methodArray0 = ArrayUtils.EMPTY_METHOD_ARRAY;
        org.junit.Assert.assertNotNull(methodArray0);
        org.junit.Assert.assertArrayEquals(methodArray0, new java.lang.reflect.Method[] {});
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test165");
        RandomStringUtils randomStringUtils0 = RandomStringUtils.secureStrong();
        // The following exception was thrown during execution in test generation
        try {
            String str3 = randomStringUtils0.nextAlphabetic((int) (byte) 1, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Start value must be smaller or equal to end value.");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(randomStringUtils0);
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test166");
        BooleanUtils booleanUtils0 = new BooleanUtils();
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test167");
        boolean boolean1 = BooleanUtils.isTrue((Boolean) true);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test168");
        org.apache.commons.lang3.function.FailableLongPredicate<Throwable> throwableFailableLongPredicate0 = org.apache.commons.lang3.function.FailableLongPredicate.truePredicate();
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate0);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test169");
        String str0 = SystemProperties.getJavaVendor();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "Oracle Corporation" + "'", str0, "Oracle Corporation");
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test170");
        byte[] byteArray6 = new byte[] { (byte) 1, (byte) 1, (byte) 0, (byte) 1, (byte) 0, (byte) -1 };
        ArrayUtils.swap(byteArray6, (int) 'a', (int) 'a');
        ThreadUtils.ThreadIdPredicate threadIdPredicate11 = new ThreadUtils.ThreadIdPredicate((long) 100);
        org.apache.commons.lang3.builder.ReflectionToStringBuilder reflectionToStringBuilder13 = new org.apache.commons.lang3.builder.ReflectionToStringBuilder((Object) 10);
        org.apache.commons.lang3.tuple.MutablePair<ThreadUtils.ThreadPredicate, org.apache.commons.lang3.builder.ToStringBuilder> threadPredicateMutablePair14 = org.apache.commons.lang3.tuple.MutablePair.ofNonNull((ThreadUtils.ThreadPredicate) threadIdPredicate11, (org.apache.commons.lang3.builder.ToStringBuilder) reflectionToStringBuilder13);
        org.apache.commons.lang3.builder.ReflectionToStringBuilder reflectionToStringBuilder16 = new org.apache.commons.lang3.builder.ReflectionToStringBuilder((Object) 10);
        org.apache.commons.lang3.builder.ToStringBuilder toStringBuilder17 = reflectionToStringBuilder13.appendAsObjectToString((Object) reflectionToStringBuilder16);
        byte[] byteArray25 = new byte[] { (byte) 1, (byte) 100, (byte) 10, (byte) 1, (byte) 0, (byte) 0 };
        org.apache.commons.lang3.builder.ToStringBuilder toStringBuilder27 = reflectionToStringBuilder13.append("org.openjdk.java.util.stream.tripwire", byteArray25, false);
        boolean boolean28 = ArrayUtils.startsWith(byteArray6, byteArray25);
        ArrayUtils.reverse(byteArray25, (int) (short) -1, (int) (short) 100);
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertArrayEquals(byteArray6, new byte[] { (byte) 1, (byte) 1, (byte) 0, (byte) 1, (byte) 0, (byte) -1 });
        org.junit.Assert.assertNotNull(threadPredicateMutablePair14);
        org.junit.Assert.assertNotNull(toStringBuilder17);
        org.junit.Assert.assertNotNull(byteArray25);
        org.junit.Assert.assertArrayEquals(byteArray25, new byte[] { (byte) 0, (byte) 0, (byte) 1, (byte) 10, (byte) 100, (byte) 1 });
        org.junit.Assert.assertNotNull(toStringBuilder27);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test171");
        String str0 = StringUtils.CR;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "\r" + "'", str0, "\r");
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test172");
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator0 = StringEscapeUtils.UNESCAPE_HTML4;
        org.junit.Assert.assertNotNull(charSequenceTranslator0);
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test173");
        float float3 = org.apache.commons.lang3.math.NumberUtils.max((float) (byte) -1, 0.0f, (float) '#');
        org.junit.Assert.assertTrue("'" + float3 + "' != '" + 35.0f + "'", float3 == 35.0f);
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test174");
        // The following exception was thrown during execution in test generation
        try {
            Boolean boolean4 = BooleanUtils.toBooleanObject((Integer) 1, (Integer) (-1), (Integer) 2, (Integer) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The Integer did not match any specified value");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test175");
        String str0 = SystemProperties.getUserCountry();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "AU" + "'", str0, "AU");
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test176");
        java.util.Calendar calendar0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Calendar calendar2 = org.apache.commons.lang3.time.DateUtils.ceiling(calendar0, 2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: calendar");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test177");
        boolean boolean0 = SystemUtils.IS_JAVA_1_7;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test178");
        boolean boolean0 = SystemUtils.IS_JAVA_1_6;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test179");
        java.util.concurrent.TimeUnit timeUnit1 = null;
        org.apache.commons.lang3.concurrent.TimedSemaphore timedSemaphore3 = new org.apache.commons.lang3.concurrent.TimedSemaphore((long) 'a', timeUnit1, (int) (byte) 10);
        // The following exception was thrown during execution in test generation
        try {
            timedSemaphore3.acquire();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test180");
        org.apache.commons.lang3.arch.Processor processor0 = ArchUtils.getProcessor();
        org.junit.Assert.assertNotNull(processor0);
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test181");
        boolean[] booleanArray2 = new boolean[] { false, true };
        boolean boolean3 = ArrayUtils.isEmpty(booleanArray2);
        boolean[] booleanArray6 = ArrayUtils.subarray(booleanArray2, (int) ' ', (-1));
        ArrayUtils.reverse(booleanArray6, (int) '0', (int) (short) 10);
        org.junit.Assert.assertNotNull(booleanArray2);
        org.junit.Assert.assertArrayEquals(booleanArray2, new boolean[] { false, true });
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(booleanArray6);
        org.junit.Assert.assertArrayEquals(booleanArray6, new boolean[] {});
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test182");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.time.FastDateFormat fastDateFormat2 = org.apache.commons.lang3.time.FastDateFormat.getDateTimeInstance((-1), 32);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal time style 32");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test183");
        java.util.Calendar calendar0 = null;
        java.util.Calendar calendar1 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean3 = org.apache.commons.lang3.time.DateUtils.truncatedEquals(calendar0, calendar1, (int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test184");
        String str0 = SystemProperties.JAVA_NIO_CHANNELS_DEFAULT_THREAD_POOL_THREAD_FACTORY;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.nio.channels.DefaultThreadPool.threadFactory" + "'", str0, "java.nio.channels.DefaultThreadPool.threadFactory");
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test185");
        String str0 = SystemProperties.getFileSeparator();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "/" + "'", str0, "/");
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test186");
        Boolean boolean1 = BooleanUtils.toBooleanObject((int) '0');
        org.junit.Assert.assertEquals("'" + boolean1 + "' != '" + true + "'", boolean1, true);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test187");
        char[] charArray3 = new char[] { ' ', '4' };
        String str4 = org.apache.commons.lang3.text.WordUtils.capitalizeFully("", charArray3);
        ArrayUtils.swap(charArray3, (int) (short) 1, (int) '#');
        String[] strArray12 = new String[] { "Hi!", "Hi!", "Hi!" };
        String str13 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((Object) 0.0f, strArray12);
        String str14 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((Object) '#', strArray12);
        String[] strArray16 = ArrayUtils.toStringArray((Object[]) strArray12, "Java Virtual Machine Specification");
        org.junit.Assert.assertNotNull(charArray3);
        org.junit.Assert.assertArrayEquals(charArray3, new char[] { ' ', '4' });
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertNotNull(strArray12);
        org.junit.Assert.assertArrayEquals(strArray12, new String[] { "Hi!", "Hi!", "Hi!" });
        org.junit.Assert.assertNotNull(strArray16);
        org.junit.Assert.assertArrayEquals(strArray16, new String[] { "Hi!", "Hi!", "Hi!" });
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test188");
        String str2 = RegExUtils.removeFirst("52.0", "java.nio.channels.DefaultThreadPool.threadFactory");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "52.0" + "'", str2, "52.0");
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test189");
        String str0 = SystemProperties.getNetworkAddressCacheTtl();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test190");
        org.apache.commons.lang3.compare.ObjectToStringComparator objectToStringComparator0 = org.apache.commons.lang3.compare.ObjectToStringComparator.INSTANCE;
        org.junit.Assert.assertNotNull(objectToStringComparator0);
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test191");
        java.util.concurrent.TimeUnit timeUnit1 = null;
        org.apache.commons.lang3.concurrent.TimedSemaphore timedSemaphore3 = new org.apache.commons.lang3.concurrent.TimedSemaphore((long) 'a', timeUnit1, (int) (byte) 10);
        timedSemaphore3.shutdown();
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test192");
        CharSequence[] charSequenceArray1 = null;
        boolean boolean2 = StringUtils.equalsAnyIgnoreCase((CharSequence) "jdk.httpclient.connectionPoolSize", charSequenceArray1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test193");
        String str2 = StringUtils.substringBefore("org.openjdk.java.util.stream.tripwire", "jdk.http.auth.proxying.disabledSchemes");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "org.openjdk.java.util.stream.tripwire" + "'", str2, "org.openjdk.java.util.stream.tripwire");
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test194");
        String str0 = SystemProperties.getUserExtensions();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test195");
        boolean[] booleanArray2 = new boolean[] { false, true };
        boolean boolean3 = ArrayUtils.isEmpty(booleanArray2);
        boolean boolean4 = BooleanUtils.xor(booleanArray2);
        boolean[] booleanArray6 = ArrayUtils.add(booleanArray2, false);
        org.junit.Assert.assertNotNull(booleanArray2);
        org.junit.Assert.assertArrayEquals(booleanArray2, new boolean[] { false, true });
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(booleanArray6);
        org.junit.Assert.assertArrayEquals(booleanArray6, new boolean[] { false, true, false });
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test196");
        Long[] longArray4 = new Long[] { 1L, 1L, 10L, (-1L) };
        long[] longArray6 = ArrayUtils.toPrimitive(longArray4, (long) 'j');
        String str8 = StringUtils.join(longArray6, '4');
        org.junit.Assert.assertNotNull(longArray4);
        org.junit.Assert.assertArrayEquals(longArray4, new Long[] { 1L, 1L, 10L, (-1L) });
        org.junit.Assert.assertNotNull(longArray6);
        org.junit.Assert.assertArrayEquals(longArray6, new long[] { 1L, 1L, 10L, (-1L) });
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "1414104-1" + "'", str8, "1414104-1");
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test197");
        Short[] shortArray3 = new Short[] { (short) 10, (short) -1, (short) -1 };
        Short[] shortArray4 = ArrayUtils.nullToEmpty(shortArray3);
        org.junit.Assert.assertNotNull(shortArray3);
        org.junit.Assert.assertArrayEquals(shortArray3, new Short[] { (short) 10, (short) -1, (short) -1 });
        org.junit.Assert.assertNotNull(shortArray4);
        org.junit.Assert.assertArrayEquals(shortArray4, new Short[] { (short) 10, (short) -1, (short) -1 });
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test198");
        boolean[] booleanArray1 = new boolean[] { false };
        char char3 = Conversion.binaryBeMsb0ToHexDigit(booleanArray1, (int) (byte) 0);
        boolean boolean4 = BooleanUtils.or(booleanArray1);
        org.junit.Assert.assertNotNull(booleanArray1);
        org.junit.Assert.assertArrayEquals(booleanArray1, new boolean[] { false });
        org.junit.Assert.assertTrue("'" + char3 + "' != '" + '0' + "'", char3 == '0');
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test199");
        org.apache.commons.lang3.text.StrMatcher strMatcher1 = null;
        org.apache.commons.lang3.text.StrMatcher strMatcher2 = null;
        org.apache.commons.lang3.text.StrTokenizer strTokenizer3 = new org.apache.commons.lang3.text.StrTokenizer("", strMatcher1, strMatcher2);
        org.apache.commons.lang3.text.StrMatcher strMatcher4 = strTokenizer3.getQuoteMatcher();
        String[] strArray11 = new String[] { "Hi!", "Hi!", "Hi!" };
        String str12 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((Object) 0.0f, strArray11);
        String[] strArray17 = new String[] { "Hi!", "Hi!", "Hi!" };
        String str18 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((Object) 0.0f, strArray17);
        String str19 = StringUtils.replaceEach("sun.net.httpserver.nodelay", strArray11, strArray17);
        // The following exception was thrown during execution in test generation
        try {
            Object obj20 = org.apache.commons.lang3.reflect.MethodUtils.invokeExactMethod((Object) strMatcher4, "52.0", (Object[]) strArray11);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodException; message: No such accessible method: 52.0() on object: org.apache.commons.lang3.text.StrMatcher$NoMatcher");
        } catch (NoSuchMethodException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strMatcher4);
        org.junit.Assert.assertNotNull(strArray11);
        org.junit.Assert.assertArrayEquals(strArray11, new String[] { "Hi!", "Hi!", "Hi!" });
        org.junit.Assert.assertNotNull(strArray17);
        org.junit.Assert.assertArrayEquals(strArray17, new String[] { "Hi!", "Hi!", "Hi!" });
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "sun.net.httpserver.nodelay" + "'", str19, "sun.net.httpserver.nodelay");
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test200");
        org.apache.commons.lang3.concurrent.ThresholdCircuitBreaker thresholdCircuitBreaker1 = new org.apache.commons.lang3.concurrent.ThresholdCircuitBreaker(0L);
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test201");
        int[] intArray3 = new int[] { 1, 1, (short) 1 };
        int[] intArray6 = ArrayUtils.subarray(intArray3, 0, 0);
        int[] intArray7 = ArrayUtils.clone(intArray3);
        int int8 = org.apache.commons.lang3.math.NumberUtils.max(intArray3);
        org.junit.Assert.assertNotNull(intArray3);
        org.junit.Assert.assertArrayEquals(intArray3, new int[] { 1, 1, 1 });
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertArrayEquals(intArray6, new int[] {});
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertArrayEquals(intArray7, new int[] { 1, 1, 1 });
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 1 + "'", int8 == 1);
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test202");
        Long[] longArray4 = new Long[] { 1L, 1L, 10L, (-1L) };
        long[] longArray6 = ArrayUtils.toPrimitive(longArray4, (long) 'j');
        int int9 = ArrayUtils.lastIndexOf(longArray6, (long) (short) 1, (int) ' ');
        org.junit.Assert.assertNotNull(longArray4);
        org.junit.Assert.assertArrayEquals(longArray4, new Long[] { 1L, 1L, 10L, (-1L) });
        org.junit.Assert.assertNotNull(longArray6);
        org.junit.Assert.assertArrayEquals(longArray6, new long[] { 1L, 1L, 10L, (-1L) });
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 1 + "'", int9 == 1);
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test203");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.mutable.MutableDouble mutableDouble1 = new org.apache.commons.lang3.mutable.MutableDouble("AU");
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: For input string: \"AU\"");
        } catch (NumberFormatException e) {
            // Expected exception.
        }
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test204");
        org.apache.commons.lang3.time.StopWatch stopWatch0 = org.apache.commons.lang3.time.StopWatch.create();
        boolean boolean1 = stopWatch0.isStarted();
        boolean boolean2 = stopWatch0.isSuspended();
        org.junit.Assert.assertNotNull(stopWatch0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test205");
        int int2 = CharUtils.compare('j', 'j');
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test206");
        RandomStringUtils randomStringUtils0 = RandomStringUtils.secure();
        org.junit.Assert.assertNotNull(randomStringUtils0);
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test207");
        String str0 = SystemProperties.JAVA_UTIL_CONCURRENT_FORK_JOIN_POOL_COMMON_MAXIMUM_SPARES;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.util.concurrent.ForkJoinPool.common.maximumSpares" + "'", str0, "java.util.concurrent.ForkJoinPool.common.maximumSpares");
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test208");
        org.apache.commons.lang3.text.StrMatcher strMatcher1 = null;
        org.apache.commons.lang3.text.StrMatcher strMatcher2 = null;
        org.apache.commons.lang3.text.StrTokenizer strTokenizer3 = new org.apache.commons.lang3.text.StrTokenizer("", strMatcher1, strMatcher2);
        org.apache.commons.lang3.text.StrMatcher strMatcher4 = strTokenizer3.getQuoteMatcher();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer5 = strTokenizer3.reset();
        java.util.function.Consumer<Object> objConsumer6 = org.apache.commons.lang3.function.Consumers.nop();
        strTokenizer5.forEachRemaining(objConsumer6);
        org.junit.Assert.assertNotNull(strMatcher4);
        org.junit.Assert.assertNotNull(strTokenizer5);
        org.junit.Assert.assertNotNull(objConsumer6);
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test209");
        org.apache.commons.lang3.reflect.MethodUtils methodUtils0 = new org.apache.commons.lang3.reflect.MethodUtils();
        org.apache.commons.lang3.reflect.MethodUtils methodUtils1 = new org.apache.commons.lang3.reflect.MethodUtils();
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle2 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.builder.DiffBuilder<org.apache.commons.lang3.reflect.MethodUtils> methodUtilsDiffBuilder4 = new org.apache.commons.lang3.builder.DiffBuilder<org.apache.commons.lang3.reflect.MethodUtils>(methodUtils0, methodUtils1, (org.apache.commons.lang3.builder.ToStringStyle) multilineRecursiveToStringStyle2, false);
        Long[] longArray9 = new Long[] { (-1L), 10L, 1L };
        long[] longArray11 = ArrayUtils.toPrimitive(longArray9, (long) (byte) 0);
        long[] longArray12 = new long[] {};
        java.util.BitSet bitSet14 = ArrayUtils.indexesOf(longArray12, 10L);
        org.apache.commons.lang3.builder.DiffBuilder<org.apache.commons.lang3.reflect.MethodUtils> methodUtilsDiffBuilder15 = methodUtilsDiffBuilder4.append("java.util.logging.config.class", longArray11, longArray12);
        org.apache.commons.lang3.builder.DiffBuilder<org.apache.commons.lang3.reflect.MethodUtils> methodUtilsDiffBuilder19 = methodUtilsDiffBuilder4.append("jdk.tls.server.SignatureSchemes", (double) (short) 1, (double) 3776573491206566018L);
        org.junit.Assert.assertNotNull(longArray9);
        org.junit.Assert.assertArrayEquals(longArray9, new Long[] { (-1L), 10L, 1L });
        org.junit.Assert.assertNotNull(longArray11);
        org.junit.Assert.assertArrayEquals(longArray11, new long[] { (-1L), 10L, 1L });
        org.junit.Assert.assertNotNull(longArray12);
        org.junit.Assert.assertArrayEquals(longArray12, new long[] {});
        org.junit.Assert.assertNotNull(bitSet14);
        org.junit.Assert.assertEquals(bitSet14.toString(), "{}");
        org.junit.Assert.assertNotNull(methodUtilsDiffBuilder15);
        org.junit.Assert.assertNotNull(methodUtilsDiffBuilder19);
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test210");
        short[] shortArray0 = new short[] {};
        ArrayUtils.shuffle(shortArray0);
        short[] shortArray4 = ArrayUtils.subarray(shortArray0, (int) '#', (int) '4');
        short[] shortArray5 = ArrayUtils.nullToEmpty(shortArray4);
        org.junit.Assert.assertNotNull(shortArray0);
        org.junit.Assert.assertArrayEquals(shortArray0, new short[] {});
        org.junit.Assert.assertNotNull(shortArray4);
        org.junit.Assert.assertArrayEquals(shortArray4, new short[] {});
        org.junit.Assert.assertNotNull(shortArray5);
        org.junit.Assert.assertArrayEquals(shortArray5, new short[] {});
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test211");
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle0 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        String str2 = ClassUtils.getShortCanonicalName((Object) multilineRecursiveToStringStyle0, "Oracle Corporation");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "MultilineRecursiveToStringStyle" + "'", str2, "MultilineRecursiveToStringStyle");
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test212");
        org.apache.commons.lang3.math.Fraction fraction0 = org.apache.commons.lang3.math.Fraction.ONE;
        org.apache.commons.lang3.math.Fraction fraction1 = org.apache.commons.lang3.math.Fraction.ONE;
        org.apache.commons.lang3.math.Fraction fraction2 = fraction0.multiplyBy(fraction1);
        org.junit.Assert.assertNotNull(fraction0);
        org.junit.Assert.assertNotNull(fraction1);
        org.junit.Assert.assertNotNull(fraction2);
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test213");
        java.util.concurrent.ScheduledExecutorService scheduledExecutorService0 = null;
        java.util.concurrent.TimeUnit timeUnit2 = null;
        org.apache.commons.lang3.concurrent.TimedSemaphore timedSemaphore4 = new org.apache.commons.lang3.concurrent.TimedSemaphore(scheduledExecutorService0, (long) 1, timeUnit2, 100);
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test214");
        org.apache.commons.lang3.text.StrMatcher strMatcher1 = null;
        org.apache.commons.lang3.text.StrMatcher strMatcher2 = null;
        org.apache.commons.lang3.text.StrTokenizer strTokenizer3 = new org.apache.commons.lang3.text.StrTokenizer("", strMatcher1, strMatcher2);
        org.apache.commons.lang3.text.StrMatcher strMatcher4 = strTokenizer3.getQuoteMatcher();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer5 = strTokenizer3.reset();
        // The following exception was thrown during execution in test generation
        try {
            String str6 = strTokenizer5.previous();
            org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException; message: null");
        } catch (java.util.NoSuchElementException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strMatcher4);
        org.junit.Assert.assertNotNull(strTokenizer5);
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test215");
        String str0 = SystemProperties.JDK_HTTP_CLIENT_MAX_STREAMS;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "jdk.httpclient.maxstreams" + "'", str0, "jdk.httpclient.maxstreams");
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test216");
        String str0 = SystemProperties.JDK_JNDI_RMI_OBJECT_FACTORIES_FILTER;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "jdk.jndi.rmi.object.factoriesFilter" + "'", str0, "jdk.jndi.rmi.object.factoriesFilter");
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test217");
        org.apache.commons.lang3.text.translate.NumericEntityEscaper numericEntityEscaper2 = org.apache.commons.lang3.text.translate.NumericEntityEscaper.outsideOf((int) (byte) 0, (int) (byte) -1);
        org.junit.Assert.assertNotNull(numericEntityEscaper2);
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test218");
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper0 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test219");
        String str0 = SystemProperties.HTTP_AUTH_DIGEST_CNONCE_REPEAT;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "http.auth.digest.cnonceRepeat" + "'", str0, "http.auth.digest.cnonceRepeat");
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test220");
        double[] doubleArray1 = new double[] { 0L };
        double[] doubleArray4 = new double[] { 10, (byte) 100 };
        ArrayUtils.reverse(doubleArray4);
        boolean boolean6 = ArrayUtils.isSameLength(doubleArray1, doubleArray4);
        double[] doubleArray7 = ArrayUtils.nullToEmpty(doubleArray1);
        org.junit.Assert.assertNotNull(doubleArray1);
        org.junit.Assert.assertArrayEquals(doubleArray1, new double[] { 0.0d }, 1.0E-15);
        org.junit.Assert.assertNotNull(doubleArray4);
        org.junit.Assert.assertArrayEquals(doubleArray4, new double[] { 100.0d, 10.0d }, 1.0E-15);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(doubleArray7);
        org.junit.Assert.assertArrayEquals(doubleArray7, new double[] { 0.0d }, 1.0E-15);
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test221");
        double[] doubleArray1 = new double[] { 0L };
        double[] doubleArray4 = new double[] { 10, (byte) 100 };
        ArrayUtils.reverse(doubleArray4);
        boolean boolean6 = ArrayUtils.isSameLength(doubleArray1, doubleArray4);
        ArrayUtils.swap(doubleArray1, (int) '#', (int) (byte) 100);
        org.junit.Assert.assertNotNull(doubleArray1);
        org.junit.Assert.assertArrayEquals(doubleArray1, new double[] { 0.0d }, 1.0E-15);
        org.junit.Assert.assertNotNull(doubleArray4);
        org.junit.Assert.assertArrayEquals(doubleArray4, new double[] { 100.0d, 10.0d }, 1.0E-15);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test222");
        String str0 = SystemProperties.JAVA_NIO_CHANNELS_SPI_ASYNCHRONOUS_CHANNEL_PROVIDER;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.nio.channels.spi.AsynchronousChannelProvider" + "'", str0, "java.nio.channels.spi.AsynchronousChannelProvider");
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test223");
        org.apache.commons.lang3.time.StopWatch stopWatch0 = org.apache.commons.lang3.time.StopWatch.create();
        boolean boolean1 = stopWatch0.isStarted();
        boolean boolean2 = stopWatch0.isStopped();
        stopWatch0.reset();
        org.junit.Assert.assertNotNull(stopWatch0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test224");
        org.apache.commons.lang3.function.FailableObjLongConsumer<org.apache.commons.lang3.function.FailableObjDoubleConsumer<Class<?>[], Exception>, org.apache.commons.lang3.exception.ContextedException> wildcardClassArrayFailableObjDoubleConsumerFailableObjLongConsumer0 = org.apache.commons.lang3.function.FailableObjLongConsumer.nop();
        org.junit.Assert.assertNotNull(wildcardClassArrayFailableObjDoubleConsumerFailableObjLongConsumer0);
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test225");
        String str2 = StringUtils.wrap("java.locale.providers", '#');
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "#java.locale.providers#" + "'", str2, "#java.locale.providers#");
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test226");
        org.apache.commons.lang3.text.translate.CodePointTranslator[] codePointTranslatorArray0 = new org.apache.commons.lang3.text.translate.CodePointTranslator[] {};
        org.apache.commons.lang3.text.translate.NumericEntityEscaper numericEntityEscaper3 = org.apache.commons.lang3.text.translate.NumericEntityEscaper.outsideOf(100, (int) (byte) 1);
        org.apache.commons.lang3.text.translate.CodePointTranslator[] codePointTranslatorArray4 = ArrayUtils.addFirst(codePointTranslatorArray0, (org.apache.commons.lang3.text.translate.CodePointTranslator) numericEntityEscaper3);
        org.junit.Assert.assertNotNull(codePointTranslatorArray0);
        org.junit.Assert.assertArrayEquals(codePointTranslatorArray0, new org.apache.commons.lang3.text.translate.CodePointTranslator[] {});
        org.junit.Assert.assertNotNull(numericEntityEscaper3);
        org.junit.Assert.assertNotNull(codePointTranslatorArray4);
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test227");
        java.util.Date date0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date2 = org.apache.commons.lang3.time.DateUtils.setSeconds(date0, (int) 'j');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test228");
        java.util.Set<java.util.Locale> localeSet0 = LocaleUtils.availableLocaleSet();
        java.util.Spliterator<java.util.Locale> localeSpliterator1 = localeSet0.spliterator();
        org.junit.Assert.assertNotNull(localeSet0);
        org.junit.Assert.assertNotNull(localeSpliterator1);
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test229");
        double double3 = org.apache.commons.lang3.math.IEEE754rUtils.max((-1.0d), 100.0d, (double) (short) 1);
        org.junit.Assert.assertTrue("'" + double3 + "' != '" + 100.0d + "'", double3 == 100.0d);
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test230");
        char[] charArray3 = new char[] { ' ', '4' };
        String str4 = org.apache.commons.lang3.text.WordUtils.capitalizeFully("", charArray3);
        char[] charArray6 = ArrayFill.fill(charArray3, 'a');
        ArrayUtils.swap(charArray6, (int) 'j', (int) '#');
        ArrayUtils.swap(charArray6, (int) '4', 10);
        org.junit.Assert.assertNotNull(charArray3);
        org.junit.Assert.assertArrayEquals(charArray3, new char[] { 'a', 'a' });
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertArrayEquals(charArray6, new char[] { 'a', 'a' });
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test231");
        String str0 = SystemUtils.JAVA_AWT_PRINTERJOB;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "sun.lwawt.macosx.CPrinterJob" + "'", str0, "sun.lwawt.macosx.CPrinterJob");
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test232");
        String str0 = SystemProperties.getSunNetHttpServerMaxReqTime();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test233");
        java.util.TimeZone timeZone1 = org.apache.commons.lang3.time.FastTimeZone.getGmtTimeZone("java.util.concurrent.ForkJoinPool.common.maximumSpares");
        org.junit.Assert.assertNull(timeZone1);
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test234");
        org.apache.commons.lang3.math.Fraction fraction0 = org.apache.commons.lang3.math.Fraction.ONE_QUARTER;
        org.junit.Assert.assertNotNull(fraction0);
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test235");
        org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION[] oPTIONArray0 = new org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION[] {};
        org.apache.commons.lang3.text.translate.NumericEntityUnescaper numericEntityUnescaper1 = new org.apache.commons.lang3.text.translate.NumericEntityUnescaper(oPTIONArray0);
        org.junit.Assert.assertNotNull(oPTIONArray0);
        org.junit.Assert.assertArrayEquals(oPTIONArray0, new org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION[] {});
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test236");
        // The following exception was thrown during execution in test generation
        try {
            Validate.isTrue(false, "jdk.httpclient.maxstreams", 0.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: jdk.httpclient.maxstreams");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test237");
        String str5 = Conversion.shortToHex((short) 1, (int) ' ', "jdk.httpclient.connectionPoolSizeHi!Hi!Hi!Hi!Hi!Hi!H", (int) (byte) 1, (int) (byte) 0);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "jdk.httpclient.connectionPoolSizeHi!Hi!Hi!Hi!Hi!Hi!H" + "'", str5, "jdk.httpclient.connectionPoolSizeHi!Hi!Hi!Hi!Hi!Hi!H");
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test238");
        org.apache.commons.lang3.mutable.MutableFloat mutableFloat0 = new org.apache.commons.lang3.mutable.MutableFloat();
        org.apache.commons.lang3.mutable.MutableFloat mutableFloat1 = new org.apache.commons.lang3.mutable.MutableFloat();
        int int2 = mutableFloat0.compareTo(mutableFloat1);
        String[] strArray10 = new String[] { "Hi!", "Hi!", "Hi!" };
        String str11 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((Object) 0.0f, strArray10);
        String[] strArray16 = new String[] { "Hi!", "Hi!", "Hi!" };
        String str17 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((Object) 0.0f, strArray16);
        String str18 = StringUtils.replaceEach("sun.net.httpserver.nodelay", strArray10, strArray16);
        Class<?>[] wildcardClassArray19 = ArrayUtils.EMPTY_CLASS_ARRAY;
        // The following exception was thrown during execution in test generation
        try {
            Object obj20 = org.apache.commons.lang3.reflect.MethodUtils.invokeMethod((Object) mutableFloat1, false, "org.openjdk.java.util.stream.tripwire", (Object[]) strArray10, wildcardClassArray19);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodException; message: No such accessible method: org.openjdk.java.util.stream.tripwire() on object: org.apache.commons.lang3.mutable.MutableFloat");
        } catch (NoSuchMethodException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(strArray10);
        org.junit.Assert.assertArrayEquals(strArray10, new String[] { "Hi!", "Hi!", "Hi!" });
        org.junit.Assert.assertNotNull(strArray16);
        org.junit.Assert.assertArrayEquals(strArray16, new String[] { "Hi!", "Hi!", "Hi!" });
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "sun.net.httpserver.nodelay" + "'", str18, "sun.net.httpserver.nodelay");
        org.junit.Assert.assertNotNull(wildcardClassArray19);
        org.junit.Assert.assertArrayEquals(wildcardClassArray19, new Class[] {});
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test239");
        int int3 = org.apache.commons.lang3.math.NumberUtils.max(100, (int) (short) 10, (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test240");
        String str0 = SystemProperties.JAVA_UTIL_LOGGING_CONFIG_FILE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.util.logging.config.file" + "'", str0, "java.util.logging.config.file");
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test241");
        JavaVersion javaVersion0 = JavaVersion.JAVA_11;
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + JavaVersion.JAVA_11 + "'", javaVersion0.equals(JavaVersion.JAVA_11));
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test242");
        double[] doubleArray1 = new double[] { 0L };
        double[] doubleArray4 = new double[] { 10, (byte) 100 };
        ArrayUtils.reverse(doubleArray4);
        boolean boolean6 = ArrayUtils.isSameLength(doubleArray1, doubleArray4);
        int[] intArray7 = ArrayUtils.EMPTY_INT_ARRAY;
        double[] doubleArray8 = ArrayUtils.removeAll(doubleArray1, intArray7);
        int[] intArray10 = ArrayUtils.add(intArray7, (int) (short) 10);
        org.junit.Assert.assertNotNull(doubleArray1);
        org.junit.Assert.assertArrayEquals(doubleArray1, new double[] { 0.0d }, 1.0E-15);
        org.junit.Assert.assertNotNull(doubleArray4);
        org.junit.Assert.assertArrayEquals(doubleArray4, new double[] { 100.0d, 10.0d }, 1.0E-15);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertArrayEquals(intArray7, new int[] {});
        org.junit.Assert.assertNotNull(doubleArray8);
        org.junit.Assert.assertArrayEquals(doubleArray8, new double[] { 0.0d }, 1.0E-15);
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] { 10 });
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test243");
        java.util.stream.Stream<org.apache.commons.lang3.text.translate.UnicodeUnescaper> unicodeUnescaperStream0 = null;
        org.apache.commons.lang3.stream.Streams.FailableStream<org.apache.commons.lang3.text.translate.UnicodeUnescaper> unicodeUnescaperFailableStream1 = new org.apache.commons.lang3.stream.Streams.FailableStream<org.apache.commons.lang3.text.translate.UnicodeUnescaper>(unicodeUnescaperStream0);
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test244");
        JavaVersion javaVersion1 = JavaVersion.JAVA_1_6;
        JavaVersion[] javaVersionArray2 = new JavaVersion[] { javaVersion1 };
        JavaVersion[] javaVersionArray4 = ArrayUtils.remove(javaVersionArray2, (int) (byte) 0);
        org.apache.commons.lang3.exception.ContextedException contextedException5 = new org.apache.commons.lang3.exception.ContextedException();
        Throwable[] throwableArray6 = org.apache.commons.lang3.exception.ExceptionUtils.getThrowables((Throwable) contextedException5);
        java.util.Set<String> strSet7 = contextedException5.getContextLabels();
        boolean boolean8 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals((Object) 10.0d, (Object) (byte) 0, (java.util.Collection<String>) strSet7);
        org.junit.Assert.assertTrue("'" + javaVersion1 + "' != '" + JavaVersion.JAVA_1_6 + "'", javaVersion1.equals(JavaVersion.JAVA_1_6));
        org.junit.Assert.assertNotNull(javaVersionArray2);
        org.junit.Assert.assertArrayEquals(javaVersionArray2, new JavaVersion[] { JavaVersion.JAVA_1_6 });
        org.junit.Assert.assertNotNull(javaVersionArray4);
        org.junit.Assert.assertArrayEquals(javaVersionArray4, new JavaVersion[] {});
        org.junit.Assert.assertNotNull(throwableArray6);
        org.junit.Assert.assertNotNull(strSet7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test245");
        String str0 = SystemProperties.getJavaNioFileSpiDefaultFileSystemProvider();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test246");
        boolean boolean0 = SystemUtils.IS_JAVA_19;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test247");
        java.util.Locale locale0 = null;
        java.util.List<java.util.Locale> localeList1 = LocaleUtils.localeLookupList(locale0);
        org.junit.Assert.assertNotNull(localeList1);
    }
}
