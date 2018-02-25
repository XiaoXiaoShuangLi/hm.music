package com.xxscloud.api;

import com.xxscloud.api.core.ApiGatewayHand;
import com.xxscloud.api.data.TimeDto;
import com.xxscloud.api.service.MusicService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 李小双 2018.2.22
 * API 控制器
 */
public class ApiGatewayServlet extends HttpServlet {

    /**
     * IOC 注册对象.
     */
    private ApiGatewayHand apiGatewayHand;

    @Override
    public void init() throws ServletException {
        super.init();
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        apiGatewayHand = applicationContext.getBean(ApiGatewayHand.class);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        apiGatewayHand.handle(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        apiGatewayHand.handle(req, resp);
    }


//    @RequestMapping(value = {"time"}, method = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT})
//    public TimeDto time() {
//        return new TimeDto(System.currentTimeMillis());
//    }
}
