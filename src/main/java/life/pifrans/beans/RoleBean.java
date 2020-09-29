package life.pifrans.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import life.pifrans.controllers.GenericController;
import life.pifrans.models.Role;

@Named
@RequestScoped
public class RoleBean {
	@Autowired
	private GenericController<Role> controller;

	@Autowired
	private Role role;

	private static final String SUB_PATH = "roles";

	public void findAll() {
		List<Role> list = new ArrayList<>();
		list = controller.listAll(Role[].class, SUB_PATH);
		for (Role role : list) {
			System.out.println(role.getId() + " - " + role.getAccess());
		}
	}

	public void find() {
		role = controller.findById(Role.class, role.getId(), SUB_PATH);
		System.out.println(role.getId() + " - " + role.getAccess() + " - " + role.getPlayer().getName());
	}

	public void save() {
		controller.save(role, SUB_PATH);
	}

	public void update() {
		controller.update(role, role.getId(), SUB_PATH);
	}

	public void delete() {
		controller.delete(role.getId(), SUB_PATH);
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
