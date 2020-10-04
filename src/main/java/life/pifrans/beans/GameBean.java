package life.pifrans.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import life.pifrans.controllers.GameController;
import life.pifrans.controllers.ScoreController;
import life.pifrans.models.Game;
import life.pifrans.models.Score;

@Named
@Scope(value = "view")
public class GameBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private GameController gameController;

	@Autowired
	private ScoreController scoreController;

	@Autowired
	private Game game;

	private List<Game> games;

	private static final String SUB_PATH = "games";
	private static final String PAGE_GAMES = "/private/games.jsf";
	private Date currentDate = new Date();

	@PostConstruct
	public void init() {
		games = gameController.listAll(Game[].class, SUB_PATH);
		for (Game game : games) {
			game.setScores(scoreController.findScoresByGamesId("game", game.getId()));
		}

		for (Game game : games) {
			for (Score score : game.getScores()) {
				game.setTotalPoints(game.getTotalPoints() + score.getPoints());
			}
			gameController.update(game, game.getId(), SUB_PATH);
		}
	}

	public void findAll() {
		games = new ArrayList<>();
		games = gameController.listAll(Game[].class, SUB_PATH);

	}

	public void find() {
		game = gameController.findById(Game.class, game.getId(), SUB_PATH);
	}

	public void renew() {
		game = new Game();
	}

	public String save() {
		gameController.save(game, SUB_PATH);
		renew();
		return PAGE_GAMES;
	}

	public String update() {
		gameController.update(game, game.getId(), SUB_PATH);
		return PAGE_GAMES;
	}

	public String delete() {
		gameController.delete(game.getId(), SUB_PATH);
		return PAGE_GAMES;
	}

	public String delete(Game game) {
		gameController.delete(game.getId(), SUB_PATH);
		return PAGE_GAMES;
	}

	public List<Game> findGamesBySeasonId() {
		games = gameController.findGamesBySeasonId("season", 1L);
		return games;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
}
