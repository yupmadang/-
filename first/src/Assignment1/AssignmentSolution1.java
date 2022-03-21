package Assignment1;

public class AssignmentSolution1 {

	public static void main(String[] args) {
		int sec  = 100000;
		int total;
		for(int i = 1; i < 6; i++) {
			switch(i) {
			case 1 :
				System.out.println(sec+"초입니다");
				break;
			case 2 :
				total = sec / 60;
				System.out.println(total+"분입니다");
				break;
			case 3 :
				total = sec / 360;
				System.out.println(total+"시간입니다");
				break;
			case 4 :
				total = sec / 8640;
				System.out.println(total+"일입니다");
				break;
			case 5 :
				total = sec / 3153600;
				if(total == 0) {
					System.out.println("1년보다 짧습니다!!!");
				}
				else {
					System.out.println("1년보다 깁니다!!!");
				}
			}
		}	
	}
}
