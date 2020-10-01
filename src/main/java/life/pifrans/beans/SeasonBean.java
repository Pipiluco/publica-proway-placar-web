package life.pifrans.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import life.pifrans.controllers.GenericController;
import life.pifrans.models.Season;

@Named
@Scope(value = "view")
public class SeasonBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private GenericController<Season> controller;

	@Autowired
	private Season season;

	private List<Season> seasons;

	private static final String SUB_PATH = "seasons";
	private static final String PAGE_SEASONS = "/private/seasons.jsf";

	@PostConstruct
	public void init() {
		seasons = controller.listAll(Season[].class, SUB_PATH);
	}

	public List<Season> findAll() {
		seasons = new ArrayList<>();
		seasons = controller.listAll(Season[].class, SUB_PATH);
		return seasons;
	}

	public void find() {
		season = controller.findById(Season.class, season.getId(), SUB_PATH);
		System.out.println(season.getMaximumRecord() + " - " + season.getMinimumRecord());
	}

	public void renew() {
		season = new Season();
	}

	public String save() {
		season.setMinimumRecord(0);
		season.setMaximumRecord(0);
		controller.save(season, SUB_PATH);
		return PAGE_SEASONS;
	}

	public String update() {
		controller.update(season, season.getId(), SUB_PATH);
		return PAGE_SEASONS;
	}

	public String delete(Season season) {
		controller.delete(season.getId(), SUB_PATH);
		return PAGE_SEASONS;
	}

	public String delete() {
		controller.delete(season.getId(), SUB_PATH);
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
