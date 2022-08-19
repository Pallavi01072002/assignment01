package assignment03;
import java.util.Arrays;
import java.util.Scanner;

public class Assignment3 {

//three ways of reversing a string.
	public String reversingString1(String str) {
		//since string class does not have inbuilt reverse method.
		String reverseName="";
		for(int i=str.length()-1; i>=0; i--) {
			reverseName=reverseName+str.charAt(i);
		}
		return reverseName;
	}
	
	public String reversingString2(String str) {
		char[] c=str.toCharArray();
		String reverseName="";
		for(int i=c.length-1; i>=0; i--) {
			reverseName=reverseName+Character.toString(c[i]);
		}
		return reverseName;
	}
	
	public String reversingString3(String str) {
		String reverseName="";
		for(int i=str.length(); i>0; i--) {
			reverseName=reverseName+str.substring(i-1,i);
		}
		return reverseName;
	}
//--------------------------------------------------------------------------------
	public String wordReverse1(String str) {
		String[] arr=str.trim().split(" ");
		String reverseName="";
		for(int i=arr.length-1; i>=0; i--) {
			reverseName=reverseName+arr[i]+" ";
		}
		return reverseName.trim();
	}
	
	public String wordReverse2(String str) {
		String reverseName="";
		String str1 = str.trim();
		int count = str1.length();
		for(int i=str1.length()-1; i>=0; i--) {
			if(str1.charAt(i)==' ') {
	         	reverseName=reverseName+str1.substring(i+1,count)+" ";
	         	count = i;
			}
		}
		return reverseName+str1.substring(0, count).trim();
	}
//--------------------------------------------------------------------------------
	//without sorting the array, case sensitive.
	public boolean anagramCheck1(String ana1, String ana2) {
		if(ana1.length()==ana2.length()) {
			char[] str1 = ana1.toCharArray();
			char[] str2 = ana2.toCharArray();
			boolean flag = false;
			for(int i=0; i<str1.length; i++) {
				for(char c : str2) {
					if(str1[i]==c) {
						flag = true; break;
					}
				}
				if(!flag) {
					return false;
				}
			}
			return true;
		 }
	  return false;
    }
	
	//using all inbuilt methods, case sensitive.
	public boolean anagramCheck2(String ana1, String ana2) {
		if(ana1.length()==ana2.length()) {
			char[] str1 = ana1.toCharArray();
			char[] str2 = ana2.toCharArray();
			Arrays.sort(str1);
			Arrays.sort(str2);
			return Arrays.equals(str1, str2);
		}
		return false;
	}
	
	//case insensitive
	public boolean anagramCaseInsensitive(String ana1, String ana2) {
		if(ana1.length()==ana2.length()) {
		    char[] str1 = ana1.toCharArray();
			char[] str2 = ana2.toCharArray();
			Arrays.sort(str1);
			Arrays.sort(str2);
			for(int i=0; i<str1.length; i++) {
				if(str1[i]!=str2[i]) return false;
			}
			return true;
		}
		return false;
	}
	
//-------------------------------------------------------------------------------
	
	//this method is for strict lowercasePangram check.
	//for Upper case Pangram check: value>64 && value<91
	//for case insensitive you may convert whole string in lowercase and continue with below code.
	public boolean pangramLowerCaseCheck(String s) {
		if(s.length()>25) {
			char[] str = s.toCharArray();
			boolean[] pangram = new boolean[26];
			for(int i=0; i<str.length; i++) {
				int value = (byte)str[i];
				if(value>96 && value<123) { // change here for different cases.
					pangram[value-97]=true;
				}
			}
			for(boolean b : pangram) {
				if(b==false) return false;
			}
			return true;
		}
		return false;
	}
	
//another logic to check Pangram for case insensitive strings.
	public boolean pangramCaseInsensitiveCheck(String s) {
		if(s.length()>25) {
			boolean[] pangram = new boolean[26];
			for(int i=0; i<s.length(); i++) {
				int value = s.charAt(i);
				int index = 0;
				if(value>='A' && value<='Z')
					index = value-'A';
				else if(value>='a' && value<='z')
					index = value-'a';
				pangram[index]=true;
			}
			for(boolean b: pangram) {
				if(b==false) return false;
			}
			return true;
		}
		return false;
	}

//-------------------------------------------------------------------------------
	
	//case sensitive
	public String repeatPrintedChar(String str) {
		String repeatedStr = "";
		int[] check = new int[128];
		for(int i=0; i<str.length(); i++) {
			int value = (byte)str.charAt(i);
			if(check[value]==0)
				check[value]++;
			else if(check[value]==1) {
				repeatedStr=repeatedStr+str.charAt(i);
				check[value]++;
			}
		}
		return repeatedStr;
	}
	
//case insensitive.
	public String repeatPrintedCharCaseInsensitive(String str) {
		String repeatedStr = "";
		int[] check = new int[101];
		for(int i=0; i<str.length(); i++) {
			int value = (byte)str.charAt(i);
			if(97<=value && value<=122) {
				value=value-32;
			}
			else if(123<=value && value<=127) {
				value=value-26;
			}
			if(check[value]==0)
				check[value]++;
			else if(check[value]==1) {
				repeatedStr=repeatedStr+(char)value;
				check[value]++;
			}
		}
		return repeatedStr;
	}
//-------------------------------------------------------------------------------
	//using all inbuilt methods, case sensitive.
	public String sortedString(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		String sorted = new String(c);
		return sorted;
	}
	
