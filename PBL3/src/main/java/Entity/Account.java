package Entity;

public class Account {
		private int id;
		private String userName;
		private String fullName;
		private int gender;
		private String address;
		private String birth;
		private String phoneNumber;
		private String email;

		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Account(int id, String userName, String fullName, int gender, String birth, String address
				,String phoneNumber, String email) {
			super();
			this.id = id;
			this.userName = userName;
			this.fullName = fullName;
			this.gender = gender;
			this.address = address;
			this.birth = birth;
			this.phoneNumber = phoneNumber;
			this.email = email;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getFullName() {
			return fullName;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		public int getGender() {
			return gender;
		}
		public void setGender(int gender) {
			this.gender = gender;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getBirth() {
			return birth;
		}
		public void setBirth(String birth) {
			this.birth = birth;
		}
		
		
}
