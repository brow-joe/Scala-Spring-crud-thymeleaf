package br.com.jonathan.repository

import org.springframework.data.jpa.repository.JpaRepository
import br.com.jonathan.domain.Product
import java.lang.Long

trait ProductRepository extends JpaRepository[Product, Long]