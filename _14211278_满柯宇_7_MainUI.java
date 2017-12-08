package homework7;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.*;
import javafx.util.Callback;

public class _14211278_Âú¿ÂÓî_7_MainUI extends Application implements Initializable, _14211278_Âú¿ÂÓî_7_Observer{
	public static void main(String[] args) {
		Application.launch(_14211278_Âú¿ÂÓî_7_MainUI.class,args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("_14211278_Âú¿ÂÓî_7_cart.fxml"));
        Scene scene = new Scene(root);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Í¼ÊéÏúÊÛÏµÍ³");
        primaryStage.setResizable(false);
        primaryStage.show();
        
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		initComboBox();
		initTableView();
		initCart();
		initList();
		_14211278_Âú¿ÂÓî_7_Controller.getInstance().getSale().registerObserver(this);
	}

	@FXML
	ComboBox<String> simpleDiscountType;
	@FXML
	ComboBox<String> combinedDiscountType;
	@FXML
	ComboBox<String> manageBookType;
	@FXML
	ComboBox<String> simpleDiscountBookType;
	@FXML
	ComboBox<String> combinedDIscountBookType;
	
	private void initComboBox() {
		simpleDiscountType.getItems().addAll(_14211278_Âú¿ÂÓî_7_IPricingStrategy.SIMPLE_DISCOUNT_NAME);
		combinedDiscountType.getItems().addAll(_14211278_Âú¿ÂÓî_7_IPricingStrategy.COMPOSITE_DISCOUNT_NAME);
		simpleDiscountBookType.getItems().addAll(_14211278_Âú¿ÂÓî_7_BookType.NAME);
		combinedDIscountBookType.getItems().addAll(_14211278_Âú¿ÂÓî_7_BookType.NAME);
		manageBookType.getItems().addAll(_14211278_Âú¿ÂÓî_7_BookType.NAME);
	}
	
	@FXML
	TableView<_14211278_Âú¿ÂÓî_7_BookSpecification> shelfTable;
	@FXML
	TableColumn<_14211278_Âú¿ÂÓî_7_BookSpecification, String> shelfISBNColumn;
	@FXML
	TableColumn<_14211278_Âú¿ÂÓî_7_BookSpecification, String> shelfNameColumn;
	@FXML
	TableColumn<_14211278_Âú¿ÂÓî_7_BookSpecification, Double> shelfPriceColumn;
	
	@FXML
	TableView<_14211278_Âú¿ÂÓî_7_BookSpecification> manageShelfTable;
	@FXML
	TableColumn<_14211278_Âú¿ÂÓî_7_BookSpecification, String> manageISBNColumn;
	@FXML
	TableColumn<_14211278_Âú¿ÂÓî_7_BookSpecification, String> manageNameColumn;
	@FXML
	TableColumn<_14211278_Âú¿ÂÓî_7_BookSpecification, Double> managePriceColumn;
	@FXML
	TableColumn<_14211278_Âú¿ÂÓî_7_BookSpecification, String> manageTypeColumn;
	
	@FXML
	TableView<_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy> discountTable;
	@FXML
	TableColumn<_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy,Integer> discountTableColumnId;
	@FXML
	TableColumn<_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy,String> discountTableColumnBookType;
	@FXML
	TableColumn<_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy,String> discountTableColumnName;
	@FXML
	TableColumn<_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy,String> discountTableColumnType;
	@FXML
	TableColumn<_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy,String> discountTableColumnValue;
	
