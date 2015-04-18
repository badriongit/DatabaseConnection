package demo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usertable database table.
 * 
 */
@Entity
@NamedQuery(name="Usertable.findAll", query="SELECT u FROM Usertable u")
public class Usertable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String userid;

	private String passwd;

	public Usertable(Usertable user) {
		this.userid = user.userid;
		this.passwd = user.passwd;
	}
	
	public Usertable() {
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}