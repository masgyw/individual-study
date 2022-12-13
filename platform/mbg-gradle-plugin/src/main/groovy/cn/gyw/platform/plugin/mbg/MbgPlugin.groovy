package cn.gyw.platform.plugin.mbg

import org.gradle.api.Plugin
import org.gradle.api.Project

import cn.gyw.platform.plugin.mbg.extension.FtlExtension
import cn.gyw.platform.plugin.mbg.extension.MbgExtension
import cn.gyw.platform.plugin.mbg.extension.JdbcExtension
import cn.gyw.platform.plugin.mbg.extension.XmlExtension

class MbgPlugin implements Plugin<Project> {

	@Override
	public void apply(Project project) {
		project.extensions.create("mbg", MbgExtension)

		project.mbg.extensions.create("jdbc", JdbcExtension)
		project.mbg.extensions.create("xml", XmlExtension)
		project.mbg.extensions.create("ftl", FtlExtension)

		project.task("mbg", type: MbgTask)
	}
}
