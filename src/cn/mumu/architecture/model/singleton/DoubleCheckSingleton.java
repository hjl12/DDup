package cn.mumu.architecture.model.singleton;

import java.io.Serializable;

/**
 * 双重校验单例模式
 * 
 * @author 木木
 *
 */
public class DoubleCheckSingleton  {

	//
	private static volatile DoubleCheckSingleton instance;

	// 私有构造
	private DoubleCheckSingleton() {

	}
	// 获取单例
	public static DoubleCheckSingleton getInstance() {
		if (null != instance) {
			return instance;
		}
		synchronized (DoubleCheckSingleton.class) {
			if (null == instance) {
				instance = new DoubleCheckSingleton();
			}
		}
		return instance;

	}

}
