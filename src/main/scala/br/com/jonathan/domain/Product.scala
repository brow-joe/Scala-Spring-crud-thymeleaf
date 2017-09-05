package br.com.jonathan.domain

import java.lang.Long
import java.util.Date

import scala.reflect._
import scala.beans.BeanProperty

import javax.persistence._
import javax.validation.constraints.NotNull

import org.hibernate.validator.constraints.NotBlank
import org.springframework.format.annotation.DateTimeFormat

@Entity
class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @BeanProperty
  var id: Long = _

  @Column(nullable = false, length = 150, name = "nome")
  @NotBlank(message = "Nome é uma informação obrigatória.")
  @BeanProperty
  var name: String = _

  @Column(nullable = false, name = "quantidade")
  @NotNull(message = "Quantidade é uma informação obrigatória.")
  @BeanProperty
  var quantity: Integer = _

  @Column(nullable = false, name = "valorVenda")
  @NotNull(message = "Valor de venda é uma informação obrigatória.")
  @BeanProperty
  var saleValue: Double = _

  @Column(nullable = false, name = "dataValidade")
  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @NotNull(message = "Data de validade é uma informação obrigatória.")
  @BeanProperty
  var expirationDate: Date = _

}