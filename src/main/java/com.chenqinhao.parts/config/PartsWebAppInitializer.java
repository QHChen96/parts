package com.chenqinhao.parts.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Administrator on 2017/1/5.
 */
public class PartsWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * @return 配置ContextLoaderListener创建的上下文的bean
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**
     * @return 用来定义DispatcherServlet应用上下文的bean
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * @return 请求映射路径
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected boolean isAsyncSupported() {
        return true;
    }
}
