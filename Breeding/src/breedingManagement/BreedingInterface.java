package breedingManagement;

public interface BreedingInterface {
	//�긮���� �ʿ��� �޼��带 ������ interface
	public void Add_Insect(int id, String name, double weight, String stock);
	public void	Delete_Insect(int id);
	public void Edit_Insect(int id, double weight, int num);
	public void Search_Insect(int id);
	public void Show_Insect();
}
