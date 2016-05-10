package com.dream.common.api.test;

import com.dream.common.annotation.ApiMethod;
import com.dream.common.api.test.request.RopHelloWorldRequest;
import com.dream.common.api.test.response.RopResponseHelloWorld;
import com.dream.common.utils.log.LogUtils;
import com.dream.common.utils.rop.RopRequestBody;
import com.dream.common.utils.rop.RopResponse;

public class HelloWorld {
   @ApiMethod(method = "api.com.test.sayHello", version = "1.0.0", cached=false)
   public RopResponse<RopResponseHelloWorld> sayHello(RopRequestBody<RopHelloWorldRequest> request){
	   RopResponse<RopResponseHelloWorld> response = new RopResponse<RopResponseHelloWorld>();
	   RopResponseHelloWorld responseData = new RopResponseHelloWorld();
	   RopHelloWorldRequest  helloWorld = request.getT();
	   LogUtils.startLogWeb("测试api的debug日志功能");
	   LogUtils.appendLogWeb("测试debug日志");
	   responseData.setContent("hello ! "+helloWorld.getUsername());
	   response.setData(responseData);
	   LogUtils.endLogWeb();
	   return response;
   }
}
