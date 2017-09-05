package br.com.jonathan.service

import org.springframework.beans.factory.annotation.Autowired
import br.com.jonathan.repository.ProductRepository
import org.springframework.stereotype.Service
import br.com.jonathan.domain.Product
import java.util.List

@Service
class ProductService @Autowired() (private val repository: ProductRepository) {

  def findAll(): List[Product] = {
    repository.findAll()
  }

  def findOne(id: Long): Product = {
    repository.findOne(id)
  }

  def save(product: Product): Product = {
    repository.save(product)
  }

  def delete(id: Long) = {
    repository.delete(id)
  }

}