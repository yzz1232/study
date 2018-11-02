package yzz.study.util;

/**
 * 
    * @ClassName: Serializer
    * @Description: 序列化接口
    * @author yzz
    * @date 2018年11月2日
    *
 */
public interface Serializer {
	
	byte[] serialize(Object obj);
	
	Object deserialize(byte[] bytes);
	
}
