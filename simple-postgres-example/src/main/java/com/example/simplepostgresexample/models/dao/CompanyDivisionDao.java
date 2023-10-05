package com.example.simplepostgresexample.models.dao;

import com.example.simplepostgresexample.models.enums.CompanyDivisionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "company_divisions", schema = "data")
public class CompanyDivisionDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    private String name;
    private String mainAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false,
            insertable = false, updatable = false,
            foreignKey = @ForeignKey(name = "fk_company_divisions_company_id"))
    private CompanyDao company;

    @Column(name = "company_id", nullable = false)
    private UUID companyId;

    @Enumerated(EnumType.STRING)
    private CompanyDivisionStatus status;

    @Version
    private Long version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyDivisionDao that = (CompanyDivisionDao) o;
        return Objects.equals(id, that.id) && Objects.equals(companyId, that.companyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyId);
    }

    @Override
    public String toString() {
        return "CompanyDivisionDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mainAddress='" + mainAddress + '\'' +
                ", companyId=" + companyId +
                '}';
    }
}
