package com.github.webapp.backend.common.model.bo;

import com.github.webapp.backend.common.model.po.TreePO;

import java.util.List;

/**
 * @author wangweijiang
 * @since 2019-10-14 15:07
 */
public class Node<E extends TreePO> {
    private E parent;

    private List<Node<E>> children;
}
