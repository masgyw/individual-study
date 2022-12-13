package cn.gyw.corejava.exceptions;

import org.junit.jupiter.api.Test;

public class ExceptionTest {

	@Test
	public void tryCatchFinally() {
		System.out.println(doWithTry());
	}
	
	private Object doWithTry() {
		Object ret = 0;
		try {
			ret = 1;
			return ret;
		} catch (Exception e) {
			return 2;
		} finally {
			ret = 3;
		}
	}
}
