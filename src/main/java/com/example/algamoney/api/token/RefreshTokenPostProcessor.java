package com.example.algamoney.api.token;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.example.algamoney.api.config.property.AlgamoneyApiProperty;

@ControllerAdvice
public class RefreshTokenPostProcessor implements ResponseBodyAdvice<OAuth2AccessToken> {

	@Autowired
	private AlgamoneyApiProperty algamoneyApiProperty;
	
	
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		// TODO Auto-generated method stub
		return returnType.getMethod().getName().equals("postAccessToken");
	}

	@Override
	public OAuth2AccessToken beforeBodyWrite(OAuth2AccessToken body, MethodParameter returnType,
			MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
			ServerHttpRequest request, ServerHttpResponse response) {
		
		HttpServletRequest req = ((ServletServerHttpRequest) request).getServletRequest();
		HttpServletResponse resp = ((ServletServerHttpResponse) response).getServletResponse();
		
		//pegando o token
		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) body;
		
		//Pegando o refreshToken do corpo da resposta
		String refreshToken = body.getRefreshToken().getValue();
		//adicionando o refreshToken no Cookie
		addRefreshTokenInCookie(refreshToken, req, resp);
		removeRefreshTokenAtBody(token);
		
		
		//devolve as informaçoes do token para a requisicao
		return body;
	}

	private void removeRefreshTokenAtBody(DefaultOAuth2AccessToken token) {
		token.setRefreshToken(null);
		
	}

	private void addRefreshTokenInCookie(String refreshToken, HttpServletRequest req, HttpServletResponse resp) {
		
		Cookie refreshTokenCookie = new Cookie("refreshToken", refreshToken);
		//Setando apenas para http
		refreshTokenCookie.setHttpOnly(true);
		//Nesse ponto é para definiçao de apenas https ou nao
		refreshTokenCookie.setSecure(algamoneyApiProperty.getSeguranca().isEnableHttps()); // TODO: Mudar para true em producao
		//pegando o Path
		refreshTokenCookie.setPath(req.getContextPath() + "/oauth/token");
		//Validade do Cookie
		refreshTokenCookie.setMaxAge(2592000);
		resp.addCookie(refreshTokenCookie);
	}

}
