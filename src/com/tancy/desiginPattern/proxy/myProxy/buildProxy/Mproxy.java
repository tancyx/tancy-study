package com.tancy.desiginPattern.proxy.myProxy.buildProxy;
import java.lang.reflect.*;
import java.lang.Exception;
import com.tancy.desiginPattern.proxy.myProxy.MyInvokeHandler;
public class Mproxy implements com.tancy.desiginPattern.proxy.WineProduct {
	private MyInvokeHandler mi;
	public Mproxy(MyInvokeHandler mi){
		this.mi=mi;
	}
	public void sell (){
		try {
			Method method=com.tancy.desiginPattern.proxy.WineProduct.class.getDeclaredMethod("sell");
			mi.inovke(method);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}