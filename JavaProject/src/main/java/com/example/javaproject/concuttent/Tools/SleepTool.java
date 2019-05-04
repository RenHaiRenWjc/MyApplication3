package com.example.javaproject.concuttent.Tools;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:com.example.javaproject.concuttent.Tools
 * Description:
 * author:wjc on 2019/5/4 10:01
 */
public class SleepTool {

    public static final void seconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    public static final void ms(int ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
