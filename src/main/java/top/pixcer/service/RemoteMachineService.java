package top.pixcer.service;

import top.pixcer.entity.Ret;

/**
 * Created by HectorPu
 * on 2022/9/13 1:11 <hr/>
 * Desc：
 **/
public interface RemoteMachineService {
    Ret connectShell();
    Ret connectFtp();
    Ret downloadLog();
}
