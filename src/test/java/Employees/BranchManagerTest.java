package Employees;

import Bank.Employees.BranchManager;
import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



public class BranchManagerTest {
    private BranchManager branchManager;

    @Before
    public void initialize()
    {
        branchManager = mock(BranchManager.class);
        when(branchManager.isBankOpen()).thenReturn(true);
    }

    @Test
    public void testIsBankOpen_Success()
    {
        assertTrue(branchManager.isBankOpen());
    }

    @Test
    public void testIsBankOpen_Failure()
    {
        when(branchManager.isBankOpen()).thenReturn(false);
        assertFalse(branchManager.isBankOpen());
    }
}
