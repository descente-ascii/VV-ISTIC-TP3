package test.java.fr.istic.vv;

import org.junit.jupiter.api.Test;
import main.java.fr.istic.vv.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    /************************************
            TEST ISLEAPYEAR()
     ************************************/

    @Test
    public void testLeapYear() {
        int year = 2024;
        assertTrue(Date.isLeapYear(year));
    }

    @Test
    public void testLeapYearZero() {
        int year = 0;
        assertTrue(Date.isLeapYear(year));
    }

    @Test
    public void testNegativeLeapYear() {
        int year = -2016;
        assertTrue(Date.isLeapYear(year));
    }

    @Test
    public void testNonLeapYear() {
        int year = 2023;
        assertFalse(Date.isLeapYear(year));
    }

    @Test
    public void testNegativeNonLeapYear() {
        int year = -443;
        assertFalse(Date.isLeapYear(year));
    }

    /************************************
                TEST ISVALIDDATE()
     ************************************/
    @Test
    public void testIsValidDateAnyDate() {
        int day = 24;
        int month = 4;
        int year = 2023;
        assertTrue(Date.isValidDate(day,month,year));
    }

    @Test
    public void testIsValidDateFirstDay() {
        int day = 1;
        int month = 1;
        int year = 2016;
        assertTrue(Date.isValidDate(day,month,year));
    }

    @Test
    public void testIsValidDateLastDay30() {
        int day = 30;
        int month = 1;
        int year = 2016;
        assertTrue(Date.isValidDate(day,month,year));
    }

    @Test
    public void testIsValidDateLastDay31() {
        int day = 31;
        int month = 12;
        int year = 1999;
        assertTrue(Date.isValidDate(day,month,year));
    }

    @Test
    public void testIsValidDateFebruaryLastDayLeapYear() {
        int day = 29;
        int month = 2;
        int year = 2020;
        assertTrue(Date.isValidDate(day,month,year));
    }

    @Test
    public void testIsValidDateFebruaryLastDayNonLeapYear() {
        int day = 28;
        int month = 2;
        int year = 2021;
        assertTrue(Date.isValidDate(day,month,year));
    }

    @Test
    public void testIsValidDateNotValidPositiveDay() {
        int day = 35;
        int month = 11;
        int year = 445;
        assertFalse(Date.isValidDate(day,month,year));
    }

    @Test
    public void testIsValidDateNotNegativeZeroDay() {
        int day = 0;
        int month = 5;
        int year = -150;
        assertFalse(Date.isValidDate(day,month,year));
    }

    @Test
    public void testIsValidDateFebruaryLeapYear() {
        int day = 30;
        int month = 2;
        int year = 2028;
        assertFalse(Date.isValidDate(day,month,year));
    }

    @Test
    public void testIsValidDateFebruaryNonLeapYear() {
        int day = 29;
        int month = 2;
        int year = 2023;
        assertFalse(Date.isValidDate(day,month,year));
    }

    @Test
    public void testIsValidDateMonthOver12() {
        int day = 3;
        int month = 13;
        int year = 2023;
        assertFalse(Date.isValidDate(day,month,year));
    }

    @Test
    public void testIsValidDateMonthBelow1() {
        int day = 3;
        int month = 0;
        int year = 2023;
        assertFalse(Date.isValidDate(day,month,year));
    }

    /************************************
            TEST COMPARETO()
     ***********************************/

    @Test
    public void testCompareToPositive(){
        Date date1 = new Date(13,11,1492);
        Date date2 = new Date(12,11,1492);
        assertEquals(date1.compareTo(date2), 1);
    }

    @Test
    public void testCompareToZero(){
        Date date1 = new Date(13,11,1492);
        Date date2 = new Date(13,11,1492);
        assertEquals(date1.compareTo(date2), 0);
    }

    @Test
    public void testCompareToNegative(){
        Date date1 = new Date(30,12,1491);
        Date date2 = new Date(13,11,1492);
        assertEquals(date1.compareTo(date2), -1);
    }

    @Test
    public void testCompareToPositive2(){
        Date date1 = new Date(1,3,2016);
        Date date2 = new Date(29,2,2016);
        assertEquals(date1.compareTo(date2), 1);
    }

    /************************************
            TEST NEXTDATE()
     ************************************/

    @Test
    public void testNextDateAnyDate(){
        Date date = new Date(13,11,1492);
        Date nextDay = date.nextDate();
        assertEquals(date.compareTo(nextDay), -1);
        assertEquals(nextDay.getDay(), 14);
        assertEquals(nextDay.getMonth(), date.getMonth());
        assertEquals(nextDay.getYear(), date.getYear());
    }

    @Test
    public void testNextDate30th(){
        Date date = new Date(30,11,1492);
        Date nextDay = date.nextDate();
        assertEquals(date.compareTo(nextDay), -1);
        assertEquals(nextDay.getDay(), 1);
        assertEquals(nextDay.getMonth(), 12);
        assertEquals(nextDay.getYear(), date.getYear());
    }

    @Test
    public void testNextDate31th(){
        Date date = new Date(31,12,1492);
        Date nextDay = date.nextDate();
        assertEquals(date.compareTo(nextDay), -1);
        assertEquals(nextDay.getDay(), 1);
        assertEquals(nextDay.getMonth(), 1);
        assertEquals(nextDay.getYear(), 1493);
    }

    @Test
    public void testNextDateFebLastDayLeap(){
        Date date = new Date(29,2,2016);
        Date nextDay = date.nextDate();
        assertEquals(date.compareTo(nextDay), -1);
        assertEquals(nextDay.getDay(), 1);
        assertEquals(nextDay.getMonth(), 3);
        assertEquals(nextDay.getYear(), 2016);
    }

    @Test
    public void testNextDateFebPenultimateDayLeap(){
        Date date = new Date(28,2,2016);
        Date nextDay = date.nextDate();
        assertEquals(date.compareTo(nextDay), -1);
        assertEquals(nextDay.getDay(), 29);
        assertEquals(nextDay.getMonth(), 2);
        assertEquals(nextDay.getYear(), 2016);
    }

    @Test
    public void testNextDateFebLastDayNonLeap(){
        Date date = new Date(28,2,2017);
        Date nextDay = date.nextDate();
        assertEquals(date.compareTo(nextDay), -1);
        assertEquals(nextDay.getDay(), 1);
        assertEquals(nextDay.getMonth(), 3);
        assertEquals(nextDay.getYear(), 2017);
    }

    @Test
    public void testNextDateFebPenultimateNonLeap(){
        Date date = new Date(27,2,2017);
        Date nextDay = date.nextDate();
        assertEquals(date.compareTo(nextDay), -1);
        assertEquals(nextDay.getDay(), 28);
        assertEquals(nextDay.getMonth(), 2);
        assertEquals(nextDay.getYear(), 2017);
    }

    /************************************
            TEST PREVIOUSDATE()
     ************************************/

    @Test
    public void testPreviousDateAnyDate(){
        Date date = new Date(13,11,1492);
        Date previousDay = date.previousDate();
        assertEquals(date.compareTo(previousDay), 1);
        assertEquals(previousDay.getDay(), 12);
        assertEquals(previousDay.getMonth(), date.getMonth());
        assertEquals(previousDay.getYear(), date.getYear());
    }

    @Test
    public void testPreviousDate1rtOfYear(){
        Date date = new Date(1,1,1492);
        Date previousDay = date.previousDate();
        assertEquals(date.compareTo(previousDay), 1);
        assertEquals(previousDay.getDay(), 31);
        assertEquals(previousDay.getMonth(), 12);
        assertEquals(previousDay.getYear(), 1491);
    }

    @Test
    public void testPreviousDateTo30th(){
        Date date = new Date(1,12,1492);
        Date previousDay = date.previousDate();
        assertEquals(date.compareTo(previousDay), 1);
        assertEquals(previousDay.getDay(), 30);
        assertEquals(previousDay.getMonth(), 11);
        assertEquals(previousDay.getYear(), 1492);
    }

    @Test
    public void testPreviousDateFebLeap(){
        Date date = new Date(1,3,2016);
        Date previousDay = date.previousDate();
        assertEquals(date.compareTo(previousDay), 1);
        assertEquals(previousDay.getDay(), 29);
        assertEquals(previousDay.getMonth(), 2);
        assertEquals(previousDay.getYear(), 2016);
    }

    @Test
    public void testPreviousDateFebNonLeap(){
        Date date = new Date(1,3,2015);
        Date previousDay = date.previousDate();
        assertEquals(date.compareTo(previousDay), 1);
        assertEquals(previousDay.getDay(), 28);
        assertEquals(previousDay.getMonth(), 2);
        assertEquals(previousDay.getYear(), 2015);
    }
}