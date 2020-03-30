package core.domain;

import core.domain.helper.BasicDomain;

/**
 * JobTitle class
 */
public class JobTitle extends BasicDomain implements Comparable<JobTitle> {

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

    /**
     * Base gross salary for this position
     */
    private float baseGrossSalary;

    @Override
    public String toString() {
        return this.name + " - " + this.department;
    }

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

    public float getBaseGrossSalary() {
        return baseGrossSalary;
    }

    public void setBaseGrossSalary(float baseGrossSalary) {
        this.baseGrossSalary = baseGrossSalary;
    }

    @Override
    public int compareTo(JobTitle jobTitle) {
        if (jobTitle.id == this.id) {
            return 0;
        }

        if (this.leadershipPosition && !jobTitle.leadershipPosition) {
            return 1;
        } else if (!this.leadershipPosition && jobTitle.leadershipPosition) {
            return -1;
        }

        if (jobTitle.superiorPosition == this) {
            return 1;
        } else if (this.superiorPosition == jobTitle) {
            return -1;
        } else if (jobTitle.coordinatingPosition == this) {
            return -1;
        } else if (this.coordinatingPosition == jobTitle) {
            return 1;
        }

        JobTitle nextPosition = this.superiorPosition;
        while (nextPosition != null) {
            if (nextPosition.getId() == jobTitle.getId()) {
                return -1;
            }
            nextPosition = this.coordinatingPosition;
        }

        nextPosition = jobTitle.superiorPosition;
        while (nextPosition != null) {
            if (nextPosition.getId() == this.getId()) {
                return 1;
            }
            nextPosition = this.coordinatingPosition;
        }

        if (this.baseGrossSalary == jobTitle.baseGrossSalary) {
            return 0;
        }

        return this.baseGrossSalary > jobTitle.baseGrossSalary ? 1 : -1;
    }
}
