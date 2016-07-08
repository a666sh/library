package org.lee.spring.hibernate.action;

import java.util.List;

import javax.annotation.Resource;

import org.lee.spring.hibernate.model.PersonType;
import org.lee.spring.hibernate.service.IPersonTypeService;
import org.lee.spring.hibernate.util.ActionUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@Controller("personTypeAction")
@Scope("prototype")
public class PersonTypeAction extends ActionSupport implements ModelDriven<PersonType>{


	private static final long serialVersionUID = 1592132540935684795L;
	private IPersonTypeService personTypeService;
	private PersonType personType;
	
	public PersonType getPersonType() {
		return personType;
	}

	public void setPersonType(PersonType personType) {
		this.personType = personType;
	}

	
	public IPersonTypeService getPersonTypeService() {
		return personTypeService;
	}
	@Resource(name="personTypeService")
	public void setPersonTypeService(IPersonTypeService personTypeService) {
		this.personTypeService = personTypeService;
	}

	public String addInput() {
		return "success";
	}
	public String updateInput() {
		PersonType pt=personTypeService.load(personType.getId());
		personType.setDate(pt.getDate());
		personType.setName(pt.getName());
		personType.setMaxNo(pt.getMaxNo());
		return "success";
	}
	public String update() {
		PersonType p=personTypeService.load(personType.getId());
		p.setName(personType.getName());
		p.setMaxNo(personType.getMaxNo());
		p.setDate(personType.getDate());
		personTypeService.update(p);
		ActionContext.getContext().put("url", "/personType_list.do");
		return ActionUtil.REDIRECT;
	}
	public String delete() {
		personTypeService.delete(personType.getId());
		ActionContext.getContext().put("url", "/personType_list.do");
		return ActionUtil.REDIRECT;
	}
	public String list() {
		List<PersonType> list=personTypeService.listAll();
		ActionContext.getContext().put("personTypes", list);
		return SUCCESS;
	}
	public String add() {
		personTypeService.add(personType);
		ActionContext.getContext().put("url", "/personType_list.action");
		return ActionUtil.REDIRECT;
	}
	public void validateAdd() {
		if(personType.getName()==null||"".equals(personType.getName()))
			this.addFieldError("name", "读者类型名称不能为空");
		if(personType.getDate()==0||"".equals(personType.getDate()))
			this.addFieldError("date", "读者借阅日期不能为空");
		if(personType.getMaxNo()==0||"".equals(personType.getMaxNo()))
			this.addFieldError("maxNo", "最大可借阅量不能为空");
	}
	@Override
	public PersonType getModel() {
		if(personType==null) personType=new PersonType();
		return personType;
	}

}
