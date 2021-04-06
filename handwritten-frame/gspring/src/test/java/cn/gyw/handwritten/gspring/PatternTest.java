package cn.gyw.handwritten.gspring;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

public class PatternTest {

	@Test
	public void test() {
		String regex = "\\$\\{[\\w]+\\}";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		
		String line = "1234${name}56789${age}";
		Matcher matcher = pattern.matcher(line);
		
		while (matcher.find()) {
			System.out.println(matcher.group());
			line.replaceFirst(matcher.group(), "abc");
		}
		
		System.out.println(line);
	}
}
