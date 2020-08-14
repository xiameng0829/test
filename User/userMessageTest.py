from selenium import webdriver
import time
import unittest


class MyTestCase(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.get("http://localhost:8060/usermanger/login.html")
        self.driver.maximize_window()
    def tearDown(self):
        self.driver.quit()


    # 登录页面

    def test_login(self):
        self.driver.find_element_by_id("user").send_keys("lisi")
        self.driver.find_element_by_id("password").send_keys("1236")
        time.sleep(4)
        self.driver.find_element_by_id("submit").click()
        time.sleep(3)

    # 添加用户页面

    def test_add(self):
        self.driver.find_element_by_id("user").send_keys("lisi")
        self.driver.find_element_by_id("password").send_keys("1236")
        time.sleep(3)
        self.driver.find_element_by_id("submit").click()
        time.sleep(2)
        self.driver.find_element_by_xpath("/html/body/div/div[2]/a[1]").click()
        time.sleep(3)

        # 添加用户
        self.driver.find_element_by_id("name").send_keys("杨颖")
        inputs = self.driver.find_elements_by_tag_name("input")
        time.sleep(2)
        for input in inputs:
            if input.get_attribute('value') == "女":
                input.click()

        self.driver.find_element_by_id("age").send_keys("37")
        time.sleep(2)
        self.driver.find_element_by_xpath("//*[@id='address']/option[8]").click()
        time.sleep(2)
        self.driver.find_element_by_id("qq").send_keys("1261234334")
        time.sleep(2)
        self.driver.find_element_by_id("email").send_keys("ym@qq.com")
        time.sleep(4)
        self.driver.find_element_by_id("submit").click()
        time.sleep(4)

        alert = self.driver.switch_to.alert
        # 关闭弹出框
        alert.accept()
        time.sleep(4)



    # 删除某个用户

    def test_delete(self):
        self.driver.find_element_by_id("user").send_keys("lisi")
        self.driver.find_element_by_id("password").send_keys("1236")
        time.sleep(3)
        self.driver.find_element_by_id("submit").click()
        time.sleep(3)
        self.driver.find_element_by_xpath("//*[@id='info']/tr[1]/td[8]/a[2]").click()
        time.sleep(3)


    # 批量删除

    def test_deleteSelect(self):
        self.driver.find_element_by_id("user").send_keys("lisi")
        self.driver.find_element_by_id("password").send_keys("1236")
        time.sleep(4)
        self.driver.find_element_by_id("submit").click()
        time.sleep(3)

        inputs = self.driver.find_elements_by_tag_name("input")
        for i in inputs:
            if i.get_attribute('id') == "3" or i.get_attribute('id') == "4":
                i.click()
        time.sleep(2)
        self.driver.find_element_by_xpath("//*[@id='delete']").click()
        time.sleep(3)

    # 模糊查询
    def test_find(self):
        self.driver.find_element_by_id("user").send_keys("guanyu")
        self.driver.find_element_by_id("password").send_keys("1234")
        time.sleep(4)
        self.driver.find_element_by_id("submit").click()
        time.sleep(3)

        self.driver.find_element_by_name("name").send_keys("张")
        self.driver.find_element_by_xpath("//*[@id='submit1']").click()
        time.sleep(3)

if __name__ == '__main__':
    unittest.main()
