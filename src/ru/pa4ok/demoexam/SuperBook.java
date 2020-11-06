package ru.pa4ok.demoexam;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public class SuperBook implements Externalizable
{
    private int id;
    private String title;
    private String author;

    public SuperBook(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public SuperBook() {}

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject(title);
        out.writeObject(author);
        //List<Integer> list = new ArrayList<>();
        //out.writeObject(list);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readInt();
        title = (String) in.readObject();
        author = (String) in.readObject();
        //List<Integer> list = (List<Integer>) in.readObject();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
