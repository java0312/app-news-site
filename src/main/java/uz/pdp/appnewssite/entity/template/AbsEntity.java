package uz.pdp.appnewssite.entity.template;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import uz.pdp.appnewssite.entity.User;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
@Data
public abstract class AbsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false, nullable = false) //__updatable = false__ -> o'zgartrish mumkin emas
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private Timestamp updatedAt;

    @JoinColumn(updatable = false) //Why? Chunki user ustun emas object _|_ tahrirlash mumkin emas
    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY) //userni chaqirsakkina database dan olib kelsin
    private User createdBy;

    @LastModifiedBy //oxirgi marta kim tahrirlagani
    @ManyToOne(fetch = FetchType.LAZY)
    private User updatedBy;

}
