package cn.mumu.architecture.model.future.success;

import java.util.concurrent.TimeUnit;

public class MyRealData implements MyData {

	private int result;

	public MyRealData(int i) {
		int count = 0;
		for (int j = 0; j < i; j++) {
			count += j;
		}
		try {
			System.out.println("后台计算耗时5秒");
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		this.result = count;
	}

	@Override
	public int getResult() {
		System.out.println("获取MyRealData");
		return this.result;
	}

}
