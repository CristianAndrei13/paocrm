package core.datafixture;

import core.domain.JobTitle;
import core.services.JobTitleBuilder;
import util.fixtures.Factory;
import util.helper.RandomGenerator;

import java.util.ArrayList;

public class JobTitleFactory implements Factory<JobTitle> {

    private ArrayList<JobTitle> fixtures = new ArrayList<>();

    public JobTitleFactory() {
        DepartmentFactory departmentFactory = new DepartmentFactory();

        this.fixtures.add(JobTitleBuilder.createJobTitle("CEO", departmentFactory.createRandom(), true, 6000));
        this.fixtures.add(JobTitleBuilder.createJobTitle("CTO", departmentFactory.createRandom(), true, 5000));
        this.fixtures.add(JobTitleBuilder.createJobTitle("Head of Custom Software Solutions", departmentFactory.createRandom(), true, 4500));
        this.fixtures.add(JobTitleBuilder.createJobTitle("Software Engineer", departmentFactory.createRandom(), false, 3500));
        this.fixtures.add(JobTitleBuilder.createJobTitle("Project Manager", departmentFactory.createRandom(), true, 2600));
        this.fixtures.add(JobTitleBuilder.createJobTitle("Business Analyst", departmentFactory.createRandom(), false, 2600));
        this.fixtures.add(JobTitleBuilder.createJobTitle("Team Leader", departmentFactory.createRandom(), true, 4000));
        this.fixtures.add(JobTitleBuilder.createJobTitle("Law Consultant", departmentFactory.createRandom(), false, 1000));
        this.fixtures.add(JobTitleBuilder.createJobTitle("Security Guard", departmentFactory.createRandom(), false, 400));
    }

    public JobTitle createRandom() {
        return this.fixtures.get(RandomGenerator.generateRandomInt(this.fixtures.size()));
    }

}
