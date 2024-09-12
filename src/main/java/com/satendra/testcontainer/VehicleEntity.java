package com.satendra.testcontainer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicle")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleEntity {

    @Id
    @SequenceGenerator(name = "seq_vehicle", sequenceName = "seq_vehicle", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vehicle")
    private long id;

    private String name;
}
