package com.lzx.sys.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//import com.my.annotation.excel.ExcelColumn;
//import com.my.annotation.excel.ExcelTable;
//import com.my.annotation.page.PageMate;

/**
 * TbMenu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Person")
//@ExcelTable(title="人")
public class Person implements java.io.Serializable {

    
	/**
	 * id
	 */
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;
	
	/**
	 * 姓名
	 */
//	@PageMate(fieldName="姓名")
//	@ExcelColumn(title="姓名",column=0)
	@Column(name = "name", nullable = true, length = 200)
	private String name;

	public String getId() {
	    return id;
	}

	public void setId(String id) {
	    this.id = id;
	}

	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}
}