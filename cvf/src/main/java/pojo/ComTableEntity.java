package pojo;

import java.util.List;

import com.utils.StringUtils;
import com.utils.TimeUtils;
/**
 * 通用表头数据项封装实体bean
 * @author bobo
 *
 */
public class ComTableEntity {
	private String startTime;
	private String endTime;
	private String authorization;
	private List<DepartMent> departMents;
	public class DepartMent {
		private String departName;
		private String departCode;
		public void setDepartCode(String departCode) {
			this.departCode = departCode;
		}
		public String getDepartCode() {
			return departCode;
		}
		public void setDepartName(String departName) {
			this.departName = departName;
		}
		public String getDepartName() {
			return departName;
		}
		public DepartMent(String departName,String departCode){
			this.departName = departName;
			this.departCode = departCode;
		}
		public DepartMent(){}
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getStartTime() {
		if ("".equals(StringUtils.trim(this.startTime))) {
			return TimeUtils.format(TimeUtils.getCurrYearFirst(), "yyyyMMdd");
		}
		return startTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getEndTime() {
		if ("".equals(StringUtils.trim(this.endTime))) {
			return TimeUtils.getNowTime();
		}
		return endTime;
	}
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}
	public String getAuthorization() {
		return authorization;
	}
	public void setDepartMents(List<DepartMent> departMents) {
		this.departMents = departMents;
	}
	public List<DepartMent> getDepartMents() {
		return departMents;
	}
}
