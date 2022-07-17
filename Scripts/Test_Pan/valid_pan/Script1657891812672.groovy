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
import com.mongodb.DB as DB

WebUI.click(findTestObject('login/Input_KYC number'))

WebUI.setText(findTestObject('login/Input_KYC number'), 'BRHPR7014J')

WebUI.click(findTestObject('login/Submit_button'))

WebUI.delay(10)

WebUI.setText(findTestObject('login/pan_pincode'), '470002')

WebUI.scrollToPosition(500, 2000)

WebUI.click(findTestObject('login/pan_submitfinal'))

WebUI.waitForElementVisible(findTestObject('login/congrarulation_pan'), 0)

test1 = WebUI.getText(findTestObject('login/congrarulation_pan'), FailureHandling.STOP_ON_FAILURE)

System.println(test1)

WebUI.delay(2)

test2 = WebUI.getText(findTestObject('login/pan_amount'))

System.println(test2)

deleteLead()

System.println('Leaddeleted' //BasicDBobject a= mongoClient.getDatabase('bk-bnpl-uat').getCollection('leads').find({mobile:'9742368997'})
    )

static void deleteLead() {
    MongoClientURI connectionString = new MongoClientURI('mongodb://admin:Y2Vzc3Bvb2w@cesspool.jai-kisan.com:30001,cesspool.jai-kisan.com:30002,cesspool.jai-kisan.com:30003/vendor_erp?authSource=admin&replicaSet=cesspool&readPreference=primary&appname=MongoDB%20Compass&ssl=false')

    MongoClient mongoClient = new MongoClient(connectionString)

    DB db = mongoClient.getDB('bk-bnpl-uat')

    DBObject query = new BasicDBObject('mobile', '9589703000')

    db.getCollection('leads').remove(query)
}

static String getOtp() {
    MongoClientURI connectionString = new MongoClientURI('mongodb://admin:Y2Vzc3Bvb2w@cesspool.jai-kisan.com:30001,cesspool.jai-kisan.com:30002,cesspool.jai-kisan.com:30003/vendor_erp?authSource=admin&replicaSet=cesspool&readPreference=primary&appname=MongoDB%20Compass&ssl=false')

    MongoClient mongoClient = new MongoClient(connectionString)

    String otp = mongoClient.getDatabase('bk-bnpl-uat').getCollection('otp').find().sort(new BasicDBObject('_id', OrderBy.DESC.getIntRepresentation())).limit(
        1).first().getString('otp')

    return otp
}

