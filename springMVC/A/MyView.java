package A;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

/*
 * 自定义视图
 * 
 */
@Component
public class MyView implements View{

	@Override
	public String getContentType() {
		return "text";
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.getWriter().append("hello , I am zyf !");
	}

}
