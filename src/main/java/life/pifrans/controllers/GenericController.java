package life.pifrans.controllers;

import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import life.pifrans.exceptions.StandardError;

@Controller
public class GenericController<T> {
	@Autowired
	private RestTemplate restTemplate;

	private JSONObject json;
	private StandardError standardError;

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
		try {
			String url = "http://localhost/" + subPath;
			restTemplate.postForObject(url, object, object.getClass());
		} catch (HttpClientErrorException e) {
			json = new JSONObject(e.getResponseBodyAsString());
			standardError = new StandardError(json.getInt("status"), json.getString("message"), json.getLong("timeStamp"));
			addMessage(standardError);
		}
	}

	public void update(T object, Long id, String subPath) {
		String url = "http://localhost/" + subPath + "/" + id;
		restTemplate.put(url, object, id);
	}

	public void delete(Long id, String subPath) {
		String url = "http://localhost/" + subPath + "/" + id;
		restTemplate.delete(url, id);
	}

	public void addMessage(StandardError error) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, error.getMessage(), null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
