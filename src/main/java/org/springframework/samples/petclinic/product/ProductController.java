package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
	
	private static final String VIEWS_PRODUCT_CREATE_FORM = "products/createOrUpdateProductForm";
	
	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@GetMapping(value = "/product/create")
	public String initCreationForm(Map<String, Object> model) {
		Product product = new Product();
		List<ProductType>tiposProductos = this.productService.tiposProductos();
		model.put("product", product);
		model.put("tipos", tiposProductos);
		return VIEWS_PRODUCT_CREATE_FORM;
		
	}

	@PostMapping(value = "/product/create")
	public String processCreationForm(@Valid Product product, BindingResult result,Map<String,Object>model) {
		if (result.hasErrors()) {
			List<ProductType>tiposProductos = this.productService.tiposProductos();
			model.put("tipos", tiposProductos);
			return VIEWS_PRODUCT_CREATE_FORM;
		}
		else {
			this.productService.save(product);
			model.put("message", "Producto creado satisfactoriamente");
			return "welcome";
		}
	}
   
}
