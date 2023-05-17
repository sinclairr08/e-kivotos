package sinclairr08.ekivotosserver.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    private String name;
    private Integer star;
    private Integer cost;
    private Boolean isLimited;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Pickup> pickups = new ArrayList<>();

    public void setStudent(String name, Integer star, Integer cost, Boolean isLimited) {
        this.name = name;
        this.star = star;
        this.cost = cost;
        this.isLimited = isLimited;
    }
}
