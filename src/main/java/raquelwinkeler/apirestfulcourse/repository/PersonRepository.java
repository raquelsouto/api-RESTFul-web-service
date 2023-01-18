package raquelwinkeler.apirestfulcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import raquelwinkeler.apirestfulcourse.dataVO.PersonVO;

@Repository
public interface PersonRepository extends JpaRepository<PersonVO, Long> {}
