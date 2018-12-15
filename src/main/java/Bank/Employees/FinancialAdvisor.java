package Bank.Employees;

import static com.tyro.oss.randomdata.RandomInteger.randomPositiveInteger;

public class FinancialAdvisor {
    private BranchManager branchManager;


    public FinancialAdvisor(BranchManager branchManager){
        this.branchManager = branchManager;
    }

    private Boolean fateDecider(){
        if(randomPositiveInteger() % 2 == 0 )
            return true;
        else
            return false;
    }


}
