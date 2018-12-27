package cn.mumu.architecture.model;

import cn.mumu.architecture.model.singleton.InnerClassSingleton;

public class MumuTest {
	
	
	public static void main(String[] args) {
		InnerClassSingleton instance = InnerClassSingleton.getInstance();
		System.out.println(instance.hashCode());
	}

}
