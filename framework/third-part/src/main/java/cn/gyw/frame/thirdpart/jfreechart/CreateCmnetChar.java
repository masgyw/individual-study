package cn.gyw.frame.thirdpart.jfreechart;

import org.apache.commons.lang3.StringUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Base64;
import java.util.List;

public class CreateCmnetChar {

	private static JFreeChart chart;

	// 折线图数据
	private static CategoryDataset datasetLine;

	// 柱状图数据
	private static CategoryDataset datasetHistogram;

	// 柱状图最大值
	private static Double leftMaxValue;

	// 折线图Y轴右边最大值
	private static Double rightMaxValue;

	/**
	 * @param
	 * 		listsLine  折线图数据
	 * @param
	 * 		listsHistogram   柱状图数据
	 * @param
	 * 		title      标题
	 * @param
	 * 		path       生成图片路径
	 * @param
	 * 		weight     生成图片宽度
	 * @param
	 * 		height     生成图片高度
	 * @param
	 * 		leftUtil   左边的单位
	 * @param
	 * 		rightUtil  右边的单位
	 * @param
	 * 		isShowNumber   是否展示数据
	 *
	 * */
	public static void create(List<CharSet> listsLine, List<CharSet> listsHistogram, String title, String path,
			int weight, int height, String leftUtil, String rightUtil, boolean isShowNumber) throws Exception {
//		if(listsLine.size() < 1 && listsHistogram.size() < 1)
//			throw new Exception("数据不存在, 无法生成图片");
		getDataset(listsLine, listsHistogram);
		createChart(title, isShowNumber, leftUtil, rightUtil);
		FileOutputStream out = new FileOutputStream(path);
		ChartUtilities.writeChartAsPNG(out, chart, weight, height);
		out.flush();
		out.close();
	}

