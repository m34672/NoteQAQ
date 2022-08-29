package User;

import java.util.Map;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

import common.Result;

public class UserService {

	Result _result = null;
	UserDao dao = null;

	UserService() {
		dao = new UserDao();
		_result = new Result();
	}

	private Result isFail(Map<String, Object> data) {

		// 判斷
		if (data.get("data") != null)
			return _result.success(data.get("data"));

		return _result.fail((String) data.get("error"));
	}

	public Result getAll(String id) {
		// 判斷
		if (id == null)
			return isFail(dao.getAll());

		return isFail(dao.getId(Integer.parseInt(id)));

	}

	public Result insert(String name, Integer age) {
		return isFail(dao.insert(name, age));
	}
	
	public Result delete(String id) {
		return isFail(dao.delete(Integer.parseInt(id)));
	}
	
	
}
