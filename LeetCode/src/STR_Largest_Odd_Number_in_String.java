
public class STR_Largest_Odd_Number_in_String {
	public static void main(String[] args) {
		System.out.println(largestOddNumber("35427"));
	}

    public static  String largestOddNumber(String num) {
        char [] c= num.toCharArray();
        String res=new String();
        for(int i=c.length-1;i>=0;i--) {
        	if(c[i]=='1'||c[i]=='3'||c[i]=='5'||c[i]=='7'||c[i]=='9') {
        		res=num.substring(0, i+1);
        		return res;
        	}
        }
        return res;
     }
}
