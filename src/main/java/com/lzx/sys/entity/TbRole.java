package com.lzx.sys.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

//import com.my.annotation.excel.ExcelColumn;
//import com.my.annotation.excel.ExcelTable;

/**
 * TbMenu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_role")
//@ExcelTable(title="角色数据")
public class TbRole implements java.io.Serializable {

	/**
	 * 角色id
	 */
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;//角色id
	
	/**
	 * 角色名称
	 */
	@Column(name = "role_name", nullable = false, length = 200)
//	@ExcelColumn(title="角色名称",column=0)
	private String roleName;
	
	

	// Constructors

	/** default constructor */
	public TbRole() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}