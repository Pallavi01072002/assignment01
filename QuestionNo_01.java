package assignment_01;

public class QuestionNo_01 {

	public static void main(String[] args) {
		int n=7;
		for(int j=0;j<n;j++) {
			for(int i=0;i<n;i++) {
				if(((j==1 || j==n-2) && 0<i && i<n-1) || (j!=0 && j!=n-1 && i==(n-1)/2))
					System.out.print("ii");
				else
					System.out.print("* ");
			}
		
		
			for(int i=0;i<n;i++) {
				if((j!=0 && j!=n-1 && (i==1 || i==n-2)) || (i==j && i!=0 && i!=n-1))
					System.out.print("nn");
				else
					System.out.print("* ");
			}  
		

		
			for(int i=0;i<n;i++) {
				if((j!=0 && j!=n-1 && i==1) || ((j==n-2||j==1) && 0<i && i<n-1) || (j==n/2 && i!=0 && i!=n-1))
					System.out.print("ee");
				else
					System.out.print("* ");
			}  
		
		
			for(int i=0;i<n;i++) {
				if((j!=0 && j!=n-1 && (i==1 || i==n-2)) || (j==n-2 && 0<i && i<n-1))
					System.out.print("uu");
				else
					System.out.print("* ");
			}  
		

		
			for(int i=0;i<n;i++) {
				if((j!=0 && j!=n-1 && i==1) || (j==1 && 0<i && i<n-1) || (j==n/2 && i!=0 && i!=n-1) || (i==n-2 && j!=0 && j<n/2) || (j-i==2 && j>4))
					System.out.print("rr");
				else
					System.out.print("* ");
			}  

		
		
			for(int i=0;i<n;i++) {
				if((j!=0 && j!=n-1 && (i==1 || i==n-2)) || ((j==1 || j==n-2) && 0<i && i<n-1))
					System.out.print("oo");
				else
					System.out.print("* ");
			}  

		
		
			for(int i=0;i<n;i++) {
				if((j!=0 && j!=n-1 && (i==1 || i==n-2)) || (i==j && i!=0 && i!=n-1))
					System.out.print("nn");
				else
					System.out.print("* ");
			}  
            System.out.println("");
		}
		}
		}

		
		
		
