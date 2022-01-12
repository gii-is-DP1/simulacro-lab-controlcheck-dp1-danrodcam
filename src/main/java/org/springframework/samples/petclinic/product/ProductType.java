package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "prtypes")
@Getter
@Setter
public class ProductType extends BaseEntity {
	
	@NotNull
	@Size(min=3,max=50)
	@Column(name = "name",unique = true)
    String name;
	
	
	
	
}
