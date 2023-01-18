package raquelwinkeler.apirestfulcourse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import raquelwinkeler.apirestfulcourse.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
