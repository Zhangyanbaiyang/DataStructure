/**
 * 
 */
package cn.zy.Regex;

import java.util.regex.*;

/**
 * 检验正则表达式  java->linux
 * @author zy
 * 2017年5月10日
 */
public class PatternDemo {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Pattern pattern = Pattern.compile("a*b");
		System.out.println(pattern.toString());
		Matcher matcher = pattern.matcher("aaaaab");
		System.out.println(matcher);
		System.out.println(matcher.matches());
		
		System.out.println(Pattern.matches("a*b", "aaaaab"));
		*/
		
		//邮箱正则表达式验证
		System.out.println("----------邮箱正则表达式验证---------------");
		//String regEx = "^[a-zA-Z0-9_]+@[a-zA-Z0-9_]+[_.]+[a-zA-Z0-9_]+$";
		String regEx = "^[A-Za-z\\d]+([-_\\.][A-Za-z\\d]+)*@";
		Pattern p = Pattern.compile(regEx);
		System.out.println(p.toString());
		Matcher matcher = p.matcher("119252.8707@qq.com.cn");
		System.out.println(matcher.matches());
		
		
		//邮政编码
		System.out.println("----------邮政编码---------------");
		String regEx1 = "^[1-9]\\d{5}$";
		Pattern p1 = Pattern.compile(regEx1);
		System.out.println(p1.toString());
		Matcher matcher1 = p1.matcher("414500");
		System.out.println(matcher1.matches());
		
		//手机号码
		System.out.println("----------手机号码验证---------------");
		//^1[3|4|5|7|8][0-9]\d{8}$ 
		String regEx2 = "^1[3|5|7|8]\\d{9}$";
		Pattern p2 = Pattern.compile(regEx2);
		System.out.println(p2.toString());
		Matcher matcher2 = p2.matcher("13521064470");
		System.out.println(matcher2.matches());
		
		//QQ号码
		System.out.println("----------QQ号码验证---------------");
		//^1[3|4|5|7|8][0-9]\d{8}$ 
		String regEx3 = "^[1-9]\\d{4,10}$";
		Pattern p3 = Pattern.compile(regEx3);
		System.out.println(p3.toString());
		Matcher matcher3 = p3.matcher("11210");
		System.out.println(matcher3.matches());
		
		//网址校验
		
	}

}
