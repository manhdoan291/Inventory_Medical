package com.java1906.demointerceptor.com.example.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired
	private ProductService service; 
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.save(product);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Product product = service.get(id);
		mav.addObject("product", product);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";		
	}

//	@RequestMapping("/save-product")
//	public String uploadResources( HttpServletRequest servletRequest,
//								   @ModelAttribute Product product,
//								   Model model)
//	{
//		//Get the uploaded files and store them
//		List<MultipartFile> files = product.getImages();
//		List<String> fileNames = new ArrayList<String>();
//		if (null != files && files.size() > 0)
//		{
//			for (MultipartFile multipartFile : files) {
//
//				String fileName = multipartFile.getOriginalFilename();
//				fileNames.add(fileName);
//
//				File imageFile = new File(servletRequest.getServletContext().getRealPath("/image"), fileName);
//				try
//				{
//					multipartFile.transferTo(imageFile);
//				} catch (IOException e)
//				{
//					e.printStackTrace();
//				}
//			}
//		}
//
//		// Here, you can save the product details in database
//
//		model.addAttribute("product", product);
//		return "viewProductDetail";
//	}

}

