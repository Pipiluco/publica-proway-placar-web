package life.pifrans.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class GenericController<T> {
	@Autowired
	private RestTemplate restTemplate;

	public List<T> listAll(Class<T[]> model, String subPath) {
		String url = "http://localhost/" + subPath;
		List<T> list = Arrays.asList(restTemplate.getForObject(url, model));
		return list;
	}

	public T findById(Class<T> model, Long id, String subPath) {
		String url = "http://localhost/" + subPath + "/" + id;
		T object = restTemplate.getForObject(url, model);
		return object;
	}

	public void save(T object, String subPath) {
		String url = "http://localhost/" + subPath;
		restTemplate.postForObject(url, object, object.getClass());
	}

	public void update(T object, Long id, String subPath) {
		String url = "http://localhost/" + subPath + "/" + id;
		restTemplate.put(url, object, id);
	}

	public void delete(Long id, String subPath) {
		String url = "http://localhost/" + subPath + "/" + id;
		restTemplate.delete(url, id);
	}
}
