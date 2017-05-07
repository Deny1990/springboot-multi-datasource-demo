package com.yuan.boot.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by yuanxin on 17/5/5.
 */
@WebServlet(urlPatterns = "/xs/cometservlet", asyncSupported = true)
public class CometServlet extends HttpServlet
{
    Logger logger = LoggerFactory.getLogger(CometServlet.class);

    private static final long serialVersionUID = -8685285401859800066L;

    private final Queue<AsyncContext> asyncContexts = new LinkedBlockingQueue<>();

    private final Thread generator = new Thread("Async Event generator") {

        @Override
        public void run() {
            while (!generator.isInterrupted()) {// 线程有效
                try {
                    while (!asyncContexts.isEmpty()) {// 不为空
                        TimeUnit.SECONDS.sleep(10);// 秒，模拟耗时操作
                        AsyncContext asyncContext = asyncContexts.poll();
                        logger.info("thread is {}",Thread.currentThread().getName());
                        HttpServletResponse res = (HttpServletResponse) asyncContext.getResponse();
                        res.getWriter().write("{\"result\":\"OK - "+System.currentTimeMillis()+"\"}");
                        res.setStatus(HttpServletResponse.SC_OK);
                        res.setContentType("application/json");
                        asyncContext.complete();// 完成
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    };

    @Override
    public void init() throws ServletException
    {
        super.init();
        generator.start();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(">>>>>>>>>>CometServlet Request<<<<<<<<<<<");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext asyncContext = req.startAsync();
        asyncContext.setTimeout(20 * 1000L);
        logger.info("just do it,thread is {}",Thread.currentThread().getName());
        asyncContexts.offer(asyncContext);
    }

    @Override
    public void destroy() {
        super.destroy();
        generator.interrupt();
    }


}
