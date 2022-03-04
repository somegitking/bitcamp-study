from selenium import webdriver
from selenium.webdriver.common.keys import Keys

driver = webdriver.Chrome()

driver.get("http://www.google.com")
#1. selenium을 activate 시켜야 한다.
#2. python 파일이 있는 폴더 위치로 이동 시켜 놔야 한다.


# assert "Python" in driver.title
# elem = driver.find_element_by_name("q")

# elem.clear()
# elem.send_keys("pycon")
# elem.send_keys(Keys.RETURN)
# assert "No results found." not in driver.page_source
# driver.close()
