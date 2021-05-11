package cn.com.aaic.policyticker.util;

import java.math.BigDecimal;

public class CalculateUtil {

	/**
	 * float 完整精度相乘
	 * @return
	 */
	public static double bigDecimalMultiply(double a ,double b) {
		BigDecimal bignum1 = new BigDecimal(a); 
		BigDecimal bignum2 = new BigDecimal(b); 
		BigDecimal bignum3 =  bignum1.multiply(bignum2);  
		return Double.parseDouble(bignum3.toString());
	}
	
	/**
	 * float 完整精度相除
	 * @return
	 */
	public static double bigDecimaldivide(double a ,double b) {
		BigDecimal bignum1 = new BigDecimal(a); 
		BigDecimal bignum2 = new BigDecimal(b); 
		BigDecimal bignum3 =  bignum1.divide(bignum2);  
		return Double.parseDouble(bignum3.toString());
	}
	

	
	/**
	 * 3个数 高精度相乘 ,保留2位小数  这块可以优化的 做成通用的 ，入参为一个 List<float>
	 * 留两位小数， 四舍五入
	 * @param a
	 * @param b
	 * @return
	 */
	public static float  bigDecimalMultiply(float a ,float b,float c) {
		BigDecimal bignum1 = new BigDecimal(Float.toString(a)); 
		BigDecimal bignum2 = new BigDecimal(Float.toString(b)); 
		BigDecimal bignum3 = new BigDecimal(Float.toString(c)); 
		BigDecimal sum = bignum1.multiply(bignum2).multiply(bignum3);  
		sum = sum.setScale(2, BigDecimal.ROUND_HALF_UP);
		return Float.parseFloat(sum.toString());
	}
	
}




/**


BigDecimal bignum1 = new BigDecimal("10"); 

BigDecimal bignum2 = new BigDecimal("5"); 

BigDecimal bignum3 = null; 

//加法 

bignum3 =  bignum1.add(bignum2);      

System.out.println("求和：" + bignum3); 

//减法 

bignum3 = bignum1.subtract(bignum2); 

System.out.println("求差：" + bignum3); 

//乘法 

bignum3 = bignum1.multiply(bignum2); 

System.out.println("乘法积：" + bignum3); 

//除法 

bignum3 = bignum1.divide(bignum2); 

System.out.println("除法结果：" + bignum3);  
**/