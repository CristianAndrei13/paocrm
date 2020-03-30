package core.persistence;

import core.datafixture.JobTitleFactory;
import core.domain.JobTitle;
import util.fixtures.RandomFixtures;

import java.util.ArrayList;

public class JobTitleRepository {

    private ArrayList<JobTitle> jobTitles = new ArrayList<>();

    public JobTitleRepository() {
        RandomFixtures<JobTitle> fixtures = new RandomFixtures<>();
        jobTitles = fixtures.generateTwelve(new JobTitleFactory());
    }

    public ArrayList<JobTitle> findAll() {
        //TODO: replace with real db conn

        return jobTitles;
    }

    public JobTitle findById(int id) {
        for(JobTitle jobTitle: jobTitles) {
            if(jobTitle.getId() == id) {
                return jobTitle;
            }
        }

        return null;
    }
}
