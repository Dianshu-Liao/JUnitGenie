package org.joda.time;

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
        org.joda.time.field.DividedDateTimeField dividedDateTimeField0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.joda.time.field.RemainderDateTimeField remainderDateTimeField1 = new org.joda.time.field.RemainderDateTimeField(dividedDateTimeField0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        double double1 = DateTimeUtils.toJulianDay((-1L));
        org.junit.Assert.assertTrue("'" + double1 + "' != '" + 2440587.4999999884d + "'", double1 == 2440587.4999999884d);
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        Chronology chronology0 = null;
        DateTimeField dateTimeField1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.joda.time.field.SkipDateTimeField skipDateTimeField3 = new org.joda.time.field.SkipDateTimeField(chronology0, dateTimeField1, (int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The field must not be null");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test004");
        ReadableInstant readableInstant0 = null;
        ReadableInstant readableInstant1 = null;
        // The following exception was thrown during execution in test generation
        try {
            Days days2 = Days.daysBetween(readableInstant0, readableInstant1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: ReadableInstant objects must not be null");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test005");
        int int0 = DateTimeConstants.JUNE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 6 + "'", int0 == 6);
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        DateTimeZone dateTimeZone0 = null;
        // The following exception was thrown during execution in test generation
        try {
            LocalDate localDate1 = LocalDate.now(dateTimeZone0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Zone must not be null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        int int0 = DateTimeConstants.OCTOBER;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 10 + "'", int0 == 10);
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        Chronology chronology2 = null;
        // The following exception was thrown during execution in test generation
        try {
            Interval interval3 = new Interval((long) (short) 10, 1L, chronology2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The end instant must be greater than the start instant");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        PeriodType periodType1 = PeriodType.seconds();
        Chronology chronology2 = null;
        // The following exception was thrown during execution in test generation
        try {
            Period period3 = new Period((Object) 2440587.4999999884d, periodType1, chronology2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: No period converter found for type: java.lang.Double");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(periodType1);
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        Chronology chronology0 = null;
        DateTimeField dateTimeField1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.joda.time.field.SkipDateTimeField skipDateTimeField3 = new org.joda.time.field.SkipDateTimeField(chronology0, dateTimeField1, 6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The field must not be null");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        int int0 = DateTimeConstants.SECONDS_PER_MINUTE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 60 + "'", int0 == 60);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        Duration duration4 = interval2.toDuration();
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        PeriodType periodType7 = PeriodType.days();
        MutablePeriod mutablePeriod8 = new MutablePeriod((ReadableDuration) duration4, (ReadableInstant) dateMidnight6, periodType7);
        Chronology chronology9 = null;
        Period period10 = duration4.toPeriod(chronology9);
        int int12 = period10.getValue((int) (byte) 0);
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertNotNull(duration4);
        org.junit.Assert.assertNotNull(periodType7);
        org.junit.Assert.assertNotNull(period10);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        // The following exception was thrown during execution in test generation
        try {
            DateTime dateTime3 = new DateTime((Object) 1.0d, dateTimeZone2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: No instant converter found for type: java.lang.Double");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter1 = null;
        // The following exception was thrown during execution in test generation
        try {
            DateTime dateTime2 = DateTime.parse("", dateTimeFormatter1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        Chronology chronology2 = null;
        DateMidnight dateMidnight3 = dateMidnight1.withChronology(chronology2);
        DateMidnight dateMidnight5 = new DateMidnight(0L);
        Hours hours6 = Hours.hoursBetween((ReadableInstant) dateMidnight1, (ReadableInstant) dateMidnight5);
        // The following exception was thrown during execution in test generation
        try {
            String str8 = dateMidnight5.toString("");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid pattern specification: Pattern is null or empty");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(dateMidnight3);
        org.junit.Assert.assertNotNull(hours6);
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        Duration duration4 = interval2.toDuration();
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        PeriodType periodType7 = PeriodType.days();
        MutablePeriod mutablePeriod8 = new MutablePeriod((ReadableDuration) duration4, (ReadableInstant) dateMidnight6, periodType7);
        // The following exception was thrown during execution in test generation
        try {
            mutablePeriod8.setWeeks((int) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Period does not support field 'weeks'");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertNotNull(duration4);
        org.junit.Assert.assertNotNull(periodType7);
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        PeriodType periodType8 = PeriodType.days();
        MutablePeriod mutablePeriod9 = new MutablePeriod(periodType8);
        // The following exception was thrown during execution in test generation
        try {
            Period period10 = new Period(1, 1, 100, (int) '4', (int) (byte) 10, (int) 'a', (int) (byte) 100, (int) ' ', periodType8);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Period does not support field 'years'");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(periodType8);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        java.util.Calendar calendar0 = null;
        // The following exception was thrown during execution in test generation
        try {
            LocalTime localTime1 = LocalTime.fromCalendarFields(calendar0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The calendar must not be null");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        Duration duration4 = interval2.toDuration();
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        PeriodType periodType7 = PeriodType.days();
        MutablePeriod mutablePeriod8 = new MutablePeriod((ReadableDuration) duration4, (ReadableInstant) dateMidnight6, periodType7);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology9 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone10 = ethiopicChronology9.getZone();
        Weeks weeks11 = Weeks.ONE;
        int[] intArray14 = ethiopicChronology9.get((ReadablePeriod) weeks11, (long) (short) 1, 100L);
        // The following exception was thrown during execution in test generation
        try {
            mutablePeriod8.setPeriod((ReadablePeriod) weeks11);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Period does not support field 'weeks'");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertNotNull(duration4);
        org.junit.Assert.assertNotNull(periodType7);
        org.junit.Assert.assertNotNull(ethiopicChronology9);
        org.junit.Assert.assertNotNull(dateTimeZone10);
        org.junit.Assert.assertNotNull(weeks11);
        org.junit.Assert.assertNotNull(intArray14);
        org.junit.Assert.assertArrayEquals(intArray14, new int[] { 0 });
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        DateTimeFieldType dateTimeFieldType0 = DateTimeFieldType.dayOfYear();
        String str1 = dateTimeFieldType0.toString();
        org.junit.Assert.assertNotNull(dateTimeFieldType0);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "dayOfYear" + "'", str1, "dayOfYear");
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        Instant instant1 = Instant.ofEpochMilli((-1L));
        org.junit.Assert.assertNotNull(instant1);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        // The following exception was thrown during execution in test generation
        try {
            LocalDateTime localDateTime1 = LocalDateTime.parse("");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid format: \"\"");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        MutableInterval mutableInterval2 = new MutableInterval((long) (byte) -1, (long) 1);
        Object obj3 = mutableInterval2.clone();
        ReadableInterval readableInterval4 = null;
        boolean boolean5 = mutableInterval2.isBefore(readableInterval4);
        org.junit.Assert.assertNotNull(obj3);
        org.junit.Assert.assertEquals(obj3.toString(), "1970-01-01T09:59:59.999+10:00/1970-01-01T10:00:00.001+10:00");
        org.junit.Assert.assertEquals(String.valueOf(obj3), "1970-01-01T09:59:59.999+10:00/1970-01-01T10:00:00.001+10:00");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj3), "1970-01-01T09:59:59.999+10:00/1970-01-01T10:00:00.001+10:00");
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        Duration duration4 = interval2.toDuration();
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        PeriodType periodType7 = PeriodType.days();
        MutablePeriod mutablePeriod8 = new MutablePeriod((ReadableDuration) duration4, (ReadableInstant) dateMidnight6, periodType7);
        Chronology chronology9 = null;
        Period period10 = duration4.toPeriod(chronology9);
        Object obj11 = null;
        Chronology chronology12 = null;
        Interval interval13 = new Interval(obj11, chronology12);
        Months months14 = Months.monthsIn((ReadableInterval) interval13);
        Duration duration15 = interval13.toDuration();
        DateMidnight dateMidnight17 = new DateMidnight(0L);
        PeriodType periodType18 = PeriodType.days();
        MutablePeriod mutablePeriod19 = new MutablePeriod((ReadableDuration) duration15, (ReadableInstant) dateMidnight17, periodType18);
        DateMidnight dateMidnight21 = new DateMidnight(0L);
        Chronology chronology22 = null;
        DateMidnight dateMidnight23 = dateMidnight21.withChronology(chronology22);
        DateMidnight dateMidnight25 = dateMidnight21.withCenturyOfEra((int) ' ');
        Object obj26 = null;
        Chronology chronology27 = null;
        Interval interval28 = new Interval(obj26, chronology27);
        Months months29 = Months.monthsIn((ReadableInterval) interval28);
        Duration duration30 = interval28.toDuration();
        DateMidnight dateMidnight32 = new DateMidnight(0L);
        PeriodType periodType33 = PeriodType.days();
        MutablePeriod mutablePeriod34 = new MutablePeriod((ReadableDuration) duration30, (ReadableInstant) dateMidnight32, periodType33);
        Period period35 = duration15.toPeriodFrom((ReadableInstant) dateMidnight21, periodType33);
        Interval interval36 = duration4.toIntervalFrom((ReadableInstant) dateMidnight21);
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertNotNull(duration4);
        org.junit.Assert.assertNotNull(periodType7);
        org.junit.Assert.assertNotNull(period10);
        org.junit.Assert.assertNotNull(months14);
        org.junit.Assert.assertNotNull(duration15);
        org.junit.Assert.assertNotNull(periodType18);
        org.junit.Assert.assertNotNull(dateMidnight23);
        org.junit.Assert.assertNotNull(dateMidnight25);
        org.junit.Assert.assertNotNull(months29);
        org.junit.Assert.assertNotNull(duration30);
        org.junit.Assert.assertNotNull(periodType33);
        org.junit.Assert.assertNotNull(period35);
        org.junit.Assert.assertNotNull(interval36);
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology7 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone8 = ethiopicChronology7.getZone();
        // The following exception was thrown during execution in test generation
        try {
            DateTime dateTime9 = new DateTime(6, (int) (byte) 1, 0, (int) '4', 100, (int) (short) 10, 100, dateTimeZone8);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 52 for hourOfDay must be in the range [0,23]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology7);
        org.junit.Assert.assertNotNull(dateTimeZone8);
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Weeks weeks2 = Weeks.ONE;
        int[] intArray5 = ethiopicChronology0.get((ReadablePeriod) weeks2, (long) (short) 1, 100L);
        DateTimeField dateTimeField6 = ethiopicChronology0.millisOfDay();
        DateTimeZone dateTimeZone7 = null;
        // The following exception was thrown during execution in test generation
        try {
            LocalDate localDate8 = new LocalDate((Object) ethiopicChronology0, dateTimeZone7);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: No partial converter found for type: org.joda.time.chrono.EthiopicChronology");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks2);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField6);
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        boolean boolean0 = org.joda.time.tz.ZoneInfoLogger.verbose();
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter0 = org.joda.time.format.ISODateTimeFormat.yearMonthDay();
        StringBuffer stringBuffer1 = null;
        // The following exception was thrown during execution in test generation
        try {
            dateTimeFormatter0.printTo(stringBuffer1, (long) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(dateTimeFormatter0);
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        java.util.Date date0 = null;
        // The following exception was thrown during execution in test generation
        try {
            LocalDate localDate1 = LocalDate.fromDateFields(date0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The date must not be null");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        int int0 = DateTimeConstants.JULY;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 7 + "'", int0 == 7);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        Hours hours2 = Hours.MIN_VALUE;
        // The following exception was thrown during execution in test generation
        try {
            Interval interval3 = new Interval((ReadableInstant) dateMidnight1, (ReadablePeriod) hours2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The end instant must be greater than the start instant");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(hours2);
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Weeks weeks6 = Weeks.ONE;
        Interval interval7 = interval5.withPeriodAfterStart((ReadablePeriod) weeks6);
        int[] intArray10 = ethiopicChronology1.get((ReadablePeriod) weeks6, (long) (short) -1, (long) (short) -1);
        DurationField durationField11 = ethiopicChronology1.minutes();
        YearMonthDay yearMonthDay12 = new YearMonthDay(100L, (Chronology) ethiopicChronology1);
        DateTimeField dateTimeField13 = ethiopicChronology1.minuteOfDay();
        DateTimeField dateTimeField14 = org.joda.time.field.StrictDateTimeField.getInstance(dateTimeField13);
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(weeks6);
        org.junit.Assert.assertNotNull(interval7);
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField11);
        org.junit.Assert.assertNotNull(dateTimeField13);
        org.junit.Assert.assertNotNull(dateTimeField14);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        long long1 = DateTimeUtils.fromJulianDay(0.0d);
        org.junit.Assert.assertTrue("'" + long1 + "' != '" + (-210866760000000L) + "'", long1 == (-210866760000000L));
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Weeks weeks6 = Weeks.ONE;
        Interval interval7 = interval5.withPeriodAfterStart((ReadablePeriod) weeks6);
        int[] intArray10 = ethiopicChronology1.get((ReadablePeriod) weeks6, (long) (short) -1, (long) (short) -1);
        DurationField durationField11 = ethiopicChronology1.minutes();
        YearMonthDay yearMonthDay12 = new YearMonthDay(100L, (Chronology) ethiopicChronology1);
        ReadablePartial readablePartial13 = null;
        // The following exception was thrown during execution in test generation
        try {
            Period period14 = new Period((ReadablePartial) yearMonthDay12, readablePartial13);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: ReadablePartial objects must not be null");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(weeks6);
        org.junit.Assert.assertNotNull(interval7);
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField11);
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test035");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        Chronology chronology2 = null;
        DateMidnight dateMidnight3 = dateMidnight1.withChronology(chronology2);
        DateMidnight dateMidnight5 = new DateMidnight(0L);
        Hours hours6 = Hours.hoursBetween((ReadableInstant) dateMidnight1, (ReadableInstant) dateMidnight5);
        Hours hours7 = Hours.MIN_VALUE;
        // The following exception was thrown during execution in test generation
        try {
            Hours hours8 = hours6.minus(hours7);
            org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException; message: Integer.MIN_VALUE cannot be negated");
        } catch (ArithmeticException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(dateMidnight3);
        org.junit.Assert.assertNotNull(hours6);
        org.junit.Assert.assertNotNull(hours7);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        Hours hours0 = Hours.MIN_VALUE;
        Hours hours1 = Hours.MIN_VALUE;
        // The following exception was thrown during execution in test generation
        try {
            Hours hours2 = hours0.minus(hours1);
            org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException; message: Integer.MIN_VALUE cannot be negated");
        } catch (ArithmeticException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(hours0);
        org.junit.Assert.assertNotNull(hours1);
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        Duration duration4 = interval2.toDuration();
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        PeriodType periodType7 = PeriodType.days();
        MutablePeriod mutablePeriod8 = new MutablePeriod((ReadableDuration) duration4, (ReadableInstant) dateMidnight6, periodType7);
        DateMidnight dateMidnight10 = new DateMidnight(0L);
        Chronology chronology11 = null;
        DateMidnight dateMidnight12 = dateMidnight10.withChronology(chronology11);
        DateMidnight dateMidnight14 = dateMidnight10.withCenturyOfEra((int) ' ');
        Object obj15 = null;
        Chronology chronology16 = null;
        Interval interval17 = new Interval(obj15, chronology16);
        Months months18 = Months.monthsIn((ReadableInterval) interval17);
        Duration duration19 = interval17.toDuration();
        DateMidnight dateMidnight21 = new DateMidnight(0L);
        PeriodType periodType22 = PeriodType.days();
        MutablePeriod mutablePeriod23 = new MutablePeriod((ReadableDuration) duration19, (ReadableInstant) dateMidnight21, periodType22);
        Period period24 = duration4.toPeriodFrom((ReadableInstant) dateMidnight10, periodType22);
        // The following exception was thrown during execution in test generation
        try {
            Period period26 = period24.minusMinutes((int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: Field is not supported");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertNotNull(duration4);
        org.junit.Assert.assertNotNull(periodType7);
        org.junit.Assert.assertNotNull(dateMidnight12);
        org.junit.Assert.assertNotNull(dateMidnight14);
        org.junit.Assert.assertNotNull(months18);
        org.junit.Assert.assertNotNull(duration19);
        org.junit.Assert.assertNotNull(periodType22);
        org.junit.Assert.assertNotNull(period24);
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        int int2 = org.joda.time.field.FieldUtils.safeMultiply(60, (int) ' ');
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 1920 + "'", int2 == 1920);
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology7 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone8 = ethiopicChronology7.getZone();
        org.joda.time.chrono.CopticChronology copticChronology9 = org.joda.time.chrono.CopticChronology.getInstance(dateTimeZone8);
        // The following exception was thrown during execution in test generation
        try {
            MutableDateTime mutableDateTime10 = new MutableDateTime(36000000, (int) ' ', 10, (int) (byte) 1, (int) (short) 0, (int) (byte) 1, 7, dateTimeZone8);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 32 for monthOfYear must be in the range [1,12]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology7);
        org.junit.Assert.assertNotNull(dateTimeZone8);
        org.junit.Assert.assertNotNull(copticChronology9);
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter1 = org.joda.time.format.ISODateTimeFormat.yearMonthDay();
        // The following exception was thrown during execution in test generation
        try {
            LocalDate localDate2 = LocalDate.parse("dayOfYear", dateTimeFormatter1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid format: \"dayOfYear\"");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(dateTimeFormatter1);
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        Object obj5 = null;
        Chronology chronology6 = null;
        Interval interval7 = new Interval(obj5, chronology6);
        Months months8 = Months.monthsIn((ReadableInterval) interval7);
        Duration duration9 = interval7.toDuration();
        DateMidnight dateMidnight11 = new DateMidnight(0L);
        PeriodType periodType12 = PeriodType.days();
        MutablePeriod mutablePeriod13 = new MutablePeriod((ReadableDuration) duration9, (ReadableInstant) dateMidnight11, periodType12);
        Chronology chronology14 = null;
        Period period15 = duration9.toPeriod(chronology14);
        Object obj16 = null;
        Chronology chronology17 = null;
        Interval interval18 = new Interval(obj16, chronology17);
        Months months19 = Months.monthsIn((ReadableInterval) interval18);
        Duration duration20 = interval18.toDuration();
        DateMidnight dateMidnight22 = new DateMidnight(0L);
        PeriodType periodType23 = PeriodType.days();
        MutablePeriod mutablePeriod24 = new MutablePeriod((ReadableDuration) duration20, (ReadableInstant) dateMidnight22, periodType23);
        boolean boolean25 = duration9.isShorterThan((ReadableDuration) duration20);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology26 = org.joda.time.chrono.EthiopicChronology.getInstance();
        Period period27 = new Period((Object) duration9, (Chronology) ethiopicChronology26);
        // The following exception was thrown during execution in test generation
        try {
            DateTime dateTime28 = new DateTime(100, (int) (short) 1, 60, (int) (short) -1, (int) 'a', (Chronology) ethiopicChronology26);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value -1 for hourOfDay must be in the range [0,23]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(months8);
        org.junit.Assert.assertNotNull(duration9);
        org.junit.Assert.assertNotNull(periodType12);
        org.junit.Assert.assertNotNull(period15);
        org.junit.Assert.assertNotNull(months19);
        org.junit.Assert.assertNotNull(duration20);
        org.junit.Assert.assertNotNull(periodType23);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(ethiopicChronology26);
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        MutableInterval mutableInterval2 = new MutableInterval((long) (byte) -1, (long) 1);
        ReadablePeriod readablePeriod3 = null;
        mutableInterval2.setPeriodBeforeEnd(readablePeriod3);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        DateMidnight dateMidnight3 = new DateMidnight(0L);
        boolean boolean4 = dateMidnight1.isEqual((ReadableInstant) dateMidnight3);
        DateMidnight dateMidnight6 = dateMidnight1.plusDays((int) 'a');
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(dateMidnight6);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        int int0 = DateTimeConstants.MINUTES_PER_WEEK;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 10080 + "'", int0 == 10080);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        int int0 = DateTimeConstants.DECEMBER;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 12 + "'", int0 == 12);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter0 = org.joda.time.format.ISODateTimeFormat.dateTimeParser();
        // The following exception was thrown during execution in test generation
        try {
            MutableDateTime mutableDateTime2 = dateTimeFormatter0.parseMutableDateTime("hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid format: \"hi!\"");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(dateTimeFormatter0);
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        java.util.Date date0 = null;
        // The following exception was thrown during execution in test generation
        try {
            TimeOfDay timeOfDay1 = TimeOfDay.fromDateFields(date0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The date must not be null");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        int int0 = DateTimeConstants.APRIL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 4 + "'", int0 == 4);
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        // The following exception was thrown during execution in test generation
        try {
            long long2 = org.joda.time.field.FieldUtils.safeDivide((long) 7, 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException; message: / by zero");
        } catch (ArithmeticException e) {
            // Expected exception.
        }
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        int int0 = TimeOfDay.MINUTE_OF_HOUR;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        int int3 = dateTimeZone1.getOffset((long) 100);
        LocalDateTime localDateTime4 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean5 = dateTimeZone1.isLocalDateTimeGap(localDateTime4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 36000000 + "'", int3 == 36000000);
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        int int0 = DateTimeConstants.MARCH;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 3 + "'", int0 == 3);
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Weeks weeks2 = Weeks.ONE;
        int[] intArray5 = ethiopicChronology0.get((ReadablePeriod) weeks2, (long) (short) 1, 100L);
        DateTimeField dateTimeField6 = ethiopicChronology0.millisOfDay();
        java.util.Locale locale8 = null;
        String str9 = dateTimeField6.getAsShortText(100L, locale8);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks2);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField6);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "36000100" + "'", str9, "36000100");
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Weeks weeks2 = Weeks.ONE;
        int[] intArray5 = ethiopicChronology0.get((ReadablePeriod) weeks2, (long) (short) 1, 100L);
        DateTimeField dateTimeField6 = ethiopicChronology0.millisOfDay();
        TimeOfDay timeOfDay7 = new TimeOfDay();
        long long9 = ethiopicChronology0.set((ReadablePartial) timeOfDay7, 0L);
        TimeOfDay timeOfDay11 = timeOfDay7.withMinuteOfHour(12);
        // The following exception was thrown during execution in test generation
        try {
            DateTimeField dateTimeField13 = timeOfDay11.getField((int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Invalid index: 52");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks2);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField6);
// flaky "1) test054(RegressionTest0)":         org.junit.Assert.assertTrue("'" + long9 + "' != '" + 31081282L + "'", long9 == 31081282L);
        org.junit.Assert.assertNotNull(timeOfDay11);
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter0 = org.joda.time.format.ISODateTimeFormat.dateTime();
        // The following exception was thrown during execution in test generation
        try {
            MutableDateTime mutableDateTime2 = dateTimeFormatter0.parseMutableDateTime("36000100");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid format: \"36000100\" is too short");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(dateTimeFormatter0);
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Weeks weeks6 = Weeks.ONE;
        Interval interval7 = interval5.withPeriodAfterStart((ReadablePeriod) weeks6);
        int[] intArray10 = ethiopicChronology1.get((ReadablePeriod) weeks6, (long) (short) -1, (long) (short) -1);
        DurationField durationField11 = ethiopicChronology1.minutes();
        YearMonthDay yearMonthDay12 = new YearMonthDay(100L, (Chronology) ethiopicChronology1);
        DateTimeField dateTimeField13 = ethiopicChronology1.minuteOfDay();
        boolean boolean14 = dateTimeField13.isLenient();
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(weeks6);
        org.junit.Assert.assertNotNull(interval7);
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField11);
        org.junit.Assert.assertNotNull(dateTimeField13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        DateTimeZone dateTimeZone1 = null;
        MutableDateTime mutableDateTime2 = new MutableDateTime((long) 10080, dateTimeZone1);
        DateMidnight dateMidnight4 = new DateMidnight(0L);
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        boolean boolean7 = dateMidnight4.isEqual((ReadableInstant) dateMidnight6);
        int int8 = dateMidnight4.getSecondOfDay();
        DateMidnight dateMidnight10 = dateMidnight4.plus((long) 36000000);
        mutableDateTime2.setMillis((ReadableInstant) dateMidnight10);
        ReadableInstant readableInstant12 = null;
        // The following exception was thrown during execution in test generation
        try {
            Years years13 = Years.yearsBetween((ReadableInstant) mutableDateTime2, readableInstant12);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: ReadableInstant objects must not be null");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateMidnight10);
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        Period period1 = Period.weeks((int) (byte) -1);
        org.junit.Assert.assertNotNull(period1);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        String str4 = months3.toString();
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "P0M" + "'", str4, "P0M");
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        // The following exception was thrown during execution in test generation
        try {
            DateTime dateTime6 = new DateTime((int) '4', (int) '#', (int) (short) 10, 7, 4, 1920);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 1920 for secondOfMinute must be in the range [0,59]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        // The following exception was thrown during execution in test generation
        try {
            DateTime dateTime6 = new DateTime(1920, (int) '4', 0, 0, 0, 36000000);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 36000000 for secondOfMinute must be in the range [0,59]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter0 = org.joda.time.format.ISODateTimeFormat.yearMonthDay();
        Appendable appendable1 = null;
        TimeOfDay timeOfDay2 = new TimeOfDay();
        Weeks weeks3 = Weeks.ONE;
        Period period4 = weeks3.toPeriod();
        TimeOfDay timeOfDay5 = timeOfDay2.minus((ReadablePeriod) weeks3);
        // The following exception was thrown during execution in test generation
        try {
            dateTimeFormatter0.printTo(appendable1, (ReadablePartial) timeOfDay5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(dateTimeFormatter0);
        org.junit.Assert.assertNotNull(weeks3);
        org.junit.Assert.assertNotNull(period4);
        org.junit.Assert.assertNotNull(timeOfDay5);
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Weeks weeks6 = Weeks.ONE;
        Interval interval7 = interval5.withPeriodAfterStart((ReadablePeriod) weeks6);
        int[] intArray10 = ethiopicChronology1.get((ReadablePeriod) weeks6, (long) (short) -1, (long) (short) -1);
        DurationField durationField11 = ethiopicChronology1.minutes();
        YearMonthDay yearMonthDay12 = new YearMonthDay(100L, (Chronology) ethiopicChronology1);
        DateTimeField dateTimeField13 = ethiopicChronology1.minuteOfDay();
        DateTimeField dateTimeField14 = ethiopicChronology1.dayOfMonth();
        DateTimeField dateTimeField15 = ethiopicChronology1.hourOfHalfday();
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(weeks6);
        org.junit.Assert.assertNotNull(interval7);
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField11);
        org.junit.Assert.assertNotNull(dateTimeField13);
        org.junit.Assert.assertNotNull(dateTimeField14);
        org.junit.Assert.assertNotNull(dateTimeField15);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        DateMidnight dateMidnight3 = new DateMidnight(0L);
        boolean boolean4 = dateMidnight1.isEqual((ReadableInstant) dateMidnight3);
        int int5 = dateMidnight1.getSecondOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology8 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone9 = ethiopicChronology8.getZone();
        Weeks weeks10 = Weeks.ONE;
        int[] intArray13 = ethiopicChronology8.get((ReadablePeriod) weeks10, (long) (short) 1, 100L);
        Period period14 = new Period((long) (short) 0, (long) 'a', (Chronology) ethiopicChronology8);
        DateMidnight dateMidnight15 = dateMidnight1.withChronology((Chronology) ethiopicChronology8);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertNotNull(ethiopicChronology8);
        org.junit.Assert.assertNotNull(dateTimeZone9);
        org.junit.Assert.assertNotNull(weeks10);
        org.junit.Assert.assertNotNull(intArray13);
        org.junit.Assert.assertArrayEquals(intArray13, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateMidnight15);
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Object obj2 = null;
        Chronology chronology3 = null;
        Interval interval4 = new Interval(obj2, chronology3);
        Weeks weeks5 = Weeks.ONE;
        Interval interval6 = interval4.withPeriodAfterStart((ReadablePeriod) weeks5);
        int[] intArray9 = ethiopicChronology0.get((ReadablePeriod) weeks5, (long) (short) -1, (long) (short) -1);
        DurationField durationField10 = ethiopicChronology0.minutes();
        DateTimeField dateTimeField11 = ethiopicChronology0.clockhourOfDay();
        // The following exception was thrown during execution in test generation
        try {
            long long16 = ethiopicChronology0.getDateTimeMillis(6, (int) 'a', 100, (int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 97 for monthOfYear must be in the range [1,13]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks5);
        org.junit.Assert.assertNotNull(interval6);
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertArrayEquals(intArray9, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField10);
        org.junit.Assert.assertNotNull(dateTimeField11);
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField4 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField3);
        String str5 = dateTimeField3.toString();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "DateTimeField[clockhourOfDay]" + "'", str5, "DateTimeField[clockhourOfDay]");
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DateTimeField dateTimeField2 = ethiopicChronology0.minuteOfHour();
        MonthDay monthDay3 = new MonthDay((Chronology) ethiopicChronology0);
        String str4 = monthDay3.toString();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology5 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone6 = ethiopicChronology5.getZone();
        long long10 = dateTimeZone6.convertLocalToUTC((long) 6, false, 0L);
        LocalDate localDate11 = new LocalDate(dateTimeZone6);
        // The following exception was thrown during execution in test generation
        try {
            Period period12 = new Period((ReadablePartial) monthDay3, (ReadablePartial) localDate11);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: ReadablePartial objects must have the same set of fields");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(dateTimeField2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "--09-15" + "'", str4, "--09-15");
        org.junit.Assert.assertNotNull(ethiopicChronology5);
        org.junit.Assert.assertNotNull(dateTimeZone6);
        org.junit.Assert.assertTrue("'" + long10 + "' != '" + (-35999994L) + "'", long10 == (-35999994L));
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        PeriodType periodType0 = PeriodType.days();
        MutablePeriod mutablePeriod1 = new MutablePeriod(periodType0);
        // The following exception was thrown during execution in test generation
        try {
            mutablePeriod1.setSeconds(6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Period does not support field 'seconds'");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(periodType0);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        TimeOfDay timeOfDay0 = new TimeOfDay();
        Weeks weeks1 = Weeks.ONE;
        Period period2 = weeks1.toPeriod();
        TimeOfDay timeOfDay3 = timeOfDay0.minus((ReadablePeriod) weeks1);
        DateTimeFieldType dateTimeFieldType4 = DateTimeFieldType.dayOfYear();
        // The following exception was thrown during execution in test generation
        try {
            int int5 = timeOfDay3.get(dateTimeFieldType4);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Field 'dayOfYear' is not supported");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(weeks1);
        org.junit.Assert.assertNotNull(period2);
        org.junit.Assert.assertNotNull(timeOfDay3);
        org.junit.Assert.assertNotNull(dateTimeFieldType4);
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        PeriodType periodType0 = PeriodType.yearMonthDayTime();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        long long6 = dateTimeZone2.convertLocalToUTC((long) 6, false, 0L);
        // The following exception was thrown during execution in test generation
        try {
            MutableDateTime mutableDateTime7 = new MutableDateTime((Object) periodType0, dateTimeZone2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: No instant converter found for type: org.joda.time.PeriodType");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(periodType0);
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertTrue("'" + long6 + "' != '" + (-35999994L) + "'", long6 == (-35999994L));
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        double double1 = DateTimeUtils.toJulianDay(0L);
        org.junit.Assert.assertTrue("'" + double1 + "' != '" + 2440587.5d + "'", double1 == 2440587.5d);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        int int0 = DateTimeConstants.HOURS_PER_DAY;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 24 + "'", int0 == 24);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology7 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone8 = ethiopicChronology7.getZone();
        org.joda.time.chrono.CopticChronology copticChronology9 = org.joda.time.chrono.CopticChronology.getInstance(dateTimeZone8);
        // The following exception was thrown during execution in test generation
        try {
            MutableDateTime mutableDateTime10 = new MutableDateTime((-1), 36000000, 23, 60, (int) ' ', 23, 1, (Chronology) copticChronology9);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 60 for hourOfDay must be in the range [0,23]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology7);
        org.junit.Assert.assertNotNull(dateTimeZone8);
        org.junit.Assert.assertNotNull(copticChronology9);
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        long long0 = DateTimeUtils.currentTimeMillis();
// flaky "2) test074(RegressionTest0)":         org.junit.Assert.assertTrue("'" + long0 + "' != '" + 1747989495648L + "'", long0 == 1747989495648L);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeField dateTimeField1 = ethiopicChronology0.monthOfYear();
        // The following exception was thrown during execution in test generation
        try {
            long long6 = ethiopicChronology0.getDateTimeMillis(10080, (int) (byte) 10, (int) (short) 1, (int) (short) -1);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value -1 for millisOfDay must be in the range [0,86399999]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeField1);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        java.util.Calendar calendar0 = null;
        // The following exception was thrown during execution in test generation
        try {
            LocalDate localDate1 = LocalDate.fromCalendarFields(calendar0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The calendar must not be null");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        DurationField durationField4 = ethiopicChronology0.minutes();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(durationField4);
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        DateMidnight dateMidnight3 = new DateMidnight(0L);
        boolean boolean4 = dateMidnight1.isEqual((ReadableInstant) dateMidnight3);
        Object obj5 = null;
        Chronology chronology6 = null;
        Interval interval7 = new Interval(obj5, chronology6);
        Months months8 = Months.monthsIn((ReadableInterval) interval7);
        Duration duration9 = interval7.toDuration();
        DateMidnight dateMidnight11 = new DateMidnight(0L);
        PeriodType periodType12 = PeriodType.days();
        MutablePeriod mutablePeriod13 = new MutablePeriod((ReadableDuration) duration9, (ReadableInstant) dateMidnight11, periodType12);
        Chronology chronology14 = null;
        Period period15 = duration9.toPeriod(chronology14);
        PeriodType periodType16 = PeriodType.yearMonthDayTime();
        MutablePeriod mutablePeriod17 = new MutablePeriod((ReadableInstant) dateMidnight3, (ReadableDuration) duration9, periodType16);
        int int18 = mutablePeriod17.size();
        DurationFieldType durationFieldType19 = DurationFieldType.millis();
        mutablePeriod17.add(durationFieldType19, 0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(months8);
        org.junit.Assert.assertNotNull(duration9);
        org.junit.Assert.assertNotNull(periodType12);
        org.junit.Assert.assertNotNull(period15);
        org.junit.Assert.assertNotNull(periodType16);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 7 + "'", int18 == 7);
        org.junit.Assert.assertNotNull(durationFieldType19);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        DateTime dateTime0 = new DateTime();
        DateTime.Property property1 = dateTime0.hourOfDay();
        DateTime dateTime3 = dateTime0.withWeekyear(7);
        DateTime.Property property4 = dateTime0.centuryOfEra();
        String str5 = dateTime0.toString();
        org.junit.Assert.assertNotNull(property1);
        org.junit.Assert.assertNotNull(dateTime3);
        org.junit.Assert.assertNotNull(property4);
// flaky "3) test079(RegressionTest0)":         org.junit.Assert.assertEquals("'" + str5 + "' != '" + "2025-05-23T18:38:20.565+10:00" + "'", str5, "2025-05-23T18:38:20.565+10:00");
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        Hours hours0 = Hours.SIX;
        Hours hours2 = hours0.minus(36000000);
        Hours hours3 = Hours.MIN_VALUE;
        // The following exception was thrown during execution in test generation
        try {
            Hours hours4 = hours2.minus(hours3);
            org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException; message: Integer.MIN_VALUE cannot be negated");
        } catch (ArithmeticException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(hours0);
        org.junit.Assert.assertNotNull(hours2);
        org.junit.Assert.assertNotNull(hours3);
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        DateMidnight dateMidnight3 = new DateMidnight(0L);
        boolean boolean4 = dateMidnight1.isEqual((ReadableInstant) dateMidnight3);
        Object obj5 = null;
        Chronology chronology6 = null;
        Interval interval7 = new Interval(obj5, chronology6);
        Months months8 = Months.monthsIn((ReadableInterval) interval7);
        Duration duration9 = interval7.toDuration();
        DateMidnight dateMidnight11 = new DateMidnight(0L);
        PeriodType periodType12 = PeriodType.days();
        MutablePeriod mutablePeriod13 = new MutablePeriod((ReadableDuration) duration9, (ReadableInstant) dateMidnight11, periodType12);
        Chronology chronology14 = null;
        Period period15 = duration9.toPeriod(chronology14);
        PeriodType periodType16 = PeriodType.yearMonthDayTime();
        MutablePeriod mutablePeriod17 = new MutablePeriod((ReadableInstant) dateMidnight3, (ReadableDuration) duration9, periodType16);
        int int18 = dateMidnight3.getYear();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(months8);
        org.junit.Assert.assertNotNull(duration9);
        org.junit.Assert.assertNotNull(periodType12);
        org.junit.Assert.assertNotNull(period15);
        org.junit.Assert.assertNotNull(periodType16);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 1970 + "'", int18 == 1970);
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        Duration duration4 = interval2.toDuration();
        long long5 = duration4.getMillis();
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertNotNull(duration4);
        org.junit.Assert.assertTrue("'" + long5 + "' != '" + 0L + "'", long5 == 0L);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        Duration duration4 = interval2.toDuration();
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        PeriodType periodType7 = PeriodType.days();
        MutablePeriod mutablePeriod8 = new MutablePeriod((ReadableDuration) duration4, (ReadableInstant) dateMidnight6, periodType7);
        // The following exception was thrown during execution in test generation
        try {
            mutablePeriod8.setWeeks((int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Period does not support field 'weeks'");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertNotNull(duration4);
        org.junit.Assert.assertNotNull(periodType7);
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter1 = org.joda.time.format.ISODateTimeFormat.dateTimeParser();
        // The following exception was thrown during execution in test generation
        try {
            LocalDateTime localDateTime2 = LocalDateTime.parse("DateTimeField[clockhourOfDay]", dateTimeFormatter1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid format: \"DateTimeField[clockhourOfDay]\"");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(dateTimeFormatter1);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        DateTimeZone dateTimeZone1 = null;
        MutableDateTime mutableDateTime2 = new MutableDateTime((long) 10080, dateTimeZone1);
        mutableDateTime2.setDayOfYear(6);
        // The following exception was thrown during execution in test generation
        try {
            mutableDateTime2.setDayOfWeek(1920);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 1920 for dayOfWeek must be in the range [1,7]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        TimeOfDay timeOfDay0 = new TimeOfDay();
        Weeks weeks1 = Weeks.ONE;
        Period period2 = weeks1.toPeriod();
        TimeOfDay timeOfDay3 = timeOfDay0.minus((ReadablePeriod) weeks1);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        DurationField durationField6 = ethiopicChronology4.hours();
        DateTimeField dateTimeField7 = ethiopicChronology4.minuteOfHour();
        // The following exception was thrown during execution in test generation
        try {
            MonthDay monthDay8 = new MonthDay((Object) timeOfDay3, (Chronology) ethiopicChronology4);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Field 'monthOfYear' is not supported");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(weeks1);
        org.junit.Assert.assertNotNull(period2);
        org.junit.Assert.assertNotNull(timeOfDay3);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertNotNull(dateTimeField7);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        DateTimeFieldType dateTimeFieldType0 = DateTimeFieldType.weekyearOfCentury();
        IllegalFieldValueException illegalFieldValueException2 = new IllegalFieldValueException(dateTimeFieldType0, "hi!");
        // The following exception was thrown during execution in test generation
        try {
            Partial partial4 = new Partial(dateTimeFieldType0, (int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 100 for weekyearOfCentury must not be larger than 99");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(dateTimeFieldType0);
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        long long1 = DateTimeUtils.toJulianDayNumber(0L);
        org.junit.Assert.assertTrue("'" + long1 + "' != '" + 2440588L + "'", long1 == 2440588L);
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter0 = org.joda.time.format.ISODateTimeFormat.dateTimeParser();
        boolean boolean1 = dateTimeFormatter0.isPrinter();
        org.junit.Assert.assertNotNull(dateTimeFormatter0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        MutableInterval mutableInterval2 = new MutableInterval((long) (byte) -1, (long) 1);
        Object obj3 = mutableInterval2.clone();
        DateMidnight dateMidnight5 = new DateMidnight(0L);
        DateMidnight dateMidnight7 = new DateMidnight(0L);
        boolean boolean8 = dateMidnight5.isEqual((ReadableInstant) dateMidnight7);
        Object obj9 = null;
        Chronology chronology10 = null;
        Interval interval11 = new Interval(obj9, chronology10);
        Months months12 = Months.monthsIn((ReadableInterval) interval11);
        Duration duration13 = interval11.toDuration();
        DateMidnight dateMidnight15 = new DateMidnight(0L);
        PeriodType periodType16 = PeriodType.days();
        MutablePeriod mutablePeriod17 = new MutablePeriod((ReadableDuration) duration13, (ReadableInstant) dateMidnight15, periodType16);
        Chronology chronology18 = null;
        Period period19 = duration13.toPeriod(chronology18);
        PeriodType periodType20 = PeriodType.yearMonthDayTime();
        MutablePeriod mutablePeriod21 = new MutablePeriod((ReadableInstant) dateMidnight7, (ReadableDuration) duration13, periodType20);
        mutableInterval2.setDurationBeforeEnd((ReadableDuration) duration13);
        ReadableDuration readableDuration23 = null;
        mutableInterval2.setDurationBeforeEnd(readableDuration23);
        org.junit.Assert.assertNotNull(obj3);
        org.junit.Assert.assertEquals(obj3.toString(), "1970-01-01T09:59:59.999+10:00/1970-01-01T10:00:00.001+10:00");
        org.junit.Assert.assertEquals(String.valueOf(obj3), "1970-01-01T09:59:59.999+10:00/1970-01-01T10:00:00.001+10:00");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj3), "1970-01-01T09:59:59.999+10:00/1970-01-01T10:00:00.001+10:00");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(months12);
        org.junit.Assert.assertNotNull(duration13);
        org.junit.Assert.assertNotNull(periodType16);
        org.junit.Assert.assertNotNull(period19);
        org.junit.Assert.assertNotNull(periodType20);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        StringBuffer stringBuffer0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.joda.time.format.FormatUtils.appendUnpaddedInteger(stringBuffer0, (long) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField4 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField3);
        int int6 = delegatedDateTimeField4.get((long) (byte) 10);
        LocalDate localDate7 = new LocalDate();
        LocalDate localDate9 = localDate7.minusWeeks(3);
        LocalDate.Property property10 = localDate9.monthOfYear();
        java.util.Locale locale12 = null;
        String str13 = delegatedDateTimeField4.getAsText((ReadablePartial) localDate9, (int) (byte) 10, locale12);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology14 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone15 = ethiopicChronology14.getZone();
        long long19 = dateTimeZone15.convertLocalToUTC((long) 6, false, 0L);
        YearMonthDay yearMonthDay20 = new YearMonthDay(dateTimeZone15);
        DateTime dateTime21 = localDate9.toDateTimeAtStartOfDay(dateTimeZone15);
        LocalDate localDate23 = localDate9.withWeekyear(1);
        TimeOfDay timeOfDay24 = new TimeOfDay();
        // The following exception was thrown during execution in test generation
        try {
            Days days25 = Days.daysBetween((ReadablePartial) localDate9, (ReadablePartial) timeOfDay24);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: ReadablePartial objects must have the same set of fields");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
        org.junit.Assert.assertNotNull(localDate9);
        org.junit.Assert.assertNotNull(property10);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "10" + "'", str13, "10");
        org.junit.Assert.assertNotNull(ethiopicChronology14);
        org.junit.Assert.assertNotNull(dateTimeZone15);
        org.junit.Assert.assertTrue("'" + long19 + "' != '" + (-35999994L) + "'", long19 == (-35999994L));
        org.junit.Assert.assertNotNull(dateTime21);
        org.junit.Assert.assertNotNull(localDate23);
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField4 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField3);
        int int6 = delegatedDateTimeField4.get((long) (byte) 10);
        LocalDate localDate7 = new LocalDate();
        LocalDate localDate9 = localDate7.minusWeeks(3);
        LocalDate.Property property10 = localDate9.monthOfYear();
        java.util.Locale locale12 = null;
        String str13 = delegatedDateTimeField4.getAsText((ReadablePartial) localDate9, (int) (byte) 10, locale12);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology14 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone15 = ethiopicChronology14.getZone();
        long long19 = dateTimeZone15.convertLocalToUTC((long) 6, false, 0L);
        YearMonthDay yearMonthDay20 = new YearMonthDay(dateTimeZone15);
        DateTime dateTime21 = localDate9.toDateTimeAtStartOfDay(dateTimeZone15);
        LocalDate localDate23 = localDate9.withWeekyear(1);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology24 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone25 = ethiopicChronology24.getZone();
        Weeks weeks26 = Weeks.ONE;
        int[] intArray29 = ethiopicChronology24.get((ReadablePeriod) weeks26, (long) (short) 1, 100L);
        DateTimeField dateTimeField30 = ethiopicChronology24.millisOfDay();
        TimeOfDay timeOfDay31 = new TimeOfDay();
        long long33 = ethiopicChronology24.set((ReadablePartial) timeOfDay31, 0L);
        // The following exception was thrown during execution in test generation
        try {
            Period period34 = new Period((Object) 1, (Chronology) ethiopicChronology24);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: No period converter found for type: java.lang.Integer");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
        org.junit.Assert.assertNotNull(localDate9);
        org.junit.Assert.assertNotNull(property10);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "10" + "'", str13, "10");
        org.junit.Assert.assertNotNull(ethiopicChronology14);
        org.junit.Assert.assertNotNull(dateTimeZone15);
        org.junit.Assert.assertTrue("'" + long19 + "' != '" + (-35999994L) + "'", long19 == (-35999994L));
        org.junit.Assert.assertNotNull(dateTime21);
        org.junit.Assert.assertNotNull(localDate23);
        org.junit.Assert.assertNotNull(ethiopicChronology24);
        org.junit.Assert.assertNotNull(dateTimeZone25);
        org.junit.Assert.assertNotNull(weeks26);
        org.junit.Assert.assertNotNull(intArray29);
        org.junit.Assert.assertArrayEquals(intArray29, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField30);
// flaky "4) test093(RegressionTest0)":         org.junit.Assert.assertTrue("'" + long33 + "' != '" + 31112621L + "'", long33 == 31112621L);
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        DateTime dateTime0 = new DateTime();
        DateTime.Property property1 = dateTime0.hourOfDay();
        DateTime dateTime3 = dateTime0.withWeekyear(7);
        DateTime.Property property4 = dateTime0.centuryOfEra();
        DateTimeField dateTimeField5 = property4.getField();
        org.junit.Assert.assertNotNull(property1);
        org.junit.Assert.assertNotNull(dateTime3);
        org.junit.Assert.assertNotNull(property4);
        org.junit.Assert.assertNotNull(dateTimeField5);
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        int int0 = DateTimeConstants.MAY;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 5 + "'", int0 == 5);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        DateTimeFieldType dateTimeFieldType0 = DateTimeFieldType.weekyear();
        org.junit.Assert.assertNotNull(dateTimeFieldType0);
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        DurationFieldType durationFieldType0 = DurationFieldType.millis();
        String str1 = durationFieldType0.getName();
        org.junit.Assert.assertNotNull(durationFieldType0);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "millis" + "'", str1, "millis");
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Weeks weeks2 = Weeks.ONE;
        int[] intArray5 = ethiopicChronology0.get((ReadablePeriod) weeks2, (long) (short) 1, 100L);
        DurationField durationField6 = ethiopicChronology0.eras();
        DateTimeField dateTimeField7 = ethiopicChronology0.clockhourOfHalfday();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks2);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertNotNull(dateTimeField7);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        DurationField durationField6 = ethiopicChronology4.hours();
        int int8 = durationField6.getValue(0L);
        DateTimeFieldType dateTimeFieldType9 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField11 = new org.joda.time.field.DividedDateTimeField(dateTimeField3, durationField6, dateTimeFieldType9, (int) '4');
        java.util.Locale locale13 = null;
        String str14 = dividedDateTimeField11.getAsText((long) (-1), locale13);
        // The following exception was thrown during execution in test generation
        try {
            long long17 = dividedDateTimeField11.add((-210866760000000L), 0L);
            org.junit.Assert.fail("Expected exception of type org.joda.time.chrono.LimitChronology.LimitException; message: The instant is below the supported minimum of 0001-01-01T00:00:00.000Z (EthiopicChronology[UTC])");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType9);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology2 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone3 = ethiopicChronology2.getZone();
        Weeks weeks4 = Weeks.ONE;
        int[] intArray7 = ethiopicChronology2.get((ReadablePeriod) weeks4, (long) (short) 1, 100L);
        Period period8 = new Period((long) (short) 0, (long) 'a', (Chronology) ethiopicChronology2);
        DurationFieldType[] durationFieldTypeArray9 = period8.getFieldTypes();
        org.junit.Assert.assertNotNull(ethiopicChronology2);
        org.junit.Assert.assertNotNull(dateTimeZone3);
        org.junit.Assert.assertNotNull(weeks4);
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertArrayEquals(intArray7, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationFieldTypeArray9);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology2 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone3 = ethiopicChronology2.getZone();
        Weeks weeks4 = Weeks.ONE;
        int[] intArray7 = ethiopicChronology2.get((ReadablePeriod) weeks4, (long) (short) 1, 100L);
        Period period8 = new Period((long) (short) 0, (long) 'a', (Chronology) ethiopicChronology2);
        DateTimeField dateTimeField9 = ethiopicChronology2.dayOfMonth();
        String str11 = dateTimeField9.getAsShortText(1L);
        org.junit.Assert.assertNotNull(ethiopicChronology2);
        org.junit.Assert.assertNotNull(dateTimeZone3);
        org.junit.Assert.assertNotNull(weeks4);
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertArrayEquals(intArray7, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField9);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "23" + "'", str11, "23");
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeField dateTimeField1 = ethiopicChronology0.monthOfYear();
        String str2 = dateTimeField1.getName();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeField1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "monthOfYear" + "'", str2, "monthOfYear");
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        int int0 = YearMonthDay.MONTH_OF_YEAR;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        // The following exception was thrown during execution in test generation
        try {
            LocalDateTime localDateTime5 = new LocalDateTime(1970, (int) (byte) 100, (-1), 23, 3);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 100 for monthOfYear must be in the range [1,12]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology2 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone3 = ethiopicChronology2.getZone();
        Weeks weeks4 = Weeks.ONE;
        int[] intArray7 = ethiopicChronology2.get((ReadablePeriod) weeks4, (long) (short) 1, 100L);
        Period period8 = new Period((long) (short) 0, (long) 'a', (Chronology) ethiopicChronology2);
        Period period9 = period8.negated();
        org.junit.Assert.assertNotNull(ethiopicChronology2);
        org.junit.Assert.assertNotNull(dateTimeZone3);
        org.junit.Assert.assertNotNull(weeks4);
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertArrayEquals(intArray7, new int[] { 0 });
        org.junit.Assert.assertNotNull(period9);
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        Months months0 = Months.MAX_VALUE;
        Object obj1 = null;
        Chronology chronology2 = null;
        Interval interval3 = new Interval(obj1, chronology2);
        Months months4 = Months.monthsIn((ReadableInterval) interval3);
        boolean boolean5 = months0.isGreaterThan(months4);
        DurationFieldType durationFieldType6 = DurationFieldType.months();
        boolean boolean7 = months0.isSupported(durationFieldType6);
        String str8 = durationFieldType6.getName();
        org.junit.Assert.assertNotNull(months0);
        org.junit.Assert.assertNotNull(months4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(durationFieldType6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "months" + "'", str8, "months");
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Weeks weeks2 = Weeks.ONE;
        int[] intArray5 = ethiopicChronology0.get((ReadablePeriod) weeks2, (long) (short) 1, 100L);
        DateTimeField dateTimeField6 = ethiopicChronology0.millisOfDay();
        TimeOfDay timeOfDay7 = new TimeOfDay();
        long long9 = ethiopicChronology0.set((ReadablePartial) timeOfDay7, 0L);
        TimeOfDay timeOfDay11 = timeOfDay7.withMinuteOfHour(12);
        String str12 = timeOfDay7.toString();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks2);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField6);
// flaky "5) test107(RegressionTest0)":         org.junit.Assert.assertTrue("'" + long9 + "' != '" + 31123983L + "'", long9 == 31123983L);
        org.junit.Assert.assertNotNull(timeOfDay11);
// flaky "1) test107(RegressionTest0)":         org.junit.Assert.assertEquals("'" + str12 + "' != '" + "T18:38:43.983" + "'", str12, "T18:38:43.983");
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField4 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField3);
        int int6 = delegatedDateTimeField4.get((long) (byte) 10);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology7 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone8 = ethiopicChronology7.getZone();
        DurationField durationField9 = ethiopicChronology7.hours();
        DateTimeField dateTimeField10 = ethiopicChronology7.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField11 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField10);
        int int13 = delegatedDateTimeField11.get((long) (byte) 10);
        LocalDate localDate14 = new LocalDate();
        LocalDate localDate16 = localDate14.minusWeeks(3);
        LocalDate.Property property17 = localDate16.monthOfYear();
        java.util.Locale locale19 = null;
        String str20 = delegatedDateTimeField11.getAsText((ReadablePartial) localDate16, (int) (byte) 10, locale19);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology21 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone22 = ethiopicChronology21.getZone();
        DurationField durationField23 = ethiopicChronology21.hours();
        DateTimeField dateTimeField24 = ethiopicChronology21.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField25 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField24);
        int int27 = delegatedDateTimeField25.get((long) (byte) 10);
        LocalDate localDate28 = new LocalDate();
        LocalDate localDate30 = localDate28.minusWeeks(3);
        LocalDate.Property property31 = localDate30.monthOfYear();
        java.util.Locale locale33 = null;
        String str34 = delegatedDateTimeField25.getAsText((ReadablePartial) localDate30, (int) (byte) 10, locale33);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology35 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone36 = ethiopicChronology35.getZone();
        long long40 = dateTimeZone36.convertLocalToUTC((long) 6, false, 0L);
        YearMonthDay yearMonthDay41 = new YearMonthDay(dateTimeZone36);
        DateTime dateTime42 = localDate30.toDateTimeAtStartOfDay(dateTimeZone36);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology43 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone44 = ethiopicChronology43.getZone();
        Weeks weeks45 = Weeks.ONE;
        int[] intArray48 = ethiopicChronology43.get((ReadablePeriod) weeks45, (long) (short) 1, 100L);
        int int49 = delegatedDateTimeField11.getMinimumValue((ReadablePartial) localDate30, intArray48);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology51 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone52 = ethiopicChronology51.getZone();
        Weeks weeks53 = Weeks.ONE;
        int[] intArray56 = ethiopicChronology51.get((ReadablePeriod) weeks53, (long) (short) 1, 100L);
        java.util.Locale locale58 = null;
        // The following exception was thrown during execution in test generation
        try {
            int[] intArray59 = delegatedDateTimeField4.set((ReadablePartial) localDate30, (int) (short) -1, intArray56, "months", locale58);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value \"months\" for clockhourOfDay is not supported");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
        org.junit.Assert.assertNotNull(ethiopicChronology7);
        org.junit.Assert.assertNotNull(dateTimeZone8);
        org.junit.Assert.assertNotNull(durationField9);
        org.junit.Assert.assertNotNull(dateTimeField10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 10 + "'", int13 == 10);
        org.junit.Assert.assertNotNull(localDate16);
        org.junit.Assert.assertNotNull(property17);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "10" + "'", str20, "10");
        org.junit.Assert.assertNotNull(ethiopicChronology21);
        org.junit.Assert.assertNotNull(dateTimeZone22);
        org.junit.Assert.assertNotNull(durationField23);
        org.junit.Assert.assertNotNull(dateTimeField24);
        org.junit.Assert.assertTrue("'" + int27 + "' != '" + 10 + "'", int27 == 10);
        org.junit.Assert.assertNotNull(localDate30);
        org.junit.Assert.assertNotNull(property31);
        org.junit.Assert.assertEquals("'" + str34 + "' != '" + "10" + "'", str34, "10");
        org.junit.Assert.assertNotNull(ethiopicChronology35);
        org.junit.Assert.assertNotNull(dateTimeZone36);
        org.junit.Assert.assertTrue("'" + long40 + "' != '" + (-35999994L) + "'", long40 == (-35999994L));
        org.junit.Assert.assertNotNull(dateTime42);
        org.junit.Assert.assertNotNull(ethiopicChronology43);
        org.junit.Assert.assertNotNull(dateTimeZone44);
        org.junit.Assert.assertNotNull(weeks45);
        org.junit.Assert.assertNotNull(intArray48);
        org.junit.Assert.assertArrayEquals(intArray48, new int[] { 0 });
        org.junit.Assert.assertTrue("'" + int49 + "' != '" + 1 + "'", int49 == 1);
        org.junit.Assert.assertNotNull(ethiopicChronology51);
        org.junit.Assert.assertNotNull(dateTimeZone52);
        org.junit.Assert.assertNotNull(weeks53);
        org.junit.Assert.assertNotNull(intArray56);
        org.junit.Assert.assertArrayEquals(intArray56, new int[] { 0 });
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        int int0 = DateTimeConstants.SATURDAY;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 6 + "'", int0 == 6);
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        LocalDate localDate0 = new LocalDate();
        LocalDate localDate2 = localDate0.minusWeeks(3);
        LocalDate.Property property3 = localDate2.monthOfYear();
        LocalDate localDate4 = property3.roundHalfFloorCopy();
        LocalDate localDate5 = new LocalDate();
        DateTimeFieldType dateTimeFieldType6 = DateTimeFieldType.weekyearOfCentury();
        int int7 = localDate5.indexOf(dateTimeFieldType6);
        LocalDate localDate9 = localDate5.withDayOfYear(24);
        int int10 = localDate4.compareTo((ReadablePartial) localDate9);
        DateTimeFieldType dateTimeFieldType11 = DateTimeFieldType.dayOfWeek();
        LocalDate localDate13 = localDate4.withField(dateTimeFieldType11, (int) (byte) 1);
        org.junit.Assert.assertNotNull(localDate2);
        org.junit.Assert.assertNotNull(property3);
        org.junit.Assert.assertNotNull(localDate4);
        org.junit.Assert.assertNotNull(dateTimeFieldType6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + (-1) + "'", int7 == (-1));
        org.junit.Assert.assertNotNull(localDate9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 1 + "'", int10 == 1);
        org.junit.Assert.assertNotNull(dateTimeFieldType11);
        org.junit.Assert.assertNotNull(localDate13);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter0 = org.joda.time.format.DateTimeFormat.longDate();
        org.junit.Assert.assertNotNull(dateTimeFormatter0);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        DateMidnight dateMidnight3 = new DateMidnight(0L);
        boolean boolean4 = dateMidnight1.isEqual((ReadableInstant) dateMidnight3);
        int int5 = dateMidnight1.getSecondOfDay();
        DateMidnight dateMidnight7 = dateMidnight1.plus((long) 36000000);
        DateMidnight dateMidnight9 = new DateMidnight(0L);
        Chronology chronology10 = null;
        DateMidnight dateMidnight11 = dateMidnight9.withChronology(chronology10);
        DateMidnight dateMidnight13 = new DateMidnight(0L);
        Hours hours14 = Hours.hoursBetween((ReadableInstant) dateMidnight9, (ReadableInstant) dateMidnight13);
        DateMidnight dateMidnight15 = dateMidnight7.minus((ReadablePeriod) hours14);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertNotNull(dateMidnight7);
        org.junit.Assert.assertNotNull(dateMidnight11);
        org.junit.Assert.assertNotNull(hours14);
        org.junit.Assert.assertNotNull(dateMidnight15);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        DurationField durationField6 = ethiopicChronology4.hours();
        int int8 = durationField6.getValue(0L);
        DateTimeFieldType dateTimeFieldType9 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField11 = new org.joda.time.field.DividedDateTimeField(dateTimeField3, durationField6, dateTimeFieldType9, (int) '4');
        java.util.Locale locale13 = null;
        String str14 = dividedDateTimeField11.getAsText((long) (-1), locale13);
        // The following exception was thrown during execution in test generation
        try {
            long long16 = dividedDateTimeField11.roundHalfFloor((long) 6);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 0 for clockhourOfDay must be in the range [1,24]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType9);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        MutableDateTime mutableDateTime0 = MutableDateTime.now();
        Object obj1 = null;
        Chronology chronology2 = null;
        Interval interval3 = new Interval(obj1, chronology2);
        Months months4 = Months.monthsIn((ReadableInterval) interval3);
        Duration duration5 = interval3.toDuration();
        DateMidnight dateMidnight7 = new DateMidnight(0L);
        PeriodType periodType8 = PeriodType.days();
        MutablePeriod mutablePeriod9 = new MutablePeriod((ReadableDuration) duration5, (ReadableInstant) dateMidnight7, periodType8);
        Chronology chronology10 = null;
        Period period11 = duration5.toPeriod(chronology10);
        Object obj12 = null;
        Chronology chronology13 = null;
        Interval interval14 = new Interval(obj12, chronology13);
        Months months15 = Months.monthsIn((ReadableInterval) interval14);
        Duration duration16 = interval14.toDuration();
        DateMidnight dateMidnight18 = new DateMidnight(0L);
        PeriodType periodType19 = PeriodType.days();
        MutablePeriod mutablePeriod20 = new MutablePeriod((ReadableDuration) duration16, (ReadableInstant) dateMidnight18, periodType19);
        boolean boolean21 = duration5.isShorterThan((ReadableDuration) duration16);
        mutableDateTime0.add((ReadableDuration) duration16, 10);
        boolean boolean25 = mutableDateTime0.equals((Object) (-1.0f));
        MutableDateTime.Property property26 = mutableDateTime0.secondOfDay();
        org.junit.Assert.assertNotNull(mutableDateTime0);
        org.junit.Assert.assertNotNull(months4);
        org.junit.Assert.assertNotNull(duration5);
        org.junit.Assert.assertNotNull(periodType8);
        org.junit.Assert.assertNotNull(period11);
        org.junit.Assert.assertNotNull(months15);
        org.junit.Assert.assertNotNull(duration16);
        org.junit.Assert.assertNotNull(periodType19);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(property26);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField4 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField3);
        int int6 = delegatedDateTimeField4.get((long) (byte) 10);
        LocalDate localDate7 = new LocalDate();
        LocalDate localDate9 = localDate7.minusWeeks(3);
        LocalDate.Property property10 = localDate9.monthOfYear();
        java.util.Locale locale12 = null;
        String str13 = delegatedDateTimeField4.getAsText((ReadablePartial) localDate9, (int) (byte) 10, locale12);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology14 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone15 = ethiopicChronology14.getZone();
        long long19 = dateTimeZone15.convertLocalToUTC((long) 6, false, 0L);
        YearMonthDay yearMonthDay20 = new YearMonthDay(dateTimeZone15);
        DateTime dateTime21 = localDate9.toDateTimeAtStartOfDay(dateTimeZone15);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology22 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone23 = ethiopicChronology22.getZone();
        DurationField durationField24 = ethiopicChronology22.hours();
        DateTimeField dateTimeField25 = ethiopicChronology22.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology26 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone27 = ethiopicChronology26.getZone();
        DurationField durationField28 = ethiopicChronology26.hours();
        int int30 = durationField28.getValue(0L);
        DateTimeFieldType dateTimeFieldType31 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField33 = new org.joda.time.field.DividedDateTimeField(dateTimeField25, durationField28, dateTimeFieldType31, (int) '4');
        DateTimeFieldType dateTimeFieldType34 = DateTimeFieldType.clockhourOfHalfday();
        org.joda.time.field.OffsetDateTimeField offsetDateTimeField38 = new org.joda.time.field.OffsetDateTimeField((DateTimeField) dividedDateTimeField33, dateTimeFieldType34, 7, 1, 12);
        int int39 = localDate9.indexOf(dateTimeFieldType34);
        IllegalFieldValueException illegalFieldValueException43 = new IllegalFieldValueException(dateTimeFieldType34, (Number) (-36000000L), (Number) 24L, (Number) 23);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
        org.junit.Assert.assertNotNull(localDate9);
        org.junit.Assert.assertNotNull(property10);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "10" + "'", str13, "10");
        org.junit.Assert.assertNotNull(ethiopicChronology14);
        org.junit.Assert.assertNotNull(dateTimeZone15);
        org.junit.Assert.assertTrue("'" + long19 + "' != '" + (-35999994L) + "'", long19 == (-35999994L));
        org.junit.Assert.assertNotNull(dateTime21);
        org.junit.Assert.assertNotNull(ethiopicChronology22);
        org.junit.Assert.assertNotNull(dateTimeZone23);
        org.junit.Assert.assertNotNull(durationField24);
        org.junit.Assert.assertNotNull(dateTimeField25);
        org.junit.Assert.assertNotNull(ethiopicChronology26);
        org.junit.Assert.assertNotNull(dateTimeZone27);
        org.junit.Assert.assertNotNull(durationField28);
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 0 + "'", int30 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType31);
        org.junit.Assert.assertNotNull(dateTimeFieldType34);
        org.junit.Assert.assertTrue("'" + int39 + "' != '" + (-1) + "'", int39 == (-1));
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Weeks weeks6 = Weeks.ONE;
        Interval interval7 = interval5.withPeriodAfterStart((ReadablePeriod) weeks6);
        int[] intArray10 = ethiopicChronology1.get((ReadablePeriod) weeks6, (long) (short) -1, (long) (short) -1);
        DurationField durationField11 = ethiopicChronology1.minutes();
        YearMonthDay yearMonthDay12 = new YearMonthDay(100L, (Chronology) ethiopicChronology1);
        DateTimeField dateTimeField13 = ethiopicChronology1.minuteOfDay();
        DateTimeField dateTimeField14 = ethiopicChronology1.dayOfMonth();
        DateTimeZone dateTimeZone15 = ethiopicChronology1.getZone();
        // The following exception was thrown during execution in test generation
        try {
            org.joda.time.chrono.GJChronology gJChronology18 = org.joda.time.chrono.GJChronology.getInstance(dateTimeZone15, 100L, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid min days in first week: 0");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(weeks6);
        org.junit.Assert.assertNotNull(interval7);
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField11);
        org.junit.Assert.assertNotNull(dateTimeField13);
        org.junit.Assert.assertNotNull(dateTimeField14);
        org.junit.Assert.assertNotNull(dateTimeZone15);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        org.joda.time.chrono.CopticChronology copticChronology1 = org.joda.time.chrono.CopticChronology.getInstanceUTC();
        LocalDateTime localDateTime2 = new LocalDateTime((-35999994L), (Chronology) copticChronology1);
        LocalDateTime localDateTime4 = localDateTime2.plusDays((int) (byte) -1);
        // The following exception was thrown during execution in test generation
        try {
            DateTimeFieldType dateTimeFieldType6 = localDateTime4.getFieldType((int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Invalid index: 32");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(copticChronology1);
        org.junit.Assert.assertNotNull(localDateTime4);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Object obj2 = null;
        Chronology chronology3 = null;
        Interval interval4 = new Interval(obj2, chronology3);
        Weeks weeks5 = Weeks.ONE;
        Interval interval6 = interval4.withPeriodAfterStart((ReadablePeriod) weeks5);
        int[] intArray9 = ethiopicChronology0.get((ReadablePeriod) weeks5, (long) (short) -1, (long) (short) -1);
        DurationField durationField10 = ethiopicChronology0.years();
        boolean boolean11 = durationField10.isSupported();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks5);
        org.junit.Assert.assertNotNull(interval6);
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertArrayEquals(intArray9, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        int int0 = DateTimeConstants.HOURS_PER_WEEK;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 168 + "'", int0 == 168);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Weeks weeks2 = Weeks.ONE;
        int[] intArray5 = ethiopicChronology0.get((ReadablePeriod) weeks2, (long) (short) 1, 100L);
        TimeOfDay timeOfDay6 = new TimeOfDay();
        Weeks weeks7 = Weeks.ONE;
        Period period8 = weeks7.toPeriod();
        TimeOfDay timeOfDay9 = timeOfDay6.minus((ReadablePeriod) weeks7);
        Weeks weeks10 = weeks2.minus(weeks7);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks2);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] { 0 });
        org.junit.Assert.assertNotNull(weeks7);
        org.junit.Assert.assertNotNull(period8);
        org.junit.Assert.assertNotNull(timeOfDay9);
        org.junit.Assert.assertNotNull(weeks10);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        org.joda.time.chrono.CopticChronology copticChronology1 = org.joda.time.chrono.CopticChronology.getInstanceUTC();
        LocalDateTime localDateTime2 = new LocalDateTime((-35999994L), (Chronology) copticChronology1);
        // The following exception was thrown during execution in test generation
        try {
            LocalDateTime localDateTime4 = localDateTime2.withMinuteOfHour(36000000);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 36000000 for minuteOfHour must be in the range [0,59]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(copticChronology1);
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        int int4 = durationField2.getValue(0L);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology5 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone6 = ethiopicChronology5.getZone();
        DurationField durationField7 = ethiopicChronology5.hours();
        int int9 = durationField7.getValue(0L);
        int int10 = durationField2.compareTo(durationField7);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(ethiopicChronology5);
        org.junit.Assert.assertNotNull(dateTimeZone6);
        org.junit.Assert.assertNotNull(durationField7);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField4 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField3);
        int int6 = delegatedDateTimeField4.get((long) (byte) 10);
        LocalDate localDate7 = new LocalDate();
        LocalDate localDate9 = localDate7.minusWeeks(3);
        LocalDate.Property property10 = localDate9.monthOfYear();
        java.util.Locale locale12 = null;
        String str13 = delegatedDateTimeField4.getAsText((ReadablePartial) localDate9, (int) (byte) 10, locale12);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology14 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone15 = ethiopicChronology14.getZone();
        long long19 = dateTimeZone15.convertLocalToUTC((long) 6, false, 0L);
        YearMonthDay yearMonthDay20 = new YearMonthDay(dateTimeZone15);
        DateTime dateTime21 = localDate9.toDateTimeAtStartOfDay(dateTimeZone15);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology22 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone23 = ethiopicChronology22.getZone();
        DurationField durationField24 = ethiopicChronology22.hours();
        DateTimeField dateTimeField25 = ethiopicChronology22.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology26 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone27 = ethiopicChronology26.getZone();
        DurationField durationField28 = ethiopicChronology26.hours();
        int int30 = durationField28.getValue(0L);
        DateTimeFieldType dateTimeFieldType31 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField33 = new org.joda.time.field.DividedDateTimeField(dateTimeField25, durationField28, dateTimeFieldType31, (int) '4');
        int int35 = dividedDateTimeField33.getLeapAmount(10L);
        boolean boolean36 = org.joda.time.field.FieldUtils.equals((Object) dateTime21, (Object) 10L);
        Object obj37 = null;
        Chronology chronology38 = null;
        Interval interval39 = new Interval(obj37, chronology38);
        Months months40 = Months.monthsIn((ReadableInterval) interval39);
        Duration duration41 = interval39.toDuration();
        DateMidnight dateMidnight43 = new DateMidnight(0L);
        PeriodType periodType44 = PeriodType.days();
        MutablePeriod mutablePeriod45 = new MutablePeriod((ReadableDuration) duration41, (ReadableInstant) dateMidnight43, periodType44);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology47 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone48 = ethiopicChronology47.getZone();
        Object obj49 = null;
        Chronology chronology50 = null;
        Interval interval51 = new Interval(obj49, chronology50);
        Weeks weeks52 = Weeks.ONE;
        Interval interval53 = interval51.withPeriodAfterStart((ReadablePeriod) weeks52);
        int[] intArray56 = ethiopicChronology47.get((ReadablePeriod) weeks52, (long) (short) -1, (long) (short) -1);
        DurationField durationField57 = ethiopicChronology47.minutes();
        YearMonthDay yearMonthDay58 = new YearMonthDay(100L, (Chronology) ethiopicChronology47);
        // The following exception was thrown during execution in test generation
        try {
            MutablePeriod mutablePeriod59 = new MutablePeriod((Object) boolean36, periodType44, (Chronology) ethiopicChronology47);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: No period converter found for type: java.lang.Boolean");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
        org.junit.Assert.assertNotNull(localDate9);
        org.junit.Assert.assertNotNull(property10);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "10" + "'", str13, "10");
        org.junit.Assert.assertNotNull(ethiopicChronology14);
        org.junit.Assert.assertNotNull(dateTimeZone15);
        org.junit.Assert.assertTrue("'" + long19 + "' != '" + (-35999994L) + "'", long19 == (-35999994L));
        org.junit.Assert.assertNotNull(dateTime21);
        org.junit.Assert.assertNotNull(ethiopicChronology22);
        org.junit.Assert.assertNotNull(dateTimeZone23);
        org.junit.Assert.assertNotNull(durationField24);
        org.junit.Assert.assertNotNull(dateTimeField25);
        org.junit.Assert.assertNotNull(ethiopicChronology26);
        org.junit.Assert.assertNotNull(dateTimeZone27);
        org.junit.Assert.assertNotNull(durationField28);
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 0 + "'", int30 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType31);
        org.junit.Assert.assertTrue("'" + int35 + "' != '" + 0 + "'", int35 == 0);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertNotNull(months40);
        org.junit.Assert.assertNotNull(duration41);
        org.junit.Assert.assertNotNull(periodType44);
        org.junit.Assert.assertNotNull(ethiopicChronology47);
        org.junit.Assert.assertNotNull(dateTimeZone48);
        org.junit.Assert.assertNotNull(weeks52);
        org.junit.Assert.assertNotNull(interval53);
        org.junit.Assert.assertNotNull(intArray56);
        org.junit.Assert.assertArrayEquals(intArray56, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField57);
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        LocalDate localDate2 = LocalDate.now((Chronology) ethiopicChronology0);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(localDate2);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test125");
        Hours hours0 = Hours.SIX;
        MutablePeriod mutablePeriod1 = hours0.toMutablePeriod();
        PeriodType periodType2 = hours0.getPeriodType();
        org.junit.Assert.assertNotNull(hours0);
        org.junit.Assert.assertNotNull(mutablePeriod1);
        org.junit.Assert.assertNotNull(periodType2);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test126");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        DurationField durationField6 = ethiopicChronology4.hours();
        int int8 = durationField6.getValue(0L);
        DateTimeFieldType dateTimeFieldType9 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField11 = new org.joda.time.field.DividedDateTimeField(dateTimeField3, durationField6, dateTimeFieldType9, (int) '4');
        long long14 = dividedDateTimeField11.add(0L, 2440588L);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType9);
        org.junit.Assert.assertTrue("'" + long14 + "' != '" + 456878073600000L + "'", long14 == 456878073600000L);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test127");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField4 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField3);
        int int6 = delegatedDateTimeField4.get((long) (byte) 10);
        LocalDate localDate7 = new LocalDate();
        LocalDate localDate9 = localDate7.minusWeeks(3);
        LocalDate.Property property10 = localDate9.monthOfYear();
        java.util.Locale locale12 = null;
        String str13 = delegatedDateTimeField4.getAsText((ReadablePartial) localDate9, (int) (byte) 10, locale12);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology14 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone15 = ethiopicChronology14.getZone();
        DurationField durationField16 = ethiopicChronology14.hours();
        DateTimeField dateTimeField17 = ethiopicChronology14.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField18 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField17);
        int int20 = delegatedDateTimeField18.get((long) (byte) 10);
        LocalDate localDate21 = new LocalDate();
        LocalDate localDate23 = localDate21.minusWeeks(3);
        LocalDate.Property property24 = localDate23.monthOfYear();
        java.util.Locale locale26 = null;
        String str27 = delegatedDateTimeField18.getAsText((ReadablePartial) localDate23, (int) (byte) 10, locale26);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology28 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone29 = ethiopicChronology28.getZone();
        long long33 = dateTimeZone29.convertLocalToUTC((long) 6, false, 0L);
        YearMonthDay yearMonthDay34 = new YearMonthDay(dateTimeZone29);
        DateTime dateTime35 = localDate23.toDateTimeAtStartOfDay(dateTimeZone29);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology36 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone37 = ethiopicChronology36.getZone();
        Weeks weeks38 = Weeks.ONE;
        int[] intArray41 = ethiopicChronology36.get((ReadablePeriod) weeks38, (long) (short) 1, 100L);
        int int42 = delegatedDateTimeField4.getMinimumValue((ReadablePartial) localDate23, intArray41);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology43 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone44 = ethiopicChronology43.getZone();
        DateTimeField dateTimeField45 = ethiopicChronology43.minuteOfHour();
        MonthDay monthDay46 = new MonthDay((Chronology) ethiopicChronology43);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology48 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone49 = ethiopicChronology48.getZone();
        DurationField durationField50 = ethiopicChronology48.hours();
        DateTimeField dateTimeField51 = ethiopicChronology48.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField52 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField51);
        int int54 = delegatedDateTimeField52.get((long) (byte) 10);
        LocalDate localDate55 = new LocalDate();
        LocalDate localDate57 = localDate55.minusWeeks(3);
        LocalDate.Property property58 = localDate57.monthOfYear();
        java.util.Locale locale60 = null;
        String str61 = delegatedDateTimeField52.getAsText((ReadablePartial) localDate57, (int) (byte) 10, locale60);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology62 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone63 = ethiopicChronology62.getZone();
        DurationField durationField64 = ethiopicChronology62.hours();
        DateTimeField dateTimeField65 = ethiopicChronology62.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField66 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField65);
        int int68 = delegatedDateTimeField66.get((long) (byte) 10);
        LocalDate localDate69 = new LocalDate();
        LocalDate localDate71 = localDate69.minusWeeks(3);
        LocalDate.Property property72 = localDate71.monthOfYear();
        java.util.Locale locale74 = null;
        String str75 = delegatedDateTimeField66.getAsText((ReadablePartial) localDate71, (int) (byte) 10, locale74);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology76 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone77 = ethiopicChronology76.getZone();
        long long81 = dateTimeZone77.convertLocalToUTC((long) 6, false, 0L);
        YearMonthDay yearMonthDay82 = new YearMonthDay(dateTimeZone77);
        DateTime dateTime83 = localDate71.toDateTimeAtStartOfDay(dateTimeZone77);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology84 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone85 = ethiopicChronology84.getZone();
        Weeks weeks86 = Weeks.ONE;
        int[] intArray89 = ethiopicChronology84.get((ReadablePeriod) weeks86, (long) (short) 1, 100L);
        int int90 = delegatedDateTimeField52.getMinimumValue((ReadablePartial) localDate71, intArray89);
        // The following exception was thrown during execution in test generation
        try {
            int[] intArray92 = delegatedDateTimeField4.addWrapPartial((ReadablePartial) monthDay46, 0, intArray89, (int) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 1");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
        org.junit.Assert.assertNotNull(localDate9);
        org.junit.Assert.assertNotNull(property10);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "10" + "'", str13, "10");
        org.junit.Assert.assertNotNull(ethiopicChronology14);
        org.junit.Assert.assertNotNull(dateTimeZone15);
        org.junit.Assert.assertNotNull(durationField16);
        org.junit.Assert.assertNotNull(dateTimeField17);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 10 + "'", int20 == 10);
        org.junit.Assert.assertNotNull(localDate23);
        org.junit.Assert.assertNotNull(property24);
        org.junit.Assert.assertEquals("'" + str27 + "' != '" + "10" + "'", str27, "10");
        org.junit.Assert.assertNotNull(ethiopicChronology28);
        org.junit.Assert.assertNotNull(dateTimeZone29);
        org.junit.Assert.assertTrue("'" + long33 + "' != '" + (-35999994L) + "'", long33 == (-35999994L));
        org.junit.Assert.assertNotNull(dateTime35);
        org.junit.Assert.assertNotNull(ethiopicChronology36);
        org.junit.Assert.assertNotNull(dateTimeZone37);
        org.junit.Assert.assertNotNull(weeks38);
        org.junit.Assert.assertNotNull(intArray41);
        org.junit.Assert.assertArrayEquals(intArray41, new int[] { 0 });
        org.junit.Assert.assertTrue("'" + int42 + "' != '" + 1 + "'", int42 == 1);
        org.junit.Assert.assertNotNull(ethiopicChronology43);
        org.junit.Assert.assertNotNull(dateTimeZone44);
        org.junit.Assert.assertNotNull(dateTimeField45);
        org.junit.Assert.assertNotNull(ethiopicChronology48);
        org.junit.Assert.assertNotNull(dateTimeZone49);
        org.junit.Assert.assertNotNull(durationField50);
        org.junit.Assert.assertNotNull(dateTimeField51);
        org.junit.Assert.assertTrue("'" + int54 + "' != '" + 10 + "'", int54 == 10);
        org.junit.Assert.assertNotNull(localDate57);
        org.junit.Assert.assertNotNull(property58);
        org.junit.Assert.assertEquals("'" + str61 + "' != '" + "10" + "'", str61, "10");
        org.junit.Assert.assertNotNull(ethiopicChronology62);
        org.junit.Assert.assertNotNull(dateTimeZone63);
        org.junit.Assert.assertNotNull(durationField64);
        org.junit.Assert.assertNotNull(dateTimeField65);
        org.junit.Assert.assertTrue("'" + int68 + "' != '" + 10 + "'", int68 == 10);
        org.junit.Assert.assertNotNull(localDate71);
        org.junit.Assert.assertNotNull(property72);
        org.junit.Assert.assertEquals("'" + str75 + "' != '" + "10" + "'", str75, "10");
        org.junit.Assert.assertNotNull(ethiopicChronology76);
        org.junit.Assert.assertNotNull(dateTimeZone77);
        org.junit.Assert.assertTrue("'" + long81 + "' != '" + (-35999994L) + "'", long81 == (-35999994L));
        org.junit.Assert.assertNotNull(dateTime83);
        org.junit.Assert.assertNotNull(ethiopicChronology84);
        org.junit.Assert.assertNotNull(dateTimeZone85);
        org.junit.Assert.assertNotNull(weeks86);
        org.junit.Assert.assertNotNull(intArray89);
        org.junit.Assert.assertArrayEquals(intArray89, new int[] { 1 });
        org.junit.Assert.assertTrue("'" + int90 + "' != '" + 1 + "'", int90 == 1);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test128");
        DateTimeFieldType dateTimeFieldType0 = DateTimeFieldType.dayOfYear();
        String str1 = dateTimeFieldType0.getName();
        IllegalFieldValueException illegalFieldValueException6 = new IllegalFieldValueException(dateTimeFieldType0, (Number) 6, (Number) 0.0f, (Number) 100.0f, "");
        PeriodType periodType7 = PeriodType.seconds();
        PeriodType periodType8 = periodType7.withDaysRemoved();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology9 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone10 = ethiopicChronology9.getZone();
        Weeks weeks11 = Weeks.ONE;
        int[] intArray14 = ethiopicChronology9.get((ReadablePeriod) weeks11, (long) (short) 1, 100L);
        DateTimeField dateTimeField15 = ethiopicChronology9.millisOfDay();
        // The following exception was thrown during execution in test generation
        try {
            MutablePeriod mutablePeriod16 = new MutablePeriod((Object) dateTimeFieldType0, periodType7, (Chronology) ethiopicChronology9);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: No period converter found for type: org.joda.time.DateTimeFieldType$StandardDateTimeFieldType");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(dateTimeFieldType0);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "dayOfYear" + "'", str1, "dayOfYear");
        org.junit.Assert.assertNotNull(periodType7);
        org.junit.Assert.assertNotNull(periodType8);
        org.junit.Assert.assertNotNull(ethiopicChronology9);
        org.junit.Assert.assertNotNull(dateTimeZone10);
        org.junit.Assert.assertNotNull(weeks11);
        org.junit.Assert.assertNotNull(intArray14);
        org.junit.Assert.assertArrayEquals(intArray14, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField15);
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test129");
        LocalDate localDate0 = new LocalDate();
        LocalDate localDate2 = localDate0.minusWeeks(3);
        LocalDate.Property property3 = localDate2.monthOfYear();
        LocalDate localDate4 = property3.roundHalfFloorCopy();
        LocalDate localDate5 = new LocalDate();
        DateTimeFieldType dateTimeFieldType6 = DateTimeFieldType.weekyearOfCentury();
        int int7 = localDate5.indexOf(dateTimeFieldType6);
        LocalDate localDate9 = localDate5.withDayOfYear(24);
        int int10 = localDate4.compareTo((ReadablePartial) localDate9);
        LocalDate localDate12 = localDate4.plusMonths((int) (byte) 0);
        org.junit.Assert.assertNotNull(localDate2);
        org.junit.Assert.assertNotNull(property3);
        org.junit.Assert.assertNotNull(localDate4);
        org.junit.Assert.assertNotNull(dateTimeFieldType6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + (-1) + "'", int7 == (-1));
        org.junit.Assert.assertNotNull(localDate9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 1 + "'", int10 == 1);
        org.junit.Assert.assertNotNull(localDate12);
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test130");
        LocalDate localDate0 = new LocalDate();
        LocalDate localDate2 = localDate0.minusWeeks(3);
        LocalDate.Property property3 = localDate2.monthOfYear();
        LocalDate localDate4 = property3.withMinimumValue();
        DateTimeField dateTimeField5 = property3.getField();
        org.junit.Assert.assertNotNull(localDate2);
        org.junit.Assert.assertNotNull(property3);
        org.junit.Assert.assertNotNull(localDate4);
        org.junit.Assert.assertNotNull(dateTimeField5);
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test131");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DateTimeField dateTimeField2 = ethiopicChronology0.minuteOfHour();
        DurationField durationField3 = ethiopicChronology0.eras();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(dateTimeField2);
        org.junit.Assert.assertNotNull(durationField3);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test132");
        DateTimeFieldType dateTimeFieldType0 = DateTimeFieldType.yearOfEra();
        org.junit.Assert.assertNotNull(dateTimeFieldType0);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test133");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        DurationField durationField6 = ethiopicChronology4.hours();
        int int8 = durationField6.getValue(0L);
        DateTimeFieldType dateTimeFieldType9 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField11 = new org.joda.time.field.DividedDateTimeField(dateTimeField3, durationField6, dateTimeFieldType9, (int) '4');
        DurationField durationField12 = dividedDateTimeField11.getDurationField();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType9);
        org.junit.Assert.assertNotNull(durationField12);
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test134");
        Weeks weeks0 = Weeks.THREE;
        MutableInterval mutableInterval3 = new MutableInterval((long) (byte) -1, (long) 1);
        Weeks weeks4 = Weeks.weeksIn((ReadableInterval) mutableInterval3);
        Weeks weeks5 = weeks0.minus(weeks4);
        org.junit.Assert.assertNotNull(weeks0);
        org.junit.Assert.assertNotNull(weeks4);
        org.junit.Assert.assertNotNull(weeks5);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test135");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Object obj2 = null;
        Chronology chronology3 = null;
        Interval interval4 = new Interval(obj2, chronology3);
        Weeks weeks5 = Weeks.ONE;
        Interval interval6 = interval4.withPeriodAfterStart((ReadablePeriod) weeks5);
        int[] intArray9 = ethiopicChronology0.get((ReadablePeriod) weeks5, (long) (short) -1, (long) (short) -1);
        DurationField durationField10 = ethiopicChronology0.years();
        DateTimeField dateTimeField11 = ethiopicChronology0.halfdayOfDay();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks5);
        org.junit.Assert.assertNotNull(interval6);
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertArrayEquals(intArray9, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField10);
        org.junit.Assert.assertNotNull(dateTimeField11);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test136");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        DateTimeZone dateTimeZone3 = null;
        MutableDateTime mutableDateTime4 = new MutableDateTime((long) 10080, dateTimeZone3);
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        DateMidnight dateMidnight8 = new DateMidnight(0L);
        boolean boolean9 = dateMidnight6.isEqual((ReadableInstant) dateMidnight8);
        int int10 = dateMidnight6.getSecondOfDay();
        DateMidnight dateMidnight12 = dateMidnight6.plus((long) 36000000);
        mutableDateTime4.setMillis((ReadableInstant) dateMidnight12);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology16 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone17 = ethiopicChronology16.getZone();
        Weeks weeks18 = Weeks.ONE;
        int[] intArray21 = ethiopicChronology16.get((ReadablePeriod) weeks18, (long) (short) 1, 100L);
        Period period22 = new Period((long) (short) 0, (long) 'a', (Chronology) ethiopicChronology16);
        org.joda.time.format.PeriodFormatter periodFormatter23 = null;
        String str24 = period22.toString(periodFormatter23);
        mutableDateTime4.add((ReadablePeriod) period22, (int) 'a');
        DateMidnight dateMidnight28 = dateMidnight1.withPeriodAdded((ReadablePeriod) period22, 3);
        DurationFieldType durationFieldType29 = null;
        int int30 = period22.get(durationFieldType29);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertNotNull(dateMidnight12);
        org.junit.Assert.assertNotNull(ethiopicChronology16);
        org.junit.Assert.assertNotNull(dateTimeZone17);
        org.junit.Assert.assertNotNull(weeks18);
        org.junit.Assert.assertNotNull(intArray21);
        org.junit.Assert.assertArrayEquals(intArray21, new int[] { 0 });
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "PT0.097S" + "'", str24, "PT0.097S");
        org.junit.Assert.assertNotNull(dateMidnight28);
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 0 + "'", int30 == 0);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test137");
        TimeOfDay timeOfDay0 = new TimeOfDay();
        Weeks weeks1 = Weeks.ONE;
        Period period2 = weeks1.toPeriod();
        TimeOfDay timeOfDay3 = timeOfDay0.minus((ReadablePeriod) weeks1);
        LocalTime localTime4 = new LocalTime((Object) timeOfDay0);
        LocalTime.Property property5 = localTime4.millisOfDay();
        org.junit.Assert.assertNotNull(weeks1);
        org.junit.Assert.assertNotNull(period2);
        org.junit.Assert.assertNotNull(timeOfDay3);
        org.junit.Assert.assertNotNull(property5);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test138");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        Chronology chronology2 = null;
        DateMidnight dateMidnight3 = dateMidnight1.withChronology(chronology2);
        DateMidnight dateMidnight5 = new DateMidnight(0L);
        Hours hours6 = Hours.hoursBetween((ReadableInstant) dateMidnight1, (ReadableInstant) dateMidnight5);
        int int7 = dateMidnight1.getDayOfMonth();
        org.junit.Assert.assertNotNull(dateMidnight3);
        org.junit.Assert.assertNotNull(hours6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 1 + "'", int7 == 1);
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test139");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DateTimeField dateTimeField2 = ethiopicChronology0.minuteOfHour();
        // The following exception was thrown during execution in test generation
        try {
            long long5 = dateTimeField2.setExtended((-210866760000000L), 1920);
            org.junit.Assert.fail("Expected exception of type org.joda.time.chrono.LimitChronology.LimitException; message: The instant is below the supported minimum of 0001-01-01T00:00:00.000Z (EthiopicChronology[UTC])");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(dateTimeField2);
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test140");
        Minutes minutes0 = Minutes.ONE;
        Minutes minutes1 = minutes0.negated();
        org.junit.Assert.assertNotNull(minutes0);
        org.junit.Assert.assertNotNull(minutes1);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test141");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeField dateTimeField1 = ethiopicChronology0.halfdayOfDay();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeField1);
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test142");
        MutableInterval mutableInterval2 = new MutableInterval((long) (byte) -1, (long) 1);
        MutableInterval mutableInterval3 = mutableInterval2.copy();
        DateTimeZone dateTimeZone5 = null;
        MutableDateTime mutableDateTime6 = new MutableDateTime((long) 10080, dateTimeZone5);
        DateMidnight dateMidnight8 = new DateMidnight(0L);
        DateMidnight dateMidnight10 = new DateMidnight(0L);
        boolean boolean11 = dateMidnight8.isEqual((ReadableInstant) dateMidnight10);
        int int12 = dateMidnight8.getSecondOfDay();
        DateMidnight dateMidnight14 = dateMidnight8.plus((long) 36000000);
        mutableDateTime6.setMillis((ReadableInstant) dateMidnight14);
        mutableDateTime6.setYear(60);
        DateTime dateTime18 = new DateTime();
        DateTime.Property property19 = dateTime18.hourOfDay();
        int int20 = dateTime18.getDayOfYear();
        mutableInterval2.setInterval((ReadableInstant) mutableDateTime6, (ReadableInstant) dateTime18);
        // The following exception was thrown during execution in test generation
        try {
            mutableInterval2.setInterval((long) (short) 100, (long) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The end instant must be greater than the start instant");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(mutableInterval3);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(dateMidnight14);
        org.junit.Assert.assertNotNull(property19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 143 + "'", int20 == 143);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test143");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter1 = org.joda.time.format.ISODateTimeFormat.dateHour();
        // The following exception was thrown during execution in test generation
        try {
            MonthDay monthDay2 = MonthDay.parse("0", dateTimeFormatter1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid format: \"0\" is too short");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(dateTimeFormatter1);
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test144");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Months months6 = Months.monthsIn((ReadableInterval) interval5);
        Duration duration7 = interval5.toDuration();
        DateMidnight dateMidnight9 = new DateMidnight(0L);
        PeriodType periodType10 = PeriodType.days();
        MutablePeriod mutablePeriod11 = new MutablePeriod((ReadableDuration) duration7, (ReadableInstant) dateMidnight9, periodType10);
        Interval interval12 = interval2.withStart((ReadableInstant) dateMidnight9);
        Duration duration13 = interval2.toDuration();
        String str14 = interval2.toString();
        org.junit.Assert.assertNotNull(months6);
        org.junit.Assert.assertNotNull(duration7);
        org.junit.Assert.assertNotNull(periodType10);
        org.junit.Assert.assertNotNull(interval12);
        org.junit.Assert.assertNotNull(duration13);
// flaky "6) test144(RegressionTest0)":         org.junit.Assert.assertEquals("'" + str14 + "' != '" + "2025-05-23T18:38:56.233+10:00/2025-05-23T18:38:56.233+10:00" + "'", str14, "2025-05-23T18:38:56.233+10:00/2025-05-23T18:38:56.233+10:00");
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test145");
        Hours hours0 = Hours.SIX;
        Hours hours2 = hours0.minus(36000000);
        // The following exception was thrown during execution in test generation
        try {
            int int4 = hours0.getValue((int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: -1");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(hours0);
        org.junit.Assert.assertNotNull(hours2);
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test146");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        DurationField durationField6 = ethiopicChronology4.hours();
        int int8 = durationField6.getValue(0L);
        DateTimeFieldType dateTimeFieldType9 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField11 = new org.joda.time.field.DividedDateTimeField(dateTimeField3, durationField6, dateTimeFieldType9, (int) '4');
        int int13 = dividedDateTimeField11.getLeapAmount(10L);
        int int15 = dividedDateTimeField11.get(456878073600000L);
        // The following exception was thrown during execution in test generation
        try {
            long long17 = dividedDateTimeField11.roundHalfCeiling(0L);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 0 for clockhourOfDay must be in the range [1,24]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType9);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test147");
        DateTimeZone dateTimeZone1 = null;
        MutableDateTime mutableDateTime2 = new MutableDateTime((long) 10080, dateTimeZone1);
        DateMidnight dateMidnight4 = new DateMidnight(0L);
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        boolean boolean7 = dateMidnight4.isEqual((ReadableInstant) dateMidnight6);
        int int8 = dateMidnight4.getSecondOfDay();
        DateMidnight dateMidnight10 = dateMidnight4.plus((long) 36000000);
        mutableDateTime2.setMillis((ReadableInstant) dateMidnight10);
        // The following exception was thrown during execution in test generation
        try {
            mutableDateTime2.setDateTime(23, 0, 168, (int) (byte) 1, 10, 12, (int) 'a');
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 0 for monthOfYear must be in the range [1,12]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateMidnight10);
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test148");
        // The following exception was thrown during execution in test generation
        try {
            Instant instant1 = Instant.parse("PT0.097S");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid format: \"PT0.097S\"");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test149");
        Period period8 = new Period(0, (int) (byte) -1, 0, 1, 1920, (int) '4', (int) (byte) 1, (int) (byte) -1);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test150");
        DateTimeFieldType dateTimeFieldType0 = DateTimeFieldType.centuryOfEra();
        org.junit.Assert.assertNotNull(dateTimeFieldType0);
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test151");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DateTimeField dateTimeField2 = ethiopicChronology0.minuteOfHour();
        MonthDay monthDay3 = new MonthDay((Chronology) ethiopicChronology0);
        int int4 = monthDay3.getMonthOfYear();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(dateTimeField2);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 9 + "'", int4 == 9);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test152");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter0 = org.joda.time.format.ISODateTimeFormat.yearMonthDay();
        java.io.Writer writer1 = null;
        org.joda.time.chrono.EthiopicChronology ethiopicChronology2 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone3 = ethiopicChronology2.getZone();
        DurationField durationField4 = ethiopicChronology2.hours();
        DateTimeField dateTimeField5 = ethiopicChronology2.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField6 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField5);
        int int8 = delegatedDateTimeField6.get((long) (byte) 10);
        LocalDate localDate9 = new LocalDate();
        LocalDate localDate11 = localDate9.minusWeeks(3);
        LocalDate.Property property12 = localDate11.monthOfYear();
        java.util.Locale locale14 = null;
        String str15 = delegatedDateTimeField6.getAsText((ReadablePartial) localDate11, (int) (byte) 10, locale14);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology16 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone17 = ethiopicChronology16.getZone();
        long long21 = dateTimeZone17.convertLocalToUTC((long) 6, false, 0L);
        YearMonthDay yearMonthDay22 = new YearMonthDay(dateTimeZone17);
        DateTime dateTime23 = localDate11.toDateTimeAtStartOfDay(dateTimeZone17);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology24 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone25 = ethiopicChronology24.getZone();
        DurationField durationField26 = ethiopicChronology24.hours();
        DateTimeField dateTimeField27 = ethiopicChronology24.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology28 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone29 = ethiopicChronology28.getZone();
        DurationField durationField30 = ethiopicChronology28.hours();
        int int32 = durationField30.getValue(0L);
        DateTimeFieldType dateTimeFieldType33 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField35 = new org.joda.time.field.DividedDateTimeField(dateTimeField27, durationField30, dateTimeFieldType33, (int) '4');
        DateTimeFieldType dateTimeFieldType36 = DateTimeFieldType.clockhourOfHalfday();
        org.joda.time.field.OffsetDateTimeField offsetDateTimeField40 = new org.joda.time.field.OffsetDateTimeField((DateTimeField) dividedDateTimeField35, dateTimeFieldType36, 7, 1, 12);
        int int41 = localDate11.indexOf(dateTimeFieldType36);
        // The following exception was thrown during execution in test generation
        try {
            dateTimeFormatter0.printTo(writer1, (ReadablePartial) localDate11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(dateTimeFormatter0);
        org.junit.Assert.assertNotNull(ethiopicChronology2);
        org.junit.Assert.assertNotNull(dateTimeZone3);
        org.junit.Assert.assertNotNull(durationField4);
        org.junit.Assert.assertNotNull(dateTimeField5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 10 + "'", int8 == 10);
        org.junit.Assert.assertNotNull(localDate11);
        org.junit.Assert.assertNotNull(property12);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "10" + "'", str15, "10");
        org.junit.Assert.assertNotNull(ethiopicChronology16);
        org.junit.Assert.assertNotNull(dateTimeZone17);
        org.junit.Assert.assertTrue("'" + long21 + "' != '" + (-35999994L) + "'", long21 == (-35999994L));
        org.junit.Assert.assertNotNull(dateTime23);
        org.junit.Assert.assertNotNull(ethiopicChronology24);
        org.junit.Assert.assertNotNull(dateTimeZone25);
        org.junit.Assert.assertNotNull(durationField26);
        org.junit.Assert.assertNotNull(dateTimeField27);
        org.junit.Assert.assertNotNull(ethiopicChronology28);
        org.junit.Assert.assertNotNull(dateTimeZone29);
        org.junit.Assert.assertNotNull(durationField30);
        org.junit.Assert.assertTrue("'" + int32 + "' != '" + 0 + "'", int32 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType33);
        org.junit.Assert.assertNotNull(dateTimeFieldType36);
        org.junit.Assert.assertTrue("'" + int41 + "' != '" + (-1) + "'", int41 == (-1));
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test153");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Months months6 = Months.monthsIn((ReadableInterval) interval5);
        Duration duration7 = interval5.toDuration();
        DateMidnight dateMidnight9 = new DateMidnight(0L);
        PeriodType periodType10 = PeriodType.days();
        MutablePeriod mutablePeriod11 = new MutablePeriod((ReadableDuration) duration7, (ReadableInstant) dateMidnight9, periodType10);
        Interval interval12 = interval2.withStart((ReadableInstant) dateMidnight9);
        // The following exception was thrown during execution in test generation
        try {
            LocalDate localDate13 = new LocalDate((Object) interval2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: No partial converter found for type: org.joda.time.Interval");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(months6);
        org.junit.Assert.assertNotNull(duration7);
        org.junit.Assert.assertNotNull(periodType10);
        org.junit.Assert.assertNotNull(interval12);
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test154");
        Hours hours0 = Hours.MIN_VALUE;
        // The following exception was thrown during execution in test generation
        try {
            int int2 = hours0.getValue(12);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: 12");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(hours0);
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test155");
        int int0 = MonthDay.MONTH_OF_YEAR;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 0 + "'", int0 == 0);
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test156");
        MutableInterval mutableInterval2 = new MutableInterval((long) (byte) -1, (long) 1);
        MutableInterval mutableInterval3 = mutableInterval2.copy();
        mutableInterval3.setDurationAfterStart((long) (byte) 0);
        Object obj6 = null;
        Chronology chronology7 = null;
        Interval interval8 = new Interval(obj6, chronology7);
        Months months9 = Months.monthsIn((ReadableInterval) interval8);
        Duration duration10 = interval8.toDuration();
        DateMidnight dateMidnight12 = new DateMidnight(0L);
        PeriodType periodType13 = PeriodType.days();
        MutablePeriod mutablePeriod14 = new MutablePeriod((ReadableDuration) duration10, (ReadableInstant) dateMidnight12, periodType13);
        int int15 = mutablePeriod14.getYears();
        Object obj16 = null;
        Chronology chronology17 = null;
        Interval interval18 = new Interval(obj16, chronology17);
        Months months19 = Months.monthsIn((ReadableInterval) interval18);
        Duration duration20 = interval18.toDuration();
        DateMidnight dateMidnight22 = new DateMidnight(0L);
        PeriodType periodType23 = PeriodType.days();
        MutablePeriod mutablePeriod24 = new MutablePeriod((ReadableDuration) duration20, (ReadableInstant) dateMidnight22, periodType23);
        Object obj25 = null;
        Chronology chronology26 = null;
        Interval interval27 = new Interval(obj25, chronology26);
        Months months28 = Months.monthsIn((ReadableInterval) interval27);
        Duration duration29 = interval27.toDuration();
        Object obj30 = null;
        Chronology chronology31 = null;
        Interval interval32 = new Interval(obj30, chronology31);
        Months months33 = Months.monthsIn((ReadableInterval) interval32);
        Duration duration34 = interval32.toDuration();
        boolean boolean35 = duration29.isEqual((ReadableDuration) duration34);
        boolean boolean36 = duration20.isEqual((ReadableDuration) duration34);
        mutablePeriod14.setPeriod((ReadableDuration) duration34);
        mutableInterval3.setDurationAfterStart((ReadableDuration) duration34);
        DateTime dateTime39 = new DateTime();
        DateTimeZone dateTimeZone41 = null;
        MutableDateTime mutableDateTime42 = new MutableDateTime((long) 10080, dateTimeZone41);
        DateMidnight dateMidnight44 = new DateMidnight(0L);
        DateMidnight dateMidnight46 = new DateMidnight(0L);
        boolean boolean47 = dateMidnight44.isEqual((ReadableInstant) dateMidnight46);
        int int48 = dateMidnight44.getSecondOfDay();
        DateMidnight dateMidnight50 = dateMidnight44.plus((long) 36000000);
        mutableDateTime42.setMillis((ReadableInstant) dateMidnight50);
        int int52 = dateMidnight50.getWeekOfWeekyear();
        // The following exception was thrown during execution in test generation
        try {
            mutableInterval3.setInterval((ReadableInstant) dateTime39, (ReadableInstant) dateMidnight50);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The end instant must be greater than the start instant");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(mutableInterval3);
        org.junit.Assert.assertNotNull(months9);
        org.junit.Assert.assertNotNull(duration10);
        org.junit.Assert.assertNotNull(periodType13);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNotNull(months19);
        org.junit.Assert.assertNotNull(duration20);
        org.junit.Assert.assertNotNull(periodType23);
        org.junit.Assert.assertNotNull(months28);
        org.junit.Assert.assertNotNull(duration29);
        org.junit.Assert.assertNotNull(months33);
        org.junit.Assert.assertNotNull(duration34);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + true + "'", boolean35 == true);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + true + "'", boolean47 == true);
        org.junit.Assert.assertTrue("'" + int48 + "' != '" + 0 + "'", int48 == 0);
        org.junit.Assert.assertNotNull(dateMidnight50);
        org.junit.Assert.assertTrue("'" + int52 + "' != '" + 1 + "'", int52 == 1);
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test157");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        DateMidnight dateMidnight3 = new DateMidnight(0L);
        boolean boolean4 = dateMidnight1.isEqual((ReadableInstant) dateMidnight3);
        Object obj5 = null;
        Chronology chronology6 = null;
        Interval interval7 = new Interval(obj5, chronology6);
        Months months8 = Months.monthsIn((ReadableInterval) interval7);
        Duration duration9 = interval7.toDuration();
        DateMidnight dateMidnight11 = new DateMidnight(0L);
        PeriodType periodType12 = PeriodType.days();
        MutablePeriod mutablePeriod13 = new MutablePeriod((ReadableDuration) duration9, (ReadableInstant) dateMidnight11, periodType12);
        Chronology chronology14 = null;
        Period period15 = duration9.toPeriod(chronology14);
        PeriodType periodType16 = PeriodType.yearMonthDayTime();
        MutablePeriod mutablePeriod17 = new MutablePeriod((ReadableInstant) dateMidnight3, (ReadableDuration) duration9, periodType16);
        mutablePeriod17.setSeconds(0);
        DurationFieldType durationFieldType20 = DurationFieldType.weeks();
        // The following exception was thrown during execution in test generation
        try {
            mutablePeriod17.add(durationFieldType20, (int) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Period does not support field 'weeks'");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(months8);
        org.junit.Assert.assertNotNull(duration9);
        org.junit.Assert.assertNotNull(periodType12);
        org.junit.Assert.assertNotNull(period15);
        org.junit.Assert.assertNotNull(periodType16);
        org.junit.Assert.assertNotNull(durationFieldType20);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test158");
        Object obj0 = null;
        PeriodType periodType1 = PeriodType.seconds();
        PeriodType periodType2 = periodType1.withDaysRemoved();
        Period period3 = new Period(obj0, periodType2);
        PeriodType periodType4 = periodType2.withMillisRemoved();
        org.junit.Assert.assertNotNull(periodType1);
        org.junit.Assert.assertNotNull(periodType2);
        org.junit.Assert.assertNotNull(periodType4);
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test159");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField4 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField3);
        int int6 = delegatedDateTimeField4.get((long) (byte) 10);
        java.util.Locale locale8 = null;
        String str9 = delegatedDateTimeField4.getAsShortText((long) (byte) 10, locale8);
        LocalDate localDate10 = new LocalDate();
        LocalDate localDate12 = localDate10.minusWeeks(3);
        LocalDate.Property property13 = localDate12.monthOfYear();
        LocalDate localDate14 = property13.roundHalfFloorCopy();
        LocalDate localDate15 = new LocalDate();
        DateTimeFieldType dateTimeFieldType16 = DateTimeFieldType.weekyearOfCentury();
        int int17 = localDate15.indexOf(dateTimeFieldType16);
        LocalDate localDate19 = localDate15.withDayOfYear(24);
        int int20 = localDate14.compareTo((ReadablePartial) localDate19);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology22 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone23 = ethiopicChronology22.getZone();
        Object obj24 = null;
        Chronology chronology25 = null;
        Interval interval26 = new Interval(obj24, chronology25);
        Weeks weeks27 = Weeks.ONE;
        Interval interval28 = interval26.withPeriodAfterStart((ReadablePeriod) weeks27);
        int[] intArray31 = ethiopicChronology22.get((ReadablePeriod) weeks27, (long) (short) -1, (long) (short) -1);
        DurationField durationField32 = ethiopicChronology22.minutes();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology33 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone34 = ethiopicChronology33.getZone();
        DurationField durationField35 = ethiopicChronology33.hours();
        DateTimeField dateTimeField36 = ethiopicChronology33.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField37 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField36);
        int int39 = delegatedDateTimeField37.get((long) (byte) 10);
        LocalDate localDate40 = new LocalDate();
        LocalDate localDate42 = localDate40.minusWeeks(3);
        LocalDate.Property property43 = localDate42.monthOfYear();
        java.util.Locale locale45 = null;
        String str46 = delegatedDateTimeField37.getAsText((ReadablePartial) localDate42, (int) (byte) 10, locale45);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology47 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone48 = ethiopicChronology47.getZone();
        long long52 = dateTimeZone48.convertLocalToUTC((long) 6, false, 0L);
        YearMonthDay yearMonthDay53 = new YearMonthDay(dateTimeZone48);
        DateTime dateTime54 = localDate42.toDateTimeAtStartOfDay(dateTimeZone48);
        LocalDate localDate56 = localDate42.withWeekyear(1);
        int[] intArray58 = ethiopicChronology22.get((ReadablePartial) localDate42, (long) 24);
        // The following exception was thrown during execution in test generation
        try {
            int[] intArray60 = delegatedDateTimeField4.addWrapPartial((ReadablePartial) localDate14, 10, intArray58, 9);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 10");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "10" + "'", str9, "10");
        org.junit.Assert.assertNotNull(localDate12);
        org.junit.Assert.assertNotNull(property13);
        org.junit.Assert.assertNotNull(localDate14);
        org.junit.Assert.assertNotNull(dateTimeFieldType16);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + (-1) + "'", int17 == (-1));
        org.junit.Assert.assertNotNull(localDate19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 1 + "'", int20 == 1);
        org.junit.Assert.assertNotNull(ethiopicChronology22);
        org.junit.Assert.assertNotNull(dateTimeZone23);
        org.junit.Assert.assertNotNull(weeks27);
        org.junit.Assert.assertNotNull(interval28);
        org.junit.Assert.assertNotNull(intArray31);
        org.junit.Assert.assertArrayEquals(intArray31, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField32);
        org.junit.Assert.assertNotNull(ethiopicChronology33);
        org.junit.Assert.assertNotNull(dateTimeZone34);
        org.junit.Assert.assertNotNull(durationField35);
        org.junit.Assert.assertNotNull(dateTimeField36);
        org.junit.Assert.assertTrue("'" + int39 + "' != '" + 10 + "'", int39 == 10);
        org.junit.Assert.assertNotNull(localDate42);
        org.junit.Assert.assertNotNull(property43);
        org.junit.Assert.assertEquals("'" + str46 + "' != '" + "10" + "'", str46, "10");
        org.junit.Assert.assertNotNull(ethiopicChronology47);
        org.junit.Assert.assertNotNull(dateTimeZone48);
        org.junit.Assert.assertTrue("'" + long52 + "' != '" + (-35999994L) + "'", long52 == (-35999994L));
        org.junit.Assert.assertNotNull(dateTime54);
        org.junit.Assert.assertNotNull(localDate56);
        org.junit.Assert.assertNotNull(intArray58);
        org.junit.Assert.assertArrayEquals(intArray58, new int[] { 1962, 4, 23 });
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test160");
        DateTime dateTime0 = new DateTime();
        DateTime.Property property1 = dateTime0.hourOfDay();
        DateTime dateTime3 = dateTime0.withWeekyear(7);
        DateTime.Property property4 = dateTime3.dayOfYear();
        org.junit.Assert.assertNotNull(property1);
        org.junit.Assert.assertNotNull(dateTime3);
        org.junit.Assert.assertNotNull(property4);
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test161");
        Period period1 = Period.minutes((int) (short) 10);
        org.junit.Assert.assertNotNull(period1);
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test162");
        int int0 = DateTimeConstants.MILLIS_PER_SECOND;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1000 + "'", int0 == 1000);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test163");
        // The following exception was thrown during execution in test generation
        try {
            org.joda.time.field.FieldUtils.verifyValueBounds("2025-05-23T18:38:20.565+10:00", 24, 4, 6);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 24 for 2025-05-23T18:38:20.565+10:00 must be in the range [4,6]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test164");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        org.joda.time.chrono.CopticChronology copticChronology2 = org.joda.time.chrono.CopticChronology.getInstance(dateTimeZone1);
        LocalDateTime localDateTime3 = LocalDateTime.now(dateTimeZone1);
        // The following exception was thrown during execution in test generation
        try {
            MutableInterval mutableInterval4 = new MutableInterval((Object) localDateTime3);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: No interval converter found for type: org.joda.time.LocalDateTime");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(copticChronology2);
        org.junit.Assert.assertNotNull(localDateTime3);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test165");
        MutableInterval mutableInterval0 = new MutableInterval();
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test166");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Object obj2 = null;
        Chronology chronology3 = null;
        Interval interval4 = new Interval(obj2, chronology3);
        Weeks weeks5 = Weeks.ONE;
        Interval interval6 = interval4.withPeriodAfterStart((ReadablePeriod) weeks5);
        int[] intArray9 = ethiopicChronology0.get((ReadablePeriod) weeks5, (long) (short) -1, (long) (short) -1);
        DurationField durationField10 = ethiopicChronology0.years();
        DateTimeField dateTimeField11 = ethiopicChronology0.halfdayOfDay();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks5);
        org.junit.Assert.assertNotNull(interval6);
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertArrayEquals(intArray9, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField10);
        org.junit.Assert.assertNotNull(dateTimeField11);
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test167");
        MutableInterval mutableInterval2 = new MutableInterval((long) (byte) -1, (long) 1);
        Weeks weeks3 = Weeks.weeksIn((ReadableInterval) mutableInterval2);
        Period period4 = mutableInterval2.toPeriod();
        Period period6 = period4.withSeconds(143);
        org.junit.Assert.assertNotNull(weeks3);
        org.junit.Assert.assertNotNull(period4);
        org.junit.Assert.assertNotNull(period6);
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test168");
        DateTimeUtils.MillisProvider millisProvider0 = DateTimeUtils.SYSTEM_MILLIS_PROVIDER;
        // The following exception was thrown during execution in test generation
        try {
            TimeOfDay timeOfDay1 = new TimeOfDay((Object) millisProvider0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: No partial converter found for type: org.joda.time.DateTimeUtils$SystemMillisProvider");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(millisProvider0);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test169");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter1 = org.joda.time.format.ISODateTimeFormat.localTimeParser();
        // The following exception was thrown during execution in test generation
        try {
            MutableDateTime mutableDateTime2 = MutableDateTime.parse("millis", dateTimeFormatter1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid format: \"millis\"");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(dateTimeFormatter1);
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test170");
        DateTimeZone dateTimeZone1 = null;
        MutableDateTime mutableDateTime2 = new MutableDateTime((long) 10080, dateTimeZone1);
        DateMidnight dateMidnight4 = new DateMidnight(0L);
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        boolean boolean7 = dateMidnight4.isEqual((ReadableInstant) dateMidnight6);
        int int8 = dateMidnight4.getSecondOfDay();
        DateMidnight dateMidnight10 = dateMidnight4.plus((long) 36000000);
        mutableDateTime2.setMillis((ReadableInstant) dateMidnight10);
        mutableDateTime2.setYear(60);
        // The following exception was thrown during execution in test generation
        try {
            mutableDateTime2.setDayOfMonth(0);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 0 for dayOfMonth must be in the range [1,31]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateMidnight10);
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test171");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        DurationField durationField6 = ethiopicChronology4.hours();
        int int8 = durationField6.getValue(0L);
        DateTimeFieldType dateTimeFieldType9 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField11 = new org.joda.time.field.DividedDateTimeField(dateTimeField3, durationField6, dateTimeFieldType9, (int) '4');
        java.util.Locale locale13 = null;
        String str14 = dividedDateTimeField11.getAsText((long) (-1), locale13);
        ReadablePartial readablePartial15 = null;
        org.joda.time.chrono.EthiopicChronology ethiopicChronology17 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone18 = ethiopicChronology17.getZone();
        Object obj19 = null;
        Chronology chronology20 = null;
        Interval interval21 = new Interval(obj19, chronology20);
        Weeks weeks22 = Weeks.ONE;
        Interval interval23 = interval21.withPeriodAfterStart((ReadablePeriod) weeks22);
        int[] intArray26 = ethiopicChronology17.get((ReadablePeriod) weeks22, (long) (short) -1, (long) (short) -1);
        DurationField durationField27 = ethiopicChronology17.minutes();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology28 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone29 = ethiopicChronology28.getZone();
        DurationField durationField30 = ethiopicChronology28.hours();
        DateTimeField dateTimeField31 = ethiopicChronology28.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField32 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField31);
        int int34 = delegatedDateTimeField32.get((long) (byte) 10);
        LocalDate localDate35 = new LocalDate();
        LocalDate localDate37 = localDate35.minusWeeks(3);
        LocalDate.Property property38 = localDate37.monthOfYear();
        java.util.Locale locale40 = null;
        String str41 = delegatedDateTimeField32.getAsText((ReadablePartial) localDate37, (int) (byte) 10, locale40);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology42 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone43 = ethiopicChronology42.getZone();
        long long47 = dateTimeZone43.convertLocalToUTC((long) 6, false, 0L);
        YearMonthDay yearMonthDay48 = new YearMonthDay(dateTimeZone43);
        DateTime dateTime49 = localDate37.toDateTimeAtStartOfDay(dateTimeZone43);
        LocalDate localDate51 = localDate37.withWeekyear(1);
        int[] intArray53 = ethiopicChronology17.get((ReadablePartial) localDate37, (long) 24);
        // The following exception was thrown during execution in test generation
        try {
            int[] intArray55 = dividedDateTimeField11.add(readablePartial15, 10080, intArray53, 1920);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 10080");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType9);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertNotNull(ethiopicChronology17);
        org.junit.Assert.assertNotNull(dateTimeZone18);
        org.junit.Assert.assertNotNull(weeks22);
        org.junit.Assert.assertNotNull(interval23);
        org.junit.Assert.assertNotNull(intArray26);
        org.junit.Assert.assertArrayEquals(intArray26, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField27);
        org.junit.Assert.assertNotNull(ethiopicChronology28);
        org.junit.Assert.assertNotNull(dateTimeZone29);
        org.junit.Assert.assertNotNull(durationField30);
        org.junit.Assert.assertNotNull(dateTimeField31);
        org.junit.Assert.assertTrue("'" + int34 + "' != '" + 10 + "'", int34 == 10);
        org.junit.Assert.assertNotNull(localDate37);
        org.junit.Assert.assertNotNull(property38);
        org.junit.Assert.assertEquals("'" + str41 + "' != '" + "10" + "'", str41, "10");
        org.junit.Assert.assertNotNull(ethiopicChronology42);
        org.junit.Assert.assertNotNull(dateTimeZone43);
        org.junit.Assert.assertTrue("'" + long47 + "' != '" + (-35999994L) + "'", long47 == (-35999994L));
        org.junit.Assert.assertNotNull(dateTime49);
        org.junit.Assert.assertNotNull(localDate51);
        org.junit.Assert.assertNotNull(intArray53);
        org.junit.Assert.assertArrayEquals(intArray53, new int[] { 1962, 4, 23 });
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test172");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        Weeks weeks3 = Weeks.ONE;
        int[] intArray6 = ethiopicChronology1.get((ReadablePeriod) weeks3, (long) (short) 1, 100L);
        DateTimeField dateTimeField7 = ethiopicChronology1.millisOfDay();
        TimeOfDay timeOfDay8 = new TimeOfDay((long) (short) 10, (Chronology) ethiopicChronology1);
        LocalTime localTime9 = timeOfDay8.toLocalTime();
        int int10 = localTime9.getMillisOfSecond();
        LocalTime.Property property11 = localTime9.millisOfDay();
        LocalTime localTime13 = property11.addNoWrapToCopy(60);
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(weeks3);
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertArrayEquals(intArray6, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField7);
        org.junit.Assert.assertNotNull(localTime9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 10 + "'", int10 == 10);
        org.junit.Assert.assertNotNull(property11);
        org.junit.Assert.assertNotNull(localTime13);
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test173");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        Duration duration4 = interval2.toDuration();
        String str5 = duration4.toString();
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertNotNull(duration4);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "PT0S" + "'", str5, "PT0S");
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test174");
        LocalTime localTime1 = LocalTime.fromMillisOfDay((-35999994L));
        org.junit.Assert.assertNotNull(localTime1);
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test175");
        LocalDate localDate0 = new LocalDate();
        LocalDate localDate2 = localDate0.minusWeeks(3);
        LocalDate.Property property3 = localDate2.monthOfYear();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology5 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone6 = ethiopicChronology5.getZone();
        Object obj7 = null;
        Chronology chronology8 = null;
        Interval interval9 = new Interval(obj7, chronology8);
        Weeks weeks10 = Weeks.ONE;
        Interval interval11 = interval9.withPeriodAfterStart((ReadablePeriod) weeks10);
        int[] intArray14 = ethiopicChronology5.get((ReadablePeriod) weeks10, (long) (short) -1, (long) (short) -1);
        DurationField durationField15 = ethiopicChronology5.minutes();
        YearMonthDay yearMonthDay16 = new YearMonthDay(100L, (Chronology) ethiopicChronology5);
        DateTimeField dateTimeField17 = ethiopicChronology5.minuteOfDay();
        DateTimeField dateTimeField18 = ethiopicChronology5.dayOfMonth();
        DateTimeZone dateTimeZone19 = ethiopicChronology5.getZone();
        // The following exception was thrown during execution in test generation
        try {
            LocalTime localTime20 = new LocalTime((Object) localDate2, dateTimeZone19);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Field 'hourOfDay' is not supported");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(localDate2);
        org.junit.Assert.assertNotNull(property3);
        org.junit.Assert.assertNotNull(ethiopicChronology5);
        org.junit.Assert.assertNotNull(dateTimeZone6);
        org.junit.Assert.assertNotNull(weeks10);
        org.junit.Assert.assertNotNull(interval11);
        org.junit.Assert.assertNotNull(intArray14);
        org.junit.Assert.assertArrayEquals(intArray14, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField15);
        org.junit.Assert.assertNotNull(dateTimeField17);
        org.junit.Assert.assertNotNull(dateTimeField18);
        org.junit.Assert.assertNotNull(dateTimeZone19);
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test176");
        java.util.Set<String> strSet0 = DateTimeZone.getAvailableIDs();
        org.junit.Assert.assertNotNull(strSet0);
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test177");
        // The following exception was thrown during execution in test generation
        try {
            Interval interval1 = Interval.parseWithOffset("PT0.097S");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Format requires a '/' separator: PT0.097S");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test178");
        MutableInterval mutableInterval2 = new MutableInterval((long) (byte) -1, (long) 1);
        MutableInterval mutableInterval3 = mutableInterval2.copy();
        mutableInterval3.setDurationAfterStart((long) (byte) 0);
        Object obj6 = null;
        Chronology chronology7 = null;
        Interval interval8 = new Interval(obj6, chronology7);
        Months months9 = Months.monthsIn((ReadableInterval) interval8);
        Duration duration10 = interval8.toDuration();
        DateMidnight dateMidnight12 = new DateMidnight(0L);
        PeriodType periodType13 = PeriodType.days();
        MutablePeriod mutablePeriod14 = new MutablePeriod((ReadableDuration) duration10, (ReadableInstant) dateMidnight12, periodType13);
        int int15 = mutablePeriod14.getYears();
        Object obj16 = null;
        Chronology chronology17 = null;
        Interval interval18 = new Interval(obj16, chronology17);
        Months months19 = Months.monthsIn((ReadableInterval) interval18);
        Duration duration20 = interval18.toDuration();
        DateMidnight dateMidnight22 = new DateMidnight(0L);
        PeriodType periodType23 = PeriodType.days();
        MutablePeriod mutablePeriod24 = new MutablePeriod((ReadableDuration) duration20, (ReadableInstant) dateMidnight22, periodType23);
        Object obj25 = null;
        Chronology chronology26 = null;
        Interval interval27 = new Interval(obj25, chronology26);
        Months months28 = Months.monthsIn((ReadableInterval) interval27);
        Duration duration29 = interval27.toDuration();
        Object obj30 = null;
        Chronology chronology31 = null;
        Interval interval32 = new Interval(obj30, chronology31);
        Months months33 = Months.monthsIn((ReadableInterval) interval32);
        Duration duration34 = interval32.toDuration();
        boolean boolean35 = duration29.isEqual((ReadableDuration) duration34);
        boolean boolean36 = duration20.isEqual((ReadableDuration) duration34);
        mutablePeriod14.setPeriod((ReadableDuration) duration34);
        mutableInterval3.setDurationAfterStart((ReadableDuration) duration34);
        MutableInterval mutableInterval39 = mutableInterval3.copy();
        DateTime dateTime40 = mutableInterval39.getStart();
        long long41 = mutableInterval39.getEndMillis();
        org.junit.Assert.assertNotNull(mutableInterval3);
        org.junit.Assert.assertNotNull(months9);
        org.junit.Assert.assertNotNull(duration10);
        org.junit.Assert.assertNotNull(periodType13);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNotNull(months19);
        org.junit.Assert.assertNotNull(duration20);
        org.junit.Assert.assertNotNull(periodType23);
        org.junit.Assert.assertNotNull(months28);
        org.junit.Assert.assertNotNull(duration29);
        org.junit.Assert.assertNotNull(months33);
        org.junit.Assert.assertNotNull(duration34);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + true + "'", boolean35 == true);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        org.junit.Assert.assertNotNull(mutableInterval39);
        org.junit.Assert.assertNotNull(dateTime40);
        org.junit.Assert.assertTrue("'" + long41 + "' != '" + (-1L) + "'", long41 == (-1L));
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test179");
        // The following exception was thrown during execution in test generation
        try {
            LocalDate localDate3 = new LocalDate(24, 6, (int) (short) 100);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 100 for dayOfMonth must be in the range [1,30]: year: 24 month: 6");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test180");
        MutablePeriod mutablePeriod8 = new MutablePeriod(10, (int) (byte) -1, 0, (-1), 1, (int) (short) 100, 12, (-1));
        mutablePeriod8.setYears((int) (byte) 0);
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test181");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology2 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone3 = ethiopicChronology2.getZone();
        long long7 = dateTimeZone3.convertLocalToUTC((long) 6, false, 0L);
        LocalDate localDate8 = new LocalDate(dateTimeZone3);
        int int10 = dateTimeZone3.getOffset((long) '#');
        // The following exception was thrown during execution in test generation
        try {
            Interval interval11 = new Interval((long) 60, (-36000000L), dateTimeZone3);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The end instant must be greater than the start instant");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology2);
        org.junit.Assert.assertNotNull(dateTimeZone3);
        org.junit.Assert.assertTrue("'" + long7 + "' != '" + (-35999994L) + "'", long7 == (-35999994L));
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 36000000 + "'", int10 == 36000000);
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test182");
        LocalDate localDate0 = new LocalDate();
        DateTimeFieldType dateTimeFieldType1 = DateTimeFieldType.weekyearOfCentury();
        int int2 = localDate0.indexOf(dateTimeFieldType1);
        DurationFieldType durationFieldType3 = DurationFieldType.weeks();
        boolean boolean4 = localDate0.isSupported(durationFieldType3);
        org.junit.Assert.assertNotNull(dateTimeFieldType1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
        org.junit.Assert.assertNotNull(durationFieldType3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test183");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology2 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone3 = ethiopicChronology2.getZone();
        org.joda.time.chrono.CopticChronology copticChronology4 = org.joda.time.chrono.CopticChronology.getInstance(dateTimeZone3);
        LocalDateTime localDateTime5 = LocalDateTime.now(dateTimeZone3);
        // The following exception was thrown during execution in test generation
        try {
            Interval interval6 = new Interval(456878073600000L, (long) 36000000, dateTimeZone3);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The end instant must be greater than the start instant");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology2);
        org.junit.Assert.assertNotNull(dateTimeZone3);
        org.junit.Assert.assertNotNull(copticChronology4);
        org.junit.Assert.assertNotNull(localDateTime5);
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test184");
        int int0 = DateTimeConstants.SUNDAY;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 7 + "'", int0 == 7);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test185");
        MutableDateTime mutableDateTime0 = MutableDateTime.now();
        // The following exception was thrown during execution in test generation
        try {
            mutableDateTime0.setMonthOfYear((int) (short) -1);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value -1 for monthOfYear must be in the range [1,12]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(mutableDateTime0);
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test186");
        Months months0 = Months.MAX_VALUE;
        Object obj1 = null;
        Chronology chronology2 = null;
        Interval interval3 = new Interval(obj1, chronology2);
        Months months4 = Months.monthsIn((ReadableInterval) interval3);
        boolean boolean5 = months0.isGreaterThan(months4);
        DurationFieldType durationFieldType6 = DurationFieldType.months();
        boolean boolean7 = months0.isSupported(durationFieldType6);
        LocalDate localDate8 = new LocalDate();
        DateTimeFieldType dateTimeFieldType9 = DateTimeFieldType.weekyearOfCentury();
        int int10 = localDate8.indexOf(dateTimeFieldType9);
        DurationFieldType durationFieldType11 = DurationFieldType.weeks();
        boolean boolean12 = localDate8.isSupported(durationFieldType11);
        Months months13 = Months.MAX_VALUE;
        Object obj14 = null;
        Chronology chronology15 = null;
        Interval interval16 = new Interval(obj14, chronology15);
        Months months17 = Months.monthsIn((ReadableInterval) interval16);
        boolean boolean18 = months13.isGreaterThan(months17);
        DurationFieldType durationFieldType19 = DurationFieldType.months();
        boolean boolean20 = months13.isSupported(durationFieldType19);
        String str21 = durationFieldType19.getName();
        LocalDate localDate22 = new LocalDate();
        DateTimeFieldType dateTimeFieldType23 = DateTimeFieldType.weekyearOfCentury();
        int int24 = localDate22.indexOf(dateTimeFieldType23);
        DurationFieldType durationFieldType25 = DurationFieldType.weeks();
        boolean boolean26 = localDate22.isSupported(durationFieldType25);
        DateTimeZone dateTimeZone28 = null;
        MutableDateTime mutableDateTime29 = new MutableDateTime((long) 10080, dateTimeZone28);
        DateMidnight dateMidnight31 = new DateMidnight(0L);
        DateMidnight dateMidnight33 = new DateMidnight(0L);
        boolean boolean34 = dateMidnight31.isEqual((ReadableInstant) dateMidnight33);
        int int35 = dateMidnight31.getSecondOfDay();
        DateMidnight dateMidnight37 = dateMidnight31.plus((long) 36000000);
        mutableDateTime29.setMillis((ReadableInstant) dateMidnight37);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology41 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone42 = ethiopicChronology41.getZone();
        Weeks weeks43 = Weeks.ONE;
        int[] intArray46 = ethiopicChronology41.get((ReadablePeriod) weeks43, (long) (short) 1, 100L);
        Period period47 = new Period((long) (short) 0, (long) 'a', (Chronology) ethiopicChronology41);
        org.joda.time.format.PeriodFormatter periodFormatter48 = null;
        String str49 = period47.toString(periodFormatter48);
        mutableDateTime29.add((ReadablePeriod) period47, (int) 'a');
        DurationFieldType durationFieldType52 = DurationFieldType.years();
        mutableDateTime29.add(durationFieldType52, (int) (short) 1);
        DurationFieldType[] durationFieldTypeArray55 = new DurationFieldType[] { durationFieldType6, durationFieldType11, durationFieldType19, durationFieldType25, durationFieldType52 };
        // The following exception was thrown during execution in test generation
        try {
            PeriodType periodType56 = PeriodType.forFields(durationFieldTypeArray55);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: PeriodType does not support fields: [months, weeks]");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(months0);
        org.junit.Assert.assertNotNull(months4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(durationFieldType6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNotNull(dateTimeFieldType9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + (-1) + "'", int10 == (-1));
        org.junit.Assert.assertNotNull(durationFieldType11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertNotNull(months13);
        org.junit.Assert.assertNotNull(months17);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertNotNull(durationFieldType19);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "months" + "'", str21, "months");
        org.junit.Assert.assertNotNull(dateTimeFieldType23);
        org.junit.Assert.assertTrue("'" + int24 + "' != '" + (-1) + "'", int24 == (-1));
        org.junit.Assert.assertNotNull(durationFieldType25);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + true + "'", boolean26 == true);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + true + "'", boolean34 == true);
        org.junit.Assert.assertTrue("'" + int35 + "' != '" + 0 + "'", int35 == 0);
        org.junit.Assert.assertNotNull(dateMidnight37);
        org.junit.Assert.assertNotNull(ethiopicChronology41);
        org.junit.Assert.assertNotNull(dateTimeZone42);
        org.junit.Assert.assertNotNull(weeks43);
        org.junit.Assert.assertNotNull(intArray46);
        org.junit.Assert.assertArrayEquals(intArray46, new int[] { 0 });
        org.junit.Assert.assertEquals("'" + str49 + "' != '" + "PT0.097S" + "'", str49, "PT0.097S");
        org.junit.Assert.assertNotNull(durationFieldType52);
        org.junit.Assert.assertNotNull(durationFieldTypeArray55);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test187");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Weeks weeks3 = Weeks.ONE;
        Interval interval4 = interval2.withPeriodAfterStart((ReadablePeriod) weeks3);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology5 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone6 = ethiopicChronology5.getZone();
        long long10 = dateTimeZone6.convertLocalToUTC((long) 6, false, 0L);
        LocalDate localDate11 = new LocalDate(dateTimeZone6);
        // The following exception was thrown during execution in test generation
        try {
            LocalDateTime localDateTime12 = new LocalDateTime((Object) interval2, dateTimeZone6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: No partial converter found for type: org.joda.time.Interval");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(weeks3);
        org.junit.Assert.assertNotNull(interval4);
        org.junit.Assert.assertNotNull(ethiopicChronology5);
        org.junit.Assert.assertNotNull(dateTimeZone6);
        org.junit.Assert.assertTrue("'" + long10 + "' != '" + (-35999994L) + "'", long10 == (-35999994L));
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test188");
        TimeOfDay timeOfDay0 = new TimeOfDay();
        Weeks weeks1 = Weeks.ONE;
        Period period2 = weeks1.toPeriod();
        TimeOfDay timeOfDay3 = timeOfDay0.minus((ReadablePeriod) weeks1);
        LocalTime localTime4 = new LocalTime((Object) timeOfDay0);
        DateTimeFieldType dateTimeFieldType5 = DateTimeFieldType.year();
        // The following exception was thrown during execution in test generation
        try {
            int int6 = localTime4.get(dateTimeFieldType5);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Field 'year' is not supported");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(weeks1);
        org.junit.Assert.assertNotNull(period2);
        org.junit.Assert.assertNotNull(timeOfDay3);
        org.junit.Assert.assertNotNull(dateTimeFieldType5);
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test189");
        org.joda.time.chrono.CopticChronology copticChronology0 = org.joda.time.chrono.CopticChronology.getInstanceUTC();
        DateTimeField dateTimeField1 = copticChronology0.year();
        TimeOfDay timeOfDay2 = new TimeOfDay();
        Weeks weeks3 = Weeks.ONE;
        Period period4 = weeks3.toPeriod();
        TimeOfDay timeOfDay5 = timeOfDay2.minus((ReadablePeriod) weeks3);
        LocalTime localTime6 = new LocalTime((Object) timeOfDay2);
        String str7 = localTime6.toString();
        int[] intArray9 = copticChronology0.get((ReadablePartial) localTime6, (long) 5);
        DateTimeField dateTimeField10 = copticChronology0.minuteOfDay();
        org.junit.Assert.assertNotNull(copticChronology0);
        org.junit.Assert.assertNotNull(dateTimeField1);
        org.junit.Assert.assertNotNull(weeks3);
        org.junit.Assert.assertNotNull(period4);
        org.junit.Assert.assertNotNull(timeOfDay5);
// flaky "7) test189(RegressionTest0)":         org.junit.Assert.assertEquals("'" + str7 + "' != '" + "18:39:08.350" + "'", str7, "18:39:08.350");
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertArrayEquals(intArray9, new int[] { 0, 0, 0, 5 });
        org.junit.Assert.assertNotNull(dateTimeField10);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test190");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter0 = org.joda.time.format.ISODateTimeFormat.localTimeParser();
        StringBuffer stringBuffer1 = null;
        // The following exception was thrown during execution in test generation
        try {
            dateTimeFormatter0.printTo(stringBuffer1, (long) 1970);
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: Printing not supported");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(dateTimeFormatter0);
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test191");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology3 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone4 = ethiopicChronology3.getZone();
        Object obj5 = null;
        Chronology chronology6 = null;
        Interval interval7 = new Interval(obj5, chronology6);
        Weeks weeks8 = Weeks.ONE;
        Interval interval9 = interval7.withPeriodAfterStart((ReadablePeriod) weeks8);
        int[] intArray12 = ethiopicChronology3.get((ReadablePeriod) weeks8, (long) (short) -1, (long) (short) -1);
        DurationField durationField13 = ethiopicChronology3.minutes();
        DateTimeField dateTimeField14 = ethiopicChronology3.clockhourOfDay();
        // The following exception was thrown during execution in test generation
        try {
            DateMidnight dateMidnight15 = new DateMidnight((int) (byte) -1, (int) (short) -1, 7, (Chronology) ethiopicChronology3);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value -1 for monthOfYear must be in the range [1,13]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology3);
        org.junit.Assert.assertNotNull(dateTimeZone4);
        org.junit.Assert.assertNotNull(weeks8);
        org.junit.Assert.assertNotNull(interval9);
        org.junit.Assert.assertNotNull(intArray12);
        org.junit.Assert.assertArrayEquals(intArray12, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField13);
        org.junit.Assert.assertNotNull(dateTimeField14);
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test192");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Weeks weeks6 = Weeks.ONE;
        Interval interval7 = interval5.withPeriodAfterStart((ReadablePeriod) weeks6);
        int[] intArray10 = ethiopicChronology1.get((ReadablePeriod) weeks6, (long) (short) -1, (long) (short) -1);
        DurationField durationField11 = ethiopicChronology1.minutes();
        YearMonthDay yearMonthDay12 = new YearMonthDay(100L, (Chronology) ethiopicChronology1);
        YearMonthDay.Property property13 = yearMonthDay12.monthOfYear();
        // The following exception was thrown during execution in test generation
        try {
            YearMonthDay yearMonthDay15 = property13.setCopy((int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value -1 for monthOfYear must be in the range [1,13]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(weeks6);
        org.junit.Assert.assertNotNull(interval7);
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField11);
        org.junit.Assert.assertNotNull(property13);
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test193");
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder0 = new org.joda.time.format.DateTimeFormatterBuilder();
        // The following exception was thrown during execution in test generation
        try {
            org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder3 = dateTimeFormatterBuilder0.appendYearOfCentury((int) (short) -1, 24);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test194");
        ReadablePeriod readablePeriod0 = null;
        org.joda.time.chrono.EthiopicChronology ethiopicChronology2 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone3 = ethiopicChronology2.getZone();
        Object obj4 = null;
        Chronology chronology5 = null;
        Interval interval6 = new Interval(obj4, chronology5);
        Weeks weeks7 = Weeks.ONE;
        Interval interval8 = interval6.withPeriodAfterStart((ReadablePeriod) weeks7);
        int[] intArray11 = ethiopicChronology2.get((ReadablePeriod) weeks7, (long) (short) -1, (long) (short) -1);
        DurationField durationField12 = ethiopicChronology2.minutes();
        YearMonthDay yearMonthDay13 = new YearMonthDay(100L, (Chronology) ethiopicChronology2);
        DateTime dateTime14 = yearMonthDay13.toDateTimeAtMidnight();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology15 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone16 = ethiopicChronology15.getZone();
        long long20 = dateTimeZone16.convertLocalToUTC((long) 6, false, 0L);
        LocalDate localDate21 = new LocalDate(dateTimeZone16);
        int int23 = dateTimeZone16.getOffset((long) '#');
        DateTime dateTime24 = yearMonthDay13.toDateTimeAtCurrentTime(dateTimeZone16);
        MutableInterval mutableInterval25 = new MutableInterval(readablePeriod0, (ReadableInstant) dateTime24);
        org.junit.Assert.assertNotNull(ethiopicChronology2);
        org.junit.Assert.assertNotNull(dateTimeZone3);
        org.junit.Assert.assertNotNull(weeks7);
        org.junit.Assert.assertNotNull(interval8);
        org.junit.Assert.assertNotNull(intArray11);
        org.junit.Assert.assertArrayEquals(intArray11, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField12);
        org.junit.Assert.assertNotNull(dateTime14);
        org.junit.Assert.assertNotNull(ethiopicChronology15);
        org.junit.Assert.assertNotNull(dateTimeZone16);
        org.junit.Assert.assertTrue("'" + long20 + "' != '" + (-35999994L) + "'", long20 == (-35999994L));
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + 36000000 + "'", int23 == 36000000);
        org.junit.Assert.assertNotNull(dateTime24);
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test195");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        DateMidnight dateMidnight3 = new DateMidnight(0L);
        boolean boolean4 = dateMidnight1.isEqual((ReadableInstant) dateMidnight3);
        Object obj5 = null;
        Chronology chronology6 = null;
        Interval interval7 = new Interval(obj5, chronology6);
        Months months8 = Months.monthsIn((ReadableInterval) interval7);
        Duration duration9 = interval7.toDuration();
        DateMidnight dateMidnight11 = new DateMidnight(0L);
        PeriodType periodType12 = PeriodType.days();
        MutablePeriod mutablePeriod13 = new MutablePeriod((ReadableDuration) duration9, (ReadableInstant) dateMidnight11, periodType12);
        Chronology chronology14 = null;
        Period period15 = duration9.toPeriod(chronology14);
        PeriodType periodType16 = PeriodType.yearMonthDayTime();
        MutablePeriod mutablePeriod17 = new MutablePeriod((ReadableInstant) dateMidnight3, (ReadableDuration) duration9, periodType16);
        mutablePeriod17.setSeconds(0);
        mutablePeriod17.setDays((-1));
        mutablePeriod17.addSeconds(0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(months8);
        org.junit.Assert.assertNotNull(duration9);
        org.junit.Assert.assertNotNull(periodType12);
        org.junit.Assert.assertNotNull(period15);
        org.junit.Assert.assertNotNull(periodType16);
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test196");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        Duration duration4 = interval2.toDuration();
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        PeriodType periodType7 = PeriodType.days();
        MutablePeriod mutablePeriod8 = new MutablePeriod((ReadableDuration) duration4, (ReadableInstant) dateMidnight6, periodType7);
        Chronology chronology9 = null;
        Period period10 = duration4.toPeriod(chronology9);
        Object obj11 = null;
        Chronology chronology12 = null;
        Interval interval13 = new Interval(obj11, chronology12);
        Months months14 = Months.monthsIn((ReadableInterval) interval13);
        Duration duration15 = interval13.toDuration();
        DateMidnight dateMidnight17 = new DateMidnight(0L);
        PeriodType periodType18 = PeriodType.days();
        MutablePeriod mutablePeriod19 = new MutablePeriod((ReadableDuration) duration15, (ReadableInstant) dateMidnight17, periodType18);
        boolean boolean20 = duration4.isShorterThan((ReadableDuration) duration15);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology21 = org.joda.time.chrono.EthiopicChronology.getInstance();
        Period period22 = new Period((Object) duration4, (Chronology) ethiopicChronology21);
        Months months23 = Months.MAX_VALUE;
        Months months24 = Months.MAX_VALUE;
        Object obj25 = null;
        Chronology chronology26 = null;
        Interval interval27 = new Interval(obj25, chronology26);
        Months months28 = Months.monthsIn((ReadableInterval) interval27);
        boolean boolean29 = months24.isGreaterThan(months28);
        Months months30 = months23.minus(months24);
        PeriodType periodType31 = months30.getPeriodType();
        Period period32 = period22.normalizedStandard(periodType31);
        DurationFieldType durationFieldType33 = DurationFieldType.weeks();
        int int34 = period32.get(durationFieldType33);
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertNotNull(duration4);
        org.junit.Assert.assertNotNull(periodType7);
        org.junit.Assert.assertNotNull(period10);
        org.junit.Assert.assertNotNull(months14);
        org.junit.Assert.assertNotNull(duration15);
        org.junit.Assert.assertNotNull(periodType18);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(ethiopicChronology21);
        org.junit.Assert.assertNotNull(months23);
        org.junit.Assert.assertNotNull(months24);
        org.junit.Assert.assertNotNull(months28);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + true + "'", boolean29 == true);
        org.junit.Assert.assertNotNull(months30);
        org.junit.Assert.assertNotNull(periodType31);
        org.junit.Assert.assertNotNull(period32);
        org.junit.Assert.assertNotNull(durationFieldType33);
        org.junit.Assert.assertTrue("'" + int34 + "' != '" + 0 + "'", int34 == 0);
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test197");
        Hours hours1 = Hours.hours(143);
        org.junit.Assert.assertNotNull(hours1);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test198");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Months months6 = Months.monthsIn((ReadableInterval) interval5);
        boolean boolean7 = interval5.isBeforeNow();
        boolean boolean8 = interval2.abuts((ReadableInterval) interval5);
        Chronology chronology9 = DateTimeUtils.getIntervalChronology((ReadableInterval) interval2);
        org.junit.Assert.assertNotNull(months6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(chronology9);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test199");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField4 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField3);
        int int6 = delegatedDateTimeField4.get((long) (byte) 10);
        boolean boolean8 = delegatedDateTimeField4.isLeap((long) (short) 0);
        // The following exception was thrown during execution in test generation
        try {
            long long11 = delegatedDateTimeField4.set(31123983L, 10080);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 10080 for clockhourOfDay must be in the range [1,24]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test200");
        Appendable appendable0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.joda.time.format.FormatUtils.appendPaddedInteger(appendable0, (long) 1000, (int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test201");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        long long5 = dateTimeZone1.convertLocalToUTC((long) 6, false, 0L);
        LocalDate localDate6 = new LocalDate(dateTimeZone1);
        // The following exception was thrown during execution in test generation
        try {
            org.joda.time.chrono.EthiopicChronology ethiopicChronology8 = org.joda.time.chrono.EthiopicChronology.getInstance(dateTimeZone1, 18);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid min days in first week: 18");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertTrue("'" + long5 + "' != '" + (-35999994L) + "'", long5 == (-35999994L));
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test202");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField4 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField3);
        int int6 = delegatedDateTimeField4.get((long) (byte) 10);
        LocalDate localDate7 = new LocalDate();
        LocalDate localDate9 = localDate7.minusWeeks(3);
        LocalDate.Property property10 = localDate9.monthOfYear();
        java.util.Locale locale12 = null;
        String str13 = delegatedDateTimeField4.getAsText((ReadablePartial) localDate9, (int) (byte) 10, locale12);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology14 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone15 = ethiopicChronology14.getZone();
        DurationField durationField16 = ethiopicChronology14.hours();
        DateTimeField dateTimeField17 = ethiopicChronology14.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField18 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField17);
        int int20 = delegatedDateTimeField18.get((long) (byte) 10);
        LocalDate localDate21 = new LocalDate();
        LocalDate localDate23 = localDate21.minusWeeks(3);
        LocalDate.Property property24 = localDate23.monthOfYear();
        java.util.Locale locale26 = null;
        String str27 = delegatedDateTimeField18.getAsText((ReadablePartial) localDate23, (int) (byte) 10, locale26);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology28 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone29 = ethiopicChronology28.getZone();
        long long33 = dateTimeZone29.convertLocalToUTC((long) 6, false, 0L);
        YearMonthDay yearMonthDay34 = new YearMonthDay(dateTimeZone29);
        DateTime dateTime35 = localDate23.toDateTimeAtStartOfDay(dateTimeZone29);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology36 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone37 = ethiopicChronology36.getZone();
        Weeks weeks38 = Weeks.ONE;
        int[] intArray41 = ethiopicChronology36.get((ReadablePeriod) weeks38, (long) (short) 1, 100L);
        int int42 = delegatedDateTimeField4.getMinimumValue((ReadablePartial) localDate23, intArray41);
        // The following exception was thrown during execution in test generation
        try {
            long long45 = delegatedDateTimeField4.set((long) 60, "--09-15");
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value \"--09-15\" for clockhourOfDay is not supported");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
        org.junit.Assert.assertNotNull(localDate9);
        org.junit.Assert.assertNotNull(property10);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "10" + "'", str13, "10");
        org.junit.Assert.assertNotNull(ethiopicChronology14);
        org.junit.Assert.assertNotNull(dateTimeZone15);
        org.junit.Assert.assertNotNull(durationField16);
        org.junit.Assert.assertNotNull(dateTimeField17);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 10 + "'", int20 == 10);
        org.junit.Assert.assertNotNull(localDate23);
        org.junit.Assert.assertNotNull(property24);
        org.junit.Assert.assertEquals("'" + str27 + "' != '" + "10" + "'", str27, "10");
        org.junit.Assert.assertNotNull(ethiopicChronology28);
        org.junit.Assert.assertNotNull(dateTimeZone29);
        org.junit.Assert.assertTrue("'" + long33 + "' != '" + (-35999994L) + "'", long33 == (-35999994L));
        org.junit.Assert.assertNotNull(dateTime35);
        org.junit.Assert.assertNotNull(ethiopicChronology36);
        org.junit.Assert.assertNotNull(dateTimeZone37);
        org.junit.Assert.assertNotNull(weeks38);
        org.junit.Assert.assertNotNull(intArray41);
        org.junit.Assert.assertArrayEquals(intArray41, new int[] { 0 });
        org.junit.Assert.assertTrue("'" + int42 + "' != '" + 1 + "'", int42 == 1);
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test203");
        PeriodType periodType0 = PeriodType.days();
        MutablePeriod mutablePeriod1 = new MutablePeriod(periodType0);
        // The following exception was thrown during execution in test generation
        try {
            mutablePeriod1.setHours(7);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Period does not support field 'hours'");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(periodType0);
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test204");
        int int0 = MutableDateTime.ROUND_HALF_EVEN;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 5 + "'", int0 == 5);
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test205");
        org.joda.time.chrono.CopticChronology copticChronology1 = org.joda.time.chrono.CopticChronology.getInstanceUTC();
        LocalDateTime localDateTime2 = new LocalDateTime((-35999994L), (Chronology) copticChronology1);
        LocalDateTime localDateTime4 = localDateTime2.plusDays((int) (byte) -1);
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        Chronology chronology7 = null;
        DateMidnight dateMidnight8 = dateMidnight6.withChronology(chronology7);
        DateMidnight dateMidnight10 = dateMidnight6.withCenturyOfEra((int) ' ');
        DateMidnight.Property property11 = dateMidnight6.dayOfMonth();
        DateMidnight dateMidnight13 = new DateMidnight(0L);
        Chronology chronology14 = null;
        DateMidnight dateMidnight15 = dateMidnight13.withChronology(chronology14);
        DateMidnight dateMidnight17 = dateMidnight13.withCenturyOfEra((int) ' ');
        DateMidnight.Property property18 = dateMidnight13.dayOfMonth();
        int int19 = dateMidnight13.getMinuteOfHour();
        Duration duration20 = new Duration((ReadableInstant) dateMidnight6, (ReadableInstant) dateMidnight13);
        LocalDateTime localDateTime22 = localDateTime4.withDurationAdded((ReadableDuration) duration20, 12);
        DateTime dateTime23 = localDateTime4.toDateTime();
        DateTime dateTime25 = dateTime23.minusMinutes(1920);
        org.junit.Assert.assertNotNull(copticChronology1);
        org.junit.Assert.assertNotNull(localDateTime4);
        org.junit.Assert.assertNotNull(dateMidnight8);
        org.junit.Assert.assertNotNull(dateMidnight10);
        org.junit.Assert.assertNotNull(property11);
        org.junit.Assert.assertNotNull(dateMidnight15);
        org.junit.Assert.assertNotNull(dateMidnight17);
        org.junit.Assert.assertNotNull(property18);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 0 + "'", int19 == 0);
        org.junit.Assert.assertNotNull(localDateTime22);
        org.junit.Assert.assertNotNull(dateTime23);
        org.junit.Assert.assertNotNull(dateTime25);
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test206");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeField dateTimeField1 = ethiopicChronology0.monthOfYear();
        String str2 = ethiopicChronology0.toString();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeField1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "EthiopicChronology[Australia/Sydney]" + "'", str2, "EthiopicChronology[Australia/Sydney]");
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test207");
        java.util.Date date0 = null;
        // The following exception was thrown during execution in test generation
        try {
            LocalTime localTime1 = LocalTime.fromDateFields(date0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The date must not be null");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test208");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        Weeks weeks3 = Weeks.ONE;
        int[] intArray6 = ethiopicChronology1.get((ReadablePeriod) weeks3, (long) (short) 1, 100L);
        DateTimeField dateTimeField7 = ethiopicChronology1.millisOfDay();
        DateTimeField dateTimeField8 = ethiopicChronology1.year();
        DateTime dateTime9 = DateTime.now((Chronology) ethiopicChronology1);
        TimeOfDay timeOfDay10 = TimeOfDay.fromMillisOfDay((long) (byte) 1, (Chronology) ethiopicChronology1);
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(weeks3);
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertArrayEquals(intArray6, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField7);
        org.junit.Assert.assertNotNull(dateTimeField8);
        org.junit.Assert.assertNotNull(dateTime9);
        org.junit.Assert.assertNotNull(timeOfDay10);
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test209");
        ReadableInstant readableInstant0 = null;
        DateTime dateTime1 = new DateTime();
        Interval interval2 = new Interval(readableInstant0, (ReadableInstant) dateTime1);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        Object obj6 = null;
        Chronology chronology7 = null;
        Interval interval8 = new Interval(obj6, chronology7);
        Weeks weeks9 = Weeks.ONE;
        Interval interval10 = interval8.withPeriodAfterStart((ReadablePeriod) weeks9);
        int[] intArray13 = ethiopicChronology4.get((ReadablePeriod) weeks9, (long) (short) -1, (long) (short) -1);
        DurationField durationField14 = ethiopicChronology4.minutes();
        YearMonthDay yearMonthDay15 = new YearMonthDay(100L, (Chronology) ethiopicChronology4);
        DateTimeField dateTimeField16 = ethiopicChronology4.minuteOfDay();
        DateTimeField dateTimeField17 = ethiopicChronology4.dayOfMonth();
        DateTimeZone dateTimeZone18 = ethiopicChronology4.getZone();
        DateTime dateTime19 = dateTime1.toDateTime(dateTimeZone18);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(weeks9);
        org.junit.Assert.assertNotNull(interval10);
        org.junit.Assert.assertNotNull(intArray13);
        org.junit.Assert.assertArrayEquals(intArray13, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField14);
        org.junit.Assert.assertNotNull(dateTimeField16);
        org.junit.Assert.assertNotNull(dateTimeField17);
        org.junit.Assert.assertNotNull(dateTimeZone18);
        org.junit.Assert.assertNotNull(dateTime19);
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test210");
        Weeks weeks0 = Weeks.MAX_VALUE;
        // The following exception was thrown during execution in test generation
        try {
            Weeks weeks2 = weeks0.plus(24);
            org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException; message: The calculation caused an overflow: 2147483647 + 24");
        } catch (ArithmeticException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(weeks0);
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test211");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        Duration duration4 = interval2.toDuration();
        boolean boolean6 = interval2.isBefore((-35999994L));
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertNotNull(duration4);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test212");
        LocalDate localDate0 = new LocalDate();
        LocalDate localDate2 = localDate0.minusWeeks(3);
        LocalDate.Property property3 = localDate2.monthOfYear();
        LocalDate localDate4 = property3.withMinimumValue();
        String str5 = property3.getAsShortText();
        org.junit.Assert.assertNotNull(localDate2);
        org.junit.Assert.assertNotNull(property3);
        org.junit.Assert.assertNotNull(localDate4);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "May" + "'", str5, "May");
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test213");
        java.math.RoundingMode roundingMode2 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long3 = org.joda.time.field.FieldUtils.safeDivide((-35999994L), (-210866760000000L), roundingMode2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test214");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Weeks weeks2 = Weeks.ONE;
        int[] intArray5 = ethiopicChronology0.get((ReadablePeriod) weeks2, (long) (short) 1, 100L);
        DateTimeField dateTimeField6 = ethiopicChronology0.millisOfDay();
        TimeOfDay timeOfDay7 = new TimeOfDay();
        long long9 = ethiopicChronology0.set((ReadablePartial) timeOfDay7, 0L);
        // The following exception was thrown during execution in test generation
        try {
            TimeOfDay timeOfDay11 = timeOfDay7.withSecondOfMinute(1000);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 1000 for secondOfMinute must be in the range [0,59]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks2);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField6);
// flaky "8) test214(RegressionTest0)":         org.junit.Assert.assertTrue("'" + long9 + "' != '" + 31154409L + "'", long9 == 31154409L);
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test215");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Weeks weeks2 = Weeks.ONE;
        int[] intArray5 = ethiopicChronology0.get((ReadablePeriod) weeks2, (long) (short) 1, 100L);
        DateTimeField dateTimeField6 = ethiopicChronology0.millisOfDay();
        DateTimeField dateTimeField7 = ethiopicChronology0.year();
        DateTime dateTime8 = DateTime.now((Chronology) ethiopicChronology0);
        DurationField durationField9 = ethiopicChronology0.weekyears();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks2);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField6);
        org.junit.Assert.assertNotNull(dateTimeField7);
        org.junit.Assert.assertNotNull(dateTime8);
        org.junit.Assert.assertNotNull(durationField9);
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test216");
        java.util.Calendar calendar0 = null;
        // The following exception was thrown during execution in test generation
        try {
            YearMonthDay yearMonthDay1 = YearMonthDay.fromCalendarFields(calendar0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The calendar must not be null");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test217");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        DateTimeField dateTimeField3 = ethiopicChronology1.minuteOfHour();
        LocalDateTime localDateTime4 = new LocalDateTime(31139671L, (Chronology) ethiopicChronology1);
        // The following exception was thrown during execution in test generation
        try {
            LocalDateTime localDateTime6 = localDateTime4.withDayOfWeek((int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 10 for dayOfWeek must be in the range [1,7]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(dateTimeField3);
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test218");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Object obj2 = null;
        Chronology chronology3 = null;
        Interval interval4 = new Interval(obj2, chronology3);
        Weeks weeks5 = Weeks.ONE;
        Interval interval6 = interval4.withPeriodAfterStart((ReadablePeriod) weeks5);
        int[] intArray9 = ethiopicChronology0.get((ReadablePeriod) weeks5, (long) (short) -1, (long) (short) -1);
        DurationField durationField10 = ethiopicChronology0.minutes();
        DateTimeField dateTimeField11 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology12 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone13 = ethiopicChronology12.getZone();
        DateTimeField dateTimeField14 = ethiopicChronology12.minuteOfHour();
        MonthDay monthDay15 = new MonthDay((Chronology) ethiopicChronology12);
        String str16 = monthDay15.toString();
        Object obj17 = null;
        Chronology chronology18 = null;
        Interval interval19 = new Interval(obj17, chronology18);
        Months months20 = Months.monthsIn((ReadableInterval) interval19);
        Duration duration21 = interval19.toDuration();
        DateMidnight dateMidnight23 = new DateMidnight(0L);
        PeriodType periodType24 = PeriodType.days();
        MutablePeriod mutablePeriod25 = new MutablePeriod((ReadableDuration) duration21, (ReadableInstant) dateMidnight23, periodType24);
        Chronology chronology26 = null;
        Period period27 = duration21.toPeriod(chronology26);
        Object obj28 = null;
        Chronology chronology29 = null;
        Interval interval30 = new Interval(obj28, chronology29);
        Months months31 = Months.monthsIn((ReadableInterval) interval30);
        Duration duration32 = interval30.toDuration();
        DateMidnight dateMidnight34 = new DateMidnight(0L);
        PeriodType periodType35 = PeriodType.days();
        MutablePeriod mutablePeriod36 = new MutablePeriod((ReadableDuration) duration32, (ReadableInstant) dateMidnight34, periodType35);
        boolean boolean37 = duration21.isShorterThan((ReadableDuration) duration32);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology38 = org.joda.time.chrono.EthiopicChronology.getInstance();
        Period period39 = new Period((Object) duration21, (Chronology) ethiopicChronology38);
        Months months40 = Months.MAX_VALUE;
        Months months41 = Months.MAX_VALUE;
        Object obj42 = null;
        Chronology chronology43 = null;
        Interval interval44 = new Interval(obj42, chronology43);
        Months months45 = Months.monthsIn((ReadableInterval) interval44);
        boolean boolean46 = months41.isGreaterThan(months45);
        Months months47 = months40.minus(months41);
        PeriodType periodType48 = months47.getPeriodType();
        Period period49 = period39.normalizedStandard(periodType48);
        MonthDay monthDay51 = monthDay15.withPeriodAdded((ReadablePeriod) period39, 0);
        // The following exception was thrown during execution in test generation
        try {
            long long53 = ethiopicChronology0.set((ReadablePartial) monthDay51, (-210866760000000L));
            org.junit.Assert.fail("Expected exception of type org.joda.time.chrono.LimitChronology.LimitException; message: The instant is below the supported minimum of 0001-01-01T00:00:00.000Z (EthiopicChronology[UTC])");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks5);
        org.junit.Assert.assertNotNull(interval6);
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertArrayEquals(intArray9, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField10);
        org.junit.Assert.assertNotNull(dateTimeField11);
        org.junit.Assert.assertNotNull(ethiopicChronology12);
        org.junit.Assert.assertNotNull(dateTimeZone13);
        org.junit.Assert.assertNotNull(dateTimeField14);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "--09-15" + "'", str16, "--09-15");
        org.junit.Assert.assertNotNull(months20);
        org.junit.Assert.assertNotNull(duration21);
        org.junit.Assert.assertNotNull(periodType24);
        org.junit.Assert.assertNotNull(period27);
        org.junit.Assert.assertNotNull(months31);
        org.junit.Assert.assertNotNull(duration32);
        org.junit.Assert.assertNotNull(periodType35);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertNotNull(ethiopicChronology38);
        org.junit.Assert.assertNotNull(months40);
        org.junit.Assert.assertNotNull(months41);
        org.junit.Assert.assertNotNull(months45);
        org.junit.Assert.assertTrue("'" + boolean46 + "' != '" + true + "'", boolean46 == true);
        org.junit.Assert.assertNotNull(months47);
        org.junit.Assert.assertNotNull(periodType48);
        org.junit.Assert.assertNotNull(period49);
        org.junit.Assert.assertNotNull(monthDay51);
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test219");
        org.joda.time.chrono.CopticChronology copticChronology1 = org.joda.time.chrono.CopticChronology.getInstanceUTC();
        LocalDateTime localDateTime2 = new LocalDateTime((-35999994L), (Chronology) copticChronology1);
        LocalDateTime localDateTime4 = localDateTime2.plusDays((int) (byte) -1);
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        Chronology chronology7 = null;
        DateMidnight dateMidnight8 = dateMidnight6.withChronology(chronology7);
        DateMidnight dateMidnight10 = dateMidnight6.withCenturyOfEra((int) ' ');
        DateMidnight.Property property11 = dateMidnight6.dayOfMonth();
        DateMidnight dateMidnight13 = new DateMidnight(0L);
        Chronology chronology14 = null;
        DateMidnight dateMidnight15 = dateMidnight13.withChronology(chronology14);
        DateMidnight dateMidnight17 = dateMidnight13.withCenturyOfEra((int) ' ');
        DateMidnight.Property property18 = dateMidnight13.dayOfMonth();
        int int19 = dateMidnight13.getMinuteOfHour();
        Duration duration20 = new Duration((ReadableInstant) dateMidnight6, (ReadableInstant) dateMidnight13);
        LocalDateTime localDateTime22 = localDateTime4.withDurationAdded((ReadableDuration) duration20, 12);
        // The following exception was thrown during execution in test generation
        try {
            LocalDateTime localDateTime24 = localDateTime22.withDayOfWeek(23);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 23 for dayOfWeek must be in the range [1,7]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(copticChronology1);
        org.junit.Assert.assertNotNull(localDateTime4);
        org.junit.Assert.assertNotNull(dateMidnight8);
        org.junit.Assert.assertNotNull(dateMidnight10);
        org.junit.Assert.assertNotNull(property11);
        org.junit.Assert.assertNotNull(dateMidnight15);
        org.junit.Assert.assertNotNull(dateMidnight17);
        org.junit.Assert.assertNotNull(property18);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 0 + "'", int19 == 0);
        org.junit.Assert.assertNotNull(localDateTime22);
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test220");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Weeks weeks2 = Weeks.ONE;
        int[] intArray5 = ethiopicChronology0.get((ReadablePeriod) weeks2, (long) (short) 1, 100L);
        DurationField durationField6 = ethiopicChronology0.eras();
        int int7 = ethiopicChronology0.getMinimumDaysInFirstWeek();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks2);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 4 + "'", int7 == 4);
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test221");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        DurationField durationField6 = ethiopicChronology4.hours();
        int int8 = durationField6.getValue(0L);
        DateTimeFieldType dateTimeFieldType9 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField11 = new org.joda.time.field.DividedDateTimeField(dateTimeField3, durationField6, dateTimeFieldType9, (int) '4');
        // The following exception was thrown during execution in test generation
        try {
            long long13 = dividedDateTimeField11.roundFloor((long) 1);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 0 for clockhourOfDay must be in the range [1,24]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType9);
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test222");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology2 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone3 = ethiopicChronology2.getZone();
        Weeks weeks4 = Weeks.ONE;
        int[] intArray7 = ethiopicChronology2.get((ReadablePeriod) weeks4, (long) (short) 1, 100L);
        Period period8 = new Period((long) (short) 0, (long) 'a', (Chronology) ethiopicChronology2);
        DateTimeField dateTimeField9 = ethiopicChronology2.centuryOfEra();
        DateTimeField dateTimeField10 = ethiopicChronology2.year();
        java.util.Locale locale12 = null;
        String str13 = dateTimeField10.getAsShortText((int) (short) 10, locale12);
        org.junit.Assert.assertNotNull(ethiopicChronology2);
        org.junit.Assert.assertNotNull(dateTimeZone3);
        org.junit.Assert.assertNotNull(weeks4);
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertArrayEquals(intArray7, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField9);
        org.junit.Assert.assertNotNull(dateTimeField10);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "10" + "'", str13, "10");
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test223");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField4 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField3);
        int int6 = delegatedDateTimeField4.get((long) (byte) 10);
        LocalDate localDate7 = new LocalDate();
        LocalDate localDate9 = localDate7.minusWeeks(3);
        LocalDate.Property property10 = localDate9.monthOfYear();
        java.util.Locale locale12 = null;
        String str13 = delegatedDateTimeField4.getAsText((ReadablePartial) localDate9, (int) (byte) 10, locale12);
        int int15 = delegatedDateTimeField4.get((-36000000L));
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
        org.junit.Assert.assertNotNull(localDate9);
        org.junit.Assert.assertNotNull(property10);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "10" + "'", str13, "10");
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 24 + "'", int15 == 24);
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test224");
        Instant instant1 = Instant.ofEpochSecond((long) 12);
        org.junit.Assert.assertNotNull(instant1);
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test225");
        PeriodType periodType0 = PeriodType.days();
        MutablePeriod mutablePeriod1 = new MutablePeriod(periodType0);
        DurationFieldType durationFieldType2 = DurationFieldType.millis();
        // The following exception was thrown during execution in test generation
        try {
            mutablePeriod1.set(durationFieldType2, 10080);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Period does not support field 'millis'");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(periodType0);
        org.junit.Assert.assertNotNull(durationFieldType2);
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test226");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        Duration duration4 = interval2.toDuration();
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        PeriodType periodType7 = PeriodType.days();
        MutablePeriod mutablePeriod8 = new MutablePeriod((ReadableDuration) duration4, (ReadableInstant) dateMidnight6, periodType7);
        Object obj9 = null;
        Chronology chronology10 = null;
        Interval interval11 = new Interval(obj9, chronology10);
        Months months12 = Months.monthsIn((ReadableInterval) interval11);
        Duration duration13 = interval11.toDuration();
        Object obj14 = null;
        Chronology chronology15 = null;
        Interval interval16 = new Interval(obj14, chronology15);
        Months months17 = Months.monthsIn((ReadableInterval) interval16);
        Duration duration18 = interval16.toDuration();
        boolean boolean19 = duration13.isEqual((ReadableDuration) duration18);
        boolean boolean20 = duration4.isEqual((ReadableDuration) duration18);
        DateTimeZone dateTimeZone22 = null;
        MutableDateTime mutableDateTime23 = new MutableDateTime((long) 10080, dateTimeZone22);
        mutableDateTime23.setDayOfYear(6);
        MutableInterval mutableInterval28 = new MutableInterval((long) (byte) -1, (long) 1);
        MutableInterval mutableInterval29 = mutableInterval28.copy();
        mutableInterval29.setDurationAfterStart((long) (byte) 0);
        Object obj32 = null;
        Chronology chronology33 = null;
        Interval interval34 = new Interval(obj32, chronology33);
        Months months35 = Months.monthsIn((ReadableInterval) interval34);
        Duration duration36 = interval34.toDuration();
        DateMidnight dateMidnight38 = new DateMidnight(0L);
        PeriodType periodType39 = PeriodType.days();
        MutablePeriod mutablePeriod40 = new MutablePeriod((ReadableDuration) duration36, (ReadableInstant) dateMidnight38, periodType39);
        int int41 = mutablePeriod40.getYears();
        Object obj42 = null;
        Chronology chronology43 = null;
        Interval interval44 = new Interval(obj42, chronology43);
        Months months45 = Months.monthsIn((ReadableInterval) interval44);
        Duration duration46 = interval44.toDuration();
        DateMidnight dateMidnight48 = new DateMidnight(0L);
        PeriodType periodType49 = PeriodType.days();
        MutablePeriod mutablePeriod50 = new MutablePeriod((ReadableDuration) duration46, (ReadableInstant) dateMidnight48, periodType49);
        Object obj51 = null;
        Chronology chronology52 = null;
        Interval interval53 = new Interval(obj51, chronology52);
        Months months54 = Months.monthsIn((ReadableInterval) interval53);
        Duration duration55 = interval53.toDuration();
        Object obj56 = null;
        Chronology chronology57 = null;
        Interval interval58 = new Interval(obj56, chronology57);
        Months months59 = Months.monthsIn((ReadableInterval) interval58);
        Duration duration60 = interval58.toDuration();
        boolean boolean61 = duration55.isEqual((ReadableDuration) duration60);
        boolean boolean62 = duration46.isEqual((ReadableDuration) duration60);
        mutablePeriod40.setPeriod((ReadableDuration) duration60);
        mutableInterval29.setDurationAfterStart((ReadableDuration) duration60);
        mutableDateTime23.add((ReadableDuration) duration60, 9);
        Months months67 = Months.MAX_VALUE;
        Months months68 = Months.MAX_VALUE;
        Object obj69 = null;
        Chronology chronology70 = null;
        Interval interval71 = new Interval(obj69, chronology70);
        Months months72 = Months.monthsIn((ReadableInterval) interval71);
        boolean boolean73 = months68.isGreaterThan(months72);
        Months months74 = months67.minus(months68);
        PeriodType periodType75 = months74.getPeriodType();
        Period period76 = new Period((ReadableDuration) duration18, (ReadableInstant) mutableDateTime23, periodType75);
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertNotNull(duration4);
        org.junit.Assert.assertNotNull(periodType7);
        org.junit.Assert.assertNotNull(months12);
        org.junit.Assert.assertNotNull(duration13);
        org.junit.Assert.assertNotNull(months17);
        org.junit.Assert.assertNotNull(duration18);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
        org.junit.Assert.assertNotNull(mutableInterval29);
        org.junit.Assert.assertNotNull(months35);
        org.junit.Assert.assertNotNull(duration36);
        org.junit.Assert.assertNotNull(periodType39);
        org.junit.Assert.assertTrue("'" + int41 + "' != '" + 0 + "'", int41 == 0);
        org.junit.Assert.assertNotNull(months45);
        org.junit.Assert.assertNotNull(duration46);
        org.junit.Assert.assertNotNull(periodType49);
        org.junit.Assert.assertNotNull(months54);
        org.junit.Assert.assertNotNull(duration55);
        org.junit.Assert.assertNotNull(months59);
        org.junit.Assert.assertNotNull(duration60);
        org.junit.Assert.assertTrue("'" + boolean61 + "' != '" + true + "'", boolean61 == true);
        org.junit.Assert.assertTrue("'" + boolean62 + "' != '" + true + "'", boolean62 == true);
        org.junit.Assert.assertNotNull(months67);
        org.junit.Assert.assertNotNull(months68);
        org.junit.Assert.assertNotNull(months72);
        org.junit.Assert.assertTrue("'" + boolean73 + "' != '" + true + "'", boolean73 == true);
        org.junit.Assert.assertNotNull(months74);
        org.junit.Assert.assertNotNull(periodType75);
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test227");
        Hours hours0 = Hours.SIX;
        MutablePeriod mutablePeriod1 = hours0.toMutablePeriod();
        mutablePeriod1.setSeconds((int) (short) 0);
        int int4 = mutablePeriod1.getMinutes();
        MutablePeriod mutablePeriod5 = mutablePeriod1.copy();
        org.junit.Assert.assertNotNull(hours0);
        org.junit.Assert.assertNotNull(mutablePeriod1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(mutablePeriod5);
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test228");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        DurationField durationField6 = ethiopicChronology4.hours();
        int int8 = durationField6.getValue(0L);
        DateTimeFieldType dateTimeFieldType9 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField11 = new org.joda.time.field.DividedDateTimeField(dateTimeField3, durationField6, dateTimeFieldType9, (int) '4');
        DurationFieldType durationFieldType12 = durationField6.getType();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType9);
        org.junit.Assert.assertNotNull(durationFieldType12);
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test229");
        Days days0 = Days.FIVE;
        Days days2 = days0.minus((int) (short) 100);
        Days days3 = Days.FIVE;
        int int4 = days3.getDays();
        Days days6 = days3.multipliedBy(1);
        boolean boolean7 = days2.isLessThan(days3);
        org.junit.Assert.assertNotNull(days0);
        org.junit.Assert.assertNotNull(days2);
        org.junit.Assert.assertNotNull(days3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 5 + "'", int4 == 5);
        org.junit.Assert.assertNotNull(days6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test230");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeField dateTimeField1 = ethiopicChronology0.monthOfYear();
        DurationField durationField2 = ethiopicChronology0.weekyears();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeField1);
        org.junit.Assert.assertNotNull(durationField2);
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test231");
        int int0 = DateTimeConstants.BC;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 0 + "'", int0 == 0);
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test232");
        MutableInterval mutableInterval2 = new MutableInterval((long) (byte) -1, (long) 1);
        MutableInterval mutableInterval3 = mutableInterval2.copy();
        DateTimeZone dateTimeZone5 = null;
        MutableDateTime mutableDateTime6 = new MutableDateTime((long) 10080, dateTimeZone5);
        DateMidnight dateMidnight8 = new DateMidnight(0L);
        DateMidnight dateMidnight10 = new DateMidnight(0L);
        boolean boolean11 = dateMidnight8.isEqual((ReadableInstant) dateMidnight10);
        int int12 = dateMidnight8.getSecondOfDay();
        DateMidnight dateMidnight14 = dateMidnight8.plus((long) 36000000);
        mutableDateTime6.setMillis((ReadableInstant) dateMidnight14);
        mutableDateTime6.setYear(60);
        DateTime dateTime18 = new DateTime();
        DateTime.Property property19 = dateTime18.hourOfDay();
        int int20 = dateTime18.getDayOfYear();
        mutableInterval2.setInterval((ReadableInstant) mutableDateTime6, (ReadableInstant) dateTime18);
        MutableDateTime.Property property22 = mutableDateTime6.centuryOfEra();
        MutableDateTime mutableDateTime23 = property22.roundCeiling();
        org.junit.Assert.assertNotNull(mutableInterval3);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(dateMidnight14);
        org.junit.Assert.assertNotNull(property19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 143 + "'", int20 == 143);
        org.junit.Assert.assertNotNull(property22);
        org.junit.Assert.assertNotNull(mutableDateTime23);
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test233");
        DateTimeZone dateTimeZone1 = null;
        MutableDateTime mutableDateTime2 = new MutableDateTime((long) 10080, dateTimeZone1);
        DateTime dateTime3 = new DateTime();
        DateTime.Property property4 = dateTime3.hourOfDay();
        int int5 = dateTime3.getDayOfYear();
        Minutes minutes6 = Minutes.minutesBetween((ReadableInstant) mutableDateTime2, (ReadableInstant) dateTime3);
        int int7 = mutableDateTime2.getDayOfMonth();
        int int8 = mutableDateTime2.getDayOfMonth();
        org.junit.Assert.assertNotNull(property4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 143 + "'", int5 == 143);
        org.junit.Assert.assertNotNull(minutes6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 1 + "'", int7 == 1);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 1 + "'", int8 == 1);
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test234");
        YearMonth yearMonth0 = new YearMonth();
        // The following exception was thrown during execution in test generation
        try {
            YearMonth yearMonth2 = yearMonth0.withMonthOfYear(1000);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 1000 for monthOfYear must be in the range [1,12]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test235");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        Duration duration4 = interval2.toDuration();
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        PeriodType periodType7 = PeriodType.days();
        MutablePeriod mutablePeriod8 = new MutablePeriod((ReadableDuration) duration4, (ReadableInstant) dateMidnight6, periodType7);
        Object obj9 = null;
        Chronology chronology10 = null;
        Interval interval11 = new Interval(obj9, chronology10);
        Months months12 = Months.monthsIn((ReadableInterval) interval11);
        Duration duration13 = interval11.toDuration();
        Object obj14 = null;
        Chronology chronology15 = null;
        Interval interval16 = new Interval(obj14, chronology15);
        Months months17 = Months.monthsIn((ReadableInterval) interval16);
        Duration duration18 = interval16.toDuration();
        boolean boolean19 = duration13.isEqual((ReadableDuration) duration18);
        boolean boolean20 = duration4.isEqual((ReadableDuration) duration18);
        Duration duration22 = duration18.plus((-35999994L));
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertNotNull(duration4);
        org.junit.Assert.assertNotNull(periodType7);
        org.junit.Assert.assertNotNull(months12);
        org.junit.Assert.assertNotNull(duration13);
        org.junit.Assert.assertNotNull(months17);
        org.junit.Assert.assertNotNull(duration18);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
        org.junit.Assert.assertNotNull(duration22);
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test236");
        PeriodType periodType8 = PeriodType.yearWeekDayTime();
        // The following exception was thrown during execution in test generation
        try {
            MutablePeriod mutablePeriod9 = new MutablePeriod((int) '#', (int) ' ', 9, 10, 0, 3, 9, 23, periodType8);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Period does not support field 'months'");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(periodType8);
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test237");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Weeks weeks6 = Weeks.ONE;
        Interval interval7 = interval5.withPeriodAfterStart((ReadablePeriod) weeks6);
        int[] intArray10 = ethiopicChronology1.get((ReadablePeriod) weeks6, (long) (short) -1, (long) (short) -1);
        DurationField durationField11 = ethiopicChronology1.minutes();
        YearMonthDay yearMonthDay12 = new YearMonthDay(100L, (Chronology) ethiopicChronology1);
        DateTimeField dateTimeField13 = ethiopicChronology1.minuteOfDay();
        DateTimeField dateTimeField14 = ethiopicChronology1.dayOfMonth();
        DateTimeField dateTimeField15 = ethiopicChronology1.era();
        DateTimeField dateTimeField16 = ethiopicChronology1.minuteOfDay();
        long long20 = ethiopicChronology1.add((long) '#', (long) ' ', 10080);
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(weeks6);
        org.junit.Assert.assertNotNull(interval7);
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField11);
        org.junit.Assert.assertNotNull(dateTimeField13);
        org.junit.Assert.assertNotNull(dateTimeField14);
        org.junit.Assert.assertNotNull(dateTimeField15);
        org.junit.Assert.assertNotNull(dateTimeField16);
        org.junit.Assert.assertTrue("'" + long20 + "' != '" + 322595L + "'", long20 == 322595L);
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test238");
        DateTimeZone dateTimeZone1 = null;
        MutableDateTime mutableDateTime2 = new MutableDateTime((long) 10080, dateTimeZone1);
        DateMidnight dateMidnight4 = new DateMidnight(0L);
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        boolean boolean7 = dateMidnight4.isEqual((ReadableInstant) dateMidnight6);
        int int8 = dateMidnight4.getSecondOfDay();
        DateMidnight dateMidnight10 = dateMidnight4.plus((long) 36000000);
        mutableDateTime2.setMillis((ReadableInstant) dateMidnight10);
        mutableDateTime2.setYear(60);
        mutableDateTime2.addMonths(9);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateMidnight10);
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test239");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        Duration duration4 = interval2.toDuration();
        Object obj5 = null;
        Chronology chronology6 = null;
        Interval interval7 = new Interval(obj5, chronology6);
        Months months8 = Months.monthsIn((ReadableInterval) interval7);
        Duration duration9 = interval7.toDuration();
        boolean boolean10 = duration4.isEqual((ReadableDuration) duration9);
        DateTimeZone dateTimeZone12 = null;
        MutableDateTime mutableDateTime13 = new MutableDateTime((long) 10080, dateTimeZone12);
        DateMidnight dateMidnight15 = new DateMidnight(0L);
        DateMidnight dateMidnight17 = new DateMidnight(0L);
        boolean boolean18 = dateMidnight15.isEqual((ReadableInstant) dateMidnight17);
        int int19 = dateMidnight15.getSecondOfDay();
        DateMidnight dateMidnight21 = dateMidnight15.plus((long) 36000000);
        mutableDateTime13.setMillis((ReadableInstant) dateMidnight21);
        DateMidnight.Property property23 = dateMidnight21.weekyear();
        MutableInterval mutableInterval24 = new MutableInterval((ReadableDuration) duration9, (ReadableInstant) dateMidnight21);
        DateMidnight dateMidnight26 = dateMidnight21.minus((-210866760000000L));
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertNotNull(duration4);
        org.junit.Assert.assertNotNull(months8);
        org.junit.Assert.assertNotNull(duration9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 0 + "'", int19 == 0);
        org.junit.Assert.assertNotNull(dateMidnight21);
        org.junit.Assert.assertNotNull(property23);
        org.junit.Assert.assertNotNull(dateMidnight26);
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test240");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        String str3 = durationField2.getName();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hours" + "'", str3, "hours");
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test241");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter0 = org.joda.time.format.ISODateTimeFormat.timeElementParser();
        boolean boolean1 = dateTimeFormatter0.isOffsetParsed();
        org.junit.Assert.assertNotNull(dateTimeFormatter0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test242");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Weeks weeks2 = Weeks.ONE;
        int[] intArray5 = ethiopicChronology0.get((ReadablePeriod) weeks2, (long) (short) 1, 100L);
        DateTimeField dateTimeField6 = ethiopicChronology0.millisOfDay();
        TimeOfDay timeOfDay7 = new TimeOfDay();
        long long9 = ethiopicChronology0.set((ReadablePartial) timeOfDay7, 0L);
        TimeOfDay timeOfDay11 = timeOfDay7.withMinuteOfHour(12);
        TimeOfDay.Property property12 = timeOfDay11.secondOfMinute();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks2);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField6);
// flaky "9) test242(RegressionTest0)":         org.junit.Assert.assertTrue("'" + long9 + "' != '" + 31158917L + "'", long9 == 31158917L);
        org.junit.Assert.assertNotNull(timeOfDay11);
        org.junit.Assert.assertNotNull(property12);
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test243");
        MutableInterval mutableInterval2 = new MutableInterval((long) (byte) -1, (long) 1);
        MutableInterval mutableInterval3 = mutableInterval2.copy();
        DateTimeZone dateTimeZone5 = null;
        MutableDateTime mutableDateTime6 = new MutableDateTime((long) 10080, dateTimeZone5);
        DateMidnight dateMidnight8 = new DateMidnight(0L);
        DateMidnight dateMidnight10 = new DateMidnight(0L);
        boolean boolean11 = dateMidnight8.isEqual((ReadableInstant) dateMidnight10);
        int int12 = dateMidnight8.getSecondOfDay();
        DateMidnight dateMidnight14 = dateMidnight8.plus((long) 36000000);
        mutableDateTime6.setMillis((ReadableInstant) dateMidnight14);
        mutableDateTime6.setYear(60);
        DateTime dateTime18 = new DateTime();
        DateTime.Property property19 = dateTime18.hourOfDay();
        int int20 = dateTime18.getDayOfYear();
        mutableInterval2.setInterval((ReadableInstant) mutableDateTime6, (ReadableInstant) dateTime18);
        MutableDateTime.Property property22 = mutableDateTime6.centuryOfEra();
        MutableDateTime mutableDateTime24 = property22.add((int) (short) 100);
        org.junit.Assert.assertNotNull(mutableInterval3);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(dateMidnight14);
        org.junit.Assert.assertNotNull(property19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 143 + "'", int20 == 143);
        org.junit.Assert.assertNotNull(property22);
        org.junit.Assert.assertNotNull(mutableDateTime24);
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test244");
        PeriodType periodType0 = PeriodType.days();
        MutablePeriod mutablePeriod1 = new MutablePeriod(periodType0);
        // The following exception was thrown during execution in test generation
        try {
            mutablePeriod1.addSeconds(18);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Period does not support field 'seconds'");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(periodType0);
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test245");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        Duration duration4 = interval2.toDuration();
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        PeriodType periodType7 = PeriodType.days();
        MutablePeriod mutablePeriod8 = new MutablePeriod((ReadableDuration) duration4, (ReadableInstant) dateMidnight6, periodType7);
        DateMidnight dateMidnight10 = new DateMidnight(0L);
        Chronology chronology11 = null;
        DateMidnight dateMidnight12 = dateMidnight10.withChronology(chronology11);
        DateMidnight dateMidnight14 = dateMidnight10.withCenturyOfEra((int) ' ');
        Object obj15 = null;
        Chronology chronology16 = null;
        Interval interval17 = new Interval(obj15, chronology16);
        Months months18 = Months.monthsIn((ReadableInterval) interval17);
        Duration duration19 = interval17.toDuration();
        DateMidnight dateMidnight21 = new DateMidnight(0L);
        PeriodType periodType22 = PeriodType.days();
        MutablePeriod mutablePeriod23 = new MutablePeriod((ReadableDuration) duration19, (ReadableInstant) dateMidnight21, periodType22);
        Period period24 = duration4.toPeriodFrom((ReadableInstant) dateMidnight10, periodType22);
        long long25 = duration4.getMillis();
        Duration duration27 = duration4.withMillis((long) (byte) 0);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology28 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone29 = ethiopicChronology28.getZone();
        int int31 = dateTimeZone29.getOffset((long) 100);
        DateMidnight dateMidnight32 = DateMidnight.now(dateTimeZone29);
        Period period33 = duration27.toPeriodTo((ReadableInstant) dateMidnight32);
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertNotNull(duration4);
        org.junit.Assert.assertNotNull(periodType7);
        org.junit.Assert.assertNotNull(dateMidnight12);
        org.junit.Assert.assertNotNull(dateMidnight14);
        org.junit.Assert.assertNotNull(months18);
        org.junit.Assert.assertNotNull(duration19);
        org.junit.Assert.assertNotNull(periodType22);
        org.junit.Assert.assertNotNull(period24);
        org.junit.Assert.assertTrue("'" + long25 + "' != '" + 0L + "'", long25 == 0L);
        org.junit.Assert.assertNotNull(duration27);
        org.junit.Assert.assertNotNull(ethiopicChronology28);
        org.junit.Assert.assertNotNull(dateTimeZone29);
        org.junit.Assert.assertTrue("'" + int31 + "' != '" + 36000000 + "'", int31 == 36000000);
        org.junit.Assert.assertNotNull(dateMidnight32);
        org.junit.Assert.assertNotNull(period33);
    }

    @Test
    public void test246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test246");
        Period period1 = Period.millis(18);
        org.junit.Assert.assertNotNull(period1);
    }

    @Test
    public void test247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test247");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology5 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone6 = ethiopicChronology5.getZone();
        Object obj7 = null;
        Chronology chronology8 = null;
        Interval interval9 = new Interval(obj7, chronology8);
        Weeks weeks10 = Weeks.ONE;
        Interval interval11 = interval9.withPeriodAfterStart((ReadablePeriod) weeks10);
        int[] intArray14 = ethiopicChronology5.get((ReadablePeriod) weeks10, (long) (short) -1, (long) (short) -1);
        DurationField durationField15 = ethiopicChronology5.minutes();
        YearMonthDay yearMonthDay16 = new YearMonthDay(100L, (Chronology) ethiopicChronology5);
        DateTime dateTime17 = yearMonthDay16.toDateTimeAtMidnight();
        int int18 = yearMonthDay16.size();
        long long20 = ethiopicChronology0.set((ReadablePartial) yearMonthDay16, (long) 24);
        DateTimeFieldType[] dateTimeFieldTypeArray21 = yearMonthDay16.getFieldTypes();
        Interval interval22 = yearMonthDay16.toInterval();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(ethiopicChronology5);
        org.junit.Assert.assertNotNull(dateTimeZone6);
        org.junit.Assert.assertNotNull(weeks10);
        org.junit.Assert.assertNotNull(interval11);
        org.junit.Assert.assertNotNull(intArray14);
        org.junit.Assert.assertArrayEquals(intArray14, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField15);
        org.junit.Assert.assertNotNull(dateTime17);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 3 + "'", int18 == 3);
        org.junit.Assert.assertTrue("'" + long20 + "' != '" + 24L + "'", long20 == 24L);
        org.junit.Assert.assertNotNull(dateTimeFieldTypeArray21);
        org.junit.Assert.assertNotNull(interval22);
    }

    @Test
    public void test248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test248");
        // The following exception was thrown during execution in test generation
        try {
            DateTime dateTime5 = new DateTime((int) (short) 100, (int) (byte) -1, 36000000, 0, (int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value -1 for minuteOfHour must be in the range [0,59]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
    }

    @Test
    public void test249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test249");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        Chronology chronology2 = null;
        DateMidnight dateMidnight3 = dateMidnight1.withChronology(chronology2);
        DateMidnight dateMidnight5 = dateMidnight3.minus((long) 5);
        org.junit.Assert.assertNotNull(dateMidnight3);
        org.junit.Assert.assertNotNull(dateMidnight5);
    }

    @Test
    public void test250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test250");
        org.joda.time.format.PeriodFormatter periodFormatter0 = org.joda.time.format.ISOPeriodFormat.alternateExtendedWithWeeks();
        java.util.Locale locale1 = periodFormatter0.getLocale();
        // The following exception was thrown during execution in test generation
        try {
            Period period3 = periodFormatter0.parsePeriod("");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid format: \"\"");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(periodFormatter0);
        org.junit.Assert.assertNull(locale1);
    }

    @Test
    public void test251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test251");
        LocalDate localDate0 = new LocalDate();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        DateTimeField dateTimeField3 = ethiopicChronology1.minuteOfHour();
        org.joda.time.chrono.CopticChronology copticChronology5 = org.joda.time.chrono.CopticChronology.getInstanceUTC();
        LocalDateTime localDateTime6 = new LocalDateTime((-35999994L), (Chronology) copticChronology5);
        LocalDateTime localDateTime8 = localDateTime6.plusDays((int) (byte) -1);
        DateMidnight dateMidnight10 = new DateMidnight(0L);
        Chronology chronology11 = null;
        DateMidnight dateMidnight12 = dateMidnight10.withChronology(chronology11);
        DateMidnight dateMidnight14 = dateMidnight10.withCenturyOfEra((int) ' ');
        DateMidnight.Property property15 = dateMidnight10.dayOfMonth();
        DateMidnight dateMidnight17 = new DateMidnight(0L);
        Chronology chronology18 = null;
        DateMidnight dateMidnight19 = dateMidnight17.withChronology(chronology18);
        DateMidnight dateMidnight21 = dateMidnight17.withCenturyOfEra((int) ' ');
        DateMidnight.Property property22 = dateMidnight17.dayOfMonth();
        int int23 = dateMidnight17.getMinuteOfHour();
        Duration duration24 = new Duration((ReadableInstant) dateMidnight10, (ReadableInstant) dateMidnight17);
        LocalDateTime localDateTime26 = localDateTime8.withDurationAdded((ReadableDuration) duration24, 12);
        DateTime dateTime27 = localDateTime8.toDateTime();
        int int28 = dateTimeField3.getMinimumValue((ReadablePartial) localDateTime8);
        // The following exception was thrown during execution in test generation
        try {
            int int29 = localDate0.compareTo((ReadablePartial) localDateTime8);
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: ReadablePartial objects must have matching field types");
        } catch (ClassCastException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(copticChronology5);
        org.junit.Assert.assertNotNull(localDateTime8);
        org.junit.Assert.assertNotNull(dateMidnight12);
        org.junit.Assert.assertNotNull(dateMidnight14);
        org.junit.Assert.assertNotNull(property15);
        org.junit.Assert.assertNotNull(dateMidnight19);
        org.junit.Assert.assertNotNull(dateMidnight21);
        org.junit.Assert.assertNotNull(property22);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + 0 + "'", int23 == 0);
        org.junit.Assert.assertNotNull(localDateTime26);
        org.junit.Assert.assertNotNull(dateTime27);
        org.junit.Assert.assertTrue("'" + int28 + "' != '" + 0 + "'", int28 == 0);
    }

    @Test
    public void test252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test252");
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder0 = new org.joda.time.format.DateTimeFormatterBuilder();
        // The following exception was thrown during execution in test generation
        try {
            org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder3 = dateTimeFormatterBuilder0.appendFractionOfSecond((int) (short) -1, (int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test253");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Weeks weeks6 = Weeks.ONE;
        Interval interval7 = interval5.withPeriodAfterStart((ReadablePeriod) weeks6);
        int[] intArray10 = ethiopicChronology1.get((ReadablePeriod) weeks6, (long) (short) -1, (long) (short) -1);
        DurationField durationField11 = ethiopicChronology1.minutes();
        YearMonthDay yearMonthDay12 = new YearMonthDay(100L, (Chronology) ethiopicChronology1);
        DateTime dateTime13 = yearMonthDay12.toDateTimeAtMidnight();
        DateTimeFieldType dateTimeFieldType14 = DateTimeFieldType.clockhourOfHalfday();
        // The following exception was thrown during execution in test generation
        try {
            YearMonthDay.Property property15 = yearMonthDay12.property(dateTimeFieldType14);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Field 'clockhourOfHalfday' is not supported");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(weeks6);
        org.junit.Assert.assertNotNull(interval7);
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField11);
        org.junit.Assert.assertNotNull(dateTime13);
        org.junit.Assert.assertNotNull(dateTimeFieldType14);
    }

    @Test
    public void test254() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test254");
        // The following exception was thrown during execution in test generation
        try {
            org.joda.time.format.DateTimeFormatter dateTimeFormatter1 = org.joda.time.format.DateTimeFormat.forPattern("2025-05-23T18:38:20.565+10:00");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal pattern component: T");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test255() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test255");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        org.joda.time.chrono.CopticChronology copticChronology3 = org.joda.time.chrono.CopticChronology.getInstance(dateTimeZone2);
        LocalDate localDate4 = new LocalDate((long) (short) 1, (Chronology) copticChronology3);
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(copticChronology3);
    }

    @Test
    public void test256() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test256");
        // The following exception was thrown during execution in test generation
        try {
            Seconds seconds1 = Seconds.parseSeconds("18:39:07.849");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid format: \"18:39:07.849\"");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test257() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test257");
        LocalDate localDate0 = new LocalDate();
        LocalDate localDate2 = localDate0.minusWeeks(3);
        LocalDate.Property property3 = localDate2.monthOfYear();
        Interval interval4 = localDate2.toInterval();
        LocalDate localDate5 = new LocalDate();
        LocalDate localDate7 = localDate5.minusWeeks(3);
        LocalDate.Property property8 = localDate7.monthOfYear();
        LocalDate localDate9 = property8.roundHalfFloorCopy();
        LocalDate localDate10 = new LocalDate();
        DateTimeFieldType dateTimeFieldType11 = DateTimeFieldType.weekyearOfCentury();
        int int12 = localDate10.indexOf(dateTimeFieldType11);
        LocalDate localDate14 = localDate10.withDayOfYear(24);
        int int15 = localDate9.compareTo((ReadablePartial) localDate14);
        Weeks weeks16 = Weeks.weeksBetween((ReadablePartial) localDate2, (ReadablePartial) localDate9);
        LocalDate.Property property17 = localDate2.centuryOfEra();
        org.junit.Assert.assertNotNull(localDate2);
        org.junit.Assert.assertNotNull(property3);
        org.junit.Assert.assertNotNull(interval4);
        org.junit.Assert.assertNotNull(localDate7);
        org.junit.Assert.assertNotNull(property8);
        org.junit.Assert.assertNotNull(localDate9);
        org.junit.Assert.assertNotNull(dateTimeFieldType11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + (-1) + "'", int12 == (-1));
        org.junit.Assert.assertNotNull(localDate14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 1 + "'", int15 == 1);
        org.junit.Assert.assertNotNull(weeks16);
        org.junit.Assert.assertNotNull(property17);
    }

    @Test
    public void test258() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test258");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField4 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField3);
        int int6 = delegatedDateTimeField4.get((long) (byte) 10);
        LocalDate localDate7 = new LocalDate();
        LocalDate localDate9 = localDate7.minusWeeks(3);
        LocalDate.Property property10 = localDate9.monthOfYear();
        java.util.Locale locale12 = null;
        String str13 = delegatedDateTimeField4.getAsText((ReadablePartial) localDate9, (int) (byte) 10, locale12);
        long long15 = delegatedDateTimeField4.roundHalfEven((long) 1);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
        org.junit.Assert.assertNotNull(localDate9);
        org.junit.Assert.assertNotNull(property10);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "10" + "'", str13, "10");
        org.junit.Assert.assertTrue("'" + long15 + "' != '" + 0L + "'", long15 == 0L);
    }

    @Test
    public void test259() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test259");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology2 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone3 = ethiopicChronology2.getZone();
        Object obj4 = null;
        Chronology chronology5 = null;
        Interval interval6 = new Interval(obj4, chronology5);
        Weeks weeks7 = Weeks.ONE;
        Interval interval8 = interval6.withPeriodAfterStart((ReadablePeriod) weeks7);
        int[] intArray11 = ethiopicChronology2.get((ReadablePeriod) weeks7, (long) (short) -1, (long) (short) -1);
        DurationField durationField12 = ethiopicChronology2.minutes();
        DateTimeField dateTimeField13 = ethiopicChronology2.clockhourOfDay();
        MutablePeriod mutablePeriod14 = new MutablePeriod((long) '#', (long) (byte) -1, (Chronology) ethiopicChronology2);
        mutablePeriod14.addHours(9);
        org.junit.Assert.assertNotNull(ethiopicChronology2);
        org.junit.Assert.assertNotNull(dateTimeZone3);
        org.junit.Assert.assertNotNull(weeks7);
        org.junit.Assert.assertNotNull(interval8);
        org.junit.Assert.assertNotNull(intArray11);
        org.junit.Assert.assertArrayEquals(intArray11, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField12);
        org.junit.Assert.assertNotNull(dateTimeField13);
    }

    @Test
    public void test260() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test260");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Weeks weeks6 = Weeks.ONE;
        Interval interval7 = interval5.withPeriodAfterStart((ReadablePeriod) weeks6);
        int[] intArray10 = ethiopicChronology1.get((ReadablePeriod) weeks6, (long) (short) -1, (long) (short) -1);
        DurationField durationField11 = ethiopicChronology1.minutes();
        MonthDay monthDay12 = new MonthDay((-35999994L), (Chronology) ethiopicChronology1);
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(weeks6);
        org.junit.Assert.assertNotNull(interval7);
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField11);
    }

    @Test
    public void test261() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test261");
        DateTimeZone dateTimeZone1 = null;
        MutableDateTime mutableDateTime2 = new MutableDateTime((long) 10080, dateTimeZone1);
        DateMidnight dateMidnight4 = new DateMidnight(0L);
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        boolean boolean7 = dateMidnight4.isEqual((ReadableInstant) dateMidnight6);
        int int8 = dateMidnight4.getSecondOfDay();
        DateMidnight dateMidnight10 = dateMidnight4.plus((long) 36000000);
        mutableDateTime2.setMillis((ReadableInstant) dateMidnight10);
        mutableDateTime2.setYear(60);
        Chronology chronology14 = DateTimeUtils.getInstantChronology((ReadableInstant) mutableDateTime2);
        DateTimeFieldType dateTimeFieldType15 = DateTimeFieldType.year();
        boolean boolean16 = mutableDateTime2.isSupported(dateTimeFieldType15);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateMidnight10);
        org.junit.Assert.assertNotNull(chronology14);
        org.junit.Assert.assertNotNull(dateTimeFieldType15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
    }

    @Test
    public void test262() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test262");
        MutablePeriod mutablePeriod8 = new MutablePeriod((int) (short) 10, 1000, 1000, (int) ' ', 10, (int) '#', (int) (short) 0, 12);
    }

    @Test
    public void test263() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test263");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        Duration duration4 = interval2.toDuration();
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        PeriodType periodType7 = PeriodType.days();
        MutablePeriod mutablePeriod8 = new MutablePeriod((ReadableDuration) duration4, (ReadableInstant) dateMidnight6, periodType7);
        Object obj9 = null;
        Chronology chronology10 = null;
        Interval interval11 = new Interval(obj9, chronology10);
        Months months12 = Months.monthsIn((ReadableInterval) interval11);
        Duration duration13 = interval11.toDuration();
        Object obj14 = null;
        Chronology chronology15 = null;
        Interval interval16 = new Interval(obj14, chronology15);
        Months months17 = Months.monthsIn((ReadableInterval) interval16);
        Duration duration18 = interval16.toDuration();
        boolean boolean19 = duration13.isEqual((ReadableDuration) duration18);
        boolean boolean20 = duration4.isEqual((ReadableDuration) duration18);
        DateMidnight dateMidnight22 = new DateMidnight(0L);
        Chronology chronology23 = null;
        DateMidnight dateMidnight24 = dateMidnight22.withChronology(chronology23);
        Period period25 = new Period((ReadableDuration) duration4, (ReadableInstant) dateMidnight24);
        Period period26 = period25.toPeriod();
        Period period27 = period25.toPeriod();
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertNotNull(duration4);
        org.junit.Assert.assertNotNull(periodType7);
        org.junit.Assert.assertNotNull(months12);
        org.junit.Assert.assertNotNull(duration13);
        org.junit.Assert.assertNotNull(months17);
        org.junit.Assert.assertNotNull(duration18);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
        org.junit.Assert.assertNotNull(dateMidnight24);
        org.junit.Assert.assertNotNull(period26);
        org.junit.Assert.assertNotNull(period27);
    }

    @Test
    public void test264() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test264");
        org.joda.time.chrono.CopticChronology copticChronology1 = org.joda.time.chrono.CopticChronology.getInstanceUTC();
        LocalDateTime localDateTime2 = new LocalDateTime((-35999994L), (Chronology) copticChronology1);
        LocalDateTime localDateTime4 = localDateTime2.plusDays((int) (byte) -1);
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        Chronology chronology7 = null;
        DateMidnight dateMidnight8 = dateMidnight6.withChronology(chronology7);
        DateMidnight dateMidnight10 = dateMidnight6.withCenturyOfEra((int) ' ');
        DateMidnight.Property property11 = dateMidnight6.dayOfMonth();
        DateMidnight dateMidnight13 = new DateMidnight(0L);
        Chronology chronology14 = null;
        DateMidnight dateMidnight15 = dateMidnight13.withChronology(chronology14);
        DateMidnight dateMidnight17 = dateMidnight13.withCenturyOfEra((int) ' ');
        DateMidnight.Property property18 = dateMidnight13.dayOfMonth();
        int int19 = dateMidnight13.getMinuteOfHour();
        Duration duration20 = new Duration((ReadableInstant) dateMidnight6, (ReadableInstant) dateMidnight13);
        LocalDateTime localDateTime22 = localDateTime4.withDurationAdded((ReadableDuration) duration20, 12);
        LocalDate localDate23 = new LocalDate();
        LocalDate localDate25 = localDate23.minusWeeks(3);
        LocalDate.Property property26 = localDate25.monthOfYear();
        Interval interval27 = localDate25.toInterval();
        LocalDate localDate28 = new LocalDate();
        LocalDate localDate30 = localDate28.minusWeeks(3);
        LocalDate.Property property31 = localDate30.monthOfYear();
        LocalDate localDate32 = property31.roundHalfFloorCopy();
        LocalDate localDate33 = new LocalDate();
        DateTimeFieldType dateTimeFieldType34 = DateTimeFieldType.weekyearOfCentury();
        int int35 = localDate33.indexOf(dateTimeFieldType34);
        LocalDate localDate37 = localDate33.withDayOfYear(24);
        int int38 = localDate32.compareTo((ReadablePartial) localDate37);
        Weeks weeks39 = Weeks.weeksBetween((ReadablePartial) localDate25, (ReadablePartial) localDate32);
        // The following exception was thrown during execution in test generation
        try {
            Period period40 = Period.fieldDifference((ReadablePartial) localDateTime4, (ReadablePartial) localDate32);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: ReadablePartial objects must have the same set of fields");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(copticChronology1);
        org.junit.Assert.assertNotNull(localDateTime4);
        org.junit.Assert.assertNotNull(dateMidnight8);
        org.junit.Assert.assertNotNull(dateMidnight10);
        org.junit.Assert.assertNotNull(property11);
        org.junit.Assert.assertNotNull(dateMidnight15);
        org.junit.Assert.assertNotNull(dateMidnight17);
        org.junit.Assert.assertNotNull(property18);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 0 + "'", int19 == 0);
        org.junit.Assert.assertNotNull(localDateTime22);
        org.junit.Assert.assertNotNull(localDate25);
        org.junit.Assert.assertNotNull(property26);
        org.junit.Assert.assertNotNull(interval27);
        org.junit.Assert.assertNotNull(localDate30);
        org.junit.Assert.assertNotNull(property31);
        org.junit.Assert.assertNotNull(localDate32);
        org.junit.Assert.assertNotNull(dateTimeFieldType34);
        org.junit.Assert.assertTrue("'" + int35 + "' != '" + (-1) + "'", int35 == (-1));
        org.junit.Assert.assertNotNull(localDate37);
        org.junit.Assert.assertTrue("'" + int38 + "' != '" + 1 + "'", int38 == 1);
        org.junit.Assert.assertNotNull(weeks39);
    }

    @Test
    public void test265() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test265");
        DateTime dateTime1 = DateTime.parse("23");
        LocalDate localDate2 = new LocalDate();
        DateTime dateTime3 = dateTime1.withFields((ReadablePartial) localDate2);
        String str4 = dateTime3.toString();
        org.junit.Assert.assertNotNull(dateTime1);
        org.junit.Assert.assertNotNull(dateTime3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "2025-05-23T00:00:00.000+10:00" + "'", str4, "2025-05-23T00:00:00.000+10:00");
    }

    @Test
    public void test266() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test266");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Weeks weeks2 = Weeks.ONE;
        int[] intArray5 = ethiopicChronology0.get((ReadablePeriod) weeks2, (long) (short) 1, 100L);
        DateTimeField dateTimeField6 = ethiopicChronology0.millisOfDay();
        DateTimeField dateTimeField7 = ethiopicChronology0.year();
        DateTime dateTime8 = DateTime.now((Chronology) ethiopicChronology0);
        DateTime dateTime10 = dateTime8.minusMillis(36000000);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks2);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField6);
        org.junit.Assert.assertNotNull(dateTimeField7);
        org.junit.Assert.assertNotNull(dateTime8);
        org.junit.Assert.assertNotNull(dateTime10);
    }

    @Test
    public void test267() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test267");
        DateTimeFieldType dateTimeFieldType0 = DateTimeFieldType.clockhourOfDay();
        org.junit.Assert.assertNotNull(dateTimeFieldType0);
    }

    @Test
    public void test268() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test268");
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder0 = new org.joda.time.format.DateTimeFormatterBuilder();
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder3 = dateTimeFormatterBuilder0.appendCenturyOfEra(9, 2);
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder5 = dateTimeFormatterBuilder3.appendWeekOfWeekyear((int) (byte) 0);
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder3);
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder5);
    }

    @Test
    public void test269() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test269");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        DurationField durationField6 = ethiopicChronology4.hours();
        int int8 = durationField6.getValue(0L);
        DateTimeFieldType dateTimeFieldType9 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField11 = new org.joda.time.field.DividedDateTimeField(dateTimeField3, durationField6, dateTimeFieldType9, (int) '4');
        java.util.Locale locale13 = null;
        String str14 = dividedDateTimeField11.getAsText((long) (-1), locale13);
        long long17 = dividedDateTimeField11.add(456878073600000L, 24);
        int int18 = dividedDateTimeField11.getMaximumValue();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType9);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
        org.junit.Assert.assertTrue("'" + long17 + "' != '" + 456882566400000L + "'", long17 == 456882566400000L);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 0 + "'", int18 == 0);
    }

    @Test
    public void test270() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test270");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField4 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField3);
        int int6 = delegatedDateTimeField4.get((long) (byte) 10);
        java.util.Locale locale8 = null;
        String str9 = delegatedDateTimeField4.getAsShortText((long) (byte) 10, locale8);
        int int12 = delegatedDateTimeField4.getDifference(31158917L, (-35999994L));
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "10" + "'", str9, "10");
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 18 + "'", int12 == 18);
    }

    @Test
    public void test271() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test271");
        Hours hours0 = Hours.SIX;
        MutablePeriod mutablePeriod1 = hours0.toMutablePeriod();
        mutablePeriod1.setSeconds((int) (short) 0);
        int int4 = mutablePeriod1.getMinutes();
        int int5 = mutablePeriod1.getDays();
        org.junit.Assert.assertNotNull(hours0);
        org.junit.Assert.assertNotNull(mutablePeriod1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test272() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test272");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Weeks weeks6 = Weeks.ONE;
        Interval interval7 = interval5.withPeriodAfterStart((ReadablePeriod) weeks6);
        int[] intArray10 = ethiopicChronology1.get((ReadablePeriod) weeks6, (long) (short) -1, (long) (short) -1);
        DurationField durationField11 = ethiopicChronology1.minutes();
        YearMonthDay yearMonthDay12 = new YearMonthDay(100L, (Chronology) ethiopicChronology1);
        DateTime dateTime13 = yearMonthDay12.toDateTimeAtMidnight();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology15 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone16 = ethiopicChronology15.getZone();
        Object obj17 = null;
        Chronology chronology18 = null;
        Interval interval19 = new Interval(obj17, chronology18);
        Weeks weeks20 = Weeks.ONE;
        Interval interval21 = interval19.withPeriodAfterStart((ReadablePeriod) weeks20);
        int[] intArray24 = ethiopicChronology15.get((ReadablePeriod) weeks20, (long) (short) -1, (long) (short) -1);
        DurationField durationField25 = ethiopicChronology15.minutes();
        YearMonthDay yearMonthDay26 = new YearMonthDay(100L, (Chronology) ethiopicChronology15);
        DateTimeField dateTimeField27 = ethiopicChronology15.minuteOfDay();
        DateTimeField dateTimeField28 = ethiopicChronology15.dayOfMonth();
        DateTimeZone dateTimeZone29 = ethiopicChronology15.getZone();
        Interval interval30 = yearMonthDay12.toInterval(dateTimeZone29);
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(weeks6);
        org.junit.Assert.assertNotNull(interval7);
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField11);
        org.junit.Assert.assertNotNull(dateTime13);
        org.junit.Assert.assertNotNull(ethiopicChronology15);
        org.junit.Assert.assertNotNull(dateTimeZone16);
        org.junit.Assert.assertNotNull(weeks20);
        org.junit.Assert.assertNotNull(interval21);
        org.junit.Assert.assertNotNull(intArray24);
        org.junit.Assert.assertArrayEquals(intArray24, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField25);
        org.junit.Assert.assertNotNull(dateTimeField27);
        org.junit.Assert.assertNotNull(dateTimeField28);
        org.junit.Assert.assertNotNull(dateTimeZone29);
        org.junit.Assert.assertNotNull(interval30);
    }

    @Test
    public void test273() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test273");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        Chronology chronology2 = null;
        DateMidnight dateMidnight3 = dateMidnight1.withChronology(chronology2);
        Object obj4 = null;
        Chronology chronology5 = null;
        Interval interval6 = new Interval(obj4, chronology5);
        Months months7 = Months.monthsIn((ReadableInterval) interval6);
        Duration duration8 = interval6.toDuration();
        DateMidnight dateMidnight10 = new DateMidnight(0L);
        PeriodType periodType11 = PeriodType.days();
        MutablePeriod mutablePeriod12 = new MutablePeriod((ReadableDuration) duration8, (ReadableInstant) dateMidnight10, periodType11);
        DateMidnight dateMidnight14 = new DateMidnight(0L);
        Chronology chronology15 = null;
        DateMidnight dateMidnight16 = dateMidnight14.withChronology(chronology15);
        DateMidnight dateMidnight18 = dateMidnight14.withCenturyOfEra((int) ' ');
        Object obj19 = null;
        Chronology chronology20 = null;
        Interval interval21 = new Interval(obj19, chronology20);
        Months months22 = Months.monthsIn((ReadableInterval) interval21);
        Duration duration23 = interval21.toDuration();
        DateMidnight dateMidnight25 = new DateMidnight(0L);
        PeriodType periodType26 = PeriodType.days();
        MutablePeriod mutablePeriod27 = new MutablePeriod((ReadableDuration) duration23, (ReadableInstant) dateMidnight25, periodType26);
        Period period28 = duration8.toPeriodFrom((ReadableInstant) dateMidnight14, periodType26);
        boolean boolean29 = dateMidnight1.isAfter((ReadableInstant) dateMidnight14);
        ReadableInstant readableInstant30 = null;
        // The following exception was thrown during execution in test generation
        try {
            Days days31 = Days.daysBetween((ReadableInstant) dateMidnight14, readableInstant30);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: ReadableInstant objects must not be null");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(dateMidnight3);
        org.junit.Assert.assertNotNull(months7);
        org.junit.Assert.assertNotNull(duration8);
        org.junit.Assert.assertNotNull(periodType11);
        org.junit.Assert.assertNotNull(dateMidnight16);
        org.junit.Assert.assertNotNull(dateMidnight18);
        org.junit.Assert.assertNotNull(months22);
        org.junit.Assert.assertNotNull(duration23);
        org.junit.Assert.assertNotNull(periodType26);
        org.junit.Assert.assertNotNull(period28);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
    }

    @Test
    public void test274() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test274");
        StringBuffer stringBuffer0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.joda.time.format.FormatUtils.appendPaddedInteger(stringBuffer0, 36000000, 36000000);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test275() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test275");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        long long5 = dateTimeZone1.convertLocalToUTC((long) 6, false, 0L);
        YearMonthDay yearMonthDay6 = new YearMonthDay(dateTimeZone1);
        int int7 = yearMonthDay6.getYear();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertTrue("'" + long5 + "' != '" + (-35999994L) + "'", long5 == (-35999994L));
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 2025 + "'", int7 == 2025);
    }

    @Test
    public void test276() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test276");
        org.joda.time.format.DateTimePrinter dateTimePrinter0 = null;
        org.joda.time.format.DateTimeParser dateTimeParser1 = null;
        org.joda.time.format.DateTimeFormatter dateTimeFormatter2 = new org.joda.time.format.DateTimeFormatter(dateTimePrinter0, dateTimeParser1);
    }

    @Test
    public void test277() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test277");
        LocalDate localDate0 = new LocalDate();
        LocalDate localDate2 = localDate0.minusWeeks(3);
        LocalDate.Property property3 = localDate2.monthOfYear();
        Interval interval4 = localDate2.toInterval();
        DateTime dateTime5 = new DateTime();
        DateTime.Property property6 = dateTime5.hourOfDay();
        int int7 = dateTime5.getDayOfYear();
        boolean boolean8 = interval4.isAfter((ReadableInstant) dateTime5);
        org.junit.Assert.assertNotNull(localDate2);
        org.junit.Assert.assertNotNull(property3);
        org.junit.Assert.assertNotNull(interval4);
        org.junit.Assert.assertNotNull(property6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 143 + "'", int7 == 143);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test278() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test278");
        DateTimeZone dateTimeZone1 = null;
        MutableDateTime mutableDateTime2 = new MutableDateTime((long) 10080, dateTimeZone1);
        mutableDateTime2.setDayOfYear(6);
        mutableDateTime2.addMinutes(1920);
    }

    @Test
    public void test279() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test279");
        org.joda.time.chrono.CopticChronology copticChronology0 = org.joda.time.chrono.CopticChronology.getInstanceUTC();
        DateTimeField dateTimeField1 = copticChronology0.year();
        TimeOfDay timeOfDay2 = new TimeOfDay();
        Weeks weeks3 = Weeks.ONE;
        Period period4 = weeks3.toPeriod();
        TimeOfDay timeOfDay5 = timeOfDay2.minus((ReadablePeriod) weeks3);
        LocalTime localTime6 = new LocalTime((Object) timeOfDay2);
        String str7 = localTime6.toString();
        int[] intArray9 = copticChronology0.get((ReadablePartial) localTime6, (long) 5);
        LocalTime localTime11 = localTime6.plusMinutes(9);
        org.junit.Assert.assertNotNull(copticChronology0);
        org.junit.Assert.assertNotNull(dateTimeField1);
        org.junit.Assert.assertNotNull(weeks3);
        org.junit.Assert.assertNotNull(period4);
        org.junit.Assert.assertNotNull(timeOfDay5);
// flaky "10) test279(RegressionTest0)":         org.junit.Assert.assertEquals("'" + str7 + "' != '" + "18:39:28.603" + "'", str7, "18:39:28.603");
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertArrayEquals(intArray9, new int[] { 0, 0, 0, 5 });
        org.junit.Assert.assertNotNull(localTime11);
    }

    @Test
    public void test280() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test280");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Object obj2 = null;
        Chronology chronology3 = null;
        Interval interval4 = new Interval(obj2, chronology3);
        Weeks weeks5 = Weeks.ONE;
        Interval interval6 = interval4.withPeriodAfterStart((ReadablePeriod) weeks5);
        int[] intArray9 = ethiopicChronology0.get((ReadablePeriod) weeks5, (long) (short) -1, (long) (short) -1);
        DurationField durationField10 = ethiopicChronology0.minutes();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology11 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone12 = ethiopicChronology11.getZone();
        DurationField durationField13 = ethiopicChronology11.hours();
        DateTimeField dateTimeField14 = ethiopicChronology11.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField15 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField14);
        int int17 = delegatedDateTimeField15.get((long) (byte) 10);
        LocalDate localDate18 = new LocalDate();
        LocalDate localDate20 = localDate18.minusWeeks(3);
        LocalDate.Property property21 = localDate20.monthOfYear();
        java.util.Locale locale23 = null;
        String str24 = delegatedDateTimeField15.getAsText((ReadablePartial) localDate20, (int) (byte) 10, locale23);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology25 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone26 = ethiopicChronology25.getZone();
        long long30 = dateTimeZone26.convertLocalToUTC((long) 6, false, 0L);
        YearMonthDay yearMonthDay31 = new YearMonthDay(dateTimeZone26);
        DateTime dateTime32 = localDate20.toDateTimeAtStartOfDay(dateTimeZone26);
        LocalDate localDate34 = localDate20.withWeekyear(1);
        int[] intArray36 = ethiopicChronology0.get((ReadablePartial) localDate20, (long) 24);
        // The following exception was thrown during execution in test generation
        try {
            LocalDate localDate38 = localDate20.withEra((int) '4');
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 52 for era must be in the range [0,1]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks5);
        org.junit.Assert.assertNotNull(interval6);
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertArrayEquals(intArray9, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField10);
        org.junit.Assert.assertNotNull(ethiopicChronology11);
        org.junit.Assert.assertNotNull(dateTimeZone12);
        org.junit.Assert.assertNotNull(durationField13);
        org.junit.Assert.assertNotNull(dateTimeField14);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 10 + "'", int17 == 10);
        org.junit.Assert.assertNotNull(localDate20);
        org.junit.Assert.assertNotNull(property21);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "10" + "'", str24, "10");
        org.junit.Assert.assertNotNull(ethiopicChronology25);
        org.junit.Assert.assertNotNull(dateTimeZone26);
        org.junit.Assert.assertTrue("'" + long30 + "' != '" + (-35999994L) + "'", long30 == (-35999994L));
        org.junit.Assert.assertNotNull(dateTime32);
        org.junit.Assert.assertNotNull(localDate34);
        org.junit.Assert.assertNotNull(intArray36);
        org.junit.Assert.assertArrayEquals(intArray36, new int[] { 1962, 4, 23 });
    }

    @Test
    public void test281() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test281");
        DateTime dateTime1 = DateTime.parse("23");
        LocalDate localDate2 = new LocalDate();
        DateTime dateTime3 = dateTime1.withFields((ReadablePartial) localDate2);
        // The following exception was thrown during execution in test generation
        try {
            LocalDate localDate5 = localDate2.withEra(6);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 6 for era must be in the range [0,1]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(dateTime1);
        org.junit.Assert.assertNotNull(dateTime3);
    }

    @Test
    public void test282() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test282");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DateTimeField dateTimeField2 = ethiopicChronology0.minuteOfHour();
        MonthDay monthDay3 = new MonthDay((Chronology) ethiopicChronology0);
        MonthDay.Property property4 = monthDay3.dayOfMonth();
        DateTimeField dateTimeField5 = property4.getField();
        DurationField durationField6 = property4.getRangeDurationField();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(dateTimeField2);
        org.junit.Assert.assertNotNull(property4);
        org.junit.Assert.assertNotNull(dateTimeField5);
        org.junit.Assert.assertNotNull(durationField6);
    }

    @Test
    public void test283() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test283");
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder0 = new org.joda.time.format.DateTimeFormatterBuilder();
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder2 = dateTimeFormatterBuilder0.appendWeekOfWeekyear(3);
        boolean boolean3 = dateTimeFormatterBuilder2.canBuildPrinter();
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test284() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test284");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeField dateTimeField1 = ethiopicChronology0.monthOfYear();
        DateTimeField dateTimeField2 = ethiopicChronology0.hourOfDay();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeField1);
        org.junit.Assert.assertNotNull(dateTimeField2);
    }

    @Test
    public void test285() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test285");
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder0 = new org.joda.time.format.DateTimeFormatterBuilder();
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder3 = dateTimeFormatterBuilder0.appendCenturyOfEra(9, 2);
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder5 = dateTimeFormatterBuilder0.appendHourOfHalfday(100);
        // The following exception was thrown during execution in test generation
        try {
            org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder8 = dateTimeFormatterBuilder5.appendYearOfCentury(0, (int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: null");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder3);
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder5);
    }

    @Test
    public void test286() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test286");
        MutableDateTime mutableDateTime0 = MutableDateTime.now();
        Object obj1 = null;
        Chronology chronology2 = null;
        Interval interval3 = new Interval(obj1, chronology2);
        Months months4 = Months.monthsIn((ReadableInterval) interval3);
        Duration duration5 = interval3.toDuration();
        DateMidnight dateMidnight7 = new DateMidnight(0L);
        PeriodType periodType8 = PeriodType.days();
        MutablePeriod mutablePeriod9 = new MutablePeriod((ReadableDuration) duration5, (ReadableInstant) dateMidnight7, periodType8);
        Chronology chronology10 = null;
        Period period11 = duration5.toPeriod(chronology10);
        Object obj12 = null;
        Chronology chronology13 = null;
        Interval interval14 = new Interval(obj12, chronology13);
        Months months15 = Months.monthsIn((ReadableInterval) interval14);
        Duration duration16 = interval14.toDuration();
        DateMidnight dateMidnight18 = new DateMidnight(0L);
        PeriodType periodType19 = PeriodType.days();
        MutablePeriod mutablePeriod20 = new MutablePeriod((ReadableDuration) duration16, (ReadableInstant) dateMidnight18, periodType19);
        boolean boolean21 = duration5.isShorterThan((ReadableDuration) duration16);
        mutableDateTime0.add((ReadableDuration) duration16, 10);
        mutableDateTime0.setWeekOfWeekyear((int) (byte) 1);
        mutableDateTime0.addHours((int) (short) 1);
        mutableDateTime0.setWeekyear(7);
        DateMidnight dateMidnight31 = new DateMidnight(0L);
        Chronology chronology32 = null;
        DateMidnight dateMidnight33 = dateMidnight31.withChronology(chronology32);
        Object obj34 = null;
        Chronology chronology35 = null;
        Interval interval36 = new Interval(obj34, chronology35);
        Months months37 = Months.monthsIn((ReadableInterval) interval36);
        Duration duration38 = interval36.toDuration();
        DateMidnight dateMidnight40 = new DateMidnight(0L);
        PeriodType periodType41 = PeriodType.days();
        MutablePeriod mutablePeriod42 = new MutablePeriod((ReadableDuration) duration38, (ReadableInstant) dateMidnight40, periodType41);
        DateMidnight dateMidnight44 = new DateMidnight(0L);
        Chronology chronology45 = null;
        DateMidnight dateMidnight46 = dateMidnight44.withChronology(chronology45);
        DateMidnight dateMidnight48 = dateMidnight44.withCenturyOfEra((int) ' ');
        Object obj49 = null;
        Chronology chronology50 = null;
        Interval interval51 = new Interval(obj49, chronology50);
        Months months52 = Months.monthsIn((ReadableInterval) interval51);
        Duration duration53 = interval51.toDuration();
        DateMidnight dateMidnight55 = new DateMidnight(0L);
        PeriodType periodType56 = PeriodType.days();
        MutablePeriod mutablePeriod57 = new MutablePeriod((ReadableDuration) duration53, (ReadableInstant) dateMidnight55, periodType56);
        Period period58 = duration38.toPeriodFrom((ReadableInstant) dateMidnight44, periodType56);
        boolean boolean59 = dateMidnight31.isAfter((ReadableInstant) dateMidnight44);
        boolean boolean60 = mutableDateTime0.isBefore((ReadableInstant) dateMidnight31);
        boolean boolean61 = mutableDateTime0.isEqualNow();
        org.junit.Assert.assertNotNull(mutableDateTime0);
        org.junit.Assert.assertNotNull(months4);
        org.junit.Assert.assertNotNull(duration5);
        org.junit.Assert.assertNotNull(periodType8);
        org.junit.Assert.assertNotNull(period11);
        org.junit.Assert.assertNotNull(months15);
        org.junit.Assert.assertNotNull(duration16);
        org.junit.Assert.assertNotNull(periodType19);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(dateMidnight33);
        org.junit.Assert.assertNotNull(months37);
        org.junit.Assert.assertNotNull(duration38);
        org.junit.Assert.assertNotNull(periodType41);
        org.junit.Assert.assertNotNull(dateMidnight46);
        org.junit.Assert.assertNotNull(dateMidnight48);
        org.junit.Assert.assertNotNull(months52);
        org.junit.Assert.assertNotNull(duration53);
        org.junit.Assert.assertNotNull(periodType56);
        org.junit.Assert.assertNotNull(period58);
        org.junit.Assert.assertTrue("'" + boolean59 + "' != '" + false + "'", boolean59 == false);
        org.junit.Assert.assertTrue("'" + boolean60 + "' != '" + true + "'", boolean60 == true);
        org.junit.Assert.assertTrue("'" + boolean61 + "' != '" + false + "'", boolean61 == false);
    }

    @Test
    public void test287() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test287");
        MutableInterval mutableInterval2 = new MutableInterval((long) (byte) -1, (long) 1);
        MutableInterval mutableInterval3 = mutableInterval2.copy();
        mutableInterval3.setDurationAfterStart((long) (byte) 0);
        Object obj6 = null;
        Chronology chronology7 = null;
        Interval interval8 = new Interval(obj6, chronology7);
        Months months9 = Months.monthsIn((ReadableInterval) interval8);
        Duration duration10 = interval8.toDuration();
        DateMidnight dateMidnight12 = new DateMidnight(0L);
        PeriodType periodType13 = PeriodType.days();
        MutablePeriod mutablePeriod14 = new MutablePeriod((ReadableDuration) duration10, (ReadableInstant) dateMidnight12, periodType13);
        int int15 = mutablePeriod14.getYears();
        Object obj16 = null;
        Chronology chronology17 = null;
        Interval interval18 = new Interval(obj16, chronology17);
        Months months19 = Months.monthsIn((ReadableInterval) interval18);
        Duration duration20 = interval18.toDuration();
        DateMidnight dateMidnight22 = new DateMidnight(0L);
        PeriodType periodType23 = PeriodType.days();
        MutablePeriod mutablePeriod24 = new MutablePeriod((ReadableDuration) duration20, (ReadableInstant) dateMidnight22, periodType23);
        Object obj25 = null;
        Chronology chronology26 = null;
        Interval interval27 = new Interval(obj25, chronology26);
        Months months28 = Months.monthsIn((ReadableInterval) interval27);
        Duration duration29 = interval27.toDuration();
        Object obj30 = null;
        Chronology chronology31 = null;
        Interval interval32 = new Interval(obj30, chronology31);
        Months months33 = Months.monthsIn((ReadableInterval) interval32);
        Duration duration34 = interval32.toDuration();
        boolean boolean35 = duration29.isEqual((ReadableDuration) duration34);
        boolean boolean36 = duration20.isEqual((ReadableDuration) duration34);
        mutablePeriod14.setPeriod((ReadableDuration) duration34);
        mutableInterval3.setDurationAfterStart((ReadableDuration) duration34);
        MutableInterval mutableInterval39 = mutableInterval3.copy();
        DateTime dateTime40 = mutableInterval39.getStart();
        DateTime dateTime42 = dateTime40.withWeekOfWeekyear((int) '#');
        org.junit.Assert.assertNotNull(mutableInterval3);
        org.junit.Assert.assertNotNull(months9);
        org.junit.Assert.assertNotNull(duration10);
        org.junit.Assert.assertNotNull(periodType13);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNotNull(months19);
        org.junit.Assert.assertNotNull(duration20);
        org.junit.Assert.assertNotNull(periodType23);
        org.junit.Assert.assertNotNull(months28);
        org.junit.Assert.assertNotNull(duration29);
        org.junit.Assert.assertNotNull(months33);
        org.junit.Assert.assertNotNull(duration34);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + true + "'", boolean35 == true);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        org.junit.Assert.assertNotNull(mutableInterval39);
        org.junit.Assert.assertNotNull(dateTime40);
        org.junit.Assert.assertNotNull(dateTime42);
    }

    @Test
    public void test288() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test288");
        Months months0 = Months.MAX_VALUE;
        DurationFieldType durationFieldType1 = null;
        boolean boolean2 = months0.isSupported(durationFieldType1);
        org.junit.Assert.assertNotNull(months0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test289() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test289");
        int int0 = DateTimeConstants.PM;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test290() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test290");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        Object obj6 = null;
        Chronology chronology7 = null;
        Interval interval8 = new Interval(obj6, chronology7);
        Weeks weeks9 = Weeks.ONE;
        Interval interval10 = interval8.withPeriodAfterStart((ReadablePeriod) weeks9);
        int[] intArray13 = ethiopicChronology4.get((ReadablePeriod) weeks9, (long) (short) -1, (long) (short) -1);
        DurationField durationField14 = ethiopicChronology4.minutes();
        DateTimeField dateTimeField15 = ethiopicChronology4.clockhourOfDay();
        MutablePeriod mutablePeriod16 = new MutablePeriod((long) '#', (long) (byte) -1, (Chronology) ethiopicChronology4);
        Period period17 = new Period(322595L, 24L, (Chronology) ethiopicChronology4);
        Period period19 = period17.minusDays(168);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(weeks9);
        org.junit.Assert.assertNotNull(interval10);
        org.junit.Assert.assertNotNull(intArray13);
        org.junit.Assert.assertArrayEquals(intArray13, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField14);
        org.junit.Assert.assertNotNull(dateTimeField15);
        org.junit.Assert.assertNotNull(period19);
    }

    @Test
    public void test291() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test291");
        MutableInterval mutableInterval2 = new MutableInterval((long) (byte) -1, (long) 1);
        MutableInterval mutableInterval3 = mutableInterval2.copy();
        mutableInterval3.setDurationAfterStart((long) (byte) 0);
        Object obj6 = null;
        Chronology chronology7 = null;
        Interval interval8 = new Interval(obj6, chronology7);
        Months months9 = Months.monthsIn((ReadableInterval) interval8);
        Duration duration10 = interval8.toDuration();
        DateMidnight dateMidnight12 = new DateMidnight(0L);
        PeriodType periodType13 = PeriodType.days();
        MutablePeriod mutablePeriod14 = new MutablePeriod((ReadableDuration) duration10, (ReadableInstant) dateMidnight12, periodType13);
        int int15 = mutablePeriod14.getYears();
        Object obj16 = null;
        Chronology chronology17 = null;
        Interval interval18 = new Interval(obj16, chronology17);
        Months months19 = Months.monthsIn((ReadableInterval) interval18);
        Duration duration20 = interval18.toDuration();
        DateMidnight dateMidnight22 = new DateMidnight(0L);
        PeriodType periodType23 = PeriodType.days();
        MutablePeriod mutablePeriod24 = new MutablePeriod((ReadableDuration) duration20, (ReadableInstant) dateMidnight22, periodType23);
        Object obj25 = null;
        Chronology chronology26 = null;
        Interval interval27 = new Interval(obj25, chronology26);
        Months months28 = Months.monthsIn((ReadableInterval) interval27);
        Duration duration29 = interval27.toDuration();
        Object obj30 = null;
        Chronology chronology31 = null;
        Interval interval32 = new Interval(obj30, chronology31);
        Months months33 = Months.monthsIn((ReadableInterval) interval32);
        Duration duration34 = interval32.toDuration();
        boolean boolean35 = duration29.isEqual((ReadableDuration) duration34);
        boolean boolean36 = duration20.isEqual((ReadableDuration) duration34);
        mutablePeriod14.setPeriod((ReadableDuration) duration34);
        mutableInterval3.setDurationAfterStart((ReadableDuration) duration34);
        Duration duration40 = new Duration((long) (short) 0);
        boolean boolean41 = duration34.isShorterThan((ReadableDuration) duration40);
        org.junit.Assert.assertNotNull(mutableInterval3);
        org.junit.Assert.assertNotNull(months9);
        org.junit.Assert.assertNotNull(duration10);
        org.junit.Assert.assertNotNull(periodType13);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNotNull(months19);
        org.junit.Assert.assertNotNull(duration20);
        org.junit.Assert.assertNotNull(periodType23);
        org.junit.Assert.assertNotNull(months28);
        org.junit.Assert.assertNotNull(duration29);
        org.junit.Assert.assertNotNull(months33);
        org.junit.Assert.assertNotNull(duration34);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + true + "'", boolean35 == true);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
    }

    @Test
    public void test292() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test292");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField4 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField3);
        String str6 = delegatedDateTimeField4.getAsShortText((long) 10080);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "10" + "'", str6, "10");
    }

    @Test
    public void test293() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test293");
        DateTimeZone dateTimeZone1 = null;
        MutableDateTime mutableDateTime2 = new MutableDateTime((long) 10080, dateTimeZone1);
        DateMidnight dateMidnight4 = new DateMidnight(0L);
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        boolean boolean7 = dateMidnight4.isEqual((ReadableInstant) dateMidnight6);
        int int8 = dateMidnight4.getSecondOfDay();
        DateMidnight dateMidnight10 = dateMidnight4.plus((long) 36000000);
        mutableDateTime2.setMillis((ReadableInstant) dateMidnight10);
        mutableDateTime2.setYear(60);
        MutableDateTime.Property property14 = mutableDateTime2.year();
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateMidnight10);
        org.junit.Assert.assertNotNull(property14);
    }

    @Test
    public void test294() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test294");
        MutableDateTime mutableDateTime0 = MutableDateTime.now();
        Object obj1 = null;
        Chronology chronology2 = null;
        Interval interval3 = new Interval(obj1, chronology2);
        Months months4 = Months.monthsIn((ReadableInterval) interval3);
        Duration duration5 = interval3.toDuration();
        DateMidnight dateMidnight7 = new DateMidnight(0L);
        PeriodType periodType8 = PeriodType.days();
        MutablePeriod mutablePeriod9 = new MutablePeriod((ReadableDuration) duration5, (ReadableInstant) dateMidnight7, periodType8);
        Chronology chronology10 = null;
        Period period11 = duration5.toPeriod(chronology10);
        Object obj12 = null;
        Chronology chronology13 = null;
        Interval interval14 = new Interval(obj12, chronology13);
        Months months15 = Months.monthsIn((ReadableInterval) interval14);
        Duration duration16 = interval14.toDuration();
        DateMidnight dateMidnight18 = new DateMidnight(0L);
        PeriodType periodType19 = PeriodType.days();
        MutablePeriod mutablePeriod20 = new MutablePeriod((ReadableDuration) duration16, (ReadableInstant) dateMidnight18, periodType19);
        boolean boolean21 = duration5.isShorterThan((ReadableDuration) duration16);
        mutableDateTime0.add((ReadableDuration) duration16, 10);
        mutableDateTime0.setWeekOfWeekyear((int) (byte) 1);
        mutableDateTime0.addHours((int) (short) 1);
        mutableDateTime0.setWeekyear(7);
        DateMidnight dateMidnight31 = new DateMidnight(0L);
        Chronology chronology32 = null;
        DateMidnight dateMidnight33 = dateMidnight31.withChronology(chronology32);
        Object obj34 = null;
        Chronology chronology35 = null;
        Interval interval36 = new Interval(obj34, chronology35);
        Months months37 = Months.monthsIn((ReadableInterval) interval36);
        Duration duration38 = interval36.toDuration();
        DateMidnight dateMidnight40 = new DateMidnight(0L);
        PeriodType periodType41 = PeriodType.days();
        MutablePeriod mutablePeriod42 = new MutablePeriod((ReadableDuration) duration38, (ReadableInstant) dateMidnight40, periodType41);
        DateMidnight dateMidnight44 = new DateMidnight(0L);
        Chronology chronology45 = null;
        DateMidnight dateMidnight46 = dateMidnight44.withChronology(chronology45);
        DateMidnight dateMidnight48 = dateMidnight44.withCenturyOfEra((int) ' ');
        Object obj49 = null;
        Chronology chronology50 = null;
        Interval interval51 = new Interval(obj49, chronology50);
        Months months52 = Months.monthsIn((ReadableInterval) interval51);
        Duration duration53 = interval51.toDuration();
        DateMidnight dateMidnight55 = new DateMidnight(0L);
        PeriodType periodType56 = PeriodType.days();
        MutablePeriod mutablePeriod57 = new MutablePeriod((ReadableDuration) duration53, (ReadableInstant) dateMidnight55, periodType56);
        Period period58 = duration38.toPeriodFrom((ReadableInstant) dateMidnight44, periodType56);
        boolean boolean59 = dateMidnight31.isAfter((ReadableInstant) dateMidnight44);
        boolean boolean60 = mutableDateTime0.isBefore((ReadableInstant) dateMidnight31);
        YearMonthDay yearMonthDay61 = dateMidnight31.toYearMonthDay();
        org.junit.Assert.assertNotNull(mutableDateTime0);
        org.junit.Assert.assertNotNull(months4);
        org.junit.Assert.assertNotNull(duration5);
        org.junit.Assert.assertNotNull(periodType8);
        org.junit.Assert.assertNotNull(period11);
        org.junit.Assert.assertNotNull(months15);
        org.junit.Assert.assertNotNull(duration16);
        org.junit.Assert.assertNotNull(periodType19);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(dateMidnight33);
        org.junit.Assert.assertNotNull(months37);
        org.junit.Assert.assertNotNull(duration38);
        org.junit.Assert.assertNotNull(periodType41);
        org.junit.Assert.assertNotNull(dateMidnight46);
        org.junit.Assert.assertNotNull(dateMidnight48);
        org.junit.Assert.assertNotNull(months52);
        org.junit.Assert.assertNotNull(duration53);
        org.junit.Assert.assertNotNull(periodType56);
        org.junit.Assert.assertNotNull(period58);
        org.junit.Assert.assertTrue("'" + boolean59 + "' != '" + false + "'", boolean59 == false);
        org.junit.Assert.assertTrue("'" + boolean60 + "' != '" + true + "'", boolean60 == true);
        org.junit.Assert.assertNotNull(yearMonthDay61);
    }

    @Test
    public void test295() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test295");
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder0 = new org.joda.time.format.DateTimeFormatterBuilder();
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder2 = dateTimeFormatterBuilder0.appendWeekOfWeekyear(3);
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder4 = dateTimeFormatterBuilder2.appendMinuteOfHour((int) (byte) 100);
        DateTimeFieldType dateTimeFieldType5 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder8 = dateTimeFormatterBuilder2.appendFraction(dateTimeFieldType5, 24, 143);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Field type must not be null");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder2);
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder4);
    }

    @Test
    public void test296() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test296");
        MutableInterval mutableInterval2 = new MutableInterval((long) (byte) -1, (long) 1);
        MutableInterval mutableInterval3 = mutableInterval2.copy();
        DateTimeZone dateTimeZone5 = null;
        MutableDateTime mutableDateTime6 = new MutableDateTime((long) 10080, dateTimeZone5);
        DateMidnight dateMidnight8 = new DateMidnight(0L);
        DateMidnight dateMidnight10 = new DateMidnight(0L);
        boolean boolean11 = dateMidnight8.isEqual((ReadableInstant) dateMidnight10);
        int int12 = dateMidnight8.getSecondOfDay();
        DateMidnight dateMidnight14 = dateMidnight8.plus((long) 36000000);
        mutableDateTime6.setMillis((ReadableInstant) dateMidnight14);
        mutableDateTime6.setYear(60);
        DateTime dateTime18 = new DateTime();
        DateTime.Property property19 = dateTime18.hourOfDay();
        int int20 = dateTime18.getDayOfYear();
        mutableInterval2.setInterval((ReadableInstant) mutableDateTime6, (ReadableInstant) dateTime18);
        int int22 = mutableDateTime6.getWeekOfWeekyear();
        MutableDateTime.Property property23 = mutableDateTime6.weekOfWeekyear();
        MutableDateTime.Property property24 = mutableDateTime6.minuteOfDay();
        org.junit.Assert.assertNotNull(mutableInterval3);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(dateMidnight14);
        org.junit.Assert.assertNotNull(property19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 143 + "'", int20 == 143);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 1 + "'", int22 == 1);
        org.junit.Assert.assertNotNull(property23);
        org.junit.Assert.assertNotNull(property24);
    }

    @Test
    public void test297() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test297");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology2 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone3 = ethiopicChronology2.getZone();
        Weeks weeks4 = Weeks.ONE;
        int[] intArray7 = ethiopicChronology2.get((ReadablePeriod) weeks4, (long) (short) 1, 100L);
        Period period8 = new Period((long) (short) 0, (long) 'a', (Chronology) ethiopicChronology2);
        DateTimeField dateTimeField9 = ethiopicChronology2.dayOfMonth();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology10 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone11 = ethiopicChronology10.getZone();
        int int13 = dateTimeZone11.getOffset((long) 100);
        DateMidnight dateMidnight14 = DateMidnight.now(dateTimeZone11);
        Chronology chronology15 = ethiopicChronology2.withZone(dateTimeZone11);
        org.junit.Assert.assertNotNull(ethiopicChronology2);
        org.junit.Assert.assertNotNull(dateTimeZone3);
        org.junit.Assert.assertNotNull(weeks4);
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertArrayEquals(intArray7, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField9);
        org.junit.Assert.assertNotNull(ethiopicChronology10);
        org.junit.Assert.assertNotNull(dateTimeZone11);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 36000000 + "'", int13 == 36000000);
        org.junit.Assert.assertNotNull(dateMidnight14);
        org.junit.Assert.assertNotNull(chronology15);
    }

    @Test
    public void test298() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test298");
        Appendable appendable0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.joda.time.format.FormatUtils.appendUnpaddedInteger(appendable0, 36000000);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test299() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test299");
        org.joda.time.chrono.CopticChronology copticChronology1 = org.joda.time.chrono.CopticChronology.getInstanceUTC();
        LocalDateTime localDateTime2 = new LocalDateTime((-35999994L), (Chronology) copticChronology1);
        LocalDateTime.Property property3 = localDateTime2.dayOfMonth();
        org.junit.Assert.assertNotNull(copticChronology1);
        org.junit.Assert.assertNotNull(property3);
    }

    @Test
    public void test300() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test300");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Object obj2 = null;
        Chronology chronology3 = null;
        Interval interval4 = new Interval(obj2, chronology3);
        Weeks weeks5 = Weeks.ONE;
        Interval interval6 = interval4.withPeriodAfterStart((ReadablePeriod) weeks5);
        int[] intArray9 = ethiopicChronology0.get((ReadablePeriod) weeks5, (long) (short) -1, (long) (short) -1);
        DurationField durationField10 = ethiopicChronology0.minutes();
        DurationField durationField11 = ethiopicChronology0.weeks();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks5);
        org.junit.Assert.assertNotNull(interval6);
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertArrayEquals(intArray9, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField10);
        org.junit.Assert.assertNotNull(durationField11);
    }

    @Test
    public void test301() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test301");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        DurationField durationField6 = ethiopicChronology4.hours();
        int int8 = durationField6.getValue(0L);
        DateTimeFieldType dateTimeFieldType9 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField11 = new org.joda.time.field.DividedDateTimeField(dateTimeField3, durationField6, dateTimeFieldType9, (int) '4');
        DateTimeFieldType dateTimeFieldType12 = DateTimeFieldType.clockhourOfHalfday();
        org.joda.time.field.OffsetDateTimeField offsetDateTimeField16 = new org.joda.time.field.OffsetDateTimeField((DateTimeField) dividedDateTimeField11, dateTimeFieldType12, 7, 1, 12);
        // The following exception was thrown during execution in test generation
        try {
            long long19 = dividedDateTimeField11.set((long) 1970, "2025-05-23T18:38:56.233+10:00/2025-05-23T18:38:56.233+10:00");
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value \"2025-05-23T18:38:56.233+10:00/2025-05-23T18:38:56.233+10:00\" for millisOfDay is not supported");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType9);
        org.junit.Assert.assertNotNull(dateTimeFieldType12);
    }

    @Test
    public void test302() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test302");
        TimeOfDay timeOfDay0 = new TimeOfDay();
        Weeks weeks1 = Weeks.ONE;
        Period period2 = weeks1.toPeriod();
        TimeOfDay timeOfDay3 = timeOfDay0.minus((ReadablePeriod) weeks1);
        LocalTime localTime4 = new LocalTime((Object) timeOfDay0);
        // The following exception was thrown during execution in test generation
        try {
            DateTimeField dateTimeField6 = localTime4.getField((int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Invalid index: 32");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(weeks1);
        org.junit.Assert.assertNotNull(period2);
        org.junit.Assert.assertNotNull(timeOfDay3);
    }

    @Test
    public void test303() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test303");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        Duration duration4 = interval2.toDuration();
        Object obj5 = null;
        Chronology chronology6 = null;
        Interval interval7 = new Interval(obj5, chronology6);
        Months months8 = Months.monthsIn((ReadableInterval) interval7);
        Duration duration9 = interval7.toDuration();
        boolean boolean10 = duration4.isEqual((ReadableDuration) duration9);
        DateTimeZone dateTimeZone12 = null;
        MutableDateTime mutableDateTime13 = new MutableDateTime((long) 10080, dateTimeZone12);
        DateMidnight dateMidnight15 = new DateMidnight(0L);
        DateMidnight dateMidnight17 = new DateMidnight(0L);
        boolean boolean18 = dateMidnight15.isEqual((ReadableInstant) dateMidnight17);
        int int19 = dateMidnight15.getSecondOfDay();
        DateMidnight dateMidnight21 = dateMidnight15.plus((long) 36000000);
        mutableDateTime13.setMillis((ReadableInstant) dateMidnight21);
        DateMidnight.Property property23 = dateMidnight21.weekyear();
        MutableInterval mutableInterval24 = new MutableInterval((ReadableDuration) duration9, (ReadableInstant) dateMidnight21);
        DateMidnight dateMidnight26 = new DateMidnight(0L);
        DateMidnight dateMidnight28 = new DateMidnight(0L);
        boolean boolean29 = dateMidnight26.isEqual((ReadableInstant) dateMidnight28);
        int int30 = dateMidnight26.getSecondOfDay();
        long long31 = DateTimeUtils.getInstantMillis((ReadableInstant) dateMidnight26);
        DateMidnight dateMidnight33 = dateMidnight26.withWeekOfWeekyear((int) (short) 10);
        mutableInterval24.setStart((ReadableInstant) dateMidnight26);
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertNotNull(duration4);
        org.junit.Assert.assertNotNull(months8);
        org.junit.Assert.assertNotNull(duration9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 0 + "'", int19 == 0);
        org.junit.Assert.assertNotNull(dateMidnight21);
        org.junit.Assert.assertNotNull(property23);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + true + "'", boolean29 == true);
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 0 + "'", int30 == 0);
        org.junit.Assert.assertTrue("'" + long31 + "' != '" + (-36000000L) + "'", long31 == (-36000000L));
        org.junit.Assert.assertNotNull(dateMidnight33);
    }

    @Test
    public void test304() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test304");
        org.joda.time.format.PeriodFormatter periodFormatter0 = org.joda.time.format.PeriodFormat.wordBased();
        org.junit.Assert.assertNotNull(periodFormatter0);
    }

    @Test
    public void test305() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test305");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        Chronology chronology2 = null;
        DateMidnight dateMidnight3 = dateMidnight1.withChronology(chronology2);
        DateMidnight dateMidnight5 = new DateMidnight(0L);
        Hours hours6 = Hours.hoursBetween((ReadableInstant) dateMidnight1, (ReadableInstant) dateMidnight5);
        int int7 = dateMidnight5.getDayOfMonth();
        org.joda.time.format.PeriodFormatter periodFormatter8 = org.joda.time.format.ISOPeriodFormat.alternateExtendedWithWeeks();
        java.util.Locale locale9 = null;
        org.joda.time.format.PeriodFormatter periodFormatter10 = periodFormatter8.withLocale(locale9);
        boolean boolean11 = dateMidnight5.equals((Object) periodFormatter8);
        org.junit.Assert.assertNotNull(dateMidnight3);
        org.junit.Assert.assertNotNull(hours6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 1 + "'", int7 == 1);
        org.junit.Assert.assertNotNull(periodFormatter8);
        org.junit.Assert.assertNotNull(periodFormatter10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test306() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test306");
        Hours hours0 = Hours.SIX;
        MutablePeriod mutablePeriod1 = hours0.toMutablePeriod();
        mutablePeriod1.setSeconds((int) (short) 0);
        int int4 = mutablePeriod1.getMinutes();
        // The following exception was thrown during execution in test generation
        try {
            mutablePeriod1.setValue((int) '4', 168);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 52");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(hours0);
        org.junit.Assert.assertNotNull(mutablePeriod1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
    }

    @Test
    public void test307() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test307");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        org.joda.time.chrono.CopticChronology copticChronology2 = org.joda.time.chrono.CopticChronology.getInstance(dateTimeZone1);
        LocalDateTime localDateTime3 = LocalDateTime.now(dateTimeZone1);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology5 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone6 = ethiopicChronology5.getZone();
        org.joda.time.chrono.CopticChronology copticChronology7 = org.joda.time.chrono.CopticChronology.getInstance(dateTimeZone6);
        LocalDateTime localDateTime8 = LocalDateTime.now(dateTimeZone6);
        MutableDateTime mutableDateTime9 = new MutableDateTime((long) 0, dateTimeZone6);
        long long11 = dateTimeZone1.getMillisKeepLocal(dateTimeZone6, 24L);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(copticChronology2);
        org.junit.Assert.assertNotNull(localDateTime3);
        org.junit.Assert.assertNotNull(ethiopicChronology5);
        org.junit.Assert.assertNotNull(dateTimeZone6);
        org.junit.Assert.assertNotNull(copticChronology7);
        org.junit.Assert.assertNotNull(localDateTime8);
        org.junit.Assert.assertTrue("'" + long11 + "' != '" + 24L + "'", long11 == 24L);
    }

    @Test
    public void test308() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test308");
        LocalDateTime localDateTime0 = new LocalDateTime();
    }

    @Test
    public void test309() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test309");
        DateTimeZone dateTimeZone1 = null;
        MutableDateTime mutableDateTime2 = new MutableDateTime((long) 10080, dateTimeZone1);
        DateMidnight dateMidnight4 = new DateMidnight(0L);
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        boolean boolean7 = dateMidnight4.isEqual((ReadableInstant) dateMidnight6);
        int int8 = dateMidnight4.getSecondOfDay();
        DateMidnight dateMidnight10 = dateMidnight4.plus((long) 36000000);
        mutableDateTime2.setMillis((ReadableInstant) dateMidnight10);
        DateMidnight.Property property12 = dateMidnight10.weekyear();
        DateMidnight dateMidnight14 = property12.addWrapFieldToCopy(0);
        ReadablePartial readablePartial15 = null;
        DateMidnight dateMidnight16 = dateMidnight14.withFields(readablePartial15);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateMidnight10);
        org.junit.Assert.assertNotNull(property12);
        org.junit.Assert.assertNotNull(dateMidnight14);
        org.junit.Assert.assertNotNull(dateMidnight16);
    }

    @Test
    public void test310() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test310");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter0 = org.joda.time.format.ISODateTimeFormat.basicTTimeNoMillis();
        org.junit.Assert.assertNotNull(dateTimeFormatter0);
    }

    @Test
    public void test311() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test311");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter0 = org.joda.time.format.ISODateTimeFormat.basicOrdinalDate();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        DateTimeField dateTimeField3 = ethiopicChronology1.minuteOfHour();
        org.joda.time.chrono.CopticChronology copticChronology5 = org.joda.time.chrono.CopticChronology.getInstanceUTC();
        LocalDateTime localDateTime6 = new LocalDateTime((-35999994L), (Chronology) copticChronology5);
        LocalDateTime localDateTime8 = localDateTime6.plusDays((int) (byte) -1);
        DateMidnight dateMidnight10 = new DateMidnight(0L);
        Chronology chronology11 = null;
        DateMidnight dateMidnight12 = dateMidnight10.withChronology(chronology11);
        DateMidnight dateMidnight14 = dateMidnight10.withCenturyOfEra((int) ' ');
        DateMidnight.Property property15 = dateMidnight10.dayOfMonth();
        DateMidnight dateMidnight17 = new DateMidnight(0L);
        Chronology chronology18 = null;
        DateMidnight dateMidnight19 = dateMidnight17.withChronology(chronology18);
        DateMidnight dateMidnight21 = dateMidnight17.withCenturyOfEra((int) ' ');
        DateMidnight.Property property22 = dateMidnight17.dayOfMonth();
        int int23 = dateMidnight17.getMinuteOfHour();
        Duration duration24 = new Duration((ReadableInstant) dateMidnight10, (ReadableInstant) dateMidnight17);
        LocalDateTime localDateTime26 = localDateTime8.withDurationAdded((ReadableDuration) duration24, 12);
        DateTime dateTime27 = localDateTime8.toDateTime();
        int int28 = dateTimeField3.getMinimumValue((ReadablePartial) localDateTime8);
        LocalDateTime.Property property29 = localDateTime8.era();
        String str30 = dateTimeFormatter0.print((ReadablePartial) localDateTime8);
        org.junit.Assert.assertNotNull(dateTimeFormatter0);
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(copticChronology5);
        org.junit.Assert.assertNotNull(localDateTime8);
        org.junit.Assert.assertNotNull(dateMidnight12);
        org.junit.Assert.assertNotNull(dateMidnight14);
        org.junit.Assert.assertNotNull(property15);
        org.junit.Assert.assertNotNull(dateMidnight19);
        org.junit.Assert.assertNotNull(dateMidnight21);
        org.junit.Assert.assertNotNull(property22);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + 0 + "'", int23 == 0);
        org.junit.Assert.assertNotNull(localDateTime26);
        org.junit.Assert.assertNotNull(dateTime27);
        org.junit.Assert.assertTrue("'" + int28 + "' != '" + 0 + "'", int28 == 0);
        org.junit.Assert.assertNotNull(property29);
        org.junit.Assert.assertEquals("'" + str30 + "' != '" + "1686111" + "'", str30, "1686111");
    }

    @Test
    public void test312() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test312");
        DateTime dateTime0 = new DateTime();
        DateTime.Property property1 = dateTime0.yearOfCentury();
        DateTime dateTime3 = property1.addToCopy(5);
        DateTime dateTime5 = dateTime3.minusDays((int) (short) 0);
        org.junit.Assert.assertNotNull(property1);
        org.junit.Assert.assertNotNull(dateTime3);
        org.junit.Assert.assertNotNull(dateTime5);
    }

    @Test
    public void test313() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test313");
        TimeOfDay timeOfDay0 = new TimeOfDay();
        Weeks weeks1 = Weeks.ONE;
        Period period2 = weeks1.toPeriod();
        TimeOfDay timeOfDay3 = timeOfDay0.minus((ReadablePeriod) weeks1);
        LocalTime localTime4 = new LocalTime((Object) timeOfDay0);
        TimeOfDay timeOfDay6 = timeOfDay0.withMillisOfSecond((int) '#');
        org.junit.Assert.assertNotNull(weeks1);
        org.junit.Assert.assertNotNull(period2);
        org.junit.Assert.assertNotNull(timeOfDay3);
        org.junit.Assert.assertNotNull(timeOfDay6);
    }

    @Test
    public void test314() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test314");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField4 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField3);
        int int6 = delegatedDateTimeField4.get((long) (byte) 10);
        String str8 = delegatedDateTimeField4.getAsText((long) 5);
        long long10 = delegatedDateTimeField4.roundFloor((long) 0);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "10" + "'", str8, "10");
        org.junit.Assert.assertTrue("'" + long10 + "' != '" + 0L + "'", long10 == 0L);
    }

    @Test
    public void test315() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test315");
        Years years1 = Years.parseYears("P0M");
        Years years3 = Years.parseYears("P0M");
        Years years4 = years1.minus(years3);
        DurationFieldType durationFieldType5 = years1.getFieldType();
        org.junit.Assert.assertNotNull(years1);
        org.junit.Assert.assertNotNull(years3);
        org.junit.Assert.assertNotNull(years4);
        org.junit.Assert.assertNotNull(durationFieldType5);
    }

    @Test
    public void test316() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test316");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DateTimeField dateTimeField2 = ethiopicChronology0.minuteOfHour();
        MonthDay monthDay3 = new MonthDay((Chronology) ethiopicChronology0);
        String str4 = monthDay3.toString();
        Object obj5 = null;
        Chronology chronology6 = null;
        Interval interval7 = new Interval(obj5, chronology6);
        Months months8 = Months.monthsIn((ReadableInterval) interval7);
        Duration duration9 = interval7.toDuration();
        DateMidnight dateMidnight11 = new DateMidnight(0L);
        PeriodType periodType12 = PeriodType.days();
        MutablePeriod mutablePeriod13 = new MutablePeriod((ReadableDuration) duration9, (ReadableInstant) dateMidnight11, periodType12);
        Chronology chronology14 = null;
        Period period15 = duration9.toPeriod(chronology14);
        Object obj16 = null;
        Chronology chronology17 = null;
        Interval interval18 = new Interval(obj16, chronology17);
        Months months19 = Months.monthsIn((ReadableInterval) interval18);
        Duration duration20 = interval18.toDuration();
        DateMidnight dateMidnight22 = new DateMidnight(0L);
        PeriodType periodType23 = PeriodType.days();
        MutablePeriod mutablePeriod24 = new MutablePeriod((ReadableDuration) duration20, (ReadableInstant) dateMidnight22, periodType23);
        boolean boolean25 = duration9.isShorterThan((ReadableDuration) duration20);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology26 = org.joda.time.chrono.EthiopicChronology.getInstance();
        Period period27 = new Period((Object) duration9, (Chronology) ethiopicChronology26);
        Months months28 = Months.MAX_VALUE;
        Months months29 = Months.MAX_VALUE;
        Object obj30 = null;
        Chronology chronology31 = null;
        Interval interval32 = new Interval(obj30, chronology31);
        Months months33 = Months.monthsIn((ReadableInterval) interval32);
        boolean boolean34 = months29.isGreaterThan(months33);
        Months months35 = months28.minus(months29);
        PeriodType periodType36 = months35.getPeriodType();
        Period period37 = period27.normalizedStandard(periodType36);
        MonthDay monthDay39 = monthDay3.withPeriodAdded((ReadablePeriod) period27, 0);
        MonthDay.Property property40 = monthDay3.dayOfMonth();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(dateTimeField2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "--09-15" + "'", str4, "--09-15");
        org.junit.Assert.assertNotNull(months8);
        org.junit.Assert.assertNotNull(duration9);
        org.junit.Assert.assertNotNull(periodType12);
        org.junit.Assert.assertNotNull(period15);
        org.junit.Assert.assertNotNull(months19);
        org.junit.Assert.assertNotNull(duration20);
        org.junit.Assert.assertNotNull(periodType23);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(ethiopicChronology26);
        org.junit.Assert.assertNotNull(months28);
        org.junit.Assert.assertNotNull(months29);
        org.junit.Assert.assertNotNull(months33);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + true + "'", boolean34 == true);
        org.junit.Assert.assertNotNull(months35);
        org.junit.Assert.assertNotNull(periodType36);
        org.junit.Assert.assertNotNull(period37);
        org.junit.Assert.assertNotNull(monthDay39);
        org.junit.Assert.assertNotNull(property40);
    }

    @Test
    public void test317() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test317");
        Months months0 = Months.TWELVE;
        org.junit.Assert.assertNotNull(months0);
    }

    @Test
    public void test318() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test318");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Weeks weeks2 = Weeks.ONE;
        int[] intArray5 = ethiopicChronology0.get((ReadablePeriod) weeks2, (long) (short) 1, 100L);
        DateTimeField dateTimeField6 = ethiopicChronology0.millisOfDay();
        TimeOfDay timeOfDay7 = new TimeOfDay();
        long long9 = ethiopicChronology0.set((ReadablePartial) timeOfDay7, 0L);
        TimeOfDay timeOfDay11 = timeOfDay7.withMinuteOfHour(12);
        TimeOfDay timeOfDay13 = timeOfDay11.withMillisOfSecond((int) '#');
        TimeOfDay timeOfDay15 = timeOfDay13.plusMillis((-1));
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks2);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField6);
// flaky "11) test318(RegressionTest0)":         org.junit.Assert.assertTrue("'" + long9 + "' != '" + 31175162L + "'", long9 == 31175162L);
        org.junit.Assert.assertNotNull(timeOfDay11);
        org.junit.Assert.assertNotNull(timeOfDay13);
        org.junit.Assert.assertNotNull(timeOfDay15);
    }

    @Test
    public void test319() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test319");
        PeriodType periodType0 = PeriodType.days();
        MutablePeriod mutablePeriod1 = new MutablePeriod(periodType0);
        Duration duration3 = new Duration((long) (short) 0);
        mutablePeriod1.setPeriod((ReadableDuration) duration3);
        org.junit.Assert.assertNotNull(periodType0);
    }

    @Test
    public void test320() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test320");
        Months months0 = Months.MAX_VALUE;
        Object obj1 = null;
        Chronology chronology2 = null;
        Interval interval3 = new Interval(obj1, chronology2);
        Months months4 = Months.monthsIn((ReadableInterval) interval3);
        boolean boolean5 = months0.isGreaterThan(months4);
        Period period6 = new Period((Object) months0);
        org.junit.Assert.assertNotNull(months0);
        org.junit.Assert.assertNotNull(months4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test321() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test321");
        org.joda.time.chrono.CopticChronology copticChronology0 = org.joda.time.chrono.CopticChronology.getInstance();
        org.junit.Assert.assertNotNull(copticChronology0);
    }

    @Test
    public void test322() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test322");
        // The following exception was thrown during execution in test generation
        try {
            DateTimeZone dateTimeZone1 = DateTimeZone.forOffsetHours((int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Hours out of range: 97");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test323() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test323");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Weeks weeks3 = Weeks.ONE;
        Interval interval4 = interval2.withPeriodAfterStart((ReadablePeriod) weeks3);
        LocalDate localDate5 = new LocalDate();
        LocalDate localDate7 = localDate5.minusWeeks(3);
        LocalDate.Property property8 = localDate7.monthOfYear();
        LocalDate localDate9 = property8.roundHalfFloorCopy();
        LocalDate localDate10 = new LocalDate();
        DateTimeFieldType dateTimeFieldType11 = DateTimeFieldType.weekyearOfCentury();
        int int12 = localDate10.indexOf(dateTimeFieldType11);
        LocalDate localDate14 = localDate10.withDayOfYear(24);
        int int15 = localDate9.compareTo((ReadablePartial) localDate14);
        DateTime dateTime16 = localDate9.toDateTimeAtCurrentTime();
        Interval interval17 = interval4.withStart((ReadableInstant) dateTime16);
        DateTime.Property property18 = dateTime16.yearOfEra();
        org.junit.Assert.assertNotNull(weeks3);
        org.junit.Assert.assertNotNull(interval4);
        org.junit.Assert.assertNotNull(localDate7);
        org.junit.Assert.assertNotNull(property8);
        org.junit.Assert.assertNotNull(localDate9);
        org.junit.Assert.assertNotNull(dateTimeFieldType11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + (-1) + "'", int12 == (-1));
        org.junit.Assert.assertNotNull(localDate14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 1 + "'", int15 == 1);
        org.junit.Assert.assertNotNull(dateTime16);
        org.junit.Assert.assertNotNull(interval17);
        org.junit.Assert.assertNotNull(property18);
    }

    @Test
    public void test324() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test324");
        DateTime dateTime1 = DateTime.parse("23");
        int int2 = dateTime1.getMonthOfYear();
        DateMidnight dateMidnight4 = new DateMidnight(0L);
        Chronology chronology5 = null;
        DateMidnight dateMidnight6 = dateMidnight4.withChronology(chronology5);
        DateMidnight dateMidnight8 = new DateMidnight(0L);
        Hours hours9 = Hours.hoursBetween((ReadableInstant) dateMidnight4, (ReadableInstant) dateMidnight8);
        MutablePeriod mutablePeriod10 = hours9.toMutablePeriod();
        DateTime dateTime11 = dateTime1.minus((ReadablePeriod) hours9);
        org.junit.Assert.assertNotNull(dateTime1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 1 + "'", int2 == 1);
        org.junit.Assert.assertNotNull(dateMidnight6);
        org.junit.Assert.assertNotNull(hours9);
        org.junit.Assert.assertNotNull(mutablePeriod10);
        org.junit.Assert.assertNotNull(dateTime11);
    }

    @Test
    public void test325() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test325");
        DateTime dateTime1 = new DateTime(0L);
    }

    @Test
    public void test326() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test326");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        DurationField durationField4 = ethiopicChronology0.weeks();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(durationField4);
    }

    @Test
    public void test327() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test327");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology7 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone8 = ethiopicChronology7.getZone();
        Object obj9 = null;
        Chronology chronology10 = null;
        Interval interval11 = new Interval(obj9, chronology10);
        Weeks weeks12 = Weeks.ONE;
        Interval interval13 = interval11.withPeriodAfterStart((ReadablePeriod) weeks12);
        int[] intArray16 = ethiopicChronology7.get((ReadablePeriod) weeks12, (long) (short) -1, (long) (short) -1);
        DurationField durationField17 = ethiopicChronology7.minutes();
        DurationField durationField18 = ethiopicChronology7.months();
        DateTimeField dateTimeField19 = ethiopicChronology7.millisOfDay();
        DateTimeField dateTimeField20 = ethiopicChronology7.secondOfDay();
        // The following exception was thrown during execution in test generation
        try {
            LocalDateTime localDateTime21 = new LocalDateTime((int) (byte) 1, 10080, (int) ' ', 1920, (int) 'a', 5, 1920, (Chronology) ethiopicChronology7);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 1920 for hourOfDay must be in the range [0,23]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology7);
        org.junit.Assert.assertNotNull(dateTimeZone8);
        org.junit.Assert.assertNotNull(weeks12);
        org.junit.Assert.assertNotNull(interval13);
        org.junit.Assert.assertNotNull(intArray16);
        org.junit.Assert.assertArrayEquals(intArray16, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField17);
        org.junit.Assert.assertNotNull(durationField18);
        org.junit.Assert.assertNotNull(dateTimeField19);
        org.junit.Assert.assertNotNull(dateTimeField20);
    }

    @Test
    public void test328() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test328");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        Duration duration4 = interval2.toDuration();
        Object obj5 = null;
        Chronology chronology6 = null;
        Interval interval7 = new Interval(obj5, chronology6);
        Months months8 = Months.monthsIn((ReadableInterval) interval7);
        Duration duration9 = interval7.toDuration();
        boolean boolean10 = duration4.isEqual((ReadableDuration) duration9);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology12 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone13 = ethiopicChronology12.getZone();
        Object obj14 = null;
        Chronology chronology15 = null;
        Interval interval16 = new Interval(obj14, chronology15);
        Weeks weeks17 = Weeks.ONE;
        Interval interval18 = interval16.withPeriodAfterStart((ReadablePeriod) weeks17);
        int[] intArray21 = ethiopicChronology12.get((ReadablePeriod) weeks17, (long) (short) -1, (long) (short) -1);
        DurationField durationField22 = ethiopicChronology12.minutes();
        DateTimeField dateTimeField23 = ethiopicChronology12.clockhourOfDay();
        TimeOfDay timeOfDay24 = new TimeOfDay(31139671L, (Chronology) ethiopicChronology12);
        // The following exception was thrown during execution in test generation
        try {
            Interval interval25 = new Interval((Object) duration4, (Chronology) ethiopicChronology12);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: No interval converter found for type: org.joda.time.Duration");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertNotNull(duration4);
        org.junit.Assert.assertNotNull(months8);
        org.junit.Assert.assertNotNull(duration9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertNotNull(ethiopicChronology12);
        org.junit.Assert.assertNotNull(dateTimeZone13);
        org.junit.Assert.assertNotNull(weeks17);
        org.junit.Assert.assertNotNull(interval18);
        org.junit.Assert.assertNotNull(intArray21);
        org.junit.Assert.assertArrayEquals(intArray21, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField22);
        org.junit.Assert.assertNotNull(dateTimeField23);
    }

    @Test
    public void test329() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test329");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter0 = org.joda.time.format.ISODateTimeFormat.basicTime();
        org.junit.Assert.assertNotNull(dateTimeFormatter0);
    }

    @Test
    public void test330() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test330");
        DateTimeZone dateTimeZone1 = null;
        MutableDateTime mutableDateTime2 = new MutableDateTime((long) 10080, dateTimeZone1);
        DateMidnight dateMidnight4 = new DateMidnight(0L);
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        boolean boolean7 = dateMidnight4.isEqual((ReadableInstant) dateMidnight6);
        int int8 = dateMidnight4.getSecondOfDay();
        DateMidnight dateMidnight10 = dateMidnight4.plus((long) 36000000);
        mutableDateTime2.setMillis((ReadableInstant) dateMidnight10);
        mutableDateTime2.setYear(60);
        Chronology chronology14 = DateTimeUtils.getInstantChronology((ReadableInstant) mutableDateTime2);
        PeriodType periodType15 = PeriodType.days();
        // The following exception was thrown during execution in test generation
        try {
            MutablePeriod mutablePeriod16 = new MutablePeriod((Object) mutableDateTime2, periodType15);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: No period converter found for type: org.joda.time.MutableDateTime");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateMidnight10);
        org.junit.Assert.assertNotNull(chronology14);
        org.junit.Assert.assertNotNull(periodType15);
    }

    @Test
    public void test331() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test331");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        Duration duration4 = interval2.toDuration();
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        PeriodType periodType7 = PeriodType.days();
        MutablePeriod mutablePeriod8 = new MutablePeriod((ReadableDuration) duration4, (ReadableInstant) dateMidnight6, periodType7);
        DateMidnight dateMidnight10 = new DateMidnight(0L);
        Chronology chronology11 = null;
        DateMidnight dateMidnight12 = dateMidnight10.withChronology(chronology11);
        DateMidnight dateMidnight14 = dateMidnight10.withCenturyOfEra((int) ' ');
        Object obj15 = null;
        Chronology chronology16 = null;
        Interval interval17 = new Interval(obj15, chronology16);
        Months months18 = Months.monthsIn((ReadableInterval) interval17);
        Duration duration19 = interval17.toDuration();
        DateMidnight dateMidnight21 = new DateMidnight(0L);
        PeriodType periodType22 = PeriodType.days();
        MutablePeriod mutablePeriod23 = new MutablePeriod((ReadableDuration) duration19, (ReadableInstant) dateMidnight21, periodType22);
        Period period24 = duration4.toPeriodFrom((ReadableInstant) dateMidnight10, periodType22);
        long long25 = duration4.getMillis();
        Duration duration27 = duration4.plus((long) 100);
        long long28 = duration27.getStandardMinutes();
        Duration duration29 = duration27.abs();
        Object obj30 = null;
        Chronology chronology31 = null;
        Interval interval32 = new Interval(obj30, chronology31);
        Months months33 = Months.monthsIn((ReadableInterval) interval32);
        Duration duration34 = interval32.toDuration();
        DateMidnight dateMidnight36 = new DateMidnight(0L);
        PeriodType periodType37 = PeriodType.days();
        MutablePeriod mutablePeriod38 = new MutablePeriod((ReadableDuration) duration34, (ReadableInstant) dateMidnight36, periodType37);
        DateMidnight dateMidnight40 = new DateMidnight(0L);
        Chronology chronology41 = null;
        DateMidnight dateMidnight42 = dateMidnight40.withChronology(chronology41);
        DateMidnight dateMidnight44 = dateMidnight40.withCenturyOfEra((int) ' ');
        Object obj45 = null;
        Chronology chronology46 = null;
        Interval interval47 = new Interval(obj45, chronology46);
        Months months48 = Months.monthsIn((ReadableInterval) interval47);
        Duration duration49 = interval47.toDuration();
        DateMidnight dateMidnight51 = new DateMidnight(0L);
        PeriodType periodType52 = PeriodType.days();
        MutablePeriod mutablePeriod53 = new MutablePeriod((ReadableDuration) duration49, (ReadableInstant) dateMidnight51, periodType52);
        Period period54 = duration34.toPeriodFrom((ReadableInstant) dateMidnight40, periodType52);
        long long55 = duration34.getMillis();
        Duration duration57 = duration34.plus((long) 100);
        boolean boolean58 = duration27.isEqual((ReadableDuration) duration34);
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertNotNull(duration4);
        org.junit.Assert.assertNotNull(periodType7);
        org.junit.Assert.assertNotNull(dateMidnight12);
        org.junit.Assert.assertNotNull(dateMidnight14);
        org.junit.Assert.assertNotNull(months18);
        org.junit.Assert.assertNotNull(duration19);
        org.junit.Assert.assertNotNull(periodType22);
        org.junit.Assert.assertNotNull(period24);
        org.junit.Assert.assertTrue("'" + long25 + "' != '" + 0L + "'", long25 == 0L);
        org.junit.Assert.assertNotNull(duration27);
        org.junit.Assert.assertTrue("'" + long28 + "' != '" + 0L + "'", long28 == 0L);
        org.junit.Assert.assertNotNull(duration29);
        org.junit.Assert.assertNotNull(months33);
        org.junit.Assert.assertNotNull(duration34);
        org.junit.Assert.assertNotNull(periodType37);
        org.junit.Assert.assertNotNull(dateMidnight42);
        org.junit.Assert.assertNotNull(dateMidnight44);
        org.junit.Assert.assertNotNull(months48);
        org.junit.Assert.assertNotNull(duration49);
        org.junit.Assert.assertNotNull(periodType52);
        org.junit.Assert.assertNotNull(period54);
        org.junit.Assert.assertTrue("'" + long55 + "' != '" + 0L + "'", long55 == 0L);
        org.junit.Assert.assertNotNull(duration57);
        org.junit.Assert.assertTrue("'" + boolean58 + "' != '" + false + "'", boolean58 == false);
    }

    @Test
    public void test332() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test332");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        Duration duration4 = interval2.toDuration();
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        PeriodType periodType7 = PeriodType.days();
        MutablePeriod mutablePeriod8 = new MutablePeriod((ReadableDuration) duration4, (ReadableInstant) dateMidnight6, periodType7);
        Chronology chronology9 = null;
        Period period10 = duration4.toPeriod(chronology9);
        Object obj11 = null;
        Chronology chronology12 = null;
        Interval interval13 = new Interval(obj11, chronology12);
        Months months14 = Months.monthsIn((ReadableInterval) interval13);
        Duration duration15 = interval13.toDuration();
        DateMidnight dateMidnight17 = new DateMidnight(0L);
        PeriodType periodType18 = PeriodType.days();
        MutablePeriod mutablePeriod19 = new MutablePeriod((ReadableDuration) duration15, (ReadableInstant) dateMidnight17, periodType18);
        boolean boolean20 = duration4.isShorterThan((ReadableDuration) duration15);
        Object obj21 = null;
        Chronology chronology22 = null;
        Interval interval23 = new Interval(obj21, chronology22);
        Months months24 = Months.monthsIn((ReadableInterval) interval23);
        Duration duration25 = interval23.toDuration();
        Object obj26 = null;
        Chronology chronology27 = null;
        Interval interval28 = new Interval(obj26, chronology27);
        Months months29 = Months.monthsIn((ReadableInterval) interval28);
        Duration duration30 = interval28.toDuration();
        boolean boolean31 = duration25.isEqual((ReadableDuration) duration30);
        Duration duration32 = duration4.plus((ReadableDuration) duration30);
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertNotNull(duration4);
        org.junit.Assert.assertNotNull(periodType7);
        org.junit.Assert.assertNotNull(period10);
        org.junit.Assert.assertNotNull(months14);
        org.junit.Assert.assertNotNull(duration15);
        org.junit.Assert.assertNotNull(periodType18);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(months24);
        org.junit.Assert.assertNotNull(duration25);
        org.junit.Assert.assertNotNull(months29);
        org.junit.Assert.assertNotNull(duration30);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + true + "'", boolean31 == true);
        org.junit.Assert.assertNotNull(duration32);
    }

    @Test
    public void test333() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test333");
        Duration duration1 = Duration.standardMinutes(0L);
        org.junit.Assert.assertNotNull(duration1);
    }

    @Test
    public void test334() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test334");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField4 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField3);
        int int6 = delegatedDateTimeField4.get((long) (byte) 10);
        LocalDate localDate7 = new LocalDate();
        LocalDate localDate9 = localDate7.minusWeeks(3);
        LocalDate.Property property10 = localDate9.monthOfYear();
        java.util.Locale locale12 = null;
        String str13 = delegatedDateTimeField4.getAsText((ReadablePartial) localDate9, (int) (byte) 10, locale12);
        LocalDate localDate15 = localDate9.withYear(3);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
        org.junit.Assert.assertNotNull(localDate9);
        org.junit.Assert.assertNotNull(property10);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "10" + "'", str13, "10");
        org.junit.Assert.assertNotNull(localDate15);
    }

    @Test
    public void test335() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test335");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        org.joda.time.chrono.CopticChronology copticChronology2 = org.joda.time.chrono.CopticChronology.getInstance(dateTimeZone1);
        LocalDateTime localDateTime3 = LocalDateTime.now(dateTimeZone1);
        LocalDateTime.Property property4 = localDateTime3.dayOfMonth();
        DurationFieldType durationFieldType5 = DurationFieldType.minutes();
        LocalDateTime localDateTime7 = localDateTime3.withFieldAdded(durationFieldType5, 6);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(copticChronology2);
        org.junit.Assert.assertNotNull(localDateTime3);
        org.junit.Assert.assertNotNull(property4);
        org.junit.Assert.assertNotNull(durationFieldType5);
        org.junit.Assert.assertNotNull(localDateTime7);
    }

    @Test
    public void test336() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test336");
        DateTimeZone dateTimeZone1 = null;
        MutableDateTime mutableDateTime2 = new MutableDateTime((long) 10080, dateTimeZone1);
        DateMidnight dateMidnight4 = new DateMidnight(0L);
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        boolean boolean7 = dateMidnight4.isEqual((ReadableInstant) dateMidnight6);
        int int8 = dateMidnight4.getSecondOfDay();
        DateMidnight dateMidnight10 = dateMidnight4.plus((long) 36000000);
        mutableDateTime2.setMillis((ReadableInstant) dateMidnight10);
        DateMidnight.Property property12 = dateMidnight10.weekyear();
        DateMidnight dateMidnight13 = property12.roundCeilingCopy();
        // The following exception was thrown during execution in test generation
        try {
            DateMidnight dateMidnight15 = property12.setCopy("P0M");
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value \"P0M\" for weekyear is not supported");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateMidnight10);
        org.junit.Assert.assertNotNull(property12);
        org.junit.Assert.assertNotNull(dateMidnight13);
    }

    @Test
    public void test337() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test337");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        DateMidnight dateMidnight3 = new DateMidnight(0L);
        boolean boolean4 = dateMidnight1.isEqual((ReadableInstant) dateMidnight3);
        Object obj5 = null;
        Chronology chronology6 = null;
        Interval interval7 = new Interval(obj5, chronology6);
        Months months8 = Months.monthsIn((ReadableInterval) interval7);
        Duration duration9 = interval7.toDuration();
        DateMidnight dateMidnight11 = new DateMidnight(0L);
        PeriodType periodType12 = PeriodType.days();
        MutablePeriod mutablePeriod13 = new MutablePeriod((ReadableDuration) duration9, (ReadableInstant) dateMidnight11, periodType12);
        Chronology chronology14 = null;
        Period period15 = duration9.toPeriod(chronology14);
        PeriodType periodType16 = PeriodType.yearMonthDayTime();
        MutablePeriod mutablePeriod17 = new MutablePeriod((ReadableInstant) dateMidnight3, (ReadableDuration) duration9, periodType16);
        DateMidnight dateMidnight19 = dateMidnight3.minusMonths((int) (short) -1);
        DateMidnight dateMidnight21 = dateMidnight3.minusMonths(1);
        Object obj22 = null;
        Chronology chronology23 = null;
        Interval interval24 = new Interval(obj22, chronology23);
        Months months25 = Months.monthsIn((ReadableInterval) interval24);
        Duration duration26 = interval24.toDuration();
        DateMidnight dateMidnight28 = new DateMidnight(0L);
        PeriodType periodType29 = PeriodType.days();
        MutablePeriod mutablePeriod30 = new MutablePeriod((ReadableDuration) duration26, (ReadableInstant) dateMidnight28, periodType29);
        DateMidnight dateMidnight32 = new DateMidnight(0L);
        Chronology chronology33 = null;
        DateMidnight dateMidnight34 = dateMidnight32.withChronology(chronology33);
        DateMidnight dateMidnight36 = dateMidnight32.withCenturyOfEra((int) ' ');
        Object obj37 = null;
        Chronology chronology38 = null;
        Interval interval39 = new Interval(obj37, chronology38);
        Months months40 = Months.monthsIn((ReadableInterval) interval39);
        Duration duration41 = interval39.toDuration();
        DateMidnight dateMidnight43 = new DateMidnight(0L);
        PeriodType periodType44 = PeriodType.days();
        MutablePeriod mutablePeriod45 = new MutablePeriod((ReadableDuration) duration41, (ReadableInstant) dateMidnight43, periodType44);
        Period period46 = duration26.toPeriodFrom((ReadableInstant) dateMidnight32, periodType44);
        long long47 = duration26.getMillis();
        Duration duration49 = duration26.plus((long) 100);
        long long50 = duration49.getStandardMinutes();
        DateMidnight dateMidnight51 = dateMidnight3.minus((ReadableDuration) duration49);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(months8);
        org.junit.Assert.assertNotNull(duration9);
        org.junit.Assert.assertNotNull(periodType12);
        org.junit.Assert.assertNotNull(period15);
        org.junit.Assert.assertNotNull(periodType16);
        org.junit.Assert.assertNotNull(dateMidnight19);
        org.junit.Assert.assertNotNull(dateMidnight21);
        org.junit.Assert.assertNotNull(months25);
        org.junit.Assert.assertNotNull(duration26);
        org.junit.Assert.assertNotNull(periodType29);
        org.junit.Assert.assertNotNull(dateMidnight34);
        org.junit.Assert.assertNotNull(dateMidnight36);
        org.junit.Assert.assertNotNull(months40);
        org.junit.Assert.assertNotNull(duration41);
        org.junit.Assert.assertNotNull(periodType44);
        org.junit.Assert.assertNotNull(period46);
        org.junit.Assert.assertTrue("'" + long47 + "' != '" + 0L + "'", long47 == 0L);
        org.junit.Assert.assertNotNull(duration49);
        org.junit.Assert.assertTrue("'" + long50 + "' != '" + 0L + "'", long50 == 0L);
        org.junit.Assert.assertNotNull(dateMidnight51);
    }

    @Test
    public void test338() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test338");
        PeriodType periodType0 = PeriodType.seconds();
        PeriodType periodType1 = periodType0.withDaysRemoved();
        org.joda.time.chrono.CopticChronology copticChronology3 = org.joda.time.chrono.CopticChronology.getInstanceUTC();
        LocalDateTime localDateTime4 = new LocalDateTime((-35999994L), (Chronology) copticChronology3);
        LocalDateTime localDateTime6 = localDateTime4.plusDays((int) (byte) -1);
        DateMidnight dateMidnight8 = new DateMidnight(0L);
        Chronology chronology9 = null;
        DateMidnight dateMidnight10 = dateMidnight8.withChronology(chronology9);
        DateMidnight dateMidnight12 = dateMidnight8.withCenturyOfEra((int) ' ');
        DateMidnight.Property property13 = dateMidnight8.dayOfMonth();
        DateMidnight dateMidnight15 = new DateMidnight(0L);
        Chronology chronology16 = null;
        DateMidnight dateMidnight17 = dateMidnight15.withChronology(chronology16);
        DateMidnight dateMidnight19 = dateMidnight15.withCenturyOfEra((int) ' ');
        DateMidnight.Property property20 = dateMidnight15.dayOfMonth();
        int int21 = dateMidnight15.getMinuteOfHour();
        Duration duration22 = new Duration((ReadableInstant) dateMidnight8, (ReadableInstant) dateMidnight15);
        LocalDateTime localDateTime24 = localDateTime6.withDurationAdded((ReadableDuration) duration22, 12);
        int int25 = localDateTime6.getDayOfWeek();
        Minutes minutes26 = Minutes.MIN_VALUE;
        DurationFieldType durationFieldType27 = minutes26.getFieldType();
        boolean boolean28 = localDateTime6.isSupported(durationFieldType27);
        boolean boolean29 = periodType1.isSupported(durationFieldType27);
        org.junit.Assert.assertNotNull(periodType0);
        org.junit.Assert.assertNotNull(periodType1);
        org.junit.Assert.assertNotNull(copticChronology3);
        org.junit.Assert.assertNotNull(localDateTime6);
        org.junit.Assert.assertNotNull(dateMidnight10);
        org.junit.Assert.assertNotNull(dateMidnight12);
        org.junit.Assert.assertNotNull(property13);
        org.junit.Assert.assertNotNull(dateMidnight17);
        org.junit.Assert.assertNotNull(dateMidnight19);
        org.junit.Assert.assertNotNull(property20);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
        org.junit.Assert.assertNotNull(localDateTime24);
        org.junit.Assert.assertTrue("'" + int25 + "' != '" + 2 + "'", int25 == 2);
        org.junit.Assert.assertNotNull(minutes26);
        org.junit.Assert.assertNotNull(durationFieldType27);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + true + "'", boolean28 == true);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
    }

    @Test
    public void test339() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test339");
        DateTime dateTime0 = new DateTime();
        DateTime.Property property1 = dateTime0.hourOfDay();
        int int2 = property1.getMaximumValueOverall();
        java.util.Locale locale4 = null;
        // The following exception was thrown during execution in test generation
        try {
            DateTime dateTime5 = property1.setCopy("1686111", locale4);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 1686111 for hourOfDay must be in the range [0,23]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(property1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 23 + "'", int2 == 23);
    }

    @Test
    public void test340() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test340");
        DateTimeFieldType dateTimeFieldType0 = DateTimeFieldType.weekyearOfCentury();
        IllegalFieldValueException illegalFieldValueException2 = new IllegalFieldValueException(dateTimeFieldType0, "hi!");
        Number number3 = illegalFieldValueException2.getLowerBound();
        illegalFieldValueException2.prependMessage("hours");
        org.junit.Assert.assertNotNull(dateTimeFieldType0);
        org.junit.Assert.assertNull(number3);
    }

    @Test
    public void test341() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test341");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter0 = org.joda.time.format.ISODateTimeFormat.localTimeParser();
        Appendable appendable1 = null;
        TimeOfDay timeOfDay2 = new TimeOfDay();
        // The following exception was thrown during execution in test generation
        try {
            dateTimeFormatter0.printTo(appendable1, (ReadablePartial) timeOfDay2);
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: Printing not supported");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(dateTimeFormatter0);
    }

    @Test
    public void test342() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test342");
        int int0 = DateTimeConstants.MILLIS_PER_DAY;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 86400000 + "'", int0 == 86400000);
    }

    @Test
    public void test343() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test343");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter0 = org.joda.time.format.ISODateTimeFormat.yearMonth();
        Integer int1 = dateTimeFormatter0.getPivotYear();
        org.junit.Assert.assertNotNull(dateTimeFormatter0);
        org.junit.Assert.assertNull(int1);
    }

    @Test
    public void test344() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test344");
        // The following exception was thrown during execution in test generation
        try {
            DateTime dateTime1 = DateTime.parse("EthiopicChronology[Australia/Sydney]");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid format: \"EthiopicChronology[Australia/Syd...\"");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test345() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test345");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Weeks weeks6 = Weeks.ONE;
        Interval interval7 = interval5.withPeriodAfterStart((ReadablePeriod) weeks6);
        int[] intArray10 = ethiopicChronology1.get((ReadablePeriod) weeks6, (long) (short) -1, (long) (short) -1);
        DurationField durationField11 = ethiopicChronology1.minutes();
        YearMonthDay yearMonthDay12 = new YearMonthDay(100L, (Chronology) ethiopicChronology1);
        DateTime dateTime13 = yearMonthDay12.toDateTimeAtMidnight();
        YearMonthDay yearMonthDay15 = yearMonthDay12.minusDays((int) (byte) 0);
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(weeks6);
        org.junit.Assert.assertNotNull(interval7);
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField11);
        org.junit.Assert.assertNotNull(dateTime13);
        org.junit.Assert.assertNotNull(yearMonthDay15);
    }

    @Test
    public void test346() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test346");
        Days days0 = Days.FIVE;
        int int1 = days0.getDays();
        int int2 = days0.getDays();
        org.junit.Assert.assertNotNull(days0);
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 5 + "'", int1 == 5);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 5 + "'", int2 == 5);
    }

    @Test
    public void test347() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test347");
        LocalDate localDate0 = new LocalDate();
        LocalDate localDate2 = localDate0.minusWeeks(3);
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Months months6 = Months.monthsIn((ReadableInterval) interval5);
        Duration duration7 = interval5.toDuration();
        DateMidnight dateMidnight9 = new DateMidnight(0L);
        PeriodType periodType10 = PeriodType.days();
        MutablePeriod mutablePeriod11 = new MutablePeriod((ReadableDuration) duration7, (ReadableInstant) dateMidnight9, periodType10);
        int int12 = mutablePeriod11.getYears();
        Object obj13 = null;
        Chronology chronology14 = null;
        Interval interval15 = new Interval(obj13, chronology14);
        Months months16 = Months.monthsIn((ReadableInterval) interval15);
        Duration duration17 = interval15.toDuration();
        DateMidnight dateMidnight19 = new DateMidnight(0L);
        PeriodType periodType20 = PeriodType.days();
        MutablePeriod mutablePeriod21 = new MutablePeriod((ReadableDuration) duration17, (ReadableInstant) dateMidnight19, periodType20);
        Object obj22 = null;
        Chronology chronology23 = null;
        Interval interval24 = new Interval(obj22, chronology23);
        Months months25 = Months.monthsIn((ReadableInterval) interval24);
        Duration duration26 = interval24.toDuration();
        Object obj27 = null;
        Chronology chronology28 = null;
        Interval interval29 = new Interval(obj27, chronology28);
        Months months30 = Months.monthsIn((ReadableInterval) interval29);
        Duration duration31 = interval29.toDuration();
        boolean boolean32 = duration26.isEqual((ReadableDuration) duration31);
        boolean boolean33 = duration17.isEqual((ReadableDuration) duration31);
        mutablePeriod11.setPeriod((ReadableDuration) duration31);
        boolean boolean35 = localDate2.equals((Object) duration31);
        org.junit.Assert.assertNotNull(localDate2);
        org.junit.Assert.assertNotNull(months6);
        org.junit.Assert.assertNotNull(duration7);
        org.junit.Assert.assertNotNull(periodType10);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(months16);
        org.junit.Assert.assertNotNull(duration17);
        org.junit.Assert.assertNotNull(periodType20);
        org.junit.Assert.assertNotNull(months25);
        org.junit.Assert.assertNotNull(duration26);
        org.junit.Assert.assertNotNull(months30);
        org.junit.Assert.assertNotNull(duration31);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + true + "'", boolean32 == true);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + true + "'", boolean33 == true);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
    }

    @Test
    public void test348() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test348");
        Hours hours0 = Hours.SIX;
        MutablePeriod mutablePeriod1 = hours0.toMutablePeriod();
        mutablePeriod1.setSeconds((int) (short) 0);
        mutablePeriod1.addHours(100);
        org.junit.Assert.assertNotNull(hours0);
        org.junit.Assert.assertNotNull(mutablePeriod1);
    }

    @Test
    public void test349() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test349");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter0 = org.joda.time.format.ISODateTimeFormat.localDateParser();
        org.junit.Assert.assertNotNull(dateTimeFormatter0);
    }

    @Test
    public void test350() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test350");
        int int0 = MonthDay.DAY_OF_MONTH;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test351() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test351");
        MutableInterval mutableInterval2 = new MutableInterval((long) (byte) -1, (long) 1);
        MutableInterval mutableInterval3 = mutableInterval2.copy();
        DateTimeZone dateTimeZone5 = null;
        MutableDateTime mutableDateTime6 = new MutableDateTime((long) 10080, dateTimeZone5);
        DateMidnight dateMidnight8 = new DateMidnight(0L);
        DateMidnight dateMidnight10 = new DateMidnight(0L);
        boolean boolean11 = dateMidnight8.isEqual((ReadableInstant) dateMidnight10);
        int int12 = dateMidnight8.getSecondOfDay();
        DateMidnight dateMidnight14 = dateMidnight8.plus((long) 36000000);
        mutableDateTime6.setMillis((ReadableInstant) dateMidnight14);
        mutableDateTime6.setYear(60);
        DateTime dateTime18 = new DateTime();
        DateTime.Property property19 = dateTime18.hourOfDay();
        int int20 = dateTime18.getDayOfYear();
        mutableInterval2.setInterval((ReadableInstant) mutableDateTime6, (ReadableInstant) dateTime18);
        int int22 = mutableDateTime6.getWeekOfWeekyear();
        MutableDateTime.Property property23 = mutableDateTime6.weekOfWeekyear();
        mutableDateTime6.setMinuteOfDay(5);
        org.junit.Assert.assertNotNull(mutableInterval3);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(dateMidnight14);
        org.junit.Assert.assertNotNull(property19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 143 + "'", int20 == 143);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 1 + "'", int22 == 1);
        org.junit.Assert.assertNotNull(property23);
    }

    @Test
    public void test352() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test352");
        Hours hours0 = Hours.SIX;
        MutablePeriod mutablePeriod1 = hours0.toMutablePeriod();
        mutablePeriod1.addDays(12);
        org.junit.Assert.assertNotNull(hours0);
        org.junit.Assert.assertNotNull(mutablePeriod1);
    }

    @Test
    public void test353() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test353");
        java.util.Locale locale1 = null;
        // The following exception was thrown during execution in test generation
        try {
            String str2 = org.joda.time.format.DateTimeFormat.patternForStyle("monthOfYear", locale1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid style specification: monthOfYear");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test354() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test354");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        Weeks weeks3 = Weeks.ONE;
        int[] intArray6 = ethiopicChronology1.get((ReadablePeriod) weeks3, (long) (short) 1, 100L);
        DateTimeField dateTimeField7 = ethiopicChronology1.millisOfDay();
        TimeOfDay timeOfDay8 = new TimeOfDay((long) (short) 10, (Chronology) ethiopicChronology1);
        LocalTime localTime9 = timeOfDay8.toLocalTime();
        int int10 = localTime9.getMillisOfSecond();
        LocalTime localTime12 = localTime9.withMillisOfSecond((int) (short) 10);
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(weeks3);
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertArrayEquals(intArray6, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField7);
        org.junit.Assert.assertNotNull(localTime9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 10 + "'", int10 == 10);
        org.junit.Assert.assertNotNull(localTime12);
    }

    @Test
    public void test355() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test355");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        DurationField durationField6 = ethiopicChronology4.hours();
        int int8 = durationField6.getValue(0L);
        DateTimeFieldType dateTimeFieldType9 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField11 = new org.joda.time.field.DividedDateTimeField(dateTimeField3, durationField6, dateTimeFieldType9, (int) '4');
        int int13 = dividedDateTimeField11.getLeapAmount(10L);
        boolean boolean15 = dividedDateTimeField11.isLeap((long) 1000);
        long long17 = dividedDateTimeField11.remainder((long) 4);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType9);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + long17 + "' != '" + 4L + "'", long17 == 4L);
    }

    @Test
    public void test356() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test356");
        Hours hours0 = Hours.MAX_VALUE;
        org.junit.Assert.assertNotNull(hours0);
    }

    @Test
    public void test357() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test357");
        MutableInterval mutableInterval2 = new MutableInterval((long) (byte) -1, (long) 1);
        MutableInterval mutableInterval3 = mutableInterval2.copy();
        DateTimeZone dateTimeZone5 = null;
        MutableDateTime mutableDateTime6 = new MutableDateTime((long) 10080, dateTimeZone5);
        DateMidnight dateMidnight8 = new DateMidnight(0L);
        DateMidnight dateMidnight10 = new DateMidnight(0L);
        boolean boolean11 = dateMidnight8.isEqual((ReadableInstant) dateMidnight10);
        int int12 = dateMidnight8.getSecondOfDay();
        DateMidnight dateMidnight14 = dateMidnight8.plus((long) 36000000);
        mutableDateTime6.setMillis((ReadableInstant) dateMidnight14);
        mutableDateTime6.setYear(60);
        DateTime dateTime18 = new DateTime();
        DateTime.Property property19 = dateTime18.hourOfDay();
        int int20 = dateTime18.getDayOfYear();
        mutableInterval2.setInterval((ReadableInstant) mutableDateTime6, (ReadableInstant) dateTime18);
        mutableDateTime6.setSecondOfDay((int) (short) 1);
        org.junit.Assert.assertNotNull(mutableInterval3);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(dateMidnight14);
        org.junit.Assert.assertNotNull(property19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 143 + "'", int20 == 143);
    }

    @Test
    public void test358() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test358");
        org.joda.time.chrono.CopticChronology copticChronology1 = org.joda.time.chrono.CopticChronology.getInstanceUTC();
        LocalDateTime localDateTime2 = new LocalDateTime((-35999994L), (Chronology) copticChronology1);
        LocalDateTime localDateTime4 = localDateTime2.plusDays((int) (byte) -1);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology5 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone6 = ethiopicChronology5.getZone();
        Weeks weeks7 = Weeks.ONE;
        int[] intArray10 = ethiopicChronology5.get((ReadablePeriod) weeks7, (long) (short) 1, 100L);
        DateTimeField dateTimeField11 = ethiopicChronology5.millisOfDay();
        TimeOfDay timeOfDay12 = new TimeOfDay();
        long long14 = ethiopicChronology5.set((ReadablePartial) timeOfDay12, 0L);
        // The following exception was thrown during execution in test generation
        try {
            int int15 = localDateTime2.compareTo((ReadablePartial) timeOfDay12);
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: ReadablePartial objects must have matching field types");
        } catch (ClassCastException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(copticChronology1);
        org.junit.Assert.assertNotNull(localDateTime4);
        org.junit.Assert.assertNotNull(ethiopicChronology5);
        org.junit.Assert.assertNotNull(dateTimeZone6);
        org.junit.Assert.assertNotNull(weeks7);
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField11);
// flaky "12) test358(RegressionTest0)":         org.junit.Assert.assertTrue("'" + long14 + "' != '" + 31181042L + "'", long14 == 31181042L);
    }

    @Test
    public void test359() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test359");
        LocalDate localDate0 = new LocalDate();
        LocalDate localDate2 = localDate0.minusWeeks(3);
        LocalDate.Property property3 = localDate2.monthOfYear();
        LocalDate localDate4 = property3.roundHalfFloorCopy();
        LocalDate localDate5 = new LocalDate();
        DateTimeFieldType dateTimeFieldType6 = DateTimeFieldType.weekyearOfCentury();
        int int7 = localDate5.indexOf(dateTimeFieldType6);
        LocalDate localDate9 = localDate5.withDayOfYear(24);
        int int10 = localDate4.compareTo((ReadablePartial) localDate9);
        DateTimeField[] dateTimeFieldArray11 = localDate9.getFields();
        org.junit.Assert.assertNotNull(localDate2);
        org.junit.Assert.assertNotNull(property3);
        org.junit.Assert.assertNotNull(localDate4);
        org.junit.Assert.assertNotNull(dateTimeFieldType6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + (-1) + "'", int7 == (-1));
        org.junit.Assert.assertNotNull(localDate9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 1 + "'", int10 == 1);
        org.junit.Assert.assertNotNull(dateTimeFieldArray11);
    }

    @Test
    public void test360() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test360");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Weeks weeks2 = Weeks.ONE;
        int[] intArray5 = ethiopicChronology0.get((ReadablePeriod) weeks2, (long) (short) 1, 100L);
        // The following exception was thrown during execution in test generation
        try {
            DurationFieldType durationFieldType7 = weeks2.getFieldType(18);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: 18");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks2);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] { 0 });
    }

    @Test
    public void test361() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test361");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Weeks weeks2 = Weeks.ONE;
        int[] intArray5 = ethiopicChronology0.get((ReadablePeriod) weeks2, (long) (short) 1, 100L);
        DateTimeField dateTimeField6 = ethiopicChronology0.millisOfDay();
        DateTimeField dateTimeField7 = ethiopicChronology0.year();
        int int8 = dateTimeField7.getMinimumValue();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks2);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField6);
        org.junit.Assert.assertNotNull(dateTimeField7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-292269338) + "'", int8 == (-292269338));
    }

    @Test
    public void test362() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test362");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeField dateTimeField1 = ethiopicChronology0.monthOfYear();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology2 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone3 = ethiopicChronology2.getZone();
        long long7 = dateTimeZone3.convertLocalToUTC((long) 6, false, 0L);
        LocalDate localDate8 = new LocalDate(dateTimeZone3);
        Chronology chronology9 = ethiopicChronology0.withZone(dateTimeZone3);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeField1);
        org.junit.Assert.assertNotNull(ethiopicChronology2);
        org.junit.Assert.assertNotNull(dateTimeZone3);
        org.junit.Assert.assertTrue("'" + long7 + "' != '" + (-35999994L) + "'", long7 == (-35999994L));
        org.junit.Assert.assertNotNull(chronology9);
    }

    @Test
    public void test363() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test363");
        DateTimeZone dateTimeZone1 = null;
        MutableDateTime mutableDateTime2 = new MutableDateTime((long) 10080, dateTimeZone1);
        DateMidnight dateMidnight4 = new DateMidnight(0L);
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        boolean boolean7 = dateMidnight4.isEqual((ReadableInstant) dateMidnight6);
        int int8 = dateMidnight4.getSecondOfDay();
        DateMidnight dateMidnight10 = dateMidnight4.plus((long) 36000000);
        mutableDateTime2.setMillis((ReadableInstant) dateMidnight10);
        mutableDateTime2.setMinuteOfDay(10);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateMidnight10);
    }

    @Test
    public void test364() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test364");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        DurationField durationField6 = ethiopicChronology4.hours();
        int int8 = durationField6.getValue(0L);
        DateTimeFieldType dateTimeFieldType9 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField11 = new org.joda.time.field.DividedDateTimeField(dateTimeField3, durationField6, dateTimeFieldType9, (int) '4');
        java.util.Locale locale13 = null;
        String str14 = dividedDateTimeField11.getAsText((long) (-1), locale13);
        // The following exception was thrown during execution in test generation
        try {
            long long17 = dividedDateTimeField11.set((long) 2, 7);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 7 for millisOfDay must be in the range [0,0]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType9);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "0" + "'", str14, "0");
    }

    @Test
    public void test365() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test365");
        MutableInterval mutableInterval2 = new MutableInterval((long) (byte) -1, (long) 1);
        MutableInterval mutableInterval3 = mutableInterval2.copy();
        mutableInterval3.setDurationAfterStart((long) (byte) 0);
        DateTime dateTime6 = mutableInterval3.getStart();
        DateTime dateTime7 = mutableInterval3.getEnd();
        org.junit.Assert.assertNotNull(mutableInterval3);
        org.junit.Assert.assertNotNull(dateTime6);
        org.junit.Assert.assertNotNull(dateTime7);
    }

    @Test
    public void test366() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test366");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        Duration duration4 = interval2.toDuration();
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        PeriodType periodType7 = PeriodType.days();
        MutablePeriod mutablePeriod8 = new MutablePeriod((ReadableDuration) duration4, (ReadableInstant) dateMidnight6, periodType7);
        DateMidnight dateMidnight10 = new DateMidnight(0L);
        Chronology chronology11 = null;
        DateMidnight dateMidnight12 = dateMidnight10.withChronology(chronology11);
        DateMidnight dateMidnight14 = dateMidnight10.withCenturyOfEra((int) ' ');
        Object obj15 = null;
        Chronology chronology16 = null;
        Interval interval17 = new Interval(obj15, chronology16);
        Months months18 = Months.monthsIn((ReadableInterval) interval17);
        Duration duration19 = interval17.toDuration();
        DateMidnight dateMidnight21 = new DateMidnight(0L);
        PeriodType periodType22 = PeriodType.days();
        MutablePeriod mutablePeriod23 = new MutablePeriod((ReadableDuration) duration19, (ReadableInstant) dateMidnight21, periodType22);
        Period period24 = duration4.toPeriodFrom((ReadableInstant) dateMidnight10, periodType22);
        Period period25 = period24.negated();
        int int26 = period24.getMinutes();
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertNotNull(duration4);
        org.junit.Assert.assertNotNull(periodType7);
        org.junit.Assert.assertNotNull(dateMidnight12);
        org.junit.Assert.assertNotNull(dateMidnight14);
        org.junit.Assert.assertNotNull(months18);
        org.junit.Assert.assertNotNull(duration19);
        org.junit.Assert.assertNotNull(periodType22);
        org.junit.Assert.assertNotNull(period24);
        org.junit.Assert.assertNotNull(period25);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 0 + "'", int26 == 0);
    }

    @Test
    public void test367() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test367");
        // The following exception was thrown during execution in test generation
        try {
            MutableInterval mutableInterval1 = MutableInterval.parse("months");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Format requires a '/' separator: months");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test368() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test368");
        Hours hours0 = Hours.TWO;
        org.junit.Assert.assertNotNull(hours0);
    }

    @Test
    public void test369() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test369");
        Instant instant1 = Instant.ofEpochSecond(0L);
        org.junit.Assert.assertNotNull(instant1);
    }

    @Test
    public void test370() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test370");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        DurationField durationField6 = ethiopicChronology4.hours();
        int int8 = durationField6.getValue(0L);
        DateTimeFieldType dateTimeFieldType9 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField11 = new org.joda.time.field.DividedDateTimeField(dateTimeField3, durationField6, dateTimeFieldType9, (int) '4');
        int int13 = dividedDateTimeField11.getLeapAmount(10L);
        int int15 = dividedDateTimeField11.get(456878073600000L);
        boolean boolean16 = dividedDateTimeField11.isSupported();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType9);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
    }

    @Test
    public void test371() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test371");
        Days days0 = Days.FIVE;
        Days days1 = days0.negated();
        org.junit.Assert.assertNotNull(days0);
        org.junit.Assert.assertNotNull(days1);
    }

    @Test
    public void test372() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test372");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField4 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField3);
        int int6 = delegatedDateTimeField4.get((long) (byte) 10);
        java.util.Locale locale8 = null;
        String str9 = delegatedDateTimeField4.getAsShortText((long) (byte) 10, locale8);
        long long12 = delegatedDateTimeField4.add((long) 100, 3);
        DateTimeFieldType dateTimeFieldType13 = DateTimeFieldType.millisOfDay();
        IllegalFieldValueException illegalFieldValueException16 = new IllegalFieldValueException(dateTimeFieldType13, (Number) 9, "hi!");
        org.joda.time.field.RemainderDateTimeField remainderDateTimeField18 = new org.joda.time.field.RemainderDateTimeField((DateTimeField) delegatedDateTimeField4, dateTimeFieldType13, (int) 'a');
        LocalDate localDate19 = new LocalDate();
        DateTimeFieldType dateTimeFieldType20 = DateTimeFieldType.weekyearOfCentury();
        int int21 = localDate19.indexOf(dateTimeFieldType20);
        LocalDate localDate23 = localDate19.withDayOfYear(24);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology25 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone26 = ethiopicChronology25.getZone();
        Object obj27 = null;
        Chronology chronology28 = null;
        Interval interval29 = new Interval(obj27, chronology28);
        Weeks weeks30 = Weeks.ONE;
        Interval interval31 = interval29.withPeriodAfterStart((ReadablePeriod) weeks30);
        int[] intArray34 = ethiopicChronology25.get((ReadablePeriod) weeks30, (long) (short) -1, (long) (short) -1);
        // The following exception was thrown during execution in test generation
        try {
            int[] intArray36 = delegatedDateTimeField4.addWrapField((ReadablePartial) localDate23, (int) ' ', intArray34, 6);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 32");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "10" + "'", str9, "10");
        org.junit.Assert.assertTrue("'" + long12 + "' != '" + 10800100L + "'", long12 == 10800100L);
        org.junit.Assert.assertNotNull(dateTimeFieldType13);
        org.junit.Assert.assertNotNull(dateTimeFieldType20);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + (-1) + "'", int21 == (-1));
        org.junit.Assert.assertNotNull(localDate23);
        org.junit.Assert.assertNotNull(ethiopicChronology25);
        org.junit.Assert.assertNotNull(dateTimeZone26);
        org.junit.Assert.assertNotNull(weeks30);
        org.junit.Assert.assertNotNull(interval31);
        org.junit.Assert.assertNotNull(intArray34);
        org.junit.Assert.assertArrayEquals(intArray34, new int[] { 0 });
    }

    @Test
    public void test373() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test373");
        ReadableInstant readableInstant0 = null;
        DateTime dateTime1 = new DateTime();
        Interval interval2 = new Interval(readableInstant0, (ReadableInstant) dateTime1);
        DateTime dateTime4 = dateTime1.withWeekyear(0);
        DateTime.Property property5 = dateTime4.weekOfWeekyear();
        DateTime dateTime6 = property5.withMaximumValue();
        org.junit.Assert.assertNotNull(dateTime4);
        org.junit.Assert.assertNotNull(property5);
        org.junit.Assert.assertNotNull(dateTime6);
    }

    @Test
    public void test374() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test374");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Weeks weeks6 = Weeks.ONE;
        Interval interval7 = interval5.withPeriodAfterStart((ReadablePeriod) weeks6);
        int[] intArray10 = ethiopicChronology1.get((ReadablePeriod) weeks6, (long) (short) -1, (long) (short) -1);
        DurationField durationField11 = ethiopicChronology1.minutes();
        YearMonthDay yearMonthDay12 = new YearMonthDay(100L, (Chronology) ethiopicChronology1);
        DateTime dateTime13 = yearMonthDay12.toDateTimeAtMidnight();
        DateTime dateTime14 = yearMonthDay12.toDateTimeAtCurrentTime();
        // The following exception was thrown during execution in test generation
        try {
            DateTimeFieldType dateTimeFieldType16 = yearMonthDay12.getFieldType(143);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 143");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(weeks6);
        org.junit.Assert.assertNotNull(interval7);
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField11);
        org.junit.Assert.assertNotNull(dateTime13);
        org.junit.Assert.assertNotNull(dateTime14);
    }

    @Test
    public void test375() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test375");
        LocalDate localDate0 = new LocalDate();
        LocalDate localDate2 = localDate0.minusWeeks(3);
        LocalDate.Property property3 = localDate2.monthOfYear();
        Interval interval4 = localDate2.toInterval();
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        Chronology chronology7 = null;
        DateMidnight dateMidnight8 = dateMidnight6.withChronology(chronology7);
        DateMidnight dateMidnight10 = new DateMidnight(0L);
        Hours hours11 = Hours.hoursBetween((ReadableInstant) dateMidnight6, (ReadableInstant) dateMidnight10);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology12 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone13 = ethiopicChronology12.getZone();
        long long17 = dateTimeZone13.convertLocalToUTC((long) 6, false, 0L);
        LocalDate localDate18 = new LocalDate(dateTimeZone13);
        MutableDateTime mutableDateTime19 = dateMidnight10.toMutableDateTime(dateTimeZone13);
        DateTime dateTime20 = localDate2.toDateTimeAtMidnight(dateTimeZone13);
        org.junit.Assert.assertNotNull(localDate2);
        org.junit.Assert.assertNotNull(property3);
        org.junit.Assert.assertNotNull(interval4);
        org.junit.Assert.assertNotNull(dateMidnight8);
        org.junit.Assert.assertNotNull(hours11);
        org.junit.Assert.assertNotNull(ethiopicChronology12);
        org.junit.Assert.assertNotNull(dateTimeZone13);
        org.junit.Assert.assertTrue("'" + long17 + "' != '" + (-35999994L) + "'", long17 == (-35999994L));
        org.junit.Assert.assertNotNull(mutableDateTime19);
        org.junit.Assert.assertNotNull(dateTime20);
    }

    @Test
    public void test376() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test376");
        // The following exception was thrown during execution in test generation
        try {
            LocalTime localTime1 = LocalTime.parse("dayOfYear");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid format: \"dayOfYear\"");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test377() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test377");
        Days days0 = Days.ONE;
        org.junit.Assert.assertNotNull(days0);
    }

    @Test
    public void test378() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test378");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter1 = org.joda.time.format.ISODateTimeFormat.dateTimeParser();
        // The following exception was thrown during execution in test generation
        try {
            LocalDate localDate2 = LocalDate.parse("millis", dateTimeFormatter1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid format: \"millis\"");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(dateTimeFormatter1);
    }

    @Test
    public void test379() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test379");
        MutableInterval mutableInterval2 = new MutableInterval((long) (byte) -1, (long) 1);
        MutableInterval mutableInterval3 = mutableInterval2.copy();
        DateTimeZone dateTimeZone5 = null;
        MutableDateTime mutableDateTime6 = new MutableDateTime((long) 10080, dateTimeZone5);
        DateMidnight dateMidnight8 = new DateMidnight(0L);
        DateMidnight dateMidnight10 = new DateMidnight(0L);
        boolean boolean11 = dateMidnight8.isEqual((ReadableInstant) dateMidnight10);
        int int12 = dateMidnight8.getSecondOfDay();
        DateMidnight dateMidnight14 = dateMidnight8.plus((long) 36000000);
        mutableDateTime6.setMillis((ReadableInstant) dateMidnight14);
        mutableDateTime6.setYear(60);
        DateTime dateTime18 = new DateTime();
        DateTime.Property property19 = dateTime18.hourOfDay();
        int int20 = dateTime18.getDayOfYear();
        mutableInterval2.setInterval((ReadableInstant) mutableDateTime6, (ReadableInstant) dateTime18);
        int int22 = mutableDateTime6.getWeekOfWeekyear();
        mutableDateTime6.setMinuteOfDay(4);
        Months months25 = Months.FIVE;
        mutableDateTime6.add((ReadablePeriod) months25);
        org.junit.Assert.assertNotNull(mutableInterval3);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(dateMidnight14);
        org.junit.Assert.assertNotNull(property19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 143 + "'", int20 == 143);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 1 + "'", int22 == 1);
        org.junit.Assert.assertNotNull(months25);
    }

    @Test
    public void test380() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test380");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DateTimeField dateTimeField2 = ethiopicChronology0.minuteOfHour();
        org.joda.time.chrono.CopticChronology copticChronology4 = org.joda.time.chrono.CopticChronology.getInstanceUTC();
        LocalDateTime localDateTime5 = new LocalDateTime((-35999994L), (Chronology) copticChronology4);
        LocalDateTime localDateTime7 = localDateTime5.plusDays((int) (byte) -1);
        DateMidnight dateMidnight9 = new DateMidnight(0L);
        Chronology chronology10 = null;
        DateMidnight dateMidnight11 = dateMidnight9.withChronology(chronology10);
        DateMidnight dateMidnight13 = dateMidnight9.withCenturyOfEra((int) ' ');
        DateMidnight.Property property14 = dateMidnight9.dayOfMonth();
        DateMidnight dateMidnight16 = new DateMidnight(0L);
        Chronology chronology17 = null;
        DateMidnight dateMidnight18 = dateMidnight16.withChronology(chronology17);
        DateMidnight dateMidnight20 = dateMidnight16.withCenturyOfEra((int) ' ');
        DateMidnight.Property property21 = dateMidnight16.dayOfMonth();
        int int22 = dateMidnight16.getMinuteOfHour();
        Duration duration23 = new Duration((ReadableInstant) dateMidnight9, (ReadableInstant) dateMidnight16);
        LocalDateTime localDateTime25 = localDateTime7.withDurationAdded((ReadableDuration) duration23, 12);
        DateTime dateTime26 = localDateTime7.toDateTime();
        int int27 = dateTimeField2.getMinimumValue((ReadablePartial) localDateTime7);
        LocalDateTime.Property property28 = localDateTime7.era();
        LocalDateTime.Property property29 = localDateTime7.millisOfDay();
        org.joda.time.format.DateTimeFormatter dateTimeFormatter30 = org.joda.time.format.ISODateTimeFormat.yearMonthDay();
        String str31 = localDateTime7.toString(dateTimeFormatter30);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(dateTimeField2);
        org.junit.Assert.assertNotNull(copticChronology4);
        org.junit.Assert.assertNotNull(localDateTime7);
        org.junit.Assert.assertNotNull(dateMidnight11);
        org.junit.Assert.assertNotNull(dateMidnight13);
        org.junit.Assert.assertNotNull(property14);
        org.junit.Assert.assertNotNull(dateMidnight18);
        org.junit.Assert.assertNotNull(dateMidnight20);
        org.junit.Assert.assertNotNull(property21);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 0 + "'", int22 == 0);
        org.junit.Assert.assertNotNull(localDateTime25);
        org.junit.Assert.assertNotNull(dateTime26);
        org.junit.Assert.assertTrue("'" + int27 + "' != '" + 0 + "'", int27 == 0);
        org.junit.Assert.assertNotNull(property28);
        org.junit.Assert.assertNotNull(property29);
        org.junit.Assert.assertNotNull(dateTimeFormatter30);
        org.junit.Assert.assertEquals("'" + str31 + "' != '" + "1686-04-21" + "'", str31, "1686-04-21");
    }

    @Test
    public void test381() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test381");
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder0 = new org.joda.time.format.DateTimeFormatterBuilder();
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder3 = dateTimeFormatterBuilder0.appendCenturyOfEra(9, 2);
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder5 = dateTimeFormatterBuilder3.appendDayOfYear((int) (short) 0);
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder8 = dateTimeFormatterBuilder3.appendFractionOfSecond(18, (int) (short) -1);
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder3);
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder5);
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder8);
    }

    @Test
    public void test382() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test382");
        MutableInterval mutableInterval2 = new MutableInterval((long) (byte) -1, (long) 1);
        mutableInterval2.setDurationBeforeEnd((long) '#');
        Weeks weeks5 = Weeks.weeksIn((ReadableInterval) mutableInterval2);
        org.junit.Assert.assertNotNull(weeks5);
    }

    @Test
    public void test383() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test383");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology2 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone3 = ethiopicChronology2.getZone();
        Object obj4 = null;
        Chronology chronology5 = null;
        Interval interval6 = new Interval(obj4, chronology5);
        Weeks weeks7 = Weeks.ONE;
        Interval interval8 = interval6.withPeriodAfterStart((ReadablePeriod) weeks7);
        int[] intArray11 = ethiopicChronology2.get((ReadablePeriod) weeks7, (long) (short) -1, (long) (short) -1);
        DurationField durationField12 = ethiopicChronology2.minutes();
        DateTimeField dateTimeField13 = ethiopicChronology2.clockhourOfDay();
        MutablePeriod mutablePeriod14 = new MutablePeriod((long) '#', (long) (byte) -1, (Chronology) ethiopicChronology2);
        mutablePeriod14.setSeconds((int) (short) 0);
        org.junit.Assert.assertNotNull(ethiopicChronology2);
        org.junit.Assert.assertNotNull(dateTimeZone3);
        org.junit.Assert.assertNotNull(weeks7);
        org.junit.Assert.assertNotNull(interval8);
        org.junit.Assert.assertNotNull(intArray11);
        org.junit.Assert.assertArrayEquals(intArray11, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField12);
        org.junit.Assert.assertNotNull(dateTimeField13);
    }

    @Test
    public void test384() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test384");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField4 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField3);
        int int6 = delegatedDateTimeField4.get((long) (byte) 10);
        LocalDate localDate7 = new LocalDate();
        LocalDate localDate9 = localDate7.minusWeeks(3);
        LocalDate.Property property10 = localDate9.monthOfYear();
        java.util.Locale locale12 = null;
        String str13 = delegatedDateTimeField4.getAsText((ReadablePartial) localDate9, (int) (byte) 10, locale12);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology14 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone15 = ethiopicChronology14.getZone();
        DurationField durationField16 = ethiopicChronology14.hours();
        DateTimeField dateTimeField17 = ethiopicChronology14.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField18 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField17);
        int int20 = delegatedDateTimeField18.get((long) (byte) 10);
        LocalDate localDate21 = new LocalDate();
        LocalDate localDate23 = localDate21.minusWeeks(3);
        LocalDate.Property property24 = localDate23.monthOfYear();
        java.util.Locale locale26 = null;
        String str27 = delegatedDateTimeField18.getAsText((ReadablePartial) localDate23, (int) (byte) 10, locale26);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology28 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone29 = ethiopicChronology28.getZone();
        long long33 = dateTimeZone29.convertLocalToUTC((long) 6, false, 0L);
        YearMonthDay yearMonthDay34 = new YearMonthDay(dateTimeZone29);
        DateTime dateTime35 = localDate23.toDateTimeAtStartOfDay(dateTimeZone29);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology36 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone37 = ethiopicChronology36.getZone();
        Weeks weeks38 = Weeks.ONE;
        int[] intArray41 = ethiopicChronology36.get((ReadablePeriod) weeks38, (long) (short) 1, 100L);
        int int42 = delegatedDateTimeField4.getMinimumValue((ReadablePartial) localDate23, intArray41);
        int int44 = delegatedDateTimeField4.getMaximumValue((long) 143);
        java.util.Locale locale47 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long48 = delegatedDateTimeField4.set((long) 7, "PT0S", locale47);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value \"PT0S\" for clockhourOfDay is not supported");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
        org.junit.Assert.assertNotNull(localDate9);
        org.junit.Assert.assertNotNull(property10);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "10" + "'", str13, "10");
        org.junit.Assert.assertNotNull(ethiopicChronology14);
        org.junit.Assert.assertNotNull(dateTimeZone15);
        org.junit.Assert.assertNotNull(durationField16);
        org.junit.Assert.assertNotNull(dateTimeField17);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 10 + "'", int20 == 10);
        org.junit.Assert.assertNotNull(localDate23);
        org.junit.Assert.assertNotNull(property24);
        org.junit.Assert.assertEquals("'" + str27 + "' != '" + "10" + "'", str27, "10");
        org.junit.Assert.assertNotNull(ethiopicChronology28);
        org.junit.Assert.assertNotNull(dateTimeZone29);
        org.junit.Assert.assertTrue("'" + long33 + "' != '" + (-35999994L) + "'", long33 == (-35999994L));
        org.junit.Assert.assertNotNull(dateTime35);
        org.junit.Assert.assertNotNull(ethiopicChronology36);
        org.junit.Assert.assertNotNull(dateTimeZone37);
        org.junit.Assert.assertNotNull(weeks38);
        org.junit.Assert.assertNotNull(intArray41);
        org.junit.Assert.assertArrayEquals(intArray41, new int[] { 0 });
        org.junit.Assert.assertTrue("'" + int42 + "' != '" + 1 + "'", int42 == 1);
        org.junit.Assert.assertTrue("'" + int44 + "' != '" + 24 + "'", int44 == 24);
    }

    @Test
    public void test385() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test385");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Weeks weeks2 = Weeks.ONE;
        int[] intArray5 = ethiopicChronology0.get((ReadablePeriod) weeks2, (long) (short) 1, 100L);
        DateTimeField dateTimeField6 = ethiopicChronology0.millisOfDay();
        MutableDateTime mutableDateTime7 = new MutableDateTime((Chronology) ethiopicChronology0);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks2);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField6);
    }

    @Test
    public void test386() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test386");
        Instant instant0 = Instant.now();
        MutableDateTime mutableDateTime1 = MutableDateTime.now();
        Object obj2 = null;
        Chronology chronology3 = null;
        Interval interval4 = new Interval(obj2, chronology3);
        Months months5 = Months.monthsIn((ReadableInterval) interval4);
        Duration duration6 = interval4.toDuration();
        DateMidnight dateMidnight8 = new DateMidnight(0L);
        PeriodType periodType9 = PeriodType.days();
        MutablePeriod mutablePeriod10 = new MutablePeriod((ReadableDuration) duration6, (ReadableInstant) dateMidnight8, periodType9);
        Chronology chronology11 = null;
        Period period12 = duration6.toPeriod(chronology11);
        Object obj13 = null;
        Chronology chronology14 = null;
        Interval interval15 = new Interval(obj13, chronology14);
        Months months16 = Months.monthsIn((ReadableInterval) interval15);
        Duration duration17 = interval15.toDuration();
        DateMidnight dateMidnight19 = new DateMidnight(0L);
        PeriodType periodType20 = PeriodType.days();
        MutablePeriod mutablePeriod21 = new MutablePeriod((ReadableDuration) duration17, (ReadableInstant) dateMidnight19, periodType20);
        boolean boolean22 = duration6.isShorterThan((ReadableDuration) duration17);
        mutableDateTime1.add((ReadableDuration) duration17, 10);
        mutableDateTime1.setWeekOfWeekyear((int) (byte) 1);
        DateMidnight dateMidnight28 = new DateMidnight(0L);
        DateMidnight dateMidnight30 = new DateMidnight(0L);
        boolean boolean31 = dateMidnight28.isEqual((ReadableInstant) dateMidnight30);
        MutableDateTime mutableDateTime32 = MutableDateTime.now();
        Object obj33 = null;
        Chronology chronology34 = null;
        Interval interval35 = new Interval(obj33, chronology34);
        Months months36 = Months.monthsIn((ReadableInterval) interval35);
        Duration duration37 = interval35.toDuration();
        DateMidnight dateMidnight39 = new DateMidnight(0L);
        PeriodType periodType40 = PeriodType.days();
        MutablePeriod mutablePeriod41 = new MutablePeriod((ReadableDuration) duration37, (ReadableInstant) dateMidnight39, periodType40);
        Chronology chronology42 = null;
        Period period43 = duration37.toPeriod(chronology42);
        Object obj44 = null;
        Chronology chronology45 = null;
        Interval interval46 = new Interval(obj44, chronology45);
        Months months47 = Months.monthsIn((ReadableInterval) interval46);
        Duration duration48 = interval46.toDuration();
        DateMidnight dateMidnight50 = new DateMidnight(0L);
        PeriodType periodType51 = PeriodType.days();
        MutablePeriod mutablePeriod52 = new MutablePeriod((ReadableDuration) duration48, (ReadableInstant) dateMidnight50, periodType51);
        boolean boolean53 = duration37.isShorterThan((ReadableDuration) duration48);
        mutableDateTime32.add((ReadableDuration) duration48, 10);
        MutableInterval mutableInterval56 = new MutableInterval((ReadableInstant) dateMidnight30, (ReadableDuration) duration48);
        mutableDateTime1.add((ReadableDuration) duration48);
        DateMidnight dateMidnight59 = new DateMidnight(0L);
        Chronology chronology60 = null;
        DateMidnight dateMidnight61 = dateMidnight59.withChronology(chronology60);
        DateMidnight dateMidnight63 = dateMidnight59.withCenturyOfEra((int) ' ');
        DateMidnight.Property property64 = dateMidnight59.dayOfMonth();
        DateMidnight dateMidnight66 = new DateMidnight(0L);
        Chronology chronology67 = null;
        DateMidnight dateMidnight68 = dateMidnight66.withChronology(chronology67);
        DateMidnight dateMidnight70 = dateMidnight66.withCenturyOfEra((int) ' ');
        DateMidnight.Property property71 = dateMidnight66.dayOfMonth();
        int int72 = dateMidnight66.getMinuteOfHour();
        Duration duration73 = new Duration((ReadableInstant) dateMidnight59, (ReadableInstant) dateMidnight66);
        boolean boolean74 = duration48.isShorterThan((ReadableDuration) duration73);
        Instant instant75 = instant0.minus((ReadableDuration) duration48);
        org.junit.Assert.assertNotNull(instant0);
        org.junit.Assert.assertNotNull(mutableDateTime1);
        org.junit.Assert.assertNotNull(months5);
        org.junit.Assert.assertNotNull(duration6);
        org.junit.Assert.assertNotNull(periodType9);
        org.junit.Assert.assertNotNull(period12);
        org.junit.Assert.assertNotNull(months16);
        org.junit.Assert.assertNotNull(duration17);
        org.junit.Assert.assertNotNull(periodType20);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + true + "'", boolean31 == true);
        org.junit.Assert.assertNotNull(mutableDateTime32);
        org.junit.Assert.assertNotNull(months36);
        org.junit.Assert.assertNotNull(duration37);
        org.junit.Assert.assertNotNull(periodType40);
        org.junit.Assert.assertNotNull(period43);
        org.junit.Assert.assertNotNull(months47);
        org.junit.Assert.assertNotNull(duration48);
        org.junit.Assert.assertNotNull(periodType51);
        org.junit.Assert.assertTrue("'" + boolean53 + "' != '" + false + "'", boolean53 == false);
        org.junit.Assert.assertNotNull(dateMidnight61);
        org.junit.Assert.assertNotNull(dateMidnight63);
        org.junit.Assert.assertNotNull(property64);
        org.junit.Assert.assertNotNull(dateMidnight68);
        org.junit.Assert.assertNotNull(dateMidnight70);
        org.junit.Assert.assertNotNull(property71);
        org.junit.Assert.assertTrue("'" + int72 + "' != '" + 0 + "'", int72 == 0);
        org.junit.Assert.assertTrue("'" + boolean74 + "' != '" + false + "'", boolean74 == false);
        org.junit.Assert.assertNotNull(instant75);
    }

    @Test
    public void test387() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test387");
        DateTimeZone dateTimeZone1 = null;
        MutableDateTime mutableDateTime2 = new MutableDateTime((long) 10080, dateTimeZone1);
        DateMidnight dateMidnight4 = new DateMidnight(0L);
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        boolean boolean7 = dateMidnight4.isEqual((ReadableInstant) dateMidnight6);
        int int8 = dateMidnight4.getSecondOfDay();
        DateMidnight dateMidnight10 = dateMidnight4.plus((long) 36000000);
        mutableDateTime2.setMillis((ReadableInstant) dateMidnight10);
        int int12 = dateMidnight10.getWeekOfWeekyear();
        // The following exception was thrown during execution in test generation
        try {
            DateMidnight dateMidnight14 = dateMidnight10.withYearOfCentury(86400000);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 86400000 for yearOfCentury must be in the range [0,99]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateMidnight10);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 1 + "'", int12 == 1);
    }

    @Test
    public void test388() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test388");
        Period period0 = Period.ZERO;
        org.junit.Assert.assertNotNull(period0);
    }

    @Test
    public void test389() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test389");
        int int2 = org.joda.time.field.FieldUtils.safeAdd((int) (byte) -1, 9);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 8 + "'", int2 == 8);
    }

    @Test
    public void test390() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test390");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter0 = org.joda.time.format.DateTimeFormat.shortTime();
        org.junit.Assert.assertNotNull(dateTimeFormatter0);
    }

    @Test
    public void test391() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test391");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField4 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField3);
        int int6 = delegatedDateTimeField4.get((long) (byte) 10);
        java.util.Locale locale8 = null;
        String str9 = delegatedDateTimeField4.getAsShortText((long) (byte) 10, locale8);
        long long12 = delegatedDateTimeField4.add((long) 100, 3);
        DateTimeFieldType dateTimeFieldType13 = DateTimeFieldType.millisOfDay();
        IllegalFieldValueException illegalFieldValueException16 = new IllegalFieldValueException(dateTimeFieldType13, (Number) 9, "hi!");
        org.joda.time.field.RemainderDateTimeField remainderDateTimeField18 = new org.joda.time.field.RemainderDateTimeField((DateTimeField) delegatedDateTimeField4, dateTimeFieldType13, (int) 'a');
        long long20 = remainderDateTimeField18.roundHalfEven((long) 4);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "10" + "'", str9, "10");
        org.junit.Assert.assertTrue("'" + long12 + "' != '" + 10800100L + "'", long12 == 10800100L);
        org.junit.Assert.assertNotNull(dateTimeFieldType13);
        org.junit.Assert.assertTrue("'" + long20 + "' != '" + 0L + "'", long20 == 0L);
    }

    @Test
    public void test392() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test392");
        LocalDateTime localDateTime0 = LocalDateTime.now();
        LocalDateTime.Property property1 = localDateTime0.secondOfMinute();
        org.junit.Assert.assertNotNull(localDateTime0);
        org.junit.Assert.assertNotNull(property1);
    }

    @Test
    public void test393() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test393");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        DurationField durationField6 = ethiopicChronology4.hours();
        int int8 = durationField6.getValue(0L);
        DateTimeFieldType dateTimeFieldType9 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField11 = new org.joda.time.field.DividedDateTimeField(dateTimeField3, durationField6, dateTimeFieldType9, (int) '4');
        DateTimeFieldType dateTimeFieldType12 = DateTimeFieldType.clockhourOfHalfday();
        org.joda.time.field.OffsetDateTimeField offsetDateTimeField16 = new org.joda.time.field.OffsetDateTimeField((DateTimeField) dividedDateTimeField11, dateTimeFieldType12, 7, 1, 12);
        // The following exception was thrown during execution in test generation
        try {
            long long18 = offsetDateTimeField16.roundHalfCeiling((-36000000L));
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 0 for clockhourOfDay must be in the range [1,24]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType9);
        org.junit.Assert.assertNotNull(dateTimeFieldType12);
    }

    @Test
    public void test394() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test394");
        DateTime dateTime0 = new DateTime();
        DateTime.Property property1 = dateTime0.hourOfDay();
        DateTime dateTime3 = dateTime0.withSecondOfMinute((int) '4');
        int int4 = dateTime3.getCenturyOfEra();
        org.junit.Assert.assertNotNull(property1);
        org.junit.Assert.assertNotNull(dateTime3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 20 + "'", int4 == 20);
    }

    @Test
    public void test395() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test395");
        Hours hours0 = Hours.SIX;
        MutablePeriod mutablePeriod1 = hours0.toMutablePeriod();
        mutablePeriod1.addYears((int) '#');
        org.junit.Assert.assertNotNull(hours0);
        org.junit.Assert.assertNotNull(mutablePeriod1);
    }

    @Test
    public void test396() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test396");
        DateTime dateTime1 = DateTime.parse("23");
        int int2 = dateTime1.getMonthOfYear();
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Months months6 = Months.monthsIn((ReadableInterval) interval5);
        Duration duration7 = interval5.toDuration();
        DateMidnight dateMidnight9 = new DateMidnight(0L);
        PeriodType periodType10 = PeriodType.days();
        MutablePeriod mutablePeriod11 = new MutablePeriod((ReadableDuration) duration7, (ReadableInstant) dateMidnight9, periodType10);
        Chronology chronology12 = null;
        Period period13 = duration7.toPeriod(chronology12);
        Object obj14 = null;
        Chronology chronology15 = null;
        Interval interval16 = new Interval(obj14, chronology15);
        Months months17 = Months.monthsIn((ReadableInterval) interval16);
        Duration duration18 = interval16.toDuration();
        DateMidnight dateMidnight20 = new DateMidnight(0L);
        PeriodType periodType21 = PeriodType.days();
        MutablePeriod mutablePeriod22 = new MutablePeriod((ReadableDuration) duration18, (ReadableInstant) dateMidnight20, periodType21);
        boolean boolean23 = duration7.isShorterThan((ReadableDuration) duration18);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology24 = org.joda.time.chrono.EthiopicChronology.getInstance();
        Period period25 = new Period((Object) duration7, (Chronology) ethiopicChronology24);
        Months months26 = Months.MAX_VALUE;
        Months months27 = Months.MAX_VALUE;
        Object obj28 = null;
        Chronology chronology29 = null;
        Interval interval30 = new Interval(obj28, chronology29);
        Months months31 = Months.monthsIn((ReadableInterval) interval30);
        boolean boolean32 = months27.isGreaterThan(months31);
        Months months33 = months26.minus(months27);
        PeriodType periodType34 = months33.getPeriodType();
        Period period35 = period25.normalizedStandard(periodType34);
        Period period37 = period25.plusWeeks(168);
        DateTime dateTime38 = dateTime1.minus((ReadablePeriod) period25);
        org.junit.Assert.assertNotNull(dateTime1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 1 + "'", int2 == 1);
        org.junit.Assert.assertNotNull(months6);
        org.junit.Assert.assertNotNull(duration7);
        org.junit.Assert.assertNotNull(periodType10);
        org.junit.Assert.assertNotNull(period13);
        org.junit.Assert.assertNotNull(months17);
        org.junit.Assert.assertNotNull(duration18);
        org.junit.Assert.assertNotNull(periodType21);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNotNull(ethiopicChronology24);
        org.junit.Assert.assertNotNull(months26);
        org.junit.Assert.assertNotNull(months27);
        org.junit.Assert.assertNotNull(months31);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + true + "'", boolean32 == true);
        org.junit.Assert.assertNotNull(months33);
        org.junit.Assert.assertNotNull(periodType34);
        org.junit.Assert.assertNotNull(period35);
        org.junit.Assert.assertNotNull(period37);
        org.junit.Assert.assertNotNull(dateTime38);
    }

    @Test
    public void test397() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test397");
        MutablePeriod mutablePeriod8 = new MutablePeriod(10, (int) (byte) -1, 0, (-1), 1, (int) (short) 100, 12, (-1));
        mutablePeriod8.setSeconds((int) '#');
    }

    @Test
    public void test398() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test398");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Weeks weeks6 = Weeks.ONE;
        Interval interval7 = interval5.withPeriodAfterStart((ReadablePeriod) weeks6);
        int[] intArray10 = ethiopicChronology1.get((ReadablePeriod) weeks6, (long) (short) -1, (long) (short) -1);
        DurationField durationField11 = ethiopicChronology1.minutes();
        YearMonthDay yearMonthDay12 = new YearMonthDay(100L, (Chronology) ethiopicChronology1);
        YearMonthDay.Property property13 = yearMonthDay12.monthOfYear();
        int int14 = property13.get();
        YearMonthDay yearMonthDay15 = property13.withMinimumValue();
        YearMonthDay yearMonthDay16 = property13.getYearMonthDay();
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(weeks6);
        org.junit.Assert.assertNotNull(interval7);
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField11);
        org.junit.Assert.assertNotNull(property13);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 4 + "'", int14 == 4);
        org.junit.Assert.assertNotNull(yearMonthDay15);
        org.junit.Assert.assertNotNull(yearMonthDay16);
    }

    @Test
    public void test399() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test399");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField4 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField3);
        int int6 = delegatedDateTimeField4.get((long) (byte) 10);
        java.util.Locale locale8 = null;
        String str9 = delegatedDateTimeField4.getAsShortText((long) (byte) 10, locale8);
        java.util.Locale locale11 = null;
        String str12 = delegatedDateTimeField4.getAsText((int) '4', locale11);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "10" + "'", str9, "10");
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "52" + "'", str12, "52");
    }

    @Test
    public void test400() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test400");
        // The following exception was thrown during execution in test generation
        try {
            LocalTime localTime3 = new LocalTime(1970, 10, 36000000);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 1970 for hourOfDay must be in the range [0,23]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
    }

    @Test
    public void test401() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test401");
        LocalDate localDate0 = new LocalDate();
        LocalDate localDate2 = localDate0.minusWeeks(3);
        LocalDate.Property property3 = localDate2.monthOfYear();
        LocalDate localDate4 = property3.roundHalfFloorCopy();
        LocalDate localDate5 = new LocalDate();
        DateTimeFieldType dateTimeFieldType6 = DateTimeFieldType.weekyearOfCentury();
        int int7 = localDate5.indexOf(dateTimeFieldType6);
        LocalDate localDate9 = localDate5.withDayOfYear(24);
        int int10 = localDate4.compareTo((ReadablePartial) localDate9);
        DateTime dateTime11 = localDate4.toDateTimeAtCurrentTime();
        DateTime dateTime12 = dateTime11.withLaterOffsetAtOverlap();
        DateTime dateTime13 = dateTime11.toDateTime();
        org.junit.Assert.assertNotNull(localDate2);
        org.junit.Assert.assertNotNull(property3);
        org.junit.Assert.assertNotNull(localDate4);
        org.junit.Assert.assertNotNull(dateTimeFieldType6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + (-1) + "'", int7 == (-1));
        org.junit.Assert.assertNotNull(localDate9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 1 + "'", int10 == 1);
        org.junit.Assert.assertNotNull(dateTime11);
        org.junit.Assert.assertNotNull(dateTime12);
        org.junit.Assert.assertNotNull(dateTime13);
    }

    @Test
    public void test402() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test402");
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder0 = new org.joda.time.format.DateTimeFormatterBuilder();
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder3 = dateTimeFormatterBuilder0.appendCenturyOfEra(9, 2);
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder5 = dateTimeFormatterBuilder3.appendDayOfYear((int) (short) 0);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology6 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone7 = ethiopicChronology6.getZone();
        DurationField durationField8 = ethiopicChronology6.hours();
        DateTimeField dateTimeField9 = ethiopicChronology6.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology10 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone11 = ethiopicChronology10.getZone();
        DurationField durationField12 = ethiopicChronology10.hours();
        int int14 = durationField12.getValue(0L);
        DateTimeFieldType dateTimeFieldType15 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField17 = new org.joda.time.field.DividedDateTimeField(dateTimeField9, durationField12, dateTimeFieldType15, (int) '4');
        DateTimeFieldType dateTimeFieldType18 = DateTimeFieldType.clockhourOfHalfday();
        org.joda.time.field.OffsetDateTimeField offsetDateTimeField22 = new org.joda.time.field.OffsetDateTimeField((DateTimeField) dividedDateTimeField17, dateTimeFieldType18, 7, 1, 12);
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder23 = dateTimeFormatterBuilder5.appendShortText(dateTimeFieldType18);
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder26 = dateTimeFormatterBuilder5.appendYearOfEra(7, 1920);
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder3);
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder5);
        org.junit.Assert.assertNotNull(ethiopicChronology6);
        org.junit.Assert.assertNotNull(dateTimeZone7);
        org.junit.Assert.assertNotNull(durationField8);
        org.junit.Assert.assertNotNull(dateTimeField9);
        org.junit.Assert.assertNotNull(ethiopicChronology10);
        org.junit.Assert.assertNotNull(dateTimeZone11);
        org.junit.Assert.assertNotNull(durationField12);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType15);
        org.junit.Assert.assertNotNull(dateTimeFieldType18);
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder23);
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder26);
    }

    @Test
    public void test403() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test403");
        MutableInterval mutableInterval2 = new MutableInterval((long) (byte) -1, (long) 1);
        Object obj3 = mutableInterval2.clone();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology6 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone7 = ethiopicChronology6.getZone();
        Weeks weeks8 = Weeks.ONE;
        int[] intArray11 = ethiopicChronology6.get((ReadablePeriod) weeks8, (long) (short) 1, 100L);
        Period period12 = new Period((long) (short) 0, (long) 'a', (Chronology) ethiopicChronology6);
        DateTimeField dateTimeField13 = ethiopicChronology6.dayOfMonth();
        Period period14 = new Period((Object) mutableInterval2, (Chronology) ethiopicChronology6);
        Object obj15 = mutableInterval2.clone();
        // The following exception was thrown during execution in test generation
        try {
            mutableInterval2.setEndMillis((long) (-292269338));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The end instant must be greater than the start instant");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(obj3);
        org.junit.Assert.assertEquals(obj3.toString(), "1970-01-01T09:59:59.999+10:00/1970-01-01T10:00:00.001+10:00");
        org.junit.Assert.assertEquals(String.valueOf(obj3), "1970-01-01T09:59:59.999+10:00/1970-01-01T10:00:00.001+10:00");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj3), "1970-01-01T09:59:59.999+10:00/1970-01-01T10:00:00.001+10:00");
        org.junit.Assert.assertNotNull(ethiopicChronology6);
        org.junit.Assert.assertNotNull(dateTimeZone7);
        org.junit.Assert.assertNotNull(weeks8);
        org.junit.Assert.assertNotNull(intArray11);
        org.junit.Assert.assertArrayEquals(intArray11, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField13);
        org.junit.Assert.assertNotNull(obj15);
        org.junit.Assert.assertEquals(obj15.toString(), "1970-01-01T09:59:59.999+10:00/1970-01-01T10:00:00.001+10:00");
        org.junit.Assert.assertEquals(String.valueOf(obj15), "1970-01-01T09:59:59.999+10:00/1970-01-01T10:00:00.001+10:00");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj15), "1970-01-01T09:59:59.999+10:00/1970-01-01T10:00:00.001+10:00");
    }

    @Test
    public void test404() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test404");
        MutableInterval mutableInterval2 = new MutableInterval((long) (byte) -1, (long) 1);
        MutableInterval mutableInterval3 = mutableInterval2.copy();
        DateTimeZone dateTimeZone5 = null;
        MutableDateTime mutableDateTime6 = new MutableDateTime((long) 10080, dateTimeZone5);
        DateMidnight dateMidnight8 = new DateMidnight(0L);
        DateMidnight dateMidnight10 = new DateMidnight(0L);
        boolean boolean11 = dateMidnight8.isEqual((ReadableInstant) dateMidnight10);
        int int12 = dateMidnight8.getSecondOfDay();
        DateMidnight dateMidnight14 = dateMidnight8.plus((long) 36000000);
        mutableDateTime6.setMillis((ReadableInstant) dateMidnight14);
        mutableDateTime6.setYear(60);
        DateTime dateTime18 = new DateTime();
        DateTime.Property property19 = dateTime18.hourOfDay();
        int int20 = dateTime18.getDayOfYear();
        mutableInterval2.setInterval((ReadableInstant) mutableDateTime6, (ReadableInstant) dateTime18);
        int int22 = mutableDateTime6.getWeekOfWeekyear();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology23 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone24 = ethiopicChronology23.getZone();
        DurationField durationField25 = ethiopicChronology23.hours();
        DateTimeField dateTimeField26 = ethiopicChronology23.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology27 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone28 = ethiopicChronology27.getZone();
        DurationField durationField29 = ethiopicChronology27.hours();
        int int31 = durationField29.getValue(0L);
        DateTimeFieldType dateTimeFieldType32 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField34 = new org.joda.time.field.DividedDateTimeField(dateTimeField26, durationField29, dateTimeFieldType32, (int) '4');
        DateTimeFieldType dateTimeFieldType35 = DateTimeFieldType.clockhourOfHalfday();
        org.joda.time.field.OffsetDateTimeField offsetDateTimeField39 = new org.joda.time.field.OffsetDateTimeField((DateTimeField) dividedDateTimeField34, dateTimeFieldType35, 7, 1, 12);
        // The following exception was thrown during execution in test generation
        try {
            mutableDateTime6.setRounding((DateTimeField) offsetDateTimeField39);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 0 for clockhourOfDay must be in the range [1,24]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(mutableInterval3);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(dateMidnight14);
        org.junit.Assert.assertNotNull(property19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 143 + "'", int20 == 143);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 1 + "'", int22 == 1);
        org.junit.Assert.assertNotNull(ethiopicChronology23);
        org.junit.Assert.assertNotNull(dateTimeZone24);
        org.junit.Assert.assertNotNull(durationField25);
        org.junit.Assert.assertNotNull(dateTimeField26);
        org.junit.Assert.assertNotNull(ethiopicChronology27);
        org.junit.Assert.assertNotNull(dateTimeZone28);
        org.junit.Assert.assertNotNull(durationField29);
        org.junit.Assert.assertTrue("'" + int31 + "' != '" + 0 + "'", int31 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType32);
        org.junit.Assert.assertNotNull(dateTimeFieldType35);
    }

    @Test
    public void test405() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test405");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField4 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField3);
        int int6 = delegatedDateTimeField4.get((long) (byte) 10);
        java.util.Locale locale8 = null;
        String str9 = delegatedDateTimeField4.getAsShortText((long) (byte) 10, locale8);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology10 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone11 = ethiopicChronology10.getZone();
        DurationField durationField12 = ethiopicChronology10.hours();
        DateTimeField dateTimeField13 = ethiopicChronology10.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField14 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField13);
        int int16 = delegatedDateTimeField14.get((long) (byte) 10);
        LocalDate localDate17 = new LocalDate();
        LocalDate localDate19 = localDate17.minusWeeks(3);
        LocalDate.Property property20 = localDate19.monthOfYear();
        java.util.Locale locale22 = null;
        String str23 = delegatedDateTimeField14.getAsText((ReadablePartial) localDate19, (int) (byte) 10, locale22);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology24 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone25 = ethiopicChronology24.getZone();
        long long29 = dateTimeZone25.convertLocalToUTC((long) 6, false, 0L);
        YearMonthDay yearMonthDay30 = new YearMonthDay(dateTimeZone25);
        DateTime dateTime31 = localDate19.toDateTimeAtStartOfDay(dateTimeZone25);
        LocalDate localDate33 = localDate19.withWeekyear(1);
        LocalDate.Property property34 = localDate33.weekOfWeekyear();
        LocalDate.Property property35 = localDate33.weekOfWeekyear();
        java.util.Locale locale36 = null;
        // The following exception was thrown during execution in test generation
        try {
            String str37 = delegatedDateTimeField4.getAsText((ReadablePartial) localDate33, locale36);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Field 'clockhourOfDay' is not supported");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "10" + "'", str9, "10");
        org.junit.Assert.assertNotNull(ethiopicChronology10);
        org.junit.Assert.assertNotNull(dateTimeZone11);
        org.junit.Assert.assertNotNull(durationField12);
        org.junit.Assert.assertNotNull(dateTimeField13);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 10 + "'", int16 == 10);
        org.junit.Assert.assertNotNull(localDate19);
        org.junit.Assert.assertNotNull(property20);
        org.junit.Assert.assertEquals("'" + str23 + "' != '" + "10" + "'", str23, "10");
        org.junit.Assert.assertNotNull(ethiopicChronology24);
        org.junit.Assert.assertNotNull(dateTimeZone25);
        org.junit.Assert.assertTrue("'" + long29 + "' != '" + (-35999994L) + "'", long29 == (-35999994L));
        org.junit.Assert.assertNotNull(dateTime31);
        org.junit.Assert.assertNotNull(localDate33);
        org.junit.Assert.assertNotNull(property34);
        org.junit.Assert.assertNotNull(property35);
    }

    @Test
    public void test406() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test406");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Months months6 = Months.monthsIn((ReadableInterval) interval5);
        Duration duration7 = interval5.toDuration();
        DateMidnight dateMidnight9 = new DateMidnight(0L);
        PeriodType periodType10 = PeriodType.days();
        MutablePeriod mutablePeriod11 = new MutablePeriod((ReadableDuration) duration7, (ReadableInstant) dateMidnight9, periodType10);
        Interval interval12 = interval2.withStart((ReadableInstant) dateMidnight9);
        long long13 = interval2.getStartMillis();
        org.junit.Assert.assertNotNull(months6);
        org.junit.Assert.assertNotNull(duration7);
        org.junit.Assert.assertNotNull(periodType10);
        org.junit.Assert.assertNotNull(interval12);
// flaky "13) test406(RegressionTest0)":         org.junit.Assert.assertTrue("'" + long13 + "' != '" + 1747989585176L + "'", long13 == 1747989585176L);
    }

    @Test
    public void test407() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test407");
        MutableDateTime mutableDateTime0 = MutableDateTime.now();
        Object obj1 = null;
        Chronology chronology2 = null;
        Interval interval3 = new Interval(obj1, chronology2);
        Months months4 = Months.monthsIn((ReadableInterval) interval3);
        Duration duration5 = interval3.toDuration();
        DateMidnight dateMidnight7 = new DateMidnight(0L);
        PeriodType periodType8 = PeriodType.days();
        MutablePeriod mutablePeriod9 = new MutablePeriod((ReadableDuration) duration5, (ReadableInstant) dateMidnight7, periodType8);
        Chronology chronology10 = null;
        Period period11 = duration5.toPeriod(chronology10);
        Object obj12 = null;
        Chronology chronology13 = null;
        Interval interval14 = new Interval(obj12, chronology13);
        Months months15 = Months.monthsIn((ReadableInterval) interval14);
        Duration duration16 = interval14.toDuration();
        DateMidnight dateMidnight18 = new DateMidnight(0L);
        PeriodType periodType19 = PeriodType.days();
        MutablePeriod mutablePeriod20 = new MutablePeriod((ReadableDuration) duration16, (ReadableInstant) dateMidnight18, periodType19);
        boolean boolean21 = duration5.isShorterThan((ReadableDuration) duration16);
        mutableDateTime0.add((ReadableDuration) duration16, 10);
        mutableDateTime0.setWeekOfWeekyear((int) (byte) 1);
        mutableDateTime0.addHours((int) (short) 1);
        MutableDateTime mutableDateTime28 = mutableDateTime0.copy();
        org.junit.Assert.assertNotNull(mutableDateTime0);
        org.junit.Assert.assertNotNull(months4);
        org.junit.Assert.assertNotNull(duration5);
        org.junit.Assert.assertNotNull(periodType8);
        org.junit.Assert.assertNotNull(period11);
        org.junit.Assert.assertNotNull(months15);
        org.junit.Assert.assertNotNull(duration16);
        org.junit.Assert.assertNotNull(periodType19);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(mutableDateTime28);
    }

    @Test
    public void test408() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test408");
        YearMonthDay yearMonthDay1 = new YearMonthDay((long) 168);
    }

    @Test
    public void test409() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test409");
        org.joda.time.format.PeriodPrinter periodPrinter0 = null;
        org.joda.time.format.PeriodParser periodParser1 = null;
        org.joda.time.format.PeriodFormatter periodFormatter2 = new org.joda.time.format.PeriodFormatter(periodPrinter0, periodParser1);
    }

    @Test
    public void test410() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test410");
        org.joda.time.chrono.CopticChronology copticChronology0 = org.joda.time.chrono.CopticChronology.getInstanceUTC();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology2 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone3 = ethiopicChronology2.getZone();
        Object obj4 = null;
        Chronology chronology5 = null;
        Interval interval6 = new Interval(obj4, chronology5);
        Weeks weeks7 = Weeks.ONE;
        Interval interval8 = interval6.withPeriodAfterStart((ReadablePeriod) weeks7);
        int[] intArray11 = ethiopicChronology2.get((ReadablePeriod) weeks7, (long) (short) -1, (long) (short) -1);
        DurationField durationField12 = ethiopicChronology2.minutes();
        YearMonthDay yearMonthDay13 = new YearMonthDay(100L, (Chronology) ethiopicChronology2);
        DateTimeField dateTimeField14 = ethiopicChronology2.minuteOfDay();
        DateTimeField dateTimeField15 = ethiopicChronology2.dayOfMonth();
        DateTimeZone dateTimeZone16 = ethiopicChronology2.getZone();
        Chronology chronology17 = copticChronology0.withZone(dateTimeZone16);
        DateTime dateTime18 = new DateTime(dateTimeZone16);
        org.junit.Assert.assertNotNull(copticChronology0);
        org.junit.Assert.assertNotNull(ethiopicChronology2);
        org.junit.Assert.assertNotNull(dateTimeZone3);
        org.junit.Assert.assertNotNull(weeks7);
        org.junit.Assert.assertNotNull(interval8);
        org.junit.Assert.assertNotNull(intArray11);
        org.junit.Assert.assertArrayEquals(intArray11, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField12);
        org.junit.Assert.assertNotNull(dateTimeField14);
        org.junit.Assert.assertNotNull(dateTimeField15);
        org.junit.Assert.assertNotNull(dateTimeZone16);
        org.junit.Assert.assertNotNull(chronology17);
    }

    @Test
    public void test411() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test411");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Weeks weeks6 = Weeks.ONE;
        Interval interval7 = interval5.withPeriodAfterStart((ReadablePeriod) weeks6);
        int[] intArray10 = ethiopicChronology1.get((ReadablePeriod) weeks6, (long) (short) -1, (long) (short) -1);
        DurationField durationField11 = ethiopicChronology1.minutes();
        YearMonthDay yearMonthDay12 = new YearMonthDay(100L, (Chronology) ethiopicChronology1);
        YearMonthDay.Property property13 = yearMonthDay12.monthOfYear();
        YearMonthDay yearMonthDay15 = property13.addWrapFieldToCopy(9);
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(weeks6);
        org.junit.Assert.assertNotNull(interval7);
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField11);
        org.junit.Assert.assertNotNull(property13);
        org.junit.Assert.assertNotNull(yearMonthDay15);
    }

    @Test
    public void test412() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test412");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Months months6 = Months.monthsIn((ReadableInterval) interval5);
        Duration duration7 = interval5.toDuration();
        DateMidnight dateMidnight9 = new DateMidnight(0L);
        PeriodType periodType10 = PeriodType.days();
        MutablePeriod mutablePeriod11 = new MutablePeriod((ReadableDuration) duration7, (ReadableInstant) dateMidnight9, periodType10);
        Interval interval12 = interval2.withStart((ReadableInstant) dateMidnight9);
        ReadableInstant readableInstant13 = null;
        DateTime dateTime14 = new DateTime();
        Interval interval15 = new Interval(readableInstant13, (ReadableInstant) dateTime14);
        DateTime dateTime17 = dateTime14.withWeekyear(0);
        DateTime dateTime18 = new DateTime();
        DateTime dateTime20 = dateTime18.minusMonths((int) (byte) 100);
        DateTime dateTime21 = dateTime20.toDateTimeISO();
        MutableInterval mutableInterval22 = new MutableInterval((ReadableInstant) dateTime17, (ReadableInstant) dateTime21);
        boolean boolean24 = mutableInterval22.contains((long) 100);
        boolean boolean25 = interval2.contains((ReadableInterval) mutableInterval22);
        Chronology chronology26 = interval2.getChronology();
        org.junit.Assert.assertNotNull(months6);
        org.junit.Assert.assertNotNull(duration7);
        org.junit.Assert.assertNotNull(periodType10);
        org.junit.Assert.assertNotNull(interval12);
        org.junit.Assert.assertNotNull(dateTime17);
        org.junit.Assert.assertNotNull(dateTime20);
        org.junit.Assert.assertNotNull(dateTime21);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(chronology26);
    }

    @Test
    public void test413() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test413");
        Seconds seconds0 = Seconds.ZERO;
        org.junit.Assert.assertNotNull(seconds0);
    }

    @Test
    public void test414() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test414");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter0 = org.joda.time.format.ISODateTimeFormat.timeElementParser();
        Appendable appendable1 = null;
        DateMidnight dateMidnight3 = new DateMidnight(0L);
        Chronology chronology4 = null;
        DateMidnight dateMidnight5 = dateMidnight3.withChronology(chronology4);
        DateMidnight dateMidnight7 = dateMidnight3.withCenturyOfEra((int) ' ');
        DateMidnight.Property property8 = dateMidnight3.dayOfMonth();
        // The following exception was thrown during execution in test generation
        try {
            dateTimeFormatter0.printTo(appendable1, (ReadableInstant) dateMidnight3);
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: Printing not supported");
        } catch (UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(dateTimeFormatter0);
        org.junit.Assert.assertNotNull(dateMidnight5);
        org.junit.Assert.assertNotNull(dateMidnight7);
        org.junit.Assert.assertNotNull(property8);
    }

    @Test
    public void test415() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test415");
        IllegalInstantException illegalInstantException2 = new IllegalInstantException((long) 60, "2025-05-23T18:38:56.233+10:00/2025-05-23T18:38:56.233+10:00");
    }

    @Test
    public void test416() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test416");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        DateMidnight dateMidnight3 = new DateMidnight(0L);
        boolean boolean4 = dateMidnight1.isEqual((ReadableInstant) dateMidnight3);
        Object obj5 = null;
        Chronology chronology6 = null;
        Interval interval7 = new Interval(obj5, chronology6);
        Months months8 = Months.monthsIn((ReadableInterval) interval7);
        Duration duration9 = interval7.toDuration();
        DateMidnight dateMidnight11 = new DateMidnight(0L);
        PeriodType periodType12 = PeriodType.days();
        MutablePeriod mutablePeriod13 = new MutablePeriod((ReadableDuration) duration9, (ReadableInstant) dateMidnight11, periodType12);
        Chronology chronology14 = null;
        Period period15 = duration9.toPeriod(chronology14);
        PeriodType periodType16 = PeriodType.yearMonthDayTime();
        MutablePeriod mutablePeriod17 = new MutablePeriod((ReadableInstant) dateMidnight3, (ReadableDuration) duration9, periodType16);
        DateMidnight dateMidnight19 = dateMidnight3.minusMonths((int) (short) -1);
        DateMidnight dateMidnight21 = dateMidnight3.minusMonths(1);
        MutableDateTime mutableDateTime22 = MutableDateTime.now();
        Object obj23 = null;
        Chronology chronology24 = null;
        Interval interval25 = new Interval(obj23, chronology24);
        Months months26 = Months.monthsIn((ReadableInterval) interval25);
        Duration duration27 = interval25.toDuration();
        DateMidnight dateMidnight29 = new DateMidnight(0L);
        PeriodType periodType30 = PeriodType.days();
        MutablePeriod mutablePeriod31 = new MutablePeriod((ReadableDuration) duration27, (ReadableInstant) dateMidnight29, periodType30);
        Chronology chronology32 = null;
        Period period33 = duration27.toPeriod(chronology32);
        Object obj34 = null;
        Chronology chronology35 = null;
        Interval interval36 = new Interval(obj34, chronology35);
        Months months37 = Months.monthsIn((ReadableInterval) interval36);
        Duration duration38 = interval36.toDuration();
        DateMidnight dateMidnight40 = new DateMidnight(0L);
        PeriodType periodType41 = PeriodType.days();
        MutablePeriod mutablePeriod42 = new MutablePeriod((ReadableDuration) duration38, (ReadableInstant) dateMidnight40, periodType41);
        boolean boolean43 = duration27.isShorterThan((ReadableDuration) duration38);
        mutableDateTime22.add((ReadableDuration) duration38, 10);
        mutableDateTime22.setWeekOfWeekyear((int) (byte) 1);
        DateMidnight dateMidnight49 = new DateMidnight(0L);
        DateMidnight dateMidnight51 = new DateMidnight(0L);
        boolean boolean52 = dateMidnight49.isEqual((ReadableInstant) dateMidnight51);
        MutableDateTime mutableDateTime53 = MutableDateTime.now();
        Object obj54 = null;
        Chronology chronology55 = null;
        Interval interval56 = new Interval(obj54, chronology55);
        Months months57 = Months.monthsIn((ReadableInterval) interval56);
        Duration duration58 = interval56.toDuration();
        DateMidnight dateMidnight60 = new DateMidnight(0L);
        PeriodType periodType61 = PeriodType.days();
        MutablePeriod mutablePeriod62 = new MutablePeriod((ReadableDuration) duration58, (ReadableInstant) dateMidnight60, periodType61);
        Chronology chronology63 = null;
        Period period64 = duration58.toPeriod(chronology63);
        Object obj65 = null;
        Chronology chronology66 = null;
        Interval interval67 = new Interval(obj65, chronology66);
        Months months68 = Months.monthsIn((ReadableInterval) interval67);
        Duration duration69 = interval67.toDuration();
        DateMidnight dateMidnight71 = new DateMidnight(0L);
        PeriodType periodType72 = PeriodType.days();
        MutablePeriod mutablePeriod73 = new MutablePeriod((ReadableDuration) duration69, (ReadableInstant) dateMidnight71, periodType72);
        boolean boolean74 = duration58.isShorterThan((ReadableDuration) duration69);
        mutableDateTime53.add((ReadableDuration) duration69, 10);
        MutableInterval mutableInterval77 = new MutableInterval((ReadableInstant) dateMidnight51, (ReadableDuration) duration69);
        mutableDateTime22.add((ReadableDuration) duration69);
        DateMidnight dateMidnight79 = dateMidnight21.minus((ReadableDuration) duration69);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(months8);
        org.junit.Assert.assertNotNull(duration9);
        org.junit.Assert.assertNotNull(periodType12);
        org.junit.Assert.assertNotNull(period15);
        org.junit.Assert.assertNotNull(periodType16);
        org.junit.Assert.assertNotNull(dateMidnight19);
        org.junit.Assert.assertNotNull(dateMidnight21);
        org.junit.Assert.assertNotNull(mutableDateTime22);
        org.junit.Assert.assertNotNull(months26);
        org.junit.Assert.assertNotNull(duration27);
        org.junit.Assert.assertNotNull(periodType30);
        org.junit.Assert.assertNotNull(period33);
        org.junit.Assert.assertNotNull(months37);
        org.junit.Assert.assertNotNull(duration38);
        org.junit.Assert.assertNotNull(periodType41);
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + true + "'", boolean52 == true);
        org.junit.Assert.assertNotNull(mutableDateTime53);
        org.junit.Assert.assertNotNull(months57);
        org.junit.Assert.assertNotNull(duration58);
        org.junit.Assert.assertNotNull(periodType61);
        org.junit.Assert.assertNotNull(period64);
        org.junit.Assert.assertNotNull(months68);
        org.junit.Assert.assertNotNull(duration69);
        org.junit.Assert.assertNotNull(periodType72);
        org.junit.Assert.assertTrue("'" + boolean74 + "' != '" + false + "'", boolean74 == false);
        org.junit.Assert.assertNotNull(dateMidnight79);
    }

    @Test
    public void test417() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test417");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter0 = org.joda.time.format.ISODateTimeFormat.year();
        Chronology chronology1 = dateTimeFormatter0.getChronolgy();
        org.junit.Assert.assertNotNull(dateTimeFormatter0);
        org.junit.Assert.assertNull(chronology1);
    }

    @Test
    public void test418() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test418");
        org.joda.time.tz.FixedDateTimeZone fixedDateTimeZone4 = new org.joda.time.tz.FixedDateTimeZone("P0M", "hours", 7, 4);
        long long6 = fixedDateTimeZone4.nextTransition((long) '4');
        int int8 = fixedDateTimeZone4.getOffsetFromLocal((long) 7);
        org.junit.Assert.assertTrue("'" + long6 + "' != '" + 52L + "'", long6 == 52L);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 7 + "'", int8 == 7);
    }

    @Test
    public void test419() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test419");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        org.joda.time.chrono.CopticChronology copticChronology2 = org.joda.time.chrono.CopticChronology.getInstance(dateTimeZone1);
        LocalDateTime localDateTime3 = LocalDateTime.now(dateTimeZone1);
        LocalDateTime.Property property4 = localDateTime3.dayOfMonth();
        LocalDateTime localDateTime6 = localDateTime3.withWeekyear(36000000);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(copticChronology2);
        org.junit.Assert.assertNotNull(localDateTime3);
        org.junit.Assert.assertNotNull(property4);
        org.junit.Assert.assertNotNull(localDateTime6);
    }

    @Test
    public void test420() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test420");
        org.joda.time.chrono.CopticChronology copticChronology1 = org.joda.time.chrono.CopticChronology.getInstanceUTC();
        LocalDateTime localDateTime2 = new LocalDateTime((-35999994L), (Chronology) copticChronology1);
        LocalDateTime localDateTime4 = localDateTime2.plusDays((int) (byte) -1);
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        Chronology chronology7 = null;
        DateMidnight dateMidnight8 = dateMidnight6.withChronology(chronology7);
        DateMidnight dateMidnight10 = dateMidnight6.withCenturyOfEra((int) ' ');
        DateMidnight.Property property11 = dateMidnight6.dayOfMonth();
        DateMidnight dateMidnight13 = new DateMidnight(0L);
        Chronology chronology14 = null;
        DateMidnight dateMidnight15 = dateMidnight13.withChronology(chronology14);
        DateMidnight dateMidnight17 = dateMidnight13.withCenturyOfEra((int) ' ');
        DateMidnight.Property property18 = dateMidnight13.dayOfMonth();
        int int19 = dateMidnight13.getMinuteOfHour();
        Duration duration20 = new Duration((ReadableInstant) dateMidnight6, (ReadableInstant) dateMidnight13);
        LocalDateTime localDateTime22 = localDateTime4.withDurationAdded((ReadableDuration) duration20, 12);
        DateTime dateTime23 = localDateTime4.toDateTime();
        Months months24 = Months.EIGHT;
        LocalDateTime localDateTime25 = localDateTime4.minus((ReadablePeriod) months24);
        org.junit.Assert.assertNotNull(copticChronology1);
        org.junit.Assert.assertNotNull(localDateTime4);
        org.junit.Assert.assertNotNull(dateMidnight8);
        org.junit.Assert.assertNotNull(dateMidnight10);
        org.junit.Assert.assertNotNull(property11);
        org.junit.Assert.assertNotNull(dateMidnight15);
        org.junit.Assert.assertNotNull(dateMidnight17);
        org.junit.Assert.assertNotNull(property18);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 0 + "'", int19 == 0);
        org.junit.Assert.assertNotNull(localDateTime22);
        org.junit.Assert.assertNotNull(dateTime23);
        org.junit.Assert.assertNotNull(months24);
        org.junit.Assert.assertNotNull(localDateTime25);
    }

    @Test
    public void test421() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test421");
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder0 = new org.joda.time.format.DateTimeFormatterBuilder();
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder2 = dateTimeFormatterBuilder0.appendWeekOfWeekyear(3);
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder4 = dateTimeFormatterBuilder2.appendMinuteOfHour((int) (byte) 100);
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder7 = dateTimeFormatterBuilder4.appendTwoDigitYear((int) '4', true);
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder10 = dateTimeFormatterBuilder7.appendTwoDigitYear(143, true);
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder12 = dateTimeFormatterBuilder10.appendMonthOfYear(5);
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder2);
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder4);
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder7);
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder10);
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder12);
    }

    @Test
    public void test422() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test422");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        DateMidnight dateMidnight3 = new DateMidnight(0L);
        boolean boolean4 = dateMidnight1.isEqual((ReadableInstant) dateMidnight3);
        Object obj5 = null;
        Chronology chronology6 = null;
        Interval interval7 = new Interval(obj5, chronology6);
        Months months8 = Months.monthsIn((ReadableInterval) interval7);
        Duration duration9 = interval7.toDuration();
        DateMidnight dateMidnight11 = new DateMidnight(0L);
        PeriodType periodType12 = PeriodType.days();
        MutablePeriod mutablePeriod13 = new MutablePeriod((ReadableDuration) duration9, (ReadableInstant) dateMidnight11, periodType12);
        Chronology chronology14 = null;
        Period period15 = duration9.toPeriod(chronology14);
        PeriodType periodType16 = PeriodType.yearMonthDayTime();
        MutablePeriod mutablePeriod17 = new MutablePeriod((ReadableInstant) dateMidnight3, (ReadableDuration) duration9, periodType16);
        mutablePeriod17.setSeconds(0);
        mutablePeriod17.setDays((-1));
        mutablePeriod17.setSeconds(0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(months8);
        org.junit.Assert.assertNotNull(duration9);
        org.junit.Assert.assertNotNull(periodType12);
        org.junit.Assert.assertNotNull(period15);
        org.junit.Assert.assertNotNull(periodType16);
    }

    @Test
    public void test423() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test423");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        Weeks weeks3 = Weeks.ONE;
        int[] intArray6 = ethiopicChronology1.get((ReadablePeriod) weeks3, (long) (short) 1, 100L);
        DateTimeField dateTimeField7 = ethiopicChronology1.millisOfDay();
        TimeOfDay timeOfDay8 = new TimeOfDay((long) (short) 10, (Chronology) ethiopicChronology1);
        LocalTime localTime9 = timeOfDay8.toLocalTime();
        int int10 = localTime9.getMillisOfSecond();
        LocalTime.Property property11 = localTime9.millisOfDay();
        LocalTime localTime13 = property11.setCopy(23);
        LocalTime localTime14 = property11.roundCeilingCopy();
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(weeks3);
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertArrayEquals(intArray6, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField7);
        org.junit.Assert.assertNotNull(localTime9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 10 + "'", int10 == 10);
        org.junit.Assert.assertNotNull(property11);
        org.junit.Assert.assertNotNull(localTime13);
        org.junit.Assert.assertNotNull(localTime14);
    }

    @Test
    public void test424() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test424");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DateTimeField dateTimeField2 = ethiopicChronology0.minuteOfHour();
        MonthDay monthDay3 = new MonthDay((Chronology) ethiopicChronology0);
        DurationField durationField4 = ethiopicChronology0.weeks();
        DateTimeField dateTimeField5 = ethiopicChronology0.year();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(dateTimeField2);
        org.junit.Assert.assertNotNull(durationField4);
        org.junit.Assert.assertNotNull(dateTimeField5);
    }

    @Test
    public void test425() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test425");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DateTimeField dateTimeField2 = ethiopicChronology0.minuteOfHour();
        org.joda.time.chrono.CopticChronology copticChronology4 = org.joda.time.chrono.CopticChronology.getInstanceUTC();
        LocalDateTime localDateTime5 = new LocalDateTime((-35999994L), (Chronology) copticChronology4);
        LocalDateTime localDateTime7 = localDateTime5.plusDays((int) (byte) -1);
        DateMidnight dateMidnight9 = new DateMidnight(0L);
        Chronology chronology10 = null;
        DateMidnight dateMidnight11 = dateMidnight9.withChronology(chronology10);
        DateMidnight dateMidnight13 = dateMidnight9.withCenturyOfEra((int) ' ');
        DateMidnight.Property property14 = dateMidnight9.dayOfMonth();
        DateMidnight dateMidnight16 = new DateMidnight(0L);
        Chronology chronology17 = null;
        DateMidnight dateMidnight18 = dateMidnight16.withChronology(chronology17);
        DateMidnight dateMidnight20 = dateMidnight16.withCenturyOfEra((int) ' ');
        DateMidnight.Property property21 = dateMidnight16.dayOfMonth();
        int int22 = dateMidnight16.getMinuteOfHour();
        Duration duration23 = new Duration((ReadableInstant) dateMidnight9, (ReadableInstant) dateMidnight16);
        LocalDateTime localDateTime25 = localDateTime7.withDurationAdded((ReadableDuration) duration23, 12);
        DateTime dateTime26 = localDateTime7.toDateTime();
        int int27 = dateTimeField2.getMinimumValue((ReadablePartial) localDateTime7);
        LocalDateTime.Property property28 = localDateTime7.monthOfYear();
        // The following exception was thrown during execution in test generation
        try {
            LocalDateTime localDateTime30 = property28.setCopy(0);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 0 for monthOfYear must be in the range [1,13]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(dateTimeField2);
        org.junit.Assert.assertNotNull(copticChronology4);
        org.junit.Assert.assertNotNull(localDateTime7);
        org.junit.Assert.assertNotNull(dateMidnight11);
        org.junit.Assert.assertNotNull(dateMidnight13);
        org.junit.Assert.assertNotNull(property14);
        org.junit.Assert.assertNotNull(dateMidnight18);
        org.junit.Assert.assertNotNull(dateMidnight20);
        org.junit.Assert.assertNotNull(property21);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 0 + "'", int22 == 0);
        org.junit.Assert.assertNotNull(localDateTime25);
        org.junit.Assert.assertNotNull(dateTime26);
        org.junit.Assert.assertTrue("'" + int27 + "' != '" + 0 + "'", int27 == 0);
        org.junit.Assert.assertNotNull(property28);
    }

    @Test
    public void test426() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test426");
        org.joda.time.tz.NameProvider nameProvider0 = DateTimeZone.getNameProvider();
        org.junit.Assert.assertNotNull(nameProvider0);
    }

    @Test
    public void test427() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test427");
        MutableDateTime mutableDateTime0 = MutableDateTime.now();
        Object obj1 = null;
        Chronology chronology2 = null;
        Interval interval3 = new Interval(obj1, chronology2);
        Months months4 = Months.monthsIn((ReadableInterval) interval3);
        Duration duration5 = interval3.toDuration();
        DateMidnight dateMidnight7 = new DateMidnight(0L);
        PeriodType periodType8 = PeriodType.days();
        MutablePeriod mutablePeriod9 = new MutablePeriod((ReadableDuration) duration5, (ReadableInstant) dateMidnight7, periodType8);
        Chronology chronology10 = null;
        Period period11 = duration5.toPeriod(chronology10);
        Object obj12 = null;
        Chronology chronology13 = null;
        Interval interval14 = new Interval(obj12, chronology13);
        Months months15 = Months.monthsIn((ReadableInterval) interval14);
        Duration duration16 = interval14.toDuration();
        DateMidnight dateMidnight18 = new DateMidnight(0L);
        PeriodType periodType19 = PeriodType.days();
        MutablePeriod mutablePeriod20 = new MutablePeriod((ReadableDuration) duration16, (ReadableInstant) dateMidnight18, periodType19);
        boolean boolean21 = duration5.isShorterThan((ReadableDuration) duration16);
        mutableDateTime0.add((ReadableDuration) duration16, 10);
        boolean boolean25 = mutableDateTime0.equals((Object) (-1.0f));
        int int26 = mutableDateTime0.getRoundingMode();
        mutableDateTime0.addMillis((int) (short) 1);
        org.junit.Assert.assertNotNull(mutableDateTime0);
        org.junit.Assert.assertNotNull(months4);
        org.junit.Assert.assertNotNull(duration5);
        org.junit.Assert.assertNotNull(periodType8);
        org.junit.Assert.assertNotNull(period11);
        org.junit.Assert.assertNotNull(months15);
        org.junit.Assert.assertNotNull(duration16);
        org.junit.Assert.assertNotNull(periodType19);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 0 + "'", int26 == 0);
    }

    @Test
    public void test428() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test428");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        DurationField durationField6 = ethiopicChronology4.hours();
        int int8 = durationField6.getValue(0L);
        DateTimeFieldType dateTimeFieldType9 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField11 = new org.joda.time.field.DividedDateTimeField(dateTimeField3, durationField6, dateTimeFieldType9, (int) '4');
        int int13 = dividedDateTimeField11.getMinimumValue((long) 10080);
        // The following exception was thrown during execution in test generation
        try {
            long long15 = dividedDateTimeField11.roundCeiling(0L);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 0 for clockhourOfDay must be in the range [1,24]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType9);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
    }

    @Test
    public void test429() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test429");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Weeks weeks2 = Weeks.ONE;
        int[] intArray5 = ethiopicChronology0.get((ReadablePeriod) weeks2, (long) (short) 1, 100L);
        DateTimeField dateTimeField6 = ethiopicChronology0.millisOfDay();
        TimeOfDay timeOfDay7 = new TimeOfDay();
        long long9 = ethiopicChronology0.set((ReadablePartial) timeOfDay7, 0L);
        TimeOfDay timeOfDay11 = timeOfDay7.withMinuteOfHour(12);
        TimeOfDay timeOfDay13 = timeOfDay11.withMillisOfSecond((int) '#');
        int int14 = timeOfDay11.getHourOfDay();
        TimeOfDay timeOfDay16 = timeOfDay11.minusHours(143);
        TimeOfDay timeOfDay18 = timeOfDay16.minusMinutes((int) '#');
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks2);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField6);
// flaky "14) test429(RegressionTest0)":         org.junit.Assert.assertTrue("'" + long9 + "' != '" + 31186566L + "'", long9 == 31186566L);
        org.junit.Assert.assertNotNull(timeOfDay11);
        org.junit.Assert.assertNotNull(timeOfDay13);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 18 + "'", int14 == 18);
        org.junit.Assert.assertNotNull(timeOfDay16);
        org.junit.Assert.assertNotNull(timeOfDay18);
    }

    @Test
    public void test430() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test430");
        PeriodType periodType0 = PeriodType.months();
        org.junit.Assert.assertNotNull(periodType0);
    }

    @Test
    public void test431() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test431");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        Weeks weeks6 = Weeks.ONE;
        int[] intArray9 = ethiopicChronology4.get((ReadablePeriod) weeks6, (long) (short) 1, 100L);
        Period period10 = new Period((long) (short) 0, (long) 'a', (Chronology) ethiopicChronology4);
        Period period12 = period10.withDays((int) 'a');
        PeriodType periodType13 = period10.getPeriodType();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology14 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone15 = ethiopicChronology14.getZone();
        Object obj16 = null;
        Chronology chronology17 = null;
        Interval interval18 = new Interval(obj16, chronology17);
        Weeks weeks19 = Weeks.ONE;
        Interval interval20 = interval18.withPeriodAfterStart((ReadablePeriod) weeks19);
        int[] intArray23 = ethiopicChronology14.get((ReadablePeriod) weeks19, (long) (short) -1, (long) (short) -1);
        DurationField durationField24 = ethiopicChronology14.minutes();
        Period period25 = new Period((long) 143, 24L, periodType13, (Chronology) ethiopicChronology14);
        int int26 = period25.getHours();
        Period period28 = period25.minusMonths((int) (byte) 0);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(weeks6);
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertArrayEquals(intArray9, new int[] { 0 });
        org.junit.Assert.assertNotNull(period12);
        org.junit.Assert.assertNotNull(periodType13);
        org.junit.Assert.assertNotNull(ethiopicChronology14);
        org.junit.Assert.assertNotNull(dateTimeZone15);
        org.junit.Assert.assertNotNull(weeks19);
        org.junit.Assert.assertNotNull(interval20);
        org.junit.Assert.assertNotNull(intArray23);
        org.junit.Assert.assertArrayEquals(intArray23, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField24);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 0 + "'", int26 == 0);
        org.junit.Assert.assertNotNull(period28);
    }

    @Test
    public void test432() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test432");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DateTimeField dateTimeField2 = ethiopicChronology0.minuteOfHour();
        MonthDay monthDay3 = new MonthDay((Chronology) ethiopicChronology0);
        MonthDay.Property property4 = monthDay3.dayOfMonth();
        DateTimeField dateTimeField5 = property4.getField();
        // The following exception was thrown during execution in test generation
        try {
            MonthDay monthDay7 = property4.setCopy((int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 0 for dayOfMonth must be in the range [1,30]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(dateTimeField2);
        org.junit.Assert.assertNotNull(property4);
        org.junit.Assert.assertNotNull(dateTimeField5);
    }

    @Test
    public void test433() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test433");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        DurationField durationField6 = ethiopicChronology4.hours();
        int int8 = durationField6.getValue(0L);
        DateTimeFieldType dateTimeFieldType9 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField11 = new org.joda.time.field.DividedDateTimeField(dateTimeField3, durationField6, dateTimeFieldType9, (int) '4');
        DateTimeFieldType dateTimeFieldType12 = DateTimeFieldType.clockhourOfHalfday();
        org.joda.time.field.OffsetDateTimeField offsetDateTimeField16 = new org.joda.time.field.OffsetDateTimeField((DateTimeField) dividedDateTimeField11, dateTimeFieldType12, 7, 1, 12);
        long long19 = offsetDateTimeField16.add((long) (byte) 0, (long) 143);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType9);
        org.junit.Assert.assertNotNull(dateTimeFieldType12);
        org.junit.Assert.assertTrue("'" + long19 + "' != '" + 26769600000L + "'", long19 == 26769600000L);
    }

    @Test
    public void test434() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test434");
        MutableInterval mutableInterval2 = new MutableInterval((long) (byte) -1, (long) 1);
        MutableInterval mutableInterval3 = mutableInterval2.copy();
        mutableInterval3.setDurationAfterStart((long) (byte) 0);
        DateTime dateTime6 = mutableInterval3.getStart();
        Chronology chronology7 = mutableInterval3.getChronology();
        org.junit.Assert.assertNotNull(mutableInterval3);
        org.junit.Assert.assertNotNull(dateTime6);
        org.junit.Assert.assertNotNull(chronology7);
    }

    @Test
    public void test435() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test435");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology2 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone3 = ethiopicChronology2.getZone();
        Weeks weeks4 = Weeks.ONE;
        int[] intArray7 = ethiopicChronology2.get((ReadablePeriod) weeks4, (long) (short) 1, 100L);
        Period period8 = new Period((long) (short) 0, (long) 'a', (Chronology) ethiopicChronology2);
        Period period10 = period8.minusHours((int) (short) -1);
        Period period12 = period8.plusMillis(0);
        org.junit.Assert.assertNotNull(ethiopicChronology2);
        org.junit.Assert.assertNotNull(dateTimeZone3);
        org.junit.Assert.assertNotNull(weeks4);
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertArrayEquals(intArray7, new int[] { 0 });
        org.junit.Assert.assertNotNull(period10);
        org.junit.Assert.assertNotNull(period12);
    }

    @Test
    public void test436() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test436");
        YearMonth yearMonth0 = YearMonth.now();
        org.junit.Assert.assertNotNull(yearMonth0);
    }

    @Test
    public void test437() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test437");
        DateTimeZone dateTimeZone1 = null;
        MutableDateTime mutableDateTime2 = new MutableDateTime((long) 10080, dateTimeZone1);
        mutableDateTime2.setDayOfYear(6);
        MutableInterval mutableInterval7 = new MutableInterval((long) (byte) -1, (long) 1);
        MutableInterval mutableInterval8 = mutableInterval7.copy();
        mutableInterval8.setDurationAfterStart((long) (byte) 0);
        Object obj11 = null;
        Chronology chronology12 = null;
        Interval interval13 = new Interval(obj11, chronology12);
        Months months14 = Months.monthsIn((ReadableInterval) interval13);
        Duration duration15 = interval13.toDuration();
        DateMidnight dateMidnight17 = new DateMidnight(0L);
        PeriodType periodType18 = PeriodType.days();
        MutablePeriod mutablePeriod19 = new MutablePeriod((ReadableDuration) duration15, (ReadableInstant) dateMidnight17, periodType18);
        int int20 = mutablePeriod19.getYears();
        Object obj21 = null;
        Chronology chronology22 = null;
        Interval interval23 = new Interval(obj21, chronology22);
        Months months24 = Months.monthsIn((ReadableInterval) interval23);
        Duration duration25 = interval23.toDuration();
        DateMidnight dateMidnight27 = new DateMidnight(0L);
        PeriodType periodType28 = PeriodType.days();
        MutablePeriod mutablePeriod29 = new MutablePeriod((ReadableDuration) duration25, (ReadableInstant) dateMidnight27, periodType28);
        Object obj30 = null;
        Chronology chronology31 = null;
        Interval interval32 = new Interval(obj30, chronology31);
        Months months33 = Months.monthsIn((ReadableInterval) interval32);
        Duration duration34 = interval32.toDuration();
        Object obj35 = null;
        Chronology chronology36 = null;
        Interval interval37 = new Interval(obj35, chronology36);
        Months months38 = Months.monthsIn((ReadableInterval) interval37);
        Duration duration39 = interval37.toDuration();
        boolean boolean40 = duration34.isEqual((ReadableDuration) duration39);
        boolean boolean41 = duration25.isEqual((ReadableDuration) duration39);
        mutablePeriod19.setPeriod((ReadableDuration) duration39);
        mutableInterval8.setDurationAfterStart((ReadableDuration) duration39);
        mutableDateTime2.add((ReadableDuration) duration39, 9);
        mutableDateTime2.addMonths((int) (byte) 0);
        org.junit.Assert.assertNotNull(mutableInterval8);
        org.junit.Assert.assertNotNull(months14);
        org.junit.Assert.assertNotNull(duration15);
        org.junit.Assert.assertNotNull(periodType18);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertNotNull(months24);
        org.junit.Assert.assertNotNull(duration25);
        org.junit.Assert.assertNotNull(periodType28);
        org.junit.Assert.assertNotNull(months33);
        org.junit.Assert.assertNotNull(duration34);
        org.junit.Assert.assertNotNull(months38);
        org.junit.Assert.assertNotNull(duration39);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + true + "'", boolean40 == true);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + true + "'", boolean41 == true);
    }

    @Test
    public void test438() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test438");
        org.joda.time.chrono.CopticChronology copticChronology1 = org.joda.time.chrono.CopticChronology.getInstanceUTC();
        LocalDateTime localDateTime2 = new LocalDateTime((-35999994L), (Chronology) copticChronology1);
        int int3 = localDateTime2.getMonthOfYear();
        LocalDateTime.Property property4 = localDateTime2.yearOfEra();
        int int5 = localDateTime2.getWeekyear();
        org.junit.Assert.assertNotNull(copticChronology1);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 4 + "'", int3 == 4);
        org.junit.Assert.assertNotNull(property4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1686 + "'", int5 == 1686);
    }

    @Test
    public void test439() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test439");
        DateTimeFieldType dateTimeFieldType0 = DateTimeFieldType.dayOfYear();
        String str1 = dateTimeFieldType0.getName();
        IllegalFieldValueException illegalFieldValueException6 = new IllegalFieldValueException(dateTimeFieldType0, (Number) 6, (Number) 0.0f, (Number) 100.0f, "");
        Throwable[] throwableArray7 = illegalFieldValueException6.getSuppressed();
        Number number8 = illegalFieldValueException6.getUpperBound();
        Number number9 = illegalFieldValueException6.getUpperBound();
        org.junit.Assert.assertNotNull(dateTimeFieldType0);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "dayOfYear" + "'", str1, "dayOfYear");
        org.junit.Assert.assertNotNull(throwableArray7);
        org.junit.Assert.assertArrayEquals(throwableArray7, new Throwable[] {});
        org.junit.Assert.assertEquals("'" + number8 + "' != '" + 100.0f + "'", number8, 100.0f);
        org.junit.Assert.assertEquals("'" + number9 + "' != '" + 100.0f + "'", number9, 100.0f);
    }

    @Test
    public void test440() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test440");
        int int0 = DateTimeConstants.AUGUST;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 8 + "'", int0 == 8);
    }

    @Test
    public void test441() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test441");
        DateTimeZone dateTimeZone1 = null;
        MutableDateTime mutableDateTime2 = new MutableDateTime((long) 10080, dateTimeZone1);
        DateMidnight dateMidnight4 = new DateMidnight(0L);
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        boolean boolean7 = dateMidnight4.isEqual((ReadableInstant) dateMidnight6);
        int int8 = dateMidnight4.getSecondOfDay();
        DateMidnight dateMidnight10 = dateMidnight4.plus((long) 36000000);
        mutableDateTime2.setMillis((ReadableInstant) dateMidnight10);
        DateMidnight.Property property12 = dateMidnight10.weekyear();
        // The following exception was thrown during execution in test generation
        try {
            DateMidnight dateMidnight14 = property12.setCopy("dayOfYear");
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value \"dayOfYear\" for weekyear is not supported");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateMidnight10);
        org.junit.Assert.assertNotNull(property12);
    }

    @Test
    public void test442() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test442");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField4 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField3);
        int int6 = delegatedDateTimeField4.get((long) (byte) 10);
        LocalDate localDate7 = new LocalDate();
        LocalDate localDate9 = localDate7.minusWeeks(3);
        LocalDate.Property property10 = localDate9.monthOfYear();
        java.util.Locale locale12 = null;
        String str13 = delegatedDateTimeField4.getAsText((ReadablePartial) localDate9, (int) (byte) 10, locale12);
        LocalDate.Property property14 = localDate9.dayOfMonth();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
        org.junit.Assert.assertNotNull(localDate9);
        org.junit.Assert.assertNotNull(property10);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "10" + "'", str13, "10");
        org.junit.Assert.assertNotNull(property14);
    }

    @Test
    public void test443() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test443");
        Period period1 = Period.months(12);
        Period period3 = period1.withMinutes(1920);
        org.junit.Assert.assertNotNull(period1);
        org.junit.Assert.assertNotNull(period3);
    }

    @Test
    public void test444() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test444");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Object obj2 = null;
        Chronology chronology3 = null;
        Interval interval4 = new Interval(obj2, chronology3);
        Weeks weeks5 = Weeks.ONE;
        Interval interval6 = interval4.withPeriodAfterStart((ReadablePeriod) weeks5);
        int[] intArray9 = ethiopicChronology0.get((ReadablePeriod) weeks5, (long) (short) -1, (long) (short) -1);
        DurationField durationField10 = ethiopicChronology0.minutes();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology11 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone12 = ethiopicChronology11.getZone();
        DurationField durationField13 = ethiopicChronology11.hours();
        DateTimeField dateTimeField14 = ethiopicChronology11.clockhourOfDay();
        org.joda.time.field.DelegatedDateTimeField delegatedDateTimeField15 = new org.joda.time.field.DelegatedDateTimeField(dateTimeField14);
        int int17 = delegatedDateTimeField15.get((long) (byte) 10);
        LocalDate localDate18 = new LocalDate();
        LocalDate localDate20 = localDate18.minusWeeks(3);
        LocalDate.Property property21 = localDate20.monthOfYear();
        java.util.Locale locale23 = null;
        String str24 = delegatedDateTimeField15.getAsText((ReadablePartial) localDate20, (int) (byte) 10, locale23);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology25 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone26 = ethiopicChronology25.getZone();
        long long30 = dateTimeZone26.convertLocalToUTC((long) 6, false, 0L);
        YearMonthDay yearMonthDay31 = new YearMonthDay(dateTimeZone26);
        DateTime dateTime32 = localDate20.toDateTimeAtStartOfDay(dateTimeZone26);
        LocalDate localDate34 = localDate20.withWeekyear(1);
        int[] intArray36 = ethiopicChronology0.get((ReadablePartial) localDate20, (long) 24);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology37 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone38 = ethiopicChronology37.getZone();
        long long42 = dateTimeZone38.convertLocalToUTC((long) 6, false, 0L);
        LocalDate localDate43 = new LocalDate(dateTimeZone38);
        Chronology chronology44 = ethiopicChronology0.withZone(dateTimeZone38);
        org.joda.time.chrono.GJChronology gJChronology47 = org.joda.time.chrono.GJChronology.getInstance(dateTimeZone38, 456878073600000L, 5);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks5);
        org.junit.Assert.assertNotNull(interval6);
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertArrayEquals(intArray9, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField10);
        org.junit.Assert.assertNotNull(ethiopicChronology11);
        org.junit.Assert.assertNotNull(dateTimeZone12);
        org.junit.Assert.assertNotNull(durationField13);
        org.junit.Assert.assertNotNull(dateTimeField14);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 10 + "'", int17 == 10);
        org.junit.Assert.assertNotNull(localDate20);
        org.junit.Assert.assertNotNull(property21);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "10" + "'", str24, "10");
        org.junit.Assert.assertNotNull(ethiopicChronology25);
        org.junit.Assert.assertNotNull(dateTimeZone26);
        org.junit.Assert.assertTrue("'" + long30 + "' != '" + (-35999994L) + "'", long30 == (-35999994L));
        org.junit.Assert.assertNotNull(dateTime32);
        org.junit.Assert.assertNotNull(localDate34);
        org.junit.Assert.assertNotNull(intArray36);
        org.junit.Assert.assertArrayEquals(intArray36, new int[] { 1962, 4, 23 });
        org.junit.Assert.assertNotNull(ethiopicChronology37);
        org.junit.Assert.assertNotNull(dateTimeZone38);
        org.junit.Assert.assertTrue("'" + long42 + "' != '" + (-35999994L) + "'", long42 == (-35999994L));
        org.junit.Assert.assertNotNull(chronology44);
        org.junit.Assert.assertNotNull(gJChronology47);
    }

    @Test
    public void test445() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test445");
        DateTimeZone dateTimeZone1 = null;
        MutableDateTime mutableDateTime2 = new MutableDateTime((long) 10080, dateTimeZone1);
        DateMidnight dateMidnight4 = new DateMidnight(0L);
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        boolean boolean7 = dateMidnight4.isEqual((ReadableInstant) dateMidnight6);
        int int8 = dateMidnight4.getSecondOfDay();
        DateMidnight dateMidnight10 = dateMidnight4.plus((long) 36000000);
        mutableDateTime2.setMillis((ReadableInstant) dateMidnight10);
        DateMidnight.Property property12 = dateMidnight10.weekyear();
        DateMidnight dateMidnight14 = property12.addWrapFieldToCopy((int) (short) 10);
        DateMidnight dateMidnight16 = new DateMidnight(0L);
        DateMidnight dateMidnight18 = new DateMidnight(0L);
        boolean boolean19 = dateMidnight16.isEqual((ReadableInstant) dateMidnight18);
        Object obj20 = null;
        Chronology chronology21 = null;
        Interval interval22 = new Interval(obj20, chronology21);
        Months months23 = Months.monthsIn((ReadableInterval) interval22);
        Duration duration24 = interval22.toDuration();
        DateMidnight dateMidnight26 = new DateMidnight(0L);
        PeriodType periodType27 = PeriodType.days();
        MutablePeriod mutablePeriod28 = new MutablePeriod((ReadableDuration) duration24, (ReadableInstant) dateMidnight26, periodType27);
        Chronology chronology29 = null;
        Period period30 = duration24.toPeriod(chronology29);
        PeriodType periodType31 = PeriodType.yearMonthDayTime();
        MutablePeriod mutablePeriod32 = new MutablePeriod((ReadableInstant) dateMidnight18, (ReadableDuration) duration24, periodType31);
        Object obj33 = null;
        Chronology chronology34 = null;
        Interval interval35 = new Interval(obj33, chronology34);
        Object obj36 = null;
        Chronology chronology37 = null;
        Interval interval38 = new Interval(obj36, chronology37);
        Months months39 = Months.monthsIn((ReadableInterval) interval38);
        Duration duration40 = interval38.toDuration();
        DateMidnight dateMidnight42 = new DateMidnight(0L);
        PeriodType periodType43 = PeriodType.days();
        MutablePeriod mutablePeriod44 = new MutablePeriod((ReadableDuration) duration40, (ReadableInstant) dateMidnight42, periodType43);
        Interval interval45 = interval35.withStart((ReadableInstant) dateMidnight42);
        Object obj46 = null;
        Chronology chronology47 = null;
        Interval interval48 = new Interval(obj46, chronology47);
        Months months49 = Months.monthsIn((ReadableInterval) interval48);
        Duration duration50 = interval48.toDuration();
        Interval interval51 = interval45.withDurationBeforeEnd((ReadableDuration) duration50);
        boolean boolean52 = duration24.isShorterThan((ReadableDuration) duration50);
        DateMidnight dateMidnight54 = dateMidnight14.withDurationAdded((ReadableDuration) duration24, 1920);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateMidnight10);
        org.junit.Assert.assertNotNull(property12);
        org.junit.Assert.assertNotNull(dateMidnight14);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertNotNull(months23);
        org.junit.Assert.assertNotNull(duration24);
        org.junit.Assert.assertNotNull(periodType27);
        org.junit.Assert.assertNotNull(period30);
        org.junit.Assert.assertNotNull(periodType31);
        org.junit.Assert.assertNotNull(months39);
        org.junit.Assert.assertNotNull(duration40);
        org.junit.Assert.assertNotNull(periodType43);
        org.junit.Assert.assertNotNull(interval45);
        org.junit.Assert.assertNotNull(months49);
        org.junit.Assert.assertNotNull(duration50);
        org.junit.Assert.assertNotNull(interval51);
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + false + "'", boolean52 == false);
        org.junit.Assert.assertNotNull(dateMidnight54);
    }

    @Test
    public void test446() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test446");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DateTimeField dateTimeField2 = ethiopicChronology0.minuteOfHour();
        MonthDay monthDay3 = new MonthDay((Chronology) ethiopicChronology0);
        MonthDay.Property property4 = monthDay3.dayOfMonth();
        MonthDay.Property property5 = monthDay3.monthOfYear();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(dateTimeField2);
        org.junit.Assert.assertNotNull(property4);
        org.junit.Assert.assertNotNull(property5);
    }

    @Test
    public void test447() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test447");
        LocalDate localDate0 = new LocalDate();
        LocalDate localDate2 = localDate0.minusWeeks(3);
        LocalDate.Property property3 = localDate2.monthOfYear();
        java.util.Date date4 = localDate2.toDate();
        org.junit.Assert.assertNotNull(localDate2);
        org.junit.Assert.assertNotNull(property3);
        org.junit.Assert.assertNotNull(date4);
        org.junit.Assert.assertEquals(date4.toString(), "Fri May 02 00:00:00 AEST 2025");
    }

    @Test
    public void test448() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test448");
        MutableDateTime mutableDateTime0 = MutableDateTime.now();
        Object obj1 = null;
        Chronology chronology2 = null;
        Interval interval3 = new Interval(obj1, chronology2);
        Months months4 = Months.monthsIn((ReadableInterval) interval3);
        Duration duration5 = interval3.toDuration();
        DateMidnight dateMidnight7 = new DateMidnight(0L);
        PeriodType periodType8 = PeriodType.days();
        MutablePeriod mutablePeriod9 = new MutablePeriod((ReadableDuration) duration5, (ReadableInstant) dateMidnight7, periodType8);
        Chronology chronology10 = null;
        Period period11 = duration5.toPeriod(chronology10);
        Object obj12 = null;
        Chronology chronology13 = null;
        Interval interval14 = new Interval(obj12, chronology13);
        Months months15 = Months.monthsIn((ReadableInterval) interval14);
        Duration duration16 = interval14.toDuration();
        DateMidnight dateMidnight18 = new DateMidnight(0L);
        PeriodType periodType19 = PeriodType.days();
        MutablePeriod mutablePeriod20 = new MutablePeriod((ReadableDuration) duration16, (ReadableInstant) dateMidnight18, periodType19);
        boolean boolean21 = duration5.isShorterThan((ReadableDuration) duration16);
        mutableDateTime0.add((ReadableDuration) duration16, 10);
        mutableDateTime0.setWeekOfWeekyear((int) (byte) 1);
        mutableDateTime0.addHours((int) (short) 1);
        mutableDateTime0.setMillis((long) 7);
        // The following exception was thrown during execution in test generation
        try {
            mutableDateTime0.setTime(10, 8, (-1), 6);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value -1 for secondOfMinute must be in the range [0,59]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(mutableDateTime0);
        org.junit.Assert.assertNotNull(months4);
        org.junit.Assert.assertNotNull(duration5);
        org.junit.Assert.assertNotNull(periodType8);
        org.junit.Assert.assertNotNull(period11);
        org.junit.Assert.assertNotNull(months15);
        org.junit.Assert.assertNotNull(duration16);
        org.junit.Assert.assertNotNull(periodType19);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
    }

    @Test
    public void test449() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test449");
        Minutes minutes0 = Minutes.MIN_VALUE;
        DurationFieldType durationFieldType1 = minutes0.getFieldType();
        String str2 = minutes0.toString();
        org.junit.Assert.assertNotNull(minutes0);
        org.junit.Assert.assertNotNull(durationFieldType1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "PT-2147483648M" + "'", str2, "PT-2147483648M");
    }

    @Test
    public void test450() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test450");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Weeks weeks2 = Weeks.ONE;
        int[] intArray5 = ethiopicChronology0.get((ReadablePeriod) weeks2, (long) (short) 1, 100L);
        DurationField durationField6 = ethiopicChronology0.eras();
        String str7 = durationField6.getName();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks2);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "eras" + "'", str7, "eras");
    }

    @Test
    public void test451() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test451");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter0 = org.joda.time.format.ISODateTimeFormat.basicOrdinalDate();
        boolean boolean1 = dateTimeFormatter0.isOffsetParsed();
        org.junit.Assert.assertNotNull(dateTimeFormatter0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test452() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test452");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Weeks weeks2 = Weeks.ONE;
        int[] intArray5 = ethiopicChronology0.get((ReadablePeriod) weeks2, (long) (short) 1, 100L);
        DateTimeField dateTimeField6 = ethiopicChronology0.millisOfDay();
        TimeOfDay timeOfDay7 = new TimeOfDay();
        long long9 = ethiopicChronology0.set((ReadablePartial) timeOfDay7, 0L);
        TimeOfDay timeOfDay11 = timeOfDay7.withMinuteOfHour(12);
        TimeOfDay timeOfDay13 = timeOfDay11.withMillisOfSecond((int) '#');
        int int14 = timeOfDay13.getHourOfDay();
        int int15 = timeOfDay13.size();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks2);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertArrayEquals(intArray5, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField6);
// flaky "15) test452(RegressionTest0)":         org.junit.Assert.assertTrue("'" + long9 + "' != '" + 31187681L + "'", long9 == 31187681L);
        org.junit.Assert.assertNotNull(timeOfDay11);
        org.junit.Assert.assertNotNull(timeOfDay13);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 18 + "'", int14 == 18);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 4 + "'", int15 == 4);
    }

    @Test
    public void test453() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test453");
        Hours hours0 = Hours.SIX;
        MutablePeriod mutablePeriod1 = hours0.toMutablePeriod();
        mutablePeriod1.setPeriod(2, (int) (short) 1, 18, (int) ' ', 1000, (int) (short) 100, 2, (int) (short) 1);
        mutablePeriod1.clear();
        org.junit.Assert.assertNotNull(hours0);
        org.junit.Assert.assertNotNull(mutablePeriod1);
    }

    @Test
    public void test454() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test454");
        org.joda.time.chrono.GJChronology gJChronology1 = org.joda.time.chrono.GJChronology.getInstanceUTC();
        YearMonthDay yearMonthDay2 = new YearMonthDay(31076007L, (Chronology) gJChronology1);
        org.junit.Assert.assertNotNull(gJChronology1);
    }

    @Test
    public void test455() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test455");
        org.joda.time.chrono.CopticChronology copticChronology1 = org.joda.time.chrono.CopticChronology.getInstanceUTC();
        LocalDateTime localDateTime2 = new LocalDateTime((-35999994L), (Chronology) copticChronology1);
        LocalDateTime localDateTime4 = localDateTime2.plusDays((int) (byte) -1);
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        Chronology chronology7 = null;
        DateMidnight dateMidnight8 = dateMidnight6.withChronology(chronology7);
        DateMidnight dateMidnight10 = dateMidnight6.withCenturyOfEra((int) ' ');
        DateMidnight.Property property11 = dateMidnight6.dayOfMonth();
        DateMidnight dateMidnight13 = new DateMidnight(0L);
        Chronology chronology14 = null;
        DateMidnight dateMidnight15 = dateMidnight13.withChronology(chronology14);
        DateMidnight dateMidnight17 = dateMidnight13.withCenturyOfEra((int) ' ');
        DateMidnight.Property property18 = dateMidnight13.dayOfMonth();
        int int19 = dateMidnight13.getMinuteOfHour();
        Duration duration20 = new Duration((ReadableInstant) dateMidnight6, (ReadableInstant) dateMidnight13);
        LocalDateTime localDateTime22 = localDateTime4.withDurationAdded((ReadableDuration) duration20, 12);
        DateTime dateTime23 = localDateTime4.toDateTime();
        Object obj24 = null;
        Chronology chronology25 = null;
        Interval interval26 = new Interval(obj24, chronology25);
        Months months27 = Months.monthsIn((ReadableInterval) interval26);
        Duration duration28 = interval26.toDuration();
        DateMidnight dateMidnight30 = new DateMidnight(0L);
        PeriodType periodType31 = PeriodType.days();
        MutablePeriod mutablePeriod32 = new MutablePeriod((ReadableDuration) duration28, (ReadableInstant) dateMidnight30, periodType31);
        DateMidnight dateMidnight34 = new DateMidnight(0L);
        Chronology chronology35 = null;
        DateMidnight dateMidnight36 = dateMidnight34.withChronology(chronology35);
        DateMidnight dateMidnight38 = dateMidnight34.withCenturyOfEra((int) ' ');
        Object obj39 = null;
        Chronology chronology40 = null;
        Interval interval41 = new Interval(obj39, chronology40);
        Months months42 = Months.monthsIn((ReadableInterval) interval41);
        Duration duration43 = interval41.toDuration();
        DateMidnight dateMidnight45 = new DateMidnight(0L);
        PeriodType periodType46 = PeriodType.days();
        MutablePeriod mutablePeriod47 = new MutablePeriod((ReadableDuration) duration43, (ReadableInstant) dateMidnight45, periodType46);
        Period period48 = duration28.toPeriodFrom((ReadableInstant) dateMidnight34, periodType46);
        long long49 = duration28.getMillis();
        Duration duration51 = duration28.withMillis((long) (byte) 0);
        LocalDateTime localDateTime53 = localDateTime4.withDurationAdded((ReadableDuration) duration28, (int) (short) 100);
        org.junit.Assert.assertNotNull(copticChronology1);
        org.junit.Assert.assertNotNull(localDateTime4);
        org.junit.Assert.assertNotNull(dateMidnight8);
        org.junit.Assert.assertNotNull(dateMidnight10);
        org.junit.Assert.assertNotNull(property11);
        org.junit.Assert.assertNotNull(dateMidnight15);
        org.junit.Assert.assertNotNull(dateMidnight17);
        org.junit.Assert.assertNotNull(property18);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 0 + "'", int19 == 0);
        org.junit.Assert.assertNotNull(localDateTime22);
        org.junit.Assert.assertNotNull(dateTime23);
        org.junit.Assert.assertNotNull(months27);
        org.junit.Assert.assertNotNull(duration28);
        org.junit.Assert.assertNotNull(periodType31);
        org.junit.Assert.assertNotNull(dateMidnight36);
        org.junit.Assert.assertNotNull(dateMidnight38);
        org.junit.Assert.assertNotNull(months42);
        org.junit.Assert.assertNotNull(duration43);
        org.junit.Assert.assertNotNull(periodType46);
        org.junit.Assert.assertNotNull(period48);
        org.junit.Assert.assertTrue("'" + long49 + "' != '" + 0L + "'", long49 == 0L);
        org.junit.Assert.assertNotNull(duration51);
        org.junit.Assert.assertNotNull(localDateTime53);
    }

    @Test
    public void test456() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test456");
        DateTimeZone dateTimeZone1 = null;
        MutableDateTime mutableDateTime2 = new MutableDateTime((long) 10080, dateTimeZone1);
        DateMidnight dateMidnight4 = new DateMidnight(0L);
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        boolean boolean7 = dateMidnight4.isEqual((ReadableInstant) dateMidnight6);
        int int8 = dateMidnight4.getSecondOfDay();
        DateMidnight dateMidnight10 = dateMidnight4.plus((long) 36000000);
        mutableDateTime2.setMillis((ReadableInstant) dateMidnight10);
        DateMidnight.Property property12 = dateMidnight10.weekyear();
        DateMidnight dateMidnight13 = property12.roundCeilingCopy();
        DateMidnight dateMidnight14 = property12.roundHalfCeilingCopy();
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateMidnight10);
        org.junit.Assert.assertNotNull(property12);
        org.junit.Assert.assertNotNull(dateMidnight13);
        org.junit.Assert.assertNotNull(dateMidnight14);
    }

    @Test
    public void test457() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test457");
        PeriodType periodType0 = PeriodType.yearMonthDayTime();
        PeriodType periodType1 = DateTimeUtils.getPeriodType(periodType0);
        org.junit.Assert.assertNotNull(periodType0);
        org.junit.Assert.assertNotNull(periodType1);
    }

    @Test
    public void test458() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test458");
        int int0 = DateTimeConstants.MONDAY;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test459() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test459");
        org.joda.time.chrono.CopticChronology copticChronology1 = org.joda.time.chrono.CopticChronology.getInstanceUTC();
        LocalDateTime localDateTime2 = new LocalDateTime((-35999994L), (Chronology) copticChronology1);
        DateTimeField dateTimeField3 = copticChronology1.yearOfEra();
        org.junit.Assert.assertNotNull(copticChronology1);
        org.junit.Assert.assertNotNull(dateTimeField3);
    }

    @Test
    public void test460() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test460");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        DateMidnight dateMidnight3 = new DateMidnight(0L);
        boolean boolean4 = dateMidnight1.isEqual((ReadableInstant) dateMidnight3);
        int int5 = dateMidnight1.getSecondOfDay();
        long long6 = DateTimeUtils.getInstantMillis((ReadableInstant) dateMidnight1);
        DateMidnight.Property property7 = dateMidnight1.yearOfEra();
        java.util.Locale locale8 = null;
        int int9 = property7.getMaximumTextLength(locale8);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + long6 + "' != '" + (-36000000L) + "'", long6 == (-36000000L));
        org.junit.Assert.assertNotNull(property7);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 9 + "'", int9 == 9);
    }

    @Test
    public void test461() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test461");
        Seconds seconds0 = Seconds.THREE;
        Seconds seconds1 = Seconds.MAX_VALUE;
        boolean boolean2 = seconds0.isLessThan(seconds1);
        DurationFieldType durationFieldType3 = seconds0.getFieldType();
        org.junit.Assert.assertNotNull(seconds0);
        org.junit.Assert.assertNotNull(seconds1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(durationFieldType3);
    }

    @Test
    public void test462() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test462");
        MutableInterval mutableInterval2 = new MutableInterval((long) (byte) -1, (long) 1);
        MutableInterval mutableInterval3 = mutableInterval2.copy();
        mutableInterval3.setDurationAfterStart((long) (byte) 0);
        Object obj6 = null;
        Chronology chronology7 = null;
        Interval interval8 = new Interval(obj6, chronology7);
        Months months9 = Months.monthsIn((ReadableInterval) interval8);
        Duration duration10 = interval8.toDuration();
        DateMidnight dateMidnight12 = new DateMidnight(0L);
        PeriodType periodType13 = PeriodType.days();
        MutablePeriod mutablePeriod14 = new MutablePeriod((ReadableDuration) duration10, (ReadableInstant) dateMidnight12, periodType13);
        int int15 = mutablePeriod14.getYears();
        Object obj16 = null;
        Chronology chronology17 = null;
        Interval interval18 = new Interval(obj16, chronology17);
        Months months19 = Months.monthsIn((ReadableInterval) interval18);
        Duration duration20 = interval18.toDuration();
        DateMidnight dateMidnight22 = new DateMidnight(0L);
        PeriodType periodType23 = PeriodType.days();
        MutablePeriod mutablePeriod24 = new MutablePeriod((ReadableDuration) duration20, (ReadableInstant) dateMidnight22, periodType23);
        Object obj25 = null;
        Chronology chronology26 = null;
        Interval interval27 = new Interval(obj25, chronology26);
        Months months28 = Months.monthsIn((ReadableInterval) interval27);
        Duration duration29 = interval27.toDuration();
        Object obj30 = null;
        Chronology chronology31 = null;
        Interval interval32 = new Interval(obj30, chronology31);
        Months months33 = Months.monthsIn((ReadableInterval) interval32);
        Duration duration34 = interval32.toDuration();
        boolean boolean35 = duration29.isEqual((ReadableDuration) duration34);
        boolean boolean36 = duration20.isEqual((ReadableDuration) duration34);
        mutablePeriod14.setPeriod((ReadableDuration) duration34);
        mutableInterval3.setDurationAfterStart((ReadableDuration) duration34);
        MutableInterval mutableInterval39 = mutableInterval3.copy();
        DateTime dateTime40 = mutableInterval39.getStart();
        // The following exception was thrown during execution in test generation
        try {
            mutableInterval39.setEndMillis((-35999994L));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The end instant must be greater than the start instant");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(mutableInterval3);
        org.junit.Assert.assertNotNull(months9);
        org.junit.Assert.assertNotNull(duration10);
        org.junit.Assert.assertNotNull(periodType13);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNotNull(months19);
        org.junit.Assert.assertNotNull(duration20);
        org.junit.Assert.assertNotNull(periodType23);
        org.junit.Assert.assertNotNull(months28);
        org.junit.Assert.assertNotNull(duration29);
        org.junit.Assert.assertNotNull(months33);
        org.junit.Assert.assertNotNull(duration34);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + true + "'", boolean35 == true);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        org.junit.Assert.assertNotNull(mutableInterval39);
        org.junit.Assert.assertNotNull(dateTime40);
    }

    @Test
    public void test463() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test463");
        org.joda.time.chrono.GJChronology gJChronology0 = org.joda.time.chrono.GJChronology.getInstanceUTC();
        org.joda.time.tz.FixedDateTimeZone fixedDateTimeZone5 = new org.joda.time.tz.FixedDateTimeZone("P0M", "hours", 7, 4);
        Chronology chronology6 = gJChronology0.withZone((DateTimeZone) fixedDateTimeZone5);
        org.junit.Assert.assertNotNull(gJChronology0);
        org.junit.Assert.assertNotNull(chronology6);
    }

    @Test
    public void test464() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test464");
        DateTime dateTime0 = new DateTime();
        DateTime.Property property1 = dateTime0.hourOfDay();
        int int2 = dateTime0.getDayOfYear();
        ReadableInstant readableInstant3 = null;
        DateTime dateTime4 = new DateTime();
        Interval interval5 = new Interval(readableInstant3, (ReadableInstant) dateTime4);
        MutablePeriod mutablePeriod6 = new MutablePeriod((ReadableInstant) dateTime0, readableInstant3);
        DateTime dateTime8 = dateTime0.plusSeconds((int) (short) 100);
        org.junit.Assert.assertNotNull(property1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 143 + "'", int2 == 143);
        org.junit.Assert.assertNotNull(dateTime8);
    }

    @Test
    public void test465() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test465");
        DateTimeZone dateTimeZone1 = null;
        MutableDateTime mutableDateTime2 = new MutableDateTime((long) 10080, dateTimeZone1);
        DateMidnight dateMidnight4 = new DateMidnight(0L);
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        boolean boolean7 = dateMidnight4.isEqual((ReadableInstant) dateMidnight6);
        int int8 = dateMidnight4.getSecondOfDay();
        DateMidnight dateMidnight10 = dateMidnight4.plus((long) 36000000);
        mutableDateTime2.setMillis((ReadableInstant) dateMidnight10);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology14 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone15 = ethiopicChronology14.getZone();
        Weeks weeks16 = Weeks.ONE;
        int[] intArray19 = ethiopicChronology14.get((ReadablePeriod) weeks16, (long) (short) 1, 100L);
        Period period20 = new Period((long) (short) 0, (long) 'a', (Chronology) ethiopicChronology14);
        org.joda.time.format.PeriodFormatter periodFormatter21 = null;
        String str22 = period20.toString(periodFormatter21);
        mutableDateTime2.add((ReadablePeriod) period20, (int) 'a');
        DurationFieldType durationFieldType25 = DurationFieldType.years();
        mutableDateTime2.add(durationFieldType25, (int) (short) 1);
        MutableDateTime.Property property28 = mutableDateTime2.year();
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateMidnight10);
        org.junit.Assert.assertNotNull(ethiopicChronology14);
        org.junit.Assert.assertNotNull(dateTimeZone15);
        org.junit.Assert.assertNotNull(weeks16);
        org.junit.Assert.assertNotNull(intArray19);
        org.junit.Assert.assertArrayEquals(intArray19, new int[] { 0 });
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "PT0.097S" + "'", str22, "PT0.097S");
        org.junit.Assert.assertNotNull(durationFieldType25);
        org.junit.Assert.assertNotNull(property28);
    }

    @Test
    public void test466() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test466");
        int int0 = YearMonth.MONTH_OF_YEAR;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 1 + "'", int0 == 1);
    }

    @Test
    public void test467() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test467");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        Duration duration4 = interval2.toDuration();
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        PeriodType periodType7 = PeriodType.days();
        MutablePeriod mutablePeriod8 = new MutablePeriod((ReadableDuration) duration4, (ReadableInstant) dateMidnight6, periodType7);
        Chronology chronology9 = null;
        Period period10 = duration4.toPeriod(chronology9);
        Object obj11 = null;
        Chronology chronology12 = null;
        Interval interval13 = new Interval(obj11, chronology12);
        Months months14 = Months.monthsIn((ReadableInterval) interval13);
        Duration duration15 = interval13.toDuration();
        DateMidnight dateMidnight17 = new DateMidnight(0L);
        PeriodType periodType18 = PeriodType.days();
        MutablePeriod mutablePeriod19 = new MutablePeriod((ReadableDuration) duration15, (ReadableInstant) dateMidnight17, periodType18);
        boolean boolean20 = duration4.isShorterThan((ReadableDuration) duration15);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology21 = org.joda.time.chrono.EthiopicChronology.getInstance();
        Period period22 = new Period((Object) duration4, (Chronology) ethiopicChronology21);
        Months months23 = Months.MAX_VALUE;
        Months months24 = Months.MAX_VALUE;
        Object obj25 = null;
        Chronology chronology26 = null;
        Interval interval27 = new Interval(obj25, chronology26);
        Months months28 = Months.monthsIn((ReadableInterval) interval27);
        boolean boolean29 = months24.isGreaterThan(months28);
        Months months30 = months23.minus(months24);
        PeriodType periodType31 = months30.getPeriodType();
        Period period32 = period22.normalizedStandard(periodType31);
        Period period34 = period22.plusWeeks(168);
        Period period36 = period22.withMonths(1970);
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertNotNull(duration4);
        org.junit.Assert.assertNotNull(periodType7);
        org.junit.Assert.assertNotNull(period10);
        org.junit.Assert.assertNotNull(months14);
        org.junit.Assert.assertNotNull(duration15);
        org.junit.Assert.assertNotNull(periodType18);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(ethiopicChronology21);
        org.junit.Assert.assertNotNull(months23);
        org.junit.Assert.assertNotNull(months24);
        org.junit.Assert.assertNotNull(months28);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + true + "'", boolean29 == true);
        org.junit.Assert.assertNotNull(months30);
        org.junit.Assert.assertNotNull(periodType31);
        org.junit.Assert.assertNotNull(period32);
        org.junit.Assert.assertNotNull(period34);
        org.junit.Assert.assertNotNull(period36);
    }

    @Test
    public void test468() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test468");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        DurationField durationField6 = ethiopicChronology4.hours();
        int int8 = durationField6.getValue(0L);
        DateTimeFieldType dateTimeFieldType9 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField11 = new org.joda.time.field.DividedDateTimeField(dateTimeField3, durationField6, dateTimeFieldType9, (int) '4');
        int int13 = dividedDateTimeField11.getLeapAmount(10L);
        int int14 = dividedDateTimeField11.getDivisor();
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType9);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 52 + "'", int14 == 52);
    }

    @Test
    public void test469() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test469");
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder0 = new org.joda.time.format.DateTimeFormatterBuilder();
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder2 = dateTimeFormatterBuilder0.appendWeekOfWeekyear(3);
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder4 = dateTimeFormatterBuilder2.appendMinuteOfHour((int) (byte) 100);
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder7 = dateTimeFormatterBuilder4.appendTwoDigitYear((int) '4', true);
        org.joda.time.format.DateTimePrinter dateTimePrinter8 = dateTimeFormatterBuilder7.toPrinter();
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder2);
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder4);
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder7);
        org.junit.Assert.assertNotNull(dateTimePrinter8);
    }

    @Test
    public void test470() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test470");
        Hours hours0 = Hours.SIX;
        MutablePeriod mutablePeriod1 = hours0.toMutablePeriod();
        mutablePeriod1.setSeconds((int) (short) 0);
        mutablePeriod1.addSeconds(1000);
        org.junit.Assert.assertNotNull(hours0);
        org.junit.Assert.assertNotNull(mutablePeriod1);
    }

    @Test
    public void test471() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test471");
        Partial partial0 = new Partial();
        Period period2 = Period.months(12);
        Partial partial3 = partial0.minus((ReadablePeriod) period2);
        org.junit.Assert.assertNotNull(period2);
        org.junit.Assert.assertNotNull(partial3);
    }

    @Test
    public void test472() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test472");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology2 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone3 = ethiopicChronology2.getZone();
        Weeks weeks4 = Weeks.ONE;
        int[] intArray7 = ethiopicChronology2.get((ReadablePeriod) weeks4, (long) (short) 1, 100L);
        Period period8 = new Period((long) (short) 0, (long) 'a', (Chronology) ethiopicChronology2);
        DateTimeField dateTimeField9 = ethiopicChronology2.centuryOfEra();
        DateTimeField dateTimeField10 = ethiopicChronology2.year();
        int int11 = dateTimeField10.getMaximumValue();
        org.junit.Assert.assertNotNull(ethiopicChronology2);
        org.junit.Assert.assertNotNull(dateTimeZone3);
        org.junit.Assert.assertNotNull(weeks4);
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertArrayEquals(intArray7, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField9);
        org.junit.Assert.assertNotNull(dateTimeField10);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 292272984 + "'", int11 == 292272984);
    }

    @Test
    public void test473() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test473");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DateTimeField dateTimeField2 = ethiopicChronology0.minuteOfHour();
        org.joda.time.chrono.CopticChronology copticChronology4 = org.joda.time.chrono.CopticChronology.getInstanceUTC();
        LocalDateTime localDateTime5 = new LocalDateTime((-35999994L), (Chronology) copticChronology4);
        LocalDateTime localDateTime7 = localDateTime5.plusDays((int) (byte) -1);
        DateMidnight dateMidnight9 = new DateMidnight(0L);
        Chronology chronology10 = null;
        DateMidnight dateMidnight11 = dateMidnight9.withChronology(chronology10);
        DateMidnight dateMidnight13 = dateMidnight9.withCenturyOfEra((int) ' ');
        DateMidnight.Property property14 = dateMidnight9.dayOfMonth();
        DateMidnight dateMidnight16 = new DateMidnight(0L);
        Chronology chronology17 = null;
        DateMidnight dateMidnight18 = dateMidnight16.withChronology(chronology17);
        DateMidnight dateMidnight20 = dateMidnight16.withCenturyOfEra((int) ' ');
        DateMidnight.Property property21 = dateMidnight16.dayOfMonth();
        int int22 = dateMidnight16.getMinuteOfHour();
        Duration duration23 = new Duration((ReadableInstant) dateMidnight9, (ReadableInstant) dateMidnight16);
        LocalDateTime localDateTime25 = localDateTime7.withDurationAdded((ReadableDuration) duration23, 12);
        DateTime dateTime26 = localDateTime7.toDateTime();
        int int27 = dateTimeField2.getMinimumValue((ReadablePartial) localDateTime7);
        LocalDateTime.Property property28 = localDateTime7.monthOfYear();
        LocalDateTime localDateTime29 = property28.roundHalfEvenCopy();
        LocalDateTime localDateTime31 = localDateTime29.minusMonths((int) '4');
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(dateTimeField2);
        org.junit.Assert.assertNotNull(copticChronology4);
        org.junit.Assert.assertNotNull(localDateTime7);
        org.junit.Assert.assertNotNull(dateMidnight11);
        org.junit.Assert.assertNotNull(dateMidnight13);
        org.junit.Assert.assertNotNull(property14);
        org.junit.Assert.assertNotNull(dateMidnight18);
        org.junit.Assert.assertNotNull(dateMidnight20);
        org.junit.Assert.assertNotNull(property21);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 0 + "'", int22 == 0);
        org.junit.Assert.assertNotNull(localDateTime25);
        org.junit.Assert.assertNotNull(dateTime26);
        org.junit.Assert.assertTrue("'" + int27 + "' != '" + 0 + "'", int27 == 0);
        org.junit.Assert.assertNotNull(property28);
        org.junit.Assert.assertNotNull(localDateTime29);
        org.junit.Assert.assertNotNull(localDateTime31);
    }

    @Test
    public void test474() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test474");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Weeks weeks3 = Weeks.ONE;
        Interval interval4 = interval2.withPeriodAfterStart((ReadablePeriod) weeks3);
        LocalDate localDate5 = new LocalDate();
        LocalDate localDate7 = localDate5.minusWeeks(3);
        LocalDate.Property property8 = localDate7.monthOfYear();
        LocalDate localDate9 = property8.roundHalfFloorCopy();
        LocalDate localDate10 = new LocalDate();
        DateTimeFieldType dateTimeFieldType11 = DateTimeFieldType.weekyearOfCentury();
        int int12 = localDate10.indexOf(dateTimeFieldType11);
        LocalDate localDate14 = localDate10.withDayOfYear(24);
        int int15 = localDate9.compareTo((ReadablePartial) localDate14);
        DateTime dateTime16 = localDate9.toDateTimeAtCurrentTime();
        Interval interval17 = interval4.withStart((ReadableInstant) dateTime16);
        DateTime dateTime18 = interval17.getStart();
        org.junit.Assert.assertNotNull(weeks3);
        org.junit.Assert.assertNotNull(interval4);
        org.junit.Assert.assertNotNull(localDate7);
        org.junit.Assert.assertNotNull(property8);
        org.junit.Assert.assertNotNull(localDate9);
        org.junit.Assert.assertNotNull(dateTimeFieldType11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + (-1) + "'", int12 == (-1));
        org.junit.Assert.assertNotNull(localDate14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 1 + "'", int15 == 1);
        org.junit.Assert.assertNotNull(dateTime16);
        org.junit.Assert.assertNotNull(interval17);
        org.junit.Assert.assertNotNull(dateTime18);
    }

    @Test
    public void test475() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test475");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        DurationField durationField6 = ethiopicChronology4.hours();
        int int8 = durationField6.getValue(0L);
        DateTimeFieldType dateTimeFieldType9 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField11 = new org.joda.time.field.DividedDateTimeField(dateTimeField3, durationField6, dateTimeFieldType9, (int) '4');
        int int13 = dividedDateTimeField11.getLeapAmount(10L);
        int int15 = dividedDateTimeField11.get(456878073600000L);
        // The following exception was thrown during execution in test generation
        try {
            long long18 = dividedDateTimeField11.set(100L, "months");
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value \"months\" for millisOfDay is not supported");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType9);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
    }

    @Test
    public void test476() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test476");
        org.joda.time.chrono.CopticChronology copticChronology1 = org.joda.time.chrono.CopticChronology.getInstanceUTC();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology3 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone4 = ethiopicChronology3.getZone();
        Object obj5 = null;
        Chronology chronology6 = null;
        Interval interval7 = new Interval(obj5, chronology6);
        Weeks weeks8 = Weeks.ONE;
        Interval interval9 = interval7.withPeriodAfterStart((ReadablePeriod) weeks8);
        int[] intArray12 = ethiopicChronology3.get((ReadablePeriod) weeks8, (long) (short) -1, (long) (short) -1);
        DurationField durationField13 = ethiopicChronology3.minutes();
        YearMonthDay yearMonthDay14 = new YearMonthDay(100L, (Chronology) ethiopicChronology3);
        DateTimeField dateTimeField15 = ethiopicChronology3.minuteOfDay();
        DateTimeField dateTimeField16 = ethiopicChronology3.dayOfMonth();
        DateTimeZone dateTimeZone17 = ethiopicChronology3.getZone();
        Chronology chronology18 = copticChronology1.withZone(dateTimeZone17);
        DateTime dateTime19 = new DateTime((long) 168, chronology18);
        org.junit.Assert.assertNotNull(copticChronology1);
        org.junit.Assert.assertNotNull(ethiopicChronology3);
        org.junit.Assert.assertNotNull(dateTimeZone4);
        org.junit.Assert.assertNotNull(weeks8);
        org.junit.Assert.assertNotNull(interval9);
        org.junit.Assert.assertNotNull(intArray12);
        org.junit.Assert.assertArrayEquals(intArray12, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField13);
        org.junit.Assert.assertNotNull(dateTimeField15);
        org.junit.Assert.assertNotNull(dateTimeField16);
        org.junit.Assert.assertNotNull(dateTimeZone17);
        org.junit.Assert.assertNotNull(chronology18);
    }

    @Test
    public void test477() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test477");
        LocalDate localDate0 = new LocalDate();
        LocalDate localDate2 = localDate0.minusWeeks(3);
        LocalDate localDate4 = localDate2.withYear((int) (byte) 100);
        org.junit.Assert.assertNotNull(localDate2);
        org.junit.Assert.assertNotNull(localDate4);
    }

    @Test
    public void test478() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test478");
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder0 = new org.joda.time.format.DateTimeFormatterBuilder();
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder3 = dateTimeFormatterBuilder0.appendCenturyOfEra(9, 2);
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder5 = dateTimeFormatterBuilder3.appendDayOfYear((int) (short) 0);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology6 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone7 = ethiopicChronology6.getZone();
        DurationField durationField8 = ethiopicChronology6.hours();
        DateTimeField dateTimeField9 = ethiopicChronology6.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology10 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone11 = ethiopicChronology10.getZone();
        DurationField durationField12 = ethiopicChronology10.hours();
        int int14 = durationField12.getValue(0L);
        DateTimeFieldType dateTimeFieldType15 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField17 = new org.joda.time.field.DividedDateTimeField(dateTimeField9, durationField12, dateTimeFieldType15, (int) '4');
        DateTimeFieldType dateTimeFieldType18 = DateTimeFieldType.clockhourOfHalfday();
        org.joda.time.field.OffsetDateTimeField offsetDateTimeField22 = new org.joda.time.field.OffsetDateTimeField((DateTimeField) dividedDateTimeField17, dateTimeFieldType18, 7, 1, 12);
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder23 = dateTimeFormatterBuilder5.appendShortText(dateTimeFieldType18);
        org.joda.time.format.DateTimeFormatterBuilder dateTimeFormatterBuilder26 = dateTimeFormatterBuilder23.appendFractionOfMinute((int) (byte) 0, (int) 'a');
        boolean boolean27 = dateTimeFormatterBuilder23.canBuildFormatter();
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder3);
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder5);
        org.junit.Assert.assertNotNull(ethiopicChronology6);
        org.junit.Assert.assertNotNull(dateTimeZone7);
        org.junit.Assert.assertNotNull(durationField8);
        org.junit.Assert.assertNotNull(dateTimeField9);
        org.junit.Assert.assertNotNull(ethiopicChronology10);
        org.junit.Assert.assertNotNull(dateTimeZone11);
        org.junit.Assert.assertNotNull(durationField12);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType15);
        org.junit.Assert.assertNotNull(dateTimeFieldType18);
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder23);
        org.junit.Assert.assertNotNull(dateTimeFormatterBuilder26);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + true + "'", boolean27 == true);
    }

    @Test
    public void test479() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test479");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        DateMidnight dateMidnight3 = new DateMidnight(0L);
        boolean boolean4 = dateMidnight1.isEqual((ReadableInstant) dateMidnight3);
        Object obj5 = null;
        Chronology chronology6 = null;
        Interval interval7 = new Interval(obj5, chronology6);
        Months months8 = Months.monthsIn((ReadableInterval) interval7);
        Duration duration9 = interval7.toDuration();
        DateMidnight dateMidnight11 = new DateMidnight(0L);
        PeriodType periodType12 = PeriodType.days();
        MutablePeriod mutablePeriod13 = new MutablePeriod((ReadableDuration) duration9, (ReadableInstant) dateMidnight11, periodType12);
        Chronology chronology14 = null;
        Period period15 = duration9.toPeriod(chronology14);
        PeriodType periodType16 = PeriodType.yearMonthDayTime();
        MutablePeriod mutablePeriod17 = new MutablePeriod((ReadableInstant) dateMidnight3, (ReadableDuration) duration9, periodType16);
        DateMidnight dateMidnight19 = dateMidnight3.minusMonths((int) (short) -1);
        DateTime dateTime20 = dateMidnight3.toDateTimeISO();
        // The following exception was thrown during execution in test generation
        try {
            DateTime dateTime24 = dateTime20.withDate(143, 10, 292272984);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 292272984 for dayOfMonth must be in the range [1,31]: year: 143 month: 10");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(months8);
        org.junit.Assert.assertNotNull(duration9);
        org.junit.Assert.assertNotNull(periodType12);
        org.junit.Assert.assertNotNull(period15);
        org.junit.Assert.assertNotNull(periodType16);
        org.junit.Assert.assertNotNull(dateMidnight19);
        org.junit.Assert.assertNotNull(dateTime20);
    }

    @Test
    public void test480() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test480");
        MutableDateTime mutableDateTime0 = MutableDateTime.now();
        Object obj1 = null;
        Chronology chronology2 = null;
        Interval interval3 = new Interval(obj1, chronology2);
        Months months4 = Months.monthsIn((ReadableInterval) interval3);
        Duration duration5 = interval3.toDuration();
        DateMidnight dateMidnight7 = new DateMidnight(0L);
        PeriodType periodType8 = PeriodType.days();
        MutablePeriod mutablePeriod9 = new MutablePeriod((ReadableDuration) duration5, (ReadableInstant) dateMidnight7, periodType8);
        Chronology chronology10 = null;
        Period period11 = duration5.toPeriod(chronology10);
        Object obj12 = null;
        Chronology chronology13 = null;
        Interval interval14 = new Interval(obj12, chronology13);
        Months months15 = Months.monthsIn((ReadableInterval) interval14);
        Duration duration16 = interval14.toDuration();
        DateMidnight dateMidnight18 = new DateMidnight(0L);
        PeriodType periodType19 = PeriodType.days();
        MutablePeriod mutablePeriod20 = new MutablePeriod((ReadableDuration) duration16, (ReadableInstant) dateMidnight18, periodType19);
        boolean boolean21 = duration5.isShorterThan((ReadableDuration) duration16);
        mutableDateTime0.add((ReadableDuration) duration16, 10);
        boolean boolean25 = mutableDateTime0.equals((Object) (-1.0f));
        int int26 = mutableDateTime0.getRoundingMode();
        Instant instant27 = Instant.now();
        Instant instant29 = instant27.withMillis((long) 1970);
        Instant instant31 = instant27.plus(100L);
        MutablePeriod mutablePeriod32 = new MutablePeriod((ReadableInstant) mutableDateTime0, (ReadableInstant) instant31);
        DateTimeFieldType dateTimeFieldType33 = DateTimeFieldType.dayOfYear();
        String str34 = dateTimeFieldType33.getName();
        // The following exception was thrown during execution in test generation
        try {
            mutableDateTime0.set(dateTimeFieldType33, 10080);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 10080 for dayOfYear must be in the range [1,365]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(mutableDateTime0);
        org.junit.Assert.assertNotNull(months4);
        org.junit.Assert.assertNotNull(duration5);
        org.junit.Assert.assertNotNull(periodType8);
        org.junit.Assert.assertNotNull(period11);
        org.junit.Assert.assertNotNull(months15);
        org.junit.Assert.assertNotNull(duration16);
        org.junit.Assert.assertNotNull(periodType19);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 0 + "'", int26 == 0);
        org.junit.Assert.assertNotNull(instant27);
        org.junit.Assert.assertNotNull(instant29);
        org.junit.Assert.assertNotNull(instant31);
        org.junit.Assert.assertNotNull(dateTimeFieldType33);
        org.junit.Assert.assertEquals("'" + str34 + "' != '" + "dayOfYear" + "'", str34, "dayOfYear");
    }

    @Test
    public void test481() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test481");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter0 = org.joda.time.format.ISODateTimeFormat.basicDateTimeNoMillis();
        org.junit.Assert.assertNotNull(dateTimeFormatter0);
    }

    @Test
    public void test482() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test482");
        // The following exception was thrown during execution in test generation
        try {
            LocalDate localDate1 = new LocalDate((Object) 4);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: No partial converter found for type: java.lang.Integer");
        } catch (IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test483() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test483");
        org.joda.time.chrono.GJChronology gJChronology0 = org.joda.time.chrono.GJChronology.getInstanceUTC();
        // The following exception was thrown during execution in test generation
        try {
            long long5 = gJChronology0.getDateTimeMillis(9, (int) (byte) 100, (int) (short) 10, 1000);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 100 for monthOfYear must be in the range [1,12]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(gJChronology0);
    }

    @Test
    public void test484() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test484");
        org.joda.time.tz.DateTimeZoneBuilder dateTimeZoneBuilder0 = new org.joda.time.tz.DateTimeZoneBuilder();
    }

    @Test
    public void test485() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test485");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Weeks weeks6 = Weeks.ONE;
        Interval interval7 = interval5.withPeriodAfterStart((ReadablePeriod) weeks6);
        int[] intArray10 = ethiopicChronology1.get((ReadablePeriod) weeks6, (long) (short) -1, (long) (short) -1);
        DurationField durationField11 = ethiopicChronology1.minutes();
        YearMonthDay yearMonthDay12 = new YearMonthDay(100L, (Chronology) ethiopicChronology1);
        DateTimeField dateTimeField13 = ethiopicChronology1.minuteOfDay();
        DateTimeField dateTimeField14 = ethiopicChronology1.yearOfEra();
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(weeks6);
        org.junit.Assert.assertNotNull(interval7);
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField11);
        org.junit.Assert.assertNotNull(dateTimeField13);
        org.junit.Assert.assertNotNull(dateTimeField14);
    }

    @Test
    public void test486() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test486");
        org.joda.time.chrono.GJChronology gJChronology1 = org.joda.time.chrono.GJChronology.getInstanceUTC();
        java.util.Locale locale2 = null;
        org.joda.time.format.DateTimeParserBucket dateTimeParserBucket5 = new org.joda.time.format.DateTimeParserBucket((long) 0, (Chronology) gJChronology1, locale2, (Integer) 86400000, 9);
        org.joda.time.format.DateTimeParser dateTimeParser6 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long8 = dateTimeParserBucket5.parseMillis(dateTimeParser6, (CharSequence) "dayOfYear");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(gJChronology1);
    }

    @Test
    public void test487() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test487");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        Weeks weeks3 = Weeks.ONE;
        int[] intArray6 = ethiopicChronology1.get((ReadablePeriod) weeks3, (long) (short) 1, 100L);
        DateTimeField dateTimeField7 = ethiopicChronology1.millisOfDay();
        TimeOfDay timeOfDay8 = new TimeOfDay((long) (short) 10, (Chronology) ethiopicChronology1);
        DateTimeField dateTimeField9 = ethiopicChronology1.year();
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(weeks3);
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertArrayEquals(intArray6, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField7);
        org.junit.Assert.assertNotNull(dateTimeField9);
    }

    @Test
    public void test488() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test488");
        TimeOfDay timeOfDay0 = new TimeOfDay();
        Weeks weeks1 = Weeks.ONE;
        Period period2 = weeks1.toPeriod();
        TimeOfDay timeOfDay3 = timeOfDay0.minus((ReadablePeriod) weeks1);
        TimeOfDay timeOfDay5 = timeOfDay0.plusMinutes(24);
        org.junit.Assert.assertNotNull(weeks1);
        org.junit.Assert.assertNotNull(period2);
        org.junit.Assert.assertNotNull(timeOfDay3);
        org.junit.Assert.assertNotNull(timeOfDay5);
    }

    @Test
    public void test489() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test489");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        DateMidnight dateMidnight3 = new DateMidnight(0L);
        boolean boolean4 = dateMidnight1.isEqual((ReadableInstant) dateMidnight3);
        MutableDateTime mutableDateTime5 = MutableDateTime.now();
        Object obj6 = null;
        Chronology chronology7 = null;
        Interval interval8 = new Interval(obj6, chronology7);
        Months months9 = Months.monthsIn((ReadableInterval) interval8);
        Duration duration10 = interval8.toDuration();
        DateMidnight dateMidnight12 = new DateMidnight(0L);
        PeriodType periodType13 = PeriodType.days();
        MutablePeriod mutablePeriod14 = new MutablePeriod((ReadableDuration) duration10, (ReadableInstant) dateMidnight12, periodType13);
        Chronology chronology15 = null;
        Period period16 = duration10.toPeriod(chronology15);
        Object obj17 = null;
        Chronology chronology18 = null;
        Interval interval19 = new Interval(obj17, chronology18);
        Months months20 = Months.monthsIn((ReadableInterval) interval19);
        Duration duration21 = interval19.toDuration();
        DateMidnight dateMidnight23 = new DateMidnight(0L);
        PeriodType periodType24 = PeriodType.days();
        MutablePeriod mutablePeriod25 = new MutablePeriod((ReadableDuration) duration21, (ReadableInstant) dateMidnight23, periodType24);
        boolean boolean26 = duration10.isShorterThan((ReadableDuration) duration21);
        mutableDateTime5.add((ReadableDuration) duration21, 10);
        MutableInterval mutableInterval29 = new MutableInterval((ReadableInstant) dateMidnight3, (ReadableDuration) duration21);
        DateTime dateTime30 = new DateTime();
        DateTime.Property property31 = dateTime30.hourOfDay();
        DateTime dateTime33 = dateTime30.withWeekyear(7);
        Interval interval34 = duration21.toIntervalTo((ReadableInstant) dateTime30);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(mutableDateTime5);
        org.junit.Assert.assertNotNull(months9);
        org.junit.Assert.assertNotNull(duration10);
        org.junit.Assert.assertNotNull(periodType13);
        org.junit.Assert.assertNotNull(period16);
        org.junit.Assert.assertNotNull(months20);
        org.junit.Assert.assertNotNull(duration21);
        org.junit.Assert.assertNotNull(periodType24);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertNotNull(property31);
        org.junit.Assert.assertNotNull(dateTime33);
        org.junit.Assert.assertNotNull(interval34);
    }

    @Test
    public void test490() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test490");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Object obj2 = null;
        Chronology chronology3 = null;
        Interval interval4 = new Interval(obj2, chronology3);
        Weeks weeks5 = Weeks.ONE;
        Interval interval6 = interval4.withPeriodAfterStart((ReadablePeriod) weeks5);
        int[] intArray9 = ethiopicChronology0.get((ReadablePeriod) weeks5, (long) (short) -1, (long) (short) -1);
        DurationField durationField10 = ethiopicChronology0.years();
        boolean boolean11 = durationField10.isPrecise();
        // The following exception was thrown during execution in test generation
        try {
            long long14 = durationField10.getMillis(456882566400000L, (long) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException; message: Value cannot fit in an int: 456882566400000");
        } catch (ArithmeticException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(weeks5);
        org.junit.Assert.assertNotNull(interval6);
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertArrayEquals(intArray9, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test491() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test491");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        DurationField durationField2 = ethiopicChronology0.hours();
        DateTimeField dateTimeField3 = ethiopicChronology0.clockhourOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology4 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone5 = ethiopicChronology4.getZone();
        DurationField durationField6 = ethiopicChronology4.hours();
        int int8 = durationField6.getValue(0L);
        DateTimeFieldType dateTimeFieldType9 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.DividedDateTimeField dividedDateTimeField11 = new org.joda.time.field.DividedDateTimeField(dateTimeField3, durationField6, dateTimeFieldType9, (int) '4');
        int int13 = dividedDateTimeField11.getLeapAmount(10L);
        DateTimeFieldType dateTimeFieldType14 = DateTimeFieldType.millisOfDay();
        org.joda.time.field.OffsetDateTimeField offsetDateTimeField16 = new org.joda.time.field.OffsetDateTimeField((DateTimeField) dividedDateTimeField11, dateTimeFieldType14, 5);
        org.junit.Assert.assertNotNull(ethiopicChronology0);
        org.junit.Assert.assertNotNull(dateTimeZone1);
        org.junit.Assert.assertNotNull(durationField2);
        org.junit.Assert.assertNotNull(dateTimeField3);
        org.junit.Assert.assertNotNull(ethiopicChronology4);
        org.junit.Assert.assertNotNull(dateTimeZone5);
        org.junit.Assert.assertNotNull(durationField6);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType9);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertNotNull(dateTimeFieldType14);
    }

    @Test
    public void test492() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test492");
        LocalDate localDate0 = LocalDate.now();
        org.junit.Assert.assertNotNull(localDate0);
    }

    @Test
    public void test493() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test493");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology1 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone2 = ethiopicChronology1.getZone();
        Object obj3 = null;
        Chronology chronology4 = null;
        Interval interval5 = new Interval(obj3, chronology4);
        Weeks weeks6 = Weeks.ONE;
        Interval interval7 = interval5.withPeriodAfterStart((ReadablePeriod) weeks6);
        int[] intArray10 = ethiopicChronology1.get((ReadablePeriod) weeks6, (long) (short) -1, (long) (short) -1);
        DurationField durationField11 = ethiopicChronology1.minutes();
        YearMonthDay yearMonthDay12 = new YearMonthDay(100L, (Chronology) ethiopicChronology1);
        DateTimeField dateTimeField13 = ethiopicChronology1.minuteOfDay();
        DateTimeField dateTimeField14 = ethiopicChronology1.dayOfMonth();
        DateTimeField dateTimeField15 = ethiopicChronology1.era();
        DateTimeField dateTimeField16 = ethiopicChronology1.clockhourOfDay();
        org.junit.Assert.assertNotNull(ethiopicChronology1);
        org.junit.Assert.assertNotNull(dateTimeZone2);
        org.junit.Assert.assertNotNull(weeks6);
        org.junit.Assert.assertNotNull(interval7);
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertArrayEquals(intArray10, new int[] { 0 });
        org.junit.Assert.assertNotNull(durationField11);
        org.junit.Assert.assertNotNull(dateTimeField13);
        org.junit.Assert.assertNotNull(dateTimeField14);
        org.junit.Assert.assertNotNull(dateTimeField15);
        org.junit.Assert.assertNotNull(dateTimeField16);
    }

    @Test
    public void test494() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test494");
        // The following exception was thrown during execution in test generation
        try {
            DateTime dateTime6 = new DateTime((-292269338), 18, (int) (byte) -1, (int) (byte) 1, 0, 12);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 18 for monthOfYear must be in the range [1,12]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
    }

    @Test
    public void test495() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test495");
        LocalDate localDate0 = new LocalDate();
        LocalDate localDate2 = localDate0.minusWeeks(3);
        LocalDate.Property property3 = localDate2.monthOfYear();
        Interval interval4 = localDate2.toInterval();
        String str5 = interval4.toString();
        org.junit.Assert.assertNotNull(localDate2);
        org.junit.Assert.assertNotNull(property3);
        org.junit.Assert.assertNotNull(interval4);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "2025-05-02T00:00:00.000+10:00/2025-05-03T00:00:00.000+10:00" + "'", str5, "2025-05-02T00:00:00.000+10:00/2025-05-03T00:00:00.000+10:00");
    }

    @Test
    public void test496() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test496");
        Object obj2 = null;
        Chronology chronology3 = null;
        Interval interval4 = new Interval(obj2, chronology3);
        Months months5 = Months.monthsIn((ReadableInterval) interval4);
        Duration duration6 = interval4.toDuration();
        DateMidnight dateMidnight8 = new DateMidnight(0L);
        PeriodType periodType9 = PeriodType.days();
        MutablePeriod mutablePeriod10 = new MutablePeriod((ReadableDuration) duration6, (ReadableInstant) dateMidnight8, periodType9);
        Chronology chronology11 = null;
        Period period12 = duration6.toPeriod(chronology11);
        Object obj13 = null;
        Chronology chronology14 = null;
        Interval interval15 = new Interval(obj13, chronology14);
        Months months16 = Months.monthsIn((ReadableInterval) interval15);
        Duration duration17 = interval15.toDuration();
        DateMidnight dateMidnight19 = new DateMidnight(0L);
        PeriodType periodType20 = PeriodType.days();
        MutablePeriod mutablePeriod21 = new MutablePeriod((ReadableDuration) duration17, (ReadableInstant) dateMidnight19, periodType20);
        boolean boolean22 = duration6.isShorterThan((ReadableDuration) duration17);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology23 = org.joda.time.chrono.EthiopicChronology.getInstance();
        Period period24 = new Period((Object) duration6, (Chronology) ethiopicChronology23);
        DateTimeField dateTimeField25 = ethiopicChronology23.weekOfWeekyear();
        MutableInterval mutableInterval26 = new MutableInterval((long) 5, 31133524L, (Chronology) ethiopicChronology23);
        // The following exception was thrown during execution in test generation
        try {
            long long32 = ethiopicChronology23.getDateTimeMillis((long) (-292269338), 3, 52, (int) '4', 36000000);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 36000000 for millisOfSecond must be in the range [0,999]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(months5);
        org.junit.Assert.assertNotNull(duration6);
        org.junit.Assert.assertNotNull(periodType9);
        org.junit.Assert.assertNotNull(period12);
        org.junit.Assert.assertNotNull(months16);
        org.junit.Assert.assertNotNull(duration17);
        org.junit.Assert.assertNotNull(periodType20);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(ethiopicChronology23);
        org.junit.Assert.assertNotNull(dateTimeField25);
    }

    @Test
    public void test497() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test497");
        org.joda.time.chrono.CopticChronology copticChronology0 = org.joda.time.chrono.CopticChronology.getInstanceUTC();
        Chronology chronology1 = DateTimeUtils.getChronology((Chronology) copticChronology0);
        org.junit.Assert.assertNotNull(copticChronology0);
        org.junit.Assert.assertNotNull(chronology1);
    }

    @Test
    public void test498() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test498");
        DateTimeZone dateTimeZone1 = null;
        MutableDateTime mutableDateTime2 = new MutableDateTime((long) 10080, dateTimeZone1);
        DateTime dateTime3 = new DateTime();
        DateTime.Property property4 = dateTime3.hourOfDay();
        int int5 = dateTime3.getDayOfYear();
        Minutes minutes6 = Minutes.minutesBetween((ReadableInstant) mutableDateTime2, (ReadableInstant) dateTime3);
        DateTime.Property property7 = dateTime3.dayOfWeek();
        org.junit.Assert.assertNotNull(property4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 143 + "'", int5 == 143);
        org.junit.Assert.assertNotNull(minutes6);
        org.junit.Assert.assertNotNull(property7);
    }

    @Test
    public void test499() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test499");
        Object obj0 = null;
        Chronology chronology1 = null;
        Interval interval2 = new Interval(obj0, chronology1);
        Months months3 = Months.monthsIn((ReadableInterval) interval2);
        Duration duration4 = interval2.toDuration();
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        PeriodType periodType7 = PeriodType.days();
        MutablePeriod mutablePeriod8 = new MutablePeriod((ReadableDuration) duration4, (ReadableInstant) dateMidnight6, periodType7);
        Chronology chronology9 = null;
        Period period10 = duration4.toPeriod(chronology9);
        Object obj11 = null;
        Chronology chronology12 = null;
        Interval interval13 = new Interval(obj11, chronology12);
        Months months14 = Months.monthsIn((ReadableInterval) interval13);
        Duration duration15 = interval13.toDuration();
        DateMidnight dateMidnight17 = new DateMidnight(0L);
        PeriodType periodType18 = PeriodType.days();
        MutablePeriod mutablePeriod19 = new MutablePeriod((ReadableDuration) duration15, (ReadableInstant) dateMidnight17, periodType18);
        boolean boolean20 = duration4.isShorterThan((ReadableDuration) duration15);
        org.joda.time.chrono.EthiopicChronology ethiopicChronology21 = org.joda.time.chrono.EthiopicChronology.getInstance();
        Period period22 = new Period((Object) duration4, (Chronology) ethiopicChronology21);
        java.math.RoundingMode roundingMode24 = null;
        Duration duration25 = duration4.dividedBy((long) (short) 1, roundingMode24);
        org.junit.Assert.assertNotNull(months3);
        org.junit.Assert.assertNotNull(duration4);
        org.junit.Assert.assertNotNull(periodType7);
        org.junit.Assert.assertNotNull(period10);
        org.junit.Assert.assertNotNull(months14);
        org.junit.Assert.assertNotNull(duration15);
        org.junit.Assert.assertNotNull(periodType18);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(ethiopicChronology21);
        org.junit.Assert.assertNotNull(duration25);
    }

    @Test
    public void test500() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test500");
        org.joda.time.format.DateTimeFormatter dateTimeFormatter0 = org.joda.time.format.ISODateTimeFormat.dateHourMinuteSecondMillis();
        org.junit.Assert.assertNotNull(dateTimeFormatter0);
    }
}
