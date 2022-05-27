package breedingManagement;

import java.util.Scanner;
//직렬화를 진행한 프로젝트
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