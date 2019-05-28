package com.unicen.exa.ingenieria;

public class MainPresenter {

    private MainView view;
    private MainModel model;

    public MainPresenter(MainView view, MainModel model){
        this.view = view;
        this.model = model;
    }

    public void show_gc_map() {
        view.show_graphic(model.get_gc_region());
    }
}
