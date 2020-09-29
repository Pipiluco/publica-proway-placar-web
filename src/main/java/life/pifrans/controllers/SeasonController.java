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
	
	public List<Season> listAll(){
		String url = "http://localhost/seasons";
		List<Season> list = Arrays.asList(restTemplate.getForObject(url, Season[].class));
		
		for (Season season : list) {
			System.out.println("Season: " + season.getMaximumRecord());
		}
		return list;
	}
}
