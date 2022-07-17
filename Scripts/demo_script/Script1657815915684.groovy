import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.mongodb.*
import static com.mongodb.client.model.Filters.eq
import com.mongodb.operation.OrderBy as OrderBy

WebUI.openBrowser('')

WebUI.navigateToUrl('https://test-eligibility.jai-kisan.com/')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('login/input_the number'), '9742368997')

WebUI.click(findTestObject('login/next_button'))

String otp1 = getOtp()

System.out.println(otp1)

WebUI.setText(findTestObject('login/otp1 (1)'), ('' + otp1.charAt(0)) + '')

WebUI.setText(findTestObject('login/otp2'), ('' + otp1.charAt(1)) + '')

WebUI.setText(findTestObject('login/otp3'), ('' + otp1.charAt(2)) + '')

WebUI.setText(findTestObject('login/otp4'), ('' + otp1.charAt(3)) + '')

WebUI.setText(findTestObject('login/otp5'), ('' + otp1.charAt(4)) + '')

WebUI.setText(findTestObject('login/otp6'), ('' + otp1.charAt(5)) + '')

WebUI.click(findTestObject('login/verify_button'))

WebUI.click(findTestObject('login/div_Select Id Type'))

WebUI.click(findTestObject('login/span_Aadhar number'))

WebUI.setText(findTestObject('login/Input_KYC number'), '319112867921')

WebUI.click(findTestObject('login/submit_button3'))

WebUI.setText(findTestObject('login/aadhar_firstname'), 'ankur')

WebUI.setText(findTestObject('login/aadahr_secondname'), 'mangal')

WebUI.setText(findTestObject('login/aadhar_pincode'), '470002')

WebUI.scrollToPosition(500, 2000)

WebUI.click(findTestObject('login/sumit_btn4'))

WebUI.verifyElementText(findTestObject('validaadhar/Page_Check Eligibility  CONGRATULATIONS/div_Rs. 5000'), 'You are eligible for availing a maximum loan of')

WebUI.closeBrowser()

WebUI.click(findTestObject('login/verify_button'))

static String getOtp() {
    MongoClientURI connectionString = new MongoClientURI('mongodb://admin:Y2Vzc3Bvb2w@cesspool.jai-kisan.com:30001,cesspool.jai-kisan.com:30002,cesspool.jai-kisan.com:30003/vendor_erp?authSource=admin&replicaSet=cesspool&readPreference=primary&appname=MongoDB%20Compass&ssl=false')

    MongoClient mongoClient = new MongoClient(connectionString)

    String otp = mongoClient.getDatabase('bk-bnpl-uat').getCollection('otp').find().sort(new BasicDBObject('_id', OrderBy.DESC.getIntRepresentation())).limit(
        1).first().getString('otp')

    return otp
}

