package com.xxscloud.core.domain;

import java.io.Serializable;

/**
 * @param <Root>
 * @author 李小双 2018.1.10
 * 领域驱动的聚合根
 */
public interface DomainAggregation<Root extends Serializable> extends DomainObject<Root> {
    //TODO 领域事件触发器

    /**
     * 获得聚合根.
     *
     * @return 聚合根
     */
    Root getRoot();

    /**
     * 设置聚合根.
     *
     * @param rootValue 聚合根
     */
    void setRoot(Root rootValue);
}
