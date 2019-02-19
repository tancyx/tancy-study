package com.tancy.desiginPattern.proxy.myProxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class MyProxy {

    private static final String ENTER="\n";
    private static final String TAB="\t";

    public static Object createProxyInstance (Class[] interfaces,MyInvokeHandler invokeHandler){
        StringBuffer sb=new StringBuffer();
        sb.append("package com.tancy.desiginPattern.proxy.myProxy.buildProxy;");
        sb.append(ENTER);
        sb.append("import java.lang.reflect.*;");
        sb.append(ENTER);
        sb.append("import java.lang.Exception;");
        sb.append(ENTER);
        sb.append("import com.tancy.desiginPattern.proxy.myProxy.MyInvokeHandler;");
        sb.append(ENTER);
        sb.append("public class Mproxy implements ");

        sb.append(interfaces[0].getName());

        for (int i = 1; i < interfaces.length; i++) {
            Class clazz=interfaces[i];
            sb.append(","+clazz.getName());
        }
        LinkedList<Method> ml=getMethods(interfaces);
        sb.append(" {");
        sb.append(ENTER);
        sb.append(TAB);
        sb.append("private MyInvokeHandler mi;");
        sb.append(ENTER);
        sb.append("public Mproxy(MyInvokeHandler mi){");
        sb.append(ENTER);
        sb.append(TAB);
        sb.append("this.mi=mi;");
        sb.append(ENTER);
        sb.append("}");
        sb.append(ENTER);
        for (Class anInterface : interfaces) {
            Method[] methods=anInterface.getDeclaredMethods();
            for (Method method : methods) {
//            Type[] types= method.getGenericParameterTypes();
//            StringBuffer methodParams=new StringBuffer();
//            methodParams.append(types[0].getTypeName()+" param0");
//            for (int i = 1; i < types.length; i++) {
//                methodParams.append(","+types[i].getTypeName()+" param"+i);
//            }

                sb.append(TAB+TAB);
                sb.append("public "+method.getReturnType().getSimpleName()+" "+method.getName()+" (){");
                sb.append(ENTER);
                sb.append(TAB+TAB+TAB);
                sb.append("try {");
                sb.append(ENTER);
                sb.append(TAB+TAB+TAB+TAB);
                sb.append("Method method="+anInterface.getName()+".class.getDeclaredMethod(\""+method.getName()+"\");");
                sb.append(ENTER);
                sb.append(TAB+TAB+TAB+TAB);
                sb.append("mi.inovke(method);");
                sb.append(ENTER);
                sb.append(TAB+TAB+TAB);
                sb.append("} catch (Exception e){");
                sb.append(ENTER);
                sb.append(TAB+TAB+TAB+TAB);
                sb.append("e.printStackTrace();");
                sb.append(ENTER);
                sb.append(TAB+TAB+TAB);
                sb.append("}");
                sb.append(ENTER);
                sb.append(TAB+TAB);
                sb.append("}");
            }
        }

        sb.append(ENTER);
        sb.append("}");

        File file= getWriterOut(sb.toString(),"Mproxy");

        JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager= compiler.getStandardFileManager(null,null,null);
        Iterable<? extends JavaFileObject> iterable= fileManager.getJavaFileObjects(file);
        JavaCompiler.CompilationTask task= compiler.getTask(null,fileManager,null,null,null,iterable);
        task.call();
        try {
            fileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Class myProxyClzz= Class.forName("com.tancy.desiginPattern.proxy.myProxy.buildProxy.Mproxy");
            Constructor constructor= myProxyClzz.getDeclaredConstructor(MyInvokeHandler.class);
            return constructor.newInstance(invokeHandler);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
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

    private static File getWriterOut(String clazz,String className){
        Path path= Paths.get("./src/com/tancy/desiginPattern/proxy/myProxy/buildProxy");
        FileWriter fw=null;
        try {
            Path newpath=Files.createDirectories(path);
            File file=new File(newpath+"/"+className+".java");
            fw=new FileWriter(file);
            fw.write(clazz);
            fw.close();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
