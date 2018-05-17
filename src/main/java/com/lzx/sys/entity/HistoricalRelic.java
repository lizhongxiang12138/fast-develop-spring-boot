package com.lzx.sys.entity;

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
@Table(name = "HISTORICAL_RELIC")
//@ExcelTable(title="文物")
public class HistoricalRelic implements java.io.Serializable {

    
	/**
	 * id
	 */
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;
	
	/**
	 * 文物标题
	 */
//	@PageMate(fieldName="文物标题")
//	@ExcelColumn(title="文物标题",column=0)
	@Column(name = "TITLE", nullable = true, length = 200)
	private String title;
	
	/**
	 * 文物简介
	 */
//	@PageMate(fieldName="文物简介")
//	@ExcelColumn(title="文物简介",column=1)
	@Column(name = "INTRO", nullable = true, length = 1024)
	private String intro;
	
	/**
	 * 展览时间
	 */
//	@PageMate(fieldName="展览时间")
//	@ExcelColumn(title="展览时间",column=2)
	@Column(name = "SHOW_TIME", nullable = true, length = 100)
	private String showTime;
	
	/**
	 * 展览地点
	 */
//	@PageMate(fieldName="展览地点")
//	@ExcelColumn(title="展览地点",column=3)
	@Column(name = "SHOW_ADDRESS", nullable = true, length = 1000)
	private String showAddress;
	
	/**
	 * 标题图片
	 */
//	@PageMate(fieldName="标题图片")
//	@ExcelColumn(title="标题图片",column=4)
	@Column(name = "TITLE_IMAGE_ID", nullable = true, length = 32)
	private String titleImageID;
	
	/**
	 * 年代
	 */
//	@PageMate(fieldName="年代")
//	@ExcelColumn(title="年代",column=5)
	@Column(name = "HISTORICAL_TIME", nullable = true, length = 200)
	private String historicalTime;
	
	/**
	 * 外形描述
	 */
//	@PageMate(fieldName="外形描述")
//	@ExcelColumn(title="外形描述",column=6)
	@Column(name = "OUTLINE_DESCRIBE", nullable = true, length = 1000)
	private String outlineDescribe;
	
	/**
	 * 出土时间
	 */
//	@PageMate(fieldName="出土时间")
//	@ExcelColumn(title="出土时间",column=7)
	@Column(name = "COM_UP_TIME", nullable = true, length = 200)
	private String comUpTime;
	
	/**
	 * 文物类型ID
	 */
//	@PageMate(fieldName="文物类型ID")
//	@ExcelColumn(title="文物类型ID",column=8)
	@Column(name = "TYPE_ID", nullable = true, length = 32)
	private String typeID;
	
	/**
	 * 文物类型
	 */
//	@PageMate(fieldName="文物类型")
//	@ExcelColumn(title="文物类型",column=9)
	@Column(name = "TYPE", nullable = true, length = 400)
	private String type;
	
	/**
	 * 开始展示时间
	 */
//	@PageMate(fieldName="开始展示时间")
//	@ExcelColumn(title="开始展示时间",column=10)
	@Column(name = "START_TIME", nullable = true, length = 6)
	private String startTime;
	
	
	/**
	 * 结束展示时间
	 */
//	@PageMate(fieldName="结束展示时间")
//	@ExcelColumn(title="结束展示时间",column=11)
	@Column(name = "END_TIME", nullable = true, length = 6)
	private String endTime;
	
	/**
	 * 开始展示日期
	 */
//	@PageMate(fieldName="开始展示日期")
//	@ExcelColumn(title="开始展示日期",column=12)
	@Column(name = "START_DATE", nullable = true, length = 11)
	private String startDate;
	
	
	/**
	 * 结束展示日期
	 */
//	@PageMate(fieldName="结束展示日期")
//	@ExcelColumn(title="结束展示日期",column=13)
	@Column(name = "END_DATE", nullable = true, length = 11)
	private String endDate;
	
	
	/**
	 * 种类
	 */
//	@PageMate(fieldName="种类")
//	@ExcelColumn(title="种类",column=14,selectList="com.my.project.entity.HistoricType.TYPES")
	@Column(name = "CULTURAL_RELIC_ID", nullable = true, length = 2)
	private String culturalRelicId;
	
	

	public String getId() {
	    return id;
	}

	public void setId(String id) {
	    this.id = id;
	}

	public String getTitle() {
	    return title;
	}

	public void setTitle(String title) {
	    this.title = title;
	}

	public String getIntro() {
	    return intro;
	}

	public void setIntro(String intro) {
	    this.intro = intro;
	}

	public String getShowTime() {
	    return showTime;
	}

	public void setShowTime(String showTime) {
	    this.showTime = showTime;
	}

	public String getShowAddress() {
	    return showAddress;
	}

	public void setShowAddress(String showAddress) {
	    this.showAddress = showAddress;
	}

	public String getTitleImageID() {
	    return titleImageID;
	}

	public void setTitleImageID(String titleImageID) {
	    this.titleImageID = titleImageID;
	}

	public String getHistoricalTime() {
	    return historicalTime;
	}

	public void setHistoricalTime(String historicalTime) {
	    this.historicalTime = historicalTime;
	}

	public String getOutlineDescribe() {
	    return outlineDescribe;
	}

	public void setOutlineDescribe(String outlineDescribe) {
	    this.outlineDescribe = outlineDescribe;
	}

	public String getComUpTime() {
	    return comUpTime;
	}

	public void setComUpTime(String comUpTime) {
	    this.comUpTime = comUpTime;
	}

	public String getTypeID() {
	    return typeID;
	}

	public void setTypeID(String typeID) {
	    this.typeID = typeID;
	}

	public String getType() {
	    return type;
	}

	public void setType(String type) {
	    this.type = type;
	}

	public String getStartTime() {
	    return startTime;
	}

	public void setStartTime(String startTime) {
	    this.startTime = startTime;
	}

	public String getEndTime() {
	    return endTime;
	}

	public void setEndTime(String endTime) {
	    this.endTime = endTime;
	}

	public String getStartDate() {
	    return startDate;
	}

	public void setStartDate(String startDate) {
	    this.startDate = startDate;
	}

	public String getEndDate() {
	    return endDate;
	}

	public void setEndDate(String endDate) {
	    this.endDate = endDate;
	}

	public String getCulturalRelicId() {
	    return culturalRelicId;
	}

	public void setCulturalRelicId(String culturalRelicId) {
	    this.culturalRelicId = culturalRelicId;
	}
	
}