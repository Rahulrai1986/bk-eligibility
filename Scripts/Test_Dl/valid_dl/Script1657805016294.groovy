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

WebUI.delay(4)

WebUI.setText(findTestObject('login/Input_KYC number'), 'KA1420160008531')

WebUI.click(findTestObject('login/Input_KYC number'))

WebUI.delay(2)

WebUI.click(findTestObject('login/DOB'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('login/CLICK_YEAR2'))

WebUI.click(findTestObject('login/select_YEAR2'))

WebUI.click(findTestObject('login/SELECT_MONTH2'))

WebUI.click(findTestObject('login/SELECT_DATE2'))

WebUI.scrollToPosition(500, 2000)

WebUI.click(findTestObject('login/submit_dl'))

WebUI.delay(10)

WebUI.click(findTestObject('login/insert_pincodedl'))

WebUI.setText(findTestObject('login/insert_pincodedl'), '123456')

WebUI.scrollToPosition(500, 2000)

WebUI.click(findTestObject('login/submit_dl'))

test4 = WebUI.getText(findTestObject('login/erroe_messagedlpincode'))

System.println(test4)

WebUI.delay(3)

WebUI.click(findTestObject('login/insert_pincodedl'))

WebUI.setText(findTestObject('login/insert_pincodedl'), '470002')

WebUI.scrollToPosition(500, 2000)

WebUI.click(findTestObject('login/submit_dl'))

WebUI.delay(3)

test1 = WebUI.getText(findTestObject('login/congratulation_30000'), FailureHandling.STOP_ON_FAILURE)

System.println(test1)

WebUI.delay(2)

test2 = WebUI.getText(findTestObject('login/amount_30000'))

System.println(test2)

deleteLead()

System.println('Leaddeleted' //BasicDBobject a= mongoClient.getDatabase('bk-bnpl-uat').getCollection('leads').find({mobile:'9742368997'})
    )

System.println(test1)

static void deleteLead() {
    MongoClientURI connectionString = new MongoClientURI('mongodb://admin:Y2Vzc3Bvb2w@cesspool.jai-kisan.com:30001,cesspool.jai-kisan.com:30002,cesspool.jai-kisan.com:30003/vendor_erp?authSource=admin&replicaSet=cesspool&readPreference=primary&appname=MongoDB%20Compass&ssl=false')

    MongoClient mongoClient = new MongoClient(connectionString)

    DB db = mongoClient.getDB('bk-bnpl-uat')

    DBObject query = new BasicDBObject('mobile', '9742368997')

    db.getCollection('leads').remove(query)
}

static String getOtp() {
    MongoClientURI connectionString = new MongoClientURI('mongodb://admin:Y2Vzc3Bvb2w@cesspool.jai-kisan.com:30001,cesspool.jai-kisan.com:30002,cesspool.jai-kisan.com:30003/vendor_erp?authSource=admin&replicaSet=cesspool&readPreference=primary&appname=MongoDB%20Compass&ssl=false')

    MongoClient mongoClient = new MongoClient(connectionString)

    String otp = mongoClient.getDatabase('bk-bnpl-uat').getCollection('otp').find().sort(new BasicDBObject('_id', OrderBy.DESC.getIntRepresentation())).limit(
        1).first().getString('otp')

    return otp
}

