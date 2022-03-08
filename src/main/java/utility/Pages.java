package utility;

public enum Pages {

    MAIN_ROUTE("https://emrit.io"),
    PARTNERS("/partners/"),
    ABOUT("/about/"),
    BLOG("/blog/"),
    FAQ("/faq/"),
    TERMS_CONDITIONS("/terms-and-conditions/"),
    PRIVACY_POLICY("/privacy-policy/"),

    SUPPORT_ROUTE("https://support.emrit.io"),
    SUPPORT("/support/home"),

    APP_ROUTE("https://app.emrit.io"),
    LOGIN("/login"),
    SIGNUP("/sign-up");

    private final String page;

    Pages(String page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return this.page;
    }

}
