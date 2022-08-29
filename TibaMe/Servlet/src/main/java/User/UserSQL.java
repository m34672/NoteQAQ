package User;

public class UserSQL {

	final String GET_ALL = "SELECT * FROM user";

	final String GET_ID = "SELECT * FROM user where USER_ID = ?";

	final String INSERT = "INSERT INTO user (USER_NAME, USER_AGE) VALUES ( ? , ? )";

	final String DELETE = "DELETE FROM user where USER_ID = ?";

}
