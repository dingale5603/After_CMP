package first;

import java.util.Scanner;

public class Deepak {
	static String subscriber="deepak";
	//static boolean active;
	Scanner sc=new Scanner(System.in);
	int b=sc.nextInt();
	 boolean active=sc.nextBoolean();
	
	//int i=b;
	public void even_odd () {
		if (b % 2==0) {
			System.out.println(b+" this is even no  ");
		}else {
			System.out.println(b+" this is odd no   ");
		}
		if (subscriber=="deepak" && active==true) {
			System.out.println("this is active subscriverand name is "+subscriber+"  and status is active thats Why returns  "+active);
		}else {
			System.out.println("not active subscriber and name is "+subscriber);
		}
	}
	
	
   public static void main(String[] args) {
	
	
	Deepak d=new Deepak();
	d.even_odd();
}

}
