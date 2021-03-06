package com.comunicator.frontend.ui.views;

import com.comunicator.frontend.MainLayout;
import com.comunicator.frontend.data.Message;
import com.comunicator.frontend.service.BackendService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "MessagesArchive", layout = MainLayout.class)
public class MessageArchiveView extends VerticalLayout {

    Grid<Message> grid = new Grid<>(Message.class);
    private BackendService service;

    public MessageArchiveView(BackendService service) {
        this.service = service;
        setSizeFull();

        configureGrid();

        add(grid);
        updateList();
    }

    private void configureGrid() {
        grid.setSizeFull();
        grid.setColumns("id",
                "sender",
                "receiver",
                "sendDate",
                "message",
                "wasRead");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void updateList() {
        grid.setItems(service.getMessages());
    }
}
