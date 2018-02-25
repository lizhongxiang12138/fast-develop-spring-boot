package com.lzx.sys.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * TbMenu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "generate_code")
//@ExcelTable(title="自动生成代码模块")
public class GenerateCode implements java.io.Serializable {

	/**
	 * id
	 */
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;
	
	/**
	 * 类全名
	 */
	@Column(name = "class_name",  unique=true,nullable = false, length = 200)
//	@ExcelColumn(title="类全名",column=0)
//	@PageMate(fieldName="类全名")
	private String className;
	
	/**
	 * 模块名称
	 */
	@Column(name = "module_name", nullable = true, length = 200)
//	@ExcelColumn(title="模块名称",column=1)
//	@PageMate(fieldName="模块名称")
	private String moduleName;
	
	/**
	 * 模块子controller包名称
	 */
	@Column(name = "package_hildName", nullable = true, length = 500)
//	@ExcelColumn(title="模块子controller包名称",column=2)
//	@PageMate(fieldName="模块子controller包名称")
	private String packageChildName ;
	
	/**
	 * 状态
	 */
	@Column(name = "state", nullable = true)
//	@ExcelColumn(title="状态",column=3)
//	@PageMate(fieldName="状态")
	private Integer state;
	
	public final static Integer AVAILABLE = 1; //可用状态
	public final static Integer LOCK= -1; //锁定状态
	
	public static Map<Integer, String> STATESTRMAP;
	
	static {
	    STATESTRMAP=new HashMap<Integer, String>();
	    STATESTRMAP.put(1, "<span style=\"color:#9CD825;\">模块模块生成可用</span>");
	    STATESTRMAP.put(-1, "<span style=\"color:#F00;\">已锁定</span>");
	}

	//getter setter 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getPackageChildName() {
		return packageChildName;
	}

	public void setPackageChildName(String packageChildName) {
		this.packageChildName = packageChildName;
	}

	public Integer getState() {
	    return state;
	}

	public void setState(Integer state) {
	    this.state = state;
	}
	
	
	
}