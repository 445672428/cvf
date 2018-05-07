package com.hibernate.pojo;

/**
 * ProxiesPrivId entity. @author MyEclipse Persistence Tools
 */

public class ProxiesPrivId implements java.io.Serializable {

	// Fields

	private String host;
	private String user;
	private String proxiedHost;
	private String proxiedUser;

	// Constructors

	/** default constructor */
	public ProxiesPrivId() {
	}

	/** full constructor */
	public ProxiesPrivId(String host, String user, String proxiedHost,
			String proxiedUser) {
		this.host = host;
		this.user = user;
		this.proxiedHost = proxiedHost;
		this.proxiedUser = proxiedUser;
	}

	// Property accessors

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getProxiedHost() {
		return this.proxiedHost;
	}

	public void setProxiedHost(String proxiedHost) {
		this.proxiedHost = proxiedHost;
	}

	public String getProxiedUser() {
		return this.proxiedUser;
	}

	public void setProxiedUser(String proxiedUser) {
		this.proxiedUser = proxiedUser;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProxiesPrivId))
			return false;
		ProxiesPrivId castOther = (ProxiesPrivId) other;

		return ((this.getHost() == castOther.getHost()) || (this.getHost() != null
				&& castOther.getHost() != null && this.getHost().equals(
				castOther.getHost())))
				&& ((this.getUser() == castOther.getUser()) || (this.getUser() != null
						&& castOther.getUser() != null && this.getUser()
						.equals(castOther.getUser())))
				&& ((this.getProxiedHost() == castOther.getProxiedHost()) || (this
						.getProxiedHost() != null
						&& castOther.getProxiedHost() != null && this
						.getProxiedHost().equals(castOther.getProxiedHost())))
				&& ((this.getProxiedUser() == castOther.getProxiedUser()) || (this
						.getProxiedUser() != null
						&& castOther.getProxiedUser() != null && this
						.getProxiedUser().equals(castOther.getProxiedUser())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getHost() == null ? 0 : this.getHost().hashCode());
		result = 37 * result
				+ (getUser() == null ? 0 : this.getUser().hashCode());
		result = 37
				* result
				+ (getProxiedHost() == null ? 0 : this.getProxiedHost()
						.hashCode());
		result = 37
				* result
				+ (getProxiedUser() == null ? 0 : this.getProxiedUser()
						.hashCode());
		return result;
	}

}