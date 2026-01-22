package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SCHEMATICDEVICENODEXREF database table.
 * 
 */
@Embeddable
public class SchematicdevicenodexrefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long deviceid;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long schematicgraphid;

	public SchematicdevicenodexrefPK() {
	}
	public long getDeviceid() {
		return this.deviceid;
	}
	public void setDeviceid(long deviceid) {
		this.deviceid = deviceid;
	}
	public long getSchematicgraphid() {
		return this.schematicgraphid;
	}
	public void setSchematicgraphid(long schematicgraphid) {
		this.schematicgraphid = schematicgraphid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SchematicdevicenodexrefPK)) {
			return false;
		}
		SchematicdevicenodexrefPK castOther = (SchematicdevicenodexrefPK)other;
		return 
			(this.deviceid == castOther.deviceid)
			&& (this.schematicgraphid == castOther.schematicgraphid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.deviceid ^ (this.deviceid >>> 32)));
		hash = hash * prime + ((int) (this.schematicgraphid ^ (this.schematicgraphid >>> 32)));
		
		return hash;
	}
}