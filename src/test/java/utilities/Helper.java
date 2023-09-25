/*
 * Copyright (c) NCGR 2023.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 08/05/2023 - Script created.
 */
package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Helper {

    //Method to take screenshot the test case fail
    public static void captureScreenShot(WebDriver driver, String screenshotName) {
        Path dest = Paths.get("./Screenshots", screenshotName + ".png");
        try {
            Files.createDirectories(dest.getParent());
            FileOutputStream out = new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();

        } catch (IOException e) {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
    }

    //Method to generate random text.
    public static String generateRandomName(int length) {
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String randomString = sb.toString();
        return randomString;
    }

    public static String[] generateRandomWords(int numberOfWords)
    {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for(int i = 0; i < numberOfWords; i++)
        {
            char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }

    public static String generateRandomWords2(int numberOfWords2)
    {
        String x[] = Helper.generateRandomWords(numberOfWords2);
        StringBuffer result = new StringBuffer();
        for (int i = 0 ; i <x.length;i++) {
            result.append( x[i] +" " );
        }
        return result.toString();
    }

    //Method to generate random Number.
    public static String generateRandomNumber(int length) {
        char[] chars = "123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String randomString = sb.toString();
        return randomString;
    }

    public static int generateRandomNumber2(int min , int max){

        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }

    public static String getSystemDate() {
        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //get current date time with Date()
        Date date = new Date();
        // Now format the date
        String date1 = dateFormat.format(date);
        // Print the Date
        System.out.println(date1);
        return date1;
    }

    public static String getTodayDate() {
        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("dd");
        //get current date time with Date()
        Date date = new Date();
        // Now format the date
        String date1 = dateFormat.format(date);
        // Print the Date
        //System.out.println(date1);
        return date1;
    }

    public static String getTodayMonth() {
        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("MM");
        //get current date time with Date()
        Date date = new Date();
        // Now format the date
        String date1 = dateFormat.format(date);
        // Print the Date
        System.out.println(date1);
        return date1;
    }

    public static int getCurrentMonth() {
        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("MM");
        //get current date time with Date()
        Date date = new Date();
        // Now format the date
        String date1 = dateFormat.format(date);
        // Print the Date
       // System.out.println(date1);
        int date2 = Integer.parseInt(date1);
        return date2-1;
    }

    public static String getTodayYear() {
        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        //get current date time with Date()
        Date date = new Date();
        // Now format the date
        String date1 = dateFormat.format(date);
        // Print the Date
        //System.out.println(date1);
        return date1;
    }

    public static int  nextDate;
    public static String createNextDate(){
        String currentDate = getTodayDate();
        int currentDate1 = Integer.parseInt(currentDate);
        if (currentDate1 == 30){
            nextDate = 1;
        }else if (currentDate1 >= 1){
            nextDate = Integer.parseInt(currentDate) + 1;
        }
        String nextDate2 = String.valueOf(nextDate);
        System.out.println("Next Date is : " + nextDate2);

        return nextDate2;
    }

    static int PreviousDate;
    public static String createPreviousDate(){

        String currentDate = getTodayDate();
        int currentDate1 = Integer.parseInt(currentDate);
        if (currentDate1 <= 30){
            PreviousDate = Integer.parseInt(currentDate)-1;
        }else if (currentDate1 == 1){
            PreviousDate = 30;
        }
        String PreviousDate2 = String.valueOf(PreviousDate);
        System.out.println("Previous Date is : " + PreviousDate2);

        return PreviousDate2;
    }


    public static String createYear(int index){
        String currentYear = getTodayYear();
        int year = Integer.parseInt(currentYear) + index;
        String year1 = String.valueOf(year);
        //System.out.println("Year is : " + year1);
        return  year1;
    }


    static int previousMonth;
    public static int enterPreviousMonth(){
        int today = Integer.parseInt(getTodayDate());

        if (today == 1){
            previousMonth = Integer.parseInt(getTodayMonth())-1;


        }else if (today <= 30){
            previousMonth = Integer.parseInt(getTodayMonth());
        }
        System.out.println("Month : " + previousMonth);
        return previousMonth-1;
    }

    public static int nextMonth;
    public static int enterNextMonth(){
        int today = Integer.parseInt(getTodayDate());
        if (today == 30){
            nextMonth = Integer.parseInt(getTodayMonth())+1;

        }else if (today >= 1 ){
            nextMonth = Integer.parseInt(getTodayMonth());
        }
        System.out.println("Month : " + nextMonth);
        return  nextMonth-1;
    }

    public static String calDay(String startDate, String endDate){

        LocalDate sDate = LocalDate.parse(startDate);
        LocalDate eDate = LocalDate.parse(endDate);

        LocalDate ssDate = LocalDate.of(sDate.getYear(), sDate.getMonth(), sDate.getDayOfMonth());
        LocalDate eeDate = LocalDate.of(eDate.getYear(), eDate.getMonth(), eDate.getDayOfMonth());

        Period period = Period.between(ssDate, eeDate);

        String duration = period.getYears() + " سنة - "
                + period.getMonths() + " أشهر - "
                + period.getDays() + " يوم";
        System.out.println("Duration is : " + duration);
        return duration;
    }


}
