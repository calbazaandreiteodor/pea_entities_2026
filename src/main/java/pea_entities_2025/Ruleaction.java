package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the RULEACTION database table.
 * 
 */
@Entity
@Table(name="RULEACTION")
@NamedQuery(name="Ruleaction.findAll", query="SELECT r FROM Ruleaction r")
public class Ruleaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RULEACTION_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RULEACTION_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=250)
	private String name;

	@Column(nullable=false, precision=10)
	private long revision;

	//bi-directional many-to-one association to Ruleset
	@OneToMany(mappedBy="ruleaction")
	private List<Ruleset> rulesets;

	public Ruleaction() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getActive() {
		return this.active;
	}

	public void setActive(long active) {
		this.active = active;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public List<Ruleset> getRulesets() {
		return this.rulesets;
	}

	public void setRulesets(List<Ruleset> rulesets) {
		this.rulesets = rulesets;
	}

	public Ruleset addRuleset(Ruleset ruleset) {
		getRulesets().add(ruleset);
		ruleset.setRuleaction(this);

		return ruleset;
	}

	public Ruleset removeRuleset(Ruleset ruleset) {
		getRulesets().remove(ruleset);
		ruleset.setRuleaction(null);

		return ruleset;
	}

}