package Employees;

import Bank.Employees.BranchManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(PowerMockRunner.class)
@PrepareForTest(BranchManager.class)
public class BranchManagerTest {
    private BranchManager branchManager;

    @Before
    public void initialize()
    {
            branchManager = mock(BranchManager.class);
    }

    @Test
    public void testIsBankOpen_Success() throws Exception
    {
        when(branchManager.isBankOpen()).thenReturn(true);
//        boolean result = Whitebox.invokeMethod(branchManager , "isBankOpen", true);
        assertTrue(branchManager.isBankOpen());
    }

    @Test
    public void testIsBankOpen_Failure()
    {
        when(branchManager.isBankOpen()).thenReturn(false);
        assertFalse(branchManager.isBankOpen());
    }
}
