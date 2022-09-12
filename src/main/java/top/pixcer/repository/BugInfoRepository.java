package top.pixcer.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import top.pixcer.entity.BugInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HectorPu
 * on 2022/9/12 23:10 <hr/>
 * Desc：
 **/
@Slf4j
@Repository
public class BugInfoRepository {
    private final JdbcTemplate jdbcTemplate;
    public BugInfoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BugInfo> getAllBugInfo(){
        log.debug("Query All Bug Info start.");
        List<BugInfo> list = new ArrayList<>();
        String sql = "select * from BUGTOOL.`BUG-INFO`";
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                BugInfo bugInfo = new BugInfo();
                bugInfo.setID(rs.getString(1));
                bugInfo.setIp(rs.getString(2));
                bugInfo.setName(rs.getString(3));
                bugInfo.setProduct(rs.getString(4));
                bugInfo.setVersion(rs.getString(5));
                bugInfo.setLogDir(rs.getString(6));
                bugInfo.setContext(rs.getString(7));
                list.add(bugInfo);
            }
        });
        log.debug("Query All Bug Info end.");
        return list;
    }

    public int modifyBugInfo(BugInfo bugInfo){
//        jdbcTemplate
        return 0;
    }




}
