package cn.coolwind.ssh.web.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "aaa")
public class Test implements Serializable {


    private static final long serialVersionUID = 6977090527540089886L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    private float name;

    private String num;

    private String date;

    public Test(int id, float name, String value, String date) {
        this.id = id;
        this.name = name;
        this.num = value;
        this.date = date;
    }

    public Test() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getName() {
        return name;
    }

    public void setName(float name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
