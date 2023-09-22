package employee.myemployeecrud.Repository;

import employee.myemployeecrud.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Long> {
}
