package life.pifrans.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import life.pifrans.controllers.GenericController;
import life.pifrans.models.Player;

@Named
@RequestScoped
public class PlayerBean {
	@Autowired
	private GenericController<Player> controller;

	@Autowired
	private Player player;

	private static final String SUB_PATH = "players";

	public void findAll() {
		List<Player> list = new ArrayList<>();
		list = controller.listAll(Player[].class, SUB_PATH);
		for (Player player : list) {
			System.out.println(player.getName() + " - " + player.getLastName());
		}
	}

	public void find() {
		player = controller.findById(Player.class, player.getId(), SUB_PATH);
		System.out.println(player.getName() + " - " + player.getLastName());
	}

	public void save() {
		controller.save(player, SUB_PATH);
	}

	public void update() {
		controller.update(player, player.getId(), SUB_PATH);
	}

	public void delete() {
		controller.delete(player.getId(), SUB_PATH);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
