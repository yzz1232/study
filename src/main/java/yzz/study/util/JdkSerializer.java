package yzz.study.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class JdkSerializer implements Serializer{
	
	
	@Override
	public  byte[] serialize(Object obj) {
		if(obj == null){
			return null;
		}
		if (!(obj instanceof Serializable)) {
			throw new IllegalArgumentException("object of type [" + obj.getClass().getName() + "] is not serializable");
		}
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			oos.flush();
			return  baos.toByteArray();
		} catch (Exception e) {
           e.printStackTrace();
		}finally{
			try {
				if(null != oos){
					oos.close();
				}
				if(null != baos){
					baos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Object deserialize(byte[] bytes) {
		if(bytes == null){
			return null;
		}
		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;
		try {
			bais = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bais);
			return ois.readObject();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(null != ois){
					ois.close();
				}
				if(null != bais){
					bais.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	
}
