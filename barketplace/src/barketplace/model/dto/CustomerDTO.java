package barketplace.model.dto;
// ToString, 생성자 설정하기

public class CustomerDTO {

	private String id;
	private String password;
	private String name;
	private String phone;
	private String bankName;
	private String bankAccount;
	private int auth;
	private int cash;

	public CustomerDTO() {
		super();
	}

	public CustomerDTO(String id, String password, String name, String phone, String bankName, String bankAccount,
			int auth, int cash) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.bankName = bankName;
		this.bankAccount = bankAccount;
		this.auth = auth;
		this.cash = cash;
	}

	
	public CustomerDTO(String id, String password, String name, String phone, String bankName, String bankAccount) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.bankName = bankName;
		this.bankAccount = bankAccount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	/*public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append();
		return "CustomerDTO [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone
				+ ", bankName=" + bankName + ", bankAccount=" + bankAccount + ", auth=" + auth + ", cash=" + cash + "]";
	}*/

}
