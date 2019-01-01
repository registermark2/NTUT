package test;

import java.util.ArrayList;

public class First {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		ArrayList<String> wu = new ArrayList();
		ArrayList<ArrayList<String>> alGetTagstore_one = new ArrayList<ArrayList<String>>();
		
		
		for(int w=0;w<3;w++) {
			ArrayList<String> x = new ArrayList();
			for(int i=0;i<3;i++) {
				String u = "2";
				x.add(u);
				
			}
			alGetTagstore_one.add(w, x);	
		}
		System.out.print("\nΕγ₯ά:"+alGetTagstore_one);
//			for(ArrayList<String> string : alGetTagstore_one) {
		
//			}
				
		
	}
}
