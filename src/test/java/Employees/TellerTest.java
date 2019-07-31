package Employees;

import Bank.Employees.BranchManager;
import Bank.Employees.Teller;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;




import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@PrepareForTest({UUID.class})
@RunWith(PowerMockRunner.class)
public class TellerTest {

    private Teller teller;

    @Before
    public void initialize(){
        teller = mock(Teller.class);
    }

    @Test
    public void testSetUUID ()
    {
        mock(UUID.class);
        when(UUID.randomUUID().toString()).thenReturn("your-UUID");
        assertEquals( teller.setUUID(),"your-UUID");

    }
}
