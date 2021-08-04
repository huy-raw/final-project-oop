package utils;

public class Language {

    public Language() {
    }

    public static final String MSG_INPUT_TYPE = "Chọn loại tài liệu (1 = Sách|2 = Tạp Chí|3 = Báo): ";
    public static final String MSG_INPUT_ID = "Nhập ID (VD: AB200200, NA199199): ";
    public static final String MSG_INPUT_NAME = "Nhập tên tài liệu (VD: Doraemon, Ngu Van 11,...): ";
    public static final String MSG_INPUT_PUBLISHER = "Nhập tên nhà xuất bản (VD: Kim Dong, Academy Stars...): ";
    public static final String MSG_INPUT_PUBLISH_NUMBER = "Nhập số bản phát hành (VD: 5, 6,..): ";
    public static final String MSG_INPUT_AUTHOR = "Nhập tên tác giả (VD: J.K Rowling, Seth Godlin...): ";
    public static final String MSG_INPUT_PAGE_NUMBER = "Nhập số trang (VD: 355): ";
    public static final String MSG_INPUT_ISSUE_NUMBER = "Nhập số phát hành (VD: 23A-2020): ";
    public static final String MSG_INPUT_RELEASE_MONTH = "Nhập tháng phát hành (VD: 10/2020): ";
    public static final String MSG_INPUT_PUBLIC_DATE = "Nhập ngày phát hành (VD: 23/10/2020): ";

    public static final String ERROR_DUPLICATE_ID = "ID vừa nhập đã tồn tại. Vui lòng nhập lại!";
    public static final String ERROR_WRONG_INPUT_ID = "Nhập dinh dang dữ liệu (VD: AB200200, NA199199)!";
    public static final String ERROR_WRONG_INPUT_STR = "Nhập sai dữ liệu!";
    public static final String ERROR_WRONG_INPUT_INT = "Nhập sai kieu dữ liệu (Chi chap nhan so nguyen)!";

    public static final String MSG_ADD_SUCCESSFULLY = "Them dữ liệu thành công!";
    public static final String MSG_ADD_SUCCESSFULLY_INFO = "Dữ liệu bạn vừa nhập là: ";

    public static final String MSG_INPUT_DOC_ID_TO_DELETE = "Nhập mã tài liệu để xóa: ";
    public static final String ERROR_DOC_NOT_FOUND = "Không tìm thấy tài liệu, hãy kiểm tra ID bạn vừa nhập!";
    public static final String MSG_DELETE_DOC_SUCCESSFULLY = "Đã xóa tài liệu thành công!";

    public static final String MSG_UPDATE_DOC_SUCCESSFULLY = "Đã cập nhật tài liệu thành công!";
    public static final String MSG_UPDATE_DOC_FAILED = "Không thể cập nhật tài liệu!";
    public static final String MSG_INFO_BEFORE_UPDATE = "Đã tìm thấy tài liệu cần cập nhật, bạn có thể cập nhật các trường dữ liệu hoặc nhấn Enter để bỏ qua cập nhật trường dữ liệu bất kỳ!";
    public static final String MSG_INPUT_DOC_ID_TO_UPDATE = "Nhập ID cần cập nhật (VD: AB200200, NA199199): ";

    public static final String MSG_AUTH_LOADED = "Lấy dữ liệu tài khoản cũ thành công!";
    public static final String MSG_AUTH_NO_FILE = "Có vẻ như bạn chưa có tài khoản trong hệ thống.";
    public static final String MSG_AUTH_LOAD_FAILED = "Có vẻ như tập tin chứa dữ liệu đăng ký đã bị lỗi! Hãy đăng ký lại tài khoản admin của bạn.";
    public static final String MSG_DB_LOADED = "Lay dữ liệu từ cơ sở dữ liệu thành công!";
    public static final String MSG_DB_NO_FILE = "Có vẻ như bạn chưa có tài liệu nào trong hệ thống.";
    public static final String MSG_DB_LOAD_FAILED = "Có vẻ như tập tin chứa cơ sở dữ liệu đã bị lỗi! Hãy nhập lại dữ liệu của bạn.";

    public static final String MSG_ADDITIONAL_INFO = "Thông tin thêm: ";
    public static final String MSG_REG_PROCESS = "Bắt đầu đăng ký tài khoản mới.";
    public static final String MSG_LOGIN_PROCESS = "Bắt đầu đăng nhập tài khoản: ";
    public static final String MSG_AUTH_SAVE_FAILED = "Lỗi: không thể luu dữ liệu đăng ký.";
    public static final String INFO_LOGGED_GUEST = "Đang nhập dưới tài khoản khách, bạn không có quyền chỉnh sửa cơ sở dữ liệu!";

    public static final String INPUT_USERNAME = "Nhập tên đăng nhập: ";
    public static final String INPUT_PASSWORD = "Nhập mật khẩu: ";

    public static final String MSG_DB_SAVE_FAILED = "Lỗi: không thể lưu cơ sở dữ liệu.";
    public static final String MSG_FILE_SAVE_FAILED = "Lỗi: không thể lưu ra file.";

    public static final String WARN_WRONG_CREDENTIAL = "Sai tên đăng nhập hoặc mật khẩu!";
    public static final String INFO_LOGGED_IN = "Đăng nhập thành công!";
    public static final String NO_ACCOUNTS = "Không tìm thấy bất kì tài khoản nào trong dữ liệu. Hãy đăng kí tài khoản mới để sử dụng!";

    public static final String MSG_DATA_AFTER_SORT = "Dữ liệu sau khi được sắp xếp: ";

    public static final String MSG_INPUT_FILE_NAME = "Nhập tên tập tin mà bạn muốn xuất dữ liệu: ";
    public static final String MSG_DATA_EXPORTED = "Xuất tập tin thành công!";
    public static final String MSG_DATA_EXPORT_FAILED = "Xuất tập tin thất bại. Chi tiết: ";
    
    public static final String MSG_INPUT_SORT_FIELD = "Chọn kiểu dữ liệu mà bạn muốn sắp xếp (1 = ID tài liệU|2 = Nhà xuất bản|3 = Số phát hành): ";
    
    public static final String MSG_MUST_GREATER_THAN_ZERO = "Lỗi: số bạn nhập phải lớn hơn 0!";
}
