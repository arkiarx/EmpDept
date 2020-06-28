package com.demo.empdept;

import com.demo.empdept.entity.Dept;
import com.demo.empdept.exceptions.DeptExistedException;
import com.demo.empdept.exceptions.DeptNotFoundException;
import com.demo.empdept.service.IDeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
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
        //test for create new dept
        Mockito
                .when(deptService.createDept(new Dept(4, "manager")))
                .thenReturn(true);

        //
        Mockito
                .when(deptService.createDept(new Dept(1, "test dept")))
                .thenThrow(DeptExistedException.class);
    }

    @Test
    public void testDelDept() throws Exception{
        Mockito.when(deptService.deleteDept(1)).thenReturn(true);
        Mockito.when(deptService.deleteDept(-1)).thenReturn(false);
        Mockito.when(deptService.deleteDept(100)).thenThrow(DeptNotFoundException.class);
    }

    @Test
    public void testUpdDept() throws Exception{
        Mockito
                .when(deptService.modifyDept(null))
                .thenReturn(false);
        Mockito
                .when(deptService.modifyDept(new Dept(1, "manager dept")))
                .thenReturn(true);
        Mockito
                .when(deptService.modifyDept(new Dept(100, "manager dept")))
                .thenThrow(DeptNotFoundException.class);
    }
}