	public static String create(List<CharSet> listsLine, List<CharSet> listsHistogram, String title,
			int weight, int height, String leftUtil, String rightUtil, boolean isShowNumber) throws Exception {
		getDataset(listsLine, listsHistogram);
		createChart(title, isShowNumber, leftUtil, rightUtil);
		PipedInputStream in = null;
		PipedOutputStream out = null;
		try {
			in = new PipedInputStream(50000);
			out = new PipedOutputStream(in);
			ChartUtilities.writeChartAsPNG(out, chart, weight, height);
			return getImageBySystemOut(in);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (in != null)
				in.close();
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}

	@SuppressWarnings("restriction")
	private static String getImageBySystemOut(PipedInputStream in) {
		byte[] data = null;
		// 读取图片字节数组
		try {
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组Base64编码
		Base64.Encoder encoder = Base64.getEncoder();
		return encoder.encodeToString(data);// 返回Base64编码过的字节数组字符串
	}

	/**
	 *
	 * */
	private static void createChart(String title, boolean isShowNumber, String leftUtil, String rightUtil) {
		chart = ChartFactory.createBarChart(title, null, null, datasetHistogram,
				PlotOrientation.VERTICAL, true, true, false);
		chart.setBackgroundPaint(Color.WHITE);
		setChartFont(leftUtil);
		CategoryPlot cp = chart.getCategoryPlot();
		ValueAxis va = cp.getRangeAxis();
		// 设置最高的一个 Item 与图片顶端的距离
		va.setUpperMargin(0.20);
		// 设置最低的一个 Item 与图片底端的距离
		va.setLowerMargin(0.10);
		// 数据为0
		if(leftMaxValue == 0) {
			// 一系列设置
			va.setLowerBound(0);
			va.setUpperBound(5);;
		}
		cp.setRangeAxis(va);
		cp.setForegroundAlpha(1.0f);
		// 背景色 透明度
		cp.setBackgroundAlpha(0.5f);
		cp.setRangeGridlinesVisible(true);
		cp.setRangeGridlinePaint(Color.BLUE);
		cp.setBackgroundPaint(new Color(255, 255, 204));
		//设置bar显示, 如果加入则自动变为2D图
		BarRenderer renderer = new BarRenderer();
		GradientPaint gradientpaint = new GradientPaint(0.0F, 0.0F, Color.blue,
				0.0F, 0.0F, new Color(0, 0, 64)); // 设定特定颜色,三种:蓝色,绿色,红色
		GradientPaint gradientpaint1 = new GradientPaint(0.0F, 0.0F, Color.green,
				0.0F, 0.0F, new Color(0, 64, 0));
		GradientPaint gradientpaint2 = new GradientPaint(0.0F, 0.0F, Color.red,
				0.0F, 0.0F, new Color(64, 0, 0));
		GradientPaint gradientpaint3 = new GradientPaint(0.0F, 0.0F, Color.orange,
				0.0F, 0.0F, new Color(64, 0, 0));
		// 把颜色加上去
		renderer.setSeriesPaint(0, gradientpaint); // 给series1 Bar
		renderer.setSeriesPaint(1, gradientpaint1); // 给series2 Bar
		renderer.setSeriesPaint(2, gradientpaint2); // 给series3 Bar
		renderer.setSeriesPaint(3, gradientpaint3); // 给series4 Bar
		// 设置平行柱之间距离
		renderer.setItemMargin(0.1);
		cp.setRenderer(renderer);
		//显示每个柱的数值, 并修改该数值的字体属性
		if(isShowNumber) {
			renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			renderer.setBaseItemLabelsVisible(true);
			renderer.setItemLabelAnchorOffset(10D);// 设置柱形图上的文字偏离值
			cp.setForegroundAlpha((float) 0.85);
		}
		// 创建折线图
		CategoryDataset categorydataset = datasetLine;
		/*------设置Y轴----*/
		// 右边Y轴, 相关属性设置
		NumberAxis numberaxisY = new NumberAxis();
		// 数据为0
		double size = 1D;
		if(rightMaxValue <= 0) {
			numberaxisY.setRange(0, 100);//	刻度范围
			size = Math.floor(20);// 刻度的长度
		} else {
			size = rightMaxValue / 5;
			numberaxisY.setRange(0.0, rightMaxValue); // 刻度范围
		}
		NumberTickUnit tickUnit = new NumberTickUnit(size);// 刻度的长度
		numberaxisY.setTickUnit(tickUnit);
		if(StringUtils.isNotEmpty(rightUtil))// 设置单位
			numberaxisY.setLabel(rightUtil);
        cp.setRangeAxis(1, numberaxisY);
		cp.setDataset(1, categorydataset);
		// 显示折线图, 0, 0坐标轴都在左侧
		cp.mapDatasetToRangeAxis(1, 1);
		CategoryAxis categoryaxis = cp.getDomainAxis();
		categoryaxis.setMaximumCategoryLabelWidthRatio(4f);
		// 画折线图
		LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();
		// 显示数值
		lineandshaperenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		lineandshaperenderer.setBaseItemLabelsVisible(true);
		cp.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);// 设置折线图显示在柱形图上面
		BasicStroke realLine = new BasicStroke(2.0f); // 设置实线
		lineandshaperenderer.setSeriesStroke(0, realLine);
		cp.setRenderer(1, lineandshaperenderer);
	}

	/**
	 * 设置字体
	 * */
	private static void setChartFont(String leftUtil) {
		Font title = new Font("宋体", Font.PLAIN, 15);
		Font font = new Font("宋体", Font.PLAIN, 13);
		// 标题
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(title);
		CategoryPlot plot = chart.getCategoryPlot();
		CategoryAxis ca = plot.getDomainAxis();
		// 设置X轴坐标上的文字
		ca.setTickLabelFont(font);
		// 设置X轴的标题文字
		ca.setLabelFont(font);
		ValueAxis va = plot.getRangeAxis();
		// 设置Y轴坐标上的文字
		va.setTickLabelFont(font);
		// 设置Y轴的标题文字
		va.setLabelFont(font);
		if(StringUtils.isNotEmpty(leftUtil))
			va.setLabel(leftUtil);
		chart.getLegend().setItemFont(font);
	}

	/**
	 * 获取数据, 数据整理, 并设置y轴最大值
	 * */
	private static void getDataset(List<CharSet> listsLine,
			List<CharSet> listsHistogram) {
		rightMaxValue = 0D;
		leftMaxValue = 0D;
		DefaultCategoryDataset dcdLine = new DefaultCategoryDataset();
		for(CharSet cs : listsLine) {
			dcdLine.addValue(cs.getValue(), cs.getRowKey(), cs.getColumKey());
			if(rightMaxValue < cs.getValue())
				rightMaxValue = cs.getValue();
		}
		rightMaxValue = rightMaxValue * 1.2; //最大值的1.2倍
		datasetLine = dcdLine;

		DefaultCategoryDataset dcdHistogram = new DefaultCategoryDataset();
		for(CharSet cs : listsHistogram) {
			dcdHistogram.addValue(cs.getValue(), cs.getRowKey(), cs.getColumKey());
			if(leftMaxValue < cs.getValue())
				leftMaxValue = cs.getValue();
		}
		leftMaxValue = leftMaxValue * 1.2; //最大值的1.2倍
		datasetHistogram = dcdHistogram;
	}

}