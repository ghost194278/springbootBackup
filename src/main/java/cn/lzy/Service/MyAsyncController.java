package cn.lzy.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author 江梅铭
 * @date 10/23/2023 9:12 PM
 */
@RestController
public class MyAsyncController {
    @Autowired
    private MyAsyncService myService;

    @GetMapping("/sendSMS")
    public String sendSMS() throws Exception {
        Long starTime = System.currentTimeMillis();
        myService.sendSMS();
        Long endTime = System.currentTimeMillis();
        System.out.println("主流程耗时:" + (endTime - starTime));
        return "success";
    }

    @GetMapping("/calculate")
    public String calculate() throws InterruptedException, ExecutionException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        CompletableFuture<Integer> task1 = myService.calculateSumAsync(1, 1000, "1");
        CompletableFuture<Integer> task2 = myService.calculateSumAsync(1001, 2000, "2");

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(task1, task2);

        // 等待第一和第二个异步任务执行完成
        combinedFuture.join();

        // 输出1到1000的总和
        int result1 = task1.get();

        // 输出1001到2000的总和
        int result2 = task2.get();

        String startTime = "3 " + dateFormat.format(new Date());
        System.out.println("3 开始时间：" + startTime);
        System.out.println("3 结束时间：" + "3 " + dateFormat.format(new Date()));
        System.out.println("3 总和：" + (result1 + result2));

        return "计算中";
    }
}
