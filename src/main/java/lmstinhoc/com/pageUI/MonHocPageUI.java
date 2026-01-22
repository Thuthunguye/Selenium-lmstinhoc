package lmstinhoc.com.pageUI;

public class MonHocPageUI {

    // ================= ADD =================

    //OPEN POPUP
    public static final String BTN_THEMMOIMONHOC = "XPATH=//span[normalize-space()='Thêm môn học']/ancestor::button";
    public static final String ICON_SUAMONHOC = "XPATH=//td[.//strong[text()='%s']]/following-sibling::td//button[.//span[@aria-label='edit']]";
    public static final String ICON_XOAMONHOC = "XPATH=//td[.//strong[text()='%s']]/following-sibling::td//button[.//span[@aria-label='delete']]";

    //POPUP TITLE
    public static final String TEXT_TITLE = "XPATH=//h4[text()='Danh sách môn học']";
    public static final String TITLE_POPUPTHEM = "XPATH=//div[text()='Thêm môn học']";
    public static final String TITLE_POPUPEDIT = "XPATH=//div[text()='Sửa môn học']";

    //INPUT
    public static final String INPUT_NAME_ADD = "XPATH=//div[text()='Thêm lớp học']/ancestor::div[contains(@class,'ant-modal-content')]//input[@id='modalForm_name']";
    public static final String INPUT_NAME_EDIT = "XPATH=//div[text()='Sửa môn học']/ancestor::div[contains(@class,'ant-modal-content')]//input[@id='modalForm_name']";



    //ERROR
    public static final String ERROR_MESSAGE = "XPATH=//div[text()='Chọn từ danh sách hoặc nhập vào']";

    //LIST
    public static final String SUBJECT_NAME_IN_LIST = "XPATH=//table//tr[contains(@class,'ant-table-row')]//strong[normalize-space()='%s']";

    //BTN
//    public static final String BTN_DONGY = "XPATH=//button[.//span[text()='Đồng ý']]";
    public static final String BTN_DONGY = "XPATH=//div[text()='Thêm môn học']/ancestor::div[contains(@class,'ant-modal-content')]//button[.//span[text()='Đồng ý']]";
    public static final String BTN_DONGY_EDIT = "XPATH=//div[text()='Sửa môn học']/ancestor::div[contains(@class,'ant-modal-content')]//button[.//span[text()='Đồng ý']]";
    public static final String BTN_HUY = "XPATH=//button[.//span[text()='Hủy']]";
    public static final String BTN_CONFIRM_DELETE = "XPATH=//div[contains(@class,'ant-popover')]//button[.//span[normalize-space()='Xác nhận']]";
    public static final String SUBJECT_ROW_BY_NAME = "XPATH=//table//strong[normalize-space()='%s']";

    // Toast success text: <span>Thành công!</span>
    public static final String TOAST_SUCCESS_TEXT = "XPATH=//div[contains(@class,'ant-message-custom-content') and contains(@class,'ant-message-success')]/span[not(@role='img')]";

    // Wrapper để đợi toast biến mất
    public static final String TOAST_NOTICE = "XPATH=//div[contains(@class,'ant-message-notice')]";

}
