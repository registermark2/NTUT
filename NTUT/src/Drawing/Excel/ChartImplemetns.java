package Drawing.Excel;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.charts.AxisPosition;
import org.apache.poi.ss.usermodel.charts.LegendPosition;

public class ChartImplemetns {
	private int startRow = 0;
	private int startColumn = 0;
	private int chartWidth = 15;
	private int chartHeight = 10;
	private String selectedSheet = "";
	private Boolean setSmooth = true;

	private Boolean xAxis = false;
	private double xMax = 0;
	private double xMin = 0;

	private Boolean yAxis = false;
	private double yMax = 0;
	private double yMin = 0;

	private String chartTitle = "";

	private int[] xBarRange;
	private List<String> seriesName = new ArrayList<String>();
	private List<Integer[]> yBarRange = new ArrayList<Integer[]>();
	private LegendPosition legendPosition = LegendPosition.RIGHT;
	private AxisPosition yBarPosition = AxisPosition.LEFT;
	private AxisPosition xBarPosition = AxisPosition.BOTTOM;

	public void setStartPoint(int startRow, int startColumn) {
		this.startRow = startRow;
		this.startColumn = startColumn;
	}

	public void setChartSize(int chartWidth, int chartHeight) {
		this.chartHeight = chartHeight;
		this.chartWidth = chartWidth;
	}

	public void setLgendPosition(LegendPosition position) {
		this.legendPosition = position;
	}

	public void setYBarPosition(AxisPosition position) {
		this.yBarPosition = position;
	}

	public void setXBarPosition(AxisPosition position) {
		this.xBarPosition = position;
	}

	public void setXBarValue(int rowMin, int columnMin, int rowMax, int columnMax) {
		xBarRange = new int[] { rowMin, rowMax, columnMin, columnMax };
	}

	public void setYValueList(int rowMin, int columnMin, int rowMax, int columnMax, String seiresName) {
		yBarRange.add(new Integer[] { rowMin, rowMax, columnMin, columnMax });
		seriesName.add(seiresName);
	}

	public void setSelectedSheet(String sheetName) {
		this.selectedSheet = sheetName;
	}

	public void setSmooth(Boolean bool) {
		this.setSmooth = bool;
	}

	public void setXAxis(double max, double min) {
		this.xAxis = true;
		this.xMax = max;
		this.xMin = min;
	}

	public void setYAxis(double max, double min) {
		this.yAxis = true;
		this.yMax = max;
		this.yMin = min;
	}

	public void setChartName(String chartName) {
		this.chartTitle = chartName;
	}

	public int getStartRow() {
		return this.startRow;
	}

	public int getStartColumn() {
		return this.startColumn;
	}

	public int getWidth() {
		return this.chartWidth;
	}

	public int getHeight() {
		return this.chartHeight;
	}

	public LegendPosition getLegendPosition() {
		return this.legendPosition;
	}

	public AxisPosition getXBarPosition() {
		return this.xBarPosition;
	}

	public AxisPosition getYBarPosition() {
		return this.yBarPosition;
	}

	public int[] getXBarValue() {
		return this.xBarRange;
	}

	public List<Integer[]> getYBarValue() {
		return this.yBarRange;
	}

	public String getSheetName() {
		return this.selectedSheet;
	}

	public List<String> getSeriesName() {
		return this.seriesName;
	}

	public Boolean getSmooth() {
		return this.setSmooth;
	}

	public Boolean getXaxis() {
		return this.xAxis;
	}

	public Boolean getYaxis() {
		return this.yAxis;
	}

	public double getXaxisMax() {
		return this.xMax;
	}

	public double getXaxisMin() {
		return this.xMin;
	}

	public double getYaxisMax() {
		return this.yMax;
	}

	public double getYaxisMin() {
		return this.yMin;
	}

	public String getChartName() {
		return this.chartTitle;
	}

}
