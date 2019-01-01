package FEWS.Rinfall.BUI;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

import javax.naming.OperationNotSupportedException;



import FEWS.PIXml.AtPiXmlReader;
import nl.wldelft.util.timeseries.TimeSeriesArray;
import usualTool.AtFileReader;
import usualTool.TimeTranslate;

public class BuiTranslate {
	private String fileAdd;
	private TreeMap<String, String> idMapping = null;
	private ArrayList<TimeSeriesArray> timeSeriesArrays;
	private long startDate;
	private int timeStepMultiplier;
	private long endDate;
	private double valueTimes = 1;

	// <===============>
	// <this is the constructor >
	// <===============>
	public BuiTranslate(String fileAdd) throws OperationNotSupportedException, IOException {
		this.fileAdd = fileAdd;
	}

	public BuiTranslate setValueTimes(double times) {
		this.valueTimes = times;
		return this;
	}

	public String[] getBuiRainfall() throws OperationNotSupportedException, IOException {
		this.timeSeriesArrays = new AtPiXmlReader().getTimeSeriesArrays(new File(this.fileAdd));
		// <basic outPut setting>
		// <___________________________________________________________________>
		ArrayList<String> outArray = new ArrayList<String>();

		// <Starting setting BUI>
		// <____________________________________________________>
		outArray.add("*");
		outArray.add("*");
		outArray.add("*Enige algemene wenken:");
		outArray.add("*Gebruik de default dataset (1) of de volledige reeks (0) voor overige invoer");
		outArray.add("1");
		outArray.add("*Aantal stations");
		outArray.add(timeSeriesArrays.size() + "");

		// <checking idMapping is null or not>
		// <_____________________________________________________________________>
		outArray.add("*Namen van stations");
		if (this.idMapping == null) {
			this.timeSeriesArrays.stream().forEach(
					timeSeriesArray -> outArray.add("\'" + timeSeriesArray.getHeader().getLocationId() + "\'"));
		} else {
			this.timeSeriesArrays.stream().forEach(timeSeriesArray -> outArray
					.add("\'" + idMapping.get(timeSeriesArray.getHeader().getLocationId()) + "\'"));
		}

		// <translate to the bui format>
		// <____________________________________________________________________________>
		outArray.add("*Aantal gebeurtenissen (omdat het 1 bui betreft is dit altijd 1)");
		outArray.add("*en het aantal seconden per waarnemingstijdstap");
		TimeSeriesArray firstTimeSeriesArray = this.timeSeriesArrays.get(0);
		outArray.add(" 1 " + firstTimeSeriesArray.getTimeStep().getMaximumStepMillis() / 1000);

		outArray.add("*Elke commentaarregel wordt begonnen met een * (asteriks).");
		outArray.add("*Eerste record bevat startdatum en -tijd, lengte van de gebeurtenis in dd hh mm ss");
		outArray.add("*Het format is: yyyymmdd:hhmmss:ddhhmmss");
		outArray.add("*Daarna voor elk station de neerslag in mm per tijdstap.");

		outArray.add(
				TimeTranslate.milliToDate(firstTimeSeriesArray.getStartTime(), " yyyy MM dd HH mm ss") + TimeTranslate
						.milliToTime(firstTimeSeriesArray.getTimeStep().getStepMillis() * firstTimeSeriesArray.size(),
								" dd HH mm ss"));

		for (int event = 0; event < firstTimeSeriesArray.size(); event++) {
			ArrayList<String> temptValue = new ArrayList<String>();
			for (TimeSeriesArray timeSeries : this.timeSeriesArrays) {
				if ("NaN".equals(timeSeries.getValue(event) + "")) {
					temptValue.add("0.00");
				} else {
					temptValue.add(new BigDecimal(timeSeries.getValue(event) * this.valueTimes)
							.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
				}
			}
			;
			outArray.add(String.join(" ", temptValue));
		}
		return outArray.parallelStream().toArray(String[]::new);
	}

	public String[] getBuiRainfall_Fill(String fill, int times) throws OperationNotSupportedException, IOException {
		this.timeSeriesArrays = new AtPiXmlReader().getTimeSeriesArrays(new File(this.fileAdd));
		// <basic outPut setting>
		// <___________________________________________________________________>
		ArrayList<String> outArray = new ArrayList<String>();

		// <Starting setting BUI>
		// <____________________________________________________>
		outArray.add("*");
		outArray.add("*");
		outArray.add("*Enige algemene wenken:");
		outArray.add("*Gebruik de default dataset (1) of de volledige reeks (0) voor overige invoer");
		outArray.add("1");
		outArray.add("*Aantal stations");
		outArray.add(timeSeriesArrays.size() + "");

		// <checking idMapping is null or not>
		// <_____________________________________________________________________>
		outArray.add("*Namen van stations");
		if (this.idMapping == null) {
			this.timeSeriesArrays.stream().forEach(
					timeSeriesArray -> outArray.add("\'" + timeSeriesArray.getHeader().getLocationId() + "\'"));
		} else {
			this.timeSeriesArrays.stream().forEach(timeSeriesArray -> outArray
					.add("\'" + idMapping.get(timeSeriesArray.getHeader().getLocationId()) + "\'"));
		}

		// <translate to the bui format>
		// <____________________________________________________________________________>
		outArray.add("*Aantal gebeurtenissen (omdat het 1 bui betreft is dit altijd 1)");
		outArray.add("*en het aantal seconden per waarnemingstijdstap");
		TimeSeriesArray firstTimeSeriesArray = this.timeSeriesArrays.get(0);
		outArray.add(" 1 " + firstTimeSeriesArray.getTimeStep().getMaximumStepMillis() / 1000);

		outArray.add("*Elke commentaarregel wordt begonnen met een * (asteriks).");
		outArray.add("*Eerste record bevat startdatum en -tijd, lengte van de gebeurtenis in dd hh mm ss");
		outArray.add("*Het format is: yyyymmdd:hhmmss:ddhhmmss");
		outArray.add("*Daarna voor elk station de neerslag in mm per tijdstap.");

		double previousTime = (firstTimeSeriesArray.getTimeStep().getStepMillis()) * times;

		outArray.add(TimeTranslate.milliToDate(firstTimeSeriesArray.getStartTime() - (long) previousTime,
				" yyyy MM dd HH mm ss")
				+ TimeTranslate
						.milliToTime(firstTimeSeriesArray.getTimeStep().getStepMillis() * firstTimeSeriesArray.size()
								+ (long) previousTime, " dd HH mm ss"));

		for (int event = 0; event < firstTimeSeriesArray.size() + times; event++) {
			ArrayList<String> temptValue = new ArrayList<String>();
			for (TimeSeriesArray timeSeries : this.timeSeriesArrays) {
				try {
					if ("NaN".equals(timeSeries.getValue(event - times) + "")) {
						temptValue.add("0.00");
					} else {
						temptValue.add(timeSeries.getValue(event - times) * this.valueTimes + "");
					}
				} catch (Exception e) {
					temptValue.add(0, fill);
				}
			}

			outArray.add(String.join(" ", temptValue));
		}

		return outArray.parallelStream().toArray(String[]::new);
	}
}
