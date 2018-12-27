package cn.mumu.architecture.model.future.success;

public class MyMain {
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println("开始执行任务");
		MyDataProxy pro =new MyDataProxy();
		MyFutureData mf=pro.getData(5000000);
		
		System.out.println("main继续执行任务");
		int count=0;
		for (int i=0; i<5000000 ;i++) {
			count +=i;
		}
		
		int result = mf.getResult();
		System.out.println("allTime"+(System.currentTimeMillis()-start));
		System.out.println("count"+count+"result"+result);
		
	}

}
