package com.weasel.helper;

/**
 * 
 * @author Dylan
 * @time 下午1:34:16
 */
public class StringHelper {

	private StringHelper(){}
	
	
	/**
	 * 
	 * @param message such as : "i am {},i am {}"
	 * @param values such as :"dylan","good"
	 * @return
	 */
	public static String format(String message,String... values){
		StringBuffer buffer = new StringBuffer(message);
		int index = 0;
		int begin = 0;
		int end = 0;
		for(int i=0;i<=buffer.lastIndexOf("{");){
			if(index < values.length){
				begin = buffer.indexOf("{", i);
				end = buffer.indexOf("}", begin);
				String replaced = values[index];
				buffer.replace(begin, end, replaced);
			}
			i=++begin;
			index++;
			
		}
		
		return buffer.toString().replaceAll("\\{|\\}", "");
	}
}
