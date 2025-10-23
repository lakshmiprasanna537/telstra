package au.com.telstra.simcardactivator.Repository;

import au.com.telstra.simcardactivator.Entity.SimCardActivationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public  interface SimCardActivationRepository extends JpaRepository<SimCardActivationRecord, Long> {

}
