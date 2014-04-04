package com.vinod.docsch.view.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.TabChangeEvent;

import com.vinod.docsch.service.UserService;
import com.vinod.docsch.view.bean.RoleDataBean;
import com.vinod.docsch.view.bean.UserDataBean;
import com.vinod.docsch.view.bean.vo.Role;
import com.vinod.docsch.view.helper.JsfWebHelper;


@ManagedBean(name="docSchCtrlBean")
@ViewScoped

public class DocScheduleControllerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value="#{userService}")
	private UserService userService;
	
	public void createUser() {
		UserDataBean udataBean = (UserDataBean) JsfWebHelper.getDataBean("userBean");
		userService.createUser(udataBean);
	}
	
	public void createRole() {
		RoleDataBean roleBean = (RoleDataBean) JsfWebHelper.getDataBean("beanRole");
		FacesContext context = FacesContext.getCurrentInstance();
		Role createdRole = null;
		try {
			createdRole = userService.createRole(roleBean.getSelectedRole());
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
        context.addMessage(null, new FacesMessage("Role creation successful", roleBean.getSelectedRole().getRoleName()));  
        
        roleBean.getAllRoles().add(createdRole);
        
	}
	
	public void deleteRole(Role role) {
		RoleDataBean roleBean = (RoleDataBean) JsfWebHelper.getDataBean("beanRole");
		roleBean.setSelectedRole(role);
	}
	
	public void editRole(Role role) {
		RoleDataBean roleBean = (RoleDataBean) JsfWebHelper.getDataBean("beanRole");
		roleBean.setSelectedRole(role);
	}
	
	public void loadRoles() {
		RoleDataBean roleBean = (RoleDataBean) JsfWebHelper.getDataBean("beanRole");
		if(roleBean.getAllRoles().size() == 0) {
			roleBean.setAllRoles(userService.loadAllRoles());
		}
		
	}

	public void onTabChange(TabChangeEvent event) {  
        String tabSelected = event.getTab().getId();
        if(tabSelected.equals("tabRole")) {
        	loadRoles();
        }
    }  
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

		
	
}
