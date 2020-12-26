package ru.pa4ok.appname.database.entity;

import java.util.Date;

public class DateEntity
{
    private int id;
    private Date date;

    public DateEntity(int id, Date date) {
        this.id = id;
        this.date = date;
    }

    public DateEntity(Date date) {
        this(-1, date);
    }

    @Override
    public String toString() {
        return "DateEntity{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }

    public int getId() {
        return id;
    }

    public DateEntity setId(int id) {
        this.id = id;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public DateEntity setDate(Date date) {
        this.date = date;
        return this;
    }
}
