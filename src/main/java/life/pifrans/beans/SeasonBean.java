package life.pifrans.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import life.pifrans.controllers.SeasonController;

@Named
@RequestScoped
public class SeasonBean {

	@Autowired
	private SeasonController seasonController;
	
	public void teste() {
		seasonController.listAll();
	}
}
