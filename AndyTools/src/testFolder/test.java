package testFolder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class test {
	//test at AndyTools
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> nums = new ArrayList<>();
		nums.add(null);
		nums.add(1);
		nums.add(2);
		nums.add(null);
		nums.add(3);
		
		List<String> show = nums.stream().map(s -> String.valueOf(s)).collect(Collectors.toList());
		System.out.println(show);

		
		
		
	}

}