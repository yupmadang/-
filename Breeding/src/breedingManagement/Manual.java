package breedingManagement;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
//설명서 정보를 담는 클래스, 파일을 생성하고 설명을 저장하는 클래스
public class Manual implements Serializable{

	private static final long serialVersionUID = 2082895451081071795L;
	private String manual = "-----이 프로젝트의 사용법 및 규칙-----\r\n"+
	"\r\n\r\n1. 생체 아이디 작성법(안지켜도 무관)\r\n"+
	"0000번대 길쭉꼬마사슴벌레\r\n"+
	"1000번대 홍다리사슴벌레\r\n"+
	"2000번대 왕사슴벌레\r\n"+
	"3000번대 넓적사슴벌레\r\n"+
	"4000번대 사슴벌레\r\n"+
	"5000번대 톰사슴벌레\r\n"+
	"6000번대 애사슴벌레\r\n"+
	"7000번대 참넓적사슴벌레\r\n"+
	"8000번대 털보왕사슴벌레\r\n"+
	"9000번대 엷은털왕사슴벌레\r\n"+
	"\r\n\r\n2.표본 아이디 작성\r\n"+
	"10만 단위 : 속\r\n"+
	"1xxxxx : Dynastes\r\n"+
	"2xxxxx : Chalcosoma\r\n"+
	"3xxxxx : Megasoma\r\n"+
	"4xxxxx : Eutoparus\r\n"+
	"5xxxxx : Dorcus\r\n"+
	"6xxxxx : Prosopocoilus\r\n"+
	"7xxxxx : Titanus\r\n"+
	"8xxxxx : Lamprima\r\n"+
	"9xxxxx : Mesotopus\r\n"+
	"만 단위 : 종(상당히 많음으로 개인이 자유롭게 작성)\r\n"+
	"천 단위 : 아종(종에 따라 개인이 자유롭게 작성)\r\n"+
	"\r\n\r\n3.표본라벨 작성\r\n"+
	"라벨은 표본의 진위를 가리는 데이터로 매우 중요하므로\r\n"+
	"(학명/이름/크기/날짜/지역)을 적을 것 띄어쓰기 불필요\r\n"+
	"자 나머지는 메뉴에 따라서 자유롭게 쓰시면 됩니다.\r\n"+
	"사용 전에는 먼저 개체 출력으로 창을 초기화하시고 사용하시면 됩니다.\r\n"+
	"사용 중에 테이블이 너무 복잡하면 초기화 버튼으로 테이블을 비우고 사용하시면 깔끔하게 사용이 가능합니다.\r\n"+
	"그럼 이만\r\n";
	
	//생성자를 활용한 파일 생성 및 값 저장
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
