package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USERREPORTDEFINITIONXREF database table.
 * 
 */
@Entity
@Table(name="USERREPORTDEFINITIONXREF")
@NamedQuery(name="Userreportdefinitionxref.findAll", query="SELECT u FROM Userreportdefinitionxref u")
public class Userreportdefinitionxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserreportdefinitionxrefPK id;

	//bi-directional many-to-one association to Useraccount
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="USERACCOUNTID", nullable=false, insertable=false, updatable=false)
	private Useraccount useraccount;

	public Userreportdefinitionxref() {
	}

	public UserreportdefinitionxrefPK getId() {
		return this.id;
	}

	public void setId(UserreportdefinitionxrefPK id) {
		this.id = id;
	}

	public Useraccount getUseraccount() {
		return this.useraccount;
	}

	public void setUseraccount(Useraccount useraccount) {
		this.useraccount = useraccount;
	}

}