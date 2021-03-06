package life.pifrans.models;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Score implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer points;
	private Integer minimumSeason;
	private Integer maximumSeason;
	private Integer minimumRecord;
	private Integer maximumRecord;
	private Player player;
	private Game game;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getMinimumSeason() {
		return minimumSeason;
	}

	public Integer getMaximumSeason() {
		return maximumSeason;
	}

	public Integer getMinimumRecord() {
		return minimumRecord;
	}

	public Integer getMaximumRecord() {
		return maximumRecord;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
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
		Score other = (Score) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
