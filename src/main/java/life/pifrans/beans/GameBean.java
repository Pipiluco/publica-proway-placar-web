package life.pifrans.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import life.pifrans.controllers.GenericController;
import life.pifrans.models.Game;

@Named
@Scope(value = "view")
public class GameBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private GenericController<Game> controller;

	@Autowired
	private Game game;

	private List<Game> games;
	private static final String SUB_PATH = "games";
	private static final String PAGE_GAMES = "/private/games.jsf";

	@PostConstruct
	public void init() {
		games = controller.listAll(Game[].class, SUB_PATH);
	}

	public void findAll() {
		games = new ArrayList<>();
		games = controller.listAll(Game[].class, SUB_PATH);

	}

	public void find() {
		game = controller.findById(Game.class, game.getId(), SUB_PATH);
		System.out.println(game.getId() + " - " + game.getDate());
	}

	public void renew() {
		game = new Game();
	}

	public String save() {
		controller.save(game, SUB_PATH);
		return PAGE_GAMES;
	}

	public String update() {
		controller.update(game, game.getId(), SUB_PATH);
		return PAGE_GAMES;
	}

	public String delete() {
		controller.delete(game.getId(), SUB_PATH);
		return PAGE_GAMES;
	}

	public String delete(Game game) {
		controller.delete(game.getId(), SUB_PATH);
		return PAGE_GAMES;
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

}
