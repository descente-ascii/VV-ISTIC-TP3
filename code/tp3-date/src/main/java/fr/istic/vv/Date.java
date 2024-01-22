package main.java.fr.istic.vv;

public class Date implements Comparable<Date> {

    private final int day;
    private final int month;
    private final int year;

    public Date(int day, int month, int year) {
        if (isValidDate(day, month, year)){
            this.day = day;
            this.month = month;
            this.year = year;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (month > 0 && month < 13) {
            if (day > 0 && day < 32) {
                if (month == 2) {
                    return day <= 29 && (day != 29 || isLeapYear(year));
                }
                else return month % 2 == 0 || day <= 30;
            }
        }
        return false;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public Date nextDate() {
        int day = this.day;
        int month = this.month;
        int year = this.year;
        if (month == 2){
            if (isLeapYear(year)){
                if (day == 29){
                    day = 1;
                    month++;
                }
                else {
                    day++;
                }
            }
            else {
                if (day == 28){
                    day = 1;
                    month++;
                }
                else {
                    day++;
                }
            }
        }
        else {
            if (month % 2 == 0){
                if (day + 1 == 32){
                    day = 1;
                }
                else day++;
            }
            else {
                if (day + 1 == 31){
                    day = 1;
                }
                else day++;
            }
            if (day == 1) {
                month = month + 1 == 13 ? 1 : month + 1;
                if (month == 1) {
                    year++;
                }
            }
        }
        if (isValidDate(day, month, year))
            return new Date(day, month, year);
        else
            throw new IllegalArgumentException();
    }

    public Date previousDate() {
        int day = this.day;
        int month = this.month;
        int year = this.year;
        if (month == 3){
            if (isLeapYear(year)){
                if (day == 1){
                    day = 29;
                    month--;
                }
                else {
                    day--;
                }
            }
            else {
                if (day == 1){
                    day = 28;
                    month--;
                }
                else {
                    day--;
                }
            }
        }
        else {
            if (month % 2 != 0){
                if (day == 1){
                    day = 31;
                }
                else day--;
            }
            else {
                if (day == 1){
                    day = 30;
                }
                else day--;
            }
            if (day == 30 || day == 31) {
                month = month - 1 == 0 ? 12 : month - 1;
                if (month == 12) {
                    year--;
                }
            }
        }
        if (isValidDate(day, month, year))
            return new Date(day, month, year);
        else
            throw new IllegalArgumentException();
    }

    public int compareTo(Date other) {
        if (other == null) throw new NullPointerException();
        if (this.year > other.year) return 1;
        else if (this.year < other.year) return -1;
        else{
            if (this.month > other.month) return 1;
            else if (this.month < other.month) return -1;
            else {
                return Integer.compare(this.day, other.day);
            }
        }
    }

}