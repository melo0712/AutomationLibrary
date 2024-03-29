package com.libraryAutomation.pages;

import com.libraryAutomation.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BooksPage extends PageBase {

    @FindBy(id="book_categories")
    public WebElement selectBookCategories;

    @FindBy(xpath = "//thead/tr/th")
    public List<WebElement> header;

    @FindBy(xpath = "//section[@id='dashboard']")
    public WebElement sectionDashboard;//used to verify that librarian land to dashboard


    @FindBy(xpath = "//section[@id='books']")
    public WebElement sectionBooks;//used to verify that student land on books page

    @FindBy(name = "tbl_books_length")
    public WebElement selectRecords;

    @FindBy(linkText = "Books")
    public WebElement booksPageLink;
    @FindBy(xpath = "//table//tr//td[5]")
    public List<WebElement> listOfSelectedCategories;

    @FindBy(xpath = "//a[contains(@class,'btn btn-lg btn')]")
    private WebElement buttonAddButton;

    @FindBy(xpath = "//td[3]")
    private List<WebElement> allBookNames;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//tbody/tr/td/a")
   private WebElement firstEditButton;

    public WebElement getFirstEditButton() {
         BrowserUtils.fluentWait(firstEditButton,20);
         return firstEditButton;
    }

    public WebElement getButtonSearch() {
        return BrowserUtils.waitForClickability(buttonSearch,20);
    }

    public List<WebElement> getAllBookNames() {
        return allBookNames;
    }

    public WebElement getButtonAddButton() {
        return BrowserUtils.waitForVisibility(buttonAddButton,20);
    }

    public List<String> getAllBookCategories() {
        List<String> categoriesText = new ArrayList<>();
        Select select = new Select(selectBookCategories);
        select.getOptions().forEach(p -> categoriesText.add(p.getText()));
        BrowserUtils.sleep(3);
        return categoriesText;
    }

    public void selectCategory(String string) {
        Select select = new Select(selectBookCategories);
        select.selectByVisibleText(string);
        BrowserUtils.sleep(3);

    }

    public  List<String> convertWebElementToString_andGetText(List<WebElement> elements) {
        List<String> textsOfWebElement = new LinkedList<>();

        for (WebElement element : elements) {
            textsOfWebElement.add(BrowserUtils.waitForStaleElement(element).getText());
        }
        return textsOfWebElement;
    }
}
