package pojo;

import java.io.Serializable;
import java.util.Date;

public class Image implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4989534355882100534L;

	private String id;
	
	private String name;
	
	private String url;
	//'1代表女0代表男2代表人妖'
	private Integer code;
	//'1-16(1),17-26(2),27-35(3),36-42(4),43-50(5),50-60(6),60以上(7)'
	private Integer tag;
	
	private String appname;
	//'是否可用'
	private Integer flag;
	
	private Date createtime;
	
	private Date updatetime;
}
