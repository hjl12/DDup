package cn.mumu.architecture.model.singleton;

public class HungrySingleton {

	private static final HungrySingleton instance = new HungrySingleton();

	// 私有构造
	private HungrySingleton() {

	}

	public HungrySingleton getInstance() {
		return instance;
	}

}
