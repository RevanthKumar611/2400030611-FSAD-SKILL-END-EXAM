package com.klef.fsad.exam;
import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name="transport")
public class Transport 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="date")
    private Date date;
    @Column(name="status")
    private String status;
    @Column(name="type")
    private String type;
    @Column(name="cost")
    private double cost;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
}
