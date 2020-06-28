package com.demo.empdept;

import com.demo.empdept.entity.Dept;
import com.demo.empdept.service.IDeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DeptServiceTest {

    @MockBean
    private IDeptService deptService;

    @Test
    public void testAddDept() throws Exception{
        Mockito
                .when(deptService.createDept(new Dept(4, "manager")))
                .thenReturn(true);

    }

    @Test
    public void testDelDept() throws Exception{
        Mockito.when(deptService.deleteDept(1)).thenReturn(true);
    }

    @Test
    public void testUpdDept() throws Exception{

    }
}
