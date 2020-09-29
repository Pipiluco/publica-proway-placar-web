package life.pifrans.models;

import java.io.Serializable;
import java.util.List;

public class Season implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private List<Game> games;

	private Integer maximumRecord;
	private Integer minimumRecord;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public Integer getMaximumRecord() {
		return maximumRecord;
	}

	public void setMaximumRecord(Integer maximumRecord) {
		this.maximumRecord = maximumRecord;
	}

	public Integer getMinimumRecord() {
		return minimumRecord;
	}

	public void setMinimumRecord(Integer minimumRecord) {
		this.minimumRecord = minimumRecord;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Season other = (Season) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
