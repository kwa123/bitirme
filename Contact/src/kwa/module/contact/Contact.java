package kwa.module.contact;

public class Contact {
	private String name;
	private String tel;
	
	public Contact(String _name, String _tel) {
		name = _name;
		tel = _tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	

}
