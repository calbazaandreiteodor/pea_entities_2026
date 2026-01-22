package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the "RULE" database table.
 * 
 */
@Entity
@Table(name="\"RULE\"")
@NamedQuery(name="Rule.findAll", query="SELECT r FROM Rule r")
public class Rule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RULE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RULE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=250)
	private String classname;

	@Column(length=2000)
	private String description;

	@Column(nullable=false, length=100)
	private String name;

	@Column(nullable=false, precision=10)
	private long revision;

	//bi-directional many-to-one association to Ruleset
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="RULESETID")
	private Ruleset ruleset;

	//bi-directional many-to-many association to Rule
	@ManyToMany
	@JoinTable(
		name="RULEFAILUREXREF"
		, joinColumns={
@JoinColumn(name="FROMRULEID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="TORULEID", nullable=false)
			}
		)
	private List<Rule> rules1;

	//bi-directional many-to-many association to Rule
	@ManyToMany(mappedBy="rules1")
	private List<Rule> rules2;

	//bi-directional many-to-many association to Rule
	@ManyToMany
	@JoinTable(
		name="RULESUCCESSXREF"
		, joinColumns={
@JoinColumn(name="TORULEID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="FROMRULEID", nullable=false)
			}
		)
	private List<Rule> rules3;

	//bi-directional many-to-many association to Rule
	@ManyToMany(mappedBy="rules3")
	private List<Rule> rules4;

	public Rule() {
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

	public String getClassname() {
		return this.classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Ruleset getRuleset() {
		return this.ruleset;
	}

	public void setRuleset(Ruleset ruleset) {
		this.ruleset = ruleset;
	}

	public List<Rule> getRules1() {
		return this.rules1;
	}

	public void setRules1(List<Rule> rules1) {
		this.rules1 = rules1;
	}

	public List<Rule> getRules2() {
		return this.rules2;
	}

	public void setRules2(List<Rule> rules2) {
		this.rules2 = rules2;
	}

	public List<Rule> getRules3() {
		return this.rules3;
	}

	public void setRules3(List<Rule> rules3) {
		this.rules3 = rules3;
	}

	public List<Rule> getRules4() {
		return this.rules4;
	}

	public void setRules4(List<Rule> rules4) {
		this.rules4 = rules4;
	}

}