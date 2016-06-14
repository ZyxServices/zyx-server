package com.zyx.pg.test;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.common.utils.ConfigUtils;
import com.alibaba.dubbo.container.Container;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by xw on 16-6-12.
 */
public class Test {
    public static final String CONTAINER_KEY = "dubbo.container";
    public static final String SHUTDOWN_HOOK_KEY = "dubbo.shutdown.hook";
    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    private static final ExtensionLoader<Container> loader = ExtensionLoader.getExtensionLoader(Container.class);
    private static volatile boolean running = true;

    public Test() {
    }

    public static void main(String[] args) {
        try {
            if (args == null || args.length == 0) {
                String e = ConfigUtils.getProperty("dubbo.container", loader.getDefaultExtensionName());
                args = Constants.COMMA_SPLIT_PATTERN.split(e);
            }

            final ArrayList var8 = new ArrayList();

            for (int e1 = 0; e1 < args.length; ++e1) {
                var8.add(loader.getExtension(args[e1]));
            }

            logger.info("Use container type(" + Arrays.toString(args) + ") to run dubbo serivce.");
            if ("true".equals(System.getProperty("dubbo.shutdown.hook"))) {
                Runtime.getRuntime().addShutdownHook(new Thread() {
                    public void run() {
                        Iterator i$ = var8.iterator();

                        while (i$.hasNext()) {
                            Container container = (Container) i$.next();

                            try {
                                container.stop();
                                Test.logger.info("Dubbo " + container.getClass().getSimpleName() + " stopped!");
                            } catch (Throwable var6) {
                                Test.logger.error(var6.getMessage(), var6);
                            }

                            Class t = Test.class;
                            synchronized (Test.class) {
                                Test.running = false;
                                Test.class.notify();
                            }
                        }

                    }
                });
            }

            Iterator var10 = var8.iterator();

            while (var10.hasNext()) {
                Container container = (Container) var10.next();
                container.start();
                logger.info("Dubbo " + container.getClass().getSimpleName() + " started!");
            }

            System.out.println((new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]")).format(new Date()) + " Dubbo service server started!");
        } catch (RuntimeException var7) {
            var7.printStackTrace();
            logger.error(var7.getMessage(), var7);
            System.exit(1);
        }

        Class var9 = Test.class;
        synchronized (Test.class) {
            while (running) {
                try {
                    Test.class.wait();
                } catch (Throwable var5) {
                    ;
                }
            }

        }
    }
}
