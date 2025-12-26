package com.wendellyv.workshopmongo.dto;

import com.wendellyv.workshopmongo.domain.Post;
import com.wendellyv.workshopmongo.domain.User;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class PostDTO implements Serializable {

    @Id
    private String id;
    private String title;
    private String body;

    public PostDTO(Post obj) {
        this.id = obj.getId();
        this.title = obj.getTitle();
        this.body = obj.getBody();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
