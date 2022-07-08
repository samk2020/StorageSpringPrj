package com.cognixia.jump.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table; 

@Table(name ="ShoppingCart")
@Entity
public class Orders { 
	
	@Id
	@GeneratedValue
	private Long id; 
	
	@JoinColumn
	@ManyToOne
	private User enduser;  
	
	@Enumerated
	private Plans plan; 
	
	private String selection;

	public void Order(Long id, User enduser , Plans plan, List<ShoppingCart> selection) {
		super();
		this.id = id;
		this.enduser = enduser;
		this.plan = plan;
		this.selection = selection;
	}

	public Long getId() {
		Long id = null;
		return id ;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		User enduser = null;
		return enduser;
	}

	public void setUser(User enduser) {
		this.enduser = enduser;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", enduser=" + enduser + ", plan=" + plan + ", selection=" + selection + "]";
	} 
	
	
}
