package top.pixcer.service;

import java.util.Optional;

/**
 * Created by HectorPu
 * on 2022/9/10 17:24 <hr/>
 * Desc：
 **/
public interface OptionService {

    public Optional<String> getOption(String key);

    /**
     * acquire application workspace ...
     * @return init or find user config workspace ..
     */
    public String getWorkSpace();

    /**
     * set application workspace ..
     * @param value workspace path
     */
    public void setWorkSpace(String value);

    /**
     * application option init
     */
    void init();

}
