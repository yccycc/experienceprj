ldpi：240x320

mdpi：320x480
hdpi：480x800、480x854
xhdpi：至少960*720
xxhdpi：1280×720
//  // TODO Auto-generated method stub

  mPaint.setColor(Color.RED);
  //设置字体大小
  mPaint.setTextSize(100);

  //让画出的图形是空心的
  mPaint.setStyle(Paint.Style.STROKE);
  //设置画出的线的 粗细程度
  mPaint.setStrokeWidth(5);
  //画出一根线
  canvas.drawLine(0, 0, 200, 800, mPaint);

  //画矩形
  canvas.drawRect(200, 300, 300, 320, mPaint);

  //画圆
  canvas.drawCircle(200, 800, 100, mPaint);
  //画出字符串 drawText(String text, float x, float y, Paint paint)
  // y 是 基准线 ，不是 字符串的 底部
  canvas.drawText("apple", 60, 600, mPaint);
  canvas.drawLine(60, 60, 500, 60, mPaint);

  //绘制图片
  canvas.drawBitmap(mBitmap, 150, 150, mPaint);
//
  mPaint.setColor(Color.RED);
        //实心
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(getWidth()/2, getHeight()/2, 100, mPaint);
        ??????????????????????????????????????????????
package com.yctech.myapp;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import java.util.ArrayList;
import java.util.List;

public class SimpleBarChart extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_bar_chart);

        String[] titles = new String[] { "2008", "2007" };
        List<double[]> values = new ArrayList<double[]>();
        values.add(new double[] { 14230, 12300, 14240, 15244, 15900, 19200, 22030, 21200, 19500, 15500,
                12600, 14000 });
        values.add(new double[] { 5230, 7300, 9240, 10540, 7900, 9200, 12030, 11200, 9500, 10500,
                11600, 13500 });
        int[] colors = new int[] { Color.BLUE, Color.CYAN };
        XYMultipleSeriesRenderer renderer = buildBarRenderer(colors);
        setChartSettings(renderer, "Monthly sales in the last 2 years", "Month", "Units sold", 0.5,
                12.5, 0, 24000, Color.GRAY, Color.LTGRAY);
        ((XYSeriesRenderer) renderer.getSeriesRendererAt(0)).setDisplayChartValues(true);
        ((XYSeriesRenderer) renderer.getSeriesRendererAt(1)).setDisplayChartValues(true);
        renderer.setXLabels(12);
        renderer.setYLabels(10);
        renderer.setXLabelsAlign(Paint.Align.LEFT);
        renderer.setYLabelsAlign(Paint.Align.LEFT);
        renderer.setPanEnabled(true, false);
        // renderer.setZoomEnabled(false);
        renderer.setZoomRate(1.1f);
        renderer.setBarSpacing(0.5f);
        View view = ChartFactory.getBarChartView(getApplicationContext(),
                buildBarDataset(titles, values), renderer, org.achartengine.chart.BarChart.Type.DEFAULT);
        renderer.setClickEnabled(true);
        setContentView(view);
    }
    protected XYMultipleSeriesRenderer buildBarRenderer(int[] colors) {
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
        renderer.setAxisTitleTextSize(16);
        renderer.setChartTitleTextSize(20);
        renderer.setLabelsTextSize(15);
        renderer.setLegendTextSize(15);
        int length = colors.length;
        for (int i = 0; i < length; i++) {
            XYSeriesRenderer r = new XYSeriesRenderer();
            r.setColor(colors[i]);
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    }
    protected void setChartSettings(XYMultipleSeriesRenderer renderer, String title, String xTitle,
                                    String yTitle, double xMin, double xMax, double yMin, double yMax, int axesColor,
                                    int labelsColor) {
        renderer.setChartTitle(title);
        renderer.setXTitle(xTitle);
        renderer.setYTitle(yTitle);
        renderer.setXAxisMin(xMin);
        renderer.setXAxisMax(xMax);
        renderer.setYAxisMin(yMin);
        renderer.setYAxisMax(yMax);
        renderer.setAxesColor(axesColor);
        renderer.setLabelsColor(labelsColor);
    }
    protected XYMultipleSeriesDataset buildBarDataset(String[] titles, List<double[]> values) {
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        int length = titles.length;
        for (int i = 0; i < length; i++) {
            CategorySeries series = new CategorySeries(titles[i]);
            double[] v = values.get(i);
            int seriesLength = v.length;
            for (int k = 0; k < seriesLength; k++) {
                series.add(v[k]);
            }
            dataset.addSeries(series.toXYSeries());
        }
        return dataset;
    }

}
?????????????????????????????????????????????????????????????????????????????????????????????


