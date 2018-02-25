package com.xxscloud.core.domain;

import java.io.Serializable;
import java.util.Objects;

public abstract class BaseDomainAggregation<Root extends Serializable> implements DomainAggregation<Root> {

    /**
     * 比较是否相等.
     *
     * @param value 比较的值
     * @return 是否一样
     */
    @Override
    public boolean equals(Object value) {
        if (Objects.isNull(value)) {
            return false;
        }
        if (this == value) {
            return true;
        }
        if (!Objects.equals(getClass(), value.getClass())) {
            return false;
        }

        DomainAggregation<?> domainObject = (DomainAggregation<?>) value;
        return Objects.equals(this.getRoot(), domainObject.getRoot());
    }


    /**
     * hash 值.
     *
     * @return hash 值
     */
    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode += null == getRoot() ? 0 : getRoot().hashCode() * 31;
        return hashCode;
    }
}
