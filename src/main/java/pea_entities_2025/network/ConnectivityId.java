package pea_entities_2025.network;

import java.io.Serializable;
import java.util.Objects;

public class ConnectivityId implements Serializable{
	

	    private static final long serialVersionUID = 11111L;
			private long fromTerminal;
	    private long toTerminal;

	    public ConnectivityId() {}

	    public ConnectivityId(int fromTerminal, int toTerminal) {
	        this.fromTerminal = fromTerminal;
	        this.toTerminal = toTerminal;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        ConnectivityId that = (ConnectivityId) o;
	        return fromTerminal == that.fromTerminal && toTerminal == that.toTerminal;
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(fromTerminal, toTerminal);
	    }




}