	public String bubbleSortForString(String s) {
		char[] arr = s.toCharArray();
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					//swap
				    char temp = arr[j];
				    arr[j] = arr[j+1];
				    arr[j+1] = temp;
		     	}
		    }
	    }
	    String sorted = new String(arr);
	    return sorted;
    }
	
    public String selectionSortForString(String s) {
    	char[] arr = s.toCharArray();
    	for(int i=0; i<arr.length-1; i++) {
    		int smallestNumIndex = i;
    		for(int j=i+1; j<arr.length; j++) {
    			if(arr[smallestNumIndex] > arr[j]) {
    				smallestNumIndex = j;
    			}		
			}
    		//swap
    		char temp = arr[smallestNumIndex];
    		arr[smallestNumIndex] = arr[i];
    		arr[i] = temp;
		}
    	String sorted = new String(arr);
    	return sorted;
	}
    
    public String insertionSortForString(String s) {
    	char[] arr = s.toCharArray();
    	for(int i=1; i<arr.length; i++) {
    		char current = arr[i];
    		int j = i-1;
    		while(j>=0 && arr[j] > current) {
    			arr[j+1] = arr[j];
    			j--;
    		} 
    		arr[j+1] = current;
    	}
    	String sorted = new String(arr);
    	return sorted;
    }   
 //-------------------------------------------------------------------------------------------------------   
    
    //case insensitive i.e., if aA then counts 2 because at last both are vowels only.
    public void countVowelsAndConsonants(String s) {
    	int vowel = 0;
    	int consonants = 0;
    	for(int i=0; i<s.length(); i++) {
    		if( s.charAt(i)=='a' || s.charAt(i)=='e' ||s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u' || s.charAt(i)=='a' || s.charAt(i)=='A' ||
    				s.charAt(i)=='E' || s.charAt(i)=='I' || s.charAt(i)=='O' || s.charAt(i)=='U') {
    			vowel++;
    		}
    		else if((s.charAt(i)>96 && s.charAt(i)<91) 
    				|| (s.charAt(i)>64 && s.charAt(i)<123)) {
    			consonants++;
    		}
    	}
    	System.out.println("vowels: " +vowel +" " +"consonants " +consonants);
    }
    
//-----------------------------------------------------------------------------------------------------------------    
    
    public int specialCharCount(String s) {
    	int count = 0;
    	for(int i=0; i<s.length(); i++) {
    		if(!(s.charAt(i)>=48 && s.charAt(i)<=57) && !(s.charAt(i)>=65 && s.charAt(i)<=90) && !(s.charAt(i)>=97 && s.charAt(i)<=122)) {
    			count++;
    		}
    	}
    	return count;
    }
    
 //------------------------------------------------------------------------------------------------------------------------------   
    
//Main method.
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Assignment3 assign = new Assignment3();
		
		System.out.println("Type a string which you want to reverse letter by letter.");
		String input = sc.nextLine();
		System.out.println(assign.reversingString1(input));
		System.out.println(assign.reversingString2(input));
		System.out.println(assign.reversingString3(input));
		System.out.println();

		System.out.println("Type a sentence which you want to reverse word by word.");
		String sentence = sc.nextLine();
		System.out.println(assign.wordReverse1(sentence));
		System.out.println(assign.wordReverse2(sentence));
		System.out.println();
		
		System.out.println("Type two words for anagram checking (Note: special characters are also considered).");
		String ana1 = sc.nextLine();
		String ana2 = sc.nextLine();
		System.out.println("anagramCheck1 " +(assign.anagramCheck1(ana1, ana2)?"Anagram" : "Not Anagram"));
		System.out.println("anagramCheck2 " +(assign.anagramCheck2(ana1, ana2)?"Anagram" : "Not Anagram"));
		System.out.println("anagramCaseInsensitive " +(assign.anagramCaseInsensitive(ana1, ana2)?"Anagram" : "Not Anagram"));
		System.out.println();
		
		System.out.println("Type a string to check for pangram");
		String pan = sc.nextLine();
		System.out.println("pangramLowerCaseCheck " +(assign.pangramLowerCaseCheck(pan)?"Pangram" : "Not Pangram"));
		System.out.println("pangramCaseInsensitiveCheck " +(assign.pangramCaseInsensitiveCheck(pan)?"Pangram" : "Not Pangram"));
		System.out.println();

		System.out.println("Type a string to print repeated character of string");
		String str = sc.nextLine();
		System.out.println("repeatPrintedChar " +assign.repeatPrintedChar(str));
		System.out.println("repeatPrintedCharCaseInsensitive " +assign.repeatPrintedCharCaseInsensitive(str));
		System.out.println();

		System.out.println("Type a string to be sorted (case sensitive)");
		String sort = sc.nextLine();
		System.out.println("sortedString " +assign.sortedString(sort));
		System.out.println("bubbleSortForString " +assign.bubbleSortForString(sort));
		System.out.println("selectionSortForString " +assign.selectionSortForString(sort));
		System.out.println("insertionSortForString " +assign.insertionSortForString(sort));
		System.out.println();

		
		System.out.println("Type a string to count vowels and consonants");
		String pick = sc.nextLine();
		assign.countVowelsAndConsonants(pick);
		System.out.println();
		
		System.out.println("Type a string to count special characters");
		String special = sc.nextLine();
		System.out.println("specialCharCount is " +assign.specialCharCount(special));
	}
    
}