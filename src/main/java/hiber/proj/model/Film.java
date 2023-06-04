package hiber.proj.model;


import javax.persistence.*;

@Entity
@Table(name = "Film")
public class Film {

    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "year_of_production")
    private int year_of_production;

    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "director_id")
    private Director owner;

    public Film() {
    }

    public Film(String name, int year_of_production) {
        this.name = name;
        this.year_of_production = year_of_production;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear_of_production() {
        return year_of_production;
    }

    public void setYear_of_production(int year_of_production) {
        this.year_of_production = year_of_production;
    }

    public Director getOwner() {
        return owner;
    }

    public void setOwner(Director owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year_of_production=" + year_of_production +
                '}';
    }
}
