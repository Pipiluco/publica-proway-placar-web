package life.pifrans.models;

import java.util.ArrayList;
import java.util.List;

public class Player extends User {
	private static final long serialVersionUID = 1L;
	private List<Score> scores;
	private Game game;
	private List<Role> roles = new ArrayList<>();

	public Player() {
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
