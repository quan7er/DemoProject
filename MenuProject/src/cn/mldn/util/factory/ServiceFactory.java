package cn.mldn.util.factory;

import cn.mldn.util.service.proxy.ServiceProxy;

public class ServiceFactory {
	@SuppressWarnings("unchecked")
	public static <T> T getInstance(Class<T> cls) {
		try {
			return (T) new ServiceProxy().bind(cls.newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; 
	}
}
