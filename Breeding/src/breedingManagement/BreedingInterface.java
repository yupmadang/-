package breedingManagement;

public interface BreedingInterface {
	//�긮���� �ʿ��� �޼��带 ������ interface
	public boolean Add_Insect(int id, String name, double weight, String stock, int num, String date);
	public void	Delete_Insect(int id);
	public void Edit_Insect(int id, double weight, int num);
	public void Search_Insect(int id);
	public void Show_Insect();
}
