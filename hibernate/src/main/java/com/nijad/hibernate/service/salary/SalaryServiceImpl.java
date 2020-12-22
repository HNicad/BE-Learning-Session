package com.nijad.hibernate.service.salary;

import com.nijad.hibernate.dao.entity.Salary;
import com.nijad.hibernate.dao.repository.SalaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SalaryServiceImpl implements SalaryService {
    private final SalaryRepository salaryRepository;

    public SalaryServiceImpl(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    @Override
    public List<Salary> findByEmployeeId(Long id) {
        return salaryRepository.findByEmployeeId(id);
    }

    @Override
    public Optional<Salary> findById(Long id) {
        return salaryRepository.findById(id);
    }

    @Override
    public Salary save(Salary salary) {
        return salaryRepository.save(salary);
    }
}
