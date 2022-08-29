package User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Gson _gson = new Gson();
	private UserService service = new UserService();

	/*
	 * Get
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		setHeaders(resp);
		PrintWriter out = resp.getWriter();

		out.print(_gson.toJson(service.getAll(req.getParameter("id"))));
	}

	/*
	 * Post
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		setHeaders(resp);
		PrintWriter out = resp.getWriter();

		BufferedReader read = req.getReader();

		String json = read.readLine();

		// 不建議使用
//		Map<Object, String> map = gs.fromJson(json, new TypeToken<Map<String, String>>() {
//		}.getType());

		// 建議使用
		User user = _gson.fromJson(json, new TypeToken<User>() {
		}.getType());

		read.close();

		out.print(_gson.toJson(service.insert(user.getName(), user.getAge())));
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		setHeaders(resp);
		PrintWriter out = resp.getWriter();
		String pathInfo = req.getPathInfo();

		String[] splits = pathInfo.split("/");
		out.print(_gson.toJson(service.delete(splits[1])));
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setHeaders(resp);
	}

	/*
	 * 誇域
	 */
	private void setHeaders(HttpServletResponse response) {
		// 重要
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Cache-control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");

		// 重要
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "*");
		response.addHeader("Access-Control-Allow-Headers", "*");
		response.addHeader("Access-Control-Max-Age", "86400");
	}

}
