package hiber.model;

import jakarta.persistence.*;

@Entity
@Table (name = "cars")
public class Car {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String model;

    @Column
    private int series;

    @OneToOne (mappedBy = "car", cascade = CascadeType.ALL)
    private User user;

    public Car() {

    }
    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getSeries() {
        return series;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String toString() {
        return "car id = " + id + "\n" +
                "model = " + model + "\n" +
                "series = " + series;
    }
}