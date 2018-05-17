package com.lzx.sys.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import com.my.annotation.excel.ExcelTable;

/**
 * TbMenu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ID_GENERATE_RULE")
//@ExcelTable(title="id生成策略")
public class IdGenerateRule implements java.io.Serializable {

	/**
	 * 角色id
	 */
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;//角色id
	
	/**
	 * 日期
	 */
	@Column(name = "GENERATE_DATE", nullable = true, length = 8)
	private String generateDate;
	
	/**
	 * 日期数据
	 */
	@Column(name = "idNum", nullable = true)
	private Integer idNum;
	
	/**
	 * 前缀
	 */
	@Column(name = "prefix", nullable = true,length=10)
	private String prefix;
	
	

	public String getId() {
	    return id;
	}

	public void setId(String id) {
	    this.id = id;
	}

	public String getGenerateDate() {
	    return generateDate;
	}

	public void setGenerateDate(String generateDate) {
	    this.generateDate = generateDate;
	}

	public Integer getIdNum() {
	    return idNum;
	}

	public void setIdNum(Integer idNum) {
	    this.idNum = idNum;
	}

	public String getPrefix() {
	    return prefix;
	}

	public void setPrefix(String prefix) {
	    this.prefix = prefix;
	}


}