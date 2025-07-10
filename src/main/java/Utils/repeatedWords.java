package Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class repeatedWords {
 public static void main(String[] args) {
		String str = "Hello World Hello Universe Hello";
		findRepeatedWords(str);
	}
 
 public static void findRepeatedWords(String str) {
		HashMap<String, Integer> map = new HashMap<>();
		String [] s=str.split("\\s");
		for(int i=0;i<s.length;i++)
		{
			map.put(s[i], map.getOrDefault(s[i], 0)+1);
		}
		
		System.out.println(map);
		for (Map.Entry< String,Integer> entry : map.entrySet()) {
		    System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}

	}
}
