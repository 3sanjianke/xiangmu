package org.shop.utils;

import java.util.HashMap;
import java.util.Map;

public class Msg {

	private int code;
	private String message;
	private Map<String,Object> extend = new HashMap<String,Object>();
	
	public Map<String, Object> getExtend() {
		return extend;
	}
	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public static Msg success() {
		Msg  msg = new Msg();
		msg.code=100;
		msg.message="�����ɹ�";
		return msg;
	}
	
	public static Msg file() {
		Msg  msg = new Msg();
		msg.code=200;
		msg.message="����ʧ��";
		return msg;
	}
	
	public static Msg yanZhenFile() {
		Msg msg = new Msg();
		msg.code=200;
		msg.message="��֤�����";
		return msg;
	}
	public static Msg UnPsFile() {
		Msg msg = new Msg();
		msg.code=200;
		msg.message="�˺Ż�������������µ�½";
		return msg;
	}
	
	public static Msg idCFfile() {
		Msg msg = new Msg();
		msg.code=200;
		msg.message="�Ѵ��ڸñ�ţ����������";
		return msg;
	}
	
	public static Msg nameCFfile() {
		Msg msg = new Msg();
		msg.code=200;
		msg.message="�Ѵ��ڸ����ƣ����������";
		return msg;
	}
	
	public Msg add(String str,Object obj) {
		extend.put(str, obj);
		return this;
	}
}
