package top.pixcer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import top.pixcer.entity.BugInfo;

/**
 * Created by HectorPu
 * on 2022/9/13 0:18 <hr/>
 * Desc：
 **/
@Repository
public interface BugInfoRepo extends CrudRepository<BugInfo, String> {
}
