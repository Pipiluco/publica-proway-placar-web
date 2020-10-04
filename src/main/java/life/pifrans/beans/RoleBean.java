package life.pifrans.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import life.pifrans.controllers.GenericController;
import life.pifrans.models.Role;

/**
 * Classe Bean para manipulação de dados em páginas web
 */
@Named
@Scope(value = "view")
public class RoleBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private GenericController<Role> controller;

	@Autowired
	private Role role;

	private List<Role> roles;
	private static final String SUB_PATH = "roles";
	private static final String PAGE_ROLES = "/private/roles.jsf";

	@PostConstruct
	public void init() {
		roles = controller.listAll(Role[].class, SUB_PATH);
	}

	public List<Role> findAll() {
		roles = new ArrayList<>();
		roles = controller.listAll(Role[].class, SUB_PATH);
		return roles;
	}

	public void find() {
		role = controller.findById(Role.class, role.getId(), SUB_PATH);
	}

	public void renew() {
		role = new Role();
	}

	public String save() {
		controller.save(role, SUB_PATH);
		renew();
		return PAGE_ROLES;
	}

	public String update() {
		controller.update(role, role.getId(), SUB_PATH);
		return PAGE_ROLES;
	}

	public String delete(Role role) {
		controller.delete(role.getId(), SUB_PATH);
		return PAGE_ROLES;
	}

	public String delete() {
		controller.delete(role.getId(), SUB_PATH);
		renew();
		return PAGE_ROLES;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