	@FXML
	TableView<_14211278_Âú¿ÂÓî_7_SaleLineItem> cartTable;
	@FXML
	TableColumn<_14211278_Âú¿ÂÓî_7_SaleLineItem,String> cartTableNameColumn;
	@FXML
	TableColumn<_14211278_Âú¿ÂÓî_7_SaleLineItem,Integer> cartTableQuantityColumn;
	
	
	private void initTableView() {
		shelfISBNColumn.setCellValueFactory(new PropertyValueFactory<_14211278_Âú¿ÂÓî_7_BookSpecification, String>("ISBN"));
		manageISBNColumn.setCellValueFactory(new PropertyValueFactory<_14211278_Âú¿ÂÓî_7_BookSpecification, String>("ISBN"));
		shelfNameColumn.setCellValueFactory(new PropertyValueFactory<_14211278_Âú¿ÂÓî_7_BookSpecification, String>("title"));
		manageNameColumn.setCellValueFactory(new PropertyValueFactory<_14211278_Âú¿ÂÓî_7_BookSpecification, String>("title"));
		shelfPriceColumn.setCellValueFactory(new PropertyValueFactory<_14211278_Âú¿ÂÓî_7_BookSpecification, Double>("price"));
		managePriceColumn.setCellValueFactory(new PropertyValueFactory<_14211278_Âú¿ÂÓî_7_BookSpecification, Double>("price"));
		manageTypeColumn.setCellValueFactory(new PropertyValueFactory<_14211278_Âú¿ÂÓî_7_BookSpecification, String>("stringType"));
		
		shelfTable.setItems(_14211278_Âú¿ÂÓî_7_Controller.getInstance().getBookObserver());
		manageShelfTable.setItems(_14211278_Âú¿ÂÓî_7_Controller.getInstance().getBookObserver());
		
		
		discountTableColumnId.setCellValueFactory(new PropertyValueFactory<_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy, Integer>("id"));
	//	discountTableColumnBookType.setCellValueFactory(new PropertyValueFactory<AbstractPricingStrategy, String>("bookType"));
		//ÕâÃ´×öÊÇÎªÁË½âñî£¬²»ÄÜÈÃÍ¼ÊéÀàÖĞ¹ÜÀíÓÅ»İĞÅÏ¢
		discountTableColumnBookType.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy,String>,ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(
					CellDataFeatures<_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy, String> param) {
				// TODO Auto-generated method stub
				ArrayList<Integer> temp = _14211278_Âú¿ÂÓî_7_PricingStrategyFactory.getInstance().getReversePricingStrategy(param.getValue());
				StringBuilder sb = new StringBuilder();
				for (int i : temp)
					sb.append(_14211278_Âú¿ÂÓî_7_BookType.NAME.get(i));
				return new SimpleStringProperty(sb.toString());
			}
			
		});
		discountTableColumnName.setCellValueFactory(new PropertyValueFactory<_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy, String>("discountName"));
		discountTableColumnType.setCellValueFactory(new PropertyValueFactory<_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy, String>("stringDiscountType"));
		discountTableColumnValue.setCellValueFactory(new PropertyValueFactory<_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy, String>("discountDescription"));
		
		discountTable.setItems(_14211278_Âú¿ÂÓî_7_Controller.getInstance().getStrategyObserver());
		
		
		cartTableNameColumn.setCellValueFactory(new PropertyValueFactory<_14211278_Âú¿ÂÓî_7_SaleLineItem, String>("titile"));
		cartTableQuantityColumn.setCellValueFactory(new PropertyValueFactory<_14211278_Âú¿ÂÓî_7_SaleLineItem, Integer>("copies"));
		
	}
	
	
	@FXML
	TextField shelfISBN;
	@FXML
	TextField shelfCount;
	private void initCart() {
		shelfTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<_14211278_Âú¿ÂÓî_7_BookSpecification>() {

			@Override
			public void changed(
					ObservableValue<? extends _14211278_Âú¿ÂÓî_7_BookSpecification> observable,
					_14211278_Âú¿ÂÓî_7_BookSpecification oldValue, _14211278_Âú¿ÂÓî_7_BookSpecification newValue) {
				// TODO Auto-generated method stub
				shelfISBN.setText(newValue.getISBN());
				shelfCount.setText("1");
			}
			
		});
	}
	
	
	@FXML
	ListView<_14211278_Âú¿ÂÓî_7_AbstractPricingStrategy> combinedDiscountList;
	private void initList() {
		combinedDiscountList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		combinedDiscountList.setItems(_14211278_Âú¿ÂÓî_7_Controller.getInstance().getStrategyObserver());
	}
	
	
	@FXML
	TextField manageISBN;
	@FXML
	TextField manageBookName;
	@FXML
	TextField managePrice;
	@FXML
	public void manageButtonOnClick(ActionEvent event) {
		try {
			String isbn = manageISBN.getText();
			if (isbn.isEmpty())
				throw new _14211278_Âú¿ÂÓî_7_WrongParameterException("ISBNºÅ´íÎó","²»ÄÜÎª¿Õ");
			String bookName = manageBookName.getText();
			if (bookName.isEmpty())
				throw new _14211278_Âú¿ÂÓî_7_WrongParameterException("ÊéÃû´íÎó","²»ÄÜÎª¿Õ");
			double price = Double.parseDouble(managePrice.getText());
			int bookType = _14211278_Âú¿ÂÓî_7_BookType.NAME.indexOf(manageBookType.getValue());
			if (bookType == -1)
				throw new _14211278_Âú¿ÂÓî_7_WrongParameterException("Í¼ÊéÀàĞÍ´íÎó","Î´Ñ¡ÔñÀàĞÍ");
			_14211278_Âú¿ÂÓî_7_BookSpecification bs = new _14211278_Âú¿ÂÓî_7_BookSpecification(isbn, price, bookName, bookType);
			if (_14211278_Âú¿ÂÓî_7_Controller.getInstance().addBook(bs) != null)
				throw new _14211278_Âú¿ÂÓî_7_WrongParameterException("¾¯¸æ","´æÔÚISBNÏàÍ¬µÄÍ¼Êé£¬ÒÑ¸üĞÂ");
		} catch (Exception ex) {
			if (ex instanceof _14211278_Âú¿ÂÓî_7_WrongParameterException)
				((_14211278_Âú¿ÂÓî_7_WrongParameterException) ex).showExceptionPanel();
			else new _14211278_Âú¿ÂÓî_7_WrongParameterException("¼Û¸ñ´íÎó","²»ÊÇÊı×Ö").showExceptionPanel();
		}
	}
	
	
	@FXML
	public void discountDeletionOnAction(ActionEvent event) {
		_14211278_Âú¿ÂÓî_7_Controller.getInstance().deleteStrategy(discountTable.getSelectionModel().getSelectedItem());
	}
	
	
	@FXML
	TextField simpleDiscountName;
	@FXML
	TextField simpleDiscountValue;
	@FXML
	public void simpleDiscountButtonOnClick(ActionEvent event) {
		try {
			int bookType = _14211278_Âú¿ÂÓî_7_BookType.NAME.indexOf(simpleDiscountBookType.getValue());
			if (bookType == -1)
				throw new _14211278_Âú¿ÂÓî_7_WrongParameterException("Í¼ÊéÀàĞÍ´íÎó","Î´Ñ¡ÔñÀàĞÍ");
			int discountType = _14211278_Âú¿ÂÓî_7_IPricingStrategy.SIMPLE_DISCOUNT_NAME.indexOf(simpleDiscountType.getValue());
			if (discountType == -1)
				throw new _14211278_Âú¿ÂÓî_7_WrongParameterException("ÓÅ»İÀàĞÍ´íÎó","Î´Ñ¡ÔñÀàĞÍ");
			String discountName = simpleDiscountName.getText();
			if (discountName.isEmpty())
				throw new _14211278_Âú¿ÂÓî_7_WrongParameterException("ÓÅ»İÃû³Æ´íÎó","ÎŞÃû³Æ");
			Object result;
			if (discountType == _14211278_Âú¿ÂÓî_7_IPricingStrategy.PERCENTAGE) {
				int discountValue = Integer.parseInt(simpleDiscountValue.getText());
				if ((discountValue > 100 || discountValue < 0))
					throw new _14211278_Âú¿ÂÓî_7_WrongParameterException("ÕÛ¿Û·ù¶È´íÎó","°Ù·ÖÊıÓ¦µ±½éÓÚ0-100Ö®¼ä");
				result = _14211278_Âú¿ÂÓî_7_Controller.getInstance().addSimpleStrategy(discountType, bookType, discountName, String.valueOf(discountValue));
			}
			else if (discountType == _14211278_Âú¿ÂÓî_7_IPricingStrategy.FLAT_RATE) {
				double discountValue = Double.parseDouble(simpleDiscountValue.getText());
				if (discountValue < 0)
					throw new _14211278_Âú¿ÂÓî_7_WrongParameterException("ÕÛ¿Û·ù¶È´íÎó","ÓÅ»İ½ğ¶î²»ÄÜĞ¡ÓÚ0");
				result = _14211278_Âú¿ÂÓî_7_Controller.getInstance().addSimpleStrategy(discountType, bookType, discountName, String.valueOf(discountValue));
			}
			else result = _14211278_Âú¿ÂÓî_7_Controller.getInstance().addSimpleStrategy(discountType, bookType, discountName, "");
			if (result != null)
				throw new _14211278_Âú¿ÂÓî_7_WrongParameterException("¾¯¸æ","¸ÃÀàÊéÒÑÓĞÓÅ»İĞÅÏ¢£¬ÏÖÒÑ¸üĞÂ");
		} catch (Exception ex) {
			if (ex instanceof _14211278_Âú¿ÂÓî_7_WrongParameterException)
				((_14211278_Âú¿ÂÓî_7_WrongParameterException) ex).showExceptionPanel();
			else new _14211278_Âú¿ÂÓî_7_WrongParameterException("ÕÛ¿Û·ù¶È´íÎó","Êı×Ö¸ñÊ½´íÎó£¬Çë¼ì²éµ±Ç°ÓÅ»İÊÇ·ñÔÊĞíĞ¡Êı").showExceptionPanel();
		}
	}
	
	
	@FXML
	TextField combinedDiscountName;
	@FXML
	public void combinedDiscountButtonOnClick(ActionEvent event) {
		try {
			ObservableList<Integer> selected = combinedDiscountList.getSelectionModel().getSelectedIndices();
			if (selected.size() == 0)
				throw new _14211278_Âú¿ÂÓî_7_WrongParameterException("ÓÅ»İĞÅÏ¢Ñ¡Ôñ´íÎó","ÖÁÉÙÑ¡ÔñÒ»¸öÓÅ»İĞÅÏ¢");
			ArrayList<_14211278_Âú¿ÂÓî_7_IPricingStrategy> temp = new ArrayList<_14211278_Âú¿ÂÓî_7_IPricingStrategy>();
			for (int i : selected)
				temp.add(_14211278_Âú¿ÂÓî_7_Controller.getInstance().getStrategyObserver().get(i));
			int bookType = _14211278_Âú¿ÂÓî_7_BookType.NAME.indexOf(combinedDIscountBookType.getValue());
			if (bookType == -1)
				throw new _14211278_Âú¿ÂÓî_7_WrongParameterException("Í¼ÊéÀàĞÍ´íÎó","Î´Ñ¡ÔñÀàĞÍ");
			int discountType = _14211278_Âú¿ÂÓî_7_IPricingStrategy.COMPOSITE_DISCOUNT_NAME.indexOf(combinedDiscountType.getValue()) + _14211278_Âú¿ÂÓî_7_IPricingStrategy.SIMPLE_DISCOUNT_NAME.size();
			if (discountType == -1)
				throw new _14211278_Âú¿ÂÓî_7_WrongParameterException("ÓÅ»İÀàĞÍ´íÎó","Î´Ñ¡ÔñÀàĞÍ");
			String discountName = combinedDiscountName.getText();
			if (discountName.isEmpty())
				throw new _14211278_Âú¿ÂÓî_7_WrongParameterException("ÓÅ»İÃû³Æ´íÎó","ÎŞÃû³Æ");
			if (_14211278_Âú¿ÂÓî_7_Controller.getInstance().addCompositeStrategy(discountType, bookType, discountName, temp) != null)
				throw new _14211278_Âú¿ÂÓî_7_WrongParameterException("¾¯¸æ","¸ÃÀàÊéÒÑÓĞÓÅ»İĞÅÏ¢£¬ÏÖÒÑ¸üĞÂ");
			
		} catch (Exception ex) {
			((_14211278_Âú¿ÂÓî_7_WrongParameterException) ex).showExceptionPanel();
		}
	}
	

	@FXML
	Label cartText;
	@Override
	public void update(_14211278_Âú¿ÂÓî_7_Sale s) {
		// TODO Auto-generated method stub
		cartTable.setItems(s.getObserver());
		cartText.setText("×Ü¼Û:" + s.getTotal() + "Ôª");
	}
	
	
	@FXML
	public void shelfButtonOnClick(ActionEvent event) {
		try {
			String isbn = shelfISBN.getText();
			if (isbn.isEmpty())
				throw new _14211278_Âú¿ÂÓî_7_WrongParameterException("ISBNºÅ´íÎó","²»ÄÜÎª¿Õ");
			_14211278_Âú¿ÂÓî_7_BookSpecification temp = _14211278_Âú¿ÂÓî_7_Controller.getInstance().getBookSpecification(isbn);
			if (temp == null)
				throw new _14211278_Âú¿ÂÓî_7_WrongParameterException("ISBNºÅ´íÎó","Ã»ÓĞÕâ±¾Êé");
			int copies = Integer.parseInt(shelfCount.getText());
			if (copies <= 0)
				throw new _14211278_Âú¿ÂÓî_7_WrongParameterException("ÊıÁ¿´íÎó","ÊäÈëÓĞÎó£¬ÖÁÉÙ¹ºÂòÒ»±¾Êé");
			_14211278_Âú¿ÂÓî_7_Controller.getInstance().getSale().addSaleLineItem(new _14211278_Âú¿ÂÓî_7_SaleLineItem(copies,temp));
		} catch (Exception ex) {
			if (ex instanceof _14211278_Âú¿ÂÓî_7_WrongParameterException)
				((_14211278_Âú¿ÂÓî_7_WrongParameterException) ex).showExceptionPanel();
			else new _14211278_Âú¿ÂÓî_7_WrongParameterException("ÊıÁ¿´íÎó","²»ÊÇÊı×Ö").showExceptionPanel();
		}
	}
	
	
	@FXML
	public void cartButtonOnClick(ActionEvent event) {
		if (_14211278_Âú¿ÂÓî_7_Controller.getInstance().buyBook())
		//²âÊÔÄ¿µÄ£¬µ¯³ö´°¿Ú
			new _14211278_Âú¿ÂÓî_7_WrongParameterException("¹ºÂò³É¹¦","¹§Ï²Äú").showExceptionPanel();
		else new _14211278_Âú¿ÂÓî_7_WrongParameterException("¹ºÂòÊ§°Ü","¿ÉÄÜÒòÎª¹ºÎï³µÖĞÃ»ÓĞÊé¼®").showExceptionPanel();
	}
}
