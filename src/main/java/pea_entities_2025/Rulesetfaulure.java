package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RULESETFAULURE database table.
 * 
 */
@Entity
@Table(name="RULESETFAULURE")
@NamedQuery(name="Rulesetfaulure.findAll", query="SELECT r FROM Rulesetfaulure r")
public class Rulesetfaulure implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RulesetfaulurePK id;

	//bi-directional many-to-one association to Ruleset
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="RULESETID", nullable=false, insertable=false, updatable=false)
	private Ruleset ruleset;

	public Rulesetfaulure() {
	}

	public RulesetfaulurePK getId() {
		return this.id;
	}

	public void setId(RulesetfaulurePK id) {
		this.id = id;
	}

	public Ruleset getRuleset() {
		return this.ruleset;
	}

	public void setRuleset(Ruleset ruleset) {
		this.ruleset = ruleset;
	}

}