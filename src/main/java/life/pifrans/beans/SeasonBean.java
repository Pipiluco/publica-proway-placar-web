package life.pifrans.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import life.pifrans.controllers.GameController;
import life.pifrans.controllers.SeasonController;
import life.pifrans.models.Game;
import life.pifrans.models.Season;

@Named
@Scope(value = "view")
public class SeasonBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private SeasonController seasonController;

	@Autowired
	private GameController gameController;

	@Autowired
	private Season season;

	private List<Season> seasons;

	private static final String SUB_PATH = "seasons";
	private static final String PAGE_SEASONS = "/private/seasons.jsf";

	@PostConstruct
	public void init() {
		seasons = seasonController.listAll(Season[].class, SUB_PATH);
		for (Season season : seasons) {
			season.setGames(gameController.findGamesBySeasonId("season", season.getId()));

			List<Game> games = season.getGames();
			season.setMinimumRecord(games.get(0).getTotalPoints());
			season.setMaximumRecord(games.get(0).getTotalPoints());

			for (Game game : games) {
				if (game.getTotalPoints() < season.getMinimumRecord()) {
					season.setMinimumRecord(game.getTotalPoints());
				}
				if (game.getTotalPoints() > season.getMaximumRecord()) {
					season.setMaximumRecord(game.getTotalPoints());
				}
				seasonController.update(season, season.getId(), SUB_PATH);
			}
		}
	}

	public List<Season> findAll() {
		seasons = new ArrayList<>();
		seasons = seasonController.listAll(Season[].class, SUB_PATH);
		return seasons;
	}

	public void find() {
		season = seasonController.findById(Season.class, season.getId(), SUB_PATH);
	}

	public void renew() {
		season = new Season();
	}

	public String save() {
		season.setMinimumRecord(0);
		season.setMaximumRecord(0);
		seasonController.save(season, SUB_PATH);
		renew();
		return PAGE_SEASONS;
	}

	public String update() {
		seasonController.update(season, season.getId(), SUB_PATH);
		return PAGE_SEASONS;
	}

	public String delete(Season season) {
		seasonController.delete(season.getId(), SUB_PATH);
		return PAGE_SEASONS;
	}

	public String delete() {
		seasonController.delete(season.getId(), SUB_PATH);
		season = new Season();
		return PAGE_SEASONS;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public List<Season> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}

}
