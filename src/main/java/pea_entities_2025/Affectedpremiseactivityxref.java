package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AFFECTEDPREMISEACTIVITYXREF database table.
 * 
 */
@Entity
@Table(name="AFFECTEDPREMISEACTIVITYXREF")
@NamedQuery(name="Affectedpremiseactivityxref.findAll", query="SELECT a FROM Affectedpremiseactivityxref a")
public class Affectedpremiseactivityxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AffectedpremiseactivityxrefPK id;

	//bi-directional many-to-one association to Activity
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ACTIVITYID", nullable=false, insertable=false, updatable=false)
	private Activity activity;

	//bi-directional many-to-one association to Affectedpremise
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="AFFECTEDPREMISEID", nullable=false, insertable=false, updatable=false)
	private Affectedpremise affectedpremise;

	public Affectedpremiseactivityxref() {
	}

	public AffectedpremiseactivityxrefPK getId() {
		return this.id;
	}

	public void setId(AffectedpremiseactivityxrefPK id) {
		this.id = id;
	}

	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Affectedpremise getAffectedpremise() {
		return this.affectedpremise;
	}

	public void setAffectedpremise(Affectedpremise affectedpremise) {
		this.affectedpremise = affectedpremise;
	}

}