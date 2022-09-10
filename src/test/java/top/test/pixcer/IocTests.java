package top.test.pixcer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;

/**
 * Created by HectorPu
 * on 2022/9/10 15:38 <hr/>
 * Desc：
 **/

public class IocTests {

    @Configuration
    public static class AppCOnfig {


    }

    @ContextConfiguration(classes = AppCOnfig.class)
    @RunWith(SpringRunner.class)
   public static class IocContainerTests implements ApplicationContextAware {

        private ApplicationContext applicationContext;

//        @Value("#{'classpath:work/schema.sql'}")
//        private Resource schemaResource;
       @Test
       public void  test() throws IOException {
           ResourceLoader applicationContext1 = applicationContext;
           Resource resource = applicationContext1.getResource("classpath:application.properties");

           System.out.println(resource);

           System.out.println(resource.exists());

//           System.out.println(schemaResource);
//           System.out.println(schemaResource.exists());

           Resource resource1 = applicationContext.getResource("classpath:work/schema.sql");
           System.out.println(resource1.exists());
           File file = resource1.getFile();
           ReadableByteChannel readableByteChannel = resource1.readableChannel();
           ByteBuffer allocate = ByteBuffer.allocate(1024);
           int read = readableByteChannel.read(allocate);
           readableByteChannel.close();

           if(read > 0) {
               System.out.println(new String(allocate.array(),0,read));
           }
           else {
               System.out.println("is empty");
           }

       }

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            this.applicationContext = applicationContext;
        }
    }
}
