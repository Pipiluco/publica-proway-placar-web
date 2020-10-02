package life.pifrans.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import life.pifrans.controllers.GenericController;
import life.pifrans.models.Player;

@Named
@Scope(value = "view")
public class PlayerBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private GenericController<Player> controller;

	@Autowired
	private Player player;

	private List<Player> players;
	private static final String SUB_PATH = "players";
	private static final String PAGE_PLAYERS = "/private/players.jsf";

	@PostConstruct
	public void init() {
		players = controller.listAll(Player[].class, SUB_PATH);
	}

	public List<Player> findAll() {
		players = new ArrayList<>();
		players = controller.listAll(Player[].class, SUB_PATH);
		return players;
	}

	public void find() {
		player = controller.findById(Player.class, player.getId(), SUB_PATH);
	}

	public void renew() {
		player = new Player();
	}

	public String save() {
		player.setCurrentAccess(null);
		player.setLastAccess(null);
		player.setActive(true);
		player.setGame(null);
		controller.save(player, SUB_PATH);
		renew();
		return PAGE_PLAYERS;
	}

	public String update() {
		controller.update(player, player.getId(), SUB_PATH);
		return PAGE_PLAYERS;
	}

	public String delete(Player player) {
		controller.delete(player.getId(), SUB_PATH);
		return PAGE_PLAYERS;
	}

	public String delete() {
		controller.delete(player.getId(), SUB_PATH);
		renew();
		return PAGE_PLAYERS;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}
