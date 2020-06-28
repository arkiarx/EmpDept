package com.demo.empdept;

import com.demo.empdept.entity.EmpDept;
import com.demo.empdept.model.QueryModel;
import com.demo.empdept.repository.IEmpDeptRepository;
import com.demo.empdept.service.IEmpDeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.management.Query;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmpDeptServiceTest {

    @MockBean
    private IEmpDeptService empDeptService;

    @MockBean
    private IEmpDeptRepository empDeptRepository;

    @Test
    public void testQueryPaged(){
        Mockito.when(empDeptService.listEmpDeptPage(null, 0)).thenReturn(null);
        Mockito.when(empDeptService.listEmpDeptPage(new QueryModel(), -1)).thenReturn(null);

        List<EmpDept> list = empDeptRepository.findAll();

        List<EmpDept> listTest2 = list
                .stream()
                .filter(e -> e.getEmpName().equals("test2"))
                .collect(Collectors.toList());

        Mockito
                .when(
                        empDeptService
                                .listEmpDeptPage(
                                        new QueryModel("test2", 0L, 0, ""),
                                        0
                                )
                )
                .thenReturn(listTest2);


    }
}
