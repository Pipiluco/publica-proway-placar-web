package life.pifrans.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import life.pifrans.controllers.GenericController;
import life.pifrans.models.Score;

@Named
@RequestScoped
public class ScoreBean {
	@Autowired
	private GenericController<Score> controller;

	@Autowired
	private Score score;

	private static final String SUB_PATH = "scores";

	public void findAll() {
		List<Score> list = new ArrayList<>();
		list = controller.listAll(Score[].class, SUB_PATH);
		for (Score score : list) {
			System.out.println(score.getId() + " - " + score.getPoints());
		}
	}

	public void find() {
		score = controller.findById(Score.class, score.getId(), SUB_PATH);
		System.out.println(score.getId() + " - " + score.getPoints());
	}

	public void save() {
		controller.save(score, SUB_PATH);
	}

	public void update() {
		controller.update(score, score.getId(), SUB_PATH);
	}

	public void delete() {
		controller.delete(score.getId(), SUB_PATH);
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

}
