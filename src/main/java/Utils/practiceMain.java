package Utils;

import java.util.Scanner;

public class practiceMain {

	static final int CHAR = 256;
    
    static boolean areAnagram(String s1, String s2)
    {
        if(s1.length() != s2.length())
            return false;
            
        int count[] = new int[CHAR];
        
        for(int i=0; i<s1.length(); i++)
        {
//            count[s1.charAt(i)]++;
//            count[s2.charAt(i)]--;
        	System.out.println( count[s1.charAt(i)]);
            System.out.println( count[s1.charAt(i)]++);
            System.out.println( count[s2.charAt(i)]);
            System.out.println( count[s2.charAt(i)]--);
        }
        
        for(int i=0; i<CHAR; i++)
        {
            if(count[i] != 0)
                return false;
        }
        
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Scanner s= new Scanner(System.in);
//		int a=s.nextInt();
//		int b=s.nextInt();
//		String con=String.valueOf(a+b);
//		System.out.println(con);
//		String h="Hello";
//		h.replace("l", "p");
        
		    
		 String s1 = "abaac";
	        String s2 = "aacba";

	        System.out.println(areAnagram(s1, s2));    
		    
		 
		}
	}

