package musician;

public class musicin {

	//Create variables using BD column name
	
	private int m_id;
	private String m_name;
	private String m_email;
	private String m_username;
	private String m_password;
	
	public musicin(String m_name,String m_email, String m_username, String m_password) {
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_username = m_username;
		this.m_password = m_password;

}
	
	public musicin(int m_id, String m_name,String m_email, String m_username, String m_password) {
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_username = m_username;
		this.m_password = m_password;

}

	//Values get
	
	public int getM_id() {
		return m_id;
	}

	public String getM_name() {
		return m_name;
	}

	public String getM_email() {
		return m_email;
	}

	public String getM_username() {
		return m_username;
	}

	public String getM_password() {
		return m_password;
	}

	
}
