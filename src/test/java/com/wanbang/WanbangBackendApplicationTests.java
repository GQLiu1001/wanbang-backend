package com.wanbang;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CancellationException;

@SpringBootTest
class WanbangBackendApplicationTests {

    @Test
    void contextLoads() {
        Integer year = 2025;
        List<String> list = new ArrayList<>();
        Integer month = 1;
        Integer MONTH_LENGTH = 13;
        String yearMonth = "";
        if (month > MONTH_LENGTH) {
            for (int i = MONTH_LENGTH; i > 0; i--) {
                if (month < 10) {
                    String monthStr = "-0" + month;
                    yearMonth = year + monthStr;
                    System.out.println(yearMonth);
                    list.add(yearMonth);
                    month--;
                } else {
                    String monthStr = "-" + month;
                    yearMonth = year + monthStr;
                    System.out.println(yearMonth);
                    list.add(yearMonth);
                    month--;
                }
            }
        } else {
            Integer num = MONTH_LENGTH - month;
            for (int i = month; i > 0; i--) {
                String monthStr = "-0" + month;
                yearMonth = year + monthStr;
                System.out.println(yearMonth);
                list.add(yearMonth);
                month--;
            }
            for (int n = 0; n <= num / 12; n++) {
                year = year - 1;
                for (int i = 12; i > 12 - num; i--) {
                    if (i < 10) {
                        String monthStr = "-0" + i;
                        yearMonth = year + monthStr;
                        System.out.println(yearMonth);
                        list.add(yearMonth);
                        month--;
                    } else {
                        String monthStr = "-" + i;
                        yearMonth = year + monthStr;
                        System.out.println(yearMonth);
                        list.add(yearMonth);
                        month--;
                    }
                }
            }
        }
    }
    @Test
    void a(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.DATE));

    }

    @Test
    void b(){
        Date date = new Date();
        System.out.println(date);
        String date1 = date.toString().substring(0, 10);
        System.out.println(date1);
    }
}
