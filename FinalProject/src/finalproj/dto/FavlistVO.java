package finalproj.dto;

public class FavlistVO {
	private int snum;
	private String cpnum,fmemo;
	
	public String getFmemo() {
		return fmemo;
	}
	public void setFmemo(String fmemo) {
		this.fmemo = fmemo;
	}
	/**
	 * @return the snum
	 */
	public int getSnum() {
		return snum;
	}
	/**
	 * @param snum the snum to set
	 */
	public void setSnum(int snum) {
		this.snum = snum;
	}
	/**
	 * @return the cpnum
	 */
	public String getCpnum() {
		return cpnum;
	}
	/**
	 * @param cpnum the cpnum to set
	 */
	public void setCpnum(String cpnum) {
		this.cpnum = cpnum;
	}
	
	
}
