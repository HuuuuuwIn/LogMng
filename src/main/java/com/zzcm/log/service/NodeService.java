package com.zzcm.log.service;

import com.zzcm.log.bean.Node;

import java.util.List;

/**
 * Created by Administrator on 2015/12/23.
 */
public interface NodeService extends BaseService<Node,Integer>{
    public List<Node> getAllNodes();
}
