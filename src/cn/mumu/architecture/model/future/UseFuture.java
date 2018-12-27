package cn.mumu.architecture.model.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class UseFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		UseFuture uf = new UseFuture();

		List<UserF> userFlist = uf.getUserFlist();
		System.out.println(userFlist.toString());

	}

	public List<UserF> getUserFlist() throws InterruptedException, ExecutionException {
		ExecutorService exec = Executors.newFixedThreadPool(10);
		long startT = System.currentTimeMillis();
		List<Future<UserF>> ulist = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			Future<UserF> submit = exec.submit(new FindUserF(i));
			ulist.add(submit);
		}
		System.out.println("主线程继续运行500毫秒");

		TimeUnit.MILLISECONDS.sleep(500);
		System.out.println("主线程继续运行完毕,开始获取异步的结果");
		List<UserF> li = new ArrayList<>();
		for (Future<UserF> future : ulist) {
			if (future.isDone()) {
				UserF userF = future.get();
				System.out.println(userF.toString());
				li.add(userF);
			}

		}
		System.out.println("总耗时" + (System.currentTimeMillis() - startT) + "毫秒");
		return li;

	}

	class FindUserF  implements Callable<UserF> {
		private int i;

		public FindUserF(int i) {
			this.i = i;
		}

		@Override
		public UserF call() throws Exception {

			TimeUnit.SECONDS.sleep(1);
			System.out.println(" 通过id查询数据库,得到UserF,耗时1s");
			UserF f = new UserF();
			f.setName("mumu" + i);
			return f;
		}

	}
}
