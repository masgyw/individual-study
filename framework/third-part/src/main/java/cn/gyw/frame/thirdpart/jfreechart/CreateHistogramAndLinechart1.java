package cn.gyw.frame.thirdpart.jfreechart;

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
import java.util.List;
import java.util.*;

@SuppressWarnings("all")
public class CreateHistogramAndLinechart1 {

	private static JFreeChart chart;

	// 折线图数据
	private static CategoryDataset datasetLine;

	// 柱状图数据
	private static CategoryDataset datasetHistogram;

	// 柱状图最大值
	private static Double leftMaxValue;

	// 折线图Y轴右边最大值
	private static Double rightMaxValue;


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

	public static void create(List<Map<String, Object>> data,
			String title, String path,
			int weight, int height, String yName, boolean isShowNumber) throws Exception {
		mapToDataSet(data);
		createChart(title, yName, isShowNumber);
		FileOutputStream out = new FileOutputStream(path);
		ChartUtilities.writeChartAsPNG(out, chart, weight, height);
		out.flush();
		out.close();
	}

	private static void mapToDataSet(List<Map<String, Object>> data) {
		rightMaxValue = 0D;
		leftMaxValue = 0D;
		DefaultCategoryDataset dcdLine = new DefaultCategoryDataset();
		DefaultCategoryDataset dcdHistogram = new DefaultCategoryDataset();
		for(Map<String, Object> map : data) {
			 String day= map.get("START_TIME").toString().split("-")[2];
			dcdHistogram.addValue(Double.valueOf(map.get("O_SEIZE_TRAF").toString()), "主叫话务情况分析(erl)     ",day );
			dcdHistogram.addValue(Double.valueOf(map.get("O_CALL_SEIZE").toString()), "主叫占用次数      ", day);
			dcdHistogram.addValue(Double.valueOf(map.get("I_SEIZE_TRAF").toString()), "被叫话务情况分析(erl)     ", day);
			dcdHistogram.addValue(Double.valueOf(map.get("I_CALL_SEIZE").toString()), "被叫占用次数             ",day);
			if(leftMaxValue < Double.valueOf(map.get("I_CALL_SEIZE").toString()))
				leftMaxValue = Double.valueOf(map.get("I_CALL_SEIZE").toString())*100;

			dcdLine.addValue(Double.valueOf(map.get("O_CALL_RATIO").toString()), "主叫接通率       ", day);
			dcdLine.addValue(Double.valueOf(map.get("I_CALL_RATIO").toString()), "被叫接通率", day);
		/*	if(rightMaxValue < Double.valueOf(map.get("I_CALL_RATIO").toString()))
				rightMaxValue = Double.valueOf(map.get("I_CALL_RATIO").toString());*/
		}
//		rightMaxValue = rightMaxValue * 1.2; //最大值的1.2倍
		datasetLine = dcdLine;
		datasetHistogram = dcdHistogram;
	}


	private static void createChart(String title, String yName,
			boolean isShowNumber) {
		//System.out.println("left: " + leftMaxValue);
		//System.out.println("right: " + rightMaxValue);
		rightMaxValue = 110.0;
		chart = ChartFactory.createBarChart(title, null, null, datasetHistogram,
				PlotOrientation.VERTICAL, true, true, false);
		chart.setBackgroundPaint(Color.WHITE);
		setChartFont(yName);
		CategoryPlot cp = chart.getCategoryPlot();
		ValueAxis va = cp.getRangeAxis();
		// 设置最高的一个 Item 与图片顶端的距离
		va.setUpperMargin(0.40);
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
		// 把颜色加上去
		renderer.setSeriesPaint(0, gradientpaint); // 给series1 Bar
		renderer.setSeriesPaint(1, gradientpaint1); // 给series2 Bar
		renderer.setSeriesPaint(2, gradientpaint2); // 给series3 Bar

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
		//numberaxisY.setUpperMargin(9.90);
		// 数据为0
		double size = 1D;
		if(rightMaxValue <= 0) {
			numberaxisY.setRange(0, 100);//刻度范围
			size = Math.floor(20);//刻度的长度
		} else {
			size = rightMaxValue / 5;
			numberaxisY.setRange(0.0, rightMaxValue); // 刻度范围
		}
		NumberTickUnit tickUnit = new NumberTickUnit(size);// 刻度的长度
		numberaxisY.setTickUnit(tickUnit);
		numberaxisY.setLabel("单位(%)");
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

	private static void setChartFont(String yName) {
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
		if(yName != null)
			va.setLabel(yName);
		chart.getLegend().setItemFont(font);
	}

	public static String create(List<Map<String, Object>> data, String title,
			int weight, int height, String yName, boolean isShowNumber) throws IOException {
		mapToDataSet(data);
		createChart(title, yName, isShowNumber);
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


	public static void main(String[] args) {
		System.out.println("------------");
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		Map<String, Object> a = new HashMap<String, Object>();
		a.put("I_SEIZE_TRAF", "34.32");
		a.put("I_CALL_SEIZE", "303");
		a.put("I_CALL_RATIO", "97.03");
		a.put("O_SEIZE_TRAF", "112.65");
		a.put("O_CALL_SEIZE", "1079");
		a.put("O_CALL_RATIO", "100");
		a.put("X", "1");
		data.add(a);
		Map<String, Object> b = new HashMap<String, Object>();
		b.put("I_SEIZE_TRAF", "56.79");
		b.put("I_CALL_SEIZE", "439");
		b.put("I_CALL_RATIO", "95.44");
		b.put("O_SEIZE_TRAF", "168.6");
		b.put("O_CALL_SEIZE", "1477");
		b.put("O_CALL_RATIO", "100");
		b.put("X", "2");
		data.add(b);
		Map<String, Object> c = new HashMap<String, Object>();
		c.put("I_SEIZE_TRAF", "45.7");
		c.put("I_CALL_SEIZE", "361");
		c.put("I_CALL_RATIO", "94.18");
		c.put("O_SEIZE_TRAF", "173.54");
		c.put("O_CALL_SEIZE", "1515");
		c.put("O_CALL_RATIO", "99.8");
		c.put("X", "3");
		data.add(c);
	}
}