package cn.lzy.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 江梅铭
 * @date 10/24/2023 8:16 AM
 */
@Component
public class ScheduledTasks {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//    @Scheduled(fixedRate = 15000) // 每隔10秒执行一次任务
//    public void task1() throws InterruptedException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println("Task 1 executed at " + dateFormat.format(new Date()));
//        Thread.sleep(5000);
//    }

//    @Scheduled(fixedRate = 30000) // 每隔30秒执行一次任务
//    public void task2() throws InterruptedException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println("Task 2 executed at " + dateFormat.format(new Date()));
//        Thread.sleep(15000);
//    }


//    @Scheduled(fixedDelay = 15000) // 代码块休眠5秒，10秒之后重复执行任务
//    public void task3() throws InterruptedException {
//        System.out.println("Task 3 executed at " + dateFormat.format(new Date()));
//        Thread.sleep(5000);
//    }

//    @Scheduled(fixedDelay = 5000) // 代码块休眠5秒，5秒之后重复执行任务
//    public void task4() throws InterruptedException {
//        System.out.println("Task 4 executed at " + dateFormat.format(new Date()));
//        Thread.sleep(5000);
//    }

//    @Scheduled(initialDelay = 10000, fixedRate = 15000) // 代码块第一次执行延迟10秒后再执行    休眠5秒，10秒之后重复执行任务
//    public void task5() throws InterruptedException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println("Task 5 executed at " + dateFormat.format(new Date()));
//        Thread.sleep(5000);
//    }

    @Scheduled(initialDelay = 0,fixedRate = 5000) // 代码块第一次执行延迟0秒后再执行      休眠5秒，5秒之后重复执行任务
    public void task6() throws InterruptedException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Task 6 executed at " + dateFormat.format(new Date()));
        Thread.sleep(5000);

    }
}
