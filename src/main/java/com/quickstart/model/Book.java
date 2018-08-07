package com.quickstart.model;

import org.hibernate.validator.constraints.Range;

/**
 * Created by bian17888 on 2018/8/5.
 */
public class Book {
    private Integer id;
    private String name;

    @Range(min = 0, max = 10, message = "请输入0~10之间的数字")
    private Float score;
    private String link;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
