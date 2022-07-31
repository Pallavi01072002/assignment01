package assignment_01;

public class QuestionNo_04 {

	public static void main(String[] args) {
		int n=14;
		for(int i=0;i<(n+2)/2;i++) {
			for(int j=0;j<n;j++) {
				if( i+j>=n-1 || i==j || i-j>=1)
				  System.out.print("*  ");
				else
					System.out.print("   ");
			}
			System.out.println("");
		}
	}

}
