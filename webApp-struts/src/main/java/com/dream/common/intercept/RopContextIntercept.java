package com.dream.common.intercept;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.dream.common.utils.DateConverter;
import com.dream.common.utils.ServiceMethodHandler;
import com.dream.common.utils.rop.RopContext;
import com.dream.common.utils.rop.RopRequest;
import com.dream.common.utils.rop.RopRequestBody;
import com.dream.common.utils.rop.RopServiceHandler;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;



public class RopContextIntercept implements Interceptor {
	private static final Log log = LogFactory.getLog(RopContextIntercept.class);
	private static final long serialVersionUID = 6249695319594379478L;
	private RopServiceHandler ropServiceHandler; 
	
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation invocation) throws Exception {
			log.debug("init rop intercept");
			String method = this.getRequest().getParameter("method");
			String version = this.getRequest().getParameter("version");
			ServiceMethodHandler handler = null;
			handler = ropServiceHandler.getHandler(method, version);

			Map<String, Object> parameterMap = invocation
					.getInvocationContext().getParameters();
			final ActionContext context = invocation.getInvocationContext();
			RopRequestBody<?> o = this.buildParams(handler, parameterMap);
			log.debug("method:"+method+"|version:"+version);
			RopContext rc = new RopContext();
			rc.setRequestData(o);
			rc.setServiceHandler(handler);
			rc.setRequest(getRequest());
			rc.setResponse(getResponse());
			
			invocation.getInvocationContext().getParameters()
					.put("ropContext", rc);
			return invocation.invoke();


	}

	/**
	 * 鏋勫缓鍙傛暟
	 * 
	 * @param handler
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 */
	private RopRequestBody<?> buildParams(ServiceMethodHandler handler,
			final Map<String, Object> parameterMap)
			throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Type[] typs = handler.getHandlerMethod().getGenericParameterTypes();
		Type t = typs[0];
		Class<?> obj = null;
		if (t instanceof ParameterizedType)/**//* 濡傛灉鏄硾鍨嬬被鍨� */{
			Type[] types = ((ParameterizedType) t).getActualTypeArguments();// 娉涘瀷绫诲瀷鍒楄〃
			for (Type type : types) {
				obj = (Class<?>) type;
			}
		}
		Object object = obj;
		object = obj.newInstance();

		@SuppressWarnings("unchecked")
		
		final RopRequest requestBody = (RopRequest) object;
		if(object instanceof RopRequest){
			RopRequest ropRequest = (RopRequest)object;
			ropRequest.setRequest(getRequest());
			ropRequest.setResponse(getResponse());
		}
		
		DateConverter dateConverter = new DateConverter();
		ConvertUtils.register(dateConverter, Date.class);// 娉ㄥ唽銏犱釜鏃ユ湡绫�
		//log.info(JSONObject.toJSON(parameterMap).toString());
 		RopRequestBody<Object> body  = null;
		try {
            BeanUtils.populate(requestBody, parameterMap);
            body = new RopRequestBody<Object>();
            body.setT(requestBody);
            
        } catch (Exception e) {
            log.error(e.getMessage());
        }
		return body;
	}

	/**
	 * 鑾峰彇HttpRequest
	 * 
	 * @return
	 */
	private HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	private HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	public RopServiceHandler getRopServiceHandler() {
		return ropServiceHandler;
	}

	public void setRopServiceHandler(RopServiceHandler ropServiceHandler) {
		this.ropServiceHandler = ropServiceHandler;
	}
}
