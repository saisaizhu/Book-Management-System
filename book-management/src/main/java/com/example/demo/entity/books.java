package com.example.demo.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author group
 * @since 2022-12-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Books对象", description="")
public class books implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String status;

    private Integer number;

    private String author;

    private Integer value;

    private String language;

    private String category;

}
