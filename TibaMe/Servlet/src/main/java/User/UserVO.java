package User;

public class UserVO {

	private Integer userNo;
	private String userName;
	private Integer userAge;

	public Integer getUserAge() {
		return userAge;
	}
	public String getUserName() {
		return userName;
	}
	public Integer getUserNo() {
		return userNo;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}
}
