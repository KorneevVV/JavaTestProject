package ru.aplana.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static org.junit.Assert.assertTrue;

@DefaultUrl("http://vk.com")
public class HomePage extends PageObject {
    
    @FindBy(xpath = "//input[@id='index_email']")
    private WebElementFacade login;
    
    @FindBy(xpath = "//input[@id='index_pass']")
    private WebElementFacade password;
    
    @FindBy(xpath = "//button[@id='index_login_button']")
    private WebElementFacade signInButton;
    
    @FindBy(xpath = "//span[contains(.,'Моя Страница')]")
    private WebElementFacade linkMyPage;
    
    @FindBy(xpath = "//input[@id='ts_input']")
    private WebElementFacade searchBar;
    
    @FindBy(xpath = "//*[@id='ts_search_link']/span")
    private WebElementFacade showResults;
    
    @FindBy(xpath = "//a[@class='ui_rmenu_item _ui_item_people search_menu_people']")
    private WebElementFacade people;
    
    @FindBy(xpath = "//div[@id='cCountry']/descendant::input[@class='selector_input']")
    private WebElementFacade listCountry;
    
    @FindBy(xpath = "//div[@id='cCity']/descendant::input[@class='selector_input']")
    private WebElementFacade listCity;
    
    @FindBy(xpath = "//div[@id='results']/div[2]")
    //указывает на второй элемент, т.к. при любом результате поиска (найден кто-то, или никого не нашел) первый элемент всегда присутствует
    private WebElementFacade listOfSerchResults;
    
    @FindBy(xpath = "//div[@class='top_profile_name']")
    private WebElementFacade linkProfile;
    
    @FindBy(xpath = "//a[@id='top_edit_link']")
    private WebElementFacade linkEdit;
    
    @FindBy(xpath = "//div[@class='page_block_header' and contains(.,'Основное')]")
    private WebElementFacade linkHeader;
    
    @FindBy(xpath = "//div[@class='pedit_bday fl_l']/div/table/tbody/tr/td[@class='selector_dropdown']")
    private WebElementFacade linkDropdownDay;
    
    @FindBy(xpath = "//div[@class='pedit_bmonth fl_l']/div/table/tbody/tr/td[@class='selector_dropdown']")
    private WebElementFacade linkDropdownMonth;
    
    @FindBy(xpath = "//div[@class='pedit_byear fl_l']/div/table/tbody/tr/td[@class='selector_dropdown']")
    private WebElementFacade linkDropdownYears;
    
    @FindBy(xpath = "//button[@class='flat_button button_big_width']")
    private WebElementFacade linkSave;
    
    @FindBy(xpath = "//div/h2[@class='page_name']")
    private WebElementFacade linkPageName;
    
    private Calendar calendar = getCalendar();
    
    private int yearMod;
    
    private Calendar getCalendar() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), new Locale("ru", "RU"));
        calendar.setTime(new Date());
        return calendar;
    }
    
    public void enterLogin(String keyword) {
        login.type(keyword);
    }
    
    public void enterPass(String keyword) {
        password.type(keyword);
    }
    
    public void clickSignInButton() {
        signInButton.click();
    }
    
    public boolean takeLinkMyPage() {
        return linkMyPage.isEnabled();
    }
    
    public void searchOnBar(String name) {
        searchBar.click();
        searchBar.sendKeys(name);
        waitABit(1000);//костыль, пробовал решить проблему (ERROR net.serenitybdd.core.Serenity - stale element reference: element is not attached to the page document ) через:
        // 1) showResults.isVisible() (работает в связке из 3-5 вызовов метода, по сути множественные try - catch) - решение хуже,
        // т.к. wait позволяет установить время в мс, в то время как время выполнение метода isVisible() зависит от производительности компьютера
        // 2) webdriver.timeouts.implicitlywait = 10000 - не работает в данном случае
        // 3) wait.until(ExpectedConditions.visibilityOf(showResults)) - так же не помог
        // 4) public PageObject(final WebDriver driver, final int ajaxTimeout) задание времени ожидания в конструкторе так же не увенчалось успехом.
        showResults.click();
        people.click();
    }
    
    public void selectListCountry(String country) {
        listCountry.click();
        String xPath = "//li[contains(.,'" + country + "')]";
        WebElementFacade selectedCountry = find(By.xpath(xPath));
        selectedCountry.isVisible();
        selectedCountry.click();
    }
    
    public void selectListCity(String city) {
        listCity.click();
        String xPath = "//li[contains(.,'" + city + "')]";
        WebElementFacade selectedCity = find(By.xpath(xPath));
        selectedCity.isVisible();
        selectedCity.click();
    }
    
    public void checkResultSearch() {
        assertTrue(listOfSerchResults.isVisible());
    }
    
    public void clickSetting() {
        linkProfile.click();
        linkEdit.isVisible();
        linkEdit.click();
        assertTrue(linkHeader.isVisible());
    }
    
    public void changeDate(Integer yearsInt) {
        yearMod = getYearMod(yearsInt);
        int month = getMonth();
        int day = getDay();
        
        linkDropdownDay.isVisible();
        linkDropdownDay.click();
        String xPathDay = "//div[@class='pedit_bday fl_l']/div/div/div/ul/li[" + day + "]";
        WebElementFacade selectedDay = find(By.xpath(xPathDay));
        selectedDay.click();
        
        linkDropdownMonth.click();
        String xPathMonth = "//div[@class='pedit_bmonth fl_l']/div/div/div/ul/li[" + month + "]";
        WebElementFacade selectedMonth = find(By.xpath(xPathMonth));
        selectedMonth.click();
        
        linkDropdownYears.click();
        String xPathYears = "//div[@class='pedit_byear fl_l']/div/div/div/ul/li[contains(.," + yearMod + ")]";
        WebElementFacade selectedYears = find(By.xpath(xPathYears));
        selectedYears.click();
        linkSave.click();
    }
    
    private int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
    
    private int getMonth() {
        return calendar.get(Calendar.MONTH) + 1; // январь - 0, т.о. май - 4;
    }
    
    private int getYear() {
        return calendar.get(Calendar.YEAR);
    }
    
    private int getYearMod(int years) {
        return calendar.get(Calendar.YEAR) - years;
    }
    
    public void checkMsg(String msg) {
        String xPath = "//b[contains(.,'" + msg + "')]";
        WebElementFacade linkMsg = find(By.xpath(xPath));
        assertTrue(linkMsg.isVisible());
    }
    
    public void clickMyPage() {
        linkMyPage.click();
        assertTrue(linkPageName.isVisible());
    }
    
    public void checkChangeBDay() {
        Month month = Month.of(getMonth());
        String dayAndMonth = getDay() + " " + month.getDisplayName(TextStyle.FULL, new Locale("ru", "RU"));
        String xPathDM = "//a[contains(.,'" + dayAndMonth + "')]";
        WebElementFacade linkDayMonth = find(By.xpath(xPathDM));
        assertTrue(linkDayMonth.isVisible());
        String xPathY = "//a[contains(.,'" + yearMod + "')]";
        WebElementFacade linkYear = find(By.xpath(xPathY));
        assertTrue(linkYear.isVisible());
    }
}
