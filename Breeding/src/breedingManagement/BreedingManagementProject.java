package breedingManagement;

import java.util.Scanner;
//����ȭ�� ������ ������Ʈ
public class BreedingManagementProject{

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);

		BreedingMode breedingMode = BreedingMode.logger.getObject("Breeding.ser");
		if(breedingMode == null) {
			breedingMode = new BreedingMode(input);
		}
		
		breedingMode.selectMenu(input, breedingMode);
		BreedingMode.logger.PutObject(breedingMode, "Breeding.ser");
	}
}