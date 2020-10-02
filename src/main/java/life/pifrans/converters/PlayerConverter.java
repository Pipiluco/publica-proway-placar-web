package life.pifrans.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import life.pifrans.controllers.GenericController;
import life.pifrans.models.Player;

@Component
public class PlayerConverter implements Converter<Player> {
	@Autowired
	private GenericController<Player> genericController;

	@Override
	public Player getAsObject(FacesContext context, UIComponent component, String value) {
		Player player = genericController.findById(Player.class, new Long(value), "players");
		return player;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Player value) {
		if (value instanceof Player) {
			Player player = (Player) value;
			return player.getId().toString();
		} else {
			return null;
		}
	}
}
