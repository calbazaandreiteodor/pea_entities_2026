package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;


/**
 * The persistent class for the EVENTCUSTOMERSCHANGE database table.
 * 
 */
@Entity
@Table(name="EVENTCUSTOMERSCHANGE")
@NamedQuery(name="Eventcustomerschange.findAll", query="SELECT e FROM Eventcustomerschange e")
public class Eventcustomerschange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"ACTION\"", precision=1)
	private long action;

	@Column(nullable=false)
	private long amount;

	@Column(nullable=false)
	private LocalDateTime datechanged;

	@Column(precision=10)
	private long distributionareaid;

	@Column(precision=10)
	private long eventid;

	@Column(precision=10)
	private long eventlevelid;

	@Column(precision=10)
	private long eventstatusid;

	@Column(precision=10)
	private long eventtypeid;

	private LocalDateTime inserttime;

	@Column(precision=10)
	private long parenteventid;

	public Eventcustomerschange() {
	}

	public long getAction() {
		return this.action;
	}

	public void setAction(long action) {
		this.action = action;
	}

	public long getAmount() {
		return this.amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public LocalDateTime getDatechanged() {
		return this.datechanged;
	}

	public void setDatechanged(LocalDateTime datechanged) {
		this.datechanged = datechanged;
	}

	public long getDistributionareaid() {
		return this.distributionareaid;
	}

	public void setDistributionareaid(long distributionareaid) {
		this.distributionareaid = distributionareaid;
	}

	public long getEventid() {
		return this.eventid;
	}

	public void setEventid(long eventid) {
		this.eventid = eventid;
	}

	public long getEventlevelid() {
		return this.eventlevelid;
	}

	public void setEventlevelid(long eventlevelid) {
		this.eventlevelid = eventlevelid;
	}

	public long getEventstatusid() {
		return this.eventstatusid;
	}

	public void setEventstatusid(long eventstatusid) {
		this.eventstatusid = eventstatusid;
	}

	public long getEventtypeid() {
		return this.eventtypeid;
	}

	public void setEventtypeid(long eventtypeid) {
		this.eventtypeid = eventtypeid;
	}

	public LocalDateTime getInserttime() {
		return this.inserttime;
	}

	public void setInserttime(LocalDateTime inserttime) {
		this.inserttime = inserttime;
	}

	public long getParenteventid() {
		return this.parenteventid;
	}

	public void setParenteventid(long parenteventid) {
		this.parenteventid = parenteventid;
	}

}