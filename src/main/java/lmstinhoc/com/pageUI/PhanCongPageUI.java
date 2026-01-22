package lmstinhoc.com.pageUI;

public class PhanCongPageUI {
    // ================= ADD =================

    //OPEN POPUP
    public static final String BTN_THEMPHANCONG = "XPATH=//span[normalize-space()='Phân công mới']/ancestor::button";
    public static final String ICON_SUAPHANCONG = "XPATH=//tr[.//strong[normalize-space()='%s']]//button[.//span[@aria-label='edit']]";
    public static final String ICON_XOAPHANCONG = "XPATH=//tr[.//strong[normalize-space()='%s']]//button[.//span[@aria-label='delete']]";

    //POPUP TITLE
    public static final String TEXT_TITLE = "XPATH=//h4[text()='Phân công giảng dạy']";
    public static final String TITLE_POPUPTHEM = "XPATH=//div[text()='Tạo phân công mới']";
    public static final String TITLE_POPUPEDIT = "XPATH=//div[text()='Sửa phân công']";

    //INPUT
    public static final String CLASS_SEARCH_INPUT = "XPATH=//input[@id='modalForm_class']";
    public static final String SUBJECT_SEARCH_INPUT = "XPATH=//input[@id='modalForm_subject']";
    public static final String COURSE_SEARCH_INPUT = "XPATH=//input[@id='modalForm_course']";
    public static final String TEACHER_SEARCH_INPUT = "XPATH=//input[@id='modalForm_teacher']";
    public static final String ASSISTANT_SEARCH_INPUT = "XPATH=//input[@id='modalForm_assistant']";
    public static final String FOLLOWERS_SEARCH_INPUT = "XPATH=//input[@id='modalForm_followers']";
    public static final String DESCRIPTION_SEARCH_INPUT = "XPATH=//textarea[@id='modalForm_description']";



//    public static final String INPUT_CLASS_EDIT = "XPATH=//label[text()='Lớp']/following-sibling::div//span[contains(@class,'ant-select-selection-item')]";



    public static final String SELECT_OPTION_BY_TEXT ="XPATH=//div[contains(@class,'ant-select-item-option')]";

    public static final String SELECT_BY_TEXT ="XPATH=//input[@id='modalForm_class']/ancestor::div[contains(@class,'ant-select')]";


    //ERROR
    public static final String ERROR_MESSAGE = "XPATH=//div[text()='Chọn từ danh sách hoặc nhập vào']";

    //LIST
    public static final String ASSIGNMENT_NAME_IN_LIST = "XPATH=//table//tr[contains(@class,'ant-table-row')]//span[contains(normalize-space(),'%s')and contains(normalize-space(),'Giáo viên') ]";
    public static final String ASSIGNMENT_NAME_EDIT_LIST = "XPATH=//tr[contains(@class,'ant-table-row')][.//a[.//strong[normalize-space()='%s']]]//a[normalize-space()='%s']";
    public static final String TEACHER_TAG_IN_LIST = "XPATH=//tr[contains(@class,'ant-table-row')]//span[contains(@class,'ant-tag') and normalize-space()='Giáo viên: %s']";



    //BTN
    public static final String BTN_DONGY = "XPATH=//div[contains(@class,'ant-modal-footer')]//button[.//span[text()='Đồng ý']]";
    public static final String BTN_DONGY_EDIT = "XPATH=//div[contains(@class,'ant-modal-footer')]//button[.//span[normalize-space()='Đồng ý']]";
    public static final String BTN_HUY = "XPATH=//button[.//span[text()='Hủy']]";
    public static final String BTN_CONFIRM_DELETE = "XPATH=//div[contains(@class,'ant-popconfirm')]//button[.//span[normalize-space()='Xác nhận']]";
    public static final String SUBJECT_ROW_BY_NAME = "XPATH=//table//strong[normalize-space()='%s']";

    public static final String BTN_CLEAR_SELECT = "XPATH=//span[contains(@class,'ant-select-clear')]";


    //SEARCH
    public static final String TEACHER_SEARCH = "XPATH=//input[@id='filterForm_teacher']";
    public static final String CLASS_SEARCH = "XPATH=//input[@id='filterForm_class']";
    public static final String SUBJECT_SEARCH = "XPATH=//input[@id='filterForm_subject']";
    public static final String ROLE_SEARCH = "XPATH=//input[@id='filterForm_role']";

    // nút X (clear)
    public static final String CLASS_CLEAR_BTN =
            "XPATH=//div[contains(@class,'ant-modal-content')]//label[contains(normalize-space(),'Lớp')]" +
                    "/following-sibling::div//span[contains(@class,'ant-select-clear')]";


    // dropdown click
    public static final String CLASS_DROPDOWN =
            "XPATH=//div[contains(@class,'ant-modal-content')]//div[contains(@class,'ant-select-selector')]";


    // value đang hiển thị
    public static final String CLASS_SELECTED_TEXT =
            "XPATH=//div[contains(@class,'ant-modal-content')]//label[contains(normalize-space(),'Lớp')]" +
                    "/following-sibling::div//span[contains(@class,'ant-select-selection-item')]";



}
