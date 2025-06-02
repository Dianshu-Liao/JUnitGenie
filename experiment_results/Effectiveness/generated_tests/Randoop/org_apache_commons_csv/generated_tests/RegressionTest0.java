package org.apache.commons.csv;

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
        QuoteMode quoteMode0 = QuoteMode.MINIMAL;
        org.junit.Assert.assertTrue("'" + quoteMode0 + "' != '" + QuoteMode.MINIMAL + "'", quoteMode0.equals(QuoteMode.MINIMAL));
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        java.io.Reader reader0 = null;
        CSVFormat cSVFormat1 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser2 = CSVParser.parse(reader0, cSVFormat1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        CSVFormat.Predefined predefined0 = CSVFormat.Predefined.Default;
        org.junit.Assert.assertTrue("'" + predefined0 + "' != '" + CSVFormat.Predefined.Default + "'", predefined0.equals(CSVFormat.Predefined.Default));
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test004");
        java.io.InputStream inputStream0 = null;
        java.nio.charset.Charset charset1 = null;
        CSVFormat cSVFormat2 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser3 = CSVParser.parse(inputStream0, charset1, cSVFormat2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: inputStream");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test005");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        String[] strArray2 = cSVFormat1.getHeaderComments();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNull(strArray2);
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        Object obj3 = null;
        Appendable appendable4 = null;
        // The following exception was thrown during execution in test generation
        try {
            cSVFormat0.print(obj3, appendable4, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        CSVFormat.Predefined predefined0 = CSVFormat.Predefined.MySQL;
        org.junit.Assert.assertTrue("'" + predefined0 + "' != '" + CSVFormat.Predefined.MySQL + "'", predefined0.equals(CSVFormat.Predefined.MySQL));
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        CSVFormat cSVFormat4 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat5 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode6 = cSVFormat5.getDuplicateHeaderMode();
        CSVFormat cSVFormat8 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray9 = new Object[] { (short) 1, 0.0d, cSVFormat4, cSVFormat5, ' ', cSVFormat8 };
        CSVFormat cSVFormat10 = cSVFormat1.withHeaderComments(objArray9);
        Appendable appendable12 = null;
        // The following exception was thrown during execution in test generation
        try {
            cSVFormat10.print((Object) 0, appendable12, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode6 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode6.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(objArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat10);
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        CSVFormat.Predefined predefined0 = CSVFormat.Predefined.InformixUnload;
        org.junit.Assert.assertTrue("'" + predefined0 + "' != '" + CSVFormat.Predefined.InformixUnload + "'", predefined0.equals(CSVFormat.Predefined.InformixUnload));
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        CSVFormat.Predefined predefined0 = CSVFormat.Predefined.Oracle;
        org.junit.Assert.assertTrue("'" + predefined0 + "' != '" + CSVFormat.Predefined.Oracle + "'", predefined0.equals(CSVFormat.Predefined.Oracle));
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        CSVFormat cSVFormat1 = CSVFormat.newFormat('\\');
        org.junit.Assert.assertNotNull(cSVFormat1);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        CSVFormat.Predefined predefined1 = CSVFormat.Predefined.PostgreSQLCsv;
        CSVFormat cSVFormat2 = predefined1.getFormat();
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser3 = CSVParser.parse("", cSVFormat2);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.csv.CSVParser$Builder.getReader()Ljava/io/Reader;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + predefined1 + "' != '" + CSVFormat.Predefined.PostgreSQLCsv + "'", predefined1.equals(CSVFormat.Predefined.PostgreSQLCsv));
        org.junit.Assert.assertNotNull(cSVFormat2);
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        CSVFormat.Predefined predefined0 = CSVFormat.Predefined.TDF;
        org.junit.Assert.assertTrue("'" + predefined0 + "' != '" + CSVFormat.Predefined.TDF + "'", predefined0.equals(CSVFormat.Predefined.TDF));
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat2 = cSVFormat0.withSkipHeaderRecord(false);
        QuoteMode quoteMode3 = QuoteMode.NONE;
        CSVFormat cSVFormat4 = cSVFormat2.withQuoteMode(quoteMode3);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertTrue("'" + quoteMode3 + "' != '" + QuoteMode.NONE + "'", quoteMode3.equals(QuoteMode.NONE));
        org.junit.Assert.assertNotNull(cSVFormat4);
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        CSVFormat cSVFormat0 = CSVFormat.EXCEL;
        org.junit.Assert.assertNotNull(cSVFormat0);
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        CSVFormat.Predefined predefined0 = CSVFormat.Predefined.MongoDBTsv;
        org.junit.Assert.assertTrue("'" + predefined0 + "' != '" + CSVFormat.Predefined.MongoDBTsv + "'", predefined0.equals(CSVFormat.Predefined.MongoDBTsv));
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        DuplicateHeaderMode duplicateHeaderMode0 = DuplicateHeaderMode.ALLOW_EMPTY;
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode0 + "' != '" + DuplicateHeaderMode.ALLOW_EMPTY + "'", duplicateHeaderMode0.equals(DuplicateHeaderMode.ALLOW_EMPTY));
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        CSVFormat.Predefined predefined0 = CSVFormat.Predefined.Excel;
        org.junit.Assert.assertTrue("'" + predefined0 + "' != '" + CSVFormat.Predefined.Excel + "'", predefined0.equals(CSVFormat.Predefined.Excel));
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        Character char2 = cSVFormat1.getCommentMarker();
        CSVFormat cSVFormat4 = cSVFormat1.withDelimiter('4');
        Appendable appendable5 = null;
        CSVFormat cSVFormat6 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat7 = cSVFormat6.withSystemRecordSeparator();
        CSVFormat cSVFormat10 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat11 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode12 = cSVFormat11.getDuplicateHeaderMode();
        CSVFormat cSVFormat14 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray15 = new Object[] { (short) 1, 0.0d, cSVFormat10, cSVFormat11, ' ', cSVFormat14 };
        CSVFormat cSVFormat16 = cSVFormat7.withHeaderComments(objArray15);
        String[] strArray22 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat23 = cSVFormat7.withHeader(strArray22);
        // The following exception was thrown during execution in test generation
        try {
            cSVFormat4.printRecord(appendable5, (Object[]) strArray22);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNull(char2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertNotNull(cSVFormat11);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode12 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode12.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat14);
        org.junit.Assert.assertNotNull(objArray15);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray15), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray15), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat16);
        org.junit.Assert.assertNotNull(strArray22);
        org.junit.Assert.assertArrayEquals(strArray22, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat23);
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        CSVFormat cSVFormat1 = CSVFormat.newFormat(' ');
        boolean boolean2 = cSVFormat1.isEscapeCharacterSet();
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        Character char2 = cSVFormat1.getCommentMarker();
        CSVFormat cSVFormat4 = cSVFormat1.withDelimiter('4');
        // The following exception was thrown during execution in test generation
        try {
            CSVFormat cSVFormat6 = cSVFormat1.withCommentMarker((Character) '\\');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The comment start and the escape character cannot be the same ('\\')");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNull(char2);
        org.junit.Assert.assertNotNull(cSVFormat4);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat2 = cSVFormat0.withSkipHeaderRecord(false);
        boolean boolean3 = cSVFormat2.getTrim();
        String str4 = cSVFormat2.getNullString();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "\\N" + "'", str4, "\\N");
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        CSVFormat cSVFormat4 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat5 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode6 = cSVFormat5.getDuplicateHeaderMode();
        CSVFormat cSVFormat8 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray9 = new Object[] { (short) 1, 0.0d, cSVFormat4, cSVFormat5, ' ', cSVFormat8 };
        CSVFormat cSVFormat10 = cSVFormat1.withHeaderComments(objArray9);
        CSVFormat cSVFormat11 = CSVFormat.INFORMIX_UNLOAD_CSV;
        CSVFormat cSVFormat12 = cSVFormat11.withFirstRecordAsHeader();
        Appendable appendable13 = null;
        // The following exception was thrown during execution in test generation
        try {
            cSVFormat10.print((Object) cSVFormat12, appendable13, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode6 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode6.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(objArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertNotNull(cSVFormat11);
        org.junit.Assert.assertNotNull(cSVFormat12);
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        CSVFormat cSVFormat0 = CSVFormat.ORACLE;
        org.junit.Assert.assertNotNull(cSVFormat0);
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withTrailingDelimiter(false);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        CSVFormat.Predefined predefined0 = CSVFormat.Predefined.RFC4180;
        org.junit.Assert.assertTrue("'" + predefined0 + "' != '" + CSVFormat.Predefined.RFC4180 + "'", predefined0.equals(CSVFormat.Predefined.RFC4180));
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        CSVFormat cSVFormat2 = cSVFormat1.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat1.withDelimiter('a');
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        CSVParser.Builder builder0 = CSVParser.builder();
        java.nio.file.Path path1 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser.Builder builder2 = builder0.setPath(path1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        DuplicateHeaderMode duplicateHeaderMode0 = DuplicateHeaderMode.ALLOW_ALL;
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode0 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode0.equals(DuplicateHeaderMode.ALLOW_ALL));
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat2 = cSVFormat0.withSkipHeaderRecord(false);
        boolean boolean3 = cSVFormat2.getTrim();
        boolean boolean4 = cSVFormat2.isEscapeCharacterSet();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        CSVFormat cSVFormat0 = CSVFormat.INFORMIX_UNLOAD;
        CSVFormat cSVFormat2 = cSVFormat0.withRecordSeparator("hi!");
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat2);
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        java.nio.file.Path path0 = null;
        java.nio.charset.Charset charset1 = null;
        CSVFormat cSVFormat2 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat3 = cSVFormat2.withSystemRecordSeparator();
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser4 = CSVParser.parse(path0, charset1, cSVFormat2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: path");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat3);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        java.sql.ResultSetMetaData resultSetMetaData3 = null;
        CSVFormat cSVFormat4 = cSVFormat2.withHeader(resultSetMetaData3);
        CSVFormat cSVFormat5 = cSVFormat4.withIgnoreSurroundingSpaces();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        CSVParser.Builder builder0 = CSVParser.builder();
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser1 = builder0.get();
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.csv.CSVParser$Builder.getReader()Ljava/io/Reader;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test035");
        java.nio.file.Path path0 = null;
        java.nio.charset.Charset charset1 = null;
        CSVFormat cSVFormat2 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat3 = cSVFormat2.withSystemRecordSeparator();
        Character char4 = cSVFormat3.getCommentMarker();
        CSVFormat cSVFormat6 = cSVFormat3.withDelimiter('4');
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser7 = CSVParser.parse(path0, charset1, cSVFormat3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: path");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat3);
        org.junit.Assert.assertNull(char4);
        org.junit.Assert.assertNotNull(cSVFormat6);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        CSVFormat cSVFormat1 = CSVFormat.newFormat('\t');
        org.junit.Assert.assertNotNull(cSVFormat1);
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        Appendable appendable7 = null;
        // The following exception was thrown during execution in test generation
        try {
            cSVFormat2.println(appendable7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        QuoteMode quoteMode0 = QuoteMode.NON_NUMERIC;
        org.junit.Assert.assertTrue("'" + quoteMode0 + "' != '" + QuoteMode.NON_NUMERIC + "'", quoteMode0.equals(QuoteMode.NON_NUMERIC));
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat7 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat8 = cSVFormat7.withSystemRecordSeparator();
        CSVFormat cSVFormat11 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat12 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode13 = cSVFormat12.getDuplicateHeaderMode();
        CSVFormat cSVFormat15 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray16 = new Object[] { (short) 1, 0.0d, cSVFormat11, cSVFormat12, ' ', cSVFormat15 };
        CSVFormat cSVFormat17 = cSVFormat8.withHeaderComments(objArray16);
        String[] strArray23 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat24 = cSVFormat8.withHeader(strArray23);
        CSVFormat cSVFormat25 = cSVFormat2.withHeaderComments((Object[]) strArray23);
        CSVFormat cSVFormat26 = cSVFormat25.withAllowDuplicateHeaderNames();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(cSVFormat11);
        org.junit.Assert.assertNotNull(cSVFormat12);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode13 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode13.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat15);
        org.junit.Assert.assertNotNull(objArray16);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray16), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray16), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat17);
        org.junit.Assert.assertNotNull(strArray23);
        org.junit.Assert.assertArrayEquals(strArray23, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat24);
        org.junit.Assert.assertNotNull(cSVFormat25);
        org.junit.Assert.assertNotNull(cSVFormat26);
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        CSVParser.Builder builder0 = CSVParser.builder();
        java.io.InputStream inputStream1 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser.Builder builder2 = builder0.setInputStream(inputStream1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        CSVFormat cSVFormat0 = CSVFormat.INFORMIX_UNLOAD;
        String str1 = cSVFormat0.toString();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" + "'", str1, "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false");
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        boolean boolean2 = cSVFormat0.isQuoteCharacterSet();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        CSVParser.Builder builder0 = CSVParser.builder();
        java.io.Writer writer1 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser.Builder builder2 = builder0.setWriter(writer1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        java.net.URL uRL0 = null;
        java.nio.charset.Charset charset1 = null;
        CSVFormat cSVFormat2 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat3 = cSVFormat2.withSystemRecordSeparator();
        Character char4 = cSVFormat3.getCommentMarker();
        CSVFormat cSVFormat6 = cSVFormat3.withDelimiter('4');
        boolean boolean7 = cSVFormat3.isCommentMarkerSet();
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser8 = CSVParser.parse(uRL0, charset1, cSVFormat3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: url");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat3);
        org.junit.Assert.assertNull(char4);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        java.io.Writer writer5 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser.Builder builder6 = builder0.setWriter(writer5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        CSVFormat cSVFormat0 = CSVFormat.DEFAULT;
        org.junit.Assert.assertNotNull(cSVFormat0);
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        QuoteMode quoteMode0 = QuoteMode.ALL;
        org.junit.Assert.assertTrue("'" + quoteMode0 + "' != '" + QuoteMode.ALL + "'", quoteMode0.equals(QuoteMode.ALL));
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat.Builder builder13 = builder9.setSkipHeaderRecord(false);
        CSVFormat.Builder builder15 = builder9.setCommentMarker('\t');
        CSVFormat.Builder builder17 = builder15.setQuote((Character) '4');
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(builder15);
        org.junit.Assert.assertNotNull(builder17);
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        String str3 = cSVFormat0.toString();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false" + "'", str3, "Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false");
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        // The following exception was thrown during execution in test generation
        try {
            CSVFormat.Builder builder11 = builder9.setDelimiter("Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The delimiter cannot be a line break");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        CSVParser.Builder builder0 = CSVParser.builder();
        java.nio.charset.Charset charset1 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser.Builder builder2 = builder0.setCharset(charset1);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.Charsets.toCharset(Ljava/nio/charset/Charset;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        // The following exception was thrown during execution in test generation
        try {
            CSVParser.Builder builder6 = builder4.setCharset("");
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.Charsets.toCharset(Ljava/lang/String;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        boolean boolean7 = cSVFormat2.getSkipHeaderRecord();
        Character char8 = cSVFormat2.getCommentMarker();
        boolean boolean9 = cSVFormat2.getTrailingDelimiter();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNull(char8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat6 = cSVFormat4.withEscape((Character) ' ');
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat6);
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        String str2 = cSVFormat0.getDelimiterString();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "\t" + "'", str2, "\t");
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        CSVFormat cSVFormat0 = CSVFormat.INFORMIX_UNLOAD_CSV;
        CSVFormat cSVFormat1 = cSVFormat0.withFirstRecordAsHeader();
        boolean boolean2 = cSVFormat0.getSkipHeaderRecord();
        boolean boolean3 = cSVFormat0.isNullStringSet();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        CSVParser.Builder builder6 = builder0.setTrackBytes(false);
        java.io.InputStream inputStream7 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser.Builder builder8 = builder6.setInputStream(inputStream7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(builder6);
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        CSVFormat.Predefined predefined0 = CSVFormat.Predefined.MongoDBCsv;
        org.junit.Assert.assertTrue("'" + predefined0 + "' != '" + CSVFormat.Predefined.MongoDBCsv + "'", predefined0.equals(CSVFormat.Predefined.MongoDBCsv));
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        CSVFormat cSVFormat1 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode2 = cSVFormat1.getDuplicateHeaderMode();
        CSVFormat cSVFormat3 = cSVFormat1.withAllowMissingColumnNames();
        java.sql.ResultSetMetaData resultSetMetaData4 = null;
        CSVFormat cSVFormat5 = cSVFormat3.withHeader(resultSetMetaData4);
        long long6 = cSVFormat5.getMaxRows();
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser7 = CSVParser.parse("hi!", cSVFormat5);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.csv.CSVParser$Builder.getReader()Ljava/io/Reader;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode2 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode2.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat3);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + long6 + "' != '" + 0L + "'", long6 == 0L);
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat2 = cSVFormat0.withSkipHeaderRecord(false);
        boolean boolean3 = cSVFormat0.getIgnoreSurroundingSpaces();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        // The following exception was thrown during execution in test generation
        try {
            CSVParser.Builder builder6 = builder0.setCharset("Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false");
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.Charsets.toCharset(Ljava/lang/String;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat cSVFormat12 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode13 = cSVFormat12.getDuplicateHeaderMode();
        CSVFormat cSVFormat14 = cSVFormat12.withAllowMissingColumnNames();
        CSVFormat cSVFormat16 = cSVFormat14.withRecordSeparator("");
        CSVFormat cSVFormat17 = cSVFormat14.withTrim();
        CSVFormat cSVFormat18 = cSVFormat14.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat19 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat20 = cSVFormat19.withSystemRecordSeparator();
        CSVFormat cSVFormat23 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat24 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode25 = cSVFormat24.getDuplicateHeaderMode();
        CSVFormat cSVFormat27 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray28 = new Object[] { (short) 1, 0.0d, cSVFormat23, cSVFormat24, ' ', cSVFormat27 };
        CSVFormat cSVFormat29 = cSVFormat20.withHeaderComments(objArray28);
        String[] strArray35 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat36 = cSVFormat20.withHeader(strArray35);
        CSVFormat cSVFormat37 = cSVFormat14.withHeaderComments((Object[]) strArray35);
        CSVFormat.Builder builder38 = builder11.setHeaderComments((Object[]) strArray35);
        CSVFormat.Builder builder40 = builder11.setMaxRows((long) 0);
        CSVFormat.Builder builder42 = builder40.setNullString("Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false");
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(cSVFormat12);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode13 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode13.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat14);
        org.junit.Assert.assertNotNull(cSVFormat16);
        org.junit.Assert.assertNotNull(cSVFormat17);
        org.junit.Assert.assertNotNull(cSVFormat18);
        org.junit.Assert.assertNotNull(cSVFormat19);
        org.junit.Assert.assertNotNull(cSVFormat20);
        org.junit.Assert.assertNotNull(cSVFormat23);
        org.junit.Assert.assertNotNull(cSVFormat24);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode25 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode25.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat27);
        org.junit.Assert.assertNotNull(objArray28);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray28), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray28), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat29);
        org.junit.Assert.assertNotNull(strArray35);
        org.junit.Assert.assertArrayEquals(strArray35, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat36);
        org.junit.Assert.assertNotNull(cSVFormat37);
        org.junit.Assert.assertNotNull(builder38);
        org.junit.Assert.assertNotNull(builder40);
        org.junit.Assert.assertNotNull(builder42);
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat.Builder builder13 = builder9.setSkipHeaderRecord(false);
        CSVFormat.Builder builder15 = builder9.setCommentMarker('\t');
        String[] strArray18 = new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" };
        CSVFormat.Builder builder19 = builder15.setHeader(strArray18);
        java.sql.ResultSetMetaData resultSetMetaData20 = null;
        CSVFormat.Builder builder21 = builder15.setHeader(resultSetMetaData20);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(builder15);
        org.junit.Assert.assertNotNull(strArray18);
        org.junit.Assert.assertArrayEquals(strArray18, new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" });
        org.junit.Assert.assertNotNull(builder19);
        org.junit.Assert.assertNotNull(builder21);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        CSVFormat cSVFormat1 = CSVFormat.newFormat(' ');
        CSVFormat cSVFormat2 = cSVFormat1.withTrailingDelimiter();
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat2);
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        String str6 = cSVFormat5.toString();
        CSVFormat cSVFormat7 = cSVFormat5.withIgnoreHeaderCase();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false" + "'", str6, "Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false");
        org.junit.Assert.assertNotNull(cSVFormat7);
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat cSVFormat10 = cSVFormat6.withIgnoreEmptyLines();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(cSVFormat10);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat7 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVPrinter cSVPrinter8 = cSVFormat2.printer();
        java.sql.ResultSet resultSet9 = null;
        // The following exception was thrown during execution in test generation
        try {
            cSVPrinter8.printRecords(resultSet9, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertNotNull(cSVPrinter8);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        Appendable appendable7 = null;
        CSVFormat cSVFormat8 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode9 = cSVFormat8.getDuplicateHeaderMode();
        CSVFormat cSVFormat10 = cSVFormat8.withAllowMissingColumnNames();
        CSVFormat cSVFormat12 = cSVFormat10.withRecordSeparator("");
        CSVFormat cSVFormat13 = cSVFormat10.withTrim();
        CSVFormat cSVFormat14 = cSVFormat10.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat16 = cSVFormat14.withRecordSeparator(' ');
        CSVFormat.Builder builder17 = CSVFormat.Builder.create(cSVFormat14);
        CSVFormat.Builder builder19 = builder17.setRecordSeparator('a');
        CSVFormat cSVFormat20 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode21 = cSVFormat20.getDuplicateHeaderMode();
        CSVFormat cSVFormat22 = cSVFormat20.withAllowMissingColumnNames();
        CSVFormat cSVFormat24 = cSVFormat22.withRecordSeparator("");
        CSVFormat cSVFormat25 = cSVFormat22.withTrim();
        CSVFormat cSVFormat26 = cSVFormat22.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat27 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat28 = cSVFormat27.withSystemRecordSeparator();
        CSVFormat cSVFormat31 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat32 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode33 = cSVFormat32.getDuplicateHeaderMode();
        CSVFormat cSVFormat35 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray36 = new Object[] { (short) 1, 0.0d, cSVFormat31, cSVFormat32, ' ', cSVFormat35 };
        CSVFormat cSVFormat37 = cSVFormat28.withHeaderComments(objArray36);
        String[] strArray43 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat44 = cSVFormat28.withHeader(strArray43);
        CSVFormat cSVFormat45 = cSVFormat22.withHeaderComments((Object[]) strArray43);
        CSVFormat.Builder builder46 = builder19.setHeaderComments((Object[]) strArray43);
        // The following exception was thrown during execution in test generation
        try {
            cSVFormat2.printRecord(appendable7, (Object[]) strArray43);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode9 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode9.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertNotNull(cSVFormat12);
        org.junit.Assert.assertNotNull(cSVFormat13);
        org.junit.Assert.assertNotNull(cSVFormat14);
        org.junit.Assert.assertNotNull(cSVFormat16);
        org.junit.Assert.assertNotNull(builder17);
        org.junit.Assert.assertNotNull(builder19);
        org.junit.Assert.assertNotNull(cSVFormat20);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode21 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode21.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat22);
        org.junit.Assert.assertNotNull(cSVFormat24);
        org.junit.Assert.assertNotNull(cSVFormat25);
        org.junit.Assert.assertNotNull(cSVFormat26);
        org.junit.Assert.assertNotNull(cSVFormat27);
        org.junit.Assert.assertNotNull(cSVFormat28);
        org.junit.Assert.assertNotNull(cSVFormat31);
        org.junit.Assert.assertNotNull(cSVFormat32);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode33 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode33.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat35);
        org.junit.Assert.assertNotNull(objArray36);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray36), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray36), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat37);
        org.junit.Assert.assertNotNull(strArray43);
        org.junit.Assert.assertArrayEquals(strArray43, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat44);
        org.junit.Assert.assertNotNull(cSVFormat45);
        org.junit.Assert.assertNotNull(builder46);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat cSVFormat12 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode13 = cSVFormat12.getDuplicateHeaderMode();
        CSVFormat cSVFormat14 = cSVFormat12.withAllowMissingColumnNames();
        CSVFormat cSVFormat16 = cSVFormat14.withRecordSeparator("");
        CSVFormat cSVFormat17 = cSVFormat14.withTrim();
        CSVFormat cSVFormat18 = cSVFormat14.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat19 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat20 = cSVFormat19.withSystemRecordSeparator();
        CSVFormat cSVFormat23 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat24 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode25 = cSVFormat24.getDuplicateHeaderMode();
        CSVFormat cSVFormat27 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray28 = new Object[] { (short) 1, 0.0d, cSVFormat23, cSVFormat24, ' ', cSVFormat27 };
        CSVFormat cSVFormat29 = cSVFormat20.withHeaderComments(objArray28);
        String[] strArray35 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat36 = cSVFormat20.withHeader(strArray35);
        CSVFormat cSVFormat37 = cSVFormat14.withHeaderComments((Object[]) strArray35);
        CSVFormat.Builder builder38 = builder11.setHeaderComments((Object[]) strArray35);
        CSVFormat.Builder builder40 = builder38.setMaxRows((long) (byte) 100);
        CSVFormat.Builder builder42 = builder38.setIgnoreHeaderCase(true);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(cSVFormat12);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode13 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode13.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat14);
        org.junit.Assert.assertNotNull(cSVFormat16);
        org.junit.Assert.assertNotNull(cSVFormat17);
        org.junit.Assert.assertNotNull(cSVFormat18);
        org.junit.Assert.assertNotNull(cSVFormat19);
        org.junit.Assert.assertNotNull(cSVFormat20);
        org.junit.Assert.assertNotNull(cSVFormat23);
        org.junit.Assert.assertNotNull(cSVFormat24);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode25 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode25.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat27);
        org.junit.Assert.assertNotNull(objArray28);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray28), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray28), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat29);
        org.junit.Assert.assertNotNull(strArray35);
        org.junit.Assert.assertArrayEquals(strArray35, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat36);
        org.junit.Assert.assertNotNull(cSVFormat37);
        org.junit.Assert.assertNotNull(builder38);
        org.junit.Assert.assertNotNull(builder40);
        org.junit.Assert.assertNotNull(builder42);
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat3 = cSVFormat2.withSkipHeaderRecord();
        CSVFormat cSVFormat4 = cSVFormat3.withSystemRecordSeparator();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat3);
        org.junit.Assert.assertNotNull(cSVFormat4);
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat7 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVPrinter cSVPrinter8 = cSVFormat2.printer();
        java.sql.ResultSet resultSet9 = null;
        cSVPrinter8.printHeaders(resultSet9);
        cSVPrinter8.printComment("hi!");
        java.sql.ResultSet resultSet13 = null;
        // The following exception was thrown during execution in test generation
        try {
            cSVPrinter8.printRecords(resultSet13, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertNotNull(cSVPrinter8);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        java.sql.ResultSetMetaData resultSetMetaData3 = null;
        CSVFormat cSVFormat4 = cSVFormat2.withHeader(resultSetMetaData3);
        long long5 = cSVFormat4.getMaxRows();
        boolean boolean6 = cSVFormat4.getTrailingData();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertTrue("'" + long5 + "' != '" + 0L + "'", long5 == 0L);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        QuoteMode quoteMode3 = cSVFormat0.getQuoteMode();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertTrue("'" + quoteMode3 + "' != '" + QuoteMode.ALL_NON_NULL + "'", quoteMode3.equals(QuoteMode.ALL_NON_NULL));
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        CSVFormat.Builder builder0 = CSVFormat.Builder.create();
        org.junit.Assert.assertNotNull(builder0);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        java.sql.ResultSetMetaData resultSetMetaData3 = null;
        CSVFormat cSVFormat4 = cSVFormat2.withHeader(resultSetMetaData3);
        CSVFormat cSVFormat5 = cSVFormat2.withIgnoreEmptyLines();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat7 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat8 = cSVFormat7.withSystemRecordSeparator();
        CSVFormat cSVFormat11 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat12 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode13 = cSVFormat12.getDuplicateHeaderMode();
        CSVFormat cSVFormat15 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray16 = new Object[] { (short) 1, 0.0d, cSVFormat11, cSVFormat12, ' ', cSVFormat15 };
        CSVFormat cSVFormat17 = cSVFormat8.withHeaderComments(objArray16);
        String[] strArray23 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat24 = cSVFormat8.withHeader(strArray23);
        CSVFormat cSVFormat25 = cSVFormat2.withHeaderComments((Object[]) strArray23);
        Character char26 = cSVFormat25.getCommentMarker();
        long long27 = cSVFormat25.getMaxRows();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(cSVFormat11);
        org.junit.Assert.assertNotNull(cSVFormat12);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode13 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode13.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat15);
        org.junit.Assert.assertNotNull(objArray16);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray16), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray16), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat17);
        org.junit.Assert.assertNotNull(strArray23);
        org.junit.Assert.assertArrayEquals(strArray23, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat24);
        org.junit.Assert.assertNotNull(cSVFormat25);
        org.junit.Assert.assertNull(char26);
        org.junit.Assert.assertTrue("'" + long27 + "' != '" + 0L + "'", long27 == 0L);
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        CSVFormat cSVFormat1 = CSVFormat.newFormat(' ');
        boolean boolean2 = cSVFormat1.getAutoFlush();
        Appendable appendable3 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVPrinter cSVPrinter4 = cSVFormat1.print(appendable3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: appendable");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        CSVParser.Builder builder6 = builder0.setTrackBytes(false);
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser7 = builder6.get();
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.csv.CSVParser$Builder.getReader()Ljava/io/Reader;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(builder6);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat.Builder builder13 = builder9.setSkipHeaderRecord(false);
        CSVFormat.Builder builder15 = builder9.setCommentMarker('\t');
        CSVFormat.Builder builder17 = builder15.setNullString("Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false");
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(builder15);
        org.junit.Assert.assertNotNull(builder17);
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        boolean boolean2 = cSVFormat0.getIgnoreSurroundingSpaces();
        String str3 = cSVFormat0.getNullString();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "\\N" + "'", str3, "\\N");
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        CSVParser.Builder builder5 = CSVParser.builder();
        byte[] byteArray8 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder9 = builder5.setByteArray(byteArray8);
        CSVParser.Builder builder10 = builder4.setByteArray(byteArray8);
        java.io.OutputStream outputStream11 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser.Builder builder12 = builder10.setOutputStream(outputStream11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(builder5);
        org.junit.Assert.assertNotNull(byteArray8);
        org.junit.Assert.assertArrayEquals(byteArray8, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder10);
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat7 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVPrinter cSVPrinter8 = cSVFormat2.printer();
        java.sql.ResultSet resultSet9 = null;
        cSVPrinter8.printHeaders(resultSet9);
        cSVPrinter8.printComment("hi!");
        java.sql.ResultSet resultSet13 = null;
        cSVPrinter8.printHeaders(resultSet13);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertNotNull(cSVPrinter8);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        CSVParser.Builder builder6 = builder0.setCharSequence((CharSequence) ",");
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(builder6);
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        Character char2 = cSVFormat1.getCommentMarker();
        Appendable appendable3 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVPrinter cSVPrinter4 = cSVFormat1.print(appendable3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: appendable");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNull(char2);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        CSVFormat cSVFormat4 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat5 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode6 = cSVFormat5.getDuplicateHeaderMode();
        CSVFormat cSVFormat8 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray9 = new Object[] { (short) 1, 0.0d, cSVFormat4, cSVFormat5, ' ', cSVFormat8 };
        CSVFormat cSVFormat10 = cSVFormat1.withHeaderComments(objArray9);
        boolean boolean11 = cSVFormat1.getTrailingData();
        CSVFormat cSVFormat12 = cSVFormat1.withAllowMissingColumnNames();
        java.sql.ResultSet resultSet13 = null;
        CSVFormat cSVFormat14 = cSVFormat12.withHeader(resultSet13);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode6 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode6.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(objArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(cSVFormat12);
        org.junit.Assert.assertNotNull(cSVFormat14);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        CSVParser.Builder builder6 = builder0.setTrackBytes(false);
        CSVParser.Builder builder8 = builder6.setCharSequence((CharSequence) "hi!");
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser9 = builder8.get();
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.csv.CSVParser$Builder.getReader()Ljava/io/Reader;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(builder6);
        org.junit.Assert.assertNotNull(builder8);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        CSVParser.Builder builder5 = CSVParser.builder();
        byte[] byteArray8 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder9 = builder5.setByteArray(byteArray8);
        CSVParser.Builder builder10 = builder4.setByteArray(byteArray8);
        java.nio.file.Path path11 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser.Builder builder12 = builder10.setPath(path11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(builder5);
        org.junit.Assert.assertNotNull(byteArray8);
        org.junit.Assert.assertArrayEquals(byteArray8, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder10);
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat cSVFormat12 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode13 = cSVFormat12.getDuplicateHeaderMode();
        CSVFormat cSVFormat14 = cSVFormat12.withAllowMissingColumnNames();
        CSVFormat cSVFormat16 = cSVFormat14.withRecordSeparator("");
        CSVFormat cSVFormat17 = cSVFormat14.withTrim();
        CSVFormat cSVFormat18 = cSVFormat14.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat19 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat20 = cSVFormat19.withSystemRecordSeparator();
        CSVFormat cSVFormat23 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat24 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode25 = cSVFormat24.getDuplicateHeaderMode();
        CSVFormat cSVFormat27 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray28 = new Object[] { (short) 1, 0.0d, cSVFormat23, cSVFormat24, ' ', cSVFormat27 };
        CSVFormat cSVFormat29 = cSVFormat20.withHeaderComments(objArray28);
        String[] strArray35 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat36 = cSVFormat20.withHeader(strArray35);
        CSVFormat cSVFormat37 = cSVFormat14.withHeaderComments((Object[]) strArray35);
        CSVFormat.Builder builder38 = builder11.setHeaderComments((Object[]) strArray35);
        CSVFormat.Builder builder40 = builder11.setAllowDuplicateHeaderNames(true);
        CSVFormat.Builder builder42 = builder11.setCommentMarker(' ');
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(cSVFormat12);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode13 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode13.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat14);
        org.junit.Assert.assertNotNull(cSVFormat16);
        org.junit.Assert.assertNotNull(cSVFormat17);
        org.junit.Assert.assertNotNull(cSVFormat18);
        org.junit.Assert.assertNotNull(cSVFormat19);
        org.junit.Assert.assertNotNull(cSVFormat20);
        org.junit.Assert.assertNotNull(cSVFormat23);
        org.junit.Assert.assertNotNull(cSVFormat24);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode25 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode25.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat27);
        org.junit.Assert.assertNotNull(objArray28);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray28), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray28), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat29);
        org.junit.Assert.assertNotNull(strArray35);
        org.junit.Assert.assertArrayEquals(strArray35, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat36);
        org.junit.Assert.assertNotNull(cSVFormat37);
        org.junit.Assert.assertNotNull(builder38);
        org.junit.Assert.assertNotNull(builder40);
        org.junit.Assert.assertNotNull(builder42);
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        CSVFormat cSVFormat4 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat5 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode6 = cSVFormat5.getDuplicateHeaderMode();
        CSVFormat cSVFormat8 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray9 = new Object[] { (short) 1, 0.0d, cSVFormat4, cSVFormat5, ' ', cSVFormat8 };
        CSVFormat cSVFormat10 = cSVFormat1.withHeaderComments(objArray9);
        boolean boolean11 = cSVFormat1.getTrailingData();
        CSVFormat cSVFormat12 = cSVFormat1.withAllowMissingColumnNames();
        CSVFormat cSVFormat14 = cSVFormat1.withRecordSeparator("");
        boolean boolean15 = cSVFormat1.getTrim();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode6 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode6.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(objArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(cSVFormat12);
        org.junit.Assert.assertNotNull(cSVFormat14);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        CSVFormat cSVFormat0 = CSVFormat.INFORMIX_UNLOAD_CSV;
        CSVFormat cSVFormat1 = cSVFormat0.withFirstRecordAsHeader();
        boolean boolean2 = cSVFormat0.getIgnoreSurroundingSpaces();
        Character char3 = cSVFormat0.getEscapeCharacter();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNull(char3);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat3 = cSVFormat2.withSkipHeaderRecord();
        CSVFormat cSVFormat5 = cSVFormat2.withAllowMissingColumnNames(true);
        CSVFormat.Builder builder6 = CSVFormat.Builder.create(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat3);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(builder6);
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        CSVFormat cSVFormat2 = cSVFormat1.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat1.withRecordSeparator('#');
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        CSVParser.Builder builder6 = builder0.setTrackBytes(false);
        CSVParser.Builder builder8 = builder6.setCharSequence((CharSequence) "hi!");
        CSVParser.Builder builder10 = builder6.setPath("\t");
        java.nio.file.Path path11 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser.Builder builder12 = builder10.setPath(path11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(builder6);
        org.junit.Assert.assertNotNull(builder8);
        org.junit.Assert.assertNotNull(builder10);
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        CSVParser.Builder builder6 = builder0.setTrackBytes(false);
        CSVParser.Builder builder8 = builder6.setCharSequence((CharSequence) "hi!");
        java.io.Writer writer9 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser.Builder builder10 = builder6.setWriter(writer9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(builder6);
        org.junit.Assert.assertNotNull(builder8);
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        CSVFormat.Predefined predefined0 = CSVFormat.Predefined.InformixUnloadCsv;
        org.junit.Assert.assertTrue("'" + predefined0 + "' != '" + CSVFormat.Predefined.InformixUnloadCsv + "'", predefined0.equals(CSVFormat.Predefined.InformixUnloadCsv));
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        CSVFormat cSVFormat1 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode2 = cSVFormat1.getDuplicateHeaderMode();
        CSVFormat cSVFormat3 = cSVFormat1.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat3.withSkipHeaderRecord();
        CSVFormat cSVFormat6 = cSVFormat3.withAllowMissingColumnNames(true);
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser7 = CSVParser.parse("\\N", cSVFormat6);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.csv.CSVParser$Builder.getReader()Ljava/io/Reader;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode2 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode2.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat3);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat6);
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        CSVFormat cSVFormat0 = CSVFormat.MYSQL;
        CSVFormat.Builder builder1 = cSVFormat0.builder();
        // The following exception was thrown during execution in test generation
        try {
            CSVFormat.Builder builder3 = builder1.setDelimiter("Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The delimiter cannot be a line break");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(builder1);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        CSVFormat cSVFormat0 = CSVFormat.MYSQL;
        CSVFormat cSVFormat2 = cSVFormat0.withEscape('#');
        DuplicateHeaderMode duplicateHeaderMode3 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat5 = cSVFormat0.withIgnoreEmptyLines(true);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode3 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode3.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat5);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        CSVFormat cSVFormat1 = CSVFormat.newFormat(',');
        org.junit.Assert.assertNotNull(cSVFormat1);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat7 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVPrinter cSVPrinter8 = cSVFormat2.printer();
        java.sql.ResultSet resultSet9 = null;
        cSVPrinter8.printHeaders(resultSet9);
        cSVPrinter8.printComment("hi!");
        cSVPrinter8.println();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertNotNull(cSVPrinter8);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        CSVFormat cSVFormat0 = CSVFormat.RFC4180;
        CSVFormat cSVFormat2 = cSVFormat0.withAutoFlush(true);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat2);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        CSVFormat.Predefined predefined0 = CSVFormat.Predefined.PostgreSQLCsv;
        CSVFormat cSVFormat1 = predefined0.getFormat();
        String str2 = cSVFormat1.getDelimiterString();
        CSVFormat cSVFormat3 = cSVFormat1.withTrailingDelimiter();
        CSVFormat cSVFormat5 = cSVFormat3.withIgnoreSurroundingSpaces(true);
        org.junit.Assert.assertTrue("'" + predefined0 + "' != '" + CSVFormat.Predefined.PostgreSQLCsv + "'", predefined0.equals(CSVFormat.Predefined.PostgreSQLCsv));
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "," + "'", str2, ",");
        org.junit.Assert.assertNotNull(cSVFormat3);
        org.junit.Assert.assertNotNull(cSVFormat5);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat.Builder builder13 = builder9.setDelimiter('#');
        java.sql.ResultSet resultSet14 = null;
        CSVFormat.Builder builder15 = builder13.setHeader(resultSet14);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(builder15);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat cSVFormat12 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode13 = cSVFormat12.getDuplicateHeaderMode();
        CSVFormat cSVFormat14 = cSVFormat12.withAllowMissingColumnNames();
        CSVFormat cSVFormat16 = cSVFormat14.withRecordSeparator("");
        CSVFormat cSVFormat17 = cSVFormat14.withTrim();
        CSVFormat cSVFormat18 = cSVFormat14.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat19 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat20 = cSVFormat19.withSystemRecordSeparator();
        CSVFormat cSVFormat23 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat24 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode25 = cSVFormat24.getDuplicateHeaderMode();
        CSVFormat cSVFormat27 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray28 = new Object[] { (short) 1, 0.0d, cSVFormat23, cSVFormat24, ' ', cSVFormat27 };
        CSVFormat cSVFormat29 = cSVFormat20.withHeaderComments(objArray28);
        String[] strArray35 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat36 = cSVFormat20.withHeader(strArray35);
        CSVFormat cSVFormat37 = cSVFormat14.withHeaderComments((Object[]) strArray35);
        CSVFormat.Builder builder38 = builder11.setHeaderComments((Object[]) strArray35);
        CSVFormat.Builder builder40 = builder11.setAllowDuplicateHeaderNames(false);
        CSVFormat cSVFormat41 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode42 = cSVFormat41.getDuplicateHeaderMode();
        CSVFormat cSVFormat43 = cSVFormat41.withAllowMissingColumnNames();
        CSVFormat cSVFormat45 = cSVFormat43.withRecordSeparator("");
        CSVFormat cSVFormat46 = cSVFormat43.withTrim();
        CSVFormat cSVFormat47 = cSVFormat43.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat49 = cSVFormat47.withRecordSeparator(' ');
        CSVFormat.Builder builder50 = CSVFormat.Builder.create(cSVFormat47);
        CSVFormat.Builder builder52 = builder50.setRecordSeparator('a');
        CSVFormat cSVFormat53 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode54 = cSVFormat53.getDuplicateHeaderMode();
        CSVFormat cSVFormat55 = cSVFormat53.withAllowMissingColumnNames();
        CSVFormat cSVFormat57 = cSVFormat55.withRecordSeparator("");
        CSVFormat cSVFormat58 = cSVFormat55.withTrim();
        CSVFormat cSVFormat59 = cSVFormat55.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat60 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat61 = cSVFormat60.withSystemRecordSeparator();
        CSVFormat cSVFormat64 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat65 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode66 = cSVFormat65.getDuplicateHeaderMode();
        CSVFormat cSVFormat68 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray69 = new Object[] { (short) 1, 0.0d, cSVFormat64, cSVFormat65, ' ', cSVFormat68 };
        CSVFormat cSVFormat70 = cSVFormat61.withHeaderComments(objArray69);
        String[] strArray76 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat77 = cSVFormat61.withHeader(strArray76);
        CSVFormat cSVFormat78 = cSVFormat55.withHeaderComments((Object[]) strArray76);
        CSVFormat.Builder builder79 = builder52.setHeaderComments((Object[]) strArray76);
        CSVFormat.Builder builder80 = builder40.setHeaderComments((Object[]) strArray76);
        CSVFormat.Builder builder82 = builder80.setCommentMarker('\"');
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(cSVFormat12);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode13 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode13.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat14);
        org.junit.Assert.assertNotNull(cSVFormat16);
        org.junit.Assert.assertNotNull(cSVFormat17);
        org.junit.Assert.assertNotNull(cSVFormat18);
        org.junit.Assert.assertNotNull(cSVFormat19);
        org.junit.Assert.assertNotNull(cSVFormat20);
        org.junit.Assert.assertNotNull(cSVFormat23);
        org.junit.Assert.assertNotNull(cSVFormat24);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode25 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode25.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat27);
        org.junit.Assert.assertNotNull(objArray28);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray28), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray28), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat29);
        org.junit.Assert.assertNotNull(strArray35);
        org.junit.Assert.assertArrayEquals(strArray35, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat36);
        org.junit.Assert.assertNotNull(cSVFormat37);
        org.junit.Assert.assertNotNull(builder38);
        org.junit.Assert.assertNotNull(builder40);
        org.junit.Assert.assertNotNull(cSVFormat41);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode42 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode42.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat43);
        org.junit.Assert.assertNotNull(cSVFormat45);
        org.junit.Assert.assertNotNull(cSVFormat46);
        org.junit.Assert.assertNotNull(cSVFormat47);
        org.junit.Assert.assertNotNull(cSVFormat49);
        org.junit.Assert.assertNotNull(builder50);
        org.junit.Assert.assertNotNull(builder52);
        org.junit.Assert.assertNotNull(cSVFormat53);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode54 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode54.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat55);
        org.junit.Assert.assertNotNull(cSVFormat57);
        org.junit.Assert.assertNotNull(cSVFormat58);
        org.junit.Assert.assertNotNull(cSVFormat59);
        org.junit.Assert.assertNotNull(cSVFormat60);
        org.junit.Assert.assertNotNull(cSVFormat61);
        org.junit.Assert.assertNotNull(cSVFormat64);
        org.junit.Assert.assertNotNull(cSVFormat65);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode66 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode66.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat68);
        org.junit.Assert.assertNotNull(objArray69);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray69), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray69), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat70);
        org.junit.Assert.assertNotNull(strArray76);
        org.junit.Assert.assertArrayEquals(strArray76, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat77);
        org.junit.Assert.assertNotNull(cSVFormat78);
        org.junit.Assert.assertNotNull(builder79);
        org.junit.Assert.assertNotNull(builder80);
        org.junit.Assert.assertNotNull(builder82);
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat.Builder builder13 = builder9.setSkipHeaderRecord(false);
        CSVFormat.Builder builder15 = builder9.setCommentMarker('\t');
        CSVFormat cSVFormat17 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode18 = cSVFormat17.getDuplicateHeaderMode();
        CSVFormat cSVFormat19 = cSVFormat17.withAllowMissingColumnNames();
        CSVFormat cSVFormat21 = cSVFormat19.withRecordSeparator("");
        CSVFormat cSVFormat22 = cSVFormat19.withTrim();
        CSVFormat cSVFormat23 = cSVFormat19.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat24 = cSVFormat19.withAllowDuplicateHeaderNames();
        CSVPrinter cSVPrinter25 = cSVFormat19.printer();
        java.sql.ResultSet resultSet26 = null;
        cSVPrinter25.printHeaders(resultSet26);
        cSVPrinter25.printComment("hi!");
        CSVFormat cSVFormat30 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode31 = cSVFormat30.getDuplicateHeaderMode();
        CSVFormat cSVFormat32 = cSVFormat30.withAllowMissingColumnNames();
        CSVFormat cSVFormat34 = cSVFormat32.withRecordSeparator("");
        CSVFormat cSVFormat35 = cSVFormat32.withTrim();
        CSVFormat cSVFormat36 = cSVFormat32.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat38 = cSVFormat36.withRecordSeparator(' ');
        CSVFormat.Builder builder39 = CSVFormat.Builder.create(cSVFormat36);
        CSVFormat.Builder builder41 = builder39.setRecordSeparator('a');
        CSVFormat.Builder builder43 = builder39.setSkipHeaderRecord(false);
        CSVFormat.Builder builder45 = builder39.setCommentMarker('\t');
        String[] strArray48 = new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" };
        CSVFormat.Builder builder49 = builder45.setHeader(strArray48);
        cSVPrinter25.printRecords((Object[]) strArray48);
        CSVException cSVException51 = new CSVException("hi!", (Object[]) strArray48);
        CSVFormat.Builder builder52 = builder15.setHeader(strArray48);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(builder15);
        org.junit.Assert.assertNotNull(cSVFormat17);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode18 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode18.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat19);
        org.junit.Assert.assertNotNull(cSVFormat21);
        org.junit.Assert.assertNotNull(cSVFormat22);
        org.junit.Assert.assertNotNull(cSVFormat23);
        org.junit.Assert.assertNotNull(cSVFormat24);
        org.junit.Assert.assertNotNull(cSVPrinter25);
        org.junit.Assert.assertNotNull(cSVFormat30);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode31 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode31.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat32);
        org.junit.Assert.assertNotNull(cSVFormat34);
        org.junit.Assert.assertNotNull(cSVFormat35);
        org.junit.Assert.assertNotNull(cSVFormat36);
        org.junit.Assert.assertNotNull(cSVFormat38);
        org.junit.Assert.assertNotNull(builder39);
        org.junit.Assert.assertNotNull(builder41);
        org.junit.Assert.assertNotNull(builder43);
        org.junit.Assert.assertNotNull(builder45);
        org.junit.Assert.assertNotNull(strArray48);
        org.junit.Assert.assertArrayEquals(strArray48, new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" });
        org.junit.Assert.assertNotNull(builder49);
        org.junit.Assert.assertNotNull(builder52);
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        Character char2 = cSVFormat1.getCommentMarker();
        CSVFormat cSVFormat3 = cSVFormat1.withFirstRecordAsHeader();
        CSVFormat cSVFormat4 = cSVFormat3.withSkipHeaderRecord();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNull(char2);
        org.junit.Assert.assertNotNull(cSVFormat3);
        org.junit.Assert.assertNotNull(cSVFormat4);
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        // The following exception was thrown during execution in test generation
        try {
            CSVFormat cSVFormat1 = CSVFormat.valueOf("");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: No enum constant org.apache.commons.csv.CSVFormat.Predefined.");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        java.io.File file0 = null;
        CSVParser.Builder builder1 = CSVParser.builder();
        byte[] byteArray4 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder5 = builder1.setByteArray(byteArray4);
        CSVParser.Builder builder6 = CSVParser.builder();
        byte[] byteArray9 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder10 = builder6.setByteArray(byteArray9);
        CSVParser.Builder builder11 = builder5.setByteArray(byteArray9);
        CSVParser.Builder builder13 = builder5.setFile("hi!");
        java.nio.charset.Charset charset14 = builder5.getCharset();
        CSVFormat cSVFormat15 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat16 = cSVFormat15.withSystemRecordSeparator();
        Character char17 = cSVFormat16.getCommentMarker();
        CSVFormat cSVFormat18 = cSVFormat16.withFirstRecordAsHeader();
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser19 = CSVParser.parse(file0, charset14, cSVFormat16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: file");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder1);
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder5);
        org.junit.Assert.assertNotNull(builder6);
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertArrayEquals(byteArray9, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder10);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(charset14);
        org.junit.Assert.assertNotNull(cSVFormat15);
        org.junit.Assert.assertNotNull(cSVFormat16);
        org.junit.Assert.assertNull(char17);
        org.junit.Assert.assertNotNull(cSVFormat18);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat.Builder builder13 = builder9.setDelimiter('#');
        java.sql.ResultSetMetaData resultSetMetaData14 = null;
        CSVFormat.Builder builder15 = builder9.setHeader(resultSetMetaData14);
        CSVFormat cSVFormat16 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat18 = cSVFormat16.withRecordSeparator('a');
        QuoteMode quoteMode19 = cSVFormat16.getQuoteMode();
        CSVFormat.Builder builder20 = builder15.setQuoteMode(quoteMode19);
        CSVFormat.Builder builder22 = builder15.setCommentMarker((Character) '4');
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(builder15);
        org.junit.Assert.assertNotNull(cSVFormat16);
        org.junit.Assert.assertNotNull(cSVFormat18);
        org.junit.Assert.assertTrue("'" + quoteMode19 + "' != '" + QuoteMode.ALL_NON_NULL + "'", quoteMode19.equals(QuoteMode.ALL_NON_NULL));
        org.junit.Assert.assertNotNull(builder20);
        org.junit.Assert.assertNotNull(builder22);
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat7 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVPrinter cSVPrinter8 = cSVFormat2.printer();
        java.sql.ResultSet resultSet9 = null;
        cSVPrinter8.printHeaders(resultSet9);
        cSVPrinter8.printComment("hi!");
        CSVFormat cSVFormat13 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode14 = cSVFormat13.getDuplicateHeaderMode();
        CSVFormat cSVFormat15 = cSVFormat13.withAllowMissingColumnNames();
        CSVFormat cSVFormat17 = cSVFormat15.withRecordSeparator("");
        CSVFormat cSVFormat18 = cSVFormat15.withTrim();
        CSVFormat cSVFormat19 = cSVFormat15.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat21 = cSVFormat19.withRecordSeparator(' ');
        CSVFormat.Builder builder22 = CSVFormat.Builder.create(cSVFormat19);
        CSVFormat.Builder builder24 = builder22.setRecordSeparator('a');
        CSVFormat.Builder builder26 = builder22.setSkipHeaderRecord(false);
        CSVFormat.Builder builder28 = builder22.setCommentMarker('\t');
        String[] strArray31 = new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" };
        CSVFormat.Builder builder32 = builder28.setHeader(strArray31);
        cSVPrinter8.printRecords((Object[]) strArray31);
        cSVPrinter8.flush();
        cSVPrinter8.close();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertNotNull(cSVPrinter8);
        org.junit.Assert.assertNotNull(cSVFormat13);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode14 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode14.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat15);
        org.junit.Assert.assertNotNull(cSVFormat17);
        org.junit.Assert.assertNotNull(cSVFormat18);
        org.junit.Assert.assertNotNull(cSVFormat19);
        org.junit.Assert.assertNotNull(cSVFormat21);
        org.junit.Assert.assertNotNull(builder22);
        org.junit.Assert.assertNotNull(builder24);
        org.junit.Assert.assertNotNull(builder26);
        org.junit.Assert.assertNotNull(builder28);
        org.junit.Assert.assertNotNull(strArray31);
        org.junit.Assert.assertArrayEquals(strArray31, new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" });
        org.junit.Assert.assertNotNull(builder32);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        CSVFormat cSVFormat4 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat5 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode6 = cSVFormat5.getDuplicateHeaderMode();
        CSVFormat cSVFormat8 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray9 = new Object[] { (short) 1, 0.0d, cSVFormat4, cSVFormat5, ' ', cSVFormat8 };
        CSVFormat cSVFormat10 = cSVFormat1.withHeaderComments(objArray9);
        CSVFormat cSVFormat12 = cSVFormat10.withNullString("\\N");
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode6 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode6.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(objArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertNotNull(cSVFormat12);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        CSVFormat cSVFormat0 = CSVFormat.TDF;
        org.junit.Assert.assertNotNull(cSVFormat0);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        java.io.Reader reader0 = null;
        CSVFormat cSVFormat1 = CSVFormat.POSTGRESQL_TEXT;
        boolean boolean2 = cSVFormat1.getIgnoreHeaderCase();
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser3 = new CSVParser(reader0, cSVFormat1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: reader");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        CSVFormat cSVFormat0 = CSVFormat.MONGODB_CSV;
        boolean boolean1 = cSVFormat0.getLenientEof();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        CSVFormat cSVFormat0 = CSVFormat.RFC4180;
        boolean boolean1 = cSVFormat0.getSkipHeaderRecord();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat7 = cSVFormat2.withTrailingDelimiter();
        CSVFormat cSVFormat9 = cSVFormat2.withRecordSeparator('\t');
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertNotNull(cSVFormat9);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat cSVFormat12 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode13 = cSVFormat12.getDuplicateHeaderMode();
        CSVFormat cSVFormat14 = cSVFormat12.withAllowMissingColumnNames();
        CSVFormat cSVFormat16 = cSVFormat14.withRecordSeparator("");
        CSVFormat cSVFormat17 = cSVFormat14.withTrim();
        CSVFormat cSVFormat18 = cSVFormat14.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat19 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat20 = cSVFormat19.withSystemRecordSeparator();
        CSVFormat cSVFormat23 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat24 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode25 = cSVFormat24.getDuplicateHeaderMode();
        CSVFormat cSVFormat27 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray28 = new Object[] { (short) 1, 0.0d, cSVFormat23, cSVFormat24, ' ', cSVFormat27 };
        CSVFormat cSVFormat29 = cSVFormat20.withHeaderComments(objArray28);
        String[] strArray35 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat36 = cSVFormat20.withHeader(strArray35);
        CSVFormat cSVFormat37 = cSVFormat14.withHeaderComments((Object[]) strArray35);
        CSVFormat.Builder builder38 = builder11.setHeaderComments((Object[]) strArray35);
        CSVFormat.Builder builder40 = builder11.setAllowDuplicateHeaderNames(false);
        CSVFormat cSVFormat41 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode42 = cSVFormat41.getDuplicateHeaderMode();
        CSVFormat cSVFormat43 = cSVFormat41.withAllowMissingColumnNames();
        CSVFormat cSVFormat45 = cSVFormat43.withRecordSeparator("");
        CSVFormat cSVFormat46 = cSVFormat43.withTrim();
        CSVFormat cSVFormat47 = cSVFormat43.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat49 = cSVFormat47.withRecordSeparator(' ');
        CSVFormat.Builder builder50 = CSVFormat.Builder.create(cSVFormat47);
        CSVFormat.Builder builder52 = builder50.setRecordSeparator('a');
        CSVFormat cSVFormat53 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode54 = cSVFormat53.getDuplicateHeaderMode();
        CSVFormat cSVFormat55 = cSVFormat53.withAllowMissingColumnNames();
        CSVFormat cSVFormat57 = cSVFormat55.withRecordSeparator("");
        CSVFormat cSVFormat58 = cSVFormat55.withTrim();
        CSVFormat cSVFormat59 = cSVFormat55.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat60 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat61 = cSVFormat60.withSystemRecordSeparator();
        CSVFormat cSVFormat64 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat65 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode66 = cSVFormat65.getDuplicateHeaderMode();
        CSVFormat cSVFormat68 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray69 = new Object[] { (short) 1, 0.0d, cSVFormat64, cSVFormat65, ' ', cSVFormat68 };
        CSVFormat cSVFormat70 = cSVFormat61.withHeaderComments(objArray69);
        String[] strArray76 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat77 = cSVFormat61.withHeader(strArray76);
        CSVFormat cSVFormat78 = cSVFormat55.withHeaderComments((Object[]) strArray76);
        CSVFormat.Builder builder79 = builder52.setHeaderComments((Object[]) strArray76);
        CSVFormat.Builder builder80 = builder40.setHeaderComments((Object[]) strArray76);
        String[] strArray81 = null;
        CSVFormat.Builder builder82 = builder40.setHeader(strArray81);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(cSVFormat12);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode13 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode13.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat14);
        org.junit.Assert.assertNotNull(cSVFormat16);
        org.junit.Assert.assertNotNull(cSVFormat17);
        org.junit.Assert.assertNotNull(cSVFormat18);
        org.junit.Assert.assertNotNull(cSVFormat19);
        org.junit.Assert.assertNotNull(cSVFormat20);
        org.junit.Assert.assertNotNull(cSVFormat23);
        org.junit.Assert.assertNotNull(cSVFormat24);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode25 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode25.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat27);
        org.junit.Assert.assertNotNull(objArray28);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray28), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray28), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat29);
        org.junit.Assert.assertNotNull(strArray35);
        org.junit.Assert.assertArrayEquals(strArray35, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat36);
        org.junit.Assert.assertNotNull(cSVFormat37);
        org.junit.Assert.assertNotNull(builder38);
        org.junit.Assert.assertNotNull(builder40);
        org.junit.Assert.assertNotNull(cSVFormat41);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode42 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode42.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat43);
        org.junit.Assert.assertNotNull(cSVFormat45);
        org.junit.Assert.assertNotNull(cSVFormat46);
        org.junit.Assert.assertNotNull(cSVFormat47);
        org.junit.Assert.assertNotNull(cSVFormat49);
        org.junit.Assert.assertNotNull(builder50);
        org.junit.Assert.assertNotNull(builder52);
        org.junit.Assert.assertNotNull(cSVFormat53);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode54 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode54.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat55);
        org.junit.Assert.assertNotNull(cSVFormat57);
        org.junit.Assert.assertNotNull(cSVFormat58);
        org.junit.Assert.assertNotNull(cSVFormat59);
        org.junit.Assert.assertNotNull(cSVFormat60);
        org.junit.Assert.assertNotNull(cSVFormat61);
        org.junit.Assert.assertNotNull(cSVFormat64);
        org.junit.Assert.assertNotNull(cSVFormat65);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode66 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode66.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat68);
        org.junit.Assert.assertNotNull(objArray69);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray69), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray69), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat70);
        org.junit.Assert.assertNotNull(strArray76);
        org.junit.Assert.assertArrayEquals(strArray76, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat77);
        org.junit.Assert.assertNotNull(cSVFormat78);
        org.junit.Assert.assertNotNull(builder79);
        org.junit.Assert.assertNotNull(builder80);
        org.junit.Assert.assertNotNull(builder82);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat2 = cSVFormat0.withSkipHeaderRecord(false);
        CSVFormat cSVFormat3 = cSVFormat2.withIgnoreSurroundingSpaces();
        CSVFormat cSVFormat4 = cSVFormat2.withTrailingDelimiter();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat3);
        org.junit.Assert.assertNotNull(cSVFormat4);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        CSVFormat cSVFormat4 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat5 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode6 = cSVFormat5.getDuplicateHeaderMode();
        CSVFormat cSVFormat8 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray9 = new Object[] { (short) 1, 0.0d, cSVFormat4, cSVFormat5, ' ', cSVFormat8 };
        CSVFormat cSVFormat10 = cSVFormat1.withHeaderComments(objArray9);
        String[] strArray16 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat17 = cSVFormat1.withHeader(strArray16);
        CSVFormat cSVFormat18 = cSVFormat1.withIgnoreEmptyLines();
        CSVFormat cSVFormat19 = cSVFormat18.withIgnoreEmptyLines();
        boolean boolean20 = cSVFormat19.getIgnoreHeaderCase();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode6 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode6.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(objArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertNotNull(strArray16);
        org.junit.Assert.assertArrayEquals(strArray16, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat17);
        org.junit.Assert.assertNotNull(cSVFormat18);
        org.junit.Assert.assertNotNull(cSVFormat19);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        java.io.InputStream inputStream0 = null;
        CSVParser.Builder builder1 = CSVParser.builder();
        byte[] byteArray4 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder5 = builder1.setByteArray(byteArray4);
        CSVParser.Builder builder6 = CSVParser.builder();
        byte[] byteArray9 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder10 = builder6.setByteArray(byteArray9);
        CSVParser.Builder builder11 = builder5.setByteArray(byteArray9);
        CSVParser.Builder builder13 = builder5.setFile("hi!");
        java.nio.charset.Charset charset14 = builder5.getCharset();
        CSVFormat cSVFormat15 = CSVFormat.INFORMIX_UNLOAD_CSV;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser16 = CSVParser.parse(inputStream0, charset14, cSVFormat15);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: inputStream");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder1);
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder5);
        org.junit.Assert.assertNotNull(builder6);
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertArrayEquals(byteArray9, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder10);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(charset14);
        org.junit.Assert.assertNotNull(cSVFormat15);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        // The following exception was thrown during execution in test generation
        try {
            CSVFormat cSVFormat1 = CSVFormat.valueOf(",");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: No enum constant org.apache.commons.csv.CSVFormat.Predefined.,");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        CSVFormat cSVFormat0 = CSVFormat.MYSQL;
        CSVFormat cSVFormat2 = cSVFormat0.withEscape('#');
        CSVFormat cSVFormat4 = cSVFormat0.withIgnoreSurroundingSpaces(false);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        CSVFormat cSVFormat0 = CSVFormat.MYSQL;
        CSVFormat.Builder builder1 = cSVFormat0.builder();
        CSVFormat.Builder builder3 = builder1.setLenientEof(false);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(builder1);
        org.junit.Assert.assertNotNull(builder3);
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat3 = cSVFormat2.withSkipHeaderRecord();
        CSVFormat cSVFormat5 = cSVFormat3.withQuote('a');
        java.io.File file6 = null;
        CSVParser.Builder builder7 = CSVParser.builder();
        byte[] byteArray10 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder11 = builder7.setByteArray(byteArray10);
        CSVParser.Builder builder13 = builder7.setTrackBytes(false);
        java.nio.charset.Charset charset14 = builder7.getCharset();
        // The following exception was thrown during execution in test generation
        try {
            CSVPrinter cSVPrinter15 = cSVFormat3.print(file6, charset14);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat3);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(builder7);
        org.junit.Assert.assertNotNull(byteArray10);
        org.junit.Assert.assertArrayEquals(byteArray10, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(charset14);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test125");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        CSVFormat cSVFormat4 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat5 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode6 = cSVFormat5.getDuplicateHeaderMode();
        CSVFormat cSVFormat8 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray9 = new Object[] { (short) 1, 0.0d, cSVFormat4, cSVFormat5, ' ', cSVFormat8 };
        CSVFormat cSVFormat10 = cSVFormat1.withHeaderComments(objArray9);
        CSVFormat.Builder builder11 = cSVFormat10.builder();
        CSVFormat.Builder builder13 = builder11.setTrailingDelimiter(true);
        CSVFormat.Builder builder15 = builder11.setDelimiter('#');
        CSVFormat.Builder builder17 = builder15.setQuote(' ');
        CSVFormat cSVFormat18 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode19 = cSVFormat18.getDuplicateHeaderMode();
        CSVFormat cSVFormat20 = cSVFormat18.withAllowMissingColumnNames();
        CSVFormat cSVFormat22 = cSVFormat20.withRecordSeparator("");
        CSVFormat cSVFormat23 = cSVFormat20.withTrim();
        CSVFormat cSVFormat24 = cSVFormat20.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat25 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat26 = cSVFormat25.withSystemRecordSeparator();
        CSVFormat cSVFormat29 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat30 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode31 = cSVFormat30.getDuplicateHeaderMode();
        CSVFormat cSVFormat33 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray34 = new Object[] { (short) 1, 0.0d, cSVFormat29, cSVFormat30, ' ', cSVFormat33 };
        CSVFormat cSVFormat35 = cSVFormat26.withHeaderComments(objArray34);
        String[] strArray41 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat42 = cSVFormat26.withHeader(strArray41);
        CSVFormat cSVFormat43 = cSVFormat20.withHeaderComments((Object[]) strArray41);
        CSVFormat.Builder builder44 = builder17.setHeaderComments(strArray41);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode6 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode6.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(objArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(builder15);
        org.junit.Assert.assertNotNull(builder17);
        org.junit.Assert.assertNotNull(cSVFormat18);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode19 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode19.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat20);
        org.junit.Assert.assertNotNull(cSVFormat22);
        org.junit.Assert.assertNotNull(cSVFormat23);
        org.junit.Assert.assertNotNull(cSVFormat24);
        org.junit.Assert.assertNotNull(cSVFormat25);
        org.junit.Assert.assertNotNull(cSVFormat26);
        org.junit.Assert.assertNotNull(cSVFormat29);
        org.junit.Assert.assertNotNull(cSVFormat30);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode31 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode31.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat33);
        org.junit.Assert.assertNotNull(objArray34);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray34), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray34), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat35);
        org.junit.Assert.assertNotNull(strArray41);
        org.junit.Assert.assertArrayEquals(strArray41, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat42);
        org.junit.Assert.assertNotNull(cSVFormat43);
        org.junit.Assert.assertNotNull(builder44);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test126");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withCommentMarker((Character) '\"');
        CSVPrinter cSVPrinter9 = cSVFormat6.printer();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(cSVPrinter9);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test127");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat.Builder builder13 = builder11.setEscape((Character) 'a');
        CSVFormat cSVFormat14 = CSVFormat.MONGODB_TSV;
        CSVFormat cSVFormat16 = cSVFormat14.withEscape((Character) 'a');
        CSVFormat cSVFormat18 = cSVFormat16.withIgnoreHeaderCase(false);
        QuoteMode quoteMode19 = cSVFormat16.getQuoteMode();
        CSVFormat.Builder builder20 = builder13.setQuoteMode(quoteMode19);
        CSVFormat cSVFormat21 = CSVFormat.MYSQL;
        CSVFormat cSVFormat23 = cSVFormat21.withEscape('#');
        DuplicateHeaderMode duplicateHeaderMode24 = cSVFormat21.getDuplicateHeaderMode();
        CSVFormat.Builder builder25 = builder13.setDuplicateHeaderMode(duplicateHeaderMode24);
        CSVFormat.Builder builder27 = builder25.setCommentMarker('a');
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(cSVFormat14);
        org.junit.Assert.assertNotNull(cSVFormat16);
        org.junit.Assert.assertNotNull(cSVFormat18);
        org.junit.Assert.assertTrue("'" + quoteMode19 + "' != '" + QuoteMode.MINIMAL + "'", quoteMode19.equals(QuoteMode.MINIMAL));
        org.junit.Assert.assertNotNull(builder20);
        org.junit.Assert.assertNotNull(cSVFormat21);
        org.junit.Assert.assertNotNull(cSVFormat23);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode24 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode24.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(builder25);
        org.junit.Assert.assertNotNull(builder27);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test128");
        java.io.File file0 = null;
        CSVParser.Builder builder1 = CSVParser.builder();
        byte[] byteArray4 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder5 = builder1.setByteArray(byteArray4);
        CSVParser.Builder builder7 = builder1.setTrackBytes(false);
        java.nio.charset.Charset charset8 = builder1.getCharset();
        CSVFormat cSVFormat9 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat10 = cSVFormat9.withSystemRecordSeparator();
        CSVFormat cSVFormat13 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat14 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode15 = cSVFormat14.getDuplicateHeaderMode();
        CSVFormat cSVFormat17 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray18 = new Object[] { (short) 1, 0.0d, cSVFormat13, cSVFormat14, ' ', cSVFormat17 };
        CSVFormat cSVFormat19 = cSVFormat10.withHeaderComments(objArray18);
        String[] strArray25 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat26 = cSVFormat10.withHeader(strArray25);
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser27 = CSVParser.parse(file0, charset8, cSVFormat10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: file");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder1);
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder5);
        org.junit.Assert.assertNotNull(builder7);
        org.junit.Assert.assertNotNull(charset8);
        org.junit.Assert.assertNotNull(cSVFormat9);
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertNotNull(cSVFormat13);
        org.junit.Assert.assertNotNull(cSVFormat14);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode15 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode15.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat17);
        org.junit.Assert.assertNotNull(objArray18);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray18), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray18), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat19);
        org.junit.Assert.assertNotNull(strArray25);
        org.junit.Assert.assertArrayEquals(strArray25, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat26);
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test129");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        CSVParser.Builder builder5 = CSVParser.builder();
        byte[] byteArray8 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder9 = builder5.setByteArray(byteArray8);
        CSVParser.Builder builder10 = builder4.setByteArray(byteArray8);
        CSVParser.Builder builder12 = builder10.setCharSequence((CharSequence) "\n");
        java.io.Writer writer13 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser.Builder builder14 = builder10.setWriter(writer13);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(builder5);
        org.junit.Assert.assertNotNull(byteArray8);
        org.junit.Assert.assertArrayEquals(byteArray8, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder10);
        org.junit.Assert.assertNotNull(builder12);
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test130");
        CSVFormat cSVFormat1 = CSVFormat.newFormat('a');
        String str2 = cSVFormat1.toString();
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "Delimiter=<a> SkipHeaderRecord:false" + "'", str2, "Delimiter=<a> SkipHeaderRecord:false");
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test131");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat3 = cSVFormat2.withSkipHeaderRecord();
        CSVFormat cSVFormat5 = cSVFormat2.withAllowMissingColumnNames(true);
        boolean boolean6 = cSVFormat5.getAllowMissingColumnNames();
        Character char7 = cSVFormat5.getCommentMarker();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat3);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertNull(char7);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test132");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        CSVFormat cSVFormat4 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat5 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode6 = cSVFormat5.getDuplicateHeaderMode();
        CSVFormat cSVFormat8 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray9 = new Object[] { (short) 1, 0.0d, cSVFormat4, cSVFormat5, ' ', cSVFormat8 };
        CSVFormat cSVFormat10 = cSVFormat1.withHeaderComments(objArray9);
        boolean boolean11 = cSVFormat1.getTrailingData();
        CSVFormat cSVFormat12 = cSVFormat1.withAllowMissingColumnNames();
        CSVFormat cSVFormat14 = cSVFormat1.withRecordSeparator("");
        CSVFormat cSVFormat16 = cSVFormat1.withQuote((Character) '\\');
        boolean boolean17 = cSVFormat16.getIgnoreEmptyLines();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode6 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode6.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(objArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(cSVFormat12);
        org.junit.Assert.assertNotNull(cSVFormat14);
        org.junit.Assert.assertNotNull(cSVFormat16);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test133");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat.Builder builder13 = builder11.setEscape((Character) 'a');
        CSVFormat cSVFormat14 = CSVFormat.MONGODB_TSV;
        CSVFormat cSVFormat16 = cSVFormat14.withEscape((Character) 'a');
        CSVFormat cSVFormat18 = cSVFormat16.withIgnoreHeaderCase(false);
        QuoteMode quoteMode19 = cSVFormat16.getQuoteMode();
        CSVFormat.Builder builder20 = builder13.setQuoteMode(quoteMode19);
        CSVFormat cSVFormat21 = CSVFormat.MYSQL;
        CSVFormat cSVFormat23 = cSVFormat21.withEscape('#');
        DuplicateHeaderMode duplicateHeaderMode24 = cSVFormat21.getDuplicateHeaderMode();
        CSVFormat.Builder builder25 = builder13.setDuplicateHeaderMode(duplicateHeaderMode24);
        CSVFormat.Builder builder27 = builder25.setIgnoreEmptyLines(false);
        CSVFormat.Builder builder29 = builder27.setDelimiter("\t");
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(cSVFormat14);
        org.junit.Assert.assertNotNull(cSVFormat16);
        org.junit.Assert.assertNotNull(cSVFormat18);
        org.junit.Assert.assertTrue("'" + quoteMode19 + "' != '" + QuoteMode.MINIMAL + "'", quoteMode19.equals(QuoteMode.MINIMAL));
        org.junit.Assert.assertNotNull(builder20);
        org.junit.Assert.assertNotNull(cSVFormat21);
        org.junit.Assert.assertNotNull(cSVFormat23);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode24 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode24.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(builder25);
        org.junit.Assert.assertNotNull(builder27);
        org.junit.Assert.assertNotNull(builder29);
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test134");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        CSVFormat cSVFormat4 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat5 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode6 = cSVFormat5.getDuplicateHeaderMode();
        CSVFormat cSVFormat8 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray9 = new Object[] { (short) 1, 0.0d, cSVFormat4, cSVFormat5, ' ', cSVFormat8 };
        CSVFormat cSVFormat10 = cSVFormat1.withHeaderComments(objArray9);
        String[] strArray16 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat17 = cSVFormat1.withHeader(strArray16);
        CSVFormat.Builder builder18 = cSVFormat17.builder();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode6 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode6.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(objArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertNotNull(strArray16);
        org.junit.Assert.assertArrayEquals(strArray16, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat17);
        org.junit.Assert.assertNotNull(builder18);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test135");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        CSVFormat cSVFormat4 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat5 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode6 = cSVFormat5.getDuplicateHeaderMode();
        CSVFormat cSVFormat8 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray9 = new Object[] { (short) 1, 0.0d, cSVFormat4, cSVFormat5, ' ', cSVFormat8 };
        CSVFormat cSVFormat10 = cSVFormat1.withHeaderComments(objArray9);
        CSVFormat.Builder builder11 = cSVFormat10.builder();
        CSVFormat.Builder builder13 = builder11.setEscape('\\');
        CSVFormat.Builder builder15 = builder11.setAllowDuplicateHeaderNames(false);
        CSVFormat cSVFormat16 = builder15.build();
        boolean boolean17 = cSVFormat16.getAutoFlush();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode6 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode6.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(objArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(builder15);
        org.junit.Assert.assertNotNull(cSVFormat16);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test136");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        CSVFormat cSVFormat4 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat5 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode6 = cSVFormat5.getDuplicateHeaderMode();
        CSVFormat cSVFormat8 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray9 = new Object[] { (short) 1, 0.0d, cSVFormat4, cSVFormat5, ' ', cSVFormat8 };
        CSVFormat cSVFormat10 = cSVFormat1.withHeaderComments(objArray9);
        String[] strArray16 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat17 = cSVFormat1.withHeader(strArray16);
        boolean boolean18 = cSVFormat1.getTrailingData();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode6 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode6.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(objArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertNotNull(strArray16);
        org.junit.Assert.assertArrayEquals(strArray16, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat17);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test137");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat7 = cSVFormat2.withTrailingDelimiter();
        CSVFormat cSVFormat9 = cSVFormat7.withCommentMarker((Character) '4');
        CSVFormat cSVFormat10 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat11 = cSVFormat10.withSystemRecordSeparator();
        CSVFormat cSVFormat14 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat15 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode16 = cSVFormat15.getDuplicateHeaderMode();
        CSVFormat cSVFormat18 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray19 = new Object[] { (short) 1, 0.0d, cSVFormat14, cSVFormat15, ' ', cSVFormat18 };
        CSVFormat cSVFormat20 = cSVFormat11.withHeaderComments(objArray19);
        boolean boolean21 = cSVFormat11.getTrailingData();
        boolean boolean22 = cSVFormat7.equals((Object) boolean21);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertNotNull(cSVFormat9);
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertNotNull(cSVFormat11);
        org.junit.Assert.assertNotNull(cSVFormat14);
        org.junit.Assert.assertNotNull(cSVFormat15);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode16 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode16.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat18);
        org.junit.Assert.assertNotNull(objArray19);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray19), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray19), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test138");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat.Builder builder13 = builder9.setDelimiter('#');
        CSVFormat cSVFormat14 = builder9.build();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(cSVFormat14);
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test139");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        CSVParser.Builder builder6 = builder0.setFile("");
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(builder6);
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test140");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat7 = cSVFormat2.withTrailingDelimiter();
        boolean boolean8 = cSVFormat2.isNullStringSet();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test141");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat7 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVPrinter cSVPrinter8 = cSVFormat2.printer();
        java.sql.ResultSet resultSet9 = null;
        cSVPrinter8.printHeaders(resultSet9);
        cSVPrinter8.printComment("hi!");
        CSVFormat cSVFormat13 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode14 = cSVFormat13.getDuplicateHeaderMode();
        CSVFormat cSVFormat15 = cSVFormat13.withAllowMissingColumnNames();
        CSVFormat cSVFormat17 = cSVFormat15.withRecordSeparator("");
        CSVFormat cSVFormat18 = cSVFormat15.withTrim();
        CSVFormat cSVFormat19 = cSVFormat15.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat21 = cSVFormat19.withRecordSeparator(' ');
        CSVFormat.Builder builder22 = CSVFormat.Builder.create(cSVFormat19);
        CSVFormat.Builder builder24 = builder22.setRecordSeparator('a');
        CSVFormat.Builder builder26 = builder22.setSkipHeaderRecord(false);
        CSVFormat.Builder builder28 = builder22.setCommentMarker('\t');
        String[] strArray31 = new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" };
        CSVFormat.Builder builder32 = builder28.setHeader(strArray31);
        cSVPrinter8.printRecords((Object[]) strArray31);
        cSVPrinter8.flush();
        java.sql.ResultSet resultSet35 = null;
        // The following exception was thrown during execution in test generation
        try {
            cSVPrinter8.printRecords(resultSet35);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertNotNull(cSVPrinter8);
        org.junit.Assert.assertNotNull(cSVFormat13);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode14 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode14.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat15);
        org.junit.Assert.assertNotNull(cSVFormat17);
        org.junit.Assert.assertNotNull(cSVFormat18);
        org.junit.Assert.assertNotNull(cSVFormat19);
        org.junit.Assert.assertNotNull(cSVFormat21);
        org.junit.Assert.assertNotNull(builder22);
        org.junit.Assert.assertNotNull(builder24);
        org.junit.Assert.assertNotNull(builder26);
        org.junit.Assert.assertNotNull(builder28);
        org.junit.Assert.assertNotNull(strArray31);
        org.junit.Assert.assertArrayEquals(strArray31, new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" });
        org.junit.Assert.assertNotNull(builder32);
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test142");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat3 = cSVFormat2.withSkipHeaderRecord();
        boolean boolean4 = cSVFormat3.getIgnoreHeaderCase();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test143");
        CSVFormat.Predefined predefined0 = CSVFormat.Predefined.PostgreSQLText;
        org.junit.Assert.assertTrue("'" + predefined0 + "' != '" + CSVFormat.Predefined.PostgreSQLText + "'", predefined0.equals(CSVFormat.Predefined.PostgreSQLText));
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test144");
        CSVFormat cSVFormat1 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode2 = cSVFormat1.getDuplicateHeaderMode();
        CSVFormat cSVFormat3 = cSVFormat1.withAllowMissingColumnNames();
        CSVFormat cSVFormat5 = cSVFormat3.withRecordSeparator("");
        CSVFormat cSVFormat6 = cSVFormat3.withTrim();
        CSVFormat cSVFormat7 = cSVFormat3.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat3.withAllowDuplicateHeaderNames();
        CSVPrinter cSVPrinter9 = cSVFormat3.printer();
        java.sql.ResultSet resultSet10 = null;
        cSVPrinter9.printHeaders(resultSet10);
        cSVPrinter9.printComment("hi!");
        CSVFormat cSVFormat14 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode15 = cSVFormat14.getDuplicateHeaderMode();
        CSVFormat cSVFormat16 = cSVFormat14.withAllowMissingColumnNames();
        CSVFormat cSVFormat18 = cSVFormat16.withRecordSeparator("");
        CSVFormat cSVFormat19 = cSVFormat16.withTrim();
        CSVFormat cSVFormat20 = cSVFormat16.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat22 = cSVFormat20.withRecordSeparator(' ');
        CSVFormat.Builder builder23 = CSVFormat.Builder.create(cSVFormat20);
        CSVFormat.Builder builder25 = builder23.setRecordSeparator('a');
        CSVFormat.Builder builder27 = builder23.setSkipHeaderRecord(false);
        CSVFormat.Builder builder29 = builder23.setCommentMarker('\t');
        String[] strArray32 = new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" };
        CSVFormat.Builder builder33 = builder29.setHeader(strArray32);
        cSVPrinter9.printRecords((Object[]) strArray32);
        CSVException cSVException35 = new CSVException("hi!", (Object[]) strArray32);
        CSVFormat cSVFormat37 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode38 = cSVFormat37.getDuplicateHeaderMode();
        CSVFormat cSVFormat39 = cSVFormat37.withAllowMissingColumnNames();
        CSVFormat cSVFormat41 = cSVFormat39.withRecordSeparator("");
        CSVFormat cSVFormat42 = cSVFormat39.withTrim();
        CSVFormat cSVFormat43 = cSVFormat39.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat44 = cSVFormat39.withAllowDuplicateHeaderNames();
        CSVPrinter cSVPrinter45 = cSVFormat39.printer();
        java.sql.ResultSet resultSet46 = null;
        cSVPrinter45.printHeaders(resultSet46);
        cSVPrinter45.printComment("hi!");
        CSVFormat cSVFormat50 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode51 = cSVFormat50.getDuplicateHeaderMode();
        CSVFormat cSVFormat52 = cSVFormat50.withAllowMissingColumnNames();
        CSVFormat cSVFormat54 = cSVFormat52.withRecordSeparator("");
        CSVFormat cSVFormat55 = cSVFormat52.withTrim();
        CSVFormat cSVFormat56 = cSVFormat52.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat58 = cSVFormat56.withRecordSeparator(' ');
        CSVFormat.Builder builder59 = CSVFormat.Builder.create(cSVFormat56);
        CSVFormat.Builder builder61 = builder59.setRecordSeparator('a');
        CSVFormat.Builder builder63 = builder59.setSkipHeaderRecord(false);
        CSVFormat.Builder builder65 = builder59.setCommentMarker('\t');
        String[] strArray68 = new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" };
        CSVFormat.Builder builder69 = builder65.setHeader(strArray68);
        cSVPrinter45.printRecords((Object[]) strArray68);
        CSVException cSVException71 = new CSVException("hi!", (Object[]) strArray68);
        cSVException35.addSuppressed((Throwable) cSVException71);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode2 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode2.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat3);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(cSVPrinter9);
        org.junit.Assert.assertNotNull(cSVFormat14);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode15 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode15.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat16);
        org.junit.Assert.assertNotNull(cSVFormat18);
        org.junit.Assert.assertNotNull(cSVFormat19);
        org.junit.Assert.assertNotNull(cSVFormat20);
        org.junit.Assert.assertNotNull(cSVFormat22);
        org.junit.Assert.assertNotNull(builder23);
        org.junit.Assert.assertNotNull(builder25);
        org.junit.Assert.assertNotNull(builder27);
        org.junit.Assert.assertNotNull(builder29);
        org.junit.Assert.assertNotNull(strArray32);
        org.junit.Assert.assertArrayEquals(strArray32, new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" });
        org.junit.Assert.assertNotNull(builder33);
        org.junit.Assert.assertNotNull(cSVFormat37);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode38 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode38.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat39);
        org.junit.Assert.assertNotNull(cSVFormat41);
        org.junit.Assert.assertNotNull(cSVFormat42);
        org.junit.Assert.assertNotNull(cSVFormat43);
        org.junit.Assert.assertNotNull(cSVFormat44);
        org.junit.Assert.assertNotNull(cSVPrinter45);
        org.junit.Assert.assertNotNull(cSVFormat50);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode51 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode51.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat52);
        org.junit.Assert.assertNotNull(cSVFormat54);
        org.junit.Assert.assertNotNull(cSVFormat55);
        org.junit.Assert.assertNotNull(cSVFormat56);
        org.junit.Assert.assertNotNull(cSVFormat58);
        org.junit.Assert.assertNotNull(builder59);
        org.junit.Assert.assertNotNull(builder61);
        org.junit.Assert.assertNotNull(builder63);
        org.junit.Assert.assertNotNull(builder65);
        org.junit.Assert.assertNotNull(strArray68);
        org.junit.Assert.assertArrayEquals(strArray68, new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" });
        org.junit.Assert.assertNotNull(builder69);
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test145");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat.Builder builder13 = builder9.setDelimiter('#');
        java.sql.ResultSetMetaData resultSetMetaData14 = null;
        CSVFormat.Builder builder15 = builder9.setHeader(resultSetMetaData14);
        CSVFormat.Builder builder17 = builder15.setQuote('\"');
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(builder15);
        org.junit.Assert.assertNotNull(builder17);
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test146");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        CSVFormat cSVFormat4 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat5 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode6 = cSVFormat5.getDuplicateHeaderMode();
        CSVFormat cSVFormat8 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray9 = new Object[] { (short) 1, 0.0d, cSVFormat4, cSVFormat5, ' ', cSVFormat8 };
        CSVFormat cSVFormat10 = cSVFormat1.withHeaderComments(objArray9);
        boolean boolean11 = cSVFormat1.getTrailingData();
        CSVFormat cSVFormat12 = cSVFormat1.withAllowMissingColumnNames();
        CSVFormat cSVFormat14 = cSVFormat1.withRecordSeparator("");
        CSVFormat cSVFormat16 = cSVFormat1.withTrim(false);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode6 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode6.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(objArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(cSVFormat12);
        org.junit.Assert.assertNotNull(cSVFormat14);
        org.junit.Assert.assertNotNull(cSVFormat16);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test147");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        CSVFormat cSVFormat4 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat5 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode6 = cSVFormat5.getDuplicateHeaderMode();
        CSVFormat cSVFormat8 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray9 = new Object[] { (short) 1, 0.0d, cSVFormat4, cSVFormat5, ' ', cSVFormat8 };
        CSVFormat cSVFormat10 = cSVFormat1.withHeaderComments(objArray9);
        CSVFormat.Builder builder11 = cSVFormat10.builder();
        CSVFormat.Builder builder13 = builder11.setEscape('\\');
        CSVFormat.Builder builder15 = builder13.setIgnoreHeaderCase(false);
        CSVFormat.Builder builder17 = builder15.setQuote('#');
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode6 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode6.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(objArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(builder15);
        org.junit.Assert.assertNotNull(builder17);
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test148");
        CSVFormat cSVFormat1 = CSVFormat.newFormat('a');
        java.sql.ResultSet resultSet2 = null;
        CSVFormat cSVFormat3 = cSVFormat1.withHeader(resultSet2);
        CSVFormat cSVFormat5 = cSVFormat3.withEscape('\\');
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat3);
        org.junit.Assert.assertNotNull(cSVFormat5);
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test149");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat7 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVPrinter cSVPrinter8 = cSVFormat2.printer();
        java.sql.ResultSet resultSet9 = null;
        cSVPrinter8.printHeaders(resultSet9);
        cSVPrinter8.printComment("hi!");
        cSVPrinter8.close();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertNotNull(cSVPrinter8);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test150");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        CSVParser.Builder builder5 = CSVParser.builder();
        byte[] byteArray8 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder9 = builder5.setByteArray(byteArray8);
        CSVParser.Builder builder10 = builder4.setByteArray(byteArray8);
        CSVParser.Builder builder12 = builder4.setFile("hi!");
        CSVParser.Builder builder13 = CSVParser.builder();
        byte[] byteArray16 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder17 = builder13.setByteArray(byteArray16);
        CSVParser.Builder builder18 = CSVParser.builder();
        byte[] byteArray21 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder22 = builder18.setByteArray(byteArray21);
        CSVParser.Builder builder23 = builder17.setByteArray(byteArray21);
        CSVParser.Builder builder25 = builder17.setFile("hi!");
        java.nio.charset.Charset charset26 = builder17.getCharset();
        // The following exception was thrown during execution in test generation
        try {
            CSVParser.Builder builder27 = builder12.setCharset(charset26);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.io.Charsets.toCharset(Ljava/nio/charset/Charset;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(builder5);
        org.junit.Assert.assertNotNull(byteArray8);
        org.junit.Assert.assertArrayEquals(byteArray8, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder10);
        org.junit.Assert.assertNotNull(builder12);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(byteArray16);
        org.junit.Assert.assertArrayEquals(byteArray16, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder17);
        org.junit.Assert.assertNotNull(builder18);
        org.junit.Assert.assertNotNull(byteArray21);
        org.junit.Assert.assertArrayEquals(byteArray21, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder22);
        org.junit.Assert.assertNotNull(builder23);
        org.junit.Assert.assertNotNull(builder25);
        org.junit.Assert.assertNotNull(charset26);
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test151");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        CSVParser.Builder builder6 = builder0.setTrackBytes(false);
        CSVParser.Builder builder8 = builder6.setCharSequence((CharSequence) "hi!");
        CSVParser.Builder builder10 = builder8.setBufferSize((int) (byte) 10);
        java.net.URI uRI11 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser.Builder builder12 = builder10.setURI(uRI11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(builder6);
        org.junit.Assert.assertNotNull(builder8);
        org.junit.Assert.assertNotNull(builder10);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test152");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        boolean boolean1 = cSVFormat0.getIgnoreHeaderCase();
        boolean boolean2 = cSVFormat0.getTrim();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test153");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        java.sql.ResultSetMetaData resultSetMetaData3 = null;
        CSVFormat cSVFormat4 = cSVFormat2.withHeader(resultSetMetaData3);
        boolean boolean5 = cSVFormat2.getTrailingData();
        CSVFormat.Builder builder6 = CSVFormat.Builder.create(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(builder6);
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test154");
        CSVFormat cSVFormat0 = CSVFormat.INFORMIX_UNLOAD_CSV;
        char char1 = cSVFormat0.getDelimiter();
        boolean boolean3 = cSVFormat0.equals((Object) (short) 100);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + char1 + "' != '" + ',' + "'", char1 == ',');
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test155");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat cSVFormat12 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode13 = cSVFormat12.getDuplicateHeaderMode();
        CSVFormat cSVFormat14 = cSVFormat12.withAllowMissingColumnNames();
        CSVFormat cSVFormat16 = cSVFormat14.withRecordSeparator("");
        CSVFormat cSVFormat17 = cSVFormat14.withTrim();
        CSVFormat cSVFormat18 = cSVFormat14.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat19 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat20 = cSVFormat19.withSystemRecordSeparator();
        CSVFormat cSVFormat23 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat24 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode25 = cSVFormat24.getDuplicateHeaderMode();
        CSVFormat cSVFormat27 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray28 = new Object[] { (short) 1, 0.0d, cSVFormat23, cSVFormat24, ' ', cSVFormat27 };
        CSVFormat cSVFormat29 = cSVFormat20.withHeaderComments(objArray28);
        String[] strArray35 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat36 = cSVFormat20.withHeader(strArray35);
        CSVFormat cSVFormat37 = cSVFormat14.withHeaderComments((Object[]) strArray35);
        CSVFormat.Builder builder38 = builder11.setHeaderComments((Object[]) strArray35);
        CSVFormat cSVFormat39 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode40 = cSVFormat39.getDuplicateHeaderMode();
        CSVFormat cSVFormat41 = cSVFormat39.withAllowMissingColumnNames();
        CSVFormat cSVFormat43 = cSVFormat41.withRecordSeparator("");
        CSVFormat cSVFormat44 = cSVFormat41.withTrim();
        CSVFormat cSVFormat45 = cSVFormat41.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat47 = cSVFormat45.withRecordSeparator(' ');
        CSVFormat.Builder builder48 = CSVFormat.Builder.create(cSVFormat45);
        CSVFormat.Builder builder50 = builder48.setRecordSeparator('a');
        CSVFormat cSVFormat51 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode52 = cSVFormat51.getDuplicateHeaderMode();
        CSVFormat cSVFormat53 = cSVFormat51.withAllowMissingColumnNames();
        CSVFormat cSVFormat55 = cSVFormat53.withRecordSeparator("");
        CSVFormat cSVFormat56 = cSVFormat53.withTrim();
        CSVFormat cSVFormat57 = cSVFormat53.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat58 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat59 = cSVFormat58.withSystemRecordSeparator();
        CSVFormat cSVFormat62 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat63 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode64 = cSVFormat63.getDuplicateHeaderMode();
        CSVFormat cSVFormat66 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray67 = new Object[] { (short) 1, 0.0d, cSVFormat62, cSVFormat63, ' ', cSVFormat66 };
        CSVFormat cSVFormat68 = cSVFormat59.withHeaderComments(objArray67);
        String[] strArray74 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat75 = cSVFormat59.withHeader(strArray74);
        CSVFormat cSVFormat76 = cSVFormat53.withHeaderComments((Object[]) strArray74);
        CSVFormat.Builder builder77 = builder50.setHeaderComments((Object[]) strArray74);
        CSVFormat.Builder builder78 = builder11.setHeaderComments(strArray74);
        CSVFormat.Builder builder80 = builder78.setTrim(false);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(cSVFormat12);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode13 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode13.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat14);
        org.junit.Assert.assertNotNull(cSVFormat16);
        org.junit.Assert.assertNotNull(cSVFormat17);
        org.junit.Assert.assertNotNull(cSVFormat18);
        org.junit.Assert.assertNotNull(cSVFormat19);
        org.junit.Assert.assertNotNull(cSVFormat20);
        org.junit.Assert.assertNotNull(cSVFormat23);
        org.junit.Assert.assertNotNull(cSVFormat24);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode25 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode25.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat27);
        org.junit.Assert.assertNotNull(objArray28);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray28), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray28), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat29);
        org.junit.Assert.assertNotNull(strArray35);
        org.junit.Assert.assertArrayEquals(strArray35, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat36);
        org.junit.Assert.assertNotNull(cSVFormat37);
        org.junit.Assert.assertNotNull(builder38);
        org.junit.Assert.assertNotNull(cSVFormat39);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode40 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode40.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat41);
        org.junit.Assert.assertNotNull(cSVFormat43);
        org.junit.Assert.assertNotNull(cSVFormat44);
        org.junit.Assert.assertNotNull(cSVFormat45);
        org.junit.Assert.assertNotNull(cSVFormat47);
        org.junit.Assert.assertNotNull(builder48);
        org.junit.Assert.assertNotNull(builder50);
        org.junit.Assert.assertNotNull(cSVFormat51);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode52 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode52.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat53);
        org.junit.Assert.assertNotNull(cSVFormat55);
        org.junit.Assert.assertNotNull(cSVFormat56);
        org.junit.Assert.assertNotNull(cSVFormat57);
        org.junit.Assert.assertNotNull(cSVFormat58);
        org.junit.Assert.assertNotNull(cSVFormat59);
        org.junit.Assert.assertNotNull(cSVFormat62);
        org.junit.Assert.assertNotNull(cSVFormat63);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode64 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode64.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat66);
        org.junit.Assert.assertNotNull(objArray67);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray67), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray67), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat68);
        org.junit.Assert.assertNotNull(strArray74);
        org.junit.Assert.assertArrayEquals(strArray74, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat75);
        org.junit.Assert.assertNotNull(cSVFormat76);
        org.junit.Assert.assertNotNull(builder77);
        org.junit.Assert.assertNotNull(builder78);
        org.junit.Assert.assertNotNull(builder80);
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test156");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        CSVParser.Builder builder6 = builder0.setTrackBytes(false);
        CSVParser.Builder builder8 = builder6.setCharSequence((CharSequence) "hi!");
        CSVParser.Builder builder10 = builder8.setBufferSize((int) (byte) 10);
        java.io.InputStream inputStream11 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser.Builder builder12 = builder10.setInputStream(inputStream11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(builder6);
        org.junit.Assert.assertNotNull(builder8);
        org.junit.Assert.assertNotNull(builder10);
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test157");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        CSVParser.Builder builder5 = CSVParser.builder();
        byte[] byteArray8 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder9 = builder5.setByteArray(byteArray8);
        CSVParser.Builder builder10 = builder4.setByteArray(byteArray8);
        CSVParser.Builder builder12 = builder10.setCharSequence((CharSequence) "\n");
        CSVParser.Builder builder14 = builder10.setBufferSize((Integer) 100);
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(builder5);
        org.junit.Assert.assertNotNull(byteArray8);
        org.junit.Assert.assertArrayEquals(byteArray8, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder10);
        org.junit.Assert.assertNotNull(builder12);
        org.junit.Assert.assertNotNull(builder14);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test158");
        java.nio.file.Path path0 = null;
        CSVParser.Builder builder1 = CSVParser.builder();
        byte[] byteArray4 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder5 = builder1.setByteArray(byteArray4);
        CSVParser.Builder builder7 = builder1.setTrackBytes(false);
        java.nio.charset.Charset charset8 = builder1.getCharset();
        CSVFormat cSVFormat9 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode10 = cSVFormat9.getDuplicateHeaderMode();
        CSVFormat cSVFormat11 = cSVFormat9.withAllowMissingColumnNames();
        java.sql.ResultSetMetaData resultSetMetaData12 = null;
        CSVFormat cSVFormat13 = cSVFormat11.withHeader(resultSetMetaData12);
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser14 = CSVParser.parse(path0, charset8, cSVFormat11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: path");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder1);
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder5);
        org.junit.Assert.assertNotNull(builder7);
        org.junit.Assert.assertNotNull(charset8);
        org.junit.Assert.assertNotNull(cSVFormat9);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode10 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode10.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat11);
        org.junit.Assert.assertNotNull(cSVFormat13);
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test159");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        CSVParser.Builder builder5 = CSVParser.builder();
        byte[] byteArray8 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder9 = builder5.setByteArray(byteArray8);
        CSVParser.Builder builder10 = builder4.setByteArray(byteArray8);
        java.io.File file11 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser.Builder builder12 = builder10.setFile(file11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(builder5);
        org.junit.Assert.assertNotNull(byteArray8);
        org.junit.Assert.assertArrayEquals(byteArray8, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder10);
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test160");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat2 = cSVFormat0.withSkipHeaderRecord(false);
        // The following exception was thrown during execution in test generation
        try {
            CSVFormat cSVFormat4 = cSVFormat0.withEscape((Character) '\t');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The escape character and the delimiter cannot be the same ('?')");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat2);
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test161");
        java.io.Reader reader0 = null;
        CSVFormat cSVFormat1 = CSVFormat.MONGODB_TSV;
        CSVFormat cSVFormat3 = cSVFormat1.withEscape((Character) 'a');
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser4 = CSVParser.parse(reader0, cSVFormat1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat3);
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test162");
        CSVFormat cSVFormat1 = CSVFormat.MONGODB_CSV;
        CSVFormat cSVFormat3 = cSVFormat1.withNullString("\t");
        java.sql.ResultSetMetaData resultSetMetaData4 = null;
        CSVFormat cSVFormat5 = cSVFormat3.withHeader(resultSetMetaData4);
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser6 = CSVParser.parse("hi!", cSVFormat5);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.csv.CSVParser$Builder.getReader()Ljava/io/Reader;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat3);
        org.junit.Assert.assertNotNull(cSVFormat5);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test163");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        CSVFormat cSVFormat4 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat5 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode6 = cSVFormat5.getDuplicateHeaderMode();
        CSVFormat cSVFormat8 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray9 = new Object[] { (short) 1, 0.0d, cSVFormat4, cSVFormat5, ' ', cSVFormat8 };
        CSVFormat cSVFormat10 = cSVFormat1.withHeaderComments(objArray9);
        java.io.Reader reader11 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser12 = cSVFormat1.parse(reader11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode6 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode6.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(objArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat10);
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test164");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withCommentMarker((Character) '\"');
        CSVFormat cSVFormat9 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode10 = cSVFormat9.getDuplicateHeaderMode();
        CSVFormat cSVFormat11 = cSVFormat9.withAllowMissingColumnNames();
        CSVFormat cSVFormat13 = cSVFormat11.withRecordSeparator("");
        CSVFormat cSVFormat14 = cSVFormat11.withTrim();
        CSVFormat cSVFormat15 = cSVFormat11.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat16 = cSVFormat11.withAllowDuplicateHeaderNames();
        CSVPrinter cSVPrinter17 = cSVFormat11.printer();
        java.sql.ResultSet resultSet18 = null;
        cSVPrinter17.printHeaders(resultSet18);
        cSVPrinter17.printComment("hi!");
        CSVFormat cSVFormat22 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode23 = cSVFormat22.getDuplicateHeaderMode();
        CSVFormat cSVFormat24 = cSVFormat22.withAllowMissingColumnNames();
        CSVFormat cSVFormat26 = cSVFormat24.withRecordSeparator("");
        CSVFormat cSVFormat27 = cSVFormat24.withTrim();
        CSVFormat cSVFormat28 = cSVFormat24.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat30 = cSVFormat28.withRecordSeparator(' ');
        CSVFormat.Builder builder31 = CSVFormat.Builder.create(cSVFormat28);
        CSVFormat.Builder builder33 = builder31.setRecordSeparator('a');
        CSVFormat.Builder builder35 = builder31.setSkipHeaderRecord(false);
        CSVFormat.Builder builder37 = builder31.setCommentMarker('\t');
        String[] strArray40 = new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" };
        CSVFormat.Builder builder41 = builder37.setHeader(strArray40);
        cSVPrinter17.printRecords((Object[]) strArray40);
        Appendable appendable43 = cSVPrinter17.getOut();
        CSVFormat cSVFormat44 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode45 = cSVFormat44.getDuplicateHeaderMode();
        CSVFormat cSVFormat46 = cSVFormat44.withAllowMissingColumnNames();
        CSVFormat cSVFormat48 = cSVFormat46.withRecordSeparator("");
        CSVFormat cSVFormat49 = cSVFormat46.withTrim();
        CSVFormat cSVFormat50 = cSVFormat46.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat51 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat52 = cSVFormat51.withSystemRecordSeparator();
        CSVFormat cSVFormat55 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat56 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode57 = cSVFormat56.getDuplicateHeaderMode();
        CSVFormat cSVFormat59 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray60 = new Object[] { (short) 1, 0.0d, cSVFormat55, cSVFormat56, ' ', cSVFormat59 };
        CSVFormat cSVFormat61 = cSVFormat52.withHeaderComments(objArray60);
        String[] strArray67 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat68 = cSVFormat52.withHeader(strArray67);
        CSVFormat cSVFormat69 = cSVFormat46.withHeaderComments((Object[]) strArray67);
        cSVFormat8.printRecord(appendable43, (Object[]) strArray67);
        CSVFormat cSVFormat71 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode72 = cSVFormat71.getDuplicateHeaderMode();
        CSVFormat cSVFormat73 = cSVFormat71.withAllowMissingColumnNames();
        CSVFormat cSVFormat75 = cSVFormat73.withRecordSeparator("");
        CSVFormat cSVFormat77 = cSVFormat75.withEscape('4');
        CSVFormat cSVFormat78 = cSVFormat75.withIgnoreSurroundingSpaces();
        CSVPrinter cSVPrinter79 = new CSVPrinter(appendable43, cSVFormat78);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(cSVFormat9);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode10 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode10.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat11);
        org.junit.Assert.assertNotNull(cSVFormat13);
        org.junit.Assert.assertNotNull(cSVFormat14);
        org.junit.Assert.assertNotNull(cSVFormat15);
        org.junit.Assert.assertNotNull(cSVFormat16);
        org.junit.Assert.assertNotNull(cSVPrinter17);
        org.junit.Assert.assertNotNull(cSVFormat22);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode23 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode23.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat24);
        org.junit.Assert.assertNotNull(cSVFormat26);
        org.junit.Assert.assertNotNull(cSVFormat27);
        org.junit.Assert.assertNotNull(cSVFormat28);
        org.junit.Assert.assertNotNull(cSVFormat30);
        org.junit.Assert.assertNotNull(builder31);
        org.junit.Assert.assertNotNull(builder33);
        org.junit.Assert.assertNotNull(builder35);
        org.junit.Assert.assertNotNull(builder37);
        org.junit.Assert.assertNotNull(strArray40);
        org.junit.Assert.assertArrayEquals(strArray40, new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" });
        org.junit.Assert.assertNotNull(builder41);
        org.junit.Assert.assertNotNull(appendable43);
        org.junit.Assert.assertNotNull(cSVFormat44);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode45 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode45.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat46);
        org.junit.Assert.assertNotNull(cSVFormat48);
        org.junit.Assert.assertNotNull(cSVFormat49);
        org.junit.Assert.assertNotNull(cSVFormat50);
        org.junit.Assert.assertNotNull(cSVFormat51);
        org.junit.Assert.assertNotNull(cSVFormat52);
        org.junit.Assert.assertNotNull(cSVFormat55);
        org.junit.Assert.assertNotNull(cSVFormat56);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode57 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode57.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat59);
        org.junit.Assert.assertNotNull(objArray60);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray60), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray60), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat61);
        org.junit.Assert.assertNotNull(strArray67);
        org.junit.Assert.assertArrayEquals(strArray67, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat68);
        org.junit.Assert.assertNotNull(cSVFormat69);
        org.junit.Assert.assertNotNull(cSVFormat71);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode72 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode72.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat73);
        org.junit.Assert.assertNotNull(cSVFormat75);
        org.junit.Assert.assertNotNull(cSVFormat77);
        org.junit.Assert.assertNotNull(cSVFormat78);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test165");
        // The following exception was thrown during execution in test generation
        try {
            CSVFormat cSVFormat1 = CSVFormat.valueOf("Delimiter=<a> SkipHeaderRecord:false");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: No enum constant org.apache.commons.csv.CSVFormat.Predefined.Delimiter=<a> SkipHeaderRecord:false");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test166");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat7 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVPrinter cSVPrinter8 = cSVFormat2.printer();
        java.sql.ResultSet resultSet9 = null;
        cSVPrinter8.printHeaders(resultSet9);
        cSVPrinter8.printComment("hi!");
        CSVFormat cSVFormat13 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode14 = cSVFormat13.getDuplicateHeaderMode();
        CSVFormat cSVFormat15 = cSVFormat13.withAllowMissingColumnNames();
        CSVFormat cSVFormat17 = cSVFormat15.withRecordSeparator("");
        CSVFormat cSVFormat18 = cSVFormat15.withTrim();
        CSVFormat cSVFormat19 = cSVFormat15.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat21 = cSVFormat19.withRecordSeparator(' ');
        CSVFormat.Builder builder22 = CSVFormat.Builder.create(cSVFormat19);
        CSVFormat.Builder builder24 = builder22.setRecordSeparator('a');
        CSVFormat.Builder builder26 = builder22.setSkipHeaderRecord(false);
        CSVFormat.Builder builder28 = builder22.setCommentMarker('\t');
        String[] strArray31 = new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" };
        CSVFormat.Builder builder32 = builder28.setHeader(strArray31);
        cSVPrinter8.printRecords((Object[]) strArray31);
        CSVFormat cSVFormat35 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode36 = cSVFormat35.getDuplicateHeaderMode();
        CSVFormat cSVFormat37 = cSVFormat35.withAllowMissingColumnNames();
        CSVFormat cSVFormat39 = cSVFormat37.withRecordSeparator("");
        CSVFormat cSVFormat40 = cSVFormat37.withTrim();
        CSVFormat cSVFormat41 = cSVFormat37.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat42 = cSVFormat37.withAllowDuplicateHeaderNames();
        CSVPrinter cSVPrinter43 = cSVFormat37.printer();
        java.sql.ResultSet resultSet44 = null;
        cSVPrinter43.printHeaders(resultSet44);
        cSVPrinter43.printComment("hi!");
        CSVFormat cSVFormat48 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode49 = cSVFormat48.getDuplicateHeaderMode();
        CSVFormat cSVFormat50 = cSVFormat48.withAllowMissingColumnNames();
        CSVFormat cSVFormat52 = cSVFormat50.withRecordSeparator("");
        CSVFormat cSVFormat53 = cSVFormat50.withTrim();
        CSVFormat cSVFormat54 = cSVFormat50.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat56 = cSVFormat54.withRecordSeparator(' ');
        CSVFormat.Builder builder57 = CSVFormat.Builder.create(cSVFormat54);
        CSVFormat.Builder builder59 = builder57.setRecordSeparator('a');
        CSVFormat.Builder builder61 = builder57.setSkipHeaderRecord(false);
        CSVFormat.Builder builder63 = builder57.setCommentMarker('\t');
        String[] strArray66 = new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" };
        CSVFormat.Builder builder67 = builder63.setHeader(strArray66);
        cSVPrinter43.printRecords((Object[]) strArray66);
        CSVException cSVException69 = new CSVException("hi!", (Object[]) strArray66);
        cSVPrinter8.printRecord((Object[]) strArray66);
        Appendable appendable71 = cSVPrinter8.getOut();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertNotNull(cSVPrinter8);
        org.junit.Assert.assertNotNull(cSVFormat13);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode14 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode14.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat15);
        org.junit.Assert.assertNotNull(cSVFormat17);
        org.junit.Assert.assertNotNull(cSVFormat18);
        org.junit.Assert.assertNotNull(cSVFormat19);
        org.junit.Assert.assertNotNull(cSVFormat21);
        org.junit.Assert.assertNotNull(builder22);
        org.junit.Assert.assertNotNull(builder24);
        org.junit.Assert.assertNotNull(builder26);
        org.junit.Assert.assertNotNull(builder28);
        org.junit.Assert.assertNotNull(strArray31);
        org.junit.Assert.assertArrayEquals(strArray31, new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" });
        org.junit.Assert.assertNotNull(builder32);
        org.junit.Assert.assertNotNull(cSVFormat35);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode36 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode36.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat37);
        org.junit.Assert.assertNotNull(cSVFormat39);
        org.junit.Assert.assertNotNull(cSVFormat40);
        org.junit.Assert.assertNotNull(cSVFormat41);
        org.junit.Assert.assertNotNull(cSVFormat42);
        org.junit.Assert.assertNotNull(cSVPrinter43);
        org.junit.Assert.assertNotNull(cSVFormat48);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode49 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode49.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat50);
        org.junit.Assert.assertNotNull(cSVFormat52);
        org.junit.Assert.assertNotNull(cSVFormat53);
        org.junit.Assert.assertNotNull(cSVFormat54);
        org.junit.Assert.assertNotNull(cSVFormat56);
        org.junit.Assert.assertNotNull(builder57);
        org.junit.Assert.assertNotNull(builder59);
        org.junit.Assert.assertNotNull(builder61);
        org.junit.Assert.assertNotNull(builder63);
        org.junit.Assert.assertNotNull(strArray66);
        org.junit.Assert.assertArrayEquals(strArray66, new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" });
        org.junit.Assert.assertNotNull(builder67);
        org.junit.Assert.assertNotNull(appendable71);
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test167");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat7 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat8 = cSVFormat7.withSystemRecordSeparator();
        CSVFormat cSVFormat11 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat12 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode13 = cSVFormat12.getDuplicateHeaderMode();
        CSVFormat cSVFormat15 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray16 = new Object[] { (short) 1, 0.0d, cSVFormat11, cSVFormat12, ' ', cSVFormat15 };
        CSVFormat cSVFormat17 = cSVFormat8.withHeaderComments(objArray16);
        String[] strArray23 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat24 = cSVFormat8.withHeader(strArray23);
        CSVFormat cSVFormat25 = cSVFormat2.withHeaderComments((Object[]) strArray23);
        CSVFormat cSVFormat26 = cSVFormat2.withTrailingDelimiter();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(cSVFormat11);
        org.junit.Assert.assertNotNull(cSVFormat12);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode13 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode13.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat15);
        org.junit.Assert.assertNotNull(objArray16);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray16), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray16), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat17);
        org.junit.Assert.assertNotNull(strArray23);
        org.junit.Assert.assertArrayEquals(strArray23, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat24);
        org.junit.Assert.assertNotNull(cSVFormat25);
        org.junit.Assert.assertNotNull(cSVFormat26);
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test168");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat.Builder builder13 = builder11.setQuote((Character) ',');
        java.sql.ResultSet resultSet14 = null;
        CSVFormat.Builder builder15 = builder11.setHeader(resultSet14);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(builder15);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test169");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat.Builder builder13 = builder9.setDelimiter('#');
        CSVFormat.Builder builder15 = builder9.setIgnoreEmptyLines(false);
        CSVFormat.Builder builder17 = builder15.setIgnoreEmptyLines(false);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(builder15);
        org.junit.Assert.assertNotNull(builder17);
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test170");
        CSVFormat cSVFormat0 = CSVFormat.INFORMIX_UNLOAD_CSV;
        CSVFormat cSVFormat1 = cSVFormat0.withFirstRecordAsHeader();
        boolean boolean2 = cSVFormat0.getIgnoreEmptyLines();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test171");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat.Builder builder13 = builder11.setEscape((Character) 'a');
        CSVFormat cSVFormat14 = CSVFormat.MONGODB_TSV;
        CSVFormat cSVFormat16 = cSVFormat14.withEscape((Character) 'a');
        CSVFormat cSVFormat18 = cSVFormat16.withIgnoreHeaderCase(false);
        QuoteMode quoteMode19 = cSVFormat16.getQuoteMode();
        CSVFormat.Builder builder20 = builder13.setQuoteMode(quoteMode19);
        CSVFormat.Predefined predefined21 = CSVFormat.Predefined.PostgreSQLCsv;
        CSVFormat cSVFormat22 = predefined21.getFormat();
        String str23 = cSVFormat22.getDelimiterString();
        CSVFormat cSVFormat24 = cSVFormat22.withTrailingDelimiter();
        CSVFormat cSVFormat25 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode26 = cSVFormat25.getDuplicateHeaderMode();
        CSVFormat cSVFormat27 = cSVFormat25.withAllowMissingColumnNames();
        CSVFormat cSVFormat29 = cSVFormat27.withRecordSeparator("");
        CSVFormat cSVFormat31 = cSVFormat29.withEscape('4');
        CSVParser.Builder builder32 = CSVParser.builder();
        byte[] byteArray35 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder36 = builder32.setByteArray(byteArray35);
        java.nio.file.OpenOption openOption37 = null;
        java.nio.file.OpenOption[] openOptionArray38 = new java.nio.file.OpenOption[] { openOption37 };
        CSVParser.Builder builder39 = builder32.setOpenOptions(openOptionArray38);
        CSVParser.Builder builder40 = CSVParser.builder();
        byte[] byteArray43 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder44 = builder40.setByteArray(byteArray43);
        CSVParser.Builder builder45 = CSVParser.builder();
        byte[] byteArray48 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder49 = builder45.setByteArray(byteArray48);
        CSVParser.Builder builder50 = builder44.setByteArray(byteArray48);
        CSVParser.Builder builder52 = builder44.setFile("hi!");
        Object[] objArray54 = new Object[] { cSVFormat24, '4', builder39, builder52, (short) -1 };
        CSVFormat.Builder builder55 = builder20.setHeaderComments(objArray54);
        CSVFormat.Builder builder57 = builder20.setSkipHeaderRecord(false);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(cSVFormat14);
        org.junit.Assert.assertNotNull(cSVFormat16);
        org.junit.Assert.assertNotNull(cSVFormat18);
        org.junit.Assert.assertTrue("'" + quoteMode19 + "' != '" + QuoteMode.MINIMAL + "'", quoteMode19.equals(QuoteMode.MINIMAL));
        org.junit.Assert.assertNotNull(builder20);
        org.junit.Assert.assertTrue("'" + predefined21 + "' != '" + CSVFormat.Predefined.PostgreSQLCsv + "'", predefined21.equals(CSVFormat.Predefined.PostgreSQLCsv));
        org.junit.Assert.assertNotNull(cSVFormat22);
        org.junit.Assert.assertEquals("'" + str23 + "' != '" + "," + "'", str23, ",");
        org.junit.Assert.assertNotNull(cSVFormat24);
        org.junit.Assert.assertNotNull(cSVFormat25);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode26 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode26.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat27);
        org.junit.Assert.assertNotNull(cSVFormat29);
        org.junit.Assert.assertNotNull(cSVFormat31);
        org.junit.Assert.assertNotNull(builder32);
        org.junit.Assert.assertNotNull(byteArray35);
        org.junit.Assert.assertArrayEquals(byteArray35, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder36);
        org.junit.Assert.assertNotNull(openOptionArray38);
        org.junit.Assert.assertArrayEquals(openOptionArray38, new java.nio.file.OpenOption[] { null });
        org.junit.Assert.assertNotNull(builder39);
        org.junit.Assert.assertNotNull(builder40);
        org.junit.Assert.assertNotNull(byteArray43);
        org.junit.Assert.assertArrayEquals(byteArray43, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder44);
        org.junit.Assert.assertNotNull(builder45);
        org.junit.Assert.assertNotNull(byteArray48);
        org.junit.Assert.assertArrayEquals(byteArray48, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder49);
        org.junit.Assert.assertNotNull(builder50);
        org.junit.Assert.assertNotNull(builder52);
        org.junit.Assert.assertNotNull(objArray54);
        org.junit.Assert.assertNotNull(builder55);
        org.junit.Assert.assertNotNull(builder57);
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test172");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_CSV;
        CSVFormat cSVFormat1 = cSVFormat0.withTrim();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test173");
        CSVFormat cSVFormat0 = CSVFormat.MONGODB_TSV;
        CSVFormat cSVFormat2 = cSVFormat0.withEscape((Character) 'a');
        Class<?> wildcardClass3 = cSVFormat0.getClass();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test174");
        CSVFormat cSVFormat1 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode2 = cSVFormat1.getDuplicateHeaderMode();
        CSVFormat cSVFormat3 = cSVFormat1.withAllowMissingColumnNames();
        CSVFormat cSVFormat5 = cSVFormat3.withRecordSeparator("");
        CSVFormat cSVFormat6 = cSVFormat3.withTrim();
        CSVFormat cSVFormat7 = cSVFormat3.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat9 = cSVFormat7.withRecordSeparator(' ');
        CSVFormat.Builder builder10 = CSVFormat.Builder.create(cSVFormat7);
        CSVFormat.Builder builder12 = builder10.setRecordSeparator('a');
        CSVFormat.Builder builder14 = builder10.setSkipHeaderRecord(false);
        CSVFormat.Builder builder16 = builder10.setCommentMarker('\t');
        String[] strArray19 = new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" };
        CSVFormat.Builder builder20 = builder16.setHeader(strArray19);
        CSVException cSVException21 = new CSVException("\t", (Object[]) strArray19);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode2 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode2.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat3);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertNotNull(cSVFormat9);
        org.junit.Assert.assertNotNull(builder10);
        org.junit.Assert.assertNotNull(builder12);
        org.junit.Assert.assertNotNull(builder14);
        org.junit.Assert.assertNotNull(builder16);
        org.junit.Assert.assertNotNull(strArray19);
        org.junit.Assert.assertArrayEquals(strArray19, new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" });
        org.junit.Assert.assertNotNull(builder20);
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test175");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        CSVParser.Builder builder5 = CSVParser.builder();
        byte[] byteArray8 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder9 = builder5.setByteArray(byteArray8);
        CSVParser.Builder builder10 = builder4.setByteArray(byteArray8);
        java.io.Reader reader11 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser.Builder builder12 = builder4.setReader(reader11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(builder5);
        org.junit.Assert.assertNotNull(byteArray8);
        org.junit.Assert.assertArrayEquals(byteArray8, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder10);
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test176");
        java.io.Reader reader0 = null;
        CSVFormat cSVFormat1 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode2 = cSVFormat1.getDuplicateHeaderMode();
        CSVFormat cSVFormat3 = cSVFormat1.withAllowMissingColumnNames();
        CSVFormat cSVFormat5 = cSVFormat3.withRecordSeparator("");
        CSVFormat cSVFormat6 = cSVFormat3.withTrim();
        CSVFormat cSVFormat7 = cSVFormat3.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat9 = cSVFormat7.withRecordSeparator(' ');
        CSVFormat.Builder builder10 = CSVFormat.Builder.create(cSVFormat7);
        CSVFormat.Builder builder12 = builder10.setRecordSeparator('a');
        CSVFormat.Builder builder14 = builder12.setQuote((Character) ',');
        CSVFormat cSVFormat15 = builder12.get();
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser16 = new CSVParser(reader0, cSVFormat15);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: reader");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode2 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode2.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat3);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertNotNull(cSVFormat9);
        org.junit.Assert.assertNotNull(builder10);
        org.junit.Assert.assertNotNull(builder12);
        org.junit.Assert.assertNotNull(builder14);
        org.junit.Assert.assertNotNull(cSVFormat15);
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test177");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat6 = cSVFormat4.withEscape('4');
        CSVFormat cSVFormat7 = cSVFormat4.withIgnoreSurroundingSpaces();
        CSVFormat cSVFormat9 = cSVFormat7.withRecordSeparator('a');
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertNotNull(cSVFormat9);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test178");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat cSVFormat10 = cSVFormat6.withQuote('a');
        java.sql.ResultSetMetaData resultSetMetaData11 = null;
        CSVFormat cSVFormat12 = cSVFormat10.withHeader(resultSetMetaData11);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertNotNull(cSVFormat12);
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test179");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat2 = cSVFormat0.withSkipHeaderRecord(false);
        boolean boolean3 = cSVFormat2.getTrim();
        CSVFormat cSVFormat5 = cSVFormat2.withIgnoreHeaderCase(false);
        boolean boolean6 = cSVFormat2.getAllowMissingColumnNames();
        // The following exception was thrown during execution in test generation
        try {
            CSVFormat cSVFormat8 = cSVFormat2.withEscape((Character) '\t');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The escape character and the delimiter cannot be the same ('?')");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test180");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat.Builder builder13 = builder11.setEscape((Character) 'a');
        CSVFormat.Builder builder15 = builder11.setAutoFlush(false);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(builder15);
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test181");
        CSVParser.Builder builder0 = CSVParser.builder();
        CSVParser.Builder builder2 = builder0.setCharacterOffset((long) (short) 10);
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(builder2);
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test182");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        java.nio.file.OpenOption openOption5 = null;
        java.nio.file.OpenOption[] openOptionArray6 = new java.nio.file.OpenOption[] { openOption5 };
        CSVParser.Builder builder7 = builder0.setOpenOptions(openOptionArray6);
        CSVParser.Builder builder9 = builder0.setBufferSize((int) (byte) -1);
        java.io.Reader reader10 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser.Builder builder11 = builder9.setReader(reader10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(openOptionArray6);
        org.junit.Assert.assertArrayEquals(openOptionArray6, new java.nio.file.OpenOption[] { null });
        org.junit.Assert.assertNotNull(builder7);
        org.junit.Assert.assertNotNull(builder9);
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test183");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat2 = cSVFormat0.withSkipHeaderRecord(false);
        boolean boolean3 = cSVFormat2.getTrim();
        CSVFormat cSVFormat5 = cSVFormat2.withIgnoreHeaderCase(false);
        CSVFormat cSVFormat7 = cSVFormat5.withTrim(true);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat7);
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test184");
        CSVFormat cSVFormat0 = CSVFormat.MONGODB_TSV;
        CSVFormat cSVFormat2 = cSVFormat0.withEscape((Character) 'a');
        boolean boolean3 = cSVFormat0.getAllowMissingColumnNames();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test185");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        CSVParser.Builder builder6 = builder0.setTrackBytes(false);
        CSVParser.Builder builder8 = builder6.setCharSequence((CharSequence) "hi!");
        CSVParser.Builder builder10 = builder8.setBufferSize((int) (byte) 10);
        CSVParser.Builder builder12 = builder8.setCharacterOffset((long) ' ');
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser13 = builder8.get();
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.csv.CSVParser$Builder.getReader()Ljava/io/Reader;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(builder6);
        org.junit.Assert.assertNotNull(builder8);
        org.junit.Assert.assertNotNull(builder10);
        org.junit.Assert.assertNotNull(builder12);
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test186");
        java.io.InputStream inputStream0 = null;
        CSVParser.Builder builder1 = CSVParser.builder();
        byte[] byteArray4 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder5 = builder1.setByteArray(byteArray4);
        CSVParser.Builder builder6 = CSVParser.builder();
        byte[] byteArray9 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder10 = builder6.setByteArray(byteArray9);
        CSVParser.Builder builder11 = builder5.setByteArray(byteArray9);
        CSVParser.Builder builder13 = builder5.setFile("hi!");
        java.nio.charset.Charset charset14 = builder5.getCharset();
        CSVFormat cSVFormat15 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode16 = cSVFormat15.getDuplicateHeaderMode();
        CSVFormat cSVFormat17 = cSVFormat15.withAllowMissingColumnNames();
        CSVFormat cSVFormat19 = cSVFormat17.withRecordSeparator("");
        CSVFormat cSVFormat20 = cSVFormat17.withTrim();
        CSVFormat cSVFormat21 = cSVFormat17.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat23 = cSVFormat21.withRecordSeparator(' ');
        CSVFormat.Builder builder24 = CSVFormat.Builder.create(cSVFormat21);
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser25 = CSVParser.parse(inputStream0, charset14, cSVFormat21);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: inputStream");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder1);
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertArrayEquals(byteArray4, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder5);
        org.junit.Assert.assertNotNull(builder6);
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertArrayEquals(byteArray9, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder10);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(charset14);
        org.junit.Assert.assertNotNull(cSVFormat15);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode16 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode16.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat17);
        org.junit.Assert.assertNotNull(cSVFormat19);
        org.junit.Assert.assertNotNull(cSVFormat20);
        org.junit.Assert.assertNotNull(cSVFormat21);
        org.junit.Assert.assertNotNull(cSVFormat23);
        org.junit.Assert.assertNotNull(builder24);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test187");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        Character char2 = cSVFormat1.getCommentMarker();
        CSVFormat cSVFormat4 = cSVFormat1.withDelimiter('4');
        CSVFormat cSVFormat6 = cSVFormat1.withRecordSeparator("hi!");
        // The following exception was thrown during execution in test generation
        try {
            CSVFormat cSVFormat8 = cSVFormat6.withCommentMarker('\\');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The comment start and the escape character cannot be the same ('\\')");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNull(char2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat6);
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test188");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        CSVParser.Builder builder6 = builder0.setTrackBytes(false);
        CSVParser.Builder builder8 = builder0.setPath("\\N\tDelimiter=<\\\t> Escape=<\\\\> QuoteMode=<NONE> NullString=<\\\\N> RecordSeparator=<\\n> SkipHeaderRecord:false");
        CSVParser.Builder builder10 = builder8.setPath("hi!");
        java.io.File file11 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser.Builder builder12 = builder8.setFile(file11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(builder6);
        org.junit.Assert.assertNotNull(builder8);
        org.junit.Assert.assertNotNull(builder10);
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test189");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        CSVFormat cSVFormat4 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat5 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode6 = cSVFormat5.getDuplicateHeaderMode();
        CSVFormat cSVFormat8 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray9 = new Object[] { (short) 1, 0.0d, cSVFormat4, cSVFormat5, ' ', cSVFormat8 };
        CSVFormat cSVFormat10 = cSVFormat1.withHeaderComments(objArray9);
        boolean boolean11 = cSVFormat1.getTrailingData();
        CSVFormat cSVFormat12 = cSVFormat1.withAllowMissingColumnNames();
        CSVFormat cSVFormat14 = cSVFormat1.withRecordSeparator("");
        boolean boolean15 = cSVFormat1.getAutoFlush();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode6 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode6.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(objArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(cSVFormat12);
        org.junit.Assert.assertNotNull(cSVFormat14);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test190");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        CSVFormat cSVFormat4 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat5 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode6 = cSVFormat5.getDuplicateHeaderMode();
        CSVFormat cSVFormat8 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray9 = new Object[] { (short) 1, 0.0d, cSVFormat4, cSVFormat5, ' ', cSVFormat8 };
        CSVFormat cSVFormat10 = cSVFormat1.withHeaderComments(objArray9);
        boolean boolean11 = cSVFormat1.getTrailingData();
        CSVFormat cSVFormat12 = cSVFormat1.withAllowMissingColumnNames();
        CSVFormat cSVFormat14 = cSVFormat12.withRecordSeparator(',');
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode6 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode6.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(objArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(cSVFormat12);
        org.junit.Assert.assertNotNull(cSVFormat14);
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test191");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withCommentMarker((Character) '\"');
        CSVFormat cSVFormat9 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode10 = cSVFormat9.getDuplicateHeaderMode();
        CSVFormat cSVFormat11 = cSVFormat9.withAllowMissingColumnNames();
        CSVFormat cSVFormat13 = cSVFormat11.withRecordSeparator("");
        CSVFormat cSVFormat14 = cSVFormat11.withTrim();
        CSVFormat cSVFormat15 = cSVFormat11.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat16 = cSVFormat11.withAllowDuplicateHeaderNames();
        CSVPrinter cSVPrinter17 = cSVFormat11.printer();
        java.sql.ResultSet resultSet18 = null;
        cSVPrinter17.printHeaders(resultSet18);
        cSVPrinter17.printComment("hi!");
        CSVFormat cSVFormat22 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode23 = cSVFormat22.getDuplicateHeaderMode();
        CSVFormat cSVFormat24 = cSVFormat22.withAllowMissingColumnNames();
        CSVFormat cSVFormat26 = cSVFormat24.withRecordSeparator("");
        CSVFormat cSVFormat27 = cSVFormat24.withTrim();
        CSVFormat cSVFormat28 = cSVFormat24.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat30 = cSVFormat28.withRecordSeparator(' ');
        CSVFormat.Builder builder31 = CSVFormat.Builder.create(cSVFormat28);
        CSVFormat.Builder builder33 = builder31.setRecordSeparator('a');
        CSVFormat.Builder builder35 = builder31.setSkipHeaderRecord(false);
        CSVFormat.Builder builder37 = builder31.setCommentMarker('\t');
        String[] strArray40 = new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" };
        CSVFormat.Builder builder41 = builder37.setHeader(strArray40);
        cSVPrinter17.printRecords((Object[]) strArray40);
        Appendable appendable43 = cSVPrinter17.getOut();
        CSVFormat cSVFormat44 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode45 = cSVFormat44.getDuplicateHeaderMode();
        CSVFormat cSVFormat46 = cSVFormat44.withAllowMissingColumnNames();
        CSVFormat cSVFormat48 = cSVFormat46.withRecordSeparator("");
        CSVFormat cSVFormat49 = cSVFormat46.withTrim();
        CSVFormat cSVFormat50 = cSVFormat46.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat51 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat52 = cSVFormat51.withSystemRecordSeparator();
        CSVFormat cSVFormat55 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat56 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode57 = cSVFormat56.getDuplicateHeaderMode();
        CSVFormat cSVFormat59 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray60 = new Object[] { (short) 1, 0.0d, cSVFormat55, cSVFormat56, ' ', cSVFormat59 };
        CSVFormat cSVFormat61 = cSVFormat52.withHeaderComments(objArray60);
        String[] strArray67 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat68 = cSVFormat52.withHeader(strArray67);
        CSVFormat cSVFormat69 = cSVFormat46.withHeaderComments((Object[]) strArray67);
        cSVFormat8.printRecord(appendable43, (Object[]) strArray67);
        java.io.File file71 = null;
        CSVParser.Builder builder72 = CSVParser.builder();
        byte[] byteArray75 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder76 = builder72.setByteArray(byteArray75);
        CSVParser.Builder builder77 = CSVParser.builder();
        byte[] byteArray80 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder81 = builder77.setByteArray(byteArray80);
        CSVParser.Builder builder82 = builder76.setByteArray(byteArray80);
        CSVParser.Builder builder84 = builder76.setFile("hi!");
        java.nio.charset.Charset charset85 = builder76.getCharset();
        // The following exception was thrown during execution in test generation
        try {
            CSVPrinter cSVPrinter86 = cSVFormat8.print(file71, charset85);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(cSVFormat9);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode10 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode10.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat11);
        org.junit.Assert.assertNotNull(cSVFormat13);
        org.junit.Assert.assertNotNull(cSVFormat14);
        org.junit.Assert.assertNotNull(cSVFormat15);
        org.junit.Assert.assertNotNull(cSVFormat16);
        org.junit.Assert.assertNotNull(cSVPrinter17);
        org.junit.Assert.assertNotNull(cSVFormat22);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode23 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode23.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat24);
        org.junit.Assert.assertNotNull(cSVFormat26);
        org.junit.Assert.assertNotNull(cSVFormat27);
        org.junit.Assert.assertNotNull(cSVFormat28);
        org.junit.Assert.assertNotNull(cSVFormat30);
        org.junit.Assert.assertNotNull(builder31);
        org.junit.Assert.assertNotNull(builder33);
        org.junit.Assert.assertNotNull(builder35);
        org.junit.Assert.assertNotNull(builder37);
        org.junit.Assert.assertNotNull(strArray40);
        org.junit.Assert.assertArrayEquals(strArray40, new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" });
        org.junit.Assert.assertNotNull(builder41);
        org.junit.Assert.assertNotNull(appendable43);
        org.junit.Assert.assertNotNull(cSVFormat44);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode45 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode45.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat46);
        org.junit.Assert.assertNotNull(cSVFormat48);
        org.junit.Assert.assertNotNull(cSVFormat49);
        org.junit.Assert.assertNotNull(cSVFormat50);
        org.junit.Assert.assertNotNull(cSVFormat51);
        org.junit.Assert.assertNotNull(cSVFormat52);
        org.junit.Assert.assertNotNull(cSVFormat55);
        org.junit.Assert.assertNotNull(cSVFormat56);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode57 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode57.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat59);
        org.junit.Assert.assertNotNull(objArray60);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray60), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray60), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat61);
        org.junit.Assert.assertNotNull(strArray67);
        org.junit.Assert.assertArrayEquals(strArray67, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat68);
        org.junit.Assert.assertNotNull(cSVFormat69);
        org.junit.Assert.assertNotNull(builder72);
        org.junit.Assert.assertNotNull(byteArray75);
        org.junit.Assert.assertArrayEquals(byteArray75, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder76);
        org.junit.Assert.assertNotNull(builder77);
        org.junit.Assert.assertNotNull(byteArray80);
        org.junit.Assert.assertArrayEquals(byteArray80, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder81);
        org.junit.Assert.assertNotNull(builder82);
        org.junit.Assert.assertNotNull(builder84);
        org.junit.Assert.assertNotNull(charset85);
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test192");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat3 = cSVFormat2.withSkipHeaderRecord();
        CSVFormat cSVFormat5 = cSVFormat3.withTrim(false);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat3);
        org.junit.Assert.assertNotNull(cSVFormat5);
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test193");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        CSVParser.Builder builder6 = builder0.setTrackBytes(false);
        CSVParser.Builder builder8 = builder6.setCharSequence((CharSequence) "hi!");
        java.io.OutputStream outputStream9 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser.Builder builder10 = builder6.setOutputStream(outputStream9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(builder6);
        org.junit.Assert.assertNotNull(builder8);
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test194");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        java.nio.file.OpenOption openOption5 = null;
        java.nio.file.OpenOption[] openOptionArray6 = new java.nio.file.OpenOption[] { openOption5 };
        CSVParser.Builder builder7 = builder0.setOpenOptions(openOptionArray6);
        java.io.Reader reader8 = null;
        // The following exception was thrown during execution in test generation
        try {
            CSVParser.Builder builder9 = builder0.setReader(reader8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: origin");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(openOptionArray6);
        org.junit.Assert.assertArrayEquals(openOptionArray6, new java.nio.file.OpenOption[] { null });
        org.junit.Assert.assertNotNull(builder7);
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test195");
        CSVFormat.Predefined predefined0 = CSVFormat.Predefined.PostgreSQLCsv;
        CSVFormat cSVFormat1 = predefined0.getFormat();
        boolean boolean2 = cSVFormat1.getIgnoreEmptyLines();
        // The following exception was thrown during execution in test generation
        try {
            CSVFormat cSVFormat4 = cSVFormat1.withEscape((Character) ',');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The escape character and the delimiter cannot be the same (',')");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + predefined0 + "' != '" + CSVFormat.Predefined.PostgreSQLCsv + "'", predefined0.equals(CSVFormat.Predefined.PostgreSQLCsv));
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test196");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat7 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVPrinter cSVPrinter8 = cSVFormat2.printer();
        java.sql.ResultSet resultSet9 = null;
        cSVPrinter8.printHeaders(resultSet9);
        cSVPrinter8.println();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertNotNull(cSVPrinter8);
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test197");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        String str6 = cSVFormat5.toString();
        boolean boolean7 = cSVFormat5.getIgnoreEmptyLines();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false" + "'", str6, "Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false");
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test198");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        java.nio.file.OpenOption openOption5 = null;
        java.nio.file.OpenOption[] openOptionArray6 = new java.nio.file.OpenOption[] { openOption5 };
        CSVParser.Builder builder7 = builder0.setOpenOptions(openOptionArray6);
        CSVParser.Builder builder9 = builder0.setRecordNumber((long) (byte) 0);
        // The following exception was thrown during execution in test generation
        try {
            CSVParser cSVParser10 = builder0.get();
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodError; message: org.apache.commons.csv.CSVParser$Builder.getReader()Ljava/io/Reader;");
        } catch (NoSuchMethodError e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(openOptionArray6);
        org.junit.Assert.assertArrayEquals(openOptionArray6, new java.nio.file.OpenOption[] { null });
        org.junit.Assert.assertNotNull(builder7);
        org.junit.Assert.assertNotNull(builder9);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test199");
        CSVFormat cSVFormat0 = CSVFormat.INFORMIX_UNLOAD_CSV;
        CSVFormat cSVFormat1 = cSVFormat0.withFirstRecordAsHeader();
        boolean boolean2 = cSVFormat0.isQuoteCharacterSet();
        CSVFormat cSVFormat3 = cSVFormat0.withSystemRecordSeparator();
        boolean boolean4 = cSVFormat3.isCommentMarkerSet();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cSVFormat3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test200");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat.Builder builder13 = builder9.setDelimiter('#');
        java.sql.ResultSetMetaData resultSetMetaData14 = null;
        CSVFormat.Builder builder15 = builder9.setHeader(resultSetMetaData14);
        java.sql.ResultSetMetaData resultSetMetaData16 = null;
        CSVFormat.Builder builder17 = builder9.setHeader(resultSetMetaData16);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(builder15);
        org.junit.Assert.assertNotNull(builder17);
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test201");
        CSVFormat cSVFormat0 = CSVFormat.MONGODB_CSV;
        CSVFormat cSVFormat2 = cSVFormat0.withNullString("\t");
        CSVFormat cSVFormat4 = cSVFormat2.withDelimiter('a');
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test202");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat.Builder builder13 = builder9.setDelimiter('#');
        java.sql.ResultSetMetaData resultSetMetaData14 = null;
        CSVFormat.Builder builder15 = builder9.setHeader(resultSetMetaData14);
        CSVFormat cSVFormat16 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat18 = cSVFormat16.withRecordSeparator('a');
        QuoteMode quoteMode19 = cSVFormat16.getQuoteMode();
        CSVFormat.Builder builder20 = builder15.setQuoteMode(quoteMode19);
        java.sql.ResultSet resultSet21 = null;
        CSVFormat.Builder builder22 = builder20.setHeader(resultSet21);
        DuplicateHeaderMode duplicateHeaderMode23 = DuplicateHeaderMode.DISALLOW;
        CSVFormat.Builder builder24 = builder22.setDuplicateHeaderMode(duplicateHeaderMode23);
        CSVFormat.Builder builder26 = builder24.setIgnoreHeaderCase(true);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(builder15);
        org.junit.Assert.assertNotNull(cSVFormat16);
        org.junit.Assert.assertNotNull(cSVFormat18);
        org.junit.Assert.assertTrue("'" + quoteMode19 + "' != '" + QuoteMode.ALL_NON_NULL + "'", quoteMode19.equals(QuoteMode.ALL_NON_NULL));
        org.junit.Assert.assertNotNull(builder20);
        org.junit.Assert.assertNotNull(builder22);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode23 + "' != '" + DuplicateHeaderMode.DISALLOW + "'", duplicateHeaderMode23.equals(DuplicateHeaderMode.DISALLOW));
        org.junit.Assert.assertNotNull(builder24);
        org.junit.Assert.assertNotNull(builder26);
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test203");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat6 = cSVFormat4.withEscape('4');
        boolean boolean7 = cSVFormat4.isEscapeCharacterSet();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test204");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        java.sql.ResultSetMetaData resultSetMetaData3 = null;
        CSVFormat cSVFormat4 = cSVFormat2.withHeader(resultSetMetaData3);
        boolean boolean5 = cSVFormat2.getTrailingData();
        boolean boolean6 = cSVFormat2.getAutoFlush();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test205");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat.Builder builder13 = builder9.setDelimiter('#');
        CSVFormat.Builder builder15 = builder13.setAllowDuplicateHeaderNames(true);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(builder15);
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test206");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat.Builder builder13 = builder9.setDelimiter('#');
        java.sql.ResultSetMetaData resultSetMetaData14 = null;
        CSVFormat.Builder builder15 = builder9.setHeader(resultSetMetaData14);
        CSVFormat.Builder builder17 = builder9.setTrailingData(true);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(builder15);
        org.junit.Assert.assertNotNull(builder17);
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test207");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        CSVFormat cSVFormat4 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat5 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode6 = cSVFormat5.getDuplicateHeaderMode();
        CSVFormat cSVFormat8 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray9 = new Object[] { (short) 1, 0.0d, cSVFormat4, cSVFormat5, ' ', cSVFormat8 };
        CSVFormat cSVFormat10 = cSVFormat1.withHeaderComments(objArray9);
        CSVFormat.Builder builder11 = cSVFormat10.builder();
        CSVFormat.Builder builder13 = builder11.setCommentMarker((Character) 'a');
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode6 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode6.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(objArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test208");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        boolean boolean2 = cSVFormat0.getIgnoreSurroundingSpaces();
        QuoteMode quoteMode3 = QuoteMode.ALL_NON_NULL;
        CSVFormat cSVFormat4 = cSVFormat0.withQuoteMode(quoteMode3);
        CSVFormat cSVFormat6 = cSVFormat4.withQuote('#');
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + quoteMode3 + "' != '" + QuoteMode.ALL_NON_NULL + "'", quoteMode3.equals(QuoteMode.ALL_NON_NULL));
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat6);
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test209");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat7 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVPrinter cSVPrinter8 = cSVFormat2.printer();
        java.sql.ResultSet resultSet9 = null;
        cSVPrinter8.printHeaders(resultSet9);
        cSVPrinter8.printComment("hi!");
        CSVFormat cSVFormat13 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode14 = cSVFormat13.getDuplicateHeaderMode();
        CSVFormat cSVFormat15 = cSVFormat13.withAllowMissingColumnNames();
        CSVFormat cSVFormat17 = cSVFormat15.withRecordSeparator("");
        CSVFormat cSVFormat18 = cSVFormat15.withTrim();
        CSVFormat cSVFormat19 = cSVFormat15.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat21 = cSVFormat19.withRecordSeparator(' ');
        CSVFormat.Builder builder22 = CSVFormat.Builder.create(cSVFormat19);
        CSVFormat.Builder builder24 = builder22.setRecordSeparator('a');
        CSVFormat.Builder builder26 = builder22.setSkipHeaderRecord(false);
        CSVFormat.Builder builder28 = builder22.setCommentMarker('\t');
        String[] strArray31 = new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" };
        CSVFormat.Builder builder32 = builder28.setHeader(strArray31);
        cSVPrinter8.printRecords((Object[]) strArray31);
        CSVFormat cSVFormat35 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode36 = cSVFormat35.getDuplicateHeaderMode();
        CSVFormat cSVFormat37 = cSVFormat35.withAllowMissingColumnNames();
        CSVFormat cSVFormat39 = cSVFormat37.withRecordSeparator("");
        CSVFormat cSVFormat40 = cSVFormat37.withTrim();
        CSVFormat cSVFormat41 = cSVFormat37.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat42 = cSVFormat37.withAllowDuplicateHeaderNames();
        CSVPrinter cSVPrinter43 = cSVFormat37.printer();
        java.sql.ResultSet resultSet44 = null;
        cSVPrinter43.printHeaders(resultSet44);
        cSVPrinter43.printComment("hi!");
        CSVFormat cSVFormat48 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode49 = cSVFormat48.getDuplicateHeaderMode();
        CSVFormat cSVFormat50 = cSVFormat48.withAllowMissingColumnNames();
        CSVFormat cSVFormat52 = cSVFormat50.withRecordSeparator("");
        CSVFormat cSVFormat53 = cSVFormat50.withTrim();
        CSVFormat cSVFormat54 = cSVFormat50.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat56 = cSVFormat54.withRecordSeparator(' ');
        CSVFormat.Builder builder57 = CSVFormat.Builder.create(cSVFormat54);
        CSVFormat.Builder builder59 = builder57.setRecordSeparator('a');
        CSVFormat.Builder builder61 = builder57.setSkipHeaderRecord(false);
        CSVFormat.Builder builder63 = builder57.setCommentMarker('\t');
        String[] strArray66 = new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" };
        CSVFormat.Builder builder67 = builder63.setHeader(strArray66);
        cSVPrinter43.printRecords((Object[]) strArray66);
        CSVException cSVException69 = new CSVException("hi!", (Object[]) strArray66);
        cSVPrinter8.printRecord((Object[]) strArray66);
        cSVPrinter8.flush();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertNotNull(cSVPrinter8);
        org.junit.Assert.assertNotNull(cSVFormat13);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode14 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode14.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat15);
        org.junit.Assert.assertNotNull(cSVFormat17);
        org.junit.Assert.assertNotNull(cSVFormat18);
        org.junit.Assert.assertNotNull(cSVFormat19);
        org.junit.Assert.assertNotNull(cSVFormat21);
        org.junit.Assert.assertNotNull(builder22);
        org.junit.Assert.assertNotNull(builder24);
        org.junit.Assert.assertNotNull(builder26);
        org.junit.Assert.assertNotNull(builder28);
        org.junit.Assert.assertNotNull(strArray31);
        org.junit.Assert.assertArrayEquals(strArray31, new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" });
        org.junit.Assert.assertNotNull(builder32);
        org.junit.Assert.assertNotNull(cSVFormat35);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode36 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode36.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat37);
        org.junit.Assert.assertNotNull(cSVFormat39);
        org.junit.Assert.assertNotNull(cSVFormat40);
        org.junit.Assert.assertNotNull(cSVFormat41);
        org.junit.Assert.assertNotNull(cSVFormat42);
        org.junit.Assert.assertNotNull(cSVPrinter43);
        org.junit.Assert.assertNotNull(cSVFormat48);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode49 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode49.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat50);
        org.junit.Assert.assertNotNull(cSVFormat52);
        org.junit.Assert.assertNotNull(cSVFormat53);
        org.junit.Assert.assertNotNull(cSVFormat54);
        org.junit.Assert.assertNotNull(cSVFormat56);
        org.junit.Assert.assertNotNull(builder57);
        org.junit.Assert.assertNotNull(builder59);
        org.junit.Assert.assertNotNull(builder61);
        org.junit.Assert.assertNotNull(builder63);
        org.junit.Assert.assertNotNull(strArray66);
        org.junit.Assert.assertArrayEquals(strArray66, new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" });
        org.junit.Assert.assertNotNull(builder67);
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test210");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat3 = cSVFormat2.withSkipHeaderRecord();
        CSVFormat cSVFormat5 = cSVFormat3.withQuote('a');
        boolean boolean6 = cSVFormat5.getIgnoreSurroundingSpaces();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat3);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test211");
        CSVParser.Builder builder0 = CSVParser.builder();
        byte[] byteArray3 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder4 = builder0.setByteArray(byteArray3);
        CSVParser.Builder builder5 = CSVParser.builder();
        byte[] byteArray8 = new byte[] { (byte) 100, (byte) 10 };
        CSVParser.Builder builder9 = builder5.setByteArray(byteArray8);
        CSVParser.Builder builder10 = builder4.setByteArray(byteArray8);
        CSVParser.Builder builder12 = builder4.setFile("hi!");
        CSVParser.Builder builder14 = builder4.setCharacterOffset((long) (-1));
        org.junit.Assert.assertNotNull(builder0);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertArrayEquals(byteArray3, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder4);
        org.junit.Assert.assertNotNull(builder5);
        org.junit.Assert.assertNotNull(byteArray8);
        org.junit.Assert.assertArrayEquals(byteArray8, new byte[] { (byte) 100, (byte) 10 });
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder10);
        org.junit.Assert.assertNotNull(builder12);
        org.junit.Assert.assertNotNull(builder14);
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test212");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        CSVFormat cSVFormat4 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat5 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode6 = cSVFormat5.getDuplicateHeaderMode();
        CSVFormat cSVFormat8 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray9 = new Object[] { (short) 1, 0.0d, cSVFormat4, cSVFormat5, ' ', cSVFormat8 };
        CSVFormat cSVFormat10 = cSVFormat1.withHeaderComments(objArray9);
        boolean boolean11 = cSVFormat1.getTrailingData();
        CSVFormat cSVFormat12 = cSVFormat1.withAllowMissingColumnNames();
        CSVFormat cSVFormat13 = cSVFormat12.withAllowDuplicateHeaderNames();
        CSVPrinter cSVPrinter14 = cSVFormat13.printer();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode6 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode6.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(objArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(cSVFormat12);
        org.junit.Assert.assertNotNull(cSVFormat13);
        org.junit.Assert.assertNotNull(cSVPrinter14);
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test213");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat cSVFormat12 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode13 = cSVFormat12.getDuplicateHeaderMode();
        CSVFormat cSVFormat14 = cSVFormat12.withAllowMissingColumnNames();
        CSVFormat cSVFormat16 = cSVFormat14.withRecordSeparator("");
        CSVFormat cSVFormat17 = cSVFormat14.withTrim();
        CSVFormat cSVFormat18 = cSVFormat14.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat19 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat20 = cSVFormat19.withSystemRecordSeparator();
        CSVFormat cSVFormat23 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat24 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode25 = cSVFormat24.getDuplicateHeaderMode();
        CSVFormat cSVFormat27 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray28 = new Object[] { (short) 1, 0.0d, cSVFormat23, cSVFormat24, ' ', cSVFormat27 };
        CSVFormat cSVFormat29 = cSVFormat20.withHeaderComments(objArray28);
        String[] strArray35 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat36 = cSVFormat20.withHeader(strArray35);
        CSVFormat cSVFormat37 = cSVFormat14.withHeaderComments((Object[]) strArray35);
        CSVFormat.Builder builder38 = builder11.setHeaderComments((Object[]) strArray35);
        CSVFormat.Builder builder40 = builder11.setAllowDuplicateHeaderNames(false);
        CSVFormat cSVFormat41 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode42 = cSVFormat41.getDuplicateHeaderMode();
        CSVFormat cSVFormat43 = cSVFormat41.withAllowMissingColumnNames();
        CSVFormat cSVFormat45 = cSVFormat43.withRecordSeparator("");
        CSVFormat cSVFormat46 = cSVFormat43.withTrim();
        CSVFormat cSVFormat47 = cSVFormat43.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat49 = cSVFormat47.withRecordSeparator(' ');
        CSVFormat.Builder builder50 = CSVFormat.Builder.create(cSVFormat47);
        CSVFormat.Builder builder52 = builder50.setRecordSeparator('a');
        CSVFormat cSVFormat53 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode54 = cSVFormat53.getDuplicateHeaderMode();
        CSVFormat cSVFormat55 = cSVFormat53.withAllowMissingColumnNames();
        CSVFormat cSVFormat57 = cSVFormat55.withRecordSeparator("");
        CSVFormat cSVFormat58 = cSVFormat55.withTrim();
        CSVFormat cSVFormat59 = cSVFormat55.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat60 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat61 = cSVFormat60.withSystemRecordSeparator();
        CSVFormat cSVFormat64 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat65 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode66 = cSVFormat65.getDuplicateHeaderMode();
        CSVFormat cSVFormat68 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray69 = new Object[] { (short) 1, 0.0d, cSVFormat64, cSVFormat65, ' ', cSVFormat68 };
        CSVFormat cSVFormat70 = cSVFormat61.withHeaderComments(objArray69);
        String[] strArray76 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat77 = cSVFormat61.withHeader(strArray76);
        CSVFormat cSVFormat78 = cSVFormat55.withHeaderComments((Object[]) strArray76);
        CSVFormat.Builder builder79 = builder52.setHeaderComments((Object[]) strArray76);
        CSVFormat.Builder builder80 = builder40.setHeaderComments((Object[]) strArray76);
        CSVFormat.Builder builder82 = builder40.setQuote((Character) ',');
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(cSVFormat12);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode13 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode13.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat14);
        org.junit.Assert.assertNotNull(cSVFormat16);
        org.junit.Assert.assertNotNull(cSVFormat17);
        org.junit.Assert.assertNotNull(cSVFormat18);
        org.junit.Assert.assertNotNull(cSVFormat19);
        org.junit.Assert.assertNotNull(cSVFormat20);
        org.junit.Assert.assertNotNull(cSVFormat23);
        org.junit.Assert.assertNotNull(cSVFormat24);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode25 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode25.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat27);
        org.junit.Assert.assertNotNull(objArray28);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray28), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray28), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat29);
        org.junit.Assert.assertNotNull(strArray35);
        org.junit.Assert.assertArrayEquals(strArray35, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat36);
        org.junit.Assert.assertNotNull(cSVFormat37);
        org.junit.Assert.assertNotNull(builder38);
        org.junit.Assert.assertNotNull(builder40);
        org.junit.Assert.assertNotNull(cSVFormat41);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode42 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode42.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat43);
        org.junit.Assert.assertNotNull(cSVFormat45);
        org.junit.Assert.assertNotNull(cSVFormat46);
        org.junit.Assert.assertNotNull(cSVFormat47);
        org.junit.Assert.assertNotNull(cSVFormat49);
        org.junit.Assert.assertNotNull(builder50);
        org.junit.Assert.assertNotNull(builder52);
        org.junit.Assert.assertNotNull(cSVFormat53);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode54 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode54.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat55);
        org.junit.Assert.assertNotNull(cSVFormat57);
        org.junit.Assert.assertNotNull(cSVFormat58);
        org.junit.Assert.assertNotNull(cSVFormat59);
        org.junit.Assert.assertNotNull(cSVFormat60);
        org.junit.Assert.assertNotNull(cSVFormat61);
        org.junit.Assert.assertNotNull(cSVFormat64);
        org.junit.Assert.assertNotNull(cSVFormat65);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode66 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode66.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat68);
        org.junit.Assert.assertNotNull(objArray69);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray69), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray69), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat70);
        org.junit.Assert.assertNotNull(strArray76);
        org.junit.Assert.assertArrayEquals(strArray76, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat77);
        org.junit.Assert.assertNotNull(cSVFormat78);
        org.junit.Assert.assertNotNull(builder79);
        org.junit.Assert.assertNotNull(builder80);
        org.junit.Assert.assertNotNull(builder82);
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test214");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        CSVFormat cSVFormat4 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat5 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode6 = cSVFormat5.getDuplicateHeaderMode();
        CSVFormat cSVFormat8 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray9 = new Object[] { (short) 1, 0.0d, cSVFormat4, cSVFormat5, ' ', cSVFormat8 };
        CSVFormat cSVFormat10 = cSVFormat1.withHeaderComments(objArray9);
        boolean boolean11 = cSVFormat1.getTrailingData();
        CSVFormat cSVFormat12 = cSVFormat1.withAllowMissingColumnNames();
        CSVFormat cSVFormat14 = cSVFormat1.withRecordSeparator("");
        CSVFormat cSVFormat16 = cSVFormat1.withQuote((Character) '\\');
        CSVFormat cSVFormat17 = cSVFormat1.withFirstRecordAsHeader();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode6 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode6.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(objArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(cSVFormat12);
        org.junit.Assert.assertNotNull(cSVFormat14);
        org.junit.Assert.assertNotNull(cSVFormat16);
        org.junit.Assert.assertNotNull(cSVFormat17);
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test215");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat.Builder builder13 = builder9.setSkipHeaderRecord(false);
        CSVFormat.Builder builder15 = builder9.setCommentMarker('\t');
        CSVFormat.Builder builder17 = builder9.setCommentMarker((Character) ',');
        java.sql.ResultSet resultSet18 = null;
        CSVFormat.Builder builder19 = builder9.setHeader(resultSet18);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(builder15);
        org.junit.Assert.assertNotNull(builder17);
        org.junit.Assert.assertNotNull(builder19);
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test216");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat7 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat8 = cSVFormat7.withSystemRecordSeparator();
        CSVFormat cSVFormat11 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat12 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode13 = cSVFormat12.getDuplicateHeaderMode();
        CSVFormat cSVFormat15 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray16 = new Object[] { (short) 1, 0.0d, cSVFormat11, cSVFormat12, ' ', cSVFormat15 };
        CSVFormat cSVFormat17 = cSVFormat8.withHeaderComments(objArray16);
        String[] strArray23 = new String[] { "", "", "hi!", ",", "," };
        CSVFormat cSVFormat24 = cSVFormat8.withHeader(strArray23);
        CSVFormat cSVFormat25 = cSVFormat2.withHeaderComments((Object[]) strArray23);
        CSVFormat cSVFormat26 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat27 = cSVFormat26.withSystemRecordSeparator();
        CSVFormat cSVFormat30 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat31 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode32 = cSVFormat31.getDuplicateHeaderMode();
        CSVFormat cSVFormat34 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray35 = new Object[] { (short) 1, 0.0d, cSVFormat30, cSVFormat31, ' ', cSVFormat34 };
        CSVFormat cSVFormat36 = cSVFormat27.withHeaderComments(objArray35);
        CSVFormat.Builder builder37 = cSVFormat36.builder();
        CSVFormat.Builder builder39 = builder37.setEscape('\\');
        CSVFormat.Builder builder41 = builder39.setIgnoreHeaderCase(false);
        CSVFormat cSVFormat42 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode43 = cSVFormat42.getDuplicateHeaderMode();
        CSVFormat cSVFormat44 = cSVFormat42.withAllowMissingColumnNames();
        CSVFormat cSVFormat46 = cSVFormat44.withRecordSeparator("");
        CSVFormat cSVFormat47 = cSVFormat44.withTrim();
        CSVFormat cSVFormat48 = cSVFormat44.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat49 = cSVFormat44.withTrailingDelimiter();
        CSVFormat cSVFormat50 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode51 = cSVFormat50.getDuplicateHeaderMode();
        CSVFormat cSVFormat52 = cSVFormat50.withAllowMissingColumnNames();
        CSVFormat cSVFormat54 = cSVFormat52.withRecordSeparator("");
        CSVFormat cSVFormat55 = cSVFormat52.withTrim();
        CSVFormat cSVFormat56 = cSVFormat52.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat57 = cSVFormat52.withAllowDuplicateHeaderNames();
        CSVPrinter cSVPrinter58 = cSVFormat52.printer();
        java.sql.ResultSet resultSet59 = null;
        cSVPrinter58.printHeaders(resultSet59);
        cSVPrinter58.printComment("hi!");
        CSVFormat cSVFormat63 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode64 = cSVFormat63.getDuplicateHeaderMode();
        CSVFormat cSVFormat65 = cSVFormat63.withAllowMissingColumnNames();
        CSVFormat cSVFormat67 = cSVFormat65.withRecordSeparator("");
        CSVFormat cSVFormat68 = cSVFormat65.withTrim();
        CSVFormat cSVFormat69 = cSVFormat65.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat71 = cSVFormat69.withRecordSeparator(' ');
        CSVFormat.Builder builder72 = CSVFormat.Builder.create(cSVFormat69);
        CSVFormat.Builder builder74 = builder72.setRecordSeparator('a');
        CSVFormat.Builder builder76 = builder72.setSkipHeaderRecord(false);
        CSVFormat.Builder builder78 = builder72.setCommentMarker('\t');
        String[] strArray81 = new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" };
        CSVFormat.Builder builder82 = builder78.setHeader(strArray81);
        cSVPrinter58.printRecords((Object[]) strArray81);
        Appendable appendable84 = cSVPrinter58.getOut();
        cSVFormat49.println(appendable84);
        cSVFormat25.print((Object) false, appendable84, true);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(cSVFormat11);
        org.junit.Assert.assertNotNull(cSVFormat12);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode13 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode13.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat15);
        org.junit.Assert.assertNotNull(objArray16);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray16), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray16), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat17);
        org.junit.Assert.assertNotNull(strArray23);
        org.junit.Assert.assertArrayEquals(strArray23, new String[] { "", "", "hi!", ",", "," });
        org.junit.Assert.assertNotNull(cSVFormat24);
        org.junit.Assert.assertNotNull(cSVFormat25);
        org.junit.Assert.assertNotNull(cSVFormat26);
        org.junit.Assert.assertNotNull(cSVFormat27);
        org.junit.Assert.assertNotNull(cSVFormat30);
        org.junit.Assert.assertNotNull(cSVFormat31);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode32 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode32.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat34);
        org.junit.Assert.assertNotNull(objArray35);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray35), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray35), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat36);
        org.junit.Assert.assertNotNull(builder37);
        org.junit.Assert.assertNotNull(builder39);
        org.junit.Assert.assertNotNull(builder41);
        org.junit.Assert.assertNotNull(cSVFormat42);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode43 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode43.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat44);
        org.junit.Assert.assertNotNull(cSVFormat46);
        org.junit.Assert.assertNotNull(cSVFormat47);
        org.junit.Assert.assertNotNull(cSVFormat48);
        org.junit.Assert.assertNotNull(cSVFormat49);
        org.junit.Assert.assertNotNull(cSVFormat50);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode51 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode51.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat52);
        org.junit.Assert.assertNotNull(cSVFormat54);
        org.junit.Assert.assertNotNull(cSVFormat55);
        org.junit.Assert.assertNotNull(cSVFormat56);
        org.junit.Assert.assertNotNull(cSVFormat57);
        org.junit.Assert.assertNotNull(cSVPrinter58);
        org.junit.Assert.assertNotNull(cSVFormat63);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode64 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode64.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat65);
        org.junit.Assert.assertNotNull(cSVFormat67);
        org.junit.Assert.assertNotNull(cSVFormat68);
        org.junit.Assert.assertNotNull(cSVFormat69);
        org.junit.Assert.assertNotNull(cSVFormat71);
        org.junit.Assert.assertNotNull(builder72);
        org.junit.Assert.assertNotNull(builder74);
        org.junit.Assert.assertNotNull(builder76);
        org.junit.Assert.assertNotNull(builder78);
        org.junit.Assert.assertNotNull(strArray81);
        org.junit.Assert.assertArrayEquals(strArray81, new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" });
        org.junit.Assert.assertNotNull(builder82);
        org.junit.Assert.assertNotNull(appendable84);
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test217");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat1 = cSVFormat0.withSystemRecordSeparator();
        CSVFormat cSVFormat4 = CSVFormat.POSTGRESQL_TEXT;
        CSVFormat cSVFormat5 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode6 = cSVFormat5.getDuplicateHeaderMode();
        CSVFormat cSVFormat8 = CSVFormat.POSTGRESQL_TEXT;
        Object[] objArray9 = new Object[] { (short) 1, 0.0d, cSVFormat4, cSVFormat5, ' ', cSVFormat8 };
        CSVFormat cSVFormat10 = cSVFormat1.withHeaderComments(objArray9);
        boolean boolean11 = cSVFormat1.getTrailingData();
        CSVFormat cSVFormat12 = cSVFormat1.withAllowMissingColumnNames();
        boolean boolean13 = cSVFormat1.getAllowDuplicateHeaderNames();
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode6 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode6.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(objArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray9), "[1, 0.0, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false, Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false,  , Delimiter=<\t> Escape=<\\> QuoteMode=<ALL_NON_NULL> NullString=<\\N> RecordSeparator=<\n> SkipHeaderRecord:false]");
        org.junit.Assert.assertNotNull(cSVFormat10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(cSVFormat12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test218");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat8 = cSVFormat6.withRecordSeparator(' ');
        CSVFormat.Builder builder9 = CSVFormat.Builder.create(cSVFormat6);
        CSVFormat.Builder builder11 = builder9.setRecordSeparator('a');
        CSVFormat.Builder builder13 = builder11.setEscape((Character) 'a');
        CSVFormat.Builder builder15 = builder11.setQuote(' ');
        String[] strArray17 = new String[] { "hi!" };
        CSVFormat.Builder builder18 = builder15.setHeader(strArray17);
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat8);
        org.junit.Assert.assertNotNull(builder9);
        org.junit.Assert.assertNotNull(builder11);
        org.junit.Assert.assertNotNull(builder13);
        org.junit.Assert.assertNotNull(builder15);
        org.junit.Assert.assertNotNull(strArray17);
        org.junit.Assert.assertArrayEquals(strArray17, new String[] { "hi!" });
        org.junit.Assert.assertNotNull(builder18);
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test219");
        CSVFormat cSVFormat1 = CSVFormat.newFormat('a');
        Character char2 = cSVFormat1.getEscapeCharacter();
        org.junit.Assert.assertNotNull(cSVFormat1);
        org.junit.Assert.assertNull(char2);
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test220");
        CSVFormat cSVFormat0 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode1 = cSVFormat0.getDuplicateHeaderMode();
        CSVFormat cSVFormat2 = cSVFormat0.withAllowMissingColumnNames();
        CSVFormat cSVFormat4 = cSVFormat2.withRecordSeparator("");
        CSVFormat cSVFormat5 = cSVFormat2.withTrim();
        CSVFormat cSVFormat6 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat7 = cSVFormat2.withAllowDuplicateHeaderNames();
        CSVPrinter cSVPrinter8 = cSVFormat2.printer();
        java.sql.ResultSet resultSet9 = null;
        cSVPrinter8.printHeaders(resultSet9);
        cSVPrinter8.printComment("hi!");
        CSVFormat cSVFormat13 = CSVFormat.POSTGRESQL_TEXT;
        DuplicateHeaderMode duplicateHeaderMode14 = cSVFormat13.getDuplicateHeaderMode();
        CSVFormat cSVFormat15 = cSVFormat13.withAllowMissingColumnNames();
        CSVFormat cSVFormat17 = cSVFormat15.withRecordSeparator("");
        CSVFormat cSVFormat18 = cSVFormat15.withTrim();
        CSVFormat cSVFormat19 = cSVFormat15.withAllowDuplicateHeaderNames();
        CSVFormat cSVFormat21 = cSVFormat19.withRecordSeparator(' ');
        CSVFormat.Builder builder22 = CSVFormat.Builder.create(cSVFormat19);
        CSVFormat.Builder builder24 = builder22.setRecordSeparator('a');
        CSVFormat.Builder builder26 = builder22.setSkipHeaderRecord(false);
        CSVFormat.Builder builder28 = builder22.setCommentMarker('\t');
        String[] strArray31 = new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" };
        CSVFormat.Builder builder32 = builder28.setHeader(strArray31);
        cSVPrinter8.printRecords((Object[]) strArray31);
        Appendable appendable34 = cSVPrinter8.getOut();
        cSVPrinter8.printComment("Delimiter=<a> SkipHeaderRecord:false");
        org.junit.Assert.assertNotNull(cSVFormat0);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode1 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode1.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat2);
        org.junit.Assert.assertNotNull(cSVFormat4);
        org.junit.Assert.assertNotNull(cSVFormat5);
        org.junit.Assert.assertNotNull(cSVFormat6);
        org.junit.Assert.assertNotNull(cSVFormat7);
        org.junit.Assert.assertNotNull(cSVPrinter8);
        org.junit.Assert.assertNotNull(cSVFormat13);
        org.junit.Assert.assertTrue("'" + duplicateHeaderMode14 + "' != '" + DuplicateHeaderMode.ALLOW_ALL + "'", duplicateHeaderMode14.equals(DuplicateHeaderMode.ALLOW_ALL));
        org.junit.Assert.assertNotNull(cSVFormat15);
        org.junit.Assert.assertNotNull(cSVFormat17);
        org.junit.Assert.assertNotNull(cSVFormat18);
        org.junit.Assert.assertNotNull(cSVFormat19);
        org.junit.Assert.assertNotNull(cSVFormat21);
        org.junit.Assert.assertNotNull(builder22);
        org.junit.Assert.assertNotNull(builder24);
        org.junit.Assert.assertNotNull(builder26);
        org.junit.Assert.assertNotNull(builder28);
        org.junit.Assert.assertNotNull(strArray31);
        org.junit.Assert.assertArrayEquals(strArray31, new String[] { "hi!", "Delimiter=<|> Escape=<\\> QuoteChar=<\"> RecordSeparator=<\n> EmptyLines:ignored SkipHeaderRecord:false" });
        org.junit.Assert.assertNotNull(builder32);
        org.junit.Assert.assertNotNull(appendable34);
    }
}

