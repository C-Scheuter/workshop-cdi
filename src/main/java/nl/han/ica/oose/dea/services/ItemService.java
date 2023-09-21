package nl.han.ica.oose.dea.services;

import nl.han.ica.oose.dea.services.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    List<ItemDTO> getAll();
    ItemDTO getItem(int id);
    void addItem(ItemDTO itemDTO);
    void deleteItem(int id);
}
