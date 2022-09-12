package top.pixcer.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * Created by HectorPu
 * on 2022/9/10 18:39 <hr/>
 * Desc：
 **/
@Service("defaultInitService")
@RequiredArgsConstructor
public class DefaultInitService implements InitService , InitializingBean {

    private final OptionService optionService;



    @Override
    public void init() {
        // workspace check ...
        optionService.init();

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }
}
