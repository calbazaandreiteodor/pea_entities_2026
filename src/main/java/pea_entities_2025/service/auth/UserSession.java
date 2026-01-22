package pea_entities_2025.service.auth;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;


/**
 * The persistent class for the USERSESSION database table.
 * 
 */
@Entity
@Table(name="USERSESSION")
@NamedQuery(name="UserSession.findAll", query="SELECT u FROM UserSession u")
public class UserSession implements Serializable {
	private static final long serialVersionUID =56L;

	@Id
	private long tokenKey;

	@Column
	private boolean active;

	@Column(length=256)
	private String hostName;
	
	@Column
	private LocalDateTime loginTime;

	@Version
	private short revision;

	@Column(length=256)
	private String sessionId;

	@Column(length=256)
	private String userName;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USERACCOUNTID")
	private UserAccount userAccount;

	public UserSession() {
	}

	

}