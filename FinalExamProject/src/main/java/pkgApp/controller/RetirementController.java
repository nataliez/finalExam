package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;
import org.apache.poi.ss.formula.functions.Finance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;
import javafx.scene.*;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.formula.functions.Finance;

public class RetirementController implements Initializable{

		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
	@FXML
	private TextField txtAnnualReturnWorking;
	@FXML
	private TextField txtYearsRetired;
	@FXML
	private TextField txtAnnualReturnRetired;
	@FXML
	private TextField txtRequiredIncome;
	@FXML
	private TextField txtMonthlySSI;
	@FXML
	private TextField txtSaveEachMonth;
	@FXML
	private TextField txtWhatYouNeedToSave;

	
	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		}
	
	
	
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		
		//	TODO: Clear all the text inputs
		txtYearsToWork.clear();
		txtYearsToWork.setDisable(false);
		txtYearsToWork.setText("");
		txtAnnualReturnWorking.clear();
		txtAnnualReturnWorking.setDisable(false);
		txtAnnualReturnWorking.setText("");
		txtYearsRetired.clear();
		txtYearsRetired.setDisable(false);
		txtYearsRetired.setText("");
		txtAnnualReturnRetired.clear();
		txtAnnualReturnRetired.setDisable(false);
		txtAnnualReturnRetired.setText("");
		txtRequiredIncome.clear();
		txtRequiredIncome.setDisable(false);
		txtRequiredIncome.setText("");
		txtMonthlySSI.clear();
		txtMonthlySSI.setDisable(false);
		txtMonthlySSI.setText("");
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		
		//	TODO: Call AmountToSave and TotalAmountSaved and populate 
	int YW = Integer.parseInt((txtYearsToWork.getText()));
	double ARW = Double.parseDouble(((txtAnnualReturnWorking.getText())));
	int YR = Integer.parseInt((txtYearsRetired.getText()));
	double ARR = Double.parseDouble((txtAnnualReturnRetired.getText()));
	double RI = Double.parseDouble((txtRequiredIncome.getText()));
	double MSS = Double.parseDouble((txtMonthlySSI.getText()));
	
	double TAS = ((RI - MSS) / (ARR / 12) * (1 - Math.pow(1 + (ARR/ 12), - (YR * 12))));
	txtSaveEachMonth.setText(String.valueOf(TAS));
	double ATS = -(Finance.pmt((ARW /12), (YW *12), 0, TAS));
	txtWhatYouNeedToSave.setText(String.valueOf(ATS));
	
	}
	
}
