package pea_entities_2025.service.auth;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.EventCondition;
import pea_entities_2025.HistoricalPassword;
import pea_entities_2025.OrganisationalUnit;
import pea_entities_2025.ReportDefinition;
import pea_entities_2025.Role;
import pea_entities_2025.Useraccountstatus;
import pea_entities_2025.resourcemanagement.Crew;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;


/**
 * The persistent class for the USERACCOUNT database table.
 * 
 */
@Entity
@Table(name="USERACCOUNT")
@NamedQuery(name="UserAccount.findAll", query="SELECT u FROM UserAccount u")
public class UserAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERACCOUNT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERACCOUNT_ID_GENERATOR")
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false)
	private boolean external;

	@Column(nullable=false, length=255)
	private String hashPassword;

	@Column
	private short noOfActiveLogins;

	@Column
	private long noOfConsecutiveLoginFailures;

	@Column(nullable=false)
	private LocalDateTime passwordexpirydate;

	@Column(precision=1)
	private long pdpaconsent;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=15)
	private String username;


	@OneToMany(mappedBy="useraccount")
	private HashSet<HistoricalPassword> historicalPasswordsCollection;

	@OneToMany(mappedBy="userAccount")
	private List<LockToken> lockTokens;



	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USERACCOUNTSTATUSID", nullable=false)
	private Useraccountstatus userAccountStatus;

	@ManyToMany
	@JoinTable(name="USERALARMTYPEXREF"	,
				joinColumns={@JoinColumn(name="USERACCOUNTID", nullable=false)}
				, inverseJoinColumns={@JoinColumn(name="EVENTCONDITIONID", nullable=false)}
		)
	private List<EventCondition> alarmTypes;

	@ManyToMany
	@JoinTable(	name="USERORGANISATIONALUNITXREF"
		, joinColumns={@JoinColumn(name="USERACCOUNTID", nullable=false)}
		, inverseJoinColumns={@JoinColumn(name="ORGANISATIONALUNITID", nullable=false)
			}
		)
	private List<OrganisationalUnit> organisationalunits;

	@ManyToMany
	@JoinTable(name = "USERREPORTDEFINITIONXREF", 
				joinColumns = {@JoinColumn(name = "USERACCOUNTID", nullable = false) }, 
				inverseJoinColumns = {@JoinColumn(name = "REPORTDEFINITIONID", nullable = false) }
			)
	private List<ReportDefinition> reports;

	@ManyToMany
	@JoinTable(	name="USERROLEXREF"
		, joinColumns={@JoinColumn(name="USERACCOUNTID", nullable=false)}
		, inverseJoinColumns={@JoinColumn(name="ROLEID", nullable=false)}
		)
	private List<Role> relatedRoles;

	@OneToMany(mappedBy="userAccount")
	private List<UserSession> userSessions;

	public UserAccount() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
}