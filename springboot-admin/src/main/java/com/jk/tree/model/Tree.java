package com.jk.tree.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Tree
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/18 14:46
 * @Version V1.0
 **/
@Data
public class Tree implements Serializable {

    private static final long serialVersionUID = -717929878577589377L;
    private Integer id;

    private String text;

    private String href;

    private Integer pid;

    private List<Tree> nodes;

    private Boolean leaf;

    private Boolean selectable;


}
