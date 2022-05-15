/* (C)2022 */
package com.functional.pages;

import com.config.StoryProxyComponent;

@StoryProxyComponent
public class PageOpener {

    private final MainPage mainPage;

    public PageOpener(final MainPage mainPage) {
        this.mainPage = mainPage;
    }

    public void openMainPage() {
        mainPage.open();
    }
}
