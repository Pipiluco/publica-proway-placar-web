package life.pifrans.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import life.pifrans.models.Score;

@Controller
public class ScoreController extends GenericController<Score> {
	@Autowired
	private RestTemplate restTemplate;

	private static final String BASE_URL = "http://localhost/scores/";

	public Score findMinMaxRecord(String subPath, Long id) {
		String url = BASE_URL + subPath + "/" + id;
		Score object = restTemplate.getForObject(url, Score.class);
		return object;
	}

	public List<Score> findScoresByGamesId(String subPath, Long id) {
		String url = BASE_URL + subPath + "/" + id;
		List<Score> list = Arrays.asList(restTemplate.getForObject(url, Score[].class));
		return list;
	}

	public int findPointsByGameId(String subPath, Long id) {
		String url = BASE_URL + subPath + "/" + id + "/points";
		int points = restTemplate.getForObject(url, Integer.class);
		return points;
	}
}
