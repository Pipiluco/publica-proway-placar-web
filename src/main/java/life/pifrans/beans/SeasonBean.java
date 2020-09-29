package life.pifrans.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import life.pifrans.controllers.SeasonController;
import life.pifrans.models.Season;

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
