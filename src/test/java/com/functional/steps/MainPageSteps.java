package com.functional.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.functional.pages.MainPage;
import com.functional.pages.PageOpener;
import io.cucumber.java.en.Given;

public class MainPageSteps {

    private final PageOpener pageOpener;
    private final MainPage mainPage;

    public MainPageSteps(final PageOpener pageOpener, final MainPage mainPage) {
        this.pageOpener = pageOpener;
        this.mainPage = mainPage;
    }

    @Given("Customer is on main page")
    public void customerIsOnMainPage() {
        pageOpener.openMainPage();
        assertThat(mainPage.isPageOpen()).isTrue();
    }
}
