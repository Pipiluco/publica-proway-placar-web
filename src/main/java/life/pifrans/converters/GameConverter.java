package life.pifrans.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.joinfaces.autoconfigure.butterfaces.ButterfacesProperties.Integration.Primefaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import life.pifrans.controllers.GenericController;
import life.pifrans.models.Game;

/**
 * Classe {@link Converter} para trabalhar com componetes selectOneMenu do tipo {@link Game} no JSF ou {@link Primefaces}
 */
@Component
public class GameConverter implements Converter<Game> {
	@Autowired
	private GenericController<Game> genericController;

	@Override
	public Game getAsObject(FacesContext context, UIComponent component, String value) {
		Game game = genericController.findById(Game.class, new Long(value), "games");
		return game;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Game value) {
		if (value instanceof Game) {
			Game game = (Game) value;
			return game.getId().toString();
		} else {
			return null;
		}
	}
}
