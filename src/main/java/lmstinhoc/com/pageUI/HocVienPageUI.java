package lmstinhoc.com.pageUI;

public class HocVienPageUI {
    // ================= ADD =================

    //OPEN POPUP
    public static final String BTN_THEMMOIHV = "XPATH=//span[normalize-space()='Thêm mới']/ancestor::button";
    public static final String ICON_SUAHOCVIEN = "XPATH=//tr[.//td[normalize-space()='%s']]//button[.//span[@aria-label='edit']]";
    public static final String ICON_XEMCHITIET = "XPATH=//tr[.//td[normalize-space()='%s']]//button[.//span[@aria-label='eye']]";
    public static final String ICON_DOIMATKHAU = "XPATH=//tr[.//td[normalize-space()='%s']]//button[.//span[@aria-label='unlock']]";
    public static final String ICON_XOAHOCVIEN = "XPATH=//tr[.//td[normalize-space()='%s']]//button[.//span[@aria-label='delete']]";
    public static final String ICON_EDIT_PASS="XPATH=//div[contains(@class, 'ant-typography')]//span[@aria-label='edit']";


    //POPUP TITLE
    public static final String TEXT_TITLE = "XPATH=//h4[text()='Danh sách môn học']";
    public static final String TITLE_POPUPTHEM = "XPATH=//div[text()='Thêm môn học']";
    public static final String  TITLE_POPUPEDIT = "XPATH=//div[contains(@class,'ant-modal-title') and .//span[normalize-space()='%s']]";
    public static final String  TITLE_POPUPSEE = "XPATH=//div[contains(@class,'ant-modal-title') and .//span[normalize-space()='%s']]";
    public static final String  TITLE_POPUPPASS = "XPATH=//div[@class='flex items-center gap-2']//span[normalize-space()='%s']";



    //INPUT
    public static final String INPUT_NAME_ADD = "XPATH=//input[@id='fullName']";
    public static final String INPUT_PASS_ADD = "XPATH=//input[@id='password']";

    public static final String INPUT_USER_ADD = "XPATH=//input[@id='userName']";

    public static final String INPUT_NAME_EDIT = "XPATH=//div[@role='dialog']//input[@id='fullName']";
    public static final String INPUT_NAME = "XPATH=//input[@id='fullName']";

    public static final String INPUT_PASS_EDIT = "XPATH=//p[.//text()[contains(.,'Mật khẩu mới')]]//textarea";



    public static final String INPUT_USERNAME_SEARCH = "XPATH=//input[@id='filterForm_userName']";
    public static final String INPUT_FULLNAME_SEARCH = "XPATH=//input[@id='filterForm_fullName']";
    public static final String INPUT_STATUS_SEARCH = "XPATH=//input[@id='filterForm_status']";


    public static final String SELECT_OPTION_BY_TEXT ="XPATH=//div[contains(@class,'ant-select-item-option')]";

    public static final String INPUT_EDIT_PASS = "XPATH=//p[.//text()[contains(.,'Mật khẩu mới')]]//textarea";

    //ERROR
    public static final String ERROR_MESSAGE = "XPATH=//div[text()='Chọn từ danh sách hoặc nhập vào']";

    //LIST
    public static final String SUBJECT_NAME_IN_LIST = "XPATH=//table//tr[contains(@class,'ant-table-row')]//td[normalize-space()='%s']";

    public static final String ASSIGNMENT_NAME_IN_LIST = "XPATH=//tr[contains(@class,'ant-table-row')][.//td[normalize-space()='%s'] and .//td[normalize-space()='%s'] and .//button[@role='switch' and @aria-checked='true']]";


    //BTN
//    public static final String BTN_DONGY = "XPATH=//button[.//span[text()='Đồng ý']]";
    public static final String BTN_TAOMOI = "XPATH=//div[contains(@class,'ant-modal-footer')]//button[.//span[text()='Tạo mới']]";
    public static final String BTN_CAPNHAT = "XPATH=//div[contains(@class,'ant-modal-footer')]//button[.//span[text()='Cập nhật']]";
    public static final String BTN_DONGY = "XPATH=//div[contains(@class,'ant-modal-footer')]//button[.//span[text()='Đồng ý']]";
    public static final String BTN_DONG = "XPATH=//div[contains(@class,'ant-modal-footer')]//button[.//span[text()='Đóng']]";


    public static final String BTN_CONFIRM_DELETE = "XPATH=//div[contains(@class,'ant-modal-confirm')]//button[.//span[normalize-space()='Đồng ý']]";

    //UPLOAD
    public static final String IMPORT_EXCEL_INPUT = "XPATH=//input[@type='file' and contains(@accept,'xls')]";

    //EXPORT
    public static final String EXPORT_EXCEL_BUTTON = "XPATH=//button[.//span[contains(text(),'Xuất')]]";

    public static final String TABLE_ROWS = "XPATH=//table//tbody/tr";
}
