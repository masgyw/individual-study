import BaseUsage from './base-usage.vue'
import DemoElContainer from './demo-el-container.vue'

export default [
	{
		path: 'views/element-ui/base-usage',
		name: 'elementui-base-usage',
		component: BaseUsage,
		children: [
			{
				path: 'demo-el-container',
				name: 'demo-el-container',
				component: DemoElContainer
			},
		]
	},
];