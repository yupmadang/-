package breedingManagement;

import java.util.Iterator;
import java.util.LinkedList;

public class BreedingMode implements DryInsectInterface, BreedingInterface{
	LinkedList<Insect> Info_Name = new LinkedList<>();
	LinkedList<Stock> Info_Stock = new LinkedList<>();
	LinkedList<DryInsect> Info_DryInsect = new LinkedList<>();
	
	//개체추가, 제거, 출력을 위한 Insect형의 ins
	InsectInfo ins; 
	InsectInfo edit = new InsectInfo();
	Stock sto;
	Stock edit2 = new Stock();
	DryInsect dins;
	DryInsect edit3 = new DryInsect();

	
}