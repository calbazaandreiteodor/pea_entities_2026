package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RULESETSUCCESS database table.
 * 
 */
@Entity
@Table(name="RULESETSUCCESS")
@NamedQuery(name="Rulesetsuccess.findAll", query="SELECT r FROM Rulesetsuccess r")
public class Rulesetsuccess implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RulesetsuccessPK id;

	//bi-directional many-to-one association to Ruleset
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="RULESETID", nullable=false, insertable=false, updatable=false)
	private Ruleset ruleset;

	public Rulesetsuccess() {
	}

	public RulesetsuccessPK getId() {
		return this.id;
	}

	public void setId(RulesetsuccessPK id) {
		this.id = id;
	}

	public Ruleset getRuleset() {
		return this.ruleset;
	}

	public void setRuleset(Ruleset ruleset) {
		this.ruleset = ruleset;
	}

}