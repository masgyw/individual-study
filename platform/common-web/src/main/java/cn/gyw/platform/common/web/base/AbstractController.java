package cn.gyw.platform.common.web.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.context.request.WebRequest;

public abstract class AbstractController {
	
	protected Map<String, String> fillVariablesMapWithIncomingRequestParameters(WebRequest webRequest) {
		return this.fillVariablesMapWithIncomingRequestParameters(webRequest.getParameterMap());
	}

	protected Map<String, String> fillVariablesMapWithIncomingRequestParameters(Map<String, String[]> requestParams) {
		Map<String, String> variableMap = new HashMap<>();
		for (Map.Entry<String, String[]> entry : requestParams.entrySet()) {
			if (!entry.getKey().startsWith("javax")) {
				variableMap.put(entry.getKey(), entry.getValue()[0]);
			}
		}
		return variableMap;
	}

	protected Date parseDate(String dateStr) {
		SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return dateSdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
