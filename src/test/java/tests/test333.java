package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Helper;

public class test333{

        public double div2(double number,double size){
        double value;
        value = number/size;
        System.out.println(value);
        return value;

            }

    int randomNum;
            public void generate() {


                for (int i = 0; ; i++) {
                     randomNum = (int) (Math.random() * 1000000 + 0);
                    if (randomNum % 24 == 0) {
                        System.out.println(randomNum);
                        return;
                    }
                }
            }



    @Test()
    public void clickdsdsd() throws InterruptedException {

//        int randomNum = ThreadLocalRandom.current().nextInt(2019, 2020 + 1);
//        System.out.println(randomNum);

//        generate();
//        div2(randomNum,3);
//        div2(randomNum,24);
//        div2(randomNum,4);
//        Helper.getSystemDate();
//        Helper.getTodayDate();
//        Helper.getTodayMonth();
//        Helper.getTodayYear();
//        Helper.getTodayDate();
//        Helper.getTodayMonth();
//        Helper.createNextDate();
//        Helper.createPreviousDate();
//        Helper.createYear(1);
//        Helper.createYear(-1);
//        Helper.enterPreviousMonth();

        Helper.calDay("2023-09-26","2025-02-23");
        Assert.assertEquals("0 سنة - 11 أشهر - 12 يوم","0 سنة - 11 أشهر - 12 يوم");

        //System.out.println(System.getProperty("user.dir")+ "\\src\\test\\java\\config\\config.properties");

    }
}
