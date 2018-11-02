package yzz.study.util;



/**
 * 序列化类
    * @ClassName: SerializeUtils
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author Administrator
    * @date 2018年11月2日
    *
 */
public class SerializeUtils {
	
	
public static Serializer serializer;
	
	static{
		if(serializer == null){
			serializer= new Hessian2Serializer();
		}
	}
	
	public static byte[] serialize(Object object){
		return serializer.serialize(object);
	}
	
	public static Object deserialize(byte[] bytes) {
		return serializer.deserialize(bytes);
	}
	
	
}
