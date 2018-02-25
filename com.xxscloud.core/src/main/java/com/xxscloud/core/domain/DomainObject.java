package com.xxscloud.core.domain;

import java.io.Serializable;

/**
 * @param <Root> 聚合根
 * @author 李小双 2018.1.10
 * 领域对象基类
 */
public interface DomainObject<Root extends Serializable> extends Serializable {

}
