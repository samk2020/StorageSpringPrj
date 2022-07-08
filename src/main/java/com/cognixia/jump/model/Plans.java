package com.cognixia.jump.model;
import java.util.List;
import com.cognixia.jump.model.Plans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Plans {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String plan;
	
	@Column(nullable = false)
	private double price;
	

	public Plans() {
		
	}

	public Plans(Integer id, String plan, double price) {
		super();
		this.id = id;
		this.plan = plan;
		this.price = price;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getplans() {
		return plan;
	}

	public void setPlans(String plan) {
		this.plan = plan;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	@Override
	public String toString() {
		return "Plans [id=" + id + ", plan=" + plan + ", price=" + price + "]";
	}

}
		
	/* old code
	@Id				
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(columnDefinition = "int default 1", nullable = false)
	private Integer qty;
	
	@ManyToOne
	@JoinColumn(name = "order", referencedColumnName = "id")
	private Order Onbr;
	
	@ManyToOne
	@JoinColumn(name = "plan", referencedColumnName = "id")
	private Plans plan;
	
	public void Item(Long id, Order Onbr, Plans pl) {
		//super();
		this.id = id;
		this.Onbr = Onbr;
		this.plan = pl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return Onbr;
	}

	public void setOrder(Order Onbr) {
		this.Onbr = Onbr;
	}

	public Plans getDataPlan() {
		return plan;
	}

	public void setDataPlan(Plans plan) {
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", order= " + Onbr + ", plan= " + plan + ", getClass()= "
				+ getClass() + "]";
	}
*/	
}