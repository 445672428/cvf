package com.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexpUtils {


	private RegexpUtils() {
	}

	
	public static final String ICON_REGEXP = "^(/{0,1}//w){1,}//.(gif|dmp|png|jpg)$|^//w{1,}//.(gif|dmp|png|jpg)$";

	
	public static final String EMAIL_REGEXP = "(?://w[-._//w]*//w@//w[-._//w]*//w//.//w{2,3}$)";

	
	public static final String URL_REGEXP = "(//w+)://([^/:]+)(://d*)?([^#//s]*)";

	
	public static final String HTTP_REGEXP = "(http|https|ftp)://([^/:]+)(://d*)?([^#//s]*)";

	
	public static final String DATE_BARS_REGEXP = "^((((19){1}|(20){1})\\d{2})|\\d{2})-[0,1]?\\d{1}-[0-3]?\\d{1}$";  

	
	public static final String DATE_SLASH_REGEXP = "^[0-9]{4}/(((0[13578]|(10|12))/(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)/(0[1-9]|[1-2][0-9]|30)))$";

	
	public static final String PHONE_REGEXP = "^(?:0[0-9]{2,3}[-//s]{1}|//(0[0-9]{2,4}//))[0-9]{6,8}$|^[1-9]{1}[0-9]{5,7}$|^[1-9]{1}[0-9]{10}$";

	
	public static final String ID_CARD_REGEXP = "^//d{10}|//d{13}|//d{15}|//d{18}$";

	
	public static final String ZIP_REGEXP = "^[0-9]{6}$";// 匹配邮编代码

	
	public static final String NON_SPECIAL_CHAR_REGEXP = "^[^'/";
	// 匹配邮编代码

	
	public static final String NON_NEGATIVE_INTEGERS_REGEXP = "^//d+$";

	
	public static final String NON_ZERO_NEGATIVE_INTEGERS_REGEXP = "^[1-9]+//d*$";

	
	public static final String POSITIVE_INTEGER_REGEXP = "^[0-9]*[1-9][0-9]*$";

	
	public static final String NON_POSITIVE_INTEGERS_REGEXP = "^((-//d+)|(0+))$";

	
	public static final String NEGATIVE_INTEGERS_REGEXP = "^-[0-9]*[1-9][0-9]*$";

	
	public static final String INTEGER_REGEXP = "^-?//d+$";

	
	public static final String NON_NEGATIVE_RATIONAL_NUMBERS_REGEXP = "^//d+(//.//d+)?$";

	
	public static final String POSITIVE_RATIONAL_NUMBERS_REGEXP = "^(([0-9]+//.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*//.[0-9]+)|([0-9]*[1-9][0-9]*))$";

	
	public static final String NON_POSITIVE_RATIONAL_NUMBERS_REGEXP = "^((-//d+(//.//d+)?)|(0+(//.0+)?))$";

	
	public static final String NEGATIVE_RATIONAL_NUMBERS_REGEXP = "^(-(([0-9]+//.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*//.[0-9]+)|([0-9]*[1-9][0-9]*)))$";

	
	public static final String RATIONAL_NUMBERS_REGEXP = "^(-?//d+)(//.//d+)?$";

	
	public static final String LETTER_REGEXP = "^[A-Za-z]+$";

	
	public static final String UPWARD_LETTER_REGEXP = "^[A-Z]+$";

	
	public static final String LOWER_LETTER_REGEXP = "^[a-z]+$";

	
	public static final String LETTER_NUMBER_REGEXP = "^[A-Za-z0-9]+$";

	
	public static final String LETTER_NUMBER_UNDERLINE_REGEXP = "^//w+$";

	public static void main(String[] args) {
		String s = "fu.qiu.yue@qweq.com" ;
		String reg = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*$" ;
		// 验证邮箱
		Pattern emial_pattern = Pattern
				.compile(reg);
		Matcher pricess = emial_pattern.matcher(s);
		System.out.println(pricess.matches());
	}


}