package Model.DTO.San_Pham;

public class Danh_muc_san_pham{
	
	private int id;
	private int parent_id;
	private String category;
	
	public Danh_muc_san_pham() {
		
	}
	
	public Danh_muc_san_pham(int id, int parent_id, String category) {
		super();
		this.id = id;
		this.parent_id = parent_id;
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Danh_muc_san_pham [id=" + id + ", parent_id=" + parent_id + ", category=" + category + "]";
	}
	
	
}
