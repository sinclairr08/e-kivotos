package sinclairr08.ekivotosserver.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
public class Pickup {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pickup_id")
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    public void setPickup(LocalDate startDate, LocalDate endDate, Student student) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.student = student;
    }
}
