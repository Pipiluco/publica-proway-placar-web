package life.pifrans.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import life.pifrans.controllers.GenericController;
import life.pifrans.models.Season;

@Named
@RequestScoped
public class SeasonBean {
	@Autowired
	private GenericController<Season> controller;

	@Autowired
	private Season season;
	
	private static final String SUB_PATH = "seasons";

	public void findAll() {
		List<Season> list = new ArrayList<>();
		list = controller.listAll(Season[].class, SUB_PATH);
		for (Season season : list) {
			System.out.println(season.getMaximumRecord() + " - " + season.getMinimumRecord());
		}
	}

	public void find() {
		season = controller.findById(Season.class, season.getId(), SUB_PATH);
		System.out.println(season.getMaximumRecord() + " - " + season.getMinimumRecord());
	}

	public void save() {
		controller.save(season, SUB_PATH);
	}

	public void update() {
		controller.update(season, season.getId(), SUB_PATH);
	}

	public void delete() {
		controller.delete(season.getId(), SUB_PATH);
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}
}
