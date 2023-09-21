package nl.han.ica.oose.dea.resources;

import nl.han.ica.oose.dea.services.HardCodedItemService;
import nl.han.ica.oose.dea.services.ItemService;
import nl.han.ica.oose.dea.services.dto.ItemDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemResourceTest {
    private static final String TEXT_ITEMS = "bread, butter";
    private static final int ITEM_ID = 1;
    private static final int HTTP_OK = 200;
    private static final int HTTP_CREATED = 201;
    private ItemService mockedItemService;
    private ItemResource sut;
//    private HardCodedItemService itemService;


    @BeforeEach
    void setUp() throws Exception {
        this.sut = new ItemResource();

        // Gebruik Mockito om een instantie te maken
        this.mockedItemService = Mockito.mock(ItemService.class);

        // Gebruik de setter om de mockedItemService te zetten
        this.sut.setItemService(mockedItemService);
    }

    @Test
    void getItemsTest() {
        //Arrange
        ItemResource itemResource = new ItemResource();
        String goedAntwoord = "bread, butter";
        //Act
        String gegevenAntwoord = itemResource.getTextItems();
        //Assert
        Assertions.assertEquals(gegevenAntwoord, goedAntwoord);
    }

    @Test
    void testGetJsonItems() {
        var itemsToReturn = new ArrayList<ItemDTO>();
        when(mockedItemService.getAll()).thenReturn(itemsToReturn);

        // Act
        var response = sut.getJsonItems();

        // Assert
        assertEquals(HTTP_OK, response.getStatus());
        assertEquals(itemsToReturn, response.getEntity());
    }

    @Test
    void addItemsTest() {
        // Arrange

        // Act
        sut.getJsonItems();

        // Assert
        verify(mockedItemService).getAll();
    }

    @Test
    void getItemTest(){
        // Arrange
        var item = new ItemDTO(37, "Chocolate spread", new String[]{"Breakfast, Lunch"}, "Not to much");

        // Act
        sut.addItem(item);

        // Assert
        verify(mockedItemService).addItem(item);
    }
    @Test
    void DeleteItem(){
        //Arrange
        var item = new ItemDTO(37, "Chocolate spread", new String[]{"Breakfast, Lunch"}, "Not to much");

        var response = sut.addItem(item);
        //Assert
        assertEquals(HTTP_CREATED, response.getStatus());
    }
}
