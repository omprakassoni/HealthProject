package com.health.domain.security;



import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.health.model.Category;
import com.health.model.Language;
import com.health.model.User;

@Entity
@Table(name="user_role")
public class UserRole 
{	
	@Id
	private  Long userRoleId;
	
	private Timestamp created;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="role_id")
	private Role role;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="lan_id")
	private Language lan;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cat_id")
	private Category cat;
	
	private boolean status=false;
	
	private boolean revoked = false;
	

	public Category getCategory() {
		return cat;
	}

	public void setCategory(Category category) {
		this.cat = category;
	}


	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}


	public UserRole(){		

	}
	
	public UserRole(User user, Role role) {
		this.user = user;
		this.role = role;
	}
	
	public UserRole(User user,boolean status) {
		this.user = user;
		this.status = status;
	}
	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public Language getLanguage() {
		return lan;
	}

	public void setLanguage(Language language) {
		this.lan = language;
	}

	public Language getLan() {
		return lan;
	}

	public void setLan(Language lan) {
		this.lan = lan;
	}

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	public boolean isRevoked() {
		return revoked;
	}

	public void setRevoked(boolean revoked) {
		this.revoked = revoked;
	}
	
}
