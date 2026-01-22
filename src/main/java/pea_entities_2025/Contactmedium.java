package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the CONTACTMEDIUM database table.
 * 
 */
@Entity
@Table(name="CONTACTMEDIUM")
@NamedQuery(name="Contactmedium.findAll", query="SELECT c FROM Contactmedium c")
public class Contactmedium implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONTACTMEDIUM_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTACTMEDIUM_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=250)
	private String description;

	@Column(precision=5)
	private long displayorder;

	@Column(nullable=false, precision=1)
	private long emailable;

	@Column(nullable=false, precision=1)
	private long faxable;

	@Column(nullable=false, precision=1)
	private long mobiledevice;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=16)
	private String shortcode;

	@Column(precision=1)
	private long textable;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="contactmedium")
	private List<Contact> contacts;

	public Contactmedium() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getDisplayorder() {
		return this.displayorder;
	}

	public void setDisplayorder(long displayorder) {
		this.displayorder = displayorder;
	}

	public long getEmailable() {
		return this.emailable;
	}

	public void setEmailable(long emailable) {
		this.emailable = emailable;
	}

	public long getFaxable() {
		return this.faxable;
	}

	public void setFaxable(long faxable) {
		this.faxable = faxable;
	}

	public long getMobiledevice() {
		return this.mobiledevice;
	}

	public void setMobiledevice(long mobiledevice) {
		this.mobiledevice = mobiledevice;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public long getTextable() {
		return this.textable;
	}

	public void setTextable(long textable) {
		this.textable = textable;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Contact addContact(Contact contact) {
		getContacts().add(contact);
		contact.setContactmedium(this);

		return contact;
	}

	public Contact removeContact(Contact contact) {
		getContacts().remove(contact);
		contact.setContactmedium(null);

		return contact;
	}

}