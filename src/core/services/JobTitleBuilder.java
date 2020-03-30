package core.services;

import core.domain.Department;
import core.domain.JobTitle;
import util.helper.RandomGenerator;

import java.util.Date;

/**
 * JobTitle builder pattern
 */
public class JobTitleBuilder {

    /**
     * Create new job title
     */
    public static JobTitle createJobTitle(String name, Department department, boolean leadershipPosition, float baseHourRate) {
        JobTitle jobTitle = new JobTitle();

        jobTitle.setName(name);
        jobTitle.setLeadershipPosition(leadershipPosition);
        jobTitle.setId(RandomGenerator.generateId());
        jobTitle.setDepartment(department);
        jobTitle.setBaseGrossSalary(baseHourRate);
        jobTitle.setCreated(new Date());

        return jobTitle;
    }

}
