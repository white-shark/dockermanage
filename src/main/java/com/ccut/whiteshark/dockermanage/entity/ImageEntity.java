package com.ccut.whiteshark.dockermanage.entity;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/4/10 11:44 下午
 */
public class ImageEntity {
    private String id;
    private String repoTags;
    private Integer size;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRepoTags() {
        return repoTags;
    }

    public void setRepoTags(String repoTags) {
        this.repoTags = repoTags;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public ImageEntity(String id, String repoTags, Integer size) {
        this.id = id;
        this.repoTags = repoTags;
        this.size = size;
    }

    public ImageEntity() {
    }

    @Override
    public String toString() {
        return "ImageEntity{" +
                "id='" + id + '\'' +
                ", repoTags='" + repoTags + '\'' +
                ", size=" + size +
                '}';
    }
}
