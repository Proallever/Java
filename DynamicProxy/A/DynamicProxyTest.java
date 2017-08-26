package A;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest implements InvocationHandler{
	private Object toProxy;
	
	public Object bind(Object toProxy){
		this.toProxy = toProxy;
		return Proxy.newProxyInstance(toProxy.getClass().getClassLoader(), 
									  toProxy.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Proxy...");
		//TODO ������Ҫ��������д�����������spring��AOP
		return method.invoke(toProxy,args);
	}
	
	public static void main(String[] args) {
		Book book = (Book)new DynamicProxyTest().bind(new BookImpl());
		book.read();
	}
	
}
