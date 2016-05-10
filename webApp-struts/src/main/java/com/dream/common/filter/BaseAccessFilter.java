package com.dream.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 访问控制Filter
 * @author dengcheng
 *
 */
public class BaseAccessFilter implements  Filter {
	private Log log = LogFactory.getLog(BaseAccessFilter.class);

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}


	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;	
		HttpServletResponse res=(HttpServletResponse) response;
		//AccessMeta am = metaService.getMeta(req);
		//am.getRouter().go(am, res);
		//req.getRequestDispatcher("").forward(req, res);
	    log.info("in BaseAccessFilter.....");
		try{
			chain.doFilter(request, response);
		}catch (Exception ex) {
			ex.printStackTrace();
			log.error("Captured Exception Exception URL: " + req.toString());
		}catch(Throwable e) {
			e.printStackTrace();
			log.error("Captured Throwable Exception URL: " + req.toString());
			log.error(this.getClass(), e);
		}
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
