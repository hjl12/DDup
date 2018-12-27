package cn.mumu.architecture.model.future.success;

import java.util.concurrent.locks.LockSupport;

public class MyFutureData implements MyData {

	private MyRealData realData;

	private boolean isRealData = false;

//	@Override
//	public synchronized int getResult() {
//		if (!isRealData) {
//			try {
//				System.out.println("线程还没有计算好,wait()");
//				wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return realData.getResult();
//	}
//
//	public synchronized void setRequest(MyRealData my) {
//		if (!isRealData) {
//			System.out.println("计算完成设置realdata到futuredata");
//			this.realData = my;
//			isRealData = true;
//			notifyAll();
//		} else {
//			return;
//		}
//
//	}
	
	
	@Override
	public  int getResult() {
		if (!isRealData) {
				System.out.println("线程还没有计算好,wait()");
		}
		LockSupport.park();
		return realData.getResult();
	}
	
	public  void setRequest(MyRealData my,Thread t ) {
		if (!isRealData) {
			System.out.println("计算完成设置realdata到futuredata");
			this.realData = my;
			isRealData = true;
			LockSupport.unpark(t);
		} else {
			return;
		}
	}

}
