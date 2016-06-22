package domain;

// Generated 2016-6-1 14:59:12 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name = "role", catalog = "blog_user")
public class Role implements java.io.Serializable {

	private Integer roleId;
	private String rolename;
	private boolean deleted;
	private String remark;
	private Integer cn1;
	private String cn2;
	private String cn3;
	private String cn4;
	private String cn5;
	private Set<User> users = new HashSet<User>(0);

	public Role() {
	}

	public Role(String rolename, boolean deleted) {
		this.rolename = rolename;
		this.deleted = deleted;
	}

	public Role(String rolename, boolean deleted, String remark, Integer cn1,
			String cn2, String cn3, String cn4, String cn5, Set<User> users) {
		this.rolename = rolename;
		this.deleted = deleted;
		this.remark = remark;
		this.cn1 = cn1;
		this.cn2 = cn2;
		this.cn3 = cn3;
		this.cn4 = cn4;
		this.cn5 = cn5;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "roleId", unique = true, nullable = false)
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "rolename", nullable = false, length = 128)
	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@JsonIgnore
	@Column(name = "deleted", nullable = false)
	public boolean isDeleted() {
		return this.deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Column(name = "remark", length = 256)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "cn1")
	public Integer getCn1() {
		return this.cn1;
	}

	public void setCn1(Integer cn1) {
		this.cn1 = cn1;
	}

	@Column(name = "cn2", length = 512)
	public String getCn2() {
		return this.cn2;
	}

	public void setCn2(String cn2) {
		this.cn2 = cn2;
	}

	@Column(name = "cn3", length = 512)
	public String getCn3() {
		return this.cn3;
	}

	public void setCn3(String cn3) {
		this.cn3 = cn3;
	}

	@Column(name = "cn4", length = 512)
	public String getCn4() {
		return this.cn4;
	}

	public void setCn4(String cn4) {
		this.cn4 = cn4;
	}

	@Column(name = "cn5", length = 512)
	public String getCn5() {
		return this.cn5;
	}

	public void setCn5(String cn5) {
		this.cn5 = cn5;
	}
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", rolename=" + rolename
				+ ", deleted=" + deleted + ", remark=" + remark + ", cn1="
				+ cn1 + ", cn2=" + cn2 + ", cn3=" + cn3 + ", cn4=" + cn4
				+ ", cn5=" + cn5 + ", users=" + users + "]";
	}

	
}
