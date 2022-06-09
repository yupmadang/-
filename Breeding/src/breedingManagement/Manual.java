package breedingManagement;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
//���� ������ ��� Ŭ����, ������ �����ϰ� ������ �����ϴ� Ŭ����
public class Manual implements Serializable{

	private static final long serialVersionUID = 2082895451081071795L;
	private String manual = "-----�� ������Ʈ�� ���� �� ��Ģ-----\r\n"+
	"\r\n\r\n1. ��ü ���̵� �ۼ���(�����ѵ� ����)\r\n"+
	"0000���� ���߲����罿����\r\n"+
	"1000���� ȫ�ٸ��罿����\r\n"+
	"2000���� �ջ罿����\r\n"+
	"3000���� �����罿����\r\n"+
	"4000���� �罿����\r\n"+
	"5000���� ��罿����\r\n"+
	"6000���� �ֻ罿����\r\n"+
	"7000���� �������罿����\r\n"+
	"8000���� �к��ջ罿����\r\n"+
	"9000���� �����пջ罿����\r\n"+
	"\r\n\r\n2.ǥ�� ���̵� �ۼ�\r\n"+
	"10�� ���� : ��\r\n"+
	"1xxxxx : Dynastes\r\n"+
	"2xxxxx : Chalcosoma\r\n"+
	"3xxxxx : Megasoma\r\n"+
	"4xxxxx : Eutoparus\r\n"+
	"5xxxxx : Dorcus\r\n"+
	"6xxxxx : Prosopocoilus\r\n"+
	"7xxxxx : Titanus\r\n"+
	"8xxxxx : Lamprima\r\n"+
	"9xxxxx : Mesotopus\r\n"+
	"�� ���� : ��(����� �������� ������ �����Ӱ� �ۼ�)\r\n"+
	"õ ���� : ����(���� ���� ������ �����Ӱ� �ۼ�)\r\n"+
	"\r\n\r\n3.ǥ���� �ۼ�\r\n"+
	"���� ǥ���� ������ ������ �����ͷ� �ſ� �߿��ϹǷ�\r\n"+
	"(�и�/�̸�/ũ��/��¥/����)�� ���� �� ���� ���ʿ�\r\n"+
	"�� �������� �޴��� ���� �����Ӱ� ���ø� �˴ϴ�.\r\n"+
	"��� ������ ���� ��ü ������� â�� �ʱ�ȭ�Ͻð� ����Ͻø� �˴ϴ�.\r\n"+
	"��� �߿� ���̺��� �ʹ� �����ϸ� �ʱ�ȭ ��ư���� ���̺��� ���� ����Ͻø� ����ϰ� ����� �����մϴ�.\r\n"+
	"�׷� �̸�\r\n";
	
	//�����ڸ� Ȱ���� ���� ���� �� �� ����
	public Manual() {
		try  {
			FileWriter file = new FileWriter("Manual.txt");
			file.write(manual);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getManual() {
		return manual;
	}
}
