package life.pifrans.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import life.pifrans.models.Season;

@Controller
public class SeasonController {
	@Autowired
	private RestTemplate restTemplate;

	public List<Season> listAll() {
		String url = "http://localhost/seasons";
		List<Season> list = Arrays.asList(restTemplate.getForObject(url, Season[].class));
		return list;
	}

	public Season findById(Long id) {
		String url = "http://localhost/seasons/" + id;
		Season season = restTemplate.getForObject(url, Season.class);
		return season;
	}

	public void save(Season season) {
		String url = "http://localhost/seasons";
		restTemplate.postForObject(url, season, Season.class);
	}

	public void update(Season season) {
		String url = "http://localhost/seasons/" + season.getId();
		restTemplate.put(url, season, season.getId());
	}

	public void delete(Season season) {
		String url = "http://localhost/seasons/" + season.getId();
		restTemplate.delete(url, season.getId());
	}
}
