package top.test.pixcer;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.pixcer.config.SpringConfig;
import top.pixcer.repository.BugInfoRepo;
import top.pixcer.repository.BugInfoRepository;

/**
 * Created by HectorPu
 * on 2022/9/13 0:01 <hr/>
 * Desc：
 **/
public class JdbcTest {
    @Test
    public void testQuery(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BugInfoRepository bean = context.getBean("bugInfoRepository", BugInfoRepository.class);
        bean.getAllBugInfo().forEach(System.out::println);

    }
    @Test
    public void testCRUD(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BugInfoRepo repo = context.getBean("BugInfoRepo", BugInfoRepo.class);
        repo.findAll().forEach(System.out::println);
    }
}
