package com.github.webapp.backend.common.model.qo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

/**
 * @author wangweijiang
 * @since 2019-10-14 15:00
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageQO<T> {

    /**
     * 按创建时间倒序排序
     */
    public static final String ORDER_BY_CREATE_TIME_DESC = "create_time desc";

    @Range(min = 1, max = Integer.MAX_VALUE)
    private int pageNum = 1;

    @Range(min = 1, max = Integer.MAX_VALUE)
    private int pageSize = 10;

    private String orderBy;

    private T condition;

    public PageQO(int pageNum, int pageSize) {
        super();
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return (this.pageNum - 1) * this.pageSize;
    }
}
