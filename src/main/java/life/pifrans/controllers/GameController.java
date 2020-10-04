package life.pifrans.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import life.pifrans.models.Game;

/**
 * Classe {@link Controller} para trabalhar com métodos {@link Game} específicos da API
 */
@Controller
public class GameController extends GenericController<Game> {
	@Autowired
	private RestTemplate restTemplate;

	private static final String BASE_URL = "http://localhost/games/";
	
	public List<Game> findGamesBySeasonId(String subPath, Long id) {
		String url = BASE_URL + subPath + "/" + id;
		List<Game> list = Arrays.asList(restTemplate.getForObject(url, Game[].class));
		return list;
	}
}
