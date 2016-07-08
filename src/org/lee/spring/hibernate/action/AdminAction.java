package org.lee.spring.hibernate.action;

import java.lang.reflect.InvocationTargetException;

import javax.annotation.Resource;

import org.lee.spring.hibernate.model.Admin;
import org.lee.spring.hibernate.model.LibAuth;
import org.lee.spring.hibernate.service.IAdminService;
import org.lee.spring.hibernate.service.IPersonTypeService;
import org.lee.spring.hibernate.util.ActionUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.commons.beanutils.BeanUtils;

@SuppressWarnings("serial")
@Controller("adminAction")
@Scope("prototype")
public class AdminAction extends ActionSupport implements ModelDriven<Admin>{
	private Admin admin;
	private int tid;
	private IAdminService adminService;
	private IPersonTypeService personTypeService;
	
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public IAdminService getAdminService() {
		return adminService;
	}
	@Resource
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	public IPersonTypeService getPersonTypeService() {
		return personTypeService;
	}
	@Resource
	public void setPersonTypeService(IPersonTypeService personTypeService) {
		this.personTypeService = personTypeService;
	}

	public String addInput() {
		ActionContext.getContext().put("ts", personTypeService.listAll());
		return SUCCESS;
	}
	
	public String add() throws IllegalAccessException, InvocationTargetException {
		Admin a=new Admin();
		BeanUtils.copyProperties(a, admin);
		a.setType(personTypeService.load(tid));
		adminService.add(a);
		ActionUtil.RedirectURL("/admin_list.do");
		return ActionUtil.REDIRECT;
	}
	public String delete() {
		/**
		 * 因为管理员关联的对象多，所以不删除管理员的信息，只修改管理员的status属性使其
		 * 进入停用状态
		 */
		Admin ta=adminService.load(admin.getId());
		if(ta.getStatus()!=5) {
			ta.setStatus(5);
			adminService.update(ta);
		} else {
			ta.setStatus(0);
			adminService.update(ta);
		}
		ActionUtil.RedirectURL("/admin_list.do");
		return ActionUtil.REDIRECT;
	}
	public String updateInput() throws IllegalAccessException, InvocationTargetException {
		Admin a=adminService.load(admin.getId());
		BeanUtils.copyProperties(admin, a);
		ActionContext.getContext().put("ts", personTypeService.listAll());
		return SUCCESS;
	}
	public String update() {
		Admin a=adminService.load(admin.getId());
		a.setAddress(admin.getAddress());
		a.setPassword(admin.getPassword());
		a.setRelname(admin.getRelname());
		a.setStatus(admin.getStatus());
		a.setTel(admin.getTel());
		a.setUsername(admin.getUsername());
		a.setType(personTypeService.load(tid));
		adminService.update(a);
		ActionUtil.RedirectURL("/admin_list.do");
		return ActionUtil.REDIRECT;
	}
	public String list() {
		ActionContext.getContext().put("as", adminService.find());
		return SUCCESS;
	}
	@LibAuth(ActionUtil.AUTH_READER)
	public String showSelf() throws IllegalAccessException, InvocationTargetException {
		Admin a=(Admin) ActionContext.getContext().getSession().get("loginAdmin");
		BeanUtils.copyProperties(admin, a);
		return SUCCESS;
	}
	public String show() throws IllegalAccessException, InvocationTargetException {
		Admin a=adminService.load(admin.getId());
		BeanUtils.copyProperties(admin, a);
		return SUCCESS;
	}
	public String listBeStop() {
		ActionContext.getContext().put("as", adminService.findBeStop());
		return SUCCESS;
	}
	public String updateSelfInput() throws IllegalAccessException, InvocationTargetException {
		Admin a=(Admin) ActionContext.getContext().getSession().get("loginAdmin");
		if(a!=null) BeanUtils.copyProperties(admin, a);
		return SUCCESS;
	}
	public String updateSelf() {
		Admin a=(Admin)ActionContext.getContext().getSession().get("loginAdmin");
		if(a!=null) {
		a.setAddress(admin.getAddress());
		a.setPassword(admin.getPassword());
		a.setRelname(admin.getRelname());
		a.setTel(admin.getTel());
		adminService.update(a);
		ActionContext.getContext().getSession().put("loginAdmin", a);
		}
		ActionUtil.RedirectURL("/admin_showSelf.do");
		return ActionUtil.REDIRECT;
	}
	@Override
	public Admin getModel() {
		if(admin==null) admin=new Admin();
		return admin;
	}

}
