package com.demo.empdept;

import com.demo.empdept.service.IEmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpServiceTest {

    @MockBean
    private IEmpService empService;

    @Test
    public void testAddEmp() throws Exception{

    }

    @Test
    public void testUpdEmp() throws Exception{

    }

    @Test
    public void testDelEmp() throws Exception{

    }
}
