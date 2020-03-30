package core.datafixture;

import core.domain.Department;
import util.fixtures.Factory;
import util.helper.RandomGenerator;

import java.util.ArrayList;

public class DepartmentFactory implements Factory<Department> {
    private ArrayList<Department> fixtures = new ArrayList<>();

    public DepartmentFactory() {
        this.fixtures.add(new Department("Board"));
        this.fixtures.add(new Department("Sales"));
        this.fixtures.add(new Department("Marketing"));
        this.fixtures.add(new Department("Development"));
        this.fixtures.add(new Department("SysOps"));
        this.fixtures.add(new Department("Operations"));
        this.fixtures.add(new Department("HR"));
    }

    public Department createRandom() {
        return this.fixtures.get(RandomGenerator.generateRandomInt(this.fixtures.size()));
    }
}
