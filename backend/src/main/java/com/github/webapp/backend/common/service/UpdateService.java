package com.github.webapp.backend.common.service;

/**
 * @author wangweijiang
 * @since 2019-10-14 15:01
 */
public interface UpdateService<E, PK> {
    /**
     * 修改记录信息
     *
     * @param pk 主键
     * @param record 要修改的对象
     * @return 影响记录数
     */
    int updateByPk(PK pk, E record);

    /**
     * 修改记录信息
     *
     * @param pk 主键
     * @param record 要修改的对象
     * @return 影响记录数
     */
    int updateByPkSelective(PK pk, E record);

    /**
     * 保存或修改
     *
     * @param record 要修改的数据
     * @return 影响记录数
     */
    PK saveOrUpdate(E record);
}
