package com.foodreyes.menu.Controller;

import com.foodreyes.menu.Service.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.hibernate.SpringJtaPlatform;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private Mock mvc;

    @MockBean
    private ItemService service;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void whenAddItem() {


    }

    @Test
    public void findAll() {
    }

    @Test
    public void findAll1() {
    }

    @Test
    public void deleteItem() {
    }
}