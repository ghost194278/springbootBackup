package cn.lzy.Service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.time.format.DateTimeFormatter;

/**
 * @author 江梅铭
 * @date 10/23/2023 9:05 PM
 */
@Service
public class MyAsyncService {
    @Async
    public void sendSMS() throws Exception {
        System.out.println("调用短信验证码业务方法...");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        Long endTime = System.currentTimeMillis();
        System.out.println("短信业务执行完成耗时：" + (endTime - startTime));
    }

    @Async
    public Future<Integer> processA() throws Exception {
        System.out.println("开始分析并统计业务A数据...");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(4000);
        int count = 123456;
        Long endTime = System.currentTimeMillis();
        System.out.println("业务A数据统计耗时：" + (endTime - startTime));
        return new AsyncResult<Integer>(count);

    }

    @Async
    public Future<Integer> processB() throws Exception {
        System.out.println("开始分析并统计业务B数据...");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        int count = 654321;
        Long endTime = System.currentTimeMillis();
        System.out.println("业务B数据统计耗时：" + (endTime - startTime));
        return new AsyncResult<Integer>(count);
    }

    @Async
    public CompletableFuture<Integer> calculateSumAsync(int start, int end, String taskName) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = taskName + " " + dateFormat.format(new Date());
        System.out.println(taskName + "开始时间：" + startTime);

        if (taskName.equals("1")) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String endTime = taskName + " " + dateFormat.format(new Date());
        System.out.println(taskName + "结束时间：" + endTime);
        System.out.println(taskName + "总和：" + sum);

        return CompletableFuture.completedFuture(sum);
    }
}


