package cn.mldn.util.service.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.mldn.util.dbc.DatabaseConnection;

public class ServiceProxy implements InvocationHandler {
	private Object target; // ��ʵ����
	/**
	 * ���ؽӿڵĴ������
	 * @param target Ҫ�������ҵ������
	 * @return
	 */
	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object retObj = null ;
		try {
			if (method.getName().startsWith("add") || 
					method.getName().startsWith("edit") || 
					method.getName().startsWith("remove")||
					method.getName().startsWith("login")||
					method.getName().startsWith("list")){	// ��Ҫ��������Ŀ��ƴ���
				DatabaseConnection.get().setAutoCommit(false);
				try {
					retObj = method.invoke(this.target, args) ;
					DatabaseConnection.get().commit();
				} catch (Exception e) {
					DatabaseConnection.get().rollback();
					throw e ;
				}
			} else {
				retObj = method.invoke(this.target, args) ;
			}
		} catch (Exception e) {
			throw e ;
		} finally {
			DatabaseConnection.close(); // �������һ��Ҫ�������ݿ�Ĺر�
		} 
		return retObj ;
	}
}
