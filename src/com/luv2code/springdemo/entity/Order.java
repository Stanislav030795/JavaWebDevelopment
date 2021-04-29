package com.luv2code.springdemo.entity;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;

import com.luv2code.springdemo.validation.CheckPhone;

@Entity
@Table(name="productOrder")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull(message="Имя обязательное поле!")
	@Size(min=4, message="Name length must be more than four!")
	@Column(name="user_name")
	private String userName;
	
	@CheckPhone
	@NotNull(message="Телефон обязательное поле!")
	@Column(name="user_phone")
	private String userPhone;
	
	@Column(name="user_comment")
	private String userComment;
	
	@Column(name="user_id")
	private Integer userId;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Column(name="data")
	private ZonedDateTime dateTime;
	
	@Column(name="status")      
	private int status;
	
	@ManyToMany(fetch=FetchType.EAGER,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name="OrderDetail",
			joinColumns=@JoinColumn(name="order_id"),
			inverseJoinColumns=@JoinColumn(name="product_id")
			)
	private List<Product> products;
	

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserComment() {
		return userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userName=" + userName + ", userPhone=" + userPhone + ", userComment="
				+ userComment + ", userId=" + userId + ", startDateTime=" + dateTime + ", status=" + status + "]";
	}
	

	public ZonedDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(ZonedDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Order(String userName, String userPhone,String userComment, ZonedDateTime dateTime) {
		this.userName = userName;
		this.userPhone = userPhone;
		this.userComment = userComment;
		this.dateTime = dateTime;
	}
	public Order() {
		
	}

	public Order(String userName, String userPhone,String userComment) {
		this.userName = userName;
		this.userPhone = userPhone;
		this.userComment = userComment;
	}
	
	public Order(String userName) {
		this.userName = userName;
	}
	public void addProduct(Product theProduct) {
		
		if (products == null) {
			products = new ArrayList<>();
		}
		
		products.add(theProduct);
	}
	
}
