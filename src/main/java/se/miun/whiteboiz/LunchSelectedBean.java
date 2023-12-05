package se.miun.whiteboiz;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named @RequestScoped
public class LunchSelectedBean {

    @Inject
    LunchService ls;


}
