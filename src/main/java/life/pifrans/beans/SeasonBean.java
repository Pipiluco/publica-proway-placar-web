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

	public void findAll() {
		List<Season> list = new ArrayList<>();
		list = controller.listAll(Season[].class, "seasons");
		for (Season season : list) {
			System.out.println(season.getMaximumRecord() + " - " + season.getMinimumRecord());
		}
	}

	public void find() {
		season = controller.findById(Season.class, season.getId(), "seasons");
		System.out.println(season.getMaximumRecord() + " - " + season.getMinimumRecord());
	}

	public void save() {
		controller.save(season, "seasons");;
	}

	public void update() {
		controller.update(season, season.getId(), "seasons");;
	}

	public void delete() {
		controller.delete(season.getId(), "seasons");;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}
}


/*
@Named
@RequestScoped
public class SeasonBean {

	@Autowired
	private SeasonController seasonController;

	@Autowired
	private Season season;

	public void findAll() {
		seasonController.listAll();
	}

	public void find() {
		seasonController.findById(season.getId());
	}

	public void save() {
		seasonController.save(season);
	}

	public void update() {
		seasonController.update(season);
	}

	public void delete() {
		seasonController.delete(season);
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}
}

*/