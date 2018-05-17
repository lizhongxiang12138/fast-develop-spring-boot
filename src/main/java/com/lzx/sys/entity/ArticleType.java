package com.lzx.sys.entity;

import java.sql.Timestamp;

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
@Table(name = "TB_ARTICLE_TYPE")
//@ExcelTable(title="文章类型")
public class ArticleType implements java.io.Serializable {

	/**
	 * id
	 */
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;
	
	/**
	 * 文章栏目名称
	 */
//	@PageMate(fieldName="文章栏目名称")
//	@ExcelColumn(title="文章栏目名称",column=0)
	@Column(name = "NAME", nullable = true, length = 1000)
	private String name;
	
	/**
	 * 状态
	 */
//	@PageMate(fieldName="状态")
//	@ExcelColumn(title="状态",column=1)
	@Column(name = "STATE", nullable = true,length=1)
	private String state;

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

	public String getState() {
	    return state;
	}

	public void setState(String state) {
	    this.state = state;
	}

	
}