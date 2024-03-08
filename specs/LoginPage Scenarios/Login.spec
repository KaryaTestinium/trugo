Login Scenearios
=====================
Created by karya.boyraz on 23.02.2024

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
Table: fakerUser.csv

User Login with registered phone number
--------------
* Login with <PhoneNumber> phone number
* Click element "Uygulamayı kullanırken"
* Check Login is successful to Main Page

User try to Login with not registered phone number
--------------
* Write text "5442223344" to this element "editText"
* Click button "Oturum Aç"
* Check element existence "Bu geçersiz bir numara. Lütfen kontrol edip tekrar deneyin."
* Check element existence "Hesap Oluştur"

Check Login with empty phone number
--------------
* Write text "" to this element "editText"
* Click button "Oturum Aç"
* Check element existence "Bu geçersiz bir numara. Lütfen kontrol edip tekrar deneyin."
* Check element existence "Hesap Oluştur"

Check Country Code Fonksiyonality
--------------
* Click element "CountryCode"
* Click button "Tuvalu"
* Check element existence "688"

Check Country Code Search Fonksiyonality
--------------
* Click element "CountryCode"
* Write text "Turkey" to this element "editText"
* Check element existence "Turkey"
* Check element existence "90"