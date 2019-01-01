package testFolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
//import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CompareFunction {
	Double rdata, min;

	public int getCloseValue(List<Double> list, Double compareNumber) {
//		Double temp =list.stream().min(Comparator.comparingDouble(i ->Math.abs(i-compareNumber))).get();
//		if(temp <= rdata) {
//			min=temp;  
//		}
//		
//		return min;
		int rdataNumber = 0;
		Double min = 10.0;
		Double a = compareNumber;
//		System.out.println("list大小:"+list.size());
		for (int i = 0; i < list.size(); i++) {	
			Double b = Math.abs(a - list.get(i));
//			System.out.println(b);
			if (b < min) {
				rdataNumber = i;
//				System.out.println("B"+b+" "+"減第幾個"+list.get(i));
				min = b;
			}
		}
		return rdataNumber;
	}
}

//List<Double> list = Arrays.stream(numbers).collect(Collectors.toList());

//Double result = list.stream().min(Comparator.comparingDouble(i -> Math.abs(i - compareNumber))).get();
//				.orElseThrow(() -> new NoSuchElementException("No value present"));
//list.parallelStream().min(Comparator.comparingDouble(i -> Math.abs(i - compareNumber)))

//list.stream().min(Comparator.comparingDouble(i ->Math.abs(i-compareNumber))).get();

//list.stream().min(Comparator.comparingDouble(i ->Math.abs(i-compareNumber))).get();
//