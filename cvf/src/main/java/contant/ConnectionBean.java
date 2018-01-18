package contant;

import java.io.Serializable;

public class ConnectionBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5230732645647540897L;
	private String className;
	private String url;
	private String userName;
	private String password;
	public ConnectionBean(){}
	
	public ConnectionBean(String className, String url, String userName,
			String password) {
		super();
		this.className = className;
		this.url = url;
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "ConnectionBean [className=" + className + ", url=" + url
				+ ", userName=" + userName + ", password=" + password + "]";
	}

	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
