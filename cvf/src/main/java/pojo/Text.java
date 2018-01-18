package pojo;

import java.io.Serializable;
/**
 * @Table -> personal
 * @author bobo
 *
 */
public class Text implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 711939286306294831L;

	
	private String id;
	
	private String name;
	
	private String information;
	
	private String introduction;
	
	private String birthday;
	
	private String place;
	
	private Integer age = new Integer(0);
	
	private String nationality;
	
	private String nativePlace;
	
	private Integer flag = new Integer(0);
	
	private String role;
	
	
}
