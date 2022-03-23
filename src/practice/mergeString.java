package practice;

public class mergeString {
   
	public static void main(String[] args) {
		System.out.println(merge("gcta","ctaggt"));
	}
	
	public static String merge(String a,String b) {
		int i,j;
		boolean flag = false;
		for(i=1; i<a.length() && i<b.length() ;i++) {
			if(a.substring(i).equals(b.substring(0, a.length()-i))) {
				flag = true;
				break;
			}
		}
		if(flag) {
			return a.substring(0, i) + b;
		}
		return a+b;
	}
	
}
