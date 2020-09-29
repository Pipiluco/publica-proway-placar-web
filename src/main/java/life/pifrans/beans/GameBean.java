package life.pifrans.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import life.pifrans.controllers.GenericController;
import life.pifrans.models.Game;

@Named
@RequestScoped
public class GameBean {
	@Autowired
	private GenericController<Game> controller;

	@Autowired
	private Game game;

	private static final String SUB_PATH = "games";

	public void findAll() {
		List<Game> list = new ArrayList<>();
		list = controller.listAll(Game[].class, SUB_PATH);
		for (Game game : list) {
			System.out.println(game.getId() + " - " + game.getDate());
		}
	}

	public void find() {
		game = controller.findById(Game.class, game.getId(), SUB_PATH);
		System.out.println(game.getId() + " - " + game.getDate());
	}

	public void save() {
		controller.save(game, SUB_PATH);
	}

	public void update() {
		controller.update(game, game.getId(), SUB_PATH);
	}

	public void delete() {
		controller.delete(game.getId(), SUB_PATH);
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
