package cn.gyw.platform.tools.logging.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import cn.gyw.platform.tools.logging.model.RemoteConfig;

public class RemoteSSH {

	private static final String DEFAULT_CHARTSET = "UTF-8";

	private static Connection connection;

	public static boolean login(RemoteConfig config) {
		connection = new Connection(config.getIp());
		try {
			connection.connect();
			return connection.authenticateWithPassword(config.getUsername(), config.getPassword());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static String execute(String cmd) {
		String result = "";
		try {
			Session session = connection.openSession();
			session.execCommand(cmd);
			result = processStdout(session.getStdout(), DEFAULT_CHARTSET);
			if (result.equals("")) {
				result = processStdout(session.getStderr(), DEFAULT_CHARTSET);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static String processStdout(InputStream in, String charset) {
		InputStream stdout = new StreamGobbler(in);
		StringBuilder builder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(stdout, charset))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				builder.append(line + "\n");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
}
