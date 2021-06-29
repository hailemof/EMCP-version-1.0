package net.mofed.reportracking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.mofed.reportracking.app.model.Trainee;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Integer> {

}
