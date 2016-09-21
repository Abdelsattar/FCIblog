
package com.sattar.fciblog.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("likeCount")
    @Expose
    private String likeCount;
    @SerializedName("isLike")
    @Expose
    private String isLike;
    @SerializedName("owner")
    @Expose
    private Owner owner;

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time The time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return The content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content The content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return The likeCount
     */
    public String getLikeCount() {
        return likeCount;
    }

    /**
     * @param likeCount The likeCount
     */
    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * @return The isLike
     */
    public String getIsLike() {
        return isLike;
    }

    /**
     * @param isLike The isLike
     */
    public void setIsLike(String isLike) {
        this.isLike = isLike;
    }

    /**
     * @return The owner
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * @param owner The owner
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

}
