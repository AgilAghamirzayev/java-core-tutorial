package udemy_master_class.section_4.one.data;

public class UserInterfaceConfig {
    private String titleColor;
    private String titleText;
    private short titleFontSize;
    private short footerFontSize;

    public String getTitleColor() {
        return titleColor;
    }

    public String getTitleText() {
        return titleText;
    }

    public short getTitleFontSize() {
        return titleFontSize;
    }

    public short getFooterFontSize() {
        return footerFontSize;
    }


    @Override
    public String toString() {
        return String.format(
                "UserInterfaceConfig [titleColor: %s, footerText: %s, titleFontSize: %s, footerFontSize: %s]",
                titleColor, titleText, titleFontSize, footerFontSize);
    }
}
