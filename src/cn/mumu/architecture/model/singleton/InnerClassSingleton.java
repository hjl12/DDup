package cn.mumu.architecture.model.singleton;

/**
 * 静态内部类
 * 
 * @author 木木
 *
 */
public class InnerClassSingleton {

	private InnerClassSingleton() {
		System.out.println("外部类构造");
	}

	static class SingletonInstance {

//		public SingletonInstance() {
//			System.out.println("内部类构造");
//		}

		private static final InnerClassSingleton instance = new InnerClassSingleton();
	}

	public static InnerClassSingleton getInstance() {
		System.out.println("开始获取实例");
		return SingletonInstance.instance;
	}

}
