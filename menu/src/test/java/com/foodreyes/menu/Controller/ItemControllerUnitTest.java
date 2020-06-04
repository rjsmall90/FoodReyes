package com.foodreyes.menu.Controller;

import com.foodreyes.menu.Model.Item;
import com.foodreyes.menu.Service.ItemService;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



@RunWith(SpringRunner.class)
@WebMvcTest(value = ItemController.class, secure = false)
public class ItemControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService service;

    Item item;
    @Test
    public void getAddedItemByName() throws Exception {
        service.save(item);
        Mockito.when(service.find(Mockito.anyString())).thenReturn(item);

        String uri = "/item/findByName/";

        RequestBuilder rB =
        MockMvcRequestBuilders.get(uri, item.getName())
        .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(rB).andReturn();
        String expected = "{id: 1, name: Pudding_Pops, price: 1.50}";

        try {
            JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
        }
        catch(JSONException e) {
            System.out.println(e);
        }
    }

    @Test
    public void findAll() {
    }



    @Test
    public void deleteItem() {
    }
}