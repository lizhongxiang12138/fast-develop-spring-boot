package com.lzx.sys.entity;

import java.sql.Timestamp;
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
@Table(name = "TB_DOCUMENT")
//@ExcelTable(title="文档")
public class Document implements java.io.Serializable {

	/**
	 * id
	 */
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	@Id
//	@PageMate(fieldName="文件ID")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;
	/**
	 * 文档标题
	 */
//	@PageMate(fieldName="文档标题")
//	@ExcelColumn(title="文档标题",column=0)
	@Column(name = "DOCUMENT_TITLE", nullable = true, length = 100)
	private String documentTitle;
	/**
	 * 文档说明
	 */
//	@PageMate(fieldName="文档说明")
//	@ExcelColumn(title="文档说明",column=1)
	@Column(name = "DOCUMENT_DECLARE", nullable = true, length = 100)
	private String documentDeclare;
	/**
	 * 创建时间
	 */
//	@PageMate(fieldName="创建时间")
//	@ExcelColumn(title="创建时间",column=2)
	@Column(name = "CREATE_TIME", nullable = true)
	private Timestamp createTime;
	/**
	 * 更新时间
	 */
//	@PageMate(fieldName="更新时间")
//	@ExcelColumn(title="更新时间",column=3)
	@Column(name = "UPDATE_TIME", nullable = true)
	private Timestamp updateTime;
	/**
	 * 最后浏览时间
	 */
//	@PageMate(fieldName="最后浏览时间")
//	@ExcelColumn(title="最后浏览时间",column=4)
	@Column(name = "LAST_BROWSE_TIME", nullable = true)
	private Timestamp lastBrowseTime;
	/**
	 * 最后浏览用户
	 */
//	@PageMate(fieldName="最后浏览用户")
//	@ExcelColumn(title="最后浏览用户",column=5)
	@Column(name = "LAST_BROWSE_USER", nullable = true, length = 100)
	private String lastBrowseUser;
	/**
	 * 最后浏览用户ID
	 */
//	@PageMate(fieldName="最后浏览用户ID")
//	@ExcelColumn(title="最后浏览用户ID",column=6)
	@Column(name = "LAST_BROWSE_USER_ID", nullable = true, length = 32)
	private String lastBrowseUserID;
	/**
	 * 浏览人数统计
	 */
//	@PageMate(fieldName="浏览人数统计")
//	@ExcelColumn(title="浏览人数统计",column=7)
	@Column(name = "BROWSE_COUNT", nullable = true)
	private Long browseCount;
	/**
	 * 创建用户
	 */
//	@PageMate(fieldName="创建用户")
//	@ExcelColumn(title="创建用户",column=8)
	@Column(name = "CREATE_USER", nullable = true, length = 100)
	private String createUser;
	/**
	 * 创建用户ID
	 */
//	@PageMate(fieldName="创建用户ID")
//	@ExcelColumn(title="创建用户ID",column=9)
	@Column(name = "CREATE_USER_ID", nullable = true, length = 32)
	private String createUserID;
	/**
	 * 文件路径
	 */
//	@PageMate(fieldName="文件路径")
//	@ExcelColumn(title="文件路径",column=10)
	@Column(name = "FILE_PATH", nullable = false, length = 1000)
	private String filePath;
	/**
	 * 文件描述
	 */
//	@PageMate(fieldName="文件描述")
//	@ExcelColumn(title="文件描述",column=11)
	@Column(name = "FILE_DESCRIBE", nullable = true, length = 1000)
	private String fileDescribe;
	/**
	 * 业务ID
	 */
//	@PageMate(fieldName="业务ID")
//	@ExcelColumn(title="业务ID",column=12)
	@Column(name = "SERVICE_ID", nullable = true, length = 32)
	private String serviceID;
	/**
	 * 业务名称
	 */
//	@PageMate(fieldName="业务名称")
//	@ExcelColumn(title="业务名称",column=13)
	@Column(name = "SERVICE_NAME", nullable = true, length = 500)
	private String serviceName;
	/**
	 * 文件相对路径
	 */
//	@PageMate(fieldName="文件相对路径")
//	@ExcelColumn(title="文件相对路径",column=14)
	@Column(name = "FILE_RELATIVE_PATH", nullable = true, length = 500)
	private String fileRelativePath;
	/**
	 * 备注
	 */
//	@PageMate(fieldName="备注")
//	@ExcelColumn(title="备注",column=15)
	@Column(name = "remark", nullable = true, length = 10000)
	private String remark;
	
	
	public String getId() {
	    return id;
	}
	public void setId(String id) {
	    this.id = id;
	}
	public String getDocumentTitle() {
	    return documentTitle;
	}
	public void setDocumentTitle(String documentTitle) {
	    this.documentTitle = documentTitle;
	}
	public String getDocumentDeclare() {
	    return documentDeclare;
	}
	public void setDocumentDeclare(String documentDeclare) {
	    this.documentDeclare = documentDeclare;
	}
	public Timestamp getCreateTime() {
	    return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
	    this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
	    return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
	    this.updateTime = updateTime;
	}
	public Timestamp getLastBrowseTime() {
	    return lastBrowseTime;
	}
	public void setLastBrowseTime(Timestamp lastBrowseTime) {
	    this.lastBrowseTime = lastBrowseTime;
	}
	public String getLastBrowseUser() {
	    return lastBrowseUser;
	}
	public void setLastBrowseUser(String lastBrowseUser) {
	    this.lastBrowseUser = lastBrowseUser;
	}
	public String getLastBrowseUserID() {
	    return lastBrowseUserID;
	}
	public void setLastBrowseUserID(String lastBrowseUserID) {
	    this.lastBrowseUserID = lastBrowseUserID;
	}
	public Long getBrowseCount() {
	    return browseCount;
	}
	public void setBrowseCount(Long browseCount) {
	    this.browseCount = browseCount;
	}
	public String getCreateUser() {
	    return createUser;
	}
	public void setCreateUser(String createUser) {
	    this.createUser = createUser;
	}
	public String getCreateUserID() {
	    return createUserID;
	}
	public void setCreateUserID(String createUserID) {
	    this.createUserID = createUserID;
	}
	public String getFilePath() {
	    return filePath;
	}
	public void setFilePath(String filePath) {
	    this.filePath = filePath;
	}
	public String getFileDescribe() {
	    return fileDescribe;
	}
	public void setFileDescribe(String fileDescribe) {
	    this.fileDescribe = fileDescribe;
	}
	public String getServiceID() {
	    return serviceID;
	}
	public void setServiceID(String serviceID) {
	    this.serviceID = serviceID;
	}
	public String getServiceName() {
	    return serviceName;
	}
	public void setServiceName(String serviceName) {
	    this.serviceName = serviceName;
	}
	public String getFileRelativePath() {
	    return fileRelativePath;
	}
	public void setFileRelativePath(String fileRelativePath) {
	    this.fileRelativePath = fileRelativePath;
	}
	public String getRemark() {
	    return remark;
	}
	public void setRemark(String remark) {
	    this.remark = remark;
	}
	
	
}