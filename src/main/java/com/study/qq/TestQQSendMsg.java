/*
 * Copyright (c) 2016-2018 fafa.com.cn. All Rights Reserved.
 */

package com.study.qq;
import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Cll
 * @date 2018/10/17 18:05
 * @since 1.0.0
 */

public class TestQQSendMsg {
    static Desktop deskapp = Desktop.getDesktop();

    public static void main(String[] args) throws AWTException {
        String line;
        String pidInfo = "";
        try {
            Process p = Runtime.getRuntime().exec(System.getenv("windir")+"\\system32\\"+"tasklist.exe");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                pidInfo+=line;
            }
            input.close();
            if(pidInfo.contains("QQ.exe"))
            {
                System.out.println("打开了QQ");
                inputQQ();
            } else {
                openQQ();
                inputQQ();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openQQ() {
        // 判断当前系统释放支持Desktop提供的接口
        if (Desktop.isDesktopSupported()) {
            try {
                deskapp.open(new File("E:\\QQinstall\\Bin\\QQScLauncher.exe"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void inputQQ() throws AWTException {
        Robot robot = new Robot();
        //等待3秒后开始执行下面的自动键盘事件
        robot.delay(3000);
        //按下确认键进行qq登录
        TestInput.keyPress(robot, KeyEvent.VK_ENTER);
        robot.delay(5000);
        // 点击鼠标左键(目的是让光标放到QQ上)
        //TestInput.mouseLeftHit(robot);
        //打开QQ聊天窗口
        //TestInput.keyPressAtlWithCtrlWithZ(robot);
        robot.delay(1000);
        // 搜索我的手机
        TestInput.keyPressString(robot, "张建文");
        robot.delay(1000);
        // 按下回车
        TestInput.keyPress(robot, KeyEvent.VK_ENTER);
        robot.delay(1000);
        //输入要发送的消息
        for (int i = 0; i < 10; i++) {
            TestInput.keyPressString(robot, "邱世平"+i);
            TestInput.keyPress(robot, KeyEvent.VK_ENTER);
        }
        //点击enter键进行发送
        TestInput.keyPress(robot, KeyEvent.VK_ENTER);
    }
}

