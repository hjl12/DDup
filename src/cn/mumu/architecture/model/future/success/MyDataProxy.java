package cn.mumu.architecture.model.future.success;

public class MyDataProxy {

	public MyFutureData getData(final int i) {
		final MyFutureData myFutureData =new MyFutureData();
		final Thread thread = Thread.currentThread();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("并行计算realdata");
				MyRealData my =new MyRealData(i);
				
				//myFutureData.setRequest(my);
				
				/**线程不对,应该用外面的线程*/
				//Thread thread = Thread.currentThread();
				myFutureData.setRequest(my,thread);
			}
		}).start();;
		System.out.println("MyDataProxy返回MyFutureData");
		return myFutureData;
	}

}
