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
@Table(name = "TB_ARTICLE")
//@ExcelTable(title="文章")
public class Article implements java.io.Serializable {

	/**
	 * id
	 */
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;
	
	/**
	 * 文章栏目ID，对应文章类型表
	 */
//	@PageMate(fieldName="文章栏目ID")
//	@ExcelColumn(title="文章栏目ID",column=0)
	@Column(name = "typeID", nullable = true, length = 32)
	private String typeID;
	
	/**
	 * 文章栏目
	 */
//	@PageMate(fieldName="文章栏目")
//	@ExcelColumn(title="文章栏目",column=1)
	@Column(name = "type", nullable = true, length = 200)
	private String type;
	
	/**
	 * 标题
	 */
//	@PageMate(fieldName="标题")
//	@ExcelColumn(title="标题",column=2)
	@Column(name = "title", nullable = true, length = 1000)
	private String title;
	
	/**
	 * 完整标题
	 */
//	@PageMate(fieldName="完整标题")
//	@ExcelColumn(title="完整标题",column=5)
	@Column(name = "fullTitle", nullable = true, length = 1000)
	private String fullTitle;
	
	/**
	 * 副标题
	 */
//	@PageMate(fieldName="副标题")
//	@ExcelColumn(title="副标题",column=6)
	@Column(name = "subhead", nullable = true, length = 1000)
	private String subhead;
	
	/**
	 * 摘要
	 */
//	@PageMate(fieldName="摘要")
//	@ExcelColumn(title="摘要",column=7)
	@Column(name = "articleIntro", nullable = true, length = 1000)
	private String articleIntro;
	
	/**
	 * 内容
	 */
//	@PageMate(fieldName="内容")
//	@ExcelColumn(title="内容",column=8)
	@Column(name = "content", nullable = true,length=10000)
	private String content;
	
	/**
	 * 作者
	 */
//	@PageMate(fieldName="作者")
//	@ExcelColumn(title="作者",column=9)
	@Column(name = "author", nullable = true, length = 100)
	private String author;
	
	
	/**
	 * 录入者
	 */
//	@PageMate(fieldName="录入者")
//	@ExcelColumn(title="录入者",column=11)
	@Column(name = "record", nullable = true, length = 200)
	private String record;
	
	/**
	 * 关键字
	 */
//	@PageMate(fieldName="关键字")
//	@ExcelColumn(title="关键字",column=13)
	@Column(name = "keyword", nullable = true, length = 1000)
	private String keyword;
	
	/**
	 * 评论
	 */
//	@PageMate(fieldName="评论")
//	@ExcelColumn(title="评论",column=14)
	@Column(name = "comment", nullable = true, length = 1000)
	private String comment;
	
	/**
	 * 评论数
	 */
//	@PageMate(fieldName="评论数")
//	@ExcelColumn(title="评论数",column=15)
	@Column(name = "commentCount", nullable = true)
	private Long commentCount;
	
	/**
	 * 添加时间
	 */
//	@PageMate(fieldName="添加时间")
//	@ExcelColumn(title="添加时间",column=16)
	@Column(name = "createTime", nullable = true)
	private Timestamp createTime;
	
	/**
	 * 是否置顶 
	 * 0：不置顶
	 * 1：置顶
	 */
//	@PageMate(fieldName="是否置顶")
	@Column(name = "top", nullable = true,length=1)
	private String top;

	/**
	 * 标题图片ID
	 * 对应文件ID
	 */
//	@PageMate(fieldName="标题图片ID")
	@Column(name = "titleImageID", nullable = true,length=32)
	private String titleImageID;

	public String getId() {
	    return id;
	}

	public void setId(String id) {
	    this.id = id;
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

	public String getTitle() {
	    return title;
	}

	public void setTitle(String title) {
	    this.title = title;
	}

	public String getFullTitle() {
	    return fullTitle;
	}

	public void setFullTitle(String fullTitle) {
	    this.fullTitle = fullTitle;
	}

	public String getSubhead() {
	    return subhead;
	}

	public void setSubhead(String subhead) {
	    this.subhead = subhead;
	}

	public String getArticleIntro() {
	    return articleIntro;
	}

	public void setArticleIntro(String articleIntro) {
	    this.articleIntro = articleIntro;
	}

	public String getContent() {
	    return content;
	}

	public void setContent(String content) {
	    this.content = content;
	}

	public String getAuthor() {
	    return author;
	}

	public void setAuthor(String author) {
	    this.author = author;
	}

	public String getRecord() {
	    return record;
	}

	public void setRecord(String record) {
	    this.record = record;
	}

	public String getKeyword() {
	    return keyword;
	}

	public void setKeyword(String keyword) {
	    this.keyword = keyword;
	}

	public String getTop() {
	    return top;
	}

	public void setTop(String top) {
	    this.top = top;
	}

	public String getTitleImageID() {
	    return titleImageID;
	}

	public void setTitleImageID(String titleImageID) {
	    this.titleImageID = titleImageID;
	}

	public String getComment() {
	    return comment;
	}

	public void setComment(String comment) {
	    this.comment = comment;
	}

	public Long getCommentCount() {
	    return commentCount;
	}

	public void setCommentCount(Long commentCount) {
	    this.commentCount = commentCount;
	}

	public Timestamp getCreateTime() {
	    return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
	    this.createTime = createTime;
	}
	
	

}