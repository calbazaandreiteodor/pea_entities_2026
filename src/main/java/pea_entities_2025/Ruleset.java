package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.ModelType;

import java.util.List;


/**
 * The persistent class for the RULESET database table.
 * 
 */
@Entity
@Table(name="RULESET")
@NamedQuery(name="Ruleset.findAll", query="SELECT r FROM Ruleset r")
public class Ruleset implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RULESET_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RULESET_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=250)
	private String classname;

	@Column(nullable=false, length=2000)
	private String description;

	@Column(nullable=false, precision=1)
	private long mandatory;

	@Column(nullable=false, length=100)
	private String name;

	@Column(nullable=false, precision=10)
	private long revision;

	//bi-directional many-to-one association to Rule
	@OneToMany(mappedBy="ruleset")
	private List<Rule> rules;

	//bi-directional many-to-one association to Modeltype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MODELTYPEID")
	private ModelType modeltype;

	//bi-directional many-to-one association to Ruleaction
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ACTIONID", nullable=false)
	private Ruleaction ruleaction;

	//bi-directional many-to-one association to Rulesetfaulure
	@OneToMany(mappedBy="ruleset")
	private List<Rulesetfaulure> rulesetfaulures;

	//bi-directional many-to-one association to Rulesetsuccess
	@OneToMany(mappedBy="ruleset")
	private List<Rulesetsuccess> rulesetsuccesses;

	public Ruleset() {
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

	public long getMandatory() {
		return this.mandatory;
	}

	public void setMandatory(long mandatory) {
		this.mandatory = mandatory;
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

	public List<Rule> getRules() {
		return this.rules;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

	public Rule addRule(Rule rule) {
		getRules().add(rule);
		rule.setRuleset(this);

		return rule;
	}

	public Rule removeRule(Rule rule) {
		getRules().remove(rule);
		rule.setRuleset(null);

		return rule;
	}

	public ModelType getModeltype() {
		return this.modeltype;
	}

	public void setModeltype(ModelType modeltype) {
		this.modeltype = modeltype;
	}

	public Ruleaction getRuleaction() {
		return this.ruleaction;
	}

	public void setRuleaction(Ruleaction ruleaction) {
		this.ruleaction = ruleaction;
	}

	public List<Rulesetfaulure> getRulesetfaulures() {
		return this.rulesetfaulures;
	}

	public void setRulesetfaulures(List<Rulesetfaulure> rulesetfaulures) {
		this.rulesetfaulures = rulesetfaulures;
	}

	public Rulesetfaulure addRulesetfaulure(Rulesetfaulure rulesetfaulure) {
		getRulesetfaulures().add(rulesetfaulure);
		rulesetfaulure.setRuleset(this);

		return rulesetfaulure;
	}

	public Rulesetfaulure removeRulesetfaulure(Rulesetfaulure rulesetfaulure) {
		getRulesetfaulures().remove(rulesetfaulure);
		rulesetfaulure.setRuleset(null);

		return rulesetfaulure;
	}

	public List<Rulesetsuccess> getRulesetsuccesses() {
		return this.rulesetsuccesses;
	}

	public void setRulesetsuccesses(List<Rulesetsuccess> rulesetsuccesses) {
		this.rulesetsuccesses = rulesetsuccesses;
	}

	public Rulesetsuccess addRulesetsuccess(Rulesetsuccess rulesetsuccess) {
		getRulesetsuccesses().add(rulesetsuccess);
		rulesetsuccess.setRuleset(this);

		return rulesetsuccess;
	}

	public Rulesetsuccess removeRulesetsuccess(Rulesetsuccess rulesetsuccess) {
		getRulesetsuccesses().remove(rulesetsuccess);
		rulesetsuccess.setRuleset(null);

		return rulesetsuccess;
	}

}