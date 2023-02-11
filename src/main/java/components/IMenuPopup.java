package components;

import data.HeaderSubMenuPopupData;

public interface IMenuPopup {
    public void subMenuShouldBeVisible(HeaderSubMenuPopupData headerSubMenuPopupData);
    public void subMenuNotShouldBeVisible(HeaderSubMenuPopupData headerSubMenuPopupData);
}
