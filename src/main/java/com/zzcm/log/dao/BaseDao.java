package com.zzcm.log.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2015/12/22.
 */
public interface BaseDao<T,K extends Serializable> {

    public T findById(K id);

    public T saveOrUpdate(T bean);

    public boolean deleteById(K id);

    public boolean delete(T bean);

    public T update(T bean);

    public List<T> getAll();
}
