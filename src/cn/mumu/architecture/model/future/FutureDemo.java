package cn.mumu.architecture.model.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * futurn使用demo
 * 
 * @author bqcoder
 * @version $Id: FuturnDemo.java, v 0.1 2016年11月22日 下午9:07:13 bqcoder Exp $
 */
public class FutureDemo {

    public static void main(String[] args) {
        
        List<Future<String>> taskResultsList = new ArrayList<Future<String>>();

        //创建线程池,使用future必须要使用executors.submit来调用，《乌龟的屁股，规定》
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            Future<String> result = executor.submit(new TaskWithResult(i));
            taskResultsList.add(result);
        }

        //获取执行结果
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(taskResultsList.get(i).get());
            } catch (InterruptedException e) {
            } catch (ExecutionException e) {
            }
        }
    }
}

class TaskWithResult implements Callable<String> {

    private int taskId;

    TaskWithResult(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public String call() throws Exception {
        return "执行结果：任务taskId=" + taskId;
    }

}