package Assignment1;

public class AssignmentSolution1 {

	public static void main(String[] args) {
		int sec  = 100000;
		int total;
		for(int i = 1; i < 6; i++) {
			switch(i) {
			case 1 :
				System.out.println(sec+"���Դϴ�");
				break;
			case 2 :
				total = sec / 60;
				System.out.println(total+"���Դϴ�");
				break;
			case 3 :
				total = sec / 360;
				System.out.println(total+"�ð��Դϴ�");
				break;
			case 4 :
				total = sec / 8640;
				System.out.println(total+"���Դϴ�");
				break;
			case 5 :
				total = sec / 3153600;
				if(total == 0) {
					System.out.println("1�⺸�� ª���ϴ�!!!");
				}
				else {
					System.out.println("1�⺸�� ��ϴ�!!!");
				}
			}
		}	
	}
}
