package life.pifrans.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import life.pifrans.controllers.ScoreController;
import life.pifrans.models.Score;

/**
 * Classe Bean para manipulação de dados em páginas web
 */
@Named
@Scope(value = "view")
public class ScoreBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ScoreController scoreController;

	@Autowired
	private Score score;

	private List<Score> scores;
	private static final String SUB_PATH = "scores";
	private static final String PAGE_SCORES = "/private/scores.jsf";

	@PostConstruct
	public void init() {
		scores = scoreController.listAll(Score[].class, SUB_PATH);
	}

	public List<Score> findAll() {
		scores = new ArrayList<>();
		scores = scoreController.listAll(Score[].class, SUB_PATH);
		return scores;
	}

	public void renew() {
		score = new Score();
	}

	public void find() {
		score = scoreController.findById(Score.class, score.getId(), SUB_PATH);
	}

	public Score findMinRecord(Long id) {
		Score score = scoreController.findMinMaxRecord("min-record-player", id);
		return score;
	}

	public Score findMaxRecord(Long id) {
		Score score = scoreController.findMinMaxRecord("max-record-player", id);
		return score;
	}

	public String save() {
		scoreController.save(score, SUB_PATH);
		renew();
		return PAGE_SCORES;
	}

	public String update() {
		scoreController.update(score, score.getId(), SUB_PATH);
		return PAGE_SCORES;
	}

	public String delete(Score score) {
		scoreController.delete(score.getId(), SUB_PATH);
		return PAGE_SCORES;
	}

	public String delete() {
		scoreController.delete(score.getId(), SUB_PATH);
		renew();
		return PAGE_SCORES;
	}
 
	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
}
