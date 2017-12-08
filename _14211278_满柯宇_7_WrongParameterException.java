package homework7;

public class _14211278_Âú¿ÂÓî_7_WrongParameterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3573145057870731431L;
	String detail;
	String title;
	
	public _14211278_Âú¿ÂÓî_7_WrongParameterException(String title, String detail) {
        super(title + ":" + detail);
        this.detail = detail;
        this.title = title;
    }
	
	public void showExceptionPanel() {
		_14211278_Âú¿ÂÓî_7_DialogUIController.setMessageAndShow(title, detail);
	}
}
