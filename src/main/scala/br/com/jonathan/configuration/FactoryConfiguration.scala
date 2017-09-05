package br.com.jonathan.configuration

import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.web.util.UrlUtils
import org.springframework.web.filter.GenericFilterBean
import java.io.IOException

@Configuration
class FactoryConfiguration {

  @Bean
  def filterRequest(): GenericFilterBean = {
    new GenericFilterBean() {
      @throws(classOf[IOException])
      @throws(classOf[ServletException])
      override def doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        val httpRequest: HttpServletRequest = (request match {
          case x: HttpServletRequest => x
        })
        val httpResponse: HttpServletResponse = (response match {
          case x: HttpServletResponse => x
        })
        if ("/".equals(UrlUtils.buildRequestUrl(httpRequest))) {
          httpResponse.sendRedirect("/product/")
        } else {
          chain.doFilter(request, response)
        }
      }
    }
  }

}