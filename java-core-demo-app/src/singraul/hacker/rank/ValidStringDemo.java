package singraul.hacker.rank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidStringDemo {

	public static void main(String args[]) {

		String str ="abcdefghhgfedecba";
		
		System.out.println(isValid(str));
	}

	public static String isValid(String s) {
	
		
		Map<Character, Integer> charFreqMap  =new HashMap<>();

		for (int i=0; i<s.length() ; i++) {
		    char c = s.charAt(i);
		    int freq = charFreqMap.getOrDefault(c, 0);
		    charFreqMap.put(c, ++freq);
		}
		
      int[] arr = new int [charFreqMap.size()];
       int idx =0 ;
       for (Map.Entry<Character, Integer> entryMap : charFreqMap.entrySet()) {
    	   arr[idx++] = entryMap.getValue();
       }
  
       Arrays.sort(arr);
       
		if (charFreqMap.size() ==1) return "YES";
		
		int first = arr[0] ; int second = arr[1];
		int secondLast = arr[arr.length - 2];
		int last = arr[arr.length -1];
		
		// if first and last elements are same then all frequency are same, as array is sorted 
		if (first == last)
			return "YES" ;
		// if first is 1 and all other character have same frequency 
		if(first ==1 && second ==last )
			return "YES";
		// If all are same and last character has just 1 extra count
		if (first ==second && second== secondLast && secondLast == (last-1))
			return "YES";
       
       // else invalid string 
		return "NO";

	}
}
//
//Time Complexity: O(n)
//Space Complexity: O(n)