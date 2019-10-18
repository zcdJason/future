package com.future.express.loader;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.future.express.method.ExpressTransformAtomMethod;
import com.future.express.method.ExpressTransformExtraMethod;
import com.future.express.method.ExpressValidateAtomMethod;
import com.future.express.method.ExpressValidateExtraMethod;
import com.ql.util.express.ExpressRunner;

public class ExpressRunnerLoader {
	
	private ExpressRunner runner;
	private static volatile ExpressRunnerLoader loader;
	
	private ExpressRunnerLoader(){
		this.runner = new ExpressRunner();
	}
	
	/**
	 * 单例模型,双重验证，兼顾性能和多线程安全到解决方案
	 * @return
	 * @throws Exception 
	 */
	public static ExpressRunnerLoader instance() throws Exception{  
        if(null == loader){  
        	synchronized (ExpressRunnerLoader.class) {  
                if (loader == null) {
                	loader = new ExpressRunnerLoader();
                	//加载验证函数方法
                	loader.initValidateMethods();
                	//加载函数
                	loader.initCleanMethods();
                	//从类中加载验证函数方法
                	loader.initMethodsFromClass(ExpressValidateAtomMethod.class);
                	//从类中加载函数方法
                	loader.initMethodsFromClass(ExpressTransformAtomMethod.class);
                	//从类中加载扩展验证函数方法
                	loader.initMethodsFromClass(ExpressValidateExtraMethod.class);
                	//从类中加载扩展函数方法
                	loader.initMethodsFromClass(ExpressTransformExtraMethod.class);
                }
        	}
        }  
        return loader;  
    }
	
	/**
	 * 从类中加载函数方法
	 * @throws Exception
	 */
	private void initMethodsFromClass(Class<?> cls) throws Exception{
		try {
			Method[] methods = cls.getDeclaredMethods();
			for(Method method : methods){
				if(Modifier.isStatic(method.getModifiers()) && Modifier.isPublic(method.getModifiers())){
					Class<?>[] parameterTypes  = method.getParameterTypes();
					String  [] aParameterTypes = new String[parameterTypes.length]; 
					for(int i=0; i<parameterTypes.length; i++){
						aParameterTypes[i] = parameterTypes[i].getSimpleName();
					}
					this.runner.addFunctionOfClassMethod(method.getName(), cls.getName(), method.getName(), aParameterTypes, "[" + method.getName()+"]接口函数处理出现异常，请检查入参是否合理。");
				}
			}
		} catch (Exception e) {
			throw new Exception("验证器初始化函数类["+cls.getName()+"]异常。", e);
		}
	}
	
	/**
	 * 加载验证函数方法
	 * @throws Exception
	 */
	private void initValidateMethods() throws Exception{
		try {
			//加载函数
		} catch (Exception e) {
			throw new Exception("验证器初始化函数方法异常。", e);
		}
	}
	
	/**
	 * 加载验证函数方法
	 * @throws Exception
	 */
	private void initCleanMethods() throws Exception{
		try {
			//加载函数
		} catch (Exception e) {
			throw new Exception("验证器初始化函数方法异常。", e);
		}
	}
	
	/**
	 * 获取实例
	 * @return runner
	 * @throws Exception
	 */
	public ExpressRunner loader(){
		return this.runner;
	}
	
}
