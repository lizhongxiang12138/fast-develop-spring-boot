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
//import com.my.annotation.page.PageMate;

/**
 * TbMenu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DATA_TYPE")
//@ExcelTable(title="数据类型")
public class DataType implements java.io.Serializable {

	/**
	 * id
	 */
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	@Id
//	@PageMate(fieldName="类型ID")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;
	/**
	 * 数据类型标识码
	 */
//	@PageMate(fieldName="数据类型码")
//	@ExcelColumn(title="数据类型码",column=0)
	@Column(name = "TYPE_CODE", unique = true, nullable = false, length = 32)
	private String typeCode;
	
	/**
	 * 数据类型正则表达式
	 */
	@Column(name = "REGEX",  unique=true,nullable = false, length = 200)
//	@ExcelColumn(title="正则表达式",column=1)
//	@PageMate(fieldName="正则表达式")
	private String regex;
	
	/**
	 * 数据类型名称
	 */
	@Column(name = "TYPE_NAME", nullable = true, length = 200)
//	@ExcelColumn(title="类型名称",column=2)
//	@PageMate(fieldName="类型名称")
	private String typeName;
	
	/**
	 * 数据长度
	 */
	@Column(name = "DATA_LENGTH", nullable = true)
//	@ExcelColumn(title="数据长度",column=3)
//	@PageMate(fieldName="数据长度")
	private int dataLength;
	
	/**
	 * 验证错误提示信息
	 */
	@Column(name = "ERROR_MESS", nullable = true,length=200)
//	@ExcelColumn(title="提示信息",column=4)
//	@PageMate(fieldName="提示信息")
	private String errorMess;

	
	//getter setter 
	public String getId() {
	    return id;
	}

	public void setId(String id) {
	    this.id = id;
	}
	
	public String getTypeCode() {
	    return typeCode;
	}

	public void setTypeCode(String typeCode) {
	    this.typeCode = typeCode;
	}

	public String getRegex() {
	    return regex;
	}

	public void setRegex(String regex) {
	    this.regex = regex;
	}

	public String getTypeName() {
	    return typeName;
	}

	public void setTypeName(String typeName) {
	    this.typeName = typeName;
	}

	public int getDataLength() {
	    return dataLength;
	}

	public void setDataLength(int dataLength) {
	    this.dataLength = dataLength;
	}

	public String getErrorMess() {
	    return errorMess;
	}

	public void setErrorMess(String errorMess) {
	    this.errorMess = errorMess;
	}	
}