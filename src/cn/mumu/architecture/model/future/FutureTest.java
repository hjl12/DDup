package cn.mumu.architecture.model.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Future的使用
 * @author 木木
 *
 */
public class FutureTest {

	private ExecutorService exeService = Executors.newFixedThreadPool(5);

	public static void main(String[] args) {
		FutureTest ft =new FutureTest();
		Integer countAll = ft.countAll(10);
		System.out.println("最后的结果为="+countAll);
	}

	public Integer countAll(Integer i) {
		FutureTask<Integer> ft = new FutureTask<>(new DoCount(10));
		exeService.submit(ft);
		
		System.out.println("主线程继续执行任务");
		
		int count=0;
		for(int j=0 ;j<5;j++){
			count+=j;
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("主线程执行计算="+j);
		}
		Integer integer=0;
		try {
			 integer = ft.get();
			System.out.println("计算的总数为="+count  +",后台计算总数="+integer);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return count+integer;

	}

	class DoCount implements Callable<Integer> {
		private int i;

		public DoCount(Integer i) {
			this.i = i;
		}

		@Override
		public Integer call() throws Exception {
			int count = 0;
			for (int j = 0; j < i; j++) {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("异步线程运行="+j);
				count += j;
			}
			return count;
		}

	}

}
