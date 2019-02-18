package com.tancy.desiginPattern.proxy.myProxy;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class MyProxy {

    private static final String ENTER="\n";
    private static final String TAB="\t";

    public static Object createProxyInstance(Class[] interfaces,MyInvokeHandler invokeHandler){
        StringBuffer sb=new StringBuffer();
        sb.append("package com.tancy.desiginPattern.proxy.myProxy;");
        sb.append(ENTER);
        sb.append("import java.lang.reflect.*;");
        sb.append(ENTER);
        sb.append("public class Mproxy implements ");
        sb.append(interfaces[0].getSimpleName());

        for (int i = 1; i < interfaces.length; i++) {
            Class clazz=interfaces[i];
            sb.append(","+clazz.getSimpleName());
        }
        LinkedList<Method> ml=getMethods(interfaces);
        sb.append(" {");
        sb.append(ENTER);

        for (Method method : ml) {
            sb.append("public "+method.getReturnType().getSimpleName()+" "+method.getName()+"{");

            sb.append(ENTER);
            sb.append("}");
        }

        sb.append(ENTER);
        sb.append("}");
        return null;
    }

    private static LinkedList<Method> getMethods(Class[] interfaces){
        LinkedList<Method> ml=new LinkedList();
        for (Class clazz : interfaces) {
            Method[] methods=clazz.getDeclaredMethods();
            for (Method method : methods) {
               ml.add(method);
            }
        }
        return ml;
    }

}
