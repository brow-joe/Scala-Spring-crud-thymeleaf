package br.com.jonathan.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.bind.annotation.PostMapping
import br.com.jonathan.domain.Product
import javax.validation.Valid
import org.springframework.validation.BindingResult
import org.springframework.beans.factory.annotation.Autowired
import br.com.jonathan.service.ProductService

@Controller
@RequestMapping(Array("/product"))
class ProductController @Autowired() (private val service: ProductService) {

  @GetMapping(Array("/"))
  def findAll(): ModelAndView = {
    val view = new ModelAndView("/produto")
    view.addObject("products", service.findAll())
    view
  }

  @GetMapping(Array("/add"))
  def add(product: Product): ModelAndView = {
    val view = new ModelAndView("/produtoCadastro")
    view.addObject("product", product)
    view
  }

  @GetMapping(Array("/edit/{id}"))
  def edit(@PathVariable("id") id: Long): ModelAndView = {
    add(service.findOne(id))
  }

  @GetMapping(Array("/delete/{id}"))
  def delete(@PathVariable("id") id: Long): ModelAndView = {
    service.delete(id)
    findAll()
  }

  @PostMapping(Array("/save"))
  def save(@Valid product: Product, result: BindingResult): ModelAndView = {
    if (result.hasErrors()) {
      return add(product)
    }
    service.save(product)
    findAll()
  }

}