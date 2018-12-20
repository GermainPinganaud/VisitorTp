package model;

public class Visitor {
		
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getBrowser_version() {
		return browser_version;
	}
	public void setBrowser_version(String browser_version) {
		this.browser_version = browser_version;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getOs_version() {
		return os_version;
	}
	public void setOs_version(String os_version) {
		this.os_version = os_version;
	}
	private String ip;
	private String country;
	private String browser;
	private String browser_version;
	private String os;
	private String os_version;
}
