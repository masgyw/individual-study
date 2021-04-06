package cn.gyw.handwritten.gspring.web.servlet;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;
import java.util.RandomAccess;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * web交互的MVC视图
 */
public class GView {

	private final static String DEFAULT_CONTENT_TYPE = "text/html;charset=utf-8";
	
	private File viewFile;

	public GView(File viewFile) {
		this.viewFile = viewFile;
	}

	public GView() {
	}

	/**
	 * 渲染指定模型的视图
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		StringBuilder sb = new StringBuilder();
		
		RandomAccessFile accessFile = new RandomAccessFile(this.viewFile, "r");
		
		String regex = "$\\{[\\w]+\\}";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher;
		String line;
		while((line = accessFile.readLine()) != null) {
			line = new String(line.getBytes("ISO-8859-1"), "utf-8");
			matcher = pattern.matcher(line);
			while (matcher.find()) {
				
			}
		}
		
		response.setCharacterEncoding("utf-8");
		response.setContentType(DEFAULT_CONTENT_TYPE);
		response.getWriter().write(sb.toString());
	}

	public String getContentType() {
		return null;
	}

}
