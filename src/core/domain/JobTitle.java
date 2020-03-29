package core.domain;

import core.domain.helper.BasicDomain;

/**
 * JobTitle class
 */
public class JobTitle extends BasicDomain {

    /**
     * Name of job title
     */
    private String name;

    /**
     * The department of which it is part of
     */
    private Department department;

    /**
     * If is leadership position (Chief/Head/Manager/Lead), is true
     */
    private boolean leadershipPosition;

    /**
     * The next position at which one can promote
     */
    private JobTitle superiorPosition;

    /**
     * Position who coordinate employee's of this job title
     */
    private JobTitle coordinatingPosition;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public boolean isLeadershipPosition() {
        return leadershipPosition;
    }

    public void setLeadershipPosition(boolean leadershipPosition) {
        this.leadershipPosition = leadershipPosition;
    }

    public JobTitle getSuperiorPosition() {
        return superiorPosition;
    }

    public void setSuperiorPosition(JobTitle superiorPosition) {
        this.superiorPosition = superiorPosition;
    }

    public JobTitle getCoordinatingPosition() {
        return coordinatingPosition;
    }

    public void setCoordinatingPosition(JobTitle coordinatingPosition) {
        this.coordinatingPosition = coordinatingPosition;
    }
}
