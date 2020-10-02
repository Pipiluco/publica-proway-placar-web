package life.pifrans.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import life.pifrans.controllers.GenericController;
import life.pifrans.models.Season;

@Component
public class SeasonConverter implements Converter<Season> {
	@Autowired
	private GenericController<Season> genericController;

	@Override
	public Season getAsObject(FacesContext context, UIComponent component, String value) {
		Season season = genericController.findById(Season.class, new Long(value), "seasons");
		return season;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Season value) {
		if (value instanceof Season) {
			Season season = (Season) value;
			return season.getId().toString();
		} else {
			return null;
		}
	}
}
