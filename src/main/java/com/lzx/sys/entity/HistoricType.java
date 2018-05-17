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
@Table(name = "HISTORIC_TYPE")
//@ExcelTable(title="文物、陈列类型")
public class HistoricType implements java.io.Serializable {

    
	/**
	 * id
	 */
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;
	
	/**
	 * 类型名称
	 */
//	@PageMate(fieldName="类型名称")
//	@ExcelColumn(title="类型名称",column=0)
	@Column(name = "type_name", nullable = true, length = 200)
	private String typeName;
	
	public final static String CULTURAL_TREASURES = "1";//文物类型
	public final static String DISPLAY = "2";//陈列类型
	
	public static Map<String, String> TYPES;
	
	static {
	    TYPES = new HashMap<String, String>();
	    TYPES.put(CULTURAL_TREASURES, "文物");
	    TYPES.put(DISPLAY, "陈列");
	}
	
	/**
	 * 类型
	 */
//	@PageMate(fieldName="类型")
//	@ExcelColumn(title="类型",column=1,selectList="com.my.project.entity.HistoricType.TYPES")
	@Column(name = "type", nullable = true, length = 200)
	private String type;

	public String getId() {
	    return id;
	}

	public void setId(String id) {
	    this.id = id;
	}

	public String getTypeName() {
	    return typeName;
	}

	public void setTypeName(String typeName) {
	    this.typeName = typeName;
	}

	public String getType() {
	    return type;
	}

	public void setType(String type) {
	    this.type = type;
	}
}