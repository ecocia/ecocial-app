package com.example.ecocial;

public class Post {

    String postSubject;
    String postContent;
    String userName;
    String postedDateTime;
    String numComments;
    String numLikes;

    public Post(String postSubject, String postContent, String userName, String postedDateTime, String numComments, String numLikes) {
        this.postSubject = postSubject;
        this.postContent = postContent;
        this.userName = userName;
        this.postedDateTime = postedDateTime;
        this.numComments = numComments;
        this.numLikes = numLikes;
    }

    public String getPostSubject() {
        return postSubject;
    }

    public String getPostContent() {
        return postContent;
    }

    public String getUserName() {
        return userName;
    }

    public String getPostedDateTime() {
        return postedDateTime;
    }

    public String getNumComments() {
        return numComments;
    }

    public String getNumLikes() {
        return numLikes;
    }

    public void setPostSubject(String postSubject) {
        this.postSubject = postSubject;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPostedDateTime(String postedDateTime) {
        this.postedDateTime = postedDateTime;
    }

    public void setNumComments(String numComments) {
        this.numComments = numComments;
    }

    public void setNumLikes(String numLikes) {
        this.numLikes = numLikes;
    }
}
