package proctor.org.example.listener;

import org.apache.commons.lang3.StringUtils;
import ru.abtestingframework.core.ABEngine;

import javax.servlet.*;
import java.io.IOException;

public class PageStatisticListener implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String pageName = servletRequest.getParameter(ABEngine.PATTERN_VALUE);
        if (StringUtils.isNotBlank(pageName)) {
            ABEngine.increment(pageName);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
