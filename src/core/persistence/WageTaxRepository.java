package core.persistence;

import core.domain.WageTax;
import util.helper.RandomGenerator;

import java.util.ArrayList;

public class WageTaxRepository {
    public ArrayList<WageTax> findBasicTaxes() {
        //TODO: search in real db

        ArrayList<WageTax> fakeWageTaxData = new ArrayList<>();

        WageTax wage1 = new WageTax();
        wage1.setId(RandomGenerator.generateId());
        wage1.setName("CAS/CASS");
        wage1.setType(WageTax.TYPE_STATE_TAX);
        wage1.setTypeOfAmount(WageTax.AMOUNT_TYPE_PERCENTAGE);
        wage1.setPercentage(30);

        WageTax wage2 = new WageTax();
        wage2.setId(RandomGenerator.generateId());
        wage1.setName("Duty on profit");
        wage1.setType(WageTax.TYPE_STATE_TAX);
        wage1.setTypeOfAmount(WageTax.AMOUNT_TYPE_PERCENTAGE);
        wage1.setPercentage(16);

        fakeWageTaxData.add(wage1);
        fakeWageTaxData.add(wage2);

        return fakeWageTaxData;
    }
}
