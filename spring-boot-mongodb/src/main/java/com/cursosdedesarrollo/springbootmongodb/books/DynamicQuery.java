package com.cursosdedesarrollo.springbootmongodb.books;

import java.util.Date;

public class DynamicQuery {

    private String authorNameLike;
    private Date publishDateBefore;
    private Date publishDateAfter;
    private String subject;

    public String getAuthorNameLike() {
        return authorNameLike;
    }

    public void setAuthorNameLike(String authorNameLike) {
        this.authorNameLike = authorNameLike;
    }

    public Date getPublishDateBefore() {
        return publishDateBefore;
    }

    public void setPublishDateBefore(Date publishDateBefore) {
        this.publishDateBefore = publishDateBefore;
    }

    public Date getPublishDateAfter() {
        return publishDateAfter;
    }

    public void setPublishDateAfter(Date publishDateAfter) {
        this.publishDateAfter = publishDateAfter;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
