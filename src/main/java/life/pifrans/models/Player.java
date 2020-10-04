package life.pifrans.models;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Player extends User {
	private static final long serialVersionUID = 1L;
	private List<Score> scores;

	public Player() {
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

}
