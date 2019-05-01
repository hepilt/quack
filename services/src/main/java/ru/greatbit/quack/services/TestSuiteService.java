package ru.greatbit.quack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.greatbit.quack.beans.TestSuite;
import ru.greatbit.quack.dal.CommonRepository;
import ru.greatbit.quack.dal.TestSuiteRepository;
import ru.greatbit.whoru.auth.Session;

@Service
public class TestSuiteService extends BaseService<TestSuite> {

    @Autowired
    private TestSuiteRepository repository;

    @Override
    protected CommonRepository<TestSuite> getRepository() {
        return repository;
    }

    @Override
    protected void beforeSave(Session session, TestSuite testSuite) {
        super.beforeSave(session, testSuite);
        if (testSuite.getFilter() != null) {
            testSuite.getFilter().setLimit(0);
            testSuite.getFilter().setSkip(0);
        }
    }
}
