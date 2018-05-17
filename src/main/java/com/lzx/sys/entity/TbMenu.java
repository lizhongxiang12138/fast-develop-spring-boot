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
@Table(name = "tb_menu")
//@ExcelTable(title="菜单数据填表说明:\n"
//		+ "注意：不要随便更改单元格位置和格式，以免数据导入出错！")
public class TbMenu implements java.io.Serializable {

	// Fields
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "menu_id", unique = true, nullable = false, length = 32)
	private String id;
	
	@Column(name = "menu_name", nullable = false, length = 200)
//	@ExcelColumn(title="菜单名称",column=0)
	private String text;//菜单文本
	
	/**
	 * 菜单等级 0-1-2-3-4-5-......
	 * 0 是根菜单
	 */
	@Column(name = "menu_grade", nullable = false, length = 1)
//	@ExcelColumn(title="菜单等级",column=1)
	private String menuGrade;//菜单等级
	
	/**
	 * 父级菜单 对应菜单id
	 */
	@Column(name = "menu_parent", length = 32)
//	@ExcelColumn(title="父亲菜单id",column=2)
	private String menuParent;
	
	/**
	 * 一个节点数组声明了若干节点。
	 * 子节点
	 */
	@Transient
	List<TbMenu> children;
	
	/**
	 * 定义节点是否被选中
	 * true
	 * false
	 */
	@Transient
	Boolean  checked;
	
	/**
	 * 对应的链接
	 */
	@Column(name="menu_url",length=300)
//	@ExcelColumn(title="对应的链接",column=3)
	private String url;
	/**
	 * 菜单状态
	 * 节点状态，'open' 或 'closed'，默认：'open'。如果为'closed'的时候，将不自动展开该节点。
	 */
//	@ExcelColumn(title="菜单状态",column=4)
	private String state;
	
	
	/**
	 * 图标
	 */
	@Column(name="ICON_CLS",length=100)
//	@ExcelColumn(title="图标",column=5)
	private String iconCls;
	
	/**
	 * 模块英文名称
	 */
	@Column(name="EN_NAME",length=100)
//	@ExcelColumn(title="模块英文名称",column=6)
	private String enName;
	

	// Constructors

	/** default constructor */
	public TbMenu() {
	}

	/** minimal constructor */
	public TbMenu(String text, String menuGrade) {
		this.text = text;
		this.menuGrade = menuGrade;
	}

	/** full constructor */
	public TbMenu(String text, String menuGrade, String menuParent) {
		this.text = text;
		this.menuGrade = menuGrade;
		this.menuParent = menuParent;
	}

	// Property accessors
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	public String getMenuGrade() {
		return this.menuGrade;
	}

	public void setMenuGrade(String menuGrade) {
		this.menuGrade = menuGrade;
	}

	
	public String getMenuParent() {
		return this.menuParent;
	}

	public void setMenuParent(String menuParent) {
		this.menuParent = menuParent;
	}

	public List<TbMenu> getChildren() {
		return children;
	}

	public void setChildren(List<TbMenu> children) {
		this.children = children;
	}

	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getIconCls() {
	    return iconCls;
	}

	public void setIconCls(String iconCls) {
	    this.iconCls = iconCls;
	}
	public String getEnName() {
	    return enName;
	}

	public void setEnName(String enName) {
	    this.enName = enName;
	}
	
	public Boolean getChecked() {
	    return checked;
	}

	public void setChecked(Boolean checked) {
	    this.checked = checked;
	}

	@Override
	public String toString() {
		return text+menuGrade+menuParent;
	}
	
}