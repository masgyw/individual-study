package cn.gyw.platform.tools.logging;

import cn.gyw.platform.tools.logging.constants.Common;
import cn.gyw.platform.tools.logging.service.GanymedRemoteService;
import cn.gyw.platform.tools.logging.service.IRemoteService;
import cn.gyw.platform.tools.logging.support.ConfigLoader;

public class LoggingToolsApplication {

	public static void main(String[] args) {
		IRemoteService remoteService = new GanymedRemoteService();
		remoteService.login(ConfigLoader.INSTANCE.getRemoteConfig());

		String remoteFiles = ConfigLoader.INSTANCE.get(Common.PropertyKey.DOWNLOAD_REMOTE_FILES);
		String localDir = ConfigLoader.INSTANCE.get(Common.PropertyKey.DOWNLOAD_LOCAL_DIR);
		remoteService.download(remoteFiles.split(","), localDir);

	}
}
