package org.lee.spring.hibernate.test;

import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lee.spring.hibernate.model.Reader;
import org.lee.spring.hibernate.service.IPersonTypeService;
import org.lee.spring.hibernate.service.IReaderService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/beans.xml"})
public class TestInitDate {
	
	@Resource
	private IReaderService readerService;
	@Resource
	private IPersonTypeService personTypeService;
	Random ran = new Random();
	
	@Test
	public void testAdd() {
		int[] types={1,2,4,5,6};
		for(int i=9;i<=200;i++) {
			Reader r=new Reader();
			r.setCreateDate(new Date());
			r.setCurNo(0);
			r.setPassword("123");
			r.setUsername("user"+i);
			r.setRealName(getName());
			r.setSex(getSex());
			r.setType(personTypeService.load(types[ran.nextInt(types.length)]));
			readerService.add(r);
		}
	}

	private String getName() {
		String[] name1 = new String[] { "孔", "张", "叶", "李", "叶入", "孔令", "张立", "陈", "刘", "牛", "夏侯", "令", "令狐", "赵", "母",
				"穆", "倪", "张毅", "称", "程", "王", "王志", "刘金", "冬", "吴", "马", "沈" };

		String[] name2 = new String[] { "凡", "课", "颖", "页", "源", "都", "浩", "皓", "西", "东", "北", "南", "冲", "昊", "力", "量",
				"妮", "敏", "捷", "杰", "坚", "名", "生", "华", "鸣", "蓝", "春", "虎", "刚", "诚" };

		String[] name3 = new String[] { "吞", "明", "敦", "刀", "备", "伟", "唯", "楚", "勇", "诠", "佺", "河", "正", "震", "点", "贝",
				"侠", "伟", "大", "凡", "琴", "青", "林", "星", "集", "财" };

		boolean two = ran.nextInt(50) >= 45 ? false : true;
		if (two) {
			String n1 = name1[ran.nextInt(name1.length)];
			String n2;
			int n = ran.nextInt(10);
			if (n > 5) {
				n2 = name2[ran.nextInt(name2.length)];
			} else {
				n2 = name3[ran.nextInt(name3.length)];
			}
			return n1 + n2;
		} else {
			String n1 = name1[ran.nextInt(name1.length)];
			String n2 = name2[ran.nextInt(name2.length)];
			String n3 = name3[ran.nextInt(name3.length)];
			return n1 + n2 + n3;
		}
	}
	private String getSex() {
		int i=ran.nextInt(2);
		if(i==0) return "男";
		return "女";
	}
	
	@Test
	public void test02() {
		for(int a=0;a<10;a++) {
		System.out.println(getSex());
		}
	}
}
