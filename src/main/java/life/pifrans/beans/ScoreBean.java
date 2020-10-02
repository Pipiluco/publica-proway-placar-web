package life.pifrans.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import life.pifrans.controllers.GenericController;
import life.pifrans.models.Score;

@Named
@Scope(value = "view")
public class ScoreBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private GenericController<Score> controller;

	@Autowired
	private Score score;

	private List<Score> scores;
	private static final String SUB_PATH = "scores";
	private static final String PAGE_SCORES = "/private/scores.jsf";

	@PostConstruct
	public void init() {
		scores = controller.listAll(Score[].class, SUB_PATH);
	}

	public List<Score> findAll() {
		scores = new ArrayList<>();
		scores = controller.listAll(Score[].class, SUB_PATH);
		return scores;
	}

	public void renew() {
		score = new Score();
	}

	public void find() {
		score = controller.findById(Score.class, score.getId(), SUB_PATH);
	}

	public String save() {
		controller.save(score, SUB_PATH);
		renew();
		return PAGE_SCORES;
	}

	public String update() {
		controller.update(score, score.getId(), SUB_PATH);
		return PAGE_SCORES;
	}

	public String delete(Score score) {
		controller.delete(score.getId(), SUB_PATH);
		return PAGE_SCORES;
	}

	public String delete() {
		controller.delete(score.getId(), SUB_PATH);
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
